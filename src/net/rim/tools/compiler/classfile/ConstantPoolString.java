// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;

// Referenced classes of package net.rim.tools.compiler.e:
//            p, g, m

public final class ConstantPoolString extends net.rim.tools.compiler.classfile.ConstantPoolIndex
{

    private net.rim.tools.compiler.classfile.ConstantPoolUTF8 _utf8;

    public ConstantPoolString(int i, net.rim.tools.compiler.io.StructuredInputStream a1)
        throws IOException
    {
        super(i, a1);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool __constantPool)
        throws IOException
    {
        if(_utf8 == null)
            _utf8 = (ConstantPoolUTF8)__constantPool.getConstantPoolEntry(super.index);
    }

    public String getString()
    {
        return _utf8.getString();
    }
}
