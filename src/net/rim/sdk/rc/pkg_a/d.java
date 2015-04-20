// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi 

package net.rim.sdk.rc.pkg_a;


// Referenced classes of package net.rim.a.a.a:
//            b

public class d extends Exception
{

    protected boolean z_intZ;
    public cls_b z_ab;
    public int z_ifaaI[][];
    public String z_foraString[];
    protected String z_doString;

    public d(cls_b b1, int ai[][], String as[])
    {
        super("");
        z_doString = System.getProperty("line.separator", "\n");
        z_intZ = true;
        z_ab = b1;
        z_ifaaI = ai;
        z_foraString = as;
    }

    public d()
    {
        z_doString = System.getProperty("line.separator", "\n");
        z_intZ = false;
    }

    public d(String s)
    {
        super(s);
        z_doString = System.getProperty("line.separator", "\n");
        z_intZ = false;
    }

    public String getMessage()
    {
        if(!z_intZ)
            return super.getMessage();
        String s = "";
        int i = 0;
        for(int j = 0; j < z_ifaaI.length; j++)
        {
            if(i < z_ifaaI[j].length)
                i = z_ifaaI[j].length;
            for(int k = 0; k < z_ifaaI[j].length; k++)
                s = s + z_foraString[z_ifaaI[j][k]] + " ";

            if(z_ifaaI[j][z_ifaaI[j].length - 1] != 0)
                s = s + "...";
            s = s + z_doString + "    ";
        }

        String s1 = "Encountered \"";
        cls_b b1 = z_ab.z_ifb;
        for(int l = 0; l < i; l++)
        {
            if(l != 0)
                s1 = s1 + " ";
            if(b1.z_doI == 0)
            {
                s1 = s1 + z_foraString[0];
                break;
            }
            s1 = s1 + _aStringString(b1.z_newString);
            b1 = b1.z_ifb;
        }

        s1 = s1 + "\" at line " + z_ab.z_ifb.z_aI + ", column " + z_ab.z_ifb.z_intI + "." + z_doString;
        if(z_ifaaI.length == 1)
            s1 = s1 + "Was expecting:" + z_doString + "    ";
        else
            s1 = s1 + "Was expecting one of:" + z_doString + "    ";
        s1 = s1 + s;
        return s1;
    }

    protected String _aStringString(String s)
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
}
