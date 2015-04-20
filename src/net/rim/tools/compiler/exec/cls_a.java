// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.io.*;
import net.rim.tools.compiler.io.Diagnose;

class cls_a extends Thread
{

    InputStream z_aInputStream;

    cls_a(InputStream inputstream)
    {
        z_aInputStream = inputstream;
    }

    public void run()
    {
        BufferedReader bufferedreader = new BufferedReader(new InputStreamReader(z_aInputStream));
        do
        {
            try
            {
                String s = bufferedreader.readLine();
                if(s == null)
                    break;
                net.rim.tools.compiler.io.Diagnose.DiagnoseStream.println(s);
                continue;
            }
            catch(IOException ioexception) { }
            break;
        } while(true);
    }
}
