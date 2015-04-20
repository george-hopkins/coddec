// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.tools.compiler.util;


// Referenced classes of package net.rim.tools.compiler.f:
//            a

public final class i extends CompileException
{

    private int z_intI;
    private String z_newString;

    public i(String s, String s1, int j)
    {
        super(s, s1);
        z_intI = j;
    }

    public i(String s, String s1, int j, String s2)
    {
        super(s, s1);
        z_intI = j;
        z_newString = s2;
    }

    public void _aStringV(String s)
    {
        if(z_newString == null)
            z_newString = s;
        else
            z_newString = z_newString + ' ' + s;
    }

    public String getMessage()
    {
        if(z_newString == null)
            return "verification failed at opcode offset: " + z_intI;
        else
            return "verification failed at opcode offset: " + z_intI + " cause: " + z_newString;
    }
}
