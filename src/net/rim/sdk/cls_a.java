// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk;

import java.io.IOException;

public class cls_a extends IOException
{

    public static final int z_intI = 0x80000000;
    public static final int z_tryI = 0x40000000;
    public static final int z_doI = 0x3fffffff;
    public static final int z_bI = 0x80000001;
    public static final int z_caseI = 0x80000002;
    public static final int z_dI = 0x80000003;
    public static final int z_byteI = 0x80000004;
    public static final int z_gotoI = 0x80000005;
    public static final int z_voidI = 0x80000006;
    public static final int z_ifI = 0x80000007;
    public static final int z_newI = 0x80000008;
    public static final int z_forI = 0x80000009;
    public static final int z_nullI = 0x8000000a;
    public static final int z_aI = 0x8000000b;
    public static final int z_longI = 0x8000000c;
    public static final int z_elseI = 0x8000000d;
    public static final String z_charaString[] = {
        "no error", "unexpected error", "", "invalid number format", "duplicate character", "glyph too short", "glyph too tall", "glyph too wide", "glyph too narrow", "glyph different widths",
        "style must be plain, bold, italic, or bold-italic", "undefined symbol", "unterminated string", "unexpected token"
    };
    String z_cString;

    public cls_a(String s, String s1, int i, int j, String s2)
    {
        this(_aStringSIIString(s, s1, i, j, s2));
    }

    public cls_a(String s)
    {
        super(s);
        z_cString = s;
    }

    public String _getLocalizedMessagevString()
    {
        return toString();
    }

    public String getMessage()
    {
        return toString();
    }

    private static String _aStringSIIString(String s, String s1, int i, int j, String s2)
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(s);
        stringbuffer.append(s1);
        stringbuffer.append(":");
        stringbuffer.append(i);
        stringbuffer.append(": ");
        if((j & 0x80000000) != 0)
            stringbuffer.append("error F");
        else
            stringbuffer.append("warning F");
        stringbuffer.append(Integer.toString(j & 0x3fffffff));
        stringbuffer.append(": ");
        stringbuffer.append(z_charaString[j & 0x3fffffff]);
        if(s2 != null)
        {
            stringbuffer.append(' ');
            stringbuffer.append(s2);
        }
        return stringbuffer.toString();
    }

    public String toString()
    {
        return z_cString;
    }

}
