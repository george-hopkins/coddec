// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.tools.compiler.util;

import java.io.IOException;
import java.io.InputStream;

public final class c
{

    private static final int z_intI = 13;
    private static final int z_ifI = 10;
    private static final int z_forI = -1;
    private InputStream z_aInputStream;
    private int z_doI;

    public c(InputStream inputstream)
    {
        z_aInputStream = inputstream;
        z_doI = -1;
    }

    private int _avI()
        throws IOException
    {
        int i = z_doI;
        if(i != -1)
            z_doI = -1;
        else
            i = z_aInputStream.read();
        return i;
    }

    private void _aIV(int i)
        throws IOException
    {
        if(z_doI != -1)
        {
            throw new IOException("double unget");
        } else
        {
            z_doI = i;
            return;
        }
    }

    public String _dovString()
        throws IOException
    {
        int i = _avI();
        if(i == -1)
            return null;
        StringBuffer stringbuffer = new StringBuffer();
        do
        {
            if(i == 13)
            {
                i = _avI();
                if(i != 10)
                    _aIV(i);
                break;
            }
            if(i == 10)
                break;
            stringbuffer.append((char)i);
        } while((i = _avI()) != -1);
        return stringbuffer.toString();
    }

    public void _ifvV()
        throws IOException
    {
        z_aInputStream.close();
    }
}
