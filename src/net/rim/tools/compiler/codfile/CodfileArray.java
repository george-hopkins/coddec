// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.exec.MyArrays;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, e, u, a9

public final class CodfileArray extends net.rim.tools.compiler.codfile.CodfileItem
implements net.rim.tools.compiler.vm.Constants
{

    private net.rim.tools.compiler.codfile.CodfileItem _items[];
    private int _length;
    private int z_h2I;
    private boolean z_h0Z;
    private String z_h6String;
    private int z_h1I;
    private boolean z_h4Z;

    public CodfileArray(int i, int j, boolean flag)
    {
        if(i > 0)
            _items = new net.rim.tools.compiler.codfile.CodfileItem[i];
        z_h2I = j;
        z_h0Z = flag;
        z_h6String = null;
        z_h1I = 0;
        z_h4Z = false;
    }

    public CodfileArray(int i, boolean flag)
    {
        this(i, 1, flag);
    }

    public CodfileArray(int i, int j)
    {
        this(i, j, false);
    }

    public CodfileArray(int i)
    {
        this(i, 1, false);
    }

    public CodfileArray()
    {
        this(0, 1, false);
    }

    private int _docvI(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        c1.writeSlack(z_h2I);
        setOffset(c1);
        boolean flag1 = false;
        if(super._nameS.length() > 0)
        {
            c1.empty_func7();
            if(flag)
            {
                writeLocalOffset(c1);
            } else
            {
                c1.empty_func10(super._nameS, ' ');
                flag1 = true;
            }
        }
        int i = _length;
        if(z_h0Z)
        {
            c1.writeShort(i, "count=", true);
            flag1 = true;
        }
        if(flag1)
            c1.empty_func7();
        for(int j = 0; j <= z_h1I; j++)
            c1.empty_func();

        return i;
    }

    private void _ifcvV(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(z_h4Z)
        {
            if(flag)
                c1.empty_func10(z_h6String, ' ');
        } else
        {
            c1.empty_func7();
        }
    }

    private void _mcV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        for(int i = 0; i <= z_h1I; i++)
            c1.empty_func2();

    }

    public void writeLocalOffset(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.empty_func5(super._nameS, super._extent);
    }

    public void _forcvV(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        int i = _docvI(c1, flag);
        for(int j = 0; j < i; j++)
        {
            _items[j].write(c1);
            _ifcvV(c1, j < i - 1);
        }

        _mcV(c1);
        setExtent(c1);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        _forcvV(c1, false);
    }

    public void _ifcvV(net.rim.tools.compiler.io.StructuredOutputStream c1, int i)
        throws IOException
    {
        int j = _docvI(c1, false);
        for(int k = 0; k < j; k++)
        {
            CodfileItemRelative e1 = (CodfileItemRelative)_items[k];
            e1.writeRelative(c1, i);
            _ifcvV(c1, k < j - 1);
        }

        _mcV(c1);
        setExtent(c1);
    }

    public void _ocV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = _docvI(c1, false);
        for(int j = 0; j < i; j++)
        {
            ClassDef u1 = (ClassDef)_items[j];
            u1.writeAbsoluteClassDef(c1);
            _ifcvV(c1, j < i - 1);
        }

        _mcV(c1);
        setExtent(c1);
    }

    public void _ncV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        int i = _docvI(c1, false);
        for(int j = 0; j < i; j++)
        {
            _items[j]._trycV(c1);
            _ifcvV(c1, j < i - 1);
        }

        _mcV(c1);
    }

    public void _jStringV(String s)
    {
        z_h4Z = true;
        z_h6String = s;
        z_h1I = -1;
    }

    public void _auIV(int i)
    {
        z_h1I = i;
    }

    public int getExtent()
    {
        return _length;
    }

    public CodfileItem getItem(int i)
    {
        return _items[i];
    }

    public void addItem(net.rim.tools.compiler.codfile.CodfileItem ap1)
    {
        if(_items == null)
            _items = new net.rim.tools.compiler.codfile.CodfileItem[1];
        else
        if(_length == _items.length)
            _items = net.rim.tools.compiler.exec.MyArrays.resize(_items, _items.length * 2);
        _items[_length++] = ap1;
    }

    public void setItem(net.rim.tools.compiler.codfile.CodfileItem ap1, int i)
    {
        _items[i] = ap1;
    }

    public void _ifapvV(net.rim.tools.compiler.codfile.CodfileItem __item, int i)
    {
        if(_length == _items.length)
            _items = net.rim.tools.compiler.exec.MyArrays.resize(_items, _items.length + 1);
        if(_length > i)
            System.arraycopy(_items, i, _items, i + 1, _length - i);
        _items[i] = __item;
        _length++;
    }

    public int _ifapI(net.rim.tools.compiler.codfile.CodfileItem ap1)
    {
        int i = _length;
        int j = i - 1;
        int k;
        for(k = 0; k <= j;)
        {
            int l = (k + j) / 2;
            if(ap1.compareTo(_items[l]) < 0)
                j = l - 1;
            else
                k = l + 1;
        }

        _ifapvV(ap1, k);
        return k;
    }

    public void _forapV(net.rim.tools.compiler.codfile.CodfileItem __item)
    {
        int i = __item.getOffset();
        if(i <= 0)
            throw new IllegalArgumentException("item has no offset");
        int j = _length;
        int k = j - 1;
        int l = 0;
        if(j > 0 && i > _items[k].getOffset())
        {
            addItem(__item);
            return;
        }
        while(l <= k)
        {
            int i1 = (l + k) / 2;
            if(i < _items[i1].getOffset())
                k = i1 - 1;
            else
                l = i1 + 1;
        }
        _ifapvV(__item, l);
    }

    public net.rim.tools.compiler.codfile.CodfileItem _aIa9ap(int i, net.rim.tools.compiler.codfile.MemberFactory a9_1)
    {
        int j = _length;
        int k = j - 1;
        int l;
        for(l = 0; l <= k;)
        {
            int i1 = (l + k) / 2;
            net.rim.tools.compiler.codfile.CodfileItem _CodfileItem_ = _items[i1];
            int j1 = _CodfileItem_.getOffset();
            if(i == j1)
                return _CodfileItem_;
            if(i < j1)
                k = i1 - 1;
            else
                l = i1 + 1;
        }

        net.rim.tools.compiler.codfile.CodfileItem _CodfileItem_ = null;
        if(a9_1 != null)
        {
            _CodfileItem_ = a9_1.createMember(i);
            if(l == j)
                addItem(_CodfileItem_);
            else
                _ifapvV(_CodfileItem_, l);
        }
        return _CodfileItem_;
    }

    public net.rim.tools.compiler.codfile.CodfileItem _avIap(int i)
    {
        for(int j = _length - 1; j >= 0; j--)
        {
            net.rim.tools.compiler.codfile.CodfileItem ap1 = _items[j];
            if(ap1.getOffset() < i)
                return ap1;
        }

        return _items[0];
    }
}
