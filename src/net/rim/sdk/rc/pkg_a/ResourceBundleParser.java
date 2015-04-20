// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc.pkg_a;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;
import net.rim.sdk.cls_a;
import net.rim.sdk.rc.cls_b;
import net.rim.sdk.rc.cls_e;
import net.rim.sdk.rc.cls_k;

// Referenced classes of package net.rim.a.a.a:
//            d, a, f, h,
//            b, i

public class ResourceBundleParser
implements net.rim.sdk.rc.pkg_a.i
{
    static final class a
    {

        int z_forI;
        net.rim.sdk.rc.pkg_a.cls_b z_dob;
        int z_aI;
        net.rim.sdk.rc.pkg_a.g$a z_ifg$a;

        a()
        {
        }
    }


    private net.rim.sdk.rc.cls_e z_aXe;
    private String z_aMString;
    private Locale z_aKLocale;
    private Vector z_a9Vector;
    private boolean z_aRZ;
    private static final int z_a1I = 0;
    private static final int z_aHI = 1;
    private int z_bbI;
    private static final boolean z_a8Z = false;
    public net.rim.sdk.rc.pkg_a.h z_aYh;
    net.rim.sdk.rc.pkg_a.f z_a0f;
    public net.rim.sdk.rc.pkg_a.cls_b z_aSb;
    public net.rim.sdk.rc.pkg_a.cls_b z_a7b;
    private int z_a3I;
    private net.rim.sdk.rc.pkg_a.cls_b z_aWb;
    private net.rim.sdk.rc.pkg_a.cls_b z_aOb;
    private int z_aVI;
    public boolean z_bcZ;
    private boolean z_aUZ;
    private int z_a2I;
    private final int z_aQaI[];
    private final int z_aNaI[] = {
        0x20000000, 0x10000000, 0x10000000
    };
    private final int z_aLaI[] = {
        0, 0, 4
    };
    private final int z_aJaI[] = {
        0, 0, 0
    };
    private final net.rim.sdk.rc.pkg_a.g$a z_baag$a[];
    private boolean z_a4Z;
    private int z_a5I;
    private Vector z_aTVector;
    private int z_aZaI[];
    private int z_aII;
    private int z_a6aI[];
    private int z_aPI;

    public ResourceBundleParser(String s, Locale locale, net.rim.sdk.rc.cls_e e1)
        throws IOException
    {
        this(((InputStream) (new FileInputStream(s))));
        if(s == null || e1 == null)
        {
            throw new IllegalArgumentException("Values null! File Name:" + (s == null) + " collection:" + (e1 == null));
        } else
        {
            z_aXe = e1;
            z_aKLocale = locale;
            z_aMString = s;
            return;
        }
    }

    private static void _aStringV(String s)
    {
    }

    private void _gvV()
    {
        z_a9Vector.clear();
    }

    private void _ifStringV(String s)
    {
        z_a9Vector.add(s);
    }

    private Vector _evVector()
    {
        return (Vector)z_a9Vector.clone();
    }

    private String _elsevString()
    {
        if(z_a9Vector.size() < 1)
            return null;
        else
            return (String)z_a9Vector.elementAt(0);
    }

    private void _forIV(int j)
    {
        z_bbI = j;
    }

    private boolean _longvZ()
    {
        return z_bbI == 0;
    }

    public void _aeV(net.rim.sdk.rc.cls_e e1)
        throws net.rim.sdk.cls_a
    {
        z_aXe = e1;
        _lvV();
    }

    public void _lvV()
        throws net.rim.sdk.cls_a
    {
        try
        {
            _kvV();
        }
        catch(d d1)
        {
            int j = z_aSb.z_ifb.z_aI;
            int l = z_aSb.z_ifb.z_intI;
            _aIIV(j, l, d1.getMessage());
        }
        catch(net.rim.sdk.rc.pkg_a.cls_a a1)
        {
            int i1 = z_aSb.z_aI;
            int j1 = z_aSb.z_intI;
            _aIIV(i1, j1, a1.getMessage());
        }
    }

    private void _aIIV(int j, int l, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(_aStringIStringString(z_aMString, j, l - 1, s));
    }

    private String _aStringIStringString(String s, int j, int l, String s1)
    {
        return s + ":" + j + "," + (l - 1) + ": error: " + s1;
    }

    private void _abV(net.rim.sdk.rc.pkg_a.cls_b b1, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(z_aMString + ":" + b1.z_aI + "," + (b1.z_intI - 1) + ": error: " + s + ' ' + '"' + b1.toString() + '"');
    }

    public static void _aaStringV(String as[])
        throws net.rim.sdk.cls_a
    {
        net.rim.sdk.rc.pkg_a.ResourceBundleParser _resourceBundleParser_;
        if(as.length == 0)
            _resourceBundleParser_ = new net.rim.sdk.rc.pkg_a.ResourceBundleParser(System.in);
        else
        if(as.length == 1)
        {
            try
            {
                _resourceBundleParser_ = new net.rim.sdk.rc.pkg_a.ResourceBundleParser(new FileInputStream(as[0]));
            }
            catch(FileNotFoundException filenotfoundexception)
            {
                System.out.println("File " + as[0] + " not found.");
                return;
            }
        } else
        {
            System.out.println("RIM Resource Bundle Parser Version 1.0 usage:");
            System.out.println("         java ResourceBundleParser < inputfile");
            System.out.println("OR");
            System.out.println("         java ResourceBundleParser inputfile");
            return;
        }
        try
        {
            _resourceBundleParser_._kvV();
            System.out.println("Resource Bundle Parser Version 1.0: Resource bundle parsed successfully.");
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
            System.out.println("Resource Bundle Parser Version 1.0: Encountered errors during parse.");
            throw new net.rim.sdk.cls_a(exception.getMessage());
        }
    }

    public final void _kvV()
	throws net.rim.sdk.rc.pkg_a.d, net.rim.sdk.cls_a
    {
label0:
        do
            switch(z_a3I != -1 ? z_a3I : _jvI())
            {
            default:
                z_aQaI[0] = z_a2I;
                break label0;

            case 29: // '\035'
                _ivV();
                break;
            }
        while(true);
        _newIb(0);
    }

    public final void _ivV()
	throws net.rim.sdk.rc.pkg_a.d, net.rim.sdk.cls_a
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = _newIb(29);
        _newIb(74);
        net.rim.sdk.rc.pkg_a.cls_b b2 = _newIb(21);
        _newIb(41);
        _bvb();
        _newIb(38);
        String s = b1.toString();
        String s1 = b2.toString();
        if(s1.startsWith("0x") || s1.startsWith("0X"))
            s1 = s1.substring(2, s1.length());
        else
        if(s1.startsWith("-0x") || s1.startsWith("-0X"))
            s1 = "-" + s1.substring(3, s1.length());
        long l = 0L;
        try
        {
            l = Long.parseLong(s1, 16);
        }
        catch(NumberFormatException numberformatexception)
        {
            numberformatexception.printStackTrace();
        }
        net.rim.sdk.rc.pkg_a.cls_b b3 = b1.z_tryb;
        if(b3 != null)
            for(; b3.z_tryb != null; b3 = b3.z_tryb);
        net.rim.sdk.rc.cls_k k1 = new net.rim.sdk.rc.cls_k();
        k1._ifStringV(s);
        k1._aJV(l);
        if(_longvZ())
            k1._aObjectV(_elsevString());
        else
            k1._aObjectV(_evVector());
        k1._aLocaleV(z_aKLocale);
        StringBuffer stringbuffer = new StringBuffer();
        for(; b3 != null; b3 = b3.z_ifb)
            stringbuffer.append(b3.toString());

        k1._aStringV(stringbuffer.toString());
        if(z_aXe != null)
            try
            {
                z_aXe._akV(k1);
            }
            catch(net.rim.sdk.cls_a a1)
            {
                int j = b1.z_aI;
                int i1 = b1.z_intI;
                System.out.println(_aStringIStringString(z_aMString, j, i1, a1.toString()));
            }
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _bvb()
	throws net.rim.sdk.rc.pkg_a.d
    {
        _gvV();
        switch(z_a3I != -1 ? z_a3I : _jvI())
        {
        case 34: // '"'
            net.rim.sdk.rc.pkg_a.cls_b b1 = _newIb(34);
            for(; _byteIZ(2); _cvb());
            switch(z_a3I != -1 ? z_a3I : _jvI())
            {
            case 28: // '\034'
                _casevb();
                break;

            default:
                z_aQaI[1] = z_a2I;
                break;
            }
            _newIb(35);
            _forIV(1);
            return b1;

        case 28: // '\034'
            net.rim.sdk.rc.pkg_a.cls_b b2 = _casevb();
            _forIV(0);
            return b2;
        }
        z_aQaI[2] = z_a2I;
        _newIb(-1);
        throw new net.rim.sdk.rc.pkg_a.d();
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _cvb()
	throws net.rim.sdk.rc.pkg_a.d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = _casevb();
        _newIb(39);
        return b1;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _casevb()
	throws net.rim.sdk.rc.pkg_a.d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        b1 = _newIb(28);
        _ifStringV(cls_b._intStringString(b1.z_newString));
        return b1;
    }

    private final boolean _byteIZ(int j)
    {
        z_aVI = j;
        z_aOb = z_aWb = z_aSb;
        boolean flag = !_charvZ();
        _byteIIV(0, j);
        return flag;
    }

    private final boolean _voidvZ()
    {
        if(_tryIZ(28))
            return true;
        return z_aVI != 0 || z_aWb != z_aOb ? false : false;
    }

    private final boolean _bytevZ()
    {
        if(_voidvZ())
            return true;
        if(z_aVI == 0 && z_aWb == z_aOb)
            return false;
        if(_tryIZ(39))
            return true;
        return z_aVI != 0 || z_aWb != z_aOb ? false : false;
    }

    private final boolean _charvZ()
    {
        if(_bytevZ())
            return true;
        return z_aVI != 0 || z_aWb != z_aOb ? false : false;
    }

    public ResourceBundleParser(InputStream inputstream)
    {
        z_a9Vector = new Vector();
        z_aRZ = false;
        z_bcZ = false;
        z_aQaI = new int[3];
        z_baag$a = new net.rim.sdk.rc.pkg_a.g$a[1];
        z_a4Z = false;
        z_a5I = 0;
        z_aTVector = new Vector();
        z_aII = -1;
        z_a6aI = new int[100];
        z_a0f = new f(inputstream, 1, 1);
        z_aYh = new h(z_a0f);
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    public void _aInputStreamV(InputStream inputstream)
    {
        z_a0f._aInputStreamIV(inputstream, 1, 1);
        z_aYh._afV(z_a0f);
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    public ResourceBundleParser(Reader reader)
    {
        z_a9Vector = new Vector();
        z_aRZ = false;
        z_bcZ = false;
        z_aQaI = new int[3];
        z_baag$a = new net.rim.sdk.rc.pkg_a.g$a[1];
        z_a4Z = false;
        z_a5I = 0;
        z_aTVector = new Vector();
        z_aII = -1;
        z_a6aI = new int[100];
        z_a0f = new net.rim.sdk.rc.pkg_a.f(reader, 1, 1);
        z_aYh = new net.rim.sdk.rc.pkg_a.h(z_a0f);
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    public void _aReaderV(Reader reader)
    {
        z_a0f._aReaderIV(reader, 1, 1);
        z_aYh._afV(z_a0f);
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    public ResourceBundleParser(net.rim.sdk.rc.pkg_a.h h1)
    {
        z_a9Vector = new Vector();
        z_aRZ = false;
        z_bcZ = false;
        z_aQaI = new int[3];
        z_baag$a = new net.rim.sdk.rc.pkg_a.g$a[1];
        z_a4Z = false;
        z_a5I = 0;
        z_aTVector = new Vector();
        z_aII = -1;
        z_a6aI = new int[100];
        z_aYh = h1;
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    public void _ahV(net.rim.sdk.rc.pkg_a.h h1)
    {
        z_aYh = h1;
        z_aSb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a3I = -1;
        z_a2I = 0;
        for(int j = 0; j < 3; j++)
            z_aQaI[j] = -1;

        for(int l = 0; l < z_baag$a.length; l++)
            z_baag$a[l] = new net.rim.sdk.rc.pkg_a.g$a();

    }

    private final net.rim.sdk.rc.pkg_a.cls_b _newIb(int j)
	throws net.rim.sdk.rc.pkg_a.d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1;
        if((b1 = z_aSb).z_ifb != null)
            z_aSb = z_aSb.z_ifb;
        else
            z_aSb = z_aSb.z_ifb = z_aYh._ifvb();
        z_a3I = -1;
        if(z_aSb.z_doI == j)
        {
            z_a2I++;
            if(++z_a5I > 100)
            {
                z_a5I = 0;
                for(int l = 0; l < z_baag$a.length; l++)
                {
                    for(net.rim.sdk.rc.pkg_a.g$a a1 = z_baag$a[l]; a1 != null; a1 = a1.z_ifg$a)
                        if(a1.z_forI < z_a2I)
                            a1.z_dob = null;

                }

            }
            return z_aSb;
        } else
        {
            z_aSb = b1;
            z_aII = j;
            throw _hvd();
        }
    }

    private final boolean _tryIZ(int j)
    {
        if(z_aWb == z_aOb)
        {
            z_aVI--;
            if(z_aWb.z_ifb == null)
                z_aOb = z_aWb = z_aWb.z_ifb = z_aYh._ifvb();
            else
                z_aOb = z_aWb = z_aWb.z_ifb;
        } else
        {
            z_aWb = z_aWb.z_ifb;
        }
        if(z_a4Z)
        {
            int l = 0;
            net.rim.sdk.rc.pkg_a.cls_b b1;
            for(b1 = z_aSb; b1 != null && b1 != z_aWb; b1 = b1.z_ifb)
                l++;

            if(b1 != null)
                _tryIIV(j, l);
        }
        return z_aWb.z_doI != j;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _gotovb()
    {
        if(z_aSb.z_ifb != null)
            z_aSb = z_aSb.z_ifb;
        else
            z_aSb = z_aSb.z_ifb = z_aYh._ifvb();
        z_a3I = -1;
        z_a2I++;
        return z_aSb;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _intIb(int j)
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = z_bcZ ? z_aWb : z_aSb;
        for(int l = 0; l < j; l++)
            if(b1.z_ifb != null)
                b1 = b1.z_ifb;
            else
                b1 = b1.z_ifb = z_aYh._ifvb();

        return b1;
    }

    private final int _jvI()
    {
        if((z_a7b = z_aSb.z_ifb) == null)
            return z_a3I = (z_aSb.z_ifb = z_aYh._ifvb()).z_doI;
        else
            return z_a3I = z_a7b.z_doI;
    }

    private void _tryIIV(int j, int l)
    {
        if(l >= 100)
            return;
        if(l == z_aPI + 1)
            z_a6aI[z_aPI++] = j;
        else
        if(z_aPI != 0)
        {
            z_aZaI = new int[z_aPI];
            for(int i1 = 0; i1 < z_aPI; i1++)
                z_aZaI[i1] = z_a6aI[i1];

            boolean flag = false;
            Enumeration enumeration = z_aTVector.elements();
            while(enumeration.hasMoreElements())
            {
                int ai[] = (int[])enumeration.nextElement();
                if(ai.length != z_aZaI.length)
                    continue;
                flag = true;
                for(int j1 = 0; j1 < z_aZaI.length; j1++)
                {
                    if(ai[j1] == z_aZaI[j1])
                        continue;
                    flag = false;
                    break;
                }

                if(flag)
                    break;
            }
            if(!flag)
                z_aTVector.addElement(z_aZaI);
            if(l != 0)
                z_a6aI[(z_aPI = l) - 1] = j;
        }
    }

    public final net.rim.sdk.rc.pkg_a.d _hvd()
    {
        z_aTVector.removeAllElements();
        boolean aflag[] = new boolean[75];
        for(int j = 0; j < 75; j++)
            aflag[j] = false;

        if(z_aII >= 0)
        {
            aflag[z_aII] = true;
            z_aII = -1;
        }
        for(int l = 0; l < 3; l++)
            if(z_aQaI[l] == z_a2I)
            {
                for(int i1 = 0; i1 < 32; i1++)
                {
                    if((z_aNaI[l] & 1 << i1) != 0)
                        aflag[i1] = true;
                    if((z_aLaI[l] & 1 << i1) != 0)
                        aflag[32 + i1] = true;
                    if((z_aJaI[l] & 1 << i1) != 0)
                        aflag[64 + i1] = true;
                }

            }

        for(int j1 = 0; j1 < 75; j1++)
            if(aflag[j1])
            {
                z_aZaI = new int[1];
                z_aZaI[0] = j1;
                z_aTVector.addElement(z_aZaI);
            }

        z_aPI = 0;
        _dvV();
        _tryIIV(0, 0);
        int ai[][] = new int[z_aTVector.size()][];
        for(int k1 = 0; k1 < z_aTVector.size(); k1++)
            ai[k1] = (int[])z_aTVector.elementAt(k1);

        return new net.rim.sdk.rc.pkg_a.d(z_aSb, ai, i.z_EaString);
    }

    public final void _fvV()
    {
    }

    public final void _nullvV()
    {
    }

    private final void _dvV()
    {
        z_a4Z = true;
        for(int j = 0; j < 1; j++)
        {
            net.rim.sdk.rc.pkg_a.g$a a1 = z_baag$a[j];
            do
            {
                if(a1.z_forI > z_a2I)
                {
                    z_aVI = a1.z_aI;
                    z_aOb = z_aWb = a1.z_dob;
                    switch(j)
                    {
                    case 0: // '\0'
                        _charvZ();
                        break;
                    }
                }
                a1 = a1.z_ifg$a;
            } while(a1 != null);
        }

        z_a4Z = false;
    }

    private final void _byteIIV(int j, int l)
    {
        net.rim.sdk.rc.pkg_a.g$a a1;
        for(a1 = z_baag$a[j]; a1.z_forI > z_a2I; a1 = a1.z_ifg$a)
        {
            if(a1.z_ifg$a != null)
                continue;
            a1 = a1.z_ifg$a = new net.rim.sdk.rc.pkg_a.g$a();
            break;
        }

        a1.z_forI = (z_a2I + l) - z_aVI;
        a1.z_dob = z_aSb;
        a1.z_aI = l;
    }
}
