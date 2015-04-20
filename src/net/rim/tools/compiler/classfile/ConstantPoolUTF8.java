// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.exec.CharacterHelper;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            o, m

public final class ConstantPoolUTF8 extends net.rim.tools.compiler.classfile.ConstantPoolEntry
{

    private byte z_mZaB[];
    private int z_mXI;
    private int z_m0I;
    private String _string;

    public ConstantPoolUTF8(int i, net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        super(i);
        z_m0I = __input.readUnsignedShort();
        z_mXI = __input.getOffset();
        z_mZaB = __input.getBytes();
        __input.skipBytes(z_m0I);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        super.write(__output, flag);
        __output.writeShort(z_m0I, "num_bytes=", true);
        if(_string != null)
            __output.writeString(_string);
        else
            __output.writeString("bytes");
        __output.empty_func7();
        __output.write(z_mZaB, z_mXI, z_m0I);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool __constantPool)
        throws IOException
    {
        if(_string == null)
            _string = CharacterHelper.utf8ToString(z_mZaB, z_mXI, z_m0I);
    }

    public String getString()
    {
        return _string;
    }
}
