// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            r, k, an, j,
//            a1, ai, ap, u,
//            ak, p

public abstract class FieldDef extends net.rim.tools.compiler.codfile.Member
{

    protected boolean _isStatic;
    protected FixupTableEntry _fixups;
    private Vector z_fzVector;

    protected FieldDef(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak, net.rim.tools.compiler.codfile.TypeList p, boolean flag)
    {
        super(u1, ak, p);
        _isStatic = flag;
        z_fzVector = null;
    }

    protected FieldDef(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.DataSection k1, boolean flag)
        throws IOException
    {
        super(u1, k1.getDataBytes().get_identifier(0), k1.getTypeLists().createTypeList(0));
        _isStatic = flag;
    }

    protected FieldDef(net.rim.tools.compiler.codfile.ClassDef u1, int i, boolean flag)
    {
        super(u1, i);
        _isStatic = flag;
    }

    public void setName(String s)
    {
        super._nameS = s;
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k1)
    {
    }

    protected int addFixup(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
    {
        Object obj = c1.getCookie();
        int i = -1;
        net.rim.tools.compiler.codfile.FixupTableEntry an1 = null;
        if(u1 == super._classDef)
        {
            an1 = _fixups;
            if(obj != null)
            {
                if(an1 == null)
                {
                    net.rim.tools.compiler.codfile.DataSection k1 = (DataSection)obj;
                    makeSymbolic(k1);
                    an1 = _fixups = new net.rim.tools.compiler.codfile.FixupTableEntry(2);
                    an1.setItem(new MemberRef(super._classDef, super._classDef.getClassRef(k1), super._name, super._typeList));
                }
                an1._adIV(c1.getOffset());
            }
            if(an1 != null)
                i = an1.getOrdinal();
        } else
        {
            if(obj != null && z_fzVector == null)
                z_fzVector = new Vector();
            int l = z_fzVector != null ? z_fzVector.size() : 0;
            for(int i1 = 0; i1 < l; i1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an2 = (FixupTableEntry)z_fzVector.elementAt(i1);
                net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)an2.getItem();
                if(j1.getClassDef() != u1)
                    continue;
                an1 = an2;
                break;
            }

            if(obj != null)
            {
                if(an1 == null)
                {
                    net.rim.tools.compiler.codfile.DataSection k2 = (DataSection)obj;
                    makeSymbolic(k2);
                    an1 = new net.rim.tools.compiler.codfile.FixupTableEntry(2);
                    an1.setItem(new MemberRef(u1, u1.getClassRef(k2), super._name, super._typeList));
                    z_fzVector.addElement(an1);
                }
                an1._adIV(c1.getOffset());
            }
        }
        return i;
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        if(!_isStatic)
        {
            c1.writeByte(-1, u1.get_name_2(), false);
            c1.writeByte(-1, get_name_2(), false);
        } else
        {
            u1.writeOrdinal(c1);
            writeAddress(c1);
        }
    }

    public void writeMemberAddress(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(_isStatic || flag || super._address == -1)
        {
            if(!_isStatic)
                addFixup(c1, super._classDef);
            c1.writeByte(-1, super._nameS, false);
        } else
        {
            writeAddressByte(c1);
        }
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        if(_fixups != null)
            if(_isStatic)
                __dataSection._aanvV(_fixups, true);
            else
                __dataSection._doanV(_fixups);
        if(z_fzVector != null)
        {
            int i = z_fzVector.size();
            for(int l = 0; l < i; l++)
            {
                FixupTableEntry an1 = (FixupTableEntry)z_fzVector.elementAt(l);
                if(_isStatic)
                    __dataSection._aanvV(an1, false);
                else
                    __dataSection._doanV(an1);
            }

        }
    }
}
