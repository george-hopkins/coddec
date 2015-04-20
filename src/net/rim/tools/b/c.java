// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.b;

import net.rim.tools.compiler.exec.Comparator;

// Referenced classes of package net.rim.tools.b:
//            d

class c
implements net.rim.tools.compiler.exec.Comparator
{

    c()
    {
    }

    public int compare(Object obj, Object obj1)
    {
        net.rim.tools.b.d d1 = (net.rim.tools.b.d)obj;
        net.rim.tools.b.d d2 = (net.rim.tools.b.d)obj1;
        int i = d1._avI();
        int j = d2._avI();
        if(i != j)
            return i - j;
        for(int l = 0; l < i; l++)
        {
            int i1 = d1._aIString(l).compareTo(d2._aIString(l));
            if(i1 != 0)
                return i1;
        }

        return d1._dovString().compareTo(d2._dovString());
    }

    public boolean equals(Object obj)
    {
        return false;
    }
}
