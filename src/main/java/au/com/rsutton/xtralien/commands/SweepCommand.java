package au.com.rsutton.xtralien.commands;

import java.util.LinkedList;
import java.util.List;

public class SweepCommand implements XtrCommand<List<DataPoint>>
{

	private static final int MAX_STEPS = 2048;
	private Double fromVoltage;
	private Double toVoltage;
	private Double stepSize;
	private boolean bothWays;

	SweepCommand(Double fromVoltage, Double toVoltage, Double stepSize, boolean bothWays)
	{
		this.fromVoltage = fromVoltage;
		this.toVoltage = toVoltage;
		this.stepSize = stepSize;
		this.bothWays = bothWays;
		if (Math.abs(fromVoltage - toVoltage) / stepSize > MAX_STEPS)
		{
			throw new RuntimeException("Too many steps, Maximum " + MAX_STEPS + " steps");
		}
	}

	public String getCommand()
	{
		String both = "";
		if (bothWays)
		{
			both = " d";
		}

		return "Sweep " + fromVoltage + " " + stepSize + " " + toVoltage + both;
	}

	public XtrResults<List<DataPoint>> getResult(String rawData)
	{

		try
		{
			List<DataPoint> results = new LinkedList<DataPoint>();

			String data = rawData.replace("[", "").replace("]", "");
			String[] pairs = data.split(";");
			for (String pair : pairs)
			{
				String[] parts = pair.split(",");
				DataPoint point = new DataPoint(Double.parseDouble(parts[0]), Double.parseDouble(parts[1]));
				results.add(point);
			}
			return new XtrResults<List<DataPoint>>(false, rawData, results);
		} catch (Exception e)
		{
			return new XtrResults<List<DataPoint>>(true, rawData, null);
		}
	}

	public String getSimulatedRawData()
	{
		String ret = "[";
		for (double i = fromVoltage; i < toVoltage; i += stepSize)

		{
			ret += "" + i + ",0.00;";


		}
		return ret + "]";
	}

	public boolean expectsResponse()
	{
		return true;
	}

}
