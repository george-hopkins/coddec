// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.a.cls_e;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_k;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            b, m, a

public final class NullType extends net.rim.tools.compiler.types.ReferenceType
{

    public NullType()
    {
        super("NullType");
    }

    public int getTypeId()
    {
        return 7;
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i = m1.getOrdinal();
        net.rim.tools.compiler.codfile.ClassDef u = getClassDef(i, m1.getCount());
        if(u == null)
        {
            u = super._module._trymu(m1);
            setClassDef(u, i);
        }
        return u;
    }

    net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i = m1.getOrdinal();
        net.rim.tools.compiler.codfile.TypeItem x1 = getTypeItem(i, m1.getCount());
        if(x1 == null)
        {
            x1 = new net.rim.tools.compiler.codfile.TypeItem(getClassDef(m1));
            setTypeItem(x1, i);
        }
        return x1;
    }

    public net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_qPe == null || super.z_qPe._ovf() != f1)
        {
            super.z_qPe = new net.rim.tools.compiler.a.cls_k(null, getName(), getTypeId(), 0, 0, 0, 0, -1, null, null);
            f1._aeV(super.z_qPe);
        }
        return super.z_qPe;
    }
}
