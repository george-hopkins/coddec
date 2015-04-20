// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            af, k, u, a5

public final class ModuleNull extends Module
{

    public ModuleNull(DataSection k)
    {
        super(k);
    }

    public ClassDef makeClassDef(DataSection k, String s, String s1)
    {
        return super._nullClassDef;
    }

    public Routine getRoutine(int i, ClassDef u)
    {
        return super._nullRoutine;
    }
}
