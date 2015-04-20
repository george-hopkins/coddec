// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            u, n, an, k,
//            a7, ao, ak, ap,
//            a1, w, r, af,
//            at, p, a5

public final class ClassDefForeign extends net.rim.tools.compiler.codfile.ClassDef
{

    private net.rim.tools.compiler.codfile.CodfileOffset _CodfileOffset;
    private net.rim.tools.compiler.codfile.FixupTableEntry _FixupTableEntry;
    private String _packageName;
    private String _className;
    private net.rim.tools.compiler.codfile.FixupTableEntry z_gPan;

    public ClassDefForeign(net.rim.tools.compiler.codfile.DataSection k1, String s, String s1)
    {
        super(k1, -1);
        setActualName(s, s1);
    }

    public ClassDefForeign(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.Module af1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.Identifier ak2)
        throws IOException
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

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k1)
    {
        getClassRef(k1);
    }

    protected net.rim.tools.compiler.codfile.CodfileOffset getFixupRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(_CodfileOffset == null)
            _CodfileOffset = new CodfileOffset(getClassRef(k1));
        return _CodfileOffset;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write foreign class def");
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
        Object obj = c1.getCookie();
        if(obj != null)
        {
            int i = c1.getOffset();
            if(c1.writingCode())
            {
                if(_FixupTableEntry == null)
                {
                    _FixupTableEntry = new FixupTableEntry(2);
                    _FixupTableEntry.setItem(getFixupRef((DataSection)obj));
                }
                _FixupTableEntry._adIV(i);
            } else
            if(!super._siblingFormat)
            {
                if(z_gPan == null)
                {
                    z_gPan = new FixupTableEntry(2);
                    z_gPan.setItem(getFixupRef((DataSection)obj));
                }
                z_gPan._adIV(i);
            }
        }
        writeModuleOrdinal(c1);
        c1.writeByte(-1, super._nameS);
    }

    public void writeAbsoluteClassDef(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(super._siblingFormat)
        {
            int i = c1.getOffset();
            c1.writeByte(super._module.getOrdinal());
            Object obj = c1.getCookie();
            if(obj != null)
            {
                getClassRef((DataSection)obj);
                if(c1.writingCode())
                {
                    if(_FixupTableEntry == null)
                    {
                        _FixupTableEntry = new FixupTableEntry(2);
                        _FixupTableEntry.setItem(getFixupRef((DataSection)obj));
                    }
                    _FixupTableEntry._adIV(i);
                }
                c1.writeByte(-1, super._nameS);
            } else
            {
				if (super._classRef != null)
                	super._classRef.writeOrdinal(c1);
            }
        } else
        {
            writeAbsoluteOrdinal(c1);
        }
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(_FixupTableEntry != null)
            k1._tryanV(_FixupTableEntry);
        if(z_gPan != null)
            k1._ifanV(z_gPan);
        super.writeFixups(k1);
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
        return new net.rim.tools.compiler.codfile.FieldDefForeign(this, ak1, p, flag);
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, boolean flag1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.FieldDefForeign a7_1 = (net.rim.tools.compiler.codfile.FieldDefForeign)createFieldDef(a1_1.getNullIdentifier(), p, flag1);
        a7_1.setActualName(s);
        if(flag)
            a7_1.setName(s);
        addFieldDef(a7_1, flag1);
        return a7_1;
    }

    public net.rim.tools.compiler.codfile.Routine createRoutine(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        return new net.rim.tools.compiler.codfile.RoutineForeign(this, ak1, p, p1);
    }

    public net.rim.tools.compiler.codfile.Routine makeRoutine(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.RoutineForeign ao1 = (net.rim.tools.compiler.codfile.RoutineForeign)createRoutine(a1_1.getNullIdentifier(), p, p1);
        ao1.setActualName(s);
        ao1.setName(s);
        ao1.setOffset(super._module._a4vI() + 0x10000);
        super._module._trya5V(ao1);
        return ao1;
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
        if(obj instanceof net.rim.tools.compiler.codfile.ClassDefForeign)
        {
            net.rim.tools.compiler.codfile.ClassDefForeign ay1 = (net.rim.tools.compiler.codfile.ClassDefForeign)obj;
            if(this == ay1)
                return true;
            else
                return _className.equals(ay1._className) && _packageName.equals(ay1._packageName);
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
