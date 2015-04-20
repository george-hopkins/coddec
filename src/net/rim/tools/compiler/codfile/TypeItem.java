// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import net.rim.tools.compiler.vm.Constants;
import net.rim.tools.compiler.io.StructuredInputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ap, k, ai, u

public final class TypeItem
implements net.rim.tools.compiler.vm.Constants
{

    private static final int z_idI = 24;
    private static final int z_ibI = 16;
    private static final int z_h7I = 8;
    private int _typeId;
    private net.rim.tools.compiler.codfile.ClassDef _classDef;
    private static TypeItem _typeIds[] = {
        null, new net.rim.tools.compiler.codfile.TypeItem(1), new net.rim.tools.compiler.codfile.TypeItem(2), new net.rim.tools.compiler.codfile.TypeItem(3), new net.rim.tools.compiler.codfile.TypeItem(4), new net.rim.tools.compiler.codfile.TypeItem(5), new net.rim.tools.compiler.codfile.TypeItem(6), null, null, null,
        new net.rim.tools.compiler.codfile.TypeItem(10), new net.rim.tools.compiler.codfile.TypeItem(11), new net.rim.tools.compiler.codfile.TypeItem(12)
    };
    private static StringBuffer _stringBuffer = new StringBuffer();
    private String _typeName;
    private static String _typeNames[] = {
        null, "boolean", "byte", "char", "short", "int", "long", null, null, null,
        "void", "float", "double"
    };

    public String getTypeName()
    {
        if(_typeName == null)
        {
            int i = getId();
            switch(i)
            {
            default:
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
            case 5: // '\005'
            case 6: // '\006'
            case 10: // '\n'
            case 11: // '\013'
            case 12: // '\f'
                _typeName = _typeNames[i];
                break;

            case 8: // '\b'
                synchronized(_stringBuffer)
                {
                    _stringBuffer.setLength(0);
                    int j = _bAvI();
                    if(j == 7)
                        _stringBuffer.append(_classDef.get_name_2());
                    else
                        _stringBuffer.append(_typeNames[j]);
                    int l = _bzvI();
                    for(int i1 = 0; i1 < l; i1++)
                        _stringBuffer.append("[]");

                    _typeName = _stringBuffer.toString();
                }
                break;

            case 7: // '\007'
            case 9: // '\t'
                _typeName = _classDef.get_name_2();
                break;
            }
        }
        return _typeName;
    }

    public static net.rim.tools.compiler.codfile.TypeItem makeTypeItem(int __typeId)
    {
        return _typeIds[__typeId];
    }

    private TypeItem(int __typeId)
    {
        _typeId = (__typeId & 0xff) << 24 | 1;
    }

    public TypeItem(int i, int j)
    {
        _typeId = 0x8000000 | (i & 0xff) << 16 | (j & 0xff) << 8 | 3;
    }

    public TypeItem(net.rim.tools.compiler.codfile.ClassDef __classDef, int i)
    {
        _classDef = __classDef;
        _typeId = (i & 0xff) << 24 | 3;
    }

    public TypeItem(net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        _classDef = __classDef;
        _typeId = 0x7000003;
    }

    public TypeItem(int i, net.rim.tools.compiler.codfile.ClassDef __classDef)
    {
        _classDef = __classDef;
        _typeId = 0x8000000 | (i & 0xff) << 16 | 0x700 | 5;
    }

    public static net.rim.tools.compiler.codfile.TypeItem read(net.rim.tools.compiler.io.StructuredInputStream __input, net.rim.tools.compiler.codfile.DataSection __dataSection, int i)
        throws IOException
    {
        net.rim.tools.compiler.codfile.TypeLists ai1 = __dataSection.getTypeLists();
        i &= 0xf;
        net.rim.tools.compiler.codfile.TypeItem x1;
        switch(i)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
            x1 = makeTypeItem(i);
            break;

        case 8: // '\b'
            int j = __input.readUnsignedByte();
            int i1 = __input.readUnsignedByte();
            if(i1 != 7)
                return new TypeItem(j, i1);
            x1 = new TypeItem(j, __dataSection.findClassDef(__input.readUnsignedByte(), __input.readUnsignedByte()));
            x1 = ai1._axx(x1);
            break;

        case 7: // '\007'
        case 9: // '\t'
            x1 = new TypeItem(__dataSection.findClassDef(__input.readUnsignedByte(), __input.readUnsignedByte()), i);
            x1 = ai1._axx(x1);
            break;

        default:
            int l = __input.getOffset() - 1;
            throw new IOException("unexpected type id: 0x" + Integer.toHexString(i) + " at offset: 0x" + Integer.toHexString(l));
        }
        return x1;
    }

    public static int _akBII(net.rim.tools.compiler.codfile.DataSection k1, byte abyte0[], int i, int j)
    {
        int l = i;
        j &= 0xf;
        switch(j)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        default:
            break;

        case 8: // '\b'
            l++;
            j = abyte0[l++];
            if(j != 7)
                break;
            // fall through

        case 7: // '\007'
        case 9: // '\t'
            k1._doaBIV(abyte0, l);
            l += 2;
            break;
        }
        return l - i;
    }

    public void makeSymbolic(net.rim.tools.compiler.codfile.DataSection __dataSection)
    {
        if(_classDef != null)
            _classDef.makeSymbolic(__dataSection);
    }

    public void write(net.rim.tools.compiler.io.StructuredOutputStream __output, int i)
        throws IOException
    {
        int j = _typeId;
        int l = j >> 24 & 0xff;
        __output.writeByte((i & 0xf) << 4 | l);
        switch(l)
        {
        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
            __output.writeString(_typeNames[l]);
            break;

        case 8: // '\b'
            int i1 = j >> 16 & 0xff;
            __output.writeByte(i1, "array nesting=", true);
            int j1 = j >> 8 & 0xff;
            __output.writeByte(j1);
            if(j1 != 7)
            {
                __output.writeString(_typeNames[j1]);
                break;
            }
            // fall through

        case 7: // '\007'
        case 9: // '\t'
            _classDef.writeAbsoluteClassDef(__output);
            break;

        default:
            throw new IOException("unexpected type id: 0x" + Integer.toHexString(l));
        }
    }

    public int getId()
    {
        return _typeId >> 24 & 0xff;
    }

    public int getExtent()
    {
        return _typeId & 0xff;
    }

    public int _bzvI()
    {
        return _typeId >> 16 & 0xff;
    }

    public int _bAvI()
    {
        return _typeId >> 8 & 0xff;
    }

    public ClassDef getClassDef()
    {
        return _classDef;
    }

    public int compareTo(Object obj)
    {
        net.rim.tools.compiler.codfile.TypeItem x1 = (net.rim.tools.compiler.codfile.TypeItem)obj;
        if(this == x1)
            return 0;
        if(_typeId < x1._typeId)
            return -1;
        if(_typeId > x1._typeId)
            return 1;
        if(_classDef != null)
            return _classDef.compareTo(x1._classDef);
        return x1._classDef == null ? 0 : -1;
    }

    public boolean equals(Object obj)
    {
        if(obj instanceof net.rim.tools.compiler.codfile.TypeItem)
        {
            net.rim.tools.compiler.codfile.TypeItem x1 = (net.rim.tools.compiler.codfile.TypeItem)obj;
            if(this == x1)
                return true;
            if(_typeId != x1._typeId)
                return false;
            if(_classDef != null)
                return _classDef.equals(x1._classDef);
            else
                return x1._classDef == null;
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        int i = _typeId;
        if(_classDef != null)
            i = i * 31 + _classDef.hashCode();
        return i;
    }

}
