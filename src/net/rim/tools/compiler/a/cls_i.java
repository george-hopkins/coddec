// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            p, c, d, e,
//            f, k

public class cls_i extends cls_p
{

    private long f_valueL;
    private String z_EString;

    public cls_i(String s, cls_e e, int j, int k, long l)
    {
        super(s, e, j, k);
        f_valueL = l;
    }

    public cls_i(String s, cls_e e, int j, int k, String s1)
    {
        super(s, e, j, k);
        z_EString = s1;
    }

    cls_i(DataInputStream datainputstream, cls_f f, cls_k k)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
        _akV(k);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        f_valueL = datainputstream.readLong();
        z_EString = cls_c.read_string(datainputstream);
        if(z_EString.length() == 0)
            z_EString = null;
    }

    void _adV(cls_d d1)
        throws IOException
    {
        super._adV(d1);
        d1._aJStringV(f_valueL, "value");
        String s = z_EString;
        if(s == null)
            s = "";
        cls_c._adSV(d1, s, "string");
    }

    protected int _voidvI()
        throws IOException
    {
        return 2;
    }

    public long _fvJ()
    {
        return f_valueL;
    }

    public void _aJV(long l)
    {
        f_valueL = l;
    }

    public String _gvString()
    {
        return z_EString;
    }

    public void _ifStringV(String s)
    {
        z_EString = s;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        if(z_EString != null)
        {
            printstream.print(" string=\"");
            printstream.print(z_EString);
            printstream.print("\"");
        } else
        {
            printstream.print(cls_d._aStringIString(" value=0x", f_valueL, 8));
        }
    }
}
