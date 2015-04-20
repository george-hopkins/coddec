// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;

import java.util.Vector;

public final class ExecutionTimer
{

    private String _name;
    private long _value;

    public ExecutionTimer(String __name, Vector __vector)
    {
        __vector.addElement(this);
        _name = __name;
        _value = System.currentTimeMillis();
    }

    public void stop()
    {
        _value = System.currentTimeMillis() - _value;
    }

    public String toString()
    {
        int i = (int)_value;
        int j = i / 1000;
        int k = i % 1000;
        StringBuffer stringbuffer = (new StringBuffer(_name.length() + 11)).append(_name).append('(').append(j).append('.');
        if(k < 100)
        {
            stringbuffer.append('0');
            if(k < 10)
                stringbuffer.append('0');
        }
        return stringbuffer.append(k).append("s)").toString();
    }
}
