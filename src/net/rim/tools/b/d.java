// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.b;

import java.util.*;
import net.rim.tools.compiler.exec.MyArrays;

// Referenced classes of package net.rim.tools.b:
//            c, a

class d
{

    private static net.rim.tools.b.c z_intc = new net.rim.tools.b.c();
    private static net.rim.tools.b.a z_ifa = new net.rim.tools.b.a();
    private String z_aString;
    private Vector z_forVector;
    private String z_doaString[];

    public d(String s, Hashtable hashtable)
    {
        z_aString = s;
        z_forVector = new Vector();
        z_forVector.addElement(s);
        z_doaString = new String[hashtable.size()];
        int i = 0;
        for(Enumeration enumeration = hashtable.keys(); enumeration.hasMoreElements();)
            z_doaString[i++] = (String)enumeration.nextElement();

        net.rim.tools.compiler.exec.MyArrays.sort(z_doaString, z_ifa);
    }

    public String _dovString()
    {
        return z_aString;
    }

    public void _aStringV(String s)
    {
        z_forVector.addElement(s);
    }

    public Vector _forvVector()
    {
        return z_forVector;
    }

    public String _ifvString()
    {
        return z_forVector.toString();
    }

    public int _avI()
    {
        return z_doaString.length;
    }

    public String _aIString(int i)
    {
        return z_doaString[i];
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.b.d)
        {
            net.rim.tools.b.d d1 = (net.rim.tools.b.d)obj;
            if(z_doaString.length == d1.z_doaString.length)
                return z_intc.compare(this, d1) == 0;
        }
        return false;
    }

}
