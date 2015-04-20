// Decompiled by Jad v1.5.8f. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi

package net.rim.tools.compiler.codfile;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Vector;
import net.rim.tools.compiler.exec.g;
import net.rim.tools.compiler.io.StructuredInputStream;
import net.rim.tools.compiler.io.StructuredOutputStreamCounter;
import net.rim.tools.compiler.io.StructuredOutputStream;

// Referenced classes of package net.rim.tools.compiler.d:
//            ag, k, z, i,
//            ap

public final class Codfile //cod file parser
    implements net.rim.tools.compiler.vm.Constants
{

    protected int _flashId;
    protected int _timeStamp;
    protected int _userVersion;
    protected int _maxTypeListSize;
    protected int _Version;
    protected int _flags;
    protected net.rim.tools.compiler.codfile.CodfileVector _routines;
    protected net.rim.tools.compiler.codfile.DataSection _dataSection;
    protected int _codeSize;
    protected int _dataSize;
    private String _weights;
    private boolean z_izZ;
    private boolean z_irZ;
    private boolean z_ivZ;
    protected byte _data[];
    protected int _codeSegmentOffset;
    protected byte _data2[];
    protected int _dataSegmentOffset;
    protected net.rim.tools.compiler.io.StructuredInputStream _input; //byte stream for processing
    protected net.rim.tools.compiler.io.StructuredInputStream z_ipa;

    private void Initializate()
    {
        _flashId = -16162;
        _routines = new net.rim.tools.compiler.codfile.CodfileVector();
        _routines.setTableName("routines");
        _dataSection = new net.rim.tools.compiler.codfile.DataSection(this);
    }

    public Codfile(boolean flag)
    {
        Initializate();
        _Version = 78;
        _dataSection._agvV();
        z_izZ = flag;
        if(z_izZ)
        {
            _Version = 76;
            _dataSection._anvV();
        }
    }

    private Codfile()
    {
    }

    public void writeWeightsString(String s)
    {
        _weights = s;
    }

    public Codfile(byte __data[], byte __data1[])
        throws IOException
    {
        Initializate();
        _data = __data;
        net.rim.tools.compiler.io.StructuredInputStream _input_ = new net.rim.tools.compiler.io.StructuredInputStream(__data, true);
        _flashId = _input_.readInt();
        if(_flashId != -16162)
            throw new IOException("flashId mismatch.  need: -16162 found: " + _flashId);
        int _sections_ = _input_.readInt(); //section num
        int _vtable_ = _input_.readInt(); //vtable ptr
        if(_sections_ != 0 || _vtable_ != 0)
        {
            _dataSection._VvV();
            _dataSection._qIV(_sections_);
        }
        _timeStamp = _input_.readInt();
        _userVersion = _input_.readInt();
        int _fieldRefs_ = _input_.readInt(); // fieldref_pointer
        _maxTypeListSize = _input_.readShort();
        short loc_reserved = _input_.readShort();
        int _dataSection_ = _input_.readInt(); // data_section
        int _moduleInfo_ = _input_.readInt(); // module_info
        if(_fieldRefs_ != 0 || _dataSection_ != -1 || loc_reserved != -1 || _moduleInfo_ != -1)
            _dataSection._VvV();
        _Version = _input_.readUnsignedShort();
        if(_Version >= 76)
            _dataSection._agvV();
        if(_Version < 74)
            throw new IOException("file format version mismatch.  need: 74 found: " + _Version);
        _codeSize = _input_.readUnsignedShort();
        _dataSize = _input_.readUnsignedShort();
        _flags = _input_.readUnsignedShort() & 0x37;
        _codeSegmentOffset = _input_.getOffset();
        if(__data1 == null)
        {
            _input_.skipBytes(_codeSize);
            _data2 = __data;
            _dataSegmentOffset = _input_.getOffset();
        } else
        {
            _data2 = __data1;
            _dataSegmentOffset = 0;
        }
        _input_.close();
    }

    public Codfile(byte abyte0[])
        throws IOException
    {
        this(abyte0, null);
    }

    public Vector getClassDefs(boolean flag)
        throws IOException
    {
        z_ivZ = flag;
        z_irZ = true;
        _input = new StructuredInputStream(_data2, _dataSegmentOffset, _dataSize, true, 0);
        _dataSection.read(_input, flag);
        return _dataSection.getClassDefs();
    }

    public void processCodeSegment(boolean flag)
        throws IOException
    {
        if(!z_irZ)
            getClassDefs(flag);
        _input.setOffset(0);
        _dataSection.addClassRefs(_input, flag);
        StructuredInputStream _input_ = new StructuredInputStream(_data, _codeSegmentOffset, _codeSize, true, 0);
        int loc_routinesNumber = _routines.size();
        for(int l = 0; l < loc_routinesNumber; l++)
            ((RoutineLocal)_routines.elementAt(l)).read(_input_, _dataSection, flag);

        _input_.verifySlack(4);
        _routines.setExtent(_input_.getOffset());
        if(_input_.read() != -1)
            throw new IOException("Extra bytes in code section");
        _input_.close();
        if(!flag)
            _dataSection._akvV();
    }

    public void _voidkV(DataSection __dataSection)
    {
        int j = _routines.size();
        for(int l = 0; l < j; l++)
        {
            RoutineLocal _routineLocal_ = (RoutineLocal)_routines.elementAt(l);
            _routineLocal_._dokBIV(__dataSection, _data, _codeSegmentOffset);
        }

    }

    public void _ifiV(net.rim.tools.compiler.codfile.ClassDefLocal __classDefLocal)
        throws IOException
    {
        if(!z_irZ)
            throw new IOException("Dictionary has not been read");
        _input.setOffset(0);
        _dataSection._aaV(_input, __classDefLocal);
        int l = __classDefLocal.ratchetStartCodeOffset();
        int i1 = __classDefLocal.ratchetEndCodeOffset();
        net.rim.tools.compiler.io.StructuredInputStream _input_ = new net.rim.tools.compiler.io.StructuredInputStream(_data, _codeSegmentOffset, i1, true, l);
        int i2 = __classDefLocal.getNumVirtualRoutines();
        for(int j1 = 0; j1 < i2; j1++)
        {
            RoutineLocal _localRoutine_ = (RoutineLocal)__classDefLocal.getVirtualRoutine(j1);
            _localRoutine_.read(_input_, _dataSection, true);
        }

        i2 = __classDefLocal.get_nonVirtualRoutinesSize();
        for(int k1 = 0; k1 < i2; k1++)
        {
            RoutineLocal _localRoutine_ = (RoutineLocal)__classDefLocal.get_nonVirtualRoutine(k1);
            _localRoutine_.read(_input_, _dataSection, true);
        }

        i2 = __classDefLocal.get_staticRoutinesSize();
        for(int l1 = 0; l1 < i2; l1++)
        {
            RoutineLocal _localRoutine = (RoutineLocal)__classDefLocal.getStaticRoutine(l1);
            _localRoutine.read(_input_, _dataSection, true);
        }

        _input_.close();
    }

    public int calculate_file_size(net.rim.tools.compiler.io.StructuredOutputStream __output)
        throws IOException
    {
        if(z_ivZ)
            throw new IOException("cannot write codfile created by a shallow parse");
        __output.resetOffset("Codfile Header Information");
		__output.writeString("\t Field \t\t Value \r\n");
        __output.writeInt(_flashId, "\t flashid \t\t", false);
        __output.empty_func7();
        __output.writeInt(0, "\t section_number \t\t", false);
        __output.writeInt(0, "\t vtable_pointer \t\t", false);
        __output.empty_func7();
        __output.writeInt(_timeStamp, "\t timestamp = \t\t", true);
        __output.writeInt(_userVersion, "\t user_version = \t\t", true);
        __output.writeInt(0, "\t fieldref_pointer \t\t", false);
        __output.empty_func7();
        __output.writeShort(_maxTypeListSize, "\t max_type_list_size = \t\t", true);
        __output.writeShort(-1, "\t reserved_value \t\t", false);
        __output.empty_func7();
        __output.writeInt(-1, "\t data_section \t\t", false);
        __output.empty_func7();
        __output.writeInt(-1, "\t module_info \t\t", false);
        if(_weights != null)
            __output.writeString(_weights);
        __output.empty_func7();
        __output.writeShort(_Version, "\t version = \t\t", true);
        __output.writeShort(_codeSize, "\t codesize = \t\t", true);
        __output.writeShort(_dataSize, "\t datasize = \t\t", true);
        int j = _flags;
        if((j & 1) != 0)
            __output.writeString("IsLibrary ");
        if((j & 2) != 0)
            __output.writeString("IsMidlet ");
        if((j & 4) != 0)
            __output.writeString("IsParseable ");
        if((j & 0x10) != 0)
            __output.writeString("IsBrittle ");
        if((j & 0x20) != 0)
            __output.writeString("IsPlatform ");
        __output.writeShort(_flags, "flags = \t\t", true);
		__output.writeString("\r\n");
        int l = __output.getOffset();
        __output.resetOffset("Code Section");
        __output.setWritingCode(true);
        _dataSection.assignClassRefOrdinals();
        _dataSection.harvestRoutines();
        _routines._trycvV(__output, true);
        __output.writeSlack(4);
        _routines.setExtent(__output);
        _codeSize = _routines.getExtent();
        l += __output.getOffset();
        __output.resetOffset("Data Section");
        __output.setWritingCode(false);
        _dataSection.write(__output);
        _dataSize = _dataSection.getExtent();
        __output.empty_func11("End Of File");
        l += __output.getOffset();
        __output.close();
        return l;
    }

    public void write(OutputStream __output, g __digestOutput, PrintStream __print)
        throws IOException
    {
        net.rim.tools.compiler.io.StructuredOutputStream _output_ = null;
        if(__print == null)
            _output_ = new net.rim.tools.compiler.io.StructuredOutputStream(__output, true, __digestOutput);
        else
            _output_ = StructuredOutputStream.createInstance(__output, true, __digestOutput, __print);
        calculate_file_size(_output_);
    }

    public int count(String __moduleName, StringBuffer __buffer)
        throws IOException
    {
        _dataSection.InitializateTables();
        StructuredOutputStreamCounter _counter_ = new StructuredOutputStreamCounter(_dataSection);
        int j = calculate_file_size(_counter_);
        if(_codeSize > 65000 || _dataSize > 65000)
        {
            boolean flag = false;
            __buffer.append("output file: ");
            __buffer.append(__moduleName);
            __buffer.append(".cod ");
            if(_codeSize > 65000)
            {
                __buffer.append("code section too large: ");
                __buffer.append(Integer.toString(_codeSize));
                __buffer.append(" bytes");
                flag = true;
            }
            if(_dataSize > 65000)
            {
                if(flag)
                {
                    flag = false;
                    __buffer.append(", ");
                }
                __buffer.append("data section too large: ");
                __buffer.append(Integer.toString(_dataSize));
                __buffer.append(" bytes.\n");
            }
            if(flag)
                __buffer.append(".\n");
        }
        return j;
    }

    public void setTimeStamp(int __timeStamp)
    {
        _timeStamp = __timeStamp;
    }

    public int getTimeStamp()
    {
        return _timeStamp;
    }

    public int getVersion()
    {
        return _Version;
    }

    public void setMaxTypeListSize(int j)
    {
        _maxTypeListSize = j;
    }

    public void setFlags(int j)
    {
        _flags |= j;
        _dataSection.set_codFlags(j);
    }

    public int getFlags()
    {
        return _flags;
    }

    public byte[] getData()
    {
        return _data;
    }

    public int getCodeSegmentOffset()
    {
        return _codeSegmentOffset;
    }

    public byte[] _bKvaB()
    {
        return _data2;
    }

    public int getDataSegmentOffset()
    {
        return _dataSegmentOffset;
    }

    public DataSection getDataSection()
    {
        return _dataSection;
    }

    public CodfileVector getRoutines()
    {
        return _routines;
    }
}
