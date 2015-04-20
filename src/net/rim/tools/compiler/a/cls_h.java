// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            l, o, d, e,
//            f

public class cls_h extends cls_l
{

    private int f_localNum;
    private cls_o z_wo;

    public cls_h()
    {
    }

    public cls_h(String s, cls_e e, int i, cls_o o1)
    {
        super(s, e);
        f_localNum = i;
        z_wo = o1;
    }

    cls_h(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_localNum = datainputstream.readInt();
        z_wo = new cls_o(datainputstream, f);
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aIStringV(f_localNum, "localNum");
        z_wo._adV(d1);
    }

    static Vector _doDataInputStreamVector(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int j = 0; j < i; j++)
            vector.addElement(new cls_h(datainputstream, f));

        return vector;
    }

    public int _nullvI()
    {
        return f_localNum;
    }

    public void _gotoIV(int i)
    {
        f_localNum = i;
    }

    public cls_o _longvo()
    {
        return z_wo;
    }

    public void _aoV(cls_o o1)
    {
        z_wo = o1;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        printstream.print(" localNum=");
        printstream.print(Integer.toString(f_localNum));
        super._doPrintStreamvV(printstream, flag);
        z_wo._ifPrintStreamvV(printstream, flag);
        printstream.println();
    }
}
