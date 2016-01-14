package au.com.rsutton.xtralien.commands;

public class HelloCommand implements XtrCommand<String>
{

	public String getCommand()
	{
		return "cloi hello";
	}

	public XtrResults<String> getResult(String rawData)
	{
		return new XtrResults<String>(false,rawData,rawData);

	}

	public String getSimulatedRawData()
	{
		return "Hello World";
	}

}
