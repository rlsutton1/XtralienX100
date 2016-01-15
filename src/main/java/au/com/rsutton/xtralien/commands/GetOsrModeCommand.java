package au.com.rsutton.xtralien.commands;

public class GetOsrModeCommand implements XtrCommand<Integer>
{

	private int smu;

	GetOsrModeCommand(int smu)
	{
		this.smu = smu;
		if (smu < 1 || smu > 2)
		{
			throw new RuntimeException("SMU must be either 1 or 2");
		}
	}

	public String getCommand()
	{
		return "smu[" + smu + "] get osr";
	}

	public XtrResults<Integer> getResult(String rawData)
	{
		try
		{
			return new XtrResults<Integer>(false, rawData, Integer.parseInt(rawData));
		} catch (Exception e)
		{
			return new XtrResults<Integer>(true, rawData, 0);
		}
	}

	public String getSimulatedRawData()
	{
		return "3";
	}

	public boolean expectsResponse()
	{
		return true;
	}
}
