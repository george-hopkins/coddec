// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae, ac, m

public final class v extends net.rim.tools.compiler.classfile.Attribute
{

    private net.rim.tools.compiler.classfile.ac z_nHaac[];

    public v(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool __constantPool, int i, String s)
        throws IOException
    {
        super(a1, i, s);
        int j = a1.getOffset();
        int k = a1.readUnsignedShort();
        if(k > 0)
        {
            z_nHaac = new ac[k];
            for(int l = 0; l < k; l++)
            {
                net.rim.tools.compiler.classfile.ac ac1 = new net.rim.tools.compiler.classfile.ac(a1, __constantPool);
                int i1 = ac1.getInnerClassInfo();
                for(int j1 = 0; j1 < l; j1++)
                    if(i1 == z_nHaac[j1].getInnerClassInfo())
                        throw new IOException("duplicate inner classes table entry");

                z_nHaac[l] = ac1;
            }

        }
        if(j + super.z_nAI != a1.getOffset())
            throw new IOException("incorrect inner classes table attribute length");
        else
            return;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        super._xcV(__output);
        int i = _cOvI();
        __output.writeShort(i, "num_classes=", true);
        __output.empty_func7();
        __output.empty_func();
        for(int j = 0; j < i; j++)
        {
            __output.writeString("inner_class: ");
            __output.empty_func8(j);
            __output.empty_func7();
            z_nHaac[j].write(__output, flag);
        }

        __output.empty_func2();
        __output.empty_func7();
    }

    public int _cOvI()
    {
        return z_nHaac != null ? z_nHaac.length : 0;
    }

    public net.rim.tools.compiler.classfile.ac _aSIac(int i)
    {
        return z_nHaac[i];
    }
}
