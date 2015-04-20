// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.exec.MyArrays;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, j, z, af,
//            a4, k, ar

public final class FixupTableEntry extends net.rim.tools.compiler.codfile.CodfileItem
{

    private static final int z_hcI = 7;
    private int z_heI;
    private boolean z_hfZ;
    private net.rim.tools.compiler.codfile.CodfileItem _item;
    private int z_hhI;
    private int z_hdaI[];
    private boolean _aliases;

    public FixupTableEntry(int i)
    {
        z_heI = i;
        setOrdinal(-1);
    }

    private void read(net.rim.tools.compiler.io.StructuredInputStream __input)
        throws IOException
    {
        if(_aliases)
        {
			super._extent = __input.readUnsignedShort1();
            z_hdaI = new int[super._extent];
        } else
        {
            int i = __input.readUnsignedShort();
            z_hdaI = new int[i];
            super._extent = i * 2;
        }
        int k = __input.getOffset() + super._extent;
        int l = 0;
        int i1 = 0;
        while(__input.getOffset() < k)
            if(_aliases)
            {
                int j1 = __input.readUnsignedShort1() + i1;
                z_hdaI[l++] = j1;
                i1 = j1;
            } else
            {
                z_hdaI[l++] = __input.readUnsignedShort();
            }
        z_hhI = l;
    }

    public FixupTableEntry(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.codfile.CodfileItem ap1, int i, boolean flag, boolean flag1)
        throws IOException
    {
        super(a1);
        z_heI = i;
        _aliases = flag;
        z_hfZ = flag1;
        _item = ap1;
        if(!z_hfZ)
        {
            read(a1);
        } else
        {
            super._extent = 0;
            z_hhI = 0;
        }
    }

    public void _ifkZV(net.rim.tools.compiler.codfile.DataSection k, boolean flag, boolean flag1)
        throws IOException
    {
        if(_item instanceof net.rim.tools.compiler.codfile.MemberRef)
        {
            net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)_item;
            j1._akZV(k, flag, flag1);
        }
    }

    public void _ifarV(net.rim.tools.compiler.codfile.ar ar)
    {
        if(_item instanceof net.rim.tools.compiler.codfile.MemberRef)
        {
            net.rim.tools.compiler.codfile.MemberRef j1 = (net.rim.tools.compiler.codfile.MemberRef)_item;
            j1._aarV(ar);
        }
    }

    private void _lcV(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(z_hdaI != null)
        {
            c1.writeSlack(z_heI);
            _item.write(c1);
            c1.empty_func7();
            c1.empty_func();
            int i = z_hhI;
            if(_aliases)
            {
                c1.writeMultibyteShort(super._extent, "extent=", true);
                setOffset(c1);
            } else
            {
                c1.writeShort(i, "count=", true);
            }
            c1.empty_func7();
            int k = 0;
            for(int l = 0; l < i; l++)
            {
                if(_aliases)
                {
                    c1.writeString("offset=");
                    c1.empty_func3(z_hdaI[l], 2);
                    c1.writeMultibyteShort(z_hdaI[l] - k, " delta=", true);
                } else
                {
                    c1.writeShort(z_hdaI[l], "offset=", true);
                }
                c1.empty_func7();
                k = z_hdaI[l];
            }

            if(_aliases)
                if(super._extent == 0)
                {
                    setExtent(c1);
                    if((super._extent & 0xc000) != 0)
                    {
                        c1.writeShort(0);
                        super._offset += 2;
                    } else
                    if((super._extent & 0x3f80) != 0)
                    {
                        c1.writeByte(0);
                        super._offset++;
                    }
                } else
                {
                    setExtent(c1);
                }
            c1.empty_func7();
            c1.empty_func2();
        }
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        if(!z_hfZ)
            _lcV(c1);
        else
        if(z_hdaI != null)
        {
            c1.writeSlack(z_heI);
            _item.write(c1);
            c1.writeString("ordinal=");
            c1.empty_func8(super._ordinal);
            c1.empty_func7();
            c1.empty_func();
            c1.writeString("offset=");
            c1.empty_func3(z_hdaI[0], 2);
            c1.empty_func7();
            c1.empty_func2();
        }
    }

    public void _newZV(boolean flag)
    {
        _aliases = flag;
    }

    public net.rim.tools.compiler.codfile.CodfileItem getItem()
    {
        return _item;
    }

    public void setItem(net.rim.tools.compiler.codfile.CodfileItem ap1)
    {
        _item = ap1;
    }

    public void _intZV(boolean flag)
    {
        z_hfZ = flag;
    }

    public void _adIV(int i)
    {
        if(z_hdaI == null)
            z_hdaI = new int[8];
        if(z_hhI == z_hdaI.length)
            z_hdaI = net.rim.tools.compiler.exec.MyArrays.resize(z_hdaI, z_hhI * 2);
        z_hdaI[z_hhI++] = i;
    }

    public void _aaBIaV(byte abyte0[], int i, byte abyte1[])
    {
        int k = abyte1.length;
        int l = z_hhI;
        for(int i1 = 0; i1 < l; i1++)
        {
            int j1 = z_hdaI[i1];
            j1 += i;
            for(int k1 = 0; k1 < k; k1++)
                abyte0[j1 + k1] = abyte1[k1];

        }

    }

    public void _aafvV(net.rim.tools.compiler.codfile.Module af1, boolean flag)
    {
        net.rim.tools.compiler.codfile.Member r = ((net.rim.tools.compiler.codfile.MemberRef)_item).getMember();
        int i = z_hhI;
        for(int k = 0; k < i; k++)
        {
            int l = z_hdaI[k];
            net.rim.tools.compiler.codfile.RoutineLocal z1 = (net.rim.tools.compiler.codfile.RoutineLocal)af1.find(l);
            z1.getCode()._ifIrV(l, r, flag);
        }

    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.FixupTableEntry an1 = (net.rim.tools.compiler.codfile.FixupTableEntry)obj;
        int i = z_hdaI[0];
        int k = an1.z_hdaI[0];
        return i - k;
    }
}
