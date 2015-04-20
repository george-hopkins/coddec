// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;

public class cls_d
{

    private DataOutputStream z_forDataOutputStream;
    private PrintStream z_intPrintStream;
    private int z_ifI;
    private int z_doI;
    private static String z_aString = "                                        ";
    private static char z_newaC[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    public cls_d(DataOutputStream dataoutputstream, PrintStream printstream)
    {
        z_forDataOutputStream = dataoutputstream;
        z_intPrintStream = printstream;
        z_ifI = 0;
        z_doI = 0;
    }

    static String _aStringIString(String s, long l, int i)
    {
        int j = i * 2;
        char ac[] = new char[j];
        while(--j >= 0)
        {
            ac[j] = z_newaC[(int)(l & 15L)];
            l >>= 4;
        }
        s = s + String.valueOf(ac);
        return s;
    }

    public void _ifvV()
    {
        z_doI++;
    }

    public void _dovV()
    {
        z_doI--;
    }

    private String _aIString(int i)
    {
        return z_aString.substring(0, z_doI * 2 + i);
    }

    public void _aIStringV(int param_typeTagI, String s)
        throws IOException
    {
        z_forDataOutputStream.writeInt(param_typeTagI);
        if(z_intPrintStream != null)
            z_intPrintStream.print(_aStringIString("\r\n ", z_ifI, 2) + _aStringIString(" ", param_typeTagI, 4) + _aIString(16) + s + ": " + param_typeTagI + " ");
        z_ifI += 4;
    }

    public void _aJStringV(long l, String s)
        throws IOException
    {
        z_forDataOutputStream.writeLong(l);
        if(z_intPrintStream != null)
            z_intPrintStream.print(_aStringIString("\r\n ", z_ifI, 2) + _aStringIString(" ", l, 8) + _aIString(16) + s + ": " + l + " ");
        z_ifI += 8;
    }

    public void _aCV(char c)
        throws IOException
    {
        z_forDataOutputStream.writeChar(c);
        if(z_intPrintStream != null)
            z_intPrintStream.print(c);
        z_ifI += 2;
    }

    public void _ifStringV(String s)
        throws IOException
    {
        if(z_intPrintStream != null)
            z_intPrintStream.print(_aStringIString("\r\n ", z_ifI, 2) + _aIString(25) + s);
    }

    public void _aStringV(String s)
        throws IOException
    {
        if(z_intPrintStream != null)
            z_intPrintStream.print("\r\n" + s);
    }

    public void _avV()
        throws IOException
    {
        z_forDataOutputStream.close();
    }

}
