// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap

public abstract class CodfileItemRelative extends net.rim.tools.compiler.codfile.CodfileItem
{

    public CodfileItemRelative()
    {
    }

    public CodfileItemRelative(int i)
    {
        super(i);
    }

    public CodfileItemRelative(net.rim.tools.compiler.io.StructuredInputStream a)
    {
        super(a);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        writeRelative(c, 0);
        setExtent(c);
    }

    public abstract void writeRelative(net.rim.tools.compiler.io.StructuredOutputStream c, int i)
        throws IOException;
}
