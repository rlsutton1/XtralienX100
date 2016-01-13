package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.net.UnknownHostException;

public interface XtrConnection
{
	String sendCommand(String command) throws IOException;
	
	void connect() throws UnknownHostException, IOException;
	
	void disconnect() throws IOException;
}
