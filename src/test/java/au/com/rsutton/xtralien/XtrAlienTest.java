package au.com.rsutton.xtralien;

import static org.junit.Assert.*;

import java.io.IOException;

import jssc.SerialPortException;

import org.junit.Test;

import au.com.rsutton.xtralien.commands.HelloCommand;
import au.com.rsutton.xtralien.commands.XtrResults;
import au.com.rsutton.xtralien.connection.XtrConnection;
import au.com.rsutton.xtralien.connection.XtrSimulationConnection;

public class XtrAlienTest
{

	@Test
	public void test() throws IOException, SerialPortException
	{
		XtrConnection connection = new XtrSimulationConnection();
		XtrAlien alien = new XtrAlien(connection);

		XtrResults<String> result = alien.sendCommand(new HelloCommand());
		assertTrue(result.isError() == false);
		assertTrue(result.getMessage().equalsIgnoreCase("hello world"));

	}

}
