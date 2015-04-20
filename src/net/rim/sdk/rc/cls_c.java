// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;


// Referenced classes of package net.rim.a.a:
//            k, g

public class cls_c extends cls_k
{

    private String z_tryString;

    public cls_c()
    {
    }

    public String _tryvString()
    {
        return z_tryString;
    }

    public void _forStringV(String s)
    {
        z_tryString = s;
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        } else
        {
            String s = obj.toString();
            return s.equals(_ifvString());
        }
    }
}
