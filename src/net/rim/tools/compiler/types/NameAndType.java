// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_l;
import net.rim.tools.compiler.a.cls_p;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.exec.g;
import net.rim.tools.compiler.codfile.Member;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            n, a, g, m

public class NameAndType
implements net.rim.tools.compiler.vm.Constants
{

    net.rim.tools.compiler.a.cls_l z_rGl;
    String _name;
    net.rim.tools.compiler.types.Type _type;
    net.rim.tools.compiler.types.ClassType _classType;
    int _modifiers;
    int _offset;
    private net.rim.tools.compiler.codfile.Member f_Member[];
    public static final int z_a9I = -1;

    public NameAndType(String s, net.rim.tools.compiler.types.Type a1, net.rim.tools.compiler.types.ClassType g1, int i, int j)
    {
        _name = s;
        _type = a1;
        _classType = g1;
        _modifiers = i;
        _offset = j;
    }

    public final void setName(String __name)
    {
        _name = __name;
    }

    public final String getName()
    {
        return _name;
    }

    public final void setType(net.rim.tools.compiler.types.Type __type)
    {
        _type = __type;
    }

    public final net.rim.tools.compiler.types.Type getType()
    {
        return _type;
    }

    public final net.rim.tools.compiler.types.ClassType getClassType()
    {
        return _classType;
    }

    public void _longCompilerV(Compiler compiler)
        throws CompileException
    {
        g g1 = compiler._fvg();
        if(!is(512))
        {
            g1._gotoIV(Modifier._cnII(_modifiers));
            if(_type != null)
                g1._byteStringV(_type.getFullName());
            else
                g1._byteStringV("void");
            g1._byteStringV(_name);
        }
    }

    boolean _gotoCompilerZ(Compiler compiler)
    {
        if(is(0x8200000))
            return false;
        return is(512) || !is(384) && compiler.isOptimizePackage();
    }

    final net.rim.tools.compiler.codfile.Member getMember(int i, int j)
    {
        if(f_Member == null)
            f_Member = new Member[j];
        return f_Member[i];
    }

    final net.rim.tools.compiler.codfile.Member setMember(net.rim.tools.compiler.codfile.Member r1, int i)
    {
        f_Member[i] = r1;
        return r1;
    }

    public net.rim.tools.compiler.codfile.Member _ifCompilerr(Compiler compiler, net.rim.tools.compiler.types.TypeModule m)
	throws net.rim.tools.compiler.util.CompileException
    {
        throw new net.rim.tools.compiler.util.CompileException("no member associated with variable: " + _name);
    }

    public final int getSize()
    {
        return _type.getSize();
    }

    public final void setOffset(int __offset)
    {
        _offset = __offset;
    }

    public final boolean hasOffset()
    {
        return _offset != -1;
    }

    public final int getOffset()
    {
        return _offset;
    }

    public int getAbsoluteOffset()
    {
        return _offset;
    }

    public final void addModifiers(int __modifier)
    {
        _modifiers |= __modifier;
    }

    public final void clearModifiers(int __modifier)
    {
        _modifiers &= ~__modifier;
    }

    public final int getModifiers()
    {
        return _modifiers;
    }

    public final boolean is(int __modifier)
    {
        return (__modifier & _modifiers) != 0;
    }

    public boolean isAnd(int __modifier)
    {
        return (__modifier & _modifiers) == __modifier;
    }

    public net.rim.tools.compiler.a.cls_p get_NULL(net.rim.tools.compiler.a.cls_f f, net.rim.tools.compiler.types.TypeModule m)
    {
        return null;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.types.NameAndType)
        {
            net.rim.tools.compiler.types.NameAndType k1 = (net.rim.tools.compiler.types.NameAndType)obj;
            if(this == k1)
                return true;
            if(!_name.equals(k1.getName()))
                return false;
            if(_type != k1.getType())
                return false;
            int i = _modifiers ^ k1._modifiers;
            return (i & 0x10001e) == 0;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return _name.hashCode() * 31 + _type.getFullName().hashCode();
    }
}
