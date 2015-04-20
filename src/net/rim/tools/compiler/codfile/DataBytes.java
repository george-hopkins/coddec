// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.util.Vector;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, am, ag, ak,
//            al, ac, t, a,
//            f, h, aq

public final class DataBytes extends net.rim.tools.compiler.codfile.CodfileItem
{

    private net.rim.tools.compiler.codfile.CodfileVectorHash _unicodeLiterals;
    private net.rim.tools.compiler.codfile.CodfileVector _bytes;
    private net.rim.tools.compiler.codfile.CodfileVectorHash _identifiers;
    private net.rim.tools.compiler.codfile.CodfileVectorHash _literals;
    private net.rim.tools.compiler.codfile.Identifier _identifier;
    private boolean z_hKZ;
    private net.rim.tools.compiler.codfile.al z_hMal;
    private net.rim.tools.compiler.codfile.ac z_hEac;
    private net.rim.tools.compiler.codfile.t z_hFt;
    private net.rim.tools.compiler.codfile.Bytes z_hDa;
    private byte _data[];
    private int _start;

    public DataBytes()
    {
        _unicodeLiterals = new net.rim.tools.compiler.codfile.CodfileVectorHash(5);
        _bytes = new net.rim.tools.compiler.codfile.CodfileVector();
        _identifiers = new net.rim.tools.compiler.codfile.CodfileVectorHash(131);
        _literals = new net.rim.tools.compiler.codfile.CodfileVectorHash(131);
        _identifier = new net.rim.tools.compiler.codfile.Identifier();
        _unicodeLiterals.setTableName("unicode literals");
        _bytes.setTableName("data bytes");
        _identifiers.setTableName("identifiers");
        _literals.setTableName("literals");
        z_hMal = new net.rim.tools.compiler.codfile.al(this);
        z_hEac = new net.rim.tools.compiler.codfile.ac(this);
        z_hFt = new net.rim.tools.compiler.codfile.t(this);
        z_hDa = new net.rim.tools.compiler.codfile.Bytes(65535, 0);
    }

    private void addIdentifiers(net.rim.tools.compiler.codfile.CodfileVectorHash __identifiers)
        throws IOException
    {
        int i = __identifiers.size();
        for(int j = 0; j < i; j++)
        {
            net.rim.tools.compiler.codfile.CodfileData _data_ = (net.rim.tools.compiler.codfile.CodfileData)__identifiers.elementAt(j);
            _data_.resolveName(this);
            String s = _data_.getString();
            __identifiers.inject(s != null ? ((Object) (s)) : ((Object) (_identifier.getString())), _data_);
        }

    }

    private void addBytes(net.rim.tools.compiler.codfile.CodfileVector __bytes)
        throws IOException
    {
        int i = __bytes.size();
        for(int j = 0; j < i; j++)
        {
            net.rim.tools.compiler.codfile.CodfileData f1 = (net.rim.tools.compiler.codfile.CodfileData)__bytes.elementAt(j);
            f1.resolveName(this);
        }

    }

    void read(net.rim.tools.compiler.io.StructuredInputStream __input, boolean flag)
        throws IOException
    {
        z_hKZ = flag;
        __input.verifyOffset(super._offset, "data bytes");
        _data = __input.getBytes();
        _start = __input.getStart();
        addIdentifiers(_unicodeLiterals);
        addBytes(_bytes);
        addIdentifiers(_identifiers);
        addIdentifiers(_literals);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c)
        throws IOException
    {
        setOffset(c);
        _unicodeLiterals._trycvV(c, true);
        _bytes._trycvV(c, true);
        _identifiers._trycvV(c, true);
        _literals._trycvV(c, true);
        setExtent(c);
    }

    public net.rim.tools.compiler.codfile.Identifier getNullIdentifier()
    {
        return _identifier;
    }

    public net.rim.tools.compiler.codfile.Identifier getIdentifier(String s)
    {
        if(s == null)
            s = _identifier.getString();
        net.rim.tools.compiler.codfile.CodfileVectorHash am1 = _identifiers;
        net.rim.tools.compiler.codfile.Identifier ak1 = (net.rim.tools.compiler.codfile.Identifier)am1.get(s);
        if(ak1 == null)
        {
            ak1 = new net.rim.tools.compiler.codfile.Identifier(s);
            am1.put(s, ak1);
        }
        return ak1;
    }

    public net.rim.tools.compiler.codfile.Bytes getBytes(byte abyte0[], int i, boolean flag)
    {
        net.rim.tools.compiler.codfile.Bytes a2 = null;
        net.rim.tools.compiler.codfile.CodfileVector ag1 = _bytes;
        int j = ag1.size();
        for(int k = 0; k < j; k++)
        {
            a2 = (net.rim.tools.compiler.codfile.Bytes)ag1.elementAt(k);
            boolean flag1 = a2.getNeedsHeader();
            int l = !flag || !flag1 ? -1 : i;
            if(a2._aaBIZ(abyte0, l))
            {
                if(flag && !flag1)
                {
                    a2.setNeedsHeader();
                    a2.setArrayType(i);
                }
                return a2;
            }
        }

        a2 = new net.rim.tools.compiler.codfile.Bytes(abyte0, i, flag);
        ag1.addElementOrdered(a2);
        return a2;
    }

    public net.rim.tools.compiler.codfile.Literal getLiteral(String __name, boolean __isUnicode, boolean __needsHeader)
    {
        if(__name == null)
            __name = _identifier.getString();
        net.rim.tools.compiler.codfile.CodfileVectorHash _hash_ = __isUnicode ? _unicodeLiterals : _literals;
        net.rim.tools.compiler.codfile.Literal _literal_ = (net.rim.tools.compiler.codfile.Literal)_hash_.get(__name);
        if(_literal_ == null)
        {
            _literal_ = new net.rim.tools.compiler.codfile.Literal(__name, __isUnicode, __needsHeader);
            _hash_.put(__name, _literal_);
        } else
        if(__needsHeader)
            _literal_.setNeedsHeader();
        return _literal_;
    }

    private net.rim.tools.compiler.codfile.CodfileData _aamf(net.rim.tools.compiler.codfile.CodfileVectorHash param_IdentifiersTable, net.rim.tools.compiler.codfile.aq aq1, boolean __needsHeader, int __offset)
        throws IOException
    {
        if(__offset == 0 || __offset == 65535)
            throw new IOException("bad offset for data: 0x" + Integer.toHexString(__offset));
        net.rim.tools.compiler.codfile.CodfileData f1 = (net.rim.tools.compiler.codfile.CodfileData)param_IdentifiersTable.getItem(__offset, aq1);
        if(__needsHeader)
            f1.setNeedsHeader();
        if(hasData())
        {
            String s = f1.getString();
            param_IdentifiersTable.inject(s != null ? ((Object) (s)) : ((Object) (_identifier.getString())), f1);
        }
        return f1;
    }

    public net.rim.tools.compiler.codfile.Identifier get_identifier(int param_Offset)
        throws IOException
    {
        if(param_Offset == 0)
            return _identifier;
        else
            return (net.rim.tools.compiler.codfile.Identifier)_aamf(_identifiers, z_hEac, false, param_Offset);
    }

    public net.rim.tools.compiler.codfile.Bytes _aIIa(int __offset, int j, boolean flag)
        throws IOException
    {
        if(__offset == 0)
            throw new IOException("bad offset for data bytes: 0x" + Integer.toHexString(__offset));
        if(__offset == 65535)
            return z_hDa;
        z_hMal._aGIV(j);
        z_hMal._elseZV(flag);
        net.rim.tools.compiler.codfile.Bytes _bytes_ = (net.rim.tools.compiler.codfile.Bytes)_bytes.getItem(__offset, z_hMal);
        if(flag)
            _bytes_._doa1V(this);
        return _bytes_;
    }

    public net.rim.tools.compiler.codfile.Literal createSibling(int param_offset, boolean param_flagUnicode, boolean flag1, boolean flag2)
        throws IOException
    {
        z_hFt.set_flagUnicode(param_flagUnicode);
        z_hFt._elseZV(flag1);
        z_hFt._gotoZV(flag2);
        return (net.rim.tools.compiler.codfile.Literal)_aamf(param_flagUnicode ? _unicodeLiterals : _literals, z_hFt, flag1, param_offset);
    }

    public boolean _bqvZ()
    {
        return z_hKZ;
    }

    public boolean hasData()
    {
        return _data != null;
    }

    public byte getByte(int __offset)
    {
        __offset += _start;
        return _data[__offset];
    }

    public char getChar(int i)
    {
        i += _start;
        byte byte0 = _data[i];
        byte byte1 = _data[i + 1];
        char c = (char)((byte0 & 0xff | (byte1 & 0xff) << 8) & 0xffff);
        return c;
    }

    public int getInt(int i)
    {
        i += _start;
        byte byte0 = _data[i];
        byte byte1 = _data[i + 1];
        byte byte2 = _data[i + 2];
        byte byte3 = _data[i + 3];
        int j = (byte3 << 24) + ((byte2 & 0xff) << 16) + ((byte1 & 0xff) << 8) + (byte0 & 0xff);
        return j;
    }

    public int _agII(int i)
    {
        return CodfileData.getType(getInt(i - 4));
    }

    public void _byteaBIV(byte abyte0[], int param_Offset)
    {
        param_Offset += _start;
        System.arraycopy(_data, param_Offset, abyte0, 0, abyte0.length);
    }

    public void _aaCIV(char ac1[], int i)
    {
        int j = i + ac1.length * 2;
        int k = 0;
        for(; i < j; i += 2)
        {
            ac1[k] = getChar(i);
            k++;
        }

    }
}
