// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.sdk.rc.pkg_a;

import java.io.IOException;

// Referenced classes of package net.rim.a.a.a:
//            a, c, f, b

public class l
    implements cls_c
{

    static final long z_aHaJ[] = {
        -2L, -1L, -1L, -1L
    };
    static final long z_aGaJ[] = {
        0L, 0L, -1L, -1L
    };
    static final long z_aFaJ[] = {
        0x1ff00000fffffffeL, -16384L, 0xffffffffL, 0x600000000000000L
    };
    static final long z_aEaJ[] = {
        0L, 0L, 0L, 0xff7fffffff7fffffL
    };
    static final long z_aCaJ[] = {
        0L, -1L, -1L, -1L
    };
    static final long z_azaJ[] = {
        -1L, -1L, 65535L, 0L
    };
    static final long z_awaJ[] = {
        -1L, -1L, 0L, 0L
    };
    static final long z_avaJ[] = {
        0x3fffffffffffL, 0L, 0L, 0L
    };
    static final int z_aAaI[] = {
        34, 35, 40, 41, 44, 45, 12, 23, 24, 26, 
        14, 16, 49, 51, 6, 8, 9, 12, 23, 24, 
        28, 26, 36, 37, 12, 44, 45, 12, 10, 11, 
        17, 18, 20, 25, 27, 29, 38, 39, 42, 43, 
        46, 47
    };
    public static final String z_asaString[] = {
        "", null, null, null, null, null, null, null, null, null, 
        null, null, null, "boolean", "byte", "char", "class", "double", "false", "final", 
        "float", "int", "long", "new", "null", "package", "originalLocale", "resourceVersion", "dndTemplateString", "short", 
        "true", "void", null, null, null, null, null, null, null, null, 
        null, null, null, "(", ")", "{", "}", "[", "]", ";", 
        ",", ".", "=", ">", "<", "!", "~", ":", "==", "<=", 
        ">=", "!=", "||", "&&", "++", "--", "+", "-", "*", "/", 
        "&", "|", "^", "%", "<<", ">>", ">>>", "<RIM_CONFIGURATION>", "</RIM_CONFIGURATION>", "#"
    };
    public static final String z_alaString[] = {
        "DEFAULT", "IN_SINGLE_LINE_COMMENT", "IN_FORMAL_COMMENT", "IN_MULTI_LINE_COMMENT"
    };
    public static final int z_amaI[] = {
        -1, -1, -1, -1, -1, -1, 1, 2, 3, 0, 
        0, 0, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };
    static final long z_ajaJ[] = {
        0xfffff9d1ffffe001L, 65535L
    };
    static final long z_axaJ[] = {
        3646L, 0L
    };
    static final long z_ayaJ[] = {
        3584L, 0L
    };
    static final long z_anaJ[] = {
        4544L, 0L
    };
    private f z_aDf;
    private final int z_aqaI[];
    private final int z_aiaI[];
    StringBuffer z_atStringBuffer;
    int z_akI;
    int z_arI;
    protected char z_aIC;
    int z_aJI;
    int z_apI;
    int z_auI;
    int z_ahI;
    int z_aoI;
    int z_aBI;

    private final int _aIJI(int i, long l1, long l2)
    {
        switch(i)
        {
        case 0: // '\0'
            if((l1 & 320L) != 0L || (l2 & 32L) != 0L)
                return 2;
            if((l1 & 0x8000000000000L) != 0L)
                return 8;
            if((l1 & 0xffffe000L) != 0L)
            {
                z_aBI = 40;
                return 32;
            } else
            {
                return -1;
            }

        case 1: // '\001'
            if((l1 & 256L) != 0L)
                return 0;
            if((l1 & 0xffffe000L) != 0L)
            {
                if(z_aoI != 1)
                {
                    z_aBI = 40;
                    z_aoI = 1;
                }
                return 32;
            } else
            {
                return -1;
            }

        case 2: // '\002'
            if((l1 & 0xff5fe000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 2;
                return 32;
            }
            return (l1 & 0xa00000L) == 0L ? -1 : 32;

        case 3: // '\003'
            if((l1 & 0xc140c000L) != 0L)
                return 32;
            if((l1 & 0x3e1f2000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 3;
                return 32;
            } else
            {
                return -1;
            }

        case 4: // '\004'
            if((l1 & 0x1e022000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 4;
                return 32;
            }
            return (l1 & 0x201d0000L) == 0L ? -1 : 32;

        case 5: // '\005'
            if((l1 & 0x1e002000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 5;
                return 32;
            }
            return (l1 & 0x20000L) == 0L ? -1 : 32;

        case 6: // '\006'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 6;
                return 32;
            }
            return (l1 & 0x2002000L) == 0L ? -1 : 32;

        case 7: // '\007'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 7;
                return 32;
            } else
            {
                return -1;
            }

        case 8: // '\b'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 8;
                return 32;
            } else
            {
                return -1;
            }

        case 9: // '\t'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 9;
                return 32;
            } else
            {
                return -1;
            }

        case 10: // '\n'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 10;
                return 32;
            } else
            {
                return -1;
            }

        case 11: // '\013'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 11;
                return 32;
            } else
            {
                return -1;
            }

        case 12: // '\f'
            if((l1 & 0x1c000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 12;
                return 32;
            } else
            {
                return -1;
            }

        case 13: // '\r'
            if((l1 & 0x18000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 13;
                return 32;
            }
            return (l1 & 0x4000000L) == 0L ? -1 : 32;

        case 14: // '\016'
            if((l1 & 0x10000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 14;
                return 32;
            }
            return (l1 & 0x8000000L) == 0L ? -1 : 32;

        case 15: // '\017'
            if((l1 & 0x10000000L) != 0L)
            {
                z_aBI = 40;
                z_aoI = 15;
                return 32;
            } else
            {
                return -1;
            }

        case 16: // '\020'
            return (l1 & 0x10000000L) == 0L ? -1 : 32;
        }
        return -1;
    }

    private final int _ifIJI(int i, long l1, long l2)
    {
        return _aIII(_aIJI(i, l1, l2), i + 1);
    }

    private final int _doIII(int i, int j)
    {
        z_aBI = j;
        z_aoI = i;
        return i + 1;
    }

    private final int _aIII(int i, int j, int k)
    {
        z_aBI = j;
        z_aoI = i;
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            return i + 1;
        }
        return _aIII(k, i + 1);
    }

    private final int _tryvI()
    {
        switch(z_aIC)
        {
        case 33: // '!'
            z_aBI = 55;
            return _ifJJI(0x2000000000000000L, 0L);

        case 35: // '#'
            return _doIII(0, 79);

        case 37: // '%'
            return _doIII(0, 73);

        case 38: // '&'
            z_aBI = 70;
            return _ifJJI(0x8000000000000000L, 0L);

        case 40: // '('
            return _doIII(0, 43);

        case 41: // ')'
            return _doIII(0, 44);

        case 42: // '*'
            return _doIII(0, 68);

        case 43: // '+'
            z_aBI = 66;
            return _ifJJI(0L, 1L);

        case 44: // ','
            return _doIII(0, 50);

        case 45: // '-'
            z_aBI = 67;
            return _ifJJI(0L, 2L);

        case 46: // '.'
            return _aIII(0, 51, 8);

        case 47: // '/'
            z_aBI = 69;
            return _ifJJI(320L, 0L);

        case 58: // ':'
            return _doIII(0, 57);

        case 59: // ';'
            return _doIII(0, 49);

        case 60: // '<'
            z_aBI = 54;
            return _ifJJI(0x800000000000000L, 25600L);

        case 61: // '='
            z_aBI = 52;
            return _ifJJI(0x400000000000000L, 0L);

        case 62: // '>'
            z_aBI = 53;
            return _ifJJI(0x1000000000000000L, 6144L);

        case 91: // '['
            return _doIII(0, 47);

        case 93: // ']'
            return _doIII(0, 48);

        case 94: // '^'
            return _doIII(0, 72);

        case 98: // 'b'
            return _ifJJI(24576L, 0L);

        case 99: // 'c'
            return _ifJJI(0x18000L, 0L);

        case 100: // 'd'
            return _ifJJI(0x10020000L, 0L);

        case 102: // 'f'
            return _ifJJI(0x1c0000L, 0L);

        case 105: // 'i'
            return _ifJJI(0x200000L, 0L);

        case 108: // 'l'
            return _ifJJI(0x400000L, 0L);

        case 110: // 'n'
            return _ifJJI(0x1800000L, 0L);

        case 111: // 'o'
            return _ifJJI(0x4000000L, 0L);

        case 112: // 'p'
            return _ifJJI(0x2000000L, 0L);

        case 114: // 'r'
            return _ifJJI(0x8000000L, 0L);

        case 115: // 's'
            return _ifJJI(0x20000000L, 0L);

        case 116: // 't'
            return _ifJJI(0x40000000L, 0L);

        case 118: // 'v'
            return _ifJJI(0x80000000L, 0L);

        case 123: // '{'
            return _doIII(0, 45);

        case 124: // '|'
            z_aBI = 71;
            return _ifJJI(0x4000000000000000L, 0L);

        case 125: // '}'
            return _doIII(0, 46);

        case 126: // '~'
            return _doIII(0, 56);

        case 34: // '"'
        case 36: // '$'
        case 39: // '\''
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
        case 92: // '\\'
        case 95: // '_'
        case 96: // '`'
        case 97: // 'a'
        case 101: // 'e'
        case 103: // 'g'
        case 104: // 'h'
        case 106: // 'j'
        case 107: // 'k'
        case 109: // 'm'
        case 113: // 'q'
        case 117: // 'u'
        case 119: // 'w'
        case 120: // 'x'
        case 121: // 'y'
        case 122: // 'z'
        default:
            return _aIII(3, 0);
        }
    }

    private final int _ifJJI(long l1, long l2)
    {
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(0, l1, l2);
            return 1;
        }
        switch(z_aIC)
        {
        case 39: // '\''
        case 40: // '('
        case 41: // ')'
        case 44: // ','
        case 46: // '.'
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
        case 98: // 'b'
        case 99: // 'c'
        case 100: // 'd'
        case 102: // 'f'
        case 103: // 'g'
        case 106: // 'j'
        case 107: // 'k'
        case 109: // 'm'
        case 112: // 'p'
        case 113: // 'q'
        case 115: // 's'
        case 116: // 't'
        case 118: // 'v'
        case 119: // 'w'
        case 120: // 'x'
        case 122: // 'z'
        case 123: // '{'
        default:
            break;

        case 38: // '&'
            if((l1 & 0x8000000000000000L) != 0L)
                return _doIII(1, 63);
            break;

        case 42: // '*'
            if((l1 & 256L) != 0L)
                return _aIII(1, 8, 0);
            break;

        case 43: // '+'
            if((l2 & 1L) != 0L)
                return _doIII(1, 64);
            break;

        case 45: // '-'
            if((l2 & 2L) != 0L)
                return _doIII(1, 65);
            break;

        case 47: // '/'
            if((l1 & 64L) != 0L)
                return _doIII(1, 6);
            else
                return _elseJJJI(l1, 0L, l2, 16384L);

        case 60: // '<'
            if((l2 & 1024L) != 0L)
                return _doIII(1, 74);
            break;

        case 61: // '='
            if((l1 & 0x400000000000000L) != 0L)
                return _doIII(1, 58);
            if((l1 & 0x800000000000000L) != 0L)
                return _doIII(1, 59);
            if((l1 & 0x1000000000000000L) != 0L)
                return _doIII(1, 60);
            if((l1 & 0x2000000000000000L) != 0L)
                return _doIII(1, 61);
            break;

        case 62: // '>'
            if((l2 & 2048L) != 0L)
            {
                z_aBI = 75;
                z_aoI = 1;
            }
            return _elseJJJI(l1, 0L, l2, 4096L);

        case 82: // 'R'
            return _elseJJJI(l1, 0L, l2, 8192L);

        case 97: // 'a'
            return _elseJJJI(l1, 0x2040000L, l2, 0L);

        case 101: // 'e'
            return _elseJJJI(l1, 0x8800000L, l2, 0L);

        case 104: // 'h'
            return _elseJJJI(l1, 0x20008000L, l2, 0L);

        case 105: // 'i'
            return _elseJJJI(l1, 0x80000L, l2, 0L);

        case 108: // 'l'
            return _elseJJJI(l1, 0x110000L, l2, 0L);

        case 110: // 'n'
            return _elseJJJI(l1, 0x10200000L, l2, 0L);

        case 111: // 'o'
            return _elseJJJI(l1, 0x80422000L, l2, 0L);

        case 114: // 'r'
            return _elseJJJI(l1, 0x44000000L, l2, 0L);

        case 117: // 'u'
            return _elseJJJI(l1, 0x1000000L, l2, 0L);

        case 121: // 'y'
            return _elseJJJI(l1, 16384L, l2, 0L);

        case 124: // '|'
            if((l1 & 0x4000000000000000L) != 0L)
                return _doIII(1, 62);
            break;
        }
        return _ifIJI(0, l1, l2);
    }

    private final int _elseJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(0, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(1, l2, l4);
            return 2;
        }
        switch(z_aIC)
        {
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
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
        case 81: // 'Q'
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
        case 98: // 'b'
        case 101: // 'e'
        case 102: // 'f'
        case 103: // 'g'
        case 104: // 'h'
        case 106: // 'j'
        case 107: // 'k'
        case 109: // 'm'
        case 112: // 'p'
        case 113: // 'q'
        case 114: // 'r'
        case 118: // 'v'
        default:
            break;

        case 62: // '>'
            if((l4 & 4096L) != 0L)
                return _doIII(2, 76);
            break;

        case 73: // 'I'
            return _voidJJJI(l2, 0L, l4, 8192L);

        case 82: // 'R'
            return _voidJJJI(l2, 0L, l4, 16384L);

        case 97: // 'a'
            return _voidJJJI(l2, 0x18000L, l4, 0L);

        case 99: // 'c'
            return _voidJJJI(l2, 0x2000000L, l4, 0L);

        case 100: // 'd'
            return _voidJJJI(l2, 0x10000000L, l4, 0L);

        case 105: // 'i'
            return _voidJJJI(l2, 0x84000000L, l4, 0L);

        case 108: // 'l'
            return _voidJJJI(l2, 0x1040000L, l4, 0L);

        case 110: // 'n'
            return _voidJJJI(l2, 0x480000L, l4, 0L);

        case 111: // 'o'
            return _voidJJJI(l2, 0x20102000L, l4, 0L);

        case 115: // 's'
            return _voidJJJI(l2, 0x8000000L, l4, 0L);

        case 116: // 't'
            if((l2 & 0x200000L) != 0L)
                return _aIII(2, 21, 32);
            else
                return _voidJJJI(l2, 16384L, l4, 0L);

        case 117: // 'u'
            return _voidJJJI(l2, 0x40020000L, l4, 0L);

        case 119: // 'w'
            if((l2 & 0x800000L) != 0L)
                return _aIII(2, 23, 32);
            break;
        }
        return _ifIJI(1, l2, l4);
    }

    private final int _voidJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(1, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(2, l2, l4);
            return 3;
        }
        switch(z_aIC)
        {
        case 74: // 'J'
        case 75: // 'K'
        case 76: // 'L'
        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
        case 81: // 'Q'
        case 82: // 'R'
        case 83: // 'S'
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
        case 99: // 'c'
        case 102: // 'f'
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 109: // 'm'
        case 110: // 'n'
        case 112: // 'p'
        case 113: // 'q'
        default:
            break;

        case 73: // 'I'
            return _ifJJJI(l2, 0L, l4, 16384L);

        case 77: // 'M'
            return _ifJJJI(l2, 0L, l4, 8192L);

        case 84: // 'T'
            return _ifJJJI(l2, 0x10000000L, l4, 0L);

        case 97: // 'a'
            return _ifJJJI(l2, 0x180000L, l4, 0L);

        case 98: // 'b'
            return _ifJJJI(l2, 0x20000L, l4, 0L);

        case 100: // 'd'
            if((l2 & 0x80000000L) != 0L)
                return _aIII(3, 31, 32);
            break;

        case 101: // 'e'
            if((l2 & 16384L) != 0L)
                return _aIII(3, 14, 32);
            if((l2 & 0x40000000L) != 0L)
                return _aIII(3, 30, 32);
            break;

        case 103: // 'g'
            if((l2 & 0x400000L) != 0L)
                return _aIII(3, 22, 32);
            else
                return _ifJJJI(l2, 0x4000000L, l4, 0L);

        case 107: // 'k'
            return _ifJJJI(l2, 0x2000000L, l4, 0L);

        case 108: // 'l'
            if((l2 & 0x1000000L) != 0L)
                return _aIII(3, 24, 32);
            else
                return _ifJJJI(l2, 8192L, l4, 0L);

        case 111: // 'o'
            return _ifJJJI(l2, 0x8000000L, l4, 0L);

        case 114: // 'r'
            if((l2 & 32768L) != 0L)
                return _aIII(3, 15, 32);
            else
                return _ifJJJI(l2, 0x20000000L, l4, 0L);

        case 115: // 's'
            return _ifJJJI(l2, 0x50000L, l4, 0L);
        }
        return _ifIJI(2, l2, l4);
    }

    private final int _ifJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(2, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(3, l2, l4);
            return 4;
        }
        switch(z_aIC)
        {
        default:
            break;

        case 77: // 'M'
            return _newJJJI(l2, 0L, l4, 16384L);

        case 95: // '_'
            return _newJJJI(l2, 0L, l4, 8192L);

        case 97: // 'a'
            return _newJJJI(l2, 0x2000000L, l4, 0L);

        case 101: // 'e'
            if((l2 & 0x40000L) != 0L)
                return _aIII(4, 18, 32);
            else
                return _newJJJI(l2, 0x10002000L, l4, 0L);

        case 105: // 'i'
            return _newJJJI(l2, 0x4000000L, l4, 0L);

        case 108: // 'l'
            if((l2 & 0x80000L) != 0L)
                return _aIII(4, 19, 32);
            else
                return _newJJJI(l2, 0x20000L, l4, 0L);

        case 115: // 's'
            if((l2 & 0x10000L) != 0L)
                return _aIII(4, 16, 32);
            break;

        case 116: // 't'
            if((l2 & 0x100000L) != 0L)
                return _aIII(4, 20, 32);
            if((l2 & 0x20000000L) != 0L)
                return _aIII(4, 29, 32);
            break;

        case 117: // 'u'
            return _newJJJI(l2, 0x8000000L, l4, 0L);
        }
        return _ifIJI(3, l2, l4);
    }

    private final int _newJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(3, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(4, l2, l4);
            return 5;
        }
        switch(z_aIC)
        {
        case 67: // 'C'
            return _caseJJJI(l2, 0L, l4, 8192L);

        case 95: // '_'
            return _caseJJJI(l2, 0L, l4, 16384L);

        case 97: // 'a'
            return _caseJJJI(l2, 8192L, l4, 0L);

        case 101: // 'e'
            if((l2 & 0x20000L) != 0L)
                return _aIII(5, 17, 32);
            break;

        case 103: // 'g'
            return _caseJJJI(l2, 0x2000000L, l4, 0L);

        case 109: // 'm'
            return _caseJJJI(l2, 0x10000000L, l4, 0L);

        case 110: // 'n'
            return _caseJJJI(l2, 0x4000000L, l4, 0L);

        case 114: // 'r'
            return _caseJJJI(l2, 0x8000000L, l4, 0L);
        }
        return _ifIJI(4, l2, l4);
    }

    private final int _caseJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(4, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(5, l2, l4);
            return 6;
        }
        switch(z_aIC)
        {
        default:
            break;

        case 67: // 'C'
            return _longJJJI(l2, 0L, l4, 16384L);

        case 79: // 'O'
            return _longJJJI(l2, 0L, l4, 8192L);

        case 97: // 'a'
            return _longJJJI(l2, 0x4000000L, l4, 0L);

        case 99: // 'c'
            return _longJJJI(l2, 0x8000000L, l4, 0L);

        case 101: // 'e'
            if((l2 & 0x2000000L) != 0L)
                return _aIII(6, 25, 32);
            break;

        case 110: // 'n'
            if((l2 & 8192L) != 0L)
                return _aIII(6, 13, 32);
            break;

        case 112: // 'p'
            return _longJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(5, l2, l4);
    }

    private final int _longJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(5, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(6, l2, l4);
            return 7;
        }
        switch(z_aIC)
        {
        case 78: // 'N'
            return _bJJJI(l2, 0L, l4, 8192L);

        case 79: // 'O'
            return _bJJJI(l2, 0L, l4, 16384L);

        case 101: // 'e'
            return _bJJJI(l2, 0x8000000L, l4, 0L);

        case 108: // 'l'
            return _bJJJI(l2, 0x14000000L, l4, 0L);
        }
        return _ifIJI(6, l2, l4);
    }

    private final int _bJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(6, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(7, l2, l4);
            return 8;
        }
        switch(z_aIC)
        {
        case 70: // 'F'
            return _doJJJI(l2, 0L, l4, 8192L);

        case 76: // 'L'
            return _doJJJI(l2, 0x4000000L, l4, 0L);

        case 78: // 'N'
            return _doJJJI(l2, 0L, l4, 16384L);

        case 86: // 'V'
            return _doJJJI(l2, 0x8000000L, l4, 0L);

        case 97: // 'a'
            return _doJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(7, l2, l4);
    }

    private final int _doJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(7, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(8, l2, l4);
            return 9;
        }
        switch(z_aIC)
        {
        case 70: // 'F'
            return _forJJJI(l2, 0L, l4, 16384L);

        case 73: // 'I'
            return _forJJJI(l2, 0L, l4, 8192L);

        case 101: // 'e'
            return _forJJJI(l2, 0x8000000L, l4, 0L);

        case 111: // 'o'
            return _forJJJI(l2, 0x4000000L, l4, 0L);

        case 116: // 't'
            return _forJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(8, l2, l4);
    }

    private final int _forJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(8, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(9, l2, l4);
            return 10;
        }
        switch(z_aIC)
        {
        case 71: // 'G'
            return _tryJJJI(l2, 0L, l4, 8192L);

        case 73: // 'I'
            return _tryJJJI(l2, 0L, l4, 16384L);

        case 99: // 'c'
            return _tryJJJI(l2, 0x4000000L, l4, 0L);

        case 101: // 'e'
            return _tryJJJI(l2, 0x10000000L, l4, 0L);

        case 114: // 'r'
            return _tryJJJI(l2, 0x8000000L, l4, 0L);
        }
        return _ifIJI(9, l2, l4);
    }

    private final int _tryJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(9, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(10, l2, l4);
            return 11;
        }
        switch(z_aIC)
        {
        case 71: // 'G'
            return _charJJJI(l2, 0L, l4, 16384L);

        case 83: // 'S'
            return _charJJJI(l2, 0x10000000L, l4, 0L);

        case 85: // 'U'
            return _charJJJI(l2, 0L, l4, 8192L);

        case 97: // 'a'
            return _charJJJI(l2, 0x4000000L, l4, 0L);

        case 115: // 's'
            return _charJJJI(l2, 0x8000000L, l4, 0L);
        }
        return _ifIJI(10, l2, l4);
    }

    private final int _charJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(10, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(11, l2, l4);
            return 12;
        }
        switch(z_aIC)
        {
        case 82: // 'R'
            return _nullJJJI(l2, 0L, l4, 8192L);

        case 85: // 'U'
            return _nullJJJI(l2, 0L, l4, 16384L);

        case 105: // 'i'
            return _nullJJJI(l2, 0x8000000L, l4, 0L);

        case 108: // 'l'
            return _nullJJJI(l2, 0x4000000L, l4, 0L);

        case 116: // 't'
            return _nullJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(11, l2, l4);
    }

    private final int _nullJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(11, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(12, l2, l4);
            return 13;
        }
        switch(z_aIC)
        {
        case 65: // 'A'
            return _aJJJI(l2, 0L, l4, 8192L);

        case 82: // 'R'
            return _aJJJI(l2, 0L, l4, 16384L);

        case 101: // 'e'
            if((l2 & 0x4000000L) != 0L)
                return _aIII(13, 26, 32);
            break;

        case 111: // 'o'
            return _aJJJI(l2, 0x8000000L, l4, 0L);

        case 114: // 'r'
            return _aJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(12, l2, l4);
    }

    private final int _aJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(12, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(13, l2, l4);
            return 14;
        }
        switch(z_aIC)
        {
        case 65: // 'A'
            return _intJJJI(l2, 0L, l4, 16384L);

        case 84: // 'T'
            return _intJJJI(l2, 0L, l4, 8192L);

        case 105: // 'i'
            return _intJJJI(l2, 0x10000000L, l4, 0L);

        case 110: // 'n'
            if((l2 & 0x8000000L) != 0L)
                return _aIII(14, 27, 32);
            break;
        }
        return _ifIJI(13, l2, l4);
    }

    private final int _intJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(13, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(14, l2, l4);
            return 15;
        }
        switch(z_aIC)
        {
        case 73: // 'I'
            return _byteJJJI(l2, 0L, l4, 8192L);

        case 84: // 'T'
            return _byteJJJI(l2, 0L, l4, 16384L);

        case 110: // 'n'
            return _byteJJJI(l2, 0x10000000L, l4, 0L);
        }
        return _ifIJI(14, l2, l4);
    }

    private final int _byteJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(14, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(15, l2, l4);
            return 16;
        }
        switch(z_aIC)
        {
        case 73: // 'I'
            return _gotoJJJI(l2, 0L, l4, 16384L);

        case 79: // 'O'
            return _gotoJJJI(l2, 0L, l4, 8192L);

        case 103: // 'g'
            if((l2 & 0x10000000L) != 0L)
                return _aIII(16, 28, 32);
            break;
        }
        return _ifIJI(15, l2, l4);
    }

    private final int _gotoJJJI(long l1, long l2, long l3, long l4)
    {
        if(((l2 &= l1) | (l4 &= l3)) == 0L)
            return _ifIJI(15, l1, l3);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(16, 0L, l4);
            return 17;
        }
        switch(z_aIC)
        {
        case 78: // 'N'
            return _doJJI(l4, 8192L);

        case 79: // 'O'
            return _doJJI(l4, 16384L);
        }
        return _ifIJI(16, 0L, l4);
    }

    private final int _doJJI(long l1, long l2)
    {
        if((l2 &= l1) == 0L)
            return _ifIJI(16, 0L, l1);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(17, 0L, l2);
            return 18;
        }
        switch(z_aIC)
        {
        case 62: // '>'
            if((l2 & 8192L) != 0L)
                return _doIII(18, 77);
            break;

        case 78: // 'N'
            return _aJJI(l2, 16384L);
        }
        return _ifIJI(17, 0L, l2);
    }

    private final int _aJJI(long l1, long l2)
    {
        if((l2 &= l1) == 0L)
            return _ifIJI(17, 0L, l1);
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(18, 0L, l2);
            return 19;
        }
        switch(z_aIC)
        {
        case 62: // '>'
            if((l2 & 16384L) != 0L)
                return _doIII(19, 78);
            break;
        }
        return _ifIJI(18, 0L, l2);
    }

    private final void _ifIV(int i)
    {
        if(z_aqaI[i] != z_ahI)
        {
            z_aiaI[z_auI++] = i;
            z_aqaI[i] = z_ahI;
        }
    }

    private final void _newIIV(int i, int j)
    {
        do
            z_aiaI[z_auI++] = z_aAaI[i];
        while(i++ != j);
    }

    private final void _ifIIV(int i, int j)
    {
        _ifIV(i);
        _ifIV(j);
    }

    private final void _intIIV(int i, int j)
    {
        do
            _ifIV(z_aAaI[i]);
        while(i++ != j);
    }

    private final void _doIV(int i)
    {
        _ifIV(z_aAaI[i]);
        _ifIV(z_aAaI[i + 1]);
    }

    private final int _aIII(int i, int j)
    {
        int k = 0;
        z_auI = 52;
        int i1 = 1;
        z_aiaI[0] = i;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_ahI == 0x7fffffff)
                _intvV();
            if(z_aIC < '@')
            {
                long l1 = 1L << z_aIC;
                do
                    switch(z_aiaI[--i1])
                    {
                    case 3: // '\003'
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(0, 6);
                        else
                        if(z_aIC == '$')
                        {
                            if(j1 > 40)
                                j1 = 40;
                            _ifIV(32);
                        } else
                        if(z_aIC == '"')
                            _intIIV(7, 9);
                        else
                        if(z_aIC == '\'')
                            _newIIV(10, 11);
                        else
                        if(z_aIC == '.')
                            _ifIV(8);
                        else
                        if(z_aIC == '/')
                            z_aiaI[z_auI++] = 2;
                        if((0x3fe000000000000L & l1) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(5, 6);
                        } else
                        if(z_aIC == '0')
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _intIIV(12, 14);
                        }
                        break;

                    case 0: // '\0'
                        if(z_aIC == '*')
                            z_aiaI[z_auI++] = 1;
                        break;

                    case 1: // '\001'
                        if((0xffff7fffffffffffL & l1) != 0L && j1 > 7)
                            j1 = 7;
                        break;

                    case 2: // '\002'
                        if(z_aIC == '*')
                            z_aiaI[z_auI++] = 0;
                        break;

                    case 4: // '\004'
                        if((0x3fe000000000000L & l1) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(5, 6);
                        }
                        break;

                    case 5: // '\005'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(5, 6);
                        }
                        break;

                    case 7: // '\007'
                        if(z_aIC == '.')
                            _ifIV(8);
                        break;

                    case 8: // '\b'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _intIIV(15, 17);
                        }
                        break;

                    case 10: // '\n'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(11);
                        break;

                    case 11: // '\013'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _ifIIV(11, 12);
                        }
                        break;

                    case 13: // '\r'
                        if(z_aIC == '\'')
                            _newIIV(10, 11);
                        break;

                    case 14: // '\016'
                        if((0xffffff7fffffdbffL & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 15: // '\017'
                        if(z_aIC == '\'' && j1 > 38)
                            j1 = 38;
                        break;

                    case 17: // '\021'
                        if((0x8400000000L & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 18: // '\022'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIIV(19, 15);
                        break;

                    case 19: // '\023'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 20: // '\024'
                        if((0xf000000000000L & l1) != 0L)
                            z_aiaI[z_auI++] = 21;
                        break;

                    case 21: // '\025'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(19);
                        break;

                    case 22: // '\026'
                        if(z_aIC == '"')
                            _intIIV(7, 9);
                        break;

                    case 23: // '\027'
                        if((0xfffffffbffffdbffL & l1) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 25: // '\031'
                        if((0x8400000000L & l1) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 26: // '\032'
                        if(z_aIC == '"' && j1 > 39)
                            j1 = 39;
                        break;

                    case 27: // '\033'
                        if((0xff000000000000L & l1) != 0L)
                            _intIIV(18, 21);
                        break;

                    case 28: // '\034'
                        if((0xff000000000000L & l1) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 29: // '\035'
                        if((0xf000000000000L & l1) != 0L)
                            z_aiaI[z_auI++] = 30;
                        break;

                    case 30: // '\036'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(28);
                        break;

                    case 31: // '\037'
                        if(z_aIC == '$')
                        {
                            if(j1 > 40)
                                j1 = 40;
                            _ifIV(32);
                        }
                        break;

                    case 32: // ' '
                        if((0x3ff001000000000L & l1) != 0L)
                        {
                            if(j1 > 40)
                                j1 = 40;
                            _ifIV(32);
                        }
                        break;

                    case 33: // '!'
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(0, 6);
                        break;

                    case 34: // '"'
                        if((0x3ff000000000000L & l1) != 0L)
                            _ifIIV(34, 35);
                        break;

                    case 35: // '#'
                        if(z_aIC == '.')
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _intIIV(22, 24);
                        }
                        break;

                    case 36: // '$'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _intIIV(22, 24);
                        }
                        break;

                    case 38: // '&'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(39);
                        break;

                    case 39: // '\''
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _ifIIV(39, 12);
                        }
                        break;

                    case 40: // '('
                        if((0x3ff000000000000L & l1) != 0L)
                            _ifIIV(40, 41);
                        break;

                    case 42: // '*'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(43);
                        break;

                    case 43: // '+'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 36)
                                j1 = 36;
                            _ifIIV(43, 12);
                        }
                        break;

                    case 44: // ','
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(25, 27);
                        break;

                    case 46: // '.'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(47);
                        break;

                    case 47: // '/'
                        if((0x3ff000000000000L & l1) != 0L)
                            _ifIIV(47, 12);
                        break;

                    case 48: // '0'
                        if(z_aIC == '0')
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _intIIV(12, 14);
                        }
                        break;

                    case 50: // '2'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(50, 6);
                        }
                        break;

                    case 51: // '3'
                        if((0xff000000000000L & l1) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(51, 6);
                        }
                        break;
                    }
                while(i1 != k);
            } else
            if(z_aIC < '\200')
            {
                long l2 = 1L << (z_aIC & 0x3f);
                do
                    switch(z_aiaI[--i1])
                    {
                    case 3: // '\003'
                    case 32: // ' '
                        if((0x7fffffe87fffffeL & l2) != 0L)
                        {
                            if(j1 > 40)
                                j1 = 40;
                            _ifIV(32);
                        }
                        break;

                    case 1: // '\001'
                        if(j1 > 7)
                            j1 = 7;
                        break;

                    case 6: // '\006'
                        if((0x100000001000L & l2) != 0L && j1 > 32)
                            j1 = 32;
                        break;

                    case 9: // '\t'
                        if((0x2000000020L & l2) != 0L)
                            _newIIV(28, 29);
                        break;

                    case 12: // '\f'
                        if((0x5000000050L & l2) != 0L && j1 > 36)
                            j1 = 36;
                        break;

                    case 14: // '\016'
                        if((0xffffffffefffffffL & l2) != 0L)
                            _ifIV(15);
                        break;

                    case 16: // '\020'
                        if(z_aIC == '\\')
                            _newIIV(30, 32);
                        break;

                    case 17: // '\021'
                        if((0x14404410000000L & l2) != 0L)
                            _ifIV(15);
                        break;

                    case 23: // '\027'
                        if((0xffffffffefffffffL & l2) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 24: // '\030'
                        if(z_aIC == '\\')
                            _newIIV(33, 35);
                        break;

                    case 25: // '\031'
                        if((0x14404410000000L & l2) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 37: // '%'
                        if((0x2000000020L & l2) != 0L)
                            _newIIV(36, 37);
                        break;

                    case 41: // ')'
                        if((0x2000000020L & l2) != 0L)
                            _newIIV(38, 39);
                        break;

                    case 45: // '-'
                        if((0x2000000020L & l2) != 0L)
                            _newIIV(40, 41);
                        break;

                    case 49: // '1'
                        if((0x100000001000000L & l2) != 0L)
                            _ifIV(50);
                        break;

                    case 50: // '2'
                        if((0x7e0000007eL & l2) != 0L)
                        {
                            if(j1 > 32)
                                j1 = 32;
                            _ifIIV(50, 6);
                        }
                        break;
                    }
                while(i1 != k);
            } else
            {
                int k1 = z_aIC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_aIC & 0xff) >> 6;
                long l4 = 1L << (z_aIC & 0x3f);
                do
                    switch(z_aiaI[--i1])
                    {
                    case 3: // '\003'
                    case 32: // ' '
                        if(_ifIIIZ(k1, i2, j2, l3, l4))
                        {
                            if(j1 > 40)
                                j1 = 40;
                            _ifIV(32);
                        }
                        break;

                    case 1: // '\001'
                        if(_aIIIZ(k1, i2, j2, l3, l4) && j1 > 7)
                            j1 = 7;
                        break;

                    case 14: // '\016'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            z_aiaI[z_auI++] = 15;
                        break;

                    case 23: // '\027'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            _newIIV(7, 9);
                        break;
                    }
                while(i1 != k);
            }
            if(j1 != 0x7fffffff)
            {
                z_aBI = j1;
                z_aoI = j;
                j1 = 0x7fffffff;
            }
            j++;
            if((i1 = z_auI) == (k = 52 - (z_auI = k)))
                return j;
            try
            {
                z_aIC = z_aDf._dovC();
            }
            catch(IOException ioexception)
            {
                return j;
            }
        } while(true);
    }

    private final int _avI()
    {
        switch(z_aIC)
        {
        case 42: // '*'
            return _aJI(2048L);
        }
        return 1;
    }

    private final int _aJI(long l1)
    {
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_aIC)
        {
        case 47: // '/'
            if((l1 & 2048L) != 0L)
                return _doIII(1, 11);
            else
                return 2;
        }
        return 2;
    }

    private final int _dovI()
    {
        return _forIII(0, 0);
    }

    private final int _forIII(int i, int j)
    {
        int k = 0;
        z_auI = 3;
        int i1 = 1;
        z_aiaI[0] = i;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_ahI == 0x7fffffff)
                _intvV();
            if(z_aIC < '@')
            {
                long l1 = 1L << z_aIC;
                do
                    switch(z_aiaI[--i1])
                    {
                    case 0: // '\0'
                        if((9216L & l1) != 0L && j1 > 9)
                            j1 = 9;
                        if(z_aIC == '\r')
                            z_aiaI[z_auI++] = 1;
                        break;

                    case 1: // '\001'
                        if(z_aIC == '\n' && j1 > 9)
                            j1 = 9;
                        break;

                    case 2: // '\002'
                        if(z_aIC == '\r')
                            z_aiaI[z_auI++] = 1;
                        break;
                    }
                while(i1 != k);
            } else
            if(z_aIC < '\200')
            {
                long l2 = 1L << (z_aIC & 0x3f);
                do
                    switch(z_aiaI[--i1])
                    {
                    }
                while(i1 != k);
            } else
            {
                int k1 = z_aIC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_aIC & 0xff) >> 6;
                long l4 = 1L << (z_aIC & 0x3f);
                do
                    switch(z_aiaI[--i1])
                    {
                    }
                while(i1 != k);
            }
            if(j1 != 0x7fffffff)
            {
                z_aBI = j1;
                z_aoI = j;
                j1 = 0x7fffffff;
            }
            j++;
            if((i1 = z_auI) == (k = 3 - (z_auI = k)))
                return j;
            try
            {
                z_aIC = z_aDf._dovC();
            }
            catch(IOException ioexception)
            {
                return j;
            }
        } while(true);
    }

    private final int _newvI()
    {
        switch(z_aIC)
        {
        case 42: // '*'
            return _ifJI(1024L);
        }
        return 1;
    }

    private final int _ifJI(long l1)
    {
        try
        {
            z_aIC = z_aDf._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_aIC)
        {
        case 47: // '/'
            if((l1 & 1024L) != 0L)
                return _doIII(1, 10);
            else
                return 2;
        }
        return 2;
    }

    private static final boolean _aIIIZ(int i, int j, int k, long l1, long l2)
    {
        switch(i)
        {
        case 0: // '\0'
            return (z_aGaJ[k] & l2) != 0L;
        }
        return (z_aHaJ[j] & l1) != 0L;
    }

    private static final boolean _ifIIIZ(int i, int j, int k, long l1, long l2)
    {
        switch(i)
        {
        case 0: // '\0'
            return (z_aEaJ[k] & l2) != 0L;

        case 48: // '0'
            return (z_aCaJ[k] & l2) != 0L;

        case 49: // '1'
            return (z_azaJ[k] & l2) != 0L;

        case 51: // '3'
            return (z_awaJ[k] & l2) != 0L;

        case 61: // '='
            return (z_avaJ[k] & l2) != 0L;
        }
        return (z_aFaJ[j] & l1) != 0L;
    }

    public l(f f1)
    {
        z_aqaI = new int[52];
        z_aiaI = new int[104];
        z_aJI = 0;
        z_apI = 0;
        z_aDf = f1;
    }

    public l(f f1, int i)
    {
        this(f1);
        _aIV(i);
    }

    public void _afV(f f1)
    {
        z_aoI = z_auI = 0;
        z_aJI = z_apI;
        z_aDf = f1;
        _intvV();
    }

    private final void _intvV()
    {
        z_ahI = 0x80000001;
        for(int i = 52; i-- > 0;)
            z_aqaI[i] = 0x80000000;

    }

    public void _afvV(f f1, int i)
    {
        _afV(f1);
        _aIV(i);
    }

    public void _aIV(int i)
    {
        if(i >= 4 || i < 0)
        {
            throw new cls_a("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
        } else
        {
            z_aJI = i;
            return;
        }
    }

    private final cls_b _forvb()
    {
        cls_b b1 = cls_b._aIb(z_aBI);
        b1.z_doI = z_aBI;
        String s = z_asaString[z_aBI];
        b1.z_newString = s != null ? s : z_aDf._casevString();
        b1.z_aI = z_aDf._charvI();
        b1.z_intI = z_aDf._elsevI();
        b1.z_forI = z_aDf._forvI();
        b1.z_byteI = z_aDf._bytevI();
        return b1;
    }

    public final cls_b _ifvb()
    {
        cls_b b1 = null;
        int i = 0;
label0:
        do
        {
            try
            {
                z_aIC = z_aDf._tryvC();
            }
            catch(IOException ioexception)
            {
                z_aBI = 0;
                cls_b b2 = _forvb();
                b2.z_tryb = b1;
                return b2;
            }
            z_atStringBuffer = null;
            z_akI = 0;
            do
            {
                switch(z_aJI)
                {
                default:
                    break;

                case 0: // '\0'
                    try
                    {
                        z_aDf._aIV(0);
                        for(; z_aIC <= ' ' && (0x100003600L & 1L << z_aIC) != 0L; z_aIC = z_aDf._tryvC());
                    }
                    catch(IOException ioexception1)
                    {
                        continue label0;
                    }
                    z_aBI = 0x7fffffff;
                    z_aoI = 0;
                    i = _tryvI();
                    break;

                case 1: // '\001'
                    z_aBI = 0x7fffffff;
                    z_aoI = 0;
                    i = _dovI();
                    if(z_aoI == 0 && z_aBI > 12)
                        z_aBI = 12;
                    break;

                case 2: // '\002'
                    z_aBI = 0x7fffffff;
                    z_aoI = 0;
                    i = _newvI();
                    if(z_aoI == 0 && z_aBI > 12)
                        z_aBI = 12;
                    break;

                case 3: // '\003'
                    z_aBI = 0x7fffffff;
                    z_aoI = 0;
                    i = _avI();
                    if(z_aoI == 0 && z_aBI > 12)
                        z_aBI = 12;
                    break;
                }
                if(z_aBI == 0x7fffffff)
                    break;
                if(z_aoI + 1 < i)
                    z_aDf._aIV(i - z_aoI - 1);
                if((z_ajaJ[z_aBI >> 6] & 1L << (z_aBI & 0x3f)) != 0L)
                {
                    cls_b b3 = _forvb();
                    b3.z_tryb = b1;
                    if(z_amaI[z_aBI] != -1)
                        z_aJI = z_amaI[z_aBI];
                    return b3;
                }
                if((z_axaJ[z_aBI >> 6] & 1L << (z_aBI & 0x3f)) != 0L)
                {
                    if((z_ayaJ[z_aBI >> 6] & 1L << (z_aBI & 0x3f)) != 0L)
                    {
                        cls_b b4 = _forvb();
                        if(b1 == null)
                        {
                            b1 = b4;
                        } else
                        {
                            b4.z_tryb = b1;
                            b1 = b1.z_ifb = b4;
                        }
                        _abV(b4);
                    } else
                    {
                        _abV(null);
                    }
                    if(z_amaI[z_aBI] != -1)
                        z_aJI = z_amaI[z_aBI];
                } else
                {
                    z_akI += z_aoI + 1;
                    if(z_amaI[z_aBI] != -1)
                        z_aJI = z_amaI[z_aBI];
                    i = 0;
                    z_aBI = 0x7fffffff;
                    try
                    {
                        z_aIC = z_aDf._dovC();
                        continue;
                    }
                    catch(IOException ioexception2) { }
                    break;
                }
                continue label0;
            } while(true);
            int j = z_aDf._forvI();
            int k = z_aDf._bytevI();
            String s = null;
            boolean flag = false;
            try
            {
                z_aDf._dovC();
                z_aDf._aIV(1);
            }
            catch(IOException ioexception3)
            {
                flag = true;
                s = i > 1 ? z_aDf._casevString() : "";
                if(z_aIC == '\n' || z_aIC == '\r')
                {
                    j++;
                    k = 0;
                } else
                {
                    k++;
                }
            }
            if(!flag)
            {
                z_aDf._aIV(1);
                s = i > 1 ? z_aDf._casevString() : "";
            }
            throw new cls_a(flag, z_aJI, j, k, s, z_aIC, 0);
        } while(true);
    }

    final void _abV(cls_b b1)
    {
        switch(z_aBI)
        {
        default:
            return;
        }
    }

}
