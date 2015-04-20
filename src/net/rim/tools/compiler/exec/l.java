// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.awt.Image;
import net.rim.pkg_b.a;
import net.rim.pkg_b.b;
import net.rim.pkg_b.d;

// Referenced classes of package net.rim.tools.compiler.c:
//            c

public class l
{

    public l()
    {
    }

    public static byte[] _aaBIaB(byte abyte0[], int i, int j)
    {
        if(abyte0 == null)
        {
            return null;
        } else
        {
            net.rim.pkg_b.d d1 = new net.rim.pkg_b.d();
            net.rim.pkg_b.a a1 = new net.rim.pkg_b.a(abyte0, i, j, d1);
            abyte0 = a1._ifvaB();
            return abyte0;
        }
    }

    public static int[] _ifaBaI(byte abyte0[])
    {
        int ai[] = new int[2];
        ai[0] = -1;
        ai[1] = -1;
        if(abyte0 != null)
        {
            Image image = net.rim.pkg_b.b._aaBImage(abyte0);
            if(image != null)
            {
                ai[0] = image.getWidth(null);
                ai[1] = image.getHeight(null);
            }
        }
        return ai;
    }

    public static byte[] _aaBaB(byte abyte0[])
    {
        try
        {
            abyte0 = net.rim.tools.compiler.exec.c._aaBZaB(abyte0, true);
        }
        catch(IllegalArgumentException illegalargumentexception)
        {
            abyte0 = null;
        }
        return abyte0;
    }
}
