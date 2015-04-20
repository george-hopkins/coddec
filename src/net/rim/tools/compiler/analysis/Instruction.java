// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.a.cls_h;
import net.rim.tools.compiler.codfile.Code;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.g:
//            e

public class Instruction
implements net.rim.tools.compiler.vm.Constants
{

    private int _ip;
    int _op;
    int z_qpI;

    public Instruction(int i, int j)
    {
        this(i, j, 0);
    }

    public Instruction(int i, int j, int k)
    {
        _ip = i << 12 | j & 0xfff;
        _op = k;
    }

    public Instruction _eLvg()
    {
        return (new Instruction(getIp(), getOpcode(), _op)).setValueOp(z_qpI);
    }

    public void setIp(int i)
    {
        _ip = i << 12 | _ip & 0xfff;
    }

    public int getIp()
    {
        return _ip >> 12;
    }

    public void _bLIV(int i)
    {
        _ip = _ip & 0xfffff000 | i & 0xfff;
    }

    public int getOpcode()
    {
        return _ip & 0xfff;
    }

    public int getOp()
    {
        return _op;
    }

    public Instruction setValueOp(int i)
    {
        z_qpI = i;
        return this;
    }

    public int _eOvI()
    {
        return z_qpI;
    }

    public void walkInstruction(InstructionWalker e1)
        throws CompileException
    {
        e1.walkInstruction(this);
    }

    public int setOffset(int i, boolean flag)
    {
        setIp(i);
        return i + Code._aIIaII(getOpcode(), 0, null, flag, true);
    }

    public int _eMvI()
    {
        return net.rim.tools.compiler.vm.cls_h.z_aaB[getOpcode()];
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Instruction)
        {
            Instruction g1 = (Instruction)obj;
            return getOpcode() == g1.getOpcode() && _op == g1._op;
        } else
        {
            return false;
        }
    }

    public boolean _eHvZ()
    {
        switch(getOpcode())
        {
        case 167:
        case 205:
        case 206:
        case 207:
        case 208:
        case 209:
        case 210:
        case 211:
        case 212:
        case 213:
            return false;
        }
        return true;
    }

    public boolean _eJvZ()
    {
        switch(getOpcode())
        {
        case 167:
        case 205:
        case 207:
            return true;
        }
        return false;
    }
}
