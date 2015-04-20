// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.classfile.ai;
import net.rim.tools.compiler.classfile.u;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.Field;
import net.rim.tools.compiler.types.NameAndType;

// Referenced classes of package net.rim.tools.compiler.g:
//            e, p, i, n,
//            g, m, o, f,
//            h, q

public final class b extends net.rim.tools.compiler.analysis.InstructionWalker
implements net.rim.tools.compiler.classfile.u
{

    private static final boolean z_pIZ = false;
    private static final int z_pSI = -1;
    private final p z_pRp = new p();
    private ClassType z_pLg;
    private Method z_pNc;
    private ai z_pOai;
    private InstructionTarget z_pMx;
    private int f_flag;
    private int z_pQI;
    private int z_pHI;
    private int z_pKI;
    private int z_pJI;

    public b()
    {
    }

    public void _aCompilercV(Compiler compiler, net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.Method c1, net.rim.tools.compiler.classfile.ai ai1)
    {
        f_flag = compiler.getOptimization();
        if(c1.is(0x100000))
            f_flag |= 0x400;
        z_pLg = g1;
        z_pNc = c1;
        z_pOai = ai1;
    }

    private net.rim.tools.compiler.analysis.Instruction _intxvg(net.rim.tools.compiler.classfile.InstructionTarget x1, int j)
	throws net.rim.tools.compiler.analysis.p
    {
        if(j >= 0 && j < x1._dhvI())
        {
            net.rim.tools.compiler.analysis.Instruction g1 = x1.getInstruction(j);
            if(g1 != null)
                return g1;
        }
        throw z_pRp;
    }

    private net.rim.tools.compiler.analysis.Instruction _bBIg(int j)
    {
        if(z_pQI + j < z_pMx._dhvI())
            return z_pMx.getInstruction(z_pQI + j);
        else
            return null;
    }

    private net.rim.tools.compiler.analysis.Instruction _bCIg(int j)
    {
        if(z_pQI - j >= 0)
            return z_pMx.getInstruction(z_pQI - j);
        else
            return null;
    }

    private boolean _bIIZ(int j, int l)
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _bCIg(j);
        return g1 != null && g1.getOpcode() == l;
    }

    private int _bDII(int j)
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _bCIg(j);
        if(g1 != null)
            return g1._eOvI();
        else
            return 0;
    }

    public void walkInstruction(InstructionTarget x1)
        throws CompileException
    {
        z_pMx = x1;
    }

    public void walkInstruction(int j, net.rim.tools.compiler.analysis.Instruction g1)
        throws CompileException
    {
        z_pQI = j;
    }

    public void _axvV(InstructionTarget x1, boolean flag)
        throws CompileException
    {
        if(flag && x1._dpvZ())
        {
            int j = x1._dhvI();
            for(int l = 0; l < j; l++)
                if(x1.getInstruction(l) == null)
                {
                    x1._a3IV(l);
                    l--;
                    j--;
                }

        }
    }

    private int _fZI(boolean flag)
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        return _agvI(g1, flag);
    }

    private int _agvI(net.rim.tools.compiler.analysis.Instruction g1, boolean flag)
        throws p
    {
        int j = g1.getOpcode();
        switch(j)
        {
        case 35: // '#'
            return 0;

        case 44: // ','
            return 1;

        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            return g1.getOp();

        case 40: // '('
        case 42: // '*'
            if(flag)
                return -1;
            // fall through

        case 39: // '\''
        case 41: // ')'
        case 43: // '+'
        default:
            throw z_pRp;
        }
    }

    private long _etvJ()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 39: // '\''
            return ((InstructionLong)g1).getOp2();
        }
        throw z_pRp;
    }

    private int _voidIII(int j, int l)
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, j);
        int i1 = g1.getOpcode();
        byte byte0 = -1;
        switch(i1)
        {
        case 50: // '2'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        default:
            break;

        case 63: // '?'
        case 64: // '@'
        case 65: // 'A'
        case 66: // 'B'
        case 67: // 'C'
        case 68: // 'D'
        case 69: // 'E'
        case 70: // 'F'
            int j1 = i1 - 63;
            if(l == -1 || l == j1)
                return j1;
            break;

        case 55: // '7'
        case 56: // '8'
        case 57: // '9'
        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
            int k1 = i1 - 55;
            if(l == -1 || l == k1)
                return k1;
            break;

        case 49: // '1'
        case 51: // '3'
            int l1 = g1.getOp();
            if(l == -1 || l == l1)
                return l1;
            break;
        }
        throw z_pRp;
    }

    private void _euvV()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 103: // 'g'
            return;
        }
        throw z_pRp;
    }

    private void _elvV()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 95: // '_'
            return;
        }
        throw z_pRp;
    }

    private Method _bHIc(int j)
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int l = g1.getOpcode();
        if((l == j || l == j + 1) && (g1 instanceof InstructionNameAndType))
        {
            InstructionNameAndType n1 = (InstructionNameAndType)g1;
            return (Method)n1.getNameAndType();
        } else
        {
            throw z_pRp;
        }
    }

    private Method _trygc(net.rim.tools.compiler.analysis.Instruction g1)
    {
        int j = g1.getOpcode();
        switch(j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 219:
        case 220:
            if(g1 instanceof InstructionNameAndType)
            {
                InstructionNameAndType n1 = (InstructionNameAndType)g1;
                return (Method)n1.getNameAndType();
            }
            break;
        }
        return null;
    }

    private void _esvV()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 24: // '\030'
        case 27: // '\033'
        case 30: // '\036'
        case 31: // '\037'
            return;

        case 25: // '\031'
        case 26: // '\032'
        case 28: // '\034'
        case 29: // '\035'
        default:
            throw z_pRp;
        }
    }

    private void _ekvV()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 24: // '\030'
        case 27: // '\033'
            return;
        }
        throw z_pRp;
    }

    private void _envV()
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, ++z_pHI);
        int j = g1.getOpcode();
        switch(j)
        {
        case 31: // '\037'
            return;
        }
        throw z_pRp;
    }

    private void _epvV()
        throws p
    {
        if(z_pMx._dhvI() == ++z_pHI)
            return;
        else
            throw z_pRp;
    }

    private boolean _ervZ()
    {
        if(z_pQI != 0)
            return false;
        if(z_pOai._d3vI() != 2)
            return false;
        return !z_pNc.is(0x208000);
    }

    private boolean _emvZ()
    {
        if(!_ervZ())
            return false;
        z_pHI = z_pQI;
        try
        {
            _envV();
            z_pKI = z_pHI;
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }

    private boolean _newIZZ(int j, boolean flag)
    {
        if(!_ervZ())
            return false;
        if(z_pNc._fLvZ() != flag)
            return false;
        if(z_pNc.is(2))
        {
            if(z_pNc.getNumParameters() != j)
                return false;
            if(z_pNc.getParameterType(0) != z_pNc.getClassType())
                return false;
        } else
        {
            j--;
            if(z_pNc.getNumParameters() != j)
                return false;
        }
        return true;
    }

    private boolean _eovZ()
    {
        if(!_newIZZ(1, true))
            return false;
        z_pHI = z_pQI;
        try
        {
            z_pJI = _fZI(false);
            z_pKI = z_pHI;
            _ekvV();
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }

    private boolean _eqvZ()
    {
        if(!_newIZZ(1, true))
            return false;
        z_pHI = z_pQI;
        try
        {
            _euvV();
            z_pKI = z_pHI;
            _ekvV();
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }

    private boolean _evvZ()
    {
        if(!_newIZZ(2, false))
            return false;
        z_pHI = z_pQI;
        try
        {
            _voidIII(++z_pHI, 0);
            _voidIII(++z_pHI, 1);
            _elvV();
            z_pKI = z_pHI;
            _envV();
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }

    private boolean _ewvZ()
    {
        if(!_ervZ())
            return false;
        z_pHI = z_pQI;
        try
        {
            int j = z_pNc.getNumParameters();
            if(z_pNc._fKvZ())
                j++;
            int l;
            for(l = 0; l < j;)
                _voidIII(++z_pHI, l++);

            if(l != j)
                return false;
            Method c1 = _bHIc(5);
            z_pKI = z_pHI;
            if(c1.getNumParameters() != z_pNc.getNumParameters())
                return false;
            _esvV();
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }

    private boolean _bFIZ(int j)
        throws p
    {
        boolean flag = false;
        int i1 = 0;
        while(i1 < j)
        {
            net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, z_pHI++);
            int j1 = g1.getOpcode();
            byte byte0 = 1;
            int l;
            switch(j1)
            {
            case 63: // '?'
            case 64: // '@'
            case 65: // 'A'
            case 66: // 'B'
            case 67: // 'C'
            case 68: // 'D'
            case 69: // 'E'
            case 70: // 'F'
                l = j1 - 63;
                break;

            case 215:
                continue;

            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
            case 58: // ':'
            case 59: // ';'
            case 60: // '<'
            case 61: // '='
            case 62: // '>'
                l = j1 - 55;
                break;

            case 49: // '1'
            case 50: // '2'
            case 51: // '3'
            case 52: // '4'
                l = g1.getOp();
                break;

            case 53: // '5'
            case 54: // '6'
                l = g1.getOp();
                byte0 = 2;
                break;

            default:
                return false;
            }
            if(l != i1)
                return false;
            i1 += byte0;
        }
        return true;
    }

    private boolean _bIIZ(int j)
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, z_pHI);
        int l = g1.getOpcode();
        if(l == j)
        {
            z_pHI++;
            return true;
        } else
        {
            return false;
        }
    }

    private net.rim.tools.compiler.analysis.Instruction _bGIg(int j)
        throws p
    {
        net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, z_pHI);
        int l = g1.getOpcode();
        if(l == j)
        {
            z_pHI++;
            return g1;
        } else
        {
            throw z_pRp;
        }
    }

    private Method _newgc(net.rim.tools.compiler.analysis.Instruction g1)
        throws p
    {
        if(g1 instanceof InstructionNameAndType)
        {
            InstructionNameAndType n1 = (InstructionNameAndType)g1;
            return (Method)n1.getNameAndType();
        } else
        {
            throw z_pRp;
        }
    }

    private NameAndType _intgk(net.rim.tools.compiler.analysis.Instruction g1)
        throws p
    {
        if(g1 instanceof InstructionNameAndType)
        {
            InstructionNameAndType n1 = (InstructionNameAndType)g1;
            return n1.getNameAndType();
        } else
        {
            throw z_pRp;
        }
    }

    public boolean _afZ(InstructionCode f1)
    {
        if((f_flag & 0x800) == 0)
            return false;
        if(z_pOai._dVvI() != 0)
            return false;
        z_pMx = z_pOai._bkIx(0);
        z_pQI = 0;
        if(!_ervZ())
            return false;
        z_pHI = z_pQI;
        try
        {
            int l = z_pNc._fIvI();
            if(!_bIIZ(14))
                return false;
            if(!_bFIZ(l))
                return false;
            z_pKI = z_pHI;
            net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, z_pHI);
            int j = g1.getOpcode();
            int i1 = 0;
            Object obj = null;
            z_pHI++;
            switch(j)
            {
            case 207:
                g1 = _bGIg(105);
                i1 = 1;
                break;

            case 208:
                g1 = _bGIg(107);
                i1 = 2;
                break;

            case 209:
                g1 = _bGIg(95);
                i1 = 1;
                break;

            case 211:
                g1 = _bGIg(97);
                i1 = 2;
                break;

            case 109: // 'm'
                i1 = 1;
                break;

            case 111: // 'o'
                i1 = 2;
                break;

            case 99: // 'c'
            case 100: // 'd'
                i1 = 1;
                break;

            case 101: // 'e'
            case 102: // 'f'
                i1 = 2;
                break;

            case 5: // '\005'
            case 7: // '\007'
                Method c1 = _newgc(g1);
                obj = c1;
                if(c1._fIvI() != l)
                    return false;
                i1 = c1._fUvI();
                break;

            default:
                return false;
            }
            obj = _intgk(g1);
            if(!((NameAndType) (obj)).is(512))
                return false;
            if(((NameAndType) (obj)).getClassType() != z_pLg)
                return false;
            z_pJI = z_pHI;
            _bIIZ(215);
            if(j == 215)
                z_pHI++;
            g1 = _intxvg(z_pMx, z_pHI);
            j = g1.getOpcode();
            switch(j)
            {
            case 31: // '\037'
                if(i1 != 0)
                    return false;
                break;

            case 24: // '\030'
            case 27: // '\033'
                if(i1 != 1)
                    return false;
                break;

            case 30: // '\036'
                if(i1 != 2)
                    return false;
                break;

            case 25: // '\031'
            case 26: // '\032'
            case 28: // '\034'
            case 29: // '\035'
            default:
                return false;
            }
            _epvV();
        }
        catch(p p1)
        {
            return false;
        }
        f1._cIIV(z_pKI, z_pJI);
        return true;
    }

    private void _acV(Method c1, net.rim.tools.compiler.analysis.Instruction g1)
    {
        InstructionCode f1 = c1.getInstructionCode();
        ai ai1 = f1._eBvai();
        InstructionTarget x1 = ai1._bkIx(0);
        int j = g1._eOvI();
        z_pMx.setInstruction(null, z_pQI);
        int l = f1._eyvI();
        int i1 = f1._eCvI();
        byte byte0 = 0;
        int j1 = 283;
        net.rim.tools.compiler.analysis.Instruction g2 = _bBIg(1);
        if(g2 != null)
            j1 = g2.getOpcode();
        net.rim.tools.compiler.analysis.Instruction g3 = x1.getInstruction(l);
        switch(g3.getOpcode())
        {
        case 207:
        case 209:
            if(j1 == 205)
                byte0 = 1;
            break;

        case 208:
        case 211:
            if(j1 == 206)
                byte0 = 2;
            break;
        }
        if(byte0 > 0)
        {
            l++;
            i1--;
            z_pMx.setInstruction(null, z_pQI + 1);
        }
        int k1 = z_pMx._dbvI();
        for(int l1 = 0; l1 < i1; l1++)
        {
            net.rim.tools.compiler.analysis.Instruction g4 = x1.getInstruction(l + l1);
            g4 = g4._eLvg();
            g4.setValueOp(j);
            if(g4 instanceof InstructionNameAndType)
            {
                InstructionNameAndType n1 = (InstructionNameAndType)g4;
                n1.getNameAndType().addModifiers(0x200000);
            }
            z_pMx.insertInstruction(g4, z_pQI + l1);
        }

        z_pMx._dtvV();
        z_pMx._dcvI();
        int i2 = z_pMx._dbvI();
        if(i2 > k1)
        {
            InstructionCode f2 = z_pNc.getInstructionCode();
            if(f2.getMaxStacksMap() < i2)
                f2.set_maxMethodStackMap(i2);
        }
    }

    private void _forgV(net.rim.tools.compiler.analysis.Instruction g1)
        throws CompileException
    {
        net.rim.tools.compiler.analysis.Instruction g2 = _bBIg(1);
        if(g2 == null)
            return;
        net.rim.tools.compiler.analysis.Instruction g3;
        switch(g2.getOpcode())
        {
        default:
            return;

        case 40: // '('
        case 42: // '*'
            g3 = _bBIg(2);
            break;
        }
        if(g3.getOpcode() != 1)
            return;
        if(!(g3 instanceof InstructionNameAndType))
            return;
        InstructionNameAndType n1 = (InstructionNameAndType)g3;
        Method c1 = (Method)n1.getNameAndType();
        if(!c1._b8IZ(5))
            return;
        Method c2 = c1.getClassType()._bVIc(4);
        if(c2 == null)
            return;
        int j = z_pMx._dbvI();
        int l = g1._eOvI();
        z_pMx.setInstruction(null, z_pQI);
        if(g2._eOvI() == 0)
            g2.setValueOp(l);
        n1._bLIV(5);
        n1._akV(c2);
        z_pMx._dtvV();
        z_pMx._dcvI();
        int i1 = z_pMx._dbvI();
        if(i1 > j)
        {
            InstructionCode f1 = z_pNc.getInstructionCode();
            if(f1.getMaxStacksMap() < i1)
                f1.set_maxMethodStackMap(i1);
        }
    }

    private void _bEIV(int j)
    {
        try
        {
            int l = 0;
            for(int i1 = z_pQI; i1 < z_pKI; i1++)
            {
                net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, i1);
                if(l == 0)
                    l = g1._eOvI();
                z_pMx.setInstruction(null, i1);
            }

            net.rim.tools.compiler.analysis.Instruction g2 = _intxvg(z_pMx, z_pKI);
            if(g2._eOvI() == 0)
                g2.setValueOp(l);
            g2._bLIV(j);
            int j1 = z_pMx._dhvI();
            for(int k1 = z_pKI + 1; k1 < j1; k1++)
                z_pMx.setInstruction(null, k1);

            z_pMx._dtvV();
        }
        catch(p p1)
        {
            throw new RuntimeException("InstructionOptimization match failure: " + z_pNc._fWvString());
        }
    }

    private boolean _forxvZ(InstructionTarget x1, int j)
    {
        try
        {
            net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(x1, 0);
            if(g1 != null && _agvI(g1, false) == j)
            {
                net.rim.tools.compiler.analysis.Instruction g2 = _intxvg(x1, 1);
                if(g2 != null && g2.getOpcode() == 24)
                    return true;
            }
        }
        catch(p p1) { }
        return false;
    }

    private boolean _dogvZ(net.rim.tools.compiler.analysis.Instruction g1, int j)
    {
        if((f_flag & 0x1000) != 0 && z_pOai._dVvI() == 0)
        {
            net.rim.tools.compiler.analysis.Instruction g2 = _bCIg(1);
            if(g2 != null)
            {
                Method c1 = _trygc(g2);
                if(c1 != null)
                {
                    net.rim.tools.compiler.types.Type a1 = c1._fMva();
                    if(a1 != null && a1.getTypeId() == 1)
                    {
                        InstructionTarget x1 = z_pMx._dwvx();
                        if(_forxvZ(x1, j) && z_pMx._dsvI() == 1)
                        {
                            InstructionTarget x2 = z_pMx._a5Ix(0);
                            if(_forxvZ(x2, j ^ 1))
                            {
                                int l = g1._eOvI();
                                int i1 = g1.getIp();
                                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(i1, 24, 0)).setValueOp(l), z_pQI);
                                z_pMx._dtvV();
                                z_pMx._doxV(null);
                                z_pMx._a8IV(0);
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.Instruction g1)
        throws CompileException
    {
        int j = g1.getOpcode();
        boolean flag = false;
        switch(j)
        {
        default:
            break;

        case 14: // '\016'
        case 221:
            if(z_pOai._dVvI() != 0)
                break;
            if((f_flag & 0x10) != 0 && _emvZ())
            {
                _bEIV(33);
                break;
            }
            if((f_flag & 0x40) != 0 && _eovZ())
            {
                try
                {
                    g1 = _intxvg(z_pMx, z_pKI);
                    _bEIV(23);
                    _aIgIZ(z_pKI, g1, z_pJI, 23);
                }
                catch(p p1) { }
                break;
            }
            if((f_flag & 0x40) != 0 && _eqvZ())
            {
                try
                {
                    g1 = _intxvg(z_pMx, z_pKI + 1);
                    _bEIV(g1.getOpcode() + 1);
                }
                catch(p p2) { }
                break;
            }
            if((f_flag & 0x80) != 0 && _evvZ())
            {
                _bEIV(93);
                break;
            }
            if((f_flag & 0x20) == 0 || !_ewvZ())
                break;
            try
            {
                g1 = _intxvg(z_pMx, z_pKI);
                _bEIV((12 + g1.getOpcode()) - 5);
            }
            catch(p p3) { }
            break;

        case 205:
            if(z_pQI <= 0)
                break;
            if((f_flag & 0x400) != 0)
            {
                z_pHI = z_pQI - 2;
                try
                {
                    _fZI(true);
                    if(_bIIZ(2, 215))
                        z_pMx.setInstruction(null, z_pQI - 2);
                    z_pMx.setInstruction(null, z_pQI - 1);
                    z_pMx.setInstruction(null, z_pQI);
                    z_pMx._dtvV();
                    break;
                }
                catch(p p4) { }
            }
            if((f_flag & 0x100) == 0)
                break;
            z_pHI = z_pQI - 1;
            try
            {
                int j1 = _voidIII(z_pQI - 1, -1);
                if(j1 >= z_pNc.getMaxLocalsNum() || z_pMx._dbvI() >= z_pNc.getMaxStacksMap())
                    break;
                int l = _bDII(1);
                z_pMx.setInstruction(null, z_pQI - 1);
                if(l == 0)
                    l = g1._eOvI();
                z_pMx.setInstruction(null, z_pQI);
                if(l != 0)
                {
                    g1 = _bBIg(1);
                    if(g1 != null && g1._eOvI() == 0)
                        g1.setValueOp(l);
                }
                z_pMx._dtvV();
            }
            catch(p p5) { }
            break;

        case 206:
            if(z_pQI <= 0 || (f_flag & 0x400) == 0)
                break;
            try
            {
                z_pHI = z_pQI - 2;
                if(_bIIZ(1, 116))
                {
                    z_pHI--;
                    _fZI(false);
                    z_pMx.setInstruction(null, z_pQI - 2);
                } else
                {
                    _etvJ();
                    if(_bIIZ(2, 215))
                        z_pMx.setInstruction(null, z_pQI - 2);
                }
                z_pMx.setInstruction(null, z_pQI - 1);
                z_pMx.setInstruction(null, z_pQI);
                z_pMx._dtvV();
            }
            catch(p p6) { }
            break;

        case 204:
            if((f_flag & 8) == 0)
                break;
            int i1 = g1._eOvI();
            z_pMx.setInstruction(null, z_pQI);
            g1 = _bBIg(1);
            if(g1 != null && g1._eOvI() == 0)
                g1.setValueOp(i1);
            z_pMx._dtvV();
            break;

        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            if(!_bIIZ(1, 215))
                _aIgIZ(z_pQI, g1, g1.getOp(), j);
            break;
        }
    }

    public void walkInstruction(InstructionBranch q)
        throws CompileException
    {
        int j = q.getOpcode();
        boolean flag = false;
        byte byte0 = -1;
        char c1 = '\uFFFF';
        switch(j)
        {
        case 146:
            flag = true;
            byte0 = 34;
            c1 = '\237';
            break;

        case 149:
            flag = true;
            byte0 = 34;
            c1 = '\240';
            break;

        case 145:
            flag = true;
            byte0 = 35;
            c1 = '\223';
            break;

        case 148:
            flag = true;
            byte0 = 35;
            c1 = '\226';
            break;

        case 153:
            flag = true;
            byte0 = 35;
            c1 = '\232';
            break;

        case 151:
            flag = true;
            byte0 = 35;
            c1 = '\230';
            break;

        case 157:
            flag = true;
            byte0 = 35;
            c1 = '\236';
            break;

        case 155:
            flag = true;
            byte0 = 35;
            c1 = '\234';
            break;

        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
            _aIgIZ(z_pQI, q, q.getOp(), j);
            break;

        case 147:
            if(_dogvZ(q, 1))
                return;
            break;

        case 150:
            if(_dogvZ(q, 0))
                return;
            break;
        }
        if(flag && _bIIZ(1, byte0))
        {
            int l = _bDII(1);
            z_pMx.setInstruction(null, z_pQI - 1);
            q._bLIV(c1);
            if(q._eOvI() == 0)
                q.setValueOp(l);
            z_pMx._dtvV();
        }
    }

    private boolean _aIgIZ(int j, net.rim.tools.compiler.analysis.Instruction g1, long l, int i1)
    {
        int j1 = g1._eOvI();
        int k1 = g1.getIp();
        if(l == 0L)
        {
            if(i1 == 23)
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 21, (int)l)).setValueOp(j1), j);
            else
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 35)).setValueOp(j1), j);
        } else
        if(l == 1L)
        {
            if(i1 == 23)
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 21, (int)l)).setValueOp(j1), j);
            else
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 44)).setValueOp(j1), j);
        } else
        if(l <= 127L && l >= -128L)
        {
            if(i1 == 36)
                return false;
            if(i1 == 23)
                g1._bLIV(21);
            else
            if(i1 == 39)
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 36, (int)l)).setValueOp(j1), j);
            else
                g1._bLIV(36);
        } else
        if(l <= 32767L && l >= -32768L)
        {
            if(i1 == 37)
                return false;
            if(i1 == 23)
                g1._bLIV(22);
            else
            if(i1 == 39)
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 37, (int)l)).setValueOp(j1), j);
            else
                g1._bLIV(37);
        } else
        if(l <= 0x7fffffffL && l >= 0xffffffff80000000L)
        {
            if(i1 == 38)
                return false;
            if(i1 == 23)
                return false;
            if(i1 == 39)
                z_pMx.setInstruction((new net.rim.tools.compiler.analysis.Instruction(k1, 38, (int)l)).setValueOp(j1), j);
            else
                g1._bLIV(38);
        } else
        {
            return false;
        }
        z_pMx._dtvV();
        return true;
    }

    public void walkInstruction(InstructionLong j)
        throws CompileException
    {
        if(_bIIZ(1, 215))
            return;
        int l = j.getIp();
        int i1 = j.getOpcode();
        if(i1 == 39 && _aIgIZ(z_pQI, j, j.getOp2(), i1))
            z_pMx.insertInstruction(new net.rim.tools.compiler.analysis.Instruction(l, 116), z_pQI + 1);
    }

    public void walkInstruction(InstructionNameAndType n1)
        throws CompileException
    {
        int j = n1.getOpcode();
        NameAndType k1 = n1.getNameAndType();
        if(k1 instanceof Field)
        {
            int l = k1.getAbsoluteOffset();
            if(l < -1 || l > 511)
                throw new CompileException(z_pLg.getFullName(), "Wide field operations not supported by vm");
            if(j == 99 && _bIIZ(1, 63))
            {
                int i1 = _bDII(1);
                z_pMx.setInstruction(null, z_pQI - 1);
                n1._bLIV(103);
                if(n1._eOvI() == 0)
                    n1.setValueOp(i1);
                z_pMx._dtvV();
            }
        } else
        if(k1 instanceof Method)
        {
            Method c1 = (Method)k1;
            if(j == 1 && c1._b8IZ(1))
            {
                net.rim.tools.compiler.analysis.Instruction g1 = _bCIg(1);
                if(g1 == null)
                    return;
                switch(g1.getOpcode())
                {
                case 40: // '('
                case 42: // '*'
                    int j1 = g1._eOvI();
                    if(j1 == 0)
                        j1 = n1._eOvI();
                    String s = ((InstructionString)g1).getString();
						net.rim.tools.compiler.analysis.Instruction g2 = (new net.rim.tools.compiler.analysis.Instruction(g1.getIp(), 38, s.length())).setValueOp(j1);
                    z_pMx.setInstruction(g2, z_pQI - 1);
                    z_pMx.setInstruction(null, z_pQI);
                    z_pMx._dtvV();
                    break;
                }
            } else
            if(c1._b8IZ(3))
                _forgV(n1);
            else
            if(j == 7 && c1._fRvZ())
                _acV(c1, n1);
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionInts h1)
        throws CompileException
    {
        int j = h1.getOpcode();
        InstructionTarget x1 = z_pMx;
        switch(j)
        {
        default:
            break;

        case 163:
        case 164:
            if((f_flag & 0x200) != 0 && h1._eXvZ())
            {
                int l = x1._dsvI();
                InstructionTarget x2 = x1._a5Ix(0);
                for(int i1 = 1; i1 < l;)
                {
                    InstructionTarget x3 = x1._a5Ix(i1);
                    if(x3 == x2)
                    {
                        x1._dtvV();
                        x1._a8IV(i1);
                        h1._bNIV(i1 - 1);
                        if(--l == 1)
                            break;
                    } else
                    {
                        i1++;
                    }
                }

            }
            break;
        }
    }

    public void walkInstruction(InstructionType o1)
        throws CompileException
    {
        int j = o1.getOpcode();
        InstructionTarget x1 = z_pMx;
        switch(j)
        {
        case 190:
        default:
            break;

        case 189:
        case 191:
        case 192:
            if((f_flag & 2) == 0)
                break;
            try
            {
                net.rim.tools.compiler.types.Type a1 = o1._e0va();
                if(_bBIg(1).getOpcode() == 147)
                {
                    InstructionTarget x2 = z_pMx._dwvx();
                    if(x2 != null && x2._dmvZ())
                    {
                        z_pHI = 0;
                        int l = 0;
                        for(boolean flag = false; !flag && l >= 0 && l <= 3;)
                        {
                            net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(x2, ++z_pHI);
                            switch(g1.getOpcode())
                            {
                            case 35: // '#'
                            case 36: // '$'
                            case 37: // '%'
                            case 38: // '&'
                            case 44: // ','
                            case 49: // '1'
                            case 50: // '2'
                            case 51: // '3'
                            case 52: // '4'
                            case 55: // '7'
                            case 56: // '8'
                            case 57: // '9'
                            case 58: // ':'
                            case 59: // ';'
                            case 60: // '<'
                            case 61: // '='
                            case 62: // '>'
                            case 63: // '?'
                            case 64: // '@'
                            case 65: // 'A'
                            case 66: // 'B'
                            case 67: // 'C'
                            case 68: // 'D'
                            case 69: // 'E'
                            case 70: // 'F'
                            case 103: // 'g'
                            case 109: // 'm'
                                l++;
                                break;

                            case 99: // 'c'
                            case 100: // 'd'
                                break;

                            case 176:
                                l--;
                                break;

                            case 190:
                            case 193:
                            case 194:
                                if(((InstructionType)g1)._e0va().equals(a1))
                                {
                                    flag = true;
                                    break;
                                }
                                // fall through

                            default:
                                throw z_pRp;
                            }
                        }

                        boolean flag1 = true;
                        for(int i1 = 0; i1 < z_pHI && flag1; i1++)
                            flag1 = _intxvg(x1, (z_pQI - z_pHI) + i1).equals(_intxvg(x2, i1));

                        if(flag1)
                        {
                            int j1 = o1._eOvI();
                            if(j1 == 0)
                                j1 = _intxvg(x1, z_pQI + 1)._eOvI();
                            int k1 = 0;
                            for(int l1 = 0; l1 <= z_pHI && k1 == 0; l1++)
                                k1 = _intxvg(x2, l1)._eOvI();

                            switch(j)
                            {
                            case 191:
                                j = 195;
                                break;

                            case 192:
                                j = 196;
                                break;

                            case 189:
                                j = 197;
                                break;
                            }
                            o1 = new InstructionType(o1.getIp(), j, a1);
                            o1.setValueOp(j1);
                            x1.setInstruction(o1, z_pQI);
                            x1.setInstruction(null, z_pQI + 1);
                            x1._biIV(8);
                            x1._dtvV();
                            if(k1 != 0 && z_pHI + 1 < x2._dhvI())
                            {
                                net.rim.tools.compiler.analysis.Instruction g2 = _intxvg(x2, z_pHI + 1);
                                if(g2._eOvI() == 0)
                                    g2.setValueOp(k1);
                            }
                            for(int i2 = z_pHI; i2 >= 0; i2--)
                                x2._a3IV(i2);

                        }
                    }
                }
            }
            catch(p p1) { }
            break;
        }
    }

    private boolean _agZ(net.rim.tools.compiler.analysis.Instruction g1, net.rim.tools.compiler.types.Type a1)
    {
        if(g1 instanceof InstructionType)
        {
            InstructionType o1 = (InstructionType)g1;
            return o1._e0va() == a1;
        } else
        {
            return false;
        }
    }

    public boolean _ejvZ()
        throws CompileException
    {
        if(z_pOai._d3vI() != 2)
            return false;
        z_pMx = z_pOai._bkIx(0);
        z_pQI = 0;
        try
        {
            if(_intxvg(z_pMx, z_pQI++).getOpcode() != 14)
                return false;
            net.rim.tools.compiler.analysis.Instruction g1 = _intxvg(z_pMx, z_pQI++);
            int j = g1.getOpcode();
            if(j == 186 || j == 187)
            {
                if(!_agZ(g1, z_pLg.getSuperClass()))
                    return false;
                g1 = _intxvg(z_pMx, z_pQI++);
                j = g1.getOpcode();
            }
            if(j != 19)
                return false;
            if(!_agZ(g1, z_pLg))
                return false;
            if(_intxvg(z_pMx, z_pQI++).getOpcode() != 20)
                return false;
            if(_intxvg(z_pMx, z_pQI++).getOpcode() != 32)
                return false;
            if(z_pQI != z_pMx._dhvI())
                return false;
        }
        catch(p p1)
        {
            return false;
        }
        return true;
    }
}
