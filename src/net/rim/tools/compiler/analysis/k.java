// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.classfile.ad;
import net.rim.tools.compiler.classfile.af;
import net.rim.tools.compiler.classfile.ai;
import net.rim.tools.compiler.classfile.al;
import net.rim.tools.compiler.classfile.u;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.i;
import net.rim.tools.compiler.types.Type;
import net.rim.tools.compiler.types.ReferenceType;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.NullType;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.ArrayType;

// Referenced classes of package net.rim.tools.compiler.g:
//            e, d, g, n,
//            o, q, h, l,
//            i, m, a

public final class k extends net.rim.tools.compiler.analysis.InstructionWalker
implements net.rim.tools.compiler.classfile.u
{

    private boolean z_pxZ;
    private boolean z_pzZ;
    private Compiler z_pvCompiler;
    private net.rim.tools.compiler.types.Method z_pBc;
    private net.rim.tools.compiler.classfile.ai z_pCai;
    private net.rim.tools.compiler.classfile.InstructionTarget z_pAx;
    private net.rim.tools.compiler.analysis.InstructionStackEntry z_pGd;
    private int z_pDI;
    private net.rim.tools.compiler.types.Type z_pFaa[];
    private net.rim.tools.compiler.types.Type z_pyaa[];
    private boolean z_pwZ;
    private boolean z_puaZ[];
    private boolean z_pEaZ[];
    private int z_ptI;

    k()
    {
    }

    void _aCompilerV(Compiler compiler, net.rim.tools.compiler.types.Method c1, net.rim.tools.compiler.classfile.ai ai1, int j)
    {
        z_pxZ = false;
        z_pzZ = false;
        z_pvCompiler = compiler;
        z_pBc = c1;
        z_pCai = ai1;
        z_pGd = null;
        if(z_pFaa == null)
            z_pFaa = new net.rim.tools.compiler.types.Type[3];
        z_pFaa[1] = z_pvCompiler.getIntType();
        z_pFaa[2] = z_pvCompiler.getLongType();
        if(z_pyaa == null)
            z_pyaa = new net.rim.tools.compiler.types.Type[3];
        z_pyaa[1] = z_pvCompiler.getFloatType();
        z_pyaa[2] = z_pvCompiler.getDoubleType();
        z_pwZ = false;
        if(z_puaZ == null || j > z_puaZ.length)
        {
            z_puaZ = new boolean[j];
            z_pEaZ = new boolean[j];
        }
        int i1 = c1._fIvI();
        int j1;
        for(j1 = 0; j1 < i1; j1++)
            z_puaZ[j1] = z_pEaZ[j1] = true;

        for(; j1 < j; j1++)
            z_puaZ[j1] = z_pEaZ[j1] = false;

        z_ptI = j;
    }

    public void _eivV()
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = z_pBc.getClassType();
        if(z_pvCompiler._intStringZ(g1.getFullName()))
            return;
        int j = z_pCai._dPvI();
        StringBuffer stringbuffer = null;
        for(int i1 = 0; i1 < z_ptI; i1++)
            if(z_puaZ[i1] && !z_pEaZ[i1])
            {
                if(stringbuffer == null)
                    stringbuffer = new StringBuffer();
                boolean flag = false;
                for(int j1 = 0; j1 < j; j1++)
                {
                    net.rim.tools.compiler.classfile.al al1 = z_pCai._buIal(j1);
                    net.rim.tools.compiler.classfile.af af1 = al1._eavaf();
                    if(i1 == af1.getIndex())
                    {
                        stringbuffer.append(af1.getName());
                        stringbuffer.append(' ');
                        flag = true;
                    }
                }

                if(!flag)
                {
                    stringbuffer.append("local#");
                    stringbuffer.append(i1);
                    stringbuffer.append(' ');
                }
            }

        if(stringbuffer != null)
            z_pvCompiler.generateWarning(true, g1.get_className() + ':' + z_pBc._fHvI(), "local variable(s) { " + stringbuffer.toString() + "} initialized but not used in: " + z_pBc._fWvString());
    }

    public void _efvV()
    {
        z_pxZ = false;
    }

    public boolean _ehvZ()
    {
        return z_pxZ;
    }

    public void _egvV()
    {
        int j = z_pCai._d3vI();
        for(int i1 = 0; i1 < j; i1++)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x1 = z_pCai._bkIx(i1);
            net.rim.tools.compiler.analysis.InstructionStackEntry d1 = x1.getStackEntry();
            if(d1 != null)
                d1._cYvV();
        }

    }

    private void _EStringV(String s)
	throws net.rim.tools.compiler.util.i
    {
        throw new net.rim.tools.compiler.util.i(null, z_pBc._fWvString(), z_pDI, s);
    }

    private void _charStringV(String s, String s1)
	throws net.rim.tools.compiler.util.i
    {
        throw new net.rim.tools.compiler.util.i(null, z_pBc._fWvString(), z_pDI, "found " + s + " where " + s1 + " is required");
    }

    private void _aaV(net.rim.tools.compiler.types.Type a1, String s)
	throws net.rim.tools.compiler.util.i
    {
        _charStringV(a1.getName(), s);
    }

    private void _ifaV(net.rim.tools.compiler.types.Type a1, Type a2)
	throws net.rim.tools.compiler.util.i
    {
        _charStringV(a1.getName(), a2.getName());
    }

    private void _aaV(net.rim.tools.compiler.types.Type a1, net.rim.tools.compiler.types.Type a2)
	throws net.rim.tools.compiler.util.i
    {
        String s;
        if(a2.getTypeId() == 5)
            s = "integer type";
        else
            s = a2.getName() + " type";
        throw new i(null, z_pBc._fWvString(), z_pDI, "found " + a1.getName() + " where " + s + " is required");
    }

    public void walkInstruction(net.rim.tools.compiler.classfile.InstructionTarget x1)
        throws net.rim.tools.compiler.util.CompileException
    {
        z_pAx = x1;
        if(z_pGd == null)
        {
            z_pGd = z_pAx.getStackEntry();
            if(z_pGd != null)
            {
                if(!z_pGd._c5vZ())
                    z_pGd = null;
                else
                    z_pGd = new net.rim.tools.compiler.analysis.InstructionStackEntry(z_pGd);
            } else
            if(z_pvCompiler.isPreverified() && z_pAx._dCvZ())
                _EStringV("missing stack map at label");
        }
        boolean flag = false;
        int j = z_pCai._dVvI();
        for(int i1 = 0; i1 < j; i1++)
        {
            if(x1 != z_pCai._bpIad(i1)._dMvx())
                continue;
            flag = true;
            break;
        }

        z_pwZ = flag;
    }

    public void walkInstruction(int j, net.rim.tools.compiler.analysis.Instruction g1)
    {
        z_pDI = j;
    }

    private void _adV(net.rim.tools.compiler.analysis.InstructionStackEntry d1, net.rim.tools.compiler.classfile.InstructionTarget x1, boolean flag)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d2 = x1.getStackEntry();
        if(d2 == null)
        {
            d2 = new net.rim.tools.compiler.analysis.InstructionStackEntry(d1);
            d2._a0IV(x1.getOffset());
            if(flag)
                d2._aXIV(1);
            x1.setStackEntry(d2);
            z_pxZ = true;
        } else
        {
            d2._adCompilerV(d1, flag, z_pvCompiler);
            if(d2._c5vZ())
                z_pxZ = true;
        }
    }

    public void _axvV(net.rim.tools.compiler.classfile.InstructionTarget x1, boolean flag)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(z_pGd != null)
        {
            net.rim.tools.compiler.analysis.InstructionStackEntry d1 = null;
            int j1 = z_pCai._dVvI();
            for(int j = 0; j < j1; j++)
            {
                net.rim.tools.compiler.classfile.ad ad1 = z_pCai._bpIad(j);
                if(ad1._charxZ(x1) && (!flag || x1.getOffset() + x1._dxvI() != ad1._dKvx().getOffset()))
                {
                    if(d1 == null)
                        d1 = new net.rim.tools.compiler.analysis.InstructionStackEntry(z_pGd);
                    d1._c1vV();
                    net.rim.tools.compiler.types.ClassType g1 = ad1._dLvg();
                    if(g1 == null)
                        g1 = z_pvCompiler._rvg();
                    d1._ifaV(g1);
                    _adV(d1, ad1._dMvx(), false);
                }
            }

            if(flag)
            {
                x1.getStackEntry()._cVvV();
                InstructionTarget x2 = x1._dwvx();
                if(x2 != null)
                    _adV(z_pGd, x2, false);
                int k1 = x1._dsvI();
                for(int i1 = 0; i1 < k1; i1++)
                {
                    InstructionTarget x3 = x1._a5Ix(i1);
                    _adV(z_pGd, x3, x1._baIZ(8));
                }

                int l1 = z_pGd._cXvI();
                if(l1 > x1._dnvI())
                    x1._bcIV(l1);
                z_pGd = null;
            }
        }
    }

    private void _aIaV(int j, net.rim.tools.compiler.types.Type a1)
	throws net.rim.tools.compiler.util.i
    {
        boolean flag = false;
        String s = "";
        switch(j)
        {
        case 176:
        case 182:
            flag = a1 instanceof ReferenceType;
            s = "reference type";
            break;

        case 172:
        case 178:
            flag = a1.equals(z_pvCompiler.getByteType()) || a1.equals(z_pvCompiler.getBooleanType());
            s = "byte or boolean type";
            break;

        case 174:
        case 179:
            flag = a1.equals(z_pvCompiler.getCharType());
            s = "char type";
            break;

        case 175:
        case 181:
            if(z_pzZ)
            {
                flag = a1.equals(z_pvCompiler.getFloatType());
                s = "float type";
            } else
            {
                flag = a1.equals(z_pvCompiler.getIntType());
                s = "integer type";
            }
            break;

        case 177:
        case 183:
            if(z_pzZ)
            {
                flag = a1.equals(z_pvCompiler.getDoubleType());
                s = "double type";
            } else
            {
                flag = a1.equals(z_pvCompiler.getLongType());
                s = "long type";
            }
            break;

        case 173:
        case 180:
            flag = a1.equals(z_pvCompiler.getShortType());
            s = "short type";
            break;
        }
        if(!flag)
            _aaV(a1, s);
    }

    private void _ifIIV(int j, int i1, boolean flag)
	throws net.rim.tools.compiler.util.i
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        net.rim.tools.compiler.types.Type a1 = d1._aYIa(1);
        if(!a1._doaZ(z_pFaa[1]))
            _aaV(a1, z_pFaa[1]);
        net.rim.tools.compiler.types.Type a2 = d1._aYIa(1);
        if(a2 instanceof net.rim.tools.compiler.types.ArrayType)
        {
            a2 = ((net.rim.tools.compiler.types.ArrayType)a2).getBaseType();
            _aIaV(j, a2);
        } else
        if(a2 instanceof net.rim.tools.compiler.types.NullType)
        {
            if(!flag)
                a2 = z_pzZ ? z_pyaa[i1] : z_pFaa[i1];
        } else
        {
            _aaV(a2, "array type");
        }
        d1._ifaV(a2);
    }

    private void _doIIV(int j, int i1, boolean flag)
	throws net.rim.tools.compiler.util.i
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        net.rim.tools.compiler.types.Type a1 = d1._aYIa(i1);
        net.rim.tools.compiler.types.Type a2 = d1._aYIa(1);
        if(!a2._doaZ(z_pFaa[1]))
            _aaV(a2, z_pFaa[1]);
        net.rim.tools.compiler.types.Type a3 = d1._aYIa(1);
        if(a3 instanceof net.rim.tools.compiler.types.ArrayType)
        {
            a3 = ((net.rim.tools.compiler.types.ArrayType)a3).getBaseType();
            _aIaV(j, a3);
        } else
        if(a3 instanceof net.rim.tools.compiler.types.NullType)
        {
            if(flag)
                a3 = a1;
            else
                a3 = z_pzZ ? z_pyaa[i1] : z_pFaa[i1];
        } else
        {
            _aaV(a3, "array type");
        }
        if(!a1._doaZ(a3))
            _ifaV(a1, a3);
    }

    private void _bAIV(int j)
        throws net.rim.tools.compiler.util.CompileException
    {
        Object obj = null;
        switch(j)
        {
        case 1: // '\001'
            obj = z_pvCompiler.getBooleanType();
            break;

        case 3: // '\003'
            obj = z_pvCompiler.getCharType();
            break;

        case 2: // '\002'
            obj = z_pvCompiler.getByteType();
            break;

        case 4: // '\004'
            obj = z_pvCompiler.getShortType();
            break;

        case 5: // '\005'
            obj = z_pvCompiler.getIntType();
            break;

        case 6: // '\006'
            obj = z_pvCompiler.getLongType();
            break;

        case 11: // '\013'
            obj = z_pvCompiler.getFloatType();
            break;

        case 12: // '\f'
            obj = z_pvCompiler.getDoubleType();
            break;
        }
        if(obj == null)
            _charStringV("type code: " + j, "type enumeration");
        obj = ((net.rim.tools.compiler.types.Type) (obj)).getArrayType();
        z_pGd._ifaV(((net.rim.tools.compiler.types.Type) (obj)));
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.Instruction g1)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = 1;
            int i1 = g1.getOpcode();
            int j1 = g1.getOp();
            Type aa[] = z_pzZ ? z_pyaa : z_pFaa;
            switch(i1)
            {
            case 0: // '\0'
            case 14: // '\016'
            case 16: // '\020'
            case 18: // '\022'
            case 20: // '\024'
            case 204:
            case 216:
            case 221:
            case 250:
                break;

            case 177:
                j++;
                // fall through

            case 172:
            case 173:
            case 174:
            case 175:
            case 176:
                _ifIIV(i1, j, i1 == 176);
                break;

            case 183:
                j++;
                // fall through

            case 178:
            case 179:
            case 180:
            case 181:
            case 182:
                _doIIV(i1, j, i1 == 182);
                break;

            case 167:
					net.rim.tools.compiler.types.Type a1 = d1._aYIa(1);
					if(!(a1 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a1, "array type");
                d1._ifaV(z_pFaa[1]);
                break;

            case 34: // '"'
                d1._ifaV(z_pvCompiler.getNullType());
                break;

            case 63: // '?'
            case 64: // '@'
            case 65: // 'A'
            case 66: // 'B'
            case 67: // 'C'
            case 68: // 'D'
            case 69: // 'E'
            case 70: // 'F'
                j1 = i1 - 63;
                // fall through

            case 51: // '3'
            case 52: // '4'
					net.rim.tools.compiler.types.Type a2 = d1._aZIa(j1);
					if(!(a2 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a2, "reference type");
                d1._ifaV(a2);
                z_pEaZ[j1] = true;
                break;

            case 55: // '7'
            case 56: // '8'
            case 57: // '9'
            case 58: // ':'
            case 59: // ';'
            case 60: // '<'
            case 61: // '='
            case 62: // '>'
                j1 = i1 - 55;
                // fall through

            case 49: // '1'
            case 50: // '2'
            case 53: // '5'
            case 54: // '6'
                if(i1 == 53 || i1 == 54)
                    j++;
					net.rim.tools.compiler.types.Type a3 = d1._aZIa(j1);
                if(!a3._doaZ(aa[j]))
                    _aaV(a3, aa[j]);
                d1._ifaV(a3);
                z_pEaZ[j1] = true;
                break;

            case 85: // 'U'
            case 86: // 'V'
            case 87: // 'W'
            case 88: // 'X'
            case 89: // 'Y'
            case 90: // 'Z'
            case 91: // '['
            case 92: // '\\'
                j1 = i1 - 85;
                // fall through

            case 73: // 'I'
            case 74: // 'J'
					net.rim.tools.compiler.types.Type a4 = d1._aYIa(1);
					if(!(a4 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a4, "reference type");
                d1._aavV(a4, j1);
                z_puaZ[j1] = true;
                if(z_pwZ)
                {
                    z_pEaZ[j1] = true;
                    z_pwZ = false;
                }
                break;

            case 77: // 'M'
            case 78: // 'N'
            case 79: // 'O'
            case 80: // 'P'
            case 81: // 'Q'
            case 82: // 'R'
            case 83: // 'S'
            case 84: // 'T'
                j1 = i1 - 77;
                // fall through

            case 71: // 'G'
            case 72: // 'H'
            case 75: // 'K'
            case 76: // 'L'
                if(i1 == 75 || i1 == 76)
                    j++;
                Type a5 = d1._aYIa(j);
                if(!a5._doaZ(aa[j]))
                    _aaV(a5, aa[j]);
                d1._aavV(a5, j1);
                z_puaZ[j1] = true;
                break;

            case 123: // '{'
            case 125: // '}'
            case 127: // '\177'
            case 129:
            case 131:
            case 133:
            case 135:
            case 137:
                j++;
                // fall through

            case 122: // 'z'
            case 124: // '|'
            case 126: // '~'
            case 128:
            case 130:
            case 132:
            case 134:
            case 136:
            case 138:
            case 140:
            case 142:
					net.rim.tools.compiler.types.Type a6 = d1._aYIa(j);
                if(!a6._doaZ(z_pFaa[j]))
                    _aaV(a6, aa[j]);
					net.rim.tools.compiler.types.Type a28 = d1._aYIa(j);
                if(!a28._doaZ(z_pFaa[j]))
                    _aaV(a28, z_pFaa[j]);
                // fall through

            case 35: // '#'
            case 36: // '$'
            case 37: // '%'
            case 38: // '&'
            case 44: // ','
                d1._ifaV(aa[j]);
                break;

            case 202:
            case 203:
					net.rim.tools.compiler.types.Type a29 = d1._aYIa(j);
					if(!(a29 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a29, "reference type");
                break;

            case 119: // 'w'
                j++;
                // fall through

            case 113: // 'q'
            case 114: // 'r'
            case 115: // 's'
            case 118: // 'v'
					net.rim.tools.compiler.types.Type a30 = d1._a1Ia(j);
                if(!a30._doaZ(z_pFaa[j]))
                    _aaV(a30, z_pFaa[j]);
                break;

            case 144:
                j++;
					net.rim.tools.compiler.types.Type a7 = d1._aYIa(j);
                if(!a7._doaZ(aa[j]))
                    _aaV(a7, aa[j]);
                // fall through

            case 117: // 'u'
                j = 2;
                // fall through

            case 116: // 't'
					net.rim.tools.compiler.types.Type a31 = d1._aYIa(j);
                if(!a31._doaZ(aa[j]))
                    _aaV(a31, aa[j]);
                d1._ifaV(aa[3 - j]);
                break;

            case 139:
            case 141:
            case 143:
					net.rim.tools.compiler.types.Type a8 = d1._aYIa(1);
                if(!a8._doaZ(z_pFaa[1]))
                    _aaV(a8, z_pFaa[1]);
					net.rim.tools.compiler.types.Type a32 = d1._aYIa(2);
                if(!a32._doaZ(z_pFaa[2]))
                    _aaV(a32, z_pFaa[2]);
                d1._ifaV(z_pFaa[2]);
                break;

            case 188:
					net.rim.tools.compiler.types.Type a9 = d1._a1Ia(1);
                if(!a9._doaZ(z_pvCompiler._rvg()))
                    _aaV(a9, "class derived from " + z_pvCompiler._rvg().getName());
                break;

            case 165:
					net.rim.tools.compiler.types.Type a10 = d1._aYIa(1);
                if(!a10._doaZ(z_pFaa[1]))
                    _aaV(a10, z_pFaa[1]);
                _bAIV(j1);
                break;

            case 21: // '\025'
            case 22: // '\026'
            case 23: // '\027'
                d1._ifaV(aa[j]);
                // fall through

            case 24: // '\030'
            case 27: // '\033'
            case 30: // '\036'
                if(i1 == 30)
                    j++;
					net.rim.tools.compiler.types.Type a11 = d1._aYIa(j);
                if(!z_pBc._fLvZ())
                    _aaV(a11, "void type");
                if(!a11._doaZ(z_pBc._fMva()))
                    _aaV(a11, z_pBc._fMva().getName());
                break;

            case 31: // '\037'
            case 32: // ' '
            case 33: // '!'
                d1._c1vV();
                if(z_pBc._fLvZ())
                    _charStringV("void type", z_pBc._fMva().getName());
                break;

            case 206:
                j++;
                // fall through

            case 205:
                d1._aXIV(j);
                break;

            case 213:
					net.rim.tools.compiler.types.Type a12 = d1._aYIa(1);
                if(a12.getLocalCount() != 1)
                    _aaV(a12, "4 byte type");
					net.rim.tools.compiler.types.Type a33 = d1._aYIa(1);
                if(a33.getLocalCount() != 1)
                    _aaV(a33, "4 byte type");
                d1._ifaV(a12);
                d1._ifaV(a33);
                break;

            case 207:
					net.rim.tools.compiler.types.Type a13 = d1._a1Ia(1);
                if(a13.getLocalCount() != 1)
                    _aaV(a13, "4 byte type");
                d1._ifaV(a13);
                break;

            case 208:
					net.rim.tools.compiler.types.Type a34 = d1._a1Ia(2);
                if(a34.getLocalCount() == 2)
                {
                    d1._ifaV(a34);
                    break;
                }
                if(a34.getLocalCount() == 1)
                {
                    net.rim.tools.compiler.types.Type a14 = d1._a1Ia(1);
                    if(a14.getLocalCount() != 1)
                        _aaV(a14, "4 byte type");
                    d1._ifaV(a34);
                    d1._ifaV(a14);
                } else
                {
                    _aaV(a34, "non-void type");
                }
                break;

            case 211:
					net.rim.tools.compiler.types.Type a42 = d1._a1Ia(3);
                if(a42.getLocalCount() != 1)
                    _aaV(a42, "4 byte type");
					net.rim.tools.compiler.types.Type a35 = d1._a1Ia(2);
                if(a35.getLocalCount() == 1)
                {
                    net.rim.tools.compiler.types.Type a15 = d1._aYIa(1);
                    if(a15.getLocalCount() != 1)
                        _aaV(a15, "4 byte type");
                    d1._aXIV(2);
                    d1._ifaV(a35);
                    d1._ifaV(a15);
                    d1._ifaV(a42);
                    d1._ifaV(a35);
                    d1._ifaV(a15);
                    break;
                }
                if(a35.getLocalCount() == 2)
                {
                    d1._aXIV(2);
                    d1._aXIV(1);
                    d1._ifaV(a35);
                    d1._ifaV(a42);
                    d1._ifaV(a35);
                } else
                {
                    _aaV(a35, "non-void type");
                }
                break;

            case 212:
					net.rim.tools.compiler.types.Type a45 = d1._a1Ia(4);
					net.rim.tools.compiler.types.Type a36 = d1._a1Ia(2);
                if(a45.getLocalCount() == 1)
                {
                    net.rim.tools.compiler.types.Type a43 = d1._a1Ia(3);
                    if(a43.getLocalCount() != 1)
                        _aaV(a43, "4 byte type");
                    if(a36.getLocalCount() == 1)
                    {
                        net.rim.tools.compiler.types.Type a16 = d1._a1Ia(1);
                        if(a16.getLocalCount() != 1)
                            _aaV(a16, "4 byte type");
                        d1._aXIV(2);
                        d1._aXIV(2);
                        d1._ifaV(a36);
                        d1._ifaV(a16);
                        d1._ifaV(a45);
                        d1._ifaV(a43);
                        d1._ifaV(a36);
                        d1._ifaV(a16);
                        break;
                    }
                    if(a36.getLocalCount() == 2)
                    {
                        d1._aXIV(2);
                        d1._aXIV(2);
                        d1._ifaV(a36);
                        d1._ifaV(a45);
                        d1._ifaV(a43);
                        d1._ifaV(a36);
                    } else
                    {
                        _aaV(a36, "non-void type");
                    }
                    break;
                }
                if(a45.getLocalCount() == 2)
                {
                    if(a36.getLocalCount() == 1)
                    {
                        net.rim.tools.compiler.types.Type a17 = d1._a1Ia(1);
                        if(a17.getLocalCount() != 1)
                            _aaV(a17, "4 byte type");
                        d1._aXIV(2);
                        d1._aXIV(2);
                        d1._ifaV(a36);
                        d1._ifaV(a17);
                        d1._ifaV(a45);
                        d1._ifaV(a36);
                        d1._ifaV(a17);
                        break;
                    }
                    if(a36.getLocalCount() == 2)
                    {
                        d1._aXIV(2);
                        d1._aXIV(2);
                        d1._ifaV(a36);
                        d1._ifaV(a45);
                        d1._ifaV(a36);
                    } else
                    {
                        _aaV(a36, "non-void type");
                    }
                } else
                {
                    _aaV(a45, "non-void type");
                }
                break;

            case 209:
					net.rim.tools.compiler.types.Type a18 = d1._aYIa(1);
                if(a18.getLocalCount() != 1)
                    _aaV(a18, "4 byte type");
					net.rim.tools.compiler.types.Type a37 = d1._aYIa(1);
                if(a37.getLocalCount() != 1)
                    _aaV(a37, "4 byte type");
                d1._ifaV(a18);
                d1._ifaV(a37);
                d1._ifaV(a18);
                break;

            case 210:
					net.rim.tools.compiler.types.Type a19 = d1._aYIa(1);
                if(a19.getLocalCount() != 1)
                    _aaV(a19, "4 byte type");
					net.rim.tools.compiler.types.Type a44 = d1._a1Ia(2);
                if(a44.getLocalCount() == 1)
                {
                    net.rim.tools.compiler.types.Type a38 = d1._aYIa(1);
                    if(a38.getLocalCount() != 1)
                        _aaV(a38, "4 byte type");
                    d1._aXIV(1);
                    d1._ifaV(a19);
                    d1._ifaV(a44);
                    d1._ifaV(a38);
                    d1._ifaV(a19);
                    break;
                }
                if(a44.getLocalCount() == 2)
                {
                    d1._aXIV(2);
                    d1._ifaV(a19);
                    d1._ifaV(a44);
                    d1._ifaV(a19);
                } else
                {
                    _aaV(a44, "non-void type");
                }
                break;

            case 215:
                z_pzZ = true;
                return;

            case 257:
            case 259:
            case 261:
            case 263:
            case 265:
                j++;
                // fall through

            case 256:
            case 258:
            case 260:
            case 262:
            case 264:
					net.rim.tools.compiler.types.Type a20 = d1._aYIa(j);
                if(!a20._doaZ(z_pyaa[j]))
                    _aaV(a20, aa[j]);
					net.rim.tools.compiler.types.Type a39 = d1._aYIa(j);
                if(!a39._doaZ(z_pyaa[j]))
                    _aaV(a39, z_pyaa[j]);
                d1._ifaV(z_pyaa[j]);
                break;

            case 267:
                j++;
                // fall through

            case 266:
					net.rim.tools.compiler.types.Type a40 = d1._a1Ia(j);
                if(!a40._doaZ(z_pyaa[j]))
                    _aaV(a40, z_pyaa[j]);
                break;

            case 269:
                j++;
                // fall through

            case 268:
					net.rim.tools.compiler.types.Type a21 = d1._aYIa(1);
                if(!a21._doaZ(z_pFaa[1]))
                    _aaV(a21, z_pFaa[1]);
                d1._ifaV(z_pyaa[j]);
                break;

            case 271:
                j++;
                // fall through

            case 270:
					net.rim.tools.compiler.types.Type a22 = d1._aYIa(2);
                if(!a22._doaZ(z_pFaa[2]))
                    _aaV(a22, z_pFaa[2]);
                d1._ifaV(z_pyaa[j]);
                break;

            case 273:
                j++;
                // fall through

            case 272:
					net.rim.tools.compiler.types.Type a23 = d1._aYIa(1);
                if(!a23._doaZ(z_pyaa[1]))
                    _aaV(a23, z_pyaa[1]);
                d1._ifaV(z_pFaa[j]);
                break;

            case 276:
                j++;
                // fall through

            case 275:
					net.rim.tools.compiler.types.Type a24 = d1._aYIa(2);
                if(!a24._doaZ(z_pyaa[2]))
                    _aaV(a24, z_pyaa[2]);
                d1._ifaV(z_pFaa[j]);
                break;

            case 274:
					net.rim.tools.compiler.types.Type a25 = d1._aYIa(1);
                if(!a25._doaZ(z_pyaa[1]))
                    _aaV(a25, z_pyaa[1]);
                d1._ifaV(z_pyaa[2]);
                break;

            case 277:
					net.rim.tools.compiler.types.Type a26 = d1._aYIa(2);
                if(!a26._doaZ(z_pyaa[2]))
                    _aaV(a26, z_pyaa[2]);
                d1._ifaV(z_pyaa[1]);
                break;

            case 280:
            case 281:
                j++;
                // fall through

            case 278:
            case 279:
					net.rim.tools.compiler.types.Type a27 = d1._aYIa(j);
                if(!a27._doaZ(z_pyaa[j]))
                    _aaV(a27, aa[j]);
					net.rim.tools.compiler.types.Type a41 = d1._aYIa(j);
                if(!a41._doaZ(z_pyaa[j]))
                    _aaV(a41, z_pyaa[j]);
                d1._ifaV(z_pFaa[1]);
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 7: // '\007'
            case 8: // '\b'
            case 9: // '\t'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
            case 13: // '\r'
            case 15: // '\017'
            case 17: // '\021'
            case 19: // '\023'
            case 25: // '\031'
            case 26: // '\032'
            case 28: // '\034'
            case 29: // '\035'
            case 39: // '\''
            case 40: // '('
            case 41: // ')'
            case 42: // '*'
            case 43: // '+'
            case 45: // '-'
            case 46: // '.'
            case 47: // '/'
            case 48: // '0'
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
            case 120: // 'x'
            case 121: // 'y'
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
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
            case 166:
            case 168:
            case 169:
            case 170:
            case 171:
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
            case 198:
            case 199:
            case 200:
            case 201:
            case 214:
            case 217:
            case 218:
            case 219:
            case 220:
            case 222:
            case 223:
            case 224:
            case 225:
            case 226:
            case 227:
            case 228:
            case 229:
            case 230:
            case 231:
            case 232:
            case 233:
            case 234:
            case 235:
            case 236:
            case 237:
            case 238:
            case 239:
            case 240:
            case 241:
            case 242:
            case 243:
            case 244:
            case 245:
            case 246:
            case 247:
            case 248:
            case 249:
            case 251:
            case 252:
            case 253:
            case 254:
            case 255:
            default:
                unexpectedInstruction(g1);
                break;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionBranch q)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = 1;
            int i1 = q.getOpcode();
            switch(i1)
            {
            case 161:
                break;

            case 146:
            case 149:
					net.rim.tools.compiler.types.Type a1 = d1._aYIa(j);
					if(!(a1 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a1, "reference type");
                // fall through

            case 159:
            case 160:
					net.rim.tools.compiler.types.Type a3 = d1._aYIa(j);
					if(!(a3 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a3, "reference type");
                break;

            case 145:
            case 148:
            case 151:
            case 153:
            case 155:
            case 157:
					net.rim.tools.compiler.types.Type a2 = d1._aYIa(j);
                if(!a2._doaZ(z_pFaa[j]))
                    _aaV(a2, z_pFaa[j]);
                // fall through

            case 147:
            case 150:
            case 152:
            case 154:
            case 156:
            case 158:
					net.rim.tools.compiler.types.Type a4 = d1._aYIa(j);
                if(!a4._doaZ(z_pFaa[j]))
                    _aaV(a4, z_pFaa[j]);
                break;

            default:
                unexpectedInstruction(q);
                break;
            }
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionInts h)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = h.getOpcode();
            switch(j)
            {
            case 15: // '\017'
            case 17: // '\021'
                break;

            case 47: // '/'
            case 163:
            case 164:
					net.rim.tools.compiler.types.Type a1 = d1._aYIa(1);
                if(!a1._doaZ(z_pFaa[1]))
                    _aaV(a1, z_pFaa[1]);
                break;

            default:
                unexpectedInstruction(h);
                break;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionBytes l1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(z_pGd != null)
        {
            int j = l1.getOpcode();
            switch(j)
            {
            case 45: // '-'
                _bAIV(l1.getOp());
                break;

            default:
                unexpectedInstruction(l1);
                break;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionLong j)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int i1 = j.getOpcode();
            switch(i1)
            {
            case 39: // '\''
					net.rim.tools.compiler.types.Type a1 = z_pzZ ? z_pyaa[2] : z_pFaa[2];
                d1._ifaV(a1);
                break;

            default:
                unexpectedInstruction(j);
                break;

            case 120: // 'x'
            case 121: // 'y'
                break;
            }
        }
        z_pzZ = false;
    }

    private void _agV(net.rim.tools.compiler.analysis.Instruction g1, net.rim.tools.compiler.types.Method c1)
	throws net.rim.tools.compiler.util.i
    {
        if(!z_pBc._fKvZ() || !c1._fKvZ())
            _EStringV("incorrect parameters provided for method invocation.");
        if(!z_pBc.getClassType()._doaZ(c1.getClassType()))
            _EStringV("inconsistent parameters provided for method invocation.");
        int j = z_pBc.getNumParameters();
        if(j != c1.getNumParameters())
            _EStringV("incorrect number of parameters provided for method invocation.");
        for(int i1 = j - 1; i1 >= 0; i1--)
        {
            net.rim.tools.compiler.types.Type a1 = c1.getParameterType(i1);
            net.rim.tools.compiler.types.Type a3 = z_pBc.getParameterType(i1);
            if(!a3._doaZ(a1))
                _ifaV(a3, a1);
        }

        net.rim.tools.compiler.types.Type a2 = z_pBc._fMva();
        if(c1._fLvZ())
        {
            net.rim.tools.compiler.types.Type a4 = c1._fMva();
            if(a2 == null)
                _aaV(a4, "void");
            else
            if(!a4._doaZ(a2))
                _ifaV(a4, a2);
        } else
        if(a2 != null)
            _charStringV("void", a2.getName());
    }

    private void _anV(net.rim.tools.compiler.analysis.InstructionNameAndType n1, net.rim.tools.compiler.types.Method c1)
	throws net.rim.tools.compiler.util.i
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        int j = n1.getOpcode();
        int i1 = c1.getNumParameters();
        for(int j1 = i1 - 1; j1 >= 0; j1--)
        {
            net.rim.tools.compiler.types.Type a1 = c1.getParameterType(j1);
            int k1 = 1;
            if(a1.isTwoWord())
                k1++;
            net.rim.tools.compiler.types.Type a3 = d1._aYIa(k1);
            if(!a3._doaZ(a1))
                _ifaV(a3, a1);
        }

        if(c1._fKvZ())
        {
            Object obj = d1._aYIa(1);
            if(j != 2)
                if((j == 5 || j == 6) && c1.is(16))
                {
                    if(obj instanceof net.rim.tools.compiler.types.ClassUninitializedType)
                    {
                        net.rim.tools.compiler.types.ClassUninitializedType l1 = (net.rim.tools.compiler.types.ClassUninitializedType)obj;
                        obj = l1.getClassType();
                        d1._aiV(l1);
                    }
                    net.rim.tools.compiler.types.ClassType g1 = c1.getClassType();
                    if(!((net.rim.tools.compiler.types.Type) (obj))._doaZ(g1))
                        _ifaV(((net.rim.tools.compiler.types.Type) (obj)), g1);
                } else
                {
                    if(j == 1 && ((net.rim.tools.compiler.types.Type) (obj)).equals(z_pvCompiler.getNullType()))
                        n1._eTvV();
                    net.rim.tools.compiler.types.ClassType g2 = c1.getClassType();
                    if(!((net.rim.tools.compiler.types.Type) (obj))._doaZ(g2))
                    {
                        n1._eTvV();
                        _ifaV(((net.rim.tools.compiler.types.Type) (obj)), g2);
                    }
                }
        }
        if(c1._fLvZ())
        {
            net.rim.tools.compiler.types.Type a2 = c1._fMva();
            d1._ifaV(a2);
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionNameAndType n1)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = 1;
            int i1 = n1.getOpcode();
            net.rim.tools.compiler.types.NameAndType k1 = n1.getNameAndType();
            net.rim.tools.compiler.types.Type a5 = k1.getType();
            try
            {
                switch(i1)
                {
                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
                    break;

                case 107: // 'k'
                case 108: // 'l'
                    j++;
                    // fall through

                case 105: // 'i'
                case 106: // 'j'
						net.rim.tools.compiler.types.Type a1 = d1._aYIa(j);
                    if(!a1._doaZ(a5))
                        _ifaV(a1, a5);
                    break;

                case 25: // '\031'
                case 26: // '\032'
                case 28: // '\034'
                case 29: // '\035'
                    if(!z_pBc._fLvZ())
                        _aaV(a5, "void type");
                    if(!a5._doaZ(z_pBc._fMva()))
                        _ifaV(a5, z_pBc._fMva());
                    break;

                case 99: // 'c'
                case 100: // 'd'
                case 101: // 'e'
                case 102: // 'f'
						net.rim.tools.compiler.types.Type a2 = d1._aYIa(j);
                    if(!a2._doaZ(k1.getClassType()))
                    {
                        n1._eTvV();
                        _ifaV(a2, k1.getClassType());
                    }
                    if(a2.equals(z_pvCompiler.getNullType()))
                        n1._eTvV();
                    // fall through

                case 109: // 'm'
                case 110: // 'n'
                case 111: // 'o'
                case 112: // 'p'
                    d1._ifaV(a5);
                    break;

                case 103: // 'g'
                case 104: // 'h'
                    d1._ifaV(a5);
                    z_pEaZ[0] = true;
                    break;

                case 97: // 'a'
                case 98: // 'b'
                    j++;
                    // fall through

                case 95: // '_'
                case 96: // '`'
						net.rim.tools.compiler.types.Type a3 = d1._aYIa(j);
                    if(!a3._doaZ(a5))
                        _ifaV(a3, a5);
                    a3 = d1._aYIa(1);
						net.rim.tools.compiler.types.ClassType g1 = k1.getClassType();
                    if(!a3._doaZ(g1))
                    {
                        boolean flag = false;
                        if(z_pBc.is(16))
                        {
                            ClassType g2 = z_pBc.getClassType();
                            if(a3 instanceof net.rim.tools.compiler.types.ClassUninitializedType)
                            {
                                net.rim.tools.compiler.types.ClassUninitializedType l1 = (net.rim.tools.compiler.types.ClassUninitializedType)a3;
                                if(l1._fsvI() == 0 && l1.getClassType().equals(g2) && g2.equals(g1))
                                    flag = true;
                            }
                        }
                        if(!flag)
                        {
                            n1._eTvV();
                            _ifaV(a3, g1);
                        }
                    }
                    if(a3.equals(z_pvCompiler.getNullType()))
                        n1._eTvV();
                    break;

                case 93: // ']'
                case 94: // '^'
						net.rim.tools.compiler.types.Type a4 = d1._aZIa(j);
                    if(!a4._doaZ(a5))
                        _ifaV(a4, a5);
                    a4 = d1._aZIa(0);
                    if(!a4._doaZ(k1.getClassType()))
                        _ifaV(a4, k1.getClassType());
                    d1._c1vV();
                    break;

                case 12: // '\f'
                case 13: // '\r'
						_agV(n1, (net.rim.tools.compiler.types.Method)k1);
                    break;

                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
						_anV(n1, (net.rim.tools.compiler.types.Method)k1);
                    break;

                case 14: // '\016'
                case 15: // '\017'
                case 16: // '\020'
                case 17: // '\021'
                case 18: // '\022'
                case 19: // '\023'
                case 20: // '\024'
                case 21: // '\025'
                case 22: // '\026'
                case 23: // '\027'
                case 24: // '\030'
                case 27: // '\033'
                case 30: // '\036'
                case 31: // '\037'
                case 32: // ' '
                case 33: // '!'
                case 34: // '"'
                case 35: // '#'
                case 36: // '$'
                case 37: // '%'
                case 38: // '&'
                case 39: // '\''
                case 40: // '('
                case 41: // ')'
                case 42: // '*'
                case 43: // '+'
                case 44: // ','
                case 45: // '-'
                case 46: // '.'
                case 47: // '/'
                case 48: // '0'
                case 49: // '1'
                case 50: // '2'
                case 51: // '3'
                case 52: // '4'
                case 53: // '5'
                case 54: // '6'
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
                case 71: // 'G'
                case 72: // 'H'
                case 73: // 'I'
                case 74: // 'J'
                case 75: // 'K'
                case 76: // 'L'
                case 77: // 'M'
                case 78: // 'N'
                case 79: // 'O'
                case 80: // 'P'
                case 81: // 'Q'
                case 82: // 'R'
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
                default:
                    unexpectedInstruction(n1);
                    break;
                }
            }
            catch(net.rim.tools.compiler.util.i j1)
            {
                if(k1 instanceof net.rim.tools.compiler.types.Method)
                    j1._aStringV("invoking " + ((net.rim.tools.compiler.types.Method)k1)._fWvString());
                else
                    j1._aStringV("accessing " + k1.getName());
                throw j1;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionString m)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = m.getOpcode();
            switch(j)
            {
            case 40: // '('
            case 42: // '*'
                d1._ifaV(z_pvCompiler.getStringClass());
                break;

            default:
                unexpectedInstruction(m);
                break;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionStringArray a1)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = a1.getOpcode();
            switch(j)
            {
            case 282:
                d1._ifaV(z_pvCompiler.getStringClass().getArrayType());
                break;

            default:
                unexpectedInstruction(a1);
                break;
            }
        }
        z_pzZ = false;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionType o1)
        throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.analysis.InstructionStackEntry d1 = z_pGd;
        if(d1 != null)
        {
            int j = o1.getOpcode();
            net.rim.tools.compiler.types.Type a3 = o1._e0va();
            int i1 = o1.getOp();
            switch(j)
            {
            case 19: // '\023'
            case 186:
            case 187:
                break;

            case 189:
            case 191:
            case 192:
            case 198:
            case 199:
                a3 = z_pFaa[1];
                // fall through

            case 190:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 200:
            case 201:
					net.rim.tools.compiler.types.Type a1 = d1._aYIa(1);
					if(!(a1 instanceof net.rim.tools.compiler.types.ReferenceType))
                    _aaV(a1, "reference type");
                d1._ifaV(a3);
                break;

            case 184:
            case 185:
					d1._ifaV(new net.rim.tools.compiler.types.ClassUninitializedType((net.rim.tools.compiler.types.ClassType)a3, o1.getOp()));
                break;

            case 168:
            case 169:
                i1 = 1;
                // fall through

            case 166:
            case 170:
            case 171:
                for(int j1 = i1; j1 > 0; j1--)
                {
                    net.rim.tools.compiler.types.Type a2 = d1._aYIa(1);
                    if(!a2._doaZ(z_pFaa[1]))
                        _aaV(a2, z_pFaa[1]);
                }

                d1._ifaV(a3);
                break;

            default:
                unexpectedInstruction(o1);
                break;
            }
        }
        z_pzZ = false;
    }
}
