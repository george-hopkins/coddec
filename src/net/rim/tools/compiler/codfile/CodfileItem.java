// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.io.StructuredInputStream;

public abstract class CodfileItem
implements net.rim.tools.compiler.vm.Constants
{

    protected int _offset;
    protected int _extent;
    protected int _ordinal;
    protected int _address;
    protected String _nameS;  // table name

    public CodfileItem(int __offset)
    {
        _offset = __offset;
    }

    public CodfileItem()
    {
        this(-1);
    }

    public CodfileItem(net.rim.tools.compiler.io.StructuredInputStream __input)
    {
        this(__input.getOffset());
    }

    public void writeLocalOffset(net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        __output.empty_func5(get_name_1(), _extent);
    }

    public void _acV(net.rim.tools.compiler.io.StructuredOutputStream c1, String s)
        throws IOException
    {
        String s1 = get_name_1();
        if(s1 == null)
        {
            c1.writeShort(_offset, s, false);
        } else
        {
            c1.writeString(s);
            c1.writeShort(_offset, s1, false);
        }
    }

    public void _trycV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        String s = get_Name();
        if(s != null)
        {
            c1.writeShort(_offset, s, false);
            return;
        } else
        {
            c1.writeShort(_offset);
            return;
        }
    }

    public void writeOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        String s = get_name_1();
        if(s != null)
        {
            c1.writeShort(_offset, s, false);
            return;
        } else
        {
            c1.writeShort(_offset);
            return;
        }
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        String s = get_name_1();
        if(s != null)
        {
            c1.writeByte(_ordinal, s, false);
            return;
        } else
        {
            c1.writeByte(_ordinal);
            return;
        }
    }

    public void writeAddress(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        String s = get_name_1();
        if(s != null)
        {
            c1.writeShort(_address, s, false);
            return;
        } else
        {
            c1.writeShort(_address);
            return;
        }
    }

    public void writeAddressByte(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        String s = get_name_1();
        if(s != null)
        {
            c1.writeByte(_address, s, false);
            return;
        } else
        {
            c1.writeByte(_address);
            return;
        }
    }

    public abstract void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException;

    public void setOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        _offset = c1.getOffset();
    }

    public void setOffset(int __offset)
    {
        _offset = __offset; //current index
    }

    public int getOffset()
    {
        return _offset;
    }

    public void setExtent(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        _extent = c1.getOffset() - _offset;
    }

    public void setExtent(int __size)
    {
        _extent = __size;
    }

    public int getExtent()
    {
        return _extent;
    }

    public void setOrdinal(int i)
    {
        _ordinal = i;
    }

    public int getOrdinal()
    {
        return _ordinal;
    }

    public void setAddress(int i)
    {
        _address = i;
    }

    public int getAddress()
    {
        return _address;
    }

    protected void setName(String s)
    {
        _nameS = s;
    }

    public String get_name_2()
    {
        return _nameS;
    }

    public String get_Name()
    {
        return _nameS;
    }

    public String get_name_1()
    {
        return _nameS;
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.CodfileItem ap1 = (net.rim.tools.compiler.codfile.CodfileItem)obj;
        return _offset - ap1._offset;
    }
}
