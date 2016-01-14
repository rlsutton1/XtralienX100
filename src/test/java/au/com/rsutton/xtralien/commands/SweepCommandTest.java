package au.com.rsutton.xtralien.commands;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SweepCommandTest
{

	@Test
	public void test()
	{
		SweepCommand command = new SweepCommand(-10.0, 10.0, 1.0, false);

		XtrResults<List<DataPoint>> result = command.getResult(command.getSimulatedRawData());
		System.out.println("Message: " + result.getMessage());
		assertFalse(result.isError());
		for (DataPoint value:result.getData())
		{
			System.out.println(value.getVoltage()+" "+value.getCurrent());
		}
	}

}
