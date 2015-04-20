// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import java.io.PrintStream;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.io.Diagnose;

// Referenced classes of package net.rim.tools.compiler.e:
//            aa, a, c, ab,
//            h, r, e, l,
//            y, o, m

public final class JavaByteCodes
implements net.rim.tools.compiler.vm.Constants
{

    public static final int z_kuI = -2;
    public static final int z_lyI = -1;
    public static final int z_iYI = 0;
    public static final int z_laI = 1;
    public static final int z_jOI = 2;
    public static final int z_kEI = 3;
    public static final int z_lwI = 4;
    public static final int z_jUI = 5;
    public static final int z_j4I = 0;
    public static final int z_i1I = 1;
    public static final int z_lqI = 2;
    public static final int z_myI = 3;
    public static final int z_mxI = 4;
    public static final int z_muI = 5;
    public static final int z_mtI = 6;
    public static final int z_mqI = 7;
    public static final int z_moI = 8;
    public static final int z_lNI = 9;
    public static final int z_lMI = 10;
    public static final int z_iWI = 11;
    public static final int z_iUI = 12;
    public static final int z_iTI = 13;
    public static final int z_kJI = 14;
    public static final int z_kHI = 15;
    public static final int z_lmI = 16;
    public static final int z_i0I = 17;
    public static final int z_jRI = 18;
    public static final int z_jYI = 19;
    public static final int z_kYI = 20;
    public static final int z_loI = 21;
    public static final int z_lKI = 22;
    public static final int z_kUI = 23;
    public static final int z_i4I = 24;
    public static final int z_maI = 25;
    public static final int z_jeI = 26;
    public static final int z_jcI = 27;
    public static final int z_jbI = 28;
    public static final int z_jaI = 29;
    public static final int z_mpI = 30;
    public static final int z_mnI = 31;
    public static final int z_mmI = 32;
    public static final int z_mlI = 33;
    public static final int z_jrI = 34;
    public static final int z_jpI = 35;
    public static final int z_jnI = 36;
    public static final int z_jlI = 37;
    public static final int z_jHI = 38;
    public static final int z_jFI = 39;
    public static final int z_jEI = 40;
    public static final int z_jDI = 41;
    public static final int z_jNI = 42;
    public static final int z_jMI = 43;
    public static final int z_jKI = 44;
    public static final int z_jJI = 45;
    public static final int z_kqI = 46;
    public static final int z_jxI = 47;
    public static final int z_k8I = 48;
    public static final int z_i9I = 49;
    public static final int z_j2I = 50;
    public static final int z_k3I = 51;
    public static final int z_lOI = 52;
    public static final int z_mrI = 53;
    public static final int z_lnI = 54;
    public static final int z_kBI = 55;
    public static final int z_lZI = 56;
    public static final int z_kjI = 57;
    public static final int z_k5I = 58;
    public static final int z_mGI = 59;
    public static final int z_mEI = 60;
    public static final int z_mDI = 61;
    public static final int z_mCI = 62;
    public static final int z_mjI = 63;
    public static final int z_miI = 64;
    public static final int z_mhI = 65;
    public static final int z_mfI = 66;
    public static final int z_jwI = 67;
    public static final int z_jvI = 68;
    public static final int z_juI = 69;
    public static final int z_jtI = 70;
    public static final int z_kSI = 71;
    public static final int z_kRI = 72;
    public static final int z_kPI = 73;
    public static final int z_kNI = 74;
    public static final int z_liI = 75;
    public static final int z_lgI = 76;
    public static final int z_lfI = 77;
    public static final int z_leI = 78;
    public static final int z_msI = 79;
    public static final int z_lPI = 80;
    public static final int z_mHI = 81;
    public static final int z_i5I = 82;
    public static final int z_jhI = 83;
    public static final int z_jkI = 84;
    public static final int z_i3I = 85;
    public static final int z_lCI = 86;
    public static final int z_j0I = 87;
    public static final int z_lHI = 88;
    public static final int z_meI = 89;
    public static final int z_lzI = 90;
    public static final int z_lxI = 91;
    public static final int z_joI = 92;
    public static final int z_kQI = 93;
    public static final int z_kOI = 94;
    public static final int z_kAI = 95;
    public static final int z_jLI = 96;
    public static final int z_l3I = 97;
    public static final int z_k6I = 98;
    public static final int z_jzI = 99;
    public static final int z_luI = 100;
    public static final int z_kfI = 101;
    public static final int z_i2I = 102;
    public static final int z_ldI = 103;
    public static final int z_lBI = 104;
    public static final int z_ktI = 105;
    public static final int z_i8I = 106;
    public static final int z_lkI = 107;
    public static final int z_jQI = 108;
    public static final int z_mbI = 109;
    public static final int z_lcI = 110;
    public static final int z_jBI = 111;
    public static final int z_kMI = 112;
    public static final int z_jmI = 113;
    public static final int z_lRI = 114;
    public static final int z_kwI = 115;
    public static final int z_k0I = 116;
    public static final int z_jCI = 117;
    public static final int z_l1I = 118;
    public static final int z_kGI = 119;
    public static final int z_lAI = 120;
    public static final int z_ksI = 121;
    public static final int z_lvI = 122;
    public static final int z_kkI = 123;
    public static final int z_mwI = 124;
    public static final int z_jjI = 125;
    public static final int z_kCI = 126;
    public static final int z_i6I = 127;
    public static final int z_lYI = 128;
    public static final int z_j9I = 129;
    public static final int z_k9I = 130;
    public static final int z_jPI = 131;
    public static final int z_khI = 132;
    public static final int z_lLI = 133;
    public static final int z_lQI = 134;
    public static final int z_lSI = 135;
    public static final int z_jXI = 136;
    public static final int z_jZI = 137;
    public static final int z_j1I = 138;
    public static final int z_kdI = 139;
    public static final int z_kaI = 140;
    public static final int z_kiI = 141;
    public static final int z_klI = 142;
    public static final int z_kgI = 143;
    public static final int z_kpI = 144;
    public static final int z_lUI = 145;
    public static final int z_lTI = 146;
    public static final int z_lII = 147;
    public static final int z_jgI = 148;
    public static final int z_j8I = 149;
    public static final int z_kbI = 150;
    public static final int z_l8I = 151;
    public static final int z_l9I = 152;
    public static final int z_k4I = 153;
    public static final int z_l0I = 154;
    public static final int z_mFI = 155;
    public static final int z_kFI = 156;
    public static final int z_kyI = 157;
    public static final int z_iZI = 158;
    public static final int z_kII = 159;
    public static final int z_lEI = 160;
    public static final int z_l2I = 161;
    public static final int z_j5I = 162;
    public static final int z_jWI = 163;
    public static final int z_mdI = 164;
    public static final int z_kvI = 165;
    public static final int z_lrI = 166;
    public static final int z_keI = 167;
    public static final int z_iVI = 168;
    public static final int z_i7I = 169;
    public static final int z_mcI = 170;
    public static final int z_koI = 171;
    public static final int z_jqI = 172;
    public static final int z_jdI = 173;
    public static final int z_jTI = 174;
    public static final int z_j6I = 175;
    public static final int z_krI = 176;
    public static final int z_lVI = 177;
    public static final int z_lXI = 178;
    public static final int z_lhI = 179;
    public static final int z_jAI = 180;
    public static final int z_kXI = 181;
    public static final int z_kZI = 182;
    public static final int z_k2I = 183;
    public static final int z_mzI = 184;
    public static final int z_k1I = 185;
    public static final int z_kmI = 186;
    public static final int z_jfI = 187;
    public static final int z_k7I = 188;
    public static final int z_ljI = 189;
    public static final int z_jII = 190;
    public static final int z_knI = 191;
    public static final int z_kVI = 192;
    public static final int z_kxI = 193;
    public static final int z_kWI = 194;
    public static final int z_kzI = 195;
    public static final int z_jGI = 196;
    public static final int z_mvI = 197;
    public static final int z_kDI = 198;
    public static final int z_ltI = 199;
    public static final int z_lDI = 200;
    public static final int z_kLI = 201;
    public static final int z_lGI = 202;
    public static final int z_jsI = 203;
    public static final int z_lbI = 204;
    public static final int z_kKI = 205;
    private static final int z_lpaI[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 2, 1, 2,
        2, 1, 1, 1, 1, 1, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 1, 1, 1, 1, 1, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 2, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 2, 2, 2, 2, 2, 2, 2,
        2, 2, 2, 2, 2, 2, 2, 2, 2, 1,
        -1, -1, 0, 0, 0, 0, 0, 0, 2, 2,
        2, 2, 2, 2, 2, 4, 0, 2, 1, 2,
        0, 0, 2, 2, 0, 0, -1, 3, 2, 2,
        4, 4, 0, 0, 2, -1, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0
    };
    private static final int z_j7aI[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 1, 1, 4, 4,
        4, 5, 5, 5, 5, 5, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 5, 5, 5, 5, 5, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, -1, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
        0, 0, 0, 3, 3, 3, 3, 3, 3, 3,
        3, 3, 3, 3, 3, 3, 3, 3, 3, 5,
        -1, -1, 0, 0, 0, 0, 0, 0, 4, 4,
        4, 4, 4, 4, 4, -1, -2, 4, 2, 4,
        0, 0, 4, 4, 0, 0, -1, -1, 3, 3,
        3, 3, 0, -2, 4, -1, -2, -2, -2, -2,
        -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
        -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
        -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
        -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,
        -2, -2, -2, -2, -2, -2, 0, 0
    };
    private static final char z_lsC = 76;
    private static final char z_kcC = 91;
    private byte _data[];
    private int z_j3I;
    private int z_kTI;
    private net.rim.tools.compiler.analysis.InstructionResolver _resolver;
    private net.rim.tools.compiler.classfile.ConstantPool _constantPool;
    private int z_l7aI[];
    private int z_l6aI[];
    private int z_l4aI[];
    private net.rim.tools.compiler.classfile.ByteCodeNotFoundException z_mgaa;
    private net.rim.tools.compiler.classfile.ConstantPoolArrayData z_jSl;
    private String z_mkaString[];
    private int z_lFI;
    private static final int z_jyI = 4;
    private static final int z_llI = 5;
    private static final int z_l5I = 6;
    private static final int z_lWI = 7;
    private static final int z_jVI = 8;
    private static final int z_mAI = 9;
    private static final int z_iXI = 10;
    private static final int z_iSI = 11;

    public JavaByteCodes()
    {
        z_l7aI = new int[0];
        z_l6aI = new int[1];
        z_l4aI = new int[2];
        z_mgaa = new net.rim.tools.compiler.classfile.ByteCodeNotFoundException();
    }

    private int _aIII(int i)
    {
        int k = 0;
        switch(i)
        {
        case 1: // '\001'
            k = _data[z_j3I + 0];
            z_j3I += i;
            break;

        case 2: // '\002'
            k = _data[z_j3I + 0] << 8;
            k |= _data[z_j3I + 1] & 0xff;
            z_j3I += i;
            break;

        case 4: // '\004'
            k = _data[z_j3I + 0] << 24;
            k |= (_data[z_j3I + 1] & 0xff) << 16;
            k |= (_data[z_j3I + 2] & 0xff) << 8;
            k |= _data[z_j3I + 3] & 0xff;
            z_j3I += i;
            break;
        }
        return k;
    }

    private int _aLII(int i)
    {
        switch(i)
        {
        case 1: // '\001'
            return _aIII(i) & 0xff;

        case 2: // '\002'
            return _aIII(i) & 0xffff;
        }
        return _aIII(i);
    }

    private int _bYvI()
    {
        z_kTI = _aLII(1);
        return z_kTI;
    }

    private int _b3vI()
    {
        return _aIII(z_lpaI[z_kTI]);
    }

    private int _b5vI()
    {
        return _aLII(z_lpaI[z_kTI]);
    }

    public static int align(int i)
    {
        int k = i + 3;
        k &= -4;
        return k - i;
    }

    private void _aIIV(int i, int __opcode, net.rim.tools.compiler.classfile.ConstantPoolEntry __constantPoolEntry)
        throws CompileException, IOException
    {
        switch(__opcode)
        {
        default:
            break;

        case 18: // '\022'
        case 19: // '\023'
            if(__constantPoolEntry instanceof net.rim.tools.compiler.classfile.ConstantPoolString)
            {
                net.rim.tools.compiler.classfile.ConstantPoolString a1 = (net.rim.tools.compiler.classfile.ConstantPoolString)__constantPoolEntry;
                _resolver._aIIV(i, __opcode, a1);
                break;
            }
            if(__constantPoolEntry instanceof net.rim.tools.compiler.classfile.ConstantPoolInteger)
            {
                net.rim.tools.compiler.classfile.ConstantPoolInteger c1 = (net.rim.tools.compiler.classfile.ConstantPoolInteger)__constantPoolEntry;
                _resolver._aIIV(i, __opcode, c1);
            } else
            {
                ConstantPoolEntry._b6vV();
            }
            break;

        case 20: // '\024'
            if(__constantPoolEntry instanceof ConstantPoolLong)
            {
                ConstantPoolLong ab1 = (ConstantPoolLong)__constantPoolEntry;
                _resolver._aIIV(i, __opcode, ab1);
            } else
            {
                ConstantPoolEntry._b6vV();
            }
            break;

        case 178:
        case 179:
        case 180:
        case 181:
            if(__constantPoolEntry instanceof ConstantPoolFieldRef)
            {
                ConstantPoolFieldRef h1 = (ConstantPoolFieldRef)__constantPoolEntry;
                _resolver._aIIV(i, __opcode, h1);
            } else
            {
                ConstantPoolEntry._b6vV();
            }
            break;

        case 182:
        case 183:
        case 184:
            if(__constantPoolEntry instanceof ConstantPoolMethodRef)
            {
                ConstantPoolMethodRef r1 = (ConstantPoolMethodRef)__constantPoolEntry;
                _resolver._aIIV(i, __opcode, r1);
            } else
            {
                ConstantPoolEntry._b6vV();
            }
            break;

        case 187:
        case 189:
        case 192:
        case 193:
            if(__constantPoolEntry instanceof ConstantPoolClass)
            {
                net.rim.tools.compiler.classfile.ConstantPoolClass e1 = (net.rim.tools.compiler.classfile.ConstantPoolClass)__constantPoolEntry;
                _resolver._aIIeV(i, __opcode, e1, 0, __opcode == 187);
            } else
            {
                net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            }
            break;
        }
    }

    private void _aIIaV(int i, int k, int ai[])
        throws CompileException, IOException
    {
        _resolver._ifIIaV(i, k, ai);
    }

    private void _bXvV()
    {
        z_lFI = z_j3I;
    }

    private void _b4vV()
        throws ByteCodeNotFoundException
    {
        z_j3I = z_lFI;
        throw z_mgaa;
    }

    private int _aJII(int i)
    {
        switch(i)
        {
        case 4: // '\004'
            return 1;

        case 5: // '\005'
            return 3;

        case 6: // '\006'
            return 11;

        case 7: // '\007'
            return 12;

        case 8: // '\b'
            return 2;

        case 9: // '\t'
            return 4;

        case 10: // '\n'
            return 5;

        case 11: // '\013'
            return 6;
        }
        Diagnose.DiagnoseStream.println("Warning!: Bad type for newarray opcode: 0x" + Integer.toHexString(i));
        return 10;
    }

    private int _voidZI(boolean flag)
        throws ByteCodeNotFoundException
    {
        _bXvV();
        int i = _bYvI();
        if(i == 188)
            return _aJII(_b5vI());
        if(i == 189 && flag)
            try
            {
                int k = _b5vI();
                ConstantPoolEntry _entry_ = _constantPool.getConstantPoolEntry(k);
                if(_entry_ instanceof ConstantPoolClass)
                {
                    String s = ((ConstantPoolClass)_entry_).getName();
                    if(s.equals("java.lang.String"))
                        return 13;
                }
            }
            catch(IOException ioexception) { }
        _b4vV();
        return 0;
    }

    private int _bUvI()
        throws ByteCodeNotFoundException, IOException
    {
        _bXvV();
        switch(_bYvI())
        {
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
        default:
            break;

        case 2: // '\002'
            return -1;

        case 3: // '\003'
            return 0;

        case 4: // '\004'
            return 1;

        case 5: // '\005'
            return 2;

        case 6: // '\006'
            return 3;

        case 7: // '\007'
            return 4;

        case 8: // '\b'
            return 5;

        case 16: // '\020'
            return _aIII(1);

        case 17: // '\021'
            return _aIII(2);

        case 18: // '\022'
        case 19: // '\023'
            try
            {
                ConstantPoolEntry o1 = _constantPool.getConstantPoolEntry(_b5vI());
                if(o1 instanceof net.rim.tools.compiler.classfile.ConstantPoolInteger)
                    return ((net.rim.tools.compiler.classfile.ConstantPoolInteger)o1).getValue();
            }
            catch(IOException ioexception) { }
            break;
        }
        _b4vV();
        return 0;
    }

    private int _bWvI()
        throws ByteCodeNotFoundException, IOException
    {
        _bXvV();
        switch(_bYvI())
        {
        default:
            break;

        case 18: // '\022'
        case 19: // '\023'
            try
            {
                int i = _b5vI();
                net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = _constantPool.getConstantPoolEntry(i);
                if(o1 instanceof net.rim.tools.compiler.classfile.ConstantPoolString)
                    return i;
            }
            catch(IOException ioexception) { }
            break;
        }
        _b4vV();
        return 0;
    }

    private long _b2vJ()
        throws ByteCodeNotFoundException, IOException
    {
        _bXvV();
        switch(_bYvI())
        {
        case 9: // '\t'
            return 0L;

        case 10: // '\n'
            return 1L;

        case 20: // '\024'
            ConstantPoolEntry o1 = _constantPool.getConstantPoolEntry(_b5vI());
            if(o1 instanceof ConstantPoolLong)
                return ((ConstantPoolLong)o1).getValue();
            break;
        }
        _b4vV();
        return 0L;
    }

    private void _b1vV()
        throws ByteCodeNotFoundException
    {
        _bXvV();
        if(_bYvI() != 89)
            _b4vV();
    }

    private void _bZvV()
        throws ByteCodeNotFoundException
    {
        _bXvV();
        if(_bYvI() != 92)
            _b4vV();
    }

    private void _aKIV(int i)
        throws ByteCodeNotFoundException
    {
        _bXvV();
        switch(_bYvI())
        {
        case 81: // 'Q'
        case 82: // 'R'
        default:
            break;

        case 84: // 'T'
            if(i == 1)
                return;
            if(i == 2)
                return;
            break;

        case 85: // 'U'
            if(i == 3)
                return;
            break;

        case 86: // 'V'
            if(i == 4)
                return;
            break;

        case 79: // 'O'
            if(i == 5)
                return;
            break;

        case 80: // 'P'
            if(i == 6)
                return;
            break;

        case 83: // 'S'
            if(i == 13)
                return;
            break;
        }
        _b4vV();
    }

    private net.rim.tools.compiler.classfile.ConstantPoolFieldRef _b0vh()
        throws ByteCodeNotFoundException, IOException
    {
        _bXvV();
        switch(_bYvI())
        {
        case 179:
        case 181:
				net.rim.tools.compiler.classfile.ConstantPoolEntry _entry_ = _constantPool.getConstantPoolEntry(_b5vI());
				if(_entry_ instanceof net.rim.tools.compiler.classfile.ConstantPoolFieldRef)
					return (net.rim.tools.compiler.classfile.ConstantPoolFieldRef)_entry_;
            break;
        }
        _b4vV();
        return null;
    }

    private int _nullZI(boolean flag)
        throws IOException
    {
        int i = 0;
        try
        {
            i = _bUvI();
        }
        catch(ByteCodeNotFoundException aa1)
        {
            return 10;
        }
        if(i < 1)
            return 10;
        byte byte0 = 1;
        int k;
        try
        {
            k = _voidZI(flag);
            if(k == 6)
                byte0 = 2;
        }
        catch(ByteCodeNotFoundException aa2)
        {
            return 10;
        }
        net.rim.tools.compiler.classfile.ConstantPoolFieldRef h1 = null;
        int i1 = _resolver.getMaxStacksMap();
        boolean aflag[];
        long al[];
        boolean aflag1[];
        long al1[];
        try
        {
            al1 = new long[i];
            aflag = new boolean[i];
            al = new long[i1];
            aflag1 = new boolean[i1];
        }
        catch(OutOfMemoryError outofmemoryerror)
        {
            return 10;
        }
        int j1 = 0;
        int k1 = 0;
        try
        {
            aflag1[k1] = true;
            k1++;
            while(j1 != i)
            {
                try
                {
                    _b1vV();
                    aflag1[k1] = aflag1[k1 - 1];
                    al[k1] = al[k1 - 1];
                    k1++;
                    continue;
                }
                catch(ByteCodeNotFoundException aa3) { }
                try
                {
                    _bZvV();
                    aflag1[k1] = aflag1[k1 - 2];
                    al[k1] = al[k1 - 2];
                    k1++;
                    aflag1[k1] = aflag1[k1 - 2];
                    al[k1] = al[k1 - 2];
                    k1++;
                    continue;
                }
                catch(ByteCodeNotFoundException aa4) { }
                try
                {
                    al[k1] = _bUvI();
                    aflag1[k1] = false;
                    k1++;
                    continue;
                }
                catch(ByteCodeNotFoundException aa5) { }
                try
                {
                    al[k1] = _bWvI();
                    aflag1[k1] = true;
                    k1++;
                    continue;
                }
                catch(ByteCodeNotFoundException aa6) { }
                try
                {
                    al[k1] = _b2vJ();
                    aflag1[k1] = false;
                    k1++;
                    aflag1[k1] = false;
                    k1++;
                    continue;
                }
                catch(ByteCodeNotFoundException aa7)
                {
                    try
                    {
                        _aKIV(k);
                        int l1 = k1 - (1 + byte0);
                        int j2 = k1 - byte0;
                        int k2 = k1 - (2 + byte0);
                        if(!aflag1[k2])
                            return 10;
                        if(aflag1[l1])
                            return 10;
                        if(k == 13)
                        {
                            if(!aflag1[j2])
                                return 10;
                        } else
                        if(aflag1[j2])
                            return 10;
                        int l2 = (int)al[l1];
                        al1[l2] = al[j2];
                        if(!aflag[l2])
                            j1++;
                        aflag[l2] = true;
                        k1 = k2;
                    }
                    catch(ByteCodeNotFoundException aa8)
                    {
                        return 10;
                    }
                }
                try
                {
                    if(k1 != 1)
                        continue;
                    h1 = _b0vh();
                    z_j3I = z_lFI;
                    break;
                }
                catch(ByteCodeNotFoundException aa9) { }
            }
            if(k1 != 1)
                return 10;
            if(k == 13)
            {
                z_mkaString = new String[i];
                for(int i2 = i - 1; i2 >= 0; i2--)
                    z_mkaString[i2] = ((net.rim.tools.compiler.classfile.ConstantPoolString)_constantPool.getConstantPoolEntry((int)al1[i2])).getString();

            } else
            {
                z_jSl = new net.rim.tools.compiler.classfile.ConstantPoolArrayData(k, al1, h1);
            }
            return k;
        }
        catch(ArrayIndexOutOfBoundsException arrayindexoutofboundsexception)
        {
            return 10;
        }
    }

    public void walk(int i, byte __data[], net.rim.tools.compiler.classfile.ConstantPool __constantPool, net.rim.tools.compiler.analysis.InstructionResolver __resolver)
        throws CompileException, IOException
    {
        int ai[] = z_l7aI;
        boolean flag = (i & 4) != 0;
        boolean flag1 = (i & 0x2000) != 0;
        _data = __data;
        _constantPool = __constantPool;
        _resolver = __resolver;
        for(z_j3I = 0; z_j3I < _data.length;)
        {
            int k = z_j3I;
            int i1;
            if(flag && (i1 = _nullZI(flag1)) != 10)
            {
                if(i1 == 13)
                    _resolver._ifIIaV(k, 205, z_mkaString);
                else
                    _resolver._aIIV(k, 204, z_jSl);
                _resolver._nullIIV(k, z_j3I);
            } else
            {
                z_j3I = k;
                Object obj = null;
label0:
                switch(z_j7aI[_bYvI()])
                {
                default:
                    break;

                case -1:
                    switch(z_kTI)
                    {
                    default:
                        break;

                    case 132:
                        int ai1[] = z_l4aI;
                        ai1[0] = _aLII(1);
                        ai1[1] = _aIII(1);
                        _aIIaV(k, z_kTI, ai1);
                        break label0;

                    case 185:
							net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = _constantPool.getConstantPoolEntry(_aLII(2));
                        if(o1 instanceof ConstantPoolInterfaceMethodRef)
                        {
                            net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef y1 = (net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef)o1;
                            int i2 = _aLII(1);
                            if(_aLII(1) != 0)
                                throw new CompileException("Fourth byte of invokeinterface operands must be zero.");
                            _resolver._aIIyV(k, z_kTI, y1, i2);
                        } else
                        {
                            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
                        }
                        break label0;

                    case 171:
                        z_j3I += align(z_j3I);
                        int k1 = _aIII(4) + k;
                        int j2 = _aLII(4);
                        int l2 = j2;
                        if(l2 < 0 || l2 > 4096)
                            l2 = 0;
                        int ai2[] = new int[2 * l2 + 2];
                        int j3 = 0;
                        ai2[j3++] = k1;
                        for(ai2[j3++] = j2; --l2 >= 0; ai2[j3++] = _aIII(4) + k)
                            ai2[j3++] = _aIII(4);

                        _aIIaV(k, z_kTI, ai2);
                        break label0;

                    case 170:
                        z_j3I += align(z_j3I);
                        int l1 = _aIII(4) + k;
                        int k2 = _aIII(4);
                        int i3 = _aIII(4);
                        int k3 = (i3 - k2) + 1;
                        if(i3 < k2 || k3 > 8192)
                            k3 = 1;
                        int ai3[] = new int[3 + k3];
                        int l3 = 0;
                        ai3[l3++] = l1;
                        ai3[l3++] = k2;
                        for(ai3[l3++] = i3; --k3 >= 0; ai3[l3++] = _aIII(4) + k);
                        _aIIaV(k, z_kTI, ai3);
                        break label0;

                    case 197:
							net.rim.tools.compiler.classfile.ConstantPoolEntry o2 = _constantPool.getConstantPoolEntry(_aLII(2));
							if(o2 instanceof net.rim.tools.compiler.classfile.ConstantPoolClass)
                        {
                            net.rim.tools.compiler.classfile.ConstantPoolClass e1 = (net.rim.tools.compiler.classfile.ConstantPoolClass)o2;
                            _resolver._aIIeV(k, z_kTI, e1, _aLII(1), false);
                        } else
                        {
                            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
                        }
                        break label0;

                    case 196:
                        int ai4[];
                        switch(_bYvI())
                        {
                        case 132:
                            ai4 = z_l4aI;
                            ai4[0] = _aLII(2);
                            ai4[1] = _aLII(2);
                            break;

                        case 21: // '\025'
                        case 22: // '\026'
                        case 23: // '\027'
                        case 24: // '\030'
                        case 25: // '\031'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                        case 58: // ':'
                        case 169:
                            ai4 = z_l6aI;
                            ai4[0] = _aLII(2);
                            break;

                        default:
                            throw new CompileException("Bad opcode suffix of wide opcode: 0x" + Integer.toHexString(z_kTI));
                        }
                        _aIIaV(k, z_kTI, ai4);
                        break;
                    }
                    break;

                case 0: // '\0'
                    int ai5[] = z_l7aI;
                    _aIIaV(k, z_kTI, ai5);
                    break;

                case 3: // '\003'
                    int ai6[] = z_l6aI;
                    ai6[0] = _b3vI() + k;
                    _aIIaV(k, z_kTI, ai6);
                    break;

                case 4: // '\004'
                    _aIIV(k, z_kTI, _constantPool.getConstantPoolEntry(_b5vI()));
                    break;

                case 5: // '\005'
                    int ai7[] = z_l6aI;
                    ai7[0] = _b5vI();
                    _aIIaV(k, z_kTI, ai7);
                    break;

                case 2: // '\002'
                    int ai8[] = z_l6aI;
                    ai8[0] = _aJII(_b5vI());
                    _aIIaV(k, z_kTI, ai8);
                    break;

                case 1: // '\001'
                    int ai9[] = z_l6aI;
                    ai9[0] = _b3vI();
                    _aIIaV(k, z_kTI, ai9);
                    break;

                case -2:
                    throw new CompileException("Bad opcode: 0x" + Integer.toHexString(z_kTI));
                }
                _resolver._nullIIV(k, z_j3I);
            }
        }

        _constantPool = null;
        _resolver = null;
        _data = null;
    }

    public void fini()
    {
        _data = null;
        _resolver = null;
        _constantPool = null;
        z_jSl = null;
    }

}
