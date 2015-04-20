// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            s, e, f, d

public class cls_l extends cls_s
{

    private cls_e z_ve;

    public cls_l()
    {
    }

    public cls_l(String s1, cls_e e1)
    {
        super(s1);
        z_ve = e1;
    }

    cls_l(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        z_ve = cls_e._caseDataInputStreame(datainputstream, f);
    }

    void _adV(cls_d d)
        throws IOException
    {
        super._adV(d);
        z_ve._adV(d);
    }

    public cls_e _gotove()
    {
        return z_ve;
    }

    public void _ifeV(cls_e e1)
    {
        z_ve = e1;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        printstream.print(" type=");
        printstream.print(z_ve._intvString());
    }
}
