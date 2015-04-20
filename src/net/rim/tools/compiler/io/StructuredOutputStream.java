// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import net.rim.tools.compiler.exec.g;

public class StructuredOutputStream
    implements net.rim.tools.compiler.vm.Constants
{

    private boolean _endians;
    private boolean _isWritingCode;
    protected int _offset;
    private OutputStream _stream;
    private byte _buffer[];
    private int _offsetBuff;
    private net.rim.tools.compiler.exec.g _cipher;

    protected void init(OutputStream __outputstream, boolean __flagEndians, PrintStream __printstream)
    {
        _endians = __flagEndians;
        _stream = __outputstream;
        _buffer = new byte[128];
    }

    protected StructuredOutputStream()
    {
    }

    public StructuredOutputStream(OutputStream __outputstream, boolean __flagEndians, g __cipher)
    {
        init(__outputstream, __flagEndians, null);
        _cipher = __cipher;
    }

    public static StructuredOutputStream createInstance(OutputStream __outputstream, boolean __endiansFlag, g __cipher, PrintStream __printstream)
        throws IOException
    {
        StructuredOutputStream _stream_ = null;
        try
        {
            Class _class_ = Class.forName("net.rim.tools.compiler.io.StructuredOutputStream");
            _stream_ = (StructuredOutputStream)_class_.newInstance();
            _stream_.init(__outputstream, __endiansFlag, __printstream);
            _stream_._cipher = __cipher;
        }
        catch(ClassNotFoundException classnotfoundexception) { }
        catch(InstantiationException instantiationexception) { }
        catch(IllegalAccessException illegalaccessexception) { }
        if(_stream_ == null)
            throw new IOException("listing option not supported");
        else
            return _stream_;
    }

    public void setWritingCode(boolean __flag)
    {
        _isWritingCode = __flag;
    }

    public boolean writingCode()
    {
        return _isWritingCode;
    }

    public Object getCookie()
    {
        return null;
    }

    public int getOffset()
    {
        return _offset;
    }

    public void resetOffset()
        throws IOException
    {
        if((_offset & 3) != 0)
        {
            throw new IOException("output stream offset may only be reset on 4 byte aligned boundary");
        } else
        {
            _offset = 0;
            return;
        }
    }

    public void resetOffset(String s)
        throws IOException
    {
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(s);
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		resetOffset();
    }

    public void check_badStreamOffset(int i, String s)
        throws IOException
    {
		System.out.println(s);
        if(_offset != i)
            throw new IOException("bad stream offset for " + s + " expected: 0x" + Integer.toHexString(i) + " actually at: 0x" + Integer.toHexString(_offset));
        else
            return;
    }

    public void empty_func()
    {
    }

    public void empty_func2()
    {
    }

    public void empty_func3(int i, int j)
        throws IOException
    {
		System.out.println(i);
		System.out.println(j);
    }

    public void empty_func4(int i, int j)
        throws IOException
    {
		System.out.println(i);
		System.out.println(j);
    }

    public void empty_func5(String s, int i)
        throws IOException
    {
		
		System.out.println(s + " " +  i);
		
    }

    public void empty_func6(String s)
        throws IOException
    {
		System.out.println(s);
    }

    public void empty_func7()
        throws IOException
    {

    }

    public void empty_func8(int i)
    {
		System.out.println(i);
    }

    public void writeString(String s)
    {
		System.out.print(s);
    }

    public void empty_func10(String s, char c1)
    {
		System.out.println(s + " " + c1);
    }

    public void empty_func11(String s)
        throws IOException
    {
		System.out.println(s);
    }

    public void flush()
        throws IOException
    {
        if(_cipher != null)
            _cipher.updateSignature(_buffer, 0, _offsetBuff);
        _stream.write(_buffer, 0, _offsetBuff);
        _offsetBuff = 0;
    }

    public void flush(int __value)
        throws IOException
    {
        _buffer[_offsetBuff++] = (byte)__value;
        if(_offsetBuff == _buffer.length)
            flush();
    }

    public int writeSlack(int i)
        throws IOException
    {
        int j = i - 1;
        int k = (_offset + j & ~j) - _offset;
        if(k > 0)
            empty_func7();
        for(int l = k; l > 0; l--)
            writeByte(0);

        if(k > 0)
            empty_func11("slack");
        return k;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        int k = i + j;
        for(int l = i; l < k; l++)
            writeByte(abyte0[l]);

    }

    public void write(byte abyte0[])
        throws IOException
    {
        write(abyte0, 0, abyte0.length);
    }

    public void writeByte(int i)
        throws IOException
    {
        _offset++;
		short k = (short)(i);
		System.out.print(Integer.toHexString(k) + " ");
        flush(i);
    }

    public void writeByte(int i, String s, boolean flag)
        throws IOException
    {
		if (flag)
			System.out.println(s + " " +  i);
		else
			System.out.println(s);
        writeByte(i);
    }

    public void writeByte(int i, String s)
        throws IOException
    {
		System.out.println(s + " " +  i);
        writeByte(i);
    }

    public void writeChar(int i)
        throws IOException
    {
        _offset += 2;
        if(_endians)
        {
            flush(i);
            flush(i >> 8);
        } else
        {
            flush(i >> 8);
            flush(i);
        }
    }

    public void writeChar(int i, String s)
        throws IOException
    {
		System.out.println(s + " " +  i);
        writeChar(i);
    }

    public void writeShort(int param_startOffset)
        throws IOException
    {
        _offset += 2;
        if(_endians)
        {
            flush(param_startOffset);
            flush(param_startOffset >> 8);
        } else
        {
            flush(param_startOffset >> 8);
            flush(param_startOffset);
        }
    }

    public void writeShort(int param_startOffset, String s, boolean flag)
        throws IOException
    {
		System.out.println(s + " " + param_startOffset);
        writeShort(param_startOffset);
    }

    public void writeShort(int i, String s)
        throws IOException
    {
		System.out.println(s + " " +  i);
        writeShort(i);
    }

    public void writeMultibyteShort(int i)
        throws IOException
    {
        i &= 0xffff;
        if(_endians)
        {
            for(; (i & 0xffffff80) != 0; i >>>= 7)
                writeByte(i & 0x7f | 0x80);

            writeByte(i & 0x7f);
        } else
        {
            boolean flag = false;
            if((i & 0xc000) != 0 || flag)
            {
                flag = true;
                writeByte(i >> 14 & 0x7f | 0x80);
            }
            if((i & 0x3f80) != 0 || flag)
            {
                boolean flag1 = true;
                writeByte(i >> 7 & 0x7f | 0x80);
            }
            writeByte(i & 0x7f);
        }
    }

    public void writeMultibyteShort(int i, String s, boolean flag)
        throws IOException
    {
        writeMultibyteShort(i);
    }

    public void writeInt(int i)
        throws IOException
    {
        _offset += 4;
        if(_endians)
        {
            flush(i);
            flush(i >> 8);
            flush(i >> 16);
            flush(i >> 24);
        } else
        {
            flush(i >> 24);
            flush(i >> 16);
            flush(i >> 8);
            flush(i);
        }
    }

    public void writeInt(int i, String s, boolean flag)
        throws IOException
    {
		System.out.println(s + " " +  i);
        writeInt(i);
    }

    public void writeInt(int i, String s)
        throws IOException
    {
		System.out.println(s + " " +  i);
        writeInt(i);
    }

    public void writeLong(long l)
        throws IOException
    {
        _offset += 8;
        if(_endians)
        {
            flush((byte)(int)l);
            flush((byte)(int)(l >> 8));
            flush((byte)(int)(l >> 16));
            flush((byte)(int)(l >> 24));
            flush((byte)(int)(l >> 32));
            flush((byte)(int)(l >> 40));
            flush((byte)(int)(l >> 48));
            flush((byte)(int)(l >> 56));
        } else
        {
            flush((byte)(int)(l >> 56));
            flush((byte)(int)(l >> 48));
            flush((byte)(int)(l >> 40));
            flush((byte)(int)(l >> 32));
            flush((byte)(int)(l >> 24));
            flush((byte)(int)(l >> 16));
            flush((byte)(int)(l >> 8));
            flush((byte)(int)l);
        }
    }

    public void writeLong(long l, String s)
        throws IOException
    {
		System.out.println(s + " " +  l);
        writeLong(l);
    }

    public void close()
        throws IOException
    {
        flush();
        _stream.close();
        _stream = null;
        _buffer = null;
    }
}
