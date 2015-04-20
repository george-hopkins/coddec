// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

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
import net.rim.tools.compiler.codfile.Codfile;
import net.rim.tools.compiler.codfile.Module;
import net.rim.tools.compiler.codfile.Identifier;
import net.rim.tools.compiler.codfile.FixupTableEntry;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.ClassRef;
import net.rim.tools.compiler.codfile.Literal;
import net.rim.tools.compiler.codfile.MemberRef;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.codfile.RoutineLocal;
import net.rim.tools.compiler.types.Modifier;
import net.rim.tools.compiler.io.Diagnose;

public class cls_a
{

    private static Hashtable f_methodsHashTable2 = new Hashtable();
    private static Hashtable f_methodsHashTable1 = new Hashtable();
    static StringBuffer z_ifStringBuffer = null;

    public cls_a()
    {
    }

    private static void _aStringBFileOutputStreamV(String s, byte abyte0[], FileOutputStream fileoutputstream)
        throws IOException
    {
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Reading " + s + "...");
        net.rim.tools.compiler.codfile.Codfile _codFile_ = new net.rim.tools.compiler.codfile.Codfile(abyte0);
        _codFile_.processCodeSegment(false);
        net.rim.tools.compiler.codfile.DataSection _DataSection_ = _codFile_.getDataSection();
        OutputStreamWriter outputstreamwriter = null;
        if(fileoutputstream != null)
            outputstreamwriter = new OutputStreamWriter(fileoutputstream);
        StringBuffer stringbuffer = new StringBuffer("<methodrefs codfile='");
        stringbuffer.append(s);
        stringbuffer.append("'>\r\n");
        if(outputstreamwriter != null)
            outputstreamwriter.write(stringbuffer.toString(), 0, stringbuffer.length());
        int i = 0;
        i += _aIkI(0, _DataSection_, outputstreamwriter);
        i += _aIkI(1, _DataSection_, outputstreamwriter);
        i += _aIkI(2, _DataSection_, outputstreamwriter);
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Total number of methods dumped: " + i);
        if(outputstreamwriter != null)
        {
            outputstreamwriter.write("</methodrefs>", 0, 13);
            outputstreamwriter.flush();
            outputstreamwriter.close();
        }
    }

    private static int _aIkI(int __value, net.rim.tools.compiler.codfile.DataSection __dataSection, OutputStreamWriter outputstreamwriter)
        throws IOException
    {
        //net.rim.tools.compiler.d.cls_bbTable ag=k1.get_routineFixupTable(i);
		Vector _ClassDefs_=__dataSection.getClassDefs();
        int l = _ClassDefs_.size();
        StringBuffer stringbuffer = new StringBuffer();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.CodfileItem ap1 = (net.rim.tools.compiler.codfile.CodfileItem)_ClassDefs_.elementAt(i1);
            if(ap1 instanceof net.rim.tools.compiler.codfile.ClassDefLocal)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ap1;
                net.rim.tools.compiler.codfile.CodfileItem ap2 = an1.getItem();
                if(ap2 instanceof MemberRef)
                {
                    net.rim.tools.compiler.codfile.MemberRef _memeberRef_ = (net.rim.tools.compiler.codfile.MemberRef)ap2;
                    stringbuffer.setLength(0);
                    net.rim.tools.compiler.codfile.ClassRef _classRef_ = _memeberRef_.getClassRef();
                    net.rim.tools.compiler.codfile.Identifier _package_ = _classRef_.getPackageName();
                    net.rim.tools.compiler.codfile.Identifier _class_ = _classRef_.getClassName();
                    String _packageName_ = _package_.getString();
                    String _className_ = _class_.getString();
                    net.rim.tools.compiler.codfile.Identifier loc_method = _memeberRef_.getName();
                    String s2 = loc_method.getString();
                    if(!exist(_packageName_ + '.' + _className_ + '.' + s2))
                    {
                        stringbuffer.append("\t<element ");
                        stringbuffer.append("className='");
                        stringbuffer.append(_packageName_);
                        stringbuffer.append(".");
                        stringbuffer.append(_className_);
                        stringbuffer.append("' ");
                        stringbuffer.append("elementType='");
                        boolean flag = false;
                        if(s2.indexOf('<') == -1 && s2.indexOf('>') == -1)
                        {
                            stringbuffer.append("METHOD");
                            stringbuffer.append("' ");
                            stringbuffer.append("methodName='");
                            stringbuffer.append(s2);
                        } else
                        {
                            flag = true;
                            stringbuffer.append("CONSTRUCTOR");
                        }
                        stringbuffer.append("' ");
                        net.rim.tools.compiler.codfile.TypeList loc_methodParameter = _memeberRef_.getTypeList();
                        int l1 = loc_methodParameter.length();
                        boolean flag1 = false;
                        for(int i2 = 0; i2 < l1; i2++)
                            if(i2 != 0 || __value != 2 && (__value != 0 || !flag && _ifStringZ(_packageName_ + '.' + _className_ + '.' + s2)))
                            {
                                if(!flag1)
                                {
                                    stringbuffer.append("parameters='");
                                    flag1 = true;
                                }
                                TypeItem loc_parameter = loc_methodParameter.get_type(i2);
                                stringbuffer.append(loc_parameter.getTypeName());
                                stringbuffer.append(", ");
                            }

                        if(flag1)
                            stringbuffer.append("'");
                        stringbuffer.append("/>\r\n");
                        if(outputstreamwriter != null)
                            outputstreamwriter.write(stringbuffer.toString(), 0, stringbuffer.length());
                        else
                            z_ifStringBuffer.append(stringbuffer);
                    }
                }
            }
        }

        return l;
    }

    private static boolean exist(String __key)
    {
        return f_methodsHashTable1.get(__key) != null;
    }

    private static boolean _ifStringZ(String s)
    {
        if(f_methodsHashTable2.size() > 0)
        {
            Object obj = f_methodsHashTable2.get(s);
            if(obj instanceof RoutineLocal)
            {
                net.rim.tools.compiler.codfile.RoutineLocal loc_method = (net.rim.tools.compiler.codfile.RoutineLocal)obj;
                if((Modifier.toCodfileProtectionAttribute(loc_method.getAttributes()) & 2) != 0)
                    return true;
            } else
            {
                System.out.println("Warning: the entry for " + s + " was not found!");
            }
        }
        return false;
    }

    private static void create_xmlFile(String s)
    {
        File file = new File(s);
        if(file.exists())
            try
            {
                StringBuffer stringbuffer = new StringBuffer(s);
                int i = stringbuffer.length();
                stringbuffer.replace(i - 3, i, "xml");
                FileOutputStream fileoutputstream = new FileOutputStream(stringbuffer.toString());
                try
                {
                    JarFile jarfile = new JarFile(file, false);
                    Enumeration enumeration = jarfile.entries();
                    z_ifStringBuffer = new StringBuffer("<methodrefs codfile='");
                    z_ifStringBuffer.append(s);
                    z_ifStringBuffer.append("'>\r\n");
                    byte abyte1[];
                    for(; enumeration.hasMoreElements(); _aStringBFileOutputStreamV(s, abyte1, null))
                    {
                        JarEntry jarentry = (JarEntry)enumeration.nextElement();
                        s = jarentry.getName();
                        abyte1 = net.rim.tools.compiler.io.StructuredInputStream.readFully(jarfile.getInputStream(jarentry), (int)jarentry.getSize(), s);
                    }

                    OutputStreamWriter outputstreamwriter = new OutputStreamWriter(fileoutputstream);
                    outputstreamwriter.write(z_ifStringBuffer.toString(), 0, z_ifStringBuffer.length());
                    outputstreamwriter.write("</methodrefs>", 0, 13);
                    outputstreamwriter.flush();
                    outputstreamwriter.close();
                    z_ifStringBuffer.setLength(0);
                }
                catch(IOException ioexception1)
                {
                    byte abyte0[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(new FileInputStream(file), (int)file.length(), s);
                    _aStringBFileOutputStreamV(s, abyte0, fileoutputstream);
                }
                fileoutputstream.close();
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(ioexception.getMessage());
            }
        else
            System.out.println(file.toString() + " file was not found.");
    }

    private static void add_methods_to_hasttable(byte __data[], boolean flag, boolean flag1)
        throws IOException
    {
        net.rim.tools.compiler.codfile.Codfile _codFile_ = new net.rim.tools.compiler.codfile.Codfile(__data);
        _codFile_.processCodeSegment(false);
        if(flag)
        {
            net.rim.tools.compiler.codfile.CodfileVector _Routines_ = _codFile_.getRoutines();
            int i = _Routines_.size();
            for(int i1 = 0; i1 < i; i1++)
            {
                RoutineLocal _routine_ = (RoutineLocal)_Routines_.elementAt(i1);
                int l1 = _routine_.getAttributes();
                String _routineName_ = _routine_.get_name_2();
                if(flag1)
                    f_methodsHashTable1.put(_routineName_, _routine_);
                else
                    f_methodsHashTable2.put(_routineName_, _routine_);
            }

        } else
        {
            net.rim.tools.compiler.codfile.DataSection _DataSection_ = _codFile_.getDataSection();
            int l = _DataSection_.getModulesNum();
            for(int j1 = 0; j1 < l; j1++)
            {
                net.rim.tools.compiler.codfile.Module loc_module = _DataSection_.getModule(j1);
                net.rim.tools.compiler.codfile.Literal loc_dataByte = loc_module.getName();
                process_codfile(isFileExists(loc_dataByte.getString()), true, false);
            }

        }
    }

    private static String isFileExists(String s)
    {
        File file = new File(s);
        if(!file.exists())
        {
            StringBuffer stringbuffer = new StringBuffer("..\\Debug\\");
            stringbuffer.append(s);
            stringbuffer.append(".cod");
            s = stringbuffer.toString();
        }
        return s;
    }

    private static void process_codfile(String s, boolean flag, boolean flag1)
    {
        File file = new File(s);
        if(file.exists())
            try
            {
                try
                {
                    JarFile jarfile = new JarFile(file, false);
                    byte abyte1[];
                    for(Enumeration enumeration = jarfile.entries(); enumeration.hasMoreElements(); add_methods_to_hasttable(abyte1, flag, flag1))
                    {
                        JarEntry jarentry = (JarEntry)enumeration.nextElement();
                        s = jarentry.getName();
                        abyte1 = net.rim.tools.compiler.io.StructuredInputStream.readFully(jarfile.getInputStream(jarentry), (int)jarentry.getSize(), s);
                    }

                }
                catch(IOException ioexception)
                {
                    byte abyte0[] = net.rim.tools.compiler.io.StructuredInputStream.readFully(new FileInputStream(file), (int)file.length(), s);
                    add_methods_to_hasttable(abyte0, flag, flag1);
                }
            }
            catch(IOException ioexception1)
            {
                ioexception1.printStackTrace();
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(ioexception1.getMessage());
            }
    }

    private static void clear_hashTable()
    {
        f_methodsHashTable2.clear();
    }

    public static void _aaStringV(String as[])
    {
        net.rim.tools.compiler.io.Diagnose.DiagnoseStream = System.out;
        if(as.length == 0)
        {
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Usage: dumpmethodrefs <filename1> [<filename2>, ...]");
        } else
        {
            int i = as.length;
            for(int l = 0; l < i; l++)
            {
                String s = isFileExists(as[l]);
                process_codfile(s, true, true);
                process_codfile(s, false, false);
                create_xmlFile(s);
                clear_hashTable();
            }

        }
    }

}
