// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.util.Hashtable;
import java.util.Vector;

public class cls_f extends Hashtable
{

    static final String z_aString = "1";
    static final String z_ifString = "0";

    public cls_f()
    {
    }

    public cls_f(Hashtable hashtable)
    {
        super(hashtable);
    }

    public String _aStringString(String s)
    {
        Object obj = get(s);
        if(obj == null)
            return "";
        if(obj instanceof String)
            return (String)obj;
        if(obj instanceof Vector)
            return (String)((Vector)obj).elementAt(0);
        else
            return obj.toString();
    }

    public void _aStringV(String s, String s1)
    {
        put(s, s1);
    }

    public boolean _doStringZ(String s)
    {
        return _aStringString(s).equalsIgnoreCase("1");
    }

    public void _aStringvV(String s, boolean flag)
    {
        String s1 = flag ? "1" : "0";
        _aStringV(s, s1);
    }

    public int _ifStringI(String s)
    {
        int i = 0;
        try
        {
            String s1 = _aStringString(s);
            s1 = s1.trim();
            if(s1.length() == 0)
            {
                return 0;
            } else
            {
                i = Integer.parseInt(s1);
                return i;
            }
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
        return i;
    }
}
