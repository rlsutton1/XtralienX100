package au.com.rsutton.xtralien.connection;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import au.com.rsutton.xtralien.commands.XtrCommand;

public class XtrSocketConnection implements XtrConnection
{

	private Socket socket;
	private PrintWriter out;
	private InputStreamReader in;
	private String host;
	private int port;

	public XtrSocketConnection(String host, int port)
	{
		this.host = host;
		this.port = port;
	}

	public String sendCommand(XtrCommand<?> command) throws IOException
	{
		out.print(command.getCommand());
		out.flush();

		String result = "";
		if (command.expectsResponse())
		{

			int ch;
			while ((ch = in.read()) != -1)
			{
				result += ch;
			}
		}
		return result;
	}

	public void connect() throws UnknownHostException, IOException
	{

		socket = new Socket(host, port);
		out = new PrintWriter(socket.getOutputStream(), true);
		in = new InputStreamReader(socket.getInputStream());

	}

	public void close() throws IOException
	{
		in.close();
		out.close();
		socket.close();

	}

}
