// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            s, d, c, f

public class cls_q extends cls_s
{

    protected int f_keyIDI;

    public cls_q()
    {
    }

    public cls_q(String s1, int i)
    {
        super(s1);
        f_keyIDI = i;
    }

    cls_q(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_keyIDI = datainputstream.readInt();
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aIStringV(f_keyIDI, "keyId");
    }

    static Vector _intDataInputStreamVector(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int j = 0; j < i; j++)
            vector.addElement(new cls_q(datainputstream, f));

        return vector;
    }

    public int _nvI()
    {
        return f_keyIDI;
    }

    public void _dIV(int i)
    {
        f_keyIDI = i;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        printstream.println(cls_c._ifIString(f_keyIDI));
    }

    public boolean equals(Object obj)
    {
        return f_keyIDI == ((cls_q)obj).f_keyIDI;
    }
}
