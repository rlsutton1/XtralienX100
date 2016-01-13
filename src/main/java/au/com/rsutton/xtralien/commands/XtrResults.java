package au.com.rsutton.xtralien.commands;

public class XtrResults<T>
{

	final private boolean error;
	final private String message;
	final private T data;

	XtrResults(boolean isError, String message, T data)
	{
		this.error = isError;
		this.message = message;
		this.data = data;
	}

	public boolean isError()
	{
		return error;
	}

	public String getMessage()
	{
		return message;
	}

	public T getData()
	{
		return data;
	}

}
