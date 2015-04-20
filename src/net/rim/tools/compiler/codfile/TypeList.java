// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, x, k

public final class TypeList extends net.rim.tools.compiler.codfile.CodfileItem
{

    private boolean _comperssable;
    private net.rim.tools.compiler.codfile.TypeItem _typeList[];
    private static Vector z_fsVector = new Vector();
    private static StringBuffer z_frStringBuffer = new StringBuffer();
    private static int f_index = 0;

    public String get_name_2()
    {
        if(super._nameS == null)
            synchronized(z_frStringBuffer)
            {
                z_frStringBuffer.setLength(0);
                z_frStringBuffer.append("typelist_");
                z_frStringBuffer.append(++f_index);
                super._nameS = z_frStringBuffer.toString();
            }
        return super._nameS;
    }

    private void _aVectorV(Vector vector)
    {
        int i = vector.size();
        _typeList = new net.rim.tools.compiler.codfile.TypeItem[i];
        for(int j = 0; j < i; j++)
            _typeList[j] = (net.rim.tools.compiler.codfile.TypeItem)vector.elementAt(j);

    }

    public TypeList(int i)
    {
        super(i);
        _comperssable = true;
    }

    public TypeList(net.rim.tools.compiler.codfile.TypeItem x1)
    {
        _comperssable = true;
        _typeList = new net.rim.tools.compiler.codfile.TypeItem[1];
        _typeList[0] = x1;
    }

    public TypeList(Vector vector)
    {
        _comperssable = true;
        _aVectorV(vector);
    }

    public TypeList(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.codfile.DataSection k)
        throws IOException
    {
        super(a1);
        _comperssable = false;
        int i = a1.readUnsignedByte();
        int l = 0;
        if((i & 0x80) == 0)
        {
            l = (i & 0x70) >> 4;
        } else
        {
            l = i & 0x7f;
            i = a1.readUnsignedByte();
            if((l & 0x40) != 0)
            {
                l &= 0xffffffbf;
                l <<= 4;
                l += (i & 0xf0) >> 4;
            }
            l--;
        }
        if(l > 0)
            synchronized(z_fsVector)
            {
                z_fsVector.setSize(0);
                l--;
                int i1 = a1.getOffset() + l;
                z_fsVector.addElement(net.rim.tools.compiler.codfile.TypeItem.read(a1, k, i));
                while(a1.getOffset() < i1)
                {
                    int j = a1.readUnsignedByte();
                    net.rim.tools.compiler.codfile.TypeItem x1 = net.rim.tools.compiler.codfile.TypeItem.read(a1, k, j);
                    j >>= 4;
                    if(j != 0)
                        _comperssable = true;
                    do
                        z_fsVector.addElement(x1);
                    while(j-- > 0);
                }
                _aVectorV(z_fsVector);
                z_fsVector.setSize(0);
            }
    }

    public static int _ifkBII(net.rim.tools.compiler.codfile.DataSection k, byte abyte0[], int i)
    {
        int j = i;
        byte byte0 = abyte0[j++];
        int l = 0;
        if((byte0 & 0x80) == 0)
        {
            l = (byte0 & 0x70) >> 4;
        } else
        {
            l = byte0 & 0x7f;
            byte0 = abyte0[j++];
            if((l & 0x40) != 0)
            {
                l &= 0xffffffbf;
                l <<= 4;
                l += (byte0 & 0xf0) >> 4;
            }
            l--;
        }
        if(l > 0)
        {
            l--;
            int i1 = j + l;
            for(j += net.rim.tools.compiler.codfile.TypeItem._akBII(k, abyte0, j, byte0); j < i1; j += net.rim.tools.compiler.codfile.TypeItem._akBII(k, abyte0, j, byte0))
                byte0 = abyte0[j++];

        }
        return j - i;
    }

    public void _ifkV(net.rim.tools.compiler.codfile.DataSection k)
    {
        int i = length();
        for(int j = 0; j < i; j++)
            _typeList[j].makeSymbolic(k);

    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        setOffset(c1);
        c1.writeString(get_name_2());
        int i = length();
        c1.writeString(": count=");
        c1.empty_func8(i);
        if(i == 0)
        {
            c1.writeByte(0, " [ <empty-list> ]", false);
        } else
        {
            int j = _typeList[0].getExtent();
            if(i > 1)
            {
                int k = 0;
                net.rim.tools.compiler.codfile.TypeItem x1 = _typeList[1];
                for(int i1 = 1; i1 < i; i1++)
                {
                    net.rim.tools.compiler.codfile.TypeItem x3 = i1 >= i - 1 ? null : _typeList[i1 + 1];
                    if(_comperssable && k < 15 && x1.equals(x3))
                    {
                        k++;
                    } else
                    {
                        j += x1.getExtent();
                        k = 0;
                        x1 = x3;
                    }
                }

            }
            if(j > 7)
                if(++j < 64)
                {
                    c1.writeByte(128 + j);
                    j = 0;
                } else
                {
                    c1.writeByte(192 + (j >> 4));
                    j &= 0xf;
                }
            c1.writeString(" [ ");
            _typeList[0].write(c1, j);
            if(i > 1)
            {
                int l = 0;
                net.rim.tools.compiler.codfile.TypeItem x2 = _typeList[1];
                for(int j1 = 1; j1 < i; j1++)
                {
                    TypeItem x4 = j1 >= i - 1 ? null : _typeList[j1 + 1];
                    if(_comperssable && l < 15 && x2.equals(x4))
                    {
                        l++;
                    } else
                    {
                        if(l > 0)
                        {
                            c1.writeString(", RLE=");
                            c1.empty_func8(l);
                            c1.writeString(" ");
                        } else
                        {
                            c1.writeString(", ");
                        }
                        x2.write(c1, l);
                        l = 0;
                        x2 = x4;
                    }
                }

            }
            c1.writeString(" ]");
        }
        setExtent(c1);
    }

    public void setCompressable(boolean flag)
    {
        _comperssable = _comperssable && flag;
    }

    public int length()
    {
        return _typeList != null ? _typeList.length : 0;
    }

    public net.rim.tools.compiler.codfile.TypeItem get_baseType()
    {
        return _typeList != null && _typeList.length != 0 ? _typeList[0] : null;
    }

    public net.rim.tools.compiler.codfile.TypeItem get_type(int i)
    {
        return _typeList[i];
    }

    public int _axvI()
    {
        int i = length();
        int j = i;
        for(int k = 0; k < i; k++)
        {
            int l = _typeList[k].getId();
            if(l == 6 || l == 12)
                j++;
        }

        return j;
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.TypeList p1 = (net.rim.tools.compiler.codfile.TypeList)obj;
        if(this == p1)
            return 0;
        int i = length();
        int j = p1.length();
        if(i < j)
            return -1;
        if(i > j)
            return 1;
        for(int k = 0; k < i; k++)
        {
            int l = _typeList[k].compareTo(p1._typeList[k]);
            if(l != 0)
                return l;
        }

        return 0;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.codfile.TypeList)
        {
            net.rim.tools.compiler.codfile.TypeList p1 = (net.rim.tools.compiler.codfile.TypeList)obj;
            if(this == p1)
                return true;
            int i = length();
            if(i != p1.length())
                return false;
            for(int j = 0; j < i; j++)
                if(!_typeList[j].equals(p1._typeList[j]))
                    return false;

            return true;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        int i = 0x12345678;
        int j = length();
        for(int k = 0; k < j; k++)
            i = i * 31 + _typeList[k].hashCode();

        return i;
    }

}
