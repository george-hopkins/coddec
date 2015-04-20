// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk;

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class cls_c
{

    public cls_c()
    {
    }

    public static void _aaStringV(String as[])
    {
        if(as.length != 1)
        {
            _avV();
            return;
        } else
        {
            System.out.println("0x" + Long.toHexString(_aStringJ(as[0])) + "L; // " + as[0]);
            return;
        }
    }

    public static long _aStringJ(String s)
    {
        byte abyte0[] = null;
        long l = 0L;
        StringBuffer stringbuffer = new StringBuffer();
        MessageDigest messagedigest = null;
        try
        {
            messagedigest = MessageDigest.getInstance("SHA");
        }
        catch(NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return 0L;
        }
        messagedigest.update(s.getBytes());
        abyte0 = messagedigest.digest();
        for(int i = 0; i < 8; i++)
            l |= ((long)abyte0[i] & 255L) << 8 * i;

        return l;
    }

    private static void _avV()
    {
        System.err.println("Usage: StringToLong <string>");
        System.err.println("   prints the 64 bit hash of the <string> for use");
        System.exit(2);
    }
}
