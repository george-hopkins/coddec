// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            a9, ap, u, ak,
//            p, r

abstract class ar extends MemberFactory
{

    protected boolean z_iQZ;

    ar()
    {
    }

    void _bRvV()
    {
        z_iQZ = true;
    }

    void _bSvV()
    {
        z_iQZ = false;
    }

    CodfileItem createMember(int i)
    {
        throw new RuntimeException("illegal use of MemberFactory");
    }

    abstract Member _aur(ClassDef u, Identifier ak, TypeList p);
}
