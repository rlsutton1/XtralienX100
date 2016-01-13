package au.com.rsutton.xtralien.commands;

public class SweepCommand implements XtrCommand<Integer>
{

	private static final int MAX_STEPS = 2048;
	private Double fromVoltage;
	private Double toVoltage;
	private Double stepSize;
	private boolean bothWays;

	SweepCommand(Double fromVoltage, Double toVoltage, Double stepSize,
			boolean bothWays)
	{
		this.fromVoltage = fromVoltage;
		this.toVoltage = toVoltage;
		this.stepSize = stepSize;
		this.bothWays = bothWays;
		if (Math.abs(fromVoltage - toVoltage) / stepSize > MAX_STEPS)
		{
			throw new RuntimeException("Too many steps, Maximum " + MAX_STEPS
					+ " steps");
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

	public XtrResults<Integer> getResult(String rawData)
	{

		return new XtrResults<Integer>(false, "", Integer.parseInt(rawData));

	}

}
