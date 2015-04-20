// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.a;

import java.io.*;
import java.util.Vector;

// Referenced classes of package net.rim.tools.compiler.a:
//            s, e, q, k,
//            c, d

public class cls_f extends cls_s
{

    public static final int z_qI = 4;
    public static final int z_sI = 5;
    public static final int z_mI = 6;
    public static final int z_rI = 7;
    public static final int z_uI = 8;
    private int z_nI;
    private int f_timeStampI;
    private String f_workSpaceNameS;
    private Vector z_pVector;
    private Vector f_keysV;
    private DataInputStream z_kDataInputStream;

    public cls_f()
    {
    }

    public cls_f(String s1, int i, String s2)
    {
        super(s1);
        z_nI = 8;
        f_timeStampI = i;
        f_workSpaceNameS = s2;
        z_pVector = new Vector();
        f_keysV = new Vector();
    }

    public cls_f(DataInputStream datainputstream)
        throws IOException
    {
        z_kDataInputStream = datainputstream;
        _elsevV();
    }

    public void _charvV()
    {
        if(z_kDataInputStream != null)
        {
            try
            {
                cls_e._aDataInputStreamVector(z_kDataInputStream, this, z_pVector);
            }
            catch(IOException ioexception)
            {
                ioexception.printStackTrace();
            }
            z_kDataInputStream = null;
        }
    }

    public void _elsevV()
        throws IOException
    {
        z_nI = z_kDataInputStream.readInt();
        if(z_nI != 8 && z_nI != 7 && z_nI != 6 && z_nI != 5 && z_nI != 4)
            throw new IOException("DebugInformation version mismatch, file is " + z_nI + " code wants " + 8);
        f_timeStampI = z_kDataInputStream.readInt();
        if(z_nI > 7)
            f_workSpaceNameS = cls_c.read_string(z_kDataInputStream);
        else
            f_workSpaceNameS = "";
        super._aDataInputStreamV(z_kDataInputStream, this);
        z_pVector = cls_e._tryDataInputStreamVector(z_kDataInputStream, this);
        if(z_nI > 6)
            f_keysV = cls_q._intDataInputStreamVector(z_kDataInputStream, this);
        else
            f_keysV = new Vector();
    }

    public void _adV(cls_d d1)
        throws IOException
    {
        _charvV();
        d1._aStringV("Debug Information");
        d1._aIStringV(8, "version");
        d1._aIStringV(f_timeStampI, "timeStamp");
        cls_c._adSV(d1, f_workSpaceNameS, "workspace");
        super._adV(d1);
        cls_e._adV(d1, this, z_pVector);
        cls_c._adVV(d1, f_keysV, "keys");
        cls_e._adV(d1, z_pVector);
        d1._ifStringV("end");
    }

    public int _bytevI()
    {
        return z_nI;
    }

    public cls_e _charIe(int i)
    {
        return (cls_e)z_pVector.elementAt(i);
    }

    public void _aeV(cls_e e1)
    {
        _charvV();
        z_pVector.addElement(e1);
        e1._afV(this);
    }

    public cls_q _caseIq(int i)
    {
        return (cls_q)f_keysV.elementAt(i);
    }

    public void _aqV(cls_q q1)
    {
        f_keysV.addElement(q1);
    }

    public int _tryvI()
    {
        return f_timeStampI;
    }

    public void _elseIV(int i)
    {
        f_timeStampI = i;
    }

    public int _casevI()
    {
        return z_pVector.size();
    }

    public int _newvI()
    {
        return f_keysV.size();
    }

    public void _doPrintStreamvV(PrintStream printstream, boolean flag)
    {
        _charvV();
        printstream.print("Module:");
        super._doPrintStreamvV(printstream, flag);
        printstream.print(" version=");
        printstream.print(Integer.toString(z_nI));
        printstream.print(cls_d._aStringIString(" timestamp=0x", f_timeStampI, 4));
        printstream.print(" workspace=");
        printstream.println(f_workSpaceNameS);
        int l = f_keysV.size();
        for(int i = 0; i < l; i++)
        {
            cls_q q1 = (cls_q)f_keysV.elementAt(i);
            printstream.print("Key ");
            printstream.print(Integer.toString(i));
            printstream.print(":");
            q1._doPrintStreamvV(printstream, flag);
        }

        l = z_pVector.size();
        for(int j = 0; j < l; j++)
        {
            cls_e e1 = (cls_e)z_pVector.elementAt(j);
            boolean flag1 = flag;
            if(!flag1 && (e1 instanceof cls_k))
            {
                cls_k k1 = (cls_k)e1;
                if(k1._yvI() == 0)
                    flag1 = true;
            }
            if(flag1)
            {
                printstream.print("Type ");
                printstream.print(Integer.toString(j));
                printstream.print(":");
                e1._doPrintStreamvV(printstream, flag);
            }
        }

        printstream.println();
    }
}
