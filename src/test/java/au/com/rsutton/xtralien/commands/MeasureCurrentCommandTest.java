package au.com.rsutton.xtralien.commands;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class MeasureCurrentCommandTest
{

	@Test
	public void test()
	{
		MeasureCurrentCommand command = new MeasureCurrentCommand(1);

		XtrResults<Double> result = command.getResult(command.getSimulatedRawData());
		System.out.println("Message: " + result.getMessage());
		assertFalse(result.isError());
		System.out.println(result.getData());

	}

}
