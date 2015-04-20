// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.util.Exported;
import net.rim.tools.compiler.util.CompilerProperties;
import net.rim.tools.compiler.util.FileHelper;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.NameAndType;
import net.rim.tools.compiler.types.ArrayType;

// Referenced classes of package net.rim.tools.compiler:
//            Compiler

public class g
    implements net.rim.tools.compiler.vm.Constants
{

    private static final String z_udString = "/* auto-generated file, do not edit */";
    private static final int z_umI = 0;
    private static final String z_ujString = "natives";
    private static final int z_ulI = 1;
    private static final String z_uhString = "exports";
    private static final int z_uiI = 2;
    private static final String z_uoString = "statics";
    private static final int z_ugI = 3;
    private static final String z_t3String = "classes";
    private static final int z_t7I = 4;
    private static final String z_t6String = "interface methods";
    private static final int z_ucI = 5;
    private static final String z_ukString = "fields";
    private static final int z_t9I = 6;
    private static final String z_ubString = "strings";
    private static final int z_ueI = 7;
    private static int z_ufaI[] = new int[7];
    private static final String z_t4aString[] = {
        "natives", "exports", "statics", "classes", "interface methods", "fields", "strings"
    };
    private static String z_unString;
    private static final int z_uaI = 0;
    private static final int z_t8I = 1;
    private static final int z_t5I = 2;

    public g()
    {
    }

    public static void _afV(net.rim.tools.compiler.util.CompilerProperties __compilerProperties)
	throws net.rim.tools.compiler.util.CompileException
    {
        for(int i = 1; i < 7; i++)
            z_ufaI[i] = __compilerProperties.getVector(z_t4aString[i]).size();

        z_unString = null;
    }

    public static void _afV(net.rim.tools.compiler.util.CompilerProperties f1, Vector vector)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(vector != null)
        {
            String s = null;
            int i = vector.size();
            for(int i1 = 0; i1 < i; i1++)
                try
                {
                    s = (String)vector.elementAt(i1);
                    BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
                    f1.readDefFile(s, bufferedinputstream);
                    bufferedinputstream.close();
                }
                catch(IOException ioexception)
                {
                    throw new net.rim.tools.compiler.util.CompileException(s, ioexception.toString());
                }

            if(s != null)
            {
                int j1 = 1 + net.rim.tools.compiler.util.StringHelper._aStringI(s, net.rim.tools.compiler.util.FileHelper.p_separatorS);
                int k1 = s.lastIndexOf('.');
                if(k1 == -1)
                    k1 = s.length();
                z_unString = s.substring(j1, k1);
            }
        }
    }

    private static void _aByteArrayOutputStreamSStringV(ByteArrayOutputStream bytearrayoutputstream, String s, String s1, String s2)
        throws IOException
    {
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        File file = new File(s);
        file.mkdirs();
        File file1 = new File(file, s1 + s2);
        boolean flag = true;
        if(file1.exists())
        {
            int i = abyte0.length;
            if(i == (int)file1.length())
            {
                byte abyte1[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(new FileInputStream(file1), i, file1.getPath());
                int i1;
                for(i1 = 0; i1 < i && abyte0[i1] == abyte1[i1]; i1++);
                if(i1 == i)
                    flag = false;
            }
        }
        if(flag)
        {
            FileOutputStream fileoutputstream = new FileOutputStream(file1);
            fileoutputstream.write(abyte0);
            fileoutputstream.close();
        }
    }

    private static StringBuffer _doStringBufferStringBuffer(StringBuffer stringbuffer, String s)
    {
        s = net.rim.tools.compiler.util.StringHelper._aStringSString(s, "()", "");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, "(", "__");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, ")", "");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, ".", "__");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, "$", "__");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, "[]", "_array");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, ",", "__");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, "<init>", "CONSTRUCTOR");
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, "<constructor>", "CONSTRUCTOR");
        return stringbuffer.append(s);
    }

    private static StringBuffer _aStringBufferStringStringBuffer(StringBuffer stringbuffer, int i, String s)
    {
        String s1 = null;
        switch(i)
        {
        case 0: // '\0'
            s1 = "NATIVE";
            break;

        case 1: // '\001'
            s1 = "STATICMETHOD";
            break;

        case 2: // '\002'
            s1 = "STATICDATA";
            break;

        case 3: // '\003'
            s1 = "CLASS";
            break;

        case 4: // '\004'
            s1 = "INTERFACEMETHOD";
            break;

        case 5: // '\005'
            s1 = "FIELD";
            break;

        case 6: // '\006'
            s1 = "STRING";
            break;
        }
        return _doStringBufferStringBuffer(stringbuffer.append(s1).append('_'), s);
    }

    private static StringBuffer _aStringBuffervStringBuffer(StringBuffer stringbuffer, int i)
    {
        stringbuffer.append("\\x");
        if(i < 16)
            stringbuffer.append("0");
        return stringbuffer.append(Integer.toHexString((char)(i & 0xff)));
    }

    private static StringBuffer _aStringBufferStringBuffer(StringBuffer stringbuffer, net.rim.tools.compiler.types.Type a1)
    {
        int i = a1.getTypeId();
        _aStringBuffervStringBuffer(stringbuffer, i);
        if(i == 8)
        {
            ArrayType l1 = (ArrayType)a1;
            _aStringBuffervStringBuffer(stringbuffer, l1.getNesting());
            a1 = l1.getMostBaseType();
            i = a1.getTypeId();
            _aStringBuffervStringBuffer(stringbuffer, i);
        }
        if(i == 7)
            _aStringBufferStringBuffer(stringbuffer, (net.rim.tools.compiler.types.ClassType)a1);
        return stringbuffer;
    }

    private static StringBuffer _aStringBufferStringBuffer(StringBuffer stringbuffer, net.rim.tools.compiler.types.NameAndType k1)
    {
        _ifStringBufferStringBuffer(stringbuffer, k1.getName()).append("\\0");
        return _aStringBufferStringBuffer(stringbuffer, k1.getType()).append("\\0");
    }

    private static StringBuffer _aStringBufferStringBuffer(StringBuffer stringbuffer, net.rim.tools.compiler.types.Method c1)
    {
        _ifStringBufferStringBuffer(stringbuffer, c1.getName()).append("\\0");
        if(c1._fKvZ())
            _aStringBufferStringBuffer(stringbuffer, ((net.rim.tools.compiler.types.Type) (c1.getClassType())));
        int i = c1.getNumParameters();
        for(int i1 = 0; i1 < i; i1++)
            _aStringBufferStringBuffer(stringbuffer, c1.getParameterType(i1));

        return stringbuffer.append("\\0");
    }

    private static StringBuffer _aStringBufferStringBuffer(StringBuffer stringbuffer, net.rim.tools.compiler.types.ClassType g1)
    {
        String s = g1.getPackageNameString();
        if(s != null)
            _ifStringBufferStringBuffer(stringbuffer, s);
        return _ifStringBufferStringBuffer(stringbuffer.append("\\0"), g1.getName()).append("\\0");
    }

    private static void _aStringBufferSaV(StringBuffer stringbuffer, String s, Object aobj[], int i)
    {
        String s1 = (String)aobj[i];
        if(s.equals(s1))
        {
            s = "";
        } else
        {
            if(i == 0)
            {
                for(int i1 = 0; i1 < 2; i1++)
                    aobj[i1] = null;

            }
            aobj[i] = s;
        }
        _ifStringBufferStringBuffer(stringbuffer, s);
    }

    private static StringBuffer _aStringBufferStringBuffer(StringBuffer stringbuffer, net.rim.tools.compiler.types.ClassType g1, Object aobj[])
    {
        _aStringBufferSaV(stringbuffer, g1.getPackageNameString(), aobj, 0);
        stringbuffer.append("\\0");
        _aStringBufferSaV(stringbuffer, g1.getName(), aobj, 1);
        stringbuffer.append("\\0");
        return stringbuffer;
    }

    private static StringBuffer _ifStringBufferStringBuffer(StringBuffer stringbuffer, String s)
    {
        String s1 = net.rim.tools.compiler.vm.IdEncode.encode(s);
        int i = s1.length();
        for(int i1 = 0; i1 < i; i1++)
        {
            char c1 = (char)(s1.charAt(i1) & 0xff);
            stringbuffer.append("\\");
            stringbuffer.append(Integer.toHexString((c1 & 0xc0) >> 6));
            stringbuffer.append(Integer.toHexString((c1 & 0x38) >> 3));
            stringbuffer.append(Integer.toHexString(c1 & 7));
        }

        return stringbuffer;
    }

    private static StringBuffer _aStringBufferCStringBuffer(StringBuffer stringbuffer, Compiler compiler, int i, int i1, Object aobj[])
	throws net.rim.tools.compiler.util.CompileException
    {
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        switch(i)
        {
        default:
            break;

        case 0: // '\0'
				net.rim.tools.compiler.types.Method c1 = compiler.getNativeMethod(i1);
            if(c1 != null)
            {
                net.rim.tools.compiler.types.ClassType g1 = c1.getClassType();
                stringbuffer.append('"');
                _aStringBufferStringBuffer(stringbuffer, g1, aobj);
                _aStringBufferStringBuffer(stringbuffer, c1).append("\" // ").append(i1);
            }
            break;

        case 1: // '\001'
				net.rim.tools.compiler.util.Exported d1 = compiler._elseId(i1);
            if(d1 != null)
            {
                net.rim.tools.compiler.types.Method c2 = d1.getMethod();
                net.rim.tools.compiler.types.ClassType g2 = c2.getClassType();
                stringbuffer.append('"');
                _aStringBufferStringBuffer(stringbuffer, g2);
                _aStringBufferStringBuffer(stringbuffer, c2).append("\" // ").append(i1);
            }
            break;

        case 2: // '\002'
				net.rim.tools.compiler.util.Exported d2 = compiler._byteId(i1);
            if(d2 != null)
            {
                net.rim.tools.compiler.types.ClassType g3 = d2.getClassType();
                net.rim.tools.compiler.types.Field h = g3.getField(d2.getClassTypeIndex());
                stringbuffer.append('"');
                _aStringBufferStringBuffer(stringbuffer, g3);
                _aStringBufferStringBuffer(stringbuffer, h).append("\" // ").append(i1);
            }
            break;

        case 3: // '\003'
            net.rim.tools.compiler.types.ClassType g4 = compiler._ifIg(i1);
            stringbuffer.append('"');
            _aStringBufferStringBuffer(stringbuffer, g4).append("\" // ").append(i1);
            break;

        case 4: // '\004'
				net.rim.tools.compiler.util.Exported d3 = compiler._caseId(i1);
            if(d3 != null)
            {
                net.rim.tools.compiler.types.Method c3 = d3.getMethod();
                net.rim.tools.compiler.types.ClassType g5 = c3.getClassType();
                stringbuffer.append('"');
                _aStringBufferStringBuffer(stringbuffer, g5);
                _aStringBufferStringBuffer(stringbuffer, c3).append("\" // ").append(i1);
            }
            break;

        case 5: // '\005'
				net.rim.tools.compiler.util.Exported d4 = compiler._intId(i1);
            if(d4 != null)
            {
                net.rim.tools.compiler.types.ClassType g6 = d4.getClassType();
                net.rim.tools.compiler.types.Field h1 = g6.getField(d4.getClassTypeIndex());
                stringbuffer.append('"');
                _aStringBufferStringBuffer(stringbuffer, g6);
                _aStringBufferStringBuffer(stringbuffer, h1).append("\" // ").append(i1);
            }
            break;

        case 6: // '\006'
            stringbuffer.append(i1);
            break;
        }
        return stringbuffer;
    }

    private static void _aHashtableSV(Hashtable hashtable, String s, String s1)
    {
        s = net.rim.tools.compiler.util.StringHelper._ifStringSString(s, ".", "_");
        Vector vector = (Vector)hashtable.get(s);
        if(vector == null)
        {
            vector = new Vector();
            hashtable.put(s, vector);
        }
        vector.addElement(s1);
    }

    private static Hashtable _aCompilerHashtable(Compiler compiler, net.rim.tools.compiler.util.CompilerProperties f1, String s, String s1)
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        Hashtable hashtable = new Hashtable();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        printstream.println("/* Codfile Data *//* auto-generated file, do not edit */");
        printstream.println();
        printstream.println("#if !defined( _NATIVE_" + s1 + "_H_ )");
        printstream.println("#define _NATIVE_" + s1 + "_H_");
        printstream.println();
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < 7; i++)
        {
            String s2 = z_t4aString[i];
            printstream.print("/* defines for ");
            printstream.print(s2);
            printstream.println(". */");
            Vector vector = f1.getVector(s2);
            Object aobj[] = new Object[2];
            int i1 = vector.size();
            for(int j1 = z_ufaI[i]; j1 < i1; j1++)
            {
                Object obj = vector.elementAt(j1);
                if(obj != null)
                {
                    String s3 = null;
                    String s4 = null;
                    String s5 = null;
                    if(obj instanceof net.rim.tools.compiler.types.Method)
                    {
                        net.rim.tools.compiler.types.Method c1 = (net.rim.tools.compiler.types.Method)obj;
                        s4 = c1._fWvString();
                        s5 = c1.getClassType().getPackageNameString();
                        if(c1.isAnd(32769))
                            s3 = "native method " + s4 + " cannot be synchronized";
                    } else
                    if(obj instanceof net.rim.tools.compiler.types.Type)
                    {
                        net.rim.tools.compiler.types.Type a1 = (net.rim.tools.compiler.types.Type)obj;
                        s4 = a1.getFullName();
                    } else
                    {
                        s4 = obj.toString();
                    }
                    stringbuffer.setLength(0);
                    String s6 = _aStringBufferCStringBuffer(stringbuffer, compiler, i, j1, aobj).toString();
                    if(s6.length() > 0 && s4.length() > 0)
                    {
                        stringbuffer.setLength(0);
                        String s7 = _aStringBufferStringStringBuffer(stringbuffer, i, s4).toString();
                        stringbuffer.setLength(0);
                        stringbuffer.append("#define ").append(s7).append(' ').append(s6);
                        printstream.println(stringbuffer.toString());
                        if(s3 != null)
                        {
                            stringbuffer.setLength(0);
                            stringbuffer.append("#error ").append(s3);
                            printstream.println(stringbuffer.toString());
                        }
                        if(i == 0)
                        {
                            stringbuffer.setLength(0);
                            String s8 = _doStringBufferStringBuffer(stringbuffer, s4).toString();
                            stringbuffer.setLength(0);
                            stringbuffer.append("extern \"C\" VMReturn VMASMCALL ").append(s8).append("( VMThread *env );");
                            printstream.println(stringbuffer.toString());
                            stringbuffer.setLength(0);
                            stringbuffer.append(s7).append(", ").append(s8).append(',');
                            _aHashtableSV(hashtable, s5, stringbuffer.toString());
                        } else
                        if(i == 6)
                        {
                            int k1 = s4.lastIndexOf('.');
                            if(k1 > 0)
                            {
                                String s9 = s4.substring(k1 + 1);
                                if(k1 > 1 && s4.charAt(k1 - 1) == '.')
                                    s9 = s4.substring(k1);
                                stringbuffer.setLength(0);
                                stringbuffer.append("#define ");
                                _aStringBufferStringStringBuffer(stringbuffer, i, s9).append(" \"");
                                _ifStringBufferStringBuffer(stringbuffer, s9).append("\"");
                                printstream.println(stringbuffer.toString());
                            }
                        }
                    }
                }
            }

            printstream.println();
        }

        printstream.println();
        printstream.println("#endif");
        printstream.close();
        _aByteArrayOutputStreamSStringV(bytearrayoutputstream, s, s1, "natives.h");
        return hashtable;
    }

    private static void _aCompilerSStringV(Compiler compiler, String s, String s1, Hashtable hashtable)
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        String s2;
        ByteArrayOutputStream bytearrayoutputstream;
        for(Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements(); _aByteArrayOutputStreamSStringV(bytearrayoutputstream, s, s1, "nativeTable_" + s2 + ".h"))
        {
            s2 = (String)enumeration.nextElement();
            Vector vector = (Vector)hashtable.get(s2);
            bytearrayoutputstream = new ByteArrayOutputStream();
            PrintStream printstream = new PrintStream(bytearrayoutputstream);
            printstream.println("/* Package Natives *//* auto-generated file, do not edit */");
            printstream.println();
            int i = vector.size();
            for(int i1 = 0; i1 < i; i1++)
                printstream.println((String)vector.elementAt(i1));

            printstream.println();
            printstream.close();
        }

    }

    private static void _aCompilerStringV(Compiler compiler, net.rim.tools.compiler.util.CompilerProperties f1, String s, String s1, String s2)
	throws IOException, net.rim.tools.compiler.util.CompileException
    {
        StringBuffer stringbuffer = new StringBuffer();
        String s3 = stringbuffer.append(Character.toUpperCase(s2.charAt(0))).append(s2.substring(1)).append("Natives").toString();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        PrintStream printstream = new PrintStream(bytearrayoutputstream);
        byte byte0 = 6;
        String s4 = z_t4aString[byte0];
        printstream.println("/* Java Header *//* auto-generated file, do not edit */");
        printstream.println();
        printstream.println("package " + s1 + ";");
        printstream.println();
        printstream.println("public final class " + s3 + " {");
        printstream.println("    /* defines for " + s4 + ". */");
        Vector vector = f1.getVector(s4);
        int i = vector.size();
        for(int i1 = z_ufaI[byte0]; i1 < i; i1++)
        {
            String s5 = vector.elementAt(i1).toString();
            int j1 = s5.lastIndexOf('.');
            if(j1 > 0)
            {
                String s6 = s5.substring(j1 + 1);
                if(j1 > 1 && s5.charAt(j1 - 1) == '.')
                    s6 = s5.substring(j1);
                stringbuffer.setLength(0);
                stringbuffer.append("    public static final String ");
                _aStringBufferStringStringBuffer(stringbuffer, byte0, s6).append(" = \"");
                _ifStringBufferStringBuffer(stringbuffer, s6).append("\";");
                printstream.println(stringbuffer.toString());
            }
        }

        printstream.println("}");
        printstream.close();
        _aByteArrayOutputStreamSStringV(bytearrayoutputstream, s, s3, ".java");
    }

    public static void _aCompilerV(Compiler compiler, net.rim.tools.compiler.util.CompilerProperties f1)
	throws net.rim.tools.compiler.util.CompileException
    {
        String s = f1.getProperty("nativedefines");
        String s1 = f1.getProperty("nativejavadefines");
        String s2 = f1.getProperty("nativejavapackage");
        String s3 = z_unString;
        z_unString = null;
        try
        {
            if(s3 != null && s != null)
            {
                Hashtable hashtable = _aCompilerHashtable(compiler, f1, s, s3);
                _aCompilerSStringV(compiler, s, s3, hashtable);
                if(s1 != null && s2 != null)
                    _aCompilerStringV(compiler, f1, s1, s2, s3);
            }
        }
        catch(IOException ioexception)
        {
            throw new net.rim.tools.compiler.util.CompileException("Unable to write natives header file.", ioexception.toString());
        }
    }

}
