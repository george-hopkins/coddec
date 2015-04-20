// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            j, at, r, k,
//            u, ap

public final class MemberRefLocal extends net.rim.tools.compiler.codfile.MemberRef
{

    protected int z_eyI;

    public MemberRefLocal(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Member r1)
    {
        super(u1, r1, r1.getName(), r1.getTypeList());
    }

    public MemberRefLocal(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.codfile.DataSection k1)
        throws IOException
    {
        super._classDef = k1.getClassDef(0, a1.readUnsignedByte());
        super._classRef = new net.rim.tools.compiler.codfile.ClassRef(k1, super._classDef);
        z_eyI = a1.readUnsignedByte();
    }

    public void _akZV(net.rim.tools.compiler.codfile.DataSection k1, boolean flag, boolean flag1)
        throws IOException
    {
        super._memeber = super._classDef.getFieldDef(z_eyI, flag1);
        super._name = super._memeber.getName();
        super._typeList = super._memeber.getTypeList();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        super._classDef.writeRelativeOrdinal(c);
        super._memeber.writeOrdinal(c);
        setExtent(c);
    }

    public static int _SvI()
    {
        return 2;
    }
}
