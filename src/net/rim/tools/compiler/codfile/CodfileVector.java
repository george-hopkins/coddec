// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.vm.Constants;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, a9

public class CodfileVector extends Vector
implements net.rim.tools.compiler.vm.Constants
{

    protected int _align;
    protected boolean _sizePrefix;
    protected boolean _sizePrefixNegative;
    protected int _offset;
    protected int _extent;
    protected String _table;
    protected String z_iGString;
    protected int z_iCI;
    protected boolean z_iFZ;

    public CodfileVector(int i, boolean flag)
    {
        _align = i;
        _sizePrefix = flag;
    }

    public CodfileVector(boolean flag)
    {
        this(1, flag);
    }

    public CodfileVector(int i)
    {
        this(i, false);
    }

    public CodfileVector()
    {
        this(1, false);
    }

    public void negatePrefix()
    {
        _sizePrefixNegative = true;
    }

    public void writeOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeShort(_offset, _table, false);
    }

    private int _newcvI(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeSlack(_align);
        setOffset(c1);
        boolean flag1 = false;
        if(_table.length() > 0)
        {
            c1.empty_func7();
            if(flag)
            {
                writeExtent(c1);
            } else
            {
                c1.empty_func10(_table, ' ');
                flag1 = true;
            }
        }
        int i = size();
        if(_sizePrefix)
        {
            int j = i;
            if(_sizePrefixNegative)
                j = -i;
            c1.writeShort(j, "count=", true);
            flag1 = true;
        }
        if(flag1)
            c1.empty_func7();
        for(int k = 0; k <= z_iCI; k++)
            c1.empty_func();

        return i;
    }

    private void _intcvV(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(z_iFZ)
        {
            if(flag)
                c1.empty_func10(z_iGString, ' ');
        } else
        {
            c1.empty_func7();
        }
    }

    private void _rcV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        for(int i = 0; i <= z_iCI; i++)
            c1.empty_func2();

    }

    public void writeExtent(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.empty_func5(_table, _extent);
    }

    public void _trycvV(net.rim.tools.compiler.io.StructuredOutputStream __output, boolean flag)
        throws IOException
    {
        int i = _newcvI(__output, flag);
        for(int j = 0; j < i; j++)
        {
            CodfileItem _item_ = (CodfileItem)elementAt(j);
			__output.writeString("\r\n");
            _item_.write(__output);
			__output.writeString("\r\n");
            _intcvV(__output, j < i - 1);
        }

        _rcV(__output);
        setExtent(__output);
    }

    public void _scV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        _trycvV(c1, false);
    }

    public void _ucV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = _newcvI(c1, false);
        for(int j = 0; j < i; j++)
        {
            CodfileItem ap1 = (CodfileItem)elementAt(j);
            int k = ap1.getOffset();
            String s = ap1.get_Name();
            if(s != null)
                c1.writeShort(k, s, false);
            else
                c1.writeShort(k);
            _intcvV(c1, j < i - 1);
        }

        _rcV(c1);
    }

    public void setOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        _offset = c1.getOffset();
    }

    public void setOffset(int __offset)
    {
        _offset = __offset; //remember value offset
    }

    public int getOffset()
    {
        return _offset;
    }

    public int getAlign()
    {
        return _align;
    }

    public void setExtent(net.rim.tools.compiler.io.StructuredOutputStream c1)
    {
        _extent = c1.getOffset() - _offset;
    }

    public void setExtent(int __extent)
    {
        _extent = __extent;
    }

    public int getExtent()
    {
        return _extent;
    }

    public void _lStringV(String s)
    {
        z_iFZ = true;
        z_iGString = s;
        z_iCI = -1;
    }

    public void _aBIV(int i)
    {
        z_iCI = i;
    }

    public void setTableName(String __name)
    {
        _table = __name;
    }

    public int addElementOrdered(CodfileItem ap1)
    {
        int i = size();
        int j = i - 1;
        int k;
        for(k = 0; k <= j;)
        {
            int l = (k + j) / 2;
            CodfileItem ap2 = (CodfileItem)elementAt(l);
            if(ap1.compareTo(ap2) < 0)
                j = l - 1;
            else
                k = l + 1;
        }

        insertElementAt(ap1, k);
        return k;
    }

    public void addItemOffset(CodfileItem __item)
    {
        int i = __item.getOffset();
        if(i <= 0)
            throw new IllegalArgumentException("item has no offset");
        int j = size();
        int k = j - 1;
        int l = 0;
        if(j > 0)
        {
            CodfileItem ap2 = (CodfileItem)elementAt(k);
            if(i > ap2.getOffset())
            {
                addElement(__item);
                return;
            }
        }
        while(l <= k)
        {
            int i1 = (l + k) / 2;
            CodfileItem ap3 = (CodfileItem)elementAt(i1);
            if(i < ap3.getOffset())
                k = i1 - 1;
            else
                l = i1 + 1;
        }
        insertElementAt(__item, l);
    }

    public CodfileItem getItem(int __offset, MemberFactory __item)
    {
        int _size_ = size();
        int _last_ = _size_ - 1;
        int _index_;
        for(_index_ = 0; _index_ <= _last_;)
        {
            int i1 = (_index_ + _last_) / 2;
            CodfileItem _item_ = (CodfileItem)elementAt(i1);
            int _offset_ = _item_.getOffset();
            if(__offset == _offset_)
                return _item_;
            if(__offset < _offset_)
                _last_ = i1 - 1;
            else
                _index_ = i1 + 1;
        }

        CodfileItem _item_ = null;
        if(__item != null)
        {
            _item_ = __item.createMember(__offset);
            if(_index_ == _size_)
                addElement(_item_);
            else
                insertElementAt(_item_, _index_);
        }
        return _item_;
    }

    public CodfileItem findItem(int __offset)
    {
        for(int _index_ = size() - 1; _index_ >= 0; _index_--)
        {
            CodfileItem _item_ = (CodfileItem)elementAt(_index_);
            if(_item_.getOffset() < __offset)
                return _item_;
        }

        return (CodfileItem)firstElement();
    }
}
