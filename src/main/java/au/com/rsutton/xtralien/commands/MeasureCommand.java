package au.com.rsutton.xtralien.commands;

public class MeasureCommand implements XtrCommand<Double>
{

	private int vsense;
	
	MeasureCommand(int vsense)
	{
		this.vsense = vsense;
		if (vsense < 1 || vsense > 2)
		{
			throw new RuntimeException("VSense must be either 1 or 2");
		}
	}

	public String getCommand()
	{
		return "vsense["+vsense+"] measure";
	}

	public XtrResults<Double> getResult(String rawData)
	{
		try
		{
			return new XtrResults<Double>(false, rawData, Double.parseDouble(rawData));
		} catch (Exception e)
		{
			return new XtrResults<Double>(true, rawData, 0.0);
		}
	}
	public String getSimulatedRawData()
	{
		return "5.25";
	}

	public boolean expectsResponse()
	{
		return true;
	}
}
