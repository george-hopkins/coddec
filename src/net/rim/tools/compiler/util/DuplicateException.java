// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;


// Referenced classes of package net.rim.tools.compiler.f:
//            a

public final class DuplicateException extends CompileException
{

    private String _fileName;

    public DuplicateException(String __fileName, String __word, String __dublicateFileName)
    {
        super(__fileName, __word);
        __fileName = __dublicateFileName;
    }

    public String getMessage()
    {
        return "Duplicate definition for '" + super._word + "' found in: " + _fileName;
    }
}
