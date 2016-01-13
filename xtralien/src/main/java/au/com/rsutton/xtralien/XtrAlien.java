package au.com.rsutton.xtralien;

import java.io.IOException;

import au.com.rsutton.xtralien.commands.XtrCommand;
import au.com.rsutton.xtralien.commands.XtrResults;
import au.com.rsutton.xtralien.connection.XtrConnection;

public class XtrAlien
{

	private XtrConnection connection;

	XtrAlien(XtrConnection connection)
	{
		this.connection = connection;
	}

	<T> XtrResults<T> sendCommand(XtrCommand<XtrResults<T>> command)
			throws IOException
	{
		String rawData = connection.sendCommand(command.getCommand());
		return command.getResult(rawData);
	}
}
