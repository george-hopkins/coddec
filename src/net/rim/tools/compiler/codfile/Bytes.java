// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            f, a1, ap

public final class Bytes extends net.rim.tools.compiler.codfile.CodfileData
{
		

    private static int _ordinal = 0;

    public Bytes(byte abyte0[], int i, boolean flag)
    {
        super(abyte0, i, flag, false);
        setName("bytes_", ++_ordinal);
    }

    public Bytes(int i, int j)
    {
        super(i, j);
        setName("bytes_", ++_ordinal);
    }

    public Bytes(int i, int j, boolean flag, net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        super(i, j, 2, flag, false);
        if(__dataBytes.hasData())
            resolveName(__dataBytes);
        setName("bytes_", ++_ordinal);
    }

    public void resolveName(net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        if(super._needsHeader)
            _ifa1V(__dataBytes);
        super._bytes = new byte[super._length];
        __dataBytes._byteaBIV(super._bytes, super._offset);
    }

    public String getString()
    {
        return null;
    }

    public void _doa1V(net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        if(!super._needsHeader && __dataBytes.hasData())
            _ifa1V(__dataBytes);
        super.setNeedsHeader();
    }

    public boolean _aaBIZ(byte abyte0[], int __arrayType)
    {
        if(super._arrayType != __arrayType && __arrayType != -1)
            return false;
        if(super._bytes.length != abyte0.length)
            return false;
        int j = abyte0.length;
        for(int k = 0; k < j; k++)
            if(super._bytes[k] != abyte0[k])
                return false;

        return true;
    }

    public void writeTerminator(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
    }

}
