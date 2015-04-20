// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.a.cls_e;
import net.rim.tools.compiler.a.cls_f;
import net.rim.tools.compiler.a.cls_k;
import net.rim.tools.compiler.codfile.Routine;
import net.rim.tools.compiler.codfile.Codfile;
import net.rim.tools.compiler.codfile.FieldDefLocal;
import net.rim.tools.compiler.codfile.ClassDefDomestic;
import net.rim.tools.compiler.codfile.Module;
import net.rim.tools.compiler.codfile.Identifier;
import net.rim.tools.compiler.codfile.CodfileItem;
import net.rim.tools.compiler.codfile.ClassDefLocal;
import net.rim.tools.compiler.codfile.l;
import net.rim.tools.compiler.codfile.TypeList;
import net.rim.tools.compiler.codfile.Member;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.codfile.FieldDef;
import net.rim.tools.compiler.codfile.TypeItem;
import net.rim.tools.compiler.codfile.RoutineLocal;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.util.DuplicateException;

// Referenced classes of package net.rim.tools.compiler.h:
//            b, h, c, a,
//            l, j, m, k,
//            n, f

public final class ClassType extends net.rim.tools.compiler.types.ReferenceType
{


    private static StringBuffer z_rcStringBuffer = new StringBuffer();
    private static Vector z_q0Vector = new Vector();
    private static final int z_rbI = 2;
    private net.rim.tools.compiler.types.ClassType _superClass;
    private net.rim.tools.compiler.types.ClassType _interfaces[];
    private Vector z_rlVector;
    private Vector z_rkVector;
    private boolean z_rmaZ[];
    private net.rim.tools.compiler.types.Field _fields[];
    private int z_riI;
    private net.rim.tools.compiler.types.Method _methods[];
    private int z_q7I;
    private int z_q1I;
    private int z_q6I;
    private int _staticDataSize;
    private int z_qVI;
    private int _codeWeight;  // codeWeight
    private int _dataWeight;  // dataWeight
    private int _vtableWeight; // vtableWeight
    private int _fieldWeight; // fieldWeight
    private String _packageNameString;
    private String _fullNameString;
    private int _attribute;
    private boolean _isProcessed;
    private boolean z_rgZ;
    private int z_rtI;
    private int z_rsI;
    private int _secureIndex;
    private int z_q8I;
    private boolean z_q9Z;
    private boolean z_rnZ;
    private boolean z_rfZ;
    private Vector z_qWVector;
    private String f_className_nv;
    private net.rim.tools.compiler.codfile.Codfile _codFile;
    private net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal;

    public ClassType(String param_classNameS, String param_packageNameS)
	throws net.rim.tools.compiler.util.CompileException
    {
        super(param_classNameS);
        _packageNameString = param_packageNameS;
        _staticDataSize = 2;
        z_rsI = -1;
        _secureIndex = 255;
        z_q8I = 0;
    }

    public void _bYIV(int i1)
    {
        z_rsI = i1;
    }

    public void _gIIV(int i1, int j1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(!z_q9Z)
        {
            if(i1 < 0 || i1 > 255)
                throw new net.rim.tools.compiler.util.CompileException("Illegal secure index (" + i1 + ") for class: " + getFullName());
            z_q9Z = true;
            _secureIndex = i1;
            z_q8I = j1;
        } else
        if(_secureIndex != i1)
            throw new net.rim.tools.compiler.util.CompileException("Attempt to change secure index from (" + _secureIndex + ") to (" + i1 + ") in class: " + getFullName());
    }

    public boolean _flvZ()
    {
        return z_q9Z;
    }

    public void setTypeModule(net.rim.tools.compiler.types.TypeModule m1)
    {
        super.setTypeModule(m1);
        m1.inc_dataWeight(_dataWeight);
        m1.inc_codeWeight(_codeWeight);
        m1._cfIV(_vtableWeight);
        m1._ckIV(_fieldWeight);
    }

    public String getPackageNameString()
    {
        return _packageNameString;
    }

    public void set_packageName(String __name)
    {
        if(_packageNameString == null || _packageNameString.length() == 0)
        {
            _packageNameString = __name;
            _fullNameString = null;
            getFullName();
        }
    }

    public void set_classAndPackageNames(String param_packageNameS, String param_classNameS)
    {
        super._name = param_classNameS;
        set_packageName(param_packageNameS);
    }

    public String getFullName()
    {
        if(_fullNameString == null)
            if(_packageNameString == null || _packageNameString.length() == 0)
                _fullNameString = super._name;
            else
                _fullNameString = _packageNameString + '.' + super._name;
        return _fullNameString;
    }

    public static String get_packageNamefromString(String s)
    {
        int i1 = s.lastIndexOf('.');
        if(i1 != -1)
            return s.substring(0, i1);
        else
            return null;
    }

    public int getTypeId()
    {
        return 7;
    }

    public int _fjvI()
    {
        return z_q1I;
    }

    public boolean _bZIZ(int i1)
    {
        return i1 >= 0 && i1 < z_rkVector.size();
    }

    public void set_className(String s)
    {
    	System.out.println("SET CLASS NAME TO " + s);
        f_className_nv = s;
    }

    public String get_className()
    {
        return f_className_nv;
    }

    public void set_classFileName(String s)
    {
        f_className_nv = s;
    }

    public void _aaaV(net.rim.tools.compiler.codfile.Codfile __codFile, ClassDefLocal __classDefLocal)
    {
        _codFile = __codFile;
        _classDefLocal = __classDefLocal;
    }

    public final void setAttribute(int param_bbAtributes)
    {
        _attribute |= param_bbAtributes;
    }

    public final void _b1IV(int i1)
    {
        _attribute &= ~i1;
    }

    public void set_superClassRef(net.rim.tools.compiler.types.ClassType g1)
    {
        _superClass = g1;
    }

    public net.rim.tools.compiler.types.ClassType getSuperClass()
    {
        return _superClass;
    }

    private boolean _fnvZ()
    {
        int i1 = super._name.lastIndexOf('$');
        return i1 != -1;
    }

    private boolean _fhvZ()
    {
        int i1 = super._name.indexOf('$');
        if(i1 == -1)
            return false;
        i1 = super._name.indexOf('$', i1 + 1);
        return i1 != -1;
    }

    private boolean _fpvZ()
    {
        int i1 = super._name.lastIndexOf('$');
        if(i1 == -1)
            return false;
        i1++;
        int j1 = super._name.length();
        if(i1 >= j1)
            return false;
        for(; i1 < j1; i1++)
            if(!Character.isDigit(super._name.charAt(i1)))
                return false;

        return true;
    }

    public boolean _trygZ(net.rim.tools.compiler.types.ClassType __class)
    {
        int i1 = 1024;
        for(net.rim.tools.compiler.types.ClassType _class_ = this; _class_ != null && --i1 > 0; _class_ = _class_._superClass)
            if(_class_ == __class)
                return true;

        return false;
    }

    public net.rim.tools.compiler.types.ClassType _elsegg(net.rim.tools.compiler.types.ClassType __class)
    {
        net.rim.tools.compiler.types.ClassType _class_ = this;
        if(_class_.hasAttribute(2048))
            return _class_._superClass;
        if(__class.hasAttribute(2048))
            return __class._superClass;
        net.rim.tools.compiler.types.ClassType g3;
        for(g3 = _class_; g3._superClass != null; g3 = g3._superClass)
            if(__class._trygZ(g3))
                return g3;

        return g3;
    }

    public boolean _newgZ(net.rim.tools.compiler.types.ClassType g1)
    {
        if(z_rlVector != null)
        {
            int i1 = z_rlVector.size();
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)z_rlVector.elementAt(j1);
                if(g1.equals(g2))
                    return true;
            }

        }
        return false;
    }

    private void _intgV(net.rim.tools.compiler.types.ClassType g1)
    {
        if(z_rlVector == null)
            z_rlVector = new Vector();
        if(!_newgZ(g1))
        {
            z_rlVector.addElement(g1);
            if(g1.hasAttribute(0x4000000))
                setAttribute(0x4000000);
        }
    }

    private void _aagV(net.rim.tools.compiler.types.ClassType ag[])
    {
        if(ag != null)
        {
            int i1 = ag.length;
            for(int j1 = 0; j1 < i1; j1++)
                _intgV(ag[j1]);

        }
    }

    private void _intVectorV(Vector vector)
    {
        if(vector != null)
        {
            int i1 = vector.size();
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)vector.elementAt(j1);
                _intgV(g1);
            }

        }
    }

    public void createInterfaces(int __value)
    {
        if(_interfaces == null && __value > 0)
            _interfaces = new net.rim.tools.compiler.types.ClassType[__value];
    }

    public void addInterface(int __index, net.rim.tools.compiler.types.ClassType __class)
    {
        _interfaces[__index] = __class;
    }

    public int _fkvI()
    {
        return z_riI;
    }

    public net.rim.tools.compiler.types.Field getField(int __index)
    {
        return _fields[__index];
    }

    public void createFields(int __value)
    {
        if(__value > 0)
            if(_fields == null)
                _fields = new net.rim.tools.compiler.types.Field[__value];
            else
            if(__value >= _fields.length)
                _fields = net.rim.tools.compiler.exec.MyArrays.resize(_fields, __value);
    }

    public net.rim.tools.compiler.types.Field add_processedField(Compiler __compiler, String __name, net.rim.tools.compiler.types.Type __type, int __attributes, net.rim.tools.compiler.types.Constant __constant)
	throws  net.rim.tools.compiler.util.CompileException
    {
        if(!net.rim.tools.compiler.util.StringHelper._ifStringZ(__name))
            throw new net.rim.tools.compiler.util.CompileException(getFullName(), "Invalid member name: " + __name);
        if(_aCompilerSh(__compiler, __name, __type, false, false) != null)
            throw new net.rim.tools.compiler.util.DuplicateException(getFullName(), __name, super._name);
        if(__name.startsWith("RIM_pragma"))
            __compiler.generateWarning(true, getFullName(), "Improperly declared 'private final static String " + __name + "' detected");
        Object obj = null;
        int j1 = -1;
        boolean flag = !hasAttribute(0x20000);
        if(flag)
        {
            String loc_FQFieldName;
            synchronized(z_rcStringBuffer)
            {
                String s2 = getFullName();
                z_rcStringBuffer.setLength(0);
                z_rcStringBuffer.ensureCapacity(s2.length() + 1 + __name.length());
                z_rcStringBuffer.append(s2);
                z_rcStringBuffer.append('.');
                z_rcStringBuffer.append(__name);
                loc_FQFieldName = z_rcStringBuffer.toString();
            }
            if((__attributes & 2) == 0)
            {
                j1 = z_q6I;
                z_q6I += __type.getLocalCount();
                if(__compiler.checkFieldForExport(loc_FQFieldName, this, z_riI))
                    __attributes |= 0x200000;
            } else
            {
                if((__attributes & 0x40) == 0 || (__attributes & 0x8000000) != 0 || __constant == null)
                    j1 = _foraI(__type);
                if(__compiler.checkStaticDataForExport(loc_FQFieldName, this, z_riI))
                    __attributes |= 0x200000;
            }
        }
        net.rim.tools.compiler.types.Field _field_ = new net.rim.tools.compiler.types.Field(__name, __type, this, __attributes, j1, __constant);
        createFields(z_riI + 1);
        _fields[z_riI++] = _field_;
        if(!_field_.is(0x20000) && (_field_.is(0x8200000) || _field_.is(0x80000) && ((_field_.getModifiers() & 0x380) != 512 || hasAttribute(2048))))
            _field_._iZV(true);
        return _field_;
    }

    public net.rim.tools.compiler.types.Field _aCompilerSh(Compiler compiler, String s, net.rim.tools.compiler.types.Type a1, boolean flag, boolean flag1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = z_riI;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Field h1 = _fields[j1];
            if(h1 != null && h1.getName().equals(s) && h1.getType().equals(a1))
                return h1;
        }

        if(hasAttribute(0x20000) && flag)
        {
            net.rim.tools.compiler.types.Field h2 = compiler._agh(this, a1, s);
            if(h2 != null)
            {
                createFields(z_riI + 1);
                _fields[z_riI++] = h2;
                return h2;
            }
        }
        if(_superClass != null && flag1)
            return _superClass._aCompilerSh(compiler, s, a1, flag, flag1);
        else
            return null;
    }

    public void createMethods(int __value)
    {
        if(_methods == null && __value > 0)
            _methods = new net.rim.tools.compiler.types.Method[__value];
    }

    private net.rim.tools.compiler.types.Method _newcc(net.rim.tools.compiler.types.Method __method)
    {
        String s = __method.getName();
        int i1 = __method.getNumParameters();
        int j1 = z_q7I;
label0:
        for(int k1 = 0; k1 < j1; k1++)
        {
            net.rim.tools.compiler.types.Method c2 = _methods[k1];
            if(!c2.getName().equals(s) || c2.getNumParameters() != i1)
                continue;
            for(int l1 = 0; l1 < i1; l1++)
                if(!c2.getParameterType(l1).equals(__method.getParameterType(l1)))
                    continue label0;

            return c2;
        }

        return null;
    }

    public void _aCompilerV(Compiler __compiler, net.rim.tools.compiler.types.Method __method)
        throws CompileException
    {
        net.rim.tools.compiler.types.Method c2 = _newcc(__method);
        if(c2 != null)
        {
            if(__method.getType() == c2.getType())
                __compiler.generateWarning(false, getFullName(), "Duplicate definition found for method: " + __method.getName());
            else
                __compiler.generateWarning(true, getFullName(), "Duplicate method only differs by return type: " + __method.getName());
            __method.addModifiers(0x8000000);
            c2.addModifiers(0x8000000);
        }
        if(_methods == null)
            createMethods(1);
        else
        if(z_q7I == _methods.length)
            _methods = net.rim.tools.compiler.exec.MyArrays.resize(_methods, z_q7I + 1);
        _methods[z_q7I++] = __method;
        if(!__method.is(0x20000) && __method.isAnd(544))
        {
            __method.addModifiers(0x8000000);
            __compiler.generateWarning(false, getFullName(), "Method is both private and abstract: " + __method._fWvString());
        }
        String s = __method._fWvString();
        if(hasAttribute(2048))
        {
            if(__compiler._aStringZ(s, __method))
                __method.addModifiers(0x200000);
            z_rsI = __method._ccII(z_rsI);
        } else
        if(__method.is(18))
            if(__compiler.checkStaticMethodForExport(s, __method))
                __method.addModifiers(0x200000);
            else
            if(__compiler.isMakingMIDlet() || !s.equals("javax.microedition.midlet.MIDletMain.main(java.lang.String[])"))
            {
                String s1 = __method._fVvString();
                if(__compiler.checkStaticMethodForExport(super._name + s1, __method))
                    __method.addModifiers(0x200000);
                else
                if(__compiler.checkStaticMethodForExport(s1, __method))
                    __method.addModifiers(0x200000);
            }
        if(!__method.is(0x20000) && (__method.is(0x8380000) || __method.is(16) && (__method.getNumParameters() == 0 || __method.is(0x2000000))))
            __method._cCompilerV(__compiler);
    }

    public net.rim.tools.compiler.types.Method _bVIc(int i1)
    {
        int k1 = z_q7I;
        for(int j1 = 0; j1 < k1; j1++)
        {
            net.rim.tools.compiler.types.Method c1 = _methods[j1];
            if(c1._b8IZ(i1))
                return c1;
        }

        return null;
    }

    private net.rim.tools.compiler.types.Method _aStringc(String s, net.rim.tools.compiler.types.Type a1, Vector vector)
    {
        int i1 = z_q7I;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Method c1 = _methods[j1];
            if(c1._ifStringZ(s, a1, vector))
                return c1;
        }

        return null;
    }

    private net.rim.tools.compiler.types.Method _aStringc(String s, net.rim.tools.compiler.types.Type a1, Vector vector, boolean flag)
    {
        net.rim.tools.compiler.types.Method c1 = _aStringc(s, a1, vector);
        if(c1 == null && !flag && hasAttribute(2048) && z_rlVector != null)
        {
            int i1 = z_rlVector.size();
            for(int j1 = 0; j1 < i1 && c1 == null; j1++)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)z_rlVector.elementAt(j1);
                c1 = g1._aStringc(s, a1, vector, flag);
            }

        }
        if(c1 == null && _superClass != null)
            c1 = _superClass._aStringc(s, a1, vector, flag);
        return c1;
    }

    public net.rim.tools.compiler.types.Method _aCompilerSac(Compiler compiler, String s, net.rim.tools.compiler.types.Type a1, Vector vector, boolean flag, boolean flag1)
        throws CompileException
    {
        net.rim.tools.compiler.types.Method c1 = null;
        if(flag1)
            c1 = _aStringc(s, a1, vector, flag);
        else
            c1 = _aStringc(s, a1, vector);
        return c1;
    }

    public void addInnerClass(InnerClassType j1)
    {
        if(z_qWVector == null)
            z_qWVector = new Vector();
        z_qWVector.addElement(j1);
    }

    public void _aCompilervV(Compiler compiler, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(!hasAttribute(0x10000000))
        {
            setAttribute(0x10000000);
            compiler.referenceClass(this);
        }
        if(flag && !z_rnZ)
        {
            z_rnZ = flag;
            if(hasAttribute(0x20000000) && hasAttribute(0x20000) && _secureIndex != 255)
                super._module._aCompilerV(compiler, this, _secureIndex);
        }
    }

    public void set_FlagProcessed()
    {
        _isProcessed = true;
    }

    public boolean isProcessed()
    {
        return _isProcessed;
    }

    public boolean hasAttribute(int __attribute)
    {
        return (__attribute & _attribute) != 0;
    }

    public boolean _bRIZ(int i1)
    {
        return (i1 & _attribute) == i1;
    }

    public int _foraI(net.rim.tools.compiler.types.Type a1)
    {
        int i1 = _staticDataSize;
        _staticDataSize += a1.getLocalCount();
        return i1;
    }

    public void _bSIV(int i1)
    {
        if(i1 > z_qVI)
            z_qVI = i1;
    }

    private void _aCompilerV(Compiler compiler, net.rim.tools.compiler.codfile.FieldDefLocal ab1, int i1)
        throws CompileException
    {
        net.rim.tools.compiler.types.Type a1 = net.rim.tools.compiler.types.Type.translateType(compiler, ab1.getTypeList().get_baseType());
        int j1 = a1.getLocalCount();
        String s = ab1.getName().getString();
        if(s == null || s.length() == 0)
        {
            if(i1 == 4)
                z_q6I += j1;
            return;
        }
        i1 |= net.rim.tools.compiler.types.Modifier.translateCodfileAttributes(ab1.getAttributes());
        i1 = compiler.augmentFieldModifiers(this, i1);
        net.rim.tools.compiler.types.Field h1 = add_processedField(compiler, s, a1, i1, null);
        if(h1.is(0x40000))
            if(h1.is(2))
            {
                h1.setOffset(ab1.getAddress());
            } else
            {
                h1.setOffset(z_q6I);
                z_q6I += j1;
            }
    }

    private void _aCompilerV(Compiler compiler, net.rim.tools.compiler.codfile.RoutineLocal z1, boolean flag)
        throws CompileException
    {
        String s = z1.getName().getString();
        if(s == null || s.length() == 0)
            return;
        int i1 = net.rim.tools.compiler.types.Modifier.toCodfileProtectionAttribute(z1.getAttributes());
        i1 = compiler.augmentMethodModifiers(this, i1);
        net.rim.tools.compiler.types.Method c1 = null;
        synchronized(z_q0Vector)
        {
            z_q0Vector.setSize(0);
            net.rim.tools.compiler.types.Type.translateTypes(compiler, z1.getProtoTypeList(), z_q0Vector);
            net.rim.tools.compiler.types.Type a1 = net.rim.tools.compiler.types.Type.translateType(compiler, z1.getTypeList().get_baseType());
            int j1 = 0;
            if((i1 & 2) == 0 || (i1 & 0x10) != 0)
                j1 = 1;
            int k1 = z_q0Vector.size();
            c1 = new net.rim.tools.compiler.types.Method(this, s, a1, k1 - j1, i1);
            c1._hZV(flag);
            for(int l1 = j1; l1 < k1; l1++)
                c1.add_parametersToMethod(l1 - j1, null, (net.rim.tools.compiler.types.Type)z_q0Vector.elementAt(l1));

            z_q0Vector.setSize(0);
        }
        c1._fOvV();
        if((i1 & 0x40000) != 0)
            c1._cbIV(z1.getOffset());
        _aCompilerV(compiler, c1);
    }

    private void _charCompilerV(Compiler compiler)
        throws CompileException
    {
        try
        {
            _codFile._ifiV(_classDefLocal);
        }
        catch(IOException ioexception)
        {
            if(compiler.getTraceback())
                ioexception.printStackTrace();
            throw new CompileException(f_className_nv, "Error reading class definition: " + ioexception.toString());
        }
        z_rtI = _classDefLocal.getOrdinal();
        _secureIndex = _classDefLocal.getSecureIndex();
        if(z_rnZ && _secureIndex != 255)
            super._module._aCompilerV(compiler, this, _secureIndex);
        String s = _classDefLocal.getSuperClass().get_name_2();
        if(s != null && s.length() > 0)
            _superClass = compiler.parseClass(f_className_nv, s);
        int i1 = _classDefLocal.getNumInterfaces();
        createInterfaces(i1);
        for(int j1 = 0; j1 < i1; j1++)
            addInterface(j1, compiler.parseClass(f_className_nv, _classDefLocal.getInterface(j1).get_name_2()));

        int k1 = _classDefLocal.getNumFieldDefs(false);
        int l1 = _classDefLocal.getNumFieldDefs(true);
        createFields(k1 + l1);
        for(int i2 = 0; i2 < k1; i2++)
        {
            net.rim.tools.compiler.codfile.FieldDefLocal ab1 = (net.rim.tools.compiler.codfile.FieldDefLocal)_classDefLocal.getFieldDef(i2, false);
            _aCompilerV(compiler, ab1, 4);
        }

        for(int j2 = 0; j2 < l1; j2++)
        {
            net.rim.tools.compiler.codfile.FieldDefLocal ab2 = (net.rim.tools.compiler.codfile.FieldDefLocal)_classDefLocal.getFieldDef(j2, true);
            _aCompilerV(compiler, ab2, 2);
        }

        int k2 = _classDefLocal.getNumVirtualRoutines();
        int l2 = _classDefLocal.get_nonVirtualRoutinesSize();
        int i3 = _classDefLocal.get_staticRoutinesSize();
        createMethods(k2 + l2 + i3);
        for(int j3 = 0; j3 < k2; j3++)
        {
            net.rim.tools.compiler.codfile.RoutineLocal z1 = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal.getVirtualRoutine(j3);
            _aCompilerV(compiler, z1, true);
        }

        for(int k3 = 0; k3 < l2; k3++)
        {
            net.rim.tools.compiler.codfile.RoutineLocal z2 = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal.get_nonVirtualRoutine(k3);
            _aCompilerV(compiler, z2, false);
        }

        for(int l3 = 0; l3 < i3; l3++)
        {
            net.rim.tools.compiler.codfile.RoutineLocal z3 = (net.rim.tools.compiler.codfile.RoutineLocal)_classDefLocal.getStaticRoutine(l3);
            _aCompilerV(compiler, z3, false);
        }

    }

    public void _elseCompilerV(Compiler compiler)
	throws net.rim.tools.compiler.util.CompileException
    {
        boolean flag = false;
        boolean flag1 = false;
        if(hasAttribute(0x20000000) || !hasAttribute(0x10000000))
            return;
        setAttribute(0x20000000);
        if(!isProcessed())
        {
            compiler.generateWarning(true, getFullName(), "No definition found");
            _classDefLocal = null;
            _codFile = null;
            return;
        }
        if(!net.rim.tools.compiler.util.StringHelper._ifStringZ(super._name))
            throw new net.rim.tools.compiler.util.CompileException(getFullName(), "Invalid class name: " + super._name);
        if(_classDefLocal != null)
        {
            _charCompilerV(compiler);
            _classDefLocal = null;
            _codFile = null;
        }
        if(_superClass == null && this == compiler.getObjectClass() && hasAttribute(0x20000))
        {
            flag1 = true;
            setAttribute(0x40000000);
            z_q1I = 0;
            Vector vector = compiler.getObjectClassVTable();
            z_rkVector = new Vector(vector.size());
            z_rkVector.setSize(vector.size());
            z_rmaZ = new boolean[vector.size()];
            for(int i1 = 0; i1 < z_rmaZ.length; i1++)
                z_rmaZ[i1] = true;

            int i4 = z_q7I;
            for(int j1 = 0; j1 < i4; j1++)
            {
                net.rim.tools.compiler.types.Method c1 = _methods[j1];
                String s = null;
                s = c1._fWvString();
                int j6 = vector.indexOf(s);
                if(j6 != -1)
                {
                    c1.setOffset(j6);
                    z_rkVector.setElementAt(c1, j6);
                }
            }

        } else
        if(_superClass != null)
        {
            _superClass._aCompilervV(compiler, !hasAttribute(0x20000));
            _superClass._elseCompilerV(compiler);
            if(!_superClass.isProcessed())
                setAttribute(0x8000000);
            if(!hasAttribute(2048))
            {
                _superClass.z_rgZ = true;
                _intVectorV(_superClass.z_rlVector);
                z_rkVector = _forVectorVector(_superClass.z_rkVector);
                if(!hasAttribute(0x20000) && compiler.isMakingMIDlet() && _superClass.getFullName().equals("javax.microedition.midlet.MIDlet"))
                {
                    flag = true;
                    compiler.addPotentialMIDlet(this);
                }
            } else
            {
                z_rkVector = new Vector();
            }
        } else
        {
            z_rkVector = new Vector();
        }
        if(_superClass == null)
            z_q1I = 0;
        else
            z_q1I = _superClass.z_q1I + _superClass.z_q6I;
        if(_interfaces != null)
        {
            int i6 = 0;
            int j4 = _interfaces.length;
            for(int k1 = 0; k1 < j4; k1++)
            {
                net.rim.tools.compiler.types.ClassType g2 = _interfaces[k1];
                g2._aCompilervV(compiler, !hasAttribute(0x20000));
                g2._elseCompilerV(compiler);
                _intgV(g2);
                if(g2.hasAttribute(0x400000))
                    setAttribute(0x400000);
                if(!g2.isProcessed())
                {
                    setAttribute(0x8000000);
                    compiler.generateWarning(true, getFullName(), "Implements undefined interface: " + g2.getFullName());
                    _interfaces[k1] = null;
                    i6++;
                }
            }

            if(i6 > 0)
                if(i6 >= j4)
                {
                    _interfaces = null;
                } else
                {
                    net.rim.tools.compiler.types.ClassType ag[] = new net.rim.tools.compiler.types.ClassType[j4 - i6];
                    int k6 = 0;
                    for(int l1 = 0; l1 < j4; l1++)
                    {
                        net.rim.tools.compiler.types.ClassType g6 = _interfaces[l1];
                        if(g6 != null)
                            ag[k6++] = g6;
                    }

                    _interfaces = ag;
                }
        }
        if(z_rlVector != null)
        {
            for(int i2 = 0; i2 < z_rlVector.size(); i2++)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)z_rlVector.elementAt(i2);
                _aagV(g1._interfaces);
            }

        }
        if(!hasAttribute(0x20000))
        {
            boolean flag2 = false;
            if(_superClass == null || _superClass == compiler.getObjectClass() || _superClass.hasAttribute(0x10000))
            {
                flag2 = true;
                if(z_rlVector != null)
                {
                    int k4 = z_rlVector.size();
                    for(int j2 = 0; j2 < k4 && flag2; j2++)
                    {
                        net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)z_rlVector.elementAt(j2);
                        if(!g3.hasAttribute(0x10000))
                            flag2 = false;
                    }

                }
            }
            if(flag2)
                setAttribute(0x10000);
            if(_superClass == null || _superClass == compiler.getObjectClass() || _superClass.hasAttribute(0x800000))
                setAttribute(0x800000);
        }
        if(!flag1)
        {
            if(hasAttribute(0x20000))
            {
                int l4 = z_q7I;
                for(int k2 = 0; k2 < l4; k2++)
                {
                    net.rim.tools.compiler.types.Method c2 = _methods[k2];
                    if(c2._fSvZ())
                        c2._aCompilerV(compiler, z_rkVector);
                }

            } else
            {
                boolean flag3 = false;
                int i5 = z_q7I;
                for(int l2 = 0; l2 < i5; l2++)
                {
                    net.rim.tools.compiler.types.Method c3 = _methods[l2];
                    if(c3._fTvZ())
                        c3._aCompilerV(compiler, z_rkVector);
                    else
                    if(c3.is(16) && c3.getNumParameters() == 0)
                    {
                        flag3 = true;
                        if(flag && !c3.is(128))
                            compiler.generateWarning(false, getFullName(), "Default MIDlet constructor should be public.");
                    }
                }

                if(!flag3)
                {
                    for(int i3 = 0; i3 < i5; i3++)
                    {
                        net.rim.tools.compiler.types.Method c4 = _methods[i3];
                        if(c4.is(16))
                            c4._cCompilerV(compiler);
                    }

                }
                if(hasAttribute(2048))
                {
                    int j5 = z_rkVector.size();
                    for(int j3 = 0; j3 < j5; j3++)
                    {
                        net.rim.tools.compiler.types.Method c5 = (net.rim.tools.compiler.types.Method)z_rkVector.elementAt(j3);
                        c5.setOffset(-1);
                    }

                } else
                if(z_rlVector != null)
                {
                    int k5 = z_rlVector.size();
                    for(int k3 = 0; k3 < k5; k3++)
                    {
                        net.rim.tools.compiler.types.ClassType g4 = (net.rim.tools.compiler.types.ClassType)z_rlVector.elementAt(k3);
                        int i7 = g4.z_q7I;
                        for(int j7 = 0; j7 < i7; j7++)
                        {
                            net.rim.tools.compiler.types.Method c6 = g4._methods[j7];
                            if(!c6.is(0x100000))
                            {
                                int k7 = c6._newVectorI(z_rkVector);
                                net.rim.tools.compiler.types.Method c9 = null;
                                if(k7 != -1)
                                    c9 = (net.rim.tools.compiler.types.Method)z_rkVector.elementAt(k7);
                                else
                                if(hasAttribute(32))
                                {
                                    c9 = compiler._agc(this, c6);
                                    _aCompilerV(compiler, c9);
                                    c9._aCompilerV(compiler, z_rkVector);
                                }
                                if(c9 != null)
                                    c9._ifCompilerV(compiler, c6);
                            }
                        }

                    }

                }
            }
            int l5 = z_riI;
            for(int l3 = 0; l3 < l5; l3++)
            {
                net.rim.tools.compiler.types.Type a1 = _fields[l3].getType();
                if(a1 instanceof net.rim.tools.compiler.types.ArrayType)
                {
                    net.rim.tools.compiler.types.ArrayType l6 = (net.rim.tools.compiler.types.ArrayType)a1;
                    a1 = l6.getMostBaseType();
                }
                if(a1 instanceof net.rim.tools.compiler.types.ClassType)
                {
                    net.rim.tools.compiler.types.ClassType g5 = (net.rim.tools.compiler.types.ClassType)a1;
                    g5._aCompilervV(compiler, !hasAttribute(0x20000));
                    if(!g5.isProcessed())
                        setAttribute(0x8000000);
                }
            }

            if(!compiler._dvZ())
                if(this == compiler.getStringClass())
                {
                    net.rim.tools.compiler.types.Type a2 = compiler.getIntType();
                    Vector vector2 = new Vector(1);
                    net.rim.tools.compiler.types.Method c7 = _aStringc("length", a2, vector2);
                    if(c7 != null)
                        c7._cdIV(1);
                    else
                        compiler.generateWarning(false, getFullName(), "No definition found for method: length()");
                    vector2.addElement(a2);
                    c7 = _aStringc("charAt", compiler.getCharType(), vector2);
                    if(c7 != null)
                        c7._cdIV(2);
                    else
                        compiler.generateWarning(false, getFullName(), "No definition found for method: charAt()");
                    z_rmaZ = new boolean[z_rkVector.size()];
                } else
                if(this == compiler.getStringBufferClass())
                {
                    Vector vector1 = new Vector(1);
                    net.rim.tools.compiler.types.Method c8 = _aStringc("<init>", null, vector1);
                    if(c8 != null)
                        c8._cdIV(3);
                    else
                        compiler.generateWarning(false, getFullName(), "No definition found for default constructor");
                    vector1.addElement(compiler.getStringClass());
                    c8 = _aStringc("<init>", null, vector1);
                    if(c8 != null)
                        c8._cdIV(4);
                    else
                        compiler.generateWarning(false, getFullName(), "No definition found for String constructor");
                    c8 = _aStringc("append", this, vector1);
                    if(c8 != null)
                        c8._cdIV(5);
                    else
                        compiler.generateWarning(false, getFullName(), "No definition found for method: append( String )");
                }
        }
    }

    public boolean[] _fivaZ()
    {
        return z_rmaZ;
    }

    private Vector _forVectorVector(Vector vector)
    {
        int i1 = 0;
        if(vector != null)
            i1 = vector.size();
        Vector vector1 = new Vector(i1);
        vector1.setSize(i1);
        while(--i1 >= 0)
            vector1.setElementAt(vector.elementAt(i1), i1);
        return vector1;
    }

    public void _byteCompilerV(Compiler compiler)
        throws CompileException
    {
        int i3 = 1;
        boolean flag = true;
        _classDefLocal = null;
        _codFile = null;
        if(hasAttribute(0x40000000) || !hasAttribute(0x10000000))
            return;
        setAttribute(0x40000000);
        if(hasAttribute(0x20000) || !isProcessed())
            return;
        _dataWeight += 40;
        int k2 = z_q7I;
        _dataWeight += k2 * 2;
        for(int i1 = 0; i1 < k2; i1++)
        {
            net.rim.tools.compiler.types.Method c1 = _methods[i1];
            _dataWeight += c1.getName().length();
            if(c1.is(1))
                flag = false;
            int j3 = c1._fHvI();
            if(j3 > 0 && (i3 == 1 || i3 > j3))
                i3 = j3;
        }

        if(hasAttribute(0x600000) || compiler._intStringZ(getFullName()))
            flag = false;
        int k3 = 0;
        int l3 = 0;
        net.rim.tools.compiler.types.ClassType g1 = compiler.getStringClass();
        _fieldWeight = 3;
        k2 = z_riI;
        for(int j1 = 0; j1 < k2; j1++)
        {
            net.rim.tools.compiler.types.Field h1 = _fields[j1];
            net.rim.tools.compiler.types.Type a1 = h1.getType();
            boolean flag1 = h1.is(2);
            if(flag1)
            {
                if(h1.hasOffset())
                {
                    _dataWeight += 7;
                    _dataWeight += h1.getName().length();
                }
            } else
            {
                _dataWeight += 5;
                if(a1 instanceof net.rim.tools.compiler.types.ReferenceType)
                    _fieldWeight++;
            }
            if(flag && (h1.getModifiers() & 0x380) == 512 && (!h1.is(64) || a1 != g1) && !h1._f1vZ() && !h1._f4vZ())
            {
                if(!h1.is(0x11000000))
                {
                    h1._fZvV();
                    if(h1.hasOffset())
                    {
                        h1.setOffset(-1);
                        int k4 = a1.getLocalCount();
                        if(flag1)
                        {
                            k3 += k4;
                        } else
                        {
                            l3 += k4;
                            z_q6I -= k4;
                        }
                    }
                    continue;
                }
                String s1 = h1.getName();
                if(h1.is(0x2000000) && (s1.startsWith("this$") || s1.indexOf("$this$") != -1))
                {
                    if(!_fpvZ() && !_fhvZ() && (_superClass == null || !_superClass._fnvZ()))
                        compiler.generateWarning(false, get_className() + ':' + i3, "inner class '" + getFullName() + "' should be declared static");
                } else
                {
                    compiler.generateWarning(!h1.is(64), get_className() + ':' + i3, "member data '" + a1.getName() + ' ' + s1 + "' not required in class: " + getFullName());
                }
            }
            if(h1.hasOffset())
                if(flag1)
                    h1.setOffset(h1.getOffset() - k3);
                else
                    h1.setOffset(h1.getOffset() - l3);
        }

        if(_interfaces != null)
            _dataWeight += _interfaces.length * 2;
        if(hasAttribute(2048))
            return;
        Vector vector;
        if(_superClass != null)
        {
            _fieldWeight += _superClass._ffvI();
            _superClass._byteCompilerV(compiler);
            z_q1I = _superClass.z_q1I + _superClass.z_q6I;
            vector = _forVectorVector(_superClass.z_rkVector);
        } else
        {
            vector = new Vector();
        }
        if(!z_rgZ && !hasAttribute(96) && !hasAttribute(0x80000))
        {
            if(compiler._hvZ())
                compiler.generateWarning(super._name.indexOf('$') == -1, getFullName(), "Class is not extended and should be marked 'final'");
            setAttribute(64);
            k2 = z_q7I;
            for(int k1 = 0; k1 < k2; k1++)
            {
                net.rim.tools.compiler.types.Method c2 = _methods[k1];
                if(!c2.is(32))
                    c2.addModifiers(64);
            }

        }
        int i4 = vector.size();
        k2 = z_q7I;
        for(int l1 = 0; l1 < k2; l1++)
        {
            net.rim.tools.compiler.types.Method c3 = _methods[l1];
            if(c3.is(0x10000000) && c3._nullCompilerZ(compiler))
                c3._aCompilerV(compiler, vector);
            else
                c3._hZV(false);
            if(!c3.is(0x10000010) && !c3._fJvZ())
            {
                String s = c3._fWvString();
                compiler.generateWarning(true, get_className() + ":" + c3._fHvI(), "method '" + s + "' not invoked.");
            }
        }

        k2 = vector.size();
        _vtableWeight = 10 + k2 * 4;
        if(z_rlVector != null && z_rlVector.size() > 0)
            _aIVectorV(i4, vector, compiler);
        z_rkVector = vector;
        k2 = vector.size();
        if(k2 > 0)
            if(!hasAttribute(0x80000))
            {
                z_rmaZ = new boolean[k2];
                k2 = z_q7I;
                for(int i2 = 0; i2 < k2; i2++)
                {
                    net.rim.tools.compiler.types.Method c4 = _methods[i2];
                    if(c4._fSvZ())
                    {
                        int j4 = c4.getOffset();
                        if(j4 != -1)
                            _b2IV(j4);
                    }
                }

            } else
            if(_bRIZ(64))
            {
                z_rmaZ = new boolean[k2];
                for(net.rim.tools.compiler.types.ClassType g2 = _superClass; g2 != null && !g2.hasAttribute(0x20000); g2 = g2._superClass)
                {
                    boolean aflag[] = g2.z_rmaZ;
                    if(aflag != null)
                        break;
                    int l2 = g2.z_rkVector.size();
                    aflag = new boolean[l2];
                    for(int j2 = 0; j2 < l2; j2++)
                        aflag[j2] = true;

                    g2.z_rmaZ = aflag;
                }

            }
    }

    private void _b2IV(int i1)
    {
        for(net.rim.tools.compiler.types.ClassType g1 = _superClass; g1 != null; g1 = g1._superClass)
        {
            boolean aflag[] = g1.z_rmaZ;
            if(aflag == null || i1 >= aflag.length)
                break;
            aflag[i1] = true;
        }

    }

    public void _bUIV(int i1)
    {
        _dataWeight += i1;
    }

    public int _fmvI()
    {
        return _dataWeight;
    }

    public void _bOIV(int i1)
    {
        _codeWeight += i1;
    }

    public int _fevI()
    {
        return _codeWeight;
    }

    public int _fdvI()
    {
        return _vtableWeight;
    }

    public int _ffvI()
    {
        return _fieldWeight;
    }

    private void _aVectorccV(Vector vector, int i1, net.rim.tools.compiler.types.Method c1, int j1, net.rim.tools.compiler.types.Method c2)
    {
        if(c1 == null)
            c1 = (net.rim.tools.compiler.types.Method)vector.elementAt(i1);
        if(c2 == null)
            c2 = (net.rim.tools.compiler.types.Method)vector.elementAt(j1);
        vector.setElementAt(c1, j1);
        c1.setOffset(j1);
        vector.setElementAt(c2, i1);
        c2.setOffset(i1);
    }

    private void _aIVectorV(int i1, Vector vector, Compiler compiler)
        throws CompileException
    {
        boolean flag = false;
        int j1 = vector.size() - 1;
        for(int k1 = i1; k1 <= j1; k1++)
        {
            net.rim.tools.compiler.types.Method c1 = (net.rim.tools.compiler.types.Method)vector.elementAt(k1);
            if(c1._fXvZ())
            {
                int i2 = c1._fQvI();
                if(i2 != -1 && i2 != k1)
                    if(i2 < i1 || i2 > j1)
                    {
                        if(compiler._nullvZ() && i2 < i1)
                        {
                            String s = c1.getName();
                            String s1 = "preferred ordinal " + i2 + " in class " + getFullName() + '[' + i1 + ',' + j1 + ']' + " could not be used for " + s;
                            String as[] = {
                                " match("
                            };
                            for(int i3 = 0; i3 < as.length; i3++)
                                if(s.indexOf(as[i3]) != -1)
                                    throw new CompileException(getFullName(), s1);

                            compiler.generateWarning(false, getFullName(), s1);
                        }
                    } else
                    {
                        _aVectorccV(vector, i2, null, k1, c1);
                        flag = true;
                    }
            }
        }

        int l1 = i1;
        for(int j2 = j1; l1 < j2;)
        {
            net.rim.tools.compiler.types.Method c2 = (net.rim.tools.compiler.types.Method)vector.elementAt(l1);
            if(!c2._fXvZ())
                l1++;
            else
            if(c2._fQvI() == l1)
            {
                l1++;
            } else
            {
                net.rim.tools.compiler.types.Method c3 = (net.rim.tools.compiler.types.Method)vector.elementAt(j2);
                if(c3._fXvZ())
                {
                    j2--;
                } else
                {
                    _aVectorccV(vector, l1, c2, j2, c3);
                    l1++;
                    j2--;
                    flag = true;
                }
            }
        }

        if(flag && _methods != null)
        {
            int k2 = 0;
            for(int l2 = i1; l2 <= j1; l2++)
            {
                net.rim.tools.compiler.types.Method c4 = (net.rim.tools.compiler.types.Method)vector.elementAt(l2);
                for(int j3 = 0; j3 < z_q7I; j3++)
                {
                    if(!_methods[j3].equals(c4) || k2 == j3)
                        continue;
                    net.rim.tools.compiler.types.Method c5 = _methods[k2];
                    _methods[k2] = c4;
                    _methods[j3] = c5;
                    break;
                }

                k2++;
            }

        }
    }

    private String _aCompilerString(Compiler compiler, net.rim.tools.compiler.types.Type a1)
    {
        if(a1 instanceof net.rim.tools.compiler.types.ClassType)
        {
            net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)a1;
            return g1._tryCompilerString(compiler);
        }
        if(a1 instanceof net.rim.tools.compiler.types.ArrayType)
        {
            net.rim.tools.compiler.types.ArrayType l1 = (net.rim.tools.compiler.types.ArrayType)a1;
            return _aCompilerString(compiler, l1.getBaseType());
        } else
        {
            return null;
        }
    }

    private String _ifZStringString(boolean flag, String s, String s1)
    {
        StringBuffer stringbuffer = new StringBuffer("Class ");
        stringbuffer.append(getFullName());
        if(flag && _interfaces != null)
        {
            int i1 = _interfaces.length;
            String s2 = " marked Persistable by interface: ";
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.types.ClassType g1 = _interfaces[j1];
                if(g1.hasAttribute(0x400000))
                {
                    stringbuffer.append(s2);
                    stringbuffer.append(g1.getFullName());
                    s2 = " and interface: ";
                }
            }

        }
        stringbuffer.append(s);
        if(s1 != null)
            stringbuffer.append(s1);
        return stringbuffer.toString();
    }

    private String _tryCompilerString(Compiler __compiler)
    {
        if(z_rfZ)
            return null;
        if(this == __compiler.getObjectClass())
            return null;
        if(!hasAttribute(0x400000))
        {
            ClassType g1 = __compiler._pvg();
            if(g1 == null)
                return _ifZStringString(false, " is not marked Persistable", null);
            else
                return _ifZStringString(false, " does not implement ", g1.getFullName());
        }
        z_rfZ = true;
        String s = _superClass._tryCompilerString(__compiler);
        if(s != null)
        {
            z_rfZ = false;
            return _ifZStringString(true, " is not Persistable: base ", s);
        }
        int i1 = z_riI;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Field h1 = _fields[j1];
            if(h1.is(4))
            {
                String s1 = _aCompilerString(__compiler, h1.getType());
                if(s1 != null)
                {
                    z_rfZ = false;
                    return _ifZStringString(true, " is not Persistable: field ", h1.getName() + ": " + s1);
                }
            }
        }

        z_rfZ = false;
        return null;
    }

    public net.rim.tools.compiler.codfile.ClassDef getClassDef(net.rim.tools.compiler.types.TypeModule __module)
    {
        int i1 = __module.getOrdinal();
        net.rim.tools.compiler.codfile.ClassDef _classDef_ = getClassDef(i1, __module.getCount());
        if(_classDef_ == null)
        {
            if(!isProcessed())
            {
                net.rim.tools.compiler.codfile.DataSection _dataSection_ = __module.getDataSection();
                _classDef_ = _dataSection_.getNullModule().makeClassDef(_dataSection_, _packageNameString, super._name);
                __module.addUndefinedClass(getFullName());
            } else
            {
                _classDef_ = super._module._amSu(__module, _packageNameString, super._name);
                if(!hasAttribute(0x20000))
                {
                    if(_classDef_ instanceof net.rim.tools.compiler.codfile.ClassDefDomestic)
                    {
                        net.rim.tools.compiler.codfile.ClassDefDomestic ad1 = (net.rim.tools.compiler.codfile.ClassDefDomestic)_classDef_;
                        ad1._aiV((net.rim.tools.compiler.codfile.ClassDefLocal)getClassDef(super._module));
                    } else
                    {
                        ((net.rim.tools.compiler.codfile.ClassDefLocal)_classDef_).setAttributes(net.rim.tools.compiler.types.Modifier._coII(_attribute));
                    }
                } else
                if(hasAttribute(0x40000))
                {
                    l l1 = (l)_classDef_;
                    l1.setOrdinal(z_rtI);
                }
            }
            setClassDef(_classDef_, i1);
        }
        return _classDef_;
    }

    net.rim.tools.compiler.codfile.TypeItem makeTypeItem(net.rim.tools.compiler.types.TypeModule m1)
        throws CompileException
    {
        int i1 = m1.getOrdinal();
        net.rim.tools.compiler.codfile.TypeItem x1 = getTypeItem(i1, m1.getCount());
        if(x1 == null)
        {
            x1 = new net.rim.tools.compiler.codfile.TypeItem(getClassDef(m1));
            setTypeItem(x1, i1);
        }
        return x1;
    }

    net.rim.tools.compiler.codfile.TypeList getTypeList(net.rim.tools.compiler.types.TypeModule m1)
        throws CompileException
    {
        int i1 = m1.getOrdinal();
        net.rim.tools.compiler.codfile.TypeList p1 = getTypeList(i1, m1.getCount());
        if(p1 == null)
        {
            if(!isProcessed())
                p1 = new net.rim.tools.compiler.codfile.TypeList(-1);
            else
                p1 = new net.rim.tools.compiler.codfile.TypeList(makeTypeItem(m1));
            setTypeList(p1, i1);
        }
        return p1;
    }

    public void _caseCompilerV(Compiler __compiler)
        throws CompileException
    {
        if(hasAttribute(0x20000))
            return;
        if(hasAttribute(0x80000000))
            return;
        if(!isProcessed())
            return;
        setAttribute(0x80000000);
        if(!hasAttribute(0x10000000))
            __compiler.generateWarning(true, getFullName(), "Unreferenced class");
        net.rim.tools.compiler.codfile.ClassDefLocal _classDefLocal_ = (net.rim.tools.compiler.codfile.ClassDefLocal)getClassDef(super._module);
        net.rim.tools.compiler.exec.g _output_ = __compiler._fvg();
        _classDefLocal_.setWeight("dataWeight: " + _dataWeight + ", codeWeight: " + _codeWeight + ", vtableWeight: " + _vtableWeight + ", fieldWeight: " + _fieldWeight);
        _output_.append("Class: ");
        _output_._gotoIV(net.rim.tools.compiler.types.Modifier._cnII(_attribute));
        _output_._byteStringV(getFullName());
        if(hasAttribute(0x400000))
        {
            String s = _tryCompilerString(__compiler);
            if(s != null)
                throw new CompileException(getFullName(), s);
            _classDefLocal_.setAttributes(128);
        } else
        if(_superClass != null && _superClass.hasAttribute(0x400000))
        {
            String s1 = _superClass.getPackageNameString();
            if(!"java.lang".equals(s1) && !"java.util".equals(s1) && !"net.rim.device.api.util".equals(s1) && __compiler._hvZ())
                __compiler.generateWarning(false, getFullName(), "Class is non-persistable but extends a persistable base class: " + _superClass.getFullName());
        }
        if(!hasAttribute(2048) && hasAttribute(0x4000000))
            _classDefLocal_.setAttributes(256);
        _classDefLocal_.setSecureIndex(_secureIndex);
        if(z_qWVector != null && (__compiler.getOptimization() & 0x800) != 0)
            _classDefLocal_.setAttributes(512);
        net.rim.tools.compiler.codfile.DataSection _dataSection_ = super._module.getDataSection();
        if(_superClass != null)
        {
            _classDefLocal_.setSuperClass(_superClass.getClassDef(super._module), _dataSection_);
            _output_.append("extends ");
            _output_._byteStringV(_superClass.getFullName());
        } else
        {
            _classDefLocal_.setSuperClass(super._module._trymu(super._module), _dataSection_);
        }
        if(_interfaces != null)
        {
            int k2 = _interfaces.length;
            if(k2 > 0)
            {
                _output_.append("implements ");
                _classDefLocal_.allocateInterfaces(k2);
                for(int i1 = 0; i1 < k2; i1++)
                {
                    net.rim.tools.compiler.types.ClassType _interface_ = _interfaces[i1];
                    _classDefLocal_.addInterface(_interface_.getClassDef(super._module), _dataSection_);
                    _output_._byteStringV(_interface_.getFullName());
                }

            }
        }
        _output_.append("\n");
        int _staticDataSize_ = super._module.allocateStaticData(_staticDataSize);
        int i4 = 0;
        int j4 = 0;
        int l2 = z_riI;
        for(int j1 = 0; j1 < l2; j1++)
        {
            net.rim.tools.compiler.types.Field _field_ = _fields[j1];
            boolean flag = _field_.is(2);
            if(!_field_._f0vZ())
            {
                boolean flag2 = _field_.is(512);
                if(!flag2)
                    _output_.append(flag ? "  Static: " : "  Field: ");
                if(flag)
                {
                    if(_field_.hasOffset())
                    {
                        _field_.setOffset(_staticDataSize_ + _field_.getOffset());
                        i4++;
                    }
                } else
                {
                    j4++;
                }
                _field_._longCompilerV(__compiler);
                if(!flag2)
                    _output_.append("\n");
            }
        }

        if(hasAttribute(0x40000))
            _classDefLocal_.set_createSize(z_q1I + z_q6I);
        _classDefLocal_.set_createSize(_staticDataSize_);
        _classDefLocal_.allocateFieldDefs(i4, true);
        _classDefLocal_.allocateFieldDefs(j4, false);
        l2 = z_riI;
        for(int k1 = 0; k1 < l2; k1++)
        {
            net.rim.tools.compiler.types.Field _field_ = _fields[k1];
            if(!_field_._f0vZ())
            {
                boolean flag1 = _field_.is(2);
                if(!flag1 || _field_.hasOffset())
                {
                    net.rim.tools.compiler.codfile.FieldDef _fieldDef_ = (net.rim.tools.compiler.codfile.FieldDef)_field_._ifCompilerr(__compiler, super._module);
                    _classDefLocal_.addFieldDef(_fieldDef_, flag1);
                }
            }
        }

        int k4 = 0;
        int l4 = 0;
        int i5 = 0;
        l2 = z_q7I;
        for(int l1 = 0; l1 < l2; l1++)
        {
            net.rim.tools.compiler.types.Method _method_ = _methods[l1];
            if(_method_._doCompilerZ(__compiler, super._module))
            {
                boolean flag4 = _method_.is(512);
                if(!flag4)
                    _output_.append("  Method: ");
                if(_method_.is(18))
                    k4++;
                else
                if(_method_._fSvZ())
                    l4++;
                else
                    i5++;
                if(!flag4)
                    _output_.append("\n");
            } else
            {
                _methods[l1] = null;
            }
        }

        _classDefLocal_.allocateVirtualRoutines(l4);
        _classDefLocal_.allocateNonVirtualRoutines(i5);
        _classDefLocal_.allocateStaticRoutines(k4);
        boolean flag3 = false;
        boolean flag5 = false;
        l2 = z_q7I;
        for(int i2 = 0; i2 < l2; i2++)
        {
            net.rim.tools.compiler.types.Method c2 = _methods[i2];
            if(c2 != null)
            {
                net.rim.tools.compiler.codfile.Routine a5_1 = (net.rim.tools.compiler.codfile.Routine)c2._ifCompilerr(__compiler, super._module);
                if(c2.is(0x100000))
                {
                    if(!flag3)
                    {
                        flag3 = true;
                        _classDefLocal_.setClinit(a5_1);
                    } else
                    {
                        _classDefLocal_.setClinit(_classDefLocal_.getNullRoutine());
                    }
                    _classDefLocal_.addStaticRoutine(a5_1);
                } else
                if(c2.is(16))
                {
                    if(c2.getNumParameters() == 0)
                        if(!flag5)
                        {
                            flag5 = true;
                            _classDefLocal_.setInit(a5_1);
                        } else
                        {
                            _classDefLocal_.setInit(_classDefLocal_.getNullRoutine());
                        }
                    _classDefLocal_.addStaticRoutine(a5_1);
                } else
                if(c2.is(18))
                    _classDefLocal_.addStaticRoutine(a5_1);
                else
                if(c2._fSvZ())
                {
                    a5_1.setAddress(c2.getAbsoluteOffset());
                    _classDefLocal_.addVirtualRoutine(a5_1);
                } else
                {
                    _classDefLocal_.addNonVirtualRoutine(a5_1);
                }
            }
        }

        if(!flag3)
            _classDefLocal_.setClinit(_classDefLocal_.getNullRoutine());
        if(!flag5)
            _classDefLocal_.setInit(_classDefLocal_.getNullRoutine());
        if(z_qWVector != null)
        {
            int i3 = z_qWVector.size();
            for(int j2 = 0; j2 < i3; j2++)
            {
                net.rim.tools.compiler.types.InnerClassType j5 = (net.rim.tools.compiler.types.InnerClassType)z_qWVector.elementAt(j2);
                _output_.append("  InnerClass: ");
                j5._aCompilerV(__compiler);
                _output_.append("\n");
            }

            z_qWVector = null;
        }
        super._module.setMaxTypeListSize(z_qVI);
    }

    public int _casegI(net.rim.tools.compiler.types.ClassType g1)
    {
        int i1 = super._name.compareTo(((net.rim.tools.compiler.types.Type) (g1))._name);
        if(i1 == 0)
            if(_packageNameString == null)
            {
                if(g1._packageNameString != null)
                    i1 = -1;
            } else
            if(g1._packageNameString == null)
                i1 = 1;
            else
                i1 = _packageNameString.compareTo(g1._packageNameString);
        return i1;
    }

    public int _bytegI(net.rim.tools.compiler.types.ClassType _class_)
    {
        int i1 = 0;
        if(_packageNameString == null)
        {
            if(_class_._packageNameString == null)
                i1 = 0;
            else
                i1 = -1;
        } else
        if(_class_._packageNameString == null)
            i1 = 1;
        else
            i1 = _packageNameString.compareTo(_class_._packageNameString);
        if(i1 == 0)
            return super._name.compareTo(((net.rim.tools.compiler.types.Type) (_class_))._name);
        else
            return i1;
    }

    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj instanceof net.rim.tools.compiler.types.ClassType)
        {
            net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)obj;
            return _bytegI(g1) == 0;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        int i1 = super._name.hashCode();
        if(_packageNameString != null)
            i1 = i1 * 31 + _packageNameString.hashCode();
        return i1;
    }

    public net.rim.tools.compiler.a.cls_e _afe(net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_qPe == null || super.z_qPe._ovf() != f1)
            if(isProcessed() && super._module == m1)
            {
                net.rim.tools.compiler.codfile.ClassDef u1 = getClassDef(m1);
                int j1 = u1.getOrdinal();
                super.z_qPe = new net.rim.tools.compiler.a.cls_k(null, getName(), getTypeId(), z_q6I, net.rim.tools.compiler.types.Modifier.toCodfileClassAttribute(_attribute), 0, z_q8I, j1, _packageNameString, f_className_nv);
                f1._aeV(super.z_qPe);
                if(_superClass != null)
                    ((net.rim.tools.compiler.a.cls_k)super.z_qPe)._ifkV((net.rim.tools.compiler.a.cls_k)_superClass._afe(f1, m1));
                if(_interfaces != null)
                {
                    net.rim.tools.compiler.a.cls_k k1 = (net.rim.tools.compiler.a.cls_k)super.z_qPe;
                    int l1 = _interfaces.length;
                    for(int i2 = 0; i2 < l1; i2++)
                    {
                        net.rim.tools.compiler.types.ClassType g1 = _interfaces[i2];
                        k1._dokV((net.rim.tools.compiler.a.cls_k)g1._afe(f1, m1));
                    }

                }
            } else
            {
                int i1 = net.rim.tools.compiler.types.Modifier.toCodfileClassAttribute(_attribute) | 0x2000;
                super.z_qPe = new net.rim.tools.compiler.a.cls_k(null, getName(), getTypeId(), 0, i1, 0, z_q8I, -1, _packageNameString, f_className_nv);
                f1._aeV(super.z_qPe);
            }
        return super.z_qPe;
    }

    public void _aCompilerV(Compiler compiler, net.rim.tools.compiler.a.cls_f f1, net.rim.tools.compiler.types.TypeModule m1)
    {
        if(super.z_qPe == null)
            return;
        if(hasAttribute(0x20000))
            return;
        net.rim.tools.compiler.a.cls_k k1 = (net.rim.tools.compiler.a.cls_k)super.z_qPe;
        int l1 = z_riI;
        for(int i1 = 0; i1 < l1; i1++)
        {
            Field h1 = _fields[i1];
            if(!h1._f0vZ())
            {
                net.rim.tools.compiler.a.cls_p p1 = h1.get_NULL(f1, m1);
                if(h1.is(2))
                    k1._apV(p1);
                else
                    k1._ifpV(p1);
            }
        }

        l1 = z_q7I;
        for(int j1 = 0; j1 < l1; j1++)
        {
            Method c1 = _methods[j1];
            if(c1 != null)
            {
                net.rim.tools.compiler.a.cls_j j2 = c1._ifCompilerj(compiler, f1, m1);
                if(j2 != null)
                    k1._ajV(j2);
            }
        }

    }

    public boolean _fgvZ()
    {
        if(hasAttribute(0x20000))
            return false;
        if(!hasAttribute(128))
            return false;
        int i1 = z_riI;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Field h1 = _fields[j1];
            if(h1.is(128) && h1.isAnd(66) && h1._f1vZ())
                return true;
        }

        return false;
    }

    public String _aStringDString(String s, DataOutputStream dataoutputstream)
        throws CompileException, IOException
    {
        if(s != _packageNameString)
        {
            s = _packageNameString;
            dataoutputstream.writeUTF('P' + s);
        }
        dataoutputstream.writeUTF('C' + super._name);
        int i1 = z_riI;
        for(int j1 = 0; j1 < i1; j1++)
        {
            Field h1 = _fields[j1];
            if(h1.isAnd(194) && h1._f1vZ())
            {
                net.rim.tools.compiler.types.Type a1 = h1.getType();
                StringBuffer stringbuffer = (new StringBuffer()).append('F').append(h1.getName()).append(':').append(a1._e6vString()).append('=');
                if(a1.getTypeId() == 7)
                    stringbuffer.append(h1._f2vString());
                else
                    stringbuffer.append(h1._f5vJ());
                dataoutputstream.writeUTF(stringbuffer.toString());
            }
        }

        return s;
    }

}
