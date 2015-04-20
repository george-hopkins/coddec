// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae, k, m

public final class AttributeStackMapTable extends net.rim.tools.compiler.classfile.Attribute
{

    private net.rim.tools.compiler.classfile.AttributeStackMap f_AttributeStackMap[];

    public AttributeStackMapTable(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool m, int i, String s)
        throws IOException
    {
        super(a1, i, s);
        int j = a1.getOffset();
        int l = a1.readUnsignedShort();
        if(l > 0)
        {
            f_AttributeStackMap = new net.rim.tools.compiler.classfile.AttributeStackMap[l];
            for(int i1 = 0; i1 < l; i1++)
            {
                net.rim.tools.compiler.classfile.AttributeStackMap k1 = new net.rim.tools.compiler.classfile.AttributeStackMap(a1, m);
                if(i1 > 0 && k1._forvI() <= f_AttributeStackMap[i1 - 1]._forvI())
                    throw new IOException("incorrect stack map table ordering");
                f_AttributeStackMap[i1] = k1;
            }

        }
        if(j + super.z_nAI != a1.getOffset())
            throw new IOException("incorrect stack map table attribute length");
        else
            return;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(flag && super.z_nzZ)
            return;
        super._xcV(c1);
        int i = getNumStackMaps();
        c1.writeShort(i, " num_stackmaps=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int j = 0; j < i; j++)
        {
            c1.writeString("stackmap: ");
            c1.empty_func8(j);
            c1.empty_func7();
            f_AttributeStackMap[j]._acvV(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func7();
    }

    public int getNumStackMaps()
    {
        return f_AttributeStackMap != null ? f_AttributeStackMap.length : 0;
    }

    public net.rim.tools.compiler.classfile.AttributeStackMap getStackMap(int i)
    {
        return f_AttributeStackMap[i];
    }
}
