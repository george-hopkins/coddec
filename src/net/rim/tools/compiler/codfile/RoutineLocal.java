// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            a5, a4, a2, a3,
//            i, k, ax, o,
//            ap, ai, r, a1,
//            ak, p, u

public final class RoutineLocal extends net.rim.tools.compiler.codfile.Routine
{
	
    public static final int z_f0I = 14;
    public static final int z_f1I = 9;
    private static final int z_fSI = 6;
    private static final int z_fUI = 4;
    private net.rim.tools.compiler.codfile.CodfileArray _stackMap;
    private int _attributes;
    private int _maxLocals;
    private int _maxStack;
    private net.rim.tools.compiler.codfile.Code _Code;
    private net.rim.tools.compiler.codfile.CodfileArray _exceptionHandlers;
    private int _byteCodeWeight;
    private boolean z_fTZ;
    private boolean z_fXZ;
    private String _weights;

    private void createCode()
    {
        _Code = new net.rim.tools.compiler.codfile.Code();
    }

    public RoutineLocal(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2)
    {
        super(u1, ak1, p1, p2);
        createCode();
    }

    public RoutineLocal(net.rim.tools.compiler.codfile.ClassDef __classDef, int j)
    {
        super(__classDef, j);
        createCode();
    }

    public void setWeights(String s)
    {
        _weights = s;
    }

    void read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, boolean __hasHeader)
        throws IOException
    {
        int _offset_ = __input.getOffset(); //_gyII
        __input.moveCurrentIdxtoOffset(super._offset - 5);//_cyII
        boolean flag1 = __input.readUnsignedByte() > 1; //_gAvI
        int _offsetHeader_ = super._offset - (flag1 ? 9 : 14);
        if(__hasHeader)
        {
            __input.moveCurrentIdxtoOffset(_offsetHeader_);
        } else
        {
            __input.moveCurrentIdxtoOffset(_offset_);
            int i1 = (_offsetHeader_ - _offset_) / StackMap.getEntrySize();
            allocateStackMaps(i1);
            for(int j1 = 0; j1 < i1; j1++)
                addStackMap(new StackMap(__input, __dataSection, super._offset));

        }
        __input.verifyOffset(_offsetHeader_, "routine header");
        TypeLists _typeLists_ = __dataSection.getTypeLists();
        int l1;
        int i2;
        if(flag1)
        {
            super._typeList = _typeLists_.createTypeList(__input.readUnsignedShort());//_gsvI
            super._protoTypeList = _typeLists_.createTypeList(__input.readUnsignedShort());
            l1 = __input.readUnsignedByte() - 2;
            _byteCodeWeight = l1;
            _attributes = __input.readUnsignedByte();
            super._name = __dataSection.getDataBytes().get_identifier(__input.readUnsignedShort());
            int j2 = __input.readUnsignedByte();
            i2 = j2 >> 6 & 3;
            _maxLocals = j2 >> 4 & 3;
            _maxStack = j2 >> 0 & 3;
        } else
        {
            super._name = __dataSection.getDataBytes().get_identifier(__input.readUnsignedShort());
            super._protoTypeList = _typeLists_.createTypeList(__input.readUnsignedShort());
            super._typeList = _typeLists_.createTypeList(__input.readUnsignedShort());
            l1 = __input.readUnsignedShort();
            _byteCodeWeight = 254;
            _attributes = __input.readUnsignedShort();
            i2 = __input.readUnsignedByte();
            _maxLocals = __input.readUnsignedByte();
            __input.readUnsignedByte();
            _maxStack = __input.readUnsignedByte();
        }
        if(!__hasHeader)
        {
            String s = super._name.getString();
            if(s.length() == 0)
                _ifStringvV("routine_", super._offset);
            else
                setName(s);
        }
        super._parmLocalCount = super._protoTypeList._axvI();
        if(!__hasHeader && i2 != getNumStack())
            throw new IOException("incorrect number of stack maps");
        _Code = new Code(__input, l1, __dataSection, this, __hasHeader);
        if(__dataSection.getCodFileVersion() < 78)
        {
            __input.verifySlack(2);
            z_fXZ = true;
        }
        if((_attributes & 0x40) != 0)
        {
            if(!__hasHeader)
                allocateExceptionHandlers(8);
            for(int k2 = __input.readUnsignedShort(); k2 != 65535; k2 = __input.readUnsignedShort())
                if(__hasHeader)
                    ExceptionHandler._aaV(__input);
                else
                    addExceptionHandler(new ExceptionHandler(__input, __dataSection, k2, super._offset));

        }
    }

    public void _dokBIV(net.rim.tools.compiler.codfile.DataSection __dataSection, byte __data[], int __offset)
    {
        int _offset_ = super._offset + __offset;
        int j1;
        int l1;
        if((__data[_offset_ - 5] & 0xff) >= 2)
        {
            _offset_ -= 5;
            j1 = __data[_offset_++] & 0xff;
            l1 = __data[_offset_++] & 0xff;
        } else
        {
            _offset_ -= 8;
            j1 = (__data[_offset_++] & 0xff) + (__data[_offset_++] << 8);
            l1 = (__data[_offset_++] & 0xff) + (__data[_offset_++] << 8);
        }
        if((l1 & 0x40) != 0)
        {
            int i1 = super._offset + __offset + j1;
            if(__dataSection.getCodFileVersion() < 78)
                i1 += i1 & 1;
            for(int i2 = (__data[i1++] & 0xff) + (__data[i1++] << 8) & 0xffff; i2 != 65535; i2 = (__data[i1++] & 0xff) + (__data[i1++] << 8) & 0xffff)
                i1 += ExceptionHandler._akBII(__dataSection, __data, i1);

        }
    }

    public void setByteCodeWeight(int j)
    {
        _byteCodeWeight = j;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeLocalOffset(c1);
        int j = c1.getOffset();
        ((ClassDefLocal)super._classDef).set_codeStart(j);
        int l = getNumStack();
        boolean flag = false;
        if(_attributes <= 255 && _byteCodeWeight <= 253 && l <= 3 && super._parmLocalCount <= 3 && _maxStack <= 3 && _maxLocals <= 3 && _Code._btvZ())
            flag = true;
        int i1 = j + l * StackMap.getEntrySize() + (flag ? 9 : 14);
        if(l > 0)
            _stackMap._ifcvV(c1, i1);
        if(flag)
        {
            _Code._bsvV();
            super._typeList._acV(c1, "returns: ");
            super._protoTypeList._acV(c1, "prototype: ");
            c1.empty_func7();
            c1.writeByte(_Code.getExtent() + 2 & 0xff, "codesize=", true);
            c1.writeString("(" + _Code.getExtent() + ") ");
            writeAttrbiutes(c1);
            c1.writeByte(_attributes & 0xff, "attributes=", true);
            c1.empty_func7();
            c1.empty_func7();
            super._name.writeOffset(c1);
            c1.empty_func7();
            c1.writeString("numstackmaps=" + l);
            c1.writeString(" locals=" + (_maxLocals & 0xff));
            c1.writeString(" parms=" + (super._parmLocalCount & 0xff));
            c1.writeString(" stack=" + (_maxStack & 0xff));
            int j1 = (l << 6) + (_maxLocals << 4) + (super._parmLocalCount << 2) + (_maxStack << 0);
            c1.writeByte(j1 & 0xff, " nlps=", true);
        } else
        {
            super._name.writeOffset(c1);
            super._protoTypeList._acV(c1, "prototype: ");
            super._typeList._acV(c1, "returns: ");
            c1.empty_func7();
            c1.writeShort(_Code.getExtent(), "codesize=", true);
            writeAttrbiutes(c1);
            c1.writeShort(_attributes & 0xffff, "attributes=", true);
            c1.empty_func7();
            c1.empty_func7();
            c1.writeByte(l & 0xff, "numstackmaps=", true);
            c1.writeByte(_maxLocals & 0xff, "locals=", true);
            c1.writeByte(super._parmLocalCount & 0xff, "parms=", true);
            c1.writeByte(_maxStack & 0xff, "stack=", true);
        }
        if(_weights != null)
            c1.writeString(_weights);
        c1.empty_func7();
        c1.check_badStreamOffset(i1, get_name_1());
        setOffset(c1);
        try
        {
            _Code.write(c1);
        }
        catch(IOException ioexception)
        {
            throw new IOException(ioexception.getMessage() + " in: " + super._classDef.get_name_2() + "." + super._name.getString());
        }
        Object obj = c1.getCookie();
        if(obj != null)
        {
            DataSection k1 = (DataSection)obj;
            if(k1.getCodFileVersion() < 78)
                z_fXZ = true;
        }
        if(z_fXZ)
            c1.writeSlack(2);
        int l1 = getNumExceptionHandlers();
        if(l1 > 0)
        {
            _exceptionHandlers._ifcvV(c1, i1);
            c1.writeShort(65535);
            c1.empty_func7();
        }
        ((ClassDefLocal)super._classDef).set_codeEnd(c1.getOffset());
        setExtent(c1.getOffset() - j);
    }

    private void writeAttrbiutes(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int j = _attributes;
        if((j & 0x10) != 0)
            c1.writeString("IsStaticMethod ");
        if((j & 0x20) != 0)
            c1.writeString("IsAbstractMethod ");
        if((j & 0x40) != 0)
            c1.writeString("IsExceptional ");
        if((j & 0x100) != 0)
            c1.writeString("IsClinit ");
        if((j & 0x80) != 0)
            c1.writeString("IsInit ");
        if((j & 1) != 0)
            c1.writeString("IsPublic ");
        if((j & 2) != 0)
            c1.writeString("IsPrivate ");
        if((j & 4) != 0)
            c1.writeString("IsProtected ");
        if((j & 8) != 0)
            c1.writeString("IsFinal ");
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        if(u1 instanceof ClassDefNull)
            u1 = super._classDef;
        else
        if(super._classDef instanceof ClassDefNull)
            super._classDef = u1;
        if(u1 == super._classDef)
        {
            u1.writeOrdinal(c1);
            c1.writeShort(super._offset, get_name_1(), false);
        } else
        {
            int j = addStaticFixup(c1, u1);
            c1.writeShort(-1, u1.get_name_2(), false);
            c1.writeShort(j, get_name_1(), false);
        }
    }

    public void writeNativeInvoke(net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        z_fTZ = true;
        __output.writeShort(-1, get_name_1(), false);
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        super.writeFixups(k1);
        if(z_fTZ && !k1.getAliasesFlag())
            k1._aa5V(this);
    }

    public net.rim.tools.compiler.codfile.Code getCode()
    {
        return _Code;
    }

    public void setAttributes(int j)
    {
        _attributes |= j;
    }

    public void setNumLocals(int __maxLocals)
    {
        _maxLocals = __maxLocals;
    }

    public void setNumStack(int __maxStack)
    {
        _maxStack = __maxStack;
    }

    public int getAttributes()
    {
        return _attributes;
    }

    public int getMaxLocals()
    {
        return _maxLocals;
    }

    public int getStackMaps()
    {
        return _maxStack;
    }

    public int getNumStack()
    {
        return _stackMap != null ? _stackMap.getExtent() : 0;
    }

    public void allocateStackMaps(int __value)
    {
        if(__value > 0 && _stackMap == null)
        {
            _stackMap = new CodfileArray(__value);
            _stackMap.setName("stack map table");
        }
    }

    public void addStackMap(net.rim.tools.compiler.codfile.StackMap a2_1)
    {
        _stackMap.addItem(a2_1);
    }

    public int getNumExceptionHandlers()
    {
        return _exceptionHandlers != null ? _exceptionHandlers.getExtent() : 0;
    }

    public void allocateExceptionHandlers(int __value)
    {
        if(__value > 0 && _exceptionHandlers == null)
        {
            setAttributes(64);
            _exceptionHandlers = new CodfileArray(__value);
            _exceptionHandlers.setName("exception handler table");
        }
    }

    public void addExceptionHandler(net.rim.tools.compiler.codfile.ExceptionHandler __exceptionHandler)
    {
        _exceptionHandlers.addItem(__exceptionHandler);
    }
	
	public net.rim.tools.compiler.codfile.CodfileArray getExceptionHandlers()
	{
		return _exceptionHandlers;
	}
}
