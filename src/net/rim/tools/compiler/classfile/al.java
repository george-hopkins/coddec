// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.tools.compiler.classfile;


// Referenced classes of package net.rim.tools.compiler.e:
//            af, u, x

public final class al
    implements u
{

    private InstructionTarget z_pax;
    private InstructionTarget z_o9x;
    private af z_pbaf;

    public al(InstructionTarget x1, InstructionTarget x2, af af1)
    {
        z_pax = x1;
        z_o9x = x2;
        z_pbaf = af1;
    }

    public void _fxV(InstructionTarget x1)
    {
        z_pax = x1;
    }

    public InstructionTarget _d8vx()
    {
        return z_pax;
    }

    public void _exV(InstructionTarget x1)
    {
        z_o9x = x1;
    }

    public InstructionTarget _d9vx()
    {
        return z_o9x;
    }

    public af _eavaf()
    {
        return z_pbaf;
    }

    public boolean _aalZ(al al1)
    {
        int i = al1.z_pax.getOffset();
        int j = al1.z_o9x.getOffset();
        return z_pax.getOffset() <= i && i <= z_o9x.getOffset() || z_pax.getOffset() <= j && j <= z_o9x.getOffset();
    }

    public al _doxal(InstructionTarget x1, InstructionTarget x2)
    {
        return new al(x1, x2, new af(z_pbaf));
    }

    public al _forxal(InstructionTarget x1, InstructionTarget x2)
    {
        al al1 = new al(z_pax, x1, z_pbaf);
        _fxV(x2);
        return al1;
    }
}
