// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.analysis;

import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.util.i;
import net.rim.tools.compiler.types.Type;
import net.rim.tools.compiler.types.ReferenceType;
import net.rim.tools.compiler.types.BaseType;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.ArrayType;

public final class InstructionStackEntry
implements net.rim.tools.compiler.vm.Constants
{

    private int z_okI;
    private net.rim.tools.compiler.types.Type z_omaa[];
    private net.rim.tools.compiler.types.Type z_ona;
    private int z_opI;
    private String z_ofString;
    private boolean z_oiZ;
    private boolean z_ohZ;
    private boolean z_ogZ;
    private boolean z_ooZ;
    private boolean z_olZ;
    private int z_ojI;
    private int z_oeI;

    public InstructionStackEntry(String s, int j, int k, int i1, net.rim.tools.compiler.types.Type aa[], net.rim.tools.compiler.types.Type a1)
    {
        z_ona = a1;
        z_ofString = s;
        z_ogZ = true;
        z_ooZ = true;
        z_ojI = -1;
        z_oeI = k;
        z_opI = j;
        z_omaa = new net.rim.tools.compiler.types.Type[k + i1 + 2];
        int j1 = aa.length;
        for(int k1 = 0; k1 < j1; k1++)
        {
            Object obj = aa[k1];
            if(obj instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g1 = (net.rim.tools.compiler.types.ClassType)obj;
                if(g1.hasAttribute(2048))
                {
                    obj = g1.getSuperClass();
                    aa[k1] = ((net.rim.tools.compiler.types.Type) (obj));
                }
            }
            z_omaa[z_okI++] = ((net.rim.tools.compiler.types.Type) (obj));
        }

    }

    public InstructionStackEntry(String s, int j, int k, net.rim.tools.compiler.types.Type a1)
    {
        z_ona = a1;
        z_ofString = s;
        z_ojI = -1;
        z_oeI = j;
        z_omaa = new net.rim.tools.compiler.types.Type[j + k + 2];
    }

    public InstructionStackEntry(InstructionStackEntry d1)
    {
        z_ona = d1.z_ona;
        z_ofString = d1.z_ofString;
        z_ogZ = true;
        z_ojI = -1;
        z_oeI = d1.z_oeI;
        z_opI = d1.z_opI;
        net.rim.tools.compiler.types.Type aa[] = d1.z_omaa;
        int j = aa.length;
        z_omaa = new net.rim.tools.compiler.types.Type[j];
        for(int k = 0; k < j; k++)
            z_omaa[k] = aa[k];

        z_okI = d1.z_okI;
    }

    public int _cZvI()
    {
        return z_okI;
    }

    public net.rim.tools.compiler.types.Type[] _cSvaa()
    {
        return z_omaa;
    }

    public void _a0IV(int j)
    {
        z_opI = j;
    }

    public void _cYvV()
    {
        z_oiZ = false;
        z_ohZ = false;
        z_ogZ = true;
    }

    public boolean _cWvZ()
    {
        return z_ohZ;
    }

    public void _c6vV()
    {
        z_ogZ = true;
    }

    public void _cVvV()
    {
        z_ogZ = false;
    }

    public boolean _c5vZ()
    {
        return z_ogZ;
    }

    public boolean _c3vZ()
    {
        return z_ooZ;
    }

    public void _cTvV()
    {
        z_ooZ = true;
    }

    public void _c4vV()
    {
        z_olZ = true;
    }

    public boolean _c0vZ()
    {
        return z_olZ;
    }

    public int _cXvI()
    {
        return z_ojI;
    }

    public void _ifavV(net.rim.tools.compiler.types.Type a1, int j)
	throws net.rim.tools.compiler.util.i
    {
        if(a1 instanceof ClassType)
        {
            ClassType g1 = (ClassType)a1;
            if(g1.hasAttribute(2048))
                a1 = g1.getSuperClass();
        }
        if(j >= z_okI)
            _cUvV();
        if(!a1.equals(z_omaa[j]))
        {
            if(z_ooZ)
                _AStringV("setType at index:" + j + " cannot change " + z_omaa[j].getName() + " to " + a1.getName());
            if(j > 0)
            {
                int k = j - 1;
                if(z_omaa[k].isTwoWord())
                    z_omaa[k] = z_ona;
            }
            if(a1.isTwoWord())
            {
                z_omaa[j++] = a1;
                if(j >= z_okI)
                    _cUvV();
                if(j >= z_omaa.length)
                    _cUvV();
                z_omaa[j] = z_ona;
            } else
            {
                if(j >= z_omaa.length)
                    _cUvV();
                z_omaa[j] = a1;
            }
            z_ogZ = true;
        }
    }

    public void _aavV(Type a1, int j)
        throws i
    {
        _ifavV(a1, j);
        if(a1.isTwoWord())
            j++;
        if(j >= z_oeI)
            _cUvV();
        if(j > z_ojI)
            z_ojI = j;
    }

    public void _ifaV(Type a1)
	throws net.rim.tools.compiler.util.i
    {
        if(a1.isTwoWord())
        {
            if(z_okI + 1 > z_omaa.length)
                _cUvV();
            z_omaa[z_okI++] = a1;
            z_omaa[z_okI++] = z_ona;
        } else
        {
            if(a1 instanceof ClassType)
            {
                ClassType g1 = (ClassType)a1;
                if(g1.hasAttribute(2048))
                    a1 = g1.getSuperClass();
            }
            if(z_okI > z_omaa.length)
                _cUvV();
            z_omaa[z_okI++] = a1;
        }
    }

    public void _aXIV(int j)
	throws net.rim.tools.compiler.util.i
    {
        int k = z_okI - j;
        if(k < z_oeI)
            _cUvV();
        net.rim.tools.compiler.types.Type a1 = z_omaa[k];
        if(a1.equals(z_ona))
            _cUvV();
        z_okI = k;
    }

    public void _c1vV()
    {
        z_okI = z_oeI;
    }

    public net.rim.tools.compiler.types.Type _aZIa(int j)
        throws i
    {
        if(j >= z_okI)
            _cUvV();
        net.rim.tools.compiler.types.Type a1 = z_omaa[j];
        if(a1.isTwoWord())
            _aWIV(j);
        return a1;
    }

    public net.rim.tools.compiler.types.Type _a1Ia(int j)
        throws i
    {
        int k = z_okI - j;
        if(k < z_oeI)
            _cUvV();
        Type a1 = z_omaa[k];
        if(a1.isTwoWord())
            _aWIV(k);
        return a1;
    }

    public net.rim.tools.compiler.types.Type _aYIa(int j)
        throws i
    {
        net.rim.tools.compiler.types.Type a1 = _a1Ia(j);
        if(j == 2 && !a1.isTwoWord())
            _cUvV();
        z_okI -= j;
        return a1;
    }

    public void _aiV(net.rim.tools.compiler.types.ClassUninitializedType j)
    {
        net.rim.tools.compiler.types.ClassType g1 = j.getClassType();
        int k = z_okI;
        for(int i1 = 0; i1 < k; i1++)
        {
            net.rim.tools.compiler.types.Type a1 = z_omaa[i1];
            if(j.equals(a1))
            {
                z_omaa[i1] = g1;
                z_ogZ = true;
            }
        }

    }

    private void _aWIV(int j)
        throws i
    {
        if(j + 1 >= z_okI)
            _cUvV();
        net.rim.tools.compiler.types.Type a1 = z_omaa[j + 1];
        if(!a1.equals(z_ona))
            _cUvV();
    }

    private void _cUvV()
        throws i
    {
        throw new i(null, z_ofString, z_opI);
    }

    private void _AStringV(String s)
        throws i
    {
        throw new i(null, z_ofString, z_opI, s);
    }

    public void _adCompilerV(net.rim.tools.compiler.analysis.InstructionStackEntry d1, boolean flag, Compiler compiler)
        throws net.rim.tools.compiler.util.CompileException
    {
        int j = _cZvI();
        int k = d1._cZvI();
        if(flag)
            k--;
        if(j != k)
            _AStringV("inconsistent stack depth in control flow merge");
        net.rim.tools.compiler.types.Type a1 = compiler.getNullType();
        net.rim.tools.compiler.types.Type a2 = z_ona;
        net.rim.tools.compiler.types.ClassType g1 = compiler.getObjectClass();
        for(int i1 = 0; i1 < j; i1++)
        {
            net.rim.tools.compiler.types.Type a3 = _aZIa(i1);
            net.rim.tools.compiler.types.Type a4 = d1._aZIa(i1);
            if(a3.equals(a4) || (a3 instanceof net.rim.tools.compiler.types.BaseType) && (a4 instanceof net.rim.tools.compiler.types.BaseType) && a3._doaZ(a4))
                continue;
            if(!z_oiZ)
                z_ohZ = true;
            if(a3.equals(a2))
                continue;
            if(a4.equals(a2))
            {
                _ifavV(a2, i1);
                continue;
            }
            if(!(a3 instanceof ReferenceType) || !(a4 instanceof ReferenceType))
            {
                _ifavV(a2, i1);
                continue;
            }
            if((a3 instanceof net.rim.tools.compiler.types.ClassUninitializedType) || (a4 instanceof net.rim.tools.compiler.types.ClassUninitializedType))
                _AStringV("incompatible types in control flow merge");
            if(a3.equals(g1))
                continue;
            if(a4.equals(g1))
            {
                _ifavV(a4, i1);
                continue;
            }
            if(a4.equals(a1))
                continue;
            if(a3.equals(a1))
            {
                _ifavV(a4, i1);
                continue;
            }
            net.rim.tools.compiler.types.ArrayType l1 = null;
            net.rim.tools.compiler.types.ArrayType l2 = null;
            if(a3 instanceof net.rim.tools.compiler.types.ArrayType)
                l1 = (net.rim.tools.compiler.types.ArrayType)a3;
            if(a4 instanceof net.rim.tools.compiler.types.ArrayType)
                l2 = (net.rim.tools.compiler.types.ArrayType)a4;
            if(l1 != null && l2 != null)
            {
                int j1 = l1.getNesting();
                if(j1 != l2.getNesting())
                {
                    _ifavV(g1, i1);
                } else
                {
                    net.rim.tools.compiler.types.Type a5 = l1.getMostBaseType();
                    net.rim.tools.compiler.types.Type a6 = l2.getMostBaseType();
                    if(!a5.equals(a6))
                        if(!(a5 instanceof net.rim.tools.compiler.types.ClassType) || !(a6 instanceof net.rim.tools.compiler.types.ClassType))
                        {
                            _ifavV(g1, i1);
                        } else
                        {
                            net.rim.tools.compiler.types.ClassType g5 = (net.rim.tools.compiler.types.ClassType)a5;
                            net.rim.tools.compiler.types.ClassType g6 = (net.rim.tools.compiler.types.ClassType)a6;
                            if(!g5.hasAttribute(2048) || !g6._newgZ(g5))
                            {
                                net.rim.tools.compiler.types.ClassType g7 = g5._elsegg(g6);
                                if(!g7.equals(g5))
                                    if(g7.equals(g6))
                                    {
                                        _ifavV(a4, i1);
                                    } else
                                    {
                                        Object obj = g7;
                                        for(int k1 = 0; k1 < j1; k1++)
                                            obj = ((net.rim.tools.compiler.types.Type) (obj)).getArrayType();

                                        _ifavV(((net.rim.tools.compiler.types.Type) (obj)), i1);
                                    }
                            }
                        }
                }
                continue;
            }
            if(l1 != null || l2 != null)
            {
                _ifavV(g1, i1);
                continue;
            }
            if(a3 instanceof net.rim.tools.compiler.types.ClassType)
            {
                net.rim.tools.compiler.types.ClassType g2 = (net.rim.tools.compiler.types.ClassType)a3;
                if(a4 instanceof net.rim.tools.compiler.types.ClassType)
                {
                    net.rim.tools.compiler.types.ClassType g3 = (net.rim.tools.compiler.types.ClassType)a4;
                    net.rim.tools.compiler.types.ClassType g4 = g2._elsegg(g3);
                    if(!g4.equals(g2))
                        _ifavV(g4, i1);
                    continue;
                }
            }
            if(i1 < z_oeI)
                _ifavV(a2, i1);
            else
                _AStringV("incompatible operand types in control flow merge");
        }

        z_oiZ = true;
    }

    public void _byteIIV(int j, int k)
    {
        int i1 = z_okI;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.types.Type a1 = z_omaa[j1];
            if(a1 instanceof net.rim.tools.compiler.types.ClassUninitializedType)
            {
                net.rim.tools.compiler.types.ClassUninitializedType k1 = (net.rim.tools.compiler.types.ClassUninitializedType)a1;
                k1.fixupOffset(j, k);
            }
        }

    }

    public void verifyUninitializedOffsets()
        throws net.rim.tools.compiler.util.CompileException
    {
        int j = z_okI;
        for(int k = 0; k < j; k++)
        {
            net.rim.tools.compiler.types.Type a1 = z_omaa[k];
            if(a1 instanceof net.rim.tools.compiler.types.ClassUninitializedType)
            {
                net.rim.tools.compiler.types.ClassUninitializedType i1 = (net.rim.tools.compiler.types.ClassUninitializedType)a1;
                if(i1.isPreverified())
                    throw new net.rim.tools.compiler.util.CompileException("bad offset for NewObject StackMap entry");
            }
        }

    }
}
