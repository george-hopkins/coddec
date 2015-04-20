// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            e, m

public final class ac
{

    private int _innerClassInfo;
    private net.rim.tools.compiler.classfile.ConstantPoolClass z_doe;
    private int _outterClassInfo;
    private net.rim.tools.compiler.classfile.ConstantPoolClass z_newe;
    private int _innerClassName;
    private String z_aString;
    private int _innerClassFlags;

    public ac(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool m1)
        throws IOException
    {
        _innerClassInfo = a1.readUnsignedShort();
        if(_innerClassInfo != 0)
            z_doe = (ConstantPoolClass)m1.getConstantPoolEntry(_innerClassInfo);
        _outterClassInfo = a1.readUnsignedShort();
        if(_outterClassInfo != 0)
            z_newe = (ConstantPoolClass)m1.getConstantPoolEntry(_outterClassInfo);
        _innerClassName = a1.readUnsignedShort();
        if(_innerClassName != 0)
            z_aString = m1.getConstantPoolEntryString(_innerClassName);
        _innerClassFlags = a1.readUnsignedShort();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeShort(_innerClassInfo, "inner_class_info=", true);
        if(z_doe != null)
            c1.empty_func10(z_doe.getName(), ' ');
        c1.writeShort(_outterClassInfo, "outer_class_info=", true);
        if(z_newe != null)
            c1.empty_func10(z_newe.getName(), ' ');
        c1.writeShort(_innerClassName, "inner_class_name=", true);
        if(z_aString != null)
            c1.empty_func10(z_aString, ' ');
        c1.writeShort(_innerClassFlags, "inner_class_flags=", true);
        c1.empty_func7();
    }

    public int getInnerClassInfo()
    {
        return _innerClassInfo;
    }

    public net.rim.tools.compiler.classfile.ConstantPoolClass _forve()
    {
        return z_doe;
    }

    public net.rim.tools.compiler.classfile.ConstantPoolClass _ifve()
    {
        return z_newe;
    }

    public String _intvString()
    {
        return z_aString;
    }

    public int getInnerClassFlags()
    {
        return _innerClassFlags;
    }
}
