// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public class InstructionBranch extends net.rim.tools.compiler.analysis.Instruction
{

    public InstructionBranch(int i, int j)
    {
        this(i, j, 0);
    }

    public InstructionBranch(int i, int j, int k)
    {
        super(i, j, k);
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new net.rim.tools.compiler.analysis.InstructionBranch(getIp(), getOpcode(), super._op)).setValueOp(super.z_qpI);
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker e1)
	throws net.rim.tools.compiler.util.CompileException
    {
        e1.walkInstruction(this);
    }
}
