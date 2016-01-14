package au.com.rsutton.xtralien.commands;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SetVoltageCommandTest
{

	@Test
	public void test()
	{
		SetVoltageCommand command = new SetVoltageCommand(1,-10.0);

		XtrResults<Void> result = command.getResult(command.getSimulatedRawData());
		System.out.println("Message: " + result.getMessage());
		assertFalse(result.isError());
		
	}

}
