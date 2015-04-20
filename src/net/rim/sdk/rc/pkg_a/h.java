// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.sdk.rc.pkg_a;

import java.io.IOException;

// Referenced classes of package net.rim.a.a.a:
//            a, i, f, b

public class h
    implements i
{

    static final long z_aEaJ[] = {
        -2L, -1L, -1L, -1L
    };
    static final long z_aDaJ[] = {
        0L, 0L, -1L, -1L
    };
    static final long z_aCaJ[] = {
        0x1ff00000fffffffeL, -16384L, 0xffffffffL, 0x600000000000000L
    };
    static final long z_aBaJ[] = {
        0L, 0L, 0L, 0xff7fffffff7fffffL
    };
    static final long z_azaJ[] = {
        0L, -1L, -1L, -1L
    };
    static final long z_awaJ[] = {
        -1L, -1L, 65535L, 0L
    };
    static final long z_ataJ[] = {
        -1L, -1L, 0L, 0L
    };
    static final long z_asaJ[] = {
        0x3fffffffffffL, 0L, 0L, 0L
    };
    static final int z_axaI[] = {
        38, 39, 44, 45, 48, 49, 12, 23, 24, 26, 
        14, 16, 5, 53, 2, 8, 9, 12, 23, 24, 
        28, 26, 40, 41, 12, 48, 49, 12, 10, 11, 
        17, 18, 20, 25, 27, 29, 42, 43, 46, 47, 
        50, 51
    };
    public static final String z_apaString[] = {
        "", null, null, null, null, null, "boolean", "byte", "char", "class", 
        "double", "false", "final", "float", "int", "long", "new", "null", "short", "true", 
        "void", null, null, null, null, null, null, null, null, null, 
        null, null, "(", ")", "{", "}", "[", "]", ";", ",", 
        ".", "=", ">", "<", "!", "~", "?", ":", "==", "<=", 
        ">=", "!=", "||", "&&", "++", "--", "+", "-", "*", "/", 
        "&", "|", "^", "%", "<<", ">>", ">>>", null, null, null, 
        null, null, null, null, "#"
    };
    public static final String z_aiaString[] = {
        "DEFAULT", "IN_SINGLE_LINE_COMMENT", "IN_FORMAL_COMMENT", "IN_MULTI_LINE_COMMENT"
    };
    public static final int z_ajaI[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, 1, 2, 3, 
        0, 0, 0, -1, -1
    };
    static final long z_agaJ[] = {
        0xffffffff3a3fffc1L, 1031L
    };
    static final long z_auaJ[] = {
        62L, 448L
    };
    static final long z_avaJ[] = {
        0L, 448L
    };
    static final long z_akaJ[] = {
        0L, 568L
    };
    private f z_aAf;
    private final int z_anaI[];
    private final int z_afaI[];
    StringBuffer z_aqStringBuffer;
    int z_ahI;
    int z_aoI;
    protected char z_aFC;
    int z_aGI;
    int z_amI;
    int z_arI;
    int z_aeI;
    int z_alI;
    int z_ayI;

    private final int _aIJI(int j, long l, long l1)
    {
        switch(j)
        {
        case 0: // '\0'
            if((l & 0x280000000000000L) != 0L)
                return 4;
            if((l & 0x1fffc0L) != 0L)
            {
                z_ayI = 29;
                return 32;
            }
            if((l & 0x10000000000L) != 0L)
                return 8;
            return (l & 0x800000000000000L) == 0L && (l1 & 40L) == 0L ? -1 : 35;

        case 1: // '\001'
            if((l1 & 32L) != 0L)
                return 33;
            if((l & 0x1fffc0L) != 0L)
            {
                if(z_alI != 1)
                {
                    z_ayI = 29;
                    z_alI = 1;
                }
                return 32;
            } else
            {
                return -1;
            }

        case 2: // '\002'
            if((l & 0x1ebfc0L) != 0L)
            {
                z_ayI = 29;
                z_alI = 2;
                return 32;
            }
            return (l & 0x14000L) == 0L ? -1 : 32;

        case 3: // '\003'
            if((l & 0x43e40L) != 0L)
            {
                z_ayI = 29;
                z_alI = 3;
                return 32;
            }
            return (l & 0x1a8180L) == 0L ? -1 : 32;

        case 4: // '\004'
            if((l & 1088L) != 0L)
            {
                z_ayI = 29;
                z_alI = 4;
                return 32;
            }
            return (l & 0x43a00L) == 0L ? -1 : 32;

        case 5: // '\005'
            if((l & 64L) != 0L)
            {
                z_ayI = 29;
                z_alI = 5;
                return 32;
            }
            return (l & 1024L) == 0L ? -1 : 32;
        }
        return -1;
    }

    private final int _ifIJI(int j, long l, long l1)
    {
        return _ifIII(_aIJI(j, l, l1), j + 1);
    }

    private final int _newIII(int j, int k)
    {
        z_ayI = k;
        z_alI = j;
        return j + 1;
    }

    private final int _aIII(int j, int k, int l)
    {
        z_ayI = k;
        z_alI = j;
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            return j + 1;
        }
        return _ifIII(l, j + 1);
    }

    private final int _forvI()
    {
        switch(z_aFC)
        {
        case 33: // '!'
            z_ayI = 44;
            return _doJJI(0x8000000000000L, 0L);

        case 35: // '#'
            return _newIII(0, 74);

        case 37: // '%'
            return _newIII(0, 63);

        case 38: // '&'
            z_ayI = 60;
            return _doJJI(0x20000000000000L, 0L);

        case 40: // '('
            return _newIII(0, 32);

        case 41: // ')'
            return _newIII(0, 33);

        case 42: // '*'
            return _newIII(0, 58);

        case 43: // '+'
            z_ayI = 56;
            return _doJJI(0x40000000000000L, 0L);

        case 44: // ','
            return _newIII(0, 39);

        case 45: // '-'
            z_ayI = 57;
            return _doJJI(0x80000000000000L, 0L);

        case 46: // '.'
            return _aIII(0, 40, 8);

        case 47: // '/'
            z_ayI = 59;
            return _doJJI(0L, 40L);

        case 58: // ':'
            return _newIII(0, 47);

        case 59: // ';'
            return _newIII(0, 38);

        case 60: // '<'
            z_ayI = 43;
            return _doJJI(0x2000000000000L, 1L);

        case 61: // '='
            z_ayI = 41;
            return _doJJI(0x1000000000000L, 0L);

        case 62: // '>'
            z_ayI = 42;
            return _doJJI(0x4000000000000L, 6L);

        case 63: // '?'
            return _newIII(0, 46);

        case 91: // '['
            return _newIII(0, 36);

        case 93: // ']'
            return _newIII(0, 37);

        case 94: // '^'
            return _newIII(0, 62);

        case 98: // 'b'
            return _doJJI(192L, 0L);

        case 99: // 'c'
            return _doJJI(768L, 0L);

        case 100: // 'd'
            return _doJJI(1024L, 0L);

        case 102: // 'f'
            return _doJJI(14336L, 0L);

        case 105: // 'i'
            return _doJJI(16384L, 0L);

        case 108: // 'l'
            return _doJJI(32768L, 0L);

        case 110: // 'n'
            return _doJJI(0x30000L, 0L);

        case 115: // 's'
            return _doJJI(0x40000L, 0L);

        case 116: // 't'
            return _doJJI(0x80000L, 0L);

        case 118: // 'v'
            return _doJJI(0x100000L, 0L);

        case 123: // '{'
            return _newIII(0, 34);

        case 124: // '|'
            z_ayI = 61;
            return _doJJI(0x10000000000000L, 0L);

        case 125: // '}'
            return _newIII(0, 35);

        case 126: // '~'
            return _newIII(0, 45);

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
        case 111: // 'o'
        case 112: // 'p'
        case 113: // 'q'
        case 114: // 'r'
        case 117: // 'u'
        case 119: // 'w'
        case 120: // 'x'
        case 121: // 'y'
        case 122: // 'z'
        default:
            return _ifIII(0, 0);
        }
    }

    private final int _doJJI(long l, long l1)
    {
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(0, l, l1);
            return 1;
        }
        switch(z_aFC)
        {
        default:
            break;

        case 38: // '&'
            if((l & 0x20000000000000L) != 0L)
                return _newIII(1, 53);
            break;

        case 42: // '*'
            if((l1 & 32L) != 0L)
                return _aIII(1, 69, 33);
            break;

        case 43: // '+'
            if((l & 0x40000000000000L) != 0L)
                return _newIII(1, 54);
            break;

        case 45: // '-'
            if((l & 0x80000000000000L) != 0L)
                return _newIII(1, 55);
            break;

        case 47: // '/'
            if((l1 & 8L) != 0L)
                return _newIII(1, 67);
            break;

        case 60: // '<'
            if((l1 & 1L) != 0L)
                return _newIII(1, 64);
            break;

        case 61: // '='
            if((l & 0x1000000000000L) != 0L)
                return _newIII(1, 48);
            if((l & 0x2000000000000L) != 0L)
                return _newIII(1, 49);
            if((l & 0x4000000000000L) != 0L)
                return _newIII(1, 50);
            if((l & 0x8000000000000L) != 0L)
                return _newIII(1, 51);
            break;

        case 62: // '>'
            if((l1 & 2L) != 0L)
            {
                z_ayI = 65;
                z_alI = 1;
            }
            return _aJJJI(l, 0L, l1, 4L);

        case 97: // 'a'
            return _aJJJI(l, 2048L, l1, 0L);

        case 101: // 'e'
            return _aJJJI(l, 0x10000L, l1, 0L);

        case 104: // 'h'
            return _aJJJI(l, 0x40100L, l1, 0L);

        case 105: // 'i'
            return _aJJJI(l, 4096L, l1, 0L);

        case 108: // 'l'
            return _aJJJI(l, 8704L, l1, 0L);

        case 110: // 'n'
            return _aJJJI(l, 16384L, l1, 0L);

        case 111: // 'o'
            return _aJJJI(l, 0x108440L, l1, 0L);

        case 114: // 'r'
            return _aJJJI(l, 0x80000L, l1, 0L);

        case 117: // 'u'
            return _aJJJI(l, 0x20000L, l1, 0L);

        case 121: // 'y'
            return _aJJJI(l, 128L, l1, 0L);

        case 124: // '|'
            if((l & 0x10000000000000L) != 0L)
                return _newIII(1, 52);
            break;
        }
        return _ifIJI(0, l, l1);
    }

    private final int _aJJJI(long l, long l1, long l2, long l3)
    {
        if(((l1 &= l) | (l3 &= l2)) == 0L)
            return _ifIJI(0, l, l2);
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(1, l1, l3);
            return 2;
        }
        switch(z_aFC)
        {
        default:
            break;

        case 62: // '>'
            if((l3 & 4L) != 0L)
                return _newIII(2, 66);
            break;

        case 97: // 'a'
            return _ifJJJI(l1, 768L, l3, 0L);

        case 105: // 'i'
            return _ifJJJI(l1, 0x100000L, l3, 0L);

        case 108: // 'l'
            return _ifJJJI(l1, 0x20800L, l3, 0L);

        case 110: // 'n'
            return _ifJJJI(l1, 36864L, l3, 0L);

        case 111: // 'o'
            return _ifJJJI(l1, 0x42040L, l3, 0L);

        case 116: // 't'
            if((l1 & 16384L) != 0L)
                return _aIII(2, 14, 32);
            else
                return _ifJJJI(l1, 128L, l3, 0L);

        case 117: // 'u'
            return _ifJJJI(l1, 0x80400L, l3, 0L);

        case 119: // 'w'
            if((l1 & 0x10000L) != 0L)
                return _aIII(2, 16, 32);
            break;
        }
        return _ifIJI(1, l1, l3);
    }

    private final int _ifJJJI(long l, long l1, long l2, long l3)
    {
        if(((l1 &= l) | (l3 &= l2)) == 0L)
            return _ifIJI(1, l, l2);
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(2, l1, 0L);
            return 3;
        }
        switch(z_aFC)
        {
        case 99: // 'c'
        case 102: // 'f'
        case 104: // 'h'
        case 105: // 'i'
        case 106: // 'j'
        case 107: // 'k'
        case 109: // 'm'
        case 110: // 'n'
        case 111: // 'o'
        case 112: // 'p'
        case 113: // 'q'
        default:
            break;

        case 97: // 'a'
            return _forJJI(l1, 12288L);

        case 98: // 'b'
            return _forJJI(l1, 1024L);

        case 100: // 'd'
            if((l1 & 0x100000L) != 0L)
                return _aIII(3, 20, 32);
            break;

        case 101: // 'e'
            if((l1 & 128L) != 0L)
                return _aIII(3, 7, 32);
            if((l1 & 0x80000L) != 0L)
                return _aIII(3, 19, 32);
            break;

        case 103: // 'g'
            if((l1 & 32768L) != 0L)
                return _aIII(3, 15, 32);
            break;

        case 108: // 'l'
            if((l1 & 0x20000L) != 0L)
                return _aIII(3, 17, 32);
            else
                return _forJJI(l1, 64L);

        case 114: // 'r'
            if((l1 & 256L) != 0L)
                return _aIII(3, 8, 32);
            else
                return _forJJI(l1, 0x40000L);

        case 115: // 's'
            return _forJJI(l1, 2560L);
        }
        return _ifIJI(2, l1, 0L);
    }

    private final int _forJJI(long l, long l1)
    {
        if((l1 &= l) == 0L)
            return _ifIJI(2, l, 0L);
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(3, l1, 0L);
            return 4;
        }
        switch(z_aFC)
        {
        default:
            break;

        case 101: // 'e'
            if((l1 & 2048L) != 0L)
                return _aIII(4, 11, 32);
            else
                return _aJJI(l1, 64L);

        case 108: // 'l'
            if((l1 & 4096L) != 0L)
                return _aIII(4, 12, 32);
            else
                return _aJJI(l1, 1024L);

        case 115: // 's'
            if((l1 & 512L) != 0L)
                return _aIII(4, 9, 32);
            break;

        case 116: // 't'
            if((l1 & 8192L) != 0L)
                return _aIII(4, 13, 32);
            if((l1 & 0x40000L) != 0L)
                return _aIII(4, 18, 32);
            break;
        }
        return _ifIJI(3, l1, 0L);
    }

    private final int _aJJI(long l, long l1)
    {
        if((l1 &= l) == 0L)
            return _ifIJI(3, l, 0L);
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(4, l1, 0L);
            return 5;
        }
        switch(z_aFC)
        {
        case 97: // 'a'
            return _ifJJI(l1, 64L);

        case 101: // 'e'
            if((l1 & 1024L) != 0L)
                return _aIII(5, 10, 32);
            break;
        }
        return _ifIJI(4, l1, 0L);
    }

    private final int _ifJJI(long l, long l1)
    {
        if((l1 &= l) == 0L)
            return _ifIJI(4, l, 0L);
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(5, l1, 0L);
            return 6;
        }
        switch(z_aFC)
        {
        case 110: // 'n'
            if((l1 & 64L) != 0L)
                return _aIII(6, 6, 32);
            break;
        }
        return _ifIJI(5, l1, 0L);
    }

    private final void _ifIV(int j)
    {
        if(z_anaI[j] != z_aeI)
        {
            z_afaI[z_arI++] = j;
            z_anaI[j] = z_aeI;
        }
    }

    private final void _aIIV(int j, int k)
    {
        do
            z_afaI[z_arI++] = z_axaI[j];
        while(j++ != k);
    }

    private final void _forIIV(int j, int k)
    {
        _ifIV(j);
        _ifIV(k);
    }

    private final void _intIIV(int j, int k)
    {
        do
            _ifIV(z_axaI[j]);
        while(j++ != k);
    }

    private final void _aIV(int j)
    {
        _ifIV(z_axaI[j]);
        _ifIV(z_axaI[j + 1]);
    }

    private final int _ifIII(int j, int k)
    {
        int l = 0;
        z_arI = 54;
        int i1 = 1;
        z_afaI[0] = j;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_aeI == 0x7fffffff)
                _newvV();
            if(z_aFC < '@')
            {
                long l1 = 1L << z_aFC;
                do
                    switch(z_afaI[--i1])
                    {
                    case 0: // '\0'
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(0, 6);
                        else
                        if(z_aFC == '/')
                            z_afaI[z_arI++] = 35;
                        else
                        if(z_aFC == '$')
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _ifIV(32);
                        } else
                        if(z_aFC == '"')
                            _intIIV(7, 9);
                        else
                        if(z_aFC == '\'')
                            _aIIV(10, 11);
                        else
                        if(z_aFC == '.')
                            _ifIV(8);
                        else
                        if(z_aFC == '-')
                            z_afaI[z_arI++] = 4;
                        if((0x3fe000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _forIIV(1, 2);
                        } else
                        if(z_aFC == '0')
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _intIIV(12, 14);
                        }
                        break;

                    case 1: // '\001'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _forIIV(1, 2);
                        }
                        break;

                    case 3: // '\003'
                        if(z_aFC == '-')
                            z_afaI[z_arI++] = 4;
                        break;

                    case 4: // '\004'
                        if(z_aFC == '0')
                            _ifIV(5);
                        break;

                    case 6: // '\006'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _forIIV(6, 2);
                        }
                        break;

                    case 7: // '\007'
                        if(z_aFC == '.')
                            _ifIV(8);
                        break;

                    case 8: // '\b'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
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
                            if(j1 > 25)
                                j1 = 25;
                            _forIIV(11, 12);
                        }
                        break;

                    case 13: // '\r'
                        if(z_aFC == '\'')
                            _aIIV(10, 11);
                        break;

                    case 14: // '\016'
                        if((0xffffff7fffffdbffL & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 15: // '\017'
                        if(z_aFC == '\'' && j1 > 27)
                            j1 = 27;
                        break;

                    case 17: // '\021'
                        if((0x8400000000L & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 18: // '\022'
                        if((0xff000000000000L & l1) != 0L)
                            _forIIV(19, 15);
                        break;

                    case 19: // '\023'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(15);
                        break;

                    case 20: // '\024'
                        if((0xf000000000000L & l1) != 0L)
                            z_afaI[z_arI++] = 21;
                        break;

                    case 21: // '\025'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(19);
                        break;

                    case 22: // '\026'
                        if(z_aFC == '"')
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
                        if(z_aFC == '"' && j1 > 28)
                            j1 = 28;
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
                            z_afaI[z_arI++] = 30;
                        break;

                    case 30: // '\036'
                        if((0xff000000000000L & l1) != 0L)
                            _ifIV(28);
                        break;

                    case 31: // '\037'
                        if(z_aFC == '$')
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _ifIV(32);
                        }
                        break;

                    case 32: // ' '
                        if((0x3ff001000000000L & l1) != 0L)
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _ifIV(32);
                        }
                        break;

                    case 33: // '!'
                        if(z_aFC == '*')
                            z_afaI[z_arI++] = 34;
                        break;

                    case 34: // '"'
                        if((0xffff7fffffffffffL & l1) != 0L && j1 > 68)
                            j1 = 68;
                        break;

                    case 35: // '#'
                        if(z_aFC == '*')
                            z_afaI[z_arI++] = 33;
                        break;

                    case 36: // '$'
                        if(z_aFC == '/')
                            z_afaI[z_arI++] = 35;
                        break;

                    case 37: // '%'
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(0, 6);
                        break;

                    case 38: // '&'
                        if((0x3ff000000000000L & l1) != 0L)
                            _forIIV(38, 39);
                        break;

                    case 39: // '\''
                        if(z_aFC == '.')
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _intIIV(22, 24);
                        }
                        break;

                    case 40: // '('
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _intIIV(22, 24);
                        }
                        break;

                    case 42: // '*'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(43);
                        break;

                    case 43: // '+'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _forIIV(43, 12);
                        }
                        break;

                    case 44: // ','
                        if((0x3ff000000000000L & l1) != 0L)
                            _forIIV(44, 45);
                        break;

                    case 46: // '.'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(47);
                        break;

                    case 47: // '/'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _forIIV(47, 12);
                        }
                        break;

                    case 48: // '0'
                        if((0x3ff000000000000L & l1) != 0L)
                            _intIIV(25, 27);
                        break;

                    case 50: // '2'
                        if((0x280000000000L & l1) != 0L)
                            _ifIV(51);
                        break;

                    case 51: // '3'
                        if((0x3ff000000000000L & l1) != 0L)
                            _forIIV(51, 12);
                        break;

                    case 52: // '4'
                        if(z_aFC == '0')
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _intIIV(12, 14);
                        }
                        break;

                    case 53: // '5'
                        if((0xff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _forIIV(53, 2);
                        }
                        break;
                    }
                while(i1 != l);
            } else
            if(z_aFC < '\200')
            {
                long l2 = 1L << (z_aFC & 0x3f);
                do
                    switch(z_afaI[--i1])
                    {
                    case 0: // '\0'
                    case 32: // ' '
                        if((0x7fffffe87fffffeL & l2) != 0L)
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _ifIV(32);
                        }
                        break;

                    case 2: // '\002'
                        if((0x100000001000L & l2) != 0L && j1 > 21)
                            j1 = 21;
                        break;

                    case 5: // '\005'
                        if((0x100000001000000L & l2) != 0L)
                            _ifIV(6);
                        break;

                    case 6: // '\006'
                        if((0x7e0000007eL & l2) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _forIIV(6, 2);
                        }
                        break;

                    case 9: // '\t'
                        if((0x2000000020L & l2) != 0L)
                            _aIIV(28, 29);
                        break;

                    case 12: // '\f'
                        if((0x5000000050L & l2) != 0L && j1 > 25)
                            j1 = 25;
                        break;

                    case 14: // '\016'
                        if((0xffffffffefffffffL & l2) != 0L)
                            _ifIV(15);
                        break;

                    case 16: // '\020'
                        if(z_aFC == '\\')
                            _aIIV(30, 32);
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
                        if(z_aFC == '\\')
                            _aIIV(33, 35);
                        break;

                    case 25: // '\031'
                        if((0x14404410000000L & l2) != 0L)
                            _intIIV(7, 9);
                        break;

                    case 34: // '"'
                        if(j1 > 68)
                            j1 = 68;
                        break;

                    case 41: // ')'
                        if((0x2000000020L & l2) != 0L)
                            _aIIV(36, 37);
                        break;

                    case 45: // '-'
                        if((0x2000000020L & l2) != 0L)
                            _aIIV(38, 39);
                        break;

                    case 49: // '1'
                        if((0x2000000020L & l2) != 0L)
                            _aIIV(40, 41);
                        break;
                    }
                while(i1 != l);
            } else
            {
                int k1 = z_aFC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_aFC & 0xff) >> 6;
                long l4 = 1L << (z_aFC & 0x3f);
                do
                    switch(z_afaI[--i1])
                    {
                    case 0: // '\0'
                    case 32: // ' '
                        if(_ifIIIZ(k1, i2, j2, l3, l4))
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _ifIV(32);
                        }
                        break;

                    case 14: // '\016'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            z_afaI[z_arI++] = 15;
                        break;

                    case 23: // '\027'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            _aIIV(7, 9);
                        break;

                    case 34: // '"'
                        if(_aIIIZ(k1, i2, j2, l3, l4) && j1 > 68)
                            j1 = 68;
                        break;
                    }
                while(i1 != l);
            }
            if(j1 != 0x7fffffff)
            {
                z_ayI = j1;
                z_alI = k;
                j1 = 0x7fffffff;
            }
            k++;
            if((i1 = z_arI) == (l = 54 - (z_arI = l)))
                return k;
            try
            {
                z_aFC = z_aAf._dovC();
            }
            catch(IOException ioexception)
            {
                return k;
            }
        } while(true);
    }

    private final int _avI()
    {
        switch(z_aFC)
        {
        case 42: // '*'
            return _aJI(256L);
        }
        return 1;
    }

    private final int _aJI(long l)
    {
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_aFC)
        {
        case 47: // '/'
            if((l & 256L) != 0L)
                return _newIII(1, 72);
            else
                return 2;
        }
        return 2;
    }

    private final int _intvI()
    {
        return _doIII(0, 0);
    }

    private final int _doIII(int j, int k)
    {
        int l = 0;
        z_arI = 3;
        int i1 = 1;
        z_afaI[0] = j;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_aeI == 0x7fffffff)
                _newvV();
            if(z_aFC < '@')
            {
                long l1 = 1L << z_aFC;
                do
                    switch(z_afaI[--i1])
                    {
                    case 0: // '\0'
                        if((9216L & l1) != 0L && j1 > 70)
                            j1 = 70;
                        if(z_aFC == '\r')
                            z_afaI[z_arI++] = 1;
                        break;

                    case 1: // '\001'
                        if(z_aFC == '\n' && j1 > 70)
                            j1 = 70;
                        break;

                    case 2: // '\002'
                        if(z_aFC == '\r')
                            z_afaI[z_arI++] = 1;
                        break;
                    }
                while(i1 != l);
            } else
            if(z_aFC < '\200')
            {
                long l2 = 1L << (z_aFC & 0x3f);
                do
                    switch(z_afaI[--i1])
                    {
                    }
                while(i1 != l);
            } else
            {
                int k1 = z_aFC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_aFC & 0xff) >> 6;
                long l4 = 1L << (z_aFC & 0x3f);
                do
                    switch(z_afaI[--i1])
                    {
                    }
                while(i1 != l);
            }
            if(j1 != 0x7fffffff)
            {
                z_ayI = j1;
                z_alI = k;
                j1 = 0x7fffffff;
            }
            k++;
            if((i1 = z_arI) == (l = 3 - (z_arI = l)))
                return k;
            try
            {
                z_aFC = z_aAf._dovC();
            }
            catch(IOException ioexception)
            {
                return k;
            }
        } while(true);
    }

    private final int _tryvI()
    {
        switch(z_aFC)
        {
        case 42: // '*'
            return _ifJI(128L);
        }
        return 1;
    }

    private final int _ifJI(long l)
    {
        try
        {
            z_aFC = z_aAf._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_aFC)
        {
        case 47: // '/'
            if((l & 128L) != 0L)
                return _newIII(1, 71);
            else
                return 2;
        }
        return 2;
    }

    private static final boolean _aIIIZ(int j, int k, int l, long l1, long l2)
    {
        switch(j)
        {
        case 0: // '\0'
            return (z_aDaJ[l] & l2) != 0L;
        }
        return (z_aEaJ[k] & l1) != 0L;
    }

    private static final boolean _ifIIIZ(int j, int k, int l, long l1, long l2)
    {
        switch(j)
        {
        case 0: // '\0'
            return (z_aBaJ[l] & l2) != 0L;

        case 48: // '0'
            return (z_azaJ[l] & l2) != 0L;

        case 49: // '1'
            return (z_awaJ[l] & l2) != 0L;

        case 51: // '3'
            return (z_ataJ[l] & l2) != 0L;

        case 61: // '='
            return (z_asaJ[l] & l2) != 0L;
        }
        return (z_aCaJ[k] & l1) != 0L;
    }

    public h(f f1)
    {
        z_anaI = new int[54];
        z_afaI = new int[108];
        z_aGI = 0;
        z_amI = 0;
        z_aAf = f1;
    }

    public h(f f1, int j)
    {
        this(f1);
        _doIV(j);
    }

    public void _afV(f f1)
    {
        z_alI = z_arI = 0;
        z_aGI = z_amI;
        z_aAf = f1;
        _newvV();
    }

    private final void _newvV()
    {
        z_aeI = 0x80000001;
        for(int j = 54; j-- > 0;)
            z_anaI[j] = 0x80000000;

    }

    public void _afvV(f f1, int j)
    {
        _afV(f1);
        _doIV(j);
    }

    public void _doIV(int j)
    {
        if(j >= 4 || j < 0)
        {
            throw new cls_a("Error: Ignoring invalid lexical state : " + j + ". State unchanged.", 2);
        } else
        {
            z_aGI = j;
            return;
        }
    }

    private final cls_b _dovb()
    {
        cls_b b1 = cls_b._aIb(z_ayI);
        b1.z_doI = z_ayI;
        String s = z_apaString[z_ayI];
        b1.z_newString = s != null ? s : z_aAf._casevString();
        b1.z_aI = z_aAf._charvI();
        b1.z_intI = z_aAf._elsevI();
        b1.z_forI = z_aAf._forvI();
        b1.z_byteI = z_aAf._bytevI();
        return b1;
    }

    public final cls_b _ifvb()
    {
        cls_b b1 = null;
        int j = 0;
label0:
        do
        {
            try
            {
                z_aFC = z_aAf._tryvC();
            }
            catch(IOException ioexception)
            {
                z_ayI = 0;
                cls_b b2 = _dovb();
                b2.z_tryb = b1;
                return b2;
            }
            z_aqStringBuffer = null;
            z_ahI = 0;
            do
            {
                switch(z_aGI)
                {
                default:
                    break;

                case 0: // '\0'
                    try
                    {
                        z_aAf._aIV(0);
                        for(; z_aFC <= ' ' && (0x100003600L & 1L << z_aFC) != 0L; z_aFC = z_aAf._tryvC());
                    }
                    catch(IOException ioexception1)
                    {
                        continue label0;
                    }
                    z_ayI = 0x7fffffff;
                    z_alI = 0;
                    j = _forvI();
                    break;

                case 1: // '\001'
                    z_ayI = 0x7fffffff;
                    z_alI = 0;
                    j = _intvI();
                    if(z_alI == 0 && z_ayI > 73)
                        z_ayI = 73;
                    break;

                case 2: // '\002'
                    z_ayI = 0x7fffffff;
                    z_alI = 0;
                    j = _tryvI();
                    if(z_alI == 0 && z_ayI > 73)
                        z_ayI = 73;
                    break;

                case 3: // '\003'
                    z_ayI = 0x7fffffff;
                    z_alI = 0;
                    j = _avI();
                    if(z_alI == 0 && z_ayI > 73)
                        z_ayI = 73;
                    break;
                }
                if(z_ayI == 0x7fffffff)
                    break;
                if(z_alI + 1 < j)
                    z_aAf._aIV(j - z_alI - 1);
                if((z_agaJ[z_ayI >> 6] & 1L << (z_ayI & 0x3f)) != 0L)
                {
                    cls_b b3 = _dovb();
                    b3.z_tryb = b1;
                    if(z_ajaI[z_ayI] != -1)
                        z_aGI = z_ajaI[z_ayI];
                    return b3;
                }
                if((z_auaJ[z_ayI >> 6] & 1L << (z_ayI & 0x3f)) != 0L)
                {
                    if((z_avaJ[z_ayI >> 6] & 1L << (z_ayI & 0x3f)) != 0L)
                    {
                        cls_b b4 = _dovb();
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
                    if(z_ajaI[z_ayI] != -1)
                        z_aGI = z_ajaI[z_ayI];
                } else
                {
                    z_ahI += z_alI + 1;
                    if(z_ajaI[z_ayI] != -1)
                        z_aGI = z_ajaI[z_ayI];
                    j = 0;
                    z_ayI = 0x7fffffff;
                    try
                    {
                        z_aFC = z_aAf._dovC();
                        continue;
                    }
                    catch(IOException ioexception2) { }
                    break;
                }
                continue label0;
            } while(true);
            int k = z_aAf._forvI();
            int l = z_aAf._bytevI();
            String s = null;
            boolean flag = false;
            try
            {
                z_aAf._dovC();
                z_aAf._aIV(1);
            }
            catch(IOException ioexception3)
            {
                flag = true;
                s = j > 1 ? z_aAf._casevString() : "";
                if(z_aFC == '\n' || z_aFC == '\r')
                {
                    k++;
                    l = 0;
                } else
                {
                    l++;
                }
            }
            if(!flag)
            {
                z_aAf._aIV(1);
                s = j > 1 ? z_aAf._casevString() : "";
            }
            throw new cls_a(flag, z_aGI, k, l, s, z_aFC, 0);
        } while(true);
    }

    final void _abV(cls_b b1)
    {
        switch(z_ayI)
        {
        default:
            return;
        }
    }

}
