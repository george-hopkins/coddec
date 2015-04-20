// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.NameAndType;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public final class InstructionNameAndType extends net.rim.tools.compiler.analysis.Instruction
{

    private net.rim.tools.compiler.types.ClassType z_qwg;
    private net.rim.tools.compiler.types.NameAndType z_qvk;
    private boolean z_quZ;

    public InstructionNameAndType(int i, int j, net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1)
    {
        this(i, j, g1, k1, 0);
    }

    public InstructionNameAndType(int i, int j, net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, int l)
    {
        super(i, j, l);
        z_qwg = g1;
        z_qvk = k1;
    }

    public InstructionNameAndType(int i, int j, net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, boolean flag)
    {
        this(i, j, g1, k1, 0, flag);
    }

    public InstructionNameAndType(int i, int j, net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, int l, boolean flag)
    {
        super(i, j, l);
        z_qwg = g1;
        z_qvk = k1;
        z_quZ = flag;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new net.rim.tools.compiler.analysis.InstructionNameAndType(getIp(), getOpcode(), z_qwg, z_qvk, super._op, z_quZ)).setValueOp(super.z_qpI);
    }

    public void _eTvV()
    {
        z_quZ = true;
    }

    public boolean _eVvZ()
    {
        return z_quZ;
    }

    void _akV(net.rim.tools.compiler.types.NameAndType k1)
    {
        z_qvk = k1;
    }

    public net.rim.tools.compiler.types.ClassType getClassType()
    {
        return z_qwg;
    }

    public net.rim.tools.compiler.types.NameAndType getNameAndType()
    {
        return z_qvk;
    }

    public void walkInstruction(InstructionWalker e1)
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
            case 3: // '\003'
            case 5: // '\005'
            case 7: // '\007'
            case 12: // '\f'
            case 105: // 'i'
            case 107: // 'k'
            case 109: // 'm'
            case 111: // 'o'
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
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
				net.rim.tools.compiler.types.Method c1 = (net.rim.tools.compiler.types.Method)z_qvk;
            i -= c1._fIvI();
            if(c1._fLvZ())
                i += c1._fMva().getLocalCount();
            break;

        default:
            i = super._eMvI();
            break;
        }
        return i;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.analysis.InstructionNameAndType)
        {
            net.rim.tools.compiler.analysis.InstructionNameAndType n1 = (net.rim.tools.compiler.analysis.InstructionNameAndType)obj;
            if(!super.equals(n1))
                return false;
            else
                return z_qwg.equals(n1.z_qwg) && z_qvk.equals(n1.z_qvk);
        } else
        {
            return false;
        }
    }

    public boolean _eHvZ()
    {
        if(getOpcode() != 5 && getOpcode() != 6)
            return true;
        else
            return !z_qvk.is(16);
    }
}
