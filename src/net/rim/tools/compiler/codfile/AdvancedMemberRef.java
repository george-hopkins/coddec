package net.rim.tools.compiler.codfile;

import java.io.IOException;

import net.rim.tools.compiler.io.StructuredOutputStream;

public class AdvancedMemberRef extends MemberRef {
	protected TypeList _advancedTypeList;
	private boolean _needAdvancedTypeList;
	protected int _advancedListOffset;
	/*
    public AdvancedMemberRef(ClassDef u, ClassRef au, Identifier ak, TypeList p, TypeList p1)
    {
        super(u, au, ak, p);
        _advancedTypeList = p1;
        _needAdvancedTypeList = false;
    }
    
    public AdvancedMemberRef(ClassRef classRef, Identifier name, int typeListOffset, int advancedListOffset)
    {
        super(classRef, name, typeListOffset);
        _advancedListOffset = advancedListOffset;
        _needAdvancedTypeList = false;
    }
*/
    public AdvancedMemberRef(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection)     	throws IOException
	{
    	int mbrOfs = __input.getOffset();
    	int crOfs = __input.readUnsignedShort();
    	int nmOfs = __input.readUnsignedShort();
    	int tlOfs = __input.readUnsignedShort();
    	int advTlOfs = __input.readUnsignedShort();
    	
    	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    	System.out.println("> ofs 0x" + Integer.toHexString(mbrOfs) + " -> CR 0x" + Integer.toHexString(crOfs));

    	_classRef = __dataSection.getClassRef(crOfs);
    	//_classRef = __dataSection.getClassRef(__input.readUnsignedShort());

    	System.out.println("In class(?) " + _classRef.getClassName().getString());

    	_name = __dataSection.getDataBytes().get_identifier(nmOfs);
    	System.out.println("member " + _name.getString());
    	
    	_typeListOffset = tlOfs;
    	_advancedListOffset = advTlOfs;
	}

    public void _akZV(DataSection dataSection, boolean flag, boolean flag1)
        throws java.io.IOException
    {
        super._akZV(dataSection, flag, flag1);
        _advancedTypeList = dataSection.getTypeLists().createTypeList(_advancedListOffset);
    }

    public void _aarV(net.rim.tools.compiler.codfile.ar ar)
    {
        net.rim.tools.compiler.codfile.aj aj1 = (net.rim.tools.compiler.codfile.aj)ar;
        super._memeber = aj1._aupr(super._classDef, super._name, super._typeList, _advancedTypeList);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream output)
        throws java.io.IOException
    {
        setOffset(output);
        super._classRef.writeOffset(output);
        super._name.writeOffset(output);
        super._typeList.writeOffset(output);
        if(_needAdvancedTypeList)
            _advancedTypeList.writeOffset(output);
        setExtent(output);
    }

    public void _mthif(net.rim.tools.compiler.codfile.DataSection k1)
    {
        _needAdvancedTypeList = k1.isVersion6();
    }

    public static int _SvI()
    {
        return 8;
    }
}
