// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.rim.tools.compiler.vm.Constants;

// Referenced classes of package net.rim.tools.compiler.c:
//            g, h

public class j extends net.rim.tools.compiler.exec.g
implements net.rim.tools.compiler.vm.Constants
{

    private StringBuffer _buffer;
    private net.rim.tools.compiler.exec.h _modifiers;
    private MessageDigest _messageDigestProc;
    private byte _signature[];

    public j(net.rim.tools.compiler.exec.h h1, String __algorithm)
    {
        _buffer = new StringBuffer(4096);
        _modifiers = h1;
        try
        {
            _messageDigestProc = MessageDigest.getInstance(__algorithm);
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            throw new RuntimeException(nosuchalgorithmexception.getMessage());
        }
    }

    public void updateSignature(byte __data[], int __start, int __size)
    {
        _messageDigestProc.update(__data, __start, __size);
    }

    public void _byteStringV(String s)
    {
        _buffer.append(s);
        _buffer.append(" ");
        _messageDigestProc.update(s.getBytes());
    }

    public void _gotoIV(int i)
    {
        _modifiers._aIStringBufferV(i, _buffer);
        _messageDigestProc.update((byte)(i >> 24 & 0xff));
        _messageDigestProc.update((byte)(i >> 16 & 0xff));
        _messageDigestProc.update((byte)(i >> 8 & 0xff));
        _messageDigestProc.update((byte)(i & 0xff));
    }

    public void append(String s)
    {
        _buffer.append(s);
    }

    public byte[] getSignature()
    {
        if(_signature == null)
            _signature = _messageDigestProc.digest();
        return _signature;
    }

    private static int _nullII(int i)
    {
        if(97 <= i && i <= 102)
            return (i - 97) + 10;
        if(65 <= i && i <= 70)
            return (i - 65) + 10;
        else
            return i - 48;
    }

    public byte[] _aInputStreamaB(InputStream __input)
        throws IOException
    {
        int i = _messageDigestProc.getDigestLength();
        byte abyte0[] = new byte[i];
        for(int k = 0; k < i; k++)
        {
            int l = __input.read();
            int i1 = __input.read();
            abyte0[k] = (byte)((_nullII(l) << 4) + _nullII(i1) & 0xff);
        }

        return abyte0;
    }

    private static char _longIC(int i)
    {
        if(10 <= i && i <= 15)
            return (char)(87 + i);
        else
            return (char)(48 + i);
    }

    public String toString()
    {
        byte abyte0[] = getSignature();
        int i = abyte0.length;
        StringBuffer stringbuffer = new StringBuffer(i * 3);
        for(int k = 0; k < i; k++)
        {
            if(k > 0)
                stringbuffer.append(' ');
            stringbuffer.append(_longIC((abyte0[k] & 0xf0) >> 4));
            stringbuffer.append(_longIC(abyte0[k] & 0xf));
        }

        return stringbuffer.toString();
    }

    public void _aPrintStreamV(PrintStream printstream)
        throws IOException
    {
        byte abyte0[] = getSignature();
        int i = abyte0.length;
        for(int k = 0; k < i; k++)
        {
            printstream.print(_longIC((abyte0[k] & 0xf0) >> 4));
            printstream.print(_longIC(abyte0[k] & 0xf));
        }

        printstream.print("\n");
        printstream.print(_buffer.toString());
    }

    public static boolean Compare(byte abyte0[], byte abyte1[])
    {
        return MessageDigest.isEqual(abyte0, abyte1);
    }
}
