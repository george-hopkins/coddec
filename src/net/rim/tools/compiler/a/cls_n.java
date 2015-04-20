// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            e, d, s, f

public class cls_n extends cls_e
{

    private cls_e z_ahe;
    private int f_nestingI;

    public cls_n()
    {
    }

    public cls_n(String s1, int i, int j, cls_e e1, int k)
    {
        super(s1, i, j);
        z_ahe = e1;
        f_nestingI = k;
    }

    cls_n(DataInputStream datainputstream, cls_f f, int i)
        throws IOException
    {
        super(datainputstream, f, i);
    }

    void _byteDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._byteDataInputStreamV(datainputstream, f);
        z_ahe = cls_e._caseDataInputStreame(datainputstream, f);
        f_nestingI = datainputstream.readInt();
    }

    void _dodV(cls_d d1)
        throws IOException
    {
        super._dodV(d1);
        z_ahe._adV(d1);
        d1._aIStringV(f_nestingI, "nesting");
    }

    public cls_e _Gve()
    {
        return z_ahe;
    }

    public void _foreV(cls_e e1)
    {
        z_ahe = e1;
    }

    public int _FvI()
    {
        return f_nestingI;
    }

    public void _pIV(int i)
    {
        f_nestingI = i;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        printstream.print(" type=");
        printstream.print(z_ahe._intvString());
        printstream.print(" nesting=");
        printstream.println(Integer.toString(f_nestingI));
    }
}
