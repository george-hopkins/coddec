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

public final class FieldDefForeign extends FieldDef
{

    private String _name;

    public FieldDefForeign(ClassDef u, Identifier ak1, TypeList p, boolean flag)
    {
        super(u, ak1, p, flag);
        setAddress(-1);
        _name = ak1.getString();
    }

    public FieldDefForeign(ClassDef u, DataSection k1, boolean flag)
        throws IOException
    {
        super(u, k1.getDataBytes().get_identifier(0), k1.getTypeLists().createTypeList(0), flag);
        setAddress(-1);
    }

    public void makeSymbolic(DataSection k1)
    {
        super._name = k1.getDataBytes().getIdentifier(_name);
        super._typeList = k1.getTypeLists().getTypeList(super._typeList, k1, false);
    }

    public void setActualName(String __name)
    {
        _name = __name;
    }

    public void write(StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write non-local member fields");
    }

    public void writeStaticOffset(StructuredOutputStream c1, ClassDef u)
        throws IOException
    {
        if(!super._isStatic)
        {
            super.writeStaticOffset(c1, u);
        } else
        {
            int i = addFixup(c1, u);
            c1.writeShort(-1, u.get_name_2(), false);
            c1.writeShort(i, get_name_2(), false);
        }
    }
}
