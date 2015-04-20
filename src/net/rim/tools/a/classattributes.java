package net.rim.tools.a;

import java.util.*;
import net.rim.tools.a.attribute;

public final class classattributes
{
	public Vector _attributes;
	
	public classattributes()
	{
		_attributes = new Vector(0);
	}
	
	public void addattributes(int __attributes)
	{
        int j = __attributes;
        if ((j & 0x200) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsInner");
			_attribute_.setAttributeName("");
            _attributes.add(_attribute_);
		}
        if ((j & 0x100) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsUnGroupable");
			_attribute_.setAttributeName("");
            _attributes.add(_attribute_);
		}
        if ((j & 0x80) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsPersistable");
			_attribute_.setAttributeName("");
            _attributes.add(_attribute_);
		}
        if ((j & 0x40) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("HasVerifyError");
			_attribute_.setAttributeName("");
            _attributes.add(_attribute_);
		}
        if ((j & 0x20) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsInterface");
			_attribute_.setAttributeName("interface");
            _attributes.add(_attribute_);
		}
        if ((j & 10) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsAbstract");
			_attribute_.setAttributeName("abstract");
            _attributes.add(_attribute_);
		}
        if ((j & 1) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsPublic");
			_attribute_.setAttributeName("public");
            _attributes.add(_attribute_);
		}
        if ((j & 2) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsPrivate");
			_attribute_.setAttributeName("private");
            _attributes.add(_attribute_);
		}
        if ((j & 4) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsProtected");
			_attribute_.setAttributeName("protected");
            _attributes.add(_attribute_);
		}
        if ((j & 8) != 0)
		{
			attribute _attribute_ = new attribute();
			_attribute_.setAttribute("IsFinal");
			_attribute_.setAttributeName("final");
            _attributes.add(_attribute_);
		}
	}
	
	public attribute getattribute(int __int)
	{
		if (_attributes != null)
		{
			return (attribute)_attributes.get(__int);
		}
		return null;
	}
	
	public int getAttributeIndex (String __attribute)
	{
		if (_attributes != null)
		{
			for (int i = 0; i < _attributes.size(); i++)
			{
				if (getattribute(i).getAttribute().equalsIgnoreCase(__attribute))
					return i;
			}
		}
		return -1;
	}
	
	public Boolean hasAttribute (String __attribute)
	{
		if (_attributes != null)
		{
			for (int i = 0; i < _attributes.size(); i++)
			{
				if (getattribute(i).getAttribute().equalsIgnoreCase(__attribute))
					return true;
			}
		}
		return false;
	}
	
	public String getAttributesString()
	{
		String _attributesString_ = "";
		if (_attributes != null)
		{
			for (int i = 0; i < _attributes.size(); i++)
			{
				attribute _attribute_ = getattribute(i);
				if (_attribute_ != null)
					if (_attribute_.getAttributeName().length()!=0)
						_attributesString_ = _attributesString_ +  _attribute_.getAttributeName() + " ";
			}
		}
		return _attributesString_;
	}
	
	public int getNumberAttributes()
	{
		return _attributes != null ? _attributes.size(): 0;
	}
	
}
