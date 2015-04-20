// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_i;
import net.rim.tools.compiler.a.cls_p;
import net.rim.tools.compiler.exec.g;
import net.rim.tools.compiler.codfile.FieldDefLocal;
import net.rim.tools.compiler.codfile.FieldDefDomestic;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.Member;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.analysis.InstructionResolver;

// Referenced classes of package net.rim.tools.compiler.h:
//            k, f, g, b,
//            m, a, n

public final class Field extends net.rim.tools.compiler.types.NameAndType
{

    private net.rim.tools.compiler.types.Constant z_r7f;
    private boolean z_r6Z;

    public Field(String param_Name, net.rim.tools.compiler.types.Type a1, net.rim.tools.compiler.types.ClassType g1, int l, int param_Attributes, net.rim.tools.compiler.types.Constant f1)
    {
        super(param_Name, a1, g1, l, param_Attributes);
        z_r7f = f1;
    }

    public boolean _f1vZ()
    {
        return z_r7f != null;
    }

    public long _f5vJ()
    {
        return z_r7f.getValue();
    }

    public String _f2vString()
    {
        return z_r7f.getString();
    }

    public void _fZvV()
    {
        z_r6Z = true;
    }

    public boolean _f0vZ()
    {
        return z_r6Z;
    }

    public void _iZV(boolean flag)
    {
        addModifiers(flag ? 0x10000000 : 0x1000000);
    }

    public boolean _f4vZ()
    {
        return (super._modifiers & 0x11000000) == 0x11000000;
    }

    public void _f3vV()
    {
        if(!is(0x20000) && !hasOffset() && is(2))
            super._offset = super._classType._foraI(super._type);
    }

    public int getAbsoluteOffset()
    {
        int l = -1;
        if(!is(0x20000))
        {
            if(super._classType.hasAttribute(0x840000) && hasOffset() && is(4))
                l = super._classType._fjvI() + super._offset;
        } else
        if(is(0x40000))
            if(is(2))
                l = super._offset;
            else
                l = super._classType._fjvI() + super._offset;
        return l;
    }

    public void _longCompilerV(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.exec.g g1 = compiler._fvg();
        if(_f1vZ() && !is(512))
        {
            g1.append("= ");
            if(z_r7f.isString())
                g1._byteStringV(z_r7f.getString());
            else
                g1._byteStringV(Long.toString(z_r7f.getValue()));
        }
        if(is(4))
        {
            net.rim.tools.compiler.codfile.FieldDefLocal ab1 = (net.rim.tools.compiler.codfile.FieldDefLocal)_ifCompilerr(compiler, super._classType.getTypeModule());
            ab1.setAddress(getAbsoluteOffset());
        } else
        if(hasOffset())
        {
            net.rim.tools.compiler.types.TypeModule m1 = super._classType.getTypeModule();
            net.rim.tools.compiler.codfile.FieldDefLocal ab2 = (net.rim.tools.compiler.codfile.FieldDefLocal)_ifCompilerr(compiler, m1);
            int l = super._offset;
            ab2.setAddress(l);
            if(_f1vZ())
            {
                net.rim.tools.compiler.codfile.DataSection k1 = m1.getDataSection();
                if(z_r7f.isString())
                {
                    String s = z_r7f.getString();
                    k1.addInitializedStaticDataString(l, s, InstructionResolver._CStringZ(s));
                } else
                {
                    k1.addInitializedStaticData(l, z_r7f.getValue(), super._type.getLocalCount());
                }
            }
        }
    }

    public net.rim.tools.compiler.codfile.Member _ifCompilerr(Compiler compiler, net.rim.tools.compiler.types.TypeModule m1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int l = m1.getOrdinal();
        net.rim.tools.compiler.codfile.Member r = getMember(l, m1.getCount());
        if(r == null)
        {
            boolean flag = false;
            flag = _gotoCompilerZ(compiler);
            net.rim.tools.compiler.codfile.ClassDef u1 = super._classType.getClassDef(m1);
            net.rim.tools.compiler.codfile.TypeList p1 = net.rim.tools.compiler.types.Type.getTypeList(m1, super._type);
            net.rim.tools.compiler.codfile.DataSection k1 = m1.getDataSection();
            boolean flag1 = is(2);
            net.rim.tools.compiler.codfile.FieldDef w = u1.makeFieldDef(k1, super._name, flag, p1, flag1);
            if(!is(0x20000))
            {
                if(w instanceof net.rim.tools.compiler.codfile.FieldDefDomestic)
                {
                    net.rim.tools.compiler.codfile.FieldDefDomestic ae1 = (net.rim.tools.compiler.codfile.FieldDefDomestic)w;
                    ae1.setSibling((net.rim.tools.compiler.codfile.FieldDefLocal)_ifCompilerr(compiler, super._classType.getTypeModule()));
                } else
                if(w instanceof net.rim.tools.compiler.codfile.FieldDefLocal)
                {
                    net.rim.tools.compiler.codfile.FieldDefLocal ab1 = (net.rim.tools.compiler.codfile.FieldDefLocal)w;
                    ab1.setAttributes(Modifier.toCodfileRoutineAttribute(super._modifiers));
                }
            } else
            if(is(0x40000))
                w.setAddress(getAbsoluteOffset());
            r = setMember(w, l);
        }
        return r;
    }

    public net.rim.tools.compiler.a.cls_p get_NULL(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_rGl == null)
            if(_f1vZ() && is(2))
            {
                if(z_r7f.isString())
                    super.z_rGl = new net.rim.tools.compiler.a.cls_i(super._name, super._type._afe(f1, m1), net.rim.tools.compiler.types.Modifier.toCodfileClassAttribute(super._modifiers), super._offset, z_r7f.getString());
                else
                    super.z_rGl = new net.rim.tools.compiler.a.cls_i(super._name, super._type._afe(f1, m1), net.rim.tools.compiler.types.Modifier.toCodfileClassAttribute(super._modifiers), super._offset, z_r7f.getValue());
            } else
            {
                super.z_rGl = super.get_NULL(f1, m1);
                super.z_rGl = new net.rim.tools.compiler.a.cls_p(super._name, super._type._afe(f1, m1), net.rim.tools.compiler.types.Modifier.toCodfileClassAttribute(super._modifiers), super._offset);
            }
        return (net.rim.tools.compiler.a.cls_p)super.z_rGl;
    }
}
