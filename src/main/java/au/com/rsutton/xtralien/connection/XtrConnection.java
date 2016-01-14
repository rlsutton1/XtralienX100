package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.net.UnknownHostException;

import au.com.rsutton.xtralien.commands.XtrCommand;

public interface XtrConnection
{
	String sendCommand(XtrCommand<?> command) throws IOException;
	
	void connect() throws UnknownHostException, IOException;
	
	void disconnect() throws IOException;
}
