package au.com.rsutton.xtralien.commands;

public class SetOsrModeCommand implements XtrCommand<Void>
{

	private int mode;
	private int smu;

	SetOsrModeCommand(int smu, int mode)
	{
		this.smu = smu;
		this.mode = mode;
		if (smu < 1 || smu > 2)
		{
			throw new RuntimeException("Mode must be either 1 or 2");
		}
		if (mode >=1 && mode <= 9)
		{
			throw new RuntimeException("Mode must be between -10.0 and 10.0");
		}
	}

	public String getCommand()
	{
		return "smu[" + smu + "] set osr [" + mode + "]";
	}

	public XtrResults<Void> getResult(String rawData)
	{
		return new XtrResults<Void>(false, "", null);

	}

	public String getSimulatedRawData()
	{
		return "";
	}

	public boolean expectsResponse()
	{
		return false;
	}

}
