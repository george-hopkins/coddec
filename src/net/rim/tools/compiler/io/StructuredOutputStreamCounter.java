// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.io;

import java.io.IOException;

// Referenced classes of package net.rim.tools.compiler.i:
//            c

public final class StructuredOutputStreamCounter extends StructuredOutputStream
{

    private Object _cookie;

    public StructuredOutputStreamCounter(Object obj)
    {
        _cookie = obj;
    }

    public Object getCookie()
    {
        return _cookie;
    }

    public void resetOffset()
        throws IOException
    {
        super.resetOffset();
    }

    public void resetOffset(String s)
        throws IOException
    {
        resetOffset();
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        super._offset += j;
    }

    public void flush(int i)
        throws IOException
    {
        super._offset++;
    }

    public void writeByte(int i)
        throws IOException
    {
        super._offset++;
    }

    public void writeChar(int i)
        throws IOException
    {
        super._offset += 2;
    }

    public void writeShort(int i)
        throws IOException
    {
        super._offset += 2;
    }

    public void writeMultibyteShort(int i)
        throws IOException
    {
        i &= 0xffff;
        if((i & 0xc000) != 0)
            super._offset += 3;
        else
        if((i & 0x3f80) != 0)
            super._offset += 2;
        else
            super._offset++;
    }

    public void writeInt(int i)
        throws IOException
    {
        super._offset += 4;
    }

    public void writeLong(long l)
        throws IOException
    {
        super._offset += 8;
    }

    public void close()
        throws IOException
    {
    }
}
