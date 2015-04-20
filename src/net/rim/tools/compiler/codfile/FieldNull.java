// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            w, ap, u

public final class FieldNull extends net.rim.tools.compiler.codfile.FieldDef
{

    public FieldNull(net.rim.tools.compiler.codfile.ClassDef u, boolean flag)
    {
        super(u, -1, flag);
        super._address = -1;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        throw new IOException("cannot write null field");
    }
}
