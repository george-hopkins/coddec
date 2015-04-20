// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.a.cls_e;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_n;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            b, e, a, m

public final class ArrayType extends net.rim.tools.compiler.types.ReferenceType
{

    private int _nesting;
    private net.rim.tools.compiler.types.Type _baseType;

    public ArrayType(net.rim.tools.compiler.types.Type a1, int i)
	throws net.rim.tools.compiler.util.CompileException
    {
        super(a1._name + "[]");
        _nesting = i;
        _baseType = a1;
        if(_nesting > 255)
            throw new CompileException("Error!: Array nesting is too deep");
        else
            return;
    }

    public ArrayType getArrayType()
	throws net.rim.tools.compiler.util.CompileException
    {
        if(super._arrayType == null)
            super._arrayType = new ArrayType(this, _nesting + 1);
        return super._arrayType;
    }

    public String getFullName()
    {
        net.rim.tools.compiler.types.Type a1 = getMostBaseType();
        if(a1 instanceof net.rim.tools.compiler.types.BaseType)
            return super._name;
        StringBuffer stringbuffer = new StringBuffer(a1.getFullName());
        for(int i = 0; i < _nesting; i++)
            stringbuffer.append("[]");

        return stringbuffer.toString();
    }

    public int getTypeId()
    {
        return 8;
    }

    public int getNesting()
    {
        return _nesting;
    }

    public net.rim.tools.compiler.types.Type getBaseType()
    {
        return _baseType;
    }

    public net.rim.tools.compiler.types.Type getMostBaseType()
    {
        net.rim.tools.compiler.types.Type a1;
        net.rim.tools.compiler.types.ArrayType l1;
        for(a1 = _baseType; a1 instanceof net.rim.tools.compiler.types.ArrayType; a1 = l1.getBaseType())
            l1 = (net.rim.tools.compiler.types.ArrayType)a1;

        return a1;
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        throw new net.rim.tools.compiler.util.CompileException("cannot get class def for array type");
    }

    net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i = m1.getOrdinal();
        TypeItem x1 = getTypeItem(i, m1.getCount());
        if(x1 == null)
        {
            net.rim.tools.compiler.types.Type a1 = getMostBaseType();
            if(a1 instanceof net.rim.tools.compiler.types.ReferenceType)
            {
                net.rim.tools.compiler.types.ReferenceType b1 = (net.rim.tools.compiler.types.ReferenceType)a1;
                x1 = new net.rim.tools.compiler.codfile.TypeItem(_nesting, b1.getClassDef(m1));
            } else
            {
                x1 = new net.rim.tools.compiler.codfile.TypeItem(_nesting, a1.getTypeId());
            }
            setTypeItem(x1, i);
        }
        return x1;
    }

    public net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_qPe == null || super.z_qPe._ovf() != f1)
        {
            super.z_qPe = new net.rim.tools.compiler.a.cls_n(getName(), getTypeId(), getSize(), _baseType._afe(f1, m1), _nesting);
            f1._aeV(super.z_qPe);
        }
        return super.z_qPe;
    }
}
