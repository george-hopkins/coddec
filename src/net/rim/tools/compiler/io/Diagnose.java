// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.io;

import java.io.PrintStream;

public final class Diagnose
{

    public static PrintStream DiagnoseStream;

    public Diagnose()
    {
    }

    static
    {
        DiagnoseStream = System.out;
    }
}
