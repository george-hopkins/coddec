// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;
import net.rim.tools.compiler.io.*;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, ag, a1, ai,
//            ax, ah, at, m,
//            az, i, s, au,
//            y, af, g, v,
//            aj, b, a0, a8,
//            j, an, aw, n,
//            a5, w, ab, h,
//            av, u, aa, ar,
//            r, ak, as, p

public final class DataSection extends net.rim.tools.compiler.codfile.CodfileItem
{
	
    private net.rim.tools.compiler.codfile.Codfile _codFile;
    private int _Flags;
    private int _Version;
    private net.rim.tools.compiler.codfile.CodfileVector _modules;
    private net.rim.tools.compiler.codfile.CodfileVector _sibblings;
    private net.rim.tools.compiler.codfile.CodfileVector _aliases;
    private int _iCallsNumber;
    private int _staticSize;
    private net.rim.tools.compiler.codfile.Module _Module;
    private net.rim.tools.compiler.codfile.ClassDef _ClassDef;
    private net.rim.tools.compiler.codfile.ClassRef _ClassRef;
    private net.rim.tools.compiler.codfile.Routine _Routine;
    private net.rim.tools.compiler.codfile.InterfaceMethodRef _InterfaceMethodRef;
    private net.rim.tools.compiler.codfile.EntryPoint _EntryPoint1;
    private net.rim.tools.compiler.codfile.EntryPoint _EntryPoint2;
    private net.rim.tools.compiler.codfile.CodfileVector _exportStrings;
    private net.rim.tools.compiler.codfile.DataBytes _DataBytes;
    private net.rim.tools.compiler.codfile.CodfileVector _initializatedStaticData;
    private net.rim.tools.compiler.codfile.CodfileVector _initializatedStaticStrings;
    private net.rim.tools.compiler.codfile.CodfileVector _classDefs;
    private int _classDefNumber;
    private net.rim.tools.compiler.codfile.CodfileVector _classRefs;
    private net.rim.tools.compiler.codfile.CodfileVector _interfaceMethodRefs;
    private net.rim.tools.compiler.codfile.TypeLists _TypeLists;
    private net.rim.tools.compiler.codfile.CodfileVector _routineFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _staticRoutineFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _virtualRoutineFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _classCodeFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _fieldsFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _localFieldsFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _staticFieldsFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _moduleCodeFixups;
    private boolean z_eGZ;
    private boolean z_e4Z;
    private boolean z_ePZ;
    private boolean _aliasesFlag;
    private boolean z_eYZ;
    private boolean z_e7Z;
    private net.rim.tools.compiler.codfile.CodfileVector _fixedFields;
    private net.rim.tools.compiler.codfile.CodfileVector _classDataFixups;
    private net.rim.tools.compiler.codfile.CodfileVector _nativeRoutines;
    private boolean z_faZ;
    private boolean z_eNZ;
    private boolean z_eSZ;
    private int z_fcI;
    private net.rim.tools.compiler.io.StructuredInputStream _input;
    private byte z_ezaaB[][];
    public static final int z_fkI = 0;
    public static final int z_eEI = 1;
    public static final int z_e8I = 2;

    public DataSection(net.rim.tools.compiler.codfile.Codfile __codFile)
    {
        _codFile = __codFile;
        _modules = new net.rim.tools.compiler.codfile.CodfileVector();
        _sibblings = new net.rim.tools.compiler.codfile.CodfileVector();
        _aliases = new net.rim.tools.compiler.codfile.CodfileVector(2);
        _exportStrings = new net.rim.tools.compiler.codfile.CodfileVector();
        _DataBytes = new net.rim.tools.compiler.codfile.DataBytes();
        _initializatedStaticData = new net.rim.tools.compiler.codfile.CodfileVector(2);
        _TypeLists = new net.rim.tools.compiler.codfile.TypeLists();
        _interfaceMethodRefs = new net.rim.tools.compiler.codfile.CodfileVector(2);
        _classDefs = new net.rim.tools.compiler.codfile.CodfileVector();
        _classRefs = new net.rim.tools.compiler.codfile.CodfileVector();
        _routineFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _staticRoutineFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _virtualRoutineFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _classCodeFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _fieldsFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _localFieldsFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _staticFieldsFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        z_eGZ = true;
        z_e4Z = true;
        _moduleCodeFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        net.rim.tools.compiler.codfile.Identifier ak1 = _DataBytes.getNullIdentifier();
        _ClassDef = new net.rim.tools.compiler.codfile.ClassDefNull(this, ak1, ak1);
        _Module = new net.rim.tools.compiler.codfile.ModuleNull(this);
        _ClassDef.setModule(_Module);
        _ClassRef = new net.rim.tools.compiler.codfile.ClassRef(this, _ClassDef);
        _Routine = new net.rim.tools.compiler.codfile.RoutineNull(_ClassDef, this);
        _InterfaceMethodRef = new net.rim.tools.compiler.codfile.InterfaceMethodRef(this, _Routine);
        super._nameS = "Data Section";
        _modules.setTableName("modules");
        _sibblings.setTableName("siblings");
        _aliases.setTableName("aliases");
        _exportStrings.setTableName("exported strings");
        _initializatedStaticData.setTableName("initialized static data");
        _interfaceMethodRefs.setTableName("interface method references");
        _classDefs.setTableName("class definitions");
        _classRefs.setTableName("class references");
        _routineFixups.setTableName("routine fixup table");
        _staticRoutineFixups.setTableName("static routine fixup table");
        _virtualRoutineFixups.setTableName("virtual routine fixup table");
        _classCodeFixups.setTableName("class code fixup table");
        _classDataFixups = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _classDataFixups.setTableName("class data fixup table");
        _fieldsFixups.setTableName("field fixup table");
        _localFieldsFixups.setTableName("local field fixup table");
        _fixedFields = new net.rim.tools.compiler.codfile.CodfileVector();
        _fixedFields.setTableName("fixed fields");
        _staticFieldsFixups.setTableName("static field fixup table");
        _nativeRoutines = new net.rim.tools.compiler.codfile.CodfileVector(2, true);
        _nativeRoutines.setTableName("native routine table");
        _moduleCodeFixups.setTableName("module code fixup table");
        _Version = 5;
    }

    public void read(net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        z_eNZ = flag;
        _Flags = __input.readUnsignedByte() & 0x37;
        _Version = __input.readUnsignedByte();
        z_eYZ = false;
        z_eGZ = false;
        z_e4Z = false;
        z_e7Z = false;
        if(_Version >= 4)
        {
            z_eYZ = true;
            z_e4Z = true;
            if(_Version >= 5)
            {
                z_e7Z = true;
                z_eGZ = true;
            }
        }
        if(!_aliasesFlag);
        _iCallsNumber = __input.readUnsignedShort();
        int _numModules_ = __input.readUnsignedByte();
        int _numClassDefs_ = __input.readUnsignedByte();
        _exportStrings.setOffset(__input.readUnsignedShort());
        _DataBytes.setOffset(__input.readUnsignedShort());
        __input.skipBytes(2);
        _classDefNumber = __input.readUnsignedShort();
        if(_aliasesFlag)
        {
            __input.skipBytes(14);
            _aliases.setOffset(__input.readUnsignedShort());
            __input.skipBytes(22);
        } else
        {
            __input.skipBytes(38);
        }
        for(int j1 = 0; j1 < _numClassDefs_; j1++)
        {
            ClassDefLocal _classDefLocal_ = new ClassDefLocal(this, __input.readUnsignedShort());
            _classDefLocal_.setOrdinal(j1);
            _classDefs.addElement(_classDefLocal_);
        }

        _modules.addElement(new net.rim.tools.compiler.codfile.ModuleLocal(__input, this, _classDefs, _codFile.getRoutines()));
        for(int _modIndex_ = 1; _modIndex_ < _numModules_; _modIndex_++)
        {
            Object obj = null;
            if(_YvZ())
                obj = new net.rim.tools.compiler.codfile.ModuleForeign(__input, this);
            else
                obj = new net.rim.tools.compiler.codfile.ModuleDomestic(__input, this);
            ((CodfileItem) (obj)).setOrdinal(_modIndex_);
            _modules.addElement(obj);
        }

        for(int i2 = 0; i2 < _numModules_; i2++)
        {
            net.rim.tools.compiler.codfile.Module _module_ = (net.rim.tools.compiler.codfile.Module)_modules.elementAt(i2);
            _module_.read(__input, this, _YvZ());
        }
//fill siblings Table
        if(_aliasesFlag)
        {
            for(int j2 = _aliases.getOffset(); __input.getOffset() < j2;)
            {
                int _aliasOffset_ = __input.readUnsignedShort();
                net.rim.tools.compiler.codfile.Literal _sibling_ = _DataBytes.createSibling(_aliasOffset_, false, false, false);
                _sibblings.addElement(_sibling_);
                for(int i3 = 1; i3 < _numModules_; i3++)
                {
                    net.rim.tools.compiler.codfile.Module af2 = (net.rim.tools.compiler.codfile.Module)_modules.elementAt(i3);
                    if(af2 instanceof net.rim.tools.compiler.codfile.ModuleDomestic)
                    {
                        net.rim.tools.compiler.codfile.ModuleDomestic y1 = (net.rim.tools.compiler.codfile.ModuleDomestic)af2;
                        if(y1.getName().getOffset() != _aliasOffset_)
                            continue;
                        _modules.setElementAt(new net.rim.tools.compiler.codfile.ModuleRef(this, y1), i3);
                        break;
                    }
                    if(!(af2 instanceof net.rim.tools.compiler.codfile.ModuleForeign))
                        continue;
                    net.rim.tools.compiler.codfile.ModuleForeign au1 = (net.rim.tools.compiler.codfile.ModuleForeign)af2;
                    if(au1.getName().getOffset() != _aliasOffset_)
                        continue;
                    _modules.setElementAt(new net.rim.tools.compiler.codfile.ModuleRef(this, au1), i3);
                    break;
                }

            }

            Literal h1;
			//Fill aliases table
            for(int k2 = _exportStrings.getOffset(); __input.getOffset() < k2; _aliases.addElement(h1))
                h1 = _DataBytes.createSibling(__input.readUnsignedShort(), false, false, false);

        }
        read(__input, _DataBytes.getOffset());
        _DataBytes.read(__input, flag);
        readClassDefs(__input);
    }

    public void addClassRefs(net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        if(z_faZ)
            return;
        z_faZ = true;
        z_eNZ = flag;
        setOffset(__input.getOffset());
        __input.skipBytes(10);
        _initializatedStaticData.setOffset(__input.readUnsignedShort());
        int l = __input.readUnsignedShort();
        int _offsetTypeLists_ = __input.readUnsignedShort();
        _TypeLists.setOffset(_offsetTypeLists_);
        int _offsetInterfaceRefs_ = __input.readUnsignedShort();
        _interfaceMethodRefs.setOffset(_offsetInterfaceRefs_);
        int _offsetClassRefs_ = __input.readUnsignedShort();
        _classRefs.setOffset(_offsetClassRefs_);
        _routineFixups.setOffset(__input.readUnsignedShort());
        _staticRoutineFixups.setOffset(__input.readUnsignedShort());
        _virtualRoutineFixups.setOffset(__input.readUnsignedShort());
        _classCodeFixups.setOffset(__input.readUnsignedShort());
        if(_aliasesFlag)
            __input.skipBytes(2);
        else
            _classDataFixups.setOffset(__input.readUnsignedShort());
        _fieldsFixups.setOffset(__input.readUnsignedShort());
        _localFieldsFixups.setOffset(__input.readUnsignedShort());
        _staticFieldsFixups.setOffset(__input.readUnsignedShort());
        if(_aliasesFlag)
            _moduleCodeFixups.setOffset(__input.readUnsignedShort());
        else
            _nativeRoutines.setOffset(__input.readUnsignedShort());
        _staticSize = __input.readUnsignedShort();
        _EntryPoint1 = new EntryPoint(__input, this);
        _EntryPoint2 = new EntryPoint(__input, this);
        __input.moveCurrentIdxtoOffset(_initializatedStaticData.getOffset());
        process_intdStaticData(__input, l, flag);
        __input.moveCurrentIdxtoOffset(_offsetClassRefs_);
        addClassRefs(__input, _routineFixups.getOffset());
        if(!z_eYZ)
            _doaZ(__input, _routineFixups, flag);
        else
            z_eYZ = _ifaZ(__input, _routineFixups, flag);
        z_e4Z = _doaZ(__input, _staticRoutineFixups, flag);
        _doaZ(__input, _virtualRoutineFixups, flag);
        if(!z_eYZ) //!z_eYZ --- demo files from BB JDE produce error here when !z_eYZ
            _aaV(__input, _classCodeFixups);
        else
            create_classDefFixupTable(__input, _classCodeFixups);
        if(!_aliasesFlag)
            _aaV(__input, _classDataFixups);
        _doaZ(__input, _fieldsFixups, flag);
        _foraV(__input, _localFieldsFixups, flag);
        if(!z_eGZ)
            _doaZ(__input, _staticFieldsFixups, flag);
        else
            z_eGZ = _ifaZ(__input, _staticFieldsFixups, flag);
        if(_aliasesFlag)
            _aaV(__input, _moduleCodeFixups, false);
        else
            addInterfaceMethodRefs(__input, flag);
        __input.verifySlack(4);
        setExtent(__input.getOffset());
        byte abyte0[] = _codFile._bKvaB();
        int l1 = _codFile.getDataSegmentOffset();
        if(z_eSZ)
        {
            _tryaBIV(abyte0, l1);
            DataSection _tmp = this;
            TypeLists._akBIIV(this, abyte0, l1, _offsetTypeLists_, _offsetInterfaceRefs_);
            if(!flag)
                InterfaceMethodRef._ifkBIIV(this, abyte0, l1, _offsetInterfaceRefs_, _offsetClassRefs_);
        }
        if(!_aliasesFlag)
            _aagBIV(_classDataFixups, abyte0, l1, false);
        __input = new net.rim.tools.compiler.io.StructuredInputStream(abyte0, l1, _offsetInterfaceRefs_, true, _offsetTypeLists_);
        _TypeLists.read(__input, this, _offsetInterfaceRefs_);
        _input = new net.rim.tools.compiler.io.StructuredInputStream(abyte0, l1, _offsetTypeLists_, true, l);
        if(!flag || z_eSZ)
            parse_classDefs();
        if(!flag)
        {
            __input = new net.rim.tools.compiler.io.StructuredInputStream(abyte0, l1, _offsetClassRefs_, true, _offsetInterfaceRefs_);
            addInterfaceMethodRefs(__input, _offsetClassRefs_);
        }
        __input = null;
        _amvV();
        if(!flag)
        {
            _aagZV(_routineFixups, true, false);
            _aagZV(_staticRoutineFixups, true, true);
            _aagZV(_virtualRoutineFixups, true, false);
            _aagZV(_fieldsFixups, false, false);
            _aagZV(_localFieldsFixups, false, false);
            _aagZV(_staticFieldsFixups, false, true);
            _asvV();
        }
        if(z_eSZ)
            _codFile._voidkV(this);
        byte abyte1[] = _codFile.getData();
        int i2 = _codFile.getCodeSegmentOffset();
        if(!z_e7Z)
            _aagBIV(_classCodeFixups, abyte1, i2, true);
        if(_aliasesFlag)
            _aagBIV(_moduleCodeFixups, abyte1, i2);
        if(!flag)
        {
            if(!z_eYZ)
                _foraBIV(abyte1, i2);
            update_staticRoutineFixupTable(abyte1, i2);
            _intaBIV(abyte1, i2);
            update_fieldFixupTable(_fieldsFixups, abyte1, i2);
            update_fieldFixupTable(_localFieldsFixups, abyte1, i2);
            if(!z_eGZ)
                update_staticFieldsFixupTable(abyte1, i2);
            _EntryPoint1._elsekV(this);
            _EntryPoint2._elsekV(this);
            if(!_aliasesFlag)
                _aovV();
        }
        z_ezaaB = null;
    }

    public void _aaV(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.ClassDefLocal l)
        throws IOException
    {
        addClassRefs(a2, true);
        _input.setOffset(l.getOffset());
        l.readClass(_input, this);
    }

    int getCodFileVersion()
    {
        return _codFile.getVersion();
    }

    public void _asvV()
    {
        aj aj1 = new aj();
        _aagV(_routineFixups, aj1);
        aj1._bRvV();
        _aagV(_staticRoutineFixups, aj1);
        aj1._bSvV();
        aj1._bTvV();
        _aagV(_virtualRoutineFixups, aj1);
        b b1 = new b();
        _aagV(_fieldsFixups, b1);
        b1._bRvV();
        _aagV(_staticFieldsFixups, b1);
    }

    public void read(net.rim.tools.compiler.io.StructuredInputStream __input, int __offset)
        throws IOException
    {
        __input.verifySlack(_exportStrings.getAlign());
        __input.verifyOffset(_exportStrings.getOffset(), "exported data");
        for(; __input.getOffset() < __offset; _exportStrings.addElement(new net.rim.tools.compiler.codfile.ExportedData(__input, _DataBytes)));
    }

    public void process_intdStaticData(net.rim.tools.compiler.io.StructuredInputStream __input, int __offset, boolean flag)
        throws IOException
    {
        __input.verifySlack(_initializatedStaticData.getAlign());
        __input.verifyOffset(_initializatedStaticData.getOffset(), "initialized static data");
        if(flag)
        {
            __input.moveCurrentIdxtoOffset(__offset);
        } else
        {
            boolean flag1 = false;
            while(__input.getOffset() < __offset)
            {
                int i1 = __input.readUnsignedShort();
                if(i1 == -1 && !flag1)
                {
                    flag1 = true;
                    _initializatedStaticStrings = new CodfileVector(2);
                    _initializatedStaticStrings.setTableName("initialized static data string");
                }
                InitializedStaticData a8_1 = new InitializedStaticData(__input, i1, flag1, _DataBytes);
                if(flag1)
                    _initializatedStaticStrings.addElement(a8_1);
                else
                    _initializatedStaticData.addElement(a8_1);
            }
        }
    }

    public void readClassDefs(net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        int loc_classDefsNum = _classDefs.size();
        for(int i1 = 0; i1 < loc_classDefsNum; i1++)
        {
            net.rim.tools.compiler.codfile.ClassDefLocal _ClassDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDefs.elementAt(i1);
            __input.moveCurrentIdxtoOffset(_ClassDefLocal_.getOffset());
            _ClassDefLocal_.read(__input, this);
        }

    }

    public void _doaBIV(byte abyte0[], int l)
    {
        int i1 = abyte0[l] & 0xff;
        if(i1 != 0 && i1 != 255)
            if(i1 == z_fcI)
            {
                abyte0[l] = 0;
            } else
            {
                int j1 = abyte0[l + 1] & 0xff;
                int k1 = _classRefs.size();
                for(int l1 = 0; l1 < k1; l1++)
                {
                    net.rim.tools.compiler.codfile.ClassRef at1 = (net.rim.tools.compiler.codfile.ClassRef)_classRefs.elementAt(l1);
                    if(at1._bkvI() == i1 && at1._bdvI() == j1)
                    {
                        abyte0[l] = (byte)at1.getModuleNum();
                        abyte0[l + 1] = (byte)at1.getOrdinal();
                        return;
                    }
                }

                abyte0[l] = -1;
            }
    }

    public void _tryaBIV(byte abyte0[], int l)
    {
        int i1 = _classDefs.size();
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.codfile.ClassDefLocal k1 = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDefs.elementAt(j1);
            k1._forkBIV(this, abyte0, l);
        }

    }

    public void parse_classDefs()
        throws IOException
    {
        int l = _classDefs.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            _input.verifySlack(2);
            net.rim.tools.compiler.codfile.ClassDefLocal j1 = (net.rim.tools.compiler.codfile.ClassDefLocal)_classDefs.elementAt(i1);
            j1.readClass(_input, this);
        }

    }

    public void addInterfaceMethodRefs(net.rim.tools.compiler.io.StructuredInputStream __input, int __offset)
        throws IOException
    {
        __input.verifySlack(_interfaceMethodRefs.getAlign());
        __input.verifyOffset(_interfaceMethodRefs.getOffset(), "interface method refs");
        for(; __input.getOffset() < __offset; _interfaceMethodRefs.addElement(new net.rim.tools.compiler.codfile.InterfaceMethodRef(__input, this)));
    }

    public void addClassRefs(net.rim.tools.compiler.io.StructuredInputStream __input, int __offset)
        throws IOException
    {
        __input.verifySlack(_classRefs.getAlign());
        __input.verifyOffset(_classRefs.getOffset(), "class refs");
        for(; __input.getOffset() < __offset; _classRefs.addElement(new net.rim.tools.compiler.codfile.ClassRef(__input, this, _classRefs.size())));
    }

    public void _amvV()
        throws IOException
    {
        int l = _classRefs.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            ClassRef at1 = (ClassRef)_classRefs.elementAt(i1);
            Module af1 = at1.getModuleName();
            if(af1 instanceof ModuleLocal)
            {
                ModuleLocal s1 = (ModuleLocal)af1;
                at1.setClassDef(s1._aatu(at1));
            }
        }

    }

    public boolean _doaZ(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.CodfileVector ag1, boolean flag)
        throws IOException
    {
        boolean flag1 = true;
        __input.verifySlack(ag1.getAlign());
        __input.verifyOffset(ag1.getOffset(), "member fixup table");
        int l = MemberRef._SvI();
        int i1 = __input.readShort();
        if(i1 < 0)
        {
            i1 = -i1;
            flag1 = false;
            ag1.negatePrefix();
        }
        for(int j1 = 0; j1 < i1; j1++)
        {
            __input.verifySlack(2);
            if(flag)
            {
                __input.skipBytes(l);
                if(_aliasesFlag)
                {
					int k1 = __input.readUnsignedShort1();
                    __input.skipBytes(k1);
                } else
                {
                    int l1 = __input.readUnsignedShort();
                    __input.skipBytes(2 * l1);
                }
            } else
            {
                net.rim.tools.compiler.codfile.MemberRef j2 = new net.rim.tools.compiler.codfile.MemberRef(__input, this);
                ag1.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(__input, j2, 2, _aliasesFlag, false));
            }
        }

        return flag1;
    }

    public boolean _ifaZ(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.CodfileVector __codFileVector, boolean flag)
        throws IOException
    {
        boolean flag1 = true;
        __input.verifySlack(__codFileVector.getAlign());
        __input.verifyOffset(__codFileVector.getOffset(), "implied member fixup table");
        int l = MemberRef._SvI();
        int i1 = __input.readShort();
        if(i1 < 0)
        {
            i1 = -i1;
            flag1 = false;
            __codFileVector.negatePrefix();
        }
        for(int j1 = 0; j1 < i1; j1++)
        {
            __input.verifySlack(2);
            if(flag)
            {
                __input.skipBytes(l);
                if(!flag1)
                    if(_aliasesFlag)
                    {
						int k1 = __input.readUnsignedShort1();
                        __input.skipBytes(k1);
                    } else
                    {
                        int l1 = __input.readUnsignedShort();
                        __input.skipBytes(2 * l1);
                    }
            } else
            {
                net.rim.tools.compiler.codfile.MemberRef j2 = new net.rim.tools.compiler.codfile.MemberRef(__input, this);
                __codFileVector.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(__input, j2, 2, _aliasesFlag, flag1));
            }
        }

        return flag1;
    }

    public void _foraV(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.CodfileVector ag1, boolean flag)
        throws IOException
    {
        a2.verifySlack(ag1.getAlign());
        a2.verifyOffset(ag1.getOffset(), "member local fixup table");
        int l = net.rim.tools.compiler.codfile.MemberRefLocal._SvI();
        int i1 = a2.readUnsignedShort();
        for(int j1 = 0; j1 < i1; j1++)
            if(flag)
            {
                a2.skipBytes(l);
                if(_aliasesFlag)
                {
                    int k1 = a2.readUnsignedShort1();
                    a2.skipBytes(k1);
                } else
                {
                    int l1 = a2.readUnsignedShort();
                    a2.skipBytes(2 * l1);
                }
            } else
            {
                net.rim.tools.compiler.codfile.MemberRefLocal aw1 = new net.rim.tools.compiler.codfile.MemberRefLocal(a2, this);
                ag1.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(a2, aw1, 1, _aliasesFlag, false));
            }

    }

    public void _aagZV(net.rim.tools.compiler.codfile.CodfileVector ag1, boolean flag, boolean flag1)
        throws IOException
    {
        int l = ag1.size();
        for(int i1 = 0; i1 < l; i1++)
            ((net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(i1))._ifkZV(this, flag, flag1);

    }

    public void _aaV(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.CodfileVector ag1)
        throws IOException
    {
        a2.verifySlack(ag1.getAlign());
        a2.verifyOffset(ag1.getOffset(), "class def fixup table");
        for(int l = a2.readUnsignedShort(); l-- > 0;)
        {
            a2.verifySlack(2);
            net.rim.tools.compiler.codfile.CodfileOffset n1 = new net.rim.tools.compiler.codfile.CodfileOffset(a2.readUnsignedShort()); //a2.readUnsignedShort1()
            ag1.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(a2, n1, 2, _aliasesFlag, false));
        }

    }

    public void create_classDefFixupTable(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.CodfileVector ag1)
        throws IOException
    {
        a2.verifySlack(ag1.getAlign());
        a2.verifyOffset(ag1.getOffset(), "class def fixup table");
        for(int l = a2.readUnsignedShort(); l-- > 0;)
        {
            a2.verifySlack(2);
            net.rim.tools.compiler.codfile.CodfileOffset n1 = new net.rim.tools.compiler.codfile.CodfileOffset(a2.readUnsignedShort());
            ag1.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(a2, n1, 2, _aliasesFlag, true));
        }

    }

    public void addInterfaceMethodRefs(net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        __input.verifySlack(_nativeRoutines.getAlign());
        __input.verifyOffset(_nativeRoutines.getOffset(), "native method table");
        int l = __input.readUnsignedShort();
        if(flag)
            __input.skipBytes(l * 2);
        else
            while(l-- > 0)
                _nativeRoutines.addElement(new net.rim.tools.compiler.codfile.CodfileOffset(__input.readUnsignedShort()));
    }

    public void _aovV()
        throws IOException
    {
        int l = _nativeRoutines.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.CodfileOffset n1 = (net.rim.tools.compiler.codfile.CodfileOffset)_nativeRoutines.elementAt(i1);
            _nativeRoutines.setElementAt(getRoutine(0, n1.getAddress(), null), i1);
        }

    }

    public void _aaV(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.CodfileVector ag1, boolean flag)
        throws IOException
    {
        a2.verifySlack(ag1.getAlign());
        a2.verifyOffset(ag1.getOffset(), "module fixup table");
        int l = a2.readUnsignedShort();
        for(int i1 = 0; i1 < l; i1++)
            if(flag)
            {
                a2.skipBytes(1);
                if(_aliasesFlag)
                {
                    int j1 = a2.readUnsignedShort1();
                    a2.skipBytes(j1);
                } else
                {
                    int k1 = a2.readUnsignedShort();
                    a2.skipBytes(2 * k1);
                }
            } else
            {
                net.rim.tools.compiler.codfile.CodfileOffset n1 = new net.rim.tools.compiler.codfile.CodfileOffset(a2.readUnsignedByte(), true);
                ag1.addElement(new net.rim.tools.compiler.codfile.FixupTableEntry(a2, n1, 1, _aliasesFlag, false));
            }

    }

    private byte[] _sIaB(int l)
    {
        if(z_ezaaB == null)
            z_ezaaB = new byte[4][];
        int i1 = l - 1;
        if(z_ezaaB[i1] == null)
            z_ezaaB[i1] = new byte[l];
        return z_ezaaB[i1];
    }

    public void _aagBIV(net.rim.tools.compiler.codfile.CodfileVector ag1, byte abyte0[], int l, boolean flag)
        throws IOException
    {
        int i1 = ag1.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(2);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(j1);
                net.rim.tools.compiler.codfile.CodfileOffset n1 = (net.rim.tools.compiler.codfile.CodfileOffset)an1.getItem();
                net.rim.tools.compiler.codfile.ClassRef at1 = getClassRef(n1.getAddress());
                abyte1[0] = (byte)at1.getModuleNum();
                if(flag)
                    abyte1[1] = (byte)at1.getClassDef().getOrdinal();
                else
                    abyte1[1] = (byte)at1.getOrdinal();
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    public void _aagBIV(net.rim.tools.compiler.codfile.CodfileVector ag1, byte abyte0[], int l)
        throws IOException
    {
        int i1 = ag1.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(1);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(j1);
                net.rim.tools.compiler.codfile.CodfileOffset n1 = (net.rim.tools.compiler.codfile.CodfileOffset)an1.getItem();
                abyte1[0] = (byte)n1.getAddress();
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    private void _foraBIV(byte abyte0[], int l)
        throws IOException
    {
        int i1 = _routineFixups.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(3);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_routineFixups.elementAt(j1);
                net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
                net.rim.tools.compiler.codfile.Member r1 = j2.getMember();
                int k1 = r1.getOffset();
                abyte1[0] = (byte)r1.getClassDef().getModule().getOrdinal();
                abyte1[1] = (byte)(k1 & 0xff);
                abyte1[2] = (byte)(k1 >> 8 & 0xff);
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    public void update_staticRoutineFixupTable(byte abyte0[], int l)
        throws IOException
    {
        int i1 = _staticRoutineFixups.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(4);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticRoutineFixups.elementAt(j1);
                net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
                net.rim.tools.compiler.codfile.Member r1 = j2.getMember();
                net.rim.tools.compiler.codfile.ClassDef u1 = r1.getClassDef();
                abyte1[0] = (byte)u1.getModule().getOrdinal();
                abyte1[1] = (byte)u1.getOrdinal();
                int k1 = r1.getOffset();
                abyte1[2] = (byte)(k1 & 0xff);
                abyte1[3] = (byte)(k1 >> 8 & 0xff);
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    public void _intaBIV(byte abyte0[], int l)
        throws IOException
    {
        int i1 = _virtualRoutineFixups.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(2);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_virtualRoutineFixups.elementAt(j1);
                net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
                if(!(j2.getClassDef() instanceof net.rim.tools.compiler.codfile.ClassDefLocal))
                {
                    int k1 = -(j1 + 2);
                    abyte1[0] = (byte)(k1 & 0xff);
                    abyte1[1] = (byte)(k1 >> 8 & 0xff);
                    an1._aaBIaV(abyte0, l, abyte1);
                }
            }

        }
    }

    public net.rim.tools.compiler.codfile.Routine _yIa5(int l)
        throws IOException
    {
        Object obj = null;
        if(l < -1)
        {
            int i1 = -(l + 2);
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_virtualRoutineFixups.elementAt(i1);
            net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
            obj = (net.rim.tools.compiler.codfile.Routine)j1.getMember();
        } else
        {
            obj = new net.rim.tools.compiler.codfile.RoutineNull(_ClassDef, this);
            ((net.rim.tools.compiler.codfile.CodfileItem) (obj)).setAddress(l);
            ((net.rim.tools.compiler.codfile.Member) (obj))._ifStringvV("virtual_", l);
        }
        return ((net.rim.tools.compiler.codfile.Routine) (obj));
    }

    public void update_fieldFixupTable(net.rim.tools.compiler.codfile.CodfileVector ag1, byte abyte0[], int l)
        throws IOException
    {
        int i1 = ag1.size(); //get size of table
        if(i1 > 0) // if > 0
        {
            byte abyte1[] = _sIaB(1);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(j1);
                net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
                net.rim.tools.compiler.codfile.FieldDef w1 = (net.rim.tools.compiler.codfile.FieldDef)j2.getMember();
                int k1 = -(_fixedFields.size() + 2);
                _fixedFields.addElement(w1);
                abyte1[0] = (byte)(k1 & 0xff);
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    public net.rim.tools.compiler.codfile.FieldDef _tIw(int l)
        throws IOException
    {
        if(l < -1)
        {
            int i1 = -(l + 2);
            if(i1 < _fixedFields.size())
                return (net.rim.tools.compiler.codfile.FieldDef)_fixedFields.elementAt(i1);
            l &= 0xff;
        }
        net.rim.tools.compiler.codfile.Identifier ak1 = _DataBytes.getNullIdentifier();
        net.rim.tools.compiler.codfile.TypeList p = _TypeLists.getNullTypeList();
        net.rim.tools.compiler.codfile.FieldDefLocal ab1 = new net.rim.tools.compiler.codfile.FieldDefLocal(_ClassDef, ak1, p, false);
        ab1.setAddress(l);
        ab1._ifStringvV("field_", l);
        return ab1;
    }

    public void update_staticFieldsFixupTable(byte abyte0[], int l)
        throws IOException
    {
        int i1 = _staticFieldsFixups.size();
        if(i1 > 0)
        {
            byte abyte1[] = _sIaB(4);
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticFieldsFixups.elementAt(j1);
                net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
                net.rim.tools.compiler.codfile.Member r1 = j2.getMember();
                net.rim.tools.compiler.codfile.ClassDef u1 = j2.getClassDef();
                abyte1[0] = (byte)u1.getModule().getOrdinal();
                abyte1[1] = (byte)u1.getOrdinal();
                int k1 = r1.getOrdinal();
                if(u1 instanceof net.rim.tools.compiler.codfile.ClassDefLocal)
                    k1 = r1.getAddress();
                abyte1[2] = (byte)(k1 & 0xff);
                abyte1[3] = (byte)(k1 >> 8 & 0xff);
                an1._aaBIaV(abyte0, l, abyte1);
            }

        }
    }

    public void _aagV(net.rim.tools.compiler.codfile.CodfileVector ag1, net.rim.tools.compiler.codfile.ar ar1)
    {
        int l = ag1.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(i1);
            net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
            if(!(j1.getClassDef() instanceof net.rim.tools.compiler.codfile.ClassDefLocal))
                an1._ifarV(ar1);
        }

    }

    public void _akvV()
    {
        net.rim.tools.compiler.codfile.Module _module_ = getModule(0);
        net.rim.tools.compiler.codfile.aj aj1 = new net.rim.tools.compiler.codfile.aj();
        aj1._bRvV();
        int l = _staticRoutineFixups.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticRoutineFixups.elementAt(i1);
            net.rim.tools.compiler.codfile.MemberRef j2 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
            if(j2.getClassDef() instanceof ClassDefLocal)
            {
                an1._ifarV(aj1);
                an1._aafvV(_module_, true);
            }
        }

        aj1._bSvV();
        aj1._bTvV();
        l = _virtualRoutineFixups.size();
        for(int j1 = 0; j1 < l; j1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an2 = (net.rim.tools.compiler.codfile.FixupTableEntry)_virtualRoutineFixups.elementAt(j1);
            net.rim.tools.compiler.codfile.MemberRef j3 = (net.rim.tools.compiler.codfile.MemberRef)an2.getItem();
            if(j3.getClassDef() instanceof ClassDefLocal)
            {
                an2._ifarV(aj1);
                an2._aafvV(_module_, false);
            }
        }

        l = _interfaceMethodRefs.size();
        for(int k1 = 0; k1 < l; k1++)
        {
            net.rim.tools.compiler.codfile.InterfaceMethodRef _interfaceMethodRef_ = (net.rim.tools.compiler.codfile.InterfaceMethodRef)_interfaceMethodRefs.elementAt(k1);
            _interfaceMethodRef_._aajV(aj1);
        }

        l = _localFieldsFixups.size();
        for(int l1 = 0; l1 < l; l1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an3 = (net.rim.tools.compiler.codfile.FixupTableEntry)_localFieldsFixups.elementAt(l1);
            an3._aafvV(_module_, false);
        }

        l = _fieldsFixups.size();
        for(int i2 = 0; i2 < l; i2++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an4 = (net.rim.tools.compiler.codfile.FixupTableEntry)_fieldsFixups.elementAt(i2);
            an4._aafvV(_module_, false);
        }

    }

    public void assignClassRefOrdinals()
    {
        int l = _classRefs.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.ClassRef _classRefs_ = (net.rim.tools.compiler.codfile.ClassRef)_classRefs.elementAt(i1);
            _classRefs_.setOrdinal(i1);
        }

    }

    public void harvestRoutines()
    {
        net.rim.tools.compiler.codfile.ModuleLocal _moduleLocal_ = (net.rim.tools.compiler.codfile.ModuleLocal)_modules.firstElement();
        _moduleLocal_.harvestRoutines();
    }

    public void _elsecV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int l = _Flags;
        if((l & 1) != 0)
            c1.writeString("IsLibrary ");
        if((l & 2) != 0)
            c1.writeString("IsMidlet ");
        if((l & 4) != 0)
            c1.writeString("IsParseable ");
        if((l & 0x10) != 0)
            c1.writeString("IsBrittle ");
        if((l & 0x20) != 0)
            c1.writeString("IsPlatform ");
        c1.writeByte(l, "attributes=", true);
        c1.empty_func7();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        writeLocalOffset(__output);
        __output.writeString("fixup_size ");
        __output.empty_func8(super._extent - _routineFixups.getOffset());
        __output.writeString(" bytes");
        __output.empty_func7();
        setOffset(__output);
        _elsecV(__output);
        __output.writeByte(_Version, "version=", true);
        __output.empty_func7();
        __output.writeShort(_iCallsNumber, "#icalls=", true);
        __output.writeByte(_modules.size(), "#modules=", true);
        __output.writeByte(_classDefs.size(), "#classes=", true);
        __output.empty_func7();
        _exportStrings.writeOffset(__output);
        __output.empty_func7();
        _DataBytes._acV(__output, "data bytes");
        __output.empty_func7();
        _initializatedStaticData.writeOffset(__output);
        __output.empty_func7();
        __output.writeShort(_classDefNumber, "class definitions", false);
        __output.empty_func7();
        _TypeLists.writeOffset(__output);
        __output.empty_func7();
        _interfaceMethodRefs.writeOffset(__output);
        __output.empty_func7();
        _classRefs.writeOffset(__output);
        __output.empty_func7();
        _routineFixups.writeOffset(__output);
        __output.empty_func7();
        _staticRoutineFixups.writeOffset(__output);
        __output.empty_func7();
        _virtualRoutineFixups.writeOffset(__output);
        __output.empty_func7();
        _classCodeFixups.writeOffset(__output);
        __output.empty_func7();
        if(!_aliasesFlag)
            _classDataFixups.writeOffset(__output);
        else
            _aliases.writeOffset(__output);
        __output.empty_func7();
        _fieldsFixups.writeOffset(__output);
        __output.empty_func7();
        _localFieldsFixups.writeOffset(__output);
        __output.empty_func7();
        _staticFieldsFixups.writeOffset(__output);
        __output.empty_func7();
        if(!_aliasesFlag)
            _nativeRoutines.writeOffset(__output);
        else
            _moduleCodeFixups.writeOffset(__output);
        __output.empty_func7();
        __output.empty_func7();
        __output.writeShort(_staticSize, "static_size=", true);
        __output.empty_func7();
        _EntryPoint1.write(__output);
        __output.empty_func7();
        _EntryPoint2.write(__output);
        __output.empty_func7();
        _classDefs._ucV(__output);
        _modules._scV(__output);
        __output.empty_func();
        int l = _modules.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            Module af1 = (Module)_modules.elementAt(i1);
            af1._kcV(__output);
            __output.empty_func7();
        }

        __output.empty_func7();
        __output.empty_func2();
        if(_aliasesFlag)
        {
            _sibblings._ucV(__output);
            _aliases._ucV(__output);
        }
        _exportStrings._trycvV(__output, true);
        _DataBytes.write(__output);
        _initializatedStaticData._trycvV(__output, true);
        if(_initializatedStaticStrings != null)
            _initializatedStaticStrings._trycvV(__output, false);
        _classDefNumber = __output.getOffset();
        _classDefs._trycvV(__output, true);
        _TypeLists.write(__output);
        _interfaceMethodRefs._trycvV(__output, true);
        if(__output.getCookie() != null)
        {
            for(int j1 = 0; j1 < l; j1++)
            {
                getModule(j1)._longkV(this);
                if(z_e4Z)
                    _aagV(_staticRoutineFixups, _routineFixups);
            }

        }
        if(z_eYZ)
            _aagV(_routineFixups);
        if(z_eGZ)
            _aagV(_staticFieldsFixups);
        if(z_e7Z)
            _aagV(_classCodeFixups);
        _classRefs._trycvV(__output, true);
        _routineFixups._trycvV(__output, true);
        _staticRoutineFixups._trycvV(__output, true);
        _virtualRoutineFixups._trycvV(__output, true);
        _classCodeFixups._trycvV(__output, true);
        if(!_aliasesFlag)
            _classDataFixups._trycvV(__output, true);
        _fieldsFixups._trycvV(__output, true);
        _localFieldsFixups._trycvV(__output, true);
        _staticFieldsFixups._trycvV(__output, true);
        if(!_aliasesFlag)
            _nativeRoutines._ucV(__output);
        else
            _moduleCodeFixups._trycvV(__output, true);
        __output.writeSlack(4);
        setExtent(__output);
    }

    public void set_codFlags(int l)
    {
        _Flags |= l;
    }

    public boolean _atvZ()
    {
        return z_eNZ;
    }

    public void _VvV()
    {
        z_eSZ = true;
    }

    public void _qIV(int l)
    {
        z_fcI = l;
    }

    public void _agvV()
    {
        _aliasesFlag = true;
        z_eYZ = true;
        z_eGZ = true;
        z_e7Z = true;
        _TypeLists._bbvV();
    }

    public boolean getAliasesFlag()
    {
        return _aliasesFlag;
    }

    public void _anvV()
    {
        z_ePZ = true;
    }

    public boolean _arvZ()
    {
        return z_ePZ;
    }

    public boolean _YvZ()
    {
        return (_Flags & 0x10) != 0;
    }

    public boolean _aavZ()
    {
        return z_eSZ;
    }

    public int _apvI()
    {
        return z_fcI;
    }

    public int getVersion()
    {
        return _Version;
    }

    public int getModulesNum()
    {
        return _modules.size();
    }

    public net.rim.tools.compiler.codfile.Module getNullModule()
    {
        return _Module;
    }

    public net.rim.tools.compiler.codfile.Module getModule(int __index)
    {
        if(__index == 255)
            return _Module;
        else
            return (net.rim.tools.compiler.codfile.Module)_modules.elementAt(__index);
    }

    public net.rim.tools.compiler.codfile.Module getModule(String param_fileNameStringS, String param_versionS, int param_timeStampI, boolean flag, boolean param_flagBrittle)
    {
        if(param_fileNameStringS.length() >= 128)
            param_fileNameStringS = param_fileNameStringS.substring(0, 127);
        if(param_versionS != null && param_versionS.length() >= 128)
            param_versionS = param_versionS.substring(0, 127);
        int loc_modulesNumber = _modules.size();
        if(param_flagBrittle)
        {
            StringBuffer stringbuffer = new StringBuffer();
            if(param_versionS != null)
                stringbuffer.append(param_versionS);
            stringbuffer.append('\0');
            stringbuffer.append((char)(param_timeStampI & 0xff));
            stringbuffer.append((char)(param_timeStampI >> 8 & 0xff));
            stringbuffer.append((char)(param_timeStampI >> 16 & 0xff));
            stringbuffer.append((char)(param_timeStampI >> 24 & 0xff));
            param_versionS = stringbuffer.toString();
        }
        Object obj = null;
        if(loc_modulesNumber == 0)
            obj = new net.rim.tools.compiler.codfile.ModuleLocal(this, param_fileNameStringS, param_versionS, _classDefs, _codFile.getRoutines());
        else
        if(flag)
            obj = new net.rim.tools.compiler.codfile.ModuleRef(this, param_fileNameStringS, param_versionS);
        else
        if(param_flagBrittle)
            obj = new net.rim.tools.compiler.codfile.ModuleForeign(this, param_fileNameStringS, param_versionS);
        else
            obj = new net.rim.tools.compiler.codfile.ModuleDomestic(this, param_fileNameStringS, param_versionS);
        ((net.rim.tools.compiler.codfile.CodfileItem) (obj)).setOrdinal(loc_modulesNumber);
        _modules.addElement(obj);
        return ((net.rim.tools.compiler.codfile.Module) (obj));
    }

    public int get_sibblingsSize()
    {
        return _sibblings.size();
    }

    public net.rim.tools.compiler.codfile.Literal getSibling(int l)
    {
        return (net.rim.tools.compiler.codfile.Literal)_sibblings.elementAt(l);
    }

    public void addSibling(String s1)
    {
        if(s1.length() >= 128)
            s1 = s1.substring(0, 127);
        net.rim.tools.compiler.codfile.Literal h1 = _DataBytes.getLiteral(s1, false, false);
        _sibblings.addElement(h1);
    }

    public void _gotoStringV(String s1)
    {
        if(s1.length() >= 128)
            s1 = s1.substring(0, 127);
        net.rim.tools.compiler.codfile.Literal h1 = _DataBytes.getLiteral(s1, false, false);
        _aliases.addElement(h1);
    }

    public Vector getClassDefs()
    {
        return _classDefs;
    }

    public net.rim.tools.compiler.codfile.DataBytes getDataBytes()
    {
        return _DataBytes;
    }

    public net.rim.tools.compiler.codfile.TypeLists getTypeLists()
    {
        return _TypeLists;
    }

    public void addInitializedStaticData(int __index, long __value, int __double)
    {
        _initializatedStaticData.addElement(new net.rim.tools.compiler.codfile.InitializedStaticData(__index, (int)__value));
        if(__double > 1)
            _initializatedStaticData.addElement(new net.rim.tools.compiler.codfile.InitializedStaticData(__index + 1, (int)(__value >> 32)));
    }

    public void addInitializedStaticDataString(int __index, String __value, boolean flag)
    {
        net.rim.tools.compiler.codfile.CodfileVector ag1 = _initializatedStaticStrings;
        if(ag1 == null)
        {
            ag1 = new net.rim.tools.compiler.codfile.CodfileVector(2);
            ag1.setTableName("initialized static data string");
            ag1.addElement(new net.rim.tools.compiler.codfile.InitializedStaticData(-1, -1));
            _initializatedStaticStrings = ag1;
        }
        net.rim.tools.compiler.codfile.Literal h1 = _DataBytes.getLiteral(__value, flag, true);
        ag1.addElement(new net.rim.tools.compiler.codfile.InitializedStaticData(__index, h1));
    }

    public void addExport(net.rim.tools.compiler.codfile.ExportedData __exportString)
    {
        _exportStrings.addElementOrdered(__exportString);
    }

    public net.rim.tools.compiler.codfile.ExportedData getExportedData(String s1)
    {
        int l = _exportStrings.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.ExportedData a0_1 = (net.rim.tools.compiler.codfile.ExportedData)_exportStrings.elementAt(i1);
            if(a0_1.getIdentifier().equals(s1))
                return a0_1;
        }

        return null;
    }

    public void setEntryRoutine(net.rim.tools.compiler.codfile.ClassDef u1, String s1, net.rim.tools.compiler.codfile.TypeList p)
    {
        net.rim.tools.compiler.codfile.Identifier ak1 = null;
        if(s1 == null)
            ak1 = _DataBytes.getNullIdentifier();
        else
            ak1 = _DataBytes.getIdentifier(s1);
        if(p != _TypeLists.getNullTypeList())
            p = _TypeLists.getTypeList(p, this, false);
        _EntryPoint1 = new net.rim.tools.compiler.codfile.EntryPoint(u1.getClassRef(this), ak1, p);
    }

    public void setAlternateEntryRoutine(net.rim.tools.compiler.codfile.ClassDef u1, String s1, net.rim.tools.compiler.codfile.TypeList p)
    {
        net.rim.tools.compiler.codfile.Identifier ak1 = null;
        if(s1 == null)
            ak1 = _DataBytes.getNullIdentifier();
        else
            ak1 = _DataBytes.getIdentifier(s1);
        if(p != _TypeLists.getNullTypeList())
            p = _TypeLists.getTypeList(p, this, false);
        _EntryPoint2 = new net.rim.tools.compiler.codfile.EntryPoint(u1.getClassRef(this), ak1, p);
    }

    public net.rim.tools.compiler.codfile.ClassDef getNullClassDef()
    {
        return _ClassDef;
    }

    public net.rim.tools.compiler.codfile.ClassRef getNullClassRef()
    {
        return _ClassRef;
    }

    public net.rim.tools.compiler.codfile.ClassRef makeClassRef(net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        if(__classDef == _ClassDef)
            return _ClassRef;
        net.rim.tools.compiler.codfile.ClassRef at1 = null;
        int l = _classRefs.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            at1 = (net.rim.tools.compiler.codfile.ClassRef)_classRefs.elementAt(i1);
            if(at1.getClassDef() == __classDef)
                return at1;
        }

        at1 = new net.rim.tools.compiler.codfile.ClassRef(this, __classDef);
        _classRefs.addElementOrdered(at1);
        return at1;
    }

    public net.rim.tools.compiler.codfile.InterfaceMethodRef getNullInterfaceMethodRef()
    {
        return _InterfaceMethodRef;
    }

    public net.rim.tools.compiler.codfile.InterfaceMethodRef makeInterfaceMethodRef(net.rim.tools.compiler.codfile.Member r1)
    {
        net.rim.tools.compiler.codfile.InterfaceMethodRef az1 = new net.rim.tools.compiler.codfile.InterfaceMethodRef(this, r1);
        _interfaceMethodRefs.addElement(az1);
        return az1;
    }

    public void setIcallIndex(int __value)
    {
        _iCallsNumber = __value;
    }

    public void setStaticSize(int __value)
    {
        _staticSize = __value;
    }

    public void addMethodFixup(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        if(!z_eYZ)
        {
            an1.setOrdinal(-1);
            _routineFixups.addElement(an1);
        } else
        {
            an1._intZV(true);
            _routineFixups.addElementOrdered(an1);
        }
    }

    private void _aagV(net.rim.tools.compiler.codfile.CodfileVector ag1, net.rim.tools.compiler.codfile.CodfileVector ag2)
    {
        int l = ag1.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(i1);
            ag2.addElementOrdered(an1);
        }

        ag1.setSize(0);
    }

    private void _aagV(net.rim.tools.compiler.codfile.CodfileVector ag1)
    {
        int l = ag1.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)ag1.elementAt(i1);
            an1.setOrdinal(i1);
        }

    }

    public void _ifanvV(net.rim.tools.compiler.codfile.FixupTableEntry an1, boolean flag)
    {
        an1._newZV(_aliasesFlag);
        if(!z_eYZ)
        {
            an1.setOrdinal(-1);
            _staticRoutineFixups.addElement(an1);
        } else
        {
            if(z_e4Z && !flag)
            {
                z_e4Z = false;
                _staticRoutineFixups.negatePrefix();
                int l = _staticRoutineFixups.size();
                for(int i1 = 0; i1 < l; i1++)
                {
                    net.rim.tools.compiler.codfile.FixupTableEntry an2 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticRoutineFixups.elementAt(i1);
                    an2._intZV(false);
                }

            }
            an1._intZV(z_e4Z);
            an1.setOrdinal(-1);
            _staticRoutineFixups.addElement(an1);
        }
    }

    public void _aanV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        if(getCodFileVersion() < 78)
            _virtualRoutineFixups.addElement(an1);
        else
            _virtualRoutineFixups.addElementOrdered(an1);
    }

    public void _tryanV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        if(!z_eYZ)
            _classCodeFixups.addElement(an1);
        else
        if(z_e7Z)
        {
            an1._intZV(true);
            _classCodeFixups.addElementOrdered(an1);
        }
    }

    public void _doanV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        if(getCodFileVersion() < 78)
            _fieldsFixups.addElement(an1);
        else
            _fieldsFixups.addElementOrdered(an1);
    }

    public void _foranV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        if(getCodFileVersion() < 78)
            _localFieldsFixups.addElement(an1);
        else
            _localFieldsFixups.addElementOrdered(an1);
    }

    public void _aanvV(net.rim.tools.compiler.codfile.FixupTableEntry __entry, boolean __isStatic)
    {
        __entry._newZV(_aliasesFlag);
        if(z_eGZ && !__isStatic)
        {
            z_eGZ = false;
            _staticFieldsFixups.negatePrefix();
            int l = _staticFieldsFixups.size();
            for(int i1 = 0; i1 < l; i1++)
            {
                net.rim.tools.compiler.codfile.FixupTableEntry an2 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticFieldsFixups.elementAt(i1);
                an2._intZV(false);
            }

        }
        __entry._intZV(z_eGZ);
        if(!z_eGZ)
        {
            __entry.setOrdinal(-1);
            _staticFieldsFixups.addElement(__entry);
        } else
        {
            _staticFieldsFixups.addElementOrdered(__entry);
        }
    }

    public void _intanV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        _moduleCodeFixups.addElement(an1);
    }

    public void _ifanV(net.rim.tools.compiler.codfile.FixupTableEntry an1)
    {
        an1._newZV(_aliasesFlag);
        _classDataFixups.addElement(an1);
    }

    public void _aa5V(net.rim.tools.compiler.codfile.Routine __routine)
    {
        _nativeRoutines.addElement(__routine);
    }

    public void InitializateTables()
    {
        _routineFixups.setSize(0);
        _staticRoutineFixups.setSize(0);
        _virtualRoutineFixups.setSize(0);
        _classCodeFixups.setSize(0);
        _classDataFixups.setSize(0);
        _fieldsFixups.setSize(0);
        _localFieldsFixups.setSize(0);
        _staticFieldsFixups.setSize(0);
        _nativeRoutines.setSize(0);
        _moduleCodeFixups.setSize(0);
    }

    public net.rim.tools.compiler.codfile.Routine getRoutine(int l, int __ordinal, net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        if(l == 255 && __ordinal != 65535)
        {
            net.rim.tools.compiler.codfile.Routine _routine_ = _Routine;
            if(__ordinal < _routineFixups.size())
            {
                net.rim.tools.compiler.codfile.FixupTableEntry _fixupEntry_ = (net.rim.tools.compiler.codfile.FixupTableEntry)_routineFixups.elementAt(__ordinal);
                net.rim.tools.compiler.codfile.MemberRef _memberRef_ = (net.rim.tools.compiler.codfile.MemberRef)_fixupEntry_.getItem();
                net.rim.tools.compiler.codfile.Member _member_ = _memberRef_.getMember();
                _routine_ = (net.rim.tools.compiler.codfile.Routine)_member_;
            } else
            {
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("bad ordinal " + Integer.toString(__ordinal));
            }
            return _routine_;
        } else
        {
            return getModule(l).getRoutine(__ordinal, __classDef);
        }
    }

    public net.rim.tools.compiler.codfile.FieldDef getFieldDef(int l)
    {
        Object obj;
        if(l < _staticFieldsFixups.size())
        {
            net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)_staticFieldsFixups.elementAt(l);
            net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)an1.getItem();
            net.rim.tools.compiler.codfile.Member r1 = j1.getMember();
            obj = (net.rim.tools.compiler.codfile.FieldDef)r1;
        } else
        {
            net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("bad ordinal " + Integer.toString(l));
            obj = new net.rim.tools.compiler.codfile.FieldNull(_ClassDef, true);
        }
        return ((net.rim.tools.compiler.codfile.FieldDef) (obj));
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(int __moduleOrdinal, int __classOrdinal)
    {
        if(__moduleOrdinal == 255)
        {
            return _ClassDef;
        } else
        {
            net.rim.tools.compiler.codfile.Module af1 = (net.rim.tools.compiler.codfile.Module)_modules.elementAt(__moduleOrdinal);
            return af1.getClassDef(__classOrdinal);
        }
    }

    public net.rim.tools.compiler.codfile.ClassDef findClassDef(int __moduleOrdinal, int __classOrdinal)
        throws IOException
    {
        if(__moduleOrdinal == 255)
            return _ClassDef;
        if(__moduleOrdinal == 0)
            return getClassDef(__moduleOrdinal, __classOrdinal);
        net.rim.tools.compiler.codfile.Module af1 = (net.rim.tools.compiler.codfile.Module)_modules.elementAt(__moduleOrdinal);
        if((af1 instanceof net.rim.tools.compiler.codfile.ModuleRef) || (af1 instanceof net.rim.tools.compiler.codfile.ModuleForeign))
            return af1.getClassDef(__classOrdinal);
        for(int j1 = _classRefs.size(); __classOrdinal < j1; __classOrdinal += 256)
        {
            net.rim.tools.compiler.codfile.ClassRef at1 = (net.rim.tools.compiler.codfile.ClassRef)_classRefs.elementAt(__classOrdinal);
            if(at1.getModuleNum() == __moduleOrdinal)
                return at1.getClassDef();
        }

        throw new IOException("no class ref found for module: " + __moduleOrdinal + " class ordinal: " + __classOrdinal);
    }

    public net.rim.tools.compiler.codfile.ClassRef getClassRef(int __offset)
        throws IOException
    {
        if(__offset == 0)
            return _ClassRef;
        net.rim.tools.compiler.codfile.ClassRef at1 = (ClassRef)_classRefs.getItem(__offset, null);
        if(at1 == null)
            throw new IOException("no class ref found at offset: 0x" + Integer.toHexString(__offset));
        else
            return at1;
    }

    public net.rim.tools.compiler.codfile.InterfaceMethodRef getInterfaceMethodRef(int l)
        throws IOException
    {
        net.rim.tools.compiler.codfile.InterfaceMethodRef az1 = _InterfaceMethodRef;
        if(l != 65535)
        {
            az1 = (net.rim.tools.compiler.codfile.InterfaceMethodRef)_interfaceMethodRefs.getItem(l, null);
            if(az1 == null)
                throw new IOException("no interface method reference found at offset: 0x" + Integer.toHexString(l));
        }
        return az1;
    }

    public void _aasV(net.rim.tools.compiler.codfile.as as1)
    {
        int l = _classDefs.size();
        for(int i1 = 0; i1 < l; i1++)
        {
            ClassDefLocal j1 = (ClassDefLocal)_classDefs.elementAt(i1);
            String s1 = j1.get_name_2();
            int k1 = j1.getAttributes();
            Object obj;
            if((k1 & 0x20) != 0)
            {
                obj = as1._ifStringObject(s1);
            } else
            {
                obj = as1._aStringObject(s1);
                net.rim.tools.compiler.codfile.ClassDef u1 = j1.getSuperClass();
                as1._ifObjectV(obj, u1.get_name_2());
            }
            int l1 = j1.getNumVirtualRoutines();
            if(l1 != 0)
                as1._aObjectvV(obj, l1);
            int i2 = j1.getNumInterfaces();
            for(int j2 = 0; j2 < i2; j2++)
            {
                net.rim.tools.compiler.codfile.ClassDef u2 = j1.getInterface(j2);
                as1._aObjectV(obj, u2.get_name_2());
            }

        }

    }

    public net.rim.tools.compiler.codfile.CodfileVector get_routineFixupTable(int l)
    {
        switch(l)
        {
        case 0: // '\0'
            return _routineFixups;

        case 1: // '\001'
            return _staticRoutineFixups;

        case 2: // '\002'
            return _virtualRoutineFixups;
        }
        return null;
    }
}
