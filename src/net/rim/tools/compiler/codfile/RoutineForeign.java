// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            a5, k, an, ax,
//            ap, ak, r, u,
//            p

public final class RoutineForeign extends net.rim.tools.compiler.codfile.Routine
{

    private net.rim.tools.compiler.codfile.FixupTableEntry _fixupTableEntry;
    private String f_nameS;

    public RoutineForeign(net.rim.tools.compiler.codfile.ClassDef u1, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        super(u1, ak1, p, p1);
        super._offset = -1;
        super._address = -1;
        f_nameS = ak1.getString();
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection k1, boolean flag)
    {
        _akStringV(k1, flag, f_nameS);
    }

    public void setActualName(String s)
    {
        f_nameS = s;
    }

    private int _bcI(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        Object obj = c1.getCookie();
        if(obj != null)
        {
            if(_fixupTableEntry == null)
            {
                net.rim.tools.compiler.codfile.DataSection k1 = (net.rim.tools.compiler.codfile.DataSection)obj;
                makeSymbolic(k1, false);
                _fixupTableEntry = new net.rim.tools.compiler.codfile.FixupTableEntry(2);
                _fixupTableEntry.setItem(getFixupRef(k1));
            }
            _fixupTableEntry._adIV(c1.getOffset());
        }
        int i = -1;
        if(_fixupTableEntry != null)
            i = _fixupTableEntry.getOrdinal();
        return i;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("unable to write foreign routine");
    }

    public void writeOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = -1;
        if(!(super._classDef instanceof net.rim.tools.compiler.codfile.ClassDefNull))
            i = _bcI(c1);
        super._classDef.writeModuleOrdinal(c1);
        c1.writeShort(i, get_name_1(), false);
    }

    public void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c1, net.rim.tools.compiler.codfile.ClassDef u1)
        throws IOException
    {
        int i = -1;
        if(u1 instanceof net.rim.tools.compiler.codfile.ClassDefNull)
            u1 = super._classDef;
        else
        if(super._classDef instanceof net.rim.tools.compiler.codfile.ClassDefNull)
            super._classDef = u1;
        if(!(super._classDef instanceof net.rim.tools.compiler.codfile.ClassDefNull))
            i = addStaticFixup(c1, u1);
        c1.writeShort(-1);
        c1.writeShort(i, get_name_1(), false);
    }

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(_fixupTableEntry != null)
            k1.addMethodFixup(_fixupTableEntry);
        super.writeFixups(k1);
    }
}
