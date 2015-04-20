// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;


public class CompileException extends Exception
{

    protected int _resultCode;
    protected String _fileName;
    protected String _word;

    public CompileException(int __resultCode, String __fileName, String __word)
    {
        super(__word);
        _resultCode = __resultCode;
        _fileName = __fileName;
        _word = __word;
    }

    public CompileException(String __fileName, String __word)
    {
        this(0, __fileName, __word);
    }

    public CompileException(String __word)
    {
        this(0, null, __word);
    }

    public int getResultCode()
    {
        return _resultCode;
    }

    public String getMessage()
    {
        return _word;
    }

    public String toString()
    {
        StringBuffer stringbuffer = new StringBuffer();
        if(_fileName != null)
            stringbuffer.append(_fileName).append(": ");
        stringbuffer.append("Error!");
        if(_resultCode != 0)
            stringbuffer.append(_resultCode);
        return stringbuffer.append(": ").append(getMessage()).toString();
    }
}
