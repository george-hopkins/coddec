// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae

public final class AttributeLineNumberTable extends net.rim.tools.compiler.classfile.Attribute
{

    private int z_nJI;
    private int z_nKaI[];
    private int z_nLaI[];

    public AttributeLineNumberTable(net.rim.tools.compiler.io.StructuredInputStream a1, int i, String s)
        throws IOException
    {
        super(a1, i, s);
        int j = a1.getOffset();
        int k = a1.readUnsignedShort();
        if(k > 0)
        {
            z_nJI = k;
            z_nKaI = new int[k];
            z_nLaI = new int[k];
            for(int l = 0; l < k; l++)
            {
                z_nKaI[l] = a1.readUnsignedShort();
                z_nLaI[l] = a1.readUnsignedShort();
            }

        }
        if(j + super.z_nAI != a1.getOffset())
            throw new IOException("incorrect line number table attribute length");
        else
            return;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(flag && super.z_nzZ)
            return;
        super._xcV(c1);
        int i = z_nJI;
        c1.writeShort(i, "num_lines=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int j = 0; j < i; j++)
        {
            c1.writeString("line: ");
            c1.empty_func8(j);
            c1.writeShort(z_nKaI[j], " start=", true);
            c1.writeShort(z_nLaI[j], "line=", true);
            c1.empty_func7();
        }

        c1.empty_func2();
        c1.empty_func7();
    }

    public int _cQvI()
    {
        return z_nJI;
    }

    public int _aUII(int i)
    {
        return z_nKaI[i];
    }

    public int _aVII(int i)
    {
        return z_nLaI[i];
    }
}
