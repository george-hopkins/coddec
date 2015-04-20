// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.exec.g;

// Referenced classes of package net.rim.tools.compiler.h:
//            g

public final class InnerClassType
{

    private net.rim.tools.compiler.types.ClassType z_dog;
    private net.rim.tools.compiler.types.ClassType z_forg;
    private String z_aString;
    private int z_ifI;

    public InnerClassType(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.ClassType g2, String s, int i)
    {
        z_dog = g1;
        z_forg = g2;
        z_aString = s;
        z_ifI = i;
    }

    public void _aCompilerV(Compiler compiler)
    {
        net.rim.tools.compiler.exec.g g1 = compiler._fvg();
        if(z_dog != null)
        {
            g1.append("Inner: ");
            g1._byteStringV(z_dog.getFullName());
        }
        if(z_forg != null)
        {
            g1.append("Outer: ");
            g1._byteStringV(z_forg.getFullName());
        }
        if(z_aString != null)
        {
            g1.append("Name: ");
            g1._byteStringV(z_aString);
        }
        g1._gotoIV(z_ifI);
    }
}
