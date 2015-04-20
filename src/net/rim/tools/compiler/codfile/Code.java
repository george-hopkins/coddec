// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.vm.OpcodeSize;
import net.rim.tools.compiler.exec.MyArrays;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.a.coddec;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, a6, h, f,
//            u, r, a5, z,
//            az, k, a1

public final class Code extends net.rim.tools.compiler.codfile.CodfileItem
implements net.rim.tools.compiler.vm.Constants
{

    private int _opcodesNum;
    private byte _opcodes[];
    private int _constants[];
    private short _parametersIndex[];
    private net.rim.tools.compiler.codfile.CodfileLabel _labels[];
    private short z_hPS;
    private Object _objectRefs[];
    private boolean z_hUZ;
    private boolean _aliasesFlag;
    private int _linesMap[];

    public Code()
    {
    }

    public Code(net.rim.tools.compiler.io.StructuredInputStream __input, int __codeSize, net.rim.tools.compiler.codfile.DataSection __dataSection, net.rim.tools.compiler.codfile.RoutineLocal z1, boolean flag)
        throws IOException
    {
        super(__input);
        setExtent(__codeSize);
        if(flag)
        {
            __input.skipBytes(__codeSize);
        } else
        {
            net.rim.tools.compiler.codfile.DataBytes _dataBytes_ = __dataSection.getDataBytes();
            _aliasesFlag = __dataSection.getAliasesFlag();
            _opcodes = new byte[super._extent];
            _constants = new int[super._extent];
            _parametersIndex = new short[super._extent];
            _linesMap = new int[super._extent];
            boolean flag1 = __dataSection._YvZ();
            int j = 0;
            int _offset_ = super._offset;
            for(int _currentOffset_ = _offset_ + __codeSize; _offset_ < _currentOffset_; _offset_ = __input.getOffset())
            {
                _linesMap[_offset_ - super._offset] = j != 0 ? 0 : _opcodesNum + 1;
                int _opcode_ = __input.readUnsignedByte() + j;
                j = 0;
                boolean flag2 = false;
                int l1 = 0;
                boolean flag3 = false;
                switch(_opcode_)
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
                case 217:
                case 218:
                case 221:
                case 223:
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
                    break;

                case 216:
                    j = 256;
                    break;

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
                    _offset_ = __input.getOffset();
						net.rim.tools.compiler.codfile.CodfileLabel a6_1 = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readByte() + _offset_) - super._offset);
                    _parametersIndex[_opcodesNum] = addObjectRef(a6_1);
                    break;

                case 162:
                    _offset_ = __input.getOffset();
						CodfileLabel a6_2 = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readShort() + _offset_) - super._offset);
                    _parametersIndex[_opcodesNum] = addObjectRef(a6_2);
                    break;

                case 49: // '1'
                case 51: // '3'
                case 53: // '5'
                case 71: // 'G'
                case 73: // 'I'
                case 75: // 'K'
                case 165:
                    _constants[_opcodesNum] = __input.readUnsignedByte();
                    break;

                case 21: // '\025'
                case 36: // '$'
                    _constants[_opcodesNum] = __input.readByte();
                    break;

                case 22: // '\026'
                case 37: // '%'
                    _constants[_opcodesNum] = __input.readShort();
                    break;

                case 50: // '2'
                case 52: // '4'
                case 54: // '6'
                case 72: // 'H'
                case 74: // 'J'
                case 76: // 'L'
                    _constants[_opcodesNum] = __input.readUnsignedShort();
                    break;

                case 23: // '\027'
                case 38: // '&'
                    _constants[_opcodesNum] = __input.readInt();
                    break;

                case 282:
                    int l2 = __input.readUnsignedShort();
                    Literal ah[] = new Literal[l2];
                    for(int k4 = 0; k4 < l2; k4++)
                    {
                        _offset_ = __input.readUnsignedShort();
                        int j5 = _dataBytes_._agII(_offset_);
                        ah[k4] = _dataBytes_.createSibling(_offset_, j5 == 3, true, false);
                    }

                    _parametersIndex[_opcodesNum] = addObjectRef(ah);
                    break;

                case 45: // '-'
                    _constants[_opcodesNum] = __input.readUnsignedByte();
                    int i3 = __input.readUnsignedShort();
                    _parametersIndex[_opcodesNum] = addObjectRef(_dataBytes_._aIIa(__input.readUnsignedShort(), i3, true));
                    break;

                case 15: // '\017'
                case 17: // '\021'
                    int j3 = __input.readUnsignedByte();
                    int j4 = __input.readUnsignedByte();
                    int l4 = __input.readUnsignedByte();
                    _ifIIV(j3, j4, l4);
                    z1.setNumLocals(z1.getMaxLocals() + (j3 << 8));
                    z1.setNumStack(z1.getStackMaps() + (l4 << 8));
                    break;

                case 163:
                    flag2 = true;
                    // fall through

                case 164:
                    int k3 = __input.readUnsignedShort();
                    _offset_ = __input.getOffset();
                    int ai[] = new int[k3];
                    CodfileLabel aa6[] = new CodfileLabel[k3 + 1];
                    for(int k5 = 0; k5 < k3; k5++)
                    {
                        if(flag2)
                        {
                            ai[k5] = __input.readShort();
                            _offset_ += 2;
                        } else
                        {
                            ai[k5] = __input.readInt();
                            _offset_ += 4;
                        }
                        aa6[k5 + 1] = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readShort() + _offset_) - super._offset);
                        _offset_ += 2;
                    }

						aa6[0] = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readShort() + _offset_) - super._offset);
                    _parametersIndex[_opcodesNum] = addObjectRef(ai);
                    addObjectRef(aa6);
                    break;

                case 47: // '/'
                    int l3 = __input.readUnsignedShort();
                    _offset_ = __input.getOffset();
                    int ai1[] = new int[2];
					net.rim.tools.compiler.codfile.CodfileLabel aa6_1[] = new net.rim.tools.compiler.codfile.CodfileLabel[l3];
                    ai1[0] = l3;
                    ai1[1] = __input.readInt();
                    _offset_ += 4;
                    for(int l5 = 0; l5 < l3; l5++)
                    {
                        aa6_1[l5] = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readShort() + _offset_) - super._offset);
                        _offset_ += 2;
                    }

                    _parametersIndex[_opcodesNum] = addObjectRef(ai1);
                    addObjectRef(aa6_1);
                    break;

                case 120: // 'x'
                case 189:
                case 190:
                    _doIIV(__input.readUnsignedByte(), __input.readByte());
                    break;

                case 121: // 'y'
                    _doIIV(__input.readUnsignedShort(), __input.readShort());
                    break;

                case 39: // '\''
                    _parametersIndex[_opcodesNum] = addObjectRef(new Long(__input.readLong()));
                    break;

                case 106: // 'j'
                case 108: // 'l'
                case 110: // 'n'
                case 112: // 'p'
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 105: // 'i'
                case 107: // 'k'
                case 109: // 'm'
                case 111: // 'o'
                    int i4 = __input.readUnsignedByte();
                    int i2 = __input.readUnsignedShort();
						net.rim.tools.compiler.codfile.ClassDef u1;
						net.rim.tools.compiler.codfile.FieldDef w;
                    if(l1 != 255)
                    {
                        u1 = __dataSection.getClassDef(l1, i4);
                        w = u1.createFieldDef(i2, true);
                    } else
                    {
                        w = __dataSection.getFieldDef(i2);
                        u1 = w.getClassDef();
                    }
                    _parametersIndex[_opcodesNum] = addObjectRef(u1);
                    addObjectRef(w);
                    break;

                case 25: // '\031'
                case 28: // '\034'
                case 93: // ']'
                case 95: // '_'
                case 97: // 'a'
                case 99: // 'c'
                case 101: // 'e'
                case 103: // 'g'
                    int j2 = flag1 ? __input.readUnsignedByte() : ((int) (__input.readByte()));
                    _parametersIndex[_opcodesNum] = addObjectRef(__dataSection._tIw(j2));
                    break;

                case 26: // '\032'
                case 29: // '\035'
                case 94: // '^'
                case 96: // '`'
                case 98: // 'b'
                case 100: // 'd'
                case 102: // 'f'
                case 104: // 'h'
                    int k2 = (flag1 ? __input.readUnsignedByte() : __input.readByte()) + 256;
                    _parametersIndex[_opcodesNum] = addObjectRef(__dataSection._tIw(k2));
                    break;

                case 8: // '\b'
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 7: // '\007'
						net.rim.tools.compiler.codfile.ClassDef u2 = __dataSection.getClassDef(l1, __input.readUnsignedByte());
						net.rim.tools.compiler.codfile.Routine a5_1 = __dataSection.getRoutine(l1, __input.readUnsignedShort(), u2);
                    _parametersIndex[_opcodesNum] = addObjectRef(u2);
                    addObjectRef(a5_1);
                    break;

                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
						net.rim.tools.compiler.codfile.RoutineLocal z2 = z1;
                    z2.setLocalCount(__input.readUnsignedByte());
                    __input.readUnsignedShort();
                    _parametersIndex[_opcodesNum] = addObjectRef(z2);
                    break;

                case 13: // '\r'
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 12: // '\f'
						net.rim.tools.compiler.codfile.Routine a5_2 = __dataSection.getRoutine(l1, __input.readUnsignedShort(), null);
                    _parametersIndex[_opcodesNum] = addObjectRef(a5_2);
                    break;

                case 4: // '\004'
                case 6: // '\006'
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 3: // '\003'
                case 5: // '\005'
						net.rim.tools.compiler.codfile.Routine a5_3 = __dataSection.getRoutine(l1, __input.readUnsignedShort(), null);
                    a5_3.setLocalCount(__input.readUnsignedByte());
                    _parametersIndex[_opcodesNum] = addObjectRef(a5_3);
                    break;

                case 1: // '\001'
						net.rim.tools.compiler.codfile.Routine a5_4 = __dataSection._yIa5(__input.readShort());
                    a5_4.setLocalCount(__input.readUnsignedByte());
                    _parametersIndex[_opcodesNum] = addObjectRef(a5_4);
                    break;

                case 222:
                    int i5 = __input.readUnsignedByte();
                    int i6 = i5 >> 2;
                    i5 &= 3;
                    i5++;
						net.rim.tools.compiler.codfile.Routine a5_5 = __dataSection._yIa5(i6);
                    a5_5.setLocalCount(i5);
                    _parametersIndex[_opcodesNum] = addObjectRef(a5_5);
                    break;

                case 2: // '\002'
                    _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.getInterfaceMethodRef(__input.readUnsignedShort()));
                    _doIIV(__input.readUnsignedByte(), __input.readUnsignedShort());
                    break;

                case 42: // '*'
                    __input.readUnsignedShort();
                    // fall through

                case 40: // '('
                    _parametersIndex[_opcodesNum] = addObjectRef(_dataBytes_.createSibling(__input.readUnsignedShort(), (byte)_opcode_ == 42, true, false));
                    break;

                case 169:
                case 185:
                case 187:
                case 192:
                case 194:
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 19: // '\023'
                case 168:
                case 184:
                case 186:
                case 191:
                case 193:
                    if(_aliasesFlag)
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.findClassDef(l1, __input.readUnsignedByte()));
                    else
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.getClassDef(l1, __input.readUnsignedByte()));
                    break;

                case 199:
                case 201:
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 198:
                case 200:
                    if(_aliasesFlag)
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.findClassDef(l1, __input.readUnsignedByte()));
                    else
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.getClassDef(l1, __input.readUnsignedByte()));
                    _constants[_opcodesNum] = __input.readUnsignedByte();
                    break;

                case 166:
                    _ifIIV(__input.readUnsignedByte(), __input.readUnsignedByte(), __input.readUnsignedByte());
                    break;

                case 171:
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 170:
                    if(_aliasesFlag)
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.findClassDef(l1, __input.readUnsignedByte()));
                    else
                        _parametersIndex[_opcodesNum] = addObjectRef(__dataSection.getClassDef(l1, __input.readUnsignedByte()));
                    _doIIV(__input.readUnsignedByte(), __input.readUnsignedByte());
                    break;

                case 196:
                    l1 = __input.readUnsignedByte();
                    // fall through

                case 195:
						net.rim.tools.compiler.codfile.ClassDef u3;
                    if(_aliasesFlag)
                        u3 = __dataSection.findClassDef(l1, __input.readUnsignedByte());
                    else
                        u3 = __dataSection.getClassDef(l1, __input.readUnsignedByte());
                    _offset_ = __input.getOffset();
						net.rim.tools.compiler.codfile.CodfileLabel a6_3 = new CodfileLabel((__input.readShort() + _offset_) - super._offset);
                    _parametersIndex[_opcodesNum] = addObjectRef(u3);
                    addObjectRef(a6_3);
                    break;

                case 197:
                    _doIIV(__input.readUnsignedByte(), __input.readUnsignedByte());
                    _offset_ = __input.getOffset();
						net.rim.tools.compiler.codfile.CodfileLabel a6_4 = new net.rim.tools.compiler.codfile.CodfileLabel((__input.readShort() + _offset_) - super._offset);
                    _parametersIndex[_opcodesNum] = addObjectRef(a6_4);
                    break;

                case 41: // ')'
                case 43: // '+'
                case 46: // '.'
                case 48: // '0'
                case 214:
                case 219:
                case 220:
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
                    throw new RuntimeException("Unexpected opcode: " + _opcode_ + " at offset: " + _offset_);
                }
                _opcodes[_opcodesNum] = (byte)_opcode_;
                _opcodesNum++;
            }

        }
        __input.verifyOffset(super._offset + super._extent, "routine end of code");
    }

    private int getBranchTarget(net.rim.tools.compiler.codfile.CodfileLabel __label, net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        int i = (super._offset + __label.getEnd()) - __output.getOffset();
        if(i < -32768 || i >= 32768)
            throw new IOException("branch target out of range");
        else
            return i;
    }

    private void writeTableSwitch(net.rim.tools.compiler.io.StructuredOutputStream __output, int __objectRefs[], net.rim.tools.compiler.codfile.CodfileLabel __labels[], int i, int __tableSwitch[])
        throws IOException
    {
        __output.writeByte(47, net.rim.tools.compiler.vm.Opcodes.opcodes[47], false);
        if(i != 0)
            i = -1;
        else
            i = _aaII(__objectRefs);
        __output.writeShort(i, "tablesize=", true);
        int j = __objectRefs[0] - 1;
        __output.writeInt(j, "low=", true);
        __output.writeString("table 0 default");
        __output.empty_func7();
        __output.empty_func();
        int l = __objectRefs.length;
        j--;
        for(int k1 = 0; k1 < l; k1++)
        {
            for(int l1 = __objectRefs[k1] - j; --l1 > 0;)
            {
                int i1 = getBranchTarget(__labels[0], __output);
                __output.empty_func4(i1, 2);
                __output.writeShort(i1);
                __output.empty_func7();
            }

            int j1 = getBranchTarget(__labels[k1 + 1], __output);
            __output.empty_func4(j1, 2);
            __output.writeShort(j1);
            __output.empty_func7();
            j = __objectRefs[k1];
        }

        __output.empty_func7();
        __output.empty_func2();
    }

    private void WriteLookupSwitch(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean __isShortCall, int __objectRefs[], net.rim.tools.compiler.codfile.CodfileLabel __labels[], int i, int[] __lookupSwitch)
        throws IOException
    {
        char c2 = __isShortCall ? '\243' : '\244';
        __output.writeByte(c2, net.rim.tools.compiler.vm.Opcodes.opcodes[c2], false);
        int _labelsNum_ = __objectRefs.length;
        if(i != 0)
            i = -1;
        else
            i = _labelsNum_;
        __output.writeShort(i, "entries=", true);
        __output.empty_func7();
        __output.empty_func();
        for(int _labelIndex_ = 0; _labelIndex_ < _labelsNum_; _labelIndex_++)
        {
            if(__isShortCall)
                __output.writeShort(__objectRefs[_labelIndex_], "value=", true);
            else
                __output.writeInt(__objectRefs[_labelIndex_], "value=", true);
			
            int l = getBranchTarget(__labels[_labelIndex_ + 1], __output);
			__lookupSwitch[_linesMap[l]] = __objectRefs[_labelIndex_];
            __output.empty_func4(l, 2);
            __output.writeShort(l);
            __output.empty_func7();
        }

        int i1 = getBranchTarget(__labels[0], __output);
        __output.writeString("default ");
        __output.empty_func4(i1, 2);
        __output.writeShort(i1);
        __output.empty_func7();
        __output.empty_func2();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        byte _opcodes_[] = _opcodes;
        int _constants_[] = _constants;
		int[] _tableSwitch_ = new int [_opcodesNum];
        setOffset(__output);
        int _numOpcodes_ = _opcodesNum;
        int j = 0;
        for(int _index_ = 0; _index_ < _numOpcodes_; _index_++)
        {
            int _opcode_ = (_opcodes_[_index_] & 0xff) + j;
            j = 0;
            boolean flag = false;
            switch(_opcode_)
            {
            case 163:
                flag = true;
                // fall through

            case 164:
                int _tableSwitchObjectRefs_[] = (int[])getObjectRef(_index_, 0);
					net.rim.tools.compiler.codfile.CodfileLabel _tableSwitchLabels_[] = (net.rim.tools.compiler.codfile.CodfileLabel[])getObjectRef(_index_, 1);
                byte byte0 = ((byte)(flag ? 2 : 4));
                int j1 = _tableSwitchObjectRefs_.length * (byte0 + 2);
                int k3 = 5 + j1;
                j1 = _aaII(_tableSwitchObjectRefs_);
                j1 = 2 * j1;
                int i4 = 7 + j1;
                if(_aliasesFlag && i4 <= k3 && _constants_[_index_] == 0)
                    writeTableSwitch(__output, _tableSwitchObjectRefs_, _tableSwitchLabels_, _constants_[_index_], _tableSwitch_);
                else
                    WriteLookupSwitch(__output, flag, _tableSwitchObjectRefs_, _tableSwitchLabels_, _constants_[_index_], _tableSwitch_);
                break;

            default:
                __output.writeByte(_opcode_, net.rim.tools.compiler.vm.Opcodes.opcodes[_opcode_], false);
                switch(_opcode_)
                {
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
                case 41: // ')'
                case 43: // '+'
                case 44: // ','
                case 46: // '.'
                case 48: // '0'
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
                case 163:
                case 164:
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
                case 214:
                case 215:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
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
                case 250:
                case 251:
                case 252:
                case 253:
                case 254:
                case 255:
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
                default:
                    break;

                case 216:
                    j = 256;
                    break;

                case 49: // '1'
                case 51: // '3'
                case 53: // '5'
                case 71: // 'G'
                case 73: // 'I'
                case 75: // 'K'
                    __output.writeByte(_constants_[_index_], "local=", true);
                    break;

                case 21: // '\025'
                case 36: // '$'
                    __output.writeByte(_constants_[_index_], "value=", true);
                    break;

                case 165:
                    __output.writeByte(_constants_[_index_], "type=", true);
                    break;

                case 22: // '\026'
                case 37: // '%'
                case 50: // '2'
                case 52: // '4'
                case 54: // '6'
                case 72: // 'H'
                case 74: // 'J'
                case 76: // 'L'
                    __output.writeShort(_constants_[_index_], "value=", true);
                    break;

                case 23: // '\027'
                case 38: // '&'
                    __output.writeInt(_constants_[_index_], "value=", true);
                    break;

                case 42: // '*'
						net.rim.tools.compiler.codfile.Literal _literal_ = (net.rim.tools.compiler.codfile.Literal)getObjectRef(_index_, 0);
                    __output.writeShort(_literal_.length(), "length=", true);
                    _literal_.writeOffset(__output);
                    break;

                case 40: // '('
						net.rim.tools.compiler.codfile.Literal _literal_1_ = (net.rim.tools.compiler.codfile.Literal)getObjectRef(_index_, 0);
                    _literal_1_.writeOffset(__output);
                    break;

                case 45: // '-'
						net.rim.tools.compiler.codfile.CodfileData _data_ = (net.rim.tools.compiler.codfile.CodfileData)getObjectRef(_index_, 0);
                    __output.writeByte(_constants_[_index_], "type=", true);
                    __output.writeShort(_data_.length(), "length=", true);
                    _data_.writeOffset(__output);
                    break;

                case 282:
						net.rim.tools.compiler.codfile.Literal _literals_[] = (net.rim.tools.compiler.codfile.Literal[])getObjectRef(_index_, 0);
                    __output.writeShort(_literals_.length, "length=", true);
                    for(int j4 = 0; j4 < _literals_.length; j4++)
                        _literals_[j4].writeOffset(__output);

                    break;

                case 189:
                case 190:
                    __output.writeByte(_akII(_index_), "nesting=", true);
                    __output.writeByte(getValue(_index_), "type=", true);
                    break;

                case 120: // 'x'
                    __output.writeByte(_akII(_index_), "local=", true);
                    __output.writeByte(getValue(_index_), "value=", true);
                    break;

                case 121: // 'y'
                    __output.writeShort(_akII(_index_), "local=", true);
                    __output.writeShort(getValue(_index_), "value=", true);
                    break;

                case 39: // '\''
                    Long long1 = (Long)getObjectRef(_index_, 0);
                    __output.writeLong(long1.longValue(), "value=");
                    break;

                case 7: // '\007'
                case 8: // '\b'
                case 105: // 'i'
                case 106: // 'j'
                case 107: // 'k'
                case 108: // 'l'
                case 109: // 'm'
                case 110: // 'n'
                case 111: // 'o'
                case 112: // 'p'
						net.rim.tools.compiler.codfile.ClassDef _classDef_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
						net.rim.tools.compiler.codfile.Member _member_ = (net.rim.tools.compiler.codfile.Member)getObjectRef(_index_, 1);
                    _member_.writeStaticOffset(__output, _classDef_);
                    break;

                case 25: // '\031'
                case 26: // '\032'
                case 28: // '\034'
                case 29: // '\035'
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
						net.rim.tools.compiler.codfile.Member _member_1_ =((net.rim.tools.compiler.codfile.Member)getObjectRef(_index_, 0));
						_member_1_.writeMemberAddress(__output, _constants_[_index_] != 0);
                    break;

                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
						net.rim.tools.compiler.codfile.Routine _routine_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
                    __output.writeByte(_routine_.getLocalCount(), "parmcount=", true);
						((net.rim.tools.compiler.codfile.RoutineLocal)_routine_).writeNativeInvoke(__output);
                    break;

                case 12: // '\f'
                case 13: // '\r'
						net.rim.tools.compiler.codfile.Routine _routine_1_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
                    _routine_1_.writeOffset(__output);
                    break;

                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
						net.rim.tools.compiler.codfile.Routine _routine_2_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
                    _routine_2_.writeOffset(__output);
                    __output.writeByte(_routine_2_.getLocalCount(), "parmcount=", true);
                    break;

                case 1: // '\001'
						net.rim.tools.compiler.codfile.Routine _routine_3_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
                    _routine_3_.writeMemberAddress(__output, _constants_[_index_] != 0);
                    __output.writeByte(_routine_3_.getLocalCount(), "parmcount=", true);
                    break;

                case 222:
						net.rim.tools.compiler.codfile.Routine _routine_4_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
                    int l3 = _routine_4_.getVTableOffset(_constants_[_index_] != 0);
                    int k4 = _routine_4_.getAddress() << 2;
                    int l4 = _routine_4_.getLocalCount();
                    __output.empty_func10(_routine_4_.get_name_1(), ' ');
                    __output.writeString("index=");
                    __output.empty_func8(l3);
                    __output.writeString(" parmcount=");
                    __output.empty_func8(l4);
                    k4 |= l4 - 1;
                    __output.writeByte(k4);
                    break;

                case 2: // '\002'
						net.rim.tools.compiler.codfile.InterfaceMethodRef _interfaceMethod_ = (net.rim.tools.compiler.codfile.InterfaceMethodRef)getObjectRef(_index_, 0);
                    _interfaceMethod_.writeOffset(__output);
                    __output.writeByte(_akII(_index_), "parmcount=", true);
                    __output.writeShort(getValue(_index_), "guess=", true);
                    break;

                case 169:
                case 185:
                case 187:
                case 192:
                case 194:
						net.rim.tools.compiler.codfile.ClassDef _classDef_1_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    if(_aliasesFlag)
                        _classDef_1_.writeAbsoluteClassDef(__output);
                    else
                        _classDef_1_.writeOrdinal(__output);
                    break;

                case 19: // '\023'
                case 168:
                case 184:
                case 186:
                case 191:
                case 193:
						net.rim.tools.compiler.codfile.ClassDef _classDef_2_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    _classDef_2_.writeOrdinal(__output);
                    break;

                case 199:
                case 201:
						net.rim.tools.compiler.codfile.ClassDef _classDef_3_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    if(_aliasesFlag)
                        _classDef_3_.writeAbsoluteClassDef(__output);
                    else
                        _classDef_3_.writeOrdinal(__output);
                    __output.writeByte(_constants_[_index_], "nesting=", true);
                    break;

                case 198:
                case 200:
						net.rim.tools.compiler.codfile.ClassDef _classDef_4_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    _classDef_4_.writeOrdinal(__output);
                    __output.writeByte(_constants_[_index_], "nesting=", true);
                    break;

                case 166:
                    __output.writeByte(_apII(_index_), "dimensions=", true);
                    __output.writeByte(_alII(_index_), "nesting=", true);
                    __output.writeByte(_ajII(_index_), "type=", true);
                    break;

                case 171:
						net.rim.tools.compiler.codfile.ClassDef _classDef_5_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    if(_aliasesFlag)
                        _classDef_5_.writeAbsoluteClassDef(__output);
                    else
                        _classDef_5_.writeOrdinal(__output);
                    __output.writeByte(_akII(_index_), "dimensions=", true);
                    __output.writeByte(getValue(_index_), "nesting=", true);
                    break;

                case 170:
						net.rim.tools.compiler.codfile.ClassDef _classDef_6_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
                    _classDef_6_.writeOrdinal(__output);
                    __output.writeByte(_akII(_index_), "dimensions=", true);
                    __output.writeByte(getValue(_index_), "nesting=", true);
                    break;

                case 196:
						net.rim.tools.compiler.codfile.ClassDef _classDef_7_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
						net.rim.tools.compiler.codfile.CodfileLabel _label_1_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 1);
                    if(_aliasesFlag)
                        _classDef_7_.writeAbsoluteClassDef(__output);
                    else
                        _classDef_7_.writeOrdinal(__output);
                    int k1 = getBranchTarget(_label_1_, __output);
                    __output.empty_func4(k1, 2);
                    __output.writeShort(k1);
                    break;

                case 195:
						net.rim.tools.compiler.codfile.ClassDef _classDef_8_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
						net.rim.tools.compiler.codfile.CodfileLabel _label_2_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 1);
                    _classDef_8_.writeOrdinal(__output);
                    int l1 = getBranchTarget(_label_2_, __output);
                    __output.empty_func4(l1, 2);
                    __output.writeShort(l1);
                    break;

                case 197:
						net.rim.tools.compiler.codfile.CodfileLabel _label_3_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
                    __output.writeByte(_akII(_index_), "nesting=", true);
                    __output.writeByte(getValue(_index_), "type=", true);
                    int i2 = getBranchTarget(_label_3_, __output);
                    __output.empty_func4(i2, 2);
                    __output.writeShort(i2);
                    break;

                case 47: // '/'
                    int ai2[] = (int[])getObjectRef(_index_, 0);
						net.rim.tools.compiler.codfile.CodfileLabel _labels_1_[] = (net.rim.tools.compiler.codfile.CodfileLabel[])getObjectRef(_index_, 1);
                    int i5 = _labels_1_.length;
                    if(_constants_[_index_] != 0)
                        i5 = -1;
                    __output.writeShort(i5, "tablesize=", true);
                    __output.writeInt(ai2[1], "low=", true);
                    i5 = _labels_1_.length;
                    __output.writeString("table 0 default");
                    __output.empty_func7();
                    __output.empty_func();
                    for(int j5 = 0; j5 < i5; j5++)
                    {
                        int j2 = getBranchTarget(_labels_1_[j5], __output);
                        __output.empty_func4(j2, 2);
                        __output.writeShort(j2);
                        __output.empty_func7();
                    }

                    __output.empty_func7();
                    __output.empty_func2();
                    break;

                case 15: // '\017'
                case 17: // '\021'
                    __output.writeByte(_apII(_index_), "locals(hibyte)=", true);
                    __output.writeByte(_alII(_index_), "parameters(hibyte)=", true);
                    __output.writeByte(_ajII(_index_), "stack(hibyte)=", true);
                    break;

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
						net.rim.tools.compiler.codfile.CodfileLabel _label_4_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
                    if(_constants_[_index_] == 0)
                    {
                        int k2 = getBranchTarget(_label_4_, __output);
                        __output.empty_func4(k2, 2);
                        __output.writeByte(k2);
                    } else
                    {
                        int l2 = 4;
                        __output.empty_func4(l2, 2);
                        __output.writeByte(l2);
                        __output.empty_func7();
                        char c2 = '\242';
                        __output.writeByte(c2, net.rim.tools.compiler.vm.Opcodes.opcodes[c2], false);
                        l2 = getBranchTarget(_label_4_, __output);
                        __output.empty_func4(l2, 2);
                        __output.writeShort(l2);
                    }
                    break;

                case 161:
						net.rim.tools.compiler.codfile.CodfileLabel _lable_5_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
                    int i3 = getBranchTarget(_lable_5_, __output);
                    __output.empty_func4(i3, 2);
                    __output.writeByte(i3);
                    break;

                case 162:
						net.rim.tools.compiler.codfile.CodfileLabel _label_6_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
                    int j3 = getBranchTarget(_label_6_, __output);
                    __output.empty_func4(j3, 2);
                    __output.writeShort(j3);
                    break;
                }
                __output.empty_func7();
                break;
            }
        }

        setExtent(__output);
    }
	
	public void disassemble (net.rim.tools.compiler.io.StructuredOutputStream __output, StringBuffer __message)
	throws IOException
    {
		StringBuffer _source_ = new StringBuffer();
        byte _opcodes_[] = _opcodes;
        int _constants_[] = _constants;
		int _tableSwitch_[] = new int [_opcodesNum] ;
		int _lookupSwitch_[] = new int [_opcodesNum];
        setOffset(__output);
        int _numOpcodes_ = _opcodesNum;
        int j = 0;
        for(int _index_ = 0; _index_ < _numOpcodes_; _index_++)
        {
            int _opcode_ = (_opcodes_[_index_] & 0xff) + j;
            j = 0;
            boolean _longCallFlag_ = false;
            switch(_opcode_)
            {
				case 163:
					_longCallFlag_ = true;
					// fall through
					
				case 164:
					//int _tableSwitchObjectRefs_[] = (int[])getObjectRef(_index_, 0);
					//net.rim.tools.compiler.codfile.CodfileLabel _tableSwitchLabels_[] = (net.rim.tools.compiler.codfile.CodfileLabel[])getObjectRef(_index_, 1);
					//byte byte0 = ((byte)(_longCallFlag_ ? 2 : 4));
					//int j1 = _tableSwitchObjectRefs_.length * (byte0 + 2);
					//int k3 = 5 + j1;
					//j1 = _aaII(_tableSwitchObjectRefs_);
					//j1 = 2 * j1;
					//int i4 = 7 + j1;
					//if(_aliasesFlag && i4 <= k3 && _constants_[_index_] == 0)
					//{
						//writeTableSwitch(__output, _tableSwitchObjectRefs_, _tableSwitchLabels_, _constants_[_index_], _tableSwitch_);
						//_source_.append("\t");
						//_source_.append(_index_ + " : ");
						//_source_.append(net.rim.tools.compiler.vm.Opcodes.opcodes[47]+ " :");
						//_source_.append("\r\n");
					//}
					//else
					//{
						//WriteLookupSwitch(__output, _longCallFlag_, _tableSwitchObjectRefs_, _tableSwitchLabels_, _constants_[_index_], _lookupSwitch_);
						//_source_.append("\t");
						//_source_.append(_index_ + " : ");
						//char _lookupMode_ = _longCallFlag_? '\243': '\244';
						//_source_.append(net.rim.tools.compiler.vm.Opcodes.opcodes[_lookupMode_]+ " :");
						//_source_.append("\r\n");
						
						//for (int _lsIndex_ = 0; _lsIndex_ < _lookupSwitch_.length;_lsIndex_++)
						//{
						//	_source_.append("\t\t");
					//		_source_.append("\r\n");
					//	}
						
					//}
					break;
					
				default:
					__output.writeByte(_opcode_, net.rim.tools.compiler.vm.Opcodes.opcodes[_opcode_], false);
					_source_.append("\t");
					_source_.append(_index_ + " : ");
					_source_.append(net.rim.tools.compiler.vm.Opcodes.opcodes[_opcode_]+ " ");
					switch(_opcode_)
					{
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
						case 41: // ')'
						case 43: // '+'
						case 44: // ','
						case 46: // '.'
						case 48: // '0'
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
						case 163:
						case 164:
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
						case 214:
						case 215:
						case 217:
						case 218:
						case 219:
						case 220:
						case 221:
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
						case 250:
						case 251:
						case 252:
						case 253:
						case 254:
						case 255:
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
						default:
							break;
							
						case 216:
							j = 256;
							break;
							
						case 49: // '1'
						case 51: // '3'
						case 53: // '5'
						case 71: // 'G'
						case 73: // 'I'
						case 75: // 'K'
							//__output.writeByte(_constants_[_index_], "local=", true);
							_source_.append( _constants_[_index_]);
							break;
							
						case 21: // '\025'
						case 36: // '$'
							//__output.writeByte(_constants_[_index_], "value=", true);
							_source_.append( _constants_[_index_]);
							break;
							
						case 165:
							//__output.writeByte(_constants_[_index_], "type=", true);
							_source_.append( _constants_[_index_]);
							break;
							
						case 22: // '\026'
						case 37: // '%'
						case 50: // '2'
						case 52: // '4'
						case 54: // '6'
						case 72: // 'H'
						case 74: // 'J'
						case 76: // 'L'
							//__output.writeShort(_constants_[_index_], "value=", true);
							_source_.append(_constants_[_index_]);
							break;
							
						case 23: // '\027'
						case 38: // '&'
							//__output.writeInt(_constants_[_index_], "value=", true);
							_source_.append( _constants_[_index_]);
							break;
							
						case 42: // '*'
							net.rim.tools.compiler.codfile.Literal _literal_ = (net.rim.tools.compiler.codfile.Literal)getObjectRef(_index_, 0);
							//__output.writeShort(_literal_.length(), "length=", true);
							//_literal_.writeOffset(//__output);
							_source_.append(_literal_.get_name_1());
							break;
							
						case 40: // '('
							net.rim.tools.compiler.codfile.Literal _literal_1_ = (net.rim.tools.compiler.codfile.Literal)getObjectRef(_index_, 0);
							//_literal_1_.writeOffset(//__output);
							_source_.append(_literal_1_.get_name_1());
							break;
							
						case 45: // '-'
							net.rim.tools.compiler.codfile.CodfileData _data_ = (net.rim.tools.compiler.codfile.CodfileData)getObjectRef(_index_, 0);
							//__output.writeByte(_constants_[_index_], "type=", true);
							//__output.writeShort(_data_.length(), "length=", true);
							//_data_.writeOffset(//__output);
							_source_.append("[");
							for (int _dataIndex_ = 0; _dataIndex_ < _data_.length();_dataIndex_++)
								{
									_source_.append(_data_._bytes[_dataIndex_]);
									if (_dataIndex_ < _data_.length()-1)
									{
										_source_.append(", ");
									}
								}
							_source_.append("]");
							break;
							
						case 282:
							net.rim.tools.compiler.codfile.Literal _literals_[] = (net.rim.tools.compiler.codfile.Literal[])getObjectRef(_index_, 0);
							//__output.writeShort(_literals_.length, "length=", true);
							//for(int j4 = 0; j4 < _literals_.length; j4++)
							//	_literals_[j4].writeOffset(__output);
							_source_.append("[");
							for (int _literalsIndex_ = 0; _literalsIndex_ < _literals_.length;_literalsIndex_++)
							{
								_source_.append(_literals_[_literalsIndex_].getString());
								if (_literalsIndex_ < _literals_.length-1)
								{
									_source_.append(", ");
								}
							}
							_source_.append("]");
							
							break;
							
						case 189:
						case 190:
							__output.writeByte(_akII(_index_), "nesting=", true);
							__output.writeByte(getValue(_index_), "type=", true);
							break;
							
						case 120: // 'x'
							__output.writeByte(_akII(_index_), "local=", true);
							__output.writeByte(getValue(_index_), "value=", true);
							break;
							
						case 121: // 'y'
							__output.writeShort(_akII(_index_), "local=", true);
							__output.writeShort(getValue(_index_), "value=", true);
							break;
							
						case 39: // '\''
							Long long1 = (Long)getObjectRef(_index_, 0);
							//__output.writeLong(long1.longValue(), "value=");
							_source_.append(long1.longValue());
							break;
							
						case 7: // '\007'
						case 8: // '\b'
						case 105: // 'i'
						case 106: // 'j'
						case 107: // 'k'
						case 108: // 'l'
						case 109: // 'm'
						case 110: // 'n'
						case 111: // 'o'
						case 112: // 'p'
							net.rim.tools.compiler.codfile.ClassDef _classDef_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							net.rim.tools.compiler.codfile.Member _member_ = (net.rim.tools.compiler.codfile.Member)getObjectRef(_index_, 1);
							_member_.writeStaticOffset(__output, _classDef_);
							if (_member_ instanceof Routine)
							{
							    _source_.append(((Routine)_member_).get_Name());
								_source_.append("   // get_name_1:  " + ((Routine)_member_).get_name_1());
								_source_.append("   // get_name_2:  " + ((Routine)_member_).get_name_2());
							}
							if (_member_ instanceof FieldDef)
							{
								_source_.append(((FieldDef)_member_).get_Name());
								_source_.append("   // get_name_1:  " + ((FieldDef)_member_).get_name_1());
								_source_.append("   // get_name_2:  " + ((FieldDef)_member_).get_name_2());

							}
							break;
							
						case 25: // '\031'
						case 26: // '\032'
						case 28: // '\034'
						case 29: // '\035'
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
							net.rim.tools.compiler.codfile.Member _member_1_ =((net.rim.tools.compiler.codfile.Member)getObjectRef(_index_, 0));
							_member_1_.writeMemberAddress(__output, _constants_[_index_] != 0);
							_member_1_.get_name_1();
							_source_.append(_member_1_.get_Name());
							_source_.append("   // get_name_1:  " + _member_1_.get_name_1());
							_source_.append("   // get_name_2:  " + _member_1_.get_name_2());
							
							break;
							
						case 9: // '\t'
						case 10: // '\n'
						case 11: // '\013'
							net.rim.tools.compiler.codfile.Routine _routine_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
							//__output.writeByte(_routine_.getLocalCount(), "parmcount=", true);
							//((net.rim.tools.compiler.codfile.RoutineLocal)_routine_).writeNativeInvoke(__output);
							_source_.append(_routine_.get_Name());
							_source_.append("   // get_name_1:  " + _routine_.get_name_1());
							_source_.append("   // get_name_2:  " + _routine_.get_name_2());
							break;
							
						case 12: // '\f'
						case 13: // '\r'
							net.rim.tools.compiler.codfile.Routine _routine_1_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
							_routine_1_.writeOffset(__output);
							_source_.append(_routine_1_.get_Name());
							_source_.append("   // get_name_1:  " + _routine_1_.get_name_1());
							_source_.append("   // get_name_2:  " + _routine_1_.get_name_2());
							break;
							
						case 3: // '\003'
						case 4: // '\004'
						case 5: // '\005'
						case 6: // '\006'
							net.rim.tools.compiler.codfile.Routine _routine_2_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
							//_routine_2_.writeOffset(__output);
							//__output.writeByte(_routine_2_.getLocalCount(), "parmcount=", true);
							 
							//_routine_2_.getClassDef().getClassNameString() + " " +
							_source_.append(_routine_2_.get_name_2());
							_source_.append("   // get_name_1:  " + _routine_2_.get_name_1());
							_source_.append("   // get_name_2:  " + _routine_2_.get_name_2());
							break;
							
						case 1: // '\001'
							net.rim.tools.compiler.codfile.Routine _routine_3_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
							//_routine_3_.writeMemberAddress(__output, _constants_[_index_] != 0);
							//__output.writeByte(_routine_3_.getLocalCount(), "parmcount=", true);
							_source_.append(_routine_3_.get_Name());
							_source_.append("   // get_name_1:  " + _routine_3_.get_name_1());
							_source_.append("   // get_name_2:  " + _routine_3_.get_name_2());
							break;
							
						case 222:
							net.rim.tools.compiler.codfile.Routine _routine_4_ = (net.rim.tools.compiler.codfile.Routine)getObjectRef(_index_, 0);
							int l3 = _routine_4_.getVTableOffset(_constants_[_index_] != 0);
							int k4 = _routine_4_.getAddress() << 2;
							int l4 = _routine_4_.getLocalCount();
							__output.empty_func10(_routine_4_.get_name_1(), ' ');
							__output.writeString("index=");
							__output.empty_func8(l3);
							__output.writeString(" parmcount=");
							__output.empty_func8(l4);
							k4 |= l4 - 1;
							__output.writeByte(k4);
							_source_.append(_routine_4_.get_name_1());
							break;
							
						case 2: // '\002'
							net.rim.tools.compiler.codfile.InterfaceMethodRef _interfaceMethod_ = (net.rim.tools.compiler.codfile.InterfaceMethodRef)getObjectRef(_index_, 0);
							//_interfaceMethod_.writeOffset(__output);
							//__output.writeByte(_akII(_index_), "parmcount=", true);
							//__output.writeShort(getValue(_index_), "guess=", true);
							_source_.append(_interfaceMethod_.get_Name());
							_source_.append("   // get_name_1:  " + _interfaceMethod_.get_name_1());
							_source_.append("   // get_name_2:  " + _interfaceMethod_.get_name_2());
							break;
							
						case 169:
						case 185:
						case 187:
						case 192:
						case 194:
							net.rim.tools.compiler.codfile.ClassDef _classDef_1_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							if(_aliasesFlag)
								_classDef_1_.writeAbsoluteClassDef(__output);
							else
								_classDef_1_.writeOrdinal(__output);
							_source_.append(_classDef_1_.getClassNameString());
							break;
							
						case 19: // '\023'
						case 168:
						case 184:
						case 186:
						case 191:
						case 193:
							net.rim.tools.compiler.codfile.ClassDef _classDef_2_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							_classDef_2_.writeOrdinal(__output);
							_source_.append(_classDef_2_.getClassNameString());
							break;
							
						case 199:
						case 201:
							net.rim.tools.compiler.codfile.ClassDef _classDef_3_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							if(_aliasesFlag)
								_classDef_3_.writeAbsoluteClassDef(__output);
							else
								_classDef_3_.writeOrdinal(__output);
							__output.writeByte(_constants_[_index_], "nesting=", true);
							_source_.append(_classDef_3_.getClassNameString());
							break;
							
						case 198:
						case 200:
							net.rim.tools.compiler.codfile.ClassDef _classDef_4_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							_classDef_4_.writeOrdinal(__output);
							__output.writeByte(_constants_[_index_], "nesting=", true);
							_source_.append(_classDef_4_.getClassNameString());
							break;
							
						case 166:
							__output.writeByte(_apII(_index_), "dimensions=", true);
							__output.writeByte(_alII(_index_), "nesting=", true);
							__output.writeByte(_ajII(_index_), "type=", true);
							break;
							
						case 171:
							net.rim.tools.compiler.codfile.ClassDef _classDef_5_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							if(_aliasesFlag)
								_classDef_5_.writeAbsoluteClassDef(__output);
							else
								_classDef_5_.writeOrdinal(__output);
							_source_.append(_classDef_5_.getClassNameString());
							__output.writeByte(_akII(_index_), "dimensions=", true);
							__output.writeByte(getValue(_index_), "nesting=", true);
							break;
							
						case 170:
							net.rim.tools.compiler.codfile.ClassDef _classDef_6_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							_classDef_6_.writeOrdinal(__output);
							__output.writeByte(_akII(_index_), "dimensions=", true);
							__output.writeByte(getValue(_index_), "nesting=", true);
							_source_.append(_classDef_6_.getClassNameString());
							break;
							
						case 196:
							net.rim.tools.compiler.codfile.ClassDef _classDef_7_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							net.rim.tools.compiler.codfile.CodfileLabel _label_1_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 1);
							if(_aliasesFlag)
								_classDef_7_.writeAbsoluteClassDef(__output);
							else
								_classDef_7_.writeOrdinal(__output);
							int k1 = getBranchTarget(_label_1_, __output);
							__output.empty_func4(k1, 2);
							__output.writeShort(k1);
							break;
							
						case 195:
							net.rim.tools.compiler.codfile.ClassDef _classDef_8_ = (net.rim.tools.compiler.codfile.ClassDef)getObjectRef(_index_, 0);
							net.rim.tools.compiler.codfile.CodfileLabel _label_2_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 1);
							_classDef_8_.writeOrdinal(__output);
							int l1 = getBranchTarget(_label_2_, __output);
							__output.empty_func4(l1, 2);
							__output.writeShort(l1);
							break;
							
						case 197:
							net.rim.tools.compiler.codfile.CodfileLabel _label_3_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
							__output.writeByte(_akII(_index_), "nesting=", true);
							__output.writeByte(getValue(_index_), "type=", true);
							int i2 = getBranchTarget(_label_3_, __output);
							__output.empty_func4(i2, 2);
							__output.writeShort(i2);
							break;
							
						case 47: // '/'
							int ai2[] = (int[])getObjectRef(_index_, 0);
							net.rim.tools.compiler.codfile.CodfileLabel _labels_1_[] = (net.rim.tools.compiler.codfile.CodfileLabel[])getObjectRef(_index_, 1);
							_source_.append(" :\r\n");
							int i5 = _labels_1_.length;
							if(_constants_[_index_] != 0)
								i5 = -1;
							__output.writeShort(i5, "tablesize=", true);
							
							__output.writeInt(ai2[1], "low=", true);
							i5 = _labels_1_.length;
							__output.writeString("table 0 default");
							__output.empty_func7();
							__output.empty_func();
							for(int j5 = 0; j5 < i5; j5++)
							{
								_source_.append("\t\t");
								int j2 = getBranchTarget(_labels_1_[j5], __output);
								__output.empty_func4(j2, 2);
								__output.writeShort(j2);
								__output.empty_func7();
								_source_.append("\r\n");
							}
							
							__output.empty_func7();
							__output.empty_func2();
							break;
							
						case 15: // '\017'
						case 17: // '\021'
							__output.writeByte(_apII(_index_), "locals(hibyte)=", true);
							__output.writeByte(_alII(_index_), "parameters(hibyte)=", true);
							__output.writeByte(_ajII(_index_), "stack(hibyte)=", true);
							break;
							
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
							net.rim.tools.compiler.codfile.CodfileLabel _label_4_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
							if(_constants_[_index_] == 0)
							{
								int k2 = getBranchTarget(_label_4_, __output);
								__output.empty_func4(k2, 2);
								__output.writeByte(k2);
							} else
							{
								int l2 = 4;
								__output.empty_func4(l2, 2);
								__output.writeByte(l2);
								__output.empty_func7();
								char c2 = '\242';
								__output.writeByte(c2, net.rim.tools.compiler.vm.Opcodes.opcodes[c2], false);
								l2 = getBranchTarget(_label_4_, __output);
								__output.empty_func4(l2, 2);
								__output.writeShort(l2);
							}
							break;
							
						case 161:
							net.rim.tools.compiler.codfile.CodfileLabel _lable_5_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
							int i3 = getBranchTarget(_lable_5_, __output);
							__output.empty_func4(i3, 2);
							__output.writeByte(i3);
							break;
							
						case 162:
							net.rim.tools.compiler.codfile.CodfileLabel _label_6_ = (net.rim.tools.compiler.codfile.CodfileLabel)getObjectRef(_index_, 0);
							int j3 = getBranchTarget(_label_6_, __output);
							__output.empty_func4(j3, 2);
							__output.writeShort(j3);
							break;
					}
					_source_.append("\r\n");
					__output.empty_func7();
					break;
            }
        }
		
		__message.append(_source_);
        setExtent(__output);
    }
	

    public void _amIV(int i)
    {
        _opcodes = new byte[i];
        _constants = new int[i];
        _parametersIndex = new short[i];
    }

    public void addByteCode(int _bytecode_)
    {
        switch(_bytecode_)
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
        case 223:
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
            _opcodes[_opcodesNum] = (byte)_bytecode_;
            // fall through

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
        case 21: // '\025'
        case 22: // '\026'
        case 23: // '\027'
        case 25: // '\031'
        case 26: // '\032'
        case 28: // '\034'
        case 29: // '\035'
        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 42: // '*'
        case 43: // '+'
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
        case 71: // 'G'
        case 72: // 'H'
        case 73: // 'I'
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
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
        case 165:
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
            _opcodesNum++;
            break;
        }
    }

    public void _tryIIV(int i, int j)
    {
        switch(i)
        {
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
            _opcodes[_opcodesNum] = (byte)i;
            _constants[_opcodesNum] = j;
            break;
        }
        _opcodesNum++;
    }

    public void _aIhV(int i, net.rim.tools.compiler.codfile.Literal __literal)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 40: // '('
        case 42: // '*'
            _parametersIndex[_opcodesNum] = addObjectRef(__literal);
            break;
        }
        _opcodesNum++;
    }

    public void _aIahV(int i, net.rim.tools.compiler.codfile.Literal ah[])
    {
        _opcodes[_opcodesNum] = (byte)i;
        _parametersIndex[_opcodesNum] = addObjectRef(ah);
        _opcodesNum++;
    }

    public void _aIIV(int i, int j, net.rim.tools.compiler.codfile.CodfileData f1)
    {
        _opcodes[_opcodesNum] = (byte)i;
        _constants[_opcodesNum] = j;
        _parametersIndex[_opcodesNum] = addObjectRef(f1);
        _opcodesNum++;
    }

    public void _aIIV(int i, int j, int l)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 120: // 'x'
        case 121: // 'y'
        case 189:
        case 190:
            _doIIV(j, l);
            break;
        }
        _opcodesNum++;
    }

    public void _aIJV(int i, long l)
    {
        _opcodes[_opcodesNum] = (byte)i;
        _parametersIndex[_opcodesNum] = addObjectRef(new Long(l));
        _opcodesNum++;
    }

    public void _aIuV(int i, net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Member r1)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 7: // '\007'
        case 8: // '\b'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
        case 108: // 'l'
        case 109: // 'm'
        case 110: // 'n'
        case 111: // 'o'
        case 112: // 'p'
            _parametersIndex[_opcodesNum] = addObjectRef(u1);
            addObjectRef(r1);
            break;
        }
        _opcodesNum++;
    }

    public void _aIrV(int i, net.rim.tools.compiler.codfile.Member r1, boolean flag)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 1: // '\001'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 25: // '\031'
        case 26: // '\032'
        case 28: // '\034'
        case 29: // '\035'
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
        case 222:
            _parametersIndex[_opcodesNum] = addObjectRef(r1);
            _constants[_opcodesNum] = flag ? 1 : 0;
            break;
        }
        _opcodesNum++;
    }

    public void _aIuV(int i, net.rim.tools.compiler.codfile.ClassDef u1, int j)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 19: // '\023'
        case 168:
        case 169:
        case 184:
        case 185:
        case 186:
        case 187:
        case 191:
        case 192:
        case 193:
        case 194:
        case 198:
        case 199:
        case 200:
        case 201:
            _parametersIndex[_opcodesNum] = addObjectRef(u1);
            _constants[_opcodesNum] = j;
            break;
        }
        _opcodesNum++;
    }

    public void _ifIIIV(int i, int j, int l, int i1)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 166:
            _ifIIV(j, l, i1);
            break;
        }
        _opcodesNum++;
    }

    public void _aIIIV(int i, int j, int l, Object obj)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 2: // '\002'
        case 170:
        case 171:
        case 197:
            _parametersIndex[_opcodesNum] = addObjectRef(obj);
            _doIIV(j, l);
            break;
        }
        _opcodesNum++;
    }

    public void _aIuV(int i, net.rim.tools.compiler.codfile.ClassDef u1, Object obj)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 195:
        case 196:
            _parametersIndex[_opcodesNum] = addObjectRef(u1);
            addObjectRef(obj);
            break;
        }
        _opcodesNum++;
    }

    public void _aIaIV(int i, int ai[])
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 15: // '\017'
        case 17: // '\021'
            _ifIIV(ai[0], ai[1], ai[2]);
            break;
        }
        _opcodesNum++;
    }

    public void _aIObjectV(int i, Object obj)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
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
            _parametersIndex[_opcodesNum] = addObjectRef(obj);
            break;
        }
        _opcodesNum++;
    }

    public void _aIaIaObjectV(int i, int ai[], Object aobj[], boolean flag)
    {
        _opcodes[_opcodesNum] = (byte)i;
        switch(i)
        {
        case 47: // '/'
        case 163:
        case 164:
            _parametersIndex[_opcodesNum] = addObjectRef(ai);
            addObjectRef(((Object) (aobj)));
            _constants[_opcodesNum] = flag ? 1 : 0;
            break;
        }
        _opcodesNum++;
    }

    public boolean _btvZ()
    {
        if(z_hUZ)
            return false;
        if(_opcodesNum > 0)
            switch(_opcodes[0])
            {
            case 15: // '\017'
            case 17: // '\021'
                return false;
            }
        return true;
    }

    public void _bsvV()
    {
        if(_opcodesNum > 0)
            switch(_opcodes[0])
            {
            case 14: // '\016'
            case 16: // '\020'
                _opcodes[0] = -35;
                break;
            }
    }

    private void _doIIV(int i, int j)
    {
        _constants[_opcodesNum] = j << 16 | i & 0xffff;
    }

    private int _akII(int i)
    {
        return _constants[i] & 0xffff;
    }

    private int getValue(int i)
    {
        return _constants[i] >> 16;
    }

    private void _aIIIV(int i, int j, int l, int i1)
    {
        _constants[i] = i1 << 16 | (l & 0xff) << 8 | j & 0xff;
    }

    private void _ifIIV(int i, int j, int l)
    {
        _aIIIV(_opcodesNum, i, j, l);
    }

    private int _apII(int i)
    {
        return _constants[i] & 0xff;
    }

    private int _alII(int i)
    {
        return _constants[i] >> 8 & 0xff;
    }

    private int _ajII(int i)
    {
        return _constants[i] >> 16;
    }

    private short addObjectRef(Object obj)
    {
        short word0 = z_hPS;
        if(_objectRefs == null)
            _objectRefs = new Object[1];
        else
        if(z_hPS == _objectRefs.length)
            _objectRefs = net.rim.tools.compiler.exec.MyArrays.resize(_objectRefs, _objectRefs.length * 2);
        _objectRefs[z_hPS++] = obj;
        return word0;
    }

    private void setObjectRef(int i, int j, Object obj)
    {
        _objectRefs[_parametersIndex[i] + j] = obj;
    }

    private Object getObjectRef(int i, int j)
    {
        return _objectRefs[_parametersIndex[i] + j];
    }

	public Object [] getObjectRefs()
	{
		return _objectRefs;
	}
	
    public net.rim.tools.compiler.codfile.CodfileLabel _bvva6()
    {
        int i = 0;
        if(_labels == null)
        {
            _labels = new CodfileLabel[1];
        } else
        {
            i = _labels.length;
            _labels = net.rim.tools.compiler.exec.MyArrays.resize(_labels, _labels.length + 1);
        }
        net.rim.tools.compiler.codfile.CodfileLabel a6_1 = new net.rim.tools.compiler.codfile.CodfileLabel(_opcodesNum, -1);
        _labels[i] = a6_1;
        return a6_1;
    }

    public static int _aIIaII(int i, int j, int ai[], boolean flag, boolean flag1)
    {
        int l = 0;
        byte byte0 = 4;
        switch(i)
        {
        case 161:
				l += net.rim.tools.compiler.vm.OpcodeSize._sizes[i];
            if(flag)
                l++;
            break;

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
				l += net.rim.tools.compiler.vm.OpcodeSize._sizes[i];
            if(j != 0 || flag)
                l += 3;
            break;

        case 163:
            byte0 = 2;
            // fall through

        case 164:
            int i1 = ai.length * (byte0 + 2);
            l = 5 + i1;
            i1 = _aaII(ai);
            int k1 = 7 + i1 * 2;
            if(flag1 && k1 < l)
                l = k1;
            break;

        case 47: // '/'
            int j1 = ai[0] * 2;
            l += 7 + j1;
            break;

        default:
				l += net.rim.tools.compiler.vm.OpcodeSize._sizes[i];
            break;
        }
        return l;
    }

    private static int _aaII(int __objectRefs[])
    {
        int i = __objectRefs.length;
        int j = i + 1;
        int l = j * 8;
        for(int i1 = 1; i1 < i; i1++)
        {
            if(__objectRefs[i1] <= __objectRefs[i1 - 1])
            {
                j = l;
                break;
            }
            int j1 = __objectRefs[i1] - __objectRefs[i1 - 1] - 1;
            if(j1 < 0)
            {
                j = l;
                break;
            }
            if(j1 > l)
            {
                j = l;
                break;
            }
            j += j1;
        }

        return j;
    }

    public static int _newIII(int i, int j)
    {
        return 3 + 2 * j;
    }

    private int _arII(int i)
    {
        char c1 = '\0';
        if(i > 0 && (_opcodes[i - 1] & 0xff) == 216)
            c1 = '\u0100';
        int ai[] = null;
        int j = (_opcodes[i] & 0xff) + c1;
        switch(j)
        {
        case 282:
				return _newIII(j, ((net.rim.tools.compiler.codfile.Literal[])getObjectRef(i, 0)).length);

        case 47: // '/'
        case 163:
        case 164:
            ai = (int[])getObjectRef(i, 0);
            break;
        }
        return _aIIaII(j, _constants[i], ai, false, _aliasesFlag);
    }

    private int _forIII(int i, int j)
    {
        net.rim.tools.compiler.codfile.CodfileLabel a6_1 = null;
        int l = -1;
        int i1 = 0;
        if(_labels != null && i1 < _labels.length)
            do
            {
                a6_1 = _labels[i1++];
                l = a6_1._ifvI();
            } while(l < j && i1 < _labels.length);
        int k1 = _opcodesNum;
        for(int j1 = j; j1 < k1; j1++)
        {
            if(a6_1 != null && l == j1)
            {
                a6_1.setEnd(i);
                a6_1 = null;
                l = -1;
                if(i1 < _labels.length)
                {
                    a6_1 = _labels[i1++];
                    l = a6_1._ifvI();
                }
            }
            i += _arII(j1);
        }

        while(a6_1 != null)
        {
            a6_1.setEnd(i);
            a6_1 = null;
            if(i1 < _labels.length)
                a6_1 = _labels[i1++];
        }
        return i;
    }

    public void _asIV(int i)
    {
        int j = _opcodes[0] & 0xff;
        switch(j)
        {
        case 15: // '\017'
        case 17: // '\021'
            _aIIIV(0, i, _alII(0), _ajII(0));
            break;
        }
    }

    private int _aoII(int i)
    {
        switch(i)
        {
        case 159:
            return 160;

        case 146:
            return 149;

        case 160:
            return 159;

        case 149:
            return 146;

        case 147:
            return 150;

        case 145:
            return 148;

        case 150:
            return 147;

        case 148:
            return 145;

        case 154:
            return 156;

        case 153:
            return 155;

        case 152:
            return 158;

        case 151:
            return 157;

        case 158:
            return 152;

        case 157:
            return 151;

        case 156:
            return 154;

        case 155:
            return 153;
        }
        return 0;
    }

    public int _brvI()
    {
        int i;
        boolean flag;
        do
        {
            flag = false;
            int j = 0;
            i = _forIII(j, 0);
            int l = _opcodesNum;
            int i1 = 0;
            for(int j1 = 0; j1 < l; j1++)
            {
                int k1 = (_opcodes[j1] & 0xff) + i1;
                i1 = 0;
                switch(k1)
                {
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
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
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
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
                case 214:
                case 215:
                default:
                    break;

                case 216:
                    i1 = 256;
                    break;

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
                    if(_constants[j1] != 0)
                        break;
                    // fall through

                case 161:
						net.rim.tools.compiler.codfile.CodfileLabel a6_1 = (net.rim.tools.compiler.codfile.CodfileLabel)_objectRefs[_parametersIndex[j1]];
                    int l1 = a6_1.getEnd() - (j + 1);
                    if(l1 >= -128 && l1 < 128)
                        break;
                    if(k1 == 161)
                    {
                        _opcodes[j1] = -94;
                    } else
                    {
                        _opcodes[j1] = (byte)_aoII(k1);
                        _constants[j1] = 1;
                    }
                    i = _forIII(j, j1);
                    flag = true;
                    break;
                }
                j += _arII(j1);
            }

        } while(flag);
        return i;
    }

    public void _buvV()
    {
        int i = _opcodesNum;
        int j = 0;
        for(int l = 0; l < i; l++)
        {
            int i1 = (_opcodes[l] & 0xff) + j;
            j = 0;
            switch(i1)
            {
            default:
                break;

            case 216:
                j = 256;
                break;

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
            case 197:
					net.rim.tools.compiler.classfile.InstructionTarget x1 = (net.rim.tools.compiler.classfile.InstructionTarget)getObjectRef(l, 0);
                setObjectRef(l, 0, x1.getLabel());
                break;

            case 195:
            case 196:
					net.rim.tools.compiler.classfile.InstructionTarget x2 = (net.rim.tools.compiler.classfile.InstructionTarget)getObjectRef(l, 1);
                setObjectRef(l, 1, x2.getLabel());
                break;

            case 47: // '/'
            case 163:
            case 164:
                Object aobj[] = (Object[])getObjectRef(l, 1);
                int j1 = aobj.length;
					net.rim.tools.compiler.codfile.CodfileLabel aa6[] = new net.rim.tools.compiler.codfile.CodfileLabel[j1];
                for(int k1 = 0; k1 < j1; k1++)
                {
                    net.rim.tools.compiler.classfile.InstructionTarget x3 = (net.rim.tools.compiler.classfile.InstructionTarget)aobj[k1];
                    aa6[k1] = x3.getLabel();
                }

                setObjectRef(l, 1, aa6);
                break;
            }
        }

    }

    public void _tryZV(boolean flag)
    {
        _aliasesFlag = flag;
    }

    public void _byteZV(boolean flag)
    {
        z_hUZ = flag;
    }

    public void _ifIrV(int i, net.rim.tools.compiler.codfile.Member r1, boolean flag)
    {
        i -= super._offset;
        int j;
        for(j = 0; j == 0; j = _linesMap[i--]);
        j--;
        int l = 1;
        if(!flag)
        {
            l = 0;
            _constants[j] = 1;
        }
        setObjectRef(j, l, r1);
    }

    public boolean _aqIZ(int i)
    {
        if(_linesMap == null)
            return false;
        else
            return _linesMap[i - super._offset] > 0;
    }
}
