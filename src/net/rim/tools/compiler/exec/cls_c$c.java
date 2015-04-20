// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

// Referenced classes of package net.rim.tools.compiler.c:
//            c, i

class cls_c$c
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

    public cls_c$c(int j, int k, int l, DataOutputStream dataoutputstream)
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
