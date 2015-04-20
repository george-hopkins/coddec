// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, m, av, o,
//            w, k, a1, ak,
//            r, p, af, at,
//            a5, n

public abstract class ClassDef extends net.rim.tools.compiler.codfile.CodfileItem
{

    protected boolean _siblingFormat;
    protected net.rim.tools.compiler.codfile.Module _module;
    protected net.rim.tools.compiler.codfile.Identifier _packageName;
    protected net.rim.tools.compiler.codfile.Identifier _className;
    protected net.rim.tools.compiler.codfile.CodfileArray _fieldDefs;
    protected net.rim.tools.compiler.codfile.CodfileArray _staticFieldDefs;
    protected net.rim.tools.compiler.codfile.ClassRef _classRef;
    protected net.rim.tools.compiler.codfile.Routine _nullRoutine;
    private static StringBuffer _stringBuffer = new StringBuffer();
    protected net.rim.tools.compiler.codfile.FieldDef _nullFieldDef;

    private void init(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        _nullRoutine = new net.rim.tools.compiler.codfile.RoutineNull(this, __dataSection);
        super._nameS = "";
        _nullFieldDef = new net.rim.tools.compiler.codfile.FieldNull(this, false);
        _siblingFormat = __dataSection.getAliasesFlag();
    }

    protected ClassDef(net.rim.tools.compiler.codfile.DataSection __dataSection, String __packageName, String __className)
    {
        init(__dataSection);
        net.rim.tools.compiler.codfile.DataBytes _DataBytes_ = __dataSection.getDataBytes();
        _packageName = _DataBytes_.getIdentifier(__packageName);
        _className = _DataBytes_.getIdentifier(__className);
        setName(__packageName, __className);
    }

    public ClassDef(net.rim.tools.compiler.codfile.DataSection __dataSection, int param_Offset)
    {
        super(param_Offset);
        init(__dataSection);
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
    }

    protected net.rim.tools.compiler.codfile.CodfileOffset getFixupRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        return null;
    }

    public void writeModuleOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        _module.writeOrdinal(c);
    }

    public abstract void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException;

    public abstract void writeRelativeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException;

    public abstract void writeAbsoluteClassDef(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException;

    public void writeFixups(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        int i = getNumFieldDefs(false);
        for(int j = 0; j < i; j++)
        {
            FieldDef _fieldDef_ = getFieldDef(j, false);
            _fieldDef_.writeFixups(__dataSection);
        }

        i = getNumFieldDefs(true);
        for(int l = 0; l < i; l++)
        {
            net.rim.tools.compiler.codfile.FieldDef _fieldDef_ = getFieldDef(l, true);
            _fieldDef_.writeFixups(__dataSection);
        }

    }

    public void setModule(net.rim.tools.compiler.codfile.Module af)
    {
        _module = af;
    }

    public net.rim.tools.compiler.codfile.Module getModule()
    {
        return _module;
    }

    public void setPackageName(net.rim.tools.compiler.codfile.Identifier __identifier)
    {
        _packageName = __identifier;
    }

    public net.rim.tools.compiler.codfile.Identifier getPackageName()
    {
        return _packageName;
    }

    public String getPackageNameString()
    {
        return _packageName.getString();
    }

    public void setClassName(net.rim.tools.compiler.codfile.Identifier __identifier)
    {
        _className = __identifier;
    }

    public net.rim.tools.compiler.codfile.Identifier getClassName()
    {
        return _className;
    }

    public String getClassNameString()
    {
        return _className.getString();
    }

    protected void setName(String __packageName, String __className)
    {
        synchronized(_stringBuffer)
        {
            _stringBuffer.setLength(0);
            if(__packageName != null && __packageName.length() > 0)
            {
                _stringBuffer.append(__packageName);
                _stringBuffer.append(".");
            }
            _stringBuffer.append(__className);
            super._nameS = _stringBuffer.toString();
        }
    }

    public int getLibOff()
    {
        return 1;
    }

    public net.rim.tools.compiler.codfile.ClassRef getClassRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(_classRef == null)
            _classRef = k1.makeClassRef(this);
        return _classRef;
    }

    public abstract net.rim.tools.compiler.codfile.Routine createRoutine(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2);

    public abstract net.rim.tools.compiler.codfile.Routine makeRoutine(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p1, net.rim.tools.compiler.codfile.TypeList p2);

    public net.rim.tools.compiler.codfile.Routine getNullRoutine()
    {
        return _nullRoutine;
    }

    public void allocateFieldDefs(int i, boolean __isStatic)
    {
        if(__isStatic)
        {
            _staticFieldDefs = new net.rim.tools.compiler.codfile.CodfileArray(i);
            _staticFieldDefs.setName("static field definitions");
        } else
        {
            _fieldDefs = new net.rim.tools.compiler.codfile.CodfileArray(i);
            _fieldDefs.setName("field definitions");
        }
    }

    public void addFieldDef(net.rim.tools.compiler.codfile.FieldDef w1, boolean flag)
    {
        net.rim.tools.compiler.codfile.CodfileArray o1 = null;
        if(flag)
        {
            if(_staticFieldDefs == null)
                allocateFieldDefs(1, flag);
            o1 = _staticFieldDefs;
        } else
        {
            if(_fieldDefs == null)
                allocateFieldDefs(1, flag);
            o1 = _fieldDefs;
        }
        int i = o1.getExtent();
        w1.setOrdinal(i);
        o1.addItem(w1);
    }

    public int getNumFieldDefs(boolean __isStatic)
    {
        net.rim.tools.compiler.codfile.CodfileArray _array_ = null;
        if(__isStatic)
            _array_ = _staticFieldDefs;
        else
            _array_ = _fieldDefs;
        if(_array_ != null)
            return _array_.getExtent();
        else
            return 0;
    }

    public net.rim.tools.compiler.codfile.FieldDef getFieldDef(int __index, boolean __isStatic)
    {
        net.rim.tools.compiler.codfile.CodfileArray _array_ = null;
        if(__isStatic)
            _array_ = _staticFieldDefs;
        else
            _array_ = _fieldDefs;
        return (net.rim.tools.compiler.codfile.FieldDef)_array_.getItem(__index);
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(int __offset, boolean __isStatic)
    {
        if(__offset <= -1 || __offset == 65535)
            return _nullFieldDef;
        if(__isStatic)
        {
            if(_staticFieldDefs != null)
            {
                int j = _staticFieldDefs.getExtent();
                for(int l = 0; l < j; l++)
                {
                    net.rim.tools.compiler.codfile.FieldDef w1 = (net.rim.tools.compiler.codfile.FieldDef)_staticFieldDefs.getItem(l);
                    if(__offset == w1.getAddress())
                        return w1;
                }

            }
        } else
        if(_fieldDefs != null && __offset < _fieldDefs.getExtent())
            return (net.rim.tools.compiler.codfile.FieldDef)_fieldDefs.getItem(__offset);
        return null;
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, boolean param_flagStatic)
    {
        net.rim.tools.compiler.codfile.CodfileArray o1 = null;
        if(param_flagStatic)
            o1 = _staticFieldDefs;
        else
            o1 = _fieldDefs;
        if(o1 != null)
        {
            int i = o1.getExtent();
            for(int j = 0; j < i; j++)
            {
                net.rim.tools.compiler.codfile.FieldDef w1 = (net.rim.tools.compiler.codfile.FieldDef)o1.getItem(j);
                if(ak1.equals(w1.getName()) && p1.equals(w1.getTypeList()))
                    return w1;
            }

        }
        return null;
    }

    public abstract net.rim.tools.compiler.codfile.FieldDef createFieldDef(net.rim.tools.compiler.codfile.Identifier ak1, net.rim.tools.compiler.codfile.TypeList p1, boolean flag);

    public abstract net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p1, boolean flag1);

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.codfile.ClassDef)
        {
            net.rim.tools.compiler.codfile.ClassDef u1 = (net.rim.tools.compiler.codfile.ClassDef)obj;
            if(this == u1)
                return true;
            else
                return getClassNameString().equals(u1.getClassNameString()) && getPackageNameString().equals(u1.getPackageNameString());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return _className.hashCode() * 31 + _packageName.hashCode();
    }

}
