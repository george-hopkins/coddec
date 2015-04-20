// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;


// Referenced classes of package net.rim.a.a:
//            g

public class cls_a extends cls_g
{

    private int z_byteI;
    private int z_caseI;

    public cls_a()
    {
        z_caseI = -1;
    }

    public int _casevI()
    {
        return z_byteI;
    }

    public void _ifIV(int i)
    {
        z_byteI = i;
    }

    public int _bytevI()
    {
        return z_caseI;
    }

    public void _aIV(int i)
    {
        z_caseI = i;
    }
}
