// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            d, g, f

public class cls_c
{

    public cls_c()
    {
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
    }

    void _adV(cls_d d1)
        throws IOException
    {
    }

    static void _adVV(cls_d d1, Vector vector, String s)
        throws IOException
    {
        int i = vector.size();
        d1._aIStringV(i, "Vector " + s);
        d1._ifvV();
        for(int j = 0; j < i; j++)
        {
            d1._ifStringV(s + " element[ " + j + " ]");
            d1._ifvV();
            ((cls_c)vector.elementAt(j))._adV(d1);
            d1._dovV();
        }

        d1._dovV();
    }

    static String read_string(DataInputStream datainputstream)
        throws IOException
    {
        int i = datainputstream.readInt();
        char ac[] = new char[i];
        for(int j = 0; j < i; j++)
            ac[j] = datainputstream.readChar();

        return cls_g.cannonicalName(new String(ac));
    }

    static void _adSV(cls_d d1, String s, String s1)
        throws IOException
    {
        int i = s.length();
        d1._aIStringV(i, s1);
        for(int j = 0; j < i; j++)
            d1._aCV(s.charAt(j));

    }

    static String _doIString(int i)
    {
        if(i == 0)
            return "";
        StringBuffer stringbuffer = new StringBuffer(" attribute=( ");
        if((i & 0x20) != 0)
            stringbuffer.append("FINAL ");
        if((i & 2) != 0)
            stringbuffer.append("STATIC ");
        if((i & 0x40) != 0)
            stringbuffer.append("PUBLIC ");
        if((i & 0x80) != 0)
            stringbuffer.append("PROTECTED ");
        if((i & 0x100) != 0)
            stringbuffer.append("PRIVATE ");
        if((i & 0x400) != 0)
            stringbuffer.append("INTERFACE ");
        if((i & 0x800) != 0)
            stringbuffer.append("SYNCHRONIZED ");
        if((i & 1) != 0)
            stringbuffer.append("NATIVE ");
        if((i & 0x200) != 0)
            stringbuffer.append("LOCAL ");
        if((i & 8) != 0)
        {
            if((i & 4) != 0)
                stringbuffer.append("VIRTUAL ");
            stringbuffer.append("METHOD ");
        } else
        if((i & 4) != 0)
            stringbuffer.append("FIELD ");
        if((i & 0x10) != 0)
            stringbuffer.append("CONSTRUCTOR ");
        if((i & 0x2000) != 0)
            stringbuffer.append("PLACEHOLDER ");
        if((i & 0x4000) != 0)
            stringbuffer.append("CLASSINIT ");
        stringbuffer.append(")");
        return stringbuffer.toString();
    }

    static String _aIString(int i)
    {
        StringBuffer stringbuffer = new StringBuffer(" id=");
        switch(i)
        {
        case 10: // '\n'
            stringbuffer.append("T_VOID");
            break;

        case 1: // '\001'
            stringbuffer.append("T_BOOLEAN");
            break;

        case 2: // '\002'
            stringbuffer.append("T_BYTE");
            break;

        case 3: // '\003'
            stringbuffer.append("T_CHAR");
            break;

        case 4: // '\004'
            stringbuffer.append("T_SHORT");
            break;

        case 5: // '\005'
            stringbuffer.append("T_INTEGER");
            break;

        case 6: // '\006'
            stringbuffer.append("T_LONG");
            break;

        case 8: // '\b'
            stringbuffer.append("T_ARRAY");
            break;

        case 11: // '\013'
            stringbuffer.append("T_FLOAT");
            break;

        case 12: // '\f'
            stringbuffer.append("T_DOUBLE");
            break;

        case 7: // '\007'
            stringbuffer.append("T_CLASS");
            break;

        case 9: // '\t'
        default:
            stringbuffer.append("<unkown>");
            break;
        }
        return stringbuffer.toString();
    }

    static String _ifIString(int i)
    {
        StringBuffer stringbuffer = new StringBuffer(" keyId=");
        stringbuffer.append(cls_d._aStringIString("0x", i, 4));
        char c1 = (char)(i & 0xff);
        char c2 = (char)(i >> 8 & 0xff);
        char c3 = (char)(i >> 16 & 0xff);
        char c4 = (char)(i >> 24 & 0xff);
        stringbuffer.append(" '");
        if(c4 != 0)
            stringbuffer.append(c4);
        if(c3 != 0)
            stringbuffer.append(c3);
        if(c2 != 0)
            stringbuffer.append(c2);
        if(c1 != 0)
            stringbuffer.append(c1);
        stringbuffer.append('\'');
        return stringbuffer.toString();
    }
}
