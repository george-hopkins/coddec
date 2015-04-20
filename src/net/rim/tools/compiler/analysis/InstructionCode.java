// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.codfile.StackMap;
import net.rim.tools.compiler.codfile.ExceptionHandler;
import net.rim.tools.compiler.codfile.Code;
import net.rim.tools.compiler.codfile.CodfileLabel;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.RoutineLocal;
import net.rim.tools.compiler.classfile.ad;
import net.rim.tools.compiler.classfile.af;
import net.rim.tools.compiler.classfile.ai;
import net.rim.tools.compiler.classfile.al;
import net.rim.tools.compiler.classfile.JavaByteCodes;
import net.rim.tools.compiler.classfile.AttributeStackMap;
import net.rim.tools.compiler.classfile.ClassFileExceptionHandler;
import net.rim.tools.compiler.classfile.AttributeLocalVariableTable;
import net.rim.tools.compiler.classfile.AttributeStackMapTable;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.ClassUninitializedType;
import net.rim.tools.compiler.types.TypeModule;

// Referenced classes of package net.rim.tools.compiler.g:
//            d, j, c, b,
//            k

public final class InstructionCode
implements net.rim.tools.compiler.vm.Constants
{

    private static final int z_pYI = -8;
    private static net.rim.tools.compiler.classfile.JavaByteCodes z_p6j = new net.rim.tools.compiler.classfile.JavaByteCodes();
    private static net.rim.tools.compiler.analysis.InstructionResolver z_p2j = new net.rim.tools.compiler.analysis.InstructionResolver();
    private static net.rim.tools.compiler.analysis.InstructionPopulater z_qic = new net.rim.tools.compiler.analysis.InstructionPopulater();
    private static net.rim.tools.compiler.analysis.b z_qcb = new net.rim.tools.compiler.analysis.b();
    private static net.rim.tools.compiler.analysis.k z_qkk = new net.rim.tools.compiler.analysis.k();
    private net.rim.tools.compiler.types.Method _method;
    private boolean z_qmZ;
    private boolean z_qeZ;
    private net.rim.tools.compiler.classfile.ConstantPool _constsPool;
    private net.rim.tools.compiler.classfile.ClassFileExceptionHandler _exceptionHandlers[];
    private net.rim.tools.compiler.classfile.AttributeStackMapTable _attributeStackMapTable;
    private int f_maxMethodStackMapI;
    private int f_maxLocalsNumberI;
    private byte f_codeByteArray[];
    private int f_codeSizeI;
    private int f_codeWeightI;
    private int z_p9I;
    private net.rim.tools.compiler.classfile.ai z_p1ai;
    private net.rim.tools.compiler.classfile.AttributeLocalVariableTable z_qgs;
    private net.rim.tools.compiler.classfile.AttributeLineNumberTable z_p8z;
    private int z_qjI;
    private int z_qbI;
    private int z_p3I;
    private int z_qfI;

    public InstructionCode(net.rim.tools.compiler.types.Method c1, int param_maxStackMap, int param_maxLocalsNumber, byte param_codeByteArray[], net.rim.tools.compiler.classfile.ConstantPool param_constsPool)
    {
        _method = c1;
        f_maxMethodStackMapI = param_maxStackMap;
        f_maxLocalsNumberI = param_maxLocalsNumber;
        f_codeByteArray = param_codeByteArray;
        f_codeSizeI = param_codeByteArray != null ? param_codeByteArray.length : 0;
        _constsPool = param_constsPool;
    }

    public final void _eFvV()
    {
        z_qeZ = true;
    }

    public final void _gZV(boolean flag)
    {
        z_qmZ = flag;
    }

    public final int getMaxStacksMap()
    {
        return f_maxMethodStackMapI;
    }

    public final void set_maxMethodStackMap(int l)
    {
        f_maxMethodStackMapI = l;
    }

    public final void _cIIV(int l, int i1)
    {
        z_p3I = l;
        z_qfI = i1 - l;
    }

    public final int _eyvI()
    {
        return z_p3I;
    }

    public final int _eCvI()
    {
        return z_qfI;
    }

    public final int inc_maxLocalsNumber()
    {
        return f_maxLocalsNumberI++;
    }

    public final int getMaxLocalsNum()
    {
        return f_maxLocalsNumberI;
    }

    public final void setExceptionHandlers(net.rim.tools.compiler.classfile.ClassFileExceptionHandler __exceptionHandlers[])
    {
        _exceptionHandlers = __exceptionHandlers;
    }

    public final void _awV(net.rim.tools.compiler.classfile.AttributeStackMapTable __stackMapTable)
    {
        _attributeStackMapTable = __stackMapTable;
    }

    public final void _doaiV(net.rim.tools.compiler.classfile.ai ai1)
    {
        z_p1ai = ai1;
    }

    public final ai _eBvai()
    {
        return z_p1ai;
    }

    public final void _asV(net.rim.tools.compiler.classfile.AttributeLocalVariableTable s1)
    {
        z_qgs = s1;
    }

    public final void _azV(net.rim.tools.compiler.classfile.AttributeLineNumberTable z1)
    {
        z_p8z = z1;
        if(z1._cQvI() > 0)
            z_qjI = z1._aVII(0);
    }

    public final int _eDvI()
    {
        return z_qjI;
    }

    private void _aCompilerV(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(_attributeStackMapTable != null)
        {
            int l = _attributeStackMapTable.getNumStackMaps();
            for(int i1 = 0; i1 < l; i1++)
            {
                net.rim.tools.compiler.classfile.AttributeStackMap k1 = _attributeStackMapTable.getStackMap(i1);
                int j1 = k1._forvI();
                net.rim.tools.compiler.analysis.InstructionStackEntry d1 = new net.rim.tools.compiler.analysis.InstructionStackEntry(_method._fWvString(), j1, f_maxLocalsNumberI, f_maxMethodStackMapI, k1._newvaa(), compiler.getVoidType());
                z_p1ai._aIdV(j1, d1);
            }

            _attributeStackMapTable = null;
        }
    }

    private void _doCompilerV(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(_exceptionHandlers != null)
        {
            int k1 = _exceptionHandlers.length;
            for(int l = 0; l < k1; l++)
            {
                net.rim.tools.compiler.classfile.ClassFileExceptionHandler n1 = _exceptionHandlers[l];
                net.rim.tools.compiler.types.ClassType g1 = n1.getExceptionClass();
                if(g1 != null)
                    g1._aCompilervV(compiler, true);
                z_p1ai._aIIIIV(l, n1.getStart(), n1.getEnd(), n1.getHandler(), g1);
            }

            _exceptionHandlers = null;
        }
        if(z_qgs != null)
        {
            int l1 = z_qgs._cNvI();
            for(int i1 = 0; i1 < l1; i1++)
            {
                af af1 = z_qgs._aRIaf(i1);
                int j2 = af1.getStart();
                int k2 = j2 + af1.getLength();
                z_p1ai._aIIV(j2, k2, af1);
            }

            z_qgs = null;
        }
        if(z_p8z != null)
        {
            int i2 = z_p8z._cQvI();
            for(int j1 = 0; j1 < i2; j1++)
                z_p1ai._gotoIIV(z_p8z._aUII(j1), z_p8z._aVII(j1));

            z_p8z = null;
        }
    }

    private void populate(Compiler compiler, ClassType g1)
	throws net.rim.tools.compiler.util.CompileException
    {
        InstructionTarget x1 = new InstructionTarget(0, 0, null, null);
        int l = -8;
        if(f_codeSizeI > 0)
        {
            int i1 = _method._fIvI();
            if(f_maxLocalsNumberI > 255 || f_maxMethodStackMapI > 255 || i1 > 255)
            {
                int ai1[] = new int[3];
                ai1[0] = f_maxLocalsNumberI >> 8;
                ai1[1] = i1 >> 8;
                ai1[2] = f_maxMethodStackMapI >> 8;
                if(z_p1ai._dVvI() > 0)
                    x1._aIIaIV(l++, 17, ai1, false);
                else
                    x1._aIIaIV(l++, 15, ai1, false);
            } else
            if(z_p1ai._dVvI() > 0)
                x1._charIIV(l++, 16);
            else
                x1._charIIV(l++, 14);
        } else
        if(!_method.is(1) && !z_qmZ)
            if(compiler._dvZ())
                x1._charIIV(l++, 0);
            else
                x1._charIIV(l++, 250);
        if(_method.is(32768) && !_method.is(1))
            if(_method.is(2))
                x1.addInstruction(l++, 19, g1);
            else
                x1._charIIV(l++, 18);
        if(_method.is(0x100000))
        {
            ClassType g2 = g1.getSuperClass();
            if(g2 != null && g2 != compiler.getObjectClass())
                if(g2.hasAttribute(0x20000))
                    x1.addInstruction(l++, 187, g2);
                else
                    x1.addInstruction(l++, 186, g2);
            x1.addInstruction(l++, 19, g1);
            x1._charIIV(l++, 20);
        }
        if(_method.is(1))
        {
            compiler.setNativeMethod(_method);
            byte byte0 = 10;
            if(_method._fLvZ())
            {
                int j1 = _method._fMva().getSize();
                if(j1 == 8)
                    byte0 = 11;
                else
                    byte0 = 9;
            }
            x1._aIIgV(l++, byte0, g1, _method);
        }
        InstructionTarget x2 = z_p1ai._bkIx(0);
        if(x2._c7vZ() || x2._baIZ(9))
        {
            x1._doxV(x2);
            z_p1ai._doxvV(x1, 0);
        } else
        {
            x2._doVectorV(x1._dHvVector());
        }
    }

    public void _intCompilerV(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_qeZ)
            return;
        int l = compiler.getOptimization();
        if(_method.is(0x100000))
            l |= 4;
        net.rim.tools.compiler.types.ClassType g1 = _method.getClassType();
        z_p1ai = new ai(f_codeSizeI);
        try
        {
            boolean flag = false;
            synchronized(z_p2j)
            {
                z_p2j.init(compiler, g1, _method, z_p1ai, f_codeSizeI);
                _aCompilerV(compiler);
                if(f_codeByteArray != null)
                    synchronized(z_p6j)
                    {
                        z_p6j.walk(l, f_codeByteArray, _constsPool, z_p2j);
                        z_p6j.fini();
                    }
                _constsPool = null;
                f_codeByteArray = null;
                _doCompilerV(compiler);
                if(!_method.is(33))
                {
                    z_p1ai._dZV(false);
                    flag = z_p2j._edvZ();
                    z_p2j._ecvV();
                    if(z_p1ai._dUvZ())
                    {
                        _method.addModifiers(0x8000000);
                        compiler.generateWarning(false, g1.get_className(), "Bad label detected in routine: " + _method.getName());
                    }
                }
                z_p2j.fini();
            }
            int i1 = z_p1ai._dSvI();
            if(i1 > 0)
            {
                _method.addModifiers(0x8000000);
                for(int k1 = 0; k1 < i1; k1++)
                {
                    InstructionTarget x1 = z_p1ai._bmIx(k1);
                    compiler.generateWarning(false, g1.get_className(), "Bad label at offset: 0x" + Integer.toHexString(x1.getOffset()) + " found in routine: " + _method.getName());
                }

                if(flag)
                    throw new CompileException(g1.get_className(), "jsr/ret opcodes are not supported in routine: " + _method.getName());
            } else
            if(flag)
            {
                compiler.generateWarning(compiler.isPreverified(), g1.get_className(), "jsr/ret opcodes found in routine: " + _method.getName());
                f_codeSizeI = z_p1ai._brII(l);
            } else
            if(_method.is(0x8000000))
                z_p1ai._dZV(true);
            else
                f_codeSizeI = z_p1ai._btII(l);
            if(z_p1ai._dUvZ() && !_method.is(0x8000000))
            {
                _method.addModifiers(0x8000000);
                compiler.generateWarning(false, g1.get_className(), "Bad control flow detected in routine: " + _method.getName());
            }
            populate(compiler, g1);
        }
        catch(CompileException a1)
        {
            throw a1;
        }
        catch(Exception exception)
        {
            if(compiler.getTraceback())
                exception.printStackTrace();
            throw new CompileException(g1.getFullName(), exception.getMessage() + " in " + _method.getName());
        }
    }

    public boolean _eEvZ()
    {
        boolean flag = true;
        if(f_codeByteArray != null)
        {
            int l = f_codeByteArray.length;
            if(l > 2)
            {
                flag = false;
            } else
            {
                for(int i1 = 0; i1 < l && flag; i1++)
                {
                    switch(f_codeByteArray[i1] & 0xff)
                    {
                    case 1: // '\001'
                    case 3: // '\003'
                    case 9: // '\t'
                    case 172:
                    case 173:
                    case 176:
                    case 177:
                        continue;

                    default:
                        flag = false;
                        break;
                    }
                    break;
                }

            }
            f_codeByteArray = null;
        }
        return flag;
    }

    private InstructionStackEntry _forCompilerd(Compiler compiler)
        throws CompileException
    {
        net.rim.tools.compiler.types.Type a1 = compiler.getVoidType();
        InstructionStackEntry d1 = new InstructionStackEntry(_method._fWvString(), f_maxLocalsNumberI, f_maxMethodStackMapI, a1);
        d1._c6vV();
        int l = f_maxLocalsNumberI;
        int i1 = _method.getNumParameters();
        if(_method._fKvZ())
        {
            Object obj = _method.getClassType();
            if(_method.is(16))
                obj = new ClassUninitializedType((ClassType)obj, 0);
            d1._ifaV(((net.rim.tools.compiler.types.Type) (obj)));
            l--;
        }
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Type a5 = _method.getParameterType(j1);
            d1._ifaV(a5);
            l--;
            if(a5.isTwoWord())
                l--;
        }

        for(; l > 0; l--)
            d1._ifaV(a1);

        return d1;
    }

    public boolean _newCompilerZ(Compiler compiler)
    {
        f_codeWeightI = 14;
        boolean flag = false;
        if(!_method.is(0x8000000))
            synchronized(z_qcb)
            {
                z_qcb._aCompilercV(compiler, _method.getClassType(), _method, z_p1ai);
                flag = z_qcb._afZ(this);
            }
        return flag;
    }

    public void resolve(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1;
        g1 = _method.getClassType();
        f_codeWeightI = 14;
label0:
        {
            if(_method.is(0x8000021));
                //break MISSING_BLOCK_LABEL_368;
            int l = z_p1ai._d5vI();
            synchronized(z_qcb)
            {
                z_qcb._aCompilercV(compiler, g1, _method, z_p1ai);
                while(z_p1ai._ifeZ(z_qcb)) ;
                f_codeSizeI = z_p1ai._dTvI();
                if(!_method.is(0x100000) || !z_qcb._ejvZ())
                    break label0;
                _method.setInstructionCode(null);
            }
            return;
        }
        //b1;
        //JVM INSTR monitorexit ;
        //  goto _L1
        //exception1;
        //throw exception1;
//_L1:
        int i1 = z_p1ai._d5vI();
        if(i1 < f_maxMethodStackMapI && f_maxMethodStackMapI <= 255)
            f_maxMethodStackMapI = i1;
        synchronized(z_qkk)
        {
            z_qkk._aCompilerV(compiler, _method, z_p1ai, f_maxLocalsNumberI);
            try
            {
                InstructionStackEntry d1 = _forCompilerd(compiler);
                InstructionStackEntry d3 = z_p1ai._bkIx(0).getStackEntry();
                if(d3 == null)
                    z_p1ai._aIdV(0, d1);
                else
                    d3._adCompilerV(d1, false, compiler);
                do
                {
                    z_qkk._efvV();
                    z_p1ai._ifeZ(z_qkk);
                } while(z_qkk._ehvZ());
                z_qkk._egvV();
                z_p1ai._ifeZ(z_qkk);
            }
            catch(net.rim.tools.compiler.util.i i2)
            {
                _method.addModifiers(0x8000000);
                compiler.generateWarning(false, g1.get_className(), i2.getMessage() + " in " + _method.getName());
                if(compiler.getTraceback())
                    i2.printStackTrace();
            }
            z_qkk._eivV();
        }
        z_p9I = z_p1ai._d6vI();
        f_codeWeightI += z_p9I;
        int j1 = z_p1ai._dVvI();
        if(j1 > 0)
            f_codeWeightI += 2 + j1 * ExceptionHandler._IvI();
        j1 = z_p1ai._d3vI();
        for(int k1 = 0; k1 < j1; k1++)
        {
            InstructionTarget x1 = z_p1ai._bkIx(k1);
            InstructionStackEntry d2 = x1.getStackEntry();
            if(d2 != null)
                if(_method.is(0x8000000))
                {
                    if(d2._c3vZ())
                    {
                        z_qbI++;
                        d2._c4vV();
                    }
                } else
                if(x1._c7vZ() && !x1._dBvZ() && !x1._devZ())
                    z_qbI++;
                else
                if(x1._devZ() || x1._c7vZ())
                {
                    if(!d2._cWvZ())
                    {
                        if(x1._c7vZ() && !x1._devZ())
                            z_qbI++;
                        else
                            x1.setStackEntry(null);
                    } else
                    {
                        z_qbI++;
                    }
                } else
                {
                    x1.setStackEntry(null);
                }
        }

        j1 = z_p1ai._dSvI();
        for(int l1 = 0; l1 < j1; l1++)
        {
            InstructionTarget x2 = z_p1ai._bmIx(l1);
            InstructionStackEntry d4 = x2.getStackEntry();
            if(d4 != null)
                z_qbI++;
        }

        f_codeWeightI += StackMap.getEntrySize() * z_qbI;
        //break MISSING_BLOCK_LABEL_760;
        //net.rim.tools.compiler.pkg_f.a a1;
        //a1;
        //throw a1;
        //Exception exception;
        //exception;
        //if(compiler._forvZ())
        //    exception.printStackTrace();
        //throw new net.rim.tools.compiler.pkg_f.a(g1._fovString(), exception.getMessage() + " in " + z_p4c._fAvString());
        //g1._bOIV(z_p7I);
        return;
    }

    public void populate(Compiler __compiler, TypeModule __module)
	throws net.rim.tools.compiler.util.CompileException
    {
        RoutineLocal _routineLocal_ = (RoutineLocal)_method._ifCompilerr(__compiler, __module);
        _routineLocal_.setByteCodeWeight(z_p9I);
        Code _code_ = _routineLocal_.getCode();
        ClassType _class_ = _method.getClassType();
        _routineLocal_.setWeights("codeWeight: " + f_codeWeightI);
        _code_._amIV(z_p1ai._d2vI());
        synchronized(z_qic)
        {
            z_qic.init(__compiler, _method, __module);
            z_p1ai._ifeZ(z_qic);
            z_qic.fini();
        }
        int i2 = z_p1ai._dSvI();
        if(i2 > 0)
        {
            CodfileLabel a6_1 = _code_._bvva6();
            for(int l = 0; l < i2; l++)
            {
                CodfileLabel a6_2 = a6_1;
                InstructionTarget x1 = z_p1ai._bmIx(l);
                InstructionTarget x2 = x1._dwvx();
                if(x2 != null)
                    a6_2 = x2.getLabel();
                x1.setLabel(new CodfileLabel(a6_2));
            }

        }
        _code_._buvV();
        f_codeSizeI = _code_._brvI();
        i2 = z_p1ai._dVvI();
        _routineLocal_.allocateExceptionHandlers(i2);
        for(int i1 = 0; i1 < i2; i1++)
        {
            ad ad1 = z_p1ai._bpIad(i1);
            ClassType g2 = ad1._dLvg();
            net.rim.tools.compiler.codfile.ClassDef u;
            if(g2 != null)
                u = g2.getClassDef(__module);
            else
                u = __module._trymu(__module);
            ExceptionHandler a3_1 = new ExceptionHandler(ad1._dNvx().getLabel(), ad1._dKvx().getLabel(), ad1._dMvx().getLabel(), u);
            _routineLocal_.addExceptionHandler(a3_1);
        }

        net.rim.tools.compiler.codfile.DataSection k2 = __module.getDataSection();
        if(z_qbI > 255)
            throw new CompileException(_class_.getFullName(), "Error!: control flow verification information too large: " + _method.getName());
        _routineLocal_.allocateStackMaps(z_qbI);
        i2 = z_p1ai._d3vI();
        int j2 = _method._fIvI();
        int l2 = j2 - 1;
        boolean flag = false;
        for(int j1 = 0; j1 < i2; j1++)
        {
            InstructionTarget x3 = z_p1ai._bkIx(j1);
            int j3 = x3._dnvI();
            if(j3 > l2)
                l2 = j3;
            InstructionStackEntry d2 = x3.getStackEntry();
            if(d2 != null)
            {
                TypeList p2 = null;
                boolean flag1 = false;
                if(d2._c0vZ())
                    flag1 = true;
                else
                if(x3._c7vZ() && !x3._dBvZ() && !x3._devZ())
                    flag1 = true;
                else
                if(x3._devZ() || x3._c7vZ())
                    if(!d2._cWvZ())
                    {
                        if(x3._c7vZ() && !x3._devZ())
                        {
                            p2 = k2.getTypeLists().getSomethingTypeList();
                            flag1 = true;
                        }
                    } else
                    {
                        flag1 = true;
                    }
                if(flag1)
                {
                    if(p2 == null)
                        p2 = net.rim.tools.compiler.types.Type.getTypeList(__module, null, d2._cSvaa(), d2._cZvI(), !_method.is(0x8000000));
                    _routineLocal_.addStackMap(new StackMap(x3.getLabel(), k2, p2));
                    if(p2._axvI() > j2)
                        flag = true;
                }
            }
        }

        i2 = z_p1ai._dSvI();
        for(int k1 = 0; k1 < i2; k1++)
        {
            InstructionTarget x4 = z_p1ai._bmIx(k1);
            InstructionStackEntry d1 = x4.getStackEntry();
            if(d1 != null)
            {
                TypeList p1 = net.rim.tools.compiler.types.Type.getTypeList(__module, null, d1._cSvaa(), d1._cZvI(), !_method.is(0x8000000));
                _routineLocal_.addStackMap(new StackMap(x4.getLabel(), k2, p1));
            }
        }

        if(++l2 < f_maxLocalsNumberI && !flag && !_method.is(0x8000000))
        {
            f_maxLocalsNumberI = l2;
            _code_._asIV(f_maxLocalsNumberI >> 8);
        }
        _routineLocal_.setNumLocals(f_maxLocalsNumberI);
        _routineLocal_.setNumStack(f_maxMethodStackMapI);
        _class_._bSIV(f_maxLocalsNumberI + f_maxMethodStackMapI);
        i2 = z_p1ai._dPvI();
        if(i2 > 0)
        {
            int i3 = _method.getNumParameters();
            for(int l1 = 0; l1 < i2; l1++)
            {
                al al1 = z_p1ai._buIal(l1);
                af af1 = al1._eavaf();
                int k3 = af1.getIndex();
                if(k3 < j2)
                {
                    for(int l3 = 0; l3 < i3; l3++)
                    {
                        net.rim.tools.compiler.types.NameAndType k4 = _method.getParameter(l3);
                        if(k4.getOffset() == k3 && k4.getName() == null)
                            k4.setName(af1.getName());
                    }

                }
                if(k3 < f_maxLocalsNumberI)
                {
                    int i4 = al1._d8vx().getLabel().getEnd();
                    af1._aIV(i4);
                    af1._ifIV(al1._d9vx().getLabel().getEnd() - i4);
                    _method._aafV(af1);
                }
            }

        }
        z_p1ai = null;
    }

}
