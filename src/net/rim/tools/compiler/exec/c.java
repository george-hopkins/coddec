// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.PixelGrabber;
import java.io.*;
import java.util.zip.*;

// Referenced classes of package net.rim.tools.compiler.c:
//            i, d

public class c
{
    static class c
    {

        private static final int z_ifI = 4;
        private byte z_byteaB[];
        private byte z_tryaB[];
        private byte z_elseaB[];
        private int z_newI;
        private int z_doI;
        private int z_caseI;
        private int z_aI;
        private int z_forI;
        private net.rim.tools.compiler.exec.cls_c$b z_gotoc$b;
        private Deflater z_charDeflater;
        private DeflaterOutputStream z_intDeflaterOutputStream;

        private byte _aBBB(byte byte0, byte byte1, byte byte2)
        {
            int j = byte0 & 0xff;
            int k = byte1 & 0xff;
            int l = byte2 & 0xff;
            int i1 = (j + k) - l;
            int j1 = Math.abs(i1 - j);
            int k1 = Math.abs(i1 - k);
            int l1 = Math.abs(i1 - l);
            if(j1 <= k1 && j1 <= l1)
                return byte0;
            if(k1 <= l1)
                return byte1;
            else
                return byte2;
        }

        private void _aIV(int j)
        {
            switch(j)
            {
            case 0: // '\0'
                System.arraycopy(z_tryaB, 4, z_elseaB, 0, z_forI);
                return;

            case 1: // '\001'
                for(int k = 0; k < z_forI; k++)
                    z_elseaB[k] = (byte)(z_tryaB[k + 4] - z_tryaB[(k + 4) - z_aI]);

                return;

            case 4: // '\004'
                for(int l = 0; l < z_forI; l++)
                    z_elseaB[l] = (byte)(z_tryaB[l + 4] - _aBBB(z_tryaB[(l + 4) - z_aI], z_byteaB[l + 4], z_byteaB[(l + 4) - z_aI]));

                return;

            case 2: // '\002'
            case 3: // '\003'
            default:
                throw new RuntimeException();
            }
        }

        public void _aaIIV(int ai[], int j, i k)
            throws IOException
        {
            byte abyte0[] = z_byteaB;
            z_byteaB = z_tryaB;
            z_tryaB = abyte0;
            z_gotoc$b._aaBIV(z_tryaB, 4);
            switch(z_newI)
            {
            case 1: // '\001'
            case 5: // '\005'
            default:
                break;

            case 0: // '\0'
                for(int l = 0; l < z_doI; l++)
                {
                    int i1 = net.rim.tools.compiler.exec.c._access$000II(ai[j + l]);
                    z_gotoc$b._aIIV(i1 >> 8 - z_caseI, z_caseI);
                }

                break;

            case 2: // '\002'
                for(int j1 = 0; j1 < z_doI; j1++)
                {
                    int k1 = ai[j + j1];
                    z_gotoc$b._aIIV(k1 >> 16 & 0xff, 8);
                    z_gotoc$b._aIIV(k1 >> 8 & 0xff, 8);
                    z_gotoc$b._aIIV(k1 & 0xff, 8);
                }

                break;

            case 3: // '\003'
                for(int l1 = 0; l1 < z_doI; l1++)
                {
                    int j2 = k._doII(net.rim.tools.compiler.exec.c._access$100II(ai[j + l1]));
                    z_gotoc$b._aIIV(j2, z_caseI);
                }

                break;

            case 4: // '\004'
                for(int i2 = 0; i2 < z_doI; i2++)
                {
                    int k2 = net.rim.tools.compiler.exec.c._access$000II(ai[j + i2]);
                    int i3 = ai[j + i2] >>> 24;
                    z_gotoc$b._aIIV(k2, 8);
                    z_gotoc$b._aIIV(i3, 8);
                }

                break;

            case 6: // '\006'
                for(int l2 = 0; l2 < z_doI; l2++)
                {
                    int j3 = ai[j + l2];
                    z_gotoc$b._aIIV(j3 >>> 16 & 0xff, 8);
                    z_gotoc$b._aIIV(j3 >>> 8 & 0xff, 8);
                    z_gotoc$b._aIIV(j3 & 0xff, 8);
                    z_gotoc$b._aIIV(j3 >>> 24 & 0xff, 8);
                }

                break;
            }
            byte byte0 = 4;
            _aIV(4);
            z_intDeflaterOutputStream.write(4);
            z_intDeflaterOutputStream.write(z_elseaB, 0, z_forI);
        }

        public void _avV()
            throws IOException
        {
            z_intDeflaterOutputStream.finish();
            z_charDeflater.end();
        }

        public c(int j, int k, int l, DataOutputStream dataoutputstream)
        {
            z_gotoc$b = new net.rim.tools.compiler.exec.cls_c$b();
            z_caseI = l;
            z_doI = k;
            z_newI = j;
            z_charDeflater = new Deflater(9);
            z_intDeflaterOutputStream = new DeflaterOutputStream(dataoutputstream, z_charDeflater);
            switch(j)
            {
            case 0: // '\0'
            case 3: // '\003'
                z_forI = (k * l + 7) / 8;
                z_aI = 1;
                break;

            case 2: // '\002'
                z_forI = k * 3;
                z_aI = 3;
                break;

            case 4: // '\004'
                z_forI = k * 2;
                z_aI = 2;
                break;

            case 6: // '\006'
                z_forI = k * 4;
                z_aI = 4;
                break;

            case 1: // '\001'
            case 5: // '\005'
            default:
                throw new RuntimeException();
            }
            z_byteaB = new byte[z_forI + 4];
            z_tryaB = new byte[z_forI + 4];
            z_elseaB = new byte[z_forI];
        }
    }

    static class b
    {

        private byte z_ifaB[];
        private int z_aI;
        private int z_doI;

        public void _aaBIV(byte abyte0[], int j)
        {
            z_ifaB = abyte0;
            for(int k = 0; k < z_ifaB.length; k++)
                z_ifaB[k] = 0;

            z_aI = j - 1;
            z_doI = 0;
        }

        public void _aIIV(int j, int k)
        {
            z_doI -= k;
            if(z_doI < 0)
            {
                z_doI = 8 - k;
                z_aI++;
            }
            z_ifaB[z_aI] |= j << z_doI;
        }

        public b()
        {
        }
    }

    static class a extends ByteArrayOutputStream
    {

        public byte[] _avaB()
        {
            return super.buf;
        }

        a()
        {
        }
    }


    private static final int z_newI = 1;
    private static final int z_tryI = 2;
    private static final int z_byteI = 3;
    private static final byte z_elseaB[] = {
        -119, 80, 78, 71, 13, 10, 26, 10
    };
    private static final byte z_doaB[] = {
        73, 72, 68, 82
    };
    private static final byte z_intaB[] = {
        73, 68, 65, 84
    };
    private static final byte z_charaB[] = {
        73, 69, 78, 68
    };
    private static final byte z_foraB[] = {
        80, 76, 84, 69
    };
    private static final byte z_caseaB[] = {
        116, 82, 78, 83
    };
    private static final int z_aI = 0xf0f8fcf8;
    private static final int z_ifI = 0xf0000000;

    public c()
    {
    }

    private static int _aII(int j)
    {
        return j >>> 8 & 0xff;
    }

    public static byte[] _aaIIIIIaB(int ai[], int j, int k, int l, int i1, i j1, int k1)
    {
        byte abyte0[] = new byte[j << 2];
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        a a1 = new a();
        DataOutputStream dataoutputstream1 = new DataOutputStream(a1);
        try
        {
            dataoutputstream.write(z_elseaB, 0, z_elseaB.length);
            dataoutputstream1.write(z_doaB, 0, z_doaB.length);
            dataoutputstream1.writeInt(j);
            dataoutputstream1.writeInt(k);
            dataoutputstream1.writeByte(i1);
            dataoutputstream1.writeByte(l);
            dataoutputstream1.writeByte(0);
            dataoutputstream1.writeByte(0);
            dataoutputstream1.writeByte(0);
            CRC32 crc32 = new CRC32();
            _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
            if(j1 != null)
            {
                dataoutputstream1.write(z_foraB, 0, z_foraB.length);
                int l1 = j1.z_doI;
                for(int i2 = 0; i2 < l1; i2++)
                {
                    int k2 = j1.z_tryaI[i2];
                    dataoutputstream1.writeByte(k2 >>> 16 & 0xff);
                    dataoutputstream1.writeByte(k2 >>> 8 & 0xff);
                    dataoutputstream1.writeByte(k2 & 0xff);
                }

                _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
                int l2 = j1.z_byteI;
                if(l2 > 0)
                {
                    dataoutputstream1.write(z_caseaB, 0, z_caseaB.length);
                    for(int j3 = 0; j3 < l2; j3++)
                    {
                        int k3 = j1.z_tryaI[j3];
                        dataoutputstream1.writeByte(k3 >>> 24);
                    }

                    _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
                }
            }
            if(k1 != -1)
            {
                dataoutputstream1.write(z_caseaB, 0, z_caseaB.length);
                switch(l)
                {
                case 0: // '\0'
                    dataoutputstream1.writeShort(k1);
                    break;

                case 2: // '\002'
                    dataoutputstream1.writeShort(k1 >>> 16 & 0xff);
                    dataoutputstream1.writeShort(k1 >>> 8 & 0xff);
                    dataoutputstream1.writeShort(k1 & 0xff);
                    break;

                default:
                    throw new RuntimeException("Internal Image Conversion Error 1");
                }
                _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
            }
            dataoutputstream1.write(z_intaB, 0, z_intaB.length);
            c c1 = new c(l, j, i1, dataoutputstream1);
            try
            {
                int j2 = 0;
                for(int i3 = 0; i3 < k; i3++)
                {
                    c1._aaIIV(ai, j2, j1);
                    j2 += j;
                }

            }
            finally
            {
                c1._avV();
            }
            _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
            dataoutputstream1.write(z_charaB, 0, z_charaB.length);
            _ac$aDSDV(a1, dataoutputstream1, dataoutputstream, crc32);
            dataoutputstream1.flush();
            dataoutputstream1.close();
            dataoutputstream.flush();
            dataoutputstream.close();
        }
        catch(IOException ioexception) { }
        return bytearrayoutputstream.toByteArray();
    }

    private static void _ac$aDSDV(a a1, DataOutputStream dataoutputstream, DataOutputStream dataoutputstream1, CRC32 crc32)
        throws IOException
    {
        dataoutputstream.flush();
        dataoutputstream1.writeInt(a1.size() - 4);
        dataoutputstream1.write(a1._avaB(), 0, a1.size());
        crc32.update(a1._avaB(), 0, a1.size());
        dataoutputstream1.writeInt((int)crc32.getValue());
        crc32.reset();
        a1.reset();
    }

    private static boolean _ifaBZ(byte abyte0[])
    {
        byte byte0 = 8;
        byte abyte1[] = {
            -119, 80, 78, 71, 13, 10, 26, 10
        };
        if(abyte0.length < 8)
            return false;
        for(int j = 0; j < 8; j++)
            if(abyte0[j] != abyte1[j])
                return false;

        return true;
    }

    private static boolean _aaBZ(byte abyte0[])
    {
        byte byte0 = 6;
        byte abyte1[][] = {
            {
                71, 73, 70, 56, 55, 97
            }, {
                71, 73, 70, 56, 57, 97
            }
        };
        if(abyte0.length < 6)
            return false;
        for(int j = 0; j < abyte1.length; j++)
        {
            boolean flag = true;
            for(int k = 0; k < abyte1[j].length; k++)
            {
                if(abyte0[k] == abyte1[j][k])
                    continue;
                flag = false;
                break;
            }

            if(flag)
                return true;
        }

        return false;
    }

    private static int _doII(int j)
    {
        if(j == 255)
            return 0;
        byte byte0;
        if((j & 0xf) != j >>> 4)
            byte0 = 8;
        else
        if((j & 3) != (j >>> 2 & 3))
            byte0 = 4;
        else
        if((j & 1) != (j >>> 1 & 1))
            byte0 = 2;
        else
            byte0 = 1;
        return byte0;
    }

    private static int _ifII(int j)
    {
        if(net.rim.tools.compiler.exec.cls_d._tryII(j) == 0)
        {
            return 0xffffff;
        } else
        {
            int k = j & 0xf0000000 | j >>> 4 & 0xf000000;
            k |= j & 0xf80000 | (j & 0xe00000) >> 5;
            k |= j & 0xfc00 | (j & 0xc000) >> 6;
            k |= j & 0xf8 | (j & 0xe0) >> 5;
            return k;
        }
    }

    public static byte[] _aaBZaB(byte abyte0[], boolean flag)
    {
        Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
        byte abyte1[] = _aImageaB(image);
        return abyte1;
    }

    public static int _aIII(int j, int k)
    {
        int l = j >>> 8 - k;
        for(; k < 8; k *= 2)
            l |= l << k;

        return l >>> k - 8;
    }

    public static void _aaIV(int ai[])
    {
        for(int j = 0; j < ai.length; j++)
        {
            int k = ai[j];
            char c1 = '\377';
            int l = _aIII(k >>> 16 & 0xff, 5);
            int i1 = _aIII(k >>> 8 & 0xff, 6);
            int j1 = _aIII(k & 0xff, 5);
            ai[j] = c1 << 24 | l << 16 | i1 << 8 | j1;
        }

    }

    public static byte[] _aImageaB(Image image)
    {
        int j = 0;
        while(image.getWidth(null) == -1 || image.getHeight(null) == -1)
        {
            try
            {
                Thread.sleep(50L);
            }
            catch(InterruptedException interruptedexception) { }
            if(++j > 100)
                throw new IllegalArgumentException();
        }
        int k = image.getWidth(null);
        int l = image.getHeight(null);
        int i1 = k * l;
        int ai[] = new int[i1];
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, k, l, ai, 0, k);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception1)
        {
            throw new IllegalArgumentException();
        }
        if((pixelgrabber.getStatus() & 0x80) != 0)
            throw new IllegalArgumentException();
        int j1 = 0;
        for(int k1 = 0; k1 < i1; k1++)
        {
            int l1 = ai[k1] >>> 24;
            int i2 = _doII(l1);
            if(i2 > j1)
                j1 = i2;
        }

        boolean flag = true;
        int j2 = 1;
        for(int k2 = 0; k2 < i1; k2++)
        {
            int l2 = ai[k2];
            int k3 = l2 >>> 16 & 0xff;
            int j4 = l2 >>> 8 & 0xff;
            int i5 = l2 & 0xff;
            if(k3 != j4 || j4 != i5)
            {
                flag = false;
                break;
            }
            int l5 = _aII(l2);
            int k6 = _doII(l5);
            if(k6 > j2)
                j2 = k6;
        }

        if(flag)
        {
            if(j1 == 0)
                return _aaIIIIIaB(ai, k, l, 0, j2, null, -1);
            if(j1 == 1)
            {
                int i3 = -1;
                for(int l3 = 0; l3 < i1; l3++)
                {
                    if(ai[l3] >>> 24 != 0)
                        continue;
                    int k4 = _aII(ai[l3]);
                    k4 >>>= 8 - j2;
                    if(i3 == -1)
                    {
                        i3 = k4;
                        continue;
                    }
                    if(k4 == i3)
                        continue;
                    i3 = -1;
                    break;
                }

                if(i3 != -1)
                {
                    for(int l4 = 0; l4 < i1; l4++)
                    {
                        int j5 = ai[l4];
                        if(_aII(j5) >>> 8 - j2 != i3 || j5 >>> 24 == 0)
                            continue;
                        i3 = -1;
                        break;
                    }

                }
                if(i3 != -1)
                    return _aaIIIIIaB(ai, k, l, 0, j2, null, i3);
            }
        }
        i j3 = new i();
        for(int i4 = 0; i4 < i1; i4++)
        {
            if(j3._aIZ(_ifII(ai[i4])))
                continue;
            j3 = null;
            break;
        }

        if(j3 != null)
        {
            byte byte0 = 8;
            if(j3.z_doI <= 2)
                byte0 = 1;
            else
            if(j3.z_doI <= 4)
                byte0 = 2;
            else
            if(j3.z_doI <= 16)
                byte0 = 4;
            return _aaIIIIIaB(ai, k, l, 3, byte0, j3, -1);
        }
        if(flag)
            return _aaIIIIIaB(ai, k, l, 4, 8, null, -1);
        if(j1 > 0)
        {
            if(j1 == 1)
            {
                byte byte1 = -1;
                for(int k5 = 0; k5 < i1; k5++)
                {
                    if(ai[k5] >>> 24 <= 0 || byte1 == -1)
                        continue;
                    int i6 = ai[k5] & 0xffffff;
                    if(i6 == byte1)
                        continue;
                    byte1 = -1;
                    break;
                }

                if(byte1 != -1)
                {
                    for(int j6 = 0; j6 < i1; j6++)
                    {
                        int l6 = ai[j6];
                        if((l6 & 0xffffff) != byte1 || l6 >>> 24 == 0)
                            continue;
                        byte1 = -1;
                        break;
                    }

                }
                if(byte1 != -1)
                    return _aaIIIIIaB(ai, k, l, 2, 8, null, byte1);
            }
            return _aaIIIIIaB(ai, k, l, 6, 8, null, -1);
        } else
        {
            return _aaIIIIIaB(ai, k, l, 2, 8, null, -1);
        }
    }

    static int _access$000II(int j)
    {
        return _aII(j);
    }

    static int _access$100II(int j)
    {
        return _ifII(j);
    }

}
