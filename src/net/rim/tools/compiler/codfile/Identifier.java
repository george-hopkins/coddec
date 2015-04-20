// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.IdDecoding;
import net.rim.tools.compiler.vm.IdEncode;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            f, ap, a1

public final class Identifier extends net.rim.tools.compiler.codfile.CodfileData
{

    private String _name;

    private static byte[] _elseStringaB(String __name)
    {
        __name = net.rim.tools.compiler.vm.IdEncode.encode(__name);
        int j = __name.length();
        byte abyte0[] = new byte[j];
        for(int l = 0; l < j; l++)
            abyte0[l] = (byte)__name.charAt(l);

        return abyte0;
    }

    public Identifier(String s)
    {
        super(_elseStringaB(s), 2, false, false);
        _name = s;
        super._nameS = s;
    }

    public Identifier()
    {
        super._offset = 0;
        _name = "";
    }

    public Identifier(int j)
    {
        super(j, 0);
    }

    public Identifier(int param_Offset, net.rim.tools.compiler.codfile.DataBytes a1_1)
    {
        super(param_Offset, 0, 2, false, false);
        if(a1_1.hasData())
            resolveName(a1_1);
    }

    public void resolveName(net.rim.tools.compiler.codfile.DataBytes __dataBytes)
    {
        int j;
        for(j = super._offset; __dataBytes.getByte(j) != 0; j++);
        int l = j - super._offset;
        if(!__dataBytes._bqvZ())
        {
            super._bytes = new byte[l];
            __dataBytes._byteaBIV(super._bytes, super._offset);
        }
        synchronized(CodfileData._stringBuf)
        {
            net.rim.tools.compiler.codfile.CodfileData._stringBuf.setLength(0);
            net.rim.tools.compiler.codfile.CodfileData._stringBuf.ensureCapacity(256);
            for(int i1 = super._offset; i1 < j; i1++)
            {
                int j1 = __dataBytes.getByte(i1) & 0xff;
                if(j1 == 255)
                {
                    i1++;
                    net.rim.tools.compiler.codfile.CodfileData._stringBuf.append((char)(__dataBytes.getByte(i1) & 0xff));
                } else
                {
                    net.rim.tools.compiler.codfile.CodfileData._stringBuf.append(net.rim.tools.compiler.vm.IdDecoding.decodeChars[j1]);
                }
            }

            _name = net.rim.tools.compiler.codfile.CodfileData._stringBuf.toString();
        }
        super._length = _name.length();
        super._nameS = _name;
    }

    public void writeTerminator(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeByte(0);
    }

    public String getString()
    {
        return _name;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.codfile.Identifier)
        {
            net.rim.tools.compiler.codfile.Identifier ak1 = (net.rim.tools.compiler.codfile.Identifier)obj;
            if(this == ak1)
                return true;
            if(_name == null && ak1._name == null)
                return true;
            if(_name == null || ak1._name == null)
                return false;
            else
                return _name.equals(ak1._name);
        }
        if(obj instanceof String)
        {
            String s = (String)obj;
            if(_name == null)
                return false;
            else
                return _name.equals(s);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        if(_name != null)
            return _name.hashCode();
        else
            return super.hashCode();
    }
}
