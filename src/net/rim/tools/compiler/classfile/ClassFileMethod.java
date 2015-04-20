// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            d, t, m, ae

public final class ClassFileMethod
{

    private int _accessFlags;
    private net.rim.tools.compiler.classfile.AttributeList _attributes;
    private int _nameIndex;
    private String _name;
    private int _descriptorIndex;
    private net.rim.tools.compiler.classfile.TypeDescriptor _descriptor;

    public ClassFileMethod(net.rim.tools.compiler.io.StructuredInputStream param_byteArray, net.rim.tools.compiler.classfile.ConstantPool param_constsPool, boolean flag)
        throws IOException
    {
        _accessFlags = param_byteArray.readUnsignedShort();
        _nameIndex = param_byteArray.readUnsignedShort();
        _name = param_constsPool.getConstantPoolEntryString(_nameIndex);
        _descriptorIndex = param_byteArray.readUnsignedShort();
        _descriptor = new net.rim.tools.compiler.classfile.TypeDescriptor(param_constsPool.getConstantPoolEntryString(_descriptorIndex));
        _attributes = new net.rim.tools.compiler.classfile.AttributeList(param_byteArray, param_constsPool, 3, flag);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        int i = _accessFlags;
        if(flag && (i & 0x400) == 0)
            i |= 0x100;
        c1.writeShort(i, "access_flags=", true);
        c1.writeShort(_nameIndex, "name=", true);
        c1.empty_func10(_name, ' ');
        c1.writeShort(_descriptorIndex, "descriptor=", true);
        c1.writeString(_descriptor.getString());
        _attributes.write(c1, flag);
    }

    public String getName()
    {
        return _name;
    }

    public int getAccessFlags()
    {
        return _accessFlags;
    }

    public net.rim.tools.compiler.classfile.TypeDescriptor getDescriptor()
    {
        return _descriptor;
    }

    public boolean hasAttribute(String s)
    {
        return getAttribute(s) != null;
    }

    public net.rim.tools.compiler.classfile.Attribute getAttribute(String s)
    {
        return _attributes.getAttribute(s);
    }
}
