// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            u, a7, ao, ap,
//            k, a1, w, r,
//            ak, p, at, a5

public final class ClassDefNull extends net.rim.tools.compiler.codfile.ClassDef
{

    public ClassDefNull(net.rim.tools.compiler.codfile.DataSection k1, net.rim.tools.compiler.codfile.Identifier ak, net.rim.tools.compiler.codfile.Identifier ak1)
    {
        super(k1, -1);
        super._packageName = ak;
        super._className = ak1;
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        throw new IOException("cannot write null classDef");
    }

    public void writeModuleOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeByte(-1);
    }

    public void writeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeAbsoluteOrdinal(c1);
    }

    public void writeRelativeOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        c1.writeByte(-1, super._nameS, false);
    }

    public void writeAbsoluteOrdinal(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeModuleOrdinal(c1);
        c1.writeByte(-1, super._nameS, false);
    }

    public void writeAbsoluteClassDef(net.rim.tools.compiler.io.StructuredOutputStream c1)
        throws IOException
    {
        writeAbsoluteOrdinal(c1);
    }

    public net.rim.tools.compiler.codfile.FieldDef createFieldDef(net.rim.tools.compiler.codfile.Identifier ak, net.rim.tools.compiler.codfile.TypeList p, boolean flag)
    {
        return new net.rim.tools.compiler.codfile.FieldDefForeign(this, ak, p, flag);
    }

    public net.rim.tools.compiler.codfile.FieldDef makeFieldDef(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, boolean flag1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.FieldDefForeign a7_1 = (net.rim.tools.compiler.codfile.FieldDefForeign)createFieldDef(a1_1.getNullIdentifier(), p, flag1);
        a7_1.setActualName(s);
        if(flag)
            a7_1.setName(s);
        return a7_1;
    }

    public net.rim.tools.compiler.codfile.ClassRef getClassRef(net.rim.tools.compiler.codfile.DataSection k1)
    {
        if(super._classRef == null)
            super._classRef = k1.getNullClassRef();
        return super._classRef;
    }

    public net.rim.tools.compiler.codfile.Routine createRoutine(net.rim.tools.compiler.codfile.Identifier ak, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        return new net.rim.tools.compiler.codfile.RoutineForeign(this, ak, p, p1);
    }

    public net.rim.tools.compiler.codfile.Routine makeRoutine(net.rim.tools.compiler.codfile.DataSection k1, String s, boolean flag, net.rim.tools.compiler.codfile.TypeList p, net.rim.tools.compiler.codfile.TypeList p1)
    {
        net.rim.tools.compiler.codfile.DataBytes a1_1 = k1.getDataBytes();
        net.rim.tools.compiler.codfile.RoutineForeign ao1 = (net.rim.tools.compiler.codfile.RoutineForeign)createRoutine(a1_1.getNullIdentifier(), p, p1);
        ao1.setActualName(s);
        ao1.setName(s);
        return ao1;
    }
}
