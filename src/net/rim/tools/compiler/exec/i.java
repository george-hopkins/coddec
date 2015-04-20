// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.tools.compiler.exec;


// Referenced classes of package net.rim.tools.compiler.c:
//            d

class i
{

    private static final int z_forI = 256;
    private static final int z_intI = 512;
    int z_tryaI[];
    int z_doI;
    int z_byteI;
    int z_ifaI[];
    int z_newaI[];
    int z_aI;

    i()
    {
        z_tryaI = new int[256];
        z_ifaI = new int[512];
        z_newaI = new int[512];
    }

    int _doIII(int j, int k)
    {
        boolean flag = cls_d._ifIZ(j);
        boolean flag1 = cls_d._ifIZ(k);
        if(flag != flag1)
            return flag ? -1 : 1;
        int l = cls_d._forII(j);
        int i1 = cls_d._forII(k);
        if(i1 != l)
            return i1 <= l ? 1 : -1;
        int j1 = cls_d._intII(j);
        int k1 = cls_d._intII(k);
        if(k1 != j1)
            return k1 <= j1 ? 1 : -1;
        int l1 = cls_d._aII(j);
        int i2 = cls_d._aII(k);
        if(i2 != l1)
            return i2 <= l1 ? 1 : -1;
        int j2 = cls_d._tryII(j);
        int k2 = cls_d._tryII(k);
        if(k2 != j2)
            return k2 <= j2 ? 1 : -1;
        else
            return 0;
    }

    public int _aaIII(int ai[], int j, int k)
    {
        int l = 0;
        for(int i1 = k - 1; l <= i1;)
        {
            int j1 = l + i1 >> 1;
            int k1 = _doIII(j, ai[j1]);
            if(k1 < 0)
                i1 = j1 - 1;
            else
            if(k1 > 0)
                l = j1 + 1;
            else
                return j1;
        }

        return -(l + 1);
    }

    boolean _ifIZ(int j)
    {
        if(z_doI == 512)
            return false;
        double d1 = 100D;
        int k = 0;
        for(int l = 0; l < z_doI; l++)
            if(cls_d._tryII(j) == cls_d._tryII(z_tryaI[l]))
            {
                double d2 = cls_d._aIID(j, z_tryaI[l]);
                if(d2 < d1)
                {
                    d1 = d2;
                    k = z_tryaI[l];
                }
            }

        if(d1 > 0.0D && d1 < 3D)
        {
            _ifIIV(j, k);
            return true;
        } else
        {
            return false;
        }
    }

    boolean _aIZ(int j)
    {
        int k = _aaIII(z_tryaI, j, z_doI);
        if(k >= 0)
            return true;
        if(z_doI == 256)
        {
            return false;
        } else
        {
            _aIIV(j, -k - 1);
            return true;
        }
    }

    void _ifIIV(int j, int k)
    {
        int l = _aaIII(z_ifaI, j, z_aI);
        if(l >= 0)
        {
            return;
        } else
        {
            l = -l - 1;
            System.arraycopy(z_ifaI, l, z_ifaI, l + 1, z_aI - l);
            System.arraycopy(z_newaI, l, z_newaI, l + 1, z_aI - l);
            z_ifaI[l] = j;
            z_newaI[l] = k;
            z_aI++;
            return;
        }
    }

    void _aIIV(int j, int k)
    {
        System.arraycopy(z_tryaI, k, z_tryaI, k + 1, z_doI - k);
        z_tryaI[k] = j;
        z_doI++;
        if(cls_d._ifIZ(j))
            z_byteI++;
    }

    int _doII(int j)
    {
        if(z_aI > 0)
        {
            int k = _aaIII(z_ifaI, j, z_aI);
            if(k >= 0)
                j = z_newaI[k];
        }
        int l = _aaIII(z_tryaI, j, z_doI);
        if(l >= 0)
            return l;
        else
            return -l - 1;
    }
}
