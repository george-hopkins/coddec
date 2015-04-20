// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            d, t, m, ae

public final class ClassFileField
{

    private int _accessFlags;
    private int _nameIndex;
    private String _name;
    private int _descriptorIndex;
    private net.rim.tools.compiler.classfile.TypeDescriptor _descriptor;
    private net.rim.tools.compiler.classfile.AttributeList _attributesInfo;

    public ClassFileField(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.classfile.ConstantPool __constsPool, boolean flag)
        throws IOException
    {
        _accessFlags = __input.readUnsignedShort();
        _nameIndex = __input.readUnsignedShort();
        _name = __constsPool.getConstantPoolEntryString(_nameIndex);
        _descriptorIndex = __input.readUnsignedShort();
        _descriptor = new net.rim.tools.compiler.classfile.TypeDescriptor(__constsPool.getConstantPoolEntryString(_descriptorIndex));
        _attributesInfo = new net.rim.tools.compiler.classfile.AttributeList(__input, __constsPool, 2, flag);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeShort(_accessFlags, "access_flags=", true);
        c1.writeShort(_nameIndex, "name=", true);
        c1.empty_func10(_name, ' ');
        c1.writeShort(_descriptorIndex, "descriptor=", true);
        c1.writeString(_descriptor.getString());
        _attributesInfo.write(c1, flag);
    }

    public int getAccessFlags()
    {
        return _accessFlags;
    }

    public String getName()
    {
        return _name;
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
        return _attributesInfo.getAttribute(s);
    }
}
