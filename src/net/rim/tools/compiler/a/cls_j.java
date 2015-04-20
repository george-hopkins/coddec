// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            p, o, e, h,
//            m, k, c, s,
//            f, d

public class cls_j extends cls_p
{

    private cls_o z_Fo;
    private Vector f_parametersV;
    private Vector f_localsV;
    private Vector f_linesV;
    private Object z_IaObject[];
    private String z_KString;

    public cls_j()
    {
    }

    public cls_j(String s1, cls_e e1, int i, int l, cls_o o1)
    {
        super(s1, e1, i, l);
        z_Fo = o1;
        f_parametersV = new Vector();
        f_localsV = new Vector();
        f_linesV = new Vector();
    }

    cls_j(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        _aDataInputStreamV(datainputstream, f);
    }

    void _aDataInputStreamV(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f);
        z_Fo = new cls_o(datainputstream, f);
        f_parametersV = cls_e._newDataInputStreamVector(datainputstream, f);
        f_localsV = cls_h._doDataInputStreamVector(datainputstream, f);
        f_linesV = cls_m._ifDataInputStreamVector(datainputstream, f);
    }

    void _adV(cls_d d)
        throws IOException
    {
        super._adV(d);
        z_Fo._adV(d);
        cls_c._adVV(d, f_parametersV, "parameters");
        cls_c._adVV(d, f_localsV, "locals");
        cls_c._adVV(d, f_linesV, "lines");
    }

    static Vector _forDataInputStreamVector(DataInputStream datainputstream, cls_f f)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int l = 0; l < i; l++)
            vector.addElement(new cls_j(datainputstream, f));

        return vector;
    }

    protected int _voidvI()
        throws IOException
    {
        throw new IOException("DebugInformation: DebugMethod has no flavour value");
    }

    public void _doeV(cls_e e1)
    {
        f_parametersV.addElement(e1);
    }

    public void _ahV(cls_h h1)
    {
        f_localsV.addElement(h1);
    }

    public void _amV(cls_m m1)
    {
        f_linesV.addElement(m1);
    }

    public cls_o _hvo()
    {
        return z_Fo;
    }

    public void _ifoV(cls_o o1)
    {
        z_Fo = o1;
    }

    public int _jvI()
    {
        return f_parametersV.size();
    }

    public cls_e _bIe(int i)
    {
        return (cls_e)f_parametersV.elementAt(i);
    }

    public int _kvI()
    {
        return f_localsV.size();
    }

    public cls_h _voidIh(int i)
    {
        return (cls_h)f_localsV.elementAt(i);
    }

    public int _lvI()
    {
        return f_linesV.size();
    }

    public cls_m _cIm(int i)
    {
        return (cls_m)f_linesV.elementAt(i);
    }

    public Object[] _ivaObject()
    {
        if(z_IaObject == null)
        {
            z_IaObject = new Object[f_linesV.size()];
            for(int i = 0; i < f_linesV.size(); i++)
                z_IaObject[i] = f_linesV.elementAt(i);

        }
        return z_IaObject;
    }

    public String _mvString()
    {
        if(z_KString == null)
        {
            z_KString = _intvString();
            if(z_KString.equals("<init>"))
                z_KString = _cvk()._AvString();
            if(z_KString.equals("<clinit>"))
            {
                z_KString = "static {}";
                return z_KString;
            }
            z_KString += "( ";
            boolean flag = true;
            int i;
            if((_evI() & 2) == 0)
                i = 1;
            else
                i = 0;
            for(; i < f_parametersV.size(); i++)
            {
                if(!flag)
                    z_KString += ", ";
                flag = false;
                Object obj = f_parametersV.elementAt(i);
                if(obj instanceof cls_k)
                {
                    cls_k k1 = (cls_k)obj;
                    z_KString += k1._AvString();
                } else
                {
                    z_KString += obj.toString();
                }
            }

            z_KString += " )";
        }
        return z_KString;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        z_Fo._ifPrintStreamvV(printstream, flag);
        printstream.println();
        int i = f_parametersV.size();
        if(i > 0)
        {
            for(int l = 0; l < i; l++)
            {
                printstream.print("    Parameter ");
                printstream.print(Integer.toString(l));
                printstream.print(": ");
                printstream.print(((cls_e)f_parametersV.elementAt(l))._intvString());
                printstream.println();
            }

        }
        i = f_localsV.size();
        if(i > 0)
        {
            for(int i1 = 0; i1 < i; i1++)
            {
                printstream.print("    Local ");
                printstream.print(Integer.toString(i1));
                printstream.print(":");
                ((cls_h)f_localsV.elementAt(i1))._doPrintStreamvV(printstream, flag);
            }

        }
        i = f_linesV.size();
        if(i > 0)
        {
            for(int j1 = 0; j1 < i; j1++)
            {
                printstream.print("    LineInfo ");
                printstream.print(Integer.toString(j1));
                printstream.print(":");
                ((cls_m)f_linesV.elementAt(j1))._aPrintStreamvV(printstream, flag);
            }

        }
    }
}
