// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            b, ag

public final class ConstantPoolMethodRef extends net.rim.tools.compiler.classfile.ConstantPoolField
{

    net.rim.tools.compiler.types.Method _method;

    public ConstantPoolMethodRef(int i, net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        super(i, __input);
    }

    public void verify()
        throws IOException
    {
        super.constantPoolNameAndType.checkMethodName();
        super.constantPoolNameAndType.checkMethodType();
    }

    public void setMethod(net.rim.tools.compiler.types.Method c)
    {
        _method = c;
    }

    public net.rim.tools.compiler.types.Method getMethod()
    {
        return _method;
    }
}
