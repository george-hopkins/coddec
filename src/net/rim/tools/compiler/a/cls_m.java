// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            c, d, f

public class cls_m extends cls_c
{

    private int f_offsetI;
    private int f_lineI;

    public cls_m()
    {
    }

    public cls_m(int i, int j)
    {
        f_offsetI = i;
        f_lineI = j;
    }

    cls_m(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_offsetI = datainputstream.readInt();
        f_lineI = datainputstream.readInt();
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aIStringV(f_offsetI, "offset");
        d1._aIStringV(f_lineI, "line");
    }

    static Vector _ifDataInputStreamVector(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int j = 0; j < i; j++)
            vector.addElement(new cls_m(datainputstream, f));

        return vector;
    }

    public int _avI()
    {
        return f_offsetI;
    }

    public void _forIV(int i)
    {
        f_offsetI = i;
    }

    public int _ifvI()
    {
        return f_lineI;
    }

    public void _intIV(int i)
    {
        f_lineI = i;
    }

    public void _aPrintStreamvV(PrintStream printstream, boolean flag)
    {
        printstream.print(cls_d._aStringIString(" offset=0x", f_offsetI, 2));
        printstream.print(" line=");
        printstream.println(Integer.toString(f_lineI));
    }
}
