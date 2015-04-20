// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import java.util.Vector;
import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.a.cls_h;
import net.rim.tools.compiler.a.cls_j;
import net.rim.tools.compiler.a.cls_m;
import net.rim.tools.compiler.a.cls_o;
import net.rim.tools.compiler.exec.MyArrays;
import net.rim.tools.compiler.exec.g;
import net.rim.tools.compiler.codfile.Routine;
import net.rim.tools.compiler.codfile.CodfileLabel;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.InterfaceMethodRef;
import net.rim.tools.compiler.codfile.RoutineDomestic;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.Member;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.RoutineLocal;
import net.rim.tools.compiler.classfile.af;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.analysis.InstructionCode;

// Referenced classes of package net.rim.tools.compiler.h:
//            k, l, g, a,
//            m, b, n

public final class Method extends net.rim.tools.compiler.types.NameAndType
{
    public static final class a
    {

        public static final int z_doI = 0;
        public static final int z_ifI = 1;
        public static final int z_intI = 2;
        public static final int z_aI = 3;
        public static final int z_newI = 4;
        public static final int z_forI = 5;

        public a()
        {
        }
    }


    private net.rim.tools.compiler.types.NameAndType _parameters[];
    private int z_r2I;
    private net.rim.tools.compiler.analysis.InstructionCode _instructionCode;
    private net.rim.tools.compiler.types.Method z_r3c;
    private net.rim.tools.compiler.types.Method z_r4ac[];
    private int z_rNI;
    private net.rim.tools.compiler.types.Method z_rJc;
    private boolean z_rPZ;
    private boolean z_rQZ;
    private boolean z_rRZ;
    private static StringBuffer z_rSStringBuffer = new StringBuffer();
    private Vector z_r0Vector;
    private Vector z_r1Vector;
    private Vector z_rLVector;
    private String f_FQMethodString;
    private String z_rWString;
    private int z_rYI;
    private int z_rXI;
    private boolean z_rZZ;
    private boolean z_r5Z;
    private net.rim.tools.compiler.codfile.TypeList z_rOap[];
    private net.rim.tools.compiler.codfile.InterfaceMethodRef z_rTaaz[];
    private int z_rVI;

    public Method(net.rim.tools.compiler.types.ClassType g1, String s, net.rim.tools.compiler.types.Type a1, int i, int i1)
        throws net.rim.tools.compiler.util.CompileException
    {
        super(s, a1, g1, i1 | 8, -1);
        if(i > 0)
            _parameters = new net.rim.tools.compiler.types.NameAndType[i];
        if((i1 & 2) == 0 || (i1 & 0x10) != 0)
        {
            z_rPZ = true;
            z_r2I = 1;
        }
        z_rXI = -1;
    }

    public void _hZV(boolean flag)
    {
        z_rRZ = flag;
    }

    public boolean _fSvZ()
    {
        return z_rRZ;
    }

    public boolean _fRvZ()
    {
        return z_rZZ;
    }

    public boolean _longgZ(net.rim.tools.compiler.types.ClassType g1)
    {
        boolean flag = z_rRZ;
        if(flag && super._offset != -1 && super._classType._fivaZ() != null)
        {
            boolean aflag[] = g1._fivaZ();
            if(aflag != null)
                flag = aflag[super._offset];
        }
        return flag;
    }

    public void add_parametersToMethod(int i, String s, net.rim.tools.compiler.types.Type a1)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.NameAndType k1 = new net.rim.tools.compiler.types.NameAndType(s, a1, super._classType, 1024, z_r2I);
        _parameters[i] = k1;
        z_r2I += a1.getLocalCount();
        if(z_r2I > 255)
            throw new net.rim.tools.compiler.util.CompileException(super._classType.get_className(), "Too many parameters in method " + _fWvString());
        else
            return;
    }

    public void _fOvV()
    {
        _fWvString();
    }

    public void _cbIV(int i)
    {
        z_rYI = i;
    }

    public void _gotogV(net.rim.tools.compiler.types.ClassType g1)
    {
        if(z_r0Vector == null)
            z_r0Vector = new Vector();
        z_r0Vector.addElement(g1);
    }

    public boolean _fJvZ()
    {
        if(!is(0x30000000))
        {
            addModifiers(0x20000000);
            z_r5Z = _instructionCode._eEvZ();
        }
        return z_r5Z;
    }

    public int _fIvI()
    {
        return z_r2I;
    }

    public int getNumParameters()
    {
        return _parameters != null ? _parameters.length : 0;
    }

    public net.rim.tools.compiler.types.NameAndType getParameter(int i)
    {
        return _parameters[i];
    }

    public net.rim.tools.compiler.types.Type getParameterType(int i)
    {
        return getParameter(i).getType();
    }

    public boolean _fKvZ()
    {
        return z_rPZ;
    }

    public boolean _fLvZ()
    {
        return super._type != null;
    }

    public net.rim.tools.compiler.types.Type _fMva()
    {
        if(_fLvZ())
            return super._type;
        else
            return null;
    }

    public int _fUvI()
    {
        int i = 0;
        if(_fLvZ())
            i = super._type.getLocalCount();
        return i;
    }

    public int getMaxLocalsNum()
    {
        return _instructionCode.getMaxLocalsNum();
    }

    public int getMaxStacksMap()
    {
        return _instructionCode.getMaxStacksMap();
    }

    public boolean _trycZ(net.rim.tools.compiler.types.Method __method)
    {
        int i = getNumParameters();
        if(i != __method.getNumParameters())
            return false;
        if(!super.equals(__method))
            return false;
        for(int i1 = 0; i1 < i; i1++)
        {
            net.rim.tools.compiler.types.Type a1 = getParameterType(i1);
            net.rim.tools.compiler.types.Type a2 = __method.getParameterType(i1);
            if(!a1.equals(a2))
                return false;
        }

        return true;
    }

    public boolean _fTvZ()
    {
        return !is(0x100212);
    }

    public void setInstructionCode(net.rim.tools.compiler.analysis.InstructionCode __instructionCode)
    {
        _instructionCode = __instructionCode;
    }

    public net.rim.tools.compiler.analysis.InstructionCode getInstructionCode()
    {
        return _instructionCode;
    }

    public int _fHvI()
    {
        return _instructionCode._eDvI();
    }

    private void _bytecV(net.rim.tools.compiler.types.Method c1)
    {
        int i = 0;
        if(z_r4ac == null)
        {
            z_r4ac = new net.rim.tools.compiler.types.Method[i + 1];
        } else
        {
            i = z_r4ac.length;
            z_r4ac = net.rim.tools.compiler.exec.MyArrays.resize(z_r4ac, i + 1);
        }
        z_r4ac[i] = c1;
    }

    public void _doCompilerV(Compiler compiler, net.rim.tools.compiler.types.Method c1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(z_r3c == c1)
            return;
        z_r3c = c1;
        c1._bytecV(this);
        if(c1.is(0x10020000))
            _cCompilerV(compiler);
    }

    public void _ifCompilerV(Compiler compiler, net.rim.tools.compiler.types.Method c1)
        throws net.rim.tools.compiler.util.CompileException
    {
        z_rQZ = true;
        c1._bytecV(this);
        if(c1.is(0x10220000))
            _cCompilerV(compiler);
        if(z_rXI == -1 && c1.z_rXI != -1)
            z_rXI = c1.z_rXI;
    }

    int _ccII(int i)
    {
        if(i != -1)
            z_rXI = i++;
        return i;
    }

    int _fQvI()
    {
        return z_rXI;
    }

    public void _cCompilerV(Compiler compiler)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(is(0x10000000))
            return;
        addModifiers(0x10000000);
        if(!is(0x20000))
        {
            compiler.useMethod(this);
            super._classType._aCompilervV(compiler, true);
        }
        if(z_r4ac != null)
        {
            int i = z_r4ac.length;
            for(int i1 = 0; i1 < i; i1++)
            {
                Method c1 = z_r4ac[i1];
                c1._cCompilerV(compiler);
            }

        }
    }

    public String _fVvString()
    {
        if(z_rWString == null)
            synchronized(z_rSStringBuffer)
            {
                z_rSStringBuffer.setLength(0);
                z_rSStringBuffer.ensureCapacity(256);
                z_rSStringBuffer.append(".");
                z_rSStringBuffer.append(super._name);
                z_rSStringBuffer.append("(");
                String s = null;
                if(_parameters != null)
                {
                    int i = _parameters.length;
                    for(int i1 = 0; i1 < i; i1++)
                    {
                        if(s == null)
                            s = ",";
                        else
                            z_rSStringBuffer.append(s);
                        z_rSStringBuffer.append(getParameterType(i1).getName());
                    }

                }
                z_rSStringBuffer.append(")");
                z_rWString = z_rSStringBuffer.toString();
            }
        return z_rWString;
    }

    public String _fWvString()
    {
        if(f_FQMethodString == null)
        {
            _fVvString();
            synchronized(z_rSStringBuffer)
            {
                z_rSStringBuffer.setLength(0);
                z_rSStringBuffer.ensureCapacity(256);
                z_rSStringBuffer.append(super._classType.getFullName());
                z_rSStringBuffer.append(z_rWString);
                f_FQMethodString = z_rSStringBuffer.toString();
            }
        }
        return f_FQMethodString;
    }

    public boolean _fXvZ()
    {
        return z_rQZ;
    }

    public boolean _nullCompilerZ(Compiler compiler)
    {
        if(!_fTvZ())
            return false;
        if(z_rQZ)
            return true;
        if(is(32))
            return true;
        if(super._classType.getSuperClass() == null && is(64) && !is(0x20000))
            return false;
        return !super._classType.hasAttribute(0x10000) || is(0x80000) || z_r3c != null || z_r4ac != null;
    }

    private boolean _forCompilerZ(Compiler compiler, net.rim.tools.compiler.types.Method c1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(c1.is(128))
            return true;
        net.rim.tools.compiler.types.ClassType g1 = c1.getClassType();
        net.rim.tools.compiler.types.ClassType g2 = getClassType();
        String s = g1.getPackageNameString();
        String s1 = g2.getPackageNameString();
        if(s == null && s1 == null)
            return true;
        if(s != null && s1 != null && s.equals(s1))
            return true;
        if(c1.is(256))
        {
            return true;
        } else
        {
            compiler.generateWarning(true, g2.getFullName(), "Method " + _fVvString() + " does not override " + g1.getFullName() + _fVvString());
            return false;
        }
    }

    public void _aCompilerV(Compiler compiler, Vector vector)
        throws net.rim.tools.compiler.util.CompileException
    {
        _hZV(true);
        int i = vector.size();
        for(int i1 = i - 1; i1 >= 0; i1--)
        {
            Method c1 = (Method)vector.elementAt(i1);
            if(_trycZ(c1) && _forCompilerZ(compiler, c1))
            {
                _doCompilerV(compiler, c1);
                setOffset(i1);
                vector.setElementAt(this, i1);
                return;
            }
        }

        setOffset(i);
        vector.addElement(this);
    }

    public int _newVectorI(Vector vector)
    {
        int i = vector.size();
        for(int i1 = i - 1; i1 >= 0; i1--)
        {
            Method c1 = (Method)vector.elementAt(i1);
            if(_trycZ(c1))
                return i1;
        }

        return -1;
    }

    public int _bCompilerI(Compiler compiler)
    {
        int i = -1;
        if(z_rRZ)
        {
            if(super._classType.hasAttribute(0x50000) || compiler.getObjectClass()._bZIZ(super._offset))
                i = super._offset;
        } else
        if(is(0x40000))
            i = z_rYI;
        return i;
    }

    private void _ifCompilerV(Compiler compiler, net.rim.tools.compiler.types.Type a1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(a1 instanceof ArrayType)
        {
            ArrayType l1 = (ArrayType)a1;
            a1 = l1.getMostBaseType();
        }
        if(a1 instanceof net.rim.tools.compiler.types.ClassType)
        {
            net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)a1;
            g1._aCompilervV(compiler, !is(0x20000));
        }
    }

    public void _dCompilerV(Compiler compiler)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(is(0x20000000) || !is(0x10000000))
            return;
        addModifiers(0x20000000);
        if(is(16))
            super._classType._elseCompilerV(compiler);
        _ifCompilerV(compiler, super._type);
        if(_parameters != null)
        {
            int i = _parameters.length;
            for(int i1 = 0; i1 < i; i1++)
            {
                net.rim.tools.compiler.types.Type a1 = getParameterType(i1);
                _ifCompilerV(compiler, a1);
            }

        }
        if(!is(0x20000) && _instructionCode != null)
        {
            _instructionCode._intCompilerV(compiler);
            if(isAnd(0x2000002) && super._name.startsWith("access$"))
                z_rZZ = _instructionCode._newCompilerZ(compiler);
        }
    }

    public void _voidCompilerV(Compiler compiler)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(is(0x40000000) || !is(0x10000000))
            return;
        addModifiers(0x40000000);
        if(_instructionCode != null && !z_rZZ)
            _instructionCode.resolve(compiler);
    }

    public TypeList _intmp(net.rim.tools.compiler.types.TypeModule m1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(z_rOap == null)
        {
            int i = m1.getCount();
            z_rOap = new TypeList[i];
        }
        int i1 = m1.getOrdinal();
        if(z_rOap[i1] == null)
        {
            net.rim.tools.compiler.types.ClassType g1 = null;
            if(z_rPZ)
                g1 = super._classType;
            z_rOap[i1] = net.rim.tools.compiler.types.Type.getTypeList(m1, g1, _parameters);
        }
        return z_rOap[i1];
    }

    boolean _gotoCompilerZ(Compiler compiler)
    {
        if(is(0x8300011))
            return false;
        if(!is(2) && z_rRZ)
            return false;
        return is(512) || !is(384) && compiler.isOptimizePackage();
    }

    public Member _ifCompilerr(Compiler __compiler, net.rim.tools.compiler.types.TypeModule __module)
        throws net.rim.tools.compiler.util.CompileException
    {
        int i = __module.getOrdinal();
        net.rim.tools.compiler.codfile.Member _member_ = getMember(i, __module.getCount());
        if(_member_ == null)
        {
            boolean flag = _gotoCompilerZ(__compiler);
            net.rim.tools.compiler.codfile.DataSection _dataSection_ = __module.getDataSection();
            net.rim.tools.compiler.codfile.ClassDef _classDef_ = super._classType.getClassDef(__module);
            net.rim.tools.compiler.codfile.TypeList _typeList_ = net.rim.tools.compiler.types.Type.getTypeList(__module, super._type);
            net.rim.tools.compiler.codfile.TypeList p2 = _intmp(__module);
            net.rim.tools.compiler.codfile.Routine _routine_ = _classDef_.makeRoutine(_dataSection_, super._name, flag, _typeList_, p2);
            if(!is(0x20000))
            {
                if(_routine_ instanceof net.rim.tools.compiler.codfile.RoutineDomestic)
                {
                    net.rim.tools.compiler.codfile.RoutineDomestic d1 = (net.rim.tools.compiler.codfile.RoutineDomestic)_routine_;
                    d1.setSibling((net.rim.tools.compiler.codfile.RoutineLocal)_ifCompilerr(__compiler, super._classType.getTypeModule()));
                } else
                if(_routine_ instanceof net.rim.tools.compiler.codfile.RoutineLocal)
                {
                    net.rim.tools.compiler.codfile.RoutineLocal z1 = (net.rim.tools.compiler.codfile.RoutineLocal)_routine_;
                    z1.setAttributes(net.rim.tools.compiler.types.Modifier._ctII(super._modifiers));
                }
            } else
            {
                if(__compiler.getObjectClass()._bZIZ(super._offset))
                    _routine_.setAddress(super._offset);
                if(is(0x40000))
                {
                    _routine_.setOffset(z_rYI);
                    _routine_.setAddress(super._offset);
                }
            }
            _member_ = setMember(_routine_, i);
        }
        return _member_;
    }

    public InterfaceMethodRef _forCompileraz(Compiler compiler, net.rim.tools.compiler.types.TypeModule m1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(z_rTaaz == null)
        {
            int i = m1.getCount();
            z_rTaaz = new net.rim.tools.compiler.codfile.InterfaceMethodRef[i];
        }
        int i1 = m1.getOrdinal();
        if(z_rTaaz[i1] == null)
        {
            net.rim.tools.compiler.codfile.DataSection k1 = m1.getDataSection();
            net.rim.tools.compiler.codfile.InterfaceMethodRef az1 = null;
            if(super._classType.isProcessed())
            {
                net.rim.tools.compiler.codfile.Routine a5_1 = (net.rim.tools.compiler.codfile.Routine)_ifCompilerr(compiler, m1);
                a5_1.makeSymbolic(m1.getDataSection(), true);
                az1 = k1.makeInterfaceMethodRef(a5_1);
            } else
            {
                az1 = k1.getNullInterfaceMethodRef();
            }
            z_rTaaz[i1] = az1;
        }
        return z_rTaaz[i1];
    }

    public int _amI(net.rim.tools.compiler.types.TypeModule m1, net.rim.tools.compiler.types.Method c1)
    {
        if(z_rJc != c1)
        {
            z_rNI = m1._gavI();
            z_rJc = c1;
        }
        return z_rNI;
    }

    public boolean _doCompilerZ(Compiler compiler, net.rim.tools.compiler.types.TypeModule _module_)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(is(0x80020000))
            return false;
        if(!is(0x10000000))
            return false;
        if(z_rZZ)
            _instructionCode = null;
        if(_instructionCode == null)
            return false;
        addModifiers(0x80000000);
        super._longCompilerV(compiler);
        g g1 = compiler._fvg();
        boolean flag = is(512);
        if(!flag)
            g1.append("( ");
        if(_parameters != null)
        {
            int j1 = _parameters.length;
            for(int i = 0; i < j1; i++)
            {
                net.rim.tools.compiler.types.NameAndType k2 = _parameters[i];
                if(!flag)
                    g1._byteStringV(k2.getType().getFullName());
            }

        }
        if(!flag)
            g1.append(") ");
        if(z_r0Vector != null)
        {
            if(!flag)
                g1.append("throws ");
            int k1 = z_r0Vector.size();
            for(int i1 = 0; i1 < k1; i1++)
            {
                net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)z_r0Vector.elementAt(i1);
                if(!flag)
                    g1._byteStringV(g2.getFullName());
            }

        }
        _ifCompilerr(compiler, _module_);
        _instructionCode.populate(compiler, _module_);
        _instructionCode = null;
        return true;
    }

    public net.rim.tools.compiler.a.cls_j _ifCompilerj(Compiler compiler, net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_rGl == null)
        {
            RoutineLocal z1 = (RoutineLocal)getMember(m1.getOrdinal(), m1.getCount());
            if(z1 == null)
                return null;
            int i = z1.getOffset();
            int i1 = i + z1.getCode().getExtent();
            if(i == -1)
                return null;
            net.rim.tools.compiler.a.cls_e e;
            if(_fLvZ())
                e = super._type._afe(f1, m1);
            else
                e = compiler.getVoidType()._afe(f1, m1);
            net.rim.tools.compiler.a.cls_o o1 = new net.rim.tools.compiler.a.cls_o(i, i1);
            net.rim.tools.compiler.a.cls_j j1 = new net.rim.tools.compiler.a.cls_j(super._name, e, Modifier.toCodfileClassAttribute(super._modifiers), i, o1);
            super.z_rGl = j1;
            if(z_rPZ)
            {
                net.rim.tools.compiler.a.cls_e e1 = super._classType._afe(f1, m1);
                j1._doeV(e1);
                boolean flag = true;
                if(z_r1Vector != null)
                {
                    int l2 = z_r1Vector.size();
                    for(int k1 = 0; k1 < l2; k1++)
                    {
                        af af3 = (af)z_r1Vector.elementAt(k1);
                        if(af3.getIndex() != 0)
                            continue;
                        flag = false;
                        break;
                    }

                }
                if(flag)
                    j1._ahV(new net.rim.tools.compiler.a.cls_h("this", e1, 0, o1));
            }
            if(_parameters != null)
            {
                int i3 = _parameters.length;
                for(int l1 = 0; l1 < i3; l1++)
                {
                    net.rim.tools.compiler.types.NameAndType k4 = _parameters[l1];
                    net.rim.tools.compiler.a.cls_e e2 = k4.getType()._afe(f1, m1);
                    j1._doeV(e2);
                    int i4 = k4.getOffset();
                    boolean flag1 = true;
                    if(z_r1Vector != null)
                    {
                        int i5 = z_r1Vector.size();
                        for(int k5 = 0; k5 < i5; k5++)
                        {
                            af af5 = (af)z_r1Vector.elementAt(k5);
                            if(af5.getIndex() != i4)
                                continue;
                            flag1 = false;
                            break;
                        }

                    }
                    if(flag1)
                    {
                        String s1 = k4.getName();
                        if(s1 == null)
                            s1 = "_" + i4;
                        j1._ahV(new net.rim.tools.compiler.a.cls_h(s1, e2, i4, o1));
                    }
                }

            }
            if(z_r1Vector != null)
            {
                int j3 = z_r1Vector.size();
                for(int i2 = 0; i2 < j3; i2++)
                {
                    af af1 = (af)z_r1Vector.elementAt(i2);
                    String s = af1.getName();
                    for(int j4 = i2 + 1; j4 < j3; j4++)
                    {
                        af af4 = (af)z_r1Vector.elementAt(j4);
                        if(s.equals(af4.getName()))
                        {
                            int j5 = af1.getStart() + af1.getLength();
                            int l5 = af4.getStart();
                            if(j5 > l5)
                                af1._ifIV(l5 - af1.getStart() - 1);
                        }
                    }

                }

                for(int j2 = 0; j2 < j3; j2++)
                {
                    af af2 = (af)z_r1Vector.elementAt(j2);
                    int l3 = af2.getStart();
                    int l4 = l3 + af2.getLength();
                    net.rim.tools.compiler.a.cls_e e3 = ((net.rim.tools.compiler.types.Type)af2._ifvObject())._afe(f1, m1);
                    net.rim.tools.compiler.a.cls_o o2 = new net.rim.tools.compiler.a.cls_o(i + l3, i + l4);
                    j1._ahV(new net.rim.tools.compiler.a.cls_h(af2.getName(), e3, af2.getIndex(), o2));
                }

            }
            z_r1Vector = null;
            if(z_rLVector != null)
            {
                int k3 = z_rLVector.size();
                for(int k2 = 0; k2 < k3; k2++)
                {
                    CodfileLabel a6_1 = (CodfileLabel)z_rLVector.elementAt(k2);
                    j1._amV(new net.rim.tools.compiler.a.cls_m(i + a6_1.getEnd(), a6_1.getOffset()));
                }

            }
            z_rLVector = null;
        }
        return (net.rim.tools.compiler.a.cls_j)super.z_rGl;
    }

    public void _aafV(net.rim.tools.compiler.classfile.af af1)
    {
        if(z_r1Vector == null)
            z_r1Vector = new Vector();
        z_r1Vector.addElement(af1);
    }

    public void _ifa6V(net.rim.tools.compiler.codfile.CodfileLabel a6_1)
    {
        if(z_rLVector == null)
            z_rLVector = new Vector();
        z_rLVector.addElement(a6_1);
    }

    public boolean _ifStringZ(String s, net.rim.tools.compiler.types.Type a1, Vector vector)
    {
        if(!super._name.equals(s))
            return false;
        if(super._type != a1)
            return false;
        int i = getNumParameters();
        if(i != vector.size())
            return false;
        for(int i1 = 0; i1 < i; i1++)
        {
            net.rim.tools.compiler.types.Type a2 = getParameterType(i1);
            net.rim.tools.compiler.types.Type a3 = (net.rim.tools.compiler.types.Type)vector.elementAt(i1);
            if(a2 != a3)
                return false;
        }

        return true;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Method)
        {
            Method c1 = (Method)obj;
            if(this == c1)
                return true;
            if(!super._name.equals(c1.getName()))
                return false;
            if(super._type != c1.getType())
                return false;
            int i = getNumParameters();
            if(i != c1.getNumParameters())
                return false;
            for(int i1 = 0; i1 < i; i1++)
            {
                net.rim.tools.compiler.types.Type a1 = getParameterType(i1);
                net.rim.tools.compiler.types.Type a2 = c1.getParameterType(i1);
                if(a1 != a2)
                    return false;
            }

            return true;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        int i = super._name.hashCode() * 31 + super._type.hashCode();
        int i1 = getNumParameters();
        for(int j1 = 0; j1 < i1; j1++)
            i = i * 31 + getParameterType(j1).hashCode();

        return i;
    }

    public void _cdIV(int i)
    {
        z_rVI = i;
    }

    public boolean _b8IZ(int i)
    {
        return z_rVI == i;
    }

    public int _fPvI()
    {
        return z_rVI;
    }

}
