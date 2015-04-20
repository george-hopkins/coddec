// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            s, r, n, k,
//            a, d, f, c

public class cls_e extends net.rim.tools.compiler.a.cls_s
implements net.rim.tools.compiler.a.cls_a
{

    protected int f_typeTagI;
    private int f_typeSizeI;
    private net.rim.tools.compiler.a.cls_f z_Of;
    protected int z_PI;

    public cls_e()
    {
    }

    public cls_e(String param_typeNameS, int param_typeTagI, int param_typeSizeI)
    {
        super(param_typeNameS);
        f_typeTagI = param_typeTagI;
        f_typeSizeI = param_typeSizeI;
    }

    cls_e(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1, int i)
        throws IOException
    {
        super._aDataInputStreamV(datainputstream, f1);
        f_typeTagI = i;
        z_Of = f1;
    }

    void _ifdV(net.rim.tools.compiler.a.cls_d d1)
        throws IOException
    {
        d1._aIStringV(f_typeTagI, "id");
        super._adV(d1);
    }

    static Vector _tryDataInputStreamVector(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int j = 0; j < i; j++)
        {
            int l = datainputstream.readInt();
            switch(l)
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
					vector.addElement(new net.rim.tools.compiler.a.cls_r(datainputstream, f1, l));
                break;

            case 8: // '\b'
					vector.addElement(new net.rim.tools.compiler.a.cls_n(datainputstream, f1, l));
                break;

            case 7: // '\007'
					net.rim.tools.compiler.a.cls_k k1 = new net.rim.tools.compiler.a.cls_k(datainputstream, f1, l);
                vector.addElement(k1);
                k1._charDataInputStreamV(datainputstream, f1);
                break;

            case 9: // '\t'
            default:
                throw new IOException("DebugInformation: unrecognized type id " + l + " at index " + j);
            }
        }

        return vector;
    }

    static void _adV(net.rim.tools.compiler.a.cls_d d1, net.rim.tools.compiler.a.cls_f f1, Vector vector)
        throws IOException
    {
        int i = vector.size();
        d1._aIStringV(i, "Vector type dictionary");
        d1._ifvV();
        for(int j = 0; j < i; j++)
        {
            d1._ifStringV("type dictionary element[ " + j + " ]");
            d1._ifvV();
            net.rim.tools.compiler.a.cls_e e1 = (net.rim.tools.compiler.a.cls_e)vector.elementAt(j);
            e1.z_PI = j;
            e1._ifdV(d1);
            d1._dovV();
        }

        d1._dovV();
    }

    void _byteDataInputStreamV(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1)
        throws IOException
    {
        f_typeSizeI = datainputstream.readInt();
    }

    void _dodV(net.rim.tools.compiler.a.cls_d d1)
        throws IOException
    {
        d1._aIStringV(f_typeSizeI, "size");
    }

    static Vector _aDataInputStreamVector(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1, Vector vector)
        throws IOException
    {
        int i = datainputstream.readInt();
        if(i != vector.size())
            throw new IOException("DebugInformationError: file contains " + i + " type definitions, but dictionary lists " + vector.size() + " entries.");
        for(int j = 0; j < i; j++)
            ((net.rim.tools.compiler.a.cls_e)vector.elementAt(j))._byteDataInputStreamV(datainputstream, f1);

        return vector;
    }

    static void _adV(cls_d d1, Vector vector)
        throws IOException
    {
        int i = vector.size();
        d1._aIStringV(i, "Vector definition");
        d1._ifvV();
        for(int j = 0; j < i; j++)
        {
            net.rim.tools.compiler.a.cls_e e1 = (net.rim.tools.compiler.a.cls_e)vector.elementAt(j);
            d1._ifStringV("definition element[ " + j + " ]: " + ((net.rim.tools.compiler.a.cls_s) (e1)).z_jString);
            d1._ifvV();
            e1._dodV(d1);
            d1._dovV();
        }

        d1._dovV();
    }

    void _adV(net.rim.tools.compiler.a.cls_d d1)
        throws IOException
    {
        d1._aIStringV(z_PI, "type index, name=" + super.z_jString);
    }

    static cls_e _caseDataInputStreame(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1)
        throws IOException
    {
        return f1._charIe(datainputstream.readInt());
    }

    static Vector _newDataInputStreamVector(DataInputStream datainputstream, net.rim.tools.compiler.a.cls_f f1)
        throws IOException
    {
        int i = datainputstream.readInt();
        Vector vector = new Vector(i);
        for(int j = 0; j < i; j++)
            vector.addElement(_caseDataInputStreame(datainputstream, f1));

        return vector;
    }

    public int get_typeTag()
    {
        return f_typeTagI;
    }

    public void set_typeTag(int i)
    {
        f_typeTagI = i;
    }

    public int get_typeSize()
    {
        return f_typeSizeI;
    }

    public void set_typeSize(int i)
    {
        f_typeSizeI = i;
    }

    public cls_f _ovf()
    {
        return z_Of;
    }

    public void _afV(net.rim.tools.compiler.a.cls_f f1)
    {
        z_Of = f1;
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        super._doPrintStreamvV(printstream, flag);
        if(flag)
            printstream.print(net.rim.tools.compiler.a.cls_c._aIString(f_typeTagI));
        printstream.print(" size=");
        printstream.print(Integer.toString(f_typeSizeI));
    }
}
