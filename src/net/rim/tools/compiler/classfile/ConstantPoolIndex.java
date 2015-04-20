// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            o

public class ConstantPoolIndex extends net.rim.tools.compiler.classfile.ConstantPoolEntry
{

    int index;

    public ConstantPoolIndex(int i, net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        super(i);
        index = __input.readShort();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        super.write(c1, flag);
        c1.writeShort(index, "index=", true);
    }
}
