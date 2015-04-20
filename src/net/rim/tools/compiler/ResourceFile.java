// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.io.*;
import net.rim.tools.compiler.util.FileHelper;
import net.rim.tools.compiler.io.StructuredInputStream;

public class ResourceFile
{

    public static final int _MaxSize = 61440;
    protected String _absoluteName;
    protected String _relativeName;
    protected byte _data[];
    protected boolean _slice;
    protected File _file;
    protected byte _data2[];

    public ResourceFile()
    {
        _relativeName = "";
        _absoluteName = _relativeName;
    }

    public ResourceFile(String s, byte abyte0[], boolean flag)
    {
        _relativeName = s;
        _absoluteName = s;
        _data = abyte0;
        _slice = flag;
    }

    public ResourceFile(File file)
        throws IOException
    {
        _relativeName = file.getPath();
        _absoluteName = file.getAbsolutePath();
        if(_relativeName.equals(_absoluteName))
            _relativeName = null;
        FileInputStream fileinputstream = new FileInputStream(file);
        read(fileinputstream, (int)file.length(), _absoluteName);
        fileinputstream.close();
    }

    public ResourceFile(String __name, InputStream __inputstream, int __startPos)
        throws IOException
    {
        if(__name.startsWith("/"))
            __name = __name.substring(1);
        _relativeName = __name;
        _absoluteName = __name;
        read(__inputstream, __startPos, __name);
    }

    private void read(InputStream __inputstream, int __startPos, String __name)
        throws IOException
    {
        __inputstream = new BufferedInputStream(__inputstream);
        _data = net.rim.tools.compiler.io.StructuredInputStream.readAll(__inputstream, __startPos, __name);
    }

    public void setRelativeName(File __file)
        throws IOException
    {
        if(_relativeName == null)
        {
            String s = __file.getPath() + FileHelper.p_separatorS;
            if(_absoluteName.startsWith(s))
            {
                _relativeName = _absoluteName.substring(s.length());
            } else
            {
                int i = _absoluteName.lastIndexOf(FileHelper.p_separatorC);
                if(i == -1)
                    _relativeName = _absoluteName;
                else
                    _relativeName = _absoluteName.substring(i + 1);
            }
        }
    }

    public void write(File __file)
        throws IOException
    {
        if(isEmpty() || _slice)
            return;
        _file = new File(__file, _relativeName);
        File file1 = _file.getParentFile();
        if(file1 != null)
            file1.mkdirs();
        FileOutputStream fileoutputstream = new FileOutputStream(_file);
        if(_data2 != null)
            fileoutputstream.write(_data2);
        else
            fileoutputstream.write(_data);
        fileoutputstream.close();
    }

    public void delete()
        throws IOException
    {
        if(_file != null)
        {
            _file.delete();
            File file = _file.getParentFile();
            if(file != null)
                file.delete();
        }
    }

    public String getAbsolutePath()
    {
        if(_file != null)
            return _file.getAbsolutePath();
        else
            return null;
    }

    public String getRelativeName()
    {
        return _relativeName;
    }

    public boolean isEmpty()
    {
        return _data == null;
    }

    public boolean isSlice()
    {
        return _slice;
    }

    public void resetData(byte __data[])
    {
        _data2 = _data;
        _data = __data;
    }

    public byte[] getData()
    {
        return _data;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
            return false;
        if(obj instanceof String)
            if(_relativeName != null && _relativeName.equals(obj))
                return true;
            else
                return _absoluteName.equals(obj);
        if(obj instanceof ResourceFile)
        {
            ResourceFile d1 = (ResourceFile)obj;
            if(_relativeName != null && _relativeName.equals(d1._relativeName))
                return true;
            else
                return _absoluteName.equals(d1._absoluteName);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        if(_relativeName != null)
            return _relativeName.hashCode();
        else
            return _absoluteName.hashCode();
    }
}
