// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.util.Vector;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.analysis.InstructionStackEntry;
import net.rim.tools.compiler.analysis.InstructionWalker;
import net.rim.tools.compiler.analysis.Instruction;

// Referenced classes of package net.rim.tools.compiler.e:
//            x, ad, al, u,
//            af

public final class ai
implements net.rim.tools.compiler.classfile.u
{

    private Vector z_o4Vector;
    private Vector z_o6Vector;
    private Vector z_o3Vector;
    private boolean z_o2Z;
    private Vector z_o8Vector;
    private int z_o5I;
    private InstructionTarget z_o7x;

    public ai()
    {
        this(0);
    }

    public ai(int i)
    {
        z_o4Vector = new Vector();
        z_o4Vector.addElement(new InstructionTarget(0, i, null, null));
        InstructionTarget x1 = new InstructionTarget(i, 1, null, null);
        x1._biIV(9);
        z_o4Vector.addElement(x1);
        z_o3Vector = new Vector();
    }

    public void _doxvV(net.rim.tools.compiler.classfile.InstructionTarget x1, int i)
    {
        z_o4Vector.insertElementAt(x1, i);
    }

    public void _dxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i = x1.getOffset();
        int j = _d3vI();
        for(int k = 0; k < j; k++)
            if(_bkIx(k).getOffset() > i)
            {
                _doxvV(x1, k);
                return;
            }

        throw new net.rim.tools.compiler.util.CompileException("byte code offset: " + i + " out of range: 0-" + _bkIx(j - 1).getOffset());
    }

    void _voidxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        _doxvV(x1, z_o5I++);
    }

    public void _boIV(int i)
    {
        z_o4Vector.removeElementAt(i);
    }

    public int _d3vI()
    {
        return z_o4Vector.size();
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _bkIx(int i)
    {
        return (net.rim.tools.compiler.classfile.InstructionTarget)z_o4Vector.elementAt(i);
    }

    public int _cxI(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        return z_o4Vector.indexOf(x1);
    }

    public void _aadvV(net.rim.tools.compiler.classfile.ad ad1, int i)
    {
        if(z_o6Vector == null)
            z_o6Vector = new Vector();
        z_o6Vector.insertElementAt(ad1, i);
    }

    public void _aIIIIV(int i, int j, int k, int l, net.rim.tools.compiler.types.ClassType g1)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.classfile.InstructionTarget x1 = _bvIx(j);
        if(x1.getOffset() != j)
            if(x1._baIZ(8))
            {
                x1 = _bkIx(_cxI(x1) + 1);
            } else
            {
                x1 = x1._aIZx(j, true, false);
                _dxV(x1);
            }
        net.rim.tools.compiler.classfile.InstructionTarget x2 = _intIZx(k, true);
        net.rim.tools.compiler.classfile.InstructionTarget x3 = _intIZx(l, false);
        int i1 = _cxI(x2);
        for(int j1 = _cxI(x1); j1 < i1; j1++)
            _bkIx(j1)._bytexV(x3);

        net.rim.tools.compiler.classfile.ad ad1 = new net.rim.tools.compiler.classfile.ad(x1, x2, x3, g1);
        if(z_o6Vector == null)
            z_o6Vector = new Vector();
        z_o6Vector.addElement(ad1);
    }

    public void _bwIV(int i)
    {
        z_o6Vector.removeElementAt(i);
        if(z_o6Vector.size() == 0)
            z_o6Vector = null;
    }

    public void _longIIV(int i, int j)
    {
        net.rim.tools.compiler.classfile.ad ad1 = _bpIad(i);
        net.rim.tools.compiler.classfile.ad ad2 = _bpIad(j);
        z_o6Vector.setElementAt(ad1, j);
        z_o6Vector.setElementAt(ad2, i);
    }

    public int _dVvI()
    {
        return z_o6Vector != null ? z_o6Vector.size() : 0;
    }

    public net.rim.tools.compiler.classfile.ad _bpIad(int i)
    {
        return (net.rim.tools.compiler.classfile.ad)z_o6Vector.elementAt(i);
    }

    public void _aalvV(net.rim.tools.compiler.classfile.al al1, int i)
    {
        z_o3Vector.insertElementAt(al1, i);
    }

    public void _aIIV(int i, int j, net.rim.tools.compiler.classfile.af af1)
	throws net.rim.tools.compiler.util.CompileException
    {
        InstructionTarget x1 = _bvIx(i);
        if(x1._baIZ(8))
        {
            if(i != x1.getOffset())
            {
                x1 = x1._dwvx();
                i = x1.getOffset();
            }
        } else
        {
            x1 = _intIZx(i, true);
        }
        InstructionTarget x2 = _intIZx(j, true);
        net.rim.tools.compiler.classfile.al al1 = new net.rim.tools.compiler.classfile.al(x1, x2, af1);
        z_o3Vector.addElement(al1);
    }

    public void _blIV(int i)
    {
        z_o3Vector.removeElementAt(i);
    }

    public void _elseIIV(int i, int j)
    {
        net.rim.tools.compiler.classfile.al al1 = _buIal(i);
        net.rim.tools.compiler.classfile.al al2 = _buIal(j);
        z_o3Vector.setElementAt(al1, j);
        z_o3Vector.setElementAt(al2, i);
    }

    public int _dPvI()
    {
        return z_o3Vector.size();
    }

    public net.rim.tools.compiler.classfile.al _buIal(int i)
    {
        return (net.rim.tools.compiler.classfile.al)z_o3Vector.elementAt(i);
    }

    public boolean _dUvZ()
    {
        return z_o2Z;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _bsIx(int i)
    {
        if(z_o8Vector == null)
            z_o8Vector = new Vector();
        net.rim.tools.compiler.classfile.InstructionTarget x1 = new net.rim.tools.compiler.classfile.InstructionTarget(i, 0, null, null);
        x1._biIV(10);
        z_o8Vector.addElement(x1);
        return x1;
    }

    public int _dSvI()
    {
        return z_o8Vector != null ? z_o8Vector.size() : 0;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _bmIx(int i)
    {
        return (InstructionTarget)z_o8Vector.elementAt(i);
    }

    void _bqIV(int i)
    {
        z_o5I = i;
    }

    void _bxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        z_o7x = x1;
    }

    net.rim.tools.compiler.classfile.InstructionTarget _d0vx()
    {
        return z_o7x;
    }

    public void _gotoIIV(int i, int j)
        throws CompileException
    {
        net.rim.tools.compiler.classfile.InstructionTarget x1 = _bvIx(i);
        if(x1._baIZ(8) && i != x1.getOffset())
        {
            x1 = x1._dwvx();
            i = x1.getOffset();
        }
        net.rim.tools.compiler.analysis.Instruction g1 = x1.findInstruction(i);
        if(g1 != null && g1._eOvI() == 0)
            g1.setValueOp(j);
    }

    public InstructionTarget _bvIx(int i)
	throws net.rim.tools.compiler.util.CompileException
    {
        InstructionTarget x1 = null;
        int j = 0;
        int k = _d3vI() - 1;
        do
        {
            int l = (j + k) / 2;
            x1 = _bkIx(l);
            if(i < x1.getOffset())
            {
                x1 = null;
                k = l - 1;
                continue;
            }
            if(x1.checkOffset(i))
                break;
            x1 = null;
            j = l + 1;
        } while(j <= k);
        if(x1 == null)
            throw new net.rim.tools.compiler.util.CompileException("byte code offset: " + i + " out of range: 0-" + _bkIx(_d3vI() - 1).getOffset());
        else
            return x1;
    }

    public InstructionTarget _intIZx(int i, boolean flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        InstructionTarget x1 = _bvIx(i);
        if(x1.getOffset() == i)
        {
            return x1;
        } else
        {
            x1 = x1._aIZx(i, flag, false);
            _dxV(x1);
            return x1;
        }
    }

    public void _aIdV(int i, net.rim.tools.compiler.analysis.InstructionStackEntry d)
	throws net.rim.tools.compiler.util.CompileException
    {
        InstructionTarget x1 = _intIZx(i, true);
        x1.setStackEntry(d);
    }

    public boolean _ifeZ(InstructionWalker e)
        throws CompileException
    {
        boolean flag = false;
        int i = _d3vI();
        for(int j = 0; j < i; j++)
        {
            InstructionTarget x1 = _bkIx(j);
            flag = x1._aeZ(e) || flag;
        }

        return flag;
    }

    void _dZvV()
        throws CompileException
    {
        int j = _d3vI();
        for(int i = 0; i < j; i++)
        {
            InstructionTarget x1 = _bkIx(i);
            if(x1._baIZ(1))
            {
                for(int k = _dVvI() - 1; k >= 0; k--)
                {
                    ad ad1 = _bpIad(k);
                    if(ad1._charxZ(x1))
                    {
                        ad ad2 = ad1._doaiad(this, x1);
                        if(ad2 == null)
                        {
                            if(ad1._dNvx() == ad1._dKvx())
                                _bwIV(k);
                        } else
                        {
                            _aadvV(ad2, k + 1);
                        }
                    }
                }

                x1._dGvV();
            }
        }

    }

    void _d7vV()
        throws CompileException
    {
        int k = _dVvI();
        for(int i = 0; i < k; i++)
        {
            ad ad1 = _bpIad(i);
            ad1._elsexV(_bvIx(ad1._dKvx().getOffset() - 1));
        }

        k = _dPvI();
        for(int j = 0; j < k; j++)
        {
            al al1 = _buIal(j);
            al1._exV(_bvIx(al1._d9vx().getOffset() - 1));
        }

    }

    void _dWvV()
    {
        boolean flag;
        do
        {
            flag = false;
            for(int i = _dVvI() - 1; i >= 0; i--)
            {
                ad ad1 = _bpIad(i);
                InstructionTarget x1 = ad1._dNvx();
                InstructionTarget x4 = ad1._dKvx();
                if(x1 != x4)
                {
                    int i2 = _cxI(x1);
                    int k2 = _cxI(x4);
                    if(i2 > k2)
                        throw new RuntimeException("bad exception range: " + i2 + " to " + k2);
                    for(int l2 = k2; l2 >= i2; l2--)
                    {
                        InstructionTarget x14 = _bkIx(l2);
                        if(x14._dvvx() != null)
                        {
                            if(l2 != k2)
                            {
                                InstructionTarget x15 = _bkIx(l2 + 1);
                                ad ad4 = ad1._axad(x14, x15);
                                _aadvV(ad4, i);
                                ad1 = ad4;
                                k2 = l2;
                                flag = true;
                            }
                            do
                            {
                                l2--;
                                x14 = _bkIx(l2);
                            } while(x14._dvvx() != null && l2 >= i2);
                            if(l2 >= i2)
                            {
                                InstructionTarget x16 = _bkIx(l2 + 1);
                                ad ad5 = ad1._axad(x14, x16);
                                _aadvV(ad5, i);
                                ad1 = ad5;
                                k2 = l2;
                                flag = true;
                            }
                        }
                    }

                }
            }

            int j1 = _dVvI();
            for(int j = 0; j < j1; j++)
            {
                ad ad3 = _bpIad(j);
                InstructionTarget x5 = ad3._dNvx()._dvvx();
                InstructionTarget x8 = ad3._dKvx()._dvvx();
                InstructionTarget x10 = ad3._dMvx()._dvvx();
                if(x5 != null && x8 != null && x10 == null)
                    throw new RuntimeException("Internal error: exception handler not cloned");
            }

        } while(flag);
        for(int k = _dPvI() - 1; k >= 0; k--)
        {
            al al1 = _buIal(k);
            int k1 = _cxI(al1._d8vx());
            int l1 = _cxI(al1._d9vx());
            for(int j2 = l1; j2 >= k1; j2--)
            {
                InstructionTarget x11 = _bkIx(j2);
                if(x11._dvvx() != null)
                {
                    if(j2 != l1)
                    {
                        InstructionTarget x12 = _bkIx(j2 + 1);
                        al al3 = al1._forxal(x11, x12);
                        _aalvV(al3, k);
                        l1 = j2;
                        al1 = al3;
                    }
                    do
                    {
                        j2--;
                        x11 = _bkIx(j2);
                    } while(x11._dvvx() != null && j2 >= k1);
                    if(j2 >= k1)
                    {
                        InstructionTarget x13 = _bkIx(j2 + 1);
                        al al4 = al1._forxal(x11, x13);
                        _aalvV(al4, k);
                        l1 = j2;
                        al1 = al4;
                    }
                }
            }

        }

        for(int l = _dVvI() - 1; l >= 0; l--)
        {
            ad ad2 = _bpIad(l);
            InstructionTarget x2 = ad2._dNvx()._dvvx();
            InstructionTarget x6 = ad2._dKvx()._dvvx();
            InstructionTarget x9 = ad2._dMvx()._dvvx();
            if(x2 != null && x6 != null)
            {
                ad2 = ad2._axad(x2, x6, x9);
                _aadvV(ad2, l + 1);
            }
        }

        for(int i1 = _dPvI() - 1; i1 >= 0; i1--)
        {
            al al2 = _buIal(i1);
            InstructionTarget x3 = al2._d8vx()._dvvx();
            InstructionTarget x7 = al2._d9vx()._dvvx();
            if(x3 != null && x7 != null)
            {
                al2 = al2._doxal(x3, x7);
                _aalvV(al2, i1 + 1);
            }
        }

    }

    void _nullxV(InstructionTarget x1)
    {
        x1._duvV();
        for(int i = 0; i < _d3vI(); i++)
        {
            InstructionTarget x2 = _bkIx(i);
            x2._aaiV(this);
        }

        int k = _d3vI();
        for(int j = 0; j < k; j++)
        {
            InstructionTarget x3 = _bkIx(j);
            x3._djvV();
        }

    }

    void _dYvV()
    {
        _bqIV(0);
        _bxV(null);
        int j = _d3vI();
        for(int i = 0; i < j; i++)
        {
            InstructionTarget x1 = _bkIx(i);
            x1._davV();
        }

    }

    public void _dZV(boolean flag)
    {
        int i1 = _d3vI();
        for(int i = 0; i < i1; i++)
        {
            InstructionTarget x1 = _bkIx(i);
            x1._dfvV();
        }

        _bkIx(0)._dkvV();
        boolean flag1;
        do
        {
            flag1 = false;
            i1 = _d3vI();
            for(int j = 0; j < i1; j++)
            {
                InstructionTarget x2 = _bkIx(j);
                if(flag || x2._c9vZ())
                {
                    InstructionTarget x4 = x2._dwvx();
                    if(x4 == null)
                    {
                        int j1 = j + 1;
                        if(x2._dxvI() == 0 && j1 < i1)
                            x4 = _bkIx(j1);
                    }
                    if(x4 != null)
                    {
                        if(!x4._c9vZ())
                            flag1 = true;
                        x4._dkvV();
                    }
                    int k1 = x2._dsvI();
                    for(int l1 = 0; l1 < k1; l1++)
                    {
                        InstructionTarget x5 = x2._a5Ix(l1);
                        if(!x5._c9vZ())
                            flag1 = true;
                        if(_cxI(x5) <= j)
                            x5._dAvV();
                        else
                            x5._c8vV();
                    }

                }
            }

            i1 = _dVvI();
            for(int k = 0; k < i1; k++)
            {
                ad ad1 = _bpIad(k);
                InstructionTarget x6 = ad1._dNvx();
                x6._drvV();
                InstructionTarget x8 = ad1._dKvx();
                x8._drvV();
                int i2 = _cxI(x6);
                int j2 = _cxI(x8);
                boolean flag2 = false;
                for(int k2 = i2; k2 <= j2; k2++)
                {
                    if(!_bkIx(k2)._c9vZ())
                        continue;
                    flag2 = true;
                    break;
                }

                if(flag2)
                {
                    InstructionTarget x10 = ad1._dMvx();
                    if(!x10._c9vZ())
                        flag1 = true;
                    if(_cxI(x10) <= i2)
                        x10._dAvV();
                    else
                        x10._c8vV();
                }
            }

        } while(flag1);
        for(i1 = _d3vI(); --i1 >= 0;)
        {
            InstructionTarget x3 = _bkIx(i1);
            if(x3._dxvI() > 0 && !x3._baIZ(9))
            {
                if(!x3._baIZ(4) && !x3._baIZ(6))
                {
                    z_o2Z = true;
                    if(!x3._c9vZ())
                        x3._c8vV();
                }
                break;
            }
        }

        i1 = _dPvI();
        for(int l = 0; l < i1; l++)
        {
            al al1 = _buIal(l);
            InstructionTarget x7 = al1._d8vx();
            x7._dgvV();
            InstructionTarget x9 = al1._d9vx();
            x9._dgvV();
        }

    }

    InstructionTarget _ifxx(InstructionTarget x1, InstructionTarget x2)
    {
        if(x2 != x1)
        {
            int i = _cxI(x2);
            for(; x2._dxvI() == 0; x2 = _bkIx(i))
                i++;

            if(x2._baIZ(6))
                x2 = x2._a5Ix(0);
        }
        return x2;
    }

    boolean _dOvZ()
        throws CompileException
    {
        boolean flag = false;
        int i = _d3vI();
        flag = false;
        boolean flag1 = false;
        do
        {
            flag1 = false;
            for(int j = 0; j < i; j++)
            {
                InstructionTarget x2 = _bkIx(j);
                x2._dlvV();
                int i1 = x2._dsvI();
                for(int k1 = 0; k1 < i1; k1++)
                {
                    InstructionTarget x8 = x2._a5Ix(k1);
                    InstructionTarget x11 = _ifxx(x2, x8);
                    if(x11 != x8)
                    {
                        x2._ifxvV(x11, k1);
                        flag = true;
                        flag1 = true;
                    }
                }

            }

        } while(flag1);
        for(int k = 0; k < i; k++)
        {
            InstructionTarget x3 = _bkIx(k);
            if(x3._baIZ(6))
            {
                InstructionTarget x4 = x3._a5Ix(0);
                if(x3 != x4)
                {
                    int l1 = k + 1;
                    InstructionTarget x9 = _bkIx(l1);
                    for(InstructionTarget x12 = x9; l1 < i; x12 = _bkIx(l1))
                    {
                        if(x12 == x4)
                        {
                            int k2 = x3._dJvI();
                            x3._doxV(x9);
                            if(x9 != x4)
                            {
                                l1 = k + 1;
                                InstructionTarget x14;
                                for(x12 = x9; x12 != x4; x12 = x14)
                                {
                                    l1++;
                                    x14 = _bkIx(l1);
                                    x12._doxV(x14);
                                }

                            }
                            flag = true;
                            if(k2 != 0)
                            {
                                for(; x4 != null && x4._dxvI() == 0; x4 = x4._dwvx());
                                if(x4 != null)
                                    x4._bbIV(k2);
                            }
                            break;
                        }
                        if(x12._dxvI() != 0)
                            break;
                        l1++;
                    }

                }
            }
        }

        InstructionTarget x1 = null;
        for(int l = 0; l < i; l++)
        {
            InstructionTarget x5 = _bkIx(l);
            if(x5._baIZ(6))
            {
                InstructionTarget x6 = x5._a5Ix(0);
                if(x5._tryxZ(x6))
                    if(x6._baIZ(4) && x6._dxvI() <= 2)
                    {
                        x5._intxV(x6);
                        flag = true;
                    } else
                    if(x6._dBvZ() && x1 != null && x1._tryxZ(x6) && x5._dmvZ())
                    {
                        int i2 = _cxI(x6);
                        if(i2 != 0)
                        {
                            InstructionTarget x13 = _bkIx(i2 - 1);
                            int l2 = x13._casexI(x1);
                            if(l2 != 0)
                            {
                                InstructionTarget x15 = x13;
                                InstructionTarget x17 = x13._bdIx(l2);
                                if(x17 != null)
                                {
                                    if(i2 <= l)
                                    {
                                        x17._dAvV();
                                        l++;
                                    } else
                                    {
                                        x17._c8vV();
                                    }
                                    x17._dkvV();
                                    int k3 = _cxI(x13);
                                    _doxvV(x17, k3 + 1);
                                    i++;
                                    x15 = x17;
                                }
                                x5._ifxvV(x15, 0);
                                x5.setStackEntry(null);
                                x1._a9IV(l2);
                                flag = true;
                            }
                        }
                    }
            }
            if(x5._dxvI() != 0 || !x5._dmvZ())
                x1 = x5;
        }

        x1 = null;
        for(int j1 = 0; j1 < i; j1++)
        {
            InstructionTarget x7 = _bkIx(j1);
            if(x7._baIZ(6) && x1 != null)
            {
                InstructionTarget x10 = x7._a5Ix(0);
                if(x7 != x10 && x7._dmvZ() && x1._tryxZ(x10) && x7._tryxZ(x10))
                {
                    x10._ifxV(x1);
                    int j2 = x10._ddvI();
                    if(j2 > 1)
                    {
                        j2--;
                        for(int i3 = 0; i3 < j2; i3++)
                        {
                            InstructionTarget x16 = x10._beIx(i3);
                            if(x1._tryxZ(x16))
                            {
                                int j3 = x1._casexI(x16);
                                if(j3 != 0)
                                {
                                    InstructionTarget x18 = null;
                                    for(int l3 = _cxI(x16) + 1; l3 < i; l3++)
                                    {
                                        InstructionTarget x19 = _bkIx(l3);
                                        if(!x19._dmvZ())
                                            break;
                                        if(x19._baIZ(6))
                                        {
                                            x18 = x19;
                                            break;
                                        }
                                        if(x19._dxvI() != 0)
                                            break;
                                    }

                                    if(x18 != null)
                                    {
                                        InstructionTarget x20 = x1;
                                        InstructionTarget x21 = x1._bdIx(j3);
                                        if(x21 != null)
                                        {
                                            x21._c8vV();
                                            x21._dkvV();
                                            int i4 = _cxI(x1);
                                            _doxvV(x21, i4 + 1);
                                            j1++;
                                            i++;
                                            x20 = x21;
                                        }
                                        x18._ifxvV(x20, 0);
                                        x18.setStackEntry(null);
                                        x16._a9IV(j3);
                                        x10._bfIV(i3);
                                        j2--;
                                        i3--;
                                        x20._ifxV(x16);
                                        flag = true;
                                        if(x21 != null)
                                        {
                                            x10._bfIV(j2);
                                            x10._ifxV(x21);
                                            x1 = x21;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            if(x7._dxvI() != 0 || !x7._dmvZ())
                x1 = x7;
        }

        return flag;
    }

    boolean _d4vZ()
    {
        boolean flag = false;
        for(int i = _dVvI() - 1; i >= 0; i--)
        {
            ad ad1 = _bpIad(i);
            InstructionTarget x1 = ad1._dNvx();
            int j = _cxI(x1);
            for(InstructionTarget x2 = ad1._dKvx(); x1._dxvI() == 0 && x1 != x2; x1 = _bkIx(j))
                j++;

            if(x1._dxvI() == 0)
            {
                _bwIV(i);
                flag = true;
            }
        }

        return flag;
    }

    boolean _dRvZ()
    {
        int i = _d3vI();
        boolean flag = false;
        boolean flag1;
        do
        {
            flag1 = false;
            _dZV(false);
            for(int j = 0; j < i - 1; j++)
            {
                InstructionTarget x1 = _bkIx(j);
                if(!x1._c9vZ())
                    if(x1._dwvx() != null || x1._dsvI() != 0)
                    {
                        x1._dJvI();
                        flag1 = true;
                    } else
                    if(x1._dxvI() != 0)
                    {
                        x1._dJvI();
                        flag1 = true;
                    }
            }

            flag |= flag1;
        } while(flag1);
        return flag;
    }

    void _bnIV(int i)
        throws CompileException
    {
        i = i;
        boolean flag;
        do
        {
            flag = false;
            flag |= _dOvZ();
            flag |= _d4vZ();
            flag |= _dRvZ();
        } while(flag);
    }

    private int _eZI(boolean flag)
        throws CompileException
    {
        InstructionTarget x1 = null;
        int i = 0;
        int j = _d3vI() - 1;
        for(int k = 0; k < j; k++)
        {
            x1 = _bkIx(k);
            i = x1._forIZI(i, flag);
        }

        x1 = _bkIx(j);
        x1.setOffset(i);
        x1._a7IV(1);
        return i;
    }

    void _dQvV()
        throws CompileException
    {
        for(int i = _dVvI() - 1; i >= 0; i--)
        {
            ad ad1 = _bpIad(i);
            InstructionTarget x1 = ad1._dKvx();
            int k = x1.getOffset() + x1._dxvI();
            if(ad1._dNvx().getOffset() == k)
                _bwIV(i);
            else
                ad1._elsexV(_bvIx(k));
        }

        for(int j = _dPvI() - 1; j >= 0; j--)
        {
            al al1 = _buIal(j);
            InstructionTarget x2 = al1._d9vx();
            int l = x2.getOffset() + x2._dxvI();
            al1._exV(_bvIx(l));
        }

    }

    void _dXvV()
        throws CompileException
    {
        boolean flag;
        do
        {
            flag = false;
            _dZV(false);
            for(int i = _d3vI() - 1; i >= 0; i--)
            {
                InstructionTarget x1 = _bkIx(i);
                InstructionTarget x3 = x1._dwvx();
                if(x3 != null)
                    if(x3._dxvI() == 0)
                    {
                        x1._doxV(_bvIx(x3.getOffset()));
                        flag = true;
                    } else
                    if(x3._dmvZ() && x3.getStackEntry() == null && !x3._dzvZ() && x1._dsvI() == 0)
                    {
                        x1._forxV(x3);
                        flag = true;
                    }
                for(int i1 = x1._dsvI() - 1; i1 >= 0; i1--)
                {
                    InstructionTarget x4 = x1._a5Ix(i1);
                    if(x4._dxvI() == 0)
                    {
                        x1._ifxvV(_bvIx(x4.getOffset()), i1);
                        flag = true;
                    }
                }

            }

            for(int j = _dVvI() - 1; j >= 0; j--)
            {
                ad ad1 = _bpIad(j);
                InstructionTarget x5 = ad1._dNvx();
                if(x5._dxvI() == 0)
                    ad1._longxV(_bvIx(x5.getOffset()));
                InstructionTarget x7 = ad1._dKvx();
                if(x7._dxvI() == 0)
                    ad1._elsexV(_bvIx(x7.getOffset()));
                InstructionTarget x9 = ad1._dMvx();
                if(x9._dxvI() == 0)
                    ad1._gotoxV(_bvIx(x9.getOffset()));
            }

            for(int k = _dPvI() - 1; k >= 0; k--)
            {
                al al1 = _buIal(k);
                InstructionTarget x6 = al1._d8vx();
                if(x6._dxvI() == 0)
                    al1._fxV(_bvIx(x6.getOffset()));
                InstructionTarget x8 = al1._d9vx();
                if(x8._dxvI() == 0)
                    al1._exV(_bvIx(x8.getOffset()));
            }

            for(int l = _d3vI() - 2; l >= 0; l--)
            {
                InstructionTarget x2 = _bkIx(l);
                if(x2._dxvI() == 0)
                    _boIV(l);
            }

        } while(flag);
    }

    void _d1vV()
        throws CompileException
    {
        int i1 = _dVvI();
        for(int i = 0; i < i1; i++)
        {
            ad ad1 = _bpIad(i);
            int j1 = ad1._dNvx().getOffset();
            for(int i2 = i + 1; i2 < i1; i2++)
            {
                ad ad4 = _bpIad(i2);
                if(ad1._dMvx() != ad4._dMvx() || ad1._dLvg() != ad4._dLvg())
                    break;
                int j3 = ad4._dNvx().getOffset();
                if(j1 > j3)
                {
                    j1 = j3;
                    ad1 = ad4;
                    _longIIV(i, i2);
                }
            }

        }

        for(int j = 0; j < _dVvI() - 1; j++)
        {
            ad ad2 = _bpIad(j);
            ad ad3 = _bpIad(j + 1);
            if(ad2._dMvx() == ad3._dMvx() && ad2._dLvg() == ad3._dLvg() && ad2._aadZ(ad3))
            {
                int j2 = ad2._dKvx().getOffset();
                int i3 = ad3._dKvx().getOffset();
                if(i3 > j2)
                    ad2._elsexV(ad3._dKvx());
                _bwIV(j + 1);
                j--;
            }
        }

        i1 = _dPvI();
        for(int k = 0; k < i1; k++)
        {
            al al1 = _buIal(k);
            int k1 = al1._d8vx().getOffset();
            for(int k2 = k + 1; k2 < i1; k2++)
            {
                al al4 = _buIal(k2);
                int k3 = al4._d8vx().getOffset();
                if(k1 > k3)
                {
                    k1 = k3;
                    al al2 = al4;
                    _elseIIV(k, k2);
                }
            }

        }

        for(int l = 0; l < _dPvI(); l++)
        {
            al al3 = _buIal(l);
            int l1 = al3._d9vx().getOffset();
            for(int l2 = l + 1; l2 < _dPvI(); l2++)
            {
                al al5 = _buIal(l2);
                int l3 = al5._d8vx().getOffset();
                if(l1 < l3)
                    break;
                if(al3._eavaf().equals(al5._eavaf()) && al3._aalZ(al5))
                {
                    int i4 = al5._d9vx().getOffset();
                    if(i4 > l1)
                    {
                        l1 = i4;
                        al3._exV(al5._d9vx());
                    }
                    _blIV(l2);
                    l2--;
                }
            }

        }

    }

    public int _brII(int i)
        throws CompileException
    {
        _dZvV();
        _d7vV();
        for(int j = 0; j < _d3vI(); j++)
        {
            InstructionTarget x1 = _bkIx(j);
            if(x1._baIZ(1))
            {
                _bqIV(j + 1);
                _bxV(x1._dwvx());
                x1._ifaiV(this);
                _dWvV();
                _dYvV();
            }
        }

        _bnIV(i);
        int k = _eZI(false);
        _dQvV();
        _dXvV();
        _d1vV();
        _dZV(false);
        return k;
    }

    public int _btII(int i)
        throws CompileException
    {
        _d7vV();
        _bnIV(i);
        int j = _eZI(false);
        _dQvV();
        _dXvV();
        _d1vV();
        _dZV(false);
        return j;
    }

    public int _dTvI()
        throws CompileException
    {
        _dRvZ();
        int i = _eZI(false);
        _dXvV();
        _dZV(false);
        return i;
    }

    public int _d5vI()
    {
        int i = _d3vI();
        for(int j = 0; j < i; j++)
            _bkIx(j)._dqvV();

        InstructionTarget x1 = _bkIx(0);
        x1._bjIV(0);
        x1._dtvV();
        i = _dVvI();
        for(int k = 0; k < i; k++)
        {
            InstructionTarget x2 = _bpIad(k)._dMvx();
            x2._bjIV(1);
            x2._dtvV();
        }

        i = _d3vI() - 1;
        boolean flag;
        do
        {
            flag = false;
            for(int l = 0; l < i; l++)
            {
                InstructionTarget x3 = _bkIx(l);
                if(x3._dpvZ())
                {
                    x3._dqvV();
                    int j1 = x3._dcvI();
                    InstructionTarget x4 = x3._dwvx();
                    if(x4 != null && x4._dIvI() < j1)
                    {
                        x4._bjIV(j1);
                        x4._dtvV();
                        flag = true;
                    }
                    if(x3._baIZ(8))
                        j1--;
                    int i2 = x3._dsvI();
                    for(int j2 = 0; j2 < i2; j2++)
                    {
                        InstructionTarget x5 = x3._a5Ix(j2);
                        if(x5 != x3 && x5._dIvI() < j1)
                        {
                            x5._bjIV(j1);
                            x5._dtvV();
                            flag = true;
                        }
                    }

                }
            }

        } while(flag);
        int i1 = 0;
        for(int k1 = 0; k1 < i; k1++)
        {
            int l1 = _bkIx(k1)._dbvI();
            if(l1 > i1)
                i1 = l1;
        }

        return i1;
    }

    public int _d6vI()
        throws CompileException
    {
        return _eZI(true);
    }

    public int _d2vI()
    {
        int i = 0;
        int j = _d3vI();
        for(int k = 0; k < j; k++)
            i += _bkIx(k)._dhvI();

        return i;
    }
}
