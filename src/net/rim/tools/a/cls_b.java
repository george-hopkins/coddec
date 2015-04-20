package net.rim.tools.a;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import net.rim.tools.compiler.codfile.*;
import net.rim.tools.compiler.h.*;
import net.rim.tools.compiler.i.*;

	


public class cls_b
{
	private static Vector f_fileList;
	
	public cls_b (){
		
	}
	
	private static String get_field_attributes (int param_Attribute)
	{
		int i = param_Attribute;
		StringBuffer local_strBuffer = new StringBuffer();
        if((i & 1) != 0)
            local_strBuffer.append("public ");
        if((i & 2) != 0)
            local_strBuffer.append("private ");
        if((i & 4) != 0)
            local_strBuffer.append("protected ");
        if((i & 8) != 0)
            local_strBuffer.append("final ");
		return local_strBuffer.toString();
	}
	
	private static String get_method_attributes (int param_Attribute)
	{
		int j = param_Attribute;
		StringBuffer local_strBuffer = new StringBuffer();
        if((j & 0x10) != 0)
            local_strBuffer.append("static ");
        if((j & 0x20) != 0)
            local_strBuffer.append("abstract ");
        if((j & 0x40) != 0)
            local_strBuffer.append("exceptional ");
        if((j & 1) != 0)
            local_strBuffer.append("public ");
        if((j & 2) != 0)
            local_strBuffer.append("private ");
        if((j & 4) != 0)
            local_strBuffer.append("protected ");
        if((j & 8) != 0)
            local_strBuffer.append("final ");
		// if((j & 0x100) != 0)
        //    local_strBuffer.append(param_className + " ");
        // if((j & 0x80) != 0)
        //    local_strBuffer.append(param_className + " ");
		return local_strBuffer.toString();
	}
	
	private static String get_class_attributes (int param_Attribute)
	{
		int j = param_Attribute;
		StringBuffer local_strBuffer = new StringBuffer();
        if((j & 0x200) != 0)
            local_strBuffer.append("inner ");
        if((j & 0x100) != 0)
            local_strBuffer.append("ungroupable ");
        if((j & 0x80) != 0)
            local_strBuffer.append("persistable ");
        if((j & 0x40) != 0)
            local_strBuffer.append("hasverifyerror ");
        if((j & 0x20) != 0)
            local_strBuffer.append("interface ");
        if((j & 0x10) != 0)
            local_strBuffer.append("abstract ");
        if((j & 1) != 0)
            local_strBuffer.append("public ");
        if((j & 2) != 0)
            local_strBuffer.append("private ");
        if((j & 4) != 0)
            local_strBuffer.append("protected ");
        if((j & 8) != 0)
            local_strBuffer.append("final ");
        
        return local_strBuffer.toString();
		
	}
	

	
	private static String create_package_path(String param_packageName)
	{
		String package_path = "decompiled" + File.separator + param_packageName.replace(".", File.separator);
			
		File package_folder = new File (package_path);
		if (!package_folder.exists())
		{
			if(!package_folder.mkdirs())
			{
				System.out.println("Problem creating package " + param_packageName + " folders");
				package_path = "";
				return package_path;
			}
			
		}
	
		String full_path = package_folder.getAbsolutePath();
		return full_path;
	
	}
	
	private static void test (byte param_fileAsByteArray[])
	throws IOException
	{
		net.rim.tools.compiler.codfile.Codfile loc_codFileParser = new net.rim.tools.compiler.codfile.Codfile(param_fileAsByteArray);
        loc_codFileParser.processCodeSegment(false);
		FileOutputStream javaOutputStream = new FileOutputStream("test.txt");
		loc_codFileParser.write(javaOutputStream, null,System.out);
	}
	
	private static void print_class_header (StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef)
	{
		if ((Message != null) && (ClassDef != null))
		{
		 
			Message.append("// Decompiled by coddec  #################################\r\n");
			net.rim.tools.compiler.codfile.Module _module_ = ClassDef.getModule();
			Message.append("// Module   : "  +  (_module_.getName()).getString() +  "\r\n");
			Message.append("// Home page   ###########################################\r\n");
			Message.append("// Copyright   ###########################################\r\n");
			Message.append("\r\n");
			
			String loc_packageName = ClassDef.getPackageNameString();
			
			if (loc_packageName.length() != 0)
			{
				Message.append("package ");
				Message.append(loc_packageName);
				Message.append(";\r\n");
				Message.append("\r\n");
			}
			else
			{
				Message.append("\r\n");
				Message.append("\r\n");
			}
			
			Message.append(get_class_attributes(ClassDef.getAttributes()));
			Message.append("class ");
			Message.append(ClassDef.getClassNameString() + " ");
			
			net.rim.tools.compiler.codfile.ClassDef loc_superClass = ClassDef.getSuperClass();
			
			if (loc_superClass != null)
			{
				Message.append("extends ");
				Message.append(loc_superClass.get_Name());
				Message.append("\r\n");
			}
				
			
			int k1 = ClassDef.getNumInterfaces();
			if (k1 > 0)
				Message.append("\t" + "implements ");
			for (int m1 = 0; m1 < k1; m1++)
			{
				net.rim.tools.compiler.codfile.ClassDef loc_interface = ClassDef.getInterface(m1);
				Message.append(loc_interface.get_Name());
				if (!(m1 >= k1 -1))
					Message.append(", ");
				else
					Message.append("\r\n");
			}
			
			Message.append("\r\n");
			Message.append("{\r\n");
			Message.append("\r\n");
			Message.append("\r\n");
			
		}
	}
	
	private static void print_fields (StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef)
	{
		if ((Message != null) && (ClassDef != null))
		{
			
			net.rim.tools.compiler.codfile.FieldDefLocal loc_Field = null;
			net.rim.tools.compiler.codfile.TypeItem loc_BaseType = null;
			
			int i = ClassDef.getNumFieldDefs(true);
			for (int k = 0; k < i; k++)
			{
				loc_Field =(net.rim.tools.compiler.codfile.FieldDefLocal)ClassDef.getFieldDef(k,true);
				String s = loc_Field.get_Name();
				if (s.lastIndexOf(".") != -1)
					s = s.substring(s.lastIndexOf(".") + 1);
				String a = get_field_attributes(loc_Field.getAttributes());
				loc_BaseType = (loc_Field.getTypeList()).get_baseType();
				String t = loc_BaseType.getTypeName() + " ";
				Message.append("\t");
				Message.append(a);
				Message.append("static ");
				Message.append(t);
				Message.append(s);
				Message.append(";\r\n");
			}
			
			i = ClassDef.getNumFieldDefs(false);
			for (int m = 0; m < i; m++ )
			{
				loc_Field =(net.rim.tools.compiler.codfile.FieldDefLocal)ClassDef.getFieldDef(m,false);
				String s = loc_Field.get_Name();
				if (s.lastIndexOf(".") != -1)
					s = s.substring(s.lastIndexOf(".") + 1);
				String a = get_field_attributes(loc_Field.getAttributes());
				loc_BaseType = (loc_Field.getTypeList()).get_baseType();
				String t = loc_BaseType.getTypeName() + " ";
				Message.append("\t");
				Message.append(a);
				Message.append(t);
				Message.append(s);
				Message.append(";\r\n");
			}
			
		}
	}
	
	private static void print_routine_parameters (StringBuffer Message, net.rim.tools.compiler.codfile.RoutineLocal Routine)
	{
		if ((Message != null) && (Routine != null))
		{
			int i = Routine.getProtoTypeList().length();
			for (int k = 0; k < i; k++)
			{
				net.rim.tools.compiler.codfile.TypeList loc_param = 	Routine.getProtoTypeList();
				String p = loc_param.get_type(k).getTypeName()+ " " + "param" + k;
				Message.append(p);
				if (k < i -1)
					Message.append(",");
			}
		}
	}
	
	private static void print_exception (StringBuffer Message, net.rim.tools.compiler.codfile.RoutineLocal Routine)
	{
		if ((Message != null) && (Routine != null))
		{
			int i = Routine.getNumExceptionHandlers();
			if (i > 0)
				Message.append("throws");
			for (int k = 0; k < i; k++)
			{
				
			}
		}
		
	}
	
	private static void print_code (StringBuffer Message, net.rim.tools.compiler.codfile.RoutineLocal Routine) throws IOException
	{
		if ((Message != null) && (Routine != null))
		{
			//Routine.getCode().disassembler(Message);
			
		}
		
	}
	
	private static void print_static_methods (StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef) throws IOException
	{
		if ((Message != null) && (ClassDef != null))
		{
			net.rim.tools.compiler.codfile.Routine loc_static_method = null;
			
			int i = ClassDef.get_staticRoutinesSize();
			for (int k = 0; k < i; k++ )
			{
				loc_static_method = ClassDef.getStaticRoutine(k);
				String s = loc_static_method.get_name_2();
				s = s.substring(s.lastIndexOf(".") + 1);
				if (s.indexOf("<") != -1)
					s = ClassDef.getClassNameString();
				String a = get_method_attributes(((net.rim.tools.compiler.codfile.RoutineLocal)loc_static_method).getAttributes());
				
				net.rim.tools.compiler.codfile.TypeItem loc_BaseType = (loc_static_method.getTypeList()).get_baseType();
				
				String t = "";
				
				if (loc_BaseType != null)
				{
					t = loc_BaseType.getTypeName() + " ";
				}
				else
				{
					if (!s.equals(ClassDef.getClassNameString()))
					{
						t = "void ";
					}
				}
								
				
				// method header
				Message.append("\t");
				Message.append(a); // attributes
				Message.append(t); // return type
				Message.append(s + " "); // method name
				
				Message.append("(");
				// method parameters
				print_routine_parameters (Message,(net.rim.tools.compiler.codfile.RoutineLocal)loc_static_method);
				Message.append(")");
				
				Message.append("\r\n");
				Message.append("\r\n");
				// exceptions handler
				//Message.append("\t");
				//print_exception(Message, (net.rim.tools.compiler.d.z)loc_static_method );
				
				// method body
				Message.append("\t");
				Message.append("{");
				Message.append("\r\n");
				print_code(Message, (net.rim.tools.compiler.codfile.RoutineLocal)loc_static_method );
				Message.append("\t");
				Message.append("}");
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\r\n");
			}
		}
	}

	private static void print_virtual_methods(StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef) throws IOException
	{
		if ((Message != null) && (ClassDef != null))
		{
			net.rim.tools.compiler.codfile.Routine loc_virtual_method = null;
			
			int i = ClassDef.getNumVirtualRoutines();
			for (int k = 0; k < i; k++ )
			{
				loc_virtual_method = ClassDef.getVirtualRoutine(k);
				String s = loc_virtual_method.get_name_2();
				s = s.substring(s.lastIndexOf(".") + 1);
				if (s.indexOf("<") != -1)
					s = ClassDef.getClassNameString();
				String a = get_method_attributes(((net.rim.tools.compiler.codfile.RoutineLocal)loc_virtual_method).getAttributes());
				
				net.rim.tools.compiler.codfile.TypeItem loc_BaseType = (loc_virtual_method.getTypeList()).get_baseType();
				
				String t = "";
				
				if (loc_BaseType != null)
				{
					t = loc_BaseType.getTypeName() + " ";
				}
				else
				{
					if (!s.equals(ClassDef.getClassNameString()))
					{
						t = "void ";
					}
				}
				
				
				// method header
				Message.append("\t");
				Message.append(a); // attributes
				Message.append(t); // return type
				Message.append(s + " "); // method name
				
				Message.append("(");
				// method parameters
				print_routine_parameters (Message,(net.rim.tools.compiler.codfile.RoutineLocal)loc_virtual_method);
				Message.append(")");
				
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\t");
				// method body
				Message.append("{");
				Message.append("\r\n");
				print_code(Message, (net.rim.tools.compiler.codfile.RoutineLocal)loc_virtual_method );
				Message.append("\t");
				Message.append("}");
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\r\n");
			}
		}
		
	}
	
	private static void print_non_virtual_methods(StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef) throws IOException
	{
		if ((Message != null) && (ClassDef != null))
		{
			net.rim.tools.compiler.codfile.Routine loc_non_virtual_method = null;
			
			int i = ClassDef.get_nonVirtualRoutinesSize();
			for (int k = 0; k < i; k++ )
			{
				loc_non_virtual_method = ClassDef.get_nonVirtualRoutine(k);
				String s = loc_non_virtual_method.get_name_2();
				s = s.substring(s.lastIndexOf(".") + 1);
				if (s.indexOf("<") != -1)
					s = ClassDef.getClassNameString();
				String a = get_method_attributes(((net.rim.tools.compiler.codfile.RoutineLocal)loc_non_virtual_method).getAttributes());
				
				net.rim.tools.compiler.codfile.TypeItem loc_BaseType = (loc_non_virtual_method.getTypeList()).get_baseType();
				
				String t = "";
				
				if (loc_BaseType != null)
				{
					t = loc_BaseType.getTypeName() + " ";
				}
				else
				{
					if (!s.equals(ClassDef.getClassNameString()))
					{
						t = "void ";
					}
				}
				
				
				// method header
				Message.append("\t");
				Message.append(a); // attributes
				Message.append(t); // return type
				Message.append(s + " "); // method name
				
				Message.append("(");
				// method parameters
				print_routine_parameters (Message,(net.rim.tools.compiler.codfile.RoutineLocal)loc_non_virtual_method);
				Message.append(")");
				
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\t");
				// method body
				Message.append("{");
				Message.append("\r\n");
				print_code(Message, (net.rim.tools.compiler.codfile.RoutineLocal)loc_non_virtual_method );
				Message.append("\t");
				Message.append("}");
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\r\n");
			}
		}
		
	}
	
	private static void print_interfaces (StringBuffer Message, net.rim.tools.compiler.codfile.ClassDefLocal ClassDef)
	{
		if ((Message != null) && (ClassDef != null))
		{
			net.rim.tools.compiler.codfile.ClassDef loc_interface_methods = null;
			
			int i = ClassDef.getNumInterfaces();
			for (int k = 0; k < i; k++ )
			{
				loc_interface_methods = ClassDef.getInterface(k);
				String s = loc_interface_methods.get_name_2();
				s = s.substring(s.lastIndexOf(".") + 1);
				if (s.indexOf("<") != -1)
					s = ClassDef.getClassNameString();
                
				String a = "" ;//get_method_attributes(((net.rim.tools.compiler.d.z)loc_interface_methods).get_methodAttributes());
				
				net.rim.tools.compiler.codfile.TypeItem loc_BaseType = null; //(loc_interface_methods.get_returnType()).get_baseType();
				
				String t = "";
				
				if (loc_BaseType != null)
				{
					t = loc_BaseType.getTypeName() + " ";
				}
				else
				{
					if (!s.equals(ClassDef.getClassNameString()))
					{
						t = "void ";
					}
				}
				
				
				// method header
				Message.append("\t");
				Message.append(a); // attributes
				Message.append(t); // return type
				Message.append(s + " "); // method name
				
				Message.append("(");
				// method parameters
				Message.append(")");
				
				Message.append("\r\n");
				Message.append("\r\n");
				Message.append("\t");
				// method body
				Message.append("{");
				Message.append("\r\n");
				Message.append("\t");
				Message.append("}");
				Message.append("\r\n");
			}
		}
		
	}
	
	private static void decompile(byte param_fileAsByteArray[])
	throws IOException
	{
		net.rim.tools.compiler.codfile.Codfile _codFile_ = new net.rim.tools.compiler.codfile.Codfile(param_fileAsByteArray);
        _codFile_.processCodeSegment(false);
		net.rim.tools.compiler.codfile.DataSection _dataSection_ = _codFile_.getDataSection();
		Vector _classDefs_ = _dataSection_.getClassDefs();
        int _numClassDefs_ = _classDefs_.size();
		StringBuffer _stringbuf_ = new StringBuffer();
		for (int i = 0; i < _numClassDefs_; i++)
		{
			net.rim.tools.compiler.codfile.ClassDefLocal _ClassDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDefs_.elementAt(i);
			String local_packageName = _ClassDefLocal_.getPackageNameString();
			String _moduleName_ = _ClassDefLocal_.getModule().getName().getString();
			String local_package_path = create_package_path(_moduleName_ + "." + local_packageName);
			String local_className = local_package_path + File.separator + _ClassDefLocal_.getClassNameString() +  ".java";
			FileOutputStream javaOutputStream = new FileOutputStream(local_className);
			try
			{
				OutputStreamWriter javaOutputWriter = new OutputStreamWriter(javaOutputStream);
				// package header : package, class attributes, class name
				print_class_header(_stringbuf_, _ClassDefLocal_);
				// imports

				javaOutputWriter.write(_stringbuf_.toString(),0,_stringbuf_.length());
				_stringbuf_.setLength(0);
							
				      // static fields, fields


						print_fields(_stringbuf_, _ClassDefLocal_);
				
				      // static methods
				
						_stringbuf_.append("\r\n");
						print_static_methods(_stringbuf_, _ClassDefLocal_);

				     // virtual methods
				
						print_virtual_methods(_stringbuf_, _ClassDefLocal_);
				
				     // print non-virtual methods
				
						print_non_virtual_methods (_stringbuf_, _ClassDefLocal_);
				
					// print interfaces
						//print_interfaces (loc_strbuffer, local_classDef);
				
				_stringbuf_.append("}\r\n");
				javaOutputWriter.write(_stringbuf_.toString(),0,_stringbuf_.length());
				_stringbuf_.setLength(0);
				javaOutputWriter.flush();
				javaOutputWriter.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
				javaOutputStream.close();
			}

		}
	}
	
	private static void parse_files()
	{
		
		if ((f_fileList != null) && (f_fileList.size()!=0))
		{
			int local_listSize = f_fileList.size();
			for (int i=0; i<local_listSize; i++)
			{
				String local_fileName = (String)f_fileList.elementAt(i);
				File local_file = new File (local_fileName);
				if (local_file.exists())
					try
				    {
						try
						{
							JarFile local_jarfile = new JarFile(local_file,false);
							byte fileAsByteArray[];
							for (Enumeration enumeration = local_jarfile.entries();enumeration.hasMoreElements(); decompile(fileAsByteArray)) //decompile(fileAsByteArray)) //decompile
							{
								JarEntry local_jarEntry = (JarEntry)enumeration.nextElement();
								String local_jarEntryName = local_jarEntry.getName();
								fileAsByteArray = net.rim.tools.compiler.io.StructuredInputStream.readFully(local_jarfile.getInputStream(local_jarEntry), (int)local_jarEntry.getSize(), local_jarEntryName);
							}
						}
						catch (IOException ioexception1)
						{
							byte fileAsByteArray1[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(new FileInputStream(local_file), (int)local_file.length(), local_fileName);
							//decompile
							decompile(fileAsByteArray1);
							//test(fileAsByteArray1);
						}
					}
					catch (IOException ioexception)
					{
                        System.out.println(ioexception.getMessage());
						ioexception.printStackTrace();
					}
			}
		
		}
		
		
	}
	
	private static void process_files ()
	{
		if (f_fileList != null)
		{
			int local_listSize = f_fileList.size();
			for (int i = 0; i < local_listSize; i++)
			{
				String local_fileName = (String)f_fileList.elementAt(i);
				File local_file = new File(local_fileName);
				if (!local_file.exists())
				{
					f_fileList.remove(i);
				}
			}
		}
		else
		{
			System.out.println("coddec is stoped. no files to process");
			return;
		}
		
		
		if ((f_fileList != null) && (f_fileList.size()!=0))
		{
			parse_files();
		}
		else
		{
			System.out.println("coddec is stoped. no files to process");
			return;
		}
		
	}
	
	private static void check_files (String args[])
	{
		if (f_fileList == null)
		{
			f_fileList = new Vector();
		}
		
		int num_files = args.length;
		
		for (int i = 0; i < num_files; i++)
		{
			String local_fileName = args[i];
			if (local_fileName.lastIndexOf(".") != -1) {
				String local_ext = local_fileName.substring(local_fileName.lastIndexOf("."));
				if (local_ext.equals(".cod"))
				{
					f_fileList.addElement((String)local_fileName);
				}
			}
			else
			{
				local_fileName = local_fileName + ".cod";
				f_fileList.addElement((String)local_fileName);
			}
			
		}
		
		
	}
	
	public static void coddec (String args[])
	{
		if ((args == null) || (args.length == 0))
		{
			System.out.println("Usage: coddec <filename1.[cod]> [.. <filenameZ.[cod]>]");
		}
		else
		{
			check_files(args);
			process_files();
		}
	}
}
