// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Vector;
import net.rim.tools.compiler.exec.MyArrays;

// Referenced classes of package net.rim.tools.compiler.f:
//            a, j

public class CompilerProperties extends Hashtable
{

    private String _chars;
    private char z_upaC[];

    public CompilerProperties()
    {
        _chars = "()<>@,;:'\"/[]?={} \t";
    }

    public Object setProperty(String __property, String __value)
    {
        return put(__property, __value);
    }

    public String getProperty(String __property) //Get value from hash by string S
    {
        Object obj = get(__property);
        if(obj == null)
            return null;
        if(obj instanceof String)
            return (String)obj;
        Vector vector = (Vector)obj;
        if(!vector.isEmpty())
            return (String)vector.firstElement();
        else
            return null;
    }

    public String getQuotedProperty(String __property) //Get value from hash by string removes quotes
    {
        String s1 = getProperty(__property);
        if(s1 == null || s1.length() == 0)
            return null;
        if(s1.charAt(0) == '"')
            return s1.substring(1, s1.length() - 1);
        else
            return s1;
    }

    public void putVector(String __property, Vector __value)
    {
        put(__property, __value);
    }

    public Vector getVector(String __property) //get or create object as vector from hash by key
    {
        Object obj = get(__property);
        Vector vector;
        if(obj == null)
        {
            vector = new Vector();
            putVector(__property, vector);
        } else
        if(obj instanceof String)
        {
            vector = getQuotedVector((String)obj);
            putVector(__property, vector);
        } else
        {
            vector = (Vector)obj;
        }
        return vector;
    }

    public static Vector getQuotedVector(String __property)
    {
        Vector vector = new Vector();
        if(__property != null)
        {
            StringBuffer stringbuffer = new StringBuffer(__property);
            int i = stringbuffer.length();
            for(int k = 0; k < i;)
            {
                char c = stringbuffer.charAt(k);
                if(c == '"')
                {
                    stringbuffer.deleteCharAt(k);
                    i--;
                } else
                if(c == FileHelper.p_pathSeparatorC)
                {
                    __property = stringbuffer.toString().substring(0, k);
                    k++;
                    stringbuffer.delete(0, k);
                    i = stringbuffer.length();
                    k = 0;
                    if(!vector.contains(__property))
                        vector.addElement(__property);
                } else
                {
                    k++;
                }
            }

            if(i > 0)
            {
                __property = stringbuffer.toString();
                if(!vector.contains(__property))
                    vector.addElement(__property);
            }
        }
        return vector;
    }

    public Vector parseVector(String __property, boolean __flag)
	throws net.rim.tools.compiler.util.CompileException
    {
        Vector vector = getVector(__property);
        if(!vector.isEmpty() && __flag)
        {
            int i = vector.size();
            StringBuffer stringbuffer = new StringBuffer();
            for(int k = 0; k < i; k++)
            {
                String s1 = (String)vector.elementAt(k);
                if(s1 != null)
                {
                    boolean flag1 = false;
                    stringbuffer.setLength(0);
                    int l = s1.length();
                    for(int i1 = 0; i1 < l; i1++)
                    {
                        char c = s1.charAt(i1);
                        switch(c)
                        {
                        case 9: // '\t'
                        case 32: // ' '
                            flag1 = true;
                            break;

                        default:
                            stringbuffer.append(c);
                            break;
                        }
                    }

                    if(flag1)
                        vector.setElementAt(stringbuffer.toString(), k);
                }
            }

        }
        return vector;
    }

    private int _ifInputStreamI(InputStream inputstream)
        throws IOException
    {
        boolean flag = true;
        boolean flag1 = false;
        int i = -1;
        int k = 0;
        do
        {
            int l;
            do
            {
                l = inputstream.read();
                if(l < 0)
                    return -1;
            } while(l == 13);
            if(l == 10)
                break;
            if(flag && l <= 32)
                continue;
            flag = false;
            if(l == 35)
                flag1 = true;
            if(flag1)
                continue;
            if(l == 37)
                if(i == -1)
                {
                    i = k + 1;
                } else
                {
                    if(i != k)
                    {
                        String s = new String(z_upaC, i, k - i);
                        k = i - 1;
                        String s1 = getProperty(s);
                        if(s1 != null)
                        {
                            int i1 = s1.length();
                            if(k + i1 >= z_upaC.length)
                                z_upaC = net.rim.tools.compiler.exec.MyArrays.resize(z_upaC, z_upaC.length + i1);
                            for(int j1 = 0; j1 < i1; j1++)
                                z_upaC[k++] = s1.charAt(j1);

                        }
                    }
                    i = -1;
                    continue;
                }
            if(k == z_upaC.length)
                z_upaC = net.rim.tools.compiler.exec.MyArrays.resize(z_upaC, z_upaC.length * 2);
            z_upaC[k++] = (char)l;
        } while(true);
        for(; k > 0 && z_upaC[k - 1] <= ' '; k--);
        return k;
    }

    private Vector _ifStringVector(String s, Vector vector)
    {
        if(s != null && !vector.isEmpty())
            if(vector.size() == 1)
            {
                setProperty(s, (String)vector.firstElement());
                vector.setSize(0);
            } else
            {
                putVector(s, vector);
                vector = null;
            }
        return vector;
    }

    public void readDefFile(String s, InputStream __inputstream)
        throws IOException
    {
        String s1 = null;
        Vector vector = null;
        if(z_upaC == null)
            z_upaC = new char[32];
        int i = 0;
        do
        {
            int k = _ifInputStreamI(__inputstream);
            if(k == -1)
                break;
            i++;
            if(k != 0)
                if(z_upaC[0] == '[')
                {
                    k--;
                    if(z_upaC[k] != ']')
                    {
                        k++;
                        throw new IOException(s + "(" + i + "): Error!: Expecting ']' but found '" + new String(z_upaC, 0, k) + "'");
                    }
                    k--;
                    vector = _ifStringVector(s1, vector);
                    s1 = new String(z_upaC, 1, k);
                    Object obj = get(s1);
                    if(obj == null)
                    {
                        if(vector == null)
                            vector = new Vector();
                    } else
                    if(obj instanceof String)
                    {
                        if(vector == null)
                            vector = new Vector();
                        vector.addElement(obj);
                    } else
                    {
                        vector = (Vector)obj;
                    }
                } else
                {
                    if(s1 == null)
                        throw new IOException(s + "(" + i + "): Error!: Expecting '[' but found '" + new String(z_upaC, 0, k) + "'");
                    String s2 = new String(z_upaC, 0, k);
                    if(vector.isEmpty() || !vector.contains(s2))
                        vector.addElement(s2);
                }
        } while(true);
        vector = _ifStringVector(s1, vector);
    }

    public void load(String s)
        throws IOException
    {
        int i = 0;
        int k = s.length();
        boolean flag = false;
        boolean flag1 = false;
        StringBuffer stringbuffer = new StringBuffer();
label0:
        for(boolean flag2 = false; !flag2;)
        {
            int l = 0;
            boolean flag3 = false;
            stringbuffer.setLength(0);
            do
            {
                if(i == k)
                {
                    if(stringbuffer.length() == 0)
                        break label0;
                    flag = true;
                    break;
                }
                int i1 = s.charAt(i++);
                if(i1 == 13 || i1 == 10)
                {
                    if(stringbuffer.length() == 0)
                    {
                        flag = false;
                        continue;
                    }
                    flag = true;
                    break;
                }
                l++;
                if(i1 == 58 || i1 == 61)
                    break;
                if(i1 <= 31 || i1 == 127 || _chars.indexOf((char)i1) != -1)
                    flag = true;
                else
                    stringbuffer.append((char)i1);
            } while(true);
            if(stringbuffer.length() == 0)
                throw new IOException("Invalid empty key name in property");
            if(flag)
                throw new IOException("Invalid key name in property: '" + stringbuffer.toString() + "'.");
            String s1 = stringbuffer.toString();
            stringbuffer.setLength(0);
            do
            {
                if(i == k)
                {
                    flag2 = true;
                    break;
                }
                int j1 = s.charAt(i++);
                if(j1 == 13)
                    continue;
                if(j1 == 10)
                {
                    if(l != 72 && l != 70 || i >= k || s.charAt(i) != ' ')
                        break;
                    i++;
                    l = 1;
                } else
                {
                    l++;
                    if(j1 != 32 && j1 != 9 || stringbuffer.length() != 0)
                    {
                        if(j1 == 92 && i < k && s.charAt(i) == 'u')
                        {
                            i++;
                            j1 = 0;
                            for(int k1 = 0; k1 < 4 && i < k; k1++)
                            {
                                char c1 = s.charAt(i++);
                                int l1 = 0;
                                if('0' <= c1 && c1 <= '9')
                                    l1 = c1 - 48;
                                else
                                if('a' <= c1 && c1 <= 'f')
                                    l1 = (c1 - 97) + 10;
                                else
                                if('A' <= c1 && c1 <= 'F')
                                {
                                    l1 = (c1 - 65) + 10;
                                } else
                                {
                                    flag2 = true;
                                    break;
                                }
                                l++;
                                j1 = (j1 << 4) + l1;
                            }

                        }
                        if((j1 <= 31 || j1 == 127) && j1 != 9)
                            flag1 = true;
                        stringbuffer.append((char)j1);
                    }
                }
            } while(true);
            l = stringbuffer.length();
            char c;
            boolean flag4;
            for(flag4 = false; --l >= 0 && ((c = stringbuffer.charAt(l)) == ' ' || c == '\t'); flag4 = true);
            if(flag4)
                stringbuffer.setLength(++l);
            String s2 = stringbuffer.toString();
            if(flag1)
                throw new IOException("Value for key: '" + s1 + "', is invalid: '" + s2 + "'.");
            put(s1, s2);
        }

    }
}
