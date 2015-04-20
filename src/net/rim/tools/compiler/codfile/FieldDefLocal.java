// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            w, k, an, aw,
//            a1, r, ai, ak,
//            ap, u, p

public final class FieldDefLocal extends net.rim.tools.compiler.codfile.FieldDef
{
	

    private int _attributes;

    public FieldDefLocal(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, boolean flag)
    {
        super(u1, ak1, p, flag);
    }

    public FieldDefLocal(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.ClassDef u1, boolean flag)
        throws IOException
    {
        super(u1, a2.getOffset(), flag);
        read(a2, k1);
    }

    protected void read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection)
        throws IOException
    {
        super._name = __dataSection.getDataBytes().get_identifier(__input.readUnsignedShort());
        super._typeList = __dataSection.getTypeLists().createTypeList(__input.readUnsignedShort());
        if(!__dataSection._atvZ())
        {
            String s = super._name.getString();
            if(s.length() == 0)
                _ifStringvV("field_", super._offset);
            else
                setName(s);
        }
        if(super._isStatic)
            super._address = __input.readUnsignedShort();
    }

    protected int addFixup(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
    {
        int i = -1;
        if(super._isStatic)
            i = super.addFixup(c1, u1);
        else
        if(super._ordinal > 255)
        {
            Object obj = c1.getCookie();
            if(obj != null)
            {
                net.rim.tools.compiler.codfile.DataSection k1 = (net.rim.tools.compiler.codfile.DataSection)obj;
                net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
                if(super._name.equals(a1_1.getNullIdentifier()))
                    super._name = a1_1.getIdentifier(super._nameS);
            }
            i = super.addFixup(c1, super._classDef);
        } else
        {
            Object obj1 = c1.getCookie();
            if(obj1 != null)
            {
                if(super._fixups == null)
                {
                    super._fixups = new net.rim.tools.compiler.codfile.FixupTableEntry(1);
                    super._fixups.setItem(new net.rim.tools.compiler.codfile.MemberRefLocal(super._classDef, this));
                }
                super._fixups._adIV(c1.getOffset());
                i = super._fixups.getOrdinal();
            }
        }
        return i;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        super._name.writeOffset(c1);
        super._typeList.writeOffset(c1);
        if(super._isStatic)
            writeAddress(c1);
        else
            c1.writeString(get_name_1());
        setExtent(c1);
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        if(!super._isStatic)
            super.writeStaticOffset(c1, u1);
        else
        if(u1 == super._classDef)
        {
            u1.writeOrdinal(c1);
            writeAddress(c1);
        } else
        {
            int i = addFixup(c1, u1);
            c1.writeShort(-1, u1.get_name_2(), false);
            c1.writeShort(i, get_name_2(), false);
        }
    }

    public void _gotocV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = _attributes;
        if((i & 1) != 0)
            c1.writeString("IsPublic ");
        if((i & 2) != 0)
            c1.writeString("IsPrivate ");
        if((i & 4) != 0)
            c1.writeString("IsProtected ");
        if((i & 8) != 0)
            c1.writeString("IsFinal ");
        c1.writeByte(i & 0xff, "attributes=", true);
        c1.empty_func7();
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(super._isStatic)
            super.writeFixups(k1);
        else
        if(super._fixups != null)
            if(super._ordinal > 255)
                super.writeFixups(k1);
            else
                k1._foranV(super._fixups);
    }

    public static int _ifZI(boolean flag)
    {
        return flag ? 6 : 4;
    }

    public int getAttributes()
    {
        return _attributes;
    }

    public void setAttributes(int i)
    {
        _attributes |= i;
    }
}
