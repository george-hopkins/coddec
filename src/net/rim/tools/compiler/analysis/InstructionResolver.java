// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import java.io.PrintStream;
import java.util.Vector;
import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.classfile.ConstantPoolLong;
import net.rim.tools.compiler.classfile.ad;
import net.rim.tools.compiler.classfile.ai;
import net.rim.tools.compiler.classfile.al;
import net.rim.tools.compiler.classfile.ConstantPoolField;
import net.rim.tools.compiler.classfile.TypeDescriptor;
import net.rim.tools.compiler.classfile.ConstantPoolMethodRef;
import net.rim.tools.compiler.classfile.u;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.BaseType;
import net.rim.tools.compiler.types.Constant;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.Field;
import net.rim.tools.compiler.types.NameAndType;
import net.rim.tools.compiler.types.ArrayType;

// Referenced classes of package net.rim.tools.compiler.g:
//            i, m, d, g

public final class InstructionResolver
implements net.rim.tools.compiler.vm.Constants, net.rim.tools.compiler.classfile.u
{

    private static final int z_piI = 0;
    private static final int z_poI = 1;
    private static final int z_phI = 2;
    private static final int z_ppI = -1;
    private static final int z_pgaI[] = {
        204, 34, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, 175, 177, -1, -1,
        176, 172, 174, 173, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, 181,
        183, -1, -1, 182, 178, 179, 180, 205, 206, 207,
        209, 210, 208, 211, 212, 213, 122, 123, 256, 257,
        124, 125, 258, 259, 126, 127, 260, 261, 128, 129,
        262, 263, 130, 131, 264, 265, 118, 119, 266, 267,
        138, 139, 140, 141, 142, 143, 132, 133, 134, 135,
        136, 137, -1, 116, 268, 269, 117, 270, 271, 272,
        273, 274, 275, 276, 277, 113, 115, 114, 144, 278,
        279, 280, 281, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, 24, 30, 24, 30, 27, -1, 109, 105,
        99, 95, 1, 5, 7, 2, -1, -1, -1, -1,
        167, 188, -1, -1, 202, 203, -1, -1, -1, -1,
        -1, -1
    };
    private static final int z_pnaI[] = {
        147, 150, 156, 154, 152, 158, 145, 148, 155, 153,
        151, 157, 146, 149, -1
    };
    private int z_psI;
    private Vector z_pqVector;
    private boolean z_peaZ[];
    private Compiler _compiler;
    private net.rim.tools.compiler.types.ClassType _classType;
    private net.rim.tools.compiler.types.Method _method;
    private int z_pcI;
    private int z_pfI;
    private int z_prI;
    private net.rim.tools.compiler.classfile.InstructionTarget z_plx;
    private net.rim.tools.compiler.classfile.ai z_pkai;

    InstructionResolver()
    {
        z_pqVector = new Vector();
    }

    void init(Compiler compiler, net.rim.tools.compiler.types.ClassType __classType, net.rim.tools.compiler.types.Method __method, net.rim.tools.compiler.classfile.ai ai1, int i1)
    {
        _compiler = compiler;
        _classType = __classType;
        _method = __method;
        i1++;
        z_peaZ = new boolean[i1];
        z_peaZ[i1 - 1] = true;
        z_pcI = i1;
        z_pfI = 0;
        z_prI = 0;
        z_pkai = ai1;
    }

    void fini()
    {
        z_pqVector.setSize(0);
        z_peaZ = null;
        _compiler = null;
        _classType = null;
        _method = null;
        z_pkai = null;
    }

    public int getMaxStacksMap()
    {
        return _method.getMaxStacksMap();
    }

    public boolean _edvZ()
    {
        return z_prI > 0;
    }

    private void _bxIV(int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(i1 > 0 && i1 < z_pcI)
            z_pkai._intIZx(i1, true);
    }

    private net.rim.tools.compiler.classfile.InstructionTarget _bzIx(int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.classfile.InstructionTarget x1 = null;
        if(i1 >= 0 && i1 < z_pcI - 1)
            x1 = z_pkai._intIZx(i1, true);
        else
            x1 = z_pkai._bsIx(i1);
        return x1;
    }

    private net.rim.tools.compiler.types.Type _BStringa(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.classfile.TypeDescriptor _utf8_ = new net.rim.tools.compiler.classfile.TypeDescriptor(s);
        net.rim.tools.compiler.types.Type _type_ = net.rim.tools.compiler.types.Type.translateType(_compiler, _utf8_);
        if(_utf8_.get_OffsetToStringEnd() != 0)
            throw new CompileException(_classType.getFullName(), "Invalid type descriptor: " + _utf8_.getString());
        net.rim.tools.compiler.types.Type _type1_ = _type_;
        if(_type1_ instanceof net.rim.tools.compiler.types.ArrayType)
        {
            net.rim.tools.compiler.types.ArrayType _arrayType_ = (net.rim.tools.compiler.types.ArrayType)_type1_;
            _type1_ = _arrayType_.getMostBaseType();
        }
        if(_type1_ instanceof net.rim.tools.compiler.types.ClassType)
        {
            net.rim.tools.compiler.types.ClassType _classType_ = (net.rim.tools.compiler.types.ClassType)_type1_;
            _classType_._aCompilervV(_compiler, true);
            _classType_._elseCompilerV(_compiler);
            if(!_classType_.isProcessed())
            {
                _compiler.generateWarning(false, _classType.getFullName(), "Reference to undefined class: " + _classType_.getFullName());
                _classType.setAttribute(0x8000000);
                _method.addModifiers(0x8000000);
            }
        }
        return _type_;
    }

    private net.rim.tools.compiler.types.ClassType _DStringg(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = _compiler.parseClass(s);
        g1._aCompilervV(_compiler, true);
        g1._elseCompilerV(_compiler);
        if(!g1.isProcessed())
        {
            _compiler.generateWarning(false, _classType.getFullName(), "Reference to undefined class: " + g1.getFullName());
            _classType.setAttribute(0x8000000);
            _method.addModifiers(0x8000000);
        }
        return g1;
    }

    private net.rim.tools.compiler.types.Type _aeva(net.rim.tools.compiler.classfile.ConstantPoolClass e1, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        String s = e1.getName();
        Object obj = null;
        if(!flag && s.charAt(0) == '[')
        {
            obj = _BStringa(s);
        } else
        {
            net.rim.tools.compiler.types.ClassType g1 = _DStringg(s);
            if(g1.hasAttribute(0x20000))
                _classType._bUIV(8 + s.length());
            obj = g1;
        }
        e1.setType(((net.rim.tools.compiler.types.Type) (obj)));
        return ((net.rim.tools.compiler.types.Type) (obj));
    }

    private net.rim.tools.compiler.types.Field _ahvh(net.rim.tools.compiler.classfile.ConstantPoolFieldRef h1, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = h1.getClassType();
        if(g1 == null)
            g1 = (net.rim.tools.compiler.types.ClassType)_aeva(h1.getConstantPoolClass(), true);
        net.rim.tools.compiler.types.Type a1 = _BStringa(h1.getType());
        String s = h1.getName();
        net.rim.tools.compiler.types.Field h2 = g1._aCompilerSh(_compiler, s, a1, flag, true);
        if(h2 == null)
        {
            _method.addModifiers(0x8000000);
            int i1 = 0x8000080;
            i1 |= flag ? 2 : 4;
            byte byte0 = -1;
            if(s.startsWith("RIM_pragma"))
            {
                i1 |= 0x40;
                h2 = new net.rim.tools.compiler.types.Field(s, a1, g1, i1, byte0, new Constant(""));
            } else
            {
                h2 = new net.rim.tools.compiler.types.Field(s, a1, g1, i1, byte0, null);
                if(g1.isProcessed())
                    _compiler.generateWarning(false, g1.getFullName(), "No definition found for member: " + a1.getFullName() + ' ' + s);
            }
        } else
        if(!flag && h2.getOffset() >= 512)
            throw new net.rim.tools.compiler.util.CompileException(g1.getFullName(), "Field offset too large for: " + h2.getName());
        if(h2.is(0x20000))
            _classType._bUIV(6 + s.length());
        h1.setField(h2);
        return h2;
    }

    private net.rim.tools.compiler.types.Method _agSc(net.rim.tools.compiler.types.ClassType g1, String s, String s1, boolean flag, boolean flag1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.Method c1 = null;
        synchronized(z_pqVector)
        {
            z_pqVector.setSize(0);
            net.rim.tools.compiler.classfile.TypeDescriptor d1 = new net.rim.tools.compiler.classfile.TypeDescriptor(s1);
            net.rim.tools.compiler.types.Type.translateTypes(_compiler, d1, z_pqVector);
            net.rim.tools.compiler.types.Type a1 = net.rim.tools.compiler.types.Type.translateType(_compiler, d1);
            if(d1.get_OffsetToStringEnd() != 0)
                throw new CompileException(_classType.getFullName(), "Invalid type descriptor '" + d1.getString() + "' for method: " + s);
            c1 = g1._aCompilerSac(_compiler, s, a1, z_pqVector, flag1, true);
            if(c1 == null)
            {
                _method.addModifiers(0x8000000);
                int i1 = z_pqVector.size();
                c1 = new net.rim.tools.compiler.types.Method(g1, s, a1, i1, 0x8000080);
                for(int j1 = 0; j1 < i1; j1++)
                    c1.add_parametersToMethod(j1, null, (net.rim.tools.compiler.types.Type)z_pqVector.elementAt(j1));

                c1._fOvV();
                if(g1.isProcessed())
                    _compiler.generateWarning(false, g1.getFullName(), "No definition found for method: " + c1.getName());
            } else
            {
                net.rim.tools.compiler.types.ClassType g2 = c1.getClassType();
                if(flag && g2.hasAttribute(2048) && g1.hasAttribute(32) && g2 != g1)
                {
                    net.rim.tools.compiler.types.Method c2 = _compiler._agc(g1, c1);
                    g1._aCompilerV(_compiler, c2);
                    c2._ifCompilerV(_compiler, c1);
                    c1 = c2;
                }
                c1._cCompilerV(_compiler);
                String s2 = c1._fWvString();
                if(_compiler._tryStringZ(s2))
                    _compiler.generateWarning(true, _classType.get_className() + ':' + _method._fHvI(), "Invocation of questionable method: " + s2 + " found in: " + _method._fWvString());
                if(c1.is(0x20000))
                    c1._dCompilerV(_compiler);
            }
        }
        if(c1.is(0x20000))
            _classType._bUIV(6 + s.length());
        return c1;
    }

    private net.rim.tools.compiler.types.Method _arZc(net.rim.tools.compiler.classfile.ConstantPoolMethodRef r1, boolean flag, boolean flag1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = r1.getClassType();
        if(g1 == null)
            g1 = (net.rim.tools.compiler.types.ClassType)_aeva(r1.getConstantPoolClass(), true);
        net.rim.tools.compiler.types.Method c1 = _agSc(g1, r1.getName(), r1.getType(), flag, flag1);
        r1.setMethod(c1);
        return c1;
    }

    private net.rim.tools.compiler.types.Method _ayc(net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef y1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = y1.getClassType();
        if(g1 == null)
            g1 = (net.rim.tools.compiler.types.ClassType)_aeva(y1.getConstantPoolClass(), true);
        net.rim.tools.compiler.types.Method c1 = _agSc(g1, y1.getName(), y1.getType(), false, false);
        y1.setMethod(c1);
        return c1;
    }

    private int _ifhI(net.rim.tools.compiler.types.Field h1)
    {
        return h1.getSize() != 8 ? 0 : 2;
    }

    private int _forgI(net.rim.tools.compiler.types.ClassType g1)
    {
        return !g1.hasAttribute(0x20000) && g1.isProcessed() ? 0 : 1;
    }

    private int _agI(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.ClassType g2)
    {
        return _forgI(g1) == 0 && _forgI(g2) == 0 && g1 == g2 ? 0 : 1;
    }

    private int _intcI(net.rim.tools.compiler.types.Method c1)
    {
        return !c1.is(0x20000) ? 0 : 1;
    }

    private int _acI(net.rim.tools.compiler.types.Method c1, net.rim.tools.compiler.types.ClassType g1)
    {
        return _intcI(c1) == 0 && _agI(c1.getClassType(), g1) == 0 ? 0 : 1;
    }

    private int _byII(int i1)
    {
        return i1 <= 255 ? 0 : 1;
    }

    public void _nullIIV(int i1, int j1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_pfI != 0)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x1 = z_pkai._bvIx(j1);
            if(z_pfI == 1)
            {
                if(x1.getOffset() == j1)
                {
                    net.rim.tools.compiler.classfile.InstructionTarget x2 = z_pkai._bvIx(i1);
                    x2._doxV(null);
                } else
                {
                    x1 = x1._aIZx(j1, false, true);
                    z_pkai._dxV(x1);
                }
            } else
            {
                net.rim.tools.compiler.classfile.InstructionTarget x3 = z_pkai._bvIx(i1);
                if(x1 == x3)
                {
                    x1 = x1._aIZx(j1, true, true);
                    z_pkai._dxV(x1);
                } else
                {
                    x3._doxV(x1);
                }
            }
            z_pfI = 0;
        }
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolLong ab1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        z_plx = z_pkai._bvIx(i1);
        long l1 = ab1.getValue();
        if(ab1.isDouble())
            z_plx._charIIV(i1, 215);
        z_plx.addInstruction(i1, 39, l1);
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolInteger c1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        z_plx = z_pkai._bvIx(i1);
        int k1 = c1.getValue();
        if(c1.isFloat())
            z_plx._charIIV(i1, 215);
        z_plx._doIIV(i1, 38, k1);
    }

    public static boolean _CStringZ(String s)
    {
        int i1 = s.length();
        for(int j1 = 0; j1 < i1; j1++)
        {
            char c1 = s.charAt(j1);
            if((c1 & 0xff00) != 0)
                return true;
        }

        return false;
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolString a1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        z_plx = z_pkai._bvIx(i1);
        String s = a1.getString();
        if(_CStringZ(s))
        {
            z_plx.addInstruction(i1, 42, s);
            _classType._bUIV(s.length() * 2 + 4);
        } else
        {
            z_plx.addInstruction(i1, 40, s);
            _classType._bUIV(s.length() + 4);
        }
    }

    public void _ifIIaV(int i1, int j1, String as[])
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        z_plx = z_pkai._bvIx(i1);
        int k1 = 0;
        for(int l1 = as.length - 1; l1 >= 0; l1--)
        {
            String s = as[l1];
            k1 += 4;
            if(_CStringZ(s))
                k1 += 2 * s.length();
            else
                k1 += s.length();
        }

        z_plx._charIIV(i1, 216);
        z_plx.addInstructionStringArray(i1, 282, as);
        _classType._bUIV(k1);
    }

    public void _aIIeV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolClass e1, int k1, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        if(flag && _compiler.isPreverified())
        {
            z_psI++;
            int l1 = z_pkai._d3vI() - 1;
            for(int i2 = 0; i2 < l1; i2++)
            {
                net.rim.tools.compiler.classfile.InstructionTarget x1 = z_pkai._bkIx(i2);
                net.rim.tools.compiler.analysis.InstructionStackEntry d1 = x1.getStackEntry();
                if(d1 != null)
                    d1._byteIIV(i1, z_psI);
            }

        }
        net.rim.tools.compiler.types.Type a1 = e1.getType();
        if(a1 == null)
            a1 = _aeva(e1, flag);
        z_plx = z_pkai._bvIx(i1);
        Object obj = null;
        Object obj1 = null;
        switch(j1)
        {
        case 188:
        case 190:
        case 191:
        case 194:
        case 195:
        case 196:
        default:
            break;

        case 189:
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx.addInstruction(i1, 168 + _forgI(g1), g1.getArrayType());
                break;
            }
				if(!(a1 instanceof net.rim.tools.compiler.types.ArrayType))
                break;
				net.rim.tools.compiler.types.ArrayType l2 = a1.getArrayType();
            a1 = l2.getMostBaseType();
				if(a1 instanceof net.rim.tools.compiler.types.BaseType)
            {
                z_plx._aIIaV(i1, 166, l2, 1);
                break;
            }
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx._aIIaV(i1, 170 + _forgI(g2), l2, 1);
            }
            break;

        case 192:
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx.addInstruction(i1, 193 + _forgI(g3), g3);
                break;
            }
				if(!(a1 instanceof net.rim.tools.compiler.types.ArrayType))
                break;
				net.rim.tools.compiler.types.ArrayType l3 = (net.rim.tools.compiler.types.ArrayType)a1;
            a1 = l3.getMostBaseType();
				if(a1 instanceof net.rim.tools.compiler.types.BaseType)
            {
                z_plx.addInstruction(i1, 190, l3);
                break;
            }
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g4 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx.addInstruction(i1, 200 + _forgI(g4), l3);
            }
            break;

        case 193:
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g5 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx.addInstruction(i1, 191 + _forgI(g5), g5);
                break;
            }
				if(!(a1 instanceof net.rim.tools.compiler.types.ArrayType))
                break;
				net.rim.tools.compiler.types.ArrayType l4 = (net.rim.tools.compiler.types.ArrayType)a1;
            a1 = l4.getMostBaseType();
				if(a1 instanceof net.rim.tools.compiler.types.BaseType)
            {
                z_plx.addInstruction(i1, 189, l4);
                break;
            }
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g6 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx.addInstruction(i1, 198 + _forgI(g6), l4);
            }
            break;

        case 197:
				net.rim.tools.compiler.types.ArrayType l5 = (net.rim.tools.compiler.types.ArrayType)a1;
            a1 = l5.getMostBaseType();
				if(a1 instanceof net.rim.tools.compiler.types.BaseType)
            {
                z_plx._aIIaV(i1, 166, l5, k1);
                break;
            }
				if(a1 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g7 = (net.rim.tools.compiler.types.ClassType)a1;
                z_plx._aIIaV(i1, 170 + _forgI(g7), l5, k1);
            }
            break;

        case 187:
				net.rim.tools.compiler.types.ClassType g8 = (net.rim.tools.compiler.types.ClassType)a1;
            z_plx._aIIaV(i1, 184 + _forgI(g8), g8, z_psI);
            break;
        }
    }

    private boolean _dohZ(net.rim.tools.compiler.types.Field h1)
    {
        if(h1.getClassType() != _classType)
            return false;
        if(!h1.is(64) || !h1._f1vZ())
            return false;
        if(z_plx._dhvI() == 0)
            return false;
        net.rim.tools.compiler.types.Type a1 = h1.getType();
        if(a1 instanceof net.rim.tools.compiler.types.BaseType)
        {
            long l1 = 0L;
            int i1 = h1.getSize();
            net.rim.tools.compiler.analysis.Instruction g2 = z_plx.getLastInstruction();
            switch(g2.getOpcode())
            {
            case 35: // '#'
                if(i1 == 8)
                    return false;
                l1 = 0L;
                break;

            case 44: // ','
                if(i1 == 8)
                    return false;
                l1 = 1L;
                break;

            case 36: // '$'
            case 37: // '%'
            case 38: // '&'
                if(i1 == 8)
                    return false;
                l1 = g2.getOp();
                break;

            case 39: // '\''
                if(i1 != 8)
                    return false;
					l1 = ((net.rim.tools.compiler.analysis.InstructionLong)g2).getOp2();
                break;

            case 40: // '('
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            default:
                return false;
            }
            return l1 == h1._f5vJ();
        }
        if(a1 == _compiler.getStringClass())
        {
            net.rim.tools.compiler.analysis.Instruction g1 = z_plx.getLastInstruction();
            switch(g1.getOpcode())
            {
            case 40: // '('
            case 42: // '*'
                return ((InstructionString)g1).getString().equals(h1._f2vString());
            }
        }
        return false;
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolFieldRef h1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        boolean flag = j1 == 178 || j1 == 179;
        net.rim.tools.compiler.types.Field h2 = h1.getField();
        if(h2 == null)
            h2 = _ahvh(h1, flag);
        net.rim.tools.compiler.types.ClassType g1 = h1.getClassType();
        z_plx = z_pkai._bvIx(i1);
        boolean flag1 = h2.is(0x8000000);
        if(h2.is(512) && g1 != _classType)
            _compiler._charIV(2048);
        switch(j1)
        {
        case 180:
        case 181:
            z_plx._aIIgV(i1, z_pgaI[j1] + _ifhI(h2), g1, h2, flag1);
            h2._iZV(j1 == 180);
            break;

        case 179:
            if(_method.is(0x100000) && _dohZ(h2))
            {
                if(h2.getSize() == 8)
                    z_plx._charIIV(i1, 206);
                else
                    z_plx._charIIV(i1, 205);
                break;
            }
            // fall through

        case 178:
            if(h2._f1vZ() && h2.isAnd(0x20000c2))
            {
                net.rim.tools.compiler.types.Type a1 = h2.getType();
                if(a1 instanceof net.rim.tools.compiler.types.BaseType)
                {
                    int k1 = a1.getTypeId();
                    if(k1 == 11 || k1 == 12)
                        z_plx._charIIV(i1, 215);
                    if(h2.getSize() == 8)
                        z_plx.addInstruction(i1, 39, h2._f5vJ());
                    else
                        z_plx._doIIV(i1, 38, (int)h2._f5vJ());
                } else
                {
                    String s = h2._f2vString();
                    z_plx.addInstruction(i1, 40, s);
                    _classType._bUIV(s.length() + 4);
                }
            } else
            {
                z_plx._aIIgV(i1, z_pgaI[j1] + _ifhI(h2) + _agI(g1, h2.getClassType()), g1, h2, flag1);
                h2._iZV(j1 == 178);
                h2._f3vV();
            }
            break;

        default:
				throw new net.rim.tools.compiler.util.CompileException(_classType.getFullName(), "Invalid opcode at offset: " + i1);
        }
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolMethodRef r1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        net.rim.tools.compiler.types.Method c1 = r1.getMethod();
        if(c1 == null)
            c1 = _arZc(r1, j1 == 182, j1 == 184);
        net.rim.tools.compiler.types.ClassType g1 = r1.getClassType();
        z_plx = z_pkai._bvIx(i1);
        boolean flag = c1.is(0x8000000);
        if(c1.is(512) && g1 != _classType)
            _compiler._charIV(2048);
        switch(j1)
        {
        case 182:
            z_plx._aIIgV(i1, z_pgaI[j1], g1, c1, flag);
            break;

        case 184:
            z_plx._aIIgV(i1, z_pgaI[j1] + _acI(c1, g1), g1, c1, flag);
            break;

        case 183:
            z_plx._aIIgV(i1, z_pgaI[j1] + _intcI(c1), g1, c1, flag);
            break;

        default:
				throw new net.rim.tools.compiler.util.CompileException(_classType.getFullName(), "Invalid opcode at offset: " + i1);
        }
    }

    public void _aIIyV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef y1, int k1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        net.rim.tools.compiler.types.Method c1 = y1.getMethod();
        if(c1 == null)
            c1 = _ayc(y1);
        net.rim.tools.compiler.types.ClassType g1 = y1.getClassType();
        z_plx = z_pkai._bvIx(i1);
        boolean flag = c1.is(0x8000000);
        if(c1.is(0x20000) && c1.getClassType() == _compiler.getObjectClass())
        {
            j1 = 182;
            g1 = c1.getClassType();
        }
        switch(j1)
        {
        case 182:
            z_plx._aIIgV(i1, z_pgaI[j1], g1, c1, flag);
            break;

        case 185:
            z_plx._aIIgV(i1, z_pgaI[j1], g1, c1, k1, flag);
            break;

        default:
				throw new net.rim.tools.compiler.util.CompileException(_classType.getFullName(), "Invalid opcode at offset: " + i1);
        }
    }

    public void _ifIIaV(int i1, int j1, int ai1[])
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        z_plx = z_pkai._bvIx(i1);
        boolean flag = false;
        int l3 = -1;
        if(j1 < z_pgaI.length)
            l3 = z_pgaI[j1];
        if(l3 != -1)
        {
            if(l3 > 255)
                z_plx._charIIV(i1, 216);
            if(j1 == 175 || j1 == 174)
                z_plx._charIIV(i1, 215);
            switch(j1)
            {
            case 89: // 'Y'
                int i4 = z_plx._dhvI();
                if(i4 > 0)
                {
                    net.rim.tools.compiler.analysis.Instruction g1 = z_plx.getInstruction(i4 - 1);
                    if(g1.getOpcode() == 63)
                        l3 = 63;
                }
                z_plx._charIIV(i1, l3);
                break;

            case 87: // 'W'
                z_plx._charIIV(i1, l3);
                if(z_plx._baIZ(5))
                    z_pfI = 2;
                break;

            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 191:
                z_plx._charIIV(i1, l3);
                z_pkai._intIZx(i1 + 1, false);
                z_plx._biIV(4);
                z_plx._doxV(null);
                break;

            default:
                z_plx._charIIV(i1, l3);
                break;
            }
        } else
        {
            switch(j1)
            {
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
                z_plx._doIIV(i1, 36, j1 - 3);
                break;

            case 16: // '\020'
                z_plx._doIIV(i1, 36, ai1[0]);
                break;

            case 17: // '\021'
                z_plx._doIIV(i1, 37, ai1[0]);
                break;

            case 18: // '\022'
            case 19: // '\023'
                z_plx._doIIV(i1, 38, ai1[0]);
                break;

            case 9: // '\t'
            case 10: // '\n'
                z_plx.addInstruction(i1, 39, j1 - 9);
                break;

            case 11: // '\013'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, 36);
                break;

            case 12: // '\f'
            case 13: // '\r'
                z_plx._charIIV(i1, 215);
                z_plx._doIIV(i1, 38, (127 + j1) - 12 << 23);
                break;

            case 14: // '\016'
                z_plx._charIIV(i1, 215);
                z_plx.addInstruction(i1, 39, 0L);
                break;

            case 15: // '\017'
                z_plx._charIIV(i1, 215);
                z_plx.addInstruction(i1, 39, 0x3ff0000000000000L);
                break;

            case 25: // '\031'
                int k1 = ai1[0];
                if(k1 <= 7)
                    z_plx._charIIV(i1, 63 + k1);
                else
                    z_plx._doIIV(i1, 51 + _byII(k1), k1);
                break;

            case 42: // '*'
            case 43: // '+'
            case 44: // ','
            case 45: // '-'
                z_plx._charIIV(i1, (63 + j1) - 42);
                break;

            case 23: // '\027'
                z_plx._charIIV(i1, 215);
                // fall through

            case 21: // '\025'
                int l1 = ai1[0];
                if(l1 <= 7)
                    z_plx._charIIV(i1, 55 + l1);
                else
                    z_plx._doIIV(i1, 49 + _byII(l1), l1);
                break;

            case 34: // '"'
            case 35: // '#'
            case 36: // '$'
            case 37: // '%'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, (55 + j1) - 34);
                break;

            case 26: // '\032'
            case 27: // '\033'
            case 28: // '\034'
            case 29: // '\035'
                z_plx._charIIV(i1, (55 + j1) - 26);
                break;

            case 24: // '\030'
                z_plx._charIIV(i1, 215);
                // fall through

            case 22: // '\026'
                int i2 = ai1[0];
                z_plx._doIIV(i1, 53 + _byII(i2), i2);
                break;

            case 38: // '&'
            case 39: // '\''
            case 40: // '('
            case 41: // ')'
                z_plx._charIIV(i1, 215);
                z_plx._doIIV(i1, 53, j1 - 38);
                break;

            case 30: // '\036'
            case 31: // '\037'
            case 32: // ' '
            case 33: // '!'
                z_plx._doIIV(i1, 53, j1 - 30);
                break;

            case 58: // ':'
                int j2 = ai1[0];
                if(j2 <= 7)
                    z_plx._charIIV(i1, 85 + j2);
                else
                    z_plx._doIIV(i1, 73 + _byII(j2), j2);
                if(z_plx._baIZ(5))
                    z_pfI = 2;
                break;

            case 75: // 'K'
            case 76: // 'L'
            case 77: // 'M'
            case 78: // 'N'
                z_plx._charIIV(i1, (85 + j1) - 75);
                if(z_plx._baIZ(5))
                    z_pfI = 2;
                break;

            case 56: // '8'
                z_plx._charIIV(i1, 215);
                // fall through

            case 54: // '6'
                int k2 = ai1[0];
                if(k2 <= 7)
                    z_plx._charIIV(i1, 77 + k2);
                else
                    z_plx._doIIV(i1, 71 + _byII(k2), k2);
                break;

            case 67: // 'C'
            case 68: // 'D'
            case 69: // 'E'
            case 70: // 'F'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, (77 + j1) - 67);
                break;

            case 59: // ';'
            case 60: // '<'
            case 61: // '='
            case 62: // '>'
                z_plx._charIIV(i1, (77 + j1) - 59);
                break;

            case 57: // '9'
                z_plx._charIIV(i1, 215);
                // fall through

            case 55: // '7'
                int l2 = ai1[0];
                z_plx._doIIV(i1, 75 + _byII(l2), l2);
                break;

            case 71: // 'G'
            case 72: // 'H'
            case 73: // 'I'
            case 74: // 'J'
                z_plx._charIIV(i1, 215);
                z_plx._doIIV(i1, 75, j1 - 71);
                break;

            case 49: // '1'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, 177);
                break;

            case 82: // 'R'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, 183);
                break;

            case 48: // '0'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, 175);
                break;

            case 81: // 'Q'
                z_plx._charIIV(i1, 215);
                z_plx._charIIV(i1, 181);
                break;

            case 63: // '?'
            case 64: // '@'
            case 65: // 'A'
            case 66: // 'B'
                z_plx._doIIV(i1, 75, j1 - 63);
                break;

            case 167:
            case 200:
					net.rim.tools.compiler.classfile.InstructionTarget x1 = _bzIx(ai1[0]);
                z_plx = z_pkai._intIZx(i1, true);
                z_plx._biIV(6);
                z_pfI = 1;
                z_plx.addInstructionBranch(i1, 161);
                z_plx._newxV(x1);
                break;

            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158:
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166:
					net.rim.tools.compiler.classfile.InstructionTarget x2 = _bzIx(ai1[0]);
                z_pfI = 2;
                if(!z_plx.checkOffset(i1))
                    z_plx = x2;
                z_plx.addInstructionBranch(i1, z_pnaI[j1 - 153]);
                z_plx._newxV(x2);
                break;

            case 198:
            case 199:
					net.rim.tools.compiler.classfile.InstructionTarget x3 = _bzIx(ai1[0]);
                z_pfI = 2;
                if(!z_plx.checkOffset(i1))
                    z_plx = x3;
                z_plx.addInstructionBranch(i1, (159 + j1) - 198);
                z_plx._newxV(x3);
                break;

            case 171:
                int j4 = ai1[1];
                int ai2[] = new int[j4];
                boolean flag1 = true;
                for(int i5 = 0; i5 < j4; i5++)
                {
                    int i3 = ai1[i5 * 2 + 2];
                    if(i3 != (short)i3)
                        flag1 = false;
                    ai2[i5] = i3;
                }

                z_pfI = 1;
                _bxIV(ai1[0]);
                for(int k5 = 3; k5 < ai1.length; k5 += 2)
                    _bxIV(ai1[k5]);

                if(!z_plx.checkOffset(i1))
                    z_plx = z_pkai._bvIx(i1);
                boolean flag3 = j4 < 0 || j4 > 4096;
                if(flag3)
                    _compiler.generateWarning(false, _classType.getFullName(), "Malformed lookupswitch opcode found in: " + _method.getName());
                z_plx._aIIaIV(i1, flag1 ? 163 : 164, ai2, flag3);
                z_plx._newxV(_bzIx(ai1[0]));
                for(int i6 = 3; i6 < ai1.length; i6 += 2)
                    z_plx._newxV(_bzIx(ai1[i6]));

                break;

            case 170:
                int k4 = ai1.length - 3;
                int ai3[] = new int[k4];
                boolean flag2 = true;
                int j3 = ai1[1];
                for(int j5 = 0; j5 < k4; j5++)
                {
                    if(j3 != (short)j3)
                        flag2 = false;
                    ai3[j5] = j3++;
                }

                z_pfI = 1;
                _bxIV(ai1[0]);
                for(int l5 = 3; l5 < ai1.length; l5++)
                    _bxIV(ai1[l5]);

                if(!z_plx.checkOffset(i1))
                    z_plx = z_pkai._bvIx(i1);
                boolean flag4 = ai1[1] > ai1[2];
                if(flag4)
                    _compiler.generateWarning(false, _classType.getFullName(), "Malformed tableswitch opcode found in: " + _method.getName());
                z_plx._aIIaIV(i1, flag2 ? 163 : 164, ai3, flag4);
                z_plx._newxV(_bzIx(ai1[0]));
                for(int j6 = 3; j6 < ai1.length; j6++)
                    z_plx._newxV(_bzIx(ai1[j6]));

                break;

            case 177:
                if(_method.is(0x100000))
                    z_plx._charIIV(i1, 32);
                else
                    z_plx._charIIV(i1, 31);
                z_pkai._intIZx(i1 + 1, false);
                z_plx._biIV(4);
                z_plx._doxV(null);
                break;

            case 188:
                z_plx._doIIV(i1, 165, ai1[0]);
                break;

            case 132:
                int k3 = ai1[1];
                int l4 = ai1[0];
                if(k3 < 128 && k3 >= -128 && l4 <= 255)
                    z_plx.addInstructionLong(i1, 120, l4, k3);
                else
                    z_plx.addInstructionLong(i1, 121, l4, k3);
                break;

            case 168:
            case 201:
                z_plx = z_pkai._intIZx(i1, true);
                z_pfI = 2;
					net.rim.tools.compiler.classfile.InstructionTarget x4 = _bzIx(ai1[0]);
                x4._biIV(5);
                z_plx._newxV(x4);
                z_plx._biIV(1);
                z_prI++;
                break;

            case 169:
                z_plx = z_pkai._intIZx(i1, true);
                z_pkai._intIZx(i1 + 2, false);
                z_plx._biIV(3);
                z_plx._doxV(null);
                break;

            case 20: // '\024'
            case 46: // '.'
            case 47: // '/'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
            case 53: // '5'
            case 79: // 'O'
            case 80: // 'P'
            case 83: // 'S'
            case 84: // 'T'
            case 85: // 'U'
            case 86: // 'V'
            case 87: // 'W'
            case 88: // 'X'
            case 89: // 'Y'
            case 90: // 'Z'
            case 91: // '['
            case 92: // '\\'
            case 93: // ']'
            case 94: // '^'
            case 95: // '_'
            case 96: // '`'
            case 97: // 'a'
            case 98: // 'b'
            case 99: // 'c'
            case 100: // 'd'
            case 101: // 'e'
            case 102: // 'f'
            case 103: // 'g'
            case 104: // 'h'
            case 105: // 'i'
            case 106: // 'j'
            case 107: // 'k'
            case 108: // 'l'
            case 109: // 'm'
            case 110: // 'n'
            case 111: // 'o'
            case 112: // 'p'
            case 113: // 'q'
            case 114: // 'r'
            case 115: // 's'
            case 116: // 't'
            case 117: // 'u'
            case 118: // 'v'
            case 119: // 'w'
            case 120: // 'x'
            case 121: // 'y'
            case 122: // 'z'
            case 123: // '{'
            case 124: // '|'
            case 125: // '}'
            case 126: // '~'
            case 127: // '\177'
            case 128:
            case 129:
            case 130:
            case 131:
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
            case 183:
            case 184:
            case 185:
            case 186:
            case 187:
            case 189:
            case 190:
            case 191:
            case 192:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            default:
					throw new net.rim.tools.compiler.util.CompileException(_classType.getFullName(), "Invalid opcode at offset: " + i1);
            }
        }
    }

    public void _aIIV(int i1, int j1, net.rim.tools.compiler.classfile.ConstantPoolArrayData l1)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_peaZ[i1] = true;
        byte abyte0[] = l1.getBytes();
        net.rim.tools.compiler.classfile.ConstantPoolFieldRef h1 = l1.getFieldRef();
        if(h1 != null)
            _compiler.checkBinaryForExport(h1.getClassName() + '.' + h1.getName(), abyte0);
        z_plx = z_pkai._bvIx(i1);
        int k1 = l1.getArrayType();
        z_plx.addInstructionBytes(i1, 45, k1, abyte0);
        _classType._bUIV(abyte0.length + 4);
    }

    private void _intxV(net.rim.tools.compiler.classfile.InstructionTarget x1, net.rim.tools.compiler.classfile.InstructionTarget x2)
    {
        int i1 = z_pkai._d3vI();
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x3 = z_pkai._bkIx(j1);
            int l1 = x3._dsvI();
            for(int j2 = 0; j2 < l1; j2++)
            {
                net.rim.tools.compiler.classfile.InstructionTarget x4 = x3._a5Ix(j2);
                if(x4 == x1)
                    x3._ifxvV(x2, j2);
            }

        }

        i1 = z_pkai._dVvI();
        for(int k1 = 0; k1 < i1; k1++)
        {
            net.rim.tools.compiler.classfile.ad ad1 = z_pkai._bpIad(k1);
            if(ad1._dNvx() == x1)
                ad1._longxV(x2);
            if(ad1._dKvx() == x1)
                ad1._elsexV(x2);
            if(ad1._dMvx() == x1)
                ad1._gotoxV(x2);
        }

        i1 = z_pkai._dPvI();
        for(int i2 = 0; i2 < i1; i2++)
        {
            net.rim.tools.compiler.classfile.al al1 = z_pkai._buIal(i2);
            if(al1._d8vx() == x1)
                al1._fxV(x2);
            if(al1._d9vx() == x1)
                al1._exV(x2);
        }

    }

    public void _ecvV()
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = z_pkai._d3vI();
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x1 = z_pkai._bkIx(j1);
            net.rim.tools.compiler.analysis.InstructionStackEntry d1 = x1.getStackEntry();
            int k1 = x1.getOffset();
            if(!z_peaZ[k1] || x1._baIZ(9) && (d1 != null || x1._c9vZ()))
            {
                net.rim.tools.compiler.classfile.InstructionTarget x2 = null;
                if(k1 > 0 && k1 < z_pcI - 1 && (z_peaZ[k1 - 1] || z_peaZ[k1 + 1]))
                {
                    k1 = z_pcI;
                    x2 = z_pkai._bsIx(k1);
                } else
                {
                    x2 = z_pkai._bsIx(k1);
                    x2._doxV(x1);
                }
                x1.setStackEntry(null);
                x2.setStackEntry(d1);
                _intxV(x1, x2);
            } else
            if(d1 != null)
            {
                d1.verifyUninitializedOffsets();
                if(_compiler.isPreverified() && j1 > 0 && (x1._dmvZ() || !x1._c9vZ()))
                {
                    if(Compiler._verboseLevel >= 2)
                        net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Funny Stackmap in: " + _method._fWvString());
                    _method.addModifiers(0x8000000);
                }
            } else
            if(!x1._dBvZ() && !x1._baIZ(9) && _compiler.isPreverified())
            {
                if(x1._c9vZ())
                    throw new net.rim.tools.compiler.util.CompileException(_classType.getFullName(), "Missing stack map at label: " + x1.getOffset());
                if(Compiler._verboseLevel >= 2)
                    net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println("Missing Stackmap in: " + _method._fWvString());
                _method.addModifiers(0x8000000);
            }
        }

    }

}
