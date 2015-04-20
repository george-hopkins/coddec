// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;

import java.io.*;
import java.util.Vector;
import net.rim.tools.compiler.vm.Constants;

// Referenced classes of package net.rim.tools.compiler.f:
//            g

public final class FileHelper
implements net.rim.tools.compiler.vm.Constants
{

    public static final char p_pathSeparatorC;
    public static final String p_pathSeparatorS;
    public static final char p_separatorC;
    public static final String p_separatorS;
    public static final long z_nMJ = 0x1b7740L;
    public static String ext_cod = ".cod";
    public static String ext_tmp = ".tmp";
    public static String ext_jar = ".jar";
    public static String ext_jad = ".jad";
    public static String ext_rapc = ".rapc";
    public static String ext_class = ".class";
    public static String ext_images[] = {
        ".gif", ".png", ".jpg", ".jpeg"
    };
    public static String p_rapcPrefixS = "rapc_";
    public static String ext_lst = ".lst";
    public static String ext_debug = ".debug";
    public static String ext_csl = ".csl";
    public static String ext_cso = ".cso";
    public static String ext_java = ".java";
    public static String ext_key = ".key";
    public static String ext_export = ".export";
    public static String ext_static = ".static";
    public static String ext_dir = ".dir";
    public static String ext_rrh;
    public static String ext_rrc;
    public static String ext_resources[];
    public static String ext_crb = ".crb";
    public static String ext_bin = ".bin";
    private Vector z_nOVector;

    public FileHelper()
    {
        z_nOVector = new Vector();
    }

    public void _wStringV(String s)
    {
        if(p_separatorC == '\\')
            s = s.replace('/', p_separatorC);
        else
            s = s.replace('\\', p_separatorC);
        z_nOVector.addElement(s);
    }

    public String _tryStringString(String s, String s1)
        throws IOException
    {
        int i = z_nOVector.size();
        if(i == 0)
            return null;
        String s2 = s1;
        int k = _rStringI(s1);
        if(k == -1)
        {
            StringBuffer stringbuffer = (new StringBuffer()).append(p_separatorC);
            if(s != null)
                stringbuffer.append(s.replace('.', p_separatorC)).append(p_separatorC);
            s2 = stringbuffer.append(s1).toString();
        }
        for(int l = 0; l < i; l++)
        {
            String s4 = (String)z_nOVector.elementAt(l);
            if(s4.endsWith(s2))
                return s4;
        }

        if(k == -1 && s != null)
        {
            String s3 = p_separatorC + s1;
            for(int i1 = 0; i1 < i; i1++)
            {
                String s5 = (String)z_nOVector.elementAt(i1);
                if(s5.endsWith(s3))
                    return s5;
            }

        }
        return null;
    }

    private static int delete_tempFile(File file)
        throws IOException
    {
        int i = 0;
        String as[] = file.list();
        if(as != null)
        {
            for(int k = 0; k < as.length; k++)
            {
                File file1 = new File(file.getPath(), as[k]);
                if(file1.isDirectory())
                {
                    i += delete_tempFile(file1);
                } else
                {
                    i += (int)file1.length();
                    file1.delete();
                }
            }

        }
        file.delete();
        return i;
    }

    private static String get_randomString()
    {
        try
        {
            Thread.sleep(13L);
        }
        catch(InterruptedException interruptedexception) { }
        String s = Integer.toHexString((int)(System.currentTimeMillis() & 0x7fffffffL));
        return "00000000".substring(0, 8 - s.length()) + s;
    }

    public static File createTempDir(String __fileName) //create temporary file
        throws IOException
    {
        File _file_ = null;
        try
        {
            if(__fileName != null)
                _file_ = File.createTempFile(p_rapcPrefixS, ext_dir, new File(__fileName));
            else
                _file_ = File.createTempFile(p_rapcPrefixS, ext_dir);
        }
        catch(IOException ioexception)
        {
            try
            {
                _file_ = File.createTempFile(p_rapcPrefixS, ext_dir, new File("."));
            }
            catch(IOException ioexception1)
            {
                throw new IOException("unable to create temporary subdirectory");
            }
        }
        File file1 = _file_.getParentFile();
        if(_file_.exists())
            _file_.delete();
        int i = 0;
        do
        {
            _file_ = new File(file1, "rapc_" + get_randomString() + ".dir");
            i++;
        } while(_file_.exists() && i < 5);
        if(!_file_.mkdir())
            throw new IOException("unable to create temporary subdirectory: " + _file_.getPath());
        else
            return _file_;
    }

    private static int delete_tempFiles(String s)
    {
        if(s == null)
            return 0;
        long l = System.currentTimeMillis() - 0x1b7740L;
        int i = 0;
        try
        {
            File file = new File(s);
            String as[] = file.list();
            if(as != null)
            {
                for(int k = 0; k < as.length; k++)
                    if(as[k].startsWith(p_rapcPrefixS) && as[k].endsWith(ext_dir))
                    {
                        File file1 = new File(file, as[k]);
                        if(file1.isDirectory() && file1.lastModified() < l)
                            i += delete_tempFile(file1);
                    }

            }
        }
        catch(IOException ioexception) { }
        return i;
    }

    public static int delete_tempFilesAll(File file)
    {
        int i = 0;
        try
        {
            i = delete_tempFile(file);
            i += delete_tempFiles(System.getProperty("java.io.tmpdir"));
            i += delete_tempFiles(".");
        }
        catch(IOException ioexception) { }
        return i;
    }

    public static String convert_tempFileTocodFile(String s, String s1)
        throws IOException
    {
        File file = new File(s);
        File file1 = new File(s1);
        file1.delete();
        file.renameTo(file1);
        return file1.getPath();
    }

    public static void deleteFiles(String __files[], String __fileName)
    {
        if(__files != null)
        {
            int i = __files.length;
            for(int k = 0; k < i; k++)
            {
                String s1 = __files[k];
                if(s1 != null)
                {
                    (new File(s1)).delete();
                    String s2 = removeExtension(s1, ext_cod);
                    if(s2 == s1)
                        s2 = removeExtension(s1, ext_tmp);
                    if(s2 != s1)
                    {
                        (new File(s2 + ext_lst)).delete();
                        (new File(s2 + ext_debug)).delete();
                    }
                }
            }

        }
        if(__fileName != null)
        {
            File file = new File(__fileName);
            file.delete();
        }
    }

    public static File _intFileFile(File __file)
    {
        boolean flag = false;
        String s = _xStringString(__file.getPath());
        for(int i = StringHelper._ifStringI(s, "/./"); i != -1; i = StringHelper._ifStringI(s, "/./"))
        {
            flag = true;
            s = s.substring(0, i + 1) + s.substring(i + 3);
        }

        for(int k = StringHelper._ifStringI(s, "/../"); k != -1;)
        {
            int l = StringHelper._ifStringI(s, "/", k - 1);
            if(l != -1)
            {
                flag = true;
                s = s.substring(0, l + 1) + s.substring(k + 4);
                k = StringHelper._ifStringI(s, "/../");
            } else
            {
                k = -1;
            }
        }

        if(flag)
            __file = new File(s);
        return __file;
    }

    public static String _xStringString(String s)
    {
        return s.replace('\\', '/');
    }

    public static int _rStringI(String s)
    {
        int i = s.lastIndexOf('\\');
        int k = s.lastIndexOf('/');
        if(k > i)
            i = k;
        return i;
    }

    public static String _sStringString(String __fileName)
    {
        int i = _rStringI(__fileName);
        if(i != -1)
            return __fileName.substring(0, i);
        else
            return null;
    }

    public static String _zStringString(String s)
    {
        int i = _rStringI(s);
        if(i != -1)
            return s.substring(i + 1);
        else
            return s;
    }

    public static String removeQuotes(String s)
    {
        if(s.charAt(0) == '"')
            return s.substring(1, s.length() - 1);
        else
            return s;
    }

    public static int checkExtension(String __name, String __extention)
    {
        if(__name.endsWith(__extention))
            return __name.length() - __extention.length();
        else
            return -1;
    }

    public static int checkExtensions(String s, String as[])
    {
        int i = as.length;
        for(int k = 0; k < i; k++)
            if(checkExtension(s, as[k]) != -1)
                return k;

        return -1;
    }

    public static String removeExtension(String __name, String __extention)
    {
        int i = checkExtension(__name, __extention);
        if(i != -1)
            return __name.substring(0, i);
        else
            return __name;
    }

    public static String extractExtension(String __name)
    {
        if(__name != null)
        {
            int i = __name.lastIndexOf('.');
            if(i != -1)
                return __name.substring(i);
        }
        return null;
    }

    public static String create_fileNameString(String param_fileNameS, int param_moduleNumberI, String param_extString)
    {
        StringBuffer stringbuffer = new StringBuffer(256);
        String s2 = null;
        if(param_moduleNumberI == 0)
        {
            if(param_extString != null)
            {
                stringbuffer.append(param_fileNameS);
                stringbuffer.append(param_extString);
                s2 = stringbuffer.toString();
            } else
            {
                s2 = param_fileNameS;
            }
        } else
        {
            stringbuffer.append(param_fileNameS);
            stringbuffer.append("-");
            stringbuffer.append(param_moduleNumberI);
            if(param_extString != null)
                stringbuffer.append(param_extString);
            s2 = stringbuffer.toString();
        }
        return s2;
    }

    public static String[] _aaStringvaString(String args[], int i)
        throws IOException
    {
        Vector vector;
        Object obj;
        boolean flag;
        StringBuffer stringbuffer;
        vector = new Vector();
        obj = new FileInputStream(args[i].substring(1));
        obj = new BufferedInputStream(((InputStream) (obj)));
        flag = false;
        stringbuffer = new StringBuffer();
_L3:
        do
        {
            int k = ((InputStream) (obj)).read();
            if(k < 0)
            {
                flag = true;
                break;
            }
            if(k == 13)
                continue;
            if(k == 10)
                break;
            stringbuffer.append((char)k);
        } while(true);
		
        if(stringbuffer.length() > 0)
        {
            vector.addElement(stringbuffer.toString());
            stringbuffer.setLength(0);
        }

        flag = true;
_L1:
        
_L2:
        ((InputStream) (obj)).close();
        String as1[] = new String[(args.length + vector.size()) - 1];
        int l = 0;
        int i1 = i;
        for(int j1 = 0; j1 < i1; j1++)
            as1[l++] = args[j1];

        i1 = vector.size();
        for(int k1 = 0; k1 < i1; k1++)
            as1[l++] = (String)vector.elementAt(k1);

        i1 = args.length;
        for(int l1 = i + 1; l1 < i1; l1++)
            as1[l++] = args[l1];

        return as1;
    }

    public static String[] prepareARGS(String args[])
        throws IOException
    {
        for(int i = 0; i < args.length; i++)
            if(args[i].charAt(0) == '@')
                args = _aaStringvaString(args, i);

        return args;
    }

    static
    {
        p_pathSeparatorC = File.pathSeparatorChar;
        p_pathSeparatorS = File.pathSeparator;
        p_separatorC = File.separatorChar;
        p_separatorS = File.separator;
        ext_rrh = ".rrh";
        ext_rrc = ".rrc";
        ext_resources = (new String[] {
            ext_rrh, ext_rrc
        });
    }
}
