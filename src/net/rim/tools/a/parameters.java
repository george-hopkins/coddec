package net.rim.tools.a;

import java.util.*;
import net.rim.tools.a.parameter;

public class parameters
{
	private Vector _parameters;
	
	public parameters ()
	{
		_parameters = new Vector(0);
	}
	
	private String generateName (String __typeName)
	{
		String _parameterName_ = "";
		
		int _dotIndex_ =__typeName.lastIndexOf(".");
		
		if (_dotIndex_ > 0)
		{
			_parameterName_ = __typeName.substring(_dotIndex_+ 1);
		}
		else
			_parameterName_ = __typeName;
		
		_parameterName_ =  _parameterName_.toLowerCase();
		
		_parameterName_ = "__" + _parameterName_;
		
		
		for (int i = 0; i < _parameters.size(); i++)
		{
			if (getParameter(i).getName().equals(_parameterName_))
				_parameterName_ = _parameterName_ + i;
		}
		return _parameterName_;
	}
	
	
	public void addParameter (String __typeName)
	{
		parameter _newParameter_ = new parameter ();
		_newParameter_.setTypeName(__typeName);
		String _name_ = generateName(__typeName);
		_newParameter_.setName(_name_);
		_parameters.add(_newParameter_);
	}
	
	public int getNumberParameters()
	{
		return _parameters != null ? _parameters.size(): 0;
	}
	
	public parameter getParameter (int __int)
	{
		return _parameters != null ? (parameter)_parameters.get(__int): null;
	}
}
