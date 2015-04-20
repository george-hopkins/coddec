// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            af, ag, ad, a5,
//            d, h, u, ap,
//            r, k

public final class ModuleRef extends Module
{

    private DataSection _dataSection;
    private ClassDef _classDef;

    public ModuleRef(DataSection k, String s, String s1)
    {
        super(k, s, s1, new CodfileVector(), new CodfileVector());
        _dataSection = k;
    }

    public ModuleRef(DataSection k, Module af1)
    {
        super(af1);
        _dataSection = k;
    }

    public ModuleRef(net.rim.tools.compiler.io.StructuredInputStream a, DataSection k)
        throws IOException
    {
        super(a, k, new CodfileVector(), new CodfileVector());
        super._routines.addElement(super._nullRoutine);
        _dataSection = k;
    }

    public ClassDef makeClassDef(DataSection k, String s, String s1)
    {
        ClassDefDomestic ad1 = new ClassDefDomestic(k, s, s1);
        _ifuV(ad1);
        return ad1;
    }

    public ClassDef getClassDef(int i)
    {
        if(i >= super._classDefs.size())
            super._classDefs.setSize(i + 1);
        ClassDefDomestic ad1 = (ClassDefDomestic)super._classDefs.elementAt(i);
        if(ad1 == null)
        {
            ad1 = new ClassDefDomestic(_dataSection, "module:" + super._name.getString(), "class#" + i);
            ad1.setModule(this);
            ad1.setAddress(i);
            ad1.setOrdinal(i);
            super._classDefs.setElementAt(ad1, i);
        }
        return ad1;
    }

    public void _auvV(ClassDef u1, int i)
    {
        if(i >= super._classDefs.size())
            super._classDefs.setSize(i + 1);
        u1.setAddress(i);
        u1.setOrdinal(i);
        super._classDefs.setElementAt(u1, i);
    }

	public DataSection getDataSection()
	{
		return _dataSection;
	}
	
    public Routine getRoutine(int __offset, ClassDef __classDef)
    {
        Object obj = (Routine)super._routines.getItem(__offset, null);
        if(obj == null)
        {
            if(__classDef == null)
            {
                if(_classDef == null)
                {
                    _classDef = new ClassDefDomestic(_dataSection, null, "");
                    _classDef.setModule(this);
                }
                __classDef = _classDef;
            }
            Identifier ak = super._nullRoutine.getName();
            TypeList p = super._nullRoutine.getProtoTypeList();
            obj = new RoutineDomestic(__classDef, ak, p, p);
            ((CodfileItem) (obj)).setOffset(__offset);
            ((Member) (obj))._ifStringvV("routine_", __offset);
            _trya5V(((Routine) (obj)));
        }
        return ((Routine) (obj));
    }
}
