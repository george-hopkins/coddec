// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, k, a1, f,
//            ak, a

public final class ExportedData extends net.rim.tools.compiler.codfile.CodfileItem
{

    private net.rim.tools.compiler.codfile.Identifier _Identifier;
    private int _length;
    private net.rim.tools.compiler.codfile.Bytes _bytes;

    public ExportedData(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.Bytes a2, String s)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        _Identifier = a1_1.getIdentifier(s);
        _bytes = a2;
        _length = a2.length();
    }

    public ExportedData(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.DataBytes a1_1)
        throws IOException
    {
        super(a2);
        _Identifier = a1_1.get_identifier(a2.readUnsignedShort());
        _length = a2.readUnsignedShort();
        _bytes = a1_1._aIIa(a2.readUnsignedShort(), _length, false);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        _Identifier.writeOffset(c1);
        c1.writeShort(_length, "length=", true);
        _bytes.writeOffset(c1);
        setExtent(c1);
    }

    public net.rim.tools.compiler.codfile.Bytes getBytes()
    {
        return _bytes;
    }

    public net.rim.tools.compiler.codfile.Identifier getIdentifier()
    {
        return _Identifier;
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.ExportedData a0_1 = (net.rim.tools.compiler.codfile.ExportedData)obj;
        return _Identifier.compareTo(a0_1._Identifier);
    }
}
