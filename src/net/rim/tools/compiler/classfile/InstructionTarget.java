// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.util.Vector;
import net.rim.tools.compiler.codfile.CodfileLabel;
import net.rim.tools.compiler.analysis.InstructionStringArray;
import net.rim.tools.compiler.analysis.InstructionStackEntry;
import net.rim.tools.compiler.analysis.InstructionWalker;
import net.rim.tools.compiler.analysis.Instruction;
import net.rim.tools.compiler.analysis.InstructionInts;
import net.rim.tools.compiler.analysis.InstructionLong;
import net.rim.tools.compiler.analysis.InstructionBytes;
import net.rim.tools.compiler.analysis.InstructionString;
import net.rim.tools.compiler.analysis.InstructionNameAndType;
import net.rim.tools.compiler.analysis.InstructionType;
import net.rim.tools.compiler.analysis.InstructionBranch;
import net.rim.tools.compiler.types.NameAndType;

// Referenced classes of package net.rim.tools.compiler.e:
//            u, ai

public final class InstructionTarget
implements net.rim.tools.compiler.classfile.u
{

    private static boolean z_oBZ = false;
    private int _offset;
    private int z_oLI;
    private int z_oTI;
    private boolean z_oQZ;
    private boolean z_oEZ;
    private boolean z_oWZ;
    private boolean z_oFZ;
    private boolean z_oIZ;
    private boolean z_oRZ;
    private boolean z_oDZ;
    private boolean z_oVZ;
    private int z_oCI;
    private int z_oOI;
    private int z_oGI;
    private net.rim.tools.compiler.classfile.InstructionTarget z_oKx;
    private net.rim.tools.compiler.classfile.InstructionTarget z_oUx;
    private net.rim.tools.compiler.codfile.CodfileLabel _codFileLabel;
    private net.rim.tools.compiler.analysis.InstructionStackEntry _instrStackEntry;
    private Vector _instructions;
    private Vector _instructionTargets;
    private Vector z_oNVector;
    private Vector z_oSVector;

    public InstructionTarget(int j, int k, net.rim.tools.compiler.classfile.InstructionTarget x1, Vector vector)
    {
        _offset = j;
        z_oLI = k;
        z_oTI = 0;
        z_oCI = -1;
        z_oUx = x1;
        _instructionTargets = vector;
    }

    public void setOffset(int j)
    {
        _offset = j;
    }

    public int _forIZI(int j, boolean flag)
    {
        _offset = j;
        int k = _dhvI();
        if(k > 0)
        {
            for(int i1 = 0; i1 < k; i1++)
                j = getInstruction(i1).setOffset(j, flag);

        }
        z_oLI = j - _offset;
        return j;
    }

    public int getOffset()
    {
        return _offset;
    }

    public void _a7IV(int j)
    {
        z_oLI = j;
    }

    public int _dxvI()
    {
        return z_oLI;
    }

    public boolean checkOffset(int j)
    {
        return _offset <= j && j < _offset + z_oLI;
    }

    public void _biIV(int j)
    {
        z_oTI = j;
    }

    public boolean _baIZ(int j)
    {
        return z_oTI == j;
    }

    public void _dtvV()
    {
        z_oQZ = true;
    }

    public void _dqvV()
    {
        z_oQZ = false;
    }

    public boolean _dpvZ()
    {
        return z_oQZ;
    }

    public void _dkvV()
    {
        z_oEZ = true;
    }

    public boolean _dBvZ()
    {
        return z_oEZ;
    }

    public boolean _dmvZ()
    {
        return z_oEZ && !z_oWZ && !z_oFZ && !z_oIZ;
    }

    public boolean _dCvZ()
    {
        return !z_oEZ && (z_oWZ || z_oFZ);
    }

    public void _c8vV()
    {
        z_oWZ = true;
    }

    public boolean _devZ()
    {
        return z_oWZ;
    }

    public void _dAvV()
    {
        z_oFZ = true;
    }

    public boolean _c7vZ()
    {
        return z_oFZ;
    }

    public void _drvV()
    {
        z_oIZ = true;
    }

    public void _dgvV()
    {
        z_oRZ = true;
    }

    public boolean _dzvZ()
    {
        return z_oRZ;
    }

    public void _dfvV()
    {
        z_oEZ = z_oWZ = z_oFZ = z_oIZ = z_oRZ = false;
    }

    public boolean _c9vZ()
    {
        return z_oEZ || z_oWZ || z_oFZ;
    }

    public void _doxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        z_oUx = x1;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _dwvx()
    {
        return z_oUx;
    }

    public void setStackEntry(net.rim.tools.compiler.analysis.InstructionStackEntry d1)
    {
        _instrStackEntry = d1;
    }

    public net.rim.tools.compiler.analysis.InstructionStackEntry getStackEntry()
    {
        return _instrStackEntry;
    }

    public void setLabel(net.rim.tools.compiler.codfile.CodfileLabel a6)
    {
        _codFileLabel = a6;
    }

    public net.rim.tools.compiler.codfile.CodfileLabel getLabel()
    {
        return _codFileLabel;
    }

    public void _dlvV()
    {
        if(z_oSVector != null)
            z_oSVector.setSize(0);
    }

    public void _ifxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        Vector vector = z_oSVector;
        if(vector == null)
        {
            vector = new Vector();
            z_oSVector = vector;
        }
        vector.addElement(x1);
    }

    public int _ddvI()
    {
        Vector vector = z_oSVector;
        return vector != null ? vector.size() : 0;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _beIx(int j)
    {
        return (net.rim.tools.compiler.classfile.InstructionTarget)z_oSVector.elementAt(j);
    }

    public void _bfIV(int j)
    {
        z_oSVector.removeElementAt(j);
    }

    public void _doVectorV(Vector vector)
    {
        if(vector != null)
        {
            int j = vector.size();
            Vector vector1 = _instructions;
            if(vector1 == null)
            {
                vector1 = new Vector(j);
                _instructions = vector1;
            }
            for(int k = 0; k < j; k++)
            {
                Object obj = vector.elementAt(k);
                vector1.insertElementAt(obj, k);
            }

        }
    }

    public Vector _dHvVector()
    {
        return _instructions;
    }

    public void setInstruction(net.rim.tools.compiler.analysis.Instruction g1, int j)
    {
        _instructions.setElementAt(g1, j);
    }

    public void insertInstruction(net.rim.tools.compiler.analysis.Instruction g1, int j)
    {
        Vector vector = _instructions;
        if(vector == null)
        {
            vector = new Vector();
            _instructions = vector;
        }
        vector.insertElementAt(g1, j);
    }

    private void addInstruction(net.rim.tools.compiler.analysis.Instruction g1)
    {
        Vector vector = _instructions;
        if(vector == null)
        {
            vector = new Vector();
            _instructions = vector;
        }
        vector.addElement(g1);
    }

    public void _a3IV(int j)
    {
        Vector vector = _instructions;
        vector.removeElementAt(j);
        if(vector.size() == 0)
            _instructions = null;
    }

    public int _dhvI()
    {
        Vector vector = _instructions;
        return vector != null ? vector.size() : 0;
    }

    public net.rim.tools.compiler.analysis.Instruction getInstruction(int j)
    {
        return (net.rim.tools.compiler.analysis.Instruction)_instructions.elementAt(j);
    }

    public net.rim.tools.compiler.analysis.Instruction findInstruction(int __offset)
    {
        net.rim.tools.compiler.analysis.Instruction g1 = null;
        Vector vector = _instructions;
        if(checkOffset(__offset) && vector != null)
        {
            int k = vector.size();
            for(int i1 = 0; i1 < k; i1++)
            {
                net.rim.tools.compiler.analysis.Instruction g2 = (net.rim.tools.compiler.analysis.Instruction)vector.elementAt(i1);
                if(g2.getIp() > __offset)
                    break;
                if(g1 == null || g1.getIp() < g2.getIp())
                    g1 = g2;
            }

        }
        return g1;
    }

    public net.rim.tools.compiler.analysis.Instruction getLastInstruction()
    {
        return (net.rim.tools.compiler.analysis.Instruction)_instructions.lastElement();
    }

    public void addInstructionBranch(int j, int k)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionBranch(j, k));
    }

    public void _charIIV(int j, int k)
    {
        addInstruction(new net.rim.tools.compiler.analysis.Instruction(j, k));
    }

    public void _doIIV(int j, int k, int i1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.Instruction(j, k, i1));
    }

    public void addInstructionBytes(int j, int k, int i1, byte abyte0[])
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionBytes(j, k, i1, abyte0));
    }

    public void addInstructionLong(int j, int k, int i1, int j1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionLong(j, k, i1, j1));
    }

    public void addInstruction(int j, int k, long l1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionLong(j, k, l1));
    }

    public void addInstruction(int j, int k, String s)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionString(j, k, s));
    }

    public void addInstructionStringArray(int j, int k, String as[])
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionStringArray(j, k, as));
    }

    public void addInstruction(int j, int k, net.rim.tools.compiler.types.Type a1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionType(j, k, a1));
    }

    public void _aIIaV(int j, int k, net.rim.tools.compiler.types.Type a1, int i1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionType(j, k, a1, i1));
    }

    public void _aIIaIV(int j, int k, int ai1[], boolean flag)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionInts(j, k, ai1, flag));
    }

    public void _aIIgV(int j, int k, net.rim.tools.compiler.types.ClassType g1, NameAndType k1)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionNameAndType(j, k, g1, k1));
    }

    public void _aIIgV(int j, int k, net.rim.tools.compiler.types.ClassType g1, NameAndType k1, boolean flag)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionNameAndType(j, k, g1, k1, flag));
    }

    public void _aIIgV(int j, int k, net.rim.tools.compiler.types.ClassType g1, NameAndType k1, int i1, boolean flag)
    {
        addInstruction(new net.rim.tools.compiler.analysis.InstructionNameAndType(j, k, g1, k1, i1, flag));
    }

    public void _ifxvV(net.rim.tools.compiler.classfile.InstructionTarget x1, int j)
    {
        _instructionTargets.setElementAt(x1, j);
    }

    public void _newxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        Vector vector = _instructionTargets;
        if(vector == null)
        {
            vector = new Vector();
            _instructionTargets = vector;
        }
        vector.addElement(x1);
    }

    public void _a8IV(int j)
    {
        Vector vector = _instructionTargets;
        vector.removeElementAt(j);
        if(vector.size() == 0)
            _instructionTargets = null;
    }

    public int _dsvI()
    {
        Vector vector = _instructionTargets;
        return vector != null ? vector.size() : 0;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _a5Ix(int j)
    {
        return (net.rim.tools.compiler.classfile.InstructionTarget)_instructionTargets.elementAt(j);
    }

    public void _axvV(net.rim.tools.compiler.classfile.InstructionTarget x1, int j)
    {
        z_oNVector.setElementAt(x1, j);
    }

    public void _bytexV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        Vector vector = z_oNVector;
        if(vector == null)
        {
            vector = new Vector();
            z_oNVector = vector;
        }
        vector.addElement(x1);
    }

    public void _dGvV()
    {
        z_oNVector = null;
    }

    public int _dyvI()
    {
        Vector vector = z_oNVector;
        return vector != null ? vector.size() : 0;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _a6Ix(int j)
    {
        return (InstructionTarget)z_oNVector.elementAt(j);
    }

    public void _bjIV(int j)
    {
        z_oCI = j;
    }

    public int _dIvI()
    {
        return z_oCI;
    }

    public int _dbvI()
    {
        return z_oOI;
    }

    public void _bcIV(int j)
    {
        z_oGI = j;
    }

    public int _dnvI()
    {
        return z_oGI;
    }

    public void _duvV()
    {
        if(z_oDZ || z_oVZ || z_oKx != null)
            return;
        if(z_oTI == 4 && _dyvI() == 0)
            z_oDZ = true;
        else
        if(z_oTI == 5)
        {
            if(z_oUx.z_oTI != 3)
            {
                z_oDZ = true;
                z_oUx._duvV();
            }
        } else
        if(z_oTI == 3)
        {
            z_oDZ = true;
        } else
        {
            z_oDZ = true;
            if(z_oUx != null)
                z_oUx._duvV();
            if(z_oTI != 1)
            {
                int j = _dsvI();
                for(int i1 = 0; i1 < j; i1++)
                    _a5Ix(i1)._duvV();

            }
            int k = _dyvI();
            for(int j1 = 0; j1 < k; j1++)
                _a6Ix(j1)._duvV();

        }
    }

    private net.rim.tools.compiler.classfile.InstructionTarget _aaix(ai ai1, InstructionTarget x1)
    {
        net.rim.tools.compiler.classfile.InstructionTarget x2 = new InstructionTarget(_offset, 1, null, null);
        x2.addInstruction(new InstructionBranch(_offset, 161));
        ai1._voidxV(x2);
        x2._newxV(x1);
        x2.z_oTI = 6;
        x2.z_oVZ = true;
        int j = _dyvI();
        for(int k = 0; k < j; k++)
            x2._bytexV(_a6Ix(k));

        return x2;
    }

    private InstructionTarget _ifaix(ai ai1, net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        net.rim.tools.compiler.classfile.InstructionTarget x2 = new net.rim.tools.compiler.classfile.InstructionTarget(_offset, 0, x1, null);
        ai1._voidxV(x2);
        x2.z_oVZ = true;
        int j = _dyvI();
        for(int k = 0; k < j; k++)
            x2._bytexV(_a6Ix(k));

        return x2;
    }

    public void _aaiV(ai ai1)
    {
        if(!z_oDZ || z_oVZ || z_oKx != null)
            return;
        if(z_oTI == 4 && _dyvI() == 0)
        {
            z_oKx = _aaix(ai1, this);
            z_oKx.z_oTI = 7;
        } else
        if(z_oTI == 5)
            z_oKx = _ifaix(ai1, z_oUx);
        else
        if(z_oTI == 3)
        {
            z_oKx = _aaix(ai1, ai1._d0vx());
        } else
        {
            z_oKx = new InstructionTarget(_offset, z_oLI, z_oUx, null);
            ai1._voidxV(z_oKx);
            z_oKx.z_oTI = z_oTI;
            z_oKx.z_oVZ = true;
            int j = _dhvI();
            for(int k = 0; k < j; k++)
                z_oKx.addInstruction(getInstruction(k)._eLvg());

            j = _dsvI();
            for(int i1 = 0; i1 < j; i1++)
                z_oKx._newxV(_a5Ix(i1));

            j = _dyvI();
            for(int j1 = 0; j1 < j; j1++)
                z_oKx._bytexV(_a6Ix(j1));

        }
    }

    public void _djvV()
    {
        if(!z_oVZ)
            return;
        if(z_oTI == 7)
        {
            _biIV(6);
            return;
        }
        if(z_oUx != null)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x1 = z_oUx.z_oKx;
            if(x1 != null)
                z_oUx = x1;
        }
        int j = _dsvI();
        for(int k = 0; k < j; k++)
        {
            InstructionTarget x2 = _a5Ix(k).z_oKx;
            if(x2 != null)
                _ifxvV(x2, k);
        }

        j = _dyvI();
        for(int i1 = 0; i1 < j; i1++)
        {
            net.rim.tools.compiler.classfile.InstructionTarget x3 = _a6Ix(i1).z_oKx;
            if(x3 != null)
                _axvV(x3, i1);
        }

    }

    public void _davV()
    {
        z_oKx = null;
        z_oDZ = false;
        z_oVZ = false;
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _dvvx()
    {
        return z_oKx;
    }

    public void _ifaiV(ai ai1)
    {
        _instructions = null;
        z_oLI = 0;
        z_oTI = 2;
        net.rim.tools.compiler.classfile.InstructionTarget x1 = _a5Ix(0);
        _instructionTargets = null;
        ai1._nullxV(x1);
        z_oUx = x1.z_oKx;
    }

    public int _dJvI()
    {
        int j = 0;
        int k = _dhvI();
        for(int i1 = 0; i1 < k; i1++)
        {
            Instruction g1 = getInstruction(i1);
            int j1 = g1._eOvI();
            if(j1 == 0)
                continue;
            j = j1;
            break;
        }

        _instructions = null;
        _instrStackEntry = null;
        z_oLI = 0;
        z_oTI = 0;
        z_oUx = null;
        _instructionTargets = null;
        return j;
    }

    public void _bbIV(int j)
    {
        if(j != 0 && _dhvI() > 0)
        {
            Instruction g1 = getInstruction(0);
            if(g1._eOvI() == 0)
                g1.setValueOp(j);
        }
    }

    public void _a9IV(int j)
    {
        int k = _dhvI();
        for(; j != 0; j--)
        {
            k--;
            Instruction g1 = getInstruction(k);
            int i1 = _offset + z_oLI;
            int j1 = g1.getIp();
            _a3IV(k);
            z_oLI -= i1 - j1;
        }

    }

    public net.rim.tools.compiler.classfile.InstructionTarget _bdIx(int j)
    {
        int k = _dhvI();
        if(j >= k)
        {
            return null;
        } else
        {
            Instruction g1 = getInstruction(k - j);
            int i1 = g1.getIp();
            return _aIZx(i1, true, false);
        }
    }

    public net.rim.tools.compiler.classfile.InstructionTarget _aIZx(int j, boolean flag, boolean flag1)
    {
        if(j == _offset)
            return this;
        int k = (z_oLI + _offset) - j;
        z_oLI = j - _offset;
        Vector vector = null;
        Vector vector1 = null;
        if(flag1)
            vector = _instructionTargets;
        else
            vector1 = _instructionTargets;
        net.rim.tools.compiler.classfile.InstructionTarget x1 = new net.rim.tools.compiler.classfile.InstructionTarget(j, k, z_oUx, vector1);
        _instructionTargets = vector;
        if(flag)
            z_oUx = x1;
        else
            z_oUx = null;
        int i1 = _dhvI();
        for(int j1 = i1 - 1; j1 >= 0; j1--)
        {
            Instruction g1 = getInstruction(j1);
            if(g1.getIp() < j)
                break;
            _a3IV(j1);
            x1.insertInstruction(g1, 0);
        }

        i1 = _dyvI();
        for(int k1 = 0; k1 < i1; k1++)
            x1._bytexV(_a6Ix(k1));

        if(z_oTI == 4)
        {
            z_oTI = 0;
            x1.z_oTI = 4;
        }
        return x1;
    }

    void _intxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        int j = _dJvI();
        int k = x1._dhvI();
        for(int i1 = 0; i1 < k; i1++)
        {
            Instruction g1 = x1.getInstruction(i1);
            g1 = g1._eLvg();
            g1.setValueOp(0);
            addInstruction(g1);
        }

        _bbIV(j);
        z_oLI = x1.z_oLI;
        z_oTI = x1.z_oTI;
        z_oUx = x1.z_oUx;
        if(x1._instrStackEntry != null)
        {
            _instrStackEntry = new InstructionStackEntry(x1._instrStackEntry);
            _instrStackEntry._cTvV();
        }
        k = x1._dsvI();
        for(int j1 = 0; j1 < k; j1++)
            _newxV(x1._a5Ix(j1));

    }

    void _forxV(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        int j = x1._dhvI();
        for(int k = 0; k < j; k++)
        {
            Instruction g1 = x1.getInstruction(k);
            addInstruction(g1);
        }

        z_oLI += x1.z_oLI;
        z_oTI = x1.z_oTI;
        z_oUx = x1.z_oUx;
        _instructionTargets = x1._instructionTargets;
        x1._dJvI();
        x1.setOffset(_offset + z_oLI);
    }

    public boolean _aeZ(InstructionWalker e1)
        throws net.rim.tools.compiler.util.CompileException
    {
        boolean flag = false;
        do
        {
            z_oQZ = false;
            e1.walkInstruction(this);
            int j = _dhvI();
            for(int i1 = 0; i1 < j; i1++)
            {
                Instruction g1 = getInstruction(i1);
                if(g1 != null)
                {
                    e1.walkInstruction(i1, g1);
                    g1.walkInstruction(e1);
                }
                e1._axvV(this, i1 == j - 1);
            }

            if(z_oQZ)
            {
                flag = true;
                int k = _dhvI();
                for(int j1 = k - 1; j1 >= 0; j1--)
                    if(getInstruction(j1) == null)
                        _a3IV(j1);

            }
        } while(z_oQZ);
        return flag;
    }

    public int _dcvI()
    {
        int j = z_oCI;
        if(j > z_oOI)
            z_oOI = j;
        int k = _dhvI();
        for(int i1 = 0; i1 < k; i1++)
        {
            Instruction g1 = getInstruction(i1);
            if(g1 != null)
            {
                j += g1._eMvI();
                if(j > z_oOI)
                    z_oOI = j;
            }
        }

        return j;
    }

    int _casexI(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        if(_dsvI() != 0 || x1._dsvI() != 0)
            return 0;
        int j = 0;
        if(z_oBZ)
        {
            int k = 0;
            int i1 = _dhvI();
            for(int j1 = x1._dhvI(); i1 != 0 && j1 != 0;)
            {
                i1--;
                j1--;
                Instruction g1 = getInstruction(i1);
                Instruction g2 = x1.getInstruction(j1);
                if(!g1.equals(g2))
                    break;
                if(!g1._eHvZ())
                {
                    if(!g1._eJvZ() || j != k)
                        break;
                    k++;
                } else
                {
                    j = ++k;
                }
            }

        }
        return j;
    }

    public boolean _tryxZ(net.rim.tools.compiler.classfile.InstructionTarget x1)
    {
        Vector vector = z_oNVector;
        Vector vector1 = x1.z_oNVector;
        if(vector == vector1)
            return true;
        if(vector == null || vector1 == null)
            return false;
        int j = vector.size();
        int k = vector1.size();
        if(j != k)
            return false;
        for(int i1 = 0; i1 < j; i1++)
            if(vector.elementAt(i1) != vector1.elementAt(i1))
                return false;

        return true;
    }

}
