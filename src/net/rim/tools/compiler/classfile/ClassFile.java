// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            m, ak, ah, t,
//            ae

public final class ClassFile
    implements net.rim.tools.compiler.vm.Constants
{

    private int _minorVersion;
    private int _majorVersion;
    private net.rim.tools.compiler.classfile.ConstantPool _constantsPool;
    private int _accessFlags;
    private int _thisClass;
    private int _superClass;
    private int _interfaces[];
    private net.rim.tools.compiler.classfile.ClassFileField _fields[];
    private net.rim.tools.compiler.classfile.ClassFileMethod _methods[];
    private net.rim.tools.compiler.classfile.AttributeList _attributes;

    public ClassFile(byte __data[], boolean flag)
        throws IOException
    {
        net.rim.tools.compiler.io.StructuredInputStream _input_ = new net.rim.tools.compiler.io.StructuredInputStream(__data, false);
        if(_input_.readByte() != -54 || _input_.readByte() != -2 || _input_.readByte() != -70 || _input_.readByte() != -66)
            throw new IOException("Not a classfile"); //checking class file signature
        _minorVersion = _input_.readUnsignedShort();
        _majorVersion = _input_.readUnsignedShort();
        if(_majorVersion < 45 || _majorVersion > 48)
            throw new IOException("Incorrect classfile version");
        _constantsPool = new net.rim.tools.compiler.classfile.ConstantPool(_input_, flag);
        _accessFlags = _input_.readUnsignedShort();
        _thisClass = _input_.readUnsignedShort();
        _superClass = _input_.readUnsignedShort();
        int l = _input_.readUnsignedShort();
        if(l > 0)
        {
            _interfaces = new int[l];
            for(int i = 0; i < l; i++)
                _interfaces[i] = _input_.readShort();

        }
        l = _input_.readShort();
        if(l > 0)
        {
            _fields = new net.rim.tools.compiler.classfile.ClassFileField[l];
            for(int j = 0; j < l; j++)
                _fields[j] = new net.rim.tools.compiler.classfile.ClassFileField(_input_, _constantsPool, flag);

        }
        l = _input_.readUnsignedShort();
        if(l > 0)
        {
            _methods = new net.rim.tools.compiler.classfile.ClassFileMethod[l];
            for(int k = 0; k < l; k++)
                _methods[k] = new net.rim.tools.compiler.classfile.ClassFileMethod(_input_, _constantsPool, flag);

        }
        _attributes = new net.rim.tools.compiler.classfile.AttributeList(_input_, _constantsPool, 1, flag);
        if(_input_.read() != -1)
        {
            throw new IOException("Extra bytes in class file");
        } else
        {
            _input_.close();
            return;
        }
    }

    public void write(OutputStream __output, boolean flag, PrintStream __print)
        throws IOException
    {
        StructuredOutputStream _output_ = null;
        if(__print == null)
            _output_ = new StructuredOutputStream(__output, false, null);
        else
            _output_ = StructuredOutputStream.createInstance(__output, false, null, __print);
        _output_.writeString("magic");
        _output_.writeByte(202);
        _output_.writeByte(254);
        _output_.writeByte(186);
        _output_.writeByte(190);
        _output_.empty_func7();
        _output_.writeShort(_minorVersion, "minor_version=", true);
        _output_.writeShort(_majorVersion, "major_version=", true);
        _output_.empty_func7();
        _output_.empty_func();
        _constantsPool.write(_output_, flag);
        _output_.empty_func2();
        _output_.empty_func7();
        _output_.writeShort(_accessFlags, "access_flags=", true);
        _output_.empty_func7();
        _output_.writeShort(_thisClass, "this_class=", true);
        _output_.empty_func7();
        _output_.writeShort(_superClass, "super_class=", true);
        _output_.empty_func7();
        int l = getNumInterfaces();
        _output_.writeShort(l, "num_interfaces=", true);
        _output_.empty_func7();
        _output_.empty_func();
        for(int i = 0; i < l; i++)
        {
            _output_.writeString("interface: ");
            _output_.empty_func8(i);
            _output_.writeShort(_interfaces[i], " interface=", true);
            _output_.empty_func7();
        }

        _output_.empty_func2();
        _output_.empty_func7();
        l = getNumFields();
        _output_.writeShort(l, "num_fields=", true);
        _output_.empty_func7();
        _output_.empty_func();
        for(int j = 0; j < l; j++)
        {
            _output_.writeString("field: ");
            _output_.empty_func8(j);
            _output_.empty_func7();
            _fields[j].write(_output_, flag);
        }

        _output_.empty_func2();
        _output_.empty_func7();
        l = getNumMethods();
        _output_.writeShort(l, "num_methods=", true);
        _output_.empty_func7();
        _output_.empty_func();
        for(int k = 0; k < l; k++)
        {
            _output_.writeString("method: ");
            _output_.empty_func8(k);
            _output_.empty_func7();
            _methods[k].write(_output_, flag);
        }

        _output_.empty_func2();
        _output_.empty_func7();
        _attributes.write(_output_, flag);
        _output_.close();
    }

    public int getAccessFlags()
    {
        return _accessFlags;
    }

    public String getClassNameString()
        throws IOException
    {
        String s = null;
        if(_thisClass != 0)
        {
            s = _constantsPool.getName(_thisClass);
            if(s.charAt(0) == '[')
                throw new IOException("invalid class name: " + s);
        }
        return s;
    }

    public String getSuperClassNameString()
        throws IOException
    {
        String s = null;
        if(_superClass != 0)
        {
            s = _constantsPool.getName(_superClass);
            if(s.charAt(0) == '[')
                throw new IOException("invalid class name: " + s);
        }
        return s;
    }

    public net.rim.tools.compiler.classfile.ConstantPool getConstantsPool()
    {
        return _constantsPool;
    }

    public int getNumInterfaces()
    {
        return _interfaces != null ? _interfaces.length : 0;
    }

    public String getInterfaceNameString(int i)
        throws IOException
    {
        String s = _constantsPool.getName(_interfaces[i]);
        if(s.charAt(0) == '[')
            throw new IOException("invalid interface name: " + s);
        else
            return s;
    }

    public int getNumFields()
    {
        return _fields != null ? _fields.length : 0;
    }

    public net.rim.tools.compiler.classfile.ClassFileField getField(int i)
    {
        return _fields[i];
    }

    public int getNumMethods()
    {
        return _methods != null ? _methods.length : 0;
    }

    public net.rim.tools.compiler.classfile.ClassFileMethod getMethod(int i)
    {
        return _methods[i];
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
