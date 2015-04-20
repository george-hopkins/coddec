package net.rim.tools.a;

import java.util.*;

public final class attribute
{
	public String __attribute;
	public String __attributeName;
	
	public attribute()
	{
		__attribute = "";
		__attributeName = "";
	}
	
	/**
	 * Sets AttributeName
	 *
	 * @param    AttributeName       a  String
	 */
	public void setAttributeName(String attributeName)
	{
		__attributeName = attributeName;
	}
	
	/**
	 * Returns AttributeName
	 *
	 * @return    a  String
	 */
	public String getAttributeName()
	{
		return __attributeName;
	}
	
	/**
	 * Sets Attribute
	 *
	 * @param    Attribute           a  String
	 */
	public void setAttribute(String attribute)
	{
		__attribute = attribute;
	}
	
	/**
	 * Returns Attribute
	 *
	 * @return    a  String
	 */
	public String getAttribute()
	{
		return __attribute;
	}
}
