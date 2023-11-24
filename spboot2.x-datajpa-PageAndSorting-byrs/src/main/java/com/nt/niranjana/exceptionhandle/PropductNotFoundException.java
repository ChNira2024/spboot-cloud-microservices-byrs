package com.nt.niranjana.exceptionhandle;

public class PropductNotFoundException extends RuntimeException
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PropductNotFoundException()
	{
		super();
	}
	public PropductNotFoundException(String msg)
	{
		super(msg);
	}
}
