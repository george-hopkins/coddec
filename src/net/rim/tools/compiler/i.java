// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import net.rim.tools.compiler.util.CompilerProperties;
import net.rim.tools.compiler.util.Tokenizer;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler:
//            h

public class i extends net.rim.tools.compiler.h
{

    private String _KeyFileName;
    private byte _data[];
    private boolean z_forZ;

    public i(File __file)
        throws IOException
    {
        _KeyFileName = __file.getName();
        _aInputStreamV(new BufferedInputStream(new FileInputStream(__file)));
    }

    private void _aInputStreamV(InputStream __inputstream)
        throws IOException
    {
        String s = net.rim.tools.compiler.exec.CharacterHelper.utf8ToString(net.rim.tools.compiler.io.StructuredInputStream.readFully(__inputstream, -1, _KeyFileName));
        CompilerProperties f1 = new CompilerProperties();
        f1.load(s);
        String s1 = f1.getProperty("ID");
        super.z_aString = f1.getProperty("Name");
        String s2 = f1.getProperty("PublicKey");
        if(s1 == null || super.z_aString == null || s2 == null)
            throw new IOException("Invalid key file: " + _KeyFileName);
        super.z_ifI = Integer.parseInt(s1, 16);
        Tokenizer h1 = new Tokenizer(s2);
        int j;
        for(j = 0; h1.hasMoreTokens(); j++)
            h1.nextToken();

        _data = new byte[j];
        h1 = new Tokenizer(s2);
        for(int k = 0; k < j; k++)
            _data[k] = (byte)Integer.parseInt(h1.nextToken(), 16);

    }

    public String get_keyFileName()
    {
        return _KeyFileName;
    }

    public String _tryvString()
    {
        StringBuffer stringbuffer = new StringBuffer(super.z_aString.length() + 10);
        stringbuffer.append(Integer.toHexString(super.z_ifI));
        stringbuffer.append("=");
        stringbuffer.append(super.z_aString);
        return stringbuffer.toString();
    }

    public byte[] _dovaB()
    {
        return _data;
    }

    public void _newvV()
    {
        z_forZ = true;
    }

    public boolean _forvZ()
    {
        return z_forZ;
    }
}
