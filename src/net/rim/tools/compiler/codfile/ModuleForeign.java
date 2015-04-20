// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            af, ag, l, a5,
//            c, h, u, ap,
//            r, k

public final class ModuleForeign extends net.rim.tools.compiler.codfile.Module
{

    private net.rim.tools.compiler.codfile.DataSection _dataSection;
    private net.rim.tools.compiler.codfile.ClassDef _classDef;

    public ModuleForeign(net.rim.tools.compiler.codfile.DataSection k, String s, String s1)
    {
        super(k, s, s1, new net.rim.tools.compiler.codfile.CodfileVector(), new net.rim.tools.compiler.codfile.CodfileVector());
        _dataSection = k;
    }

    public ModuleForeign(net.rim.tools.compiler.io.StructuredInputStream a, net.rim.tools.compiler.codfile.DataSection k)
        throws IOException
    {
        super(a, k, new net.rim.tools.compiler.codfile.CodfileVector(), new net.rim.tools.compiler.codfile.CodfileVector());
        super._routines.addElement(super._nullRoutine);
        _dataSection = k;
    }

    public net.rim.tools.compiler.codfile.ClassDef makeClassDef(net.rim.tools.compiler.codfile.DataSection k, String s, String s1)
    {
        net.rim.tools.compiler.codfile.l l1 = new net.rim.tools.compiler.codfile.l(k, s, s1);
        _ifuV(l1);
        return l1;
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(int i)
    {
        if(i >= super._classDefs.size())
            super._classDefs.setSize(i + 1);
        net.rim.tools.compiler.codfile.l l1 = (net.rim.tools.compiler.codfile.l)super._classDefs.elementAt(i);
        if(l1 == null)
        {
            l1 = new net.rim.tools.compiler.codfile.l(_dataSection, "module:" + super._name.getString(), "class#" + i);
            l1.setModule(this);
            l1.setAddress(i);
            l1.setOrdinal(i);
            super._classDefs.setElementAt(l1, i);
        }
        return l1;
    }

    public void _ifuvV(net.rim.tools.compiler.codfile.ClassDef u1, int i)
    {
        if(i >= super._classDefs.size())
            super._classDefs.setSize(i + 1);
        u1.setAddress(i);
        u1.setOrdinal(i);
        super._classDefs.setElementAt(u1, i);
    }

    public net.rim.tools.compiler.codfile.Routine getRoutine(int __offset, net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        Object obj = (net.rim.tools.compiler.codfile.Routine)super._routines.getItem(__offset, null);
        if(obj == null)
        {
            if(__classDef == null)
            {
                if(_classDef == null)
                {
                    _classDef = new l(_dataSection, null, "");
                    _classDef.setModule(this);
                }
                __classDef = _classDef;
            }
            net.rim.tools.compiler.codfile.Identifier ak = super._nullRoutine.getName();
            net.rim.tools.compiler.codfile.TypeList p = super._nullRoutine.getProtoTypeList();
            obj = new net.rim.tools.compiler.codfile.c(__classDef, ak, p, p);
            ((net.rim.tools.compiler.codfile.CodfileItem) (obj)).setOffset(__offset);
            ((net.rim.tools.compiler.codfile.Member) (obj))._ifStringvV("routine_", __offset);
            _trya5V(((net.rim.tools.compiler.codfile.Routine) (obj)));
        }
        return ((net.rim.tools.compiler.codfile.Routine) (obj));
    }
}
