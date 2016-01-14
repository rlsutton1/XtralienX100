package au.com.rsutton.xtralien.commands;

public class SetVoltageCommand implements XtrCommand<Void>
{

	private Double voltage;
	private int smu;
	
	SetVoltageCommand(int smu,Double voltage)
	{
		this.smu = smu;
		this.voltage = voltage;
		if (smu < 1 || smu > 2)
		{
			throw new RuntimeException("SMU must be either 1 or 2");
		}
		if (Math.abs(voltage)> 10.0)
		{
			throw new RuntimeException("Voltage must be between -10.0 and 10.0");
		}
	}

	public String getCommand()
	{
		return "smu["+smu+"] set voltage ["+voltage+"]";
	}

	public XtrResults<Void> getResult(String rawData)
	{
		return new XtrResults<Void>(false,"",null);

	}

	public String getSimulatedRawData()
	{
		return "";
	}
}
