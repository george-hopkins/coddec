// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.a.cls_e;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_r;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            b, a, g, m

public final class ClassUninitializedType extends net.rim.tools.compiler.types.ReferenceType
{

    private net.rim.tools.compiler.types.ClassType _classType;
    private int z_rvI;
    private boolean _preverified;

    public ClassUninitializedType(net.rim.tools.compiler.types.ClassType g1, int j)
    {
        super("<" + g1.getName() + ">");
        _classType = g1;
        z_rvI = j;
        _preverified = false;
    }

    public ClassUninitializedType(net.rim.tools.compiler.types.ClassType g1, int j, boolean flag)
    {
        super("<" + g1.getName() + ">");
        _classType = g1;
        z_rvI = j;
        _preverified = flag;
    }

    public int getTypeId()
    {
        return 9;
    }

    public net.rim.tools.compiler.types.ClassType getClassType()
    {
        return _classType;
    }

    public int _fsvI()
    {
        return z_rvI;
    }

    public void fixupOffset(int __offset1, int __offset2)
    {
        if(_preverified && z_rvI == __offset1)
        {
            z_rvI = __offset2;
            _preverified = false;
        }
    }

    public boolean isPreverified()
    {
        return _preverified;
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj instanceof net.rim.tools.compiler.types.ClassUninitializedType)
        {
            net.rim.tools.compiler.types.ClassUninitializedType j = (net.rim.tools.compiler.types.ClassUninitializedType)obj;
            if(z_rvI != j.z_rvI)
                return false;
            return _classType.equals(j._classType);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return z_rvI * 31 + _classType.hashCode();
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int j = m1.getOrdinal();
        net.rim.tools.compiler.codfile.ClassDef u = getClassDef(j, m1.getCount());
        if(u == null)
        {
            u = _classType.getClassDef(m1);
            setClassDef(u, j);
        }
        return u;
    }

    net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int j = m1.getOrdinal();
        net.rim.tools.compiler.codfile.TypeItem x1 = getTypeItem(j, m1.getCount());
        if(x1 == null)
        {
            x1 = new net.rim.tools.compiler.codfile.TypeItem(getClassDef(m1), 9);
            setTypeItem(x1, j);
        }
        return x1;
    }

    net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int j = m1.getOrdinal();
        net.rim.tools.compiler.codfile.TypeList p1 = getTypeList(j, m1.getCount());
        if(p1 == null)
        {
            if(!_classType.isProcessed())
                p1 = new net.rim.tools.compiler.codfile.TypeList(-1);
            else
                p1 = new net.rim.tools.compiler.codfile.TypeList(makeTypeItem(m1));
            setTypeList(p1, j);
        }
        return p1;
    }

    public net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_qPe == null || super.z_qPe._ovf() != f1)
        {
            super.z_qPe = new net.rim.tools.compiler.a.cls_r(getName(), getTypeId(), getSize());
            f1._aeV(super.z_qPe);
        }
        return super.z_qPe;
    }
}
