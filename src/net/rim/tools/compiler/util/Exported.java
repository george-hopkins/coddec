// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;

import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.ClassType;

public final class Exported
{

    private String _name;
    private Object _data;
    private int _index;

    public Exported(String __name, byte __data[])
    {
        _name = __name;
        _data = __data;
    }

    public Exported(String __name, Method __method)
    {
        _name = __name;
        _data = __method;
    }

    public Exported(String __name, ClassType __classType, int __index)
    {
        _name = __name;
        _data = __classType;
        _index = __index;
    }

    public String getName()
    {
        return _name;
    }

    public byte[] getData()
    {
        return (byte[])_data;
    }

    public Method getMethod()
    {
        return (Method)_data;
    }

    public ClassType getClassType()
    {
        return (ClassType)_data;
    }

    public int getClassTypeIndex()
    {
        return _index;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Exported)
        {
            Exported d1 = (Exported)obj;
            return _name.equals(d1._name);
        } else
        {
            return false;
        }
    }

    public String toString()
    {
        return _name;
    }
}
