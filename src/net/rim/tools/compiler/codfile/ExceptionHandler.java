// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            e, a6, k, ap,
//            u

public final class ExceptionHandler extends net.rim.tools.compiler.codfile.CodfileItemRelative
{

    public static final int z_eeI = 65535;
    private net.rim.tools.compiler.codfile.CodfileLabel _start;
    private net.rim.tools.compiler.codfile.CodfileLabel _end;
    private net.rim.tools.compiler.codfile.CodfileLabel _handler;
    private net.rim.tools.compiler.codfile.ClassDef _handlerClass;

    public ExceptionHandler(net.rim.tools.compiler.codfile.CodfileLabel a6_1, net.rim.tools.compiler.codfile.CodfileLabel a6_2, net.rim.tools.compiler.codfile.CodfileLabel a6_3, net.rim.tools.compiler.codfile.ClassDef u1)
    {
        _start = a6_1;
        _end = a6_2;
        _handler = a6_3;
        _handlerClass = u1;
    }

    public ExceptionHandler(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.codfile.DataSection k1, int i, int j)
        throws IOException
    {
        super(a1);
        _start = new net.rim.tools.compiler.codfile.CodfileLabel(i - j);
        _end = new net.rim.tools.compiler.codfile.CodfileLabel(a1.readUnsignedShort() - j);
        _handler = new net.rim.tools.compiler.codfile.CodfileLabel(a1.readUnsignedShort() - j);
        if(k1.getVersion() >= 2)
            _handlerClass = k1.findClassDef(a1.readUnsignedByte(), a1.readUnsignedByte());
        else
            _handlerClass = k1.getClassDef(a1.readUnsignedByte(), a1.readUnsignedByte());
    }

    public static void _aaV(net.rim.tools.compiler.io.StructuredInputStream a1)
        throws IOException
    {
        a1.skipBytes(_IvI());
    }

    public static int _akBII(net.rim.tools.compiler.codfile.DataSection k1, byte abyte0[], int i)
    {
        int j = i + 2 + 2;
        k1._doaBIV(abyte0, j);
        return (j += 2) - i;
    }

    public void writeRelative(net.rim.tools.compiler.io.StructuredOutputStream c1, int i)
        throws IOException
    {
        setOffset(c1);
        c1.writeShort(_start.getEnd() + i, "start", false);
        c1.writeShort(_end.getEnd() + i, "end", false);
        c1.writeShort(_handler.getEnd() + i, "handler", false);
        _handlerClass.writeAbsoluteClassDef(c1);
        c1.empty_func7();
        setExtent(c1);
    }

    public static int _IvI()
    {
        return 6;
    }
	
	public net.rim.tools.compiler.codfile.ClassDef getHandlerClass ()
	{
		return _handlerClass;
	}
}
