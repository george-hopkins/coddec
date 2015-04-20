// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc.pkg_a;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.sdk.rc.*;
import net.rim.sdk.rc.cls_b;
import net.rim.sdk.rc.cls_e;
import net.rim.sdk.rc.cls_g;

// Referenced classes of package net.rim.a.a.a:
//            d, f, l, b,
//            c

public class cls_m
    implements cls_c
{
    static final class a
    {

        int z_forI;
        net.rim.sdk.rc.pkg_a.cls_b z_dob;
        int z_aI;
        net.rim.sdk.rc.pkg_a.m$a z_ifm$a;

        a()
        {
        }
    }


    String z_a8String;
    net.rim.sdk.rc.cls_e z_aXe;
    Hashtable z_aSHashtable;
    private static final boolean z_a7Z = false;
    public l z_aYl;
    f z_a0f;
    public net.rim.sdk.rc.pkg_a.cls_b z_aRb;
    public net.rim.sdk.rc.pkg_a.cls_b z_a6b;
    private int z_a2I;
    private net.rim.sdk.rc.pkg_a.cls_b z_aWb;
    private net.rim.sdk.rc.pkg_a.cls_b z_aOb;
    private int z_aUI;
    public boolean z_baZ;
    private boolean z_aVZ;
    private int z_a1I;
    private final int z_aQaI[];
    private final int z_aNaI[] = {
        0x4000000, 0x8000000, 0x10000000, 0, 0, 0x2072e000, 0, 0x2072e000
    };
    private final int z_aMaI[] = {
        0, 0, 0, 256, 256, 256, 32768, 0
    };
    private final int z_aLaI[] = {
        0, 0, 0, 0, 0, 0, 0, 0
    };
    private final net.rim.sdk.rc.pkg_a.m$a z_a9am$a[];
    private boolean z_a3Z;
    private int z_a4I;
    private Vector z_aTVector;
    private int z_aZaI[];
    private int z_aKI;
    private int z_a5aI[];
    private int z_aPI;

    public cls_m(String s, net.rim.sdk.rc.cls_e e1)
        throws IOException
    {
        this(((InputStream) (new FileInputStream(s))));
        z_aXe = e1;
        z_a8String = s;
    }

    public cls_m(InputStream inputstream, net.rim.sdk.rc.cls_e e1)
        throws IOException
    {
        this(inputstream);
        z_aXe = e1;
        z_a8String = "STDIN";
    }

    private static void _aStringV(String s)
    {
        System.out.println(s);
    }

    public void _aeV(net.rim.sdk.rc.cls_e e1)
        throws net.rim.sdk.cls_a
    {
        z_aXe = e1;
        _nvV();
    }

    public Hashtable _bytevHashtable()
    {
        return z_aSHashtable;
    }

    public void _nvV()
        throws net.rim.sdk.cls_a
    {
        try
        {
            _mvV();
        }
        catch(d d1)
        {
            int i = z_aRb.z_ifb.z_aI;
            int j = z_aRb.z_ifb.z_intI;
            _aIIV(i, j, d1.getMessage());
        }
    }

    private void _aIIV(int i, int j, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(z_a8String + ":" + i + "," + (j - 1) + ": error: " + s);
    }

    private void _abV(net.rim.sdk.rc.pkg_a.cls_b b1, String s)
        throws net.rim.sdk.cls_a
    {
        throw new net.rim.sdk.cls_a(z_a8String + ":" + b1.z_aI + "," + (b1.z_intI - 1) + ": error: " + s + ' ' + '"' + b1.toString() + '"');
    }

    public static void _aaStringV(String as[])
        throws net.rim.sdk.cls_a
    {
        cls_m m1;
        if(as.length == 0)
            try
            {
                m1 = new cls_m(System.in, new net.rim.sdk.rc.cls_e(""));
            }
            catch(Exception exception)
            {
                System.out.println("Problem reading from STDIN ");
                exception.printStackTrace();
                return;
            }
        else
        if(as.length == 1)
        {
            try
            {
                m1 = new cls_m(as[0], new net.rim.sdk.rc.cls_e(""));
            }
            catch(Exception exception1)
            {
                System.out.println("File " + as[0] + " not found.");
                exception1.printStackTrace();
                return;
            }
        } else
        {
            System.out.println("RIM Resource Header Parser Version 1.0 usage:");
            System.out.println("         java ResourceHeaderParser < inputfile");
            System.out.println("OR");
            System.out.println("         java ResourceHeaderParser inputfile");
            return;
        }
        try
        {
            m1._mvV();
            System.out.println("Resource Header Parser Version 1.0: Resource bundle parsed successfully.");
        }
        catch(Exception exception2)
        {
            System.out.println("ERROR: " + exception2.getMessage());
            exception2.printStackTrace();
            System.out.println("Resource Header Parser Version 1.0: Encountered errors during parse.");
            throw new net.rim.sdk.cls_a(exception2.getMessage());
        }
    }

    public final void _mvV()
        throws d, net.rim.sdk.cls_a
    {
        _ovV();
        switch(z_a2I != -1 ? z_a2I : _kvI())
        {
        case 26: // '\032'
            _nullvV();
            break;

        default:
            z_aQaI[0] = z_a1I;
            break;
        }
        switch(z_a2I != -1 ? z_a2I : _kvI())
        {
        case 27: // '\033'
            _evV();
            break;

        default:
            z_aQaI[1] = z_a1I;
            break;
        }
        switch(z_a2I != -1 ? z_a2I : _kvI())
        {
        case 28: // '\034'
            _lvV();
            break;

        default:
            z_aQaI[2] = z_a1I;
            break;
        }
label0:
        do
            switch(z_a2I != -1 ? z_a2I : _kvI())
            {
            default:
                z_aQaI[3] = z_a1I;
                break label0;

            case 40: // '('
                _ivV();
                break;
            }
        while(true);
        _intIb(0);
    }

    public final void _ovV()
        throws d
    {
        _intIb(25);
        String s = _gotovString();
        _intIb(49);
        z_aXe._forStringV(s);
    }

    public final void _evV()
        throws d
    {
        _intIb(27);
        net.rim.sdk.rc.pkg_a.cls_b b1 = _intIb(32);
        _intIb(49);
        String s = b1.toString();
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        catch(NumberFormatException numberformatexception)
        {
            i = 0;
        }
        z_aXe._aIV(i);
    }

    public final void _nullvV()
        throws d
    {
        _intIb(26);
        String s = _jvString();
        _intIb(49);
        z_aXe._ifStringV(s);
    }

    public final String _jvString()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        b1 = _intIb(40);
        return b1.z_newString;
    }

    public final void _lvV()
        throws d
    {
        _intIb(28);
        _intIb(52);
        String s = _bvString();
        _intIb(49);
        z_aXe._newStringV(s);
    }

    public final String _bvString()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        b1 = _intIb(39);
        return cls_b._intStringString(b1.toString());
    }

    public final void _charvV()
        throws d
    {
        _intIb(77);
        z_aSHashtable = _dvHashtable();
        _intIb(78);
        z_aXe._aHashtableV(z_aSHashtable);
    }

    public final Hashtable _dvHashtable()
        throws d
    {
        Hashtable hashtable = new Hashtable();
label0:
        do
            switch(z_a2I != -1 ? z_a2I : _kvI())
            {
            default:
                z_aQaI[4] = z_a1I;
                break label0;

            case 40: // '('
				net.rim.sdk.rc.pkg_a.cls_b b1 = _intIb(40);
                _intIb(52);
				net.rim.sdk.rc.pkg_a.cls_b b2 = _intIb(39);
                _intIb(49);
                hashtable.put(b1.toString(), cls_b._intStringString(b2.toString()));
                break;
            }
        while(true);
        return hashtable;
    }

    public final void _ivV()
        throws d, net.rim.sdk.cls_a
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = _intIb(40);
        _intIb(79);
        net.rim.sdk.rc.pkg_a.cls_b b2 = _intIb(32);
        _intIb(52);
        net.rim.sdk.rc.pkg_a.cls_b b3 = _intIb(32);
        _intIb(49);
        String s = b1.toString();
        int i = Integer.parseInt(b2.toString());
        net.rim.sdk.rc.pkg_a.cls_b b4 = b1.z_tryb;
        if(b4 != null)
            for(; b4.z_tryb != null; b4 = b4.z_tryb);
        String s1 = b3.toString();
        int j = 0;
        try
        {
            if(s1.startsWith("0x"))
                j = Integer.parseInt(s1.substring(2), 16);
            else
                j = Integer.parseInt(s1);
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
            throw new net.rim.sdk.cls_a("Resource id error:" + z_a8String + " " + b1 + "->" + s1);
        }
        net.rim.sdk.rc.cls_a a1 = new net.rim.sdk.rc.cls_a();
        a1._ifStringV(s);
        a1._aIV(i);
        a1._ifIV(j);
        StringBuffer stringbuffer = new StringBuffer();
        for(; b4 != null; b4 = b4.z_ifb)
            stringbuffer.append(b4.toString());

        a1._aStringV(cls_b._ifStringBufferString(stringbuffer));
        if(z_aXe._doStringZ(a1._ifvString()))
            _abV(b1, "Duplicate definition");
        if(z_aXe._ifIZ(a1._casevI()))
            _abV(b3, "Duplicate definition");
        z_aXe._aaV(a1);
    }

    public final void _fvV()
        throws d
    {
        switch(z_a2I != -1 ? z_a2I : _kvI())
        {
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        case 17: // '\021'
        case 20: // '\024'
        case 21: // '\025'
        case 22: // '\026'
        case 29: // '\035'
            _longvV();
            break;

        case 40: // '('
            _gotovString();
            break;

        case 16: // '\020'
        case 18: // '\022'
        case 19: // '\023'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        default:
            z_aQaI[5] = z_a1I;
            _intIb(-1);
            throw new d();
        }
label0:
        do
            switch(z_a2I != -1 ? z_a2I : _kvI())
            {
            default:
                z_aQaI[6] = z_a1I;
                break label0;

            case 47: // '/'
                _intIb(47);
                _intIb(48);
                break;
            }
        while(true);
    }

    public final void _longvV()
        throws d
    {
        switch(z_a2I != -1 ? z_a2I : _kvI())
        {
        case 13: // '\r'
            _intIb(13);
            break;

        case 14: // '\016'
            _intIb(14);
            break;

        case 15: // '\017'
            _intIb(15);
            break;

        case 17: // '\021'
            _intIb(17);
            break;

        case 20: // '\024'
            _intIb(20);
            break;

        case 21: // '\025'
            _intIb(21);
            break;

        case 22: // '\026'
            _intIb(22);
            break;

        case 29: // '\035'
            _intIb(29);
            break;

        case 16: // '\020'
        case 18: // '\022'
        case 19: // '\023'
        case 23: // '\027'
        case 24: // '\030'
        case 25: // '\031'
        case 26: // '\032'
        case 27: // '\033'
        case 28: // '\034'
        default:
            z_aQaI[7] = z_a1I;
            _intIb(-1);
            throw new d();
        }
    }

    public final String _gotovString()
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = null;
        StringBuffer stringbuffer = new StringBuffer();
        b1 = _intIb(40);
        stringbuffer.append(b1.toString());
        net.rim.sdk.rc.pkg_a.cls_b b2;
        for(; _tryIZ(2); stringbuffer.append(b2.toString()))
        {
            _intIb(51);
            b2 = _intIb(40);
            stringbuffer.append(".");
        }

        return stringbuffer.toString();
    }

    private final boolean _tryIZ(int i)
    {
        z_aUI = i;
        z_aOb = z_aWb = z_aRb;
        boolean flag = !_casevZ();
        _byteIIV(0, i);
        return flag;
    }

    private final boolean _casevZ()
    {
        if(_newIZ(51))
            return true;
        if(z_aUI == 0 && z_aWb == z_aOb)
            return false;
        if(_newIZ(40))
            return true;
        return z_aUI != 0 || z_aWb != z_aOb ? false : false;
    }

    public cls_m(InputStream inputstream)
    {
        z_baZ = false;
        z_aQaI = new int[8];
        z_a9am$a = new net.rim.sdk.rc.pkg_a.m$a[1];
        z_a3Z = false;
        z_a4I = 0;
        z_aTVector = new Vector();
        z_aKI = -1;
        z_a5aI = new int[100];
        z_a0f = new f(inputstream, 1, 1);
        z_aYl = new l(z_a0f);
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    public void _aInputStreamV(InputStream inputstream)
    {
        z_a0f._aInputStreamIV(inputstream, 1, 1);
        z_aYl._afV(z_a0f);
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    public cls_m(Reader reader)
    {
        z_baZ = false;
        z_aQaI = new int[8];
        z_a9am$a = new net.rim.sdk.rc.pkg_a.m$a[1];
        z_a3Z = false;
        z_a4I = 0;
        z_aTVector = new Vector();
        z_aKI = -1;
        z_a5aI = new int[100];
        z_a0f = new f(reader, 1, 1);
        z_aYl = new l(z_a0f);
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    public void _aReaderV(Reader reader)
    {
        z_a0f._aReaderIV(reader, 1, 1);
        z_aYl._afV(z_a0f);
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    public cls_m(l l1)
    {
        z_baZ = false;
        z_aQaI = new int[8];
        z_a9am$a = new net.rim.sdk.rc.pkg_a.m$a[1];
        z_a3Z = false;
        z_a4I = 0;
        z_aTVector = new Vector();
        z_aKI = -1;
        z_a5aI = new int[100];
        z_aYl = l1;
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    public void _alV(l l1)
    {
        z_aYl = l1;
        z_aRb = new net.rim.sdk.rc.pkg_a.cls_b();
        z_a2I = -1;
        z_a1I = 0;
        for(int i = 0; i < 8; i++)
            z_aQaI[i] = -1;

        for(int j = 0; j < z_a9am$a.length; j++)
            z_a9am$a[j] = new net.rim.sdk.rc.pkg_a.m$a();

    }

    private final net.rim.sdk.rc.pkg_a.cls_b _intIb(int i)
        throws d
    {
        net.rim.sdk.rc.pkg_a.cls_b b1;
        if((b1 = z_aRb).z_ifb != null)
            z_aRb = z_aRb.z_ifb;
        else
            z_aRb = z_aRb.z_ifb = z_aYl._ifvb();
        z_a2I = -1;
        if(z_aRb.z_doI == i)
        {
            z_a1I++;
            if(++z_a4I > 100)
            {
                z_a4I = 0;
                for(int j = 0; j < z_a9am$a.length; j++)
                {
                    for(net.rim.sdk.rc.pkg_a.m$a a1 = z_a9am$a[j]; a1 != null; a1 = a1.z_ifm$a)
                        if(a1.z_forI < z_a1I)
                            a1.z_dob = null;

                }

            }
            return z_aRb;
        } else
        {
            z_aRb = b1;
            z_aKI = i;
            throw _hvd();
        }
    }

    private final boolean _newIZ(int i)
    {
        if(z_aWb == z_aOb)
        {
            z_aUI--;
            if(z_aWb.z_ifb == null)
                z_aOb = z_aWb = z_aWb.z_ifb = z_aYl._ifvb();
            else
                z_aOb = z_aWb = z_aWb.z_ifb;
        } else
        {
            z_aWb = z_aWb.z_ifb;
        }
        if(z_a3Z)
        {
            int j = 0;
            net.rim.sdk.rc.pkg_a.cls_b b1;
            for(b1 = z_aRb; b1 != null && b1 != z_aWb; b1 = b1.z_ifb)
                j++;

            if(b1 != null)
                _tryIIV(i, j);
        }
        return z_aWb.z_doI != i;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _elsevb()
    {
        if(z_aRb.z_ifb != null)
            z_aRb = z_aRb.z_ifb;
        else
            z_aRb = z_aRb.z_ifb = z_aYl._ifvb();
        z_a2I = -1;
        z_a1I++;
        return z_aRb;
    }

    public final net.rim.sdk.rc.pkg_a.cls_b _forIb(int i)
    {
        net.rim.sdk.rc.pkg_a.cls_b b1 = z_baZ ? z_aWb : z_aRb;
        for(int j = 0; j < i; j++)
            if(b1.z_ifb != null)
                b1 = b1.z_ifb;
            else
                b1 = b1.z_ifb = z_aYl._ifvb();

        return b1;
    }

    private final int _kvI()
    {
        if((z_a6b = z_aRb.z_ifb) == null)
            return z_a2I = (z_aRb.z_ifb = z_aYl._ifvb()).z_doI;
        else
            return z_a2I = z_a6b.z_doI;
    }

    private void _tryIIV(int i, int j)
    {
        if(j >= 100)
            return;
        if(j == z_aPI + 1)
            z_a5aI[z_aPI++] = i;
        else
        if(z_aPI != 0)
        {
            z_aZaI = new int[z_aPI];
            for(int k = 0; k < z_aPI; k++)
                z_aZaI[k] = z_a5aI[k];

            boolean flag = false;
            Enumeration enumeration = z_aTVector.elements();
            while(enumeration.hasMoreElements())
            {
                int ai[] = (int[])enumeration.nextElement();
                if(ai.length != z_aZaI.length)
                    continue;
                flag = true;
                for(int i1 = 0; i1 < z_aZaI.length; i1++)
                {
                    if(ai[i1] == z_aZaI[i1])
                        continue;
                    flag = false;
                    break;
                }

                if(flag)
                    break;
            }
            if(!flag)
                z_aTVector.addElement(z_aZaI);
            if(j != 0)
                z_a5aI[(z_aPI = j) - 1] = i;
        }
    }

    public final d _hvd()
    {
        z_aTVector.removeAllElements();
        boolean aflag[] = new boolean[80];
        for(int i = 0; i < 80; i++)
            aflag[i] = false;

        if(z_aKI >= 0)
        {
            aflag[z_aKI] = true;
            z_aKI = -1;
        }
        for(int j = 0; j < 8; j++)
            if(z_aQaI[j] == z_a1I)
            {
                for(int k = 0; k < 32; k++)
                {
                    if((z_aNaI[j] & 1 << k) != 0)
                        aflag[k] = true;
                    if((z_aMaI[j] & 1 << k) != 0)
                        aflag[32 + k] = true;
                    if((z_aLaI[j] & 1 << k) != 0)
                        aflag[64 + k] = true;
                }

            }

        for(int i1 = 0; i1 < 80; i1++)
            if(aflag[i1])
            {
                z_aZaI = new int[1];
                z_aZaI[0] = i1;
                z_aTVector.addElement(z_aZaI);
            }

        z_aPI = 0;
        _cvV();
        _tryIIV(0, 0);
        int ai[][] = new int[z_aTVector.size()][];
        for(int j1 = 0; j1 < z_aTVector.size(); j1++)
            ai[j1] = (int[])z_aTVector.elementAt(j1);

        return new d(z_aRb, ai, cls_c.z_charaString);
    }

    public final void _gvV()
    {
    }

    public final void _voidvV()
    {
    }

    private final void _cvV()
    {
        z_a3Z = true;
        for(int i = 0; i < 1; i++)
        {
            net.rim.sdk.rc.pkg_a.m$a a1 = z_a9am$a[i];
            do
            {
                if(a1.z_forI > z_a1I)
                {
                    z_aUI = a1.z_aI;
                    z_aOb = z_aWb = a1.z_dob;
                    switch(i)
                    {
                    case 0: // '\0'
                        _casevZ();
                        break;
                    }
                }
                a1 = a1.z_ifm$a;
            } while(a1 != null);
        }

        z_a3Z = false;
    }

    private final void _byteIIV(int i, int j)
    {
        net.rim.sdk.rc.pkg_a.m$a a1;
        for(a1 = z_a9am$a[i]; a1.z_forI > z_a1I; a1 = a1.z_ifm$a)
        {
            if(a1.z_ifm$a != null)
                continue;
            a1 = a1.z_ifm$a = new net.rim.sdk.rc.pkg_a.m$a();
            break;
        }

        a1.z_forI = (z_a1I + j) - z_aUI;
        a1.z_dob = z_aRb;
        a1.z_aI = j;
    }
}
