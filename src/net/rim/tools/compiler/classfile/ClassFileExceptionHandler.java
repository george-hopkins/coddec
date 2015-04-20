// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            m

public final class ClassFileExceptionHandler
{

    private int _start;
    private int _end;
    private int _handler;
    private int _typeTag;
    private String _typeName;
    private net.rim.tools.compiler.types.ClassType _exceptionClass;

    public ClassFileExceptionHandler(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool __constantPool)
        throws IOException
    {
        _start = a1.readUnsignedShort();
        _end = a1.readUnsignedShort();
        _handler = a1.readUnsignedShort();
        _typeTag = a1.readUnsignedShort();
        if(_typeTag == 0)
            _typeName = null;
        else
            _typeName = __constantPool.getName(_typeTag);
    }

    public void _acvV(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeShort(_start, "start=", true);
        c1.writeShort(_end, "end=", true);
        c1.writeShort(_handler, "handler=", true);
        c1.writeShort(_typeTag, "type_name=", true);
        if(_typeName != null)
            c1.writeString(_typeName);
        c1.empty_func7();
    }

    public int getStart()
    {
        return _start;
    }

    public int getEnd()
    {
        return _end;
    }

    public int getHandler()
    {
        return _handler;
    }

    public String getTypeName()
    {
        return _typeName;
    }

    public void setExceptionClass(net.rim.tools.compiler.types.ClassType g)
    {
        _exceptionClass = g;
    }

    public net.rim.tools.compiler.types.ClassType getExceptionClass()
    {
        return _exceptionClass;
    }
}
