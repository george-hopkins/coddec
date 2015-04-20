// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            af, u, i, a5,
//            at, ap, ag, k

public final class ModuleLocal extends net.rim.tools.compiler.codfile.Module
{

    public ModuleLocal(net.rim.tools.compiler.codfile.DataSection k, String s1, String s2, net.rim.tools.compiler.codfile.CodfileVector ag1, net.rim.tools.compiler.codfile.CodfileVector ag2)
    {
        super(k, s1, s2, ag1, ag2);
    }

    public ModuleLocal(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, net.rim.tools.compiler.codfile.CodfileVector __codFileVector, net.rim.tools.compiler.codfile.CodfileVector __codFileVector2)
        throws IOException
    {
        super(__input, __dataSection, __codFileVector, __codFileVector2);
        int j = super._classDefs.size();
        for(int l = 0; l < j; l++)
        {
            net.rim.tools.compiler.codfile.ClassDef _classDef_ = (net.rim.tools.compiler.codfile.ClassDef)super._classDefs.elementAt(l);
            _classDef_.setModule(this);
        }

    }

    public net.rim.tools.compiler.codfile.ClassDef _aatu(net.rim.tools.compiler.codfile.ClassRef at1)
        throws IOException
    {
        int j = super._classDefs.size();
        for(int k = 0; k < j; k++)
        {
            net.rim.tools.compiler.codfile.ClassDef u1 = (net.rim.tools.compiler.codfile.ClassDef)super._classDefs.elementAt(k);
            if(u1.getPackageName() == at1.getPackageName() && u1.getClassName() == at1.getClassName())
                return u1;
        }

        throw new IOException("no class def found for ref: " + at1.get_name_2());
    }

    public net.rim.tools.compiler.codfile.ClassDef makeClassDef(net.rim.tools.compiler.codfile.DataSection k, String s1, String s2)
    {
        net.rim.tools.compiler.codfile.ClassDefLocal j = new net.rim.tools.compiler.codfile.ClassDefLocal(k, s1, s2);
        _ifuV(j);
        return j;
    }

    public net.rim.tools.compiler.codfile.Routine getRoutine(int __offset, net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        net.rim.tools.compiler.codfile.Routine _routine_ = (net.rim.tools.compiler.codfile.Routine)super._routines.getItem(__offset, null);
        if(_routine_ == null)
            _routine_ = super._nullRoutine;
        return _routine_;
    }

    public void harvestRoutines()
    {
        super._routines.setSize(0);
        int j = super._classDefs.size();
        for(int k = 0; k < j; k++)
        {
            net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)super._classDefs.elementAt(k);
            _classDefLocal_.harvestRoutines(super._routines);
        }

    }
}
