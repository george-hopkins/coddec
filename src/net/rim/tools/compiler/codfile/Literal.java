// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            f, a1, ap

public final class Literal extends CodfileData
{

    private String _string;
    private boolean z_eqZ;
    private static int _ordinal = 0;
    private boolean z_eoZ;

    private static byte[] _doStringvaB(String s, boolean flag)
    {
        int i = s.length();
        byte abyte0[] = new byte[flag ? i * 2 : i];
        int j = 0;
        for(int k = 0; k < i; k++)
        {
            char c1 = s.charAt(k);
            abyte0[j++] = (byte)(c1 & 0xff);
            if(flag)
                abyte0[j++] = (byte)(c1 >> 8 & 0xff);
        }

        return abyte0;
    }

    public Literal(String s, boolean flag, boolean flag1)
    {
        super(_doStringvaB(s, flag), flag ? 3 : 2, flag1, true);
        _string = s;
        z_eqZ = flag;
        setName("literal_", ++_ordinal, s);
    }

    public Literal(int i, boolean flag, boolean flag1, boolean flag2, DataBytes __dataBytes)
    {
        super(i, 0, flag ? 3 : 2, flag1, true);
        z_eqZ = flag;
        z_eoZ = flag2;
        if(__dataBytes.hasData())
            resolveName(__dataBytes);
    }

    public void resolveName(DataBytes __dataBytes)
    {
        if(super._needsHeader)
        {
            _ifa1V(__dataBytes);
            if(super._arrayType != (z_eqZ ? 3 : 2))
                throw new RuntimeException("Literal type mismatch");
        } else
        {
            int i = super._offset;
            if(z_eqZ)
                for(; __dataBytes.getChar(i) != 0; i += 2);
            else
                for(; __dataBytes.getByte(i) != 0; i++);
            if(z_eoZ)
                i += 5;
            super._length = i - super._offset;
        }
        if(__dataBytes._bqvZ())
        {
            if(super._length > 0)
                synchronized(CodfileData._stringBuf)
                {
                    CodfileData._stringBuf.setLength(0);
                    CodfileData._stringBuf.ensureCapacity(super._length);
                    int j = super._offset + super._length;
                    for(int k = super._offset; k < j; k++)
                    {
                        char _char_;
                        if(z_eqZ)
                            _char_ = __dataBytes.getChar(k);
                        else
                            _char_ = (char)__dataBytes.getByte(k);
                        CodfileData._stringBuf.append(_char_);
                    }

                    _string = CodfileData._stringBuf.toString();
                }
        } else
        {
            String s = "";
            super._bytes = new byte[super._length];
            __dataBytes._byteaBIV(super._bytes, super._offset);
            if(super._length > 0)
            {
                if(z_eqZ)
                {
                    char ac[] = new char[super._length / 2];
                    __dataBytes._aaCIV(ac, super._offset);
                    _string = new String(ac);
                } else
                {
                    _string = new String(super._bytes);
                }
                s = _string;
            }
            setName("literal_", ++_ordinal, s);
        }
    }

    public String getString()
    {
        return _string;
    }

    public void writeTerminator(StructuredOutputStream c1)
        throws IOException
    {
        if(z_eqZ)
            c1.writeChar(0);
        else
            c1.writeByte(0);
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof Literal)
        {
            Literal h1 = (Literal)obj;
            if(this == h1)
                return true;
            else
                return _string.equals(h1._string);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return _string.hashCode();
    }

}
