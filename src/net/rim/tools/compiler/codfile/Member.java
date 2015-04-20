// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, ak, u, p,
//            k

public abstract class Member extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected net.rim.tools.compiler.codfile.ClassDef _classDef;
    protected net.rim.tools.compiler.codfile.Identifier _name;
    protected net.rim.tools.compiler.codfile.TypeList _typeList;
    private static StringBuffer f_nameStringBuffer = new StringBuffer();

    public Member()
    {
    }

    public Member(net.rim.tools.compiler.codfile.ClassDef u, net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList __typeList)
    {
        _classDef = u;
        _name = ak1;
        _typeList = __typeList;
        setName(ak1.getString());
    }

    public Member(net.rim.tools.compiler.codfile.ClassDef u, int i)
    {
        super(i);
        _classDef = u;
    }

    public abstract void writeStaticOffset(net.rim.tools.compiler.io.StructuredOutputStream c, net.rim.tools.compiler.codfile.ClassDef u)
        throws IOException;

    public abstract void writeMemberAddress(net.rim.tools.compiler.io.StructuredOutputStream c, boolean flag)
        throws IOException;

    public abstract void writeFixups(net.rim.tools.compiler.codfile.DataSection k);

    public ClassDef getClassDef()
    {
        return _classDef;
    }

    public Identifier getName()
    {
        return _name;
    }

    public void _ifStringvV(String s, int i)
    {
        synchronized(f_nameStringBuffer)
        {
            f_nameStringBuffer.setLength(0);
            f_nameStringBuffer.append(_classDef.get_name_2());
            f_nameStringBuffer.append(".");
            f_nameStringBuffer.append(s);
            if(i != 0)
                f_nameStringBuffer.append(i);
            super._nameS = f_nameStringBuffer.toString();
        }
    }

    public void setName(String s)
    {
        _ifStringvV(s, 0);
    }

    public net.rim.tools.compiler.codfile.TypeList getTypeList()
    {
        return _typeList;
    }

}
