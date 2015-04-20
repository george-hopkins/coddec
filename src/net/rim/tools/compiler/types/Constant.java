// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;


public final class Constant
{

    private long _value;
    private String _string;

    public Constant(long __value)
    {
        _value = __value;
    }

    public Constant(String __string)
    {
        _string = __string;
    }

    public long getValue()
    {
        return _value;
    }

    public String getString()
    {
        return _string;
    }

    public boolean isString()
    {
        return _string != null;
    }
}
