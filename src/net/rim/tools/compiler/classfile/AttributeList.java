// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.classfile;

import java.io.IOException;
import java.util.Hashtable;
import net.rim.tools.compiler.exec.CharacterHelper;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.e:
//            ae, m

public final class AttributeList
{

    static final int z_gotoI = 1;
    static final int z_cI = 2;
    static final int z_caseI = 3;
    static final int z_tryI = 4;
    public static String NAME_CODE;
    public static String NAME_DEPRECATED = net.rim.tools.compiler.exec.CharacterHelper.intern("Deprecated");
    public static String NAME_EXCEPTIONS = net.rim.tools.compiler.exec.CharacterHelper.intern("Exceptions");
    public static String NAME_INNERCLASSES = net.rim.tools.compiler.exec.CharacterHelper.intern("InnerClasses");
    public static String NAME_LINENUMBERTABLE;
    public static String NAME_LOCALVARIABLETABLE;
    public static String NAME_SOURCEFILE;
    public static String NAME_STACKMAP;
    public static String NAME_SYNTHETIC = net.rim.tools.compiler.exec.CharacterHelper.intern("Synthetic");
    private Hashtable z_aHashtable;
    private boolean z_charZ;
    private net.rim.tools.compiler.classfile.Attribute z_byteaae[];
    private static final String z_ifaString[];

    public AttributeList(net.rim.tools.compiler.io.StructuredInputStream param_byteArray, net.rim.tools.compiler.classfile.ConstantPool param_constsPool, int i, boolean flag)
        throws IOException
    {
        int j = param_byteArray.readUnsignedShort();
        if(j > 0)
        {
            z_aHashtable = new Hashtable(j * 2);
            z_charZ = flag;
            z_byteaae = new net.rim.tools.compiler.classfile.Attribute[j];
            for(int k = 0; k < j; k++)
            {
                net.rim.tools.compiler.classfile.Attribute ae1 = net.rim.tools.compiler.classfile.Attribute.read(param_byteArray, param_constsPool, i, flag);
                z_byteaae[k] = ae1;
                if(!flag && z_aHashtable.put(ae1.getName(), ae1) != null)
                    throw new IOException("duplicate " + ae1.getName() + " attribute");
            }

        }
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1, boolean flag)
        throws IOException
    {
        if(z_charZ)
            throw new IOException("cannot write attributes created from shallow read.");
        int i = z_byteaae != null ? z_byteaae.length : 0;
        int j = i;
        if(flag && z_aHashtable != null)
        {
            int k = z_ifaString.length;
            for(int i1 = 0; i1 < k; i1++)
            {
                Attribute ae1 = (Attribute)z_aHashtable.get(z_ifaString[i1]);
                if(ae1 != null)
                {
                    ae1._cHvV();
                    j--;
                }
            }

        }
        c1.empty_func7();
        c1.writeString("attributes");
        c1.empty_func7();
        c1.writeShort(j, "num_attributes=", true);
        c1.empty_func7();
        c1.empty_func();
        for(int l = 0; l < i; l++)
        {
            c1.writeString("attribute: ");
            c1.empty_func8(l);
            c1.empty_func7();
            z_byteaae[l].write(c1, flag);
        }

        c1.empty_func2();
        c1.empty_func7();
    }

    public net.rim.tools.compiler.classfile.Attribute getAttribute(String s)
    {
        return (net.rim.tools.compiler.classfile.Attribute)(z_aHashtable != null ? z_aHashtable.get(s) : null);
    }

    static
    {
        NAME_CODE = net.rim.tools.compiler.exec.CharacterHelper.intern("Code");
        NAME_LINENUMBERTABLE = net.rim.tools.compiler.exec.CharacterHelper.intern("LineNumberTable");
        NAME_LOCALVARIABLETABLE = net.rim.tools.compiler.exec.CharacterHelper.intern("LocalVariableTable");
        NAME_SOURCEFILE = net.rim.tools.compiler.exec.CharacterHelper.intern("SourceFile");
        NAME_STACKMAP = net.rim.tools.compiler.exec.CharacterHelper.intern("StackMap");
        z_ifaString = (new String[] {
            NAME_CODE, NAME_LOCALVARIABLETABLE, NAME_LINENUMBERTABLE, NAME_STACKMAP, NAME_SOURCEFILE
        });
    }
}
