// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            aq, a, a1, ap

final class al extends aq
{

    int z_iPI;

    al(DataBytes a1)
    {
        super(a1);
    }

    void _aGIV(int i)
    {
        z_iPI = i;
    }

    CodfileItem createMember(int i)
    {
        return new Bytes(i, z_iPI, super.z_iLZ, super.dataBytes);
    }
}
