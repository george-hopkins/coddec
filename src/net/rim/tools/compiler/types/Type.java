// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.codfile.TypeLists;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.classfile.TypeDescriptor;
import net.rim.tools.compiler.classfile.ConstantPoolClass;
import net.rim.tools.compiler.classfile.AttributeStackMapType;

// Referenced classes of package net.rim.tools.compiler.h:
//            l, e, g, d,
//            i, m, k

public abstract class Type
implements net.rim.tools.compiler.vm.Constants
{

    public static final char z_qKC = 66;
    public static final char z_qJC = 67;
    public static final char z_qFC = 68;
    public static final char z_qMC = 70;
    public static final char z_qLC = 73;
    public static final char z_qHC = 74;
    public static final char z_qRC = 83;
    public static final char z_qBC = 90;
    public static final char z_qAC = 91;
    public static final char z_qGC = 76;
    public static final char z_qNC = 59;
    public static final char z_qEC = 86;
    public static final char z_qQC = 40;
    public static final char z_qDC = 41;
    String _name; //f_typeNameS
    net.rim.tools.compiler.types.ArrayType _arrayType;
    net.rim.tools.compiler.a.cls_e z_qPe;
    private net.rim.tools.compiler.codfile.TypeList z_qOap[];
    private static Vector z_qCVector = new Vector();

    public Type(String __name)
    {
        _name = __name;
    }

    public final String getName()
    {
        return _name;
    }

    public String getFullName()
    {
        return _name;
    }

    public final int getLocalCount()
    {
        return (getSize() + 3) / 4;
    }

    public final boolean isTwoWord()
    {
        return getSize() == 8;
    }

    public net.rim.tools.compiler.types.ArrayType getArrayType()
        throws net.rim.tools.compiler.util.CompileException
    {
        if(_arrayType == null)
            _arrayType = new net.rim.tools.compiler.types.ArrayType(this, 1);
        return _arrayType;
    }

    public abstract int getSize();

    public abstract int getTypeId();

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj instanceof net.rim.tools.compiler.types.Type)
        {
            net.rim.tools.compiler.types.Type a1 = (net.rim.tools.compiler.types.Type)obj;
            return getFullName().equals(a1.getFullName());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return getFullName().hashCode();
    }

    public final boolean _doaZ(net.rim.tools.compiler.types.Type a1)
    {
        if(a1.equals(this))
            return true;
        if(a1 instanceof net.rim.tools.compiler.types.BaseType)
        {
            if(this instanceof net.rim.tools.compiler.types.BaseType)
            {
                int j = a1.getTypeId();
                int i1 = getTypeId();
                if(j == i1)
                    return true;
                switch(j)
                {
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                    switch(i1)
                    {
                    case 1: // '\001'
                    case 2: // '\002'
                    case 3: // '\003'
                    case 4: // '\004'
                    case 5: // '\005'
                        return true;
                    }
                    break;
                }
            }
        } else
        if(a1 instanceof net.rim.tools.compiler.types.ClassType)
        {
            net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)a1;
            if(g1.hasAttribute(2048))
                g1 = g1.getSuperClass();
            if(this instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)this;
                return g2._trygZ(g1);
            }
            if(this instanceof ArrayType)
            {
                if(g1.isProcessed() && g1.getSuperClass() == null)
                    return true;
            } else
            if(this instanceof net.rim.tools.compiler.types.NullType)
                return true;
        } else
        if(a1 instanceof net.rim.tools.compiler.types.ArrayType)
        {
            net.rim.tools.compiler.types.ArrayType l1 = (net.rim.tools.compiler.types.ArrayType)a1;
            if(this instanceof net.rim.tools.compiler.types.ArrayType)
            {
                net.rim.tools.compiler.types.ArrayType l2 = (net.rim.tools.compiler.types.ArrayType)this;
                int j1 = l2.getNesting();
                int k1 = l1.getNesting();
                if(j1 >= k1)
                {
                    net.rim.tools.compiler.types.Type a2 = l1.getMostBaseType();
                    if(j1 > k1)
                    {
                        if(a2 instanceof net.rim.tools.compiler.types.ClassType)
                        {
                            net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)a2;
                            if(g3.getSuperClass() == null)
                                return true;
                        }
                    } else
                    {
                        return l2.getMostBaseType()._doaZ(a2);
                    }
                }
            } else
            if(this instanceof net.rim.tools.compiler.types.NullType)
                return true;
        }
        return false;
    }

    abstract net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m1)
        throws net.rim.tools.compiler.util.CompileException;

    final net.rim.tools.compiler.codfile.TypeList getTypeList(int j, int i1)
    {
        if(z_qOap == null)
            z_qOap = new TypeList[i1];
        return z_qOap[j];
    }

    final void setTypeList(net.rim.tools.compiler.codfile.TypeList p1, int j)
    {
        z_qOap[j] = p1;
    }

    net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1)
        throws net.rim.tools.compiler.util.CompileException
    {
        int j = m1.getOrdinal();
        TypeList p1 = getTypeList(j, m1.getCount());
        if(p1 == null)
        {
            p1 = new TypeList(makeTypeItem(m1));
            setTypeList(p1, j);
        }
        return p1;
    }

    public static final net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1, net.rim.tools.compiler.types.Type a1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(a1 == null)
            return m1.getDataSection().getTypeLists().getEmptyTypeList();
        else
            return a1.getTypeList(m1);
    }

    public static final net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1, net.rim.tools.compiler.types.Type a1, net.rim.tools.compiler.types.NameAndType ak[])
        throws net.rim.tools.compiler.util.CompileException
    {
        TypeList p1 = null;
        synchronized(z_qCVector)
        {
            z_qCVector.setSize(0);
            if(a1 != null)
                z_qCVector.addElement(a1.makeTypeItem(m1));
            if(ak != null)
            {
                int j1 = ak.length;
                for(int j = 0; j < j1; j++)
                {
                    Type a2 = ak[j].getType();
                    TypeItem x2 = a2.makeTypeItem(m1);
                    z_qCVector.addElement(x2);
                    if(a2.isTwoWord() && j < j1 - 1)
                    {
                        Type a3 = ak[j + 1].getType();
                        if(a3.getTypeId() == 10)
                            j++;
                    }
                }

            }
            int k1 = z_qCVector.size();
            for(int i1 = k1 - 1; i1 >= 0; i1--)
            {
                TypeItem x1 = (TypeItem)z_qCVector.elementAt(i1);
                if(x1.getId() != 10)
                    break;
                z_qCVector.setSize(i1);
            }

            p1 = new TypeList(z_qCVector);
            z_qCVector.setSize(0);
        }
        return p1;
    }

    public static final net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1, net.rim.tools.compiler.types.Type a1, net.rim.tools.compiler.types.Type aa[], int j, boolean flag)
        throws net.rim.tools.compiler.util.CompileException
    {
        TypeList p1 = null;
        synchronized(z_qCVector)
        {
            z_qCVector.setSize(0);
            if(a1 != null)
                z_qCVector.addElement(a1.makeTypeItem(m1));
            for(int i1 = 0; i1 < j; i1++)
            {
                Type a2 = aa[i1];
                TypeItem x1 = a2.makeTypeItem(m1);
                z_qCVector.addElement(x1);
                if(a2.isTwoWord() && i1 < j - 1)
                {
                    Type a3 = aa[i1 + 1];
                    if(a3.getTypeId() == 10)
                        i1++;
                }
            }

            if(flag)
            {
                int j1 = z_qCVector.size();
                for(int k1 = j1 - 1; k1 >= 0; k1--)
                {
                    TypeItem x2 = (TypeItem)z_qCVector.elementAt(k1);
                    if(x2.getId() != 10)
                        break;
                    z_qCVector.setSize(k1);
                }

            }
            p1 = new TypeList(z_qCVector);
            z_qCVector.setSize(0);
        }
        return p1;
    }

    public static final net.rim.tools.compiler.types.Type translateType(Compiler compiler, net.rim.tools.compiler.classfile.TypeDescriptor __utf8)
        throws net.rim.tools.compiler.util.CompileException
    {
        Object obj = null;
        int j;
        for(j = 0; __utf8.hasChar('['); j++);
        char _char_ = __utf8.getChar();
        switch(_char_)
        {
        case 66: // 'B'
            obj = compiler.getByteType();
            break;

        case 67: // 'C'
            obj = compiler.getCharType();
            break;

        case 68: // 'D'
            obj = compiler.getDoubleType();
            break;

        case 70: // 'F'
            obj = compiler.getFloatType();
            break;

        case 73: // 'I'
            obj = compiler.getIntType();
            break;

        case 74: // 'J'
            obj = compiler.getLongType();
            break;

        case 83: // 'S'
            obj = compiler.getShortType();
            break;

        case 90: // 'Z'
            obj = compiler.getBooleanType();
            break;

        case 76: // 'L'
            obj = compiler.parseClass(__utf8._dovString());
            break;

        case 69: // 'E'
        case 71: // 'G'
        case 72: // 'H'
        case 75: // 'K'
        case 77: // 'M'
        case 78: // 'N'
        case 79: // 'O'
        case 80: // 'P'
        case 81: // 'Q'
        case 82: // 'R'
        case 84: // 'T'
        case 85: // 'U'
        case 87: // 'W'
        case 88: // 'X'
        case 89: // 'Y'
        default:
            throw new net.rim.tools.compiler.util.CompileException("bad TypeDescriptor parse: '" + _char_ + "' in " + __utf8.getString());

        case 86: // 'V'
            break;
        }
        if(obj != null)
            for(; j > 0; j--)
                obj = ((net.rim.tools.compiler.types.Type) (obj)).getArrayType();

        return ((net.rim.tools.compiler.types.Type) (obj));
    }

    public static final void translateTypes(Compiler compiler, net.rim.tools.compiler.classfile.TypeDescriptor d1, Vector vector)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(d1.hasChar('('))
            for(; !d1.hasChar(')'); vector.addElement(translateType(compiler, d1)));
    }

    public static final net.rim.tools.compiler.types.Type _aCompilerva(Compiler compiler, int j)
    {
        Type a1 = null;
        switch(j)
        {
        case 1: // '\001'
            a1 = compiler.getBooleanType();
            break;

        case 2: // '\002'
            a1 = compiler.getByteType();
            break;

        case 3: // '\003'
            a1 = compiler.getCharType();
            break;

        case 4: // '\004'
            a1 = compiler.getShortType();
            break;

        case 5: // '\005'
            a1 = compiler.getIntType();
            break;

        case 6: // '\006'
            a1 = compiler.getLongType();
            break;

        case 11: // '\013'
            a1 = compiler.getFloatType();
            break;

        case 12: // '\f'
            a1 = compiler.getDoubleType();
            break;

        case 10: // '\n'
            a1 = compiler.getVoidType();
            break;
        }
        return a1;
    }

    public static final net.rim.tools.compiler.types.Type translateType(Compiler compiler, net.rim.tools.compiler.codfile.TypeItem x1)
        throws net.rim.tools.compiler.util.CompileException
    {
        if(x1 == null)
            return null;
        Object obj = null;
        int j = 0;
        int i1 = x1.getId();
        switch(i1)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
            obj = _aCompilerva(compiler, i1);
            break;

        case 8: // '\b'
            j = x1._bzvI();
            i1 = x1._bAvI();
            if(i1 != 7 && i1 != 9)
            {
                obj = _aCompilerva(compiler, i1);
                break;
            }
            // fall through

        case 7: // '\007'
        case 9: // '\t'
            obj = compiler.parseClass(x1.getClassDef().get_name_2());
            break;

        default:
            throw new net.rim.tools.compiler.util.CompileException("unexpected type id: 0x" + Integer.toHexString(i1));
        }
        if(obj != null)
            for(; j > 0; j--)
                obj = ((Type) (obj)).getArrayType();

        return ((Type) (obj));
    }

    public static final void translateTypes(Compiler compiler, net.rim.tools.compiler.codfile.TypeList p1, Vector vector)
        throws net.rim.tools.compiler.util.CompileException
    {
        int j = p1.length();
        for(int i1 = 0; i1 < j; i1++)
        {
            Type a1 = translateType(compiler, p1.get_type(i1));
            vector.addElement(a1);
        }

    }

    public final String _e6vString()
        throws net.rim.tools.compiler.util.CompileException
    {
        Type a1 = this;
        StringBuffer stringbuffer = new StringBuffer();
label0:
        do
        {
            int j = a1.getTypeId();
            switch(j)
            {
            case 1: // '\001'
                stringbuffer.append('Z');
                break label0;

            case 2: // '\002'
                stringbuffer.append('B');
                break label0;

            case 3: // '\003'
                stringbuffer.append('C');
                break label0;

            case 4: // '\004'
                stringbuffer.append('S');
                break label0;

            case 5: // '\005'
                stringbuffer.append('I');
                break label0;

            case 6: // '\006'
                stringbuffer.append('J');
                break label0;

            case 11: // '\013'
                stringbuffer.append('F');
                break label0;

            case 12: // '\f'
                stringbuffer.append('D');
                break label0;

            case 10: // '\n'
                stringbuffer.append('V');
                break label0;

            case 8: // '\b'
                stringbuffer.append('[');
                a1 = ((ArrayType)a1).getBaseType();
                break;

            case 7: // '\007'
            case 9: // '\t'
                stringbuffer.append('L');
                stringbuffer.append(getFullName());
                stringbuffer.append(';');
                break label0;

            default:
                throw new net.rim.tools.compiler.util.CompileException("unexpected type id: 0x" + Integer.toHexString(j));
            }
        } while(true);
        return stringbuffer.toString();
    }

    private static final net.rim.tools.compiler.types.Type _aCompilera(Compiler compiler, net.rim.tools.compiler.types.ClassType g1, AttributeStackMapType f1, byte abyte0[])
        throws net.rim.tools.compiler.util.CompileException
    {
        Object obj = null;
        Object obj1 = null;
        switch(f1.getType())
        {
        default:
            break;

        case 0: // '\0'
            obj = compiler.getVoidType();
            break;

        case 2: // '\002'
            obj = compiler.getFloatType();
            break;

        case 1: // '\001'
            obj = compiler.getIntType();
            break;

        case 3: // '\003'
            obj = compiler.getDoubleType();
            break;

        case 4: // '\004'
            obj = compiler.getLongType();
            break;

        case 5: // '\005'
            obj = compiler.getNullType();
            break;

        case 6: // '\006'
            g1._aCompilervV(compiler, true);
            obj = new ClassUninitializedType(g1, 0);
            break;

        case 7: // '\007'
            String s = f1.getTypeName();
            if(s.charAt(0) == '[')
            {
                obj = translateType(compiler, new TypeDescriptor(s));
            } else
            {
                g1 = compiler.parseClass(s.replace('/', '.'));
                g1._aCompilervV(compiler, true);
                obj = g1;
            }
            break;

        case 8: // '\b'
            int j = f1.getNewOffset();
            int i1 = abyte0[j + 1] << 8 | abyte0[j + 2] & 0xff;
            String s1;
            try
            {
                ConstantPoolClass e1 = f1.getNewClass(i1);
                s1 = e1.getName();
            }
            catch(IOException ioexception)
            {
                throw new net.rim.tools.compiler.util.CompileException(ioexception.getMessage());
            }
            g1 = compiler.parseClass(s1);
            g1._aCompilervV(compiler, true);
            obj = new ClassUninitializedType(g1, j, true);
            break;
        }
        return ((Type) (obj));
    }

    public static final void _aCompilerIV(Compiler compiler, net.rim.tools.compiler.types.ClassType g1, int j, net.rim.tools.compiler.classfile.AttributeStackMap k1, byte abyte0[])
        throws net.rim.tools.compiler.util.CompileException
    {
        Type a1 = compiler.getVoidType();
        AttributeStackMapType af[] = k1._avaf();
        int j2 = af != null ? af.length : 0;
        AttributeStackMapType af1[] = k1._ifvaf();
        int k2 = af1 != null ? af1.length : 0;
        int l2 = 0;
        for(int i1 = 0; i1 < j2; i1++)
        {
            l2++;
            int i3 = af[i1].getType();
            if(i3 == 4 || i3 == 3)
                l2++;
        }

        if(l2 < j)
            l2 = j;
        for(int j1 = 0; j1 < k2; j1++)
        {
            l2++;
            int j3 = af1[j1].getType();
            if(j3 == 4 || j3 == 3)
                l2++;
        }

        Type aa[] = new Type[l2];
        int k3 = 0;
        for(int l1 = 0; l1 < j2; l1++)
        {
            Type a2 = _aCompilera(compiler, g1, af[l1], abyte0);
            aa[k3++] = a2;
            if(a2.isTwoWord())
                aa[k3++] = a1;
        }

        while(k3 < j)
            aa[k3++] = a1;
        for(int i2 = 0; i2 < k2; i2++)
        {
            Type a3 = _aCompilera(compiler, g1, af1[i2], abyte0);
            aa[k3++] = a3;
            if(a3.isTwoWord())
                aa[k3++] = a1;
        }

        k1._aaaV(aa);
    }

    public abstract net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1);

}
