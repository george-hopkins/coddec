// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.pkg_b;

import java.awt.image.ColorModel;

// Referenced classes of package net.rim.b:
//            c

public class d extends c
{

    public d()
    {
    }

    protected int _aII(int i)
    {
        int j = super.z_foraI[i];
        int k = super.z_ifColorModel.getAlpha(j);
        int l = _aIColorModelI(j, super.z_ifColorModel);
        char c1 = l <= 128 ? '\0' : '\377';
        int i1 = 0;
        i1 |= c1;
        i1 |= c1 << 8;
        i1 |= c1 << 16;
        i1 |= k << 24;
        super.z_foraI[i] = i1;
        return l - c1;
    }

    protected void _avV()
    {
        if(super.z_foraI != null)
        {
            for(int j = 1; j < super.z_aI - 2; j++)
            {
                for(int k = 1; k < super.z_doI - 2; k++)
                {
                    int i = _aII(j * super.z_doI + k);
                    _aIIV((j + 0) * super.z_doI + k + 1, (i * 7) / 16);
                    _aIIV(((j + 1) * super.z_doI + k) - 1, (i * 3) / 16);
                    _aIIV((j + 1) * super.z_doI + k + 0, (i * 5) / 16);
                    _aIIV((j + 1) * super.z_doI + k + 1, (i * 1) / 16);
                }

            }

        }
    }

    protected void _aIIV(int i, int j)
    {
        int k = super.z_foraI[i];
        int i1 = super.z_ifColorModel.getAlpha(k);
        int j1 = _aIColorModelI(k, super.z_ifColorModel) + j;
        j1 = j1 <= 255 ? j1 : 255;
        j1 = j1 >= 0 ? j1 : 0;
        int l = 0;
        l |= j1;
        l |= j1 << 8;
        l |= j1 << 16;
        l |= i1 << 24;
        super.z_foraI[i] = l;
    }
}
