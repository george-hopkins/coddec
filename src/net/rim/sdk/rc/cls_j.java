// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.UnsupportedEncodingException;

public class cls_j
{

    public static byte z_doB = 0;
    public static byte z_ifB = 1;
    public static byte z_aB = 2;
    private byte z_foraB[];
    private int z_intI;

    public cls_j()
    {
        z_foraB = new byte[15];
        z_intI = 0;
    }

    public void _aBV(byte byte0)
    {
        _aIV(z_intI + 1);
        z_foraB[z_intI] = byte0;
        z_intI++;
    }

    public void _aaBV(byte abyte0[])
    {
        _aaBIV(abyte0, abyte0.length);
    }

    public void _aaBIV(byte abyte0[], int i)
    {
        _aIV(z_intI + i);
        System.arraycopy(abyte0, 0, z_foraB, z_intI, i);
        z_intI += i;
    }

    public void _aSV(short word0)
    {
        _aIV(z_intI + 2);
        z_foraB[z_intI] = (byte)(word0 >> 8 & 0xff);
        z_foraB[z_intI + 1] = (byte)(word0 & 0xff);
        z_intI += 2;
    }

    public void _aStringV(String s)
    {
        try
        {
            boolean flag = true;
            for(int i = s.length() - 1; i >= 0; i--)
            {
                if((s.charAt(i) & 0xff00) == 0)
                    continue;
                flag = false;
                break;
            }

            if(flag)
            {
                byte abyte0[] = s.getBytes("ISO8859-1");
                _aSV((short)abyte0.length);
                _aBV(z_doB);
                _aaBV(abyte0);
            } else
            {
                byte abyte1[] = s.getBytes("UTF-8");
                _aSV((short)abyte1.length);
                _aBV(z_ifB);
                _aaBV(abyte1);
            }
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
    }

    public byte[] _avaB()
    {
        byte abyte0[] = new byte[z_intI];
        System.arraycopy(z_foraB, 0, abyte0, 0, z_intI);
        return abyte0;
    }

    public int _ifvI()
    {
        return z_intI;
    }

    private void _aIV(int i)
    {
        if(z_foraB.length < i)
        {
            i = Math.max(z_foraB.length + 100, i);
            byte abyte0[] = new byte[i];
            System.arraycopy(z_foraB, 0, abyte0, 0, z_intI);
            z_foraB = abyte0;
        }
    }

}
