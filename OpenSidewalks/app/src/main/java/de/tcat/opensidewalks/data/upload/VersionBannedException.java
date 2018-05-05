package de.tcat.opensidewalks.data.upload;


public class VersionBannedException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public VersionBannedException()
	{
		super("This version is banned from making any changes!");
	}
}
