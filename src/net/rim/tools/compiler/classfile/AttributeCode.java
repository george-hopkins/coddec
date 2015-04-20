// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae, n, t, m

public final class AttributeCode extends net.rim.tools.compiler.classfile.Attribute
{

    private int f_maxStackI;
    private int f_maxLocalsI;
    private byte _code[];
    private net.rim.tools.compiler.classfile.ClassFileExceptionHandler f_ClassfileExceptionHandler[];
    private net.rim.tools.compiler.classfile.AttributeList f_AttributeList;

    public AttributeCode(net.rim.tools.compiler.io.StructuredInputStream a1, net.rim.tools.compiler.classfile.ConstantPool param_constsPool, int j, String s)
        throws IOException
    {
        super(a1, j, s);
        int k = a1.getOffset();
        f_maxStackI = a1.readUnsignedShort();
        f_maxLocalsI = a1.readUnsignedShort();
        int l = a1.readInt();
        if(l > 0)
        {
            _code = new byte[l];
            a1.read(_code);
        }
        int i1 = a1.readUnsignedShort();
        if(i1 > 0)
        {
            f_ClassfileExceptionHandler = new net.rim.tools.compiler.classfile.ClassFileExceptionHandler[i1];
            for(int j1 = 0; j1 < i1; j1++)
                f_ClassfileExceptionHandler[j1] = new net.rim.tools.compiler.classfile.ClassFileExceptionHandler(a1, param_constsPool);

        }
        f_AttributeList = new net.rim.tools.compiler.classfile.AttributeList(a1, param_constsPool, 4, false);
        if(k + super.z_nAI != a1.getOffset())
            throw new IOException("incorrect code attribute length");
        else
            return;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(flag && super.z_nzZ)
            return;
        super._xcV(c1);
        c1.writeShort(f_maxStackI, "max_stack=", true);
        c1.writeShort(f_maxLocalsI, "max_locals=", true);
        c1.writeInt(_code != null ? _code.length : 0, "code_length=", true);
        c1.empty_func7();
        c1.writeString("code_bytes");
        c1.empty_func7();
        if(_code != null)
        {
            c1.write(_code);
            c1.empty_func7();
        }
        int j = getNumHandlers();
        c1.writeShort(j, "num_handlers=", true);
        c1.empty_func();
        c1.empty_func7();
        for(int k = 0; k < j; k++)
        {
            c1.writeString("handler: ");
            c1.empty_func8(k);
            c1.writeString(" ");
            f_ClassfileExceptionHandler[k]._acvV(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func7();
        c1.empty_func();
        f_AttributeList.write(c1, flag);
        c1.empty_func2();
        c1.empty_func7();
    }

    public byte[] getCode()
    {
        return _code;
    }

    public int getMaxStack()
    {
        return f_maxStackI;
    }

    public int getMaxLocals()
    {
        return f_maxLocalsI;
    }

    public int getNumHandlers()
    {
        return f_ClassfileExceptionHandler != null ? f_ClassfileExceptionHandler.length : 0;
    }

    public net.rim.tools.compiler.classfile.ClassFileExceptionHandler[] getHandlers()
    {
        return f_ClassfileExceptionHandler;
    }

    public boolean hasAttribute(String s)
    {
        return getAttribute(s) != null;
    }

    public net.rim.tools.compiler.classfile.Attribute getAttribute(String s)
    {
        return f_AttributeList.getAttribute(s);
    }
}
