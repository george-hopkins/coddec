// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, k, a1, ai,
//            at, ak, p

public final class EntryPoint extends net.rim.tools.compiler.codfile.CodfileItem
{

    private net.rim.tools.compiler.codfile.ClassRef _ClassRef;
    private net.rim.tools.compiler.codfile.Identifier _Identifier;
    private net.rim.tools.compiler.codfile.TypeList _TypeList;
    private int f_offset;
    private int f_typeIndex;

    public EntryPoint(net.rim.tools.compiler.codfile.ClassRef at, net.rim.tools.compiler.codfile.Identifier ak, net.rim.tools.compiler.codfile.TypeList p)
    {
        _ClassRef = at;
        _Identifier = ak;
        _TypeList = p;
    }

    public EntryPoint(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.DataSection k1)
        throws IOException
    {
        f_offset = a2.readUnsignedShort();
        _Identifier = k1.getDataBytes().get_identifier(a2.readUnsignedShort());
        f_typeIndex = a2.readUnsignedShort();
    }

    public void _elsekV(net.rim.tools.compiler.codfile.DataSection k1)
        throws IOException
    {
        _ClassRef = k1.getClassRef(f_offset);
        _TypeList = k1.getTypeLists().createTypeList(f_typeIndex);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        _ClassRef._acV(c, "entry_point_class=");
        _Identifier._acV(c, "entry_point_name=");
        _TypeList._acV(c, "entry_point_prototype");
        setExtent(c);
    }
}
