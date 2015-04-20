// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            o

public final class ConstantPoolInteger extends net.rim.tools.compiler.classfile.ConstantPoolEntry
{

    private int _value;
    private boolean _isFloat;

    public ConstantPoolInteger(int i, net.rim.tools.compiler.io.StructuredInputStream a1, boolean flag)
        throws IOException
    {
        super(i);
        _value = a1.readInt();
        _isFloat = flag;
    }

    public ConstantPoolInteger(int i)
    {
        super(-1);
        _value = i;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(super._typeTag != -1)
        {
            super.write(c1, flag);
            c1.writeInt(_value, "value=", true);
        }
    }

    public int getValue()
    {
        return _value;
    }

    public boolean isFloat()
    {
        return _isFloat;
    }
}
