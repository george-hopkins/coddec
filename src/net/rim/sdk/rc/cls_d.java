// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.*;
import java.util.*;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;
import net.rim.sdk.*;

// Referenced classes of package net.rim.a.a:
//            j, k, i, e,
//            b, f

public class cls_d extends net.rim.sdk.cls_b
{

    static final int z_rI = 4096;
    private cls_f z_qf;

    public cls_d(ResourceCompiler l, Vector vector)
    {
        super(null, null, null, vector);
        z_qf = l._intvf();
    }

    void _aeV(cls_e e1, Locale locale)
        throws net.rim.sdk.cls_a, IOException
    {
        String s = e1._intvString();
        String s1 = e1._nullvString().trim();
        String s2 = e1._longvString() + '\243' + locale;
        String s3 = cls_b._aeString(e1);
        String s4 = s3 + s1 + '.' + s2 + ".crb";
        s = s3;
        (new File(s)).mkdirs();
        s = s + s2;
        boolean flag = _newvZ();
        _doStringV("Attempting to compress: " + flag);
        _aIStringV(3, "Clean up stale files");
        (new File(s + ".java")).delete();
        (new File(s4)).delete();
        (new File(s + ".bin")).delete();
        if(e1._bytevZ())
        {
            _aIStringV(3, "Error:" + s);
            return;
        }
        int ai[] = e1._aLocaleaI(locale);
        Hashtable hashtable = e1._ifLocaleHashtable(locale);
        cls_j j1 = new cls_j();
        short aword0[] = new short[ai.length + 1];
        for(int l = 0; l < ai.length; l++)
        {
            aword0[l] = (short)j1._ifvI();
            cls_k k1 = (cls_k)hashtable.get(e1._doIString(ai[l]));
            if(k1 == null)
            {
                _aIStringV(3, "ID=" + k1);
                _aIV(0x8000000b);
            }
            Object obj = k1._intvObject();
            if(obj instanceof String)
            {
                String s5 = (String)obj;
                s5 = cls_b._newStringString(s5);
                j1._aBV((byte)115);
                j1._aStringV(s5);
            } else
            if(obj instanceof Vector)
            {
                Vector vector = (Vector)obj;
                j1._aBV((byte)91);
                j1._aBV((byte)115);
                j1._aSV((short)vector.size());
                for(int i2 = 0; i2 < vector.size(); i2++)
                {
                    String s6 = (String)vector.elementAt(i2);
                    s6 = cls_b._newStringString(s6);
                    j1._aStringV(s6);
                }

            }
        }

        aword0[aword0.length - 1] = (short)j1._ifvI();
        byte abyte0[] = j1._avaB();
        j1 = null;
        int i1 = 0;
        int l1 = _tryvI();
        if(l1 > 0)
            i1 = l1;
        else
            i1 = e1._casevI();
        if(i1 < 0)
            i1 = 0;
        _doStringV("Version set to:" + i1);
        FileOutputStream fileoutputstream = new FileOutputStream(s4);
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        fileoutputstream.write(new byte[] {
            99, 114
        });
        _aOutputStreamvV(fileoutputstream, i1);
        _aOutputStreamocaleV(gzipoutputstream, locale, e1, ai, aword0);
        gzipoutputstream.write(abyte0);
        try
        {
            gzipoutputstream.flush();
            gzipoutputstream.close();
            gzipoutputstream = null;
            int j2 = 0;
            if(abyte0.length > (bytearrayoutputstream.size() + 4096) - 1)
            {
                _doStringV("Writing out compressed resource.");
                _doStringV("Stats for (" + s2 + ") bin:" + abyte0.length + " crb:" + bytearrayoutputstream.size());
                j2 |= 1;
                _aOutputStreamvV(fileoutputstream, j2);
                fileoutputstream.write(bytearrayoutputstream.toByteArray());
                _aStringV(s4);
            } else
            {
                _doStringV("Compressed resource too large to merit using.");
                j2 |= 2;
                _aOutputStreamvV(fileoutputstream, j2);
                ByteArrayOutputStream bytearrayoutputstream1 = new ByteArrayOutputStream();
                BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(bytearrayoutputstream1);
                _aOutputStreamocaleV(bufferedoutputstream, locale, e1, ai, aword0);
                bufferedoutputstream.write(abyte0);
                bufferedoutputstream.flush();
                bufferedoutputstream.close();
                fileoutputstream.write(bytearrayoutputstream1.toByteArray());
                _aStringV(s4);
            }
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
        finally
        {
            fileoutputstream.flush();
            fileoutputstream.close();
        }
        (new File(s + ".bin")).delete();
        (new File(s + ".java")).delete();
    }

    void _aOutputStreamocaleV(OutputStream outputstream, Locale locale, cls_e e1, int ai[], short aword0[])
        throws IOException
    {
        int l = cls_b._aStringI(locale.getLanguage(), locale.getCountry());
        _aOutputStreamvV(outputstream, l);
        String s = locale.getVariant();
        if(s != null || s.length() > 0)
        {
            outputstream.write(new byte[] {
                (byte)s.length()
            });
            outputstream.write(s.getBytes());
        } else
        {
            outputstream.write(new byte[] {
                0
            });
        }
        _aOutputStreamvV(outputstream, e1._forvJ());
        _aOutputStreamvV(outputstream, (short)ai.length);
        for(int i1 = 0; i1 < ai.length; i1++)
            _aOutputStreamvV(outputstream, ai[i1]);

        for(int j1 = 0; j1 < aword0.length; j1++)
            _aOutputStreamvV(outputstream, aword0[j1]);

    }

    private int _tryvI()
    {
        int l = z_qf._ifStringI("resource_version");
        int i1 = z_qf._ifStringI("rv");
        if(l > 0)
            return l;
        if(i1 > 0)
            return i1;
        else
            return 0;
    }

    private boolean _newvZ()
    {
        return z_qf._doStringZ("resource_compress") || z_qf._doStringZ("cr");
    }

    void _aOutputStreamvV(OutputStream outputstream, long l)
        throws IOException
    {
        byte abyte0[] = new byte[8];
        _aJaBV(l, abyte0, 0);
        outputstream.write(abyte0);
    }

    void _aOutputStreamvV(OutputStream outputstream, int l)
        throws IOException
    {
        byte abyte0[] = new byte[4];
        _aIaBV(l, abyte0, 0);
        outputstream.write(abyte0);
    }

    void _aOutputStreamvV(OutputStream outputstream, short word0)
        throws IOException
    {
        byte abyte0[] = new byte[2];
        _aSaBV(word0, abyte0, 0);
        outputstream.write(abyte0);
    }

    static void _aSaBV(short word0, byte abyte0[], int l)
    {
        abyte0[l] = (byte)(word0 >> 8);
        abyte0[l + 1] = (byte)word0;
    }

    static short _aBBS(byte byte0, byte byte1)
    {
        return (short)(byte0 << 8 | byte1 & 0xff);
    }

    static short _aaBIS(byte abyte0[], int l)
    {
        return _aBBS(abyte0[l], abyte0[l + 1]);
    }

    static int _aBBBI(byte byte0, byte byte1, byte byte2, byte byte3)
    {
        return byte0 << 24 | (byte1 & 0xff) << 16 | (byte2 & 0xff) << 8 | byte3 & 0xff;
    }

    static int _ifaBII(byte abyte0[], int l)
    {
        return _aBBBI(abyte0[l], abyte0[l + 1], abyte0[l + 2], abyte0[l + 3]);
    }

    static long _aBBBBBJ(byte byte0, byte byte1, byte byte2, byte byte3, byte byte4, byte byte5, byte byte6, byte byte7)
    {
        int l = _aBBBI(byte0, byte1, byte2, byte3);
        int i1 = _aBBBI(byte4, byte5, byte6, byte7);
        return _aIIJ(i1, l);
    }

    static long _aIIJ(int l, int i1)
    {
        return (long)l & 0xffffffffL | (long)i1 << 32;
    }

    static void _aJaBV(long l, byte abyte0[], int i1)
    {
        abyte0[i1] = (byte)(int)(l >> 56);
        abyte0[i1 + 1] = (byte)(int)(l >> 48);
        abyte0[i1 + 2] = (byte)(int)(l >> 40);
        abyte0[i1 + 3] = (byte)(int)(l >> 32);
        abyte0[i1 + 4] = (byte)(int)(l >> 24);
        abyte0[i1 + 5] = (byte)(int)(l >> 16);
        abyte0[i1 + 6] = (byte)(int)(l >> 8);
        abyte0[i1 + 7] = (byte)(int)l;
    }

    static void _aIaBV(int l, byte abyte0[], int i1)
    {
        abyte0[i1] = (byte)(l >> 24);
        abyte0[i1 + 1] = (byte)(l >> 16);
        abyte0[i1 + 2] = (byte)(l >> 8);
        abyte0[i1 + 3] = (byte)l;
    }

    static void _aWriterV(Writer writer, String s, int l)
        throws IOException
    {
        writer.write("\n    private static final int " + s + " = " + l + ";\n");
    }

    static void _aWriterV(Writer writer, String s, byte abyte0[])
        throws IOException
    {
        writer.write("\n    private static final byte[] " + s + " = {\n");
        writer.write("        ");
        for(int l = 0; l < abyte0.length; l++)
        {
            writer.write("" + abyte0[l] + ", ");
            if((l & 0xf) == 15)
            {
                writer.write("\n");
                writer.write("        ");
            }
        }

        writer.write("\n    };\n");
    }

    static void _aWriterV(Writer writer, String s, int ai[])
        throws IOException
    {
        writer.write("\n    private static final int[] " + s + " = {\n");
        writer.write("        ");
        for(int l = 0; l < ai.length; l++)
        {
            writer.write("" + ai[l] + ", ");
            if((l & 7) == 7)
            {
                writer.write("\n");
                writer.write("        ");
            }
        }

        writer.write("\n    };\n");
    }

    static void _aWriterV(Writer writer, String s, short aword0[])
        throws IOException
    {
        writer.write("\n    private static final short[] " + s + " = {\n");
        writer.write("        ");
        for(int l = 0; l < aword0.length; l++)
        {
            writer.write("" + aword0[l] + ", ");
            if((l & 7) == 7)
            {
                writer.write("\n");
                writer.write("        ");
            }
        }

        writer.write("\n    };\n");
    }

    private static int _ifLocaleI(Locale locale)
    {
        int l = 0;
        String s = locale.getLanguage();
        if(s.length() == 2)
            l |= s.charAt(0) << 24 | s.charAt(1) << 16;
        String s1 = locale.getCountry();
        if(s1.length() == 2)
            l |= s1.charAt(0) << 8 | s1.charAt(1) << 0;
        return l;
    }
}
