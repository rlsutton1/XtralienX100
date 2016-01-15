package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.net.UnknownHostException;

import jssc.SerialPortException;
import au.com.rsutton.xtralien.commands.XtrCommand;

public interface XtrConnection
{
	String sendCommand(XtrCommand<?> command) throws IOException, SerialPortException;
	
	void connect() throws UnknownHostException, IOException, SerialPortException;
	
	void close() throws IOException, SerialPortException;
}
