// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.util.Locale;

// Referenced classes of package net.rim.a.a:
//            g

public class cls_k extends cls_g
{

    private Locale z_forLocale;
    private long z_newJ;
    private Object z_intObject;

    public cls_k()
    {
        z_newJ = -1L;
    }

    public Object _intvObject()
    {
        return z_intObject;
    }

    public void _aObjectV(Object obj)
    {
        z_intObject = obj;
    }

    public Locale _forvLocale()
    {
        return z_forLocale;
    }

    public void _aLocaleV(Locale locale)
    {
        z_forLocale = locale;
    }

    public long _newvJ()
    {
        return z_newJ;
    }

    public void _aJV(long l)
    {
        z_newJ = l;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        } else
        {
            String s = obj.toString();
            return s.equals(_ifvString());
        }
    }
}
