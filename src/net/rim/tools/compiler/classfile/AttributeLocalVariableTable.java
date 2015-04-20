// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae, af, m

public final class AttributeLocalVariableTable extends net.rim.tools.compiler.classfile.Attribute
{

    private af z_nGaaf[];

    public AttributeLocalVariableTable(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool m, int i, String s1)
        throws IOException
    {
        super(a1, i, s1);
        int j = a1.getOffset();
        int k = a1.readUnsignedShort();
        if(k > 0)
        {
            z_nGaaf = new net.rim.tools.compiler.classfile.af[k];
            for(int l = 0; l < k; l++)
                z_nGaaf[l] = new net.rim.tools.compiler.classfile.af(a1, m);

        }
        if(j + super.z_nAI != a1.getOffset())
            throw new IOException("incorrect local variable table attribute length");
        else
            return;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(flag && super.z_nzZ)
            return;
        super._xcV(c1);
        int i = _cNvI();
        c1.writeShort(i, "num_locals=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int j = 0; j < i; j++)
        {
            c1.writeString("local: ");
            c1.empty_func8(j);
            c1.writeString(" ");
            z_nGaaf[j].write(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func7();
    }

    public int _cNvI()
    {
        return z_nGaaf != null ? z_nGaaf.length : 0;
    }

    public net.rim.tools.compiler.classfile.af _aRIaf(int i)
    {
        return z_nGaaf[i];
    }
}
