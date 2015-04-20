// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;


public final class Tokenizer
{

    private String z_intString;
    private int _counter;
    private int z_doI;
    private int z_aaI[];
    private int z_foraI[];

    public Tokenizer(String s)
    {
        this(s, " ", false);
    }

    public Tokenizer(String s, String s1)
    {
        this(s, s1, false);
    }

    public Tokenizer(String s, String s1, boolean flag)
    {
        z_intString = s;
        int i = s.length();
        z_aaI = new int[i * 2 + 1];
        z_foraI = new int[i * 2 + 1];
        z_aaI[_counter] = 0;
        char c = s1.charAt(0);
        for(int j = 0; j != -1;)
        {
            j = s.indexOf(c, j);
            if(j != -1)
            {
                z_foraI[_counter++] = j;
                if(flag)
                {
                    z_aaI[_counter] = j;
                    j++;
                    z_foraI[_counter++] = j;
                } else
                {
                    j++;
                }
                z_aaI[_counter] = j;
            }
        }

        z_foraI[_counter++] = i;
    }

    public int countTokens()
    {
        return _counter;
    }

    public String nextToken()
    {
        if(!hasMoreTokens())
            return null;
        int i = z_aaI[z_doI];
        int j = z_foraI[z_doI];
        z_doI++;
        for(; i < j; i++)
            if(z_intString.charAt(i) != ' ')
                break;

        for(; i < j; j--)
            if(z_intString.charAt(j - 1) != ' ')
                break;

        if(i >= j)
            return "";
        else
            return z_intString.substring(i, j);
    }

    public boolean hasMoreTokens()
    {
        boolean flag = z_doI < countTokens();
        if(!flag)
        {
            z_aaI = null;
            z_foraI = null;
        }
        return flag;
    }
}
