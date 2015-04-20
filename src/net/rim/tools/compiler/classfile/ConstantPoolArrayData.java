// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import net.rim.tools.compiler.vm.Constants;

// Referenced classes of package net.rim.tools.compiler.e:
//            o, h

public final class ConstantPoolArrayData extends net.rim.tools.compiler.classfile.ConstantPoolEntry
implements net.rim.tools.compiler.vm.Constants
{

    private int _type;
    private byte _data[];
    private net.rim.tools.compiler.classfile.ConstantPoolFieldRef _fieldRef;

    public ConstantPoolArrayData(int i, long al[], net.rim.tools.compiler.classfile.ConstantPoolFieldRef h)
    {
        super(-1);
        _type = i;
        _fieldRef = h;
        switch(_type)
        {
        case 1: // '\001'
        case 2: // '\002'
            _data = _foraJaB(al);
            break;

        case 3: // '\003'
        case 4: // '\004'
            _data = _aaJaB(al);
            break;

        case 5: // '\005'
            _data = _doaJaB(al);
            break;

        case 6: // '\006'
            _data = _ifaJaB(al);
            break;
        }
    }

    public int getArrayType()
    {
        return _type;
    }

    public byte[] getBytes()
    {
        return _data;
    }

    public net.rim.tools.compiler.classfile.ConstantPoolFieldRef getFieldRef()
    {
        return _fieldRef;
    }

    private byte[] _foraJaB(long al[])
    {
        byte abyte0[] = new byte[al.length];
        for(int i = 0; i < al.length; i++)
            abyte0[i] = (byte)(int)al[i];

        return abyte0;
    }

    private byte[] _aaJaB(long al[])
    {
        byte abyte0[] = new byte[2 * al.length];
        for(int i = 0; i < al.length; i++)
        {
            long l1 = al[i];
            byte byte0 = (byte)(int)(l1 & 255L);
            byte byte1 = (byte)(int)(l1 >> 8 & 255L);
            abyte0[2 * i + 0] = byte0;
            abyte0[2 * i + 1] = byte1;
        }

        return abyte0;
    }

    private byte[] _doaJaB(long al[])
    {
        byte abyte0[] = new byte[4 * al.length];
        for(int i = 0; i < al.length; i++)
        {
            long l1 = al[i];
            byte byte0 = (byte)(int)(l1 & 255L);
            byte byte1 = (byte)(int)(l1 >> 8 & 255L);
            byte byte2 = (byte)(int)(l1 >> 16 & 255L);
            byte byte3 = (byte)(int)(l1 >> 24 & 255L);
            abyte0[4 * i + 0] = byte0;
            abyte0[4 * i + 1] = byte1;
            abyte0[4 * i + 2] = byte2;
            abyte0[4 * i + 3] = byte3;
        }

        return abyte0;
    }

    private byte[] _ifaJaB(long al[])
    {
        byte abyte0[] = new byte[8 * al.length];
        for(int i = 0; i < al.length; i++)
        {
            long l1 = al[i];
            byte byte0 = (byte)(int)(l1 & 255L);
            byte byte1 = (byte)(int)(l1 >> 8 & 255L);
            byte byte2 = (byte)(int)(l1 >> 16 & 255L);
            byte byte3 = (byte)(int)(l1 >> 24 & 255L);
            byte byte4 = (byte)(int)(l1 >> 32 & 255L);
            byte byte5 = (byte)(int)(l1 >> 40 & 255L);
            byte byte6 = (byte)(int)(l1 >> 48 & 255L);
            byte byte7 = (byte)(int)(l1 >> 56 & 255L);
            abyte0[8 * i + 0] = byte0;
            abyte0[8 * i + 1] = byte1;
            abyte0[8 * i + 2] = byte2;
            abyte0[8 * i + 3] = byte3;
            abyte0[8 * i + 4] = byte4;
            abyte0[8 * i + 5] = byte5;
            abyte0[8 * i + 6] = byte6;
            abyte0[8 * i + 7] = byte7;
        }

        return abyte0;
    }
}
