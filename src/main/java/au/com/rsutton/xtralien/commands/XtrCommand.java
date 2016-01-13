package au.com.rsutton.xtralien.commands;

public interface XtrCommand<T>
{
	
	public String getCommand();
	
	public XtrResults<T> getResult(String rawData);
	
	
}
