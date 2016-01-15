package au.com.rsutton.xtralien.commands;

public class HelloCommand implements XtrCommand<String>
{

	public String getCommand()
	{
		return "cloi hello";
	}

	public XtrResults<String> getResult(String rawData)
	{
		if (rawData.equalsIgnoreCase("Hello world"))
		{
			return new XtrResults<String>(false,rawData,rawData);	
		}
		return new XtrResults<String>(true, rawData, rawData);

	}

	public String getSimulatedRawData()
	{
		return "Hello World";
	}

	public boolean expectsResponse()
	{
		return true;
	}

}
