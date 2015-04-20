// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, am, p, x,
//            ag, k

public final class TypeLists extends net.rim.tools.compiler.codfile.CodfileItem
{

    private net.rim.tools.compiler.codfile.TypeList _TypeList;
    private net.rim.tools.compiler.codfile.TypeList _nullTypeList;
    private net.rim.tools.compiler.codfile.TypeList z_g7p;
    private net.rim.tools.compiler.codfile.CodfileVectorHash _TypeLists;
    private boolean z_g9Z;
    private Hashtable z_g8Hashtable;

    public TypeLists()
    {
        _TypeLists = new net.rim.tools.compiler.codfile.CodfileVectorHash(33);
        _TypeList = new net.rim.tools.compiler.codfile.TypeList(-1);
        _nullTypeList = new net.rim.tools.compiler.codfile.TypeList(0);
        _TypeLists.setTableName("type list table");
        setName("type list table");
    }

    void read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, int i)
        throws IOException
    {
        __input.verifyOffset(super._offset, super._nameS);
        while(__input.getOffset() < i)
        {
            net.rim.tools.compiler.codfile.TypeList _typeList_ = new TypeList(__input, __dataSection);
            if(_typeList_.length() == 0)
                if(z_g7p == null)
                    z_g7p = _typeList_;
                else
                if(__input.getOffset() == i)
                    continue;
            _TypeLists.addElement(_typeList_);
            _TypeLists.inject(_typeList_, _typeList_);
        }
    }

    public static void _akBIIV(DataSection k, byte abyte0[], int i, int j, int l)
    {
        l += i;
        for(j += i; j < l; j += TypeList._ifkBII(k, abyte0, j));
    }

    public void _bbvV()
    {
        z_g9Z = true;
    }

    public TypeItem _axx(TypeItem x1)
    {
        if(z_g8Hashtable == null)
            z_g8Hashtable = new Hashtable();
        TypeItem x2 = (TypeItem)z_g8Hashtable.get(x1);
        if(x2 == null)
        {
            z_g8Hashtable.put(x1, x1);
            x2 = x1;
        }
        return x2;
    }

    public void write(StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        writeLocalOffset(c);
        _TypeLists._scV(c);
        setExtent(c);
    }

    public TypeList getNullTypeList()
    {
        return _nullTypeList;
    }

    public TypeList getSomethingTypeList()
    {
        return _TypeList;
    }

    public TypeList getEmptyTypeList()
    {
        if(z_g7p == null)
        {
            TypeList p1 = new TypeList(0);
            z_g7p = (TypeList)_TypeLists.get(p1);
            if(z_g7p == null)
            {
                z_g7p = p1;
                _TypeLists.put(z_g7p, z_g7p);
            }
        }
        return z_g7p;
    }

    public TypeList createTypeList(int __offset)
        throws IOException
    {
        if(__offset == 65535)
            return _TypeList;
        if(__offset == 0)
            return _nullTypeList;
        TypeList _typeList_ = (TypeList)_TypeLists.getItem(__offset, null);
        if(_typeList_ == null)
            throw new IOException("bad offset for type list: 0x" + Integer.toHexString(__offset));
        else
            return _typeList_;
    }

    public TypeList getTypeList(TypeList __typeList, DataSection __dataSection, boolean __flag)
    {
        if(__typeList == _TypeList)
            return __typeList;
        if(__typeList == _nullTypeList)
            return __typeList;
        TypeList p2 = (TypeList)_TypeLists.get(__typeList);
        if(p2 == null)
        {
            __typeList._ifkV(__dataSection);
            _TypeLists.put(__typeList, __typeList);
            p2 = __typeList;
        }
        __flag = __flag && z_g9Z;
        p2.setCompressable(__flag);
        return p2;
    }
}
