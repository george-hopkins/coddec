// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.pkg_b;

import java.awt.image.ColorModel;

// Referenced classes of package net.rim.b:
//            c

public class e extends c
{

    public e()
    {
    }

    protected void _avV()
    {
        if(super.z_foraI != null)
        {
            for(int i1 = 0; i1 < super.z_aI; i1++)
            {
                for(int j1 = 0; j1 < super.z_doI; j1++)
                {
                    int i = super.z_foraI[i1 * super.z_doI + j1];
                    int l = super.z_ifColorModel.getAlpha(i);
                    int k = _aIColorModelI(i, super.z_ifColorModel);
                    char c1 = k <= 128 ? '\0' : '\377';
                    int j = 0;
                    j |= c1;
                    j |= c1 << 8;
                    j |= c1 << 16;
                    j |= l << 24;
                    super.z_foraI[i1 * super.z_doI + j1] = j;
                }

            }

        }
    }
}
