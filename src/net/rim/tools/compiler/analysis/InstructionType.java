// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            q, g, e

public final class InstructionType extends net.rim.tools.compiler.analysis.InstructionBranch
{

    private net.rim.tools.compiler.types.Type z_qya;

    public InstructionType(int i, int j, net.rim.tools.compiler.types.Type a1)
    {
        this(i, j, a1, 0);
    }

    public InstructionType(int i, int j, net.rim.tools.compiler.types.Type a1, int k)
    {
        super(i, j, k);
        z_qya = a1;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new net.rim.tools.compiler.analysis.InstructionType(getIp(), getOpcode(), z_qya, super._op)).setValueOp(super.z_qpI);
    }

    public net.rim.tools.compiler.types.Type _e0va()
    {
        return z_qya;
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker e1)
	throws net.rim.tools.compiler.util.CompileException
    {
        e1.walkInstruction(this);
    }

    public int setOffset(int i, boolean flag)
    {
        setIp(i);
        i = super.setOffset(i, flag);
        if(flag)
            switch(getOpcode())
            {
            case 168:
            case 170:
            case 184:
            case 186:
            case 191:
            case 193:
            case 195:
            case 198:
            case 200:
                i++;
                break;
            }
        return i;
    }

    public int _eMvI()
    {
        int i = 0;
        switch(getOpcode())
        {
        case 166:
        case 170:
        case 171:
            i -= super._op - 1;
            break;

        default:
            i = super._eMvI();
            break;
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.analysis.InstructionType)
        {
            net.rim.tools.compiler.analysis.InstructionType o1 = (net.rim.tools.compiler.analysis.InstructionType)obj;
            if(!super.equals(o1))
                return false;
            else
                return z_qya.equals(o1.z_qya);
        } else
        {
            return false;
        }
    }

    public boolean _eHvZ()
    {
        return getOpcode() != 184 && getOpcode() != 185;
    }
}
