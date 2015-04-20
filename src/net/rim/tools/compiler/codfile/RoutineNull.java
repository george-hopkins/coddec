// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            a5, i, k, a1,
//            r, ai, u, ap

public final class RoutineNull extends net.rim.tools.compiler.codfile.Routine
{

    public RoutineNull(net.rim.tools.compiler.codfile.ClassDef __classDef, net.rim.tools.compiler.codfile.DataSection k1)
    {
        super(__classDef, -1);
        super._name = k1.getDataBytes().getNullIdentifier();
        super._protoTypeList = k1.getTypeLists().getNullTypeList();
        setName("<null_routine>");
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int j = c1.getOffset();
        ClassDefLocal l = (ClassDefLocal)super._classDef;
        l.set_codeStart(j);
        l.set_codeEnd(j);
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        u1.writeOrdinal(c1);
        super.writeOffset(c1);
    }

    public void writeOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(super._classDef.getModule().getOrdinal() != 0)
            c1.writeByte(-1);
        c1.writeShort(-1, get_name_1(), false);
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeShort(-1, get_name_1(), false);
    }
}
