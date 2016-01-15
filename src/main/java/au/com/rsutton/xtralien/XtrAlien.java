package au.com.rsutton.xtralien;

import java.io.IOException;

import jssc.SerialPortException;
import au.com.rsutton.xtralien.commands.HelloCommand;
import au.com.rsutton.xtralien.commands.XtrCommand;
import au.com.rsutton.xtralien.commands.XtrResults;
import au.com.rsutton.xtralien.connection.XtrConnection;

public class XtrAlien
{

	private XtrConnection connection;

	public XtrAlien(XtrConnection connection) throws IOException, SerialPortException
	{
		this.connection = connection;

		XtrResults<String> result = sendCommand(new HelloCommand());
		if (result.isError())
		{
			throw new RuntimeException("Couldn't connect to XtrAlien");
		}

	}

	public <T> XtrResults<T> sendCommand(XtrCommand<T> command) throws IOException, SerialPortException
	{
		String rawData = connection.sendCommand(command);
		return command.getResult(rawData);
	}
}
