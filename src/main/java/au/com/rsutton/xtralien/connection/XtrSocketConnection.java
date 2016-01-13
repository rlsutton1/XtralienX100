package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class XtrSocketConnection implements XtrConnection
{

	private Socket socket;
	private PrintWriter out;
	private InputStreamReader in;
	private String host;
	private int port;
	
	XtrSocketConnection(String host, int port)
	{
		this.host = host;
		this.port = port;
	}
	

	public String sendCommand(String command) throws IOException
	{
		out.print(command);
		
		String result = "";
		int ch;
		while ((ch = in.read())!=-1)
		{
			result+=ch;
		}
		return result;
	}

	public void connect() throws UnknownHostException, IOException
	{

		socket = new Socket(host, port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new InputStreamReader(socket.getInputStream());

	}

	public void disconnect() throws IOException
	{
		in.close();
		out.close();
		socket.close();

	}

}
