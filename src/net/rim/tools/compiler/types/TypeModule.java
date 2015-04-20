// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.types;

import java.io.UnsupportedEncodingException;
import java.util.Vector;
import net.rim.tools.compiler.Compiler;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.codfile.ExportedData;
import net.rim.tools.compiler.codfile.DataBytes;
import net.rim.tools.compiler.codfile.Codfile;
import net.rim.tools.compiler.codfile.Module;
import net.rim.tools.compiler.codfile.DataSection;
import net.rim.tools.compiler.codfile.ClassDef;
import net.rim.tools.compiler.util.CompileException;

// Referenced classes of package net.rim.tools.compiler.h:
//            g

public final class TypeModule
implements net.rim.tools.compiler.vm.Constants
{

    private static final String z_sfString = ".UNDF";
    private String _name;
    private String _version;
    private int _timeStamp;
    private boolean _isBrittle;
    private String z_soString;
    private Vector z_srVector;
    private Vector z_spVector;
    private Vector z_stVector;
    private Codfile _codFile;
    private Vector _classes;
    private StringBuffer z_shStringBuffer;
    private int f_codeWeightI;
    private int f_dataWeightI;
    private int z_ssI;
    private int z_sgI;
    private int f_numICallsI;
    private int _staticDataSize;
    private int f_maxTypeListSizeI;
    private net.rim.tools.compiler.codfile.Module _modules[];
    private int f_ordinalI;
    private int f_countI;

    public TypeModule(String __name, String __version, int __timeStamp, net.rim.tools.compiler.codfile.Codfile __codFile)
    {
        _name = __name;
        _version = __version;
        _timeStamp = __timeStamp;
        _codFile = __codFile;
        f_dataWeightI = 74;
        f_ordinalI = -1;
        f_countI = 1;
        z_stVector = new Vector();
    }

    public void setOrdinalCount(int i, int j)
    {
        f_ordinalI = i;
        f_countI = j;
        getModule(this);
    }

    public String getName()
    {
        return _name;
    }

    public Codfile getCodfile()
    {
        return _codFile;
    }

    public boolean isBrittle()
    {
        return _isBrittle;
    }

    public void setBrittle()
    {
        _isBrittle = true;
    }

    public void _KStringV(String s)
    {
        z_soString = s;
    }

    public String _gjvString()
    {
        return z_soString;
    }

    public int _gmvI()
    {
        return z_srVector != null ? z_srVector.size() : 0;
    }

    public String[] _ceIaString(int i)
    {
        return (String[])z_srVector.elementAt(i);
    }

    public void _gotoStringV(String s, String s1)
    {
        if(z_srVector == null)
            z_srVector = new Vector();
        String as[] = new String[2];
        as[0] = s;
        as[1] = s1;
        z_srVector.addElement(as);
    }

    public void _LStringV(String s)
    {
        if(z_spVector == null)
            z_spVector = new Vector();
        if(z_spVector.indexOf(s) == -1)
            z_spVector.addElement(s);
    }

    public void _tryVectorV(Vector vector)
    {
        int i = vector != null ? vector.size() : 0;
        if(i > 0 && z_spVector == null)
            z_spVector = new Vector(i);
        for(int j = 0; j < i; j++)
            z_spVector.addElement(vector.elementAt(j));

    }

    public Vector _gbvVector()
    {
        return z_spVector;
    }

    public void _aCompilerV(Compiler __compiler, ClassType __class, String s)
        throws CompileException
    {
        if(z_stVector.indexOf(s) == -1)
            z_stVector.addElement(s);
        int i = 0;
        String s1 = null;
        try
        {
            int j = s.indexOf('=');
            i = Integer.parseInt(s.substring(0, j), 16);
            s1 = s.substring(j + 1);
        }
        catch(Exception exception) { }
        if(__class != null && i != 0 && __compiler._forIZ(i))
        {
            if(s1 == null || s1.length() == 0)
                s1 = "0x" + Integer.toHexString(i);
            __compiler.generateWarning(true, null, "Reference to class: " + __class.getFullName() + " requires signing with key: " + s1);
        }
    }

    public void _aCompilerV(Compiler compiler, ClassType g1, int i)
        throws CompileException
    {
        String s = (String)z_spVector.elementAt(i);
        _aCompilerV(compiler, g1, s);
    }

    public Vector _gdvVector()
    {
        return z_stVector;
    }

    public net.rim.tools.compiler.codfile.DataSection getDataSection()
    {
        return _codFile.getDataSection();
    }

    public Module getModule(TypeModule __module)
    {
        if(_modules == null)
            _modules = new net.rim.tools.compiler.codfile.Module[__module.getCount()];
        int i = __module.getOrdinal();
        if(_modules[i] == null)
        {
            boolean flag = f_ordinalI != -1 && this != __module;
            net.rim.tools.compiler.codfile.DataSection _dataSection_ = __module.getDataSection();
            _modules[i] = _dataSection_.getModule(_name, _version, _timeStamp, flag, _isBrittle);
        }
        return _modules[i];
    }

    public int getOrdinal()
    {
        return f_ordinalI;
    }

    public int getCount()
    {
        return f_countI;
    }

    public boolean _gkvZ()
    {
        return _modules != null;
    }

    public net.rim.tools.compiler.types.ClassType getClass(int i)
    {
        return (net.rim.tools.compiler.types.ClassType)_classes.elementAt(i);
    }

    public int getClassNum()
    {
        Vector vector = _classes;
        return vector != null ? vector.size() : 0;
    }

    public void _nullgV(net.rim.tools.compiler.types.ClassType g1)
    {
        g1.setTypeModule(this);
        Vector vector = _classes;
        if(vector == null)
        {
            vector = new Vector();
            _classes = vector;
        } else
        {
            int i = vector.size();
            for(int j = 0; j < i; j++)
                if(g1._casegI((net.rim.tools.compiler.types.ClassType)vector.elementAt(j)) < 0)
                {
                    vector.insertElementAt(g1, j);
                    return;
                }

        }
        vector.addElement(g1);
    }

    public void optimize()
        throws CompileException
    {
        Vector _classes_ = _classes;
        if(_classes_ == null)
            throw new CompileException("No classes found");
        int i = _classes_.size();
        for(int j = 0; j < i; j++)
        {
            ClassType _class_ = (ClassType)_classes_.elementAt(j);
            _class_.getClassDef(this);
        }

    }

    public void populate(Compiler __compiler, int __flags)
        throws CompileException
    {
        Vector _classes_ = _classes;
        int _classesNum_ = _classes_.size();
        for(int l = 0; l < _classesNum_; l++)
        {
            ClassType _class_ = (ClassType)_classes_.elementAt(l);
            _class_._caseCompilerV(__compiler);
        }

        _codFile.setFlags(__flags);
        _codFile.setTimeStamp(_timeStamp);
        _codFile.setMaxTypeListSize(f_maxTypeListSizeI);
        net.rim.tools.compiler.codfile.DataSection _dataSection_ = getDataSection();
        _dataSection_.setStaticSize(_staticDataSize);
        _dataSection_.setIcallIndex(f_numICallsI);
        if(z_shStringBuffer != null)
        {
            byte abyte0[] = null;
            try
            {
                abyte0 = z_shStringBuffer.toString().getBytes("UTF-8");
            }
            catch(UnsupportedEncodingException unsupportedencodingexception) { }
            z_shStringBuffer = null;
            net.rim.tools.compiler.codfile.Bytes a2 = _dataSection_.getDataBytes().getBytes(abyte0, 2, false);
            _dataSection_.addExport(new net.rim.tools.compiler.codfile.ExportedData(_dataSection_, a2, ".UNDF"));
        }
        _codFile.writeWeightsString("codeWeight=" + f_codeWeightI + " dataWeight=" + f_dataWeightI);
    }

    public void addUndefinedClass(String s)
    {
        int i = s.length() * 2;
        if(z_shStringBuffer == null)
        {
            z_shStringBuffer = new StringBuffer();
            i += 13;
        } else
        {
            z_shStringBuffer.append(',');
            i++;
        }
        inc_dataWeight(i);
        z_shStringBuffer.append(s);
    }

    public ClassDef _amSu(TypeModule m1, String s, String s1)
    {
        return getModule(m1).makeClassDef(m1.getDataSection(), s, s1);
    }

    public ClassDef _trymu(TypeModule m1)
    {
        return getModule(m1).getNullClassDef();
    }

    public void inc_dataWeight(int i)//inc data weight by
    {
        f_dataWeightI += i;
    }

    public int get_dataWeight()
    {
        return f_dataWeightI;
    }

    public void inc_codeWeight(int i) // inc code weight by
    {
        f_codeWeightI += i;
    }

    public int get_codeWeight()
    {
        return f_codeWeightI;
    }

    public void _cfIV(int i)
    {
        z_ssI += i;
    }

    public int _f8vI()
    {
        return z_ssI;
    }

    public void _ckIV(int i)
    {
        z_sgI += i;
    }

    public int _gnvI()
    {
        return z_sgI;
    }

    public int _gavI()
    {
        return f_numICallsI++;
    }

    public int allocateStaticData(int __size)
    {
        int j = _staticDataSize;
        _staticDataSize += __size;
        return j;
    }

    public void setMaxTypeListSize(int i)
    {
        if(i > f_maxTypeListSizeI)
            f_maxTypeListSizeI = i;
    }
}
