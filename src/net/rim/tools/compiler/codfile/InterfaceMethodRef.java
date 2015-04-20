// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, m, a5, p,
//            x, ak, r, k,
//            a1, ai, aj, u

public final class InterfaceMethodRef extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected net.rim.tools.compiler.codfile.Member _member;
    protected net.rim.tools.compiler.codfile.ClassDef _ClassDef;
    protected net.rim.tools.compiler.codfile.Identifier z_hsak;
    protected net.rim.tools.compiler.codfile.TypeList _protoTypeList;
    protected net.rim.tools.compiler.codfile.TypeList _typeList;
    private static StringBuffer z_hyStringBuffer = new StringBuffer();
    private static int z_hvI = 0;
    protected String z_huString;

    private void _blvV()
    {
        synchronized(z_hyStringBuffer)
        {
            z_hyStringBuffer.setLength(0);
            z_hyStringBuffer.append("interfacemethodref_");
            z_hyStringBuffer.append(++z_hvI);
            super._nameS = z_hyStringBuffer.toString();
            z_hyStringBuffer.append(' ');
            if(_typeList != null && _typeList.length() > 0)
            {
                z_hyStringBuffer.append(_typeList.get_baseType().getTypeName());
                z_hyStringBuffer.append(' ');
            }
            z_hyStringBuffer.append(_ClassDef.get_name_2());
            z_hyStringBuffer.append('.');
            z_hyStringBuffer.append(z_hsak.getString());
            z_hyStringBuffer.append("( ");
            int i = _protoTypeList != null ? _protoTypeList.length() : 0;
            for(int j = 0; j < i; j++)
            {
                z_hyStringBuffer.append(_protoTypeList.get_type(j).getTypeName());
                if(j < i - 1)
                    z_hyStringBuffer.append(", ");
            }

            z_hyStringBuffer.append(" )");
            z_huString = z_hyStringBuffer.toString();
        }
    }

    public InterfaceMethodRef(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.Member r1)
    {
        _member = r1;
        _ClassDef = r1.getClassDef();
        z_hsak = r1.getName();
        if(!(r1 instanceof RoutineNull))
        {
            net.rim.tools.compiler.codfile.Routine a5_1 = (net.rim.tools.compiler.codfile.Routine)r1;
            a5_1.makeSymbolic(k1, true);
            _protoTypeList = a5_1.getProtoTypeList();
            _typeList = a5_1.getTypeList();
        }
        _blvV();
    }

    public InterfaceMethodRef(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.DataSection k1)
        throws IOException
    {
        super(a2);
        _ClassDef = k1.findClassDef(a2.readUnsignedByte(), a2.readUnsignedByte());
        z_hsak = k1.getDataBytes().get_identifier(a2.readUnsignedShort());
        net.rim.tools.compiler.codfile.TypeLists ai1 = k1.getTypeLists();
        _protoTypeList = ai1.createTypeList(a2.readUnsignedShort());
        _typeList = ai1.createTypeList(a2.readUnsignedShort());
        _blvV();
    }

    public void _aajV(net.rim.tools.compiler.codfile.aj aj1)
    {
        _member = aj1._aupr(_ClassDef, z_hsak, _protoTypeList, _typeList);
    }

    public static void _ifkBIIV(net.rim.tools.compiler.codfile.DataSection k1, byte abyte0[], int i, int j, int l)
    {
        l += i;
        for(j += i; j < l; j += 8)
            k1._doaBIV(abyte0, j);

    }

    public String get_name_1()
    {
        return z_huString;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        c1.writeString(super._nameS);
        c1.writeString(": ");
        _ClassDef.writeAbsoluteClassDef(c1);
        z_hsak.writeOffset(c1);
        _protoTypeList._acV(c1, "prototype: ");
        _typeList._acV(c1, "returns: ");
        setExtent(c1);
    }

}
