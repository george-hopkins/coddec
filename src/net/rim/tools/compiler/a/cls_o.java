// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            c, d, f

public class cls_o extends cls_c
{

    private int f_startI;
    private int f_end;

    public cls_o()
    {
    }

    public cls_o(int i, int j)
    {
        f_startI = i;
        f_end = j;
    }

    cls_o(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_startI = datainputstream.readInt();
        f_end = datainputstream.readInt();
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aIStringV(f_startI, "start");
        d1._aIStringV(f_end, "end");
    }

    public int get_start()
    {
        return f_startI;
    }

    public void set_start(int i)
    {
        f_startI = i;
    }

    public int get_end()
    {
        return f_end;
    }

    public void set_end(int i)
    {
        f_end = i;
    }

    public boolean _tryIZ(int i)
    {
        return i >= f_startI && i < f_end;
    }

    public void _ifPrintStreamvV(PrintStream printstream, boolean flag)
    {
        printstream.print(cls_d._aStringIString(" start=0x", f_startI, 2));
        printstream.print(cls_d._aStringIString(" end=0x", f_end, 2));
    }
}
