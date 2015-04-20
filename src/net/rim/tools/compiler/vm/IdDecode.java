// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.vm;


// Referenced classes of package net.rim.tools.compiler.b:
//            i

public final class IdDecode
{

    public IdDecode()
    {
    }

    public static String decode(String _name)
    {
        StringBuffer stringbuffer = new StringBuffer();
        int j = _name.length();
        for(int k = 0; k < j; k++)
        {
            char c = _name.charAt(k);
            if(c == '\377')
            {
                k++;
                stringbuffer.append(_name.charAt(k));
            } else
            {
                stringbuffer.append(IdDecoding.decodeChars[c]);
            }
        }

        return stringbuffer.toString();
    }
}
