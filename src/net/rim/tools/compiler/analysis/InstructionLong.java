// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public final class InstructionLong extends net.rim.tools.compiler.analysis.Instruction
{

    private long z_qrJ;

    public InstructionLong(int j, int k, int l, int i1)
    {
        super(j, k, l);
        z_qrJ = i1;
    }

    public InstructionLong(int j, int k, long l)
    {
        super(j, k, 0);
        z_qrJ = l;
    }

    public InstructionLong(int j, int k, int l, long l1)
    {
        super(j, k, l);
        z_qrJ = l1;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new InstructionLong(getIp(), getOpcode(), super._op, z_qrJ)).setValueOp(super.z_qpI);
    }

    public long getOp2()
    {
        return z_qrJ;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker e1)
	throws net.rim.tools.compiler.util.CompileException
    {
        e1.walkInstruction(this);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.analysis.InstructionLong)
        {
            net.rim.tools.compiler.analysis.InstructionLong j = (net.rim.tools.compiler.analysis.InstructionLong)obj;
            if(!super.equals(j))
                return false;
            else
                return z_qrJ == j.z_qrJ;
        } else
        {
            return false;
        }
    }
}
