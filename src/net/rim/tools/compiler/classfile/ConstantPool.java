// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            o, ab, g, e,
//            a, c

public final class ConstantPool
{

    private net.rim.tools.compiler.classfile.ConstantPoolEntry _constantPool[];
    private boolean z_aZ;

    public ConstantPool(net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        int _entriesNum_ = __input.readUnsignedShort();
        if(_entriesNum_ > 1)
        {
            _constantPool = new net.rim.tools.compiler.classfile.ConstantPoolEntry[_entriesNum_];
            _constantPool[0] = new net.rim.tools.compiler.classfile.ConstantPoolEntry();
            for(int j = 1; j < _entriesNum_; j++)
            {
                net.rim.tools.compiler.classfile.ConstantPoolEntry _entry_ = net.rim.tools.compiler.classfile.ConstantPoolEntry.read(__input);
                _constantPool[j] = _entry_;
                if(_entry_ instanceof net.rim.tools.compiler.classfile.ConstantPoolLong)
                {
                    _constantPool[++j] = _constantPool[0];
                    if(j >= _entriesNum_)
                        throw new IOException("invalid constant pool in class file");
                }
            }

        }
        if(!flag)
            try
            {
                for(int k = 1; k < _entriesNum_; k++)
                    _constantPool[k].resolve(this);

                for(int l = 1; l < _entriesNum_; l++)
                    _constantPool[l].verify();

            }
            catch(ClassCastException classcastexception)
            {
                throw new IOException("invalid constant pool in class file");
            }
        z_aZ = flag;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        int i = getSize();
        __output.empty_func7();
        __output.writeString("constant_pool");
        __output.empty_func7();
        __output.writeShort(i, "num_entries=", true);
        __output.empty_func7();
        __output.empty_func();
        for(int j = 1; j < i; j++)
        {
            __output.writeString("entry: ");
            __output.empty_func8(j);
            __output.empty_func7();
            _constantPool[j].write(__output, flag);
            __output.empty_func7();
        }

        __output.empty_func2();
        __output.empty_func7();
    }

    public int getSize()
    {
        return _constantPool != null ? _constantPool.length : 1;
    }

    public net.rim.tools.compiler.classfile.ConstantPoolEntry getConstantPoolEntry(int __index)
        throws IOException
    {
        if(__index == 0 || __index >= getSize())
            throw new IOException("invalid constant pool index: " + __index);
        net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = _constantPool[__index];
        if(z_aZ)
            o1.resolve(this);
        return o1;
    }

    public String getConstantPoolEntryString(int __index)
        throws IOException
    {
        net.rim.tools.compiler.classfile.ConstantPoolEntry _entry_ = getConstantPoolEntry(__index);
        if(_entry_ instanceof net.rim.tools.compiler.classfile.ConstantPoolUTF8)
        {
            net.rim.tools.compiler.classfile.ConstantPoolUTF8 g1 = (net.rim.tools.compiler.classfile.ConstantPoolUTF8)_entry_;
            return g1.getString();
        } else
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return null;
        }
    }

    public String getName(int i)
        throws IOException
    {
        net.rim.tools.compiler.classfile.ConstantPoolEntry _entry_ = getConstantPoolEntry(i);
        if(_entry_ instanceof ConstantPoolClass)
        {
            net.rim.tools.compiler.classfile.ConstantPoolClass e1 = (net.rim.tools.compiler.classfile.ConstantPoolClass)_entry_;
            return e1.getName();
        } else
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return null;
        }
    }

    public String _aIString(int i)
        throws IOException
    {
        net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = getConstantPoolEntry(i);
        if(o1 instanceof net.rim.tools.compiler.classfile.ConstantPoolString)
        {
            net.rim.tools.compiler.classfile.ConstantPoolString a1 = (net.rim.tools.compiler.classfile.ConstantPoolString)o1;
            return a1.getString();
        } else
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return null;
        }
    }

    public int _aIZI(int i, boolean flag)
        throws IOException
    {
        net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = getConstantPoolEntry(i);
        if(o1 instanceof net.rim.tools.compiler.classfile.ConstantPoolInteger)
        {
            net.rim.tools.compiler.classfile.ConstantPoolInteger c1 = (net.rim.tools.compiler.classfile.ConstantPoolInteger)o1;
            if(flag ^ c1.isFloat())
                net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return c1.getValue();
        } else
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return 0;
        }
    }

    public long _ifIZJ(int i, boolean flag)
        throws IOException
    {
        net.rim.tools.compiler.classfile.ConstantPoolEntry o1 = getConstantPoolEntry(i);
        if(o1 instanceof net.rim.tools.compiler.classfile.ConstantPoolLong)
        {
            net.rim.tools.compiler.classfile.ConstantPoolLong ab1 = (net.rim.tools.compiler.classfile.ConstantPoolLong)o1;
            if(flag ^ ab1.isDouble())
                net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return ab1.getValue();
        } else
        {
            net.rim.tools.compiler.classfile.ConstantPoolEntry._b6vV();
            return 0L;
        }
    }
}
