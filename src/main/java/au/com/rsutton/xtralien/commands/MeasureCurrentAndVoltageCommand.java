package au.com.rsutton.xtralien.commands;

public class MeasureCurrentAndVoltageCommand implements XtrCommand<DataPoint>
{

	private int smu;
	
	MeasureCurrentAndVoltageCommand(int smu)
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

	public XtrResults<DataPoint> getResult(String rawData)
	{
		try
		{
			String data = rawData.replace("[", "").replace("]", "");

			String[] parts = data.split(",");
			DataPoint point = new DataPoint(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
			return new XtrResults<DataPoint>(false, rawData, point);
		} catch (Exception e)
		{
			return new XtrResults<DataPoint>(true, rawData, null);
		}
	}

	public String getSimulatedRawData()
	{
		return "[5.30,4.27]";
	}

	public boolean expectsResponse()
	{
		return true;
	}

}
