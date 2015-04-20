// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.tools.compiler.codfile;


// Referenced classes of package net.rim.tools.compiler.d:
//            ar, u, ap, ak, 
//            p, r

final class b extends ar
{

    b()
    {
    }

    Member _aur(ClassDef u1, Identifier ak, TypeList p)
    {
        FieldDef w = u1.makeFieldDef(ak, p, super.z_iQZ);
        if(w == null)
        {
            w = u1.createFieldDef(ak, p, super.z_iQZ);
            u1.addFieldDef(w, super.z_iQZ);
            if(super.z_iQZ)
                w.setAddress(w.getOrdinal());
            else
                w.setAddress(-1);
        }
        return w;
    }
}
