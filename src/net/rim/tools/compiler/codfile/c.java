// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;

// Referenced classes of package net.rim.tools.compiler.d:
//            a5, ax, ap, ak,
//            r, u, p, k

public final class c extends net.rim.tools.compiler.codfile.Routine
{

    private String z_fPString;

    public c(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        super(u1, ak1, p, p1);
        super._offset = -1;
        super._address = -1;
        z_fPString = ak1.getString();
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k, boolean flag)
    {
        _akStringV(k, flag, z_fPString);
    }

    public void _dStringV(String s)
    {
        z_fPString = s;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write brittle routine");
    }

    public void writeOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        super._classDef.writeModuleOrdinal(c1);
        c1.writeShort(super._offset, get_name_1(), false);
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        if(u1 instanceof ClassDefNull)
            u1 = super._classDef;
        else
        if(super._classDef instanceof ClassDefNull)
            super._classDef = u1;
        if(u1 == super._classDef)
        {
            u1.writeAbsoluteClassDef(c1);
            c1.writeShort(super._offset, get_name_1(), false);
        } else
        {
            int i = addStaticFixup(c1, u1);
            c1.writeShort(-1, u1.get_name_2(), false);
            c1.writeShort(i, get_name_1(), false);
        }
    }
}
