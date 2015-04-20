// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc.pkg_a;


public class cls_a extends Error
{

    static final int z_doI = 0;
    static final int z_ifI = 1;
    static final int z_aI = 2;
    static final int z_intI = 3;
    int z_forI;

    protected static final String _aStringString(String s)
    {
        StringBuffer stringbuffer = new StringBuffer();
        for(int i = 0; i < s.length(); i++)
        {
            char c;
            switch(s.charAt(i))
            {
            case 0: // '\0'
                break;

            case 8: // '\b'
                stringbuffer.append("\\b");
                break;

            case 9: // '\t'
                stringbuffer.append("\\t");
                break;

            case 10: // '\n'
                stringbuffer.append("\\n");
                break;

            case 12: // '\f'
                stringbuffer.append("\\f");
                break;

            case 13: // '\r'
                stringbuffer.append("\\r");
                break;

            case 34: // '"'
                stringbuffer.append("\\\"");
                break;

            case 39: // '\''
                stringbuffer.append("\\'");
                break;

            case 92: // '\\'
                stringbuffer.append("\\\\");
                break;

            default:
                if((c = s.charAt(i)) < ' ' || c > '~')
                {
                    String s1 = "0000" + Integer.toString(c, 16);
                    stringbuffer.append("\\u" + s1.substring(s1.length() - 4, s1.length()));
                } else
                {
                    stringbuffer.append(c);
                }
                break;
            }
        }

        return stringbuffer.toString();
    }

    private static final String _aZIIIString(boolean flag, int i, int j, int k, String s, char c)
    {
        return "Lexical error at line " + j + ", column " + k + ".  Encountered: " + (flag ? "<EOF> " : "\"" + _aStringString(String.valueOf(c)) + "\"" + " (" + (int)c + "), ") + "after : \"" + _aStringString(s) + "\"";
    }

    public String getMessage()
    {
        return super.getMessage();
    }

    public cls_a()
    {
    }

    public cls_a(String s, int i)
    {
        super(s);
        z_forI = i;
    }

    public cls_a(boolean flag, int i, int j, int k, String s, char c, int l)
    {
        this(_aZIIIString(flag, i, j, k, s, c), l);
    }
}
