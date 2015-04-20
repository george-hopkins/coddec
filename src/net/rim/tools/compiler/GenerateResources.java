// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.tools.compiler.classfile.ai;
import net.rim.tools.compiler.classfile.InstructionTarget;
import net.rim.tools.compiler.util.CompileException;
import net.rim.tools.compiler.util.DuplicateException;
import net.rim.tools.compiler.util.FileHelper;
import net.rim.tools.compiler.analysis.InstructionCode;
import net.rim.tools.compiler.types.Method;
import net.rim.tools.compiler.types.ClassType;
import net.rim.tools.compiler.types.NameAndType;
import net.rim.tools.compiler.types.ArrayType;

// Referenced classes of package net.rim.tools.compiler:
//            d, a, Compiler, j,
//            b, h, i, f

public class GenerateResources
    implements net.rim.tools.compiler.vm.Constants
{

    private net.rim.tools.compiler.Compiler _compiler;
    private net.rim.tools.compiler.JadSupport _jadFile;
    private Vector z_tJVector;
    private boolean z_tOZ;
    private String _className;
    private net.rim.tools.compiler.types.ClassType z_tKg;
    private net.rim.tools.compiler.types.NameAndType z_t2k;
    private net.rim.tools.compiler.types.NameAndType z_tVk;
    private net.rim.tools.compiler.types.NameAndType z_t1k;
    private byte z_tMaB[];
    private net.rim.tools.compiler.types.NameAndType z_tDk;
    private net.rim.tools.compiler.types.Type z_tUa;
    private net.rim.tools.compiler.types.Type z_tSa;
    private net.rim.tools.compiler.types.Type z_tQa;
    private Vector z_t0Vector;
    private net.rim.tools.compiler.types.ClassType z_txg;
    private net.rim.tools.compiler.types.Method z_tPc;
    private net.rim.tools.compiler.types.ClassType z_tZg;
    private net.rim.tools.compiler.types.Method z_tzc;
    private net.rim.tools.compiler.types.ClassType z_tLg;
    private net.rim.tools.compiler.types.Method z_tFc;
    private net.rim.tools.compiler.types.Method z_tEc;
    private int z_tTI;
    private net.rim.tools.compiler.classfile.InstructionTarget z_tCx;
    private static String str_init = "<init>";
    private static String str_clinit = "<clinit>";
    private static final int int_2 = 2;
    private static final int z_twI = 2;
    private static final int z_tHI = 4;
    private static final int z_tAI = 1;
    private static final int z_tuI = 0;
    private static final int z_tBI = 3;
    private static final int z_tYI = 1;
    private static final int z_ttI = 4;
    private static final int z_tyI = 49152;
    private static final int z_tNI = 8192;

    public GenerateResources(Compiler __compiler, String s, net.rim.tools.compiler.JadSupport __jadFile, Vector vector)
    {
        _compiler = __compiler;
        _className = "com.rim.resources." + s + "RIMResources";
        _jadFile = __jadFile;
        z_tJVector = vector;
        z_tOZ = __compiler.isMakingMIDlet();
    }

    public String getClassName()
    {
        return _className;
    }

    private int _ifkI(net.rim.tools.compiler.types.NameAndType k1)
    {
        return k1.getSize() != 8 ? 0 : 2;
    }

    private int _casecI(net.rim.tools.compiler.types.Method c1)
    {
        return !c1.is(0x20000) ? 0 : 1;
    }

    private int _cgI(net.rim.tools.compiler.types.ClassType g1)
    {
        return !g1.hasAttribute(0x20000) ? 0 : 1;
    }

    private net.rim.tools.compiler.types.ClassType _SStringg(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = _compiler.parseClass(s);
        if(g1 == null)
        {
            throw new net.rim.tools.compiler.util.CompileException(_className, "Unable to find type: " + s);
        } else
        {
            g1._aCompilervV(_compiler, false);
            g1._elseCompilerV(_compiler);
            return g1;
        }
    }

    private net.rim.tools.compiler.types.Method _agSac(net.rim.tools.compiler.types.ClassType g1, String s, net.rim.tools.compiler.types.Type a1, Vector vector)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.Method c1 = g1._aCompilerSac(_compiler, s, a1, vector, false, false);
        if(c1 == null)
            throw new net.rim.tools.compiler.util.CompileException(_className, "Class: " + g1.getFullName() + " has no member: " + s);
        else
            return c1;
    }

    private net.rim.tools.compiler.types.ClassType _gNvg()
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_txg == null)
        {
            z_txg = _SStringg("java.lang.String");
            z_t0Vector.setSize(0);
            z_t0Vector.addElement(_compiler.getObjectClass());
            z_tPc = _agSac(z_txg, "equals", _compiler.getBooleanType(), z_t0Vector);
        }
        return z_txg;
    }

    private net.rim.tools.compiler.types.ClassType _gKvg()
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_tZg == null)
        {
            z_tZg = _SStringg("java.lang.Integer");
            z_t0Vector.setSize(0);
            z_t0Vector.addElement(z_tUa);
            z_tzc = _agSac(z_tZg, str_init, null, z_t0Vector);
        }
        return z_tZg;
    }

    private net.rim.tools.compiler.types.ClassType _gPvg()
	throws net.rim.tools.compiler.util.CompileException
    {
        if(z_tLg == null)
        {
            _gNvg();
            z_tLg = _SStringg("java.util.Hashtable");
            z_t0Vector.setSize(0);
            z_t0Vector.addElement(z_tUa);
            z_tFc = _agSac(z_tLg, str_init, null, z_t0Vector);
            z_t0Vector.setSize(0);
            net.rim.tools.compiler.types.ClassType g1 = _compiler.getObjectClass();
            z_t0Vector.addElement(g1);
            z_t0Vector.addElement(g1);
            z_tEc = _agSac(z_tLg, "put", g1, z_t0Vector);
        }
        return z_tLg;
    }

    private net.rim.tools.compiler.types.Method _gSvc()
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentMethodModifiers(z_tKg, 144);
        net.rim.tools.compiler.types.Method c1 = new net.rim.tools.compiler.types.Method(z_tKg, str_init, null, 0, i1);
        c1._fOvV();
        net.rim.tools.compiler.analysis.InstructionCode f1 = new net.rim.tools.compiler.analysis.InstructionCode(c1, 4, 1, null, null);
        f1._eFvV();
        net.rim.tools.compiler.classfile.ai ai1 = new net.rim.tools.compiler.classfile.ai();
        z_tCx = ai1._bkIx(0);
        z_tTI = 0;
        net.rim.tools.compiler.types.ClassType g1 = z_tKg.getSuperClass();
        z_t0Vector.setSize(0);
        _gPvg();
        z_t0Vector.addElement(z_tLg);
        z_t0Vector.addElement(z_tLg);
        z_t0Vector.addElement(z_tQa);
        net.rim.tools.compiler.types.Method c2 = _agSac(g1, str_init, null, z_t0Vector);
        z_tCx._charIIV(z_tTI++, 14);
        z_tCx._charIIV(z_tTI++, 63);
        z_tCx._aIIgV(z_tTI++, 109 + _ifkI(z_t2k), z_tKg, z_t2k);
        z_tCx._aIIgV(z_tTI++, 109 + _ifkI(z_tVk), z_tKg, z_tVk);
        if(z_t1k != null)
            z_tCx._aIIgV(z_tTI++, 109 + _ifkI(z_t1k), z_tKg, z_t1k);
        else
            z_tCx._charIIV(z_tTI++, 34);
        z_tCx._aIIgV(z_tTI++, 5 + _casecI(c2), g1, c2);
        z_tCx._charIIV(z_tTI++, 31);
        z_tCx._biIV(4);
        z_tCx = null;
        f1._doaiV(ai1);
        c1.setInstructionCode(f1);
        return c1;
    }

    private void _ifkvV(net.rim.tools.compiler.types.NameAndType k1, int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        _gPvg();
        z_tCx.addInstruction(z_tTI++, 184 + _cgI(z_tLg), z_tLg);
        z_tCx._charIIV(z_tTI++, 207);
        z_tCx._doIIV(z_tTI++, 36, i1 <= 127 ? i1 : 127);
        z_tCx._aIIgV(z_tTI++, 5 + _casecI(z_tFc), z_tLg, z_tFc);
        z_tCx._aIIgV(z_tTI++, 105 + _ifkI(k1), z_tKg, k1);
    }

    private net.rim.tools.compiler.types.Method _gMvc()
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentMethodModifiers(z_tKg, 0x100002);
        net.rim.tools.compiler.types.Method c1 = new net.rim.tools.compiler.types.Method(z_tKg, str_clinit, null, 0, i1);
        c1._fOvV();
        net.rim.tools.compiler.analysis.InstructionCode f1 = new net.rim.tools.compiler.analysis.InstructionCode(c1, 3, 0, null, null);
        f1._eFvV();
        net.rim.tools.compiler.classfile.ai ai1 = new net.rim.tools.compiler.classfile.ai();
        z_tCx = ai1._bkIx(0);
        net.rim.tools.compiler.types.ClassType g1 = z_tKg.getSuperClass();
        z_tTI = 0;
        z_tCx._charIIV(z_tTI++, 14);
        z_tCx.addInstruction(z_tTI++, 186 + _cgI(g1), g1);
        z_tCx.addInstruction(z_tTI++, 19, z_tKg);
        z_tCx._charIIV(z_tTI++, 20);
        int j1 = z_tJVector.size();
        if(j1 > 0 || z_tOZ)
        {
            j1++;
            _ifkvV(z_t2k, (8 * j1) / 3 + 1);
        }
        if(z_tOZ)
        {
            int k1 = _jadFile.size();
            _ifkvV(z_tVk, (8 * k1) / 3 + 1);
        }
        f1._doaiV(ai1);
        c1.setInstructionCode(f1);
        return c1;
    }

    private void _gRvV()
    {
        z_tCx._charIIV(z_tTI++, 32);
        z_tCx._biIV(4);
        z_tCx = null;
    }

    private net.rim.tools.compiler.types.ClassType _cHIg(int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        String s = _className + "Populator" + i1;
        net.rim.tools.compiler.types.ClassType g1 = _compiler.parseClass(s);
        if(g1.isProcessed())
        {
            throw new net.rim.tools.compiler.util.DuplicateException(null, s, g1.getFullName());
        } else
        {
            g1.set_FlagProcessed();
            g1.setAttribute(_compiler.augmentClassModifiers(64));
            g1.set_superClassRef(_compiler.getObjectClass());
            g1._aCompilervV(_compiler, false);
            _compiler._agvV(g1, false);
            return g1;
        }
    }

    private net.rim.tools.compiler.types.Method _voidgc(net.rim.tools.compiler.types.ClassType g1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentMethodModifiers(g1, 2);
        net.rim.tools.compiler.types.Method c1 = new net.rim.tools.compiler.types.Method(g1, "populate", null, 1, i1);
        _gPvg();
        c1.add_parametersToMethod(0, "localZero", z_tLg);
        c1._fOvV();
        c1._cCompilerV(_compiler);
        net.rim.tools.compiler.analysis.InstructionCode f1 = new net.rim.tools.compiler.analysis.InstructionCode(c1, 4, 1, null, null);
        f1._eFvV();
        net.rim.tools.compiler.classfile.ai ai1 = new net.rim.tools.compiler.classfile.ai();
        z_tCx = ai1._bkIx(0);
        z_tTI = 0;
        z_tCx._charIIV(z_tTI++, 14);
        f1._doaiV(ai1);
        c1.setInstructionCode(f1);
        return c1;
    }

    private void _acV(net.rim.tools.compiler.types.Method c1, net.rim.tools.compiler.types.NameAndType k1)
	throws net.rim.tools.compiler.util.CompileException
    {
        if(k1.is(1024))
            z_tCx._charIIV(z_tTI++, 63 + k1.getOffset());
        else
            z_tCx._aIIgV(z_tTI++, 109 + _ifkI(k1), z_tKg, k1);
        net.rim.tools.compiler.types.ClassType g1 = c1.getClassType();
        z_tCx._aIIgV(z_tTI++, 7 + _casecI(c1), g1, c1);
    }

    private void _agStringV(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, String s, net.rim.tools.compiler.types.NameAndType k2)
	throws net.rim.tools.compiler.util.CompileException
    {
        g1._bUIV(s.length() + 4);
        _gPvg();
        if(k1.is(1024))
            z_tCx._charIIV(z_tTI++, 63 + k1.getOffset());
        else
            z_tCx._aIIgV(z_tTI++, 109 + _ifkI(k1), z_tKg, k1);
        z_tCx.addInstruction(z_tTI++, 40, FileHelper._xStringString(s));
        if(k2.is(1024))
            z_tCx._charIIV(z_tTI++, 63 + k2.getOffset());
        else
            z_tCx._aIIgV(z_tTI++, 109 + _ifkI(k2), z_tKg, k2);
        z_tCx._aIIgV(z_tTI++, 1, z_tLg, z_tEc);
        z_tCx._charIIV(z_tTI++, 205);
    }

    private net.rim.tools.compiler.types.NameAndType _agk(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.analysis.InstructionCode f1, net.rim.tools.compiler.types.Type a1)
    {
        if(z_tDk == null || z_tDk.getClassType() != g1)
            z_tDk = new net.rim.tools.compiler.types.NameAndType("_local", a1, g1, 1024, f1.inc_maxLocalsNumber());
        else
            z_tDk.setType(a1);
        return z_tDk;
    }

    private net.rim.tools.compiler.types.NameAndType _aStringk(String s, net.rim.tools.compiler.types.Type a1)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentFieldModifiers(z_tKg, 130);
        return z_tKg.add_processedField(_compiler, s, a1, i1, null);
    }

    private net.rim.tools.compiler.types.NameAndType _UStringk(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentFieldModifiers(z_tKg, 130);
        net.rim.tools.compiler.types.Field h1 = z_tKg.add_processedField(_compiler, s, _gPvg(), i1, null);
        return h1;
    }

    private void _akvV(net.rim.tools.compiler.types.NameAndType k1, int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        _gKvg();
        z_tCx.addInstruction(z_tTI++, 184 + _cgI(z_tZg), z_tZg);
        z_tCx._charIIV(z_tTI++, 207);
        z_tCx._doIIV(z_tTI++, 36, i1);
        z_tCx._aIIgV(z_tTI++, 5 + _casecI(z_tzc), z_tZg, z_tzc);
        if(k1.is(1024))
            z_tCx._charIIV(z_tTI++, 85 + k1.getOffset());
        else
            z_tCx._aIIgV(z_tTI++, 105 + _ifkI(k1), z_tKg, k1);
    }

    private void _agV(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, byte abyte0[])
	throws net.rim.tools.compiler.util.CompileException
    {
        g1._bUIV(abyte0.length + 4);
        _compiler.checkBinaryForExport(_className + '.' + k1.getName(), abyte0);
        int i1 = ((net.rim.tools.compiler.types.ArrayType)k1.getType()).getMostBaseType().getTypeId();
        z_tCx.addInstructionBytes(z_tTI++, 45, i1, abyte0);
        if(k1.is(1024))
            z_tCx._charIIV(z_tTI++, 85 + k1.getOffset());
        else
            z_tCx._aIIgV(z_tTI++, 105 + _ifkI(k1), z_tKg, k1);
    }

    private void _agV(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.types.NameAndType k1, int i1)
	throws net.rim.tools.compiler.util.CompileException
    {
        byte abyte0[] = new byte[1];
        abyte0[0] = (byte)i1;
        _agV(g1, k1, abyte0);
    }

    private void _aDataOutputStreamBV(DataOutputStream dataoutputstream, byte abyte0[])
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        if(abyte0 == null)
        {
            dataoutputstream.writeShort(0);
        } else
        {
            dataoutputstream.writeShort(abyte0.length);
            dataoutputstream.write(abyte0);
        }
    }

    private void _gTvV()
	throws net.rim.tools.compiler.util.CompileException
    {
        try
        {
            int i1 = _jadFile.getNumApplets();
            Object obj = null;
            ByteArrayOutputStream bytearrayoutputstream = null;
            DataOutputStream dataoutputstream = null;
            bytearrayoutputstream = new ByteArrayOutputStream();
            dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            boolean flag = true;
            for(int j1 = 0; j1 < i1; j1++)
            {
                net.rim.tools.compiler.Applet b1 = _jadFile.getApplet(j1);
                int k1 = 0;
                int l1 = b1.getNumIcons();
                for(int i2 = 0; i2 < l1; i2++)
                {
                    net.rim.tools.compiler.ImageFile a1 = b1.getIcon(i2);
                    if(a1 != null)
                    {
                        byte abyte0[] = a1.getData();
                        if(abyte0 != null)
                            k1 += 2 + abyte0.length;
                    }
                }

                dataoutputstream.writeShort(k1);
                if(k1 != 0)
                    flag = false;
                int j2 = 0;
                for(int k2 = 0; k2 < l1; k2++)
                {
                    net.rim.tools.compiler.ImageFile a2 = b1.getIcon(k2);
                    if(a2 != null)
                    {
                        byte abyte1[] = a2.getData();
                        if(abyte1 != null)
                        {
                            a2.setOrdinal(j2++);
                            _aDataOutputStreamBV(dataoutputstream, abyte1);
                        }
                    }
                }

            }

            if(flag)
            {
                z_t1k = null;
                z_tMaB = null;
            } else
            {
                z_t1k = _aStringk("_appIcons", z_tQa);
                z_tMaB = bytearrayoutputstream.toByteArray();
            }
        }
        catch(IOException ioexception)
        {
            throw new net.rim.tools.compiler.util.CompileException(_className, ioexception.toString());
        }
    }

    private void _dgV(ClassType g1)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int i1 = _jadFile.getNumApplets();
        Object obj = null;
        Object obj1 = null;
        ByteArrayOutputStream bytearrayoutputstream = null;
        DataOutputStream dataoutputstream = null;
        bytearrayoutputstream = new ByteArrayOutputStream();
        dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        boolean flag = true;
        for(int j1 = 0; j1 < i1; j1++)
        {
            net.rim.tools.compiler.Applet b1 = _jadFile.getApplet(j1);
            String s = b1.getName();
            if(s == null)
            {
                dataoutputstream.writeShort(0);
            } else
            {
                dataoutputstream.writeUTF(s);
                flag = false;
            }
        }

        dataoutputstream.close();
        if(!flag)
        {
            net.rim.tools.compiler.types.NameAndType k1 = _aStringk("_appNames", z_tQa);
            _agV(g1, k1, bytearrayoutputstream.toByteArray());
        }
        dataoutputstream.close();
        if(z_t1k != null)
            _agV(g1, z_t1k, z_tMaB);
        bytearrayoutputstream = new ByteArrayOutputStream();
        dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        flag = true;
        for(int l1 = 0; l1 < i1; l1++)
        {
            net.rim.tools.compiler.Applet b2 = _jadFile.getApplet(l1);
            String s1 = b2.getClassName();
            if(s1 == null)
            {
                dataoutputstream.writeShort(0);
            } else
            {
                dataoutputstream.writeUTF(s1);
                flag = false;
            }
        }

        dataoutputstream.close();
        if(!flag)
        {
            net.rim.tools.compiler.types.NameAndType k2 = _aStringk("_appArgs", z_tQa);
            _agV(g1, k2, bytearrayoutputstream.toByteArray());
        }
    }

    private net.rim.tools.compiler.types.NameAndType _agk(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.analysis.InstructionCode f1, int i1)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        net.rim.tools.compiler.types.NameAndType k1 = _agk(g1, f1, z_tUa);
        _akvV(k1, i1);
        return k1;
    }

    private net.rim.tools.compiler.types.NameAndType _agk(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.analysis.InstructionCode f1, String s, Object obj)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        NameAndType k1;
        if(s == null)
            k1 = _agk(g1, f1, z_tQa);
        else
            k1 = _aStringk(s, z_tQa);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        if(obj instanceof byte[])
        {
            byte abyte0[] = (byte[])obj;
            dataoutputstream.write(abyte0);
        } else
        if(obj != null)
            dataoutputstream.writeUTF(obj.toString());
        dataoutputstream.close();
        _agV(g1, k1, bytearrayoutputstream.toByteArray());
        return k1;
    }

    private void _agV(net.rim.tools.compiler.types.ClassType g1, net.rim.tools.compiler.analysis.InstructionCode f1, String s, String s1, int i1)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
        int j1 = _jadFile.getNumApplets();
        boolean flag = true;
        for(int l1 = 0; l1 < j1; l1++)
        {
            String s2 = s1 + (l1 + 1);
            String s3 = _jadFile.getProperty(s2);
            switch(i1)
            {
            case 4: // '\004'
            default:
                break;

            case 0: // '\0'
                if(s3 == null)
                {
                    dataoutputstream.writeByte(0);
                } else
                {
                    dataoutputstream.writeByte(Integer.parseInt(s3));
                    flag = false;
                }
                break;

            case 1: // '\001'
                if(s3 == null)
                {
                    dataoutputstream.writeShort(0);
                } else
                {
                    dataoutputstream.writeShort(Integer.parseInt(s3));
                    flag = false;
                }
                break;

            case 2: // '\002'
                if(s3 == null)
                {
                    dataoutputstream.writeInt(0);
                } else
                {
                    dataoutputstream.writeInt(Integer.parseInt(s3));
                    flag = false;
                }
                break;

            case 3: // '\003'
                if(s3 == null)
                {
                    dataoutputstream.writeLong(0L);
                } else
                {
                    dataoutputstream.writeLong(Long.parseLong(s3));
                    flag = false;
                }
                break;

            case 5: // '\005'
                if(s3 == null)
                {
                    dataoutputstream.writeShort(0);
                } else
                {
                    dataoutputstream.writeUTF(s3);
                    flag = false;
                }
                break;
            }
        }

        dataoutputstream.close();
        if(!flag)
        {
            net.rim.tools.compiler.types.NameAndType k1;
            if(s == null)
                k1 = _agk(g1, f1, z_tQa);
            else
                k1 = _aStringk(s, z_tQa);
            _agV(g1, k1, bytearrayoutputstream.toByteArray());
        }
    }

    private void _bgV(net.rim.tools.compiler.types.ClassType g1)
	throws net.rim.tools.compiler.util.CompileException, IOException
    {
        int l1 = _jadFile.get_keyFilesNumber();
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        if(l1 > 0)
        {
            net.rim.tools.compiler.types.NameAndType k2 = _aStringk("_securityVendorIds", z_tUa.getArrayType());
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            DataOutputStream dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            for(int i1 = 0; i1 < l1; i1++)
            {
                i i2 = _jadFile.get_keyFileByIndex(i1);
                dataoutputstream.writeInt(i2._ifvI());
            }

            dataoutputstream.close();
            _agV(g1, k2, bytearrayoutputstream.toByteArray());
            k2 = _aStringk("_securityDescriptions", z_tQa);
            bytearrayoutputstream = new ByteArrayOutputStream();
            dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            for(int j1 = 0; j1 < l1; j1++)
            {
                i j2 = _jadFile.get_keyFileByIndex(j1);
                if(_compiler._newIh(j2._ifvI()) != null)
                    dataoutputstream.writeShort(0);
                else
                    dataoutputstream.writeUTF(j2._avString());
            }

            dataoutputstream.close();
            _agV(g1, k2, bytearrayoutputstream.toByteArray());
            k2 = _aStringk("_securityKeys", z_tQa);
            bytearrayoutputstream = new ByteArrayOutputStream();
            dataoutputstream = new DataOutputStream(bytearrayoutputstream);
            for(int k1 = 0; k1 < l1; k1++)
            {
                i l2 = _jadFile.get_keyFileByIndex(k1);
                if(_compiler._newIh(l2._ifvI()) != null)
                    dataoutputstream.writeShort(0);
                else
                    _aDataOutputStreamBV(dataoutputstream, l2._dovaB());
            }

            dataoutputstream.close();
            _agV(g1, k2, bytearrayoutputstream.toByteArray());
        }
    }

    private void _aStringV(String s, Object obj)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_tKg._bUIV(s.length() + 4);
        _gNvg();
        z_tCx._charIIV(z_tTI++, 64);
        z_tCx.addInstruction(z_tTI++, 40, s);
        z_tCx._aIIgV(z_tTI++, 1, z_txg, z_tPc);
        z_tCx.addInstructionBranch(z_tTI++, 147);
        z_tCx._newxV((net.rim.tools.compiler.classfile.InstructionTarget)obj);
    }

    private void _TStringV(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = _SStringg(s);
        z_t0Vector.setSize(0);
        net.rim.tools.compiler.types.Method c1 = _agSac(g1, str_init, null, z_t0Vector);
        z_tCx.addInstruction(z_tTI++, 184 + _cgI(g1), g1);
        z_tCx._charIIV(z_tTI++, 207);
        z_tCx._aIIgV(z_tTI++, 5 + _casecI(c1), g1, c1);
        z_tCx._charIIV(z_tTI++, 27);
    }

    private void _gOvV()
	throws net.rim.tools.compiler.util.CompileException
    {
        net.rim.tools.compiler.types.ClassType g1 = _SStringg("java.lang.IllegalArgumentException");
        z_t0Vector.setSize(0);
        net.rim.tools.compiler.types.Method c1 = _agSac(g1, str_init, null, z_t0Vector);
        z_tCx.addInstruction(z_tTI++, 184 + _cgI(g1), g1);
        z_tCx._charIIV(z_tTI++, 207);
        z_tCx._aIIgV(z_tTI++, 5 + _casecI(c1), g1, c1);
        z_tCx._charIIV(z_tTI++, 188);
        z_tCx._biIV(4);
    }

    private net.rim.tools.compiler.types.Method _gUvc()
	throws net.rim.tools.compiler.util.CompileException
    {
        int i1 = _compiler.augmentMethodModifiers(z_tKg, 128);
        net.rim.tools.compiler.types.Method c1 = new net.rim.tools.compiler.types.Method(z_tKg, "instantiateMIDlet", _compiler.getObjectClass(), 1, i1);
        c1.add_parametersToMethod(0, "name", _gNvg());
        c1._fOvV();
        net.rim.tools.compiler.analysis.InstructionCode f1 = new net.rim.tools.compiler.analysis.InstructionCode(c1, 2, 2, null, null);
        f1._eFvV();
        z_tTI = 0;
        net.rim.tools.compiler.classfile.ai ai1 = new net.rim.tools.compiler.classfile.ai();
        z_tCx = ai1._bkIx(0);
        z_tCx._charIIV(z_tTI++, 14);
        int j1 = _jadFile.getNumApplets();
        for(int k1 = 0; k1 < j1; k1++)
        {
            net.rim.tools.compiler.Applet b1 = _jadFile.getApplet(k1);
            String s = b1.getClassName();
            if(s != null && s.length() > 0)
            {
                net.rim.tools.compiler.classfile.InstructionTarget x1 = new net.rim.tools.compiler.classfile.InstructionTarget(0, 0, null, null);
                _aStringV(s, x1);
                net.rim.tools.compiler.classfile.InstructionTarget x2 = new net.rim.tools.compiler.classfile.InstructionTarget(0, 0, null, null);
                z_tCx._doxV(x2);
                z_tCx = x2;
                ai1._doxvV(x2, ai1._d3vI() - 1);
                _TStringV(s);
                ai1._doxvV(x1, ai1._d3vI() - 1);
                z_tCx = x1;
            }
        }

        _gOvV();
        z_tCx = null;
        f1._doaiV(ai1);
        c1.setInstructionCode(f1);
        return c1;
    }

    private void _gLvV()
    {
        int i1 = z_tJVector.size();
        for(int j1 = i1 - 1; j1 >= 0; j1--)
        {
            net.rim.tools.compiler.ResourceFile d1 = (net.rim.tools.compiler.ResourceFile)z_tJVector.elementAt(j1);
            if(d1.isEmpty())
                continue;
            if(!z_tOZ && (d1 instanceof net.rim.tools.compiler.ImageFile))
            {
                net.rim.tools.compiler.ImageFile a1 = (net.rim.tools.compiler.ImageFile)d1;
                if(a1.isIcon() && a1.getOrdinal() != -1)
                    continue;
            }
            byte abyte0[] = d1.getData();
            int k1 = abyte0.length;
            if(k1 > 61440)
            {
                String s = d1.getRelativeName();
                int l1 = 0;
                int i2 = 8192;
                while(l1 < k1)
                {
                    byte abyte1[] = new byte[i2];
                    System.arraycopy(abyte0, l1, abyte1, 0, i2);
                    if(l1 == 0)
                    {
                        d1.resetData(abyte1);
                    } else
                    {
                        StringBuffer stringbuffer = new StringBuffer();
                        stringbuffer.append("__").append(s).append('@').append(l1);
                        z_tJVector.addElement(new net.rim.tools.compiler.ResourceFile(stringbuffer.toString(), abyte1, true));
                    }
                    l1 += i2;
                    if(l1 + i2 > k1)
                        i2 = k1 - l1;
                }
            }
        }

    }

    public net.rim.tools.compiler.types.ClassType generateResourceClass(String s)
	throws net.rim.tools.compiler.util.CompileException
    {
        z_t0Vector = new Vector();
        z_tUa = _compiler.getIntType();
        z_tSa = _compiler.getByteType();
        z_tQa = z_tSa.getArrayType();
        z_tKg = _compiler.parseClass(_className);
        if(z_tKg.isProcessed())
            throw new net.rim.tools.compiler.util.DuplicateException(null, _className, z_tKg.getFullName());
        z_tKg.set_FlagProcessed();
        z_tKg.setAttribute(_compiler.augmentClassModifiers(192));
        _compiler._agvV(z_tKg, false);
        net.rim.tools.compiler.types.ClassType g1 = _SStringg("net.rim.device.resources.Resource");
        z_tKg.set_superClassRef(g1);
        z_tKg._aCompilervV(_compiler, false);
        z_t2k = _UStringk("_resources");
        z_tVk = _UStringk("_properties");
        if(_jadFile.getNumApplets() > 0)
        {
            _gTvV();
            if(z_tOZ)
            {
                z_tKg.createMethods(3);
                z_tKg._aCompilerV(_compiler, _gUvc());
            } else
            {
                z_tKg.createMethods(2);
            }
        }
        if(!_compiler._dvZ())
            _gLvV();
        z_tKg._aCompilerV(_compiler, _gSvc());
        net.rim.tools.compiler.types.Method c1 = _gMvc();
        z_tKg._aCompilerV(_compiler, c1);
        net.rim.tools.compiler.analysis.InstructionCode f1 = c1.getInstructionCode();
        net.rim.tools.compiler.classfile.InstructionTarget x1 = z_tCx;
        if(_compiler._gvZ() && _jadFile.getNumApplets() == 0)
        {
            int i1 = 0;
            String s1 = _jadFile.getProperty(net.rim.tools.compiler.ResourceIds.z_sString);
            if(s1 != null)
                i1 = Integer.parseInt(s1);
            net.rim.tools.compiler.types.NameAndType k2 = _aStringk(net.rim.tools.compiler.ResourceIds.z_oString, z_tQa);
            _agV(z_tKg, k2, i1);
        }
        net.rim.tools.compiler.types.NameAndType k1 = _aStringk("_appCount", z_tQa);
        _agV(z_tKg, k1, _jadFile.getNumApplets());
        byte abyte0[] = s.getBytes();
        try
        {
            abyte0 = s.getBytes("UTF-8");
        }
        catch(UnsupportedEncodingException unsupportedencodingexception) { }
        net.rim.tools.compiler.types.NameAndType k3 = _aStringk("_resourceExtensions", z_tQa);
        _agV(z_tKg, k3, abyte0);
        try
        {
            if(_jadFile.getNumApplets() > 0)
            {
                _dgV(z_tKg);
                int j2 = net.rim.tools.compiler.ResourceIds.z_newaString.length;
                for(int j1 = 0; j1 < j2; j1++)
                {
                    String s2 = net.rim.tools.compiler.ResourceIds.z_newaString[j1];
                    if(s2 != null)
                        _agV(z_tKg, f1, s2, net.rim.tools.compiler.ResourceIds.z_maString[j1], net.rim.tools.compiler.ResourceIds.z_caseaI[j1]);
                }

            }
            for(Enumeration enumeration = _jadFile.keys(); enumeration.hasMoreElements();)
            {
                String s3 = (String)enumeration.nextElement();
                String s4 = net.rim.tools.compiler.ResourceIds.getId(s3);
                if(z_tOZ)
                {
                    net.rim.tools.compiler.types.NameAndType k5 = _agk(z_tKg, f1, s4, _jadFile.getProperty(s3));
                    _agStringV(z_tKg, z_tVk, s3, k5);
                } else
                if(s4 != null && !s4.startsWith(net.rim.tools.compiler.ResourceIds.z_tString) && !s4.equals(net.rim.tools.compiler.ResourceIds.z_paString[0]) && !s4.equals(net.rim.tools.compiler.ResourceIds.z_gaString[0]))
                    _agk(z_tKg, f1, s4, _jadFile.getProperty(s3));
            }

            _bgV(z_tKg);
            if(z_tOZ)
            {
                net.rim.tools.compiler.ResourceFile d1 = _jadFile.getManifest();
                net.rim.tools.compiler.types.NameAndType k4 = _agk(z_tKg, f1, "_manifest", d1.getData());
                _agStringV(z_tKg, z_t2k, d1.getRelativeName(), k4);
            }
            int l2 = z_tJVector.size();
            if(l2 > 0)
            {
                z_tCx = null;
                Vector vector = new Vector();
                net.rim.tools.compiler.types.ClassType g2 = null;
                net.rim.tools.compiler.types.Method c2 = null;
                net.rim.tools.compiler.analysis.InstructionCode f2 = null;
                net.rim.tools.compiler.types.NameAndType k6 = null;
                boolean flag = false;
                flag = z_tKg.hasAttribute(0x40000);
                for(int l1 = 0; l1 < l2; l1++)
                {
                    if(c2 == null)
                    {
                        z_tDk = null;
                        g2 = _cHIg(vector.size());
                        c2 = _voidgc(g2);
                        g2._aCompilerV(_compiler, c2);
                        vector.addElement(c2);
                        f2 = c2.getInstructionCode();
                        k6 = c2.getParameter(0);
                    }
                    net.rim.tools.compiler.ResourceFile d2 = (net.rim.tools.compiler.ResourceFile)z_tJVector.elementAt(l1);
                    if(!d2.isEmpty())
                    {
                        net.rim.tools.compiler.types.NameAndType k7 = null;
                        if(!z_tOZ && (d2 instanceof net.rim.tools.compiler.ImageFile))
                        {
                            net.rim.tools.compiler.ImageFile a1 = (net.rim.tools.compiler.ImageFile)d2;
                            if(a1.isIcon() && a1.getOrdinal() != -1)
                                k7 = _agk(g2, f2, a1.getOrdinal());
                        }
                        if(k7 == null)
                            k7 = _agk(g2, f2, null, d2.getData());
                        String s5 = d2.getRelativeName();
                        String s6 = net.rim.tools.compiler.util.FileHelper._zStringString(s5);
                        if(s5.equals(s6) || z_tOZ)
                        {
                            _agStringV(g2, k6, s5, k7);
                        } else
                        {
                            if(d2.isSlice())
                                s6 = "__" + s6;
                            _agStringV(g2, k6, s6, k7);
                            if(!flag)
                                _agStringV(g2, k6, s5, k7);
                        }
                    }
                    if(l1 == l2 - 1 || g2._fmvI() + ((net.rim.tools.compiler.ResourceFile)z_tJVector.elementAt(l1 + 1)).getData().length > 49152)
                    {
                        z_tCx._charIIV(z_tTI++, 31);
                        z_tCx._biIV(4);
                        c2 = null;
                        z_tCx = null;
                    }
                }

                z_tCx = x1;
                l2 = vector.size();
                for(int i2 = 0; i2 < l2; i2++)
                {
                    net.rim.tools.compiler.types.Method c3 = (net.rim.tools.compiler.types.Method)vector.elementAt(i2);
                    _acV(c3, z_t2k);
                }

            }
        }
        catch(IOException ioexception)
        {
            throw new net.rim.tools.compiler.util.CompileException(_className, ioexception.toString());
        }
        _gRvV();
        z_tKg._elseCompilerV(_compiler);
        return z_tKg;
    }

}
