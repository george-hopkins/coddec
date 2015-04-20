// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.util.Hashtable;

// Referenced classes of package net.rim.tools.compiler.d:
//            ag, ap

public class CodfileVectorHash extends CodfileVector
{

    protected Hashtable _table;

    public CodfileVectorHash(int i)
    {
        super(1, false);
        _table = new Hashtable(i);
    }

    public CodfileItem get(Object obj)
    {
        return (CodfileItem)_table.get(obj);
    }

    public void inject(Object obj, CodfileItem ap1)
    {
        _table.put(obj, ap1);
    }

    public void put(Object obj, CodfileItem ap1)
    {
        inject(obj, ap1);
        addElementOrdered(ap1);
    }
}
