// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.codfile.DataBytes;
import net.rim.tools.compiler.codfile.Code;
import net.rim.tools.compiler.codfile.Routine;
import net.rim.tools.compiler.codfile.CodfileLabel;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.Literal;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.FieldDef;
import net.rim.tools.compiler.codfile.RoutineLocal;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.ArrayType;
import net.rim.tools.compiler.types.TypeModule;

// Referenced classes of package net.rim.tools.compiler.g:
//            e, g, h, a,
//            j, l, i, n,
//            m, o, q

public final class InstructionPopulater extends InstructionWalker
{

    private Compiler z_pXCompiler;
    private TypeModule z_pTm;
    private net.rim.tools.compiler.types.Method z_pUc;
    private Code z_pWa4;
    private InstructionTarget _instructionTarget;

    InstructionPopulater()
    {
    }

    void init(Compiler compiler, net.rim.tools.compiler.types.Method c1, TypeModule m1)
        throws CompileException
    {
        z_pXCompiler = compiler;
        z_pTm = m1;
        z_pUc = c1;
        z_pWa4 = ((RoutineLocal)c1._ifCompilerr(compiler, m1)).getCode();
    }

    void fini()
    {
        z_pXCompiler = null;
        z_pTm = null;
        z_pUc = null;
        z_pWa4 = null;
        _instructionTarget = null;
    }

    public void walkInstruction(InstructionTarget x1)
        throws CompileException
    {
        _instructionTarget = x1;
        x1.setLabel(z_pWa4._bvva6());
    }

    public void walkInstruction(int i1, net.rim.tools.compiler.analysis.Instruction g1)
        throws CompileException
    {
        int j1 = g1._eOvI();
        if(j1 != 0)
        {
            CodfileLabel a6_1;
            if(i1 == 0)
                a6_1 = _instructionTarget.getLabel();
            else
                a6_1 = z_pWa4._bvva6();
            a6_1.setOffset(j1);
            z_pUc._ifa6V(a6_1);
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.Instruction g1)
        throws CompileException
    {
        int i1 = g1.getOpcode();
        switch(i1)
        {
        case 0: // '\0'
        case 14: // '\016'
        case 16: // '\020'
        case 18: // '\022'
        case 20: // '\024'
        case 24: // '\030'
        case 27: // '\033'
        case 30: // '\036'
        case 31: // '\037'
        case 32: // ' '
        case 33: // '!'
        case 34: // '"'
        case 35: // '#'
        case 44: // ','
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
        case 113: // 'q'
        case 114: // 'r'
        case 115: // 's'
        case 116: // 't'
        case 117: // 'u'
        case 118: // 'v'
        case 119: // 'w'
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
        case 132:
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
        case 167:
        case 172:
        case 173:
        case 174:
        case 175:
        case 176:
        case 177:
        case 178:
        case 179:
        case 180:
        case 181:
        case 182:
        case 183:
        case 188:
        case 202:
        case 203:
        case 204:
        case 205:
        case 206:
        case 207:
        case 208:
        case 209:
        case 210:
        case 211:
        case 212:
        case 213:
        case 215:
        case 216:
        case 217:
        case 218:
        case 221:
        case 250:
        case 256:
        case 257:
        case 258:
        case 259:
        case 260:
        case 261:
        case 262:
        case 263:
        case 264:
        case 265:
        case 266:
        case 267:
        case 268:
        case 269:
        case 270:
        case 271:
        case 272:
        case 273:
        case 274:
        case 275:
        case 276:
        case 277:
        case 278:
        case 279:
        case 280:
        case 281:
            z_pWa4.addByteCode(i1);
            break;

        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 49: // '1'
        case 50: // '2'
        case 51: // '3'
        case 52: // '4'
        case 53: // '5'
        case 54: // '6'
        case 71: // 'G'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 165:
            z_pWa4._tryIIV(i1, g1.getOp());
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

    public void walkInstruction(InstructionBranch q)
        throws CompileException
    {
        Object obj = null;
        int i1 = q.getOpcode();
        switch(i1)
        {
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
            InstructionTarget x1 = _instructionTarget._a5Ix(0);
            z_pWa4._aIObjectV(i1, x1);
            break;

        default:
            unexpectedInstruction(q);
            break;
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionInts h1)
        throws CompileException
    {
        int i1 = h1.getOpcode();
        switch(i1)
        {
        case 15: // '\017'
        case 17: // '\021'
            z_pWa4._aIaIV(i1, h1._eZvaI());
            break;

        case 47: // '/'
        case 163:
        case 164:
            int j1 = _instructionTarget._dsvI();
            Object aobj[] = new Object[j1];
            for(int k1 = 0; k1 < j1; k1++)
                aobj[k1] = _instructionTarget._a5Ix(k1);

            z_pWa4._aIaIaObjectV(i1, h1._eZvaI(), aobj, h1._eYvZ());
            break;

        default:
            unexpectedInstruction(h1);
            break;
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionStringArray a2)
        throws CompileException
    {
        int i1 = a2.getOpcode();
        switch(i1)
        {
        case 282:
            DataBytes a1_1 = z_pTm.getDataSection().getDataBytes();
            String as[] = a2.getStringArray();
            Literal ah[] = new Literal[as.length];
            for(int j1 = 0; j1 < as.length; j1++)
            {
                String s = as[j1];
                ah[j1] = a1_1.getLiteral(s, InstructionResolver._CStringZ(s), true);
            }

            z_pWa4._aIahV(i1, ah);
            break;

        default:
            unexpectedInstruction(a2);
            break;
        }
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionBytes l1)
        throws CompileException
    {
        DataBytes a1_1 = z_pTm.getDataSection().getDataBytes();
        int i1 = l1.getOpcode();
        int j1 = l1.getOp();
        net.rim.tools.compiler.codfile.Bytes a2 = null;
        switch(i1)
        {
        case 45: // '-'
            a2 = a1_1.getBytes(l1.getBytes(), j1, true);
            break;

        default:
            unexpectedInstruction(l1);
            break;
        }
        z_pWa4._aIIV(i1, j1, a2);
    }

    public void walkInstruction(InstructionLong i1)
        throws CompileException
    {
        int j1 = i1.getOpcode();
        switch(j1)
        {
        case 120: // 'x'
        case 121: // 'y'
            z_pWa4._aIIV(j1, i1.getOp(), (int)i1.getOp2());
            break;

        case 39: // '\''
            z_pWa4._aIJV(j1, i1.getOp2());
            break;

        default:
            unexpectedInstruction(i1);
            break;
        }
    }

    public void walkInstruction(InstructionNameAndType n1)
        throws CompileException
    {
        boolean flag = false;
        boolean flag1 = false;
        int _opcode_ = n1.getOpcode();
label0:
        switch(_opcode_)
        {
        case 7: // '\007'
        case 105: // 'i'
        case 107: // 'k'
        case 109: // 'm'
        case 111: // 'o'
            flag = true;
            // fall through

        case 8: // '\b'
        case 106: // 'j'
        case 108: // 'l'
        case 110: // 'n'
        case 112: // 'p'
            ClassDef u1 = n1.getClassType().getClassDef(z_pTm);
            net.rim.tools.compiler.codfile.Member r = n1.getNameAndType()._ifCompilerr(z_pXCompiler, z_pTm);
            if(flag)
            {
                _opcode_ += n1.getNameAndType().getClassType().getClassDef(z_pTm).getLibOff();
                n1._bLIV(_opcode_);
            }
            z_pWa4._aIuV(_opcode_, u1, r);
            break;

        case 25: // '\031'
        case 28: // '\034'
        case 93: // ']'
        case 95: // '_'
        case 97: // 'a'
        case 99: // 'c'
        case 101: // 'e'
        case 103: // 'g'
            flag1 = true;
            // fall through

        case 26: // '\032'
        case 29: // '\035'
        case 94: // '^'
        case 96: // '`'
        case 98: // 'b'
        case 100: // 'd'
        case 102: // 'f'
        case 104: // 'h'
				net.rim.tools.compiler.types.Field h1 = (net.rim.tools.compiler.types.Field)n1.getNameAndType();
            FieldDef w1 = (FieldDef)h1._ifCompilerr(z_pXCompiler, z_pTm);
            boolean flag2 = true;
            flag2 = n1._eVvZ() || h1.getAbsoluteOffset() == -1;
            if(flag2)
                w1.makeSymbolic(z_pTm.getDataSection());
            else
            if(flag1 && w1.getAddress() > 255)
            {
                _opcode_++;
                n1._bLIV(_opcode_);
            }
            z_pWa4._aIrV(_opcode_, w1, flag2);
            break;

        case 3: // '\003'
        case 5: // '\005'
        case 12: // '\f'
            flag = true;
            // fall through

        case 4: // '\004'
        case 6: // '\006'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 13: // '\r'
				net.rim.tools.compiler.types.Method c1 = (net.rim.tools.compiler.types.Method)n1.getNameAndType();
            ClassDef u2 = n1.getClassType().getClassDef(z_pTm);
            if(flag)
            {
                _opcode_ += c1.getClassType().getClassDef(z_pTm).getLibOff();
                n1._bLIV(_opcode_);
            }
            Routine a5_1 = (Routine)c1._ifCompilerr(z_pXCompiler, z_pTm);
            z_pWa4._aIrV(_opcode_, a5_1, false);
            break;

        case 1: // '\001'
				net.rim.tools.compiler.types.Method c2 = (net.rim.tools.compiler.types.Method)n1.getNameAndType();
            switch(c2._fPvI())
            {
            case 2: // '\002'
                z_pWa4.addByteCode(218);
                break label0;

            case 1: // '\001'
                z_pWa4.addByteCode(217);
                break label0;
            }
            ClassDef u3 = n1.getClassType().getClassDef(z_pTm);
            Routine a5_2 = (Routine)c2._ifCompilerr(z_pXCompiler, z_pTm);
            int k1 = _opcode_;
            boolean flag3 = true;
            flag3 = n1._eVvZ() || c2._bCompilerI(z_pXCompiler) == -1;
            if(!flag3 && c2._fSvZ() && !z_pXCompiler._dvZ())
            {
                int l1 = c2._fIvI();
                int i2 = c2._bCompilerI(z_pXCompiler);
                if(i2 >= 0 && i2 < 64 && l1 > 0 && l1 < 5)
                    k1 = 222;
            }
            if(k1 == _opcode_ && !c2._longgZ(n1.getClassType()))
            {
                k1 = 3;
                k1 += c2.getClassType().getClassDef(z_pTm).getLibOff();
                flag3 = false;
            }
            if(k1 != _opcode_)
            {
                _opcode_ = k1;
                n1._bLIV(_opcode_);
            }
            if(flag3)
            {
                DataSection k2 = z_pTm.getDataSection();
                u3.getClassRef(k2);
                a5_2.makeSymbolic(k2, false);
            }
            z_pWa4._aIrV(_opcode_, a5_2, flag3);
            break;

        case 2: // '\002'
				net.rim.tools.compiler.types.Method c3 = (net.rim.tools.compiler.types.Method)n1.getNameAndType();
            net.rim.tools.compiler.codfile.InterfaceMethodRef az = c3._forCompileraz(z_pXCompiler, z_pTm);
            int j1 = c3._amI(z_pTm, z_pUc);
            z_pWa4._aIIIV(_opcode_, n1.getOp(), j1, az);
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

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionString m1)
        throws CompileException
    {
        DataBytes a1_1 = z_pTm.getDataSection().getDataBytes();
        int i1 = m1.getOpcode();
        Object obj = null;
        switch(i1)
        {
        case 40: // '('
        case 42: // '*'
            String s = m1.getString();
            if(s.length() == 0 && !z_pXCompiler._dvZ())
            {
                z_pWa4.addByteCode(223);
            } else
            {
                Literal h1 = a1_1.getLiteral(m1.getString(), i1 == 42, true);
                z_pWa4._aIhV(i1, h1);
            }
            break;

        default:
            unexpectedInstruction(m1);
            break;
        }
    }

    public void walkInstruction(InstructionType o1)
        throws CompileException
    {
        boolean flag = false;
        Object obj = null;
        net.rim.tools.compiler.types.Type a2 = o1._e0va();
        int i1 = o1.getOpcode();
        switch(i1)
        {
        case 184:
        case 186:
        case 191:
        case 193:
            flag = true;
            // fall through

        case 19: // '\023'
        case 185:
        case 187:
        case 192:
        case 194:
            ClassType g1 = (ClassType)a2;
            ClassDef u1 = g1.getClassDef(z_pTm);
            if(flag)
            {
                i1 += u1.getLibOff();
                o1._bLIV(i1);
            }
            z_pWa4._aIuV(i1, u1, 0);
            break;

        case 168:
            flag = true;
            // fall through

        case 169:
            ArrayType l1 = (ArrayType)a2;
            ClassType g2 = (ClassType)l1.getMostBaseType();
            ClassDef u2 = g2.getClassDef(z_pTm);
            if(flag)
            {
                i1 += u2.getLibOff();
                o1._bLIV(i1);
            }
            z_pWa4._aIuV(i1, u2, 0);
            break;

        case 189:
        case 190:
            ArrayType l2 = (ArrayType)a2;
            z_pWa4._aIIV(i1, l2.getNesting(), l2.getMostBaseType().getTypeId());
            break;

        case 198:
        case 200:
            flag = true;
            // fall through

        case 199:
        case 201:
            ArrayType l3 = (ArrayType)a2;
            ClassType g3 = (ClassType)l3.getMostBaseType();
            ClassDef u3 = g3.getClassDef(z_pTm);
            if(flag)
            {
                i1 += u3.getLibOff();
                o1._bLIV(i1);
            }
            z_pWa4._aIuV(i1, u3, l3.getNesting());
            break;

        case 166:
            ArrayType l4 = (ArrayType)a2;
            z_pWa4._ifIIIV(i1, o1.getOp(), l4.getNesting(), l4.getMostBaseType().getTypeId());
            break;

        case 170:
            flag = true;
            // fall through

        case 171:
            ArrayType l5 = (ArrayType)a2;
            ClassType g4 = (ClassType)l5.getMostBaseType();
            ClassDef u4 = g4.getClassDef(z_pTm);
            if(flag)
            {
                i1 += u4.getLibOff();
                o1._bLIV(i1);
            }
            z_pWa4._aIIIV(i1, o1.getOp(), l5.getNesting(), u4);
            break;

        case 195:
            flag = true;
            // fall through

        case 196:
            ClassType g5 = (ClassType)a2;
            ClassDef u5 = g5.getClassDef(z_pTm);
            InstructionTarget x1 = _instructionTarget._a5Ix(0);
            if(flag)
            {
                i1 += u5.getLibOff();
                o1._bLIV(i1);
            }
            z_pWa4._aIuV(i1, u5, x1);
            break;

        case 197:
            ArrayType l6 = (ArrayType)a2;
            InstructionTarget x2 = _instructionTarget._a5Ix(0);
            z_pWa4._aIIIV(i1, l6.getNesting(), l6.getMostBaseType().getTypeId(), x2);
            break;

        default:
            unexpectedInstruction(o1);
            break;
        }
    }
}
