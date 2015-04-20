// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, q, h, l,
//            i, n, m, a,
//            o

public abstract class InstructionWalker
implements net.rim.tools.compiler.vm.Constants
{

    public InstructionWalker()
    {
    }

    public void walkInstruction(net.rim.tools.compiler.classfile.InstructionTarget x)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(int i, net.rim.tools.compiler.analysis.Instruction g1)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void _axvV(net.rim.tools.compiler.classfile.InstructionTarget x, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.Instruction g1)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionBranch q)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionInts h)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionBytes l)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionLong i)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionNameAndType n)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionString m)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionStringArray a1)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionType o)
	throws net.rim.tools.compiler.util.CompileException
    {
    }

    public void unexpectedInstruction(net.rim.tools.compiler.analysis.Instruction g1)
	throws net.rim.tools.compiler.util.CompileException
    {
        throw new net.rim.tools.compiler.util.CompileException("Unexpected instruction: " + g1.getOpcode());
    }
}
