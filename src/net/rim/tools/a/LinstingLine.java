package net.rim.tools.a;

public class LinstingLine
{
	private int lineNumber;
	private String byteCode;
	private int label;
	private String byteInstruction;
	private String byteParameters;
	
	/**
	 * Sets ByteParameters
	 *
	 * @param    ByteParameters      a  String
	 */
	public void setByteParameters(String byteParameters)
	{
		this.byteParameters = byteParameters;
	}
	
	/**
	 * Returns ByteParameters
	 *
	 * @return    a  String
	 */
	public String getByteParameters()
	{
		return byteParameters;
	}
	
	/**
	 * Sets ByteInstruction
	 *
	 * @param    ByteInstruction     a  String
	 */
	public void setByteInstruction(String byteInstruction)
	{
		this.byteInstruction = byteInstruction;
	}
	
	/**
	 * Returns ByteInstruction
	 *
	 * @return    a  String
	 */
	public String getByteInstruction()
	{
		return byteInstruction;
	}
	
	/**
	 * Sets Label
	 *
	 * @param    Label               an int
	 */
	public void setLabel(int label)
	{
		this.label = label;
	}
	
	/**
	 * Returns Label
	 *
	 * @return    an int
	 */
	public int getLabel()
	{
		return label;
	}
	
	/**
	 * Sets ByteCode
	 *
	 * @param    ByteCode            a  String
	 */
	public void setByteCode(String byteCode)
	{
		this.byteCode = byteCode;
	}
	
	/**
	 * Returns ByteCode
	 *
	 * @return    a  String
	 */
	public String getByteCode()
	{
		return byteCode;
	}
	
	
	/**
	 * Sets LineNumber
	 *
	 * @param    LineNumber          an int
	 */
	public void setLineNumber(int lineNumber)
	{
		this.lineNumber = lineNumber;
	}
	
	/**
	 * Returns LineNumber
	 *
	 * @return    an int
	 */
	public int getLineNumber()
	{
		return lineNumber;
	}}
