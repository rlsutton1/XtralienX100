package au.com.rsutton.xtralien.commands;

public class DataPoint
{
	private final Double voltage;
	private final Double current;
	
	DataPoint(Double voltage,Double current)
	{
		this.voltage =voltage;
		this.current = current;
	}
	
	public Double getVoltage()
	{
		return voltage;
	}
	public Double getCurrent()
	{
		return current;
	}
}
