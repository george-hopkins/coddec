// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, ax, m, u,
//            a5, k, a1, ag,
//            h

public abstract class Module extends net.rim.tools.compiler.codfile.CodfileItem
implements net.rim.tools.compiler.vm.Constants
{

    protected net.rim.tools.compiler.codfile.Literal _name;
    protected net.rim.tools.compiler.codfile.Literal _version;
    protected net.rim.tools.compiler.codfile.CodfileVector _classDefs;
    protected net.rim.tools.compiler.codfile.CodfileVector _routines;
    protected net.rim.tools.compiler.codfile.ClassDef _nullClassDef;
    protected net.rim.tools.compiler.codfile.Routine _nullRoutine;

    protected Module(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        super._ordinal = 255;
        net.rim.tools.compiler.codfile.Identifier _nullIdentifier_ = __dataSection.getDataBytes().getNullIdentifier();
        _nullClassDef = new net.rim.tools.compiler.codfile.ClassDefNull(__dataSection, _nullIdentifier_, _nullIdentifier_);
        _nullClassDef.setModule(this);
        _nullRoutine = new net.rim.tools.compiler.codfile.RoutineNull(_nullClassDef, __dataSection);
    }

    private void init(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        _classDefs.setTableName("class definitions");
        _routines.setTableName("routines");
        _nullClassDef = __dataSection.getNullClassDef();
        _nullRoutine = new net.rim.tools.compiler.codfile.RoutineNull(_nullClassDef, __dataSection);
    }

    protected Module(net.rim.tools.compiler.codfile.DataSection __dataSection, String __name, String __version, net.rim.tools.compiler.codfile.CodfileVector __classDefs, net.rim.tools.compiler.codfile.CodfileVector __routines)
    {
        _classDefs = __classDefs;
        _routines = __routines;
        net.rim.tools.compiler.codfile.DataBytes _dataBytes_ = __dataSection.getDataBytes();
        _name = _dataBytes_.getLiteral(__name, false, false);
        _version = _dataBytes_.getLiteral(__version, false, false);
        init(__dataSection);
    }

    protected Module(net.rim.tools.compiler.codfile.Module __module)
    {
        super(__module.getOffset());
        super._ordinal = ((net.rim.tools.compiler.codfile.CodfileItem) (__module))._ordinal;
        _name = __module._name;
        _version = __module._version;
        _classDefs = __module._classDefs;
        _routines = __module._routines;
        _nullClassDef = __module._nullClassDef;
        _nullClassDef.setModule(this);
        _nullRoutine = __module._nullRoutine;
    }

    protected Module(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, net.rim.tools.compiler.codfile.CodfileVector __classDefs, net.rim.tools.compiler.codfile.CodfileVector __routines)
        throws IOException
    {
        super(__input);
        _classDefs = __classDefs;
        _routines = __routines;
        net.rim.tools.compiler.codfile.DataBytes _dataBytes_ = __dataSection.getDataBytes();
        _name = _dataBytes_.createSibling(__input.readUnsignedShort(), false, false, false);
        init(__dataSection);
    }

    void read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, boolean flag)
        throws IOException
    {
        net.rim.tools.compiler.codfile.DataBytes _dataBytes_ = __dataSection.getDataBytes();
        _version = _dataBytes_.createSibling(__input.readUnsignedShort(), false, false, flag);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        _name.writeOffset(c1);
        setExtent(c1);
    }

    public void _kcV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        _version.writeOffset(c1);
    }

    public void _longkV(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        int i = getNumClassDefs();
        for(int j = 0; j < i; j++)
            getClassDef(j).writeFixups(__dataSection);

        i = _a4vI();
        for(int l = 0; l < i; l++)
            _ZIa5(l).writeFixups(__dataSection);

    }

    public net.rim.tools.compiler.codfile.Literal getName()
    {
        return _name;
    }

    public net.rim.tools.compiler.codfile.Literal getVersion()
    {
        return _version;
    }

    public void _ifuV(net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        __classDef.setModule(this);
        __classDef.setOrdinal(_classDefs.size());
        _classDefs.addElement(__classDef);
    }

    public int getNumClassDefs()
    {
        return _classDefs.size();
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(int i)
    {
        if(i >= _classDefs.size())
            return _nullClassDef;
        else
            return (net.rim.tools.compiler.codfile.ClassDef)_classDefs.elementAt(i);
    }

    public net.rim.tools.compiler.codfile.ClassDef getNullClassDef()
    {
        return _nullClassDef;
    }

    public abstract net.rim.tools.compiler.codfile.ClassDef makeClassDef(DataSection k1, String s, String s1);

    public void _trya5V(net.rim.tools.compiler.codfile.Routine a5_1)
    {
        _routines.addItemOffset(a5_1);
    }

    public int _a4vI()
    {
        return _routines.size();
    }

    public net.rim.tools.compiler.codfile.Routine _ZIa5(int i)
    {
        return (net.rim.tools.compiler.codfile.Routine)_routines.elementAt(i);
    }

    public abstract net.rim.tools.compiler.codfile.Routine getRoutine(int i, net.rim.tools.compiler.codfile.ClassDef u1);

    public net.rim.tools.compiler.codfile.Routine find(int __offset)
    {
        return (net.rim.tools.compiler.codfile.Routine)_routines.findItem(__offset);
    }
}
