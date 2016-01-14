package au.com.rsutton.xtralien.commands;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class HelloCommandTest
{

	@Test
	public void test()
	{
		HelloCommand command = new HelloCommand();

		XtrResults<String> result = command.getResult(command.getSimulatedRawData());
		System.out.println("Message: " + result.getMessage());
		assertFalse(result.isError());
		assertTrue(result.getMessage().equalsIgnoreCase("Hello World"));
	}

}
