// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc.pkg_a;

import java.io.IOException;

// Referenced classes of package net.rim.a.a.a:
//            a, j, f, b

public class cls_e
    implements j
{

    static final long z_a9aJ[] = {
        -2L, -1L, -1L, -1L
    };
    static final long z_a8aJ[] = {
        0L, 0L, -1L, -1L
    };
    static final long z_a7aJ[] = {
        0x1ff00000fffffffeL, -16384L, 0xffffffffL, 0x600000000000000L
    };
    static final long z_a6aJ[] = {
        0L, 0L, 0L, 0xff7fffffff7fffffL
    };
    static final long z_a4aJ[] = {
        0L, -1L, -1L, -1L
    };
    static final long z_a1aJ[] = {
        -1L, -1L, 65535L, 0L
    };
    static final long z_aYaJ[] = {
        -1L, -1L, 0L, 0L
    };
    static final long z_aXaJ[] = {
        0x3fffffffffffL, 0L, 0L, 0L
    };
    static final int z_a2aI[] = {
        38, 39, 44, 45, 48, 49, 12, 23, 24, 26,
        14, 16, 5, 53, 2, 8, 9, 12, 23, 24,
        28, 26, 40, 41, 12, 48, 49, 12, 10, 11,
        17, 18, 20, 25, 27, 29, 42, 43, 46, 47,
        50, 51
    };
    public static final String z_aUaString[] = {
        "", null, null, null, null, null, "boolean", "byte", "char", "class",
        "double", "false", "final", "float", "int", "long", "new", "null", "short", "true",
        "void", null, null, null, null, null, null, null, null, null,
        null, null, "(", ")", "{", "}", "[", "]", ";", ",",
        ".", "=", ">", "<", "!", "~", "?", ":", "==", "<=",
        ">=", "!=", "||", "&&", "++", "--", "+", "-", "*", "/",
        "&", "|", "^", "%", "<<", ">>", ">>>", null, null, null,
        null, null, null, null, "#"
    };
    public static final String z_aNaString[] = {
        "DEFAULT", "IN_SINGLE_LINE_COMMENT", "IN_FORMAL_COMMENT", "IN_MULTI_LINE_COMMENT"
    };
    public static final int z_aOaI[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
        -1, -1, -1, -1, -1, -1, -1, 1, 2, 3,
        0, 0, 0, -1, -1
    };
    static final long z_aLaJ[] = {
        0xffffffff3a3fffc1L, 1031L
    };
    static final long z_aZaJ[] = {
        62L, 448L
    };
    static final long z_a0aJ[] = {
        0L, 448L
    };
    static final long z_aPaJ[] = {
        0L, 568L
    };
    private f z_a5f;
    private final int z_aSaI[];
    private final int z_aKaI[];
    StringBuffer z_aVStringBuffer;
    int z_aMI;
    int z_aTI;
    protected char z_baC;
    int z_bbI;
    int z_aRI;
    int z_aWI;
    int z_aJI;
    int z_aQI;
    int z_a3I;

    private final int _aIJI(int i, long l, long l1)
    {
        switch(i)
        {
        case 0: // '\0'
            if((l & 0x280000000000000L) != 0L)
                return 4;
            if((l & 0x1fffc0L) != 0L)
            {
                z_a3I = 29;
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
                if(z_aQI != 1)
                {
                    z_a3I = 29;
                    z_aQI = 1;
                }
                return 32;
            } else
            {
                return -1;
            }

        case 2: // '\002'
            if((l & 0x1ebfc0L) != 0L)
            {
                z_a3I = 29;
                z_aQI = 2;
                return 32;
            }
            return (l & 0x14000L) == 0L ? -1 : 32;

        case 3: // '\003'
            if((l & 0x43e40L) != 0L)
            {
                z_a3I = 29;
                z_aQI = 3;
                return 32;
            }
            return (l & 0x1a8180L) == 0L ? -1 : 32;

        case 4: // '\004'
            if((l & 1088L) != 0L)
            {
                z_a3I = 29;
                z_aQI = 4;
                return 32;
            }
            return (l & 0x43a00L) == 0L ? -1 : 32;

        case 5: // '\005'
            if((l & 64L) != 0L)
            {
                z_a3I = 29;
                z_aQI = 5;
                return 32;
            }
            return (l & 1024L) == 0L ? -1 : 32;
        }
        return -1;
    }

    private final int _ifIJI(int i, long l, long l1)
    {
        return _forIII(_aIJI(i, l, l1), i + 1);
    }

    private final int _byteIII(int i, int k)
    {
        z_a3I = k;
        z_aQI = i;
        return i + 1;
    }

    private final int _aIII(int i, int k, int l)
    {
        z_a3I = k;
        z_aQI = i;
        try
        {
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            return i + 1;
        }
        return _forIII(l, i + 1);
    }

    private final int _jvI()
    {
        switch(z_baC)
        {
        case 33: // '!'
            z_a3I = 44;
            return _doJJI(0x8000000000000L, 0L);

        case 35: // '#'
            return _byteIII(0, 74);

        case 37: // '%'
            return _byteIII(0, 63);

        case 38: // '&'
            z_a3I = 60;
            return _doJJI(0x20000000000000L, 0L);

        case 40: // '('
            return _byteIII(0, 32);

        case 41: // ')'
            return _byteIII(0, 33);

        case 42: // '*'
            return _byteIII(0, 58);

        case 43: // '+'
            z_a3I = 56;
            return _doJJI(0x40000000000000L, 0L);

        case 44: // ','
            return _byteIII(0, 39);

        case 45: // '-'
            z_a3I = 57;
            return _doJJI(0x80000000000000L, 0L);

        case 46: // '.'
            return _aIII(0, 40, 8);

        case 47: // '/'
            z_a3I = 59;
            return _doJJI(0L, 40L);

        case 58: // ':'
            return _byteIII(0, 47);

        case 59: // ';'
            return _byteIII(0, 38);

        case 60: // '<'
            z_a3I = 43;
            return _doJJI(0x2000000000000L, 1L);

        case 61: // '='
            z_a3I = 41;
            return _doJJI(0x1000000000000L, 0L);

        case 62: // '>'
            z_a3I = 42;
            return _doJJI(0x4000000000000L, 6L);

        case 63: // '?'
            return _byteIII(0, 46);

        case 91: // '['
            return _byteIII(0, 36);

        case 93: // ']'
            return _byteIII(0, 37);

        case 94: // '^'
            return _byteIII(0, 62);

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
            return _byteIII(0, 34);

        case 124: // '|'
            z_a3I = 61;
            return _doJJI(0x10000000000000L, 0L);

        case 125: // '}'
            return _byteIII(0, 35);

        case 126: // '~'
            return _byteIII(0, 45);

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
            return _forIII(0, 0);
        }
    }

    private final int _doJJI(long l, long l1)
    {
        try
        {
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(0, l, l1);
            return 1;
        }
        switch(z_baC)
        {
        default:
            break;

        case 38: // '&'
            if((l & 0x20000000000000L) != 0L)
                return _byteIII(1, 53);
            break;

        case 42: // '*'
            if((l1 & 32L) != 0L)
                return _aIII(1, 69, 33);
            break;

        case 43: // '+'
            if((l & 0x40000000000000L) != 0L)
                return _byteIII(1, 54);
            break;

        case 45: // '-'
            if((l & 0x80000000000000L) != 0L)
                return _byteIII(1, 55);
            break;

        case 47: // '/'
            if((l1 & 8L) != 0L)
                return _byteIII(1, 67);
            break;

        case 60: // '<'
            if((l1 & 1L) != 0L)
                return _byteIII(1, 64);
            break;

        case 61: // '='
            if((l & 0x1000000000000L) != 0L)
                return _byteIII(1, 48);
            if((l & 0x2000000000000L) != 0L)
                return _byteIII(1, 49);
            if((l & 0x4000000000000L) != 0L)
                return _byteIII(1, 50);
            if((l & 0x8000000000000L) != 0L)
                return _byteIII(1, 51);
            break;

        case 62: // '>'
            if((l1 & 2L) != 0L)
            {
                z_a3I = 65;
                z_aQI = 1;
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
                return _byteIII(1, 52);
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(1, l1, l3);
            return 2;
        }
        switch(z_baC)
        {
        default:
            break;

        case 62: // '>'
            if((l3 & 4L) != 0L)
                return _byteIII(2, 66);
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(2, l1, 0L);
            return 3;
        }
        switch(z_baC)
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(3, l1, 0L);
            return 4;
        }
        switch(z_baC)
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(4, l1, 0L);
            return 5;
        }
        switch(z_baC)
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            _aIJI(5, l1, 0L);
            return 6;
        }
        switch(z_baC)
        {
        case 110: // 'n'
            if((l1 & 64L) != 0L)
                return _aIII(6, 6, 32);
            break;
        }
        return _ifIJI(5, l1, 0L);
    }

    private final void _tryIV(int i)
    {
        if(z_aSaI[i] != z_aJI)
        {
            z_aKaI[z_aWI++] = i;
            z_aSaI[i] = z_aJI;
        }
    }

    private final void _doIIV(int i, int k)
    {
        do
            z_aKaI[z_aWI++] = z_a2aI[i];
        while(i++ != k);
    }

    private final void _newIIV(int i, int k)
    {
        _tryIV(i);
        _tryIV(k);
    }

    private final void _tryIIV(int i, int k)
    {
        do
            _tryIV(z_a2aI[i]);
        while(i++ != k);
    }

    private final void _newIV(int i)
    {
        _tryIV(z_a2aI[i]);
        _tryIV(z_a2aI[i + 1]);
    }

    private final int _forIII(int i, int k)
    {
        int l = 0;
        z_aWI = 54;
        int i1 = 1;
        z_aKaI[0] = i;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_aJI == 0x7fffffff)
                _lvV();
            if(z_baC < '@')
            {
                long l1 = 1L << z_baC;
                do
                    switch(z_aKaI[--i1])
                    {
                    case 0: // '\0'
                        if((0x3ff000000000000L & l1) != 0L)
                            _tryIIV(0, 6);
                        else
                        if(z_baC == '/')
                            z_aKaI[z_aWI++] = 35;
                        else
                        if(z_baC == '$')
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _tryIV(32);
                        } else
                        if(z_baC == '"')
                            _tryIIV(7, 9);
                        else
                        if(z_baC == '\'')
                            _doIIV(10, 11);
                        else
                        if(z_baC == '.')
                            _tryIV(8);
                        else
                        if(z_baC == '-')
                            z_aKaI[z_aWI++] = 4;
                        if((0x3fe000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _newIIV(1, 2);
                        } else
                        if(z_baC == '0')
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _tryIIV(12, 14);
                        }
                        break;

                    case 1: // '\001'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _newIIV(1, 2);
                        }
                        break;

                    case 3: // '\003'
                        if(z_baC == '-')
                            z_aKaI[z_aWI++] = 4;
                        break;

                    case 4: // '\004'
                        if(z_baC == '0')
                            _tryIV(5);
                        break;

                    case 6: // '\006'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _newIIV(6, 2);
                        }
                        break;

                    case 7: // '\007'
                        if(z_baC == '.')
                            _tryIV(8);
                        break;

                    case 8: // '\b'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _tryIIV(15, 17);
                        }
                        break;

                    case 10: // '\n'
                        if((0x280000000000L & l1) != 0L)
                            _tryIV(11);
                        break;

                    case 11: // '\013'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _newIIV(11, 12);
                        }
                        break;

                    case 13: // '\r'
                        if(z_baC == '\'')
                            _doIIV(10, 11);
                        break;

                    case 14: // '\016'
                        if((0xffffff7fffffdbffL & l1) != 0L)
                            _tryIV(15);
                        break;

                    case 15: // '\017'
                        if(z_baC == '\'' && j1 > 27)
                            j1 = 27;
                        break;

                    case 17: // '\021'
                        if((0x8400000000L & l1) != 0L)
                            _tryIV(15);
                        break;

                    case 18: // '\022'
                        if((0xff000000000000L & l1) != 0L)
                            _newIIV(19, 15);
                        break;

                    case 19: // '\023'
                        if((0xff000000000000L & l1) != 0L)
                            _tryIV(15);
                        break;

                    case 20: // '\024'
                        if((0xf000000000000L & l1) != 0L)
                            z_aKaI[z_aWI++] = 21;
                        break;

                    case 21: // '\025'
                        if((0xff000000000000L & l1) != 0L)
                            _tryIV(19);
                        break;

                    case 22: // '\026'
                        if(z_baC == '"')
                            _tryIIV(7, 9);
                        break;

                    case 23: // '\027'
                        if((0xfffffffbffffdbffL & l1) != 0L)
                            _tryIIV(7, 9);
                        break;

                    case 25: // '\031'
                        if((0x8400000000L & l1) != 0L)
                            _tryIIV(7, 9);
                        break;

                    case 26: // '\032'
                        if(z_baC == '"' && j1 > 28)
                            j1 = 28;
                        break;

                    case 27: // '\033'
                        if((0xff000000000000L & l1) != 0L)
                            _tryIIV(18, 21);
                        break;

                    case 28: // '\034'
                        if((0xff000000000000L & l1) != 0L)
                            _tryIIV(7, 9);
                        break;

                    case 29: // '\035'
                        if((0xf000000000000L & l1) != 0L)
                            z_aKaI[z_aWI++] = 30;
                        break;

                    case 30: // '\036'
                        if((0xff000000000000L & l1) != 0L)
                            _tryIV(28);
                        break;

                    case 31: // '\037'
                        if(z_baC == '$')
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _tryIV(32);
                        }
                        break;

                    case 32: // ' '
                        if((0x3ff001000000000L & l1) != 0L)
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _tryIV(32);
                        }
                        break;

                    case 33: // '!'
                        if(z_baC == '*')
                            z_aKaI[z_aWI++] = 34;
                        break;

                    case 34: // '"'
                        if((0xffff7fffffffffffL & l1) != 0L && j1 > 68)
                            j1 = 68;
                        break;

                    case 35: // '#'
                        if(z_baC == '*')
                            z_aKaI[z_aWI++] = 33;
                        break;

                    case 36: // '$'
                        if(z_baC == '/')
                            z_aKaI[z_aWI++] = 35;
                        break;

                    case 37: // '%'
                        if((0x3ff000000000000L & l1) != 0L)
                            _tryIIV(0, 6);
                        break;

                    case 38: // '&'
                        if((0x3ff000000000000L & l1) != 0L)
                            _newIIV(38, 39);
                        break;

                    case 39: // '\''
                        if(z_baC == '.')
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _tryIIV(22, 24);
                        }
                        break;

                    case 40: // '('
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _tryIIV(22, 24);
                        }
                        break;

                    case 42: // '*'
                        if((0x280000000000L & l1) != 0L)
                            _tryIV(43);
                        break;

                    case 43: // '+'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _newIIV(43, 12);
                        }
                        break;

                    case 44: // ','
                        if((0x3ff000000000000L & l1) != 0L)
                            _newIIV(44, 45);
                        break;

                    case 46: // '.'
                        if((0x280000000000L & l1) != 0L)
                            _tryIV(47);
                        break;

                    case 47: // '/'
                        if((0x3ff000000000000L & l1) != 0L)
                        {
                            if(j1 > 25)
                                j1 = 25;
                            _newIIV(47, 12);
                        }
                        break;

                    case 48: // '0'
                        if((0x3ff000000000000L & l1) != 0L)
                            _tryIIV(25, 27);
                        break;

                    case 50: // '2'
                        if((0x280000000000L & l1) != 0L)
                            _tryIV(51);
                        break;

                    case 51: // '3'
                        if((0x3ff000000000000L & l1) != 0L)
                            _newIIV(51, 12);
                        break;

                    case 52: // '4'
                        if(z_baC == '0')
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _tryIIV(12, 14);
                        }
                        break;

                    case 53: // '5'
                        if((0xff000000000000L & l1) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _newIIV(53, 2);
                        }
                        break;
                    }
                while(i1 != l);
            } else
            if(z_baC < '\200')
            {
                long l2 = 1L << (z_baC & 0x3f);
                do
                    switch(z_aKaI[--i1])
                    {
                    case 0: // '\0'
                    case 32: // ' '
                        if((0x7fffffe87fffffeL & l2) != 0L)
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _tryIV(32);
                        }
                        break;

                    case 2: // '\002'
                        if((0x100000001000L & l2) != 0L && j1 > 21)
                            j1 = 21;
                        break;

                    case 5: // '\005'
                        if((0x100000001000000L & l2) != 0L)
                            _tryIV(6);
                        break;

                    case 6: // '\006'
                        if((0x7e0000007eL & l2) != 0L)
                        {
                            if(j1 > 21)
                                j1 = 21;
                            _newIIV(6, 2);
                        }
                        break;

                    case 9: // '\t'
                        if((0x2000000020L & l2) != 0L)
                            _doIIV(28, 29);
                        break;

                    case 12: // '\f'
                        if((0x5000000050L & l2) != 0L && j1 > 25)
                            j1 = 25;
                        break;

                    case 14: // '\016'
                        if((0xffffffffefffffffL & l2) != 0L)
                            _tryIV(15);
                        break;

                    case 16: // '\020'
                        if(z_baC == '\\')
                            _doIIV(30, 32);
                        break;

                    case 17: // '\021'
                        if((0x14404410000000L & l2) != 0L)
                            _tryIV(15);
                        break;

                    case 23: // '\027'
                        if((0xffffffffefffffffL & l2) != 0L)
                            _tryIIV(7, 9);
                        break;

                    case 24: // '\030'
                        if(z_baC == '\\')
                            _doIIV(33, 35);
                        break;

                    case 25: // '\031'
                        if((0x14404410000000L & l2) != 0L)
                            _tryIIV(7, 9);
                        break;

                    case 34: // '"'
                        if(j1 > 68)
                            j1 = 68;
                        break;

                    case 41: // ')'
                        if((0x2000000020L & l2) != 0L)
                            _doIIV(36, 37);
                        break;

                    case 45: // '-'
                        if((0x2000000020L & l2) != 0L)
                            _doIIV(38, 39);
                        break;

                    case 49: // '1'
                        if((0x2000000020L & l2) != 0L)
                            _doIIV(40, 41);
                        break;
                    }
                while(i1 != l);
            } else
            {
                int k1 = z_baC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_baC & 0xff) >> 6;
                long l4 = 1L << (z_baC & 0x3f);
                do
                    switch(z_aKaI[--i1])
                    {
                    case 0: // '\0'
                    case 32: // ' '
                        if(_ifIIIZ(k1, i2, j2, l3, l4))
                        {
                            if(j1 > 29)
                                j1 = 29;
                            _tryIV(32);
                        }
                        break;

                    case 14: // '\016'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            z_aKaI[z_aWI++] = 15;
                        break;

                    case 23: // '\027'
                        if(_aIIIZ(k1, i2, j2, l3, l4))
                            _doIIV(7, 9);
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
                z_a3I = j1;
                z_aQI = k;
                j1 = 0x7fffffff;
            }
            k++;
            if((i1 = z_aWI) == (l = 54 - (z_aWI = l)))
                return k;
            try
            {
                z_baC = z_a5f._dovC();
            }
            catch(IOException ioexception)
            {
                return k;
            }
        } while(true);
    }

    private final int _gvI()
    {
        switch(z_baC)
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_baC)
        {
        case 47: // '/'
            if((l & 256L) != 0L)
                return _byteIII(1, 72);
            else
                return 2;
        }
        return 2;
    }

    private final int _kvI()
    {
        return _intIII(0, 0);
    }

    private final int _intIII(int i, int k)
    {
        int l = 0;
        z_aWI = 3;
        int i1 = 1;
        z_aKaI[0] = i;
        int j1 = 0x7fffffff;
        do
        {
            if(++z_aJI == 0x7fffffff)
                _lvV();
            if(z_baC < '@')
            {
                long l1 = 1L << z_baC;
                do
                    switch(z_aKaI[--i1])
                    {
                    case 0: // '\0'
                        if((9216L & l1) != 0L && j1 > 70)
                            j1 = 70;
                        if(z_baC == '\r')
                            z_aKaI[z_aWI++] = 1;
                        break;

                    case 1: // '\001'
                        if(z_baC == '\n' && j1 > 70)
                            j1 = 70;
                        break;

                    case 2: // '\002'
                        if(z_baC == '\r')
                            z_aKaI[z_aWI++] = 1;
                        break;
                    }
                while(i1 != l);
            } else
            if(z_baC < '\200')
            {
                long l2 = 1L << (z_baC & 0x3f);
                do
                    switch(z_aKaI[--i1])
                    {
                    }
                while(i1 != l);
            } else
            {
                int k1 = z_baC >> 8;
                int i2 = k1 >> 6;
                long l3 = 1L << (k1 & 0x3f);
                int j2 = (z_baC & 0xff) >> 6;
                long l4 = 1L << (z_baC & 0x3f);
                do
                    switch(z_aKaI[--i1])
                    {
                    }
                while(i1 != l);
            }
            if(j1 != 0x7fffffff)
            {
                z_a3I = j1;
                z_aQI = k;
                j1 = 0x7fffffff;
            }
            k++;
            if((i1 = z_aWI) == (l = 3 - (z_aWI = l)))
                return k;
            try
            {
                z_baC = z_a5f._dovC();
            }
            catch(IOException ioexception)
            {
                return k;
            }
        } while(true);
    }

    private final int _mvI()
    {
        switch(z_baC)
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
            z_baC = z_a5f._dovC();
        }
        catch(IOException ioexception)
        {
            return 1;
        }
        switch(z_baC)
        {
        case 47: // '/'
            if((l & 128L) != 0L)
                return _byteIII(1, 71);
            else
                return 2;
        }
        return 2;
    }

    private static final boolean _aIIIZ(int i, int k, int l, long l1, long l2)
    {
        switch(i)
        {
        case 0: // '\0'
            return (z_a8aJ[l] & l2) != 0L;
        }
        return (z_a9aJ[k] & l1) != 0L;
    }

    private static final boolean _ifIIIZ(int i, int k, int l, long l1, long l2)
    {
        switch(i)
        {
        case 0: // '\0'
            return (z_a6aJ[l] & l2) != 0L;

        case 48: // '0'
            return (z_a4aJ[l] & l2) != 0L;

        case 49: // '1'
            return (z_a1aJ[l] & l2) != 0L;

        case 51: // '3'
            return (z_aYaJ[l] & l2) != 0L;

        case 61: // '='
            return (z_aXaJ[l] & l2) != 0L;
        }
        return (z_a7aJ[k] & l1) != 0L;
    }

    public cls_e(f f1)
    {
        z_aSaI = new int[54];
        z_aKaI = new int[108];
        z_bbI = 0;
        z_aRI = 0;
        z_a5f = f1;
    }

    public cls_e(f f1, int i)
    {
        this(f1);
        _byteIV(i);
    }

    public void _afV(f f1)
    {
        z_aQI = z_aWI = 0;
        z_bbI = z_aRI;
        z_a5f = f1;
        _lvV();
    }

    private final void _lvV()
    {
        z_aJI = 0x80000001;
        for(int i = 54; i-- > 0;)
            z_aSaI[i] = 0x80000000;

    }

    public void _afvV(f f1, int i)
    {
        _afV(f1);
        _byteIV(i);
    }

    public void _byteIV(int i)
    {
        if(i >= 4 || i < 0)
        {
            throw new cls_a("Error: Ignoring invalid lexical state : " + i + ". State unchanged.", 2);
        } else
        {
            z_bbI = i;
            return;
        }
    }

    private final cls_b _ivb()
    {
        cls_b b1 = cls_b._aIb(z_a3I);
        b1.z_doI = z_a3I;
        String s = z_aUaString[z_a3I];
        b1.z_newString = s != null ? s : z_a5f._casevString();
        b1.z_aI = z_a5f._charvI();
        b1.z_intI = z_a5f._elsevI();
        b1.z_forI = z_a5f._forvI();
        b1.z_byteI = z_a5f._bytevI();
        return b1;
    }

    public final cls_b _hvb()
    {
        cls_b b1 = null;
        int i = 0;
label0:
        do
        {
            try
            {
                z_baC = z_a5f._tryvC();
            }
            catch(IOException ioexception)
            {
                z_a3I = 0;
                cls_b b2 = _ivb();
                b2.z_tryb = b1;
                return b2;
            }
            z_aVStringBuffer = null;
            z_aMI = 0;
            do
            {
                switch(z_bbI)
                {
                default:
                    break;

                case 0: // '\0'
                    try
                    {
                        z_a5f._aIV(0);
                        for(; z_baC <= ' ' && (0x100003600L & 1L << z_baC) != 0L; z_baC = z_a5f._tryvC());
                    }
                    catch(IOException ioexception1)
                    {
                        continue label0;
                    }
                    z_a3I = 0x7fffffff;
                    z_aQI = 0;
                    i = _jvI();
                    break;

                case 1: // '\001'
                    z_a3I = 0x7fffffff;
                    z_aQI = 0;
                    i = _kvI();
                    if(z_aQI == 0 && z_a3I > 73)
                        z_a3I = 73;
                    break;

                case 2: // '\002'
                    z_a3I = 0x7fffffff;
                    z_aQI = 0;
                    i = _mvI();
                    if(z_aQI == 0 && z_a3I > 73)
                        z_a3I = 73;
                    break;

                case 3: // '\003'
                    z_a3I = 0x7fffffff;
                    z_aQI = 0;
                    i = _gvI();
                    if(z_aQI == 0 && z_a3I > 73)
                        z_a3I = 73;
                    break;
                }
                if(z_a3I == 0x7fffffff)
                    break;
                if(z_aQI + 1 < i)
                    z_a5f._aIV(i - z_aQI - 1);
                if((z_aLaJ[z_a3I >> 6] & 1L << (z_a3I & 0x3f)) != 0L)
                {
                    cls_b b3 = _ivb();
                    b3.z_tryb = b1;
                    if(z_aOaI[z_a3I] != -1)
                        z_bbI = z_aOaI[z_a3I];
                    return b3;
                }
                if((z_aZaJ[z_a3I >> 6] & 1L << (z_a3I & 0x3f)) != 0L)
                {
                    if((z_a0aJ[z_a3I >> 6] & 1L << (z_a3I & 0x3f)) != 0L)
                    {
                        cls_b b4 = _ivb();
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
                    if(z_aOaI[z_a3I] != -1)
                        z_bbI = z_aOaI[z_a3I];
                } else
                {
                    z_aMI += z_aQI + 1;
                    if(z_aOaI[z_a3I] != -1)
                        z_bbI = z_aOaI[z_a3I];
                    i = 0;
                    z_a3I = 0x7fffffff;
                    try
                    {
                        z_baC = z_a5f._dovC();
                        continue;
                    }
                    catch(IOException ioexception2) { }
                    break;
                }
                continue label0;
            } while(true);
            int k = z_a5f._forvI();
            int l = z_a5f._bytevI();
            String s = null;
            boolean flag = false;
            try
            {
                z_a5f._dovC();
                z_a5f._aIV(1);
            }
            catch(IOException ioexception3)
            {
                flag = true;
                s = i > 1 ? z_a5f._casevString() : "";
                if(z_baC == '\n' || z_baC == '\r')
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
                z_a5f._aIV(1);
                s = i > 1 ? z_a5f._casevString() : "";
            }
            throw new cls_a(flag, z_bbI, k, l, s, z_baC, 0);
        } while(true);
    }

    final void _abV(cls_b b1)
    {
        switch(z_a3I)
        {
        default:
            return;
        }
    }

}
