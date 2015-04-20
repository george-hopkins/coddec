// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, a1, h

public final class InitializedStaticData extends net.rim.tools.compiler.codfile.CodfileItem
{

    private int _value;
    private net.rim.tools.compiler.codfile.Literal _literal;

    public InitializedStaticData(int __address, int __value)
    {
        super._address = __address;
        _value = __value;
    }

    public InitializedStaticData(int __address, net.rim.tools.compiler.codfile.Literal __literal)
    {
        super._address = __address;
        _literal = __literal;
    }

    public InitializedStaticData(net.rim.tools.compiler.io.StructuredInputStream __input, int __address, boolean flag, net.rim.tools.compiler.codfile.DataBytes __dataBytes)
        throws IOException
    {
        super(__input);
        super._address = __address;
        _value = __input.readInt();
        if(super._address != -1 && flag)
        {
            int j = __dataBytes._agII(_value);
            _literal = __dataBytes.createSibling(_value, j == 3, true, false);
        }
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        writeAddress(c1);
        if(_literal != null)
        {
            _value = _literal.getOffset();
            c1.writeString(_literal.get_name_2());
        }
        c1.writeInt(_value);
        setExtent(c1);
    }
}
