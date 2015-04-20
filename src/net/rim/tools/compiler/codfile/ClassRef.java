// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, y, ay, g,
//            ad, au, l, ah,
//            ax, u, k, a1,
//            af, ak

public final class ClassRef extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected net.rim.tools.compiler.codfile.Module _module;
    protected net.rim.tools.compiler.codfile.Identifier _packageName;
    protected net.rim.tools.compiler.codfile.Identifier _className;
    protected net.rim.tools.compiler.codfile.ClassDef _classDef;
    private static StringBuffer f_classRefNameStringBuffer = new StringBuffer();
    private static int z_hkI = 0;
    private int z_hnI;
    private int z_hjI;

    public ClassRef(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.ClassDef u1)
    {
        super(0);
        super._ordinal = -1;
        _classDef = u1;
        _module = u1.getModule();
        _packageName = u1.getPackageName();
        _className = u1.getClassName();
        _bgvV();
    }

    public ClassRef(net.rim.tools.compiler.io.StructuredInputStream a2, net.rim.tools.compiler.codfile.DataSection k1, int i)
        throws IOException
    {
        super(a2);
        super._ordinal = i;
        int j = a2.readUnsignedShort();
        _module = k1.getModule(j);
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        int pkgId = a2.readUnsignedShort();
        int clsId = a2.readUnsignedShort();
        _packageName = a1_1.get_identifier(pkgId);
        _className = a1_1.get_identifier(clsId);
        System.out.println("---- ModId 0x" + Integer.toHexString(j) + " PkgId " + Integer.toHexString(pkgId) + " = " + _packageName.getString() +
        		" ClsId " + Integer.toHexString(clsId) + " = " + _className.getString());
        System.out.println("----- Mod Ord " + _module.getOrdinal() + " names " + _module.get_Name() + " " + _module.get_name_1() + " " + _module.get_name_2());
        _bgvV();
        z_hnI = a2.readUnsignedByte();
        z_hjI = a2.readUnsignedByte();
        if(j != 0)
            if(_module instanceof net.rim.tools.compiler.codfile.ModuleDomestic)
            {
            	System.out.println("---- DOMESTIC");
                _classDef = new net.rim.tools.compiler.codfile.ClassDefForeign(k1, _module, _packageName, _className);
                _module._ifuV(_classDef);
            } else
            if(_module instanceof net.rim.tools.compiler.codfile.ModuleRef)
            {
            	System.out.println("---- REF");
                net.rim.tools.compiler.codfile.ModuleRef g1 = (net.rim.tools.compiler.codfile.ModuleRef)_module;
                _classDef = new net.rim.tools.compiler.codfile.ClassDefDomestic(k1, _module, _packageName, _className);
                g1._auvV(_classDef, z_hjI);
            } else
            if(_module instanceof net.rim.tools.compiler.codfile.ModuleForeign)
            {
            	System.out.println("---- FOREIGN");
                net.rim.tools.compiler.codfile.ModuleForeign au1 = (net.rim.tools.compiler.codfile.ModuleForeign)_module;
                _classDef = new net.rim.tools.compiler.codfile.l(k1, _module, _packageName, _className);
                au1._ifuvV(_classDef, z_hjI);
            } else
            if(_module instanceof net.rim.tools.compiler.codfile.ModuleNull)
            {
            	System.out.println("---- NULL");
                _classDef = new net.rim.tools.compiler.codfile.ClassDefNull(k1, _packageName, _className);
                _classDef.setModule(_module);
            }
    }

    private void _bgvV()
    {
        synchronized(f_classRefNameStringBuffer)
        {
            f_classRefNameStringBuffer.setLength(0);
            f_classRefNameStringBuffer.append("classref_");
            f_classRefNameStringBuffer.append(++z_hkI);
            f_classRefNameStringBuffer.append(":");
            if(_packageName != null)
            {
                String s = _packageName.getString();
                if(s != null && s.length() > 0)
                {
                    f_classRefNameStringBuffer.append(s);
                    f_classRefNameStringBuffer.append(".");
                }
            }
            if(_className != null)
            {
                String s1 = _className.getString();
                if(s1 != null && s1.length() > 0)
                    f_classRefNameStringBuffer.append(s1);
            }
            super._nameS = f_classRefNameStringBuffer.toString();
        }
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        c1.empty_func10(super._nameS, ' ');
        c1.writeShort(_module.getOrdinal());
        _packageName.writeOffset(c1);
        _className.writeOffset(c1);
        c1.writeByte(0);
        if((_classDef instanceof net.rim.tools.compiler.codfile.ClassDefDomestic) || (_classDef instanceof net.rim.tools.compiler.codfile.l))
            c1.writeByte(_classDef.getOrdinal());
        else
            c1.writeByte(0);
        setExtent(c1);
    }

    public int getModuleNum()
    {
        return _module.getOrdinal();
    }

    public net.rim.tools.compiler.codfile.Module getModuleName()
    {
        return _module;
    }

    public net.rim.tools.compiler.codfile.Identifier getPackageName()
    {
        return _packageName;
    }

    public net.rim.tools.compiler.codfile.Identifier getClassName()
    {
        return _className;
    }

    public void setClassDef(net.rim.tools.compiler.codfile.ClassDef u1)
    {
        _classDef = u1;
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef()
    {
        return _classDef;
    }

    public int _bkvI()
    {
        return z_hnI;
    }

    public int _bdvI()
    {
        return z_hjI;
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.ClassRef at1 = (net.rim.tools.compiler.codfile.ClassRef)obj;
        return getModuleNum() - at1.getModuleNum();
    }

}
