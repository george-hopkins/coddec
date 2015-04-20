// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.types.ClassType;

// Referenced classes of package net.rim.tools.compiler.e:
//            u, x, ai

public final class ad
implements net.rim.tools.compiler.classfile.u
{

    private net.rim.tools.compiler.classfile.InstructionTarget z_o0x;
    private net.rim.tools.compiler.classfile.InstructionTarget z_oZx;
    private net.rim.tools.compiler.classfile.InstructionTarget z_oYx;
    private net.rim.tools.compiler.types.ClassType _classType;

    public ad(net.rim.tools.compiler.classfile.InstructionTarget x1, net.rim.tools.compiler.classfile.InstructionTarget x2, net.rim.tools.compiler.classfile.InstructionTarget x3, net.rim.tools.compiler.types.ClassType __classType)
    {
        z_o0x = x1;
        z_oZx = x2;
        z_oYx = x3;
        _classType = __classType;
    }

    public void _longxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        z_o0x = x1;
    }

    public void _elsexV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        z_oZx = x1;
    }

    public void _gotoxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        z_oYx = x1;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _dNvx()
    {
        return z_o0x;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _dKvx()
    {
        return z_oZx;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _dMvx()
    {
        return z_oYx;
    }

    public net.rim.tools.compiler.types.ClassType _dLvg()
    {
        return _classType;
    }

    public boolean _charxZ(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        int i = x1.getOffset();
        return z_o0x.getOffset() <= i && i < z_oZx.getOffset();
    }

    public boolean _aadZ(net.rim.tools.compiler.classfile.ad ad1)
    {
        int i = ad1.z_o0x.getOffset();
        int j = ad1.z_oZx.getOffset();
        return z_o0x.getOffset() <= i && i <= z_oZx.getOffset() || z_o0x.getOffset() <= j && j <= z_oZx.getOffset();
    }

    public net.rim.tools.compiler.classfile.ad _axad(net.rim.tools.compiler.classfile.InstructionTarget x1, net.rim.tools.compiler.classfile.InstructionTarget x2, net.rim.tools.compiler.classfile.InstructionTarget x3)
    {
        return new net.rim.tools.compiler.classfile.ad(x1, x2, x3, _classType);
    }

    public net.rim.tools.compiler.classfile.ad _doaiad(net.rim.tools.compiler.classfile.ai ai1, net.rim.tools.compiler.classfile.InstructionTarget x1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.classfile.ad ad1 = null;
        net.rim.tools.compiler.classfile.InstructionTarget x2 = x1._dwvx();
        int i = z_oZx.getOffset();
        int j = x2.getOffset();
        boolean flag;
        do
        {
            flag = false;
            if(x2._baIZ(1) && j < i)
            {
                x2 = x2._dwvx();
                j = x2.getOffset();
                flag = true;
            }
            if(x2._baIZ(6) && j < i)
            {
                x2 = ai1._bvIx(x2.getOffset() + x2._dxvI());
                j = x2.getOffset();
                flag = true;
            }
            if(x2._baIZ(4) && x2._dxvI() == 1 && j < i)
            {
                x2 = ai1._bvIx(x2.getOffset() + 1);
                j = x2.getOffset();
                flag = true;
            }
        } while(flag);
        if(x1 == z_o0x)
        {
            z_o0x = x2;
        } else
        {
            if(j < i)
                ad1 = new net.rim.tools.compiler.classfile.ad(x2, z_oZx, z_oYx, _classType);
            z_oZx = x1;
        }
        return ad1;
    }

    public net.rim.tools.compiler.classfile.ad _axad(net.rim.tools.compiler.classfile.InstructionTarget x1, net.rim.tools.compiler.classfile.InstructionTarget x2)
    {
        net.rim.tools.compiler.classfile.ad ad1 = new net.rim.tools.compiler.classfile.ad(z_o0x, x1, z_oYx, _classType);
        _longxV(x2);
        return ad1;
    }
}
