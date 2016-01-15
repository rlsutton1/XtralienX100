package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.net.UnknownHostException;

import jssc.SerialPort;
import jssc.SerialPortException;
import au.com.rsutton.xtralien.commands.XtrCommand;

public class XtrSerialConnection implements XtrConnection
{

	private String comportName;
	private SerialPort port;

	XtrSerialConnection(String comport)
	{
		this.comportName = comport;
	}

	public String sendCommand(XtrCommand<?> command) throws IOException, SerialPortException
	{
		port.writeString(command.getCommand());

		String result = "";
		if (command.expectsResponse())
		{
			String part;

			while ((part = port.readString()) != null)
			{
				result += part;
			}
		}
		return result;
	}

	public void connect() throws UnknownHostException, IOException, SerialPortException
	{
		port = new SerialPort(comportName);
		port.openPort();

	}

	public void close() throws IOException, SerialPortException
	{

		port.closePort();
	}

}
