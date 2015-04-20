// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.io;

import java.io.*;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.exec.MyArrays;

public final class StructuredInputStream
implements net.rim.tools.compiler.vm.Constants
{

    private byte _data[];
    private int _start;
    private int _length;
    private int _offset;
    private boolean _endiansFlag;

    public StructuredInputStream(byte __data[], int __start, int __length, boolean __endiansFlag, int __current)
    {
        _data = __data;
        _start = __start;
        _length = __length;
        _offset = __current;
        _endiansFlag = __endiansFlag;
    }
    public StructuredInputStream(byte __data[], boolean __endiansFlag, int __current)
    {
        this(__data, 0, __data.length, __endiansFlag, __current);
    }

    public StructuredInputStream(byte __data[], boolean __endiansFlag)
    {
        this(__data, 0, __data.length, __endiansFlag, 0);
    }

    public final byte[] getBytes() // gq
    {
        return _data;
    }

    public final int getStart()   //  gv
    {
        return _start;
    }

    public final void setOffset(int i)  //  cx
    {
        _offset = i;
    }

    public final int getOffset()    //  gy
    {
        return _offset;
    }

    public final void verifyOffset(int i, String s)
        throws IOException
    {
        if(_offset != i)
            throw new IOException("bad stream offset for " + s + " expected: 0x" + Integer.toHexString(i) + " actually at: 0x" + Integer.toHexString(_offset));
        else
            return;
    }

    public final int verifySlack(int i)
        throws IOException
    {
        int j = i - 1;
        int k = (_offset + j & ~j) - _offset;
        for(int l = 0; l < k; l++)
            if(readByte() != 0)
                throw new IOException("bad slack byte at offset: 0x" + Integer.toHexString(_offset));

        return k;
    }

    public final int skipBytes(int i) //  cw
        throws IOException
    {
        int j = _length - _offset;
        if(j < 0)
            throw new EOFException();
        if(i > j)
        {
            throw new EOFException();
        } else
        {
            _offset += i;
            return i;
        }
    }

    public final int moveCurrentIdxtoOffset(int i) //cy
        throws IOException
    {
        return skipBytes(i - _offset);
    }

    public final int read(byte __data[])
        throws IOException
    {
        int i = _length - _offset;
        if(i < 0)
            throw new EOFException();
        int j = __data.length;
        if(j > i)
            j = i;
        System.arraycopy(_data, _start + _offset, __data, 0, j);
        _offset += j;
        return j;
    }

    public final int read() //gz
        throws IOException
    {
        if(_offset == _length)
        {
            _offset++;
            return -1;
        }
        if(_offset > _length)
            throw new EOFException();
        else
            return _data[_start + _offset++];
    }

    public final byte readByte() // gp
        throws IOException
    {
        return (byte)read();
    }

    public final int readUnsignedByte() //gA
        throws IOException
    {
        return read() & 0xff;
    }

    public final short readShort()  // gt
        throws IOException
    {
        int i;
        byte byte0;
        if(_endiansFlag)
        {
            i = readUnsignedByte();
            byte0 = readByte();
        } else
        {
            byte0 = readByte();
            i = readUnsignedByte();
        }
        return (short)(i & 0xff | byte0 << 8);
    }

    public final int readUnsignedShort() //gs
        throws IOException
    {
        byte byte0;
        byte byte1;
        if(_endiansFlag)
        {
            byte0 = readByte();
            byte1 = readByte();
        } else
        {
            byte1 = readByte();
            byte0 = readByte();
        }
        return (byte0 & 0xff | (byte1 & 0xff) << 8) & 0xffff;
    }

    public final int readUnsignedShort1() //   gu
        throws IOException
    {
        int i = 0;
        int j = 0;
        int k;
        do
        {
            k = readByte() & 0xff;
            if(_endiansFlag)
            {
                i = ((k & 0x7f) << j) + i;
                j += 7;
            } else
            {
                i = (i << 7) + (k & 0x7f);
            }
        } while((k & 0x80) != 0);
        return i & 0xffff;
    }

    public final int readInt()  // gw
        throws IOException
    {
        int i;
        int j;
        int k;
        byte byte0;
        if(_endiansFlag)
        {
            i = readUnsignedByte();
            j = readUnsignedByte();
            k = readUnsignedByte();
            byte0 = readByte();
        } else
        {
            byte0 = readByte();
            k = readUnsignedByte();
            j = readUnsignedByte();
            i = readUnsignedByte();
        }
        return i & 0xff | (j & 0xff) << 8 | (k & 0xff) << 16 | byte0 << 24;
    }

    public final long readLong()  //gx
        throws IOException
    {
        long l;
        long l1;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        long l7;
        if(_endiansFlag)
        {
            l = readUnsignedByte();
            l1 = readUnsignedByte();
            l2 = readUnsignedByte();
            l3 = readUnsignedByte();
            l4 = readUnsignedByte();
            l5 = readUnsignedByte();
            l6 = readUnsignedByte();
            l7 = readByte();
        } else
        {
            l7 = readByte();
            l6 = readUnsignedByte();
            l5 = readUnsignedByte();
            l4 = readUnsignedByte();
            l3 = readUnsignedByte();
            l2 = readUnsignedByte();
            l1 = readUnsignedByte();
            l = readUnsignedByte();
        }
        return l & 255L | (l1 & 255L) << 8 | (l2 & 255L) << 16 | (l3 & 255L) << 24 | (l4 & 255L) << 32 | (l5 & 255L) << 40 | (l6 & 255L) << 48 | l7 << 56;
    }

    public final void close()
        throws IOException
    {
    }

    public static byte[] readFully(InputStream __inputstream, int __length, String __name)
        throws IOException
    {
        byte abyte0[] = readAll(__inputstream, __length, __name);
        __inputstream.close();
        return abyte0;
    }

    public static byte[] readAll(InputStream __inputstream, int __length, String __name)
        throws IOException
    {
        byte abyte0[] = null;
        if(__length == -1)
        {
            char c1 = '\u2000';
            abyte0 = new byte[c1];
            int loc_startOffsetI = 0;
            for(int i1 = 0; (i1 = __inputstream.read(abyte0, loc_startOffsetI, abyte0.length - loc_startOffsetI)) > 0;)
            {
                loc_startOffsetI += i1;
                if(loc_startOffsetI == abyte0.length)
                    abyte0 = net.rim.tools.compiler.exec.MyArrays.resize(abyte0, loc_startOffsetI + c1);
            }

            byte abyte1[] = new byte[loc_startOffsetI];
            System.arraycopy(abyte0, 0, abyte1, 0, loc_startOffsetI);
            abyte0 = abyte1;
        } else
        {
            abyte0 = new byte[__length];
            int l;
            for(int j = 0; j < __length; j += l)
            {
                l = __inputstream.read(abyte0, j, __length - j);
                if(l <= 0)
                    throw new IOException("Unable to read all input from: " + __name);
            }

        }
        return abyte0;
    }
}
