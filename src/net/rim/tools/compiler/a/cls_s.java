// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            c, f, d

public class cls_s extends cls_c
{

    protected String z_jString;

    public cls_s()
    {
    }

    public cls_s(String s1)
    {
        z_jString = s1;
    }

    cls_s(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        z_jString = cls_c.read_string(datainputstream);
    }

    void _adV(cls_d d)
        throws IOException
    {
        super._adV(d);
        cls_c._adSV(d, z_jString, "name");
    }

    public String _intvString()
    {
        return z_jString;
    }

    public void _aStringV(String s1)
    {
        z_jString = s1;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        printstream.print(" name=");
        printstream.print(z_jString);
    }

    public String toString()
    {
        return _intvString();
    }
}
