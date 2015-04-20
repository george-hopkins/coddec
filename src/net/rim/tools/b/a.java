// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.b;

import net.rim.tools.compiler.exec.Comparator;

class a
    implements Comparator
{

    a()
    {
    }

    public int compare(Object obj, Object obj1)
    {
        String s = (String)obj;
        String s1 = (String)obj1;
        return s.compareTo(s1);
    }

    public boolean equals(Object obj)
    {
        return false;
    }
}
