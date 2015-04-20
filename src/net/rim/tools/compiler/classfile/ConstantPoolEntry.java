// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            g, c, ab, e,
//            a, h, r, y,
//            ag, m

public class ConstantPoolEntry
implements net.rim.tools.compiler.vm.Constants
{

    public static final byte z_mIB = 1;
    public static final byte z_mKB = 3;
    public static final byte z_mNB = 4;
    public static final byte z_mPB = 5;
    public static final byte z_mSB = 6;
    public static final byte z_mOB = 7;
    public static final byte z_mUB = 8;
    public static final byte z_mMB = 9;
    public static final byte z_mRB = 10;
    public static final byte z_mQB = 11;
    public static final byte z_mTB = 12;
    static final byte z_mJB = -1;
    int _typeTag;

    public ConstantPoolEntry(int i)
    {
        _typeTag = i;
    }

    public ConstantPoolEntry()
    {
        this(-1);
    }

    public static net.rim.tools.compiler.classfile.ConstantPoolEntry read(net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        byte byte0 = __input.readByte();
        switch(byte0)
        {
        case 1: // '\001'
				return new net.rim.tools.compiler.classfile.ConstantPoolUTF8(byte0, __input);

        case 3: // '\003'
        case 4: // '\004'
            return new net.rim.tools.compiler.classfile.ConstantPoolInteger(byte0, __input, byte0 == 4);

        case 5: // '\005'
        case 6: // '\006'
				return new net.rim.tools.compiler.classfile.ConstantPoolLong(byte0, __input, byte0 == 6);

        case 7: // '\007'
				return new net.rim.tools.compiler.classfile.ConstantPoolClass(byte0, __input);

        case 8: // '\b'
            return new net.rim.tools.compiler.classfile.ConstantPoolString(byte0, __input);

        case 9: // '\t'
				return new net.rim.tools.compiler.classfile.ConstantPoolFieldRef(byte0, __input);

        case 10: // '\n'
				return new net.rim.tools.compiler.classfile.ConstantPoolMethodRef(byte0, __input);

        case 11: // '\013'
				return new net.rim.tools.compiler.classfile.ConstantPoolInterfaceMethodRef(byte0, __input);

        case 12: // '\f'
				return new net.rim.tools.compiler.classfile.ConstantPoolNameAndType(byte0, __input);

        case 2: // '\002'
        default:
            _b6vV();
            break;
        }
        return null;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        if(_typeTag != -1)
            __output.writeByte(_typeTag, "tag=", true);
    }

    public void resolve(net.rim.tools.compiler.classfile.ConstantPool m)
        throws IOException
    {
    }

    public void verify()
        throws IOException
    {
    }

    public static void _b6vV()
        throws IOException
    {
        throw new IOException("Invalid constant pool entry.");
    }
}
