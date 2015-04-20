// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            aq, h, a1, ap

final class t extends net.rim.tools.compiler.codfile.aq
{

    private boolean _isUnicode;
    private boolean z_iNZ;

    t(net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        super(__dataBytes);
    }

    void set_flagUnicode(boolean __isUnicode)
    {
        _isUnicode = __isUnicode;
    }

    void _gotoZV(boolean flag)
    {
        z_iNZ = flag;
    }

    net.rim.tools.compiler.codfile.CodfileItem createMember(int i)
    {
        return new net.rim.tools.compiler.codfile.Literal(i, _isUnicode, super.z_iLZ, z_iNZ, super.dataBytes);
    }
}
