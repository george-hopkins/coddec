// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.sdk.rc.ResourceCompiler;
import net.rim.tools.compiler.util.FileHelper;
import net.rim.tools.compiler.io.Diagnose;

// Referenced classes of package net.rim.tools.compiler.c:
//            a

public class cls_e
{

    private static final int z_aI = 128;

    public cls_e()
    {
    }

    private static int _aStringStringI(String s, String as[])
        throws Exception
    {
        Class class1 = Class.forName("com.sun.tools." + s + ".Main");
        Object obj = class1.newInstance();
        Class aclass[] = new Class[1];
        aclass[0] = as.getClass();
        Method method = class1.getMethod("compile", aclass);
        Object aobj[] = new Object[1];
        aobj[0] = as;
        Object obj1 = method.invoke(obj, aobj);
        return ((Integer)obj1).intValue();
    }

    private static int _ifStringStringI(String s, String as[])
        throws Exception
    {
        Class class1 = Class.forName("sun.tools." + s + ".Main");
        Class aclass[] = new Class[3];
        aclass[0] = net.rim.tools.compiler.io.Diagnose.DiagnoseStream.getClass();
        aclass[1] = net.rim.tools.compiler.io.Diagnose.DiagnoseStream.getClass();
        aclass[2] = s.getClass();
        Constructor constructor = class1.getConstructor(aclass);
        Object aobj[] = new Object[3];
        aobj[0] = net.rim.tools.compiler.io.Diagnose.DiagnoseStream;
        aobj[1] = net.rim.tools.compiler.io.Diagnose.DiagnoseStream;
        aobj[2] = s;
        Object obj = constructor.newInstance(aobj);
        aclass = new Class[1];
        aclass[0] = as.getClass();
        Method method = class1.getMethod("run", aclass);
        aobj = new Object[1];
        aobj[0] = as;
        Object obj1 = method.invoke(obj, aobj);
        return !((Boolean)obj1).booleanValue() ? -1 : 0;
    }

    private static int _aStringI(String s, Vector vector)
        throws IOException, InterruptedException
    {
        StringBuffer stringbuffer = new StringBuffer(s);
        Process process = Runtime.getRuntime().exec(_aStringBufferString(stringbuffer, vector));
        if(process == null)
        {
            return -1;
        } else
        {
            (new net.rim.tools.compiler.exec.cls_a(process.getInputStream())).start();
            (new net.rim.tools.compiler.exec.cls_a(process.getErrorStream())).start();
            return process.waitFor();
        }
    }

    private static String _aStringBufferString(StringBuffer stringbuffer, Vector vector)
    {
        int k = vector.size();
        for(int l = 0; l < k; l++)
        {
            String s = (String)vector.elementAt(l);
            if(s.indexOf(' ') != -1)
            {
                stringbuffer.append(" \"");
                stringbuffer.append(s);
                stringbuffer.append("\"");
            } else
            {
                stringbuffer.append(" ");
                stringbuffer.append(s);
            }
        }

        return stringbuffer.toString();
    }

    public static int invokingJavacJar(boolean flag, boolean flag1, String s, Vector vector)
        throws IOException
    {
        try
        {
            if(flag1 && s.equals("javac"))
            {
                if(flag)
                    _aStringSBV("Invoking: ", new StringBuffer(s), vector);
                String as[] = (String[])vector.toArray(new String[vector.size()]);
                int k = _aStringStringI(s, as);
                System.gc();
                System.gc();
                return k;
            }
            if(flag1 && s.equals("jar"))
            {
                if(flag)
                    _aStringSBV("Invoking: ", new StringBuffer(s), vector);
                String as1[] = (String[])vector.toArray(new String[vector.size()]);
                int l = _ifStringStringI(s, as1);
                System.gc();
                System.gc();
                return l;
            }
        }
        catch(Throwable throwable) { }
        try
        {
            if(flag)
                _aStringSBV("Running: ", new StringBuffer(s), vector);
            return _aStringI(s, vector);
        }
        catch(InterruptedException interruptedexception)
        {
            return -1;
        }
    }

    private static void _aStringSBV(String s, StringBuffer stringbuffer, Vector vector)
    {
        stringbuffer.insert(0, s);
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(_aStringBufferString(stringbuffer, vector));
    }

    public static void invokingResourceCompiler(boolean flag, boolean flag1, Vector vector, Vector vector1, Vector vector2, String s, Hashtable hashtable)
        throws IOException
    {
        boolean flag2 = true;
        int k = vector.size();
        for(int l = 0; l < k; l++)
        {
            File file = (File)vector.elementAt(l);
            String s1 = file.getPath();
            if(flag)
            {
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.print("Invoking ResourceCompiler ");
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(s1);
            }
            Vector vector3 = new Vector();
            flag2 = net.rim.sdk.rc.ResourceCompiler._aStringSHashtableZ(s1, s, hashtable, vector3) && flag2;
            if(flag2)
            {
                int i1 = vector3.size();
                for(int j1 = 0; j1 < i1; j1++)
                {
                    String s2 = (String)vector3.elementAt(j1);
                    File file1 = new File(s2);
                    if(s2.endsWith(net.rim.tools.compiler.util.FileHelper.p_separatorS )) //z_n3String
                        vector1.addElement(file1);
                    else
                        vector2.addElement(file1);
                }

            }
        }

        if(!flag2)
            throw new IOException("ResourceCompiler error");
        else
            return;
    }

    public static void _aZStringBufferV(boolean flag, StringBuffer stringbuffer, Vector vector)
    {
        _aStringBufferString(stringbuffer, vector);
        if(!flag && stringbuffer.length() > 128)
        {
            stringbuffer.setLength(128);
            stringbuffer.append(" ...");
        }
    }
}
