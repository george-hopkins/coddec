// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            l, i, d, c,
//            k, s, e, f

public class cls_p extends cls_l
{

    private int f_attributesI;
    private int f_offsetI;
    private cls_k z_Bk;
    protected static final int z_AI = 1;
    protected static final int z_yI = 2;

    public cls_p()
    {
    }

    public cls_p(String s1, cls_e e, int j, int i1)
    {
        super(s1, e);
        f_attributesI = j;
        f_offsetI = i1;
    }

    cls_p(DataInputStream datainputstream, cls_f f, cls_k k1)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
        z_Bk = k1;
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_attributesI = datainputstream.readInt();
        f_offsetI = datainputstream.readInt();
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aIStringV(f_attributesI, "attributes");
        d1._aIStringV(f_offsetI, "offset");
    }

    static Vector _aDataInputStreamVector(DataInputStream datainputstream, cls_f f, cls_k k1)
        throws IOException
    {
        int j = datainputstream.readInt();
        Vector vector = new Vector(j);
        for(int i1 = 0; i1 < j; i1++)
        {
            int j1 = datainputstream.readInt();
            Object obj;
            switch(j1)
            {
            case 2: // '\002'
                obj = new cls_i(datainputstream, f, k1);
                break;

            case 1: // '\001'
                obj = new cls_p(datainputstream, f, k1);
                break;

            default:
                throw new IOException("DebugInformation: bad flavour in DebugField.readVector: " + j1);
            }
            vector.addElement(obj);
        }

        return vector;
    }

    static void _adVV(cls_d d1, Vector vector, String s1)
        throws IOException
    {
        int j = vector.size();
        d1._aIStringV(j, "Vector " + s1);
        d1._ifvV();
        for(int i1 = 0; i1 < j; i1++)
        {
            d1._ifStringV(s1 + " element[ " + i1 + " ]");
            d1._ifvV();
            cls_p p1 = (cls_p)vector.elementAt(i1);
            d1._aIStringV(p1._voidvI(), "flavour");
            p1._adV(d1);
            d1._dovV();
        }

        d1._dovV();
    }

    protected int _voidvI()
        throws IOException
    {
        return 1;
    }

    public void _akV(cls_k k1)
    {
        z_Bk = k1;
    }

    public cls_k _cvk()
    {
        return z_Bk;
    }

    public int _evI()
    {
        return f_attributesI;
    }

    public void _longIV(int j)
    {
        f_attributesI = j;
    }

    public int _bvI()
    {
        return f_offsetI;
    }

    public void _nullIV(int j)
    {
        f_offsetI = j;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        if(f_offsetI != -1)
            printstream.print(cls_d._aStringIString(" offset=0x", f_offsetI, 2));
        super._doPrintStreamvV(printstream, flag);
        printstream.print(cls_c._doIString(f_attributesI));
    }

    public String _dvString()
    {
        StringBuffer stringbuffer = new StringBuffer(z_Bk._tvString());
        stringbuffer.append(".");
        stringbuffer.append(_intvString());
        return stringbuffer.toString();
    }

    public String toString()
    {
        return _dvString();
    }
}
