// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public final class InstructionBytes extends net.rim.tools.compiler.analysis.Instruction
{

    private byte z_qsaB[];

    public InstructionBytes(int i, int j, int k, byte abyte0[])
    {
        super(i, j, k);
        z_qsaB = abyte0;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new InstructionBytes(getIp(), getOpcode(), super._op, z_qsaB)).setValueOp(super.z_qpI);
    }

    public byte[] getBytes()
    {
        return z_qsaB;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker e1)
        throws CompileException
    {
        e1.walkInstruction(this);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof InstructionBytes)
        {
            net.rim.tools.compiler.analysis.InstructionBytes l1 = (net.rim.tools.compiler.analysis.InstructionBytes)obj;
            if(!super.equals(l1))
                return false;
            byte abyte0[] = z_qsaB;
            byte abyte1[] = l1.z_qsaB;
            if(abyte0 == abyte1)
                return true;
            int i = abyte0.length;
            if(i == abyte1.length)
            {
                for(int j = 0; j < i; j++)
                    if(abyte0[j] != abyte1[j])
                        return false;

                return true;
            }
        }
        return false;
    }
}
