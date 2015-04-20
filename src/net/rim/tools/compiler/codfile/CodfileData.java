// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, a1

public abstract class CodfileData extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected static StringBuffer _stringBuf = new StringBuffer();
    protected boolean _needsHeader;
    protected boolean _isString;
    protected int _arrayType;
    protected int _length;
    protected byte _bytes[];
    public static final int z_ehI = 4;

    protected CodfileData()
    {
    }

    protected CodfileData(byte __bytes[], int __arrayType, boolean __needsHeader, boolean __isString)
    {
        _bytes = __bytes;
        _length = __bytes.length;
        _arrayType = __arrayType;
        _needsHeader = __needsHeader;
        _isString = __isString;
    }

    protected CodfileData(int __offset, int __length)
    {
        super(__offset);
        _length = __length;
        _arrayType = 2;
    }

    protected CodfileData(int __offset, int __length, int __arrayType, boolean __needsHeader, boolean __isString)
    {
        super(__offset);
        _length = __length;
        _arrayType = __arrayType;
        _needsHeader = __needsHeader;
        _isString = __isString;
    }

    private static void _aStringBufferV(StringBuffer stringbuffer, String s)
    {
        int i = s.length();
        for(int j = 0; j < i; j++)
        {
            char c1 = s.charAt(j);
            if(c1 == 0)
                break;
            if(c1 < ' ' || c1 > '\200')
                stringbuffer.append('?');
            else
                stringbuffer.append(c1);
        }

    }

    protected void setName(String s, int i, String s1)
    {
        synchronized(_stringBuf)
        {
            _stringBuf.setLength(0);
            _stringBuf.append(s);
            _stringBuf.append(i);
            _stringBuf.append(":\"");
            _aStringBufferV(_stringBuf, s1);
            _stringBuf.append("\"");
            setName(_stringBuf.toString());
        }
    }

    protected void setName(String s, int i)
    {
        synchronized(_stringBuf)
        {
            _stringBuf.setLength(0);
            _stringBuf.append(s);
            _stringBuf.append(i);
            setName(_stringBuf.toString());
        }
    }

    static int getType(int i)
    {
        return (i & 0x1e0000) >> 17;
    }

    static int length(int i)
    {
        int j = (i & 0x1ffff) >> 0;
        return j * _fII(getType(i));
    }

    protected void _ifa1V(DataBytes __dataBytes)
    {
        int i = __dataBytes.getInt(super._offset - 4);
        _arrayType = getType(i);
        _length = length(i);
    }

    public abstract void resolveName(net.rim.tools.compiler.codfile.DataBytes __dataBytes);

    public abstract String getString();

    static int _fII(int i)
    {
        switch(i)
        {
        case 1: // '\001'
            return 1;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 2;

        case 5: // '\005'
            return 4;

        case 6: // '\006'
            return 8;
        }
        return 1;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = _fII(_arrayType);
        if(_needsHeader)
        {
            c1.writeSlack(4);
            if(i == 8 && (c1.getOffset() & 7) == 0)
                c1.writeInt(0, "slack", false);
            int j = 0xd0000000;
            if(_isString)
                j |= 0x8200000;
            j |= _arrayType << 17 & 0x1e0000;
            int k = _length / i;
            j |= k << 0 & 0x1ffff;
            c1.writeInt(j);
        }
        c1.writeString(super._nameS);
        c1.writeString(": ");
        c1.writeSlack(i);
        c1.empty_func7();
        c1.empty_func();
        setOffset(c1);
        c1.write(_bytes);
        writeTerminator(c1);
        c1.empty_func2();
        c1.empty_func7();
        setExtent(c1);
    }

    public abstract void writeTerminator(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException;

    public void setNeedsHeader()
    {
        _needsHeader = true;
    }

    public boolean getNeedsHeader()
    {
        return _needsHeader;
    }

    public void setArrayType(int __arrayType)
    {
        _arrayType = __arrayType;
    }

    public int length()
    {
        return _length;
    }

    public int _gII(int i)
    {
        byte byte0 = _bytes[i];
        byte byte1 = _bytes[i + 1];
        short word0 = (short)((byte0 << 8) + (byte1 & 0xff));
        return word0;
    }

    public int _eII(int i)
    {
        byte byte0 = _bytes[i];
        byte byte1 = _bytes[i + 1];
        byte byte2 = _bytes[i + 2];
        byte byte3 = _bytes[i + 3];
        int j = (byte3 << 24) + ((byte2 & 0xff) << 16) + ((byte1 & 0xff) << 8) + (byte0 & 0xff);
        return j;
    }

    public int _hII(int i)
    {
        byte byte0 = _bytes[i];
        byte byte1 = _bytes[i + 1];
        byte byte2 = _bytes[i + 2];
        byte byte3 = _bytes[i + 3];
        int j = (byte0 << 24) + ((byte1 & 0xff) << 16) + ((byte2 & 0xff) << 8) + (byte3 & 0xff);
        return j;
    }

    public String _kIString(int i)
    {
        int j = _gII(i);
        i += 2;
        return new String(_bytes, i, j);
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.CodfileData f1 = (net.rim.tools.compiler.codfile.CodfileData)obj;
        if(this == f1)
            return 0;
        byte abyte0[] = f1._bytes;
        if(_bytes == null)
            return 1;
        int i = _bytes.length;
        if(i > abyte0.length)
            i = abyte0.length;
        for(int j = 0; j < i; j++)
        {
            int k = _bytes[j] & 0xff;
            int l = abyte0[j] & 0xff;
            if(k != l)
                return k - l;
        }

        if(i < abyte0.length)
            return -1;
        return i >= _bytes.length ? 0 : 1;
    }

}
