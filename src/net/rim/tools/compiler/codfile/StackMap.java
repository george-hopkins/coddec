// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            e, a6, k, ai,
//            ap, p

public final class StackMap extends net.rim.tools.compiler.codfile.CodfileItemRelative
{
	

    private CodfileLabel z_d9a6;
    private TypeList z_d8p;

    public StackMap(CodfileLabel a6_1, DataSection k1, TypeList p)
    {
        z_d9a6 = a6_1;
        z_d8p = k1.getTypeLists().getTypeList(p, k1, true);
    }

    public StackMap(net.rim.tools.compiler.io.StructuredInputStream a1, DataSection k1, int i)
        throws IOException
    {
        super(a1);
        _aaV(a1, k1, i);
    }

    public void _aaV(net.rim.tools.compiler.io.StructuredInputStream a1, DataSection k1, int i)
        throws IOException
    {
        z_d9a6 = new CodfileLabel(a1.readUnsignedShort() - i); //_gsvI
        z_d8p = k1.getTypeLists().createTypeList(a1.readUnsignedShort());
    }

    public void writeRelative(StructuredOutputStream c1, int i)
        throws IOException
    {
        c1.writeShort(z_d9a6.getEnd() + i, "offset", false);
        z_d8p.writeOffset(c1);
        c1.empty_func7();
    }

    public static int getEntrySize()
    {
        return 4;
    }
}
