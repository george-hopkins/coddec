// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.pkg_b;

import java.awt.Image;
import java.awt.image.*;

public class c
    implements ImageProducer
{
	
	/**
	 * Registers an <code>ImageConsumer</code> with the
	 * <code>ImageProducer</code> for access to the image data
	 * during a later reconstruction of the <code>Image</code>.
	 * The <code>ImageProducer</code> may, at its discretion,
	 * start delivering the image data to the consumer
	 * using the <code>ImageConsumer</code> interface immediately,
	 * or when the next available image reconstruction is triggered
	 * by a call to the <code>startProduction</code> method.
	 * @param ic the specified <code>ImageConsumer</code>
	 * @see #startProduction
	 */
	public void addConsumer(ImageConsumer ic)
	{
		// TODO: Implement this method
	}
	
	/**
	 * Determines if a specified <code>ImageConsumer</code>
	 * object is currently registered with this
	 * <code>ImageProducer</code> as one of its consumers.
	 * @param ic the specified <code>ImageConsumer</code>
	 * @return <code>true</code> if the specified
	 *         <code>ImageConsumer</code> is registered with
	 *         this <code>ImageProducer</code>;
	 *         <code>false</code> otherwise.
	 */
	public boolean isConsumer(ImageConsumer ic)
	{
		// TODO: Implement this method
		return false;
	}
	
	/**
	 * Removes the specified <code>ImageConsumer</code> object
	 * from the list of consumers currently registered to
	 * receive image data.  It is not considered an error
	 * to remove a consumer that is not currently registered.
	 * The <code>ImageProducer</code> should stop sending data
	 * to this consumer as soon as is feasible.
	 * @param ic the specified <code>ImageConsumer</code>
	 */
	public void removeConsumer(ImageConsumer ic)
	{
		// TODO: Implement this method
	}
	
	/**
	 * Registers the specified <code>ImageConsumer</code> object
	 * as a consumer and starts an immediate reconstruction of
	 * the image data which will then be delivered to this
	 * consumer and any other consumer which might have already
	 * been registered with the producer.  This method differs
	 * from the addConsumer method in that a reproduction of
	 * the image data should be triggered as soon as possible.
	 * @param ic the specified <code>ImageConsumer</code>
	 * @see #addConsumer
	 */
	public void startProduction(ImageConsumer ic)
	{
		// TODO: Implement this method
	}
	
	/**
	 * Requests, on behalf of the <code>ImageConsumer</code>,
	 * that the <code>ImageProducer</code> attempt to resend
	 * the image data one more time in TOPDOWNLEFTRIGHT order
	 * so that higher quality conversion algorithms which
	 * depend on receiving pixels in order can be used to
	 * produce a better output version of the image.  The
	 * <code>ImageProducer</code> is free to
	 * ignore this call if it cannot resend the data in that
	 * order.  If the data can be resent, the
	 * <code>ImageProducer</code> should respond by executing
	 * the following minimum set of <code>ImageConsumer</code>
	 * method calls:
	 * <pre>
	 *	ic.setHints(TOPDOWNLEFTRIGHT | < otherhints >);
	 *	ic.setPixels(...);	// As many times as needed
	 *	ic.imageComplete();
	 * </pre>
	 * @param ic the specified <code>ImageConsumer</code>
	 * @see ImageConsumer#setHints
	 */
	public void requestTopDownLeftRightResend(ImageConsumer ic)
	{
		// TODO: Implement this method
	}
	

    protected int z_foraI[];
    protected int z_doI;
    protected int z_aI;
    protected ColorModel z_ifColorModel;

    public c()
    {
        z_ifColorModel = ColorModel.getRGBdefault();
    }

    public void _addConsumerImageConsumerV(ImageConsumer imageconsumer)
    {
        _startProductionImageConsumerV(imageconsumer);
    }

    protected int _aIColorModelI(int i, ColorModel colormodel)
    {
        int j = colormodel.getRed(i);
        int k = colormodel.getGreen(i);
        int l = colormodel.getBlue(i);
        return (int)((double)j * 0.29999999999999999D + (double)k * 0.58999999999999997D + (double)l * 0.11D + 0.001D);
    }

    public void _aImageV(Image image)
    {
        _ifImageV(image);
        _avV();
    }

    protected void _avV()
    {
        if(z_foraI != null)
        {
            for(int i1 = 0; i1 < z_aI; i1++)
            {
                for(int j1 = 0; j1 < z_doI; j1++)
                {
                    int i = z_foraI[i1 * z_doI + j1];
                    int l = z_ifColorModel.getAlpha(i);
                    int k = _aIColorModelI(i, z_ifColorModel);
                    int j = 0;
                    j |= k;
                    j |= k << 8;
                    j |= k << 16;
                    j |= l << 24;
                    z_foraI[i1 * z_doI + j1] = j;
                }

            }

        }
    }

    protected void _ifImageV(Image image)
    {
        boolean flag = true;
        z_doI = -1;
        z_aI = -1;
        while(flag)
        {
            z_doI = image.getWidth(null);
            z_aI = image.getHeight(null);
            if(z_aI != -1 && z_doI != -1)
                flag = false;
            else
                try
                {
                    Thread.sleep(50L);
                }
                catch(InterruptedException interruptedexception) { }
        }
        PixelGrabber pixelgrabber = new PixelGrabber(image, 0, 0, z_doI, z_aI, true);
        try
        {
            pixelgrabber.grabPixels();
        }
        catch(InterruptedException interruptedexception1)
        {
            return;
        }
        if((pixelgrabber.getStatus() & 0x80) != 0)
        {
            return;
        } else
        {
            z_foraI = (int[])pixelgrabber.getPixels();
            return;
        }
    }

    public boolean _isConsumerImageConsumerZ(ImageConsumer imageconsumer)
    {
        return false;
    }

    public void _removeConsumerImageConsumerV(ImageConsumer imageconsumer)
    {
    }

    public void _requestTopDownLeftRightResendImageConsumerV(ImageConsumer imageconsumer)
    {
        _startProductionImageConsumerV(imageconsumer);
    }

    public void _startProductionImageConsumerV(ImageConsumer imageconsumer)
    {
        if(z_foraI != null)
        {
            imageconsumer.setHints(2 | 0x10);
            imageconsumer.setDimensions(z_doI, z_aI);
            imageconsumer.setPixels(0, 0, z_doI, z_aI, ColorModel.getRGBdefault(), z_foraI, 0, z_doI);
            imageconsumer.imageComplete(3);
        } else
        {
            imageconsumer.imageComplete(1);
        }
    }
}
