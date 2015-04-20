// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            aj, e, ag, m

public class ConstantPoolField extends net.rim.tools.compiler.classfile.ConstantPoolTwoIndex
{

    net.rim.tools.compiler.classfile.ConstantPoolClass constantPoolClass;
    net.rim.tools.compiler.classfile.ConstantPoolNameAndType constantPoolNameAndType;

    public ConstantPoolField(int i, net.rim.tools.compiler.io.StructuredInputStream a)
        throws IOException
    {
        super(i, a);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool m1)
        throws IOException
    {
        if(constantPoolClass == null)
        {
            constantPoolClass = (net.rim.tools.compiler.classfile.ConstantPoolClass)m1.getConstantPoolEntry(super.index1);
            constantPoolNameAndType = (net.rim.tools.compiler.classfile.ConstantPoolNameAndType)m1.getConstantPoolEntry(super.index2);
        }
    }

    public ConstantPoolClass getConstantPoolClass()
    {
        return constantPoolClass;
    }

    public String getClassName()
    {
        return constantPoolClass.getName();
    }

    public net.rim.tools.compiler.types.ClassType getClassType()
    {
        return (net.rim.tools.compiler.types.ClassType)constantPoolClass.getType();
    }

    public String getName()
    {
        return constantPoolNameAndType.getName();
    }

    public String getType()
    {
        return constantPoolNameAndType.getType();
    }
}
