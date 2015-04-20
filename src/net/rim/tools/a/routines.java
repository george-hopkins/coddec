package net.rim.tools.a;

import net.rim.tools.compiler.codfile.*;

public class routines
{
	private DataSection _dataSection;
	
	public routines(DataSection __dataSection)
	{
		_dataSection = __dataSection;
	}
	
	public static String getRoutineAttributes(int __attribute)
	{
		int j = __attribute;
		StringBuffer _attrbutes_ = new StringBuffer();
		if((j & 0x10) != 0)
            _attrbutes_.append("static ");
        if((j & 0x20) != 0)
            _attrbutes_.append("abstract ");
		if((j & 1) != 0)
            _attrbutes_.append("public ");
        if((j & 2) != 0)
            _attrbutes_.append("private ");
        if((j & 4) != 0)
            _attrbutes_.append("protected ");
        if((j & 8) != 0)
			_attrbutes_.append("final ");
		return _attrbutes_.toString();
	}
	
	public Routine resolveRoutineName (int __routineOrdinal)
	{
		Routine _routine_ = null;
		if (_dataSection != null)
		{
		}
		return _routine_;
	}
	
	public static Routine resolveRoutineName (int __moduleOrdinal, int __routineOrdinal)
	{
		Routine _routine_ = null;
		return _routine_;
	}
	
	
}
