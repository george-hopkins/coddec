// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.*;
import java.util.*;
import net.rim.sdk.cls_a;
import net.rim.sdk.rc.pkg_a.ResourceBundleParser;
import net.rim.sdk.rc.pkg_a.ResourceDBParser;
import net.rim.sdk.rc.pkg_a.cls_m;
import net.rim.sdk.cls_b;

// Referenced classes of package net.rim.a.a:
//            f, e, d, h,
//            b

public class ResourceCompiler extends cls_b
{

    private String z_kString;
    private String z_jString;
    private Locale z_nullLocale;
    private String z_voidString;
    private net.rim.sdk.rc.cls_e z_fe;
    private net.rim.sdk.rc.pkg_a.cls_m z_hm;
    private net.rim.sdk.rc.cls_f z_mf;
    public static final String z_lString = "verbose";
    public static final String z_oString = "quiet";
    public static final String z_dString = "resource_version";
    public static final String z_cString = "resource_compress";
    public static final String z_bString = "cr";
    public static final String z_gString = "rv";
    public static final String z_pString = "rdb";
    public static final String z_eString = "1";
    public static final String z_nString = "0";
    public static final int z_longI = 1;
    public static final int z_iI = 2;

    public static boolean _aHashtableZ(Hashtable hashtable)
    {
        net.rim.sdk.rc.cls_f f1 = new net.rim.sdk.rc.cls_f(hashtable);
        return f1._doStringZ("resource_compress") || f1._doStringZ("cr");
    }

    net.rim.sdk.rc.cls_f _intvf()
    {
        return z_mf;
    }

    private ResourceCompiler(String s, String s1, Hashtable hashtable)
        throws IOException
    {
        super(null, "", "");
        if(hashtable == null)
            z_mf = new net.rim.sdk.rc.cls_f();
        else
            z_mf = new net.rim.sdk.rc.cls_f(hashtable);
        z_voidString = s;
        net.rim.sdk.cls_b.z_caseZ = z_mf._doStringZ("verbose");
        _aIStringV(3, "Compiling resource: '" + s + "' from project:" + s1);
        int j = s.lastIndexOf('/') + 1;
        int l = s.indexOf('_', j);
        if(l == -1)
        {
            z_nullLocale = new Locale("", "");
        } else
        {
            String s2 = s.substring(l + 1);
            z_nullLocale = net.rim.sdk.rc.cls_b._aStringLocale(s2);
            s = s.substring(0, l);
            z_jString = s;
        }
        z_fe = new net.rim.sdk.rc.cls_e(s);
        z_fe._tryStringV(s1);
        if(z_mf._doStringZ("rdb"))
        {
            return;
        } else
        {
            z_hm = new net.rim.sdk.rc.pkg_a.cls_m(s + ".rrh", z_fe);
            return;
        }
    }

    public static boolean _aStringSZ(String s, String s1, Hashtable hashtable)
	throws net.rim.sdk.cls_a, IOException
    {
        return _aStringSZZ(s, s1, true, hashtable);
    }

    public static boolean _aStringSHashtableZ(String s, String s1, Hashtable hashtable, Vector vector)
	throws net.rim.sdk.cls_a, IOException
    {
        return _aStringSZHashtableZ(s, s1, true, hashtable, vector);
    }

    public static boolean _aStringZ(String s, String s1, boolean flag)
	throws net.rim.sdk.cls_a, IOException
    {
        return _aStringSZZ(s, s1, flag, null);
    }

    public static boolean _aStringSZZ(String s, String s1, boolean flag, Hashtable hashtable)
	throws net.rim.sdk.cls_a, IOException
    {
        return _aStringSZHashtableZ(s, s1, flag, hashtable, null);
    }

    public static boolean _aStringSZHashtableZ(String s, String s1, boolean flag, Hashtable hashtable, Vector vector)
	throws net.rim.sdk.cls_a, IOException
    {
        boolean flag1 = false;
        if(hashtable == null)
            hashtable = new Hashtable();
        try
        {
            s = s.replace('\\', '/');
            if(s.endsWith(".rdb"))
                hashtable.put("rdb", "1");
            hashtable.put("quiet", flag ? "1" : "0");
            ResourceCompiler j = new ResourceCompiler(s.substring(0, s.length() - 4), s1, hashtable);
            if(s.endsWith(".rrh"))
                j._ifVectorV(vector);
            else
            if(s.endsWith(".rrc"))
                j._aVectorV(vector);
            flag1 = !j.z_fe._bytevZ();
        }
        catch(NullPointerException nullpointerexception)
        {
            nullpointerexception.printStackTrace();
            throw nullpointerexception;
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            throw new IOException(throwable.toString());
        }
        return flag1;
    }

    public static void _aeV(cls_e e1, Reader reader, String s, boolean flag, boolean flag1)
	throws net.rim.sdk.cls_a, IOException
    {
        if(e1 == null || s == null)
            throw new cls_a("Given resource collection is null");
        s = s.replace('\\', '/');
        String s1 = s;
        if(s.endsWith(".rdb") || s.endsWith(".rrh") || s.endsWith(".rrc"))
            s = s.substring(0, s.length() - 4);
        Hashtable hashtable = new Hashtable();
        hashtable.put("quiet", flag ? "1" : "0");
        hashtable.put("rdb", flag1 ? "1" : "0");
        net.rim.sdk.rc.ResourceCompiler j = new net.rim.sdk.rc.ResourceCompiler(s, "", hashtable);
        j._aIStringV(3, "IDE Compiling... <" + s + "> orig <" + s1 + ">");
        if(s1.endsWith(".rrh"))
        {
            j._aIStringV(3, "IDE Compiling rrh '" + s + "'");
            j._aReaderV(reader, e1);
        } else
        if(s1.endsWith(".rrc"))
        {
            j._aIStringV(3, "IDE Compiling rrc '" + s + "'");
            j._aStringV(s, reader, e1);
        } else
        if(s1.endsWith(".rdb"))
        {
            j._aIStringV(3, "IDE Parsing rdb '" + s + "'");
            j._ifStringV(s, reader, e1);
        }
    }

    public static void _aeV(net.rim.sdk.rc.cls_e e1, Reader reader, String s, boolean flag)
	throws net.rim.sdk.cls_a, IOException
    {
        _aeV(e1, reader, s, flag, false);
    }

    private void _ifStringV(String s, Reader reader, net.rim.sdk.rc.cls_e e1)
	throws net.rim.sdk.cls_a, IOException
    {
        z_fe = e1;
        net.rim.sdk.rc.pkg_a.ResourceDBParser k1 = new net.rim.sdk.rc.pkg_a.ResourceDBParser(s + ".rdb", e1);
        k1._aReaderV(reader);
        k1._aeV(e1);
    }

    private void _aStringV(String s, Reader reader, net.rim.sdk.rc.cls_e e1)
	throws net.rim.sdk.cls_a, IOException
    {
        z_fe = e1;
        z_hm._nvV();
        net.rim.sdk.rc.pkg_a.ResourceBundleParser g1 = new net.rim.sdk.rc.pkg_a.ResourceBundleParser(s + ".rrc", z_nullLocale, e1);
        g1._aReaderV(reader);
        g1._aeV(e1);
    }

    private void _aReaderV(Reader reader, net.rim.sdk.rc.cls_e e1)
	throws net.rim.sdk.cls_a, IOException
    {
        z_fe = e1;
        z_hm._aReaderV(reader);
        z_hm._aeV(e1);
        z_fe._aHashtableV(z_hm._bytevHashtable());
    }

    private void _aVectorV(Vector vector)
	throws net.rim.sdk.cls_a, IOException
    {
        _forvV();
        z_hm._nvV();
        net.rim.sdk.rc.cls_e e1 = z_fe;
        net.rim.sdk.rc.pkg_a.ResourceBundleParser g1 = new net.rim.sdk.rc.pkg_a.ResourceBundleParser(z_voidString + ".rrc", z_nullLocale, e1);
        g1._lvV();
        net.rim.sdk.rc.cls_d d1 = new net.rim.sdk.rc.cls_d(this, vector);
        d1._aeV(e1, z_nullLocale);
    }

    private void _ifVectorV(Vector vector)
	throws net.rim.sdk.cls_a, IOException
    {
        z_hm._nvV();
        net.rim.sdk.rc.cls_h h1 = new net.rim.sdk.rc.cls_h(vector);
        h1._aeV(z_fe);
    }

    public String _ifvString()
    {
        return z_jString;
    }

    public static void _aaStringV(String as[])
    {
        if(as.length == 0)
        {
            System.out.println("Usage:");
            System.out.println("    java net.rim.sdk.rc.ResourceCompiler <input>");
            System.out.println("");
            System.out.println("        The output is in the same directory as the input.");
            System.out.println("        The package can either be separated by '.' or '/' or '\\\\'.");
            return;
        }
        String s = as[0];
        boolean flag = true;
        Hashtable hashtable = new Hashtable();
        for(int j = 0; j < as.length; j++)
            if(as[j].equalsIgnoreCase("resource_compress"))
                hashtable.put("resource_compress", "1");
            else
            if(as[j].equalsIgnoreCase("cr"))
                hashtable.put("cr", "1");
            else
            if(as[j].equalsIgnoreCase("verbose"))
                hashtable.put("verbose", "1");

        try
        {
            _aStringSZ(s, "", hashtable);
        }
        catch(net.rim.sdk.cls_a a1)
        {
            System.out.println(a1);
            a1.printStackTrace();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception);
            ioexception.printStackTrace();
        }
    }

    private Locale _aLocaleLocale(Locale locale)
    {
        String s = locale.getLanguage();
        String s1 = locale.getCountry();
        String s2 = locale.getVariant();
        if(s2 != null && s2.length() != 0)
            s2 = "";
        else
        if(s1 != null && s1.length() != 0)
            s1 = "";
        else
        if(s != null && s.length() != 0)
            s = "";
        return new Locale(s, s1, s2);
    }

    private void _forvV()
        throws IOException
    {
        if(z_nullLocale.toString().length() != 0)
        {
            String s = _aLocaleLocale(z_nullLocale).toString();
            if(s.length() != 0)
                s = "_" + s;
            String s1 = _ifvString() + s + ".rrc";
            File file = new File(s1);
            if(!file.exists())
                throw new IOException("File not found: " + s1);
        }
    }
}
