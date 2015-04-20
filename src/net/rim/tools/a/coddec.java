package net.rim.tools.a;

import java.io.*;
import java.util.*;
import java.util.jar.*;
import net.rim.tools.compiler.codfile.*;
import net.rim.tools.a.parameters;
import net.rim.tools.a.routineattributes;
import net.rim.tools.a.classattributes;
import net.rim.tools.a.fieldattributes;

public final class coddec

{
	private static coddec _coddec = null;
	private static Hashtable _classes = null;
	private static Hashtable _modules = null;
	private static Hashtable _codfiles = null;
	private static Hashtable _imports = null;
	private static StringBuffer _output = null;
	
	public coddec ()
	{
	_classes = new Hashtable();
	_modules = new Hashtable();
	_codfiles = new Hashtable();
	_imports = new Hashtable();
	_output = new StringBuffer();
	_output.ensureCapacity(256);
	}
	
	
	public static String getFieldAttributes (int __attribute)
	{
		int i = __attribute;
		StringBuffer _stringBuf_ = new StringBuffer();
        if((i & 1) != 0)
		{
            _stringBuf_.append("public ");
			if((i & 8) != 0)
				_stringBuf_.append("final ");
		}
		
        // Changes
		// 1. we remove protected and final attributes as it seems that it doesn't affect results
		// 2. we only need public fields to build API
		//if((i & 2) != 0)
        //    _stringBuf_.append("private ");
		// if((i & 4) != 0)
        //    _stringBuf_.append("protected ");
        // if((i & 8) != 0)
        //     _stringBuf_.append("final ");
		return _stringBuf_.toString();
	}
	
	public static String getMethodAttributes (int __attribute)
	{
		int j = __attribute;
		StringBuffer local_strBuffer = new StringBuffer();
        //if((j & 0x10) != 0)
        //    local_strBuffer.append("static ");
        if((j & 0x20) != 0)
            local_strBuffer.append("abstract ");
        //if((j & 0x40) != 0)
        //    local_strBuffer.append("exceptional ");
        if((j & 1) != 0)
		{
            local_strBuffer.append("public ");
			if((j & 0x10) != 0)
			    local_strBuffer.append("static ");
			if((j & 8) != 0)
			   local_strBuffer.append("final ");
		}
        //if((j & 2) != 0)
        //    local_strBuffer.append("private ");
        //if((j & 4) != 0)
        //   local_strBuffer.append("protected ");
        //if((j & 8) != 0)
        //    local_strBuffer.append("final ");
		// if((j & 0x100) != 0)
        //    local_strBuffer.append(param_className + " ");
        // if((j & 0x80) != 0)
        //    local_strBuffer.append(param_className + " ");
		return local_strBuffer.toString();
	}
	
	public static String getNonLocalClassName(String __moduleName, int __classOrdinal)
	{
		String s1= "";
		net.rim.tools.compiler.codfile.Module _module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(__moduleName);
		if (_module_ == null)
		{
			
			parseFile(__moduleName + ".cod");
		}
		
		if (_module_ != null)
		{
			if (__classOrdinal < _module_.getNumClassDefs())
			{
				String _className_ = _module_.getClassDef(__classOrdinal).getClassNameString();
				s1 = _className_;
			}
		}
		return s1;
	}
	
	public static String getNonLocalPackageName (String __moduleName, int __classOrdinal)
	{
		String s1= "";
		net.rim.tools.compiler.codfile.Module _module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(__moduleName);
		
		if (_module_ == null)
		{
			
			parseFile(__moduleName + ".cod");
		}
		
		if (_module_ != null)
		{
			if (__classOrdinal < _module_.getNumClassDefs())
			{
				String _packageName_ = _module_.getClassDef(__classOrdinal).getPackageNameString();
				s1 = _packageName_;
			}
		}
		return s1;
	}
	
	public static String getTypeName (net.rim.tools.compiler.codfile.TypeItem __typeItem)
	{
		String _typeName_ ="";
		
		if (__typeItem != null)
		{
			_typeName_ = __typeItem.getTypeName();
			
			if (_typeName_.contains("."))
			{
				String _packageName_ = __typeItem.getClassDef().getPackageNameString();
				String _className_ = __typeItem.getClassDef().getClassNameString();
				
				if (_typeName_.contains("module:"))
				{
					_packageName_ = _packageName_.substring(_packageName_.indexOf(":") + 1);
					_className_ = getNonLocalClassName(_packageName_, __typeItem.getClassDef().getOrdinal());
					_packageName_ = getNonLocalPackageName (_packageName_, __typeItem.getClassDef().getOrdinal());
				}
				
				if (_packageName_.contains("java.lang") || _packageName_.length() == 0)
					_typeName_ = _className_;
				else
					_typeName_ = _packageName_ + "." + _className_;
			}
		}
		else
			_typeName_ = "void";
		return _typeName_;
	}
	
	public static String getTypeName (net.rim.tools.compiler.codfile.ClassDef __classDef)
	{
		String _typeName_ ="";
		
		if (__classDef != null)
		{
			_typeName_ = __classDef.get_Name();
			
			if (_typeName_.contains("."))
			{
				String _packageName_ = __classDef.getPackageNameString();
				String _className_ = __classDef.getClassNameString();
				
				if (_typeName_.contains("module:"))
				{
					_packageName_ = _packageName_.substring(_packageName_.indexOf(":") + 1);
					_className_ = getNonLocalClassName(_packageName_, __classDef.getOrdinal());
					_packageName_ = getNonLocalPackageName (_packageName_, __classDef.getOrdinal());
				}
				
				if (_packageName_.contains("java.lang") || _packageName_.length() == 0)
					_typeName_ = _className_;
				else
					_typeName_ = _packageName_ + "." + _className_;
			}
		}
		return _typeName_;
	}
	
	public static String getRoutineName(net.rim.tools.compiler.codfile.Routine __routine, Boolean __fullName)
	{
		String _routineName_ ="";
		if (__routine.getName().get_Name().length() > 0)
		{
				_routineName_ = __routine.getName().get_Name();
		}
		else
			_routineName_ = "routine_" + __routine.getOffset();
		if (__fullName)
			if (__routine.getClassDef().getPackageName() != null)
				if (__routine.getClassDef().getPackageName().get_Name().length() > 0)
					_routineName_ = __routine.getClassDef().getPackageNameString() + "." + __routine.getClassDef().getClassNameString() + "." +_routineName_;
				else
					_routineName_ = __routine.getClassDef().getClassNameString() + "." +_routineName_;
		return _routineName_;
	}
	
	public static String getModuleName(ClassDef __classDef)
	{
		String _typeName_ = "";
		if (__classDef != null)
		{
			_typeName_ = __classDef.get_Name();
			
			if (_typeName_.contains("."))
			{
				String _packageName_ = __classDef.getPackageNameString();
				String _className_ = __classDef.getClassNameString();
				
				if (_typeName_.contains("module:"))
				{
					_packageName_ = _packageName_.substring(_packageName_.indexOf(":") + 1);
					_className_ = getNonLocalClassName(_packageName_, __classDef.getOrdinal());
					_packageName_ = getNonLocalPackageName (_packageName_, __classDef.getOrdinal());
				}
				
				_typeName_ = _packageName_;
			}
		}
		
		return _typeName_;
	}
	
	public static RoutineLocal getNonLocalRoutine (Routine __routine)
	{
		if (__routine != null)
		{
			String _moduleName_ = __routine.getClassDef().getPackageNameString();
			if (_moduleName_.contains("module:"))
			{
				_moduleName_ = _moduleName_.substring(_moduleName_.indexOf(":")+1);
			}
			else
			{
				_moduleName_ = __routine.getClassDef().getModule().getName().getString();
			}
			
			net.rim.tools.compiler.codfile.Module _module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(_moduleName_);
			
			if (_module_ == null)
			{
				
				parseFile(_moduleName_ + ".cod");
				_module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(_moduleName_);
			}
			
			if (_module_ != null)
			{
				return (RoutineLocal) _module_.find(__routine.getOffset());
			}
		}
		return (RoutineLocal) __routine;
	}
	
	public static ClassDefLocal getNonLocalClassDef (ClassDef __classDef)
	{
		if (__classDef != null)
		{
			String _moduleName_ = __classDef.getPackageNameString();
			if (_moduleName_.contains("module:"))
			{
				_moduleName_ = _moduleName_.substring(_moduleName_.indexOf(":")+1);
			}
			else
			{
				_moduleName_ = __classDef.getModule().getName().getString();
			}
			net.rim.tools.compiler.codfile.Module _module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(_moduleName_);
			
			if (_module_ == null)
			{
				
				parseFile(_moduleName_ + ".cod");
				_module_ = (net.rim.tools.compiler.codfile.Module)_modules.get(_moduleName_);
			}
			
			if (_module_ != null)
			{
				if (__classDef.getOrdinal() < _module_.getNumClassDefs())
				{
					return (ClassDefLocal)_module_.getClassDef(__classDef.getOrdinal());
				}
			}
			
		}
		return (ClassDefLocal) __classDef;
	}
	
	public static String getRoutineParams (net.rim.tools.compiler.codfile.TypeList __typeList)
	{
		StringBuffer _stringBuf_ = new StringBuffer(0);
		_stringBuf_.ensureCapacity(256);
		
		if (__typeList != null)
		{
			int _numParams_ = __typeList.length();
			parameters _parameters_ = new parameters();
			
			for (int i = 0; i < _numParams_; i++)
				_parameters_.addParameter(getTypeName( __typeList.get_type(i)));
			
			for (int j = 0; j < _parameters_.getNumberParameters(); j++)
			{
				_stringBuf_.append(_parameters_.getParameter(j).getTypeName() + " ");
				_stringBuf_.append(_parameters_.getParameter(j).getName());
				if (j < _parameters_.getNumberParameters() - 1)
					_stringBuf_.append(", ");
			}
		}
		return _stringBuf_.toString();
	}
	
	public static Vector getRoutineParamsV (net.rim.tools.compiler.codfile.TypeList __typeList)
	{
		Vector _params_ = new Vector ();
		if (__typeList != null)
		{
			int _numParams_ = __typeList.length();
			for (int i = 0; i < _numParams_; i++)
				_params_.add(getTypeName(__typeList.get_type(i)));
		}
		return _params_;
	}
	
	
	//Header
	public static void printClassFileHeader (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef)
	{
		if(__message != null)
		{
			if (__classDef != null)
			{
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				
				__message.append("// #######################################################\r\n");
				__message.append("// Decompiled by   : coddec \r\n");
				__message.append("// Module          : " + __classDef.getModule().getName().getString() + ".cod" + "\r\n");
				__message.append("// Module version  : " + __classDef.getModule().getVersion().getString() + "\r\n");
				__message.append("// Class ID        : " + __classDef.getOrdinal() + "\r\n");
				__message.append("// ########################################################\r\n");
				__message.append("\r\n");
				__message.append("\r\n");
			}
		}
	}
	// Package name
	public static void printClassFilePackage (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef)
	{
		if(__message != null)
		{
			if (__classDef != null)
			{
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				
				if (_classDefLocal_.getPackageNameString() != null && _classDefLocal_.getPackageNameString().length() > 0)
				{
					__message.append("package " +_classDefLocal_.getPackageNameString() + ";\r\n");
					__message.append("\r\n");
					__message.append("\r\n");
				}
			}
		}
	}
	// Imports
	private static void printClassFileImports (StringBuffer __message, Hashtable __imports)
	{
	if (__message != null)
		{
			if (__imports != null)
			{
				String _importsString_;
				for (Enumeration _enumeration_ = __imports.elements(); _enumeration_.hasMoreElements(); __message.append("import " + _importsString_ + ";\r\n"))
				{
					_importsString_ = (String)_enumeration_.nextElement();
				}
			}
		}
	}

	private static void printExcemptionHandlers (StringBuffer __message, net.rim.tools.compiler.codfile.Routine __routine)
	{
		if (__message != null)
		{
			if (__routine != null)
			{

				net.rim.tools.compiler.codfile.CodfileArray _exceptions_ = ((net.rim.tools.compiler.codfile.RoutineLocal)__routine).getExceptionHandlers();
				
				if (_exceptions_ != null)
				{
					Hashtable _exceptionsTable_ = new Hashtable();
					int _size_ = _exceptions_.getExtent();
					int _pos_ = __message.length();
					
					for (int i = 0; i < _size_; i++)
					{
						net.rim.tools.compiler.codfile.ExceptionHandler _handler_ =(net.rim.tools.compiler.codfile.ExceptionHandler)_exceptions_.getItem(i);
						if (__routine.getClassDef().getModule().getNullClassDef() == _handler_.getHandlerClass())
							continue;
						_exceptionsTable_.put(getTypeName(_handler_.getHandlerClass()), i);
					}
					
					String s;
					int _elements_ = 0;
					
					for (Enumeration enumeration = _exceptionsTable_.keys(); enumeration.hasMoreElements(); __message.append(s) )
					{
						s = (String)enumeration.nextElement();
						_elements_ ++;
						if (enumeration.hasMoreElements())
							s = s + ", ";
					}
					
					if (_elements_ > 0)
					{
						if (_elements_ > 1)
							__message.insert(_pos_, "\t throws ");
						else
							__message.insert(_pos_,"\t throw ");
						
						//__message.insert(_pos_, "\r\n");
					}
					
					_exceptionsTable_.clear();
				}
			}
		}
	}
	
	public static void printClassFileFields (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef,Boolean __isStatic)
	{
		if (__message != null)
		{
			if (__classDef != null)
			{
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				Boolean _clinit_ = (_classDefLocal_.getClinit() == _classDefLocal_.getNullRoutine());
				int _numFields_  = _classDefLocal_.getNumFieldDefs(__isStatic);
				
				if (_numFields_ > 0)
					if (__isStatic)
						__message.append("\t// @@@@@@@@@@@@@ Static fields \r\n");
					else
						__message.append("\t// @@@@@@@@@@@@@ Fields \r\n");
				
				// Fields
				
				for (int i = 0; i < _numFields_; i++)
				{
					net.rim.tools.compiler.codfile.FieldDefLocal _field_ = (net.rim.tools.compiler.codfile.FieldDefLocal)_classDefLocal_.getFieldDef(i, __isStatic);
					net.rim.tools.compiler.codfile.TypeItem _type_  = _field_.getTypeList().get_baseType();
					
					// Attributes
					// Changes: we only need here public fields
					fieldattributes _fieldattributes_ = new fieldattributes();
					_fieldattributes_.addAttributes(_field_.getAttributes());
					
					String _attributeFieldString_ = _fieldattributes_.getAttributesString();
					
					if (_attributeFieldString_.length() != 0)
						__message.append("\t" + _attributeFieldString_);
					else
						break;
					
					// Static
					if (__isStatic)
						__message.append ("static" + " ");
					
					// Field type
					__message.append(getTypeName( _type_) + " ");
					
					// Field name
					if (!(_field_.getName().get_Name() != null && _field_.getName().get_Name().length() == 0))
						__message.append (_field_.getName().get_Name() + " ");
					// Changes
					// We leave only defined fields, not fields by offset
					else
						__message.append ("field_" + _field_.getOffset() + " ");
					
					// Field initial value
					if (!_clinit_)
					{
						net.rim.tools.compiler.codfile.Code _code_ =((RoutineLocal)(_classDefLocal_.getClinit())).getCode();
						//resolveObjectRef(_code_.getObjectRefs());
						//_code_.
					}
					// End of field section
					__message.append("; \r\n");
				}
				__message.append("\r\n");
			}
		}
	}
	
	public static void printClassFileConstructor (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef, Hashtable __imports)
	{
		if (__message != null)
		{
			if (__classDef != null)
			{
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				net.rim.tools.compiler.codfile.Routine _init_ = _classDefLocal_.getInit();
				
				__message.append("\r\n");
				if (_init_ != _classDefLocal_.getNullRoutine())
				{
					__message.append("\t" + "public " + _classDefLocal_.getClassNameString() + "(__params) \r\n");
					__message.append("\t\r\n");
					__message.append("\t{\r\n");
					__message.append("\t}\r\n");
					__message.append("\r\n");
				}
				else
				{
					__message.append("\t" + "public " + _classDefLocal_.getClassNameString() + "() \r\n");
					__message.append("\t\r\n");
					__message.append("\t{\r\n");
					__message.append("\t}\r\n");
					__message.append("\r\n");
				}
			}
		}
	}
	
	private static Routine resolveRoutine (Routine __routine)//, DataSection __dataSection)
	{
		if (__routine != null)
		{
			if (__routine instanceof RoutineDomestic)
			{
				return getNonLocalRoutine(__routine);
			}
			if (__routine instanceof RoutineForeign)
			{
				int __offset_ = __routine.getOffset();
			}
			if (__routine instanceof RoutineLocal)
			{
				return getNonLocalRoutine(__routine);
			}
			if (__routine instanceof RoutineNull)
			{
				return __routine;
			}
		}
		return __routine;
	}
	
	private static ClassDef ResolveClass (ClassDef __classDef)
	{
		if (__classDef != null)
		{
			if (__classDef instanceof ClassDefDomestic)
			{
				return getNonLocalClassDef(__classDef);
			}
			if (__classDef instanceof ClassDefForeign)
			{
				return __classDef;
			}
			if (__classDef instanceof ClassDefLocal)
			{
				return getNonLocalClassDef(__classDef);
			}
			if (__classDef instanceof ClassDefNull)
			{
				return __classDef;
			}
		}
		return __classDef;
	}
	
	private static FieldDef ResolveField (FieldDef __fieldDef)
	{
		if (__fieldDef != null)
		{
			if (__fieldDef instanceof FieldDefDomestic)
			{
				return __fieldDef;
			}
			if (__fieldDef instanceof FieldDefForeign)
			{
				return __fieldDef;
			}
			if (__fieldDef instanceof FieldDefLocal)
			{
				return __fieldDef;
			}
			if (__fieldDef instanceof FieldNull)
			{
				return __fieldDef;
			}
		}
		return __fieldDef;
	}
	
	public static void  resolveObjectRefs (Object __refs[])
	{
		if (__refs != null)
		{
			int _count_ = __refs.length;
			for (int i = 0; i < _count_; i++)
			{
				if (__refs[i] instanceof Routine)
				{
					__refs[i] = resolveRoutine((Routine)__refs[i]);
					continue;
				}
				if (__refs[i] instanceof ClassDef)
				{
					__refs[i] = ResolveClass((ClassDef)__refs[i]);
					continue;
				}
				if (__refs[i] instanceof FieldDef)
				{
					__refs[i] = ResolveField((FieldDef)__refs[i]);
					continue;
				}
			}
		}
	}
	
	public static void printClassFileStaticRoutines (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef,int _routineType) throws IOException
	{
		if (__message != null)
		{
			if (__classDef != null)
			{
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				String _temp_str_ = _classDefLocal_.getClassNameString();
				
				// TRAP: Catches particular class for debug review
				if (_temp_str_.equals("SIMCardOptionsItem"))
					_temp_str_ = "";
				
				int _numRoutines_ = 0;
				switch (_routineType)
				{
					case 0:
							_numRoutines_ = _classDefLocal_.get_staticRoutinesSize();
							if (_numRoutines_ > 0)
							__message.append("\t// @@@@@@@@@@@@@ Static routines \r\n");
							break;
					case 1:
							_numRoutines_ = _classDefLocal_.get_nonVirtualRoutinesSize();
						if (_numRoutines_ > 0)
							__message.append("\t// @@@@@@@@@@@@@ Non-virtual routines \r\n");
							break;
					case 2:
							_numRoutines_ = _classDefLocal_.getNumVirtualRoutines();
						if (_numRoutines_ > 0)
							__message.append("\t// @@@@@@@@@@@@@ Virtual routines \r\n");
							break;
					default:
						break;
				}
				
				for (int i = 0; i < _numRoutines_; i++)
				{
					net.rim.tools.compiler.codfile.RoutineLocal _routineLocal_ = null;
					switch (_routineType)
					{
						case 0:
							_routineLocal_ = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal_.getStaticRoutine(i);
							break;
						case 1:
							_routineLocal_ = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal_.get_nonVirtualRoutine(i);
							break;
						case 2:
							_routineLocal_ = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal_.getVirtualRoutine(i);
							break;
						default:
							break;
					}
					

					
					//if (_classDefLocal_.getClinit()== _routineLocal_)
					//	continue;
					// Start routine header
					__message.append("\r\n");
					
					// Atributes
					routineattributes _routineAttributes_ = new routineattributes();
					_routineAttributes_.addAttributes(_routineLocal_.getAttributes());
					String _routineAttributesString_ = _routineAttributes_.getAttributesString();
					
					//if (_routineAttributes_.hasAttribute("IsClinit")|| _routineAttributes_.hasAttribute("IsInit"))
					//	break;
					//else
					//{
					//	if (_routineAttributes_.hasAttribute("IsAbstract"))
					//		_routineAttributesString_ = _routineAttributes_.getAttributesString();
					//	else
					//		_routineAttributesString_ = "native " + _routineAttributes_.getAttributesString();
					//}
					
					
					//String _routineAttributes = _routineAttributes_.getAttributesString();
					//if (_routineAttributes.length() != 0)
					//{
					__message.append(_routineAttributesString_);
					//}
					//else
					//	break;
					
					__message.append(_routineLocal_.get_Name());
					// Return type
					//net.rim.tools.compiler.codfile.TypeItem _returnType_ = _routineLocal_.getTypeList().get_baseType();
					//__message.append(getTypeName(_returnType_) + " ");
					
					// Method name
					//__message.append(getRoutineName(_routineLocal_, false));
							
					//net.rim.tools.compiler.codfile.DataSection _dataSection_ = (net.rim.tools.compiler.codfile.DataSection)_codfiles.get(_classDefLocal_.getModule().getName().getString());
					
					//_dataSection_.getTypeLists().getSomethingTypeList();
					
					// Parameters
					//__message.append("(");
					//__message.append(getRoutineParams(_routineLocal_.getProtoTypeList()));
					//__message.append(")");
					//CHANGES:
					//ADDED semi-colon after function header
					__message.append(";");
					__message.append("\r\n");
					
					// exceptions
					//TODO: review the way to apply exception headers
					//printExcemptionHandlers (__message, _routineLocal_);
					
					// end of routine header
					
					__message.append("\t{\r\n");
					
					//Object _refs_[] =_routineLocal_.getCode().getObjectRefs();
					
					//resolveObjectRefs(_refs_);

					FileOutputStream javaOutputStream = new FileOutputStream("test.txt");
					net.rim.tools.compiler.io.StructuredOutputStream _stream_ = net.rim.tools.compiler.io.StructuredOutputStream.createInstance(javaOutputStream, false, null, System.out);
					_routineLocal_.getCode().disassemble(_stream_, __message);

					
					//Hashtable _module_ = _modules;
					
					//_module_.get("test");
					
					__message.append("\t}\r\n");
					
					__message.append("\r\n");
					
				}
			}
		}
	}
	
	// Class header
	private static void printClassFileClass (StringBuffer __message, net.rim.tools.compiler.codfile.ClassDef __classDef)
	{
		if(__message != null)
		{
			if (__classDef != null)
			{
				// Start class header section
				
				net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)__classDef;
				
				// Attributes
				
				classattributes _classatributes_ = new classattributes ();
				_classatributes_.addattributes(_classDefLocal_.getAttributes());

				__message.append(_classatributes_.getAttributesString());
				
				// Class name
				__message.append("class " + _classDefLocal_.getClassNameString());
				
				// Extends
				
				if (_classDefLocal_.getSuperClass()!= null)
				{
					__message.append(" extends ");
					__message.append(getTypeName(_classDefLocal_.getSuperClass()));
				}
					__message.append("\r\n");
				
				// Implements
				
				if (_classDefLocal_.getNumInterfaces()> 0)
				{
					int _numInterfaces_ = _classDefLocal_.getNumInterfaces();
					__message.append("implements ");
					
					for (int j = 0; j < _numInterfaces_; j++)
					{
						__message.append(getTypeName(_classDefLocal_.getInterface(j)));
											
						if (!(j >= _numInterfaces_ -1))
							__message.append(", ");
						else
							__message.append("\r\n");
					}
				}
				
				__message.append("\r\n");
				
			}
		}
	}
	
	private static void clearClasses()
	{
		_classes.clear();
	}
	
	private static void clearModules()
	{
		_modules.clear();
	}
	
	private static String createPackagePath(String __packageName)
	{
		String _packagePath_ = "decompiled\\" + __packageName.replace(".","\\");
		
		File _packageFolder_ = new File (_packagePath_);
		if (!_packageFolder_.exists())
		{
			if(!_packageFolder_.mkdirs())
			{
				System.out.println("Problem creating package " + __packageName + " folders");
				_packagePath_ = "";
				return _packagePath_;
			}
			
		}
		return _packageFolder_.getAbsolutePath();
		
	}
	
	private static void processClass(net.rim.tools.compiler.codfile.ClassDef __classDef)
	throws IOException
	{
		if (__classDef != null)
		{
			StringBuffer _stringBuf_ = new StringBuffer();
			StringBuffer _importsBuf_ = new StringBuffer("");
			
			String _pathString =createPackagePath(__classDef.getPackageNameString()) + "\\"+ __classDef.getClassNameString() +  ".java";
			FileOutputStream _javaOutputStream_ = new FileOutputStream(_pathString);
			try
			{
				OutputStreamWriter _javaOutputWriter_ = new OutputStreamWriter(_javaOutputStream_);
				//TODO: extend information about class
				printClassFileHeader( _stringBuf_, __classDef);
				
				printClassFilePackage(_stringBuf_,__classDef);
				
				//TODO: implement import section
				int _importsPos_ = _stringBuf_.length();
				
				//TODO: remove unnecessary references to inbuilt classes (Object)
				printClassFileClass (_stringBuf_,__classDef);
				
				_stringBuf_.append("{\r\n");
				
				//TODO: create initalizators for fields
				printClassFileFields (_stringBuf_, __classDef, true);
				
				//CHANGES: At the moment all non-static fields are not included
				printClassFileFields (_stringBuf_, __classDef, false);
				
				// printClassFileConstructor (_stringBuf_,__classDef, _imports);
				printClassFileStaticRoutines (_stringBuf_,__classDef, 0);
				printClassFileStaticRoutines (_stringBuf_,__classDef, 1);
				printClassFileStaticRoutines (_stringBuf_,__classDef, 2);
				_stringBuf_.append("}\r\n");
				// _importsBuf_.append("\r\n");
				// printClassFileImports(_importsBuf_, _imports);
				// _importsBuf_.append("\r\n");
				// _stringBuf_.insert(_importsPos_, _importsBuf_);
				_imports.clear();
				_javaOutputWriter_.write(_stringBuf_.toString(),0,_stringBuf_.length());
				_javaOutputWriter_.flush();
				_javaOutputWriter_.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	private static void processModule (net.rim.tools.compiler.codfile.Module __module)
	throws IOException
	{
		if (__module != null)
		{
			int _numClasses_ = __module.getNumClassDefs();
			for (int i = 0; i < _numClasses_; i++)
				processClass(__module.getClassDef(i));
		}
	}
	
	private static void enumerateModules (byte __data[])
	throws IOException
	{
		net.rim.tools.compiler.codfile.Codfile _codFile_ = new net.rim.tools.compiler.codfile.Codfile(__data);
		_codFile_.processCodeSegment(false);
			
		int _numModules_ =  _codFile_.getDataSection().getModulesNum();
		for (int i = 0; i < _numModules_; i++)
		{
			net.rim.tools.compiler.codfile.Module _module_ =_codFile_.getDataSection().getModule(i);
			if (_module_ instanceof net.rim.tools.compiler.codfile.ModuleLocal)
			{
				_modules.put(_module_.getName().getString(),_module_);
				_codfiles.put(_module_.getName().getString(),_codFile_.getDataSection());
			}
		}
	}
	
	private static void parseFile (String __fileName)
	{
		File _file_ = new File(__fileName);
		if (_file_.exists())
		{
			try
			{
				try
				{
					JarFile _jarfile_ = new JarFile(_file_,false);
					byte _data_[];
					for (Enumeration enumeration = _jarfile_.entries();enumeration.hasMoreElements(); enumerateModules(_data_)) //decompile(fileAsByteArray)) //decompile
							{
								JarEntry _jarEntry_ = (JarEntry)enumeration.nextElement();
								String _jarEntryName_ = _jarEntry_.getName();
								_data_ = net.rim.tools.compiler.io.StructuredInputStream.readFully(_jarfile_.getInputStream(_jarEntry_), (int)_jarEntry_.getSize(), _jarEntryName_);
							}
				}
				catch (IOException ioexception1)
				{
					byte _data_[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(new FileInputStream(_file_), (int)_file_.length(), __fileName);
					enumerateModules(_data_);
				}
			}
			catch (IOException ioexception)
			{
               System.out.println(ioexception.getMessage());
			   ioexception.printStackTrace();
			}
		}
			
	}
	
	public static void main (String[] args)
	throws IOException
	{
		if ((args == null) || (args.length == 0))
		{
			System.out.println("Usage: coddec <filename1.[cod]> [.. <filenameZ.[cod]>]");
		}
		else
		{
			int i = args.length;
			_coddec = new coddec();
			
			for (int k = 0; k < i; k++)
			{
				String s = args[k];
				parseFile(s);
				
				net.rim.tools.compiler.codfile.Module _module_ = null;
				try
				{
					for (Enumeration _enumeration_ = _modules.elements(); _enumeration_.hasMoreElements(); processModule(_module_))
					{
						_module_ = (net.rim.tools.compiler.codfile.Module) _enumeration_.nextElement();
					}
					
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
		}
	}
}
