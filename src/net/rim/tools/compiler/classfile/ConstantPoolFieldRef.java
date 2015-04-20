// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            b, ag

public final class ConstantPoolFieldRef extends net.rim.tools.compiler.classfile.ConstantPoolField
{

    net.rim.tools.compiler.types.Field field;

    public ConstantPoolFieldRef(int i, net.rim.tools.compiler.io.StructuredInputStream a)
        throws IOException
    {
        super(i, a);
    }

    public void verify()
        throws IOException
    {
        super.constantPoolNameAndType.checkFieldType();
    }

    public void setField(net.rim.tools.compiler.types.Field h1)
    {
        field = h1;
    }

    public net.rim.tools.compiler.types.Field getField()
    {
        return field;
    }
}
