// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            d, m

public final class af
{

    private int _start;
    private int _length;
    private int _nameIndex;
    private String _name;
    private int _descriptorIndex;
    private net.rim.tools.compiler.classfile.TypeDescriptor _descriptor;
    private Object z_doObject;
    private int _index;
    private boolean z_caseZ;

    public af(net.rim.tools.compiler.classfile.af af1)
    {
        _start = af1._start;
        _length = af1._length;
        _nameIndex = af1._nameIndex;
        _name = af1._name;
        _descriptorIndex = af1._descriptorIndex;
        _descriptor = af1._descriptor;
        z_doObject = af1.z_doObject;
        _index = af1._index;
        z_caseZ = true;
    }

    public af(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool __constantPool)
        throws IOException
    {
        _start = a1.readUnsignedShort();
        _length = a1.readUnsignedShort();
        _nameIndex = a1.readUnsignedShort();
        _name = __constantPool.getConstantPoolEntryString(_nameIndex);
        _descriptorIndex = a1.readUnsignedShort();
        _descriptor = new net.rim.tools.compiler.classfile.TypeDescriptor(__constantPool.getConstantPoolEntryString(_descriptorIndex));
        _index = a1.readUnsignedShort();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        if(z_caseZ)
        {
            throw new IOException("cannot write modified AttributeLocalVariable");
        } else
        {
            __output.writeShort(_start, "start=", true);
            __output.writeShort(_length, "length=", true);
            __output.writeShort(_nameIndex, "name=", true);
            __output.empty_func10(_name, ' ');
            __output.writeShort(_descriptorIndex, "descriptor=", true);
            __output.empty_func10(_descriptor.getString(), ' ');
            __output.writeShort(_index, "index=", true);
            __output.empty_func7();
            return;
        }
    }

    public int getStart()
    {
        return _start;
    }

    public void _aIV(int i)
    {
        z_caseZ = true;
        _start = i;
    }

    public int getLength()
    {
        return _length;
    }

    public void _ifIV(int i)
    {
        z_caseZ = true;
        _length = i;
    }

    public String getName()
    {
        return _name;
    }

    public net.rim.tools.compiler.classfile.TypeDescriptor getDescriptor()
    {
        return _descriptor;
    }

    public void _aObjectV(Object obj)
    {
        z_doObject = obj;
    }

    public Object _ifvObject()
    {
        return z_doObject;
    }

    public int getIndex()
    {
        return _index;
    }

    public String toString()
    {
        return _name;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.classfile.af)
        {
            net.rim.tools.compiler.classfile.af af1 = (net.rim.tools.compiler.classfile.af)obj;
            if(_index != af1._index)
                return false;
            if(z_doObject.equals(af1.z_doObject))
                return false;
            if(!_name.equals(af1._name))
                return false;
            return _descriptor.getString().equals(af1._descriptor.getString());
        } else
        {
            return false;
        }
    }
}
