// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            aj, g, m

public final class ConstantPoolNameAndType extends net.rim.tools.compiler.classfile.ConstantPoolTwoIndex
{

    private net.rim.tools.compiler.classfile.ConstantPoolUTF8 _name;
    private net.rim.tools.compiler.classfile.ConstantPoolUTF8 _type;

    public ConstantPoolNameAndType(int i, net.rim.tools.compiler.io.StructuredInputStream a)
        throws IOException
    {
        super(i, a);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool m1)
        throws IOException
    {
        if(_name == null)
        {
            _name = (ConstantPoolUTF8)m1.getConstantPoolEntry(super.index1);
            _type = (ConstantPoolUTF8)m1.getConstantPoolEntry(super.index2);
        }
    }

    public String getName()
    {
        return _name.getString();
    }

    public String getType()
    {
        return _type.getString();
    }

    public void checkFieldType()
        throws IOException
    {
        String s = _type.getString();
        if(s.charAt(0) == '(')
            throw new IOException("bad field type: " + s);
        else
            return;
    }

    public void checkMethodType()
        throws IOException
    {
        String s = _type.getString();
        if(s.charAt(0) != '(')
            throw new IOException("bad method type: " + s);
        if(_name.getString().equals("<init>") && !s.endsWith(")V"))
            throw new IOException("bad <init> method return type: " + s);
        else
            return;
    }

    public void checkMethodName()
        throws IOException
    {
        String s = _name.getString();
        if(s.charAt(0) == '<' && !s.equals("<init>"))
            throw new IOException("bad method name: " + s);
        else
            return;
    }
}
