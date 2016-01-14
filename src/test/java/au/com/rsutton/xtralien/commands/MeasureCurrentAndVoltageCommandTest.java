package au.com.rsutton.xtralien.commands;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MeasureCurrentAndVoltageCommandTest
{

	@Test
	public void test()
	{
		MeasureCurrentAndVoltageCommand command = new MeasureCurrentAndVoltageCommand(1);

		XtrResults<DataPoint> result = command.getResult(command.getSimulatedRawData());
		System.out.println("Message: " + result.getMessage());
		assertFalse(result.isError());
		System.out.println(result.getData().getVoltage() + " " + result.getData().getCurrent());

	}

}
