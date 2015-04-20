// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import net.rim.tools.compiler.vm.Constants;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap

abstract class MemberFactory
implements net.rim.tools.compiler.vm.Constants
{

    MemberFactory()
    {
    }

    abstract CodfileItem createMember(int __offset);
}
