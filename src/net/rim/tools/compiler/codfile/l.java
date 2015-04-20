// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            u, q, c, ak,
//            ap, k, a1, w,
//            r, af, a5, o,
//            at, p

public final class l extends ClassDef
{

    private String _packageName;
    private String _className;

    public l(DataSection k1, String s, String s1)
    {
        super(k1, -1);
        _doStringV(s, s1);
    }

    public l(DataSection k1, Module af1, Identifier ak1, Identifier ak2)
        throws IOException
    {
        super(k1, -1);
        super._module = af1;
        super._packageName = ak1;
        super._className = ak2;
        _doStringV(ak1.getString(), ak2.getString());
    }

    public void _doStringV(String s, String s1)
    {
        setName(s, s1);
        _packageName = s != null ? s : "";
        _className = s1;
    }

    public String getPackageNameString()
    {
        return _packageName;
    }

    public String getClassNameString()
    {
        return _className;
    }

    public void write(StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write brittle class def");
    }

    public void writeOrdinal(StructuredOutputStream c1)
        throws IOException
    {
        _gcV(c1);
    }

    public void writeRelativeOrdinal(StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write ordinal for non-local class");
    }

    public void _gcV(StructuredOutputStream c1)
        throws IOException
    {
        writeModuleOrdinal(c1);
        c1.writeByte(super._ordinal, super._nameS);
    }

    public void writeAbsoluteClassDef(StructuredOutputStream c1)
        throws IOException
    {
        _gcV(c1);
    }

    public ClassRef getClassRef(DataSection __dataSection)
    {
        DataBytes _dataBytes_ = __dataSection.getDataBytes();
        setPackageName(_dataBytes_.getIdentifier(_packageName));
        setClassName(_dataBytes_.getIdentifier(_className));
        return super.getClassRef(__dataSection);
    }

    public FieldDef createFieldDef(Identifier ak1, TypeList p, boolean flag)
    {
        return new q(this, ak1, p, flag);
    }

    public FieldDef makeFieldDef(DataSection k1, String s, boolean flag, TypeList p, boolean flag1)
    {
        DataBytes a1_1 = k1.getDataBytes();
        q q1 = (q)createFieldDef(a1_1.getNullIdentifier(), p, flag1);
        q1._voidStringV(s);
        q1.setName(s);
        addFieldDef(q1, flag1);
        return q1;
    }

    public Routine createRoutine(Identifier ak1, TypeList p, TypeList p1)
    {
        return new net.rim.tools.compiler.codfile.c(this, ak1, p, p1);
    }

    public Routine makeRoutine(DataSection k1, String s, boolean flag, TypeList p, TypeList p1)
    {
        DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.c c1 = (net.rim.tools.compiler.codfile.c)createRoutine(a1_1.getNullIdentifier(), p, p1);
        c1._dStringV(s);
        c1.setName(s);
        c1.setOffset(super._module._a4vI() + 0x10000);
        super._module._trya5V(c1);
        return c1;
    }

    public FieldDef createFieldDef(int __offset, boolean __isStatic)
    {
        if(__offset <= -1 || __offset == 65535)
            return super._nullFieldDef;
        Object obj = super.createFieldDef(__offset, __isStatic);
        if(obj == null)
        {
            Identifier ak1 = super._nullRoutine.getName();
            TypeList p = super._nullRoutine.getProtoTypeList();
            obj = new q(this, ak1, p, __isStatic);
            ((CodfileItem) (obj)).setAddress(__offset);
            if(__isStatic)
            {
                ((Member) (obj))._ifStringvV("static_", __offset);
                addFieldDef(((FieldDef) (obj)), __isStatic);
            } else
            {
                ((Member) (obj))._ifStringvV("field_", __offset);
                ((CodfileItem) (obj)).setOrdinal(__offset);
                super._fieldDefs.setItem(((CodfileItem) (obj)), __offset);
            }
        }
        return ((FieldDef) (obj));
    }

    public int compareTo(Object obj)
    {
        ClassDef u1 = (ClassDef)obj;
        int i = _className.compareTo(u1.getClassNameString());
        if(i != 0)
            return i;
        else
            return _packageName.compareTo(u1.getPackageNameString());
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof l)
        {
            l l1 = (l)obj;
            if(this == l1)
                return true;
            else
                return _className.equals(l1._className) && _packageName.equals(l1._packageName);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return _className.hashCode() * 31 + _packageName.hashCode();
    }
}
