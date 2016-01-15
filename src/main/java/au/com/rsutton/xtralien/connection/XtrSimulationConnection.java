package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.net.UnknownHostException;

import au.com.rsutton.xtralien.commands.XtrCommand;

public class XtrSimulationConnection implements XtrConnection
{

	public String sendCommand(XtrCommand<?> command) throws IOException
	{
		return command.getSimulatedRawData();
	}

	public void connect() throws UnknownHostException, IOException
	{

		
	}

	public void close() throws IOException
	{
		

	}

}
