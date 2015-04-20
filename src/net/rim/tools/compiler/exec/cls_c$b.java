// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;


// Referenced classes of package net.rim.tools.compiler.c:
//            c

 class cls_c$b
{

    private byte z_ifaB[];
    private int z_aI;
    private int z_doI;

    public void _aaBIV(byte abyte0[], int i)
    {
        z_ifaB = abyte0;
        for(int j = 0; j < z_ifaB.length; j++)
            z_ifaB[j] = 0;

        z_aI = i - 1;
        z_doI = 0;
    }

    public void _aIIV(int i, int j)
    {
        z_doI -= j;
        if(z_doI < 0)
        {
            z_doI = 8 - j;
            z_aI++;
        }
        z_ifaB[z_aI] |= i << z_doI;
    }

    public cls_c$b()
    {
    }
}
