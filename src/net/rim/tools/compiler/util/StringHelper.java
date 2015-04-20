// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;

import net.rim.tools.compiler.exec.CharacterHelper;

public final class StringHelper
{

    public StringHelper()
    {
    }

    public static String _aStringString(String s)
    {
        if(s == null)
            return null;
        int i = s.length();
        int j;
        for(j = 0; j < i && s.charAt(j) == ' '; j++);
        int k;
        for(k = i; k > j && s.charAt(k - 1) == ' '; k--);
        if(j > 0 || k < i)
            s = s.substring(j, k);
        return s;
    }

    public static int _aStringI(String s, String s1)
    {
        return _ifStringI(s, s1, s.length());
    }

    public static int _ifStringI(String s, String s1)
    {
        return _aStringI(s, s1, 0);
    }

    public static int _aStringI(String s, String s1, int i)
    {
        int j = s.length();
        int k = j - s1.length();
        if(i >= j)
            return -1;
        if(i < 0)
            i = 0;
        if(s1.length() == 0)
            return i;
        int l = i;
        byte abyte0[] = s.getBytes();
        byte abyte1[] = s1.getBytes();
        byte byte0 = abyte1[0];
label0:
        do
        {
            while(l <= k && abyte0[l] != byte0)
                l++;
            if(l > k)
                return -1;
            int i1 = l + 1;
            int j1 = (i1 + s1.length()) - 1;
            int k1 = 1;
            while(i1 < j1)
                if(abyte0[i1++] != abyte1[k1++])
                {
                    l++;
                    continue label0;
                }
            return l;
        } while(true);
    }

    public static int _ifStringI(String s, String s1, int i)
    {
        int j = s.length();
        int k = j - s1.length();
        if(i < 0)
            return -1;
        if(i > k)
            i = k;
        if(s1.length() == 0)
            return i;
        int l = s1.length() - 1;
        int i1 = s1.length() - 1;
        int j1 = i1 + i;
        byte abyte0[] = s.getBytes();
        byte abyte1[] = s1.getBytes();
        byte byte0 = abyte1[l];
label0:
        do
        {
            while(j1 >= i1 && abyte0[j1] != byte0)
                j1--;
            if(j1 < i1)
                return -1;
            int k1 = j1 - 1;
            int l1 = k1 - (s1.length() - 1);
            int i2 = l - 1;
            while(k1 > l1)
                if(abyte0[k1--] != abyte1[i2--])
                {
                    j1--;
                    continue label0;
                }
            return l1 + 1;
        } while(true);
    }

    public static boolean _ifStringZ(String s)
    {
        int i = s.length();
        if(i == 0)
            return false;
        if(!CharacterHelper.isJavaIdentifierStart(s.charAt(0)))
            return false;
        for(int j = 1; j < i; j++)
            if(!CharacterHelper.isJavaIdentifierPart(s.charAt(j)))
                return false;

        return true;
    }

    public static String _aStringSString(String s, String s1, String s2)
    {
        int i = _ifStringI(s, s1);
        if(i == -1)
            return s;
        else
            return s.substring(0, i) + s2 + s.substring(i + s1.length());
    }

    public static String _ifStringSString(String s, String s1, String s2)
    {
        int i = s1.length();
        int j = 0;
        int k = _aStringI(s, s1, j);
        if(k != -1)
        {
            StringBuffer stringbuffer = new StringBuffer();
            for(; k != -1; k = _aStringI(s, s1, j))
            {
                stringbuffer.append(s.substring(j, k)).append(s2);
                j = k + i;
            }

            if(j < s.length())
                stringbuffer.append(s.substring(j));
            return stringbuffer.toString();
        } else
        {
            return s;
        }
    }
}
