// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.sdk.rc.pkg_a;

import java.io.*;

public final class f
{

    public static final boolean z_gotoZ = false;
    public int z_aI;
    int z_newI;
    int z_intI;
    int z_doI;
    private int z_tryaI[];
    private int z_nullaI[];
    private int z_byteI;
    private int z_cI;
    private Reader z_ifReader;
    private boolean z_forZ;
    private boolean z_longZ;
    private char z_voidaC[];
    private char z_elseaC[];
    private int z_charI;
    private int z_bI;
    private int z_caseI;

    static final int _aCI(char c)
        throws IOException
    {
        switch(c)
        {
        case 48: // '0'
            return 0;

        case 49: // '1'
            return 1;

        case 50: // '2'
            return 2;

        case 51: // '3'
            return 3;

        case 52: // '4'
            return 4;

        case 53: // '5'
            return 5;

        case 54: // '6'
            return 6;

        case 55: // '7'
            return 7;

        case 56: // '8'
            return 8;

        case 57: // '9'
            return 9;

        case 65: // 'A'
        case 97: // 'a'
            return 10;

        case 66: // 'B'
        case 98: // 'b'
            return 11;

        case 67: // 'C'
        case 99: // 'c'
            return 12;

        case 68: // 'D'
        case 100: // 'd'
            return 13;

        case 69: // 'E'
        case 101: // 'e'
            return 14;

        case 70: // 'F'
        case 102: // 'f'
            return 15;

        case 58: // ':'
        case 59: // ';'
        case 60: // '<'
        case 61: // '='
        case 62: // '>'
        case 63: // '?'
        case 64: // '@'
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
        case 93: // ']'
        case 94: // '^'
        case 95: // '_'
        case 96: // '`'
        default:
            throw new IOException();
        }
    }

    private final void _aZV(boolean flag)
    {
        char ac[] = new char[z_newI + 2048];
        int ai[] = new int[z_newI + 2048];
        int ai1[] = new int[z_newI + 2048];
        try
        {
            if(flag)
            {
                System.arraycopy(z_elseaC, z_doI, ac, 0, z_newI - z_doI);
                System.arraycopy(z_elseaC, 0, ac, z_newI - z_doI, z_aI);
                z_elseaC = ac;
                System.arraycopy(z_tryaI, z_doI, ai, 0, z_newI - z_doI);
                System.arraycopy(z_tryaI, 0, ai, z_newI - z_doI, z_aI);
                z_tryaI = ai;
                System.arraycopy(z_nullaI, z_doI, ai1, 0, z_newI - z_doI);
                System.arraycopy(z_nullaI, 0, ai1, z_newI - z_doI, z_aI);
                z_nullaI = ai1;
                z_aI += z_newI - z_doI;
            } else
            {
                System.arraycopy(z_elseaC, z_doI, ac, 0, z_newI - z_doI);
                z_elseaC = ac;
                System.arraycopy(z_tryaI, z_doI, ai, 0, z_newI - z_doI);
                z_tryaI = ai;
                System.arraycopy(z_nullaI, z_doI, ai1, 0, z_newI - z_doI);
                z_nullaI = ai1;
                z_aI -= z_doI;
            }
        }
        catch(Throwable throwable)
        {
            throw new Error(throwable.getMessage());
        }
        z_intI = z_newI += 2048;
        z_doI = 0;
    }

    private final void _ifvV()
        throws IOException
    {
        if(z_charI == 4096)
            z_charI = z_bI = 0;
        int i;
        try
        {
            if((i = z_ifReader.read(z_voidaC, z_charI, 4096 - z_charI)) == -1)
            {
                z_ifReader.close();
                throw new IOException();
            } else
            {
                z_charI += i;
                return;
            }
        }
        catch(IOException ioexception)
        {
            if(z_aI != 0)
            {
                z_aI--;
                _aIV(0);
            } else
            {
                z_tryaI[z_aI] = z_cI;
                z_nullaI[z_aI] = z_byteI;
            }
            throw ioexception;
        }
    }

    private final char _gotovC()
        throws IOException
    {
        if(++z_bI >= z_charI)
            _ifvV();
        return z_voidaC[z_bI];
    }

    public final char _tryvC()
        throws IOException
    {
        if(z_caseI > 0)
        {
            z_caseI--;
            return z_elseaC[z_doI = z_aI != z_newI - 1 ? ++z_aI : (z_aI = 0)];
        } else
        {
            z_doI = 0;
            z_aI = -1;
            return _dovC();
        }
    }

    private final void _longvV()
    {
        if(z_intI == z_newI)
        {
            if(z_doI > 2048)
            {
                z_aI = 0;
                z_intI = z_doI;
            } else
            {
                _aZV(false);
            }
        } else
        if(z_intI > z_doI)
            z_intI = z_newI;
        else
        if(z_doI - z_intI < 2048)
            _aZV(true);
        else
            z_intI = z_doI;
    }

    private final void _ifCV(char c)
    {
        z_byteI++;
        if(z_longZ)
        {
            z_longZ = false;
            z_cI += z_byteI = 1;
        } else
        if(z_forZ)
        {
            z_forZ = false;
            if(c == '\n')
                z_longZ = true;
            else
                z_cI += z_byteI = 1;
        }
        switch(c)
        {
        case 13: // '\r'
            z_forZ = true;
            break;

        case 10: // '\n'
            z_longZ = true;
            break;

        case 9: // '\t'
            z_byteI--;
            z_byteI += 8 - (z_byteI & 7);
            break;
        }
        z_tryaI[z_aI] = z_cI;
        z_nullaI[z_aI] = z_byteI;
    }

    public final char _dovC()
        throws IOException
    {
        if(z_caseI > 0)
        {
            z_caseI--;
            return z_elseaC[z_aI != z_newI - 1 ? ++z_aI : (z_aI = 0)];
        }
        if(++z_aI == z_intI)
            _longvV();
        char c;
        if((z_elseaC[z_aI] = c = (char)(0xff & _gotovC())) == '\\')
        {
            _ifCV(c);
            int i = 1;
            do
            {
                if(++z_aI == z_intI)
                    _longvV();
                try
                {
                    if((z_elseaC[z_aI] = c = (char)(0xff & _gotovC())) != '\\')
                    {
                        _ifCV(c);
                        if(c == 'u' && (i & 1) == 1)
                        {
                            if(--z_aI < 0)
                                z_aI = z_newI - 1;
                        } else
                        {
                            _aIV(i);
                            return '\\';
                        }
                        break;
                    }
                }
                catch(IOException ioexception)
                {
                    if(i > 1)
                        _aIV(i);
                    return '\\';
                }
                _ifCV(c);
                i++;
            } while(true);
            try
            {
                while((c = (char)(0xff & _gotovC())) == 'u') 
                    z_byteI++;
                z_elseaC[z_aI] = c = (char)(_aCI(c) << 12 | _aCI((char)(0xff & _gotovC())) << 8 | _aCI((char)(0xff & _gotovC())) << 4 | _aCI((char)(0xff & _gotovC())));
                z_byteI += 4;
            }
            catch(IOException ioexception1)
            {
                throw new Error("Invalid escape character at line " + z_cI + " column " + z_byteI + ".");
            }
            if(i == 1)
            {
                return c;
            } else
            {
                _aIV(i - 1);
                return '\\';
            }
        } else
        {
            _ifCV(c);
            return c;
        }
    }

    public final int _intvI()
    {
        return z_nullaI[z_aI];
    }

    public final int _avI()
    {
        return z_tryaI[z_aI];
    }

    public final int _bytevI()
    {
        return z_nullaI[z_aI];
    }

    public final int _forvI()
    {
        return z_tryaI[z_aI];
    }

    public final int _elsevI()
    {
        return z_nullaI[z_doI];
    }

    public final int _charvI()
    {
        return z_tryaI[z_doI];
    }

    public final void _aIV(int i)
    {
        z_caseI += i;
        if((z_aI -= i) < 0)
            z_aI += z_newI;
    }

    public f(Reader reader, int i, int j, int k)
    {
        z_aI = -1;
        z_byteI = 0;
        z_cI = 1;
        z_forZ = false;
        z_longZ = false;
        z_charI = 0;
        z_bI = -1;
        z_caseI = 0;
        z_ifReader = reader;
        z_cI = i;
        z_byteI = j - 1;
        z_intI = z_newI = k;
        z_elseaC = new char[k];
        z_tryaI = new int[k];
        z_nullaI = new int[k];
        z_voidaC = new char[4096];
    }

    public f(Reader reader, int i, int j)
    {
        this(reader, i, j, 4096);
    }

    public void _aReaderIIV(Reader reader, int i, int j, int k)
    {
        z_ifReader = reader;
        z_cI = i;
        z_byteI = j - 1;
        if(z_elseaC == null || k != z_elseaC.length)
        {
            z_intI = z_newI = k;
            z_elseaC = new char[k];
            z_tryaI = new int[k];
            z_nullaI = new int[k];
            z_voidaC = new char[4096];
        }
        z_longZ = z_forZ = false;
        z_doI = z_caseI = z_charI = 0;
        z_bI = z_aI = -1;
    }

    public void _aReaderIV(Reader reader, int i, int j)
    {
        _aReaderIIV(reader, i, j, 4096);
    }

    public f(InputStream inputstream, int i, int j, int k)
    {
        this(((Reader) (new InputStreamReader(inputstream))), i, j, 4096);
    }

    public f(InputStream inputstream, int i, int j)
    {
        this(inputstream, i, j, 4096);
    }

    public void _aInputStreamIIV(InputStream inputstream, int i, int j, int k)
    {
        _aReaderIIV(new InputStreamReader(inputstream), i, j, 4096);
    }

    public void _aInputStreamIV(InputStream inputstream, int i, int j)
    {
        _aInputStreamIIV(inputstream, i, j, 4096);
    }

    public final String _casevString()
    {
        if(z_aI >= z_doI)
            return new String(z_elseaC, z_doI, (z_aI - z_doI) + 1);
        else
            return new String(z_elseaC, z_doI, z_newI - z_doI) + new String(z_elseaC, 0, z_aI + 1);
    }

    public final char[] _ifIaC(int i)
    {
        char ac[] = new char[i];
        if(z_aI + 1 >= i)
        {
            System.arraycopy(z_elseaC, (z_aI - i) + 1, ac, 0, i);
        } else
        {
            System.arraycopy(z_elseaC, z_newI - (i - z_aI - 1), ac, 0, i - z_aI - 1);
            System.arraycopy(z_elseaC, 0, ac, i - z_aI - 1, z_aI + 1);
        }
        return ac;
    }

    public void _newvV()
    {
        z_voidaC = null;
        z_elseaC = null;
        z_tryaI = null;
        z_nullaI = null;
    }

    public void _aIIV(int i, int j)
    {
        int k = z_doI;
        int l;
        if(z_aI >= z_doI)
            l = (z_aI - z_doI) + z_caseI + 1;
        else
            l = (z_newI - z_doI) + z_aI + 1 + z_caseI;
        int i1 = 0;
        int j1 = 0;
        boolean flag = false;
        boolean flag1 = false;
        int i2 = 0;
        int k1;
        for(; i1 < l && z_tryaI[j1 = k % z_newI] == z_tryaI[k1 = ++k % z_newI]; i1++)
        {
            z_tryaI[j1] = i;
            int l1 = (i2 + z_nullaI[k1]) - z_nullaI[j1];
            z_nullaI[j1] = j + i2;
            i2 = l1;
        }

        if(i1 < l)
        {
            z_tryaI[j1] = i++;
            z_nullaI[j1] = j + i2;
            while(i1++ < l) 
                if(z_tryaI[j1 = k % z_newI] != z_tryaI[++k % z_newI])
                    z_tryaI[j1] = i++;
                else
                    z_tryaI[j1] = i;
        }
        z_cI = z_tryaI[j1];
        z_byteI = z_nullaI[j1];
    }
}
