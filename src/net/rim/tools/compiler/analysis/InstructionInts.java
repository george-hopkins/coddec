// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.codfile.Code;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            q, g, e

public final class InstructionInts extends InstructionBranch
{

    private int z_qxaI[];

    public InstructionInts(int i, int j, int ai[])
    {
        this(i, j, ai, false);
    }

    public InstructionInts(int i, int j, int ai[], boolean flag)
    {
        super(i, j, flag ? 1 : 0);
        int k = ai.length;
        if(k == 0)
        {
            z_qxaI = ai;
        } else
        {
            z_qxaI = new int[k];
            for(int l = 0; l < k; l++)
                z_qxaI[l] = ai[l];

        }
    }

    public Instruction _eLvg()
    {
        return (new InstructionInts(getIp(), getOpcode(), z_qxaI, super._op != 0)).setValueOp(super.z_qpI);
    }

    public int[] _eZvaI()
    {
        return z_qxaI;
    }

    public void walkInstruction(InstructionWalker e1)
        throws CompileException
    {
        e1.walkInstruction(this);
    }

    public int setOffset(int i, boolean flag)
    {
        setIp(i);
        return i + Code._aIIaII(getOpcode(), 0, z_qxaI, flag, true);
    }

    public boolean _eYvZ()
    {
        return super._op != 0;
    }

    public void _bNIV(int i)
    {
        int ai[] = z_qxaI;
        int j = ai.length;
        int k = j - 1;
        int ai1[] = new int[k];
        if(i != 0)
            System.arraycopy(ai, 0, ai1, 0, i);
        if(i != k)
            System.arraycopy(ai, i + 1, ai1, i, j - (i + 1));
        z_qxaI = ai1;
    }

    boolean _eXvZ()
    {
        if(_eYvZ())
            return false;
        int ai[] = z_qxaI;
        int i = ai.length;
        for(int j = 1; j < i; j++)
            if(ai[j] <= ai[j - 1])
                return false;

        return true;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof InstructionInts)
        {
            InstructionInts h1 = (InstructionInts)obj;
            if(!super.equals(h1))
                return false;
            int ai[] = z_qxaI;
            int ai1[] = h1.z_qxaI;
            if(ai == ai1)
                return true;
            int i = ai.length;
            if(i == ai1.length)
            {
                for(int j = 0; j < i; j++)
                    if(ai[j] != ai1[j])
                        return false;

                return true;
            }
        }
        return false;
    }
}
