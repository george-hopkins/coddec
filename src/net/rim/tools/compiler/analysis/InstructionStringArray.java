// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.codfile.Code;

// Referenced classes of package net.rim.tools.compiler.g:
//            g, e

public final class InstructionStringArray extends net.rim.tools.compiler.analysis.Instruction
{

    private String z_qqaString[];

    public InstructionStringArray(int i, int j, String as[])
    {
        super(i, j, 0);
        z_qqaString = as;
    }

    public net.rim.tools.compiler.analysis.Instruction _eLvg()
    {
        return (new net.rim.tools.compiler.analysis.InstructionStringArray(getIp(), getOpcode(), z_qqaString)).setValueOp(super.z_qpI);
    }

    public String[] getStringArray()
    {
        return z_qqaString;
    }

    public int setOffset(int i, boolean flag)
    {
        setIp(i);
        return i + net.rim.tools.compiler.codfile.Code._newIII(getOpcode(), z_qqaString.length);
    }

    public void walkInstruction(net.rim.tools.compiler.analysis.InstructionWalker e1)
        throws net.rim.tools.compiler.util.CompileException
    {
        e1.walkInstruction(this);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.analysis.InstructionStringArray)
        {
            net.rim.tools.compiler.analysis.InstructionStringArray a1 = (net.rim.tools.compiler.analysis.InstructionStringArray)obj;
            if(!super.equals(a1))
                return false;
            if(z_qqaString.length != a1.z_qqaString.length)
                return false;
            for(int i = z_qqaString.length - 1; i >= 0; i--)
                if(!z_qqaString[i].equals(a1.z_qqaString[i]))
                    return false;

            return true;
        } else
        {
            return false;
        }
    }
}
