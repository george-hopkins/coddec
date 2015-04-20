// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            u, z, ab, o,
//            a5, ap, k, a1,
//            ak, af, ai, w,
//            a4, r, p

public final class ClassDefLocal extends net.rim.tools.compiler.codfile.ClassDef
{

    private net.rim.tools.compiler.codfile.ClassDef _superClass;
    private int _staticStart;
    private net.rim.tools.compiler.codfile.Routine _clinit;
    private net.rim.tools.compiler.codfile.Routine _init;
    private int f_createSize;
    private int _secureIndex;
    private int _offsetVirtualRoutines;
    private net.rim.tools.compiler.codfile.CodfileArray _virtualRoutines;
    private int _offsetNonVirtualRoutines;
    private net.rim.tools.compiler.codfile.CodfileArray _nonVirtualRoutines;
    private int _offsetStaticRoutines;
    private net.rim.tools.compiler.codfile.CodfileArray _staticRoutines;
    private int _codestart;
    private int _codeend;
    private int _attributes;
    private int _offsetInterfaces;
    private net.rim.tools.compiler.codfile.CodfileArray _interfacesImplemented;
    private int _offsetFieldsDefinitions;
    private int _offsetStaticFieldsDefinitions;
    private int _offsetFieldDefenitionAttributes;
    private int _offsetStaticFieldDefAttributes;
    private boolean z_guZ;
    private int _index;
    private String _weights;
    public static final int z_gkI = 40;

    private void resetLocalCounters()
    {
        f_createSize = -1;
        _codestart = 65535;
        _codeend = 0;
    }

    public ClassDefLocal(net.rim.tools.compiler.codfile.DataSection k1, String s, String s1)
    {
        super(k1, s, s1);
        resetLocalCounters();
    }

    public ClassDefLocal(net.rim.tools.compiler.codfile.DataSection k1, int param_Offset)
        throws IOException
    {
        super(k1, param_Offset);
        resetLocalCounters();
    }

    public void setWeight(String s)
    {
        _weights = s;
    }

    void read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection)
        throws IOException
    {
        __input.verifyOffset(super._offset, "class def");
        DataBytes _dataBytes_ = __dataSection.getDataBytes();
        super._packageName = _dataBytes_.get_identifier(__input.readUnsignedShort()); //offset for part of obfuscated string
        super._className = _dataBytes_.get_identifier(__input.readUnsignedShort()); //offset for second part of obfuscted string
        setName(super._packageName.getString(), super._className.getString());
        __input.skipBytes(10);
        _secureIndex = __input.readUnsignedShort();
        _index = __input.readUnsignedShort();
        _codestart = __input.readUnsignedShort();
        _codeend = __input.readUnsignedShort();
        _attributes = __input.readUnsignedShort();
    }

    void readClass(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection)
        throws IOException
    {
        if(z_guZ)
            return;
        z_guZ = true;
        __input.verifyOffset(super._offset, "class def");
        __input.skipBytes(4);
        _superClass = __dataSection.findClassDef(__input.readUnsignedByte(), __input.readUnsignedByte());
        _staticStart = __input.readUnsignedShort();
        int j = __input.readUnsignedShort();
        if(j == 0)
            _clinit = super._nullRoutine;
        else
            _clinit = new RoutineLocal(this, j);
        j = __input.readUnsignedShort();
        if(j == 0)
            _init = super._nullRoutine;
        else
            _init = new RoutineLocal(this, j);
        f_createSize = __input.readUnsignedShort();
        _secureIndex = __input.readUnsignedShort();
        _index = __input.readUnsignedShort();
        _codestart = __input.readUnsignedShort();
        _codeend = __input.readUnsignedShort();
        _attributes = __input.readUnsignedShort();
        _offsetVirtualRoutines = __input.readUnsignedShort() + super._offset;
        _offsetNonVirtualRoutines = __input.readUnsignedShort() + super._offset;
        _offsetStaticRoutines = __input.readUnsignedShort() + super._offset;
        _offsetFieldsDefinitions = __input.readUnsignedShort() + super._offset;
        _offsetStaticFieldsDefinitions = __input.readUnsignedShort() + super._offset;
        _offsetInterfaces = __input.readUnsignedShort() + super._offset;
        _offsetFieldDefenitionAttributes = __input.readUnsignedShort() + super._offset;
        _offsetStaticFieldDefAttributes = __input.readUnsignedShort() + super._offset;
        readRoutine(__input, _offsetVirtualRoutines, _offsetNonVirtualRoutines, false, true);
        readRoutine(__input, _offsetNonVirtualRoutines, _offsetStaticRoutines, false, false);
        readRoutine(__input, _offsetStaticRoutines, _offsetFieldsDefinitions, true, false);
        readFieldDefs(__input, __dataSection, _offsetFieldsDefinitions, _offsetStaticFieldsDefinitions, false);
        readFieldDefs(__input, __dataSection, _offsetStaticFieldsDefinitions, _offsetInterfaces, true);
        readInterfaces(__input, __dataSection, _offsetFieldDefenitionAttributes);
        readFieldFlags(__input, super._fieldDefs, _offsetFieldDefenitionAttributes);
        readFieldFlags(__input, super._staticFieldDefs, _offsetStaticFieldDefAttributes);
    }

    private void readRoutine(net.rim.tools.compiler.io.StructuredInputStream __input, int __startOffset, int __endOffset, boolean __isStatic, boolean __isVirtual)
        throws IOException
    {
        int _numRoutines_ = (__endOffset - __startOffset) / 2;
        if(_numRoutines_ > 0)
        {
            int _clinitOffset_ = _clinit.getOffset();
            int _initOffset_ = _init.getOffset();
            net.rim.tools.compiler.codfile.CodfileArray _codFileArray_ = null;
            if(__isStatic)
            {
                allocateStaticRoutines(_numRoutines_);
                _codFileArray_ = _staticRoutines;
            } else
            if(__isVirtual)
            {
                allocateVirtualRoutines(_numRoutines_);
                _codFileArray_ = _virtualRoutines;
            } else
            {
                allocateNonVirtualRoutines(_numRoutines_);
                _codFileArray_ = _nonVirtualRoutines;
            }
            __input.verifyOffset(__startOffset, "routine");
            for(int l1 = 0; l1 < _numRoutines_; l1++)
            {
                int _offset_ = __input.readUnsignedShort();
                RoutineLocal _routineLocal_;
                if(__isStatic && _offset_ == _clinitOffset_)
                    _routineLocal_ = (RoutineLocal)_clinit;
                else
                if(__isStatic && _offset_ == _initOffset_)
                    _routineLocal_ = (RoutineLocal)_init;
                else
                    _routineLocal_ = new RoutineLocal(this, _offset_);
                _routineLocal_.setOrdinal(_codFileArray_.getExtent());
                _codFileArray_.addItem(_routineLocal_);
                super._module._trya5V(_routineLocal_);
            }

        }
    }

    private void readFieldDefs(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection k1, int j, int l, boolean isStatic)
        throws IOException
    {
        __input.verifyOffset(j, "field def");
        int i1 = (l - j) / net.rim.tools.compiler.codfile.FieldDefLocal.elementSize(isStatic);
        allocateFieldDefs(i1, isStatic);
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.codfile.FieldDefLocal ab1 = new net.rim.tools.compiler.codfile.FieldDefLocal(__input, k1, this, isStatic);
            addFieldDef(ab1, isStatic);
        }

    }

    private void readInterfaces(net.rim.tools.compiler.io.StructuredInputStream __input, DataSection __dataSection, int j)
        throws IOException
    {
        __input.verifyOffset(_offsetInterfaces, "interfaces implemented");
        int l = (j - _offsetInterfaces) / 2;
        allocateInterfaces(l);
        for(int i1 = 0; i1 < l; i1++)
        {
            ClassDef _classDef_ = __dataSection.findClassDef(__input.readUnsignedByte(), __input.readUnsignedByte());
            addInterface(_classDef_, __dataSection);
        }

    }

    private void readFieldFlags(net.rim.tools.compiler.io.StructuredInputStream a2, CodfileArray o1, int j)
        throws IOException
    {
        a2.verifyOffset(j, "field flags");
        int l = o1.getExtent();
        for(int i1 = 0; i1 < l; i1++)
            ((FieldDefLocal)o1.getItem(i1)).setAttributes(a2.readUnsignedByte());

    }

    public void _forkBIV(net.rim.tools.compiler.codfile.DataSection __dataSection, byte __data[], int j)
    {
        int l = super._offset + j;
        l += 4;
        __dataSection._doaBIV(__data, l);
        l += 12;
        __data[l++] = 0;
        __data[l++] = 0;
        l += 16;
        _offsetInterfaces = (__data[l++] & 0xff) + (__data[l++] << 8);
        int i1 = (__data[l++] & 0xff) + (__data[l++] << 8);
        int j1 = (i1 - _offsetInterfaces) / 2;
        l = super._offset + j + _offsetInterfaces;
        for(int l1 = 0; l1 < j1; l1++)
        {
            __dataSection._doaBIV(__data, l);
            l += 2;
        }

    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeSlack(2);
        setOffset(c1);
        writeLocalOffset(c1);
        super._packageName.writeOffset(c1);
        super._className.writeOffset(c1);
        c1.empty_func7();
        _superClass.writeAbsoluteClassDef(c1);
        c1.writeShort(_staticStart, " staticstart", false);
        if(_weights != null)
            c1.writeString(_weights);
        c1.empty_func7();
        if(_clinit.getOffset() == -1)
            c1.writeShort(0, "<clinit>", false);
        else
            _clinit._trycV(c1);
        if(_init.getOffset() == -1)
            c1.writeShort(0, "<init>", false);
        else
            _init._trycV(c1);
        c1.empty_func7();
        c1.writeShort(f_createSize, "createsize=", true);
        c1.writeShort(_secureIndex, "secureindex=", true);
        c1.writeShort(_index, "index=", true);
        c1.empty_func7();
        c1.writeShort(_codestart, "codestart=", true);
        c1.writeShort(_codeend, "codeend=", true);
        if(_weights != null)
            c1.writeString(" codesize: " + (_codeend - _codestart));
        c1.empty_func7();
        writeAttributes(c1);
        c1.writeShort(_offsetVirtualRoutines - super._offset, "virtual routines", false);
        c1.empty_func7();
        c1.writeShort(_offsetNonVirtualRoutines - super._offset, "non-virtual routines", false);
        c1.empty_func7();
        c1.writeShort(_offsetStaticRoutines - super._offset, "static routines", false);
        c1.empty_func7();
        c1.writeShort(_offsetFieldsDefinitions - super._offset, "field definitions", false);
        c1.empty_func7();
        c1.writeShort(_offsetStaticFieldsDefinitions - super._offset, "static field definitions", false);
        c1.empty_func7();
        c1.writeShort(_offsetInterfaces - super._offset, "implemented interfaces", false);
        c1.empty_func7();
        c1.writeShort(_offsetFieldDefenitionAttributes - super._offset, "field definition attributes", false);
        c1.empty_func7();
        c1.writeShort(_offsetStaticFieldDefAttributes - super._offset, "static field definition attributes", false);
        c1.empty_func7();
        _offsetVirtualRoutines = c1.getOffset();
        if(_virtualRoutines != null)
            _virtualRoutines._ncV(c1);
        _offsetNonVirtualRoutines = c1.getOffset();
        if(_nonVirtualRoutines != null)
            _nonVirtualRoutines._ncV(c1);
        _offsetStaticRoutines = c1.getOffset();
        if(_staticRoutines != null)
            _staticRoutines._ncV(c1);
        _offsetFieldsDefinitions = c1.getOffset();
        if(super._fieldDefs != null)
            super._fieldDefs.write(c1);
        _offsetStaticFieldsDefinitions = c1.getOffset();
        if(super._staticFieldDefs != null)
            super._staticFieldDefs.write(c1);
        _offsetInterfaces = c1.getOffset();
        if(_interfacesImplemented != null)
            _interfacesImplemented._ocV(c1);
        _offsetFieldDefenitionAttributes = c1.getOffset();
        c1.empty_func11("field definition attributes");
        c1.empty_func();
        if(super._fieldDefs != null)
        {
            int j = super._fieldDefs.getExtent();
            for(int i1 = 0; i1 < j; i1++)
            {
                FieldDefLocal ab1 = (FieldDefLocal)super._fieldDefs.getItem(i1);
                ab1._gotocV(c1);
            }

        }
        c1.empty_func2();
        _offsetStaticFieldDefAttributes = c1.getOffset();
        c1.empty_func11("static field definition attributes");
        c1.empty_func();
        if(super._staticFieldDefs != null)
        {
            int l = super._staticFieldDefs.getExtent();
            for(int j1 = 0; j1 < l; j1++)
            {
                FieldDefLocal ab2 = (FieldDefLocal)super._staticFieldDefs.getItem(j1);
                ab2._gotocV(c1);
            }

        }
        c1.empty_func2();
        setExtent(c1);
    }

    public void writeAttributes(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int j = _attributes;
        if((j & 0x200) != 0)
            c1.writeString("IsInner ");
        if((j & 0x100) != 0)
            c1.writeString("IsUnGroupable ");
        if((j & 0x80) != 0)
            c1.writeString("IsPersistable ");
        if((j & 0x40) != 0)
            c1.writeString("HasVerifyError ");
        if((j & 0x20) != 0)
            c1.writeString("IsInterface ");
        if((j & 0x10) != 0)
            c1.writeString("IsAbstract ");
        if((j & 1) != 0)
            c1.writeString("IsPublic ");
        if((j & 2) != 0)
            c1.writeString("IsPrivate ");
        if((j & 4) != 0)
            c1.writeString("IsProtected ");
        if((j & 8) != 0)
            c1.writeString("IsFinal ");
        c1.writeShort(j & 0xffff, "attributes=", true);
        c1.empty_func7();
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeRelativeOrdinal(c1);
    }

    public void writeRelativeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeByte(super._ordinal, super._nameS);
    }

    public void writeAbsoluteClassDef(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeModuleOrdinal(c1);
        c1.writeByte(super._ordinal, super._nameS);
    }

    public void setSuperClass(net.rim.tools.compiler.codfile.ClassDef __classDef, net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        __classDef.makeSymbolic(__dataSection);
        _superClass = __classDef;
    }

    public net.rim.tools.compiler.codfile.ClassDef getSuperClass()
    {
        return _superClass;
    }

    public void allocateInterfaces(int j)
    {
        if(j > 0 && _interfacesImplemented == null)
        {
            _interfacesImplemented = new net.rim.tools.compiler.codfile.CodfileArray(j);
            _interfacesImplemented.setName("implemented interfaces");
        }
    }

    public void addInterface(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.DataSection k1)
    {
        u1.makeSymbolic(k1);
        _interfacesImplemented.addItem(u1);
    }

    public int getNumInterfaces()
    {
        return _interfacesImplemented != null ? _interfacesImplemented.getExtent() : 0;
    }

    public net.rim.tools.compiler.codfile.ClassDef getInterface(int j)
    {
        return (net.rim.tools.compiler.codfile.ClassDef)_interfacesImplemented.getItem(j);
    }

    public void set_createSize(int j)
    {
        f_createSize = j;
    }

    public void setStaticStart(int j)
    {
        _staticStart = j;
    }

    public void setSecureIndex(int __secureIndex)
    {
        _secureIndex = __secureIndex;
    }

    public int getSecureIndex()
    {
        return _secureIndex;
    }

    public void setClinit(net.rim.tools.compiler.codfile.Routine __routine)
    {
        _clinit = __routine;
    }
	
	public net.rim.tools.compiler.codfile.Routine getClinit ()
	{
		return _clinit;
	}
	

    public void setInit(net.rim.tools.compiler.codfile.Routine __routine)
    {
        _init = __routine;
    }
	
	public net.rim.tools.compiler.codfile.Routine getInit ()
	{
		return _init;
	}

    public int ratchetStartCodeOffset()
    {
        return _codestart;
    }

    public int ratchetEndCodeOffset()
    {
        return _codeend;
    }

    public void set_codeStart(int j)
    {
        if(j < _codestart)
            _codestart = j;
    }

    public void set_codeEnd(int j)
    {
        if(j > _codeend)
            _codeend = j;
    }

    public void setAttributes(int j)
    {
        _attributes |= j;
    }

    public int getAttributes()
    {
        return _attributes;
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(int j, boolean flag)
    {
        FieldDef w1 = super.createFieldDef(j, flag);
        if(w1 == null && _superClass != null && flag)
            w1 = _superClass.createFieldDef(j, flag);
        return w1;
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, boolean flag)
    {
        net.rim.tools.compiler.codfile.FieldDef w1 = super.makeFieldDef(ak1, p1, flag);
        if(w1 == null && _superClass != null && flag)
            w1 = _superClass.makeFieldDef(ak1, p1, flag);
        return w1;
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, boolean flag)
    {
        return new net.rim.tools.compiler.codfile.FieldDefLocal(this, ak1, p1, flag);
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p1, boolean flag1)
    {
        String s1 = flag ? null : s;
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        p1 = k1.getTypeLists().getTypeList(p1, k1, false);
        net.rim.tools.compiler.codfile.FieldDef w1 = createFieldDef(a1_1.getIdentifier(s1), p1, flag1);
        if(flag)
            w1.setName(s);
        return w1;
    }

    public net.rim.tools.compiler.codfile.Routine createRoutine(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2)
    {
        return new net.rim.tools.compiler.codfile.RoutineLocal(this, ak1, p1, p2);
    }

    public net.rim.tools.compiler.codfile.Routine makeRoutine(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2)
    {
        String s1 = flag ? null : s;
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.TypeLists ai1 = k1.getTypeLists();
        p1 = ai1.getTypeList(p1, k1, false);
        p2 = ai1.getTypeList(p2, k1, false);
        net.rim.tools.compiler.codfile.RoutineLocal z1 = (net.rim.tools.compiler.codfile.RoutineLocal)createRoutine(a1_1.getIdentifier(s1), p1, p2);
        net.rim.tools.compiler.codfile.Code a4_1 = z1.getCode();
        a4_1._tryZV(super._siblingFormat);
        a4_1._byteZV(k1._arvZ());
        if(flag)
            z1.setName(s);
        return z1;
    }

    public int getLibOff()
    {
        return 0;
    }

    private static net.rim.tools.compiler.codfile.Routine findRoutine(net.rim.tools.compiler.codfile.CodfileArray __codFileArray, net.rim.tools.compiler.codfile.Identifier __name, net.rim.tools.compiler.codfile.TypeList __typeList)
    {
        if(__codFileArray != null)
        {
            int j = __codFileArray.getExtent();
            for(int l = 0; l < j; l++)
            {
                net.rim.tools.compiler.codfile.Routine _routine_ = (net.rim.tools.compiler.codfile.Routine)__codFileArray.getItem(l);
                if(__name.equals(_routine_.getName()) && __typeList.equals(_routine_.getProtoTypeList()))
                    return _routine_;
            }

        }
        return null;
    }

    public void allocateVirtualRoutines(int j)
    {
        if(j > 0 && _virtualRoutines == null)
        {
            _virtualRoutines = new net.rim.tools.compiler.codfile.CodfileArray(j);
            _virtualRoutines.setName("virtual routines");
        }
    }

    public void addVirtualRoutine(net.rim.tools.compiler.codfile.Routine __routine)
    {
        __routine.setOrdinal(_virtualRoutines.getExtent());
        _virtualRoutines.addItem(__routine);
        if(__routine.getOffset() != -1)
            super._module._trya5V(__routine);
    }

    public int getNumVirtualRoutines()
    {
        return _virtualRoutines != null ? _virtualRoutines.getExtent() : 0;
    }

    public net.rim.tools.compiler.codfile.Routine getVirtualRoutine(int j)
    {
        if(j < 0 || _virtualRoutines == null || j >= _virtualRoutines.getExtent())
            return super._nullRoutine;
        else
            return (net.rim.tools.compiler.codfile.Routine)_virtualRoutines.getItem(j);
    }

    public net.rim.tools.compiler.codfile.Routine findVirtualRoutine(net.rim.tools.compiler.codfile.Identifier __identifier, net.rim.tools.compiler.codfile.TypeList __typeList)
    {
        return findRoutine(_virtualRoutines, __identifier, __typeList);
    }

    public net.rim.tools.compiler.codfile.Routine _MIa5(int j)
    {
        net.rim.tools.compiler.codfile.Routine _routine_ = null;
        if(_virtualRoutines != null)
            _routine_ = (net.rim.tools.compiler.codfile.Routine)_virtualRoutines._aIa9ap(j, null);
        if(_routine_ == null)
            _routine_ = super._nullRoutine;
        return _routine_;
    }

    public void allocateNonVirtualRoutines(int j)
    {
        if(j > 0 && _nonVirtualRoutines == null)
        {
            _nonVirtualRoutines = new net.rim.tools.compiler.codfile.CodfileArray(j);
            _nonVirtualRoutines.setName("non-virtual routines");
        }
    }

    public void addNonVirtualRoutine(net.rim.tools.compiler.codfile.Routine a5_1)
    {
        a5_1.setOrdinal(_nonVirtualRoutines.getExtent());
        _nonVirtualRoutines.addItem(a5_1);
        if(a5_1.getOffset() != -1)
            super._module._trya5V(a5_1);
    }

    public int get_nonVirtualRoutinesSize()
    {
        return _nonVirtualRoutines != null ? _nonVirtualRoutines.getExtent() : 0;
    }

    public net.rim.tools.compiler.codfile.Routine get_nonVirtualRoutine(int j)
    {
        if(j < 0 || _nonVirtualRoutines == null || j >= _nonVirtualRoutines.getExtent())
            return super._nullRoutine;
        else
            return (net.rim.tools.compiler.codfile.Routine)_nonVirtualRoutines.getItem(j);
    }

    public net.rim.tools.compiler.codfile.Routine findNonVirtualRoutine(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1)
    {
        return findRoutine(_nonVirtualRoutines, ak1, p1);
    }

    public net.rim.tools.compiler.codfile.Routine _NIa5(int j)
    {
        net.rim.tools.compiler.codfile.Routine a5_1 = null;
        if(_nonVirtualRoutines != null)
            a5_1 = (net.rim.tools.compiler.codfile.Routine)_nonVirtualRoutines._aIa9ap(j, null);
        if(a5_1 == null)
            a5_1 = super._nullRoutine;
        return a5_1;
    }

    public void allocateStaticRoutines(int j)
    {
        if(j > 0 && _staticRoutines == null)
        {
            _staticRoutines = new net.rim.tools.compiler.codfile.CodfileArray(j);
            _staticRoutines.setName("static routines");
        }
    }

    public void addStaticRoutine(net.rim.tools.compiler.codfile.Routine a5_1)
    {
        a5_1.setOrdinal(_staticRoutines.getExtent());
        _staticRoutines.addItem(a5_1);
        if(a5_1.getOffset() != -1)
            super._module._trya5V(a5_1);
    }

    public int get_staticRoutinesSize()
    {
        return _staticRoutines != null ? _staticRoutines.getExtent() : 0;
    }

    public net.rim.tools.compiler.codfile.Routine getStaticRoutine(int j)
    {
        if(j < 0 || _staticRoutines == null || j >= _staticRoutines.getExtent())
            return super._nullRoutine;
        else
            return (net.rim.tools.compiler.codfile.Routine)_staticRoutines.getItem(j);
    }

    public net.rim.tools.compiler.codfile.Routine _aaka5(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1)
    {
        net.rim.tools.compiler.codfile.Routine _Routine_ = findRoutine(_staticRoutines, ak1, p1);
        if(_Routine_ == null)
            if(_superClass != null)
            {
                if(_superClass instanceof net.rim.tools.compiler.codfile.ClassDefLocal)
                {
                    net.rim.tools.compiler.codfile.ClassDefLocal _ClassDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)_superClass;
                    _Routine_ = _ClassDefLocal_._aaka5(ak1, p1);
                } else
                {
                    _Routine_ = _superClass.createRoutine(ak1, null, p1);
                    _Routine_.setAddress(-1);
                    Module _Module_ = _superClass.getModule();
                    if(_Module_ != null)
                    {
                        _Routine_.setOffset(_Module_._a4vI() + 0x10000);
                        _Module_._trya5V(_Routine_);
                    }
                }
            } else
            {
                _Routine_ = super._nullRoutine;
            }
        return _Routine_;
    }

    public Routine _LIa5(int j)
    {
        Routine _Routine_ = null;
        if(_staticRoutines != null)
            _Routine_ = (Routine)_staticRoutines._aIa9ap(j, null);
        if(_Routine_ == null)
            _Routine_ = super._nullRoutine;
        return _Routine_;
    }

    public void harvestRoutines(Vector vector)
    {
        boolean flag = false;
        if(_virtualRoutines != null)
        {
            int j = _virtualRoutines.getExtent();
            for(int j1 = 0; j1 < j; j1++)
            {
                flag = true;
                vector.addElement(_virtualRoutines.getItem(j1));
            }

        }
        if(_nonVirtualRoutines != null)
        {
            int l = _nonVirtualRoutines.getExtent();
            for(int k1 = 0; k1 < l; k1++)
            {
                flag = true;
                vector.addElement(_nonVirtualRoutines.getItem(k1));
            }

        }
        if(_staticRoutines != null)
        {
            int i1 = _staticRoutines.getExtent();
            for(int l1 = 0; l1 < i1; l1++)
            {
                flag = true;
                vector.addElement(_staticRoutines.getItem(l1));
            }

        }
        if(!flag)
            vector.addElement(super._nullRoutine);
    }
}
