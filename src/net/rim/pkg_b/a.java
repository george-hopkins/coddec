// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.pkg_b;

import java.awt.Image;

// Referenced classes of package net.rim.b:
//            b, c

public class a extends b
{

    public a(byte abyte0[], int i, int j, c c)
    {
        super(abyte0, i, j, c);
    }

    protected Image _aImageIImage(Image image, int i, int j)
    {
        int k = image.getWidth(null);
        int l = image.getHeight(null);
        i = i > 0 ? i : k;
        j = j > 0 ? j : l;
        return image.getScaledInstance(i, j, 1);
    }
}
