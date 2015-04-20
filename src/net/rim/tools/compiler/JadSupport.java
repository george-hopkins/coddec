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
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.util.CompilerProperties;
import net.rim.tools.compiler.util.Tokenizer;
import net.rim.tools.compiler.types.ClassType;

// Referenced classes of package net.rim.tools.compiler:
//            b, d, i, a,
//            e, f, Compiler

public class JadSupport extends net.rim.tools.compiler.util.CompilerProperties
implements net.rim.tools.compiler.vm.Constants
{

    private boolean z_uxZ;
    private Vector _applets;
    private ResourceFile _manifest;
    private Vector _resources;
    private GenerateResources _generatedResources;
    private File _file;
    private int z_utI;
    private Vector _keyFiles;

    public JadSupport(net.rim.tools.compiler.util.CompilerProperties param_parsedArgs)
    {
        _applets = new Vector();
        _resources = param_parsedArgs.getVector("rapc_resourceBinaries");
        _keyFiles = (Vector)param_parsedArgs.get("rapc_keyFiles");
    }

    public net.rim.tools.compiler.ResourceFile getManifest()
    {
        return _manifest;
    }

    public int getNumApplets()
    {
        return _applets.size();
    }

    public net.rim.tools.compiler.Applet getApplet(int k)
    {
        return (net.rim.tools.compiler.Applet)_applets.elementAt(k);
    }

    private static String _ahString(net.rim.tools.compiler.util.Tokenizer h1)
    {
        String s = null;
        try
        {
            if(h1.hasMoreTokens())
            {
                s = net.rim.tools.compiler.util.StringHelper._aStringString(h1.nextToken());
                if(s.equals(","))
                {
                    s = null;
                } else
                {
                    if(h1.hasMoreTokens())
                        h1.nextToken();
                    if(s.length() == 0)
                        s = null;
                }
            }
        }
        catch(NoSuchElementException nosuchelementexception)
        {
            s = null;
        }
        return s;
    }

    private void _tryIStringV(int k, String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.util.Tokenizer h1 = new net.rim.tools.compiler.util.Tokenizer(s, ",", true);
        String s1 = _ahString(h1);
        String s2 = _ahString(h1);
        String s4 = _ahString(h1);
        Applet b1 = null;
        if(k < getNumApplets())
        {
            b1 = getApplet(k);
            if(s1 != null)
                b1.setName(s1);
            if(s4 != null)
                b1.setClassName(s4);
        } else
        {
            b1 = new Applet(s1, s4);
            _applets.addElement(b1);
        }
        if(s2 != null)
            b1.setIconName(s2, 0);
        String s5 = net.rim.tools.compiler.ResourceIds.z_nString + "Count-" + (k + 1);
        String s7 = getProperty(s5);
        if(s7 != null)
            try
            {
                int l = Integer.parseInt(s7);
                for(int i1 = 0; i1 < l; i1++)
                {
                    String s6 = net.rim.tools.compiler.ResourceIds.z_nString + (k + 1) + "-" + (i1 + 1);
                    String s3 = getProperty(s6);
                    if(s3 != null)
                        b1.setIconName(s3, i1 + 1);
                }

            }
            catch(NumberFormatException numberformatexception) { }
    }

    private void _afStringZV(CompilerProperties f1, String as[], boolean flag, boolean flag1)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int k = as.length;
        for(int l = 0; l < k; l++)
        {
            String s = as[l];
            String s1 = f1.getProperty(s);
            if(s1 == null)
            {
                if(flag)
                    throw new net.rim.tools.compiler.util.CompileException(907, null, "Descriptor missing required attribute: " + s);
            } else
            {
                f1.remove(s);
                if(flag1)
                {
                    setProperty(s, s1);
                } else
                {
                    String s2 = getProperty(s);
                    if(s2 == null)
                        setProperty(s, s1);
                    else
                    if(!s2.equals(s1))
                        throw new net.rim.tools.compiler.util.CompileException(905, null, "Descriptor duplicate attribute mismatch: '" + s + "' old value: '" + s2 + "' new value: '" + s1 + "'");
                }
            }
        }

    }

    private String _afStringvString(CompilerProperties f1, String as[], int k)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String s = null;
        int l = as.length;
        for(int i1 = 0; i1 < l; i1++)
        {
            String s1 = as[i1] + (k + 1);
            String s3 = f1.getProperty(s1);
            if(s3 != null)
            {
                f1.remove(s1);
                setProperty(s1, s3);
                if(i1 == 0)
                    s = s3;
                else
                if(i1 == 1)
                    try
                    {
                        int j1 = Integer.parseInt(s3);
                        for(int k1 = 0; k1 < j1; k1++)
                        {
                            String s2 = net.rim.tools.compiler.ResourceIds.z_nString + (k + 1) + "-" + (k1 + 1);
                            String s4 = f1.getProperty(s2);
                            if(s4 != null)
                            {
                                f1.remove(s2);
                                setProperty(s2, s4);
                            }
                        }

                    }
                    catch(NumberFormatException numberformatexception) { }
            }
        }

        return s;
    }

    private void _forfV(CompilerProperties f1)
    {
        String s;
        String s1;
        for(Enumeration enumeration = f1.keys(); enumeration.hasMoreElements(); setProperty(s, s1))
        {
            s = (String)enumeration.nextElement();
            s1 = f1.getProperty(s);
        }

    }

    public void parseManifest(Compiler compiler, String s, Manifest manifest)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        CompilerProperties f1 = new CompilerProperties();
        byte abyte0[] = null;
        try
        {
            Attributes attributes = manifest.getMainAttributes();
            for(Iterator iterator = attributes.keySet().iterator(); iterator.hasNext();)
            {
                Object obj = iterator.next();
                Object obj1 = attributes.get(obj);
                if(obj1 != null)
                    f1.put(obj.toString(), obj1.toString().trim());
            }

            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            manifest.write(bytearrayoutputstream);
            abyte0 = bytearrayoutputstream.toByteArray();
        }
        catch(IOException ioexception)
        {
            compiler.generateWarning(false, s, "Found malformed manifest in jar file: " + ioexception.toString());
        }
        if(abyte0 == null)
            return;
        _manifest = new ResourceFile("META-INF/MANIFEST.MF", abyte0, false);
        _afStringZV(f1, net.rim.tools.compiler.ResourceIds.p_manifestVersionArray, false, false);
        if(f1.size() <= 2)
            return;
        _afStringZV(f1, net.rim.tools.compiler.ResourceIds.p_middletKeysArray, true, false);
        _afStringZV(f1, net.rim.tools.compiler.ResourceIds.z_byteaString, false, false);
        _afStringZV(f1, net.rim.tools.compiler.ResourceIds.z_tryaString, false, false);
        int k = 0;
        do
        {
            String s1 = _afStringvString(f1, net.rim.tools.compiler.ResourceIds.z_maString, k);
            if(s1 != null)
            {
                if(s1.length() > 0)
                    _tryIStringV(k, s1);
                k++;
            } else
            {
                _forfV(f1);
                z_uxZ = true;
                return;
            }
        } while(true);
    }

    public void parseJadFile(String param_fileNameS)
        throws IOException
    {
        CompilerProperties loc_file = new CompilerProperties();
        File file = new File(param_fileNameS);
        if(file.exists())
        {
            BufferedInputStream bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
            String s1 = net.rim.tools.compiler.exec.CharacterHelper.utf8ToString(net.rim.tools.compiler.io.StructuredInputStream.readFully(bufferedinputstream, -1, param_fileNameS));
            loc_file.load(s1);
            _forfV(loc_file);
        }
    }

    private void _aIStringV(int k, String s, String s1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(s1 != null)
            s = s + s1;
        throw new net.rim.tools.compiler.util.CompileException(k, null, s);
    }

    private void _dofV(net.rim.tools.compiler.util.CompilerProperties param_parsedArgs)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String s = null;
        for(Enumeration enumeration = param_parsedArgs.keys(); enumeration.hasMoreElements();)
        {
            String s1 = (String)enumeration.nextElement();
            if(s1.startsWith("MIDlet-Certificate-"))
            {
                s = s1;
                break;
            }
        }

        if(s != null)
            _aIStringV(905, "Cannot use security attribute: ", s);
    }

    public void checkSecurity(net.rim.tools.compiler.util.CompilerProperties param_parsedArgs)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        String s = param_parsedArgs.getProperty("MIDlet-Jar-RSA-SHA1");
        if(s == null)
        {
            _dofV(param_parsedArgs);
            return;
        } else
        {
            _aIStringV(907, "Cannot check security", null);
            return;
        }
    }

    public void _ifCompilerV(Compiler compiler, String s)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        CompilerProperties f1 = new CompilerProperties();
        BufferedInputStream bufferedinputstream = null;
        File file = new File(s);
        _file = file.getAbsoluteFile().getParentFile();
        bufferedinputstream = new BufferedInputStream(new FileInputStream(file));
        String s1 = net.rim.tools.compiler.exec.CharacterHelper.utf8ToString(net.rim.tools.compiler.io.StructuredInputStream.readFully(bufferedinputstream, -1, s));
        f1.load(s1);
        _iffV(f1);
    }

    public void _aaStringV(String s)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        CompilerProperties f1 = new CompilerProperties();
        f1.load(s);
        _file = new File(".");
        _iffV(f1);
    }

    private void _iffV(net.rim.tools.compiler.util.CompilerProperties param_parsedArgs)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        checkSecurity(param_parsedArgs);
        _afStringZV(param_parsedArgs, net.rim.tools.compiler.ResourceIds.z_byteaString, false, true);
        _aaStringaStringV(net.rim.tools.compiler.ResourceIds.z_byteaString, net.rim.tools.compiler.ResourceIds.z_uaaString);
        _afStringZV(param_parsedArgs, net.rim.tools.compiler.ResourceIds.p_middletKeysArray, true, false);
        _afStringZV(param_parsedArgs, net.rim.tools.compiler.ResourceIds.z_AaString, true, true);
        _afStringZV(param_parsedArgs, net.rim.tools.compiler.ResourceIds.z_tryaString, false, true);
        int k = 0;
        do
        {
            String s = _afStringvString(param_parsedArgs, net.rim.tools.compiler.ResourceIds.z_maString, k);
            if(s != null)
            {
                if(s.length() == 0)
                    throw new net.rim.tools.compiler.util.CompileException(907, null, "Descriptor missing required attribute: " + net.rim.tools.compiler.ResourceIds.z_maString[0]);
                _tryIStringV(k, s);
                Applet b1 = getApplet(k);
                int l = b1.getNumIcons();
                for(int i1 = 0; i1 < l; i1++)
                {
                    net.rim.tools.compiler.ImageFile a1 = b1.getIcon(i1);
                    if(!a1.isEmpty())
                    {
                        a1.setRelativeName(_file);
                        if(_resources.indexOf(a1) == -1)
                            _resources.addElement(a1);
                    }
                }

                k++;
            } else
            {
                _forfV(param_parsedArgs);
                z_uxZ = true;
                return;
            }
        } while(true);
    }

    public void addResourcesFiles(Vector __files)
        throws IOException
    {
        int k = __files.size();
        if(k > 0)
        {
            File _file_ = _file;
            if(_file_ == null)
                _file_ = new File(".");
            _file_ = _file_.getAbsoluteFile();
            for(int l = 0; l < k; l++)
            {
                net.rim.tools.compiler.ResourceFile _resourceFile_ = new net.rim.tools.compiler.ResourceFile((File)__files.elementAt(l));
                _resourceFile_.setRelativeName(_file_);
                if(_resources.indexOf(_resourceFile_) == -1)
                    _resources.addElement(_resourceFile_);
            }

        }
    }

    public int get_keyFilesNumber()
    {
        return _keyFiles != null ? _keyFiles.size() : 0;
    }

    public net.rim.tools.compiler.i get_keyFileByIndex(int k)
    {
        return (i)_keyFiles.elementAt(k);
    }

    public void parse_keyFiles()
        throws IOException
    {
        if(_keyFiles != null)
        {
            int k = _keyFiles.size();
            for(int l = 0; l < k; l++)
            {
                z_uxZ = true;
                File file = (File)_keyFiles.elementAt(l);
                try
                {
                    i i1 = new i(file);
                    _keyFiles.setElementAt(i1, l);
                }
                catch(Exception exception)
                {
                    throw new IOException("Invalid key file: " + file.getPath());
                }
            }

        }
    }

    public int _abStringI(String s)
    {
        if(s.equals("nokey"))
            return 255;
        int k = _keyFiles.size();
        for(int l = 0; l < k; l++)
        {
            i i1 = (i)_keyFiles.elementAt(l);
            if(i1.get_keyFileName().equals(s))
            {
                if(!i1._forvZ())
                {
                    z_utI++;
                    z_uxZ = true;
                    i1._newvV();
                }
                return l;
            }
        }

        return -1;
    }

    public String get_middletVersion(Manifest manifest)
        throws IOException
    {
        String s = null;
        if(manifest != null)
        {
            Attributes attributes = manifest.getMainAttributes();
            s = attributes.getValue(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[1]);
        }
        return s;
    }

    private void _ifZZV(boolean flag, boolean flag1, Vector vector)
	throws net.rim.tools.compiler.util.CompileException
    {
        int k = getNumApplets();
        for(int l = k - 1; l >= 0; l--)
        {
            Applet b1 = getApplet(l);
            int j1 = b1.getNumIconNames();
            for(int l1 = 0; l1 < j1; l1++)
            {
                String s = b1.getIconName(l1);
                if(s != null)
                {
                    if(s.charAt(0) == '/')
                        s = s.substring(1);
                    net.rim.tools.compiler.ImageFile a1 = null;
                    int j2 = -1;
                    for(j2 = _resources.size() - 1; j2 >= 0; j2--)
                    {
                        Object obj = _resources.elementAt(j2);
                        if(obj.equals(s))
                            break;
                    }

                    if(j2 != -1)
                    {
                        a1 = (net.rim.tools.compiler.ImageFile)_resources.elementAt(j2);
                    } else
                    {
                        try
                        {
                            File file = new File(_file, s);
                            if(file.exists())
                            {
                                a1 = new net.rim.tools.compiler.ImageFile(file);
                            } else
                            {
                                File file1 = new File(s);
                                if(file1.exists())
                                    a1 = new net.rim.tools.compiler.ImageFile(file1);
                            }
                        }
                        catch(IOException ioexception) { }
                        if(a1 != null)
                        {
                            if(flag1)
                                a1.convertImage();
                            _resources.addElement(a1);
                        }
                    }
                    if(a1 != null)
                        b1.setIcon(a1, l1);
                }
            }

        }

        if(!flag)
            return;
        for(int i1 = k - 1; i1 >= 0; i1--)
        {
            Applet b2 = getApplet(i1);
            if(b2.getClassName() == null)
                _applets.removeElementAt(i1);
        }

        if(getNumApplets() == 0 && vector != null)
        {
            int k1 = vector.size();
            for(int i2 = 0; i2 < k1; i2++)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)vector.elementAt(i2);
                String s1 = g1.getName();
                String s2 = g1.getFullName();
                _applets.addElement(new Applet(s1, s2));
            }

        }
    }

    public void _aZZV(boolean flag, boolean flag1, Vector vector)
	throws net.rim.tools.compiler.util.CompileException
    {
        _ifZZV(flag, flag1, vector);
        if(getProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[0]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[0], "unnamed");
        if(getProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[1]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[1], "0.0");
        if(getProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[2]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.p_middletKeysArray[2], "anonymous");
        if(getProperty(net.rim.tools.compiler.ResourceIds.p_manifestVersionArray[0]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.p_manifestVersionArray[0], "1.0");
        if(getProperty(net.rim.tools.compiler.ResourceIds.z_byteaString[0]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.z_byteaString[0], "MIDP-2.0");
        if(getProperty(net.rim.tools.compiler.ResourceIds.z_byteaString[1]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.z_byteaString[1], "CLDC-1.1");
        if(getProperty(net.rim.tools.compiler.ResourceIds.z_AaString[0]) == null)
            setProperty(net.rim.tools.compiler.ResourceIds.z_AaString[0], "unknown");
    }

    private void printAll(PrintStream __print)
        throws IOException
    {
        for(Enumeration enumeration = keys(); enumeration.hasMoreElements();)
        {
            String s = (String)enumeration.nextElement();
            String s1 = getProperty(s);
            if(s1 != null)
            {
                __print.print(s);
                __print.print(": ");
                __print.println(s1);
            }
        }

    }

    private void _aaStringaStringV(String as[], String as1[][])
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int k = as.length;
        for(int l = 0; l < k; l++)
        {
            String s = as[l];
            String s1 = getProperty(s);
            if(s1 == null)
                throw new net.rim.tools.compiler.util.CompileException(907, null, "Application missing required attribute: " + s);
            if(as1 != null)
            {
                if(s1.indexOf('-') == -1)
                    throw new net.rim.tools.compiler.util.CompileException(907, null, "Application has malformed attribute: " + s + ": " + s1);
                String as2[] = as1[l];
                int i1 = as2.length;
                int j1 = 0;
                do
                {
                    String s2 = null;
                    int k1 = s1.indexOf(' ', j1);
                    if(k1 == -1)
                    {
                        s2 = s1.substring(j1);
                        j1 = k1;
                    } else
                    {
                        s2 = s1.substring(j1, k1);
                        j1 = k1 + 1;
                    }
                    boolean flag = false;
                    for(int l1 = 0; l1 < i1 && !flag; l1++)
                        flag = s2.equals(as2[l1]);

                    if(!flag)
                        throw new net.rim.tools.compiler.util.CompileException(908, null, "Application has malformed attribute: " + s + ": " + s1);
                } while(j1 != -1);
            }
        }

    }

    public void _kZV(boolean flag)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if((z_uxZ || flag) && _manifest == null)
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            if(flag)
            {
                _aaStringaStringV(net.rim.tools.compiler.ResourceIds.p_middletKeysArray, null);
                _aaStringaStringV(net.rim.tools.compiler.ResourceIds.z_byteaString, net.rim.tools.compiler.ResourceIds.z_uaaString);
            }
            PrintStream printstream = new PrintStream(bytearrayoutputstream);
            printAll(printstream);
            printstream.close();
            byte abyte0[] = bytearrayoutputstream.toByteArray();
            _manifest = new ResourceFile("META-INF/MANIFEST.MF", abyte0, false);
        }
    }

    public void createJadFile(boolean __isMiddlet, String __jadFileName)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        PrintStream __print = new PrintStream(new FileOutputStream(__jadFileName));
        if(__isMiddlet)
        {
            _aaStringaStringV(net.rim.tools.compiler.ResourceIds.p_middletKeysArray, null);
            _aaStringaStringV(net.rim.tools.compiler.ResourceIds.z_byteaString, net.rim.tools.compiler.ResourceIds.z_uaaString);
        }
        printAll(__print);
        __print.close();
    }

    public String generateResourceClass(Compiler compiler, String __codFileName)
        throws IOException
    {
        _generatedResources = new GenerateResources(compiler, __codFileName, this, _resources);
        return _generatedResources.getClassName();
    }

    public net.rim.tools.compiler.types.ClassType _gVvg()
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if(z_uxZ || _resources.size() > 0)
        {
            File file = _file;
            if(file == null)
                file = new File(".");
            file = file.getAbsoluteFile();
            Vector vector = new Vector();
            int i1 = _resources.size();
            for(int k = i1 - 1; k >= 0; k--)
            {
                ResourceFile d1 = (ResourceFile)_resources.elementAt(k);
                d1.setRelativeName(file);
                String s = net.rim.tools.compiler.util.FileHelper.extractExtension(d1.getRelativeName());
                if(s != null && vector.indexOf(s) == -1)
                    vector.addElement(s);
            }

            StringBuffer stringbuffer = new StringBuffer();
            i1 = vector.size();
            for(int l = 0; l < i1; l++)
            {
                stringbuffer.append((String)vector.elementAt(l));
                stringbuffer.append('\n');
            }

            vector = null;
            return _generatedResources.generateResourceClass(stringbuffer.toString());
        } else
        {
            return null;
        }
    }
}
