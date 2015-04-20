// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import net.rim.tools.compiler.codfile.ExportedData;
import net.rim.tools.compiler.codfile.DataBytes;
import net.rim.tools.compiler.codfile.Codfile;
import net.rim.tools.compiler.codfile.TypeLists;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.ModuleDomestic;
import net.rim.tools.compiler.classfile.ac;
import net.rim.tools.compiler.classfile.Attribute;
import net.rim.tools.compiler.classfile.af;
import net.rim.tools.compiler.classfile.ClassFileMethod;
import net.rim.tools.compiler.classfile.ClassFileField;
import net.rim.tools.compiler.classfile.AttributeCode;
import net.rim.tools.compiler.classfile.ClassFile;
import net.rim.tools.compiler.classfile.AttributeLocalVariableTable;
import net.rim.tools.compiler.classfile.AttributeList;
import net.rim.tools.compiler.classfile.v;
import net.rim.tools.compiler.classfile.AttributeStackMapTable;
import net.rim.tools.compiler.classfile.AttributeLineNumberTable;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.util.DuplicateException;
import net.rim.tools.compiler.util.FileHelper;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.NullType;
import net.rim.tools.compiler.types.BaseType;
import net.rim.tools.compiler.types.Constant;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.Field;
import net.rim.tools.compiler.types.NameAndType;
import net.rim.tools.compiler.types.TypeModule;
import net.rim.tools.compiler.types.Modifier;

// Referenced classes of package net.rim.tools.compiler:
//            a, d, h, j,
//            g, f, i

public class Compiler
    implements net.rim.tools.compiler.vm.cls_d
{

    private static final int z_ddI = 63488;
    private static final int z_coI = 61440;
    private static final int z_dGI = 61440;
    private static final int z_bNI = 61440;
    private static final int z_ceI = 8000;
    private static final int z_cZI = 8000;
    private static final int z_cHI = 0x39485766;
    public static final int z_b9I = 0;
    public static final int z_cnI = 1;
    public static final int z_c7I = 2;
    public static int _verboseLevel;
    public static final String z_ccString = "rapc_jarFiles";
    public static final String z_cAString = "rapc_resourceBinaries";
    public static final String z_cQString = "jad";
    public static final String z_cKString = "rapc";
    public static final String z_dbString = "_";
    public static final int z_dBI = 0;
    public static final int z_chI = -1;
    public static final int z_cfI = 97;
    public static final int z_drI = 904;
    public static final int z_c5I = 905;
    public static final int z_cwI = 906;
    public static final int z_ckI = 907;
    public static final int z_cxI = 908;
    public static final int z_dqI = 909;
    public static final int z_dUI = 910;
    public static final String z_dmString = "rapc_javaFiles";
    public static final String z_cTString = "rapc_classFiles";
    public static final String z_cmString = "rapc_keyFiles";
    public static final String z_bXString = "rapc_rrFiles";
    public static final int z_dtI = 0x33000000;
    public static final int z_csI = 0x52525400;
    public static final int z_dPI = 0x52424200;
    private static Vector f_parametersMethodV = new Vector();
    private net.rim.tools.compiler.types.NullType _nullType;
    private net.rim.tools.compiler.types.BaseType _voidType;
    private net.rim.tools.compiler.types.BaseType _booleanType;
    private net.rim.tools.compiler.types.BaseType _byteType;
    private net.rim.tools.compiler.types.BaseType _shortType;
    private net.rim.tools.compiler.types.BaseType _charType;
    private net.rim.tools.compiler.types.BaseType _intType;
    private net.rim.tools.compiler.types.BaseType _longType;
    private net.rim.tools.compiler.types.BaseType _floatType;
    private net.rim.tools.compiler.types.BaseType _doubleType;
    private int _timeStamp;
    private int _optimization;
    private boolean _traceBack;
    private boolean _preverified;
    private boolean z_dTZ;
    private boolean _optimizePackage;
    private boolean _isMidlet;
    private boolean f_flagInclusive;
    private Vector _modules; // list of imported modules
    private Hashtable f_packagesHashtable_nv;
    private Vector _classes;
    private int z_cyI;
    private Vector f_resultedClassTableV;
    private Vector z_cIVector;
    private int z_dFI;
    private Vector z_b1Vector;
    private Vector _stats;
    private net.rim.tools.compiler.util.CompilerProperties _configProperties;
    private Vector z_cLVector;
    private Vector _exports;
    private Vector f_paramStaticsV;
    private Vector f_paramFieldsV;
    private Vector f_paramStringsV;
    private Vector _rootObjectClassVTable;
    private ClassType _javaLangObject;
    private ClassType _javaLangString;
    private ClassType _javaLangStringBuffer;
    private net.rim.tools.compiler.JadSupport _jadFile;
    private Vector _jarFiles;
    private Vector _resources;
    private String _packageName;
    private String _codeName;
    private String _codFileName;
    private String f_midletVersionS;
    private ClassType z_bKg;
    private int f_codeFullI;
    private int f_dataFullI;
    private int _vtableMaxSize;
    private int _fieldMaxSize;
    private boolean z_cBZ;
    private boolean _isLibrary;
    private boolean z_dgZ;
    private boolean _isBrittle;
    private boolean _snapshotOption;
    private boolean z_dIZ;
    private String _currentMessage;
    private FileHelper _fileHelper;
    private File _tempDir;
    private ClassType f_javaLangThrowableG;
    private Vector _classFiles;
    private Vector _javaFiles;
    private Vector _rrFiles;
    private Vector _classPath;
    private Vector z_dKVector;
    private Vector _imports;
    private Vector z_dcVector;
    private Vector _natives;
    private Vector f_paramPersistableV;
    private Vector z_cXVector;
    private Vector f_paramInterfaceMethodsV;
    private Vector f_paramKnownKeysV;
    private Vector f_paramWarnKeyV;
    private Vector f_paramRRTTListV;
    private Vector f_paramDiagnoseExportsV;
    private Vector f_paramDiagnoseMethodsV;
    private Vector f_paramNoWXV;
    private Vector z_dDVector;
    private String _tmpDirectory;
    private int z_dhI;
    private int _modulesCounts[];
    private String _exePath;
    private String f_javaCompilerNameS;
    private String _strings_[];
    private String f_modulesDependenciesS;
    private net.rim.tools.compiler.exec.g _messageDigest;
    private net.rim.tools.compiler.exec.g _signatures[];
    private String _staticFileName_;
    private String z_dAString;
    private boolean z_c3Z;
    private boolean _debugOption;
    private boolean z_bQZ;
    private boolean z_bFZ;
    private boolean _emitStaticOption;
    private boolean f_javaCompiler;
    private boolean f_jikesCompiler;
    private boolean f_wjavaCompiler;
    private boolean f_gcjCompiler;
    private boolean _noLoadToolOption;
    private boolean _existFilesToProceed;
    private boolean z_cFZ;
    private boolean z_dOZ;
    private boolean z_c0Z;
    private boolean z_dkZ;
    private boolean z_dEZ;
    private boolean z_dnZ;
    private boolean z_dLZ;
    private boolean _convertPNGOption;
    private static final String z_bVString = "|";
    private static final String z_bGString = "&";
    private static final int z_bZI = 0;
    private static final int z_bII = 1;
    private static final int z_cjI = 2;

    public Compiler(Object obj, net.rim.tools.compiler.util.CompilerProperties __properties)
        throws net.rim.tools.compiler.util.CompileException
    {
        _classes = new Vector();
        f_resultedClassTableV = new Vector();
        z_cIVector = new Vector();
        _optimization = 11007;
        _preverified = true;
        _nullType = new net.rim.tools.compiler.types.NullType(); //NullType
        _voidType = new net.rim.tools.compiler.types.BaseType ("void", 0, 10); //void type
        _booleanType = new net.rim.tools.compiler.types.BaseType("boolean", 1, 1); //boolean
        _byteType = new net.rim.tools.compiler.types.BaseType("byte", 1, 2); //byte type
        _shortType = new net.rim.tools.compiler.types.BaseType("short", 2, 4);//short type
        _charType = new net.rim.tools.compiler.types.BaseType("char", 2, 3); //char type
        _intType = new net.rim.tools.compiler.types.BaseType("int", 4, 5); //int type
        _longType = new net.rim.tools.compiler.types.BaseType("long", 8, 6); //long type
        _floatType = new net.rim.tools.compiler.types.BaseType("float", 4, 11); //float type
        _doubleType = new net.rim.tools.compiler.types.BaseType("double", 8, 12); //double type
        _modules = new Vector();
        f_packagesHashtable_nv = new Hashtable(64);
        _configProperties = __properties;
        _jarFiles = __properties.getVector("rapc_jarFiles");
        _resources = __properties.getVector("rapc_resourceBinaries");
        _classFiles = (Vector)__properties.get("rapc_classFiles");
        _javaFiles = (Vector)__properties.get("rapc_javaFiles");
        _rrFiles = (Vector)__properties.get("rapc_rrFiles");
        _fileHelper = new net.rim.tools.compiler.util.FileHelper();
        _tmpDirectory = _configProperties.getQuotedProperty("tmpdir");
        _exePath = _configProperties.getQuotedProperty("exepath");
        _classPath = _configProperties.parseVector("classpath", false);
        _imports = _configProperties.parseVector("import", false);
        z_dKVector = _configProperties.parseVector("def", false);
        z_dcVector = _configProperties.parseVector("alias", false);
        z_dAString = _configProperties.getQuotedProperty("workspace");
        _codeName = _configProperties.getQuotedProperty("codename");
        if(_codeName == null)
        {
            _codeName = "_";
            _codFileName = "_";
        } else
        {
            _codFileName = _newStringString(net.rim.tools.compiler.util.FileHelper._zStringString(_codeName));
        }
        String s1 = _configProperties.getQuotedProperty("library"); //loc_libraryFileNameS
        if(s1 != null)
        {
            _isLibrary = true;
            if(!s1.equals("1"))
            {
                _codeName = s1;
                _codFileName = _newStringString(net.rim.tools.compiler.util.FileHelper._zStringString(_codeName));
            }
        }
        String s2 = _configProperties.getProperty("target");//loc_targetParamS
        z_c0Z = "3.6".equals(s2);//f_target36B
        z_cFZ = false;
        if(_isLibrary)
            z_cFZ = true;
        else
        if(_configProperties.getProperty("midlet") != null)
        {
            _isMidlet = true;
            if(_configProperties.getProperty("class") == null)
                _configProperties.setProperty("class", "MIDletMain");
        }
        _convertPNGOption = true;
        if(_isMidlet || __properties.getProperty("noconvertpng") != null)
            _convertPNGOption = false;
        if(_configProperties.getProperty("eviscerate") != null)
            z_cFZ = true;
        if(_configProperties.getProperty("noeviscerate") != null)
            z_cFZ = false;
        z_dOZ = true;
        if(_configProperties.getProperty("noparsecod") != null)
            z_dOZ = false;
        _timeStamp = (int)(System.currentTimeMillis() / 1000L);
        if(_configProperties.getProperty("t0") != null)
            _timeStamp = 0x39485766;
        _debugOption = true;
        if(_configProperties.get("nodebug") != null)
        {
            _debugOption = false;
            _timeStamp = 0x39485766;
        }
        if(_configProperties.get("emitstatic") != null)
            _emitStaticOption = true;
        z_bQZ = true;
        if(_configProperties.get("nocsl") != null)
            z_bQZ = false;
        z_bFZ = false;
        if(_configProperties.get("export") != null && _isLibrary)
            z_bFZ = true;
        if(_configProperties.getProperty("exclusive") != null)
            z_dgZ = true;
        if(_configProperties.getProperty("brittle") != null)
        {
            if(z_c0Z)
                throw new net.rim.tools.compiler.util.CompileException(null, "-brittle option not supported for -target=3.6");
            if(_timeStamp == 0x39485766)
                throw new net.rim.tools.compiler.util.CompileException(null, "-brittle option not supported for -t0 or -nodebug");
            _isBrittle = true;
        }
        if(_configProperties.getProperty("snapshot") != null)
            _snapshotOption = true;
        if(_configProperties.getProperty("nomain") != null)
            z_dIZ = true;
        f_javaCompilerNameS = _configProperties.getProperty("javacompiler");
        if(f_javaCompilerNameS == null)
            f_javaCompilerNameS = "javac"; //f_javaCompilerNameS
        f_javaCompiler = f_javaCompilerNameS.endsWith("javac") || f_javaCompilerNameS.endsWith("javac.exe");//f_javaCompiler
        f_jikesCompiler = f_javaCompilerNameS.endsWith("jikes") || f_javaCompilerNameS.endsWith("jikes.exe");//f_jikesCompiler
        f_wjavaCompiler = f_javaCompilerNameS.endsWith("wjava") || f_javaCompilerNameS.endsWith("wjava.exe");//f_wjavaCompiler
        f_gcjCompiler = f_javaCompilerNameS.endsWith("gcj") || f_javaCompilerNameS.endsWith("gcj.exe"); //f_gcjCompiler
        if(_configProperties.getProperty("noloadtool") == null)
            _noLoadToolOption = true;
        z_cBZ = false;
        if(_configProperties.getProperty("dump_preferred") != null)
            z_cBZ = true;
        _traceBack = true;
        _verboseLevel = 2;
        if(_configProperties.getProperty("verbose") != null)
        {
            _verboseLevel = 2;
            _traceBack = true;
        }
        if(_configProperties.getProperty("traceback") != null)
            _traceBack = true;
        if(_configProperties.getProperty("quiet") != null)
            _verboseLevel = 0;
        if(_configProperties.getProperty("VERBOSE") != null)
        {
            _verboseLevel = 2;
            _traceBack = true;
        }
        if(_configProperties.getProperty("warning") != null)
            z_dTZ = true;
        if(_configProperties.getProperty("inclusive") != null)
            f_flagInclusive = true;
        _aStringvV("optimize", true);
        _aStringvV("nooptimize", false);
        z_dnZ = !z_dTZ;
        z_dLZ = !z_dTZ;
        if(z_c0Z)
            _charIV(10240);
        if(_configProperties.getProperty("optimizepackage") != null)
            _optimizePackage = true;
        if(_configProperties.getProperty("nopreverified") != null)
            _preverified = false;
        f_codeFullI = 63488;//f_codeFullI
        String s3 = _configProperties.getProperty("codefull");
        if(s3 != null)
            try
            {
                f_codeFullI = Integer.parseInt(s3);
            }
            catch(NumberFormatException numberformatexception) { }
        f_dataFullI = 61440; //f_dataFullI
        s3 = _configProperties.getProperty("datafull");
        if(s3 != null)
            try
            {
                f_dataFullI = Integer.parseInt(s3);
            }
            catch(NumberFormatException numberformatexception1) { }
        _vtableMaxSize = 61440;//f_vtableFullI
        s3 = _configProperties.getProperty("vtablefull");
        if(s3 != null)
            try
            {
                _vtableMaxSize = Integer.parseInt(s3);
            }
            catch(NumberFormatException numberformatexception2) { }
        _fieldMaxSize = 61440;//f_fieldFullI
        s3 = _configProperties.getProperty("fieldfull");
        if(s3 != null)
            try
            {
                _fieldMaxSize = Integer.parseInt(s3);
            }
            catch(NumberFormatException numberformatexception3) { }
    }

    private String _newStringString(String s1)
    {
        int l = s1.length();
        StringBuffer stringbuffer = new StringBuffer(l + 1);
        char c1 = s1.charAt(0);
        if(!net.rim.tools.compiler.exec.CharacterHelper.isJavaIdentifierStart(c1))
            stringbuffer.append('_');
        for(int i1 = 0; i1 < l; i1++)
        {
            char c2 = s1.charAt(i1);
            if(net.rim.tools.compiler.exec.CharacterHelper.isJavaIdentifierPart(c2))
            {
                stringbuffer.append(c2);
            } else
            {
                stringbuffer.append('$');
                stringbuffer.append(Integer.toHexString(c2));
            }
        }

        if(stringbuffer.length() > 124)
            stringbuffer.setLength(124);
        return stringbuffer.toString();
    }

    public final boolean isPreverified()
    {
        return _preverified;
    }

    public final void generateWarning(boolean flag, String s1, String s2)
    {
        if(flag && z_dkZ)
            z_dEZ = true;
        if(s1 != null)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print(s1 + ": ");
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Warning!: " + s2);
    }

    private void parseAliases_notverified()
    {
        int l = z_dcVector.size();
        for(int i1 = l - 1; i1 >= 0; i1--)
        {
            String s1 = (String)z_dcVector.elementAt(i1);
            int j1 = s1.indexOf('.');
            if(j1 != -1)
            {
                generateWarning(true, null, "alias name '" + s1 + "' trimming extension: " + s1.substring(j1));
                if(j1 < 1)
                    z_dcVector.removeElementAt(i1);
                else
                    z_dcVector.setElementAt(s1.substring(0, j1), i1);
            }
        }

    }

    public boolean _hvZ()
    {
        return z_dTZ;
    }

    public boolean _intStringZ(String s1)
    {
        return f_paramNoWXV != null && f_paramNoWXV.indexOf(s1) != -1;
    }

    public final boolean _gvZ()
    {
        return _isLibrary;
    }

    public final boolean _nullvZ()
    {
        return z_cBZ;
    }

    public final void _charIV(int l)
    {
        _optimization &= ~l;
    }

    public final boolean isOptimizePackage()
    {
        return _optimizePackage;
    }

    public final boolean isMakingMIDlet()
    {
        return _isMidlet;
    }

    public final boolean getTraceback()
    {
        return _traceBack;
    }

    public final int getOptimization()
    {
        return _optimization;
    }

    public final void referenceClass(ClassType __classType)
    {
        Vector vector = _classes;
        int l = vector.size();
        for(int i1 = z_cyI; i1 < l; i1++)
            if(__classType._bytegI((ClassType)vector.elementAt(i1)) < 0)
            {
                vector.insertElementAt(__classType, i1);
                return;
            }

        vector.addElement(__classType);
    }

    public final void useClassType(ClassType __classType)
    {
        Vector vector = f_resultedClassTableV;
        int l = vector.size();
        for(int i1 = 0; i1 < l; i1++)
            if(__classType._bytegI((ClassType)vector.elementAt(i1)) < 0)
            {
                vector.insertElementAt(__classType, i1);
                return;
            }

        vector.addElement(__classType);
    }

    public final void useMethod(net.rim.tools.compiler.types.Method __method)
    {
        Vector vector = z_cIVector;
        int l = vector.size();
        for(int i1 = z_dFI; i1 < l; i1++)
            if(__method.getClassType()._bytegI(((net.rim.tools.compiler.types.NameAndType)vector.elementAt(i1)).getClassType()) < 0)
            {
                vector.insertElementAt(__method, i1);
                return;
            }

        vector.addElement(__method);
    }

    public final void addPotentialMIDlet(ClassType __classType)
    {
        if(!_isMidlet)
            return;
        if(z_b1Vector == null)
            z_b1Vector = new Vector();
        z_b1Vector.addElement(__classType);
    }

    public final net.rim.tools.compiler.types.Type getNullType()
    {
        return _nullType;
    }

    public final net.rim.tools.compiler.types.Type getVoidType()
    {
        return _voidType;
    }

    public final net.rim.tools.compiler.types.Type getBooleanType()
    {
        return _booleanType;
    }

    public final net.rim.tools.compiler.types.Type getByteType()
    {
        return _byteType;
    }

    public final net.rim.tools.compiler.types.Type getCharType()
    {
        return _charType;
    }

    public final net.rim.tools.compiler.types.Type getShortType()
    {
        return _shortType;
    }

    public final net.rim.tools.compiler.types.Type getIntType()
    {
        return _intType;
    }

    public final net.rim.tools.compiler.types.Type getLongType()
    {
        return _longType;
    }

    public final net.rim.tools.compiler.types.Type getFloatType()
    {
        return _floatType;
    }

    public final net.rim.tools.compiler.types.Type getDoubleType()
    {
        return _doubleType;
    }

    public final net.rim.tools.compiler.types.ClassType getObjectClass()
    {
        return _javaLangObject;
    }

    public final net.rim.tools.compiler.types.ClassType getStringClass()
    {
        return _javaLangString;
    }

    public final net.rim.tools.compiler.types.ClassType getStringBufferClass()
    {
        return _javaLangStringBuffer;
    }

    public final net.rim.tools.compiler.types.ClassType _pvg()
    {
        if(f_paramPersistableV.size() > 0)
            return (ClassType)f_paramPersistableV.elementAt(0);
        else
            return null;
    }

    public final net.rim.tools.compiler.types.ClassType _rvg()
    {
        return f_javaLangThrowableG;
    }

    public final void setNativeMethod(net.rim.tools.compiler.types.Method __method)
    {
        if(_natives == null)
        {
            _natives = new Vector();
            _configProperties.putVector("natives", _natives);
            z_c3Z = true;
        }
        _natives.addElement(__method);
    }

    public final net.rim.tools.compiler.types.Method getNativeMethod(int __index)
    {
        if(_natives != null)
            return (net.rim.tools.compiler.types.Method)_natives.elementAt(__index);
        else
            return null;
    }

    public final int augmentFieldModifiers(net.rim.tools.compiler.types.ClassType __classType, int __attribute)
    {
        if(__classType.hasAttribute(0x40000))
            __attribute |= 0x40000;
        if(__classType.hasAttribute(0x20000))
            __attribute |= 0x20000;
        if(__classType.hasAttribute(0x80000))
            __attribute |= 0x80000;
        if((__attribute & 2) == 0)
            __attribute |= 4;
        return __attribute;
    }

    public final int augmentMethodModifiers(net.rim.tools.compiler.types.ClassType g1, int l)
    {
        if(g1.hasAttribute(0x40000))
            l |= 0x40000;
        if(g1.hasAttribute(0x20000))
            l |= 0x20000;
        if(g1.hasAttribute(0x80000))
            l |= 0x80000;
        if((l & 0x10) == 0 && g1.hasAttribute(64))
            l |= 0x40;
        l |= 8;
        return l;
    }

    public final int augmentClassModifiers(int l)
    {
        if(_isBrittle)
            l |= 0x40000;
        if(_isLibrary && !z_dgZ)
            l |= 0x80000;
        if(f_flagInclusive)
            l |= 0x80000;
        return l;
    }

    private void setJadFile(net.rim.tools.compiler.JadSupport __jadFile)
    {
        _jadFile = __jadFile;
    }

    public final boolean checkStaticMethodForExport(String __name, net.rim.tools.compiler.types.Method __method)
    {
        int l = _exports.indexOf(__name);
        if(l == -1)
        {
            l = f_paramDiagnoseExportsV.indexOf(__name);
            if(l != -1 && !_isLibrary && !__method.is(0x20000))
            {
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print("Exported static routine: ");
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print(__name);
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(" is multiply defined.");
            }
            return false;
        }
        Object obj = _exports.elementAt(l);
        if(!(obj instanceof String))
        {
            return false;
        } else
        {
            _exports.setElementAt(new net.rim.tools.compiler.util.Exported(__name, __method), l);
            return true;
        }
    }

    public final boolean checkStaticDataForExport(String s1, net.rim.tools.compiler.types.ClassType g1, int l)
    {
        int i1 = f_paramStaticsV.indexOf(s1);
        if(i1 == -1)
            return false;
        Object obj = f_paramStaticsV.elementAt(i1);
        if(!(obj instanceof String))
        {
            return false;
        } else
        {
            f_paramStaticsV.setElementAt(new net.rim.tools.compiler.util.Exported(s1, g1, l), i1);
            return true;
        }
    }

    public final boolean checkFieldForExport(String s1, net.rim.tools.compiler.types.ClassType g1, int l)
    {
        int i1 = f_paramFieldsV.indexOf(s1);
        if(i1 == -1)
            return false;
        Object obj = f_paramFieldsV.elementAt(i1);
        if(!(obj instanceof String))
        {
            return false;
        } else
        {
            f_paramFieldsV.setElementAt(new net.rim.tools.compiler.util.Exported(s1, g1, l), i1);
            return true;
        }
    }

    public final boolean checkBinaryForExport(String s1, byte abyte0[])
    {
        int l = f_paramStringsV.indexOf(s1);
        if(l == -1)
            return false;
        Object obj = f_paramStringsV.elementAt(l);
        if(!(obj instanceof String))
        {
            return false;
        } else
        {
            f_paramStringsV.setElementAt(new net.rim.tools.compiler.util.Exported(s1, abyte0), l);
            return true;
        }
    }

    public final boolean _aStringZ(String s1, net.rim.tools.compiler.types.Method c1)
    {
        int l = f_paramInterfaceMethodsV.indexOf(s1);
        if(l == -1)
            return false;
        Object obj = f_paramInterfaceMethodsV.elementAt(l);
        if(!(obj instanceof String))
        {
            return false;
        } else
        {
            f_paramInterfaceMethodsV.setElementAt(new net.rim.tools.compiler.util.Exported(s1, c1), l);
            return true;
        }
    }

    public final boolean _tryStringZ(String s1)
    {
        return f_paramDiagnoseMethodsV.indexOf(s1) != -1;
    }

    public final net.rim.tools.compiler.util.Exported _elseId(int l)
    {
        Object obj = _exports.elementAt(l);
        if(obj instanceof net.rim.tools.compiler.util.Exported)
            return (net.rim.tools.compiler.util.Exported)obj;
        else
            return null;
    }

    public final net.rim.tools.compiler.util.Exported _byteId(int l)
    {
        Object obj = f_paramStaticsV.elementAt(l);
        if(obj instanceof net.rim.tools.compiler.util.Exported)
            return (net.rim.tools.compiler.util.Exported)obj;
        else
            return null;
    }

    public final net.rim.tools.compiler.util.Exported _caseId(int l)
    {
        Object obj = f_paramInterfaceMethodsV.elementAt(l);
        if(obj instanceof net.rim.tools.compiler.util.Exported)
            return (net.rim.tools.compiler.util.Exported)obj;
        else
            return null;
    }

    public final net.rim.tools.compiler.util.Exported _intId(int l)
    {
        Object obj = f_paramFieldsV.elementAt(l);
        if(obj instanceof net.rim.tools.compiler.util.Exported)
            return (net.rim.tools.compiler.util.Exported)obj;
        else
            return null;
    }

    ClassType _ifIg(int l)
    {
        return (ClassType)z_cXVector.elementAt(l);
    }

    public Vector getObjectClassVTable()
    {
        return _rootObjectClassVTable;
    }

    public final boolean _dvZ()
    {
        return z_c0Z;
    }

    public net.rim.tools.compiler.exec.g _fvg()
    {
        return _messageDigest;
    }

    private static File parsingArgsFilesF(String __args[], net.rim.tools.compiler.util.CompilerProperties __properties)
        throws IOException
    {
        File _file_ = null;
        if(__args != null)
        {
            Vector _classFiles_  = (Vector)__properties.get("rapc_classFiles");
            Vector _javaFiles_   = (Vector)__properties.get("rapc_javaFiles");
            Vector _jarFiles_    = (Vector)__properties.get("rapc_jarFiles");
            Vector _keyFiles_    = (Vector)__properties.get("rapc_keyFiles");
            Vector _rrFiles_     = (Vector)__properties.get("rapc_rrFiles");
            Vector _resources_ = (Vector)__properties.get("rapc_resourceBinaries");
            int _numArgs_ = __args.length;
            for(int index = 0; index < _numArgs_; index++)
            {
                String _argument_ = __args[index];
                int _posMinus_ = _argument_.indexOf('-');
                int _posEqual_ = _argument_.indexOf('=');
                if(_posEqual_ == -1)
                {
                    if(_posMinus_ == 0)
                    {
                        String loc_argsCopyOfS = _argument_.substring(1, _argument_.length());
                        __properties.setProperty(loc_argsCopyOfS, "1");
                    } else
                    {
                        String _fileName_ = net.rim.tools.compiler.util.FileHelper.removeQuotes(_argument_);
                        File file1 = (new File(_fileName_)).getAbsoluteFile(); //loc_paramFileName
                        if(_file_ == null)
                            _file_ = file1;
                        String s6 = file1.getName(); // loc_FileNameS
                        if(net.rim.tools.compiler.util.FileHelper.checkExtension(s6, net.rim.tools.compiler.util.FileHelper.ext_jar) != -1)
                            _jarFiles_.addElement(net.rim.tools.compiler.util.FileHelper._intFileFile(file1));
                        else
                        if(FileHelper.checkExtension(s6, FileHelper.ext_key) != -1)
                            _keyFiles_.addElement(file1);
                        else
                        if(FileHelper.checkExtension(s6, FileHelper.ext_class) != -1)
                            _classFiles_.addElement(file1);
                        else
                        if(FileHelper.checkExtension(s6, FileHelper.ext_java) != -1)
                            _javaFiles_.addElement(file1);
                        else
                        if(FileHelper.checkExtensions(s6, FileHelper.ext_resources) != -1)
                            _rrFiles_.addElement(file1);
                        else
                        if(FileHelper.checkExtension(s6, FileHelper.ext_jad) != -1)
                        {
                            __properties.setProperty("jad", _fileName_);
                            if(_file_ == file1)
                                _file_ = null;
                        } else
                        if(FileHelper.checkExtension(s6, FileHelper.ext_rapc) != -1)
                        {
                            __properties.setProperty("rapc", _fileName_);
                        } else
                        {
                            Object obj = null;
                            if(FileHelper.checkExtensions(s6, FileHelper.ext_images) != -1)
                                obj = new net.rim.tools.compiler.ImageFile(file1);
                            else
                                obj = new net.rim.tools.compiler.ResourceFile(file1);
                            if(_resources_.indexOf(obj) == -1)
                                _resources_.addElement(obj);
                        }
                    }
                } else
                {
                    String s3; //loc_paramKeyS
                    if(_posMinus_ == 0)
                        s3 = _argument_.substring(1, _posEqual_);
                    else
                        s3 = _argument_.substring(0, _posEqual_);
                    String s5 = _argument_.substring(_posEqual_ + 1);//loc_paramValueS
                    Vector vector6 = __properties.getVector(s3);//loc_paramPairV
                    if(s5.indexOf(net.rim.tools.compiler.util.FileHelper.p_pathSeparatorC) != -1)
                    {
                        Vector vector7 = net.rim.tools.compiler.util.CompilerProperties.getQuotedVector(s5);
                        for(int l1 = 0; l1 < vector7.size(); l1++)
                            vector6.addElement(vector7.elementAt(l1));

                    } else
                    {
                        vector6.addElement(s5);
                    }
                    __properties.putVector(s3, vector6);
                }
            }

        }
        return _file_;
    }

    private int _forStringI(String s1)
    {
        if(s1.equals("nop"))
            return 8;
        if(s1.equals("arrayinit"))
            return 4;
        if(s1.equals("strarrayinit"))
            return 8192;
        if(s1.equals("deadcode"))
            return 1;
        if(s1.equals("checkcast"))
            return 2;
        if(s1.equals("trivial"))
            return 16;
        if(s1.equals("jump"))
            return 32;
        if(s1.equals("accessor"))
            return 64;
        if(s1.equals("mutator"))
            return 128;
        if(s1.equals("pushpop"))
            return 256;
        if(s1.equals("useless_case"))
            return 512;
        if(s1.equals("inner_accessor"))
            return 2048;
        if(s1.equals("bool_ret"))
            return 4096;
        return !s1.equals("device_only") ? 0 : 15103;
    }

    private void _ifStringvV(String s1, boolean flag)
    {
        if(s1.equals("1"))
        {
            _optimization = flag ? 11007 : 0;
        } else
        {
            int l = _forStringI(s1);
            if(flag)
                _optimization |= l;
            else
                _optimization &= ~l;
        }
    }

    private void _aStringvV(String s1, boolean flag) //optimization param
    {
        Object obj = _configProperties.get(s1);
        if(obj instanceof Vector)
        {
            Vector vector = (Vector)obj;
            for(int l = vector.size() - 1; l >= 0; l--)
            {
                String s3 = (String)vector.elementAt(l);
                _ifStringvV(s3, flag);
            }

        } else
        if(obj instanceof String)
        {
            String s2 = (String)obj;
            _ifStringvV(s2, flag);
        }
    }

    private void _aStringIV(String s1, InputStream inputstream)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_cLVector == null)
            z_cLVector = new Vector();
        if(inputstream != null)
            try
            {
                DataInputStream datainputstream = new DataInputStream(inputstream);
                try
                {
                    Vector vector = z_cLVector;
                    do
                        vector.addElement(datainputstream.readUTF());
                    while(true);
                }
                catch(EOFException eofexception) { }
                finally
                {
                    datainputstream.close();
                }
            }
            catch(IOException ioexception)
            {
                throw new net.rim.tools.compiler.util.CompileException(s1, ioexception.getMessage());
            }
    }

    private void parseProperties()//get configuration from rapc.def
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String _rapcDefFileName_ = "/rapc.def";
        _currentMessage = _rapcDefFileName_;//f_rapcDefFileNameS
        InputStream _input_ = getClass().getResourceAsStream(_rapcDefFileName_);
        if(_input_ != null)
        {
            _configProperties.readDefFile(_rapcDefFileName_, _input_);
            _input_.close();
        }
        _currentMessage = "Properties";
        if(z_dKVector.size() > 0)
        {
            if(_imports.size() > 0)
                net.rim.tools.compiler.g._afV(_configProperties);
            net.rim.tools.compiler.g._afV(_configProperties, z_dKVector);
        }
        f_paramDiagnoseMethodsV = _configProperties.parseVector("diagnosemethods", true);
        f_paramDiagnoseExportsV = _configProperties.parseVector("diagnoseexports", true);
        if(_configProperties.getProperty("wx") != null && _configProperties.getProperty("wxoff") == null)
            z_dkZ = true;
        f_paramNoWXV = _configProperties.parseVector("nowx", false);
        z_dDVector = new Vector();
        parseAliases_notverified();
        _exports = _configProperties.parseVector("exports", true);
        f_paramStaticsV = _configProperties.parseVector("statics", true);
        f_paramFieldsV = _configProperties.parseVector("fields", false);
        f_paramStringsV = _configProperties.parseVector("strings", false);
        net.rim.tools.compiler.types.ClassType loc_net_rim_vm_ungroupable = parseClass("net.rim.vm.UnGroupable");
        loc_net_rim_vm_ungroupable.setAttribute(0x4000800);
        f_paramInterfaceMethodsV = _configProperties.parseVector("interface methods", true);
        create_interfaceOrdinals_nv();
        f_paramWarnKeyV = _configProperties.parseVector("warnkey", true);
        f_paramKnownKeysV = create_knownKeys_nv();
        f_paramRRTTListV = _configProperties.parseVector("rrttlist", true);
        f_paramPersistableV = create_byString_vectorofGclasses_nv("persistable");
        if(f_paramPersistableV.size() > 0)
        {
            net.rim.tools.compiler.types.ClassType _classType_ = (net.rim.tools.compiler.types.ClassType)f_paramPersistableV.elementAt(0);
            _classType_.setAttribute(0x400800);
            int l = f_paramPersistableV.size();
            for(int j1 = 1; j1 < l; j1++)
            {
                net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)f_paramPersistableV.elementAt(j1);
                g3.setAttribute(0x400000);
            }

        }
        z_cXVector = create_byString_vectorofGclasses_nv("classes");
        if(z_cXVector.size() > 0)
        {
            int i1 = z_cXVector.size();
            for(int k1 = 0; k1 < i1; k1++)
            {
                net.rim.tools.compiler.types.ClassType g4 = (net.rim.tools.compiler.types.ClassType)z_cXVector.elementAt(k1);
                g4.setAttribute(0x200000);
            }

        }
        f_javaLangThrowableG = parseClass("java.lang.Throwable");
        _rootObjectClassVTable = _configProperties.parseVector("rootclassvtable", true);
        _javaLangObject = parseClass("java.lang.Object");
        _javaLangObject._aCompilervV(this, false);
        _javaLangString = parseClass("java.lang.String");
        _javaLangStringBuffer = parseClass("java.lang.StringBuffer");
        if(_isMidlet)
            parseClass("javax.microedition.midlet.MIDletMain")._aCompilervV(this, false);
    }

    private Vector create_byString_vectorofGclasses_nv(String s1)
	throws net.rim.tools.compiler.util.CompileException
    {
        Vector vector = _configProperties.parseVector(s1, false);
        for(int l = 0; l < vector.size(); l++)
        {
            String s2 = (String)vector.elementAt(l);
            net.rim.tools.compiler.types.ClassType g1 = parseClass(s2);
            vector.setElementAt(g1, l);
        }

        return vector;
    }

    private void create_interfaceOrdinals_nv()
	throws net.rim.tools.compiler.util.CompileException
    {
        Vector vector = _configProperties.parseVector("interface ordinals", true);
        for(int l = 0; l < vector.size(); l++)
        {
            String s1 = (String)vector.elementAt(l);
            int i1 = s1.indexOf('=');
            if(i1 != -1)
            {
                String s2 = s1.substring(0, i1);
                String s3 = s1.substring(i1 + 1);
                net.rim.tools.compiler.types.ClassType g1 = parseClass(s2);
                try
                {
                    int j1 = Integer.parseInt(s3);
                    g1._bYIV(j1);
                }
                catch(NumberFormatException numberformatexception) { }
            }
        }

    }

    private Vector create_knownKeys_nv()
	throws net.rim.tools.compiler.util.CompileException
    {
        Vector vector = null;
        Vector vector1 = _configProperties.parseVector("known keys", false);
        for(int l = 0; l < vector1.size(); l++)
        {
            String s1 = (String)vector1.elementAt(l);
            int i1 = s1.indexOf('=');
            if(i1 != -1)
            {
                String s2 = s1.substring(0, i1);
                String s3 = s1.substring(i1 + 1);
                try
                {
                    int j1 = Integer.parseInt(s2, 16);
                    if(vector == null)
                        vector = new Vector();
                    vector.addElement(new net.rim.tools.compiler.h(j1, s3));
                }
                catch(NumberFormatException numberformatexception) { }
            }
        }

        return vector;
    }

    public net.rim.tools.compiler.h _newIh(int l)
    {
        if(f_paramKnownKeysV != null)
        {
            int i1 = f_paramKnownKeysV.size();
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.h h1 = (net.rim.tools.compiler.h)f_paramKnownKeysV.elementAt(j1);
                if(h1._ifvI() == l)
                    return h1;
            }

        }
        return null;
    }

    public net.rim.tools.compiler.types.Field _agh(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.Type a2, String s1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_cLVector == null)
            z_cLVector = new Vector();
        Vector vector = z_cLVector;
        String s2 = 'P' + g1.getPackageNameString();
        int l = vector.indexOf(s2);
        if(l == -1)
            return null;
        s2 = 'C' + g1.getName();
        int i1 = vector.size();
        for(l++; l < i1; l++)
        {
            String s3 = (String)vector.elementAt(l);
            char c1 = s3.charAt(0);
            if(c1 == 'P')
                return null;
            if(s3.equals(s2))
                break;
        }

        s2 = 'F' + s1 + ':' + a2._e6vString() + '=';
        for(l++; l < i1; l++)
        {
            String s4 = (String)vector.elementAt(l);
            char c2 = s4.charAt(0);
            if(c2 == 'P' || c2 == 'C')
                return null;
            if(s4.startsWith(s2))
            {
                String s5 = s4.substring(s2.length());
                Constant f1 = null;
                if(a2.getTypeId() == 7)
                    f1 = new Constant(s5);
                else
                    f1 = new Constant(Long.parseLong(s5));
                int j1 = augmentFieldModifiers(g1, 0x20000c2);
                return new net.rim.tools.compiler.types.Field(s1, a2, g1, j1, -1, f1);
            }
        }

        return null;
    }

    public net.rim.tools.compiler.types.ClassType parseClass(String __className)
	throws net.rim.tools.compiler.util.CompileException
    {
        return parseClass(null, __className, null, -1);
    }

    public net.rim.tools.compiler.types.ClassType parseClass(String __packageName, String __className)
	throws net.rim.tools.compiler.util.CompileException
    {
        return parseClass(__packageName, __className, null, -1);
    }

    private net.rim.tools.compiler.types.ClassType parseClass(String __packageName, String __className, String __moduleName, int l)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType _class_ = null;
        int i1 = __className.lastIndexOf('.');
        String _packageName_ = null;
        String _className_ = __className;
        String s6 = null;
        if(__moduleName != null)
        {
            s6 = "module:" + __moduleName + ".class#" + l;
            _class_ = (net.rim.tools.compiler.types.ClassType)f_packagesHashtable_nv.get(s6);
            if(_class_ != null)
            {
                if(i1 != -1)
                {
                    _packageName_ = net.rim.tools.compiler.exec.CharacterHelper.intern(__className.substring(0, i1));
                    _className_ = __className.substring(i1 + 1);
                }
                _class_.set_classAndPackageNames(_packageName_, _className_);
                f_packagesHashtable_nv.put(__className, _class_);
                return _class_;
            }
        }
        _class_ = (net.rim.tools.compiler.types.ClassType)f_packagesHashtable_nv.get(__className);
        if(_class_ != null)
        {
            if(s6 != null)
                f_packagesHashtable_nv.put(s6, _class_);
            return _class_;
        }
        String s7 = null;
        if(i1 == -1 && _packageName != null && _packageName.length() > 0)
        {
            s7 = _packageName + "." + __className;
            _class_ = (net.rim.tools.compiler.types.ClassType)f_packagesHashtable_nv.get(s7);
            if(_class_ != null)
            {
                if(s6 != null)
                    f_packagesHashtable_nv.put(s6, _class_);
                return _class_;
            }
        }
        if(i1 != -1)
        {
            _packageName_ = net.rim.tools.compiler.exec.CharacterHelper.intern(__className.substring(0, i1));
            _className_ = __className.substring(i1 + 1);
        }
        _class_ = new net.rim.tools.compiler.types.ClassType(_className_, _packageName_);
        f_packagesHashtable_nv.put(__className, _class_);
        if(s7 != null)
            f_packagesHashtable_nv.put(s7, _class_);
        if(__packageName == null)
            __packageName = _currentMessage;
        _class_.set_className(__packageName);
        if(s6 != null)
            f_packagesHashtable_nv.put(s6, _class_);
        return _class_;
    }

    public net.rim.tools.compiler.types.Method _agc(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.Method c1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int l = c1.getModifiers() & 0xefdffff;
        int i1 = c1.getNumParameters();
        net.rim.tools.compiler.types.Method c2 = new net.rim.tools.compiler.types.Method(g1, c1.getName(), c1._fMva(), i1, l);
        for(int j1 = 0; j1 < i1; j1++)
        {
            NameAndType k1 = c1.getParameter(j1);
            c2.add_parametersToMethod(j1, k1.getName(), k1.getType());
        }

        c2._fOvV();
        c2.setInstructionCode(new net.rim.tools.compiler.analysis.InstructionCode(c2, 0, c2._fIvI(), null, null));
        return c2;
    }

    private void resolving()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if(z_cIVector.size() == 0 && !_isLibrary && !z_dIZ)
            generateWarning(true, null, "No entry points found");
        boolean flag = false;
        do
        {
            int l = _classes.size();
            int i1 = z_cIVector.size();
            if(z_cyI < l)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)_classes.elementAt(z_cyI++);
                g1._elseCompilerV(this);
            } else
            if(z_dFI < i1)
            {
                net.rim.tools.compiler.types.Method c1 = (net.rim.tools.compiler.types.Method)z_cIVector.elementAt(z_dFI++);
                c1._dCompilerV(this);
            } else
            if(!flag)
            {
                _jadFile._aZZV(_isMidlet, _convertPNGOption, z_b1Vector);
                z_b1Vector = null;
                _jadFile._kZV(_isMidlet);
                z_bKg = _jadFile._gVvg();
                flag = true;
            } else
            {
                return;
            }
        } while(true);
    }

    private net.rim.tools.compiler.types.TypeModule _doStringm(String s1)
    {
        Object obj = null;
        int l = _modules.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.types.TypeModule m1 = (net.rim.tools.compiler.types.TypeModule)_modules.elementAt(i1);
            if(m1.getName().equals(s1))
                return m1;
        }

        return null;
    }

    public net.rim.tools.compiler.types.TypeModule _aStringm(String s1, String s2, int l)
    {
        net.rim.tools.compiler.types.TypeModule m1 = _doStringm(s1);
        if(m1 == null)
        {
            m1 = new net.rim.tools.compiler.types.TypeModule(s1, s2, l, null);
            _modules.addElement(m1);
        }
        return m1;
    }

    private net.rim.tools.compiler.types.TypeModule create_moduleEntry(int param_moduleNumber)
    {
        boolean flag = false;
        flag = z_c0Z;
        String loc_outputFileName = net.rim.tools.compiler.util.FileHelper.create_fileNameString(_codFileName, param_moduleNumber, null);
        net.rim.tools.compiler.types.TypeModule m1 = new net.rim.tools.compiler.types.TypeModule(loc_outputFileName, f_midletVersionS, _timeStamp, new Codfile(flag));
        _modules.addElement(m1);
        if(_isBrittle)
            m1.setBrittle();
        return m1;
    }

    private boolean _amZ(net.rim.tools.compiler.types.TypeModule m1, net.rim.tools.compiler.types.ClassType g1)
    {
        if(m1.getClassNum() > 254)
            return false;
        int l = g1._fmvI();
        int i1 = g1._fevI();
        int j1 = g1._fdvI();
        int k1 = g1._ffvI();
        if(m1.get_dataWeight() + l > f_dataFullI)
            return false;
        if(m1.get_codeWeight() + i1 > f_codeFullI)
            return false;
        if(m1._f8vI() + j1 > _vtableMaxSize)
        {
            if(!z_dnZ)
            {
                z_dnZ = true;
                generateWarning(false, null, "Excessive vtable size detected in output module '" + m1.getName() + "' while processing class: " + g1.getFullName());
            }
            return false;
        }
        if(m1._gnvI() + k1 > _fieldMaxSize)
        {
            if(!z_dLZ)
            {
                z_dLZ = true;
                generateWarning(false, null, "Excessive instance size detected in output module '" + m1.getName() + "' while processing class: " + g1.getFullName());
            }
            return false;
        } else
        {
            return true;
        }
    }

    private net.rim.tools.compiler.types.TypeModule[] getModules()
	throws net.rim.tools.compiler.util.CompileException
    {
        f_packagesHashtable_nv = null;
        Vector _classes_ = _classes;
        int j2 = _classes_.size();
        for(int l = 0; l < j2; l++)
        {
            net.rim.tools.compiler.types.ClassType _class_ = (net.rim.tools.compiler.types.ClassType)_classes_.elementAt(l);
            if(!_class_.hasAttribute(0x20000) && _class_.isProcessed())
            {
                useClassType(_class_);
                _class_._byteCompilerV(this);
            }
        }

        _classes_ = _classes = null;
        _classes_ = z_cIVector;
        j2 = _classes_.size();
        for(int i1 = 0; i1 < j2; i1++)
        {
            net.rim.tools.compiler.types.Method _method_ = (net.rim.tools.compiler.types.Method)_classes_.elementAt(i1);
            _method_._voidCompilerV(this);
        }

        _classes_ = z_cIVector = null;
        Vector loc_modulesListV = new Vector();
        int loc_modulesCounter = 0;
        net.rim.tools.compiler.types.TypeModule loc_module = create_moduleEntry(loc_modulesCounter);
        loc_modulesListV.addElement(loc_module);
        _nullType.setTypeModule(loc_module);
        if(z_bKg != null)
        {
            loc_module._nullgV(z_bKg);
            z_bKg = null;
        }
        _classes_ = f_resultedClassTableV;
        j2 = _classes_.size();
        for(int j1 = 0; j1 < j2; j1++)
        {
            net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)_classes_.elementAt(j1);
            if(g2.hasAttribute(0x400000))
            {
                if(!_amZ(loc_module, g2))
                {
                    loc_module = create_moduleEntry(++loc_modulesCounter);
                    loc_modulesListV.addElement(loc_module);
                }
                loc_module._nullgV(g2);
            }
        }

        for(int k1 = 0; k1 < j2; k1++)
        {
            net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)_classes_.elementAt(k1);
            if(g3.getTypeModule() == null)
                if(_amZ(loc_module, g3))
                {
                    loc_module._nullgV(g3);
                } else
                {
                    net.rim.tools.compiler.types.TypeModule m3 = null;
                    int l2 = loc_modulesListV.size() - 1;
                    for(int j3 = 0; j3 < l2; j3++)
                    {
                        m3 = (net.rim.tools.compiler.types.TypeModule)loc_modulesListV.elementAt(j3);
                        if(_amZ(m3, g3))
                        {
                            m3._nullgV(g3);
                            break;
                        }
                        m3 = null;
                    }

                    if(m3 == null)
                    {
                        loc_module = create_moduleEntry(++loc_modulesCounter);
                        loc_modulesListV.addElement(loc_module);
                        loc_module._nullgV(g3);
                    }
                }
        }

        _classes_ = f_resultedClassTableV = null;
        j2 = loc_modulesListV.size();
        net.rim.tools.compiler.types.TypeModule _modules_[] = new net.rim.tools.compiler.types.TypeModule[j2];
        for(int l1 = 0; l1 < j2; l1++)
        {
            net.rim.tools.compiler.types.TypeModule m2 = (net.rim.tools.compiler.types.TypeModule)loc_modulesListV.elementAt(l1);
            m2.setOrdinalCount(l1, j2);
            _modules_[l1] = m2;
            m2.optimize();
        }

        for(int i2 = 0; i2 < j2; i2++)
        {
            net.rim.tools.compiler.codfile.DataSection k3 = _modules_[i2].getDataSection();
            int i3 = z_dcVector.size();
            if(i2 == 0 && i3 > 0)
            {
                for(int l3 = 0; l3 < i3; l3++)
                    k3._gotoStringV((String)z_dcVector.elementAt(l3));

            }
            for(int i4 = 0; i4 < j2; i4++)
                k3.addSibling(_modules_[i4].getName());

        }

        return _modules_;
    }

    private void populating(net.rim.tools.compiler.types.TypeModule __modules[])
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_bFZ)
            _messageDigest = new net.rim.tools.compiler.exec.j(new net.rim.tools.compiler.types.Modifier(), "MD5");
        else
            _messageDigest = new net.rim.tools.compiler.exec.g();
        boolean flag = false;
        boolean flag1 = false;
        boolean flag2 = false;
        if(z_dIZ)
            flag = true;
        int l = f_paramStringsV.size();
        boolean aflag[] = new boolean[l];
        if(_isLibrary && _jadFile.getNumApplets() == 0)
        {
            int i1 = 0;
            String s1 = _jadFile.getProperty(net.rim.tools.compiler.ResourceIds.z_sString);
            if(s1 != null)
                i1 = Integer.parseInt(s1);
            flag2 = (i1 & 1) != 0;
        }
        int j1 = __modules.length;
        for(int k1 = 0; k1 < j1; k1++)
        {
            int l1 = 0;
            if(_isBrittle)
                l1 = 16;
            if(_jadFile.getProperty(net.rim.tools.compiler.ResourceIds.z_aString) != null)
                l1 |= 0x20;
            if(_isLibrary)
            {
                l1 |= 1;
                if(_configProperties.getProperty("noimport") == null)
                    l1 |= 4;
            } else
            if(_isMidlet)
                l1 = 2;
            net.rim.tools.compiler.types.TypeModule __module_ = __modules[k1];
            net.rim.tools.compiler.codfile.DataSection _dataSection_ = __module_.getDataSection();
            Object obj = null;
            Object obj2 = null;
            if(!_isLibrary)
            {
                if(_exports.size() > 0)
                    obj = _exports.elementAt(0);
                if(obj instanceof net.rim.tools.compiler.util.Exported)
                {
                    net.rim.tools.compiler.util.Exported d1 = (net.rim.tools.compiler.util.Exported)obj;
                    net.rim.tools.compiler.types.Method c1 = d1.getMethod();
                    if(k1 == 0)
                    {
                        net.rim.tools.compiler.codfile.ClassDef u = c1.getClassType().getClassDef(__module_);
                        net.rim.tools.compiler.codfile.TypeList p = c1._intmp(__module_);
                        _dataSection_.setEntryRoutine(u, c1.getName(), p);
                    } else
                    {
                        obj = null;
                    }
                } else
                if(obj != null)
                {
                    String s2 = (String)obj;
                    int j2 = f_paramDiagnoseExportsV.indexOf(s2);
                    if((z_dTZ || j2 != -1) && !flag)
                        generateWarning(false, null, "No definition found for exported static routine: " + s2);
                    flag = true;
                    obj = null;
                }
            }
            if(obj == null)
            {
                _dataSection_.setEntryRoutine(_dataSection_.getNullClassDef(), null, _dataSection_.getTypeLists().getNullTypeList());
                l1 |= 1;
                l1 &= -3;
            }
            obj = null;
            if(_exports.size() > 1)
                obj = _exports.elementAt(1);
            if(obj instanceof net.rim.tools.compiler.util.Exported)
            {
                net.rim.tools.compiler.util.Exported d2 = (net.rim.tools.compiler.util.Exported)obj;
                net.rim.tools.compiler.types.Method c2 = d2.getMethod();
                if(!c2.is(0x20000))
                {
                    if(k1 == 0)
                    {
                        net.rim.tools.compiler.codfile.ClassDef u1 = c2.getClassType().getClassDef(__module_);
                        net.rim.tools.compiler.codfile.TypeList p1 = c2._intmp(__module_);
                        _dataSection_.setAlternateEntryRoutine(u1, c2.getName(), p1);
                    } else
                    {
                        obj = null;
                    }
                } else
                {
                    obj = null;
                }
            } else
            if(obj != null)
            {
                String s3 = (String)obj;
                int l2 = f_paramDiagnoseExportsV.indexOf(s3);
                if((flag2 || l2 != -1) && !flag1)
                    generateWarning(false, null, "No definition found for exported static item: " + s3);
                flag1 = true;
                obj = null;
            }
            if(obj == null)
                _dataSection_.setAlternateEntryRoutine(_dataSection_.getNullClassDef(), null, _dataSection_.getTypeLists().getNullTypeList());
            for(int i2 = 0; i2 < l; i2++)
            {
                net.rim.tools.compiler.codfile.DataBytes a1_1 = _dataSection_.getDataBytes();
                Object obj1 = f_paramStringsV.elementAt(i2);
                if(obj1 != null)
                    if(obj1 instanceof net.rim.tools.compiler.util.Exported)
                    {
                        net.rim.tools.compiler.util.Exported d3 = (net.rim.tools.compiler.util.Exported)obj1;
                        String s4 = d3.getName();
                        s4 = s4.substring(s4.lastIndexOf('.') + 1);
                        if(k1 == 0 || s4.startsWith("_security"))
                        {
                            net.rim.tools.compiler.codfile.Bytes a2 = a1_1.getBytes(d3.getData(), 2, false);
                            _dataSection_.addExport(new net.rim.tools.compiler.codfile.ExportedData(_dataSection_, a2, s4));
                        }
                    } else
                    {
                        String s5 = (String)obj1;
                        if(z_dTZ && !aflag[i2])
                            generateWarning(false, null, "No definition found for exported string: " + s5);
                        aflag[i2] = true;
                    }
            }

            __module_.populate(this, l1);
        }

    }

    private void _aStringV(String s1, net.rim.tools.compiler.types.ClassType g1, String s2, String s3)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(s2.equals("RIM_pragma_signed"))
        {
            int l = 0;
            int k1 = _jadFile._abStringI(s3);
            if(k1 == -1)
                throw new net.rim.tools.compiler.util.CompileException(s1, "Key file not found: " + s3);
            if(k1 != 255)
                l = _jadFile.get_keyFileByIndex(k1)._ifvI();
            g1._gIIV(k1, l);
            return;
        }
        if(s2.equals("RIM_pragma_exclusive"))
        {
            g1._b1IV(0x80000);
            int i1 = g1._fkvI();
            for(int l1 = 0; l1 < i1; l1++)
                g1.getField(l1).clearModifiers(0x80000);

            return;
        }
        if(s2.equals("RIM_pragma_inclusive"))
        {
            g1.setAttribute(0x80000);
            int j1 = g1._fkvI();
            for(int i2 = 0; i2 < j1; i2++)
                g1.getField(i2).addModifiers(0x80000);

            return;
        } else
        {
            return;
        }
    }

    public void _agvV(net.rim.tools.compiler.types.ClassType param_bbTable, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(!param_bbTable._flvZ())
        {
            String s1 = param_bbTable.getFullName();
            String s2 = _configProperties.getProperty("class:" + s1);
            if(s2 == null)
                if(param_bbTable.hasAttribute(128))
                {
                    String s3 = param_bbTable.getPackageNameString();
                    s2 = _configProperties.getProperty("package:" + s3);
                    if(s2 == null && flag)
                        s2 = _configProperties.getProperty("package:.public");
                } else
                {
                    s2 = _configProperties.getProperty("package:.nonpublic");
                }
            if(s2 != null)
            {
                int l = _jadFile._abStringI(s2);
                if(l == -1)
                    throw new net.rim.tools.compiler.util.CompileException(param_bbTable.get_className(), "Key file not found: " + s2);
                int i1 = 0;
                if(l != 255)
                    i1 = _jadFile.get_keyFileByIndex(l)._ifvI();
                param_bbTable._gIIV(l, i1);
            }
        }
    }

    private net.rim.tools.compiler.classfile.ClassFile LoadClassFile(String __jarFilePathString, String __className, InputStream __input, int l, net.rim.tools.compiler.types.TypeModule __module, boolean param_flagModules_nv)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String _className_ = __className;
        if(__jarFilePathString != null)
            _className_ = __jarFilePathString + '(' + __className + ')';
        boolean flag1 = false;
        _currentMessage = _className_;
        byte _data_[] = net.rim.tools.compiler.io.StructuredInputStream.readAll(__input, l, _className_);
        net.rim.tools.compiler.classfile.ClassFile _classFile_ = null;
        try
        {
            _classFile_ = new net.rim.tools.compiler.classfile.ClassFile(_data_, param_flagModules_nv);
            if(!param_flagModules_nv && _classFile_.hasAttribute(net.rim.tools.compiler.classfile.AttributeList.NAME_SOURCEFILE))
            {
                _className_ = _classFile_.getAttribute(net.rim.tools.compiler.classfile.AttributeList.NAME_SOURCEFILE)._cEvString();
                flag1 = true;
            }
            String _classNameString_ = _classFile_.getClassNameString();
            if(_classNameString_ == null)
                throw new net.rim.tools.compiler.util.CompileException(_className_, "No class name found in classfile: " + __className);
            int _attributes_ = net.rim.tools.compiler.types.Modifier.translateClassfileAccessFlags(_classFile_.getAccessFlags());
            _packageName = null;
            if(!param_flagModules_nv) // separate package and class names
            {
                String s5 = net.rim.tools.compiler.util.FileHelper.removeExtension(__className, net.rim.tools.compiler.util.FileHelper.ext_class).replace('/', '.').replace('\\', '.');
                if(!s5.endsWith(_classNameString_))
                {
                    generateWarning(false, _className_, "Class name: " + _classNameString_ + " does not match file name: " + __className);
                    _attributes_ |= 0x8000000;
                    _classNameString_ = s5;
                }
                _packageName = net.rim.tools.compiler.types.ClassType.get_packageNamefromString(_classNameString_);
                if(flag1)
                {
                    String _fullClassName_ = _fileHelper._tryStringString(_packageName, _className_);
                    if(_fullClassName_ != null)
                    {
                        _currentMessage = _className_ = _fullClassName_;
                        if(_packageName != null && z_dDVector.indexOf(_fullClassName_) == -1)
                        {
                            String s6 = net.rim.tools.compiler.util.FileHelper.removeExtension(_fullClassName_, net.rim.tools.compiler.util.FileHelper.ext_java).replace(net.rim.tools.compiler.util.FileHelper.p_separatorC, '.');
                            int j1 = s6.lastIndexOf('.');
                            if(j1 != -1)
                            {
                                s6 = s6.substring(0, j1);
                                if(!s6.endsWith(_packageName))
                                {
                                    generateWarning(false, _fullClassName_, "Package name: " + _packageName + " does not match directory structure");
                                    z_dDVector.addElement(_fullClassName_);
                                }
                            }
                        }
                    }
                }
                if(_verboseLevel >= 1)
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Parsing classfile: " + __className);
            }
            net.rim.tools.compiler.types.ClassType _thisClass_ = parseClass(_classNameString_);
            if(_thisClass_.isProcessed())
                throw new net.rim.tools.compiler.util.DuplicateException(_className_, _classNameString_, _thisClass_.getFullName());
            _thisClass_.set_classFileName(_className_);
            if(param_flagModules_nv)
            {
                _thisClass_.setTypeModule(__module);
                _attributes_ |= 0x20000;
            }
            _thisClass_.set_FlagProcessed();
            _attributes_ = augmentClassModifiers(_attributes_);
            _thisClass_.setAttribute(_attributes_);
            String loc_superClassName = _classFile_.getSuperClassNameString();
            if(loc_superClassName != null)
            {
                net.rim.tools.compiler.types.ClassType loc_superClass = parseClass(loc_superClassName);
                _thisClass_.set_superClassRef(loc_superClass);
            }
            int _elementsNum_ = _classFile_.getNumInterfaces();
            _thisClass_.createInterfaces(_elementsNum_); //create interfaces table
            for(int i2 = 0; i2 < _elementsNum_; i2++)
                _thisClass_.addInterface(i2, parseClass(_classFile_.getInterfaceNameString(i2)));

            _elementsNum_ = _classFile_.getNumFields();
            _thisClass_.createFields(_elementsNum_);
            for(int j2 = 0; j2 < _elementsNum_; j2++)
            {
                net.rim.tools.compiler.classfile.ClassFileField loc_field = _classFile_.getField(j2);
                String loc_fieldName = loc_field.getName();
                int loc_elementBBAtributes = net.rim.tools.compiler.types.Modifier.translateClassfileAccessFlags(loc_field.getAccessFlags());
                if(loc_field.hasAttribute(net.rim.tools.compiler.classfile.AttributeList.NAME_SYNTHETIC))
                    loc_elementBBAtributes |= 0x2000000;
                loc_elementBBAtributes = augmentFieldModifiers(_thisClass_, loc_elementBBAtributes);
                if((loc_elementBBAtributes & 0x2040) == 8256)
                    throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid modifier combination for field: " + loc_fieldName);
                if(_thisClass_.hasAttribute(2048))
                {
                    char c1 = '\u3000';
                    int k6 = 0;
                    if((loc_elementBBAtributes & c1) != k6)
                        throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid modifier combination for interface field: " + loc_fieldName);
                    c1 = '\u03C2';
                    k6 = 194;
                    if((loc_elementBBAtributes & c1) != k6)
                    {
                        generateWarning(false, _className_, "Invalid modifiers for interface field: " + loc_fieldName);
                        loc_elementBBAtributes |= 0x8000000;
                    }
                }
                net.rim.tools.compiler.classfile.TypeDescriptor loc_superField_nv = loc_field.getDescriptor();
                net.rim.tools.compiler.types.Type a3 = net.rim.tools.compiler.types.Type.translateType(this, loc_superField_nv);
                if(loc_superField_nv.get_OffsetToStringEnd() != 0)
                    throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type descriptor '" + loc_superField_nv.getString() + "' for field: " + loc_fieldName);
                Constant f1 = null;
                if(!param_flagModules_nv)
                {
                    net.rim.tools.compiler.classfile.Attribute ae2 = loc_field.getAttribute("ConstantValue");
                    if((loc_elementBBAtributes & 2) != 0 && ae2 != null)
                        if(a3 instanceof BaseType)
                        {
                            int j7 = a3.getTypeId();
                            switch(j7)
                            {
                            case 1: // '\001'
                            case 2: // '\002'
                            case 3: // '\003'
                            case 4: // '\004'
                            case 5: // '\005'
                            case 11: // '\013'
                                f1 = new Constant(ae2.getConstantValue(j7 == 11));
                                break;

                            case 6: // '\006'
                            case 12: // '\f'
                                f1 = new Constant(ae2.getConstantValueLong(j7 == 12));
                                break;

                            case 7: // '\007'
                            case 8: // '\b'
                            case 9: // '\t'
                            case 10: // '\n'
                            default:
									throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type for static constant field: " + loc_fieldName);
                            }
                        } else
                        {
                            if(a3 instanceof ClassType)
                            {
                                ClassType g6 = (ClassType)a3;
                                if(!g6.equals(getStringClass()))
                                    throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type for static constant field: " + loc_fieldName);
                            } else
                            {
                                throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type for static constant field: " + loc_fieldName);
                            }
                            String s13 = ae2.getConstantString();
                            if((loc_elementBBAtributes & 0x200 | 0x40) == 576 && loc_fieldName.startsWith("RIM_pragma"))
                            {
                                _aStringV(_className_, _thisClass_, loc_fieldName, s13);
                                continue;
                            }
                            f1 = new Constant(s13);
                        }
                }
                _thisClass_.add_processedField(this, loc_fieldName, a3, loc_elementBBAtributes, f1);
            }

            _elementsNum_ = _classFile_.getNumMethods();
            _thisClass_.createMethods(_elementsNum_);
            for(int k2 = 0; k2 < _elementsNum_; k2++)
            {
                ClassFileMethod _method_ = _classFile_.getMethod(k2);
                String _methodName_ = _method_.getName();
                int _methodFlags_ = Modifier.translateClassfileAccessFlags(_method_.getAccessFlags());
                if(_method_.hasAttribute("Synthetic"))
                    _methodFlags_ |= 0x2000000;
                if(_methodName_.equals("<init>"))
                {
                    _methodFlags_ |= 0x10;
                    int i6 = 32832;
                    if((_methodFlags_ & i6) != 0)
                        throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid modifier combination for constructor.");
                } else
                if(_methodName_.equals("<clinit>"))
                {
                    if(_method_.getDescriptor().getString().equals("()V"))
                        _methodFlags_ = 0x100002;
                } else
                {
                    if(!net.rim.tools.compiler.util.StringHelper._ifStringZ(_methodName_))
                        throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid method name: " + _methodName_);
                    if((_methodFlags_ & 0x20) != 0)
                    {
                        int j6 = 49152;
                        if((_methodFlags_ & j6) != 0)
                            throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid modifier combination for method: " + _methodName_);
                    }
                }
                _methodFlags_ = augmentMethodModifiers(_thisClass_, _methodFlags_);
                net.rim.tools.compiler.types.Method _method1_ = null;
                synchronized(f_parametersMethodV)
                {
                    f_parametersMethodV.setSize(0);
                    net.rim.tools.compiler.classfile.TypeDescriptor loc_superMethod = _method_.getDescriptor();
                    net.rim.tools.compiler.types.Type.translateTypes(this, loc_superMethod, f_parametersMethodV);
                    net.rim.tools.compiler.types.Type a4 = net.rim.tools.compiler.types.Type.translateType(this, loc_superMethod);
                    if(loc_superMethod.get_OffsetToStringEnd() != 0)
                        throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type descriptor '" + loc_superMethod.getString() + "' for method: " + _methodName_);
                    int loc_paramsNumber = f_parametersMethodV.size();
                    _method1_ = new net.rim.tools.compiler.types.Method(_thisClass_, _methodName_, a4, loc_paramsNumber, _methodFlags_);
                    for(int i3 = 0; i3 < loc_paramsNumber; i3++)
                        _method1_.add_parametersToMethod(i3, null, (net.rim.tools.compiler.types.Type)f_parametersMethodV.elementAt(i3));

                    f_parametersMethodV.setSize(0);
                }
                _method1_._fOvV();
                if(param_flagModules_nv)
                {
                    _method1_._hZV((_methodFlags_ & 2) == 0);
                } else
                {
                    Attribute _exception_ = _method_.getAttribute(AttributeList.NAME_EXCEPTIONS);
                    if(_exception_ != null)
                    {
                        int k4 = _exception_._cGvI();
                        for(int j3 = 0; j3 < k4; j3++)
                        {
                            ClassType g5 = parseClass(_exception_.getConstantString(j3));
                            _method1_._gotogV(g5);
                        }

                    }
                    if(_method_.hasAttribute(AttributeList.NAME_CODE))
                    {
                        boolean flag2 = false;
                        if(_method1_.is(1))
                        {
                            generateWarning(false, _className_, "Native method has code attribute: " + _method1_.getName());
                            _method1_.addModifiers(0x8000000);
                            flag2 = true;
                        }
                        if(_method1_.is(32))
                        {
                            generateWarning(false, _className_, "Abstract method has code attribute: " + _method1_.getName());
                            _method1_.addModifiers(0x8000000);
                            flag2 = true;
                        }
                        AttributeCode k7 = (AttributeCode)_method_.getAttribute(AttributeList.NAME_CODE);
                        int loc_codeLength = 0;
                        byte _code_[] = k7.getCode();
                        if(_code_ != null)
                        {
                            loc_codeLength = _code_.length;
                            if(loc_codeLength >= 0x10000)
                                throw new net.rim.tools.compiler.util.CompileException(_className_, "Code attribute too large: " + _method1_.getName());
                        }
                        int i8 = k7.getMaxStack();
                        if(i8 > 8000)
                        {
                            generateWarning(false, _className_, "operand stack too large (" + i8 + ") in method: " + _method1_.getName());
                            i8 = 8000;
                        }
                        int j8 = k7.getMaxLocals();
                        if(j8 > 8000)
                        {
                            generateWarning(false, _className_, "too many locals (" + j8 + ") in method: " + _method1_.getName());
                            j8 = 8000;
                        }
                        net.rim.tools.compiler.analysis.InstructionCode _instrCode_ = new net.rim.tools.compiler.analysis.InstructionCode(_method1_, i8, j8, _code_, _classFile_.getConstantsPool());
                        _instrCode_._gZV(flag2);
                        int l4 = k7.getNumHandlers();
                        if(l4 > 0)
                        {
                            net.rim.tools.compiler.classfile.ClassFileExceptionHandler _exceptionHandlers_[] = k7.getHandlers();
                            for(int k3 = 0; k3 < l4; k3++)
                            {
                                net.rim.tools.compiler.classfile.ClassFileExceptionHandler n1 = _exceptionHandlers_[k3];
                                int l8 = n1.getStart();
                                int i9 = n1.getEnd();
                                if(i9 <= l8 || i9 > loc_codeLength)
                                    throw new net.rim.tools.compiler.util.CompileException(_className_, "invalid exception handler range in: " + _method1_.getName());
                                int j9 = n1.getHandler();
                                if(j9 >= loc_codeLength)
                                    throw new net.rim.tools.compiler.util.CompileException(_className_, "invalid exception handler offset in: " + _method1_.getName());
                                ClassType g7 = null;
                                String s15 = n1.getTypeName();
                                if(s15 == null)
                                    g7 = null;
                                else
                                    g7 = parseClass(s15);
                                n1.setExceptionClass(g7);
                            }

                            _instrCode_.setExceptionHandlers(_exceptionHandlers_);
                        }
                        if(k7.hasAttribute(AttributeList.NAME_STACKMAP) && isPreverified())
                        {
                            AttributeStackMapTable w1 = (AttributeStackMapTable)k7.getAttribute(AttributeList.NAME_STACKMAP);
                            int i5 = w1.getNumStackMaps();
                            for(int l3 = 0; l3 < i5; l3++)
                            {
                                net.rim.tools.compiler.classfile.AttributeStackMap k8 = w1.getStackMap(l3);
                                if(k8._intvI() > j8)
                                    throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid locals map in method: " + _method1_.getName());
                                if(k8._dovI() > i8)
                                {
                                    generateWarning(false, _className_, "stack map too big: " + _method1_.getName());
                                    _method1_.addModifiers(0x8000000);
                                }
                                net.rim.tools.compiler.types.Type._aCompilerIV(this, _thisClass_, j8, k8, _code_);
                            }

                            _instrCode_._awV(w1);
                        }
                        if(k7.hasAttribute(AttributeList.NAME_LOCALVARIABLETABLE) && _debugOption)
                        {
                            AttributeLocalVariableTable s14 = (AttributeLocalVariableTable)k7.getAttribute(AttributeList.NAME_LOCALVARIABLETABLE);
                            int j5 = s14._cNvI();
                            for(int i4 = 0; i4 < j5; i4++)
                            {
                                af af1 = s14._aRIaf(i4);
                                net.rim.tools.compiler.classfile.TypeDescriptor d3 = af1.getDescriptor();
                                af1._aObjectV(net.rim.tools.compiler.types.Type.translateType(this, af1.getDescriptor()));
                                if(d3.get_OffsetToStringEnd() != 0)
                                    throw new net.rim.tools.compiler.util.CompileException(_className_, "Invalid type descriptor '" + d3.getString() + "' for debug local: " + af1.getName());
                            }

                            _instrCode_._asV(s14);
                        }
                        if(k7.hasAttribute(AttributeList.NAME_LINENUMBERTABLE) && _debugOption)
                        {
                            AttributeLineNumberTable z1 = (AttributeLineNumberTable)k7.getAttribute(AttributeList.NAME_LINENUMBERTABLE);
                            _instrCode_._azV(z1);
                        }
                        _method1_.setInstructionCode(_instrCode_);
                    } else
                    {
                        int l6 = _method1_._fIvI();
                        _method1_.setInstructionCode(new net.rim.tools.compiler.analysis.InstructionCode(_method1_, 0, l6, null, null));
                        if(!_method1_.is(33))
                            generateWarning(false, _className_, "Method has no code attribute: " + _method1_.getName());
                    }
                }
                _thisClass_._aCompilerV(this, _method1_);
            }

            if(!param_flagModules_nv)
            {
                _agvV(_thisClass_, true);
                _thisClass_._aCompilervV(this, false);
                if(_classFile_.hasAttribute(AttributeList.NAME_INNERCLASSES))
                {
                    v v1 = (v)_classFile_.getAttribute(AttributeList.NAME_INNERCLASSES);
                    int l1 = v1._cOvI();
                    for(int l2 = 0; l2 < l1; l2++)
                    {
                        net.rim.tools.compiler.classfile.ac ac1 = v1._aSIac(l2);
                        ClassType g3 = null;
                        ClassType g4 = null;
                        net.rim.tools.compiler.classfile.ConstantPoolClass e1 = ac1._forve();
                        if(e1 != null)
                            g3 = parseClass(e1.getName());
                        e1 = ac1._ifve();
                        if(e1 != null)
                            g4 = parseClass(e1.getName());
                        String s12 = ac1._intvString();
                        int i7 = Modifier.translateClassfileAccessFlags(ac1.getInnerClassFlags());
                        _thisClass_.addInnerClass(new net.rim.tools.compiler.types.InnerClassType(g3, g4, s12, i7));
                    }

                }
            }
            _packageName = null;
        }
        catch(Throwable throwable)
        {
            if(_verboseLevel >= 2)
                throwable.printStackTrace();
            net.rim.tools.compiler.util.CompileException a2;
            if(throwable instanceof net.rim.tools.compiler.util.CompileException)
            {
                a2 = (net.rim.tools.compiler.util.CompileException)throwable;
            } else
            {
                String s7 = throwable.getMessage();
                if(s7 == null)
                    a2 = new net.rim.tools.compiler.util.CompileException(__className, "Invalid class file");
                else
                    a2 = new net.rim.tools.compiler.util.CompileException(__className, "Invalid class file: " + s7);
            }
            throw a2;
        }
        return _classFile_;
    }

    private void _aStringJV(String __jarFileName, JarInputStream __input)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if(_isMidlet)
        {
            Manifest manifest = __input.getManifest();
            if(manifest != null)
            {
                if(_verboseLevel >= 1)
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Parsing manifest");
                _jadFile.parseManifest(this, __jarFileName, manifest);
            }
        }
        for(JarEntry jarentry = null; (jarentry = __input.getNextJarEntry()) != null;)
        {
            if(!jarentry.isDirectory())
            {
                String _entryName_ = jarentry.getName();
                int l = _entryName_.length();
                if(net.rim.tools.compiler.util.FileHelper.checkExtension(_entryName_, net.rim.tools.compiler.util.FileHelper.ext_class) != -1)
                {
                    net.rim.tools.compiler.classfile.ClassFile _classFile_ = LoadClassFile(__jarFileName, _entryName_, __input, (int)jarentry.getSize(), null, false);
                    if(z_cFZ)
                    {
                        File file = new File(_tempDir, _entryName_);
                        file.getParentFile().mkdir();
                        BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file));
                        file = null;
                        _classFile_.write(bufferedoutputstream, z_cFZ, null);
                        _classFile_ = null;
                        bufferedoutputstream = null;
                        _existFilesToProceed = true;
                    }
                } else
                if(l == "META-INF/MANIFEST.MF".length() && _entryName_.regionMatches(true, 0, "META-INF/MANIFEST.MF", 0, l))
                {
                    if(_isMidlet)
                    {
                        if(_verboseLevel >= 1)
                            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Parsing manifest: " + _entryName_);
                        Manifest manifest1 = new Manifest(__input);
                        _jadFile.parseManifest(this, __jarFileName, manifest1);
                        manifest1 = null;
                    }
                } else
                {
                    if(_verboseLevel >= 1)
                        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Reading resource: " + _entryName_);
                    Object obj = null;
                    if(net.rim.tools.compiler.util.FileHelper.checkExtensions(_entryName_, net.rim.tools.compiler.util.FileHelper.ext_images) != -1)
                    {
                        net.rim.tools.compiler.ImageFile _imageFile_ = new net.rim.tools.compiler.ImageFile(_entryName_, __input, (int)jarentry.getSize());
                        if(_convertPNGOption)
                            _imageFile_.convertImage();
                        obj = _imageFile_;
                    } else
                    {
                        obj = new net.rim.tools.compiler.ResourceFile(_entryName_, __input, (int)jarentry.getSize());
                    }
                    if(_resources.indexOf(obj) == -1)
                        _resources.addElement(obj);
                }
            }
            __input.closeEntry();
        }

    }

    private void _ifStringIV(String s1, InputStream inputstream)
	throws net.rim.tools.compiler.util.CompileException
    {
        String s2 = FileHelper.removeExtension(s1, net.rim.tools.compiler.util.FileHelper.ext_csl);
        net.rim.tools.compiler.types.TypeModule m1 = _doStringm(s2);
        if(inputstream != null && m1 != null)
        {
            boolean flag = f_paramRRTTListV.indexOf(s2) == -1;
            try
            {
                net.rim.tools.compiler.util.c c1 = new net.rim.tools.compiler.util.c(inputstream);
                try
                {
                    for(String s3 = null; (s3 = c1._dovString()) != null;)
                    {
                        m1._LStringV(s3);
                        if(flag)
                        {
                            int l = 0;
                            try
                            {
                                l = Integer.parseInt(s3.substring(0, s3.indexOf('=')), 16);
                            }
                            catch(Exception exception) { }
                            if(l == 0x52525400)
                                m1._aCompilerV(this, null, s3);
                        }
                    }

                }
                catch(EOFException eofexception) { }
                finally
                {
                    c1._ifvV();
                }
            }
            catch(IOException ioexception)
            {
                throw new net.rim.tools.compiler.util.CompileException(s1, ioexception.getMessage());
            }
        }
    }

    private void _aStringJFV(String s1, JarFile jarfile, net.rim.tools.compiler.types.TypeModule m1)
        throws CompileException, IOException
    {
        for(Enumeration enumeration = jarfile.entries(); enumeration.hasMoreElements();)
        {
            JarEntry jarentry = (JarEntry)enumeration.nextElement();
            if(!jarentry.isDirectory())
            {
                String s2 = jarentry.getName();
                if(FileHelper.checkExtension(s2, FileHelper.ext_class) != -1)
                {
                    InputStream inputstream = jarfile.getInputStream(jarentry);
                    LoadClassFile(s1, s2, inputstream, (int)jarentry.getSize(), m1, true);
                    inputstream.close();
                    inputstream = null;
                }
            }
        }

    }

    private Vector _akVector(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        Vector vector = new Vector();
        ExportedData _exportedData1_ = __dataSection.getExportedData("_securityVendorIds");
        ExportedData _exportedData2_ = __dataSection.getExportedData("_securityDescriptions");
        if(_exportedData1_ == null || _exportedData2_ == null)
            return vector;
        net.rim.tools.compiler.codfile.Bytes _securityVendorsIds_ = _exportedData1_.getBytes();
        net.rim.tools.compiler.codfile.Bytes _securityDescriptions_ = _exportedData2_.getBytes();
        int l = _securityVendorsIds_.length() / 4;
        int i1 = 0;
        int j1 = 0;
        if(l > 0)
        {
            StringBuffer stringbuffer = new StringBuffer();
            for(int l1 = 0; l1 < l; l1++)
            {
                int i2 = _securityVendorsIds_._hII(i1);
                i1 += 4;
                String s1 = _securityDescriptions_._kIString(j1);
                int j2 = s1.length();
                j1 += 2 + j2;
                if(j2 == 0)
                {
                    net.rim.tools.compiler.h h1 = _newIh(i2);
                    if(h1 != null)
                    {
                        s1 = h1._avString();
                        j2 = s1.length();
                    }
                }
                stringbuffer.setLength(0);
                stringbuffer.ensureCapacity(j2 + 10);
                stringbuffer.append(Integer.toHexString(i2));
                stringbuffer.append("=");
                stringbuffer.append(s1);
                vector.addElement(stringbuffer.toString());
            }

        }
        return vector;
    }

    private void _aStringSV(String s1, String s2, InputStream inputstream, int l)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        _currentMessage = s1 + "(" + s2 + ")";
        try
        {
            byte _data_[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(inputstream, l, _currentMessage);
            net.rim.tools.compiler.codfile.Codfile _codFile_ = new net.rim.tools.compiler.codfile.Codfile(_data_, null);
            int i1 = 5 | (_isBrittle ? 0x10 : 0);
            int j1 = _codFile_.getFlags();
            if((j1 & i1) != i1)
            {
                String s4 = null;
                if(_isBrittle && (j1 & 0x10) == 0)
                    s4 = "Building brittle requires brittle import files";
                else
                if((j1 & 1) == 0)
                    s4 = "Import files must be libraries";
                else
                if((j1 & 4) == 0)
                    s4 = "Import file is marked non-parseable";
                generateWarning(true, _currentMessage, s4);
                return;
            }
            Vector _classDefs_ = _codFile_.getClassDefs(true);
            net.rim.tools.compiler.codfile.DataSection _dataSection_ = _codFile_.getDataSection();
            if(_verboseLevel >= 1)
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Parsing import: " + _currentMessage);
            Vector vector1 = _akVector(_dataSection_);
            net.rim.tools.compiler.codfile.Module _module_ = _dataSection_.getModule(0);
            String s5 = _module_.getName().getString();
            String s6 = _module_.getVersion().getString();
            if((j1 & 0x10) != 0)
                s6 = s6.substring(0, s6.length() - 5);
            int l1 = _codFile_.getTimeStamp();
            _module_ = null;
            String s7 = s5;
            if(!_isBrittle && _dataSection_.get_sibblingsSize() > 1)
                s7 = _dataSection_.getSibling(0).getString();
            net.rim.tools.compiler.types.TypeModule m1 = _aStringm(s7, s6, l1);
            if(_isBrittle)
                m1.setBrittle();
            if((j1 & 0x10) != 0)
            {
                m1._KStringV(_dataSection_.getModule(0).getVersion().getString());
                int i2 = _dataSection_.getModulesNum();
                for(int k2 = 1; k2 < i2; k2++)
                {
                    net.rim.tools.compiler.codfile.Module af2 = _dataSection_.getModule(k2);
                    String s8 = af2.getName().getString();
                    if(!_isBrittle)
                    {
                        int j3 = s8.indexOf('-');
                        if(j3 != -1)
                            s8 = s8.substring(0, j3);
                    }
                    m1._gotoStringV(s8, af2.getVersion().getString());
                }

            }
            m1._tryVectorV(vector1);
            _dataSection_ = null;
            int j2 = _classDefs_.size();
            for(int l2 = 0; l2 < j2; l2++)
            {
                net.rim.tools.compiler.codfile.ClassDefLocal i3 = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDefs_.elementAt(l2);
                String s9 = i3.get_name_2();
                net.rim.tools.compiler.types.ClassType g1 = parseClass(null, s9, s5, l2);
                if(g1.isProcessed())
                    throw new net.rim.tools.compiler.util.DuplicateException(_currentMessage, s9, g1.get_className());
                g1.set_classFileName(_currentMessage);
                g1.setTypeModule(m1);
                g1.set_FlagProcessed();
                int k3 = 0x20000 | Modifier.translateCodfileClassAttributes(i3.getAttributes());
                k3 = augmentClassModifiers(k3);
                g1.setAttribute(k3);
                g1._aaaV(_codFile_, i3);
            }

        }
        catch(Throwable throwable)
        {
            if(_verboseLevel >= 2)
                throwable.printStackTrace();
            net.rim.tools.compiler.util.CompileException a2;
            if(throwable instanceof CompileException)
            {
                a2 = (CompileException)throwable;
            } else
            {
                String s3 = throwable.getMessage();
                if(s3 == null)
                    a2 = new CompileException(s2, "Invalid cod file");
                else
                    a2 = new CompileException(s2, "Invalid cod file: " + s3);
            }
            throw a2;
        }
    }

    private void parsingImports(String s1, JarFile jarfile) //processing imports jars, checking internal cod files
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int l = 0;
        for(Enumeration enumeration = jarfile.entries(); enumeration.hasMoreElements() && z_dOZ;)
        {
            _currentMessage = s1;
            JarEntry jarentry = (JarEntry)enumeration.nextElement();
            String s3 = jarentry.getName();
            if(net.rim.tools.compiler.util.FileHelper.checkExtension(s3, net.rim.tools.compiler.util.FileHelper.ext_cod) != -1)
            {
                l++;
                _aStringSV(s1, s3, jarfile.getInputStream(jarentry), (int)jarentry.getSize()); //checking cod files
            } else
            if(net.rim.tools.compiler.util.FileHelper.checkExtension(s3, net.rim.tools.compiler.util.FileHelper.ext_static) != -1)
                _aStringIV(s3, jarfile.getInputStream(jarentry)); //checking static files
            else
            if(net.rim.tools.compiler.util.FileHelper.checkExtension(s3, net.rim.tools.compiler.util.FileHelper.ext_csl) != -1)
                _ifStringIV(s3, jarfile.getInputStream(jarentry)); //checking csl files
        }

        if(l == 0)
        {
            if(_isBrittle)
                throw new IOException(s1 + ": no .cod files found");
            _currentMessage = s1;
            if(_verboseLevel >= 1)
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Parsing import: " + s1);
            String s2 = FileHelper._zStringString(s1);
            s2 = FileHelper.removeExtension(s2, FileHelper.ext_jar);
            TypeModule m1 = _aStringm(s2, _jadFile.get_middletVersion(jarfile.getManifest()), 0);
            _aStringJFV(s1, jarfile, m1);
        }
    }

    private void _adV(net.rim.tools.compiler.a.cls_d d1, net.rim.tools.compiler.types.TypeModule m1)
        throws IOException
    {
        net.rim.tools.compiler.a.cls_f f1 = new net.rim.tools.compiler.a.cls_f(m1.getName(), _timeStamp, z_dAString != null ? z_dAString : "");
        int k1 = _jadFile.get_keyFilesNumber();
        for(int l = 0; l < k1; l++)
        {
            net.rim.tools.compiler.i l1 = _jadFile.get_keyFileByIndex(l);
            if(l1._forvZ())
                f1._aqV(new net.rim.tools.compiler.a.cls_q(l1._avString(), l1._ifvI()));
        }

        k1 = m1.getClassNum();
        for(int i1 = 0; i1 < k1; i1++)
        {
            net.rim.tools.compiler.types.ClassType g1 = m1.getClass(i1);
            g1._afe(f1, m1);
        }

        for(int j1 = 0; j1 < k1; j1++)
        {
            net.rim.tools.compiler.types.ClassType g2 = m1.getClass(j1);
            g2._aCompilerV(this, f1, m1);
        }

        f1._adV(d1);
    }

    private void _aDataOutputStreammV(DataOutputStream __output, net.rim.tools.compiler.types.TypeModule __typeModules[], Vector vector)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int l = vector.size();
        if(l == 1 && "1".equals((String)vector.elementAt(0)))
            l = 0;
        Vector vector1 = new Vector();
        int i1 = __typeModules.length;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.TypeModule _typeModule_ = __typeModules[j1];
            int k1 = _typeModule_.getClassNum();
            for(int i2 = 0; i2 < k1; i2++)
            {
                net.rim.tools.compiler.types.ClassType g2 = _typeModule_.getClass(i2);
                String s2 = g2.getPackageNameString();
                if(s2 != null && g2._fgvZ())
                {
                    boolean flag = l == 0;
                    for(int j2 = 0; !flag && j2 < l; j2++)
                    {
                        String s3 = (String)vector.elementAt(j2);
                        if(s2.startsWith(s3))
                            flag = true;
                    }

                    if(flag)
                    {
                        int k2 = vector1.size();
                        for(int l2 = 0; g2 != null && l2 < k2; l2++)
                            if(g2._bytegI((net.rim.tools.compiler.types.ClassType)vector1.elementAt(l2)) < 0)
                            {
                                vector1.insertElementAt(g2, l2);
                                g2 = null;
                            }

                        if(g2 != null)
                            vector1.addElement(g2);
                    }
                }
            }

        }

        String s1 = null;
        i1 = vector1.size();
        for(int l1 = 0; l1 < i1; l1++)
        {
            net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)vector1.elementAt(l1);
            s1 = g1._aStringDString(s1, __output);
        }

    }

    private void _aStringV(String s1, Vector vector)
        throws IOException
    {
        int l = vector.size();
        if(l > 0)
        {
            PrintStream printstream = new PrintStream(new BufferedOutputStream(new FileOutputStream(s1)));
            for(int i1 = 0; i1 < l; i1++)
                printstream.println(vector.elementAt(i1).toString());

            printstream.close();
        } else
        {
            (new File(s1)).delete();
        }
    }

    public boolean _forIZ(int l)
	throws net.rim.tools.compiler.util.CompileException
    {
        return f_paramWarnKeyV.indexOf("0x" + Integer.toHexString(l)) != -1;
    }

    private void _aVectorStringV(Vector vector, int l, String s1)
    {
        net.rim.tools.compiler.h h1 = _newIh(l);
        if(h1 != null)
            s1 = h1._avString();
        String s2 = Integer.toHexString(l) + '=' + s1;
        if(vector.indexOf(s2) == -1)
            vector.addElement(s2);
    }

    private void _ifvV()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        Vector vector = new Vector();
        Vector vector1 = new Vector();
        Object obj = null;
        if(z_c3Z)
        {
            if(_forIZ(0x33000000))
                generateWarning(true, null, "Invocation of native methods requires signing with key: RIMAPPSA2");
            _aVectorStringV(vector1, 0x33000000, "RIMAPPSA2");
        }
        int j1 = _jadFile.get_keyFilesNumber();
        for(int l = 0; l < j1; l++)
        {
            net.rim.tools.compiler.i k1 = _jadFile.get_keyFileByIndex(l);
            String s1 = k1._tryvString();
            if(vector1.indexOf(s1) == -1)
                vector1.addElement(s1);
        }

        j1 = _modules.size();
        for(int i1 = 0; i1 < j1; i1++)
        {
            net.rim.tools.compiler.types.TypeModule m1 = (net.rim.tools.compiler.types.TypeModule)_modules.elementAt(i1);
            if(m1._gkvZ())
            {
                Vector vector2 = m1._gdvVector();
                if(vector2 != null)
                {
                    int l1 = vector2.size();
                    for(int j2 = 0; j2 < l1; j2++)
                    {
                        String s2 = (String)vector2.elementAt(j2);
                        if(vector1.indexOf(s2) == -1)
                            vector1.addElement(s2);
                    }

                }
                vector2 = m1._gbvVector();
                if(vector2 != null)
                {
                    int i2 = vector2.size();
                    for(int k2 = 0; k2 < i2; k2++)
                    {
                        String s3 = (String)vector2.elementAt(k2);
                        if(vector.indexOf(s3) == -1)
                            vector.addElement(s3);
                    }

                }
            }
        }

        _aVectorStringV(vector, 0x52525400, "RIM Runtime API");
        _aVectorStringV(vector, 0x52424200, "RIM Blackberry Apps API");
        _aStringV(_codeName + net.rim.tools.compiler.util.FileHelper.ext_csl, vector1);
        _aStringV(_codeName + net.rim.tools.compiler.util.FileHelper.ext_cso, vector);
    }

    private void writing(net.rim.tools.compiler.types.TypeModule __modules[])
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int _numModules_ = __modules.length;
        _modulesCounts = new int[_numModules_];
        StringBuffer _stringbuffer_ = new StringBuffer();
        for(int l = 0; l < _numModules_; l++)
        {
            net.rim.tools.compiler.types.TypeModule _module_ = __modules[l];
            _modulesCounts[l] = _module_.getCodfile().count(_module_.getName(), _stringbuffer_);
        }

        if(_stringbuffer_.length() > 0)
            if(_configProperties.getQuotedProperty("nolimit") != null)
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(_stringbuffer_.toString());
            else
                throw new IOException(_stringbuffer_.toString());
        ByteArrayOutputStream _codByteStream_ = (ByteArrayOutputStream)_configProperties.get("codbytes");
        if(_numModules_ > 1 && _codByteStream_ != null)
            throw new net.rim.tools.compiler.util.CompileException("Compilation produced sibling .cod file");
        String _listingFileName_ = _configProperties.getQuotedProperty("listing");
        if(_listingFileName_ != null)
            _listingFileName_ = FileHelper.removeExtension(_listingFileName_, FileHelper.ext_lst);
        PrintStream _printStreams_[] = new PrintStream[_numModules_];
        _strings_ = new String[_numModules_];
        f_modulesDependenciesS = null;
        Vector vector = new Vector();
        for(int i1 = 0; i1 < _numModules_; i1++)
        {
            net.rim.tools.compiler.codfile.DataSection _dataSection_ = __modules[i1].getCodfile().getDataSection();
            int _modulesNumber_ = _dataSection_.getModulesNum();
            for(int _index_ = 1; _index_ < _modulesNumber_; _index_++)
            {
                net.rim.tools.compiler.codfile.Module _module_ = _dataSection_.getModule(_index_);
                if(_module_ instanceof ModuleDomestic)
                {
                    String _moduleName_ = _module_.getName().getString();
                    if(vector.indexOf(_moduleName_) == -1)
                        vector.addElement(_moduleName_);
                }
            }

        }

        StringBuffer _moduleDependencies_ = new StringBuffer();
        int j3 = vector.size();
        for(int j1 = 0; j1 < j3; j1++)
        {
            if(_moduleDependencies_.length() > 0)
                _moduleDependencies_.append(",");
            _moduleDependencies_.append((String)vector.elementAt(j1));
        }

        vector = null;
        f_modulesDependenciesS = _moduleDependencies_.toString();
        _moduleDependencies_ = null;
        OutputStream _outputs_[] = new OutputStream[_numModules_];
        try
        {
            _signatures = new net.rim.tools.compiler.exec.j[_numModules_];
            for(int _index_ = 0; _index_ < _numModules_; _index_++)
            {
                PrintStream printstream = null;
                String _tmpFileName_ = net.rim.tools.compiler.util.FileHelper.create_fileNameString(_codeName, _index_, net.rim.tools.compiler.util.FileHelper.ext_tmp);
                _strings_[_index_] = _tmpFileName_;
                if(_listingFileName_ != null)
                {
                    String _lstFileName_ = FileHelper.create_fileNameString(_listingFileName_, _index_, net.rim.tools.compiler.util.FileHelper.ext_lst);
                    printstream = new PrintStream(new BufferedOutputStream(new FileOutputStream(_lstFileName_)));
                    _printStreams_[_index_] = printstream;
                }
                if(_codByteStream_ != null)
                    _outputs_[_index_] = _codByteStream_;
                else
                    _outputs_[_index_] = new BufferedOutputStream(new FileOutputStream(_tmpFileName_));
                _signatures[_index_] = new net.rim.tools.compiler.exec.j(null, "SHA1");
                __modules[_index_].getCodfile().write(_outputs_[_index_], _signatures[_index_], printstream);
                _outputs_[_index_].close();
                _outputs_[_index_] = null;
            }

        }
        finally
        {
            for(int l1 = 0; l1 < _numModules_; l1++)
            {
                OutputStream _output_ = _outputs_[l1];
                if(_output_ != null)
                    _output_.close();
            }

            _outputs_ = null;
        }
        if(_debugOption)
        {
            for(int i2 = 0; i2 < _numModules_; i2++)
            {
                String _debugFileName_ = net.rim.tools.compiler.util.FileHelper.create_fileNameString(_codeName, i2, net.rim.tools.compiler.util.FileHelper.ext_debug);
                BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(_debugFileName_));
                net.rim.tools.compiler.a.cls_d d1;
                if(_configProperties.get("debuglisting") != null)
                    d1 = new net.rim.tools.compiler.a.cls_d(new DataOutputStream(bufferedoutputstream), _printStreams_[i2]);
                else
                    d1 = new net.rim.tools.compiler.a.cls_d(new DataOutputStream(bufferedoutputstream), null);
                _adV(d1, __modules[i2]);
                d1._avV();
                if(_printStreams_ != null && _printStreams_[i2] != null)
                    _printStreams_[i2].close();
                if(_configProperties.get("debugtest") != null)
                {
                    net.rim.tools.compiler.a.cls_f f1 = new net.rim.tools.compiler.a.cls_f(new DataInputStream(new FileInputStream(_debugFileName_)));
                    net.rim.tools.compiler.a.cls_d d2 = new net.rim.tools.compiler.a.cls_d(new DataOutputStream(new FileOutputStream(_debugFileName_ + "2")), null);
                    f1._adV(d2);
                    d2._avV();
                }
            }

        } else
        if(_printStreams_ != null)
        {
            for(int j2 = 0; j2 < _numModules_; j2++)
                if(_printStreams_[j2] != null)
                    _printStreams_[j2].close();

        }
        if(_emitStaticOption)
        {
            _staticFileName_ = _codeName + net.rim.tools.compiler.util.FileHelper.ext_static;
            DataOutputStream _staticFileStream_ = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(_staticFileName_))));
            _aDataOutputStreammV(_staticFileStream_, __modules, _configProperties.getVector("emitstatic"));
            _staticFileStream_.close();
        }
        if(z_bFZ)
        {
            byte abyte0[] = null;
            String s6 = _codeName + net.rim.tools.compiler.util.FileHelper.ext_export;
            File file = new File(s6);
            if(file.exists())
                try
                {
                    FileInputStream fileinputstream = new FileInputStream(file);
                    abyte0 = _messageDigest._aInputStreamaB(fileinputstream);
                    fileinputstream.close();
                }
                catch(IOException ioexception)
                {
                    abyte0 = null;
                }
            if(abyte0 == null || !net.rim.tools.compiler.exec.j.Compare(abyte0, _messageDigest.getSignature()))
            {
                File file1 = new File(s6 + ".old");
                if(file1.exists())
                    file1.delete();
                if(file.exists())
                    file.renameTo(file1);
                PrintStream printstream1 = new PrintStream(new BufferedOutputStream(new FileOutputStream(file)));
                _messageDigest._aPrintStreamV(printstream1);
                printstream1.close();
            }
        }
        if(_codByteStream_ == null)
        {
            for(int k2 = 0; k2 < _numModules_; k2++)
            {
                String s4 = net.rim.tools.compiler.util.FileHelper.create_fileNameString(_codeName, k2, net.rim.tools.compiler.util.FileHelper.ext_cod);
                _strings_[k2] = net.rim.tools.compiler.util.FileHelper.convert_tempFileTocodFile(_strings_[k2], s4);
            }

        }
        if(z_bQZ)
            _ifvV();
    }

    private void _intvV()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String s1 = _configProperties.getQuotedProperty("rapc");
        if(s1 != null)
            _jadFile._ifCompilerV(this, s1);
        String s2 = _configProperties.getQuotedProperty("jad");
        if(s2 != null)
            _jadFile._ifCompilerV(this, s2);
        byte abyte0[] = (byte[])_configProperties.get("jadContent");
        if(abyte0 != null)
            _jadFile._aaStringV(net.rim.tools.compiler.exec.CharacterHelper.utf8ToString(abyte0));
        String s3 = (String)_configProperties.get("jadString");
        if(s3 != null)
            _jadFile._aaStringV(s3);
        f_midletVersionS = _jadFile.getProperty("MIDlet-Version");
    }

    private void compileClassFile()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        net.rim.tools.compiler.util.ExecutionTimer _execTimerParse_ = new net.rim.tools.compiler.util.ExecutionTimer("parse", _stats);
        parseProperties();
        if(_classFiles != null)
        {
            int _classFilesNum_ = _classFiles.size();
            for(int l = 0; l < _classFilesNum_; l++)
            {
                File _classFile_ = (File)_classFiles.elementAt(l);
                FileInputStream _input_ = new FileInputStream(_classFile_);
                net.rim.tools.compiler.classfile.ClassFile q1 = LoadClassFile(null, _classFile_.getPath(), _input_, (int)_classFile_.length(), null, false);
                _input_ = null;
                if(z_cFZ)
                {
                    BufferedOutputStream _bufferedOutput_ = new BufferedOutputStream(new FileOutputStream(_classFile_.getPath()));
                    q1.write(_bufferedOutput_, z_cFZ, null);
                    _bufferedOutput_ = null;
                    _existFilesToProceed = true;
                }
                _classFile_ = null;
                q1 = null;
            }

            _classFiles = null;
        }
        boolean flag = false;
        if(_jarFiles != null)
        {
            int i2 = _jarFiles.size();
            for(int i1 = 0; i1 < i2; i1++)
            {
                String _jarFileName_ = null;
                BufferedInputStream bufferedinputstream = null;
                File _jarFile_ = (File)_jarFiles.elementAt(i1);
                _jarFileName_ = _jarFile_.getPath();
                if(!_jarFile_.exists())
                    throw new IOException("Jar file not found: " + _jarFileName_);
                bufferedinputstream = new BufferedInputStream(new FileInputStream(_jarFile_));
                JarInputStream jarinputstream = new JarInputStream(bufferedinputstream, false);
                bufferedinputstream = null;
                _aStringJV(_jarFileName_, jarinputstream);
                jarinputstream.close();
                jarinputstream = null;
                if(!flag)
                {
                    flag = true;
                    _intvV();
                }
            }

            _jarFiles = null;
        }
        if(!flag)
            _intvV();
        if(_imports != null) //processing imports
        {
            int j2 = _imports.size();
            for(int j1 = 0; j1 < j2; j1++)
            {
                String s2 = (String)_imports.elementAt(j1);
                File file1 = new File(s2);
                if(!file1.exists())
                    throw new IOException("Import file not found: " + s2);
                file1 = null;
                try
                {
                    JarFile jarfile = new JarFile(s2, false);
                    parsingImports(s2, jarfile);
                    jarfile.close();
                    jarfile = null;
                }
                catch(IOException ioexception)
                {
                    throw new IOException(ioexception.getMessage() + ": " + s2);
                }
            }

            _imports = null;
            j2 = _modules.size();
            for(int k1 = 0; k1 < j2; k1++)
            {
                net.rim.tools.compiler.types.TypeModule m1 = (net.rim.tools.compiler.types.TypeModule)_modules.elementAt(k1);
                int k2 = m1._gmvI();
                for(int l2 = 0; l2 < k2; l2++)
                {
                    String as[] = m1._ceIaString(l2);
                    net.rim.tools.compiler.types.TypeModule m2 = _doStringm(as[0]);
                    if(m2 == null)
                        throw new net.rim.tools.compiler.util.CompileException("brittle import: " + m1.getName() + " requires missing brittle import: " + as[0]);
                    if(!as[1].equals(m2._gjvString()))
                        throw new net.rim.tools.compiler.util.CompileException("brittle import: " + m1.getName() + " found mismatched brittle import: " + as[0]);
                }

            }

        }
        _fileHelper = null;
        z_dDVector = null;
        _execTimerParse_.stop();
        net.rim.tools.compiler.util.ExecutionTimer _execAnalysisTimer_ = new net.rim.tools.compiler.util.ExecutionTimer("analysis", _stats);
        if(_verboseLevel >= 1)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Resolving");
        resolving();
        if(_verboseLevel >= 1)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Optimizing");
        net.rim.tools.compiler.types.TypeModule _modules_[] = getModules();
        if(_verboseLevel >= 1)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Populating");
        populating(_modules_);
        _execAnalysisTimer_.stop();
        net.rim.tools.compiler.util.ExecutionTimer _timer_ = new net.rim.tools.compiler.util.ExecutionTimer("write", _stats);
        writing(_modules_);
        _timer_.stop();
        if(z_dEZ)
            throw new net.rim.tools.compiler.util.CompileException("warnings treated as errors");
        else
            return;
    }

    private boolean _aFileVectorZ(File file, int l, Vector vector, String s1)
        throws IOException
    {
        int i1 = s1.indexOf("|");
        int j1 = s1.indexOf("&");
        if(i1 != -1)
        {
            if(j1 != -1)
                throw new IOException(file.getPath() + ": " + l + " '#implicit' and '#if' do not support mixing '|' with '&'");
            for(net.rim.tools.compiler.util.Tokenizer h1 = new net.rim.tools.compiler.util.Tokenizer(s1, "|"); h1.hasMoreTokens();)
            {
                String s2 = h1.nextToken().trim();
                if(vector.indexOf(s2) != -1)
                    return true;
            }

            return false;
        }
        if(j1 != -1)
        {
            for(net.rim.tools.compiler.util.Tokenizer h2 = new net.rim.tools.compiler.util.Tokenizer(s1, "&"); h2.hasMoreTokens();)
            {
                String s3 = h2.nextToken().trim();
                if(vector.indexOf(s3) == -1)
                    return false;
            }

            return true;
        } else
        {
            return vector.indexOf(s1.trim()) != -1;
        }
    }

    private int _aVectorFI(Vector vector, File file, File file1)
        throws IOException
    {
        int l = 1;
        net.rim.tools.compiler.util.c c1 = new net.rim.tools.compiler.util.c(new BufferedInputStream(new FileInputStream(file)));
        String s1 = c1._dovString();
        if(s1 != null)
        {
            String s2 = s1.trim();
            if(s2.startsWith("//#preprocess"))
            {
                int i1 = 1;
                String s4 = "";
                byte byte0 = 0;
                boolean flag = false;
                boolean flag1 = true;
                PrintStream printstream = new PrintStream(new BufferedOutputStream(new FileOutputStream(file1)));
                while(s1 != null)
                {
                    String s3 = s1.trim();
                    if(s3.startsWith("//#"))
                    {
                        s1 = s4;
                        if(s3.startsWith("//#if"))
                        {
                            if(byte0 != 0)
                                throw new IOException(file.getPath() + ": " + i1 + " '#if' not allowed inside '#if'");
                            String s5 = s3.substring(5);
                            byte byte1 = 0;
                            boolean flag2 = false;
                            if(s5.startsWith("def "))
                                byte1 = 4;
                            else
                            if(s5.startsWith("ndef "))
                            {
                                byte1 = 5;
                                flag2 = true;
                            }
                            if(byte1 != 0)
                            {
                                byte0 = 1;
                                String s7 = s5.substring(byte1);
                                if(_aFileVectorZ(file, i1, vector, s7))
                                    flag = flag2;
                                else
                                    flag = !flag2;
                            }
                        } else
                        if(s3.startsWith("//#else"))
                        {
                            if(byte0 != 1)
                                throw new IOException(file.getPath() + ": " + i1 + " '#else' without '#ifdef'");
                            byte0 = 2;
                            flag = !flag;
                        } else
                        if(s3.startsWith("//#endif"))
                        {
                            if(byte0 == 0)
                                throw new IOException(file.getPath() + ": " + i1 + " '#endif' without '#ifdef'");
                            byte0 = 0;
                            flag = false;
                        } else
                        if(s3.startsWith("//#implicit "))
                        {
                            if(byte0 != 0)
                                throw new IOException(file.getPath() + ": " + i1 + " '#implicit' not allowed inside '#if'");
                            String s6 = s3.substring(12);
                            if(!_aFileVectorZ(file, i1, vector, s6))
                            {
                                printstream.close();
                                c1._ifvV();
                                return 0;
                            }
                        }
                    } else
                    if(flag)
                    {
                        s1 = s4;
                        l = 2;
                    } else
                    {
                        flag1 = false;
                    }
                    printstream.println(s1);
                    s1 = c1._dovString();
                    i1++;
                }
                printstream.close();
                if(byte0 != 0)
                    throw new IOException(file.getPath() + ": " + i1 + " '#endif' missing");
                if(flag1)
                    l = 0;
            }
        }
        c1._ifvV();
        return l;
    }

    private void _aFileVFileV(File file, Vector vector, File file1, Vector vector1, boolean flag)
        throws IOException
    {
        String s1 = file1.getCanonicalFile().getPath();
        if(vector1.size() > 0)
        {
            File file2 = new File(file, s1.replace(':', '!'));
            File file3 = file2.getParentFile();
            file3.mkdirs();
            switch(_aVectorFI(vector1, file1, file2))
            {
            case 0: // '\0'
                s1 = null;
                file2.delete();
                break;

            case 1: // '\001'
                file2.delete();
                break;

            case 2: // '\002'
                s1 = file2.getPath();
                break;
            }
        }
        if(s1 != null)
        {
            if(flag)
                s1 = FileHelper._xStringString(s1);
            vector.addElement(s1);
        }
    }

    private boolean _aZVectorZ(boolean flag, Vector vector, String __name)
    {
        if(!flag && (__name.endsWith("net_rim_cldc.jar") || __name.endsWith("net_rim_platform.jar") || __name.endsWith("net_rim_api.jar") || z_c0Z && __name.endsWith("net_rim_api36.jar")))
        {
            flag = true;
            if(f_javaCompiler)
            {
                vector.addElement("-bootclasspath");
                vector.addElement(__name);
            } else
            if(f_gcjCompiler)
            {
                vector.addElement("--bootclasspath");
                vector.addElement(__name);
            }
        }
        return flag;
    }

    private void _aStringBufferV(StringBuffer stringbuffer, String s1, boolean flag)
    {
        if(stringbuffer.length() > 0)
        {
            String s2 = net.rim.tools.compiler.util.FileHelper.p_pathSeparatorS;
            if(flag)
                s2 = ":";
            stringbuffer.append(s2);
        }
        stringbuffer.append(s1);
    }

    private void addClassFiles(File __file)
        throws IOException
    {
        String _fileNames_[] = __file.list();
        if(_fileNames_ != null)
        {
            for(int l = 0; l < _fileNames_.length; l++)
            {
                File _file_ = new File(__file.getPath(), _fileNames_[l]);
                if(_file_.isDirectory())
                    addClassFiles(_file_);
                else
                if(FileHelper.checkExtension(_file_.getPath(), FileHelper.ext_class) != -1)
                    _classFiles.addElement(_file_);
            }

        }
    }

    private void compileJavaFiles()
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        Vector vector = new Vector();
        if(f_javaCompiler && _configProperties.getProperty("notarget11") == null)
        {
            vector.addElement("-source");
            vector.addElement("1.3");
            vector.addElement("-target");
            vector.addElement("1.1");
        }
        if(_configProperties.getProperty("deprecation") != null)
            vector.addElement("-deprecation");
        if(_configProperties.getProperty("nowarn") != null)
            vector.addElement("-nowarn");
        if(_verboseLevel < 2 && f_wjavaCompiler)
            vector.addElement("-zq");
        if(_debugOption)
            vector.addElement("-g");
        else
        if(f_javaCompiler)
            vector.addElement("-g:none");
        else
        if(f_wjavaCompiler)
            vector.addElement("-g-");
        if(_optimization != 0)
            if(f_javaCompiler || f_gcjCompiler)
                vector.addElement("-O");
            else
            if(f_wjavaCompiler)
                vector.addElement("-o");
        vector.addElement("-d");
        vector.addElement(_tempDir.getPath());
        boolean flag = false;
        StringBuffer stringbuffer = new StringBuffer(256);
        int j2 = _imports.size();
        for(int l = 0; l < j2; l++)
        {
            String s1 = (String)_imports.elementAt(l);
            File file2 = new File(s1);
            if(!file2.exists())
                throw new IOException("Import file not found: " + s1);
            flag = _aZVectorZ(flag, vector, s1);
            _aStringBufferV(stringbuffer, s1, f_gcjCompiler);
        }

        j2 = _jarFiles.size();
        for(int i1 = 0; i1 < _jarFiles.size(); i1++)
        {
            File file = (File)_jarFiles.elementAt(i1);
            String s2 = file.getPath();
            if(!file.exists())
                throw new IOException("Jar file not found: " + s2);
            flag = _aZVectorZ(flag, vector, s2);
            _aStringBufferV(stringbuffer, s2, f_gcjCompiler);
        }

        j2 = _classPath.size();
        if(j2 > 0)
        {
            StringBuffer stringbuffer1 = new StringBuffer(256);
            for(int j1 = 0; j1 < j2; j1++)
                _aStringBufferV(stringbuffer1, (String)_classPath.elementAt(j1), f_gcjCompiler);

            if(f_javaCompiler)
            {
                vector.addElement("-sourcepath");
                vector.addElement(stringbuffer1.toString());
            } else
            {
                _aStringBufferV(stringbuffer, stringbuffer1.toString(), f_gcjCompiler);
            }
        }
        if(!flag)
        {
            int k2 = z_dKVector.size();
            for(int k1 = 0; k1 < k2 && !flag; k1++)
                if(((String)z_dKVector.elementAt(k1)).endsWith("base.def"))
                {
                    flag = true;
                    if(f_javaCompiler)
                    {
                        vector.addElement("-bootclasspath");
                        vector.addElement(".");
                    } else
                    if(f_gcjCompiler)
                    {
                        vector.addElement("--bootclasspath");
                        vector.addElement(".");
                    } else
                    {
                        _aStringBufferV(stringbuffer, ".", false);
                    }
                }

            if(!flag)
                throw new net.rim.tools.compiler.util.CompileException("Error: rapc invocation does not build or import the runtime system (missing net_rim_api)");
        }
        if(f_jikesCompiler)
            vector.addElement("+OLDCSO");
        if(f_gcjCompiler)
        {
            vector.addElement("--encoding=ISO-8859-1");
            vector.addElement("-C");
            _aStringBufferV(stringbuffer, ".", f_gcjCompiler);
        }
        if(stringbuffer.length() > 0)
            if(f_wjavaCompiler)
                vector.addElement("-cp=" + stringbuffer.toString());
            else
            if(f_gcjCompiler)
            {
                vector.addElement("--classpath");
                vector.addElement(stringbuffer.toString());
            } else
            {
                vector.addElement("-classpath");
                vector.addElement(stringbuffer.toString());
            }
        File file1 = net.rim.tools.compiler.util.FileHelper.createTempDir(_tmpDirectory);
        try
        {
            Vector vector1 = _configProperties.getVector("define");
            int l2 = vector1.size();
            for(int l1 = 0; l1 < l2; l1++)
            {
                String s3 = (String)vector1.elementAt(l1);
                if(s3.indexOf("|") != -1 || s3.indexOf("&") != -1)
                    throw new net.rim.tools.compiler.util.CompileException("-define option may not use '|' or '&' characters");
            }

            l2 = _javaFiles.size();
            for(int i2 = 0; i2 < l2; i2++)
            {
                File file3 = (File)_javaFiles.elementAt(i2);
                if(file3.exists())
                {
                    _fileHelper._wStringV(file3.getCanonicalPath());
                    _aFileVFileV(file1, vector, file3, vector1, f_gcjCompiler);
                } else
                {
                    vector.addElement(file3.getPath());
                }
            }

            _javaFiles = null;
            if(net.rim.tools.compiler.exec.cls_e.invokingJavacJar(_verboseLevel >= 2, _noLoadToolOption, f_javaCompilerNameS, vector) != 0)
            {
                StringBuffer stringbuffer2 = new StringBuffer(256);
                stringbuffer2.append("Error: java compiler failed: ");
                stringbuffer2.append(f_javaCompilerNameS);
                net.rim.tools.compiler.exec.cls_e._aZStringBufferV(_verboseLevel >= 2, stringbuffer2, vector);
                throw new net.rim.tools.compiler.util.CompileException(stringbuffer2.toString());
            }
        }
        finally
        {
            if(_verboseLevel < 2)
                z_dhI += net.rim.tools.compiler.util.FileHelper.delete_tempFilesAll(file1);
        }
        addClassFiles(_tempDir);
    }

    private void preverify()
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        String _tempDirString_ = _tempDir.getPath();
        Vector vector = new Vector();
        if(_verboseLevel >= 2)
            vector.addElement("-verbose");
        vector.addElement("-d");
        vector.addElement(_tempDirString_);
        StringBuffer stringbuffer = new StringBuffer(256);
        int k1 = _imports.size();
        for(int l = 0; l < k1; l++)
        {
            String s2 = (String)_imports.elementAt(l);
            _aStringBufferV(stringbuffer, s2, false);
        }

        k1 = _jarFiles.size();
        for(int i1 = 0; i1 < k1; i1++)
        {
            File file = (File)_jarFiles.elementAt(i1);
            _aStringBufferV(stringbuffer, file.getPath(), false);
        }

        k1 = _classPath.size();
        for(int j1 = 0; j1 < k1; j1++)
            _aStringBufferV(stringbuffer, (String)_classPath.elementAt(j1), false);

        _aStringBufferV(stringbuffer, _tempDirString_, false);
        vector.addElement("-classpath");
        vector.addElement(stringbuffer.toString());
        vector.addElement(_tempDirString_);
        String s3 = "preverify";
        if(_exePath != null)
        {
            File file1 = new File(_exePath, s3);
            if(file1.exists())
            {
                s3 = file1.getAbsolutePath();
            } else
            {
                File file2 = new File(_exePath, s3 + ".exe");
                if(file2.exists())
                    s3 = file2.getAbsolutePath();
            }
        }
        if(net.rim.tools.compiler.exec.cls_e.invokingJavacJar(_verboseLevel >= 2, false, s3, vector) != 0)
        {
            StringBuffer stringbuffer1 = new StringBuffer(256);
            stringbuffer1.append("Error: preverifier failed: ");
            stringbuffer1.append(s3);
            net.rim.tools.compiler.exec.cls_e._aZStringBufferV(_verboseLevel >= 2, stringbuffer1, vector);
            throw new net.rim.tools.compiler.util.CompileException(stringbuffer1.toString());
        } else
        {
            return;
        }
    }

    private int createSnapshot(File __snapshotFile, boolean __noLoadToolOption)
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        StringBuffer _stringBuffer_ = new StringBuffer(256);
        boolean flag1 = false;
        if(__snapshotFile.exists())
        {
            _stringBuffer_.append("-uf");
        } else
        {
            _stringBuffer_.append("-cf");
            if(_snapshotOption || _jadFile.getManifest() == null)
            {
                _stringBuffer_.append("M");
            } else
            {
                _stringBuffer_.append("m");
                flag1 = true;
                if(_tempDir != null && _resources != null)
                {
                    int l = _resources.size();
                    for(int i1 = 0; i1 < l; i1++)
                    {
                        net.rim.tools.compiler.ResourceFile d1 = (net.rim.tools.compiler.ResourceFile)_resources.elementAt(i1);
                        d1.write(_tempDir);
                    }

                }
            }
        }
        if(_verboseLevel >= 2)
            _stringBuffer_.append("v");
        Vector vector = new Vector();
        vector.addElement(_stringBuffer_.toString());
        vector.addElement(__snapshotFile.getPath());
        File file1 = null;
        if(!_snapshotOption)
        {
            if(flag1)
            {
                net.rim.tools.compiler.ResourceFile d2 = _jadFile.getManifest();
                file1 = net.rim.tools.compiler.util.FileHelper.createTempDir(_tmpDirectory);
                d2.write(file1);
                vector.addElement(d2.getAbsolutePath());
            }
            if(!_isMidlet)
            {
                int j1 = _strings_.length;
                for(int k1 = 0; k1 < j1; k1++)
                {
                    String s2 = _strings_[k1];
                    String s5 = net.rim.tools.compiler.util.FileHelper._sStringString(s2);
                    s2 = net.rim.tools.compiler.util.FileHelper._zStringString(s2);
                    if(s5 != null)
                    {
                        vector.addElement("-C");
                        vector.addElement(s5);
                    }
                    vector.addElement(s2);
                }

                if(_emitStaticOption)
                {
                    String s3 = net.rim.tools.compiler.util.FileHelper._sStringString(_staticFileName_);
                    String s6 = net.rim.tools.compiler.util.FileHelper._zStringString(_staticFileName_);
                    if(s3 != null)
                    {
                        vector.addElement("-C");
                        vector.addElement(s3);
                    }
                    vector.addElement(s6);
                }
            }
            File file2 = new File(_codeName + net.rim.tools.compiler.util.FileHelper.ext_csl);
            if(file2.exists())
            {
                String s1 = file2.getParent();
                if(s1 != null)
                {
                    vector.addElement("-C");
                    vector.addElement(s1);
                }
                vector.addElement(file2.getName());
            }
            File file3 = new File(_codeName + net.rim.tools.compiler.util.FileHelper.ext_cso);
            if(file3.exists())
            {
                String s4 = file3.getParent();
                if(s4 != null)
                {
                    vector.addElement("-C");
                    vector.addElement(s4);
                }
                vector.addElement(file3.getName());
            }
        }
        if(_tempDir != null)
        {
            vector.addElement("-C");
            vector.addElement(_tempDir.getPath());
            vector.addElement(".");
        }
        if(net.rim.tools.compiler.exec.cls_e.invokingJavacJar(_verboseLevel >= 2, __noLoadToolOption, "jar", vector) != 0)
        {
            StringBuffer stringbuffer1 = new StringBuffer(256);
            stringbuffer1.append("jar command failed: jar");
            net.rim.tools.compiler.exec.cls_e._aZStringBufferV(_verboseLevel >= 2, stringbuffer1, vector);
            throw new IOException(stringbuffer1.toString());
        }
        if(file1 != null && _verboseLevel < 2)
            z_dhI += net.rim.tools.compiler.util.FileHelper.delete_tempFilesAll(file1);
        return (int)__snapshotFile.length();
    }

    private void createJadFile()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String _jadFileName_ = _configProperties.getQuotedProperty("jad");
        if(_jadFileName_ == null)
        {
            _jadFileName_ = _codeName + net.rim.tools.compiler.util.FileHelper.ext_jad;
            _jadFile.parseJadFile(_jadFileName_);
        }
        _jadFile.setProperty(net.rim.tools.compiler.ResourceIds.p_jadKeysArray[3], _codFileName); // "RIM-COD-Module-Name"
        _jadFile.setProperty(net.rim.tools.compiler.ResourceIds.p_jadKeysArray[2], Integer.toString(_timeStamp)); //"RIM-COD-Creation-Time"
        if(f_modulesDependenciesS != null && f_modulesDependenciesS.length() > 0)
            _jadFile.setProperty(net.rim.tools.compiler.ResourceIds.p_jadKeysArray[4], f_modulesDependenciesS); //"RIM-COD-Module-Dependencies"
        else
            _jadFile.remove(net.rim.tools.compiler.ResourceIds.p_jadKeysArray[4]);//"RIM-COD-Module-Dependencies"
        int l = _modulesCounts.length;
        for(int _index_ = 0; _index_ < l; _index_++)
        {
            String _RIM_COD_PARAM_ = net.rim.tools.compiler.ResourceIds.p_jadKeysArray[0]; //"RIM-COD-URL"
            String _codFileName_ = _codFileName + net.rim.tools.compiler.util.FileHelper.ext_cod;
            if(_index_ > 0)
            {
                _RIM_COD_PARAM_ = _RIM_COD_PARAM_ + '-' + _index_;
                _codFileName_ = _codFileName + '-' + _index_ + net.rim.tools.compiler.util.FileHelper.ext_cod;
            }
            _jadFile.setProperty(_RIM_COD_PARAM_, _codFileName_);
            _RIM_COD_PARAM_ = net.rim.tools.compiler.ResourceIds.p_jadKeysArray[1]; //"RIM-COD-Size"
            if(_index_ > 0)
                _RIM_COD_PARAM_ = _RIM_COD_PARAM_ + '-' + _index_;
            _jadFile.setProperty(_RIM_COD_PARAM_, Integer.toString(_modulesCounts[_index_]));
            _RIM_COD_PARAM_ = net.rim.tools.compiler.ResourceIds.p_jadKeysArray[5]; //"RIM-COD-SHA1"
            if(_index_ > 0)
                _RIM_COD_PARAM_ = _RIM_COD_PARAM_ + '-' + _index_;
            _jadFile.setProperty(_RIM_COD_PARAM_, _signatures[_index_].toString());
        }

        _modulesCounts = null;
        _signatures = null;
        _jadFile.createJadFile(_isMidlet, _jadFileName_);
    }

    private void createJarFile(File file)
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        Vector vector = new Vector();
        if(_verboseLevel >= 2)
            vector.addElement("-cvf0M");
        else
            vector.addElement("-cf0M");
        vector.addElement(file.getPath());
        int j1 = _strings_.length;
        for(int l = 0; l < j1; l++)
        {
            String _fileName_ = _strings_[l];
            String s2 = FileHelper._sStringString(_fileName_);
            _fileName_ = net.rim.tools.compiler.util.FileHelper._zStringString(_fileName_);
            if(s2 != null)
            {
                vector.addElement("-C");
                vector.addElement(s2);
            }
            vector.addElement(_fileName_);
        }

        if(net.rim.tools.compiler.exec.cls_e.invokingJavacJar(_verboseLevel >= 2, _noLoadToolOption, "jar", vector) != 0)
        {
            StringBuffer stringbuffer = new StringBuffer(256);
            stringbuffer.append("jar command failed: jar");
            net.rim.tools.compiler.exec.cls_e._aZStringBufferV(_verboseLevel >= 2, stringbuffer, vector);
            throw new IOException(stringbuffer.toString());
        }
        for(int i1 = 0; i1 < j1; i1++)
            (new File(_strings_[i1])).delete();

        _strings_[0] = file.getPath();
    }

    private void compileResources()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if(_rrFiles != null && _rrFiles.size() > 0)
        {
            if(_isMidlet)
                generateWarning(false, null, "Internationalized resources are not supported by MIDP");
            Vector _resources_ = new Vector();
            Object obj = null;
            Hashtable hashtable = (Hashtable)_configProperties.clone();
            net.rim.tools.compiler.exec.cls_e.invokingResourceCompiler(_verboseLevel >= 2, _verboseLevel == 0, _rrFiles, _javaFiles, _resources_, _codFileName, hashtable);
            _jadFile.addResourcesFiles(_resources_);
        }
    }

    public static Compiler run(Object __object, net.rim.tools.compiler.util.CompilerProperties __compilerProperties)
	throws  net.rim.tools.compiler.util.CompileException, IOException
    {
        Compiler _compiler_ = null;
        Vector _stats_ = new Vector();
        net.rim.tools.compiler.util.ExecutionTimer _execTimer_ = new net.rim.tools.compiler.util.ExecutionTimer("total", _stats_);
        File _jarFile_ = null;
        boolean _hasJarFileinList_ = false;
        boolean _isFinished_ = false;
        int j1 = 0;
        try
        {
            _compiler_ = new Compiler(__object, __compilerProperties);
            _compiler_._stats = _stats_;
            _jarFile_ = (new File(_compiler_._codeName + net.rim.tools.compiler.util.FileHelper.ext_jar)).getAbsoluteFile();
            if(_jarFile_.exists())
            {
                _jarFile_ = net.rim.tools.compiler.util.FileHelper._intFileFile(_jarFile_);
                if(_compiler_._jarFiles.indexOf(_jarFile_) != -1)
                    _hasJarFileinList_ = true;
                else
                    _jarFile_.delete();
            }
            if(_compiler_._convertPNGOption)
            {
                Vector _resources_ = _compiler_._resources;
                int i1 = _resources_.size();
                for(int l = 0; l < i1; l++)
                {
                    net.rim.tools.compiler.ResourceFile _resourceFile_ = (net.rim.tools.compiler.ResourceFile)_resources_.elementAt(l);
                    if(_resourceFile_ instanceof net.rim.tools.compiler.ImageFile)
                    {
                        net.rim.tools.compiler.ImageFile _imageFile_ = (net.rim.tools.compiler.ImageFile)_resourceFile_;
                        _imageFile_.convertImage();
                    }
                }

            }
            net.rim.tools.compiler.JadSupport _jadFile_ = new net.rim.tools.compiler.JadSupport(__compilerProperties); //binaries and key files
            _compiler_.setJadFile(_jadFile_);
            int _totalFilesNum_ = (_compiler_._javaFiles != null ? _compiler_._javaFiles.size() : 0) + (_compiler_._rrFiles != null ? _compiler_._rrFiles.size() : 0) + (_compiler_._jarFiles != null ? _compiler_._jarFiles.size() : 0);
            _compiler_._existFilesToProceed = _totalFilesNum_ > 0;
            _compiler_.compileResources(); //processing resource files ?
            _compiler_._tempDir = net.rim.tools.compiler.util.FileHelper.createTempDir(_compiler_._tmpDirectory); //create temporary file and directory
			
            try
            {
                if(_compiler_._javaFiles != null && _compiler_._javaFiles.size() > 0)//porcessing Java files
                {
                    net.rim.tools.compiler.util.ExecutionTimer _execTimerJava_ = new net.rim.tools.compiler.util.ExecutionTimer(_compiler_.f_javaCompilerNameS, _stats_);
                    _compiler_.compileJavaFiles(); // processing java files
                    if(_compiler_._snapshotOption)
                    {
                        File _snapshotFile_ = (new File(_compiler_._codeName + "-snapshot" + net.rim.tools.compiler.util.FileHelper.ext_jar)).getAbsoluteFile();
                        if(_snapshotFile_.exists())
                            _snapshotFile_.delete();
                        _compiler_.createSnapshot(_snapshotFile_, _compiler_._noLoadToolOption);
                        _compiler_._snapshotOption = false;
                    }
                    if(_compiler_._preverified)
                        _compiler_.preverify();
                    _execTimerJava_.stop();
                }
				
                int l1 = _compiler_._classFiles != null ? _compiler_._classFiles.size() : 0;
                _jadFile_.parse_keyFiles();
                String _resourceClassName_ = _jadFile_.generateResourceClass(_compiler_, _compiler_._codFileName);//RIM resources string
                if(_resourceClassName_ != null)
                    __compilerProperties.setProperty("properties", _resourceClassName_);
                _compiler_.compileClassFile(); //processing class file ?
				
                if(_compiler_._existFilesToProceed && !_hasJarFileinList_)
                {
                    net.rim.tools.compiler.util.ExecutionTimer execTimerJar = new net.rim.tools.compiler.util.ExecutionTimer("jar", _stats_);
                    int i2 = _compiler_.createSnapshot(_jarFile_, _compiler_._noLoadToolOption && l1 < 100);
                    _jadFile_.setProperty(net.rim.tools.compiler.ResourceIds.z_AaString[1], Integer.toString(i2));
                    execTimerJar.stop();
                }
				
                if((!_hasJarFileinList_ || !_compiler_._isMidlet) && __compilerProperties.get("jadContent") == null)
                    _compiler_.createJadFile(); //processing jar file ?
			
                
				if(_compiler_._strings_.length > 1)
                {
                    _compiler_.createJarFile(new File(_compiler_._codeName + net.rim.tools.compiler.util.FileHelper.ext_tmp));
                    String _codFileName_ = _compiler_._codeName + net.rim.tools.compiler.util.FileHelper.ext_cod;
                    _compiler_._strings_[0] = net.rim.tools.compiler.util.FileHelper.convert_tempFileTocodFile(_compiler_._strings_[0], _codFileName_);
                }
            }
            finally
            {
                if(_compiler_._tempDir != null && _verboseLevel < 2)
                    j1 = net.rim.tools.compiler.util.FileHelper.delete_tempFilesAll(_compiler_._tempDir) + _compiler_.z_dhI;
            }
            if(_compiler_.z_dKVector.size() > 0)
            {
                String s1 = (String)_compiler_.z_dKVector.lastElement();
                net.rim.tools.compiler.g._aCompilerV(_compiler_, __compilerProperties);
            }
            _isFinished_ = true;
        }
        finally
        {
            if(!_isFinished_)
                net.rim.tools.compiler.util.FileHelper.deleteFiles(_compiler_._strings_, !_hasJarFileinList_ && _jarFile_ != null ? _jarFile_.getPath() : null);
        }
        _execTimer_.stop();
        if(_verboseLevel > 0)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("No errors.");
        if(__compilerProperties.getProperty("timing") != null)
        {
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print("TmpSize: " + j1);
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print(" Timing:");
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(_stats_);
        }
        return _compiler_;
    }

    public static int _compileaStringI(String __args[])
    {
        String loc_errorLogFileNameS = null;
        try
        {
            __args = net.rim.tools.compiler.util.FileHelper.prepareARGS(__args);
            net.rim.tools.compiler.util.CompilerProperties _compilerProperties_ = new net.rim.tools.compiler.util.CompilerProperties();
            _compilerProperties_.put("rapc_javaFiles", new Vector());
            _compilerProperties_.put("rapc_classFiles", new Vector());
            _compilerProperties_.put("rapc_jarFiles", new Vector());
            _compilerProperties_.put("rapc_keyFiles", new Vector());
            _compilerProperties_.put("rapc_resourceBinaries", new Vector());
            _compilerProperties_.put("rapc_rrFiles", new Vector());
            File _file_ = parsingArgsFilesF(__args, _compilerProperties_);
            String _fileName_ = "";
            if(_compilerProperties_.getProperty("version") != null)
            {
                String loc_rapcBuildS = null;
                InputStream inputstream = _compilerProperties_.getClass().getResourceAsStream("/app.version");
                if(inputstream != null)
                {
                    int j1 = inputstream.available();
                    if(j1 > 2)
                    {
                        byte abyte0[] = new byte[j1 - 2];
                        inputstream.read(abyte0, 0, abyte0.length);
                        loc_rapcBuildS = new String(abyte0, "UTF-8");
                    }
                    inputstream.close();
                }
                if(loc_rapcBuildS == null)
                {
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("RAPC Version: 2.1");
                } else
                {
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print("RAPC Version: 2.1 Build: ");
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(loc_rapcBuildS);
                }
                return 0;
            }
            if(_file_ == null)
            {
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Error: no files to process");
                return -1;
            }
            _fileName_ = _file_.getName();
            if(net.rim.tools.compiler.util.FileHelper.checkExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_jar) != -1)
                _fileName_ = net.rim.tools.compiler.util.FileHelper.removeExtension(_fileName_, FileHelper.ext_jar);
            else
            if(FileHelper.checkExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_java) != -1)
                _fileName_ = net.rim.tools.compiler.util.FileHelper.removeExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_java);
            else
            if(FileHelper.checkExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_class) != -1)
                _fileName_ = net.rim.tools.compiler.util.FileHelper.removeExtension(_fileName_, FileHelper.ext_class);
            else
            if(FileHelper.checkExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_rapc) != -1)
                _fileName_ = net.rim.tools.compiler.util.FileHelper.removeExtension(_fileName_, net.rim.tools.compiler.util.FileHelper.ext_rapc);
            else
                _fileName_ = net.rim.tools.compiler.util.FileHelper.removeExtension(_fileName_, FileHelper.ext_jad);
            String loc_codenameS = _compilerProperties_.getQuotedProperty("codename");
            if(loc_codenameS == null)
            {
                loc_codenameS = _compilerProperties_.getQuotedProperty("library");
                if(loc_codenameS == null)
                    loc_codenameS = _fileName_;
                _compilerProperties_.setProperty("codename", loc_codenameS);
            }
            loc_errorLogFileNameS = loc_codenameS + ".err";
            int index = 0;
            do //check if working files from previous compilation exist
            {
                File loc_codFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_cod));
                File loc_debugFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_debug));
                File loc_lstFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_lst));
                File loc_tmpFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_tmp));
                File loc_csoFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_cso));
                File loc_cslFileF = new File(net.rim.tools.compiler.util.FileHelper.create_fileNameString(loc_codenameS, index, net.rim.tools.compiler.util.FileHelper.ext_csl));
                if(!loc_codFileF.exists() && !loc_debugFileF.exists() && !loc_lstFileF.exists() && !loc_tmpFileF.exists() && !loc_csoFileF.exists() && !loc_cslFileF.exists())
                    break;
                loc_codFileF.delete();
                loc_debugFileF.delete();
                loc_lstFileF.delete();
                loc_tmpFileF.delete();
                loc_csoFileF.delete();
                loc_cslFileF.delete();
                index++;
            } while(true);
            run(null, _compilerProperties_); // The next step for processing
            (new File(loc_errorLogFileNameS)).delete();
        }
        catch(IOException ioexception)
        {
            if(_verboseLevel >= 2)
                ioexception.printStackTrace();
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("I/O Error: " + ioexception.getMessage());
            return -1;
        }
        catch(net.rim.tools.compiler.util.CompileException loc_exceptionHandler)
        {
            if(_verboseLevel >= 2)
                loc_exceptionHandler.printStackTrace();
            String loc_exceptionString = loc_exceptionHandler.toString();
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(loc_exceptionString);
            try
            {
                if(loc_errorLogFileNameS != null)
                {
                    FileOutputStream loc_errorLogFile = new FileOutputStream(loc_errorLogFileNameS);
                    PrintStream loc_errorPrint = new PrintStream(new BufferedOutputStream(loc_errorLogFile));
                    loc_errorPrint.print(loc_exceptionString);
                    loc_errorPrint.close();
                }
            }
            catch(IOException ioexception1)
            {
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Fatal Internal I/O Error: " + ioexception1.toString());
            }
            int loc_errorCode = loc_exceptionHandler.getResultCode();
            if(loc_errorCode == 0)
                loc_errorCode = 97;
            return loc_errorCode;
        }
        catch(Throwable throwable)
        {
            if(_verboseLevel >= 2)
                throwable.printStackTrace();
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Fatal Internal error: " + throwable.toString());
            return -1;
        }
        return 0;
    }

    public static void main(String args[]) throws IOException
    {

		
		// String str[] = net.rim.tools.compiler.pkg_b.cls_a.z_aaString;
		// int i = str.length;
				
		//for (int k=0; k<i;k++)
		//	net.rim.tools.compiler.pkg_i.d.z_aPrintStream.println("#"+k+ "    " +str[k]);
		//net.rim.tools.a.cls_a._aaStringV(args);
		//net.rim.tools.a.cls_b.coddec(args);
		net.rim.tools.a.coddec.main(args);
		
        //net.rim.tools.compiler.io.Diagnose.DiagnoseStream = System.out;
        //System.exit(_compileaStringI(args));
    }

}
