// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

// Referenced classes of package net.rim.tools.compiler.a:
//            e, f

public class cls_r extends cls_e
{

    public cls_r()
    {
    }

    public cls_r(String s, int i, int j)
    {
        super(s, i, j);
    }

    cls_r(DataInputStream datainputstream, cls_f f, int i)
        throws IOException
    {
        super(datainputstream, f, i);
    }

    public boolean equals(Object obj)
    {
        return ((cls_r)obj).get_typeTag() == get_typeTag();
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        printstream.println();
    }
}
