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
import java.util.Vector;
import net.rim.sdk.rc.*;
import net.rim.sdk.rc.cls_b;
import net.rim.sdk.rc.cls_c;
import net.rim.sdk.rc.cls_e;
import net.rim.sdk.rc.cls_g;

// Referenced classes of package net.rim.a.a.a:
//            d, a, f, e,
//            b, j

public class ResourceDBParser
implements net.rim.sdk.rc.pkg_a.j
{
    static final class a
    {

        int z_forI;
        net.rim.sdk.rc.pkg_a.cls_b z_dob;
        int z_aI;
        net.rim.sdk.rc.pkg_a.k$a z_ifk$a;

        a()
        {
        }
    }


    private net.rim.sdk.rc.cls_e z_ate;
    private String z_aiString;
    private Vector z_aFVector;
    private boolean z_anZ;
    private static final int z_axI = 0;
    private static final int z_aeI = 1;
    private int z_aHI;
    private static final boolean z_aEZ = false;
    public net.rim.sdk.rc.pkg_a.cls_e z_aue;
    net.rim.sdk.rc.pkg_a.f z_awf;
    public net.rim.sdk.rc.pkg_a.cls_b z_aob;
    public net.rim.sdk.rc.pkg_a.cls_b z_aDb;
    private int z_azI;
    private net.rim.sdk.rc.pkg_a.cls_b z_asb;
    private net.rim.sdk.rc.pkg_a.cls_b z_akb;
    private int z_arI;
    public boolean z_aIZ;
    private boolean z_aqZ;
    private int z_ayI;
    private final int z_amaI[];
    private final int z_ajaI[] = {
        0x20000000, 0x10000000, 0x10000000, 0x20000000
    };
    private final int z_ahaI[] = {
        0, 0, 4, 0
    };
    private final int z_agaI[] = {
        1024, 0, 0, 1024
    };
    private final net.rim.sdk.rc.pkg_a.k$a z_aGak$a[];
    private boolean z_aAZ;
    private int z_aBI;
    private Vector z_apVector;
    private int z_avaI[];
    private int z_afI;
    private int z_aCaI[];
    private int z_alI;

    public ResourceDBParser(String s, net.rim.sdk.rc.cls_e e1)
        throws IOException
    {
        this(((InputStream) (new FileInputStream(s))));
        if(s == null || e1 == null)
        {
            throw new IllegalArgumentException("Values null! File Name:" + (s == null) + " collection:" + (e1 == null));
        } else
        {
            z_ate = e1;
            z_aiString = s;
            return;
        }
    }

    private static void _aStringV(String s)
    {
    }

    private void _voidvV()
    {
        z_aFVector.clear();
    }

    private void _ifStringV(String s)
    {
        z_aFVector.add(s);
    }

    private Vector _longvVector()
    {
        return (Vector)z_aFVector.clone();
    }

    private String _intvString()
    {
        if(z_aFVector.size() < 1)
            return null;
        else
            return (String)z_aFVector.elementAt(0);
    }

    private void _aIV(int i)
    {
        z_aHI = i;
    }

    private boolean _tryvZ()
    {
        return z_aHI == 0;
    }

    public void _aeV(net.rim.sdk.rc.cls_e e1)
        throws net.rim.sdk.cls_a
    {
        z_ate = e1;
        _fvV();
    }

    public void _fvV()
        throws net.rim.sdk.cls_a
    {
        try
        {
            _evV();
        }
        catch(d d1)
        {
            int i = z_aob.z_ifb.z_aI;
            int l = z_aob.z_ifb.z_intI;
            _aIIV(i, l, d1.getMessage());
        }
        catch(net.rim.sdk.rc.pkg_a.cls_a a1)
        {
            int i1 = z_aob.z_aI;
            int j1 = z_aob.z_intI;
            _aIIV(i1, j1, a1.getMessage());
        }
    }

    private void _aIIV(int i, int l, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(_aStringIStringString(z_aiString, i, l - 1, s));
    }

    private String _aStringIStringString(String s, int i, int l, String s1)
    {
        return s + ":" + i + "," + (l - 1) + ": error: " + s1;
    }

    private void _abV(net.rim.sdk.rc.pkg_a.cls_b b1, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(z_aiString + ":" + b1.z_aI + "," + (b1.z_intI - 1) + ": error: " + s + ' ' + '"' + b1.toString() + '"');
    }

    public static void _aaStringV(String as[])
        throws net.rim.sdk.cls_a
    {
        ResourceDBParser k1;
        if(as.length == 0)
            k1 = new ResourceDBParser(System.in);
        else
        if(as.length == 1)
        {
            try
            {
                k1 = new ResourceDBParser(new FileInputStream(as[0]));
            }
            catch(FileNotFoundException filenotfoundexception)
            {
                System.out.println("File " + as[0] + " not found.");
                return;
            }
        } else
        {
            System.out.println("RIM Resource Bundle Parser Version 1.0 usage:");
            System.out.println("         java ResourceDBParser < inputfile");
            System.out.println("OR");
            System.out.println("         java ResourceDBParser inputfile");
            return;
        }
        try
        {
            k1._evV();
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

    public final void _evV()
	throws net.rim.sdk.rc.pkg_a.d, net.rim.sdk.cls_a
    {
label0:
        do
            switch(z_azI != -1 ? z_azI : _dvI())
            {
            default:
                z_amaI[0] = z_ayI;
                break label0;

            case 29: // '\035'
            case 74: // 'J'
                _cvV();
                break;
            }
        while(true);
        _doIb(0);
    }

    public final void _cvV()
        throws d, net.rim.sdk.cls_a
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = _ifvb();
        net.rim.sdk.rc.pkg_a.cls_b b2 = _doIb(29);
        _doIb(74);
        net.rim.sdk.rc.pkg_a.cls_b b3 = _doIb(29);
        _doIb(74);
        net.rim.sdk.rc.pkg_a.cls_b b4 = _doIb(21);
        _doIb(41);
        _charvb();
        _doIb(38);
        String s = b3.toString();
        String s1 = b1 != null ? b1.toString() : "";
        String s2 = b4.toString();
        if(s2.startsWith("0x") || s2.startsWith("0X"))
            s2 = s2.substring(2, s2.length());
        else
        if(s2.startsWith("-0x") || s2.startsWith("-0X"))
            s2 = "-" + s2.substring(3, s2.length());
        long l = 0L;
        try
        {
            l = Long.parseLong(s2, 16);
        }
        catch(NumberFormatException numberformatexception)
        {
            numberformatexception.printStackTrace();
        }
        net.rim.sdk.rc.pkg_a.cls_b b5 = b3.z_tryb;
        if(b5 != null)
            for(; b5.z_tryb != null; b5 = b5.z_tryb);
        cls_c c1 = new cls_c();
        c1._ifStringV(s);
        c1._aJV(l);
        if(_tryvZ())
            c1._aObjectV(_intvString());
        else
            c1._aObjectV(_longvVector());
        c1._aLocaleV(cls_b._aStringLocale(s1));
        c1._forStringV(b2.toString());
        StringBuffer stringbuffer = new StringBuffer();
        for(; b5 != null; b5 = b5.z_ifb)
            stringbuffer.append(b5.toString());

        c1._aStringV(stringbuffer.toString());
        if(z_ate != null)
            z_ate._acV(c1);
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _charvb()
        throws d
    {
        _voidvV();
        switch(z_azI != -1 ? z_azI : _dvI())
        {
        case 34: // '"'
			net.rim.sdk.rc.pkg_a.cls_b b1 = _doIb(34);
            for(; _intIZ(2); _gotovb());
            switch(z_azI != -1 ? z_azI : _dvI())
            {
            case 28: // '\034'
                _dovb();
                break;

            default:
                z_amaI[1] = z_ayI;
                break;
            }
            _doIb(35);
            _aIV(1);
            return b1;

        case 28: // '\034'
				net.rim.sdk.rc.pkg_a.cls_b b2 = _dovb();
            _aIV(0);
            return b2;
        }
        z_amaI[2] = z_ayI;
        _doIb(-1);
        throw new d();
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _gotovb()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = _dovb();
        _doIb(39);
        return b1;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _dovb()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        b1 = _doIb(28);
        _ifStringV(cls_b._intStringString(b1.z_newString));
        return b1;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _ifvb()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        switch(z_azI != -1 ? z_azI : _dvI())
        {
        case 29: // '\035'
            b1 = _doIb(29);
            _doIb(74);
            return b1;

        case 74: // 'J'
            _doIb(74);
            return b1;
        }
        z_amaI[3] = z_ayI;
        _doIb(-1);
        throw new d();
    }

    private final boolean _intIZ(int i)
    {
        z_arI = i;
        z_akb = z_asb = z_aob;
        boolean flag = !_forvZ();
        _ifIIV(0, i);
        return flag;
    }

    private final boolean _forvZ()
    {
        if(_avZ())
            return true;
        return z_arI != 0 || z_asb != z_akb ? false : false;
    }

    private final boolean _casevZ()
    {
        if(_forIZ(28))
            return true;
        return z_arI != 0 || z_asb != z_akb ? false : false;
    }

    private final boolean _avZ()
    {
        if(_casevZ())
            return true;
        if(z_arI == 0 && z_asb == z_akb)
            return false;
        if(_forIZ(39))
            return true;
        return z_arI != 0 || z_asb != z_akb ? false : false;
    }

    public ResourceDBParser(InputStream inputstream)
    {
        z_aFVector = new Vector();
        z_anZ = false;
        z_aIZ = false;
        z_amaI = new int[4];
        z_aGak$a = new net.rim.sdk.rc.pkg_a.k$a[1];
        z_aAZ = false;
        z_aBI = 0;
        z_apVector = new Vector();
        z_afI = -1;
        z_aCaI = new int[100];
        z_awf = new f(inputstream, 1, 1);
        z_aue = new net.rim.sdk.rc.pkg_a.cls_e(z_awf);
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    public void _aInputStreamV(InputStream inputstream)
    {
        z_awf._aInputStreamIV(inputstream, 1, 1);
        z_aue._afV(z_awf);
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    public ResourceDBParser(Reader reader)
    {
        z_aFVector = new Vector();
        z_anZ = false;
        z_aIZ = false;
        z_amaI = new int[4];
        z_aGak$a = new net.rim.sdk.rc.pkg_a.k$a[1];
        z_aAZ = false;
        z_aBI = 0;
        z_apVector = new Vector();
        z_afI = -1;
        z_aCaI = new int[100];
        z_awf = new net.rim.sdk.rc.pkg_a.f(reader, 1, 1);
        z_aue = new net.rim.sdk.rc.pkg_a.cls_e(z_awf);
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    public void _aReaderV(Reader reader)
    {
        z_awf._aReaderIV(reader, 1, 1);
        z_aue._afV(z_awf);
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    public ResourceDBParser(net.rim.sdk.rc.pkg_a.cls_e e1)
    {
        z_aFVector = new Vector();
        z_anZ = false;
        z_aIZ = false;
        z_amaI = new int[4];
        z_aGak$a = new net.rim.sdk.rc.pkg_a.k$a[1];
        z_aAZ = false;
        z_aBI = 0;
        z_apVector = new Vector();
        z_afI = -1;
        z_aCaI = new int[100];
        z_aue = e1;
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    public void _aeV(net.rim.sdk.rc.pkg_a.cls_e e1)
    {
        z_aue = e1;
        z_aob = new net.rim.sdk.rc.pkg_a.cls_b();
        z_azI = -1;
        z_ayI = 0;
        for(int i = 0; i < 4; i++)
            z_amaI[i] = -1;

        for(int l = 0; l < z_aGak$a.length; l++)
            z_aGak$a[l] = new net.rim.sdk.rc.pkg_a.k$a();

    }

    private final net.rim.sdk.rc.pkg_a.cls_b _doIb(int i)
	throws net.rim.sdk.rc.pkg_a.d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1;
        if((b1 = z_aob).z_ifb != null)
            z_aob = z_aob.z_ifb;
        else
            z_aob = z_aob.z_ifb = z_aue._hvb();
        z_azI = -1;
        if(z_aob.z_doI == i)
        {
            z_ayI++;
            if(++z_aBI > 100)
            {
                z_aBI = 0;
                for(int l = 0; l < z_aGak$a.length; l++)
                {
                    for(net.rim.sdk.rc.pkg_a.k$a a1 = z_aGak$a[l]; a1 != null; a1 = a1.z_ifk$a)
                        if(a1.z_forI < z_ayI)
                            a1.z_dob = null;

                }

            }
            return z_aob;
        } else
        {
            z_aob = b1;
            z_afI = i;
            throw _bvd();
        }
    }

    private final boolean _forIZ(int i)
    {
        if(z_asb == z_akb)
        {
            z_arI--;
            if(z_asb.z_ifb == null)
                z_akb = z_asb = z_asb.z_ifb = z_aue._hvb();
            else
                z_akb = z_asb = z_asb.z_ifb;
        } else
        {
            z_asb = z_asb.z_ifb;
        }
        if(z_aAZ)
        {
            int l = 0;
            net.rim.sdk.rc.pkg_a.cls_b b1;
            for(b1 = z_aob; b1 != null && b1 != z_asb; b1 = b1.z_ifb)
                l++;

            if(b1 != null)
                _aIIV(i, l);
        }
        return z_asb.z_doI != i;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _newvb()
    {
        if(z_aob.z_ifb != null)
            z_aob = z_aob.z_ifb;
        else
            z_aob = z_aob.z_ifb = z_aue._hvb();
        z_azI = -1;
        z_ayI++;
        return z_aob;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _ifIb(int i)
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = z_aIZ ? z_asb : z_aob;
        for(int l = 0; l < i; l++)
            if(b1.z_ifb != null)
                b1 = b1.z_ifb;
            else
                b1 = b1.z_ifb = z_aue._hvb();

        return b1;
    }

    private final int _dvI()
    {
        if((z_aDb = z_aob.z_ifb) == null)
            return z_azI = (z_aob.z_ifb = z_aue._hvb()).z_doI;
        else
            return z_azI = z_aDb.z_doI;
    }

    private void _aIIV(int i, int l)
    {
        if(l >= 100)
            return;
        if(l == z_alI + 1)
            z_aCaI[z_alI++] = i;
        else
        if(z_alI != 0)
        {
            z_avaI = new int[z_alI];
            for(int i1 = 0; i1 < z_alI; i1++)
                z_avaI[i1] = z_aCaI[i1];

            boolean flag = false;
            Enumeration enumeration = z_apVector.elements();
            while(enumeration.hasMoreElements())
            {
                int ai[] = (int[])enumeration.nextElement();
                if(ai.length != z_avaI.length)
                    continue;
                flag = true;
                for(int j1 = 0; j1 < z_avaI.length; j1++)
                {
                    if(ai[j1] == z_avaI[j1])
                        continue;
                    flag = false;
                    break;
                }

                if(flag)
                    break;
            }
            if(!flag)
                z_apVector.addElement(z_avaI);
            if(l != 0)
                z_aCaI[(z_alI = l) - 1] = i;
        }
    }

    public final d _bvd()
    {
        z_apVector.removeAllElements();
        boolean aflag[] = new boolean[75];
        for(int i = 0; i < 75; i++)
            aflag[i] = false;

        if(z_afI >= 0)
        {
            aflag[z_afI] = true;
            z_afI = -1;
        }
        for(int l = 0; l < 4; l++)
            if(z_amaI[l] == z_ayI)
            {
                for(int i1 = 0; i1 < 32; i1++)
                {
                    if((z_ajaI[l] & 1 << i1) != 0)
                        aflag[i1] = true;
                    if((z_ahaI[l] & 1 << i1) != 0)
                        aflag[32 + i1] = true;
                    if((z_agaI[l] & 1 << i1) != 0)
                        aflag[64 + i1] = true;
                }

            }

        for(int j1 = 0; j1 < 75; j1++)
            if(aflag[j1])
            {
                z_avaI = new int[1];
                z_avaI[0] = j1;
                z_apVector.addElement(z_avaI);
            }

        z_alI = 0;
        _elsevV();
        _aIIV(0, 0);
        int ai[][] = new int[z_apVector.size()][];
        for(int k1 = 0; k1 < z_apVector.size(); k1++)
            ai[k1] = (int[])z_apVector.elementAt(k1);

        return new net.rim.sdk.rc.pkg_a.d(z_aob, ai, j.z_EaString);
    }

    public final void _nullvV()
    {
    }

    public final void _bytevV()
    {
    }

    private final void _elsevV()
    {
        z_aAZ = true;
        for(int i = 0; i < 1; i++)
        {
            net.rim.sdk.rc.pkg_a.k$a a1 = z_aGak$a[i];
            do
            {
                if(a1.z_forI > z_ayI)
                {
                    z_arI = a1.z_aI;
                    z_akb = z_asb = a1.z_dob;
                    switch(i)
                    {
                    case 0: // '\0'
                        _forvZ();
                        break;
                    }
                }
                a1 = a1.z_ifk$a;
            } while(a1 != null);
        }

        z_aAZ = false;
    }

    private final void _ifIIV(int i, int l)
    {
        net.rim.sdk.rc.pkg_a.k$a a1;
        for(a1 = z_aGak$a[i]; a1.z_forI > z_ayI; a1 = a1.z_ifk$a)
        {
            if(a1.z_ifk$a != null)
                continue;
            a1 = a1.z_ifk$a = new net.rim.sdk.rc.pkg_a.k$a();
            break;
        }

        a1.z_forI = (z_ayI + l) - z_arI;
        a1.z_dob = z_aob;
        a1.z_aI = l;
    }
}
