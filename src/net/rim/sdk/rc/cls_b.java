// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.*;
import java.util.Locale;

// Referenced classes of package net.rim.a.a:
//            e

public class cls_b
{

    public static final char z_newC = 163;
    public static final String z_caseString = "\\.staging";
    public static final String z_ifString = ".bin";
    public static final String z_byteString = ".crb";
    public static final String z_charString = ".java";
    public static final String z_tryString = ".rrc";
    public static final String z_doString = ".rrh";
    public static final String z_intString = ".rdb";
    public static String z_aString = ".dir";
    public static String z_gotoString;
    public static String z_longString;
    private static String z_elseString;
    private static final char z_foraC[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    public cls_b()
    {
    }

    private static boolean _aCZ(char c)
    {
        return ' ' <= c && c <= '~' || '\240' <= c && c <= '\377';
    }

    public static String _doStringString(String s)
    {
        if(s == null)
        {
            return "";
        } else
        {
            String s1 = s.replaceAll("\\.", "\\\\");
            return s1.replaceAll(";", "").trim();
        }
    }

    static String _avString()
    {
        if(z_elseString == null)
            try
            {
                File file = File.createTempFile(z_longString, z_aString);
                file.delete();
                file.mkdir();
                z_elseString = file.getAbsolutePath();
            }
            catch(Exception exception)
            {
                z_elseString = ".";
            }
        return z_elseString;
    }

    public static String _aeString(cls_e e1)
        throws IOException
    {
        String s = e1._nullvString().trim();
        String s1 = _avString();
        StringBuffer stringbuffer = new StringBuffer(s1);
        stringbuffer.append(File.separator);
        stringbuffer.append("\\.staging");
        stringbuffer.append(File.separator);
        stringbuffer.append(_doStringString(s));
        stringbuffer.append(File.separator);
        return stringbuffer.toString();
    }

    public static void _aaStringV(String as[])
    {
        String s = "UTF-8";
        File file = null;
        boolean flag = false;
        if(as.length > 0)
        {
            for(int i = 0; i < as.length; i++)
            {
                String s1 = as[i];
                if(s1.equalsIgnoreCase("-alx"))
                {
                    flag = true;
                } else
                {
                    File file1 = new File(s1);
                    if(file1.exists())
                    {
                        file = file1;
                    } else
                    {
                        System.out.println("No file found:" + file1.getPath());
                        System.exit(1);
                    }
                }
            }

        }
        try
        {
            BufferedReader bufferedreader = null;
            if(file != null)
                bufferedreader = new BufferedReader(new InputStreamReader(new FileInputStream(file), s));
            else
                bufferedreader = new BufferedReader(new InputStreamReader(System.in, s));
            do
            {
                String s2 = bufferedreader.readLine();
                if(s2 == null)
                    break;
                if(flag)
                    System.out.println(_ifStringString(s2));
                else
                    System.out.println(_forStringString(s2));
            } while(true);
        }
        catch(Throwable throwable)
        {
            throwable.printStackTrace();
        }
    }

    public static String _newStringString(String s)
    {
        if(s == null)
            return "";
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i);
        for(int j = 0; j < i;)
        {
            char c = s.charAt(j++);
            if(c == '\\')
            {
                if(i <= j)
                {
                    stringbuffer.append('\\');
                    break;
                }
                c = s.charAt(j++);
                if(c == 'u')
                {
                    if(i < j + 4)
                    {
                        stringbuffer.append(c);
                        break;
                    }
                    int k = 0;
                    for(int l = 0; l < 4; l++)
                    {
                        c = s.charAt(j++);
                        switch(c)
                        {
                        case 48: // '0'
                        case 49: // '1'
                        case 50: // '2'
                        case 51: // '3'
                        case 52: // '4'
                        case 53: // '5'
                        case 54: // '6'
                        case 55: // '7'
                        case 56: // '8'
                        case 57: // '9'
                            k = ((k << 4) + c) - 48;
                            break;

                        case 97: // 'a'
                        case 98: // 'b'
                        case 99: // 'c'
                        case 100: // 'd'
                        case 101: // 'e'
                        case 102: // 'f'
                            k = ((k << 4) + 10 + c) - 97;
                            break;

                        case 65: // 'A'
                        case 66: // 'B'
                        case 67: // 'C'
                        case 68: // 'D'
                        case 69: // 'E'
                        case 70: // 'F'
                            k = ((k << 4) + 10 + c) - 65;
                            break;
                        }
                    }

                    stringbuffer.append((char)k);
                } else
                if(c == '"')
                {
                    stringbuffer.append('"');
                } else
                {
                    if(c == 'n')
                        c = '\n';
                    else
                    if(c == 'r')
                        c = '\r';
                    else
                    if(c == 't')
                        c = '\t';
                    else
                    if(c == 'f')
                        c = '\f';
                    stringbuffer.append(c);
                }
            } else
            {
                stringbuffer.append(c);
            }
        }

        return stringbuffer.toString();
    }

    public static String _forStringString(String s)
    {
        if(s == null)
            return "";
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i * 2);
        for(int j = 0; j < i; j++)
        {
            char c = s.charAt(j);
            switch(c)
            {
            case 34: // '"'
                stringbuffer.append('\\');
                stringbuffer.append('"');
                break;

            case 32: // ' '
                stringbuffer.append(' ');
                break;

            case 92: // '\\'
                stringbuffer.append('\\');
                stringbuffer.append('\\');
                break;

            case 9: // '\t'
                stringbuffer.append('\\');
                stringbuffer.append('t');
                break;

            case 10: // '\n'
                stringbuffer.append('\\');
                stringbuffer.append('n');
                break;

            case 13: // '\r'
                stringbuffer.append('\\');
                stringbuffer.append('r');
                break;

            case 12: // '\f'
                stringbuffer.append('\\');
                stringbuffer.append('f');
                break;

            default:
                if(!_aCZ(c))
                {
                    stringbuffer.append('\\');
                    stringbuffer.append('u');
                    stringbuffer.append(_aIC(c >> 12 & 0xf));
                    stringbuffer.append(_aIC(c >> 8 & 0xf));
                    stringbuffer.append(_aIC(c >> 4 & 0xf));
                    stringbuffer.append(_aIC(c & 0xf));
                } else
                {
                    stringbuffer.append(c);
                }
                break;
            }
        }

        return stringbuffer.toString();
    }

    public static String _ifStringString(String s)
    {
        if(s == null)
            return "";
        int i = s.length();
        StringBuffer stringbuffer = new StringBuffer(i * 2);
        for(int j = 0; j < i; j++)
        {
            char c = s.charAt(j);
            switch(c)
            {
            case 65279:
                break;

            case 34: // '"'
                stringbuffer.append('"');
                break;

            case 32: // ' '
                stringbuffer.append(' ');
                break;

            case 92: // '\\'
                stringbuffer.append('\\');
                stringbuffer.append('\\');
                break;

            case 9: // '\t'
                stringbuffer.append('\t');
                break;

            case 10: // '\n'
                stringbuffer.append('\\');
                stringbuffer.append('n');
                break;

            case 13: // '\r'
                stringbuffer.append('\\');
                stringbuffer.append('r');
                break;

            case 12: // '\f'
                stringbuffer.append('\\');
                stringbuffer.append('f');
                break;

            default:
                if(!_aCZ(c))
                {
                    stringbuffer.append('&');
                    stringbuffer.append('#');
                    stringbuffer.append('x');
                    stringbuffer.append(_aIC(c >> 12 & 0xf));
                    stringbuffer.append(_aIC(c >> 8 & 0xf));
                    stringbuffer.append(_aIC(c >> 4 & 0xf));
                    stringbuffer.append(_aIC(c & 0xf));
                    stringbuffer.append(';');
                } else
                {
                    stringbuffer.append(c);
                }
                break;
            }
        }

        return stringbuffer.toString();
    }

    private static char _aIC(int i)
    {
        return z_foraC[i & 0xf];
    }

    public static String _intStringString(String s)
    {
        if(s == null)
            throw new IllegalArgumentException("Cannot remove quotes from null String!");
        int i = s.length();
        if(i < 2)
            throw new IllegalArgumentException("Cannot remove quotes!");
        if(i == 2)
        {
            return "";
        } else
        {
            s = s.substring(1, i - 1);
            return s;
        }
    }

    public static String _ifStringBufferString(StringBuffer stringbuffer)
    {
        if(stringbuffer == null || stringbuffer.length() <= 2)
            return "";
        else
            return _aStringBufferString(stringbuffer).trim();
    }

    public static String _aStringBufferString(StringBuffer stringbuffer)
    {
        if(stringbuffer == null || stringbuffer.length() <= 2)
            return "";
        int i = stringbuffer.length();
        for(int j = 0; j + 1 < i; j++)
            switch(stringbuffer.charAt(j))
            {
            default:
                break;

            case 42: // '*'
                if(stringbuffer.charAt(j + 1) == '/')
                {
                    stringbuffer.replace(j, j + 2, "");
                    j--;
                    i = stringbuffer.length();
                }
                break;

            case 47: // '/'
                switch(stringbuffer.charAt(j + 1))
                {
                case 42: // '*'
                    stringbuffer.replace(j, j + 2, "");
                    j--;
                    i = stringbuffer.length();
                    break;

                case 47: // '/'
                    stringbuffer.replace(j, j + 2, "");
                    j--;
                    i = stringbuffer.length();
                    break;
                }
                break;
            }

        return stringbuffer.toString().replace('*', ' ');
    }

    public static Locale _aStringLocale(String s)
    {
        if(s == null || s.length() == 0)
            return new Locale("", "");
        String s1 = s.substring(0, 2);
        String s2 = "";
        String s3 = "";
        if(s.length() > 2)
        {
            if(s.charAt(2) != '_')
                throw new IllegalArgumentException("text.charAt(2) != '_':" + s);
            int i = 3;
            if(s.charAt(3) != '_')
            {
                s2 = s.substring(3, 5);
                i += 2;
            }
            if(s.length() > i + 1)
            {
                if(s.charAt(i) != '_')
                {
                    (new Throwable()).printStackTrace();
                    throw new IllegalArgumentException("text.charAt(" + i + ") != '_':" + s);
                }
                s3 = s.substring(i + 1);
                if(s3.length() == 0)
                    throw new IllegalArgumentException("variant.length() == 0," + (i + 1) + ":" + s);
            }
            if(s2.length() == 0 && s3.length() == 0)
                throw new IllegalArgumentException("(country.length() == 0) && (variant.length() == 0):" + s);
        }
        if(Character.isLowerCase(s1.charAt(0)))
            if(Character.isLowerCase(s1.charAt(1)));
        if(s2.length() != 0 && Character.isUpperCase(s2.charAt(0)))
            if(Character.isUpperCase(s2.charAt(1)));
        return new Locale(s1, s2, s3);
    }

    public static int _aStringI(String s, String s1)
    {
        int i = 0;
        if(s != null && s.length() != 0)
            i |= s.charAt(0) << 24 | s.charAt(1) << 16;
        if(s1 != null && s1.length() != 0)
            i |= s1.charAt(0) << 8 | s1.charAt(1) << 0;
        return i;
    }

    static
    {
        z_gotoString = "rapc_";
        z_longString = z_gotoString + "rc_";
    }
}
