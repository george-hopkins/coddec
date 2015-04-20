// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Vector;

// Referenced classes of package net.rim.a:
//            a

public abstract class cls_b
{

    public static final int z_forI = 0;
    public static final int z_ifI = 1;
    public static final int z_aI = 2;
    public static final int z_doI = 3;
    public static final int z_tryI = 5;
    public static boolean z_caseZ = false;
    public static int z_byteI = 5;
    private Reader z_gotoReader;
    private String z_newString;
    private String z_charString;
    protected int z_intI;
    private Vector z_elseVector;

    protected cls_b(Reader reader, String s, String s1)
    {
        this(reader, s, s1, null);
    }

    protected cls_b(Reader reader, String s, String s1, Vector vector)
    {
        z_intI = 1;
        z_gotoReader = reader;
        z_newString = s;
        z_charString = s1;
        z_elseVector = vector;
    }

    public void _aStringV(String s)
    {
        if(z_elseVector == null)
        {
            return;
        } else
        {
            z_elseVector.add(s);
            return;
        }
    }

    protected void _aIV(int i)
        throws cls_a
    {
        throw new cls_a(z_newString, z_charString, z_intI, i, null);
    }

    protected void _ifStringV(String s)
        throws cls_a
    {
        throw new cls_a(z_newString, z_charString, z_intI, 0x80000002, s);
    }

    public String _ifvString()
    {
        return z_charString;
    }

    public String _dovString()
    {
        return z_newString;
    }

    protected Reader _avReader()
    {
        return z_gotoReader;
    }

    protected void _aIStringV(int i, String s)
    {
        if(z_caseZ && i <= z_byteI)
            System.out.println(s);
    }

    protected void _doStringV(String s)
    {
        if(z_caseZ)
            System.out.println(s);
    }

    protected void _forStringV(String s)
    {
        if(z_caseZ && z_byteI >= 5)
        {
            System.out.print("tok=");
            System.out.println(s);
        }
    }

}
