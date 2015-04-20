// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;


class cls_d
{
    static class b
    {

        double z_doD;
        double z_ifD;
        double z_aD;

        b()
        {
        }
    }

    static class a
    {

        double z_doD;
        double z_ifD;
        double z_aD;

        a()
        {
        }
    }


    cls_d()
    {
    }

    static boolean _ifIZ(int i)
    {
        return (i & 0xf0000000) != 0xf0000000;
    }

    static int _tryII(int i)
    {
        return i >>> 24;
    }

    static int _forII(int i)
    {
        return i >>> 16 & 0xff;
    }

    static int _intII(int i)
    {
        return i >>> 8 & 0xff;
    }

    static int _aII(int i)
    {
        return i & 0xff;
    }

    static a _newId$a(int i)
    {
        int j = _forII(i);
        int k = _intII(i);
        int l = _aII(i);
        int i1 = Math.min(j, Math.min(k, l));
        int j1 = Math.max(j, Math.max(k, l));
        double d1 = (100D * (double)j1) / 255D;
        double d2 = j1 - i1;
        double d3 = j1 != 0 ? (100D * d2) / (double)j1 : 0.0D;
        double d4;
        if(d3 == 0.0D)
        {
            d4 = 0.0D;
        } else
        {
            if(j == j1)
                d4 = (60D * (double)(k - l)) / d2;
            else
            if(k == j1)
                d4 = 120D + (60D * (double)(l - j)) / d2;
            else
                d4 = 240D + (60D * (double)(j - k)) / d2;
            if(d4 < 0.0D)
                d4 += 360D;
        }
        a a1 = new a();
        a1.z_doD = d4;
        a1.z_ifD = d3;
        a1.z_aD = d1;
        return a1;
    }

    static b _ad$ad$b(a a1)
    {
        b b1 = new b();
        double d1 = Math.toRadians(a1.z_doD);
        double d2 = (a1.z_ifD * a1.z_aD) / 100D;
        b1.z_doD = d2 * Math.cos(d1);
        b1.z_ifD = d2 * Math.sin(d1);
        b1.z_aD = a1.z_aD;
        return b1;
    }

    static int _doII(int i)
    {
        return i & 0xf0f8fcf8;
    }

    static double _aIID(int i, int j)
    {
        b b1 = _ad$ad$b(_newId$a(_doII(i)));
        b b2 = _ad$ad$b(_newId$a(_doII(j)));
        double d1 = b1.z_doD - b2.z_doD;
        double d2 = b1.z_ifD - b2.z_ifD;
        double d3 = b1.z_aD - b2.z_aD;
        return Math.pow(d1 * d1 + d2 * d2 + d3 * d3, 0.33333333333333331D);
    }
}
