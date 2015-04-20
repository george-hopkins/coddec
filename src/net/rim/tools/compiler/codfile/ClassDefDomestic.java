// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            u, ae, d, ak,
//            ap, w, k, a1,
//            r, af, a5, i,
//            at, p

public final class ClassDefDomestic extends net.rim.tools.compiler.codfile.ClassDef
{

    private net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal;
    private String _packageName;
    private String _className;

    public ClassDefDomestic(DataSection k1, String s, String s1)
    {
        super(k1, -1);
        setActualName(s, s1);
    }

    public ClassDefDomestic(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.Module af1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.Identifier ak2)
    {
        super(k1, -1);
        super._module = af1;
        super._packageName = ak1;
        super._className = ak2;
        setActualName(ak1.getString(), ak2.getString());
    }

    public void setActualName(String s, String s1)
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

    public void _aiV(net.rim.tools.compiler.codfile.ClassDefLocal i)
    {
        _classDefLocal = i;
    }

    public int getOrdinal()
    {
        if(_classDefLocal != null)
            super._ordinal = _classDefLocal.getOrdinal();
        return super._ordinal;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write domestic class def");
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeAbsoluteOrdinal(c1);
    }

    public void writeRelativeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write ordinal for non-local class");
    }

    public void writeAbsoluteOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(_classDefLocal != null)
            super._ordinal = _classDefLocal.getOrdinal();
        writeModuleOrdinal(c1);
        c1.writeByte(super._ordinal, super._nameS);
    }

    public void writeAbsoluteClassDef(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(super._siblingFormat)
        {
            c1.writeByte(super._module.getOrdinal());
            if(_classDefLocal != null)
                super._ordinal = _classDefLocal.getOrdinal();
            c1.writeByte(super._ordinal, super._nameS);
        } else
        {
            writeAbsoluteOrdinal(c1);
        }
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        int i = getNumFieldDefs(false);
        for(int j = 0; j < i; j++)
        {
            net.rim.tools.compiler.codfile.FieldDef w1 = getFieldDef(j, false);
            w1.writeFixups(k1);
        }

    }

    public net.rim.tools.compiler.codfile.ClassRef getClassRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        setPackageName(a1_1.getIdentifier(_packageName));
        setClassName(a1_1.getIdentifier(_className));
        return super.getClassRef(k1);
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, boolean flag)
    {
        return new net.rim.tools.compiler.codfile.FieldDefDomestic(this, ak1, p, flag);
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, boolean flag1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.FieldDefDomestic ae1 = (net.rim.tools.compiler.codfile.FieldDefDomestic)createFieldDef(a1_1.getNullIdentifier(), p, flag1);
        ae1.setActualName(s);
        ae1.setName(s);
        addFieldDef(ae1, flag1);
        return ae1;
    }

    public net.rim.tools.compiler.codfile.Routine createRoutine(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        return new net.rim.tools.compiler.codfile.RoutineDomestic(this, ak1, p, p1);
    }

    public net.rim.tools.compiler.codfile.Routine makeRoutine(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.RoutineDomestic d1 = (net.rim.tools.compiler.codfile.RoutineDomestic)createRoutine(a1_1.getNullIdentifier(), p, p1);
        d1.setActualName(s);
        d1.setName(s);
        d1.setOffset(super._module._a4vI() + 0x10000);
        super._module._trya5V(d1);
        return d1;
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(int i, boolean flag)
    {
        if(i <= -1 || i == 65535)
            return super._nullFieldDef;
        Object obj = super.createFieldDef(i, flag);
        if(obj == null)
            if(flag)
            {
                net.rim.tools.compiler.codfile.Identifier ak1 = super._nullRoutine.getName();
                net.rim.tools.compiler.codfile.TypeList p = super._nullRoutine.getProtoTypeList();
                obj = new net.rim.tools.compiler.codfile.FieldDefDomestic(this, ak1, p, true);
                ((net.rim.tools.compiler.codfile.CodfileItem) (obj)).setAddress(i);
                ((net.rim.tools.compiler.codfile.Member) (obj))._ifStringvV("static_", i);
                addFieldDef(((net.rim.tools.compiler.codfile.FieldDef) (obj)), flag);
            } else
            {
                obj = super._nullFieldDef;
            }
        return ((net.rim.tools.compiler.codfile.FieldDef) (obj));
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.ClassDef u1 = (net.rim.tools.compiler.codfile.ClassDef)obj;
        int i = _className.compareTo(u1.getClassNameString());
        if(i != 0)
            return i;
        else
            return _packageName.compareTo(u1.getPackageNameString());
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof ClassDefDomestic)
        {
            net.rim.tools.compiler.codfile.ClassDefDomestic ad1 = (net.rim.tools.compiler.codfile.ClassDefDomestic)obj;
            if(this == ad1)
                return true;
            else
                return _className.equals(ad1._className) && _packageName.equals(ad1._packageName);
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
