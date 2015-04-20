// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            aq, ak, a1, ap

final class ac extends aq
{

    ac(DataBytes __dataBytes)
    {
        super(__dataBytes);
    }

    CodfileItem createMember(int param_Offset)
    {
        return new Identifier(param_Offset, super.dataBytes);
    }
}
