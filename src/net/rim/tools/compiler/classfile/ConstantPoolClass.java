// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.types.Type;

// Referenced classes of package net.rim.tools.compiler.e:
//            p, g, m

public final class ConstantPoolClass extends net.rim.tools.compiler.classfile.ConstantPoolIndex
{

    net.rim.tools.compiler.classfile.ConstantPoolUTF8 utf8;
    String name;
    net.rim.tools.compiler.types.Type _type;

    public ConstantPoolClass(int i, net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        super(i, __input);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool __constantPool)
        throws IOException
    {
        if(utf8 == null)
            utf8 = (ConstantPoolUTF8)__constantPool.getConstantPoolEntry(super.index);
    }

    public void verify()
        throws IOException
    {
        String s = utf8.getString();
        int i = s.length();
        for(int j = 0; j < i;)
        {
            char c = s.charAt(j++);
            switch(c)
            {
            default:
                break;

            case 47: // '/'
                if(j != i)
                    break;
                // fall through

            case 4224:
            case 7680:
            case 12352:
            case 13312:
            case 64256:
                throw new IOException("bad class name: " + s);
            }
        }

    }

    public String getName()
    {
        if(name == null)
            name = utf8.getString().replace('/', '.');
        return name;
    }

    public void setType(net.rim.tools.compiler.types.Type a)
    {
        _type = a;
    }

    public net.rim.tools.compiler.types.Type getType()
    {
        return _type;
    }
}
