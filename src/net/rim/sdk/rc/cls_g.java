// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;


public class cls_g
{

    private String z_ifString;
    private String z_aString;
    private String z_doString;

    public cls_g()
    {
    }

    public String _ifvString()
    {
        return z_aString;
    }

    public void _ifStringV(String s)
    {
        z_aString = s;
    }

    public String _dovString()
    {
        return z_ifString;
    }

    public void _aStringV(String s)
    {
        z_ifString = s;
    }

    public String _avString()
    {
        return z_doString;
    }

    public void _doStringV(String s)
    {
        z_doString = s;
    }

    public String toString()
    {
        return _ifvString();
    }
}
