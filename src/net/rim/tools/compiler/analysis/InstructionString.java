// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public final class InstructionString extends net.rim.tools.compiler.analysis.Instruction
{

    private String _string;

    public InstructionString(int i, int j, String s)
    {
        super(i, j, 0);
        _string = s;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new InstructionString(getIp(), getOpcode(), _string)).setValueOp(super.z_qpI);
    }

    public String getString()
    {
        return _string;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker __walker)
        throws CompileException
    {
        __walker.walkInstruction(this);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof InstructionString)
        {
            InstructionString m1 = (InstructionString)obj;
            if(!super.equals(m1))
                return false;
            else
                return _string.equals(m1._string);
        } else
        {
            return false;
        }
    }
}
