// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            a5, ax, ak, ap,
//            r, u, z, p,
//            k

public final class RoutineDomestic extends Routine
{

    private RoutineLocal _sibling;
    private String _name;

    public RoutineDomestic(ClassDef u1, Identifier ak1, TypeList p, TypeList p1)
    {
        super(u1, ak1, p, p1);
        _name = ak1.getString();
    }

    public void setActualName(String s)
    {
        _name = s;
    }

    public void setSibling(RoutineLocal z)
    {
        _sibling = z;
    }

    public void makeSymbolic(DataSection k, boolean flag)
    {
        _akStringV(k, flag, _name);
    }

    public void write(StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write domestic routine");
    }

    public void writeOffset(StructuredOutputStream c1)
        throws IOException
    {
        if(_sibling != null)
            super._offset = _sibling.getOffset();
        super._classDef.writeModuleOrdinal(c1);
        c1.writeShort(super._offset, get_name_1(), false);
    }

    public void writeStaticOffset(StructuredOutputStream c1, ClassDef u1)
        throws IOException
    {
        if(_sibling != null)
            super._offset = _sibling.getOffset();
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

    public void writeMemberAddress(StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(_sibling != null)
            super._address = _sibling.getAddress();
        super.writeMemberAddress(c1, flag);
    }

    public int getVTableOffset(boolean flag)
        throws IOException
    {
        if(_sibling != null)
            super._address = _sibling.getAddress();
        return super.getVTableOffset(flag);
    }
}
