// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            w, ak, r, u,
//            k, a1, ai, ap,
//            ab, p

public final class FieldDefDomestic extends net.rim.tools.compiler.codfile.FieldDef
{

    private net.rim.tools.compiler.codfile.FieldDefLocal _sibling;
    private String _name;

    public FieldDefDomestic(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, boolean flag)
    {
        super(u1, ak1, p, flag);
        _name = ak1.getString();
    }

    public void setActualName(String __name)
    {
        _name = __name;
    }

    public void setSibling(net.rim.tools.compiler.codfile.FieldDefLocal __sibling)
    {
        _sibling = __sibling;
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k1)
    {
        super._classDef.getClassRef(k1);
        super._name = k1.getDataBytes().getIdentifier(_name);
        super._typeList = k1.getTypeLists().getTypeList(super._typeList, k1, false);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write non-local member fields");
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        if(_sibling != null)
            super._address = _sibling.getAddress();
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

    public void writeMemberAddress(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(_sibling != null)
            super._address = _sibling.getAddress();
        super.writeMemberAddress(c1, flag);
    }
}
