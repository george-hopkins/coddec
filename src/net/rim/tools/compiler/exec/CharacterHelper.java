// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.io.IOException;

// Referenced classes of package net.rim.tools.compiler.c:
//            b

public class CharacterHelper
{

    private static char f_charArray[];
    private static char f_charArraySync[];

    public CharacterHelper()
    {
    }

    public static boolean isJavaIdentifierStart(char c)
    {
        return Character.isJavaIdentifierStart(c);
    }

    public static boolean isJavaIdentifierPart(char c)
    {
        return Character.isJavaIdentifierPart(c);
    }

    public static String intern(String s)
    {
        return s.intern();
    }

    public static String utf8ToString(byte abyte0[])
        throws IOException
    {
        return utf8ToString(abyte0, 0, abyte0.length);
    }

    public static String utf8ToString(byte param_byteArrayB[], int param_startOffsetI, int param_endOffsetI)
        throws IOException
    {
        String s = null;
        int i1 = 0;
        int j1 = param_startOffsetI + param_endOffsetI;
        for(int k = param_startOffsetI; k < j1; k++)
        {
            char c = (char)param_byteArrayB[k];
            if(c == 0)
                throw new IOException("invalid UTF-8 encoding");
            if((c & 0x80) != 0)
            {
                i1++;
                char c2 = (char)param_byteArrayB[++k];
                if((c2 & 0xc0) != 128)
                    throw new IOException("invalid UTF-8 encoding");
                if((c & 0xe0) != 192)
                    if((c & 0xf0) == 224)
                    {
                        i1++;
                        char c5 = (char)param_byteArrayB[++k];
                        if((c5 & 0xc0) != 128)
                            throw new IOException("invalid UTF-8 encoding");
                    } else
                    {
                        throw new IOException("invalid UTF-8 encoding");
                    }
            }
        }

        if(i1 == 0)
            s = new String(param_byteArrayB, param_startOffsetI, param_endOffsetI);
        else
            synchronized(f_charArraySync)
            {
                char loc_charArray[] = f_charArray;
                if(loc_charArray.length < param_endOffsetI - i1)
                {
                    loc_charArray = MyArrays.resize(loc_charArray, param_endOffsetI - i1);
                    f_charArray = loc_charArray;
                }
                int k1 = 0;
                for(int l = param_startOffsetI; l < j1; l++)
                {
                    char c1 = (char)param_byteArrayB[l];
                    if((c1 & 0x80) == 0)
                        loc_charArray[k1++] = c1;
                    else
                    if((c1 & 0xe0) == 192)
                    {
                        char c3 = (char)param_byteArrayB[++l];
                        loc_charArray[k1++] = (char)((c1 & 0x1f) << 6 | c3 & 0x3f);
                    } else
                    {
                        char c4 = (char)param_byteArrayB[++l];
                        char c6 = (char)param_byteArrayB[++l];
                        loc_charArray[k1++] = (char)((c1 & 0xf) << 12 | (c4 & 0x3f) << 6 | c6 & 0x3f);
                    }
                }

                s = new String(loc_charArray, 0, k1);
            }
        return intern(s);
    }

    static
    {
        f_charArray = new char[8];
        f_charArraySync = f_charArray;
    }
}
