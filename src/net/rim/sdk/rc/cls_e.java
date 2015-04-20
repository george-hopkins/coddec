// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.PrintStream;
import java.util.*;
import net.rim.sdk.cls_a;
import net.rim.sdk.cls_c;

// Referenced classes of package net.rim.a.a:
//            a, k, g, c

public class cls_e
{

    private String z_charString;
    private String z_elseString;
    private String z_nullString;
    private String z_voidString;
    private String z_forString;
    private int z_newI;
    private Hashtable z_ifHashtable;
    private Hashtable z_longHashtable;
    private Hashtable z_gotoHashtable;
    private Hashtable z_doHashtable;
    private Hashtable z_byteHashtable;
    private Vector z_tryVector;
    private boolean z_aZ;
    private boolean z_caseZ;
    private String z_intString;

    public cls_e(String s)
    {
        z_ifHashtable = new Hashtable();
        z_longHashtable = new Hashtable();
        z_gotoHashtable = new Hashtable();
        z_doHashtable = new Hashtable();
        z_tryVector = new Vector();
        int i = s.lastIndexOf('/');
        if(i == -1)
        {
            z_elseString = "";
            z_nullString = s;
        } else
        {
            z_elseString = s.substring(0, i + 1);
            z_nullString = s.substring(i + 1);
        }
    }

    public void _cvV()
    {
        z_ifHashtable.clear();
        z_longHashtable.clear();
        z_gotoHashtable.clear();
        z_doHashtable.clear();
        z_tryVector.clear();
        _ifStringV(null);
    }

    public void _acV(net.rim.sdk.rc.cls_c c1)
    {
        if(c1 == null)
        {
            return;
        } else
        {
            z_tryVector.add(c1);
            return;
        }
    }

    public Vector _bvVector()
    {
        return z_tryVector;
    }

    public void _akV(cls_k k1)
	throws net.rim.sdk.cls_a
    {
        Hashtable hashtable = _ifLocaleHashtable(k1._forvLocale());
        if(hashtable.get(k1._ifvString()) != null)
            throw new net.rim.sdk.cls_a("Duplicate definition " + k1._ifvString());
        net.rim.sdk.rc.cls_a a1 = (net.rim.sdk.rc.cls_a)z_longHashtable.get(k1._ifvString());
        if(a1 == null)
        {
            z_caseZ = true;
            if(z_aZ)
            {
                k1._doStringV("Declaration not found: " + k1._ifvString());
                _ifkV(k1);
                return;
            } else
            {
                throw new net.rim.sdk.cls_a("Declaration not found: " + k1._ifvString());
            }
        } else
        {
            hashtable.put(k1._ifvString(), k1);
            return;
        }
    }

    public void _aaV(net.rim.sdk.rc.cls_a a1)
	throws net.rim.sdk.cls_a
    {
        Integer integer = new Integer(a1._casevI());
        if(_doStringZ(a1._ifvString()))
            throw new net.rim.sdk.cls_a("Duplicate definition " + a1._ifvString());
        if(_ifIZ(a1._casevI()))
        {
            throw new net.rim.sdk.cls_a("Duplicate definition " + integer);
        } else
        {
            z_ifHashtable.put(a1._ifvString(), integer);
            z_longHashtable.put(a1._ifvString(), a1);
            z_longHashtable.put(integer, a1);
            return;
        }
    }

    public boolean _ifIZ(int i)
    {
        Integer integer = new Integer(i);
        return z_longHashtable.get(integer) != null;
    }

    public boolean _doStringZ(String s)
    {
        return z_longHashtable.get(s) != null;
    }

    public boolean _bytevZ()
    {
        return z_caseZ;
    }

    public void _ifaV(net.rim.sdk.rc.cls_a a1)
    {
        if(a1 == null)
        {
            return;
        } else
        {
            Integer integer = new Integer(a1._casevI());
            z_ifHashtable.remove(a1._ifvString());
            z_longHashtable.remove(a1._ifvString());
            z_longHashtable.remove(integer);
            return;
        }
    }

    public void _ifkV(cls_k k1)
	throws net.rim.sdk.cls_a
    {
        if(k1._ifvString() == null)
            return;
        Hashtable hashtable = _forLocaleHashtable(k1._forvLocale());
        if(hashtable.get(k1._ifvString()) != null)
        {
            throw new net.rim.sdk.cls_a("Duplicate error listed! " + k1._ifvString());
        } else
        {
            hashtable.put(k1._ifvString(), k1);
            return;
        }
    }

    public Enumeration _elsevEnumeration()
    {
        return z_ifHashtable.keys();
    }

    public Hashtable _ifLocaleHashtable(Locale locale)
    {
        Hashtable hashtable = (Hashtable)z_gotoHashtable.get(locale);
        if(hashtable == null)
        {
            hashtable = new Hashtable();
            z_gotoHashtable.put(locale, hashtable);
        }
        return hashtable;
    }

    public void _doLocaleV(Locale locale)
    {
        Hashtable hashtable = (Hashtable)z_gotoHashtable.get(locale);
        if(hashtable == null)
        {
            return;
        } else
        {
            hashtable.clear();
            return;
        }
    }

    public Hashtable _forLocaleHashtable(Locale locale)
    {
        Hashtable hashtable = (Hashtable)z_doHashtable.get(locale);
        if(hashtable == null)
        {
            hashtable = new Hashtable();
            z_doHashtable.put(locale, hashtable);
        }
        return hashtable;
    }

    public String _gotovString()
    {
        return "0x" + Long.toHexString(_forvJ()) + "L";
    }

    public long _forvJ()
    {
        return net.rim.sdk.cls_c._aStringJ(_nullvString() + '.' + _longvString());
    }

    public int[] _aLocaleaI(Locale locale)
    {
        Hashtable hashtable = _ifLocaleHashtable(locale);
        int ai[] = new int[hashtable.size()];
        Enumeration enumeration = hashtable.keys();
        for(int i = 0; i < ai.length; i++)
            ai[i] = _aStringI((String)enumeration.nextElement());

        Arrays.sort(ai);
        return ai;
    }

    public Locale[] _tryvaLocale()
    {
        if(z_gotoHashtable == null)
            return null;
        int i = z_gotoHashtable.size();
        Locale alocale[] = new Locale[i];
        Enumeration enumeration = z_gotoHashtable.keys();
        for(int j = 0; enumeration.hasMoreElements(); j++)
            alocale[j] = (Locale)enumeration.nextElement();

        return alocale;
    }

    public String _longvString()
    {
        return z_nullString;
    }

    public String _nullvString()
    {
        return z_charString;
    }

    public String _newvString()
    {
        return z_forString;
    }

    public void _ifStringV(String s)
    {
        z_forString = s;
    }

    public void _newStringV(String s)
    {
        z_intString = s;
    }

    public String _voidvString()
    {
        return z_intString;
    }

    public void _aIV(int i)
    {
        z_newI = i;
    }

    public int _casevI()
    {
        return z_newI;
    }

    public String _intvString()
    {
        return z_elseString;
    }

    public String _ifvString()
    {
        return z_elseString + z_nullString;
    }

    public String _charvString()
    {
        return z_voidString;
    }

    public String _doIString(int i)
    {
        return ((net.rim.sdk.rc.cls_a)z_longHashtable.get(new Integer(i)))._ifvString();
    }

    public net.rim.sdk.rc.cls_a _intStringa(String s)
    {
        return (net.rim.sdk.rc.cls_a)z_longHashtable.get(new Integer(_aStringI(s)));
    }

    public int _aStringI(String s)
    {
        try
        {
            return ((Integer)z_ifHashtable.get(s)).intValue();
        }
        catch(NullPointerException nullpointerexception)
        {
            System.out.println("Null pointer on: " + s);
            throw nullpointerexception;
        }
    }

    public void _aHashtableV(Hashtable hashtable)
    {
        z_byteHashtable = hashtable;
    }

    public Hashtable _dovHashtable()
    {
        return z_byteHashtable;
    }

    public void _avV()
    {
        z_aZ = true;
    }

    public void _tryStringV(String s)
    {
        z_voidString = s;
    }

    public void _forStringV(String s)
    {
        z_charString = s;
    }
}
