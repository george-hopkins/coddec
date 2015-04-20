// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            e, p, j, c,
//            f, d, s

public class cls_k extends cls_e
{

    public static final int z_YI = 0;
    private cls_k z_ack;
    private int f_attributesI;
    private int f_moduleIDI;
    private int f_keyIDI;
    private int f_offsetI;
    private String f_packageNameS;
    private String f_fileName;
    private Vector z_afVector;
    private Vector z_ZVector;
    private Vector z_RVector;
    private Vector z_aeVector;
    private int f_fieldsNumI;
    private int f_staticsNumI;
    private int f_methodsNumI;
    private int f_interfacesNumI;

    public cls_k()
    {
    }

    public cls_k(cls_k k1, String s1, int i, int l, int i1, int j1, int l1,
            int i2, String s2, String s3)
    {
        super(s1, i, l);
        z_ack = k1;
        f_attributesI = i1;
        f_moduleIDI = j1;
        f_keyIDI = l1;
        f_offsetI = i2;
        if(s2 == null)
            f_packageNameS = "";
        else
            f_packageNameS = s2;
        f_fileName = s3;
        z_afVector = new Vector();
        z_ZVector = new Vector();
        z_RVector = new Vector();
        z_aeVector = new Vector();
    }

    cls_k(DataInputStream datainputstream, cls_f f1, int i)
        throws IOException
    {
        super(datainputstream, f1, i);
    }

    private void _aVectorV(Vector vector)
    {
        for(int i = 0; i < vector.size(); i++)
        {
            cls_p p1 = (cls_p)vector.elementAt(i);
            p1._akV(this);
        }

    }

    void _dodV(cls_d d1)
        throws IOException
    {
        super._dodV(d1);
        (z_ack != null ? z_ack : this)._adV(d1);
        cls_p._adVV(d1, z_afVector, "fields");
        cls_p._adVV(d1, z_ZVector, "statics");
        cls_c._adVV(d1, z_RVector, "methods");
        cls_c._adVV(d1, z_aeVector, "interfaces");
    }

    void _byteDataInputStreamV(DataInputStream datainputstream, cls_f f1)
        throws IOException
    {
        super._byteDataInputStreamV(datainputstream, f1);
        z_ack = (cls_k)cls_e._caseDataInputStreame(datainputstream, f1);
        if(z_ack == this)
            z_ack = null;
        z_afVector = cls_p._aDataInputStreamVector(datainputstream, f1, this);
        f_fieldsNumI = z_afVector.size();
        _aVectorV(z_afVector);
        z_ZVector = cls_p._aDataInputStreamVector(datainputstream, f1, this);
        f_staticsNumI = z_ZVector.size();
        _aVectorV(z_ZVector);
        z_RVector = cls_j._forDataInputStreamVector(datainputstream, f1);
        f_methodsNumI = z_RVector.size();
        _aVectorV(z_RVector);
        if(f1._bytevI() > 4)
            z_aeVector = cls_e._newDataInputStreamVector(datainputstream, f1);
        else
            z_aeVector = new Vector();
        f_interfacesNumI = z_aeVector.size();
    }

    void _ifdV(cls_d d1)
        throws IOException
    {
        super._ifdV(d1);
        d1._aIStringV(f_attributesI, "attributes");
        d1._aIStringV(f_moduleIDI, "moduleId");
        d1._aIStringV(f_keyIDI, "keyId");
        d1._aIStringV(f_offsetI, "offset");
        cls_c._adSV(d1, f_packageNameS, "packageName");
        cls_c._adSV(d1, f_fileName, "fileName");
        d1._aIStringV(f_fieldsNumI, "numFields");
        d1._aIStringV(f_staticsNumI, "numStatics");
        d1._aIStringV(f_methodsNumI, "numMethods");
        d1._aIStringV(f_interfacesNumI, "numInterfaces");
    }

    void _charDataInputStreamV(DataInputStream datainputstream, cls_f f1)
        throws IOException
    {
        f_attributesI = datainputstream.readInt();
        f_moduleIDI = datainputstream.readInt();
        if(f1._bytevI() > 5)
            f_keyIDI = datainputstream.readInt();
        else
            f_keyIDI = 0;
        f_offsetI = datainputstream.readInt();
        f_packageNameS = cls_c.read_string(datainputstream);
        f_fileName = cls_c.read_string(datainputstream);
        f_fieldsNumI = datainputstream.readInt();
        f_staticsNumI = datainputstream.readInt();
        f_methodsNumI = datainputstream.readInt();
        if(f1._bytevI() > 4)
            f_interfacesNumI = datainputstream.readInt();
    }

    private void _xvV()
    {
        if(_ovf() != null)
            _ovf()._charvV();
    }

    public void _ifkV(cls_k k1)
    {
        z_ack = k1;
    }

    public String _EvString()
    {
        return f_packageNameS;
    }

    public void _ifpV(cls_p p1)
    {
        _xvV();
        z_afVector.addElement(p1);
        f_fieldsNumI = z_afVector.size();
        p1._akV(this);
    }

    public void _apV(cls_p p1)
    {
        _xvV();
        z_ZVector.addElement(p1);
        f_staticsNumI = z_ZVector.size();
    }

    public void _ajV(cls_j j1)
    {
        _xvV();
        z_RVector.addElement(j1);
        f_methodsNumI = z_RVector.size();
        j1._akV(this);
    }

    public void _dokV(cls_k k1)
    {
        _xvV();
        z_aeVector.addElement(k1);
        f_interfacesNumI = z_aeVector.size();
    }

    public cls_k _zvk()
    {
        _xvV();
        return z_ack;
    }

    public int _rvI()
    {
        return f_attributesI;
    }

    public void _oIV(int i)
    {
        f_attributesI = i;
    }

    public int _yvI()
    {
        return f_moduleIDI;
    }

    public void _lIV(int i)
    {
        f_moduleIDI = i;
    }

    public int _uvI()
    {
        return f_keyIDI;
    }

    public void _iIV(int i)
    {
        f_keyIDI = i;
    }

    public int _svI()
    {
        return f_offsetI;
    }

    public void _mIV(int i)
    {
        f_offsetI = i;
    }

    public void _doStringV(String s1)
    {
        f_packageNameS = s1;
    }

    public String _wvString()
    {
        return f_fileName;
    }

    public void _forStringV(String s1)
    {
        f_fileName = s1;
    }

    public int _CvI()
    {
        return f_fieldsNumI;
    }

    public int get_typeSize()
    {
        _xvV();
        return super.get_typeSize();
    }

    public cls_p _gIp(int i)
    {
        _xvV();
        return (cls_p)z_afVector.elementAt(i);
    }

    public cls_p _nIp(int i)
    {
        _xvV();
        for(int l = z_afVector.size() - 1; l >= 0; l--)
        {
            cls_p p1 = (cls_p)z_afVector.elementAt(l);
            if(p1._bvI() == i)
                return p1;
        }

        return null;
    }

    public int _BvI()
    {
        return f_staticsNumI;
    }

    public cls_p _jIp(int i)
    {
        _xvV();
        return (cls_p)z_ZVector.elementAt(i);
    }

    public int _vvI()
    {
        return f_methodsNumI;
    }

    public cls_j _kIj(int i)
    {
        _xvV();
        return (cls_j)z_RVector.elementAt(i);
    }

    public int _DvI()
    {
        return f_interfacesNumI;
    }

    public cls_k _hIk(int i)
    {
        _xvV();
        return (cls_k)z_aeVector.elementAt(i);
    }

    public String _AvString()
    {
        return _intvString();
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        _xvV();
        if(f_packageNameS != null && f_packageNameS.length() > 0)
        {
            printstream.print(" package=");
            printstream.print(f_packageNameS);
        }
        super._doPrintStreamvV(printstream, flag);
        if(z_ack != null)
        {
            printstream.print(" super=");
            printstream.print(z_ack._tvString());
        }
        if(flag)
        {
            printstream.print(" moduleId=");
            printstream.print(Integer.toString(f_moduleIDI));
        }
        if(f_offsetI != -1)
            printstream.print(cls_d._aStringIString(" offset=0x", f_offsetI, 2));
        if(f_keyIDI != 0)
            printstream.print(cls_c._ifIString(f_keyIDI));
        printstream.println();
        printstream.print("    ");
        printstream.print(cls_c._doIString(f_attributesI));
        printstream.print(" fileName=");
        printstream.println(f_fileName);
        int i = z_aeVector.size();
        if(i > 0)
        {
            for(int l = 0; l < i; l++)
            {
                printstream.print("  Interface ");
                printstream.print(Integer.toString(l));
                printstream.print(": ");
                printstream.print(((cls_k)z_aeVector.elementAt(l))._tvString());
                printstream.println();
            }

        }
        i = z_afVector.size();
        if(i > 0)
        {
            for(int i1 = 0; i1 < i; i1++)
            {
                printstream.print("  Field ");
                printstream.print(Integer.toString(i1));
                printstream.print(":");
                ((cls_p)z_afVector.elementAt(i1))._doPrintStreamvV(printstream, flag);
                printstream.println();
            }

        }
        i = z_ZVector.size();
        if(i > 0)
        {
            for(int j1 = 0; j1 < i; j1++)
            {
                printstream.print("  Static ");
                printstream.print(Integer.toString(j1));
                printstream.print(":");
                ((cls_p)z_ZVector.elementAt(j1))._doPrintStreamvV(printstream, flag);
                printstream.println();
            }

        }
        i = z_RVector.size();
        if(i > 0)
        {
            for(int k1 = 0; k1 < i; k1++)
            {
                printstream.print("  Method ");
                printstream.print(Integer.toString(k1));
                printstream.print(":");
                ((cls_j)z_RVector.elementAt(k1))._doPrintStreamvV(printstream, flag);
            }

        }
    }

    public String _tvString()
    {
        if(_EvString().length() == 0)
        {
            return _intvString();
        } else
        {
            StringBuffer stringbuffer = new StringBuffer(_EvString());
            stringbuffer.append(".");
            stringbuffer.append(_intvString());
            return stringbuffer.toString();
        }
    }

    public String toString()
    {
        return _tvString();
    }
}
