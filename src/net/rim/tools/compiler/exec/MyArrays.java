// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.exec;

import java.util.Arrays;
import net.rim.tools.compiler.codfile.CodfileLabel;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.Field;



public class MyArrays
{

    private MyArrays()
    {
    }

    public static void sort(Object __array[], net.rim.tools.compiler.exec.Comparator __comparator)
    {
        Arrays.sort(__array, __comparator);
    }

    public static byte[] resize(byte __array[], int __length)
    {
        byte abyte1[] = new byte[__length];
        System.arraycopy(__array, 0, abyte1, 0, __array.length);
        return abyte1;
    }

    public static char[] resize(char __array[], int __length)
    {
        char ac1[] = new char[__length];
        System.arraycopy(__array, 0, ac1, 0, __array.length);
        return ac1;
    }

    public static int[] resize(int __array[], int __length)
    {
        int ai1[] = new int[__length];
        System.arraycopy(__array, 0, ai1, 0, __array.length);
        return ai1;
    }

    public static Object[] resize(Object __array[], int _length)
    {
        Object aobj1[] = new Object[_length];
        System.arraycopy(((Object) (__array)), 0, ((Object) (aobj1)), 0, __array.length);
        return aobj1;
    }

    public static net.rim.tools.compiler.types.Method[] resize(net.rim.tools.compiler.types.Method ac[], int i)
    {
        net.rim.tools.compiler.types.Method ac1[] = new net.rim.tools.compiler.types.Method[i];
        System.arraycopy(ac, 0, ac1, 0, ac.length);
        return ac1;
    }

    public static net.rim.tools.compiler.types.Field[] resize(net.rim.tools.compiler.types.Field ah[], int i)
    {
        net.rim.tools.compiler.types.Field ah1[] = new net.rim.tools.compiler.types.Field[i];
        System.arraycopy(ah, 0, ah1, 0, ah.length);
        return ah1;
    }

    public static net.rim.tools.compiler.codfile.CodfileItem[] resize(net.rim.tools.compiler.codfile.CodfileItem aap[], int i)
    {
        net.rim.tools.compiler.codfile.CodfileItem aap1[] = new net.rim.tools.compiler.codfile.CodfileItem[i];
        System.arraycopy(aap, 0, aap1, 0, aap.length);
        return aap1;
    }

    public static net.rim.tools.compiler.codfile.CodfileLabel[] resize(net.rim.tools.compiler.codfile.CodfileLabel aa6[], int i)
    {
        net.rim.tools.compiler.codfile.CodfileLabel aa6_1[] = new net.rim.tools.compiler.codfile.CodfileLabel[i];
        System.arraycopy(aa6, 0, aa6_1, 0, aa6.length);
        return aa6_1;
    }
}
