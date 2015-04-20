// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.pkg_b;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ColorModel;
import java.awt.image.PixelGrabber;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package net.rim.b:
//            c

public class b
{

    protected int z_aI;
    protected int z_byteI;
    protected int z_forI;
    protected byte z_caseaB[];
    protected int z_doI;
    protected c z_ifc;
    protected static final int z_tryI = -1;
    protected static final int z_newI = 1;
    protected static final int z_intaI[] = {
        1, 2, 4, 8, 16, 32, 64, 128
    };

    protected b()
    {
        z_aI = -1;
        z_byteI = -1;
        z_forI = -1;
    }

    public b(byte abyte0[], int i, int j, c c1)
    {
        this();
        z_ifc = c1;
        Image image = _aaBImage(abyte0);
        _ifImageIV(image, i, j);
    }

    public b(int i, int j)
    {
        this(i, j, 1);
    }

    public b(int i, int j, int k)
    {
        this();
        if(i > 0 && j > 0 && k >= 0)
        {
            z_aI = i;
            z_byteI = j;
            z_forI = k;
            z_doI = z_byteI % 8 != 0 ? z_byteI / 8 + 1 : z_byteI / 8;
            z_caseaB = new byte[z_aI * z_doI];
            for(int l = 0; l < z_caseaB.length; l++)
                z_caseaB[l] = 0;

        }
    }

    public static Image _aaBImage(byte abyte0[])
    {
        int i = 0;
        byte byte0 = -1;
        byte byte1 = -1;
        boolean flag = true;
        Image image = Toolkit.getDefaultToolkit().createImage(abyte0);
        while(flag)
        {
            int j = image.getWidth(null);
            int k = image.getHeight(null);
            if(k != -1 && j != -1)
                flag = false;
            else
                try
                {
                    i++;
                    Thread.sleep(50L);
                }
                catch(InterruptedException interruptedexception) { }
            if(i > 100)
                return null;
        }
        return image;
    }

    public void _ifImageIV(Image image, int i, int j)
    {
        ColorModel colormodel = ColorModel.getRGBdefault();
        if(image != null)
        {
            Image image1 = _aImageIImage(image, i, j);
            z_ifc._aImageV(image1);
            Image image2 = Toolkit.getDefaultToolkit().createImage(z_ifc);
            int ai[] = _aImageaI(image2);
            if(ai != null)
            {
                z_forI = 1;
                z_aI = image2.getWidth(null);
                z_byteI = image2.getHeight(null);
                z_doI = z_byteI % 8 != 0 ? z_byteI / 8 + 1 : z_byteI / 8;
                z_caseaB = new byte[z_aI * z_doI];
                for(int k = 0; k < z_caseaB.length; k++)
                    z_caseaB[k] = 0;

                for(int i1 = 0; i1 < z_byteI; i1++)
                {
                    for(int j1 = 0; j1 < z_aI; j1++)
                    {
                        int l = ai[i1 * z_aI + j1];
                        if(colormodel.getRed(l) < 128)
                            z_caseaB[j1 * z_doI + i1 / 8] |= z_intaI[i1 % 8];
                    }

                }

            }
        }
    }

    public byte[] _ifvaB()
    {
        return z_caseaB;
    }

    protected int[] _aImageaI(Image image)
    {
        int i = 0;
        byte byte0 = -1;
        byte byte1 = -1;
        boolean flag = true;
        while(flag)
        {
            int j = image.getWidth(null);
            int k = image.getHeight(null);
            if(k != -1 && j != -1)
                flag = false;
            else
                try
                {
                    i++;
                    Thread.sleep(50L);
                }
                catch(InterruptedException interruptedexception) { }
            if(i > 1000)
                return null;
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, z_aI, z_byteI, true);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception1)
        {
            return null;
        }
        if((pixelgrabber.getStatus() & 0x80) != 0)
            return null;
        else
            return (int[])pixelgrabber.getPixels();
    }

    public boolean _avZ()
    {
        return z_aI != -1 && z_byteI != -1 && z_forI != -1 && z_caseaB != null;
    }

    protected Image _aImageIImage(Image image, int i, int j)
    {
        int k = image.getWidth(null);
        int l = image.getHeight(null);
        double d = k <= i ? 1.0D : (double)k / (double)i;
        double d1 = l <= j ? 1.0D : (double)l / (double)j;
        int i1;
        int j1;
        if(d > 1.0D && d >= d1)
        {
            i1 = i;
            j1 = (int)((double)l / d - 1.0D);
        } else
        if(d1 > 1.0D && d1 > d)
        {
            j1 = j;
            i1 = (int)((double)k / d1 - 1.0D);
        } else
        {
            i1 = k;
            j1 = l;
        }
        return image.getScaledInstance(i1, j1, 1);
    }

    public void _aIIV(int i, int j, int k)
    {
        if(_avZ())
        {
            int l = j % 8;
            int i1 = i * z_doI + j / 8;
            if(k > 0 && i1 >= 0 && i1 < z_caseaB.length && l >= 0 && l < 8)
                z_caseaB[i1] |= z_intaI[l];
        }
    }

    public void _aOutputStreamV(OutputStream outputstream)
        throws IOException
    {
        if(_avZ())
        {
            byte abyte0[] = new byte[3];
            abyte0[0] = (byte)z_forI;
            abyte0[1] = (byte)z_aI;
            abyte0[2] = (byte)z_byteI;
            outputstream.write(abyte0);
            outputstream.write(z_caseaB);
        }
    }

}
