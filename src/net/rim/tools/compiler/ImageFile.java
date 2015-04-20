// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.*;
import net.rim.tools.compiler.exec.l;


public class ImageFile extends net.rim.tools.compiler.ResourceFile
{

    private boolean z_caseZ;
    private boolean _iconFlag;
    private int _ordinal;

    public ImageFile()
    {
        _ordinal = -1;
    }

    public ImageFile(File file)
        throws IOException
    {
        super(file);
        _ordinal = -1;
    }

    public ImageFile(String s, InputStream inputstream, int i)
        throws IOException
    {
        super(s, inputstream, i);
        _ordinal = -1;
    }

    public void markIcon()
    {
        _iconFlag = true;
    }

    public boolean isIcon()
    {
        return _iconFlag;
    }

    public void setOrdinal(int i)
    {
        _ordinal = i;
    }

    public int getOrdinal()
    {
        return _ordinal;
    }

    public void convertImage()
    {
        if(!z_caseZ)
        {
            byte abyte0[] = net.rim.tools.compiler.exec.l._aaBaB(super._data);
            if(abyte0 != null)
                resetData(abyte0);
            z_caseZ = true;
        }
    }
}
