// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler;

import java.util.Vector;



public class Applet
{

    private String _appletName;
    private String _className;
    private Vector _iconNames;
    private Vector _icons;

    public Applet(String s, String s1)
    {
        _appletName = s;
        _className = s1;
        _iconNames = new Vector();
        _icons = new Vector();
    }

    public void setName(String __name)
    {
        _appletName = __name;
    }

    public String getName()
    {
        return _appletName;
    }

    public void setClassName(String __name)
    {
        _className = __name;
    }

    public String getClassName()
    {
        return _className;
    }

    public int getNumIconNames()
    {
        return _iconNames.size();
    }

    public String getIconName(int __index)
    {
        return (String)_iconNames.elementAt(__index);
    }

    public void setIconName(String __name, int __index)
    {
        Vector vector = _iconNames;
        if(vector.size() <= __index)
            vector.setSize(__index + 1);
        vector.setElementAt(__name, __index);
    }

    public int getNumIcons()
    {
        return _icons.size();
    }

    public net.rim.tools.compiler.ImageFile getIcon(int __index)
    {
        return (net.rim.tools.compiler.ImageFile)_icons.elementAt(__index);
    }

    public void setIcon(net.rim.tools.compiler.ImageFile __imageFile, int __index)
    {
        Vector vector = _icons;
        if(vector.size() <= __index)
            vector.setSize(__index + 1);
        vector.setElementAt(__imageFile, __index);
        __imageFile.markIcon();
    }
}
