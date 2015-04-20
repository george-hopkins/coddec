// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            e, m

public final class AttributeStackMapType
{

    public static final int z_elseI = 0;
    public static final int z_intI = 1;
    public static final int z_voidI = 2;
    public static final int z_bI = 3;
    public static final int z_nullI = 4;
    public static final int z_ifI = 5;
    public static final int z_charI = 6;
    public static final int z_caseI = 7;
    public static final int z_forI = 8;
    private static final int z_byteI = 7;
    private static net.rim.tools.compiler.classfile.AttributeStackMapType z_doaf[] = new net.rim.tools.compiler.classfile.AttributeStackMapType[7];
    private int _typeTag;
    private String _typeName;
    private int _offset;
    private net.rim.tools.compiler.classfile.ConstantPool _constantPool;
    private net.rim.tools.compiler.classfile.ConstantPoolClass _class;
    private int _typeIndex;

    private AttributeStackMapType(int i)
    {
        _typeTag = i;
    }

    private AttributeStackMapType(int i, int j, net.rim.tools.compiler.classfile.ConstantPool m1)
        throws IOException
    {
        this(i);
        if(i == 7)
        {
            _typeName = m1.getName(j);
            _typeIndex = j;
        } else
        if(i == 8)
        {
            _offset = j;
            _constantPool = m1;
        }
    }

    public static AttributeStackMapType read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.classfile.ConstantPool m1)
        throws IOException
    {
        AttributeStackMapType f1 = null;
        int i = __input.readUnsignedByte();
        if(i == 7 || i == 8)
            f1 = new net.rim.tools.compiler.classfile.AttributeStackMapType(i, __input.readUnsignedShort(), m1);
        else
            synchronized(z_doaf)
            {
                f1 = z_doaf[i];
                if(f1 == null)
                    f1 = z_doaf[i] = new net.rim.tools.compiler.classfile.AttributeStackMapType(i);
            }
        return f1;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeByte(_typeTag, "type=", true);
        if(_typeTag == 7)
        {
            c1.writeShort(_typeIndex, "type_name=", true);
            c1.empty_func10(_typeName, ' ');
        } else
        if(_typeTag == 8)
            c1.writeShort(_offset, "new_offset=", true);
        c1.empty_func7();
    }

    public int getType()
    {
        return _typeTag;
    }

    public int getSize()
    {
        int i = 1;
        switch(_typeTag)
        {
        case 3: // '\003'
        case 4: // '\004'
            i++;
            break;
        }
        return i;
    }

    public String getTypeName()
    {
        return _typeName;
    }

    public int getNewOffset()
    {
        return _offset;
    }

    public net.rim.tools.compiler.classfile.ConstantPoolClass getNewClass(int i)
        throws IOException
    {
        if(_class == null)
        {
            _class = (net.rim.tools.compiler.classfile.ConstantPoolClass)_constantPool.getConstantPoolEntry(i);
            _constantPool = null;
        }
        return _class;
    }

}
