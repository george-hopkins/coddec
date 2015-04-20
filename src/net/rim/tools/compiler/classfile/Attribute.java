// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            i, z, w, s,
//            v, m, t

public class Attribute
implements net.rim.tools.compiler.vm.Constants
{

    net.rim.tools.compiler.classfile.ConstantPool _constantPool;
    int z_nyI;
    String f_nameS;
    byte z_nxaB[];
    int z_nwI;
    int z_nAI;
    boolean z_nzZ;

    Attribute(net.rim.tools.compiler.io.StructuredInputStream __input, int j, String s1)
        throws IOException
    {
        z_nyI = j;
        f_nameS = s1;
        z_nAI = __input.readInt();
    }

    public Attribute(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.classfile.ConstantPool m1, int j, String s1)
        throws IOException
    {
        this(__input, j, s1);
        _constantPool = m1;
        z_nwI = __input.getOffset();
        z_nxaB = __input.getBytes();
        __input.skipBytes(z_nAI);
        if(z_nwI + z_nAI != __input.getOffset())
            throw new IOException("incorrect attribute length");
        else
            return;
    }

    public static Attribute read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.classfile.ConstantPool __constantPool, int j, boolean flag)
        throws IOException
    {
        Object obj = null;
        int k = __input.readUnsignedShort();
        String s1 = __constantPool.getConstantPoolEntryString(k);
        if(flag)
            obj = new net.rim.tools.compiler.classfile.Attribute(__input, __constantPool, k, s1);
        else
        if(s1.equals(net.rim.tools.compiler.classfile.AttributeList.NAME_CODE))
        {
            if(j != 3)
                throw new IOException("Code attribute found outside of method");
            obj = new net.rim.tools.compiler.classfile.AttributeCode(__input, __constantPool, k, s1);
        } else
        if(s1.equals(net.rim.tools.compiler.classfile.AttributeList.NAME_LINENUMBERTABLE))
        {
            if(j != 4)
                throw new IOException("LineNumberTable attribute found outside of Code attribute");
            obj = new net.rim.tools.compiler.classfile.AttributeLineNumberTable(__input, k, s1);
        } else
        if(s1.equals(net.rim.tools.compiler.classfile.AttributeList.NAME_STACKMAP))
        {
            if(j != 4)
                throw new IOException("StackMap attribute found outside of Code attribute");
            obj = new net.rim.tools.compiler.classfile.AttributeStackMapTable(__input, __constantPool, k, s1);
        } else
        if(s1.equals(AttributeList.NAME_LOCALVARIABLETABLE))
        {
            if(j != 4)
                throw new IOException("LocalVariableTable attribute found outside of Code attribute");
            obj = new net.rim.tools.compiler.classfile.AttributeLocalVariableTable(__input, __constantPool, k, s1);
        } else
        if(s1.equals(net.rim.tools.compiler.classfile.AttributeList.NAME_INNERCLASSES))
        {
            if(j != 1)
                throw new IOException("InnerClasses attribute found outside of class");
            obj = new net.rim.tools.compiler.classfile.v(__input, __constantPool, k, s1);
        } else
        {
            obj = new net.rim.tools.compiler.classfile.Attribute(__input, __constantPool, k, s1);
            if(s1.equals(net.rim.tools.compiler.classfile.AttributeList.NAME_DEPRECATED) || s1.equals(AttributeList.NAME_SYNTHETIC))
            {
                if(((net.rim.tools.compiler.classfile.Attribute) (obj)).z_nAI != 0)
                    throw new IOException("incorrect attribute length for: " + s1);
            } else
            if(s1.regionMatches(true, 0, AttributeList.NAME_STACKMAP, 0, s1.length()) && j == 4)
                throw new IOException("StackMap attribute found with incorrect case");
        }
        return ((net.rim.tools.compiler.classfile.Attribute) (obj));
    }

    void _xcV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.empty_func7();
        c1.writeShort(z_nyI, "name=", true);
        c1.empty_func10(f_nameS, ' ');
        c1.writeInt(z_nAI, "length=", true);
        c1.empty_func7();
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(flag && z_nzZ)
        {
            return;
        } else
        {
            _xcV(c1);
            c1.empty_func();
            c1.writeString("bytes");
            c1.write(z_nxaB, z_nwI, z_nAI);
            c1.empty_func2();
            c1.empty_func7();
            return;
        }
    }

    public void _cHvV()
    {
        z_nzZ = true;
    }

    private int _aQII(int j)
    {
        j += z_nwI;
        int k = (z_nxaB[j] & 0xff) << 8;
        k |= z_nxaB[j + 1] & 0xff;
        return k;
    }

    public String getName()
    {
        return f_nameS;
    }

    public int getConstantValue(boolean flag)
        throws IOException
    {
        int j = _aQII(0);
        return _constantPool._aIZI(j, flag);
    }

    public long getConstantValueLong(boolean flag)
        throws IOException
    {
        int j = _aQII(0);
        return _constantPool._ifIZJ(j, flag);
    }

    public String getConstantString()
        throws IOException
    {
        int j = _aQII(0);
        return _constantPool._aIString(j);
    }

    public int _cGvI()
    {
        return _aQII(0);
    }

    public String getConstantString(int j)
        throws IOException
    {
        j = (j + 1) * 2;
        int k = _aQII(j);
        return _constantPool.getName(k);
    }

    public String _cEvString()
        throws IOException
    {
        int j = _aQII(0);
        return _constantPool.getConstantPoolEntryString(j);
    }
}
