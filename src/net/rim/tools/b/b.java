// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.b;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import net.rim.tools.compiler.classfile.ConstantPoolNameAndType;
import net.rim.tools.compiler.classfile.ClassFileMethod;
import net.rim.tools.compiler.classfile.ClassFileField;
import net.rim.tools.compiler.classfile.TypeDescriptor;
import net.rim.tools.compiler.classfile.ConstantPoolClass;
import net.rim.tools.compiler.classfile.ConstantPool;
import net.rim.tools.compiler.classfile.ClassFile;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.b:
//            d, c

public class b
{

    private static net.rim.tools.b.c z_intc = new net.rim.tools.b.c();
    private boolean z_newZ;
    private String z_aString;
    private PrintStream z_forPrintStream;
    private Hashtable z_ifHashtable;
    private net.rim.tools.b.d z_doad[];

    private b(String s, PrintStream printstream)
    {
        z_aString = s;
        z_forPrintStream = printstream;
        z_ifHashtable = new Hashtable();
    }

    private void _aHashtableV(Hashtable hashtable, String s)
    {
        int i = s.length();
        for(int j = 0; j < i;)
        {
            char c1 = s.charAt(j++);
            if(c1 == 'L')
            {
                String s1 = s.substring(j, s.indexOf(';', j)).replace('/', '.');
                j += s1.length() + 1;
                hashtable.put(s1, s1);
            }
        }

    }

    private void _aInputStreamStringV(InputStream inputstream, int i, String s)
        throws IOException
    {
        byte abyte0[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(inputstream, i, s);
        net.rim.tools.compiler.classfile.ClassFile q1 = new net.rim.tools.compiler.classfile.ClassFile(abyte0, false);
        net.rim.tools.compiler.classfile.ConstantPool m1 = q1.getConstantsPool();
        Hashtable hashtable = new Hashtable();
        int j = m1.getSize();
        for(int k = 1; k < j; k++)
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry o = m1.getConstantPoolEntry(k);
            if(o instanceof net.rim.tools.compiler.classfile.ConstantPoolClass)
            {
                net.rim.tools.compiler.classfile.ConstantPoolClass e1 = (net.rim.tools.compiler.classfile.ConstantPoolClass)o;
                String s1 = e1.getName();
                if(s1.charAt(0) != '[')
                    hashtable.put(s1, s1);
            } else
            if(o instanceof net.rim.tools.compiler.classfile.ConstantPoolNameAndType)
            {
                net.rim.tools.compiler.classfile.ConstantPoolNameAndType ag1 = (net.rim.tools.compiler.classfile.ConstantPoolNameAndType)o;
                _aHashtableV(hashtable, ag1.getType());
            }
        }

        j = q1.getNumFields();
        for(int l = 0; l < j; l++)
        {
            net.rim.tools.compiler.classfile.ClassFileField ak1 = q1.getField(l);
            net.rim.tools.compiler.classfile.TypeDescriptor d1 = ak1.getDescriptor();
            _aHashtableV(hashtable, d1.getString());
        }

        j = q1.getNumMethods();
        for(int i1 = 0; i1 < j; i1++)
        {
            net.rim.tools.compiler.classfile.ClassFileMethod ah1 = q1.getMethod(i1);
            net.rim.tools.compiler.classfile.TypeDescriptor d2 = ah1.getDescriptor();
            _aHashtableV(hashtable, d2.getString());
        }

        String s2 = q1.getClassNameString();
        z_ifHashtable.put(s2, hashtable);
    }

    private void _dovV()
        throws IOException
    {
        if(z_aString.endsWith(".jar"))
        {
            try
            {
                JarFile jarfile = new JarFile(z_aString, false);
                for(Enumeration enumeration = jarfile.entries(); enumeration.hasMoreElements();)
                {
                    ZipEntry zipentry = (ZipEntry)enumeration.nextElement();
                    String s = zipentry.getName();
                    if(s.endsWith(".class"))
                    {
                        InputStream inputstream = jarfile.getInputStream(zipentry);
                        _aInputStreamStringV(inputstream, (int)zipentry.getSize(), s);
                        inputstream.close();
                    }
                }

                jarfile.close();
                z_newZ = true;
            }
            catch(IOException ioexception)
            {
                throw new IOException(ioexception.getMessage() + ": " + z_aString);
            }
        } else
        {
            File file = new File(z_aString);
            FileInputStream fileinputstream = new FileInputStream(file);
            _aInputStreamStringV(fileinputstream, (int)file.length(), z_aString);
            fileinputstream.close();
        }
    }

    private void _aStringV(String s, Hashtable hashtable)
    {
        hashtable.put(s, s);
        Hashtable hashtable1 = (Hashtable)z_ifHashtable.get(s);
        for(Enumeration enumeration = hashtable1.keys(); enumeration.hasMoreElements();)
        {
            String s1 = (String)enumeration.nextElement();
            if(!hashtable.containsKey(s1))
                _aStringV(s1, hashtable);
        }

    }

    private void _avV()
    {
        z_doad = new net.rim.tools.b.d[z_ifHashtable.size()];
        if(z_newZ)
        {
            for(Enumeration enumeration = z_ifHashtable.keys(); enumeration.hasMoreElements();)
            {
                String s = (String)enumeration.nextElement();
                Hashtable hashtable = (Hashtable)z_ifHashtable.get(s);
                for(Enumeration enumeration3 = hashtable.keys(); enumeration3.hasMoreElements();)
                {
                    String s3 = (String)enumeration3.nextElement();
                    if(!z_ifHashtable.containsKey(s3))
                        hashtable.remove(s3);
                }

            }

            Enumeration enumeration1 = z_ifHashtable.keys();
            int j = 0;
            while(enumeration1.hasMoreElements())
            {
                String s1 = (String)enumeration1.nextElement();
                Hashtable hashtable1 = new Hashtable();
                _aStringV(s1, hashtable1);
                z_doad[j++] = new net.rim.tools.b.d(s1, hashtable1);
            }
        } else
        {
            Enumeration enumeration2 = z_ifHashtable.keys();
            int k = 0;
            while(enumeration2.hasMoreElements())
            {
                String s2 = (String)enumeration2.nextElement();
                Hashtable hashtable2 = (Hashtable)z_ifHashtable.get(s2);
                z_doad[k++] = new net.rim.tools.b.d(s2, hashtable2);
            }
        }
        net.rim.tools.compiler.exec.MyArrays.sort(z_doad, z_intc);
        int i = z_doad.length;
        for(int l = 0; l < i - 1; l++)
        {
            net.rim.tools.b.d d1 = z_doad[l];
            if(d1 != null)
            {
                for(int i1 = l + 1; i1 < i; i1++)
                {
                    net.rim.tools.b.d d2 = z_doad[i1];
                    if(!d1.equals(d2))
                        break;
                    d1._aStringV(d2._dovString());
                    z_doad[i1] = null;
                }

            }
        }

    }

    private void _ifvV()
        throws IOException
    {
        int i = z_doad.length;
        for(int j = 0; j < i; j++)
        {
            net.rim.tools.b.d d1 = z_doad[j];
            if(d1 != null)
            {
                int k = d1._avI();
                z_forPrintStream.print("Tree contains ");
                z_forPrintStream.print(Integer.toString(k));
                z_forPrintStream.print(" classes, when rooted at: ");
                z_forPrintStream.println(d1._ifvString());
                for(int l = 0; l < k; l++)
                {
                    z_forPrintStream.print("        ");
                    z_forPrintStream.println(d1._aIString(l));
                }

            }
        }

    }

    public static void _aaStringV(String as[])
    {
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream = System.out;
        if(as.length != 1)
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Usage: dumpdepend {<filename.class>|<filename.jar>}");
        else
            try
            {
                net.rim.tools.b.b b1 = new net.rim.tools.b.b(as[0], net.rim.tools.compiler.io.Diagnose.DiagnoseStream);
                b1._dovV();
                b1._avV();
                b1._ifvV();
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(ioexception.getMessage());
            }
    }

}
