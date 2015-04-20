// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            a, m

public abstract class ReferenceType extends net.rim.tools.compiler.types.Type
{

    net.rim.tools.compiler.types.TypeModule _module;
    private net.rim.tools.compiler.codfile.ClassDef _classDefs[];
    private net.rim.tools.compiler.codfile.TypeItem _typeItems[];

    public ReferenceType(String __name)
    {
        super(__name);
    }

    public final int getSize()
    {
        return 4;
    }

    public void setTypeModule(net.rim.tools.compiler.types.TypeModule __typeModule)
    {
        _module = __typeModule;
    }

    public final net.rim.tools.compiler.types.TypeModule getTypeModule()
    {
        return _module;
    }

    final net.rim.tools.compiler.codfile.TypeItem getTypeItem(int __index1, int __index2)
    {
        if(_typeItems == null)
            _typeItems = new TypeItem[__index2];
        return _typeItems[__index1];
    }

    final void setTypeItem(net.rim.tools.compiler.codfile.TypeItem __typeItem, int __index)
    {
        _typeItems[__index] = __typeItem;
    }

    final net.rim.tools.compiler.codfile.ClassDef getClassDef(int __index1, int __index2)
    {
        if(_classDefs == null)
            _classDefs = new net.rim.tools.compiler.codfile.ClassDef[__index2];
        return _classDefs[__index1];
    }

    final void setClassDef(net.rim.tools.compiler.codfile.ClassDef __classDef, int __index)
    {
        _classDefs[__index] = __classDef;
    }

    public abstract net.rim.tools.compiler.codfile.ClassDef getClassDef(net.rim.tools.compiler.types.TypeModule m)
	throws net.rim.tools.compiler.util.CompileException;
}
