# XtralienX100
Java Client for Xtralien X100 API

Currently this project is in development and is untested against an actual X100

example usage with simulated X100: 

		import au.com.rsutton.xtralien.commands.HelloCommand;
		import au.com.rsutton.xtralien.commands.XtrResults;
		import au.com.rsutton.xtralien.connection.XtrConnection;
		import au.com.rsutton.xtralien.connection.XtrSimulationConnection;

		...

		XtrConnection connection = new XtrSimulationConnection();
		XtrAlien alien = new XtrAlien(connection);

		XtrResults<String> result = alien.sendCommand(new HelloCommand());

example usage connected via TCP: 

		import au.com.rsutton.xtralien.commands.HelloCommand;
		import au.com.rsutton.xtralien.commands.XtrResults;
		import au.com.rsutton.xtralien.connection.XtrConnection;
		import au.com.rsutton.xtralien.connection.XtrSocketConnection;

		...

		XtrSocketConnection connection = new XtrSocketConnection("192.168.0.123",8888);
		XtrAlien alien = new XtrAlien(connection);

		XtrResults<String> result = alien.sendCommand(new HelloCommand());

implemented commands are:
	HelloCommand
	MeasureCurrentAndVoltageCommand
	MeasureCurrentCommand
	MeasureVoltageCommand
	SetVoltageCommand
	SweepCommand