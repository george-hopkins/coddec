// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_r;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            a, m

public final class BaseType extends net.rim.tools.compiler.types.Type
{

    private int _size;
    private int _typeId;

    public BaseType(String __name, int __size, int __typeId)
    {
        super(__name);
        _size = __size;
        _typeId = __typeId;
    }

    public int getSize()
    {
        return _size;
    }

    public int getTypeId()
    {
        return _typeId;
    }

    net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m)
	throws net.rim.tools.compiler.util.CompileException
    {
        return net.rim.tools.compiler.codfile.TypeItem.makeTypeItem(getTypeId());
    }

    public net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m)
    {
        if(super.z_qPe == null || super.z_qPe._ovf() != f1)
        {
            super.z_qPe = new net.rim.tools.compiler.a.cls_r(getName(), getTypeId(), getSize());
            f1._aeV(super.z_qPe);
        }
        return super.z_qPe;
    }
}
