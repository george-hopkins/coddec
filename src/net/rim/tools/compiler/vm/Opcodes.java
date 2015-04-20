// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.vm;


public final class Opcodes
{

    public static final String opcodes[] = {
        "breakpoint", "invokevirtual", "invokeinterface", "invokenonvirtual", "invokenonvirtual_lib", "invokespecial", "invokespecial_lib", "invokestatic", "invokestatic_lib", "iinvokenative",
        "invokenative", "linvokenative", "jumpspecial", "jumpspecial_lib", "enter", "enter_wide", "xenter", "xenter_wide", "synch", "synch_static",
        "clinit_wait", "ireturn_bipush", "ireturn_sipush", "ireturn_iipush", "ireturn", "ireturn_field", "ireturn_field_wide", "areturn", "areturn_field", "areturn_field_wide",
        "lreturn", "return", "clinit_return", "noenter_return", "aconst_null", "iconst_0", "bipush", "sipush", "iipush", "lipush",
        "ldc", "unused_29", "ldc_unicode", "unused_2b", "iconst_1", "arrayinit", "unused_2e", "tableswitch", "unused_30", "iload",
        "iload_wide", "aload", "aload_wide", "lload", "lload_wide", "iload_0", "iload_1", "iload_2", "iload_3", "iload_4",
        "iload_5", "iload_6", "iload_7", "aload_0", "aload_1", "aload_2", "aload_3", "aload_4", "aload_5", "aload_6",
        "aload_7", "istore", "istore_wide", "astore", "astore_wide", "lstore", "lstore_wide", "istore_0", "istore_1", "istore_2",
        "istore_3", "istore_4", "istore_5", "istore_6", "istore_7", "astore_0", "astore_1", "astore_2", "astore_3", "astore_4",
        "astore_5", "astore_6", "astore_7", "putfield_return", "putfield_return_wide", "putfield", "putfield_wide", "lputfield", "lputfield_wide", "getfield",
        "getfield_wide", "lgetfield", "lgetfield_wide", "aload_0_getfield", "aload_0_getfield_wide", "putstatic", "putstatic_lib", "lputstatic", "lputstatic_lib", "getstatic",
        "getstatic_lib", "lgetstatic", "lgetstatic_lib", "i2b", "i2s", "i2c", "i2l", "l2i", "ineg", "lneg",
        "iinc", "iinc_wide", "iadd", "ladd", "isub", "lsub", "imul", "lmul", "idiv", "ldiv",
        "irem", "lrem", "iand", "land", "ior", "lor", "ixor", "lxor", "ishl", "lshl",
        "ishr", "lshr", "iushr", "lushr", "lcmp", "if_icmpeq", "if_acmpeq", "ifeq", "if_icmpne", "if_acmpne",
        "ifne", "if_icmpgt", "ifgt", "if_icmpge", "ifge", "if_icmplt", "iflt", "if_icmple", "ifle", "ifnull",
        "ifnonnull", "goto", "goto_w", "lookupswitch_short", "lookupswitch", "newarray", "multianewarray", "arraylength", "newarray_object", "newarray_object_lib",
        "multianewarray_object", "multianewarray_object_lib", "baload", "saload", "caload", "iaload", "aaload", "laload", "bastore", "castore",
        "sastore", "iastore", "aastore", "lastore", "new", "new_lib", "clinit", "clinit_lib", "athrow", "instanceof_array",
        "checkcast_array", "instanceof", "instanceof_lib", "checkcast", "checkcast_lib", "checkcastbranch", "checkcastbranch_lib", "checkcastbranch_array", "instanceof_arrayobject", "instanceof_arrayobject_lib",
        "checkcast_arrayobject", "checkcast_arrayobject_lib", "monitorenter", "monitorexit", "nop", "pop", "pop2", "dup", "dup2", "dup_x1",
        "dup_x2", "dup2_x1", "dup2_x2", "swap", "unused_d6", "isreal", "op01xx", "stringlength", "stringaload", "invokestaticqc",
        "invokestaticqc_lib", "enter_narrow", "invokevirtual_short", "ldc_nullstr", "unused_e0", "unused_e1", "unused_e2", "unused_e3", "unused_e4", "unused_e5",
        "unused_e6", "unused_e7", "unused_e8", "unused_e9", "unused_ea", "unused_eb", "unused_ec", "unused_ed", "unused_ee", "unused_ef",
        "unused_f0", "unused_f1", "unused_f2", "unused_f3", "unused_f4", "unused_f5", "unused_f6", "unused_f7", "unused_f8", "unused_f9",
        "halt", "threaddeath", "unused_fc", "unused_fd", "unused_fe", "unused_ff", "fadd", "dadd", "fsub", "dsub",
        "fmul", "dmul", "fdiv", "ddiv", "frem", "drem", "fneg", "dneg", "i2f", "i2d",
        "l2f", "l2d", "f2i", "f2l", "f2d", "d2i", "d2l", "d2f", "fcmpl", "fcmpg",
        "dcmpl", "dcmpg", "stringarrayinit", ""
    };

    public Opcodes()
    {
    }

}
