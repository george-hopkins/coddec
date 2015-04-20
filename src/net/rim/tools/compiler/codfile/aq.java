// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            a9, a1

abstract class aq extends MemberFactory
{

    net.rim.tools.compiler.codfile.DataBytes dataBytes;
    boolean z_iLZ;

    aq(net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        dataBytes = __dataBytes;
    }

    public void _elseZV(boolean flag)
    {
        z_iLZ = flag;
    }
}
