package au.com.rsutton.xtralien;

import java.io.IOException;

import jssc.SerialPortException;
import au.com.rsutton.xtralien.commands.HelloCommand;
import au.com.rsutton.xtralien.commands.XtrResults;
import au.com.rsutton.xtralien.connection.XtrSocketConnection;

public class Demo
{

	public static void main(String[] args) throws IOException, SerialPortException
	{
		XtrSocketConnection connection = new XtrSocketConnection("127.0.0.1", 8080);
		try
		{
			connection.connect();
			XtrAlien xtr = new XtrAlien(connection);

			XtrResults<String> result = xtr.sendCommand(new HelloCommand());

			System.out.println(result.getMessage());
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			connection.close();
		}
	}

}
