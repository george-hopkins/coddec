// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.*;

public interface Host
{

    public static final int z_intI = -1;
    public static final int z_doI = 0;
    public static final int z_aI = 1;
    public static final int z_ifI = 2;
    public static final int z_forI = 3;

    public abstract PrintStream openDiagnose()
        throws IOException;

    public abstract InputStream openInput(String s)
        throws IOException;

    public abstract OutputStream openOutput(String s)
        throws IOException;

    public abstract void advanceProgress(int i);

    public abstract Object getClassInfo(String s);

    public abstract String getModuleName(Object obj);

    public abstract String getModuleVersion(Object obj);

    public abstract int getClassAttributes(Object obj);
}
