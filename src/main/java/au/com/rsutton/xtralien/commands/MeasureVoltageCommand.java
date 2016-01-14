package au.com.rsutton.xtralien.commands;

public class MeasureVoltageCommand implements XtrCommand<Double>
{

	private int smu;
	
	MeasureVoltageCommand(int smu)
	{
		this.smu = smu;
		if (smu < 1 || smu > 2)
		{
			throw new RuntimeException("SMU must be either 1 or 2");
		}
	}

	public String getCommand()
	{
		return "smu["+smu+"] measurev";
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

}
