// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            w, ap, ak, k,
//            a1, ai, r, u,
//            p

public final class q extends FieldDef
{

    private String z_fBString;

    public q(ClassDef u1, Identifier ak1, TypeList p, boolean flag)
    {
        super(u1, ak1, p, flag);
        setAddress(-1);
        z_fBString = ak1.getString();
    }

    public q(ClassDef u1, DataSection k1, boolean flag)
        throws IOException
    {
        super(u1, k1.getDataBytes().get_identifier(0), k1.getTypeLists().createTypeList(0), flag);
        setAddress(-1);
    }

    public void _voidStringV(String s)
    {
        z_fBString = s;
    }

    public void makeSymbolic(DataSection k1)
    {
        if(!super._isStatic)
        {
            super._name = k1.getDataBytes().getIdentifier(z_fBString);
            super._typeList = k1.getTypeLists().getTypeList(super._typeList, k1, false);
        }
    }

    public void write(StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write brittle member fields");
    }

    public void writeStaticOffset(StructuredOutputStream c1, ClassDef u1)
        throws IOException
    {
        if(!super._isStatic)
            super.writeStaticOffset(c1, u1);
        else
        if(u1 == super._classDef)
        {
            u1.writeAbsoluteClassDef(c1);
            writeAddress(c1);
        } else
        {
            int i = addFixup(c1, u1);
            c1.writeShort(-1, u1.get_name_2(), false);
            c1.writeShort(i, get_name_2(), false);
        }
    }
}
