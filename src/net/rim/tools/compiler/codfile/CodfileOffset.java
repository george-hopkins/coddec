// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap

public final class CodfileOffset extends CodfileItem
{

    private CodfileItem z_foap;
    private boolean z_fnZ;

    public CodfileOffset(int i, boolean flag)
    {
        super._address = i;
        z_fnZ = flag;
    }

    public CodfileOffset(int i)
    {
        this(i, false);
    }

    public CodfileOffset(CodfileItem ap1)
    {
        z_foap = ap1;
    }

    public void write(StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        if(z_foap == null)
        {
            if(z_fnZ)
                writeAddressByte(c);
            else
                writeAddress(c);
        } else
        {
            z_foap.writeOffset(c);
        }
        setExtent(c);
    }
}
