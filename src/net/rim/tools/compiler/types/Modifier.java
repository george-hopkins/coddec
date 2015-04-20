// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.exec.h;

public final class Modifier
implements net.rim.tools.compiler.vm.Constants, net.rim.tools.compiler.exec.h
{

    public static final int z_sVI = 0;
    public static final int z_sWI = 1;
    public static final int z_sGI = 2;
    public static final int z_sHI = 4;
    public static final int z_sRI = 8;
    public static final int z_s1I = 16;
    public static final int z_sPI = 32;
    public static final int z_sZI = 64;
    public static final int z_s2I = 128;
    public static final int z_sXI = 256;
    public static final int z_szI = 512;
    public static final int z_s8I = 1024;
    public static final int z_sBI = 2048;
    public static final int z_sTI = 4096;
    public static final int z_s7I = 8192;
    public static final int z_sJI = 16384;
    public static final int z_tbI = 32768;
    public static final int z_sQI = 0x10000;
    public static final int z_sNI = 0x20000;
    public static final int z_sYI = 0x40000;
    public static final int z_syI = 0x80000;
    public static final int z_suI = 0x100000;
    public static final int z_tfI = 0x200000;
    public static final int z_sEI = 0x400000;
    public static final int z_sKI = 0x800000;
    public static final int z_teI = 0x1000000;
    public static final int z_sDI = 0x2000000;
    public static final int z_sUI = 0x4000000;
    public static final int z_tcI = 0x8000000;
    public static final int z_s9I = 0x10000000;
    public static final int z_s4I = 0x20000000;
    public static final int z_svI = 0x40000000;
    public static final int z_sFI = 0x80000000;
    public static final int z_swI = 896;
    public static final int z_tdI = 0xf1000000;
    public static final int z_sMI = 0x11000000;
    public static final int z_sII = 1;
    public static final int z_sOI = 2;
    public static final int z_sLI = 4;
    public static final int z_s0I = 8;
    public static final int z_taI = 16;
    public static final int z_s3I = 32;
    public static final int z_sSI = 64;
    public static final int z_sAI = 128;
    public static final int z_sCI = 256;
    public static final int z_s6I = 512;
    public static final int z_sxI = 1024;
    public static final int z_s5I = 2048;

    public Modifier()
    {
    }

    public static int translateClassfileAccessFlags(int __flag)
    {
        int j = 0;
        if((__flag & 1) != 0)
            j |= 0x80;
        if((__flag & 2) != 0)
            j |= 0x200;
        if((__flag & 4) != 0)
            j |= 0x100;
        if((__flag & 8) != 0)
            j |= 2;
        if((__flag & 0x10) != 0)
            j |= 0x40;
        if((__flag & 0x20) != 0)
            j |= 0x8000;
        if((__flag & 0x40) != 0)
            j |= 0x2000;
        if((__flag & 0x80) != 0)
            j |= 0x1000;
        if((__flag & 0x100) != 0)
            j |= 1;
        if((__flag & 0x200) != 0)
            j |= 0x800;
        if((__flag & 0x400) != 0)
            j |= 0x20;
        if((__flag & 0x800) != 0)
            j |= 0x4000;
        return j;
    }

    public static int translateCodfileAttributes(int __flag)
    {
        int j = 0;
        if((__flag & 1) != 0)
            j |= 0x80;
        if((__flag & 2) != 0)
            j |= 0x200;
        if((__flag & 4) != 0)
            j |= 0x100;
        if((__flag & 8) != 0)
            j |= 0x40;
        return j;
    }

    public static int translateCodfileClassAttributes(int __flag)
    {
        int j = translateCodfileAttributes(__flag);
        if((__flag & 0x20) != 0)
            j |= 0x800;
        if((__flag & 0x10) != 0)
            j |= 0x20;
        if((__flag & 0x40) != 0)
            j |= 0x8000000;
        return j;
    }

    public static int toCodfileProtectionAttribute(int __flag)
    {
        int j = translateCodfileAttributes(__flag);
        if((__flag & 0x10) != 0)
            j |= 2;
        if((__flag & 0x20) != 0)
            j |= 0x20;
        if((__flag & 0x100) != 0)
            j |= 0x100000;
        if((__flag & 0x80) != 0)
            j |= 0x10;
        return j;
    }

    public static int toCodfileClassAttribute(int __flag)
    {
        int j = 0;
        if((__flag & 1) != 0)
            j |= 1;
        if((__flag & 2) != 0)
            j |= 2;
        if((__flag & 2) == 0)
            j |= 4;
        if((__flag & 4) != 0)
            j |= 4;
        if((__flag & 8) != 0)
            j |= 8;
        if((__flag & 0x10) != 0)
            j |= 0x10;
        if((__flag & 0x40) != 0)
            j |= 0x20;
        if((__flag & 0x80) != 0)
            j |= 0x40;
        if((__flag & 0x100) != 0)
            j |= 0x80;
        if((__flag & 0x200) != 0)
            j |= 0x100;
        if((__flag & 0x400) != 0)
            j |= 0x200;
        if((__flag & 0x800) != 0)
            j |= 0x400;
        if((__flag & 0x8000) != 0)
            j |= 0x800;
        if((__flag & 0x100000) != 0)
            j |= 0x4000;
        return j;
    }

    public static int toCodfileRoutineAttribute(int __flag)
    {
        int j = 0;
        if((__flag & 0x40) != 0)
            j |= 8;
        if((__flag & 0x80) != 0)
            j |= 1;
        if((__flag & 0x100) != 0)
            j |= 4;
        if((__flag & 0x200) != 0)
            j |= 2;
        if((__flag & 0x200000) != 0)
            j |= 0x10000;
        return j;
    }

    public static int _coII(int i)
    {
        int j = toCodfileRoutineAttribute(i);
        if((i & 0x800) != 0)
            j |= 0x20;
        if((i & 0x20) != 0)
            j |= 0x10;
        if((i & 0x8000000) != 0)
            j |= 0x40;
        return j;
    }

    public static int _ctII(int i)
    {
        int j = toCodfileRoutineAttribute(i);
        if((i & 2) != 0)
            j |= 0x10;
        if((i & 0x100000) != 0)
            j |= 0x100;
        if((i & 0x10) != 0)
            j |= 0x80;
        if((i & 0x20) != 0)
            j |= 0x20;
        return j;
    }

    public static int _cnII(int i)
    {
        return i & 0x200fbe2;
    }

    public void _aIStringBufferV(int i, StringBuffer stringbuffer)
    {
        if((i & 2) != 0)
            stringbuffer.append("static ");
        if((i & 0x20) != 0)
            stringbuffer.append("abstract ");
        if((i & 0x40) != 0)
            stringbuffer.append("final ");
        if((i & 0x80) != 0)
            stringbuffer.append("public ");
        if((i & 0x100) != 0)
            stringbuffer.append("protected ");
        if((i & 0x200) != 0)
            stringbuffer.append("private ");
        if((i & 0x800) != 0)
            stringbuffer.append("interface ");
        if((i & 0x1000) != 0)
            stringbuffer.append("transient ");
        if((i & 0x2000) != 0)
            stringbuffer.append("volatile ");
        if((i & 0x4000) != 0)
            stringbuffer.append("strict ");
        if((i & 0x8000) != 0)
            stringbuffer.append("synchronized ");
        if((i & 0x2000000) != 0)
            stringbuffer.append("synthetic ");
    }
}
