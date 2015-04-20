// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.vm;


// Referenced classes of package net.rim.tools.compiler.b:
//            b

public final class IdEncode
{

    static final int z_intI = 256;
    static final char z_forC = 255;
    private static char z_aaC[] = new char[8];
    private static byte z_doaB[] = new byte[8];
    private static char z_ifaC[] = new char[256];

    public IdEncode()
    {
    }

    public static String encode(String _name)
    {
        int j1 = _name.length();
        if(j1 < 1)
            return _name;
        char ac[] = z_aaC;
        if(j1 > ac.length)
        {
            z_aaC = new char[j1];
            ac = z_aaC;
        }
        _name.getChars(0, j1, ac, 0);
        char ac1[] = z_ifaC;
        for(int i = ac1.length; --i >= 0;)
            ac1[i] = '\0';

        int k1 = 0;
        byte abyte0[] = z_doaB;
        if(j1 * 4 > abyte0.length)
        {
            z_doaB = new byte[j1 * 4];
            abyte0 = z_doaB;
        }
        char ac2[] = IdEncoding.codeChar2;
        int l1 = ac2.length;
        int i2 = 0;
        for(int j = 0; j < j1; j++)
        {
            char c = ac[j];
            if(c == '\377' || c < 0 || c >= l1 || ac2[c] != 0)
            {
                if(c > '\377')
                {
                    k1++;
                    abyte0[i2++] = -1;
                    abyte0[i2++] = (byte)(c >> 8 & 0xff);
                }
                k1++;
                abyte0[i2++] = -1;
            } else
            {
                ac1[c]++;
            }
            abyte0[i2++] = (byte)(c & 0xff);
        }

        char ac3[] = IdEncoding.codeChar1;
        for(int l = 0; l < 256 && i2 - k1 > 1; l++)
        {
            char c1 = ac2[l];
            if(c1 != 0 && ac1[c1] != 0)
            {
                char c2 = ac3[l];
                if(ac1[c2] != 0)
                {
                    int j2 = 1;
                    int k2 = 0;
                    char c3 = (char)(abyte0[0] & 0xff);
                    for(; j2 < i2; j2++)
                    {
                        char c4 = (char)(abyte0[j2] & 0xff);
                        if(c4 == '\377')
                        {
                            abyte0[k2++] = (byte)c3;
                            abyte0[k2++] = (byte)c4;
                            c3 = (char)(abyte0[++j2] & 0xff);
                            c4 = '\0';
                            if(++j2 < i2)
                                c4 = (char)(abyte0[j2] & 0xff);
                        } else
                        if(c3 == c2 && c4 == c1)
                        {
                            ac1[l]++;
                            if((--ac1[c3] == 0) | (--ac1[c4] == 0))
                            {
                                abyte0[k2++] = (byte)l;
                                for(j2++; j2 < i2;)
                                    abyte0[k2++] = abyte0[j2++];

                                c3 = '\0';
                                break;
                            }
                            c3 = (char)l;
                            c4 = '\0';
                            if(++j2 < i2)
                                c4 = (char)(abyte0[j2] & 0xff);
                        }
                        abyte0[k2++] = (byte)c3;
                        c3 = c4;
                    }

                    if(c3 != 0)
                        abyte0[k2++] = (byte)c3;
                    i2 = k2;
                }
            }
        }

        StringBuffer stringbuffer = new StringBuffer(i2);
        for(int i1 = 0; i1 < i2; i1++)
            stringbuffer.append((char)(abyte0[i1] & 0xff));

        return stringbuffer.toString();
    }

}
