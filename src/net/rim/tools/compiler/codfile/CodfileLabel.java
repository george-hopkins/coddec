// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;


public final class CodfileLabel
{

    private int _start;
    private int _end;
    private CodfileLabel _label;
    private int _offset;

    public CodfileLabel(int __offset)
    {
        _end = __offset;
    }

    public CodfileLabel(int __startOffset, int __endOffset)
    {
        _start = __startOffset;
        _end = __endOffset;
    }

    public CodfileLabel(CodfileLabel __codFileLabel)
    {
        _label = __codFileLabel;
    }

    public int _ifvI()
    {
        return _start;
    }

    public void setEnd(int __offset)
    {
        _end = __offset;
    }

    public int getEnd()
    {
        if(_label != null)
            return _label.getEnd() + 1;
        else
            return _end;
    }

    public void setOffset(int __offset)
    {
        _offset = __offset;
    }

    public int getOffset()
    {
        return _offset;
    }
}
