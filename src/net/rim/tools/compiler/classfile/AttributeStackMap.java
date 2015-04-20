// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            f, m

public final class AttributeStackMap
{

    private int z_aI;
    private net.rim.tools.compiler.classfile.AttributeStackMapType z_doaf[];
    private net.rim.tools.compiler.classfile.AttributeStackMapType z_ifaf[];
    private net.rim.tools.compiler.types.Type z_foraa[];

    public AttributeStackMap(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool m)
        throws IOException
    {
        z_aI = a1.readUnsignedShort();
        int l = a1.readUnsignedShort();
        if(l > 0)
        {
            z_doaf = new net.rim.tools.compiler.classfile.AttributeStackMapType[l];
            for(int i = 0; i < l; i++)
                z_doaf[i] = net.rim.tools.compiler.classfile.AttributeStackMapType.read(a1, m);

        }
        l = a1.readUnsignedShort();
        if(l > 0)
        {
            z_ifaf = new net.rim.tools.compiler.classfile.AttributeStackMapType[l];
            for(int j = 0; j < l; j++)
                z_ifaf[j] = AttributeStackMapType.read(a1, m);

        }
    }

    public void _acvV(StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeShort(z_aI, "code_offset=", true);
        c1.empty_func7();
        c1.empty_func();
        int l = z_doaf != null ? z_doaf.length : 0;
        c1.writeShort(l, "num_locals=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int i = 0; i < l; i++)
        {
            c1.writeString("local: ");
            c1.empty_func8(i);
            c1.writeString(" ");
            z_doaf[i].write(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func7();
        l = z_ifaf != null ? z_ifaf.length : 0;
        c1.writeShort(l, "num_ops=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int j = 0; j < l; j++)
        {
            c1.writeString("operand: ");
            c1.empty_func8(j);
            c1.writeString(" ");
            z_ifaf[j].write(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func2();
        c1.empty_func7();
    }

    public int _forvI()
    {
        return z_aI;
    }

    public AttributeStackMapType[] _avaf()
    {
        return z_doaf;
    }

    public int _intvI()
    {
        int i = 0;
        AttributeStackMapType af[] = z_doaf;
        int j = af != null ? af.length : 0;
        for(int l = 0; l < j; l++)
            i += af[l].getSize();

        return i;
    }

    public AttributeStackMapType[] _ifvaf()
    {
        return z_ifaf;
    }

    public int _dovI()
    {
        int i = 0;
        AttributeStackMapType af[] = z_ifaf;
        int j = af != null ? af.length : 0;
        for(int l = 0; l < j; l++)
            i += af[l].getSize();

        return i;
    }

    public void _aaaV(net.rim.tools.compiler.types.Type aa[])
    {
        z_foraa = aa;
    }

    public net.rim.tools.compiler.types.Type[] _newvaa()
    {
        return z_foraa;
    }
}
