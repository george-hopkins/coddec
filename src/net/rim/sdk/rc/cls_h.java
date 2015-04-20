// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.sdk.rc;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
import net.rim.sdk.cls_a;
import net.rim.sdk.cls_b;

// Referenced classes of package net.rim.a.a:
//            e, b

public class cls_h extends cls_b
{

    public cls_h(Vector vector)
    {
        super(null, null, null, vector);
    }

    void _aeV(cls_e e1)
        throws cls_a, IOException
    {
        String s = e1._longvString() + "Resource.java";
        String s1 = net.rim.sdk.rc.cls_b._aeString(e1);
        (new File(s1)).mkdirs();
        _aStringV(s1 + s);
        _aIStringV(3, "    interface:" + s1 + s);
        FileWriter filewriter = new FileWriter(s1 + s);
        Enumeration enumeration = e1._elsevEnumeration();
        filewriter.write("package " + e1._nullvString() + ";\n");
        filewriter.write("\n");
        filewriter.write("public interface " + e1._longvString() + "Resource {\n");
        filewriter.write("    // Hash of: \"" + e1._nullvString() + '.' + e1._longvString() + "\".\n");
        filewriter.write("    long BUNDLE_ID = " + e1._gotovString() + ";\n");
        filewriter.write("    String BUNDLE_NAME = \"" + e1._nullvString() + "." + e1._longvString() + "\";\n");
        filewriter.write("\n");
        String s2;
        int i;
        for(; enumeration.hasMoreElements(); filewriter.write("    int " + s2 + " = " + i + ";\n"))
        {
            s2 = (String)enumeration.nextElement();
            i = e1._aStringI(s2);
        }

        filewriter.write("}\n");
        filewriter.close();
    }
}
