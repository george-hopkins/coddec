// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, i, k, a1,
//            at, ai, u, ar,
//            ak, p, r

public class MemberRef extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected net.rim.tools.compiler.codfile.ClassRef _classRef;
    protected net.rim.tools.compiler.codfile.Identifier _name;
    protected net.rim.tools.compiler.codfile.TypeList _typeList;
    protected net.rim.tools.compiler.codfile.ClassDef _classDef;
    protected net.rim.tools.compiler.codfile.Member _memeber;
    protected int _typeListOffset;

    public MemberRef(net.rim.tools.compiler.codfile.ClassDef __classDef, net.rim.tools.compiler.codfile.ClassRef __ClassRef, net.rim.tools.compiler.codfile.Identifier ___name, net.rim.tools.compiler.codfile.TypeList __typeList)
    {
        _classDef = __classDef;
        _classRef = __ClassRef;
        _name = ___name;
        _typeList = __typeList;
    }

    protected MemberRef(net.rim.tools.compiler.codfile.ClassDef __classDe, net.rim.tools.compiler.codfile.Member __memeber, net.rim.tools.compiler.codfile.Identifier ___name, net.rim.tools.compiler.codfile.TypeList __typeList)
    {
        _classDef = __classDe;
        _memeber = __memeber;
        _name = ___name;
        _typeList = __typeList;
    }

    protected MemberRef()
    {
    }

    public MemberRef(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection)
        throws IOException
    {
        _classRef = __dataSection.getClassRef(__input.readUnsignedShort());
        _name = __dataSection.getDataBytes().get_identifier(__input.readUnsignedShort());
        _typeListOffset = __input.readUnsignedShort();
    }

    public void _akZV(net.rim.tools.compiler.codfile.DataSection __dataSection, boolean flag, boolean flag1)
        throws IOException
    {
        _classDef = _classRef.getClassDef();
        _typeList = __dataSection.getTypeLists().createTypeList(_typeListOffset);
        if(_classDef instanceof net.rim.tools.compiler.codfile.ClassDefLocal)
        {
            net.rim.tools.compiler.codfile.ClassDefLocal l = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDef;
            if(flag)
            {
                if(flag1)
                    _memeber = l.getNullRoutine();
            } else
            {
                _memeber = l.makeFieldDef(_name, _typeList, flag1);
            }
        }
    }

    public void _aarV(net.rim.tools.compiler.codfile.ar ar1)
    {
        _memeber = ar1._aur(_classDef, _name, _typeList);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        _classRef.writeOffset(c);
        _name.writeOffset(c);
        _typeList.writeOffset(c);
        setExtent(c);
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef()
    {
        return _classDef;
    }

    public static int _SvI()
    {
        return 6;
    }

    public net.rim.tools.compiler.codfile.Member getMember()
    {
        return _memeber;
    }

    public net.rim.tools.compiler.codfile.ClassRef getClassRef()
    {
        return _classRef;
    }

    public net.rim.tools.compiler.codfile.Identifier getName()
    {
        return _name;
    }

    public net.rim.tools.compiler.codfile.TypeList getTypeList()
    {
        return _typeList;
    }
}
