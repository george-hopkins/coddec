// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            o

public final class ConstantPoolLong extends net.rim.tools.compiler.classfile.ConstantPoolEntry
{

    private long _value;
    private boolean _isDouble;

    public ConstantPoolLong(int i, net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        super(i);
        _value = __input.readLong();
        _isDouble = flag;
    }

    public ConstantPoolLong(long l)
    {
        super(-1);
        _value = l;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(super._typeTag != -1)
        {
            super.write(c1, flag);
            c1.writeLong(_value, "value=");
        }
    }

    public long getValue()
    {
        return _value;
    }

    public boolean isDouble()
    {
        return _isDouble;
    }
}
