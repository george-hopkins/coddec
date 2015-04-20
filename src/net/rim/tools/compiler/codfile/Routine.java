// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            r, j, an, k,
//            p, ak, a1, ai,
//            u, ap, x

public abstract class Routine extends net.rim.tools.compiler.codfile.Member
{

    protected int _parmLocalCount;
    protected net.rim.tools.compiler.codfile.TypeList _protoTypeList;
    private net.rim.tools.compiler.codfile.FixupTableEntry z_fNan;
    private net.rim.tools.compiler.codfile.FixupTableEntry z_fOan;
    private Vector z_fKVector;
    private net.rim.tools.compiler.codfile.MemberRef _MemberRef;
    private static StringBuffer z_fIStringBuffer = new StringBuffer();
    protected String z_fHString;
    protected String z_fGString;

    public Routine()
    {
    }

    public Routine(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2)
    {
        super(u1, ak1, p1);
        _protoTypeList = p2;
        _parmLocalCount = p2._axvI();
    }

    public Routine(net.rim.tools.compiler.codfile.ClassDef u1, int i)
    {
        super(u1, i);
    }

    final void _akStringV(net.rim.tools.compiler.codfile.DataSection k1, boolean flag, String s)
    {
        if(!super._name.equals(s))
        {
            super._name = k1.getDataBytes().getIdentifier(s);
            _protoTypeList = k1.getTypeLists().getTypeList(_protoTypeList, k1, false);
        }
        if(flag)
            super._typeList = k1.getTypeLists().getTypeList(super._typeList, k1, false);
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k1, boolean flag)
    {
    }

    protected MemberRef getFixupRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(_MemberRef == null)
            _MemberRef = new MemberRef(super._classDef, super._classDef.getClassRef(k1), super._name, _protoTypeList);
        return _MemberRef;
    }

    protected void addVirtualFixup(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        Object obj = c1.getCookie();
        if(obj != null)
        {
            if(z_fNan == null)
            {
                z_fNan = new FixupTableEntry(2);
                z_fNan.setItem(getFixupRef((DataSection)obj));
            }
            z_fNan._adIV(c1.getOffset());
        }
    }

    protected int addStaticFixup(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
    {
        Object obj = c1.getCookie();
        int i = -1;
        net.rim.tools.compiler.codfile.FixupTableEntry an1 = null;
        if(u1 == super._classDef)
        {
            an1 = z_fOan;
            if(obj != null)
            {
                if(an1 == null)
                {
                    DataSection k1 = (DataSection)obj;
                    makeSymbolic(k1, false);
                    an1 = z_fOan = new net.rim.tools.compiler.codfile.FixupTableEntry(2);
                    an1.setItem(getFixupRef(k1));
                }
                an1._adIV(c1.getOffset());
            }
            if(an1 != null)
                i = an1.getOrdinal();
        } else
        {
            if(obj != null && z_fKVector == null)
                z_fKVector = new Vector();
            int l = z_fKVector != null ? z_fKVector.size() : 0;
            for(int i1 = 0; i1 < l; i1++)
            {
                FixupTableEntry an2 = (FixupTableEntry)z_fKVector.elementAt(i1);
                MemberRef j1 = (MemberRef)an2.getItem();
                if(j1.getClassDef() != u1)
                    continue;
                an1 = an2;
                break;
            }

            if(obj != null)
            {
                if(an1 == null)
                {
                    net.rim.tools.compiler.codfile.DataSection k2 = (net.rim.tools.compiler.codfile.DataSection)obj;
                    makeSymbolic(k2, false);
                    an1 = new net.rim.tools.compiler.codfile.FixupTableEntry(2);
                    an1.setItem(new net.rim.tools.compiler.codfile.MemberRef(u1, u1.getClassRef(k2), super._name, _protoTypeList));
                    z_fKVector.addElement(an1);
                }
                an1._adIV(c1.getOffset());
            }
        }
        return i;
    }

    public void writeMemberAddress(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        int i = super._address;
        if(flag)
            i = -1;
        if(i == -1)
            addVirtualFixup(c1);
        c1.writeShort(i, get_name_1(), false);
    }

    public int getVTableOffset(boolean flag)
        throws IOException
    {
        int i = super._address;
        if(flag)
            i = -1;
        return i;
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(z_fNan != null)
            k1._aanV(z_fNan);
        boolean flag = true;
        if(z_fOan != null)
            k1._ifanvV(z_fOan, flag);
        if(z_fKVector != null)
        {
            boolean flag1 = false;
            int i = z_fKVector.size();
            for(int l = 0; l < i; l++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)z_fKVector.elementAt(l);
                k1._ifanvV(an1, flag1);
            }

        }
    }

    public net.rim.tools.compiler.codfile.TypeList getProtoTypeList()
    {
        return _protoTypeList;
    }

    public int getLocalCount()
    {
        return _parmLocalCount;
    }

    public void setLocalCount(int i)
    {
        _parmLocalCount = i;
    }

    public String get_name_1()
    {
        if(z_fHString == null)
            synchronized(z_fIStringBuffer)
            {
                z_fIStringBuffer.setLength(0);
                z_fIStringBuffer.ensureCapacity(256);
                if(super._typeList != null && super._typeList.length() > 0)
                {
                    z_fIStringBuffer.append(super._typeList.get_baseType().getTypeName());
                    z_fIStringBuffer.append(" ");
                }
                z_fIStringBuffer.append(super._name);
                z_fIStringBuffer.append("( ");
                int i = _protoTypeList.length();
                for(int l = 0; l < i; l++)
                {
                    z_fIStringBuffer.append(_protoTypeList.get_type(l).getTypeName());
                    if(l < i - 1)
                        z_fIStringBuffer.append(", ");
                }

                z_fIStringBuffer.append(" )");
                z_fHString = z_fIStringBuffer.toString();
            }
        return z_fHString;
    }

    public String get_Name()
    {
        if(z_fGString == null)
            synchronized(z_fIStringBuffer)
            {
                z_fIStringBuffer.setLength(0);
                z_fIStringBuffer.ensureCapacity(256);
                if(super._typeList != null && super._typeList.length() > 0)
                {
                    z_fIStringBuffer.append(super._typeList.get_baseType().getTypeName());
                    z_fIStringBuffer.append(" ");
                }
                z_fIStringBuffer.append(super._name.getString());
                z_fIStringBuffer.append("( ");
                int i = _protoTypeList.length();
                for(int l = 0; l < i; l++)
                {
                    z_fIStringBuffer.append(_protoTypeList.get_type(l).getTypeName());
                    if(l < i - 1)
                        z_fIStringBuffer.append(", ");
                }

                z_fIStringBuffer.append(" )");
                z_fGString = z_fIStringBuffer.toString();
            }
        return z_fGString;
    }

}
