// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;


public final class TypeDescriptor
{

    private String _string;
    private int _length;
    private int _pos;

    public TypeDescriptor(String s)
    {
        _string = s.replace('/', '.');
        _length = s.length();
        _pos = 0;
    }

    public String getString()
    {
        return _string;
    }

    public boolean hasChar(char c)
    {
        if(_pos < _length && _string.charAt(_pos) == c)
        {
            _pos++;
            return true;
        } else
        {
            return false;
        }
    }

    public int get_OffsetToStringEnd()
    {
        if(_pos < _length)
            return _length - _pos;
        else
            return 0;
    }

    public char getChar()
    {
        if(_pos < _length)
            return _string.charAt(_pos++);
        else
            return '\0';
    }

    public String _dovString()
    {
        int i = _string.indexOf(';', _pos);
        String s = _string.substring(_pos, i);
        _pos = i + 1;
        return s;
    }
}
