// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            af, ag, ay, a5,
//            k, u

public final class ModuleDomestic extends net.rim.tools.compiler.codfile.Module
{

    public ModuleDomestic(net.rim.tools.compiler.codfile.DataSection k, String s, String s1)
    {
        super(k, s, s1, new net.rim.tools.compiler.codfile.CodfileVector(), new net.rim.tools.compiler.codfile.CodfileVector());
    }

    public ModuleDomestic(net.rim.tools.compiler.io.StructuredInputStream a, net.rim.tools.compiler.codfile.DataSection k)
        throws IOException
    {
        super(a, k, new net.rim.tools.compiler.codfile.CodfileVector(), new net.rim.tools.compiler.codfile.CodfileVector());
        super._routines.addElement(super._nullRoutine);
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeByte(-1);
    }

    public net.rim.tools.compiler.codfile.ClassDef makeClassDef(net.rim.tools.compiler.codfile.DataSection k, String s, String s1)
    {
        net.rim.tools.compiler.codfile.ClassDefForeign ay1 = new net.rim.tools.compiler.codfile.ClassDefForeign(k, s, s1);
        _ifuV(ay1);
        return ay1;
    }

    public net.rim.tools.compiler.codfile.Routine getRoutine(int i, net.rim.tools.compiler.codfile.ClassDef u)
    {
        net.rim.tools.compiler.codfile.Routine a5_1 = (net.rim.tools.compiler.codfile.Routine)super._routines.getItem(i + 0x10000, null);
        if(a5_1 == null)
            a5_1 = super._nullRoutine;
        return a5_1;
    }
}
