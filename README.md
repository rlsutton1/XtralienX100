# XtralienX100
Java Client for Xtralien X100 API

Currently this project is in development and is untested against an actual X100

Example usage with simulated X100: 

		import au.com.rsutton.xtralien.commands.HelloCommand;
		import au.com.rsutton.xtralien.commands.XtrResults;
		import au.com.rsutton.xtralien.connection.XtrConnection;
		import au.com.rsutton.xtralien.connection.XtrSimulationConnection;

		...

		XtrConnection connection = new XtrSimulationConnection();
		XtrAlien alien = new XtrAlien(connection);

		XtrResults<String> result = alien.sendCommand(new HelloCommand());

Example usage connected via TCP: 

		import au.com.rsutton.xtralien.commands.HelloCommand;
		import au.com.rsutton.xtralien.commands.XtrResults;
		import au.com.rsutton.xtralien.connection.XtrConnection;
		import au.com.rsutton.xtralien.connection.XtrSocketConnection;

		...

		XtrSocketConnection connection = new XtrSocketConnection("192.168.0.123",8888);
		XtrAlien alien = new XtrAlien(connection);

		XtrResults<String> result = alien.sendCommand(new HelloCommand());

Example MeasureVoltageCommand

		MeasureVoltageCommand command = new MeasureVoltageCommand(1);
		XtrResults<Double> result = alien.sendCommand(command);
		System.out.println("Message: " + result.getMessage());
		System.out.println("" + result.isError());
		System.out.println(result.getData());

Example SweepCommand

		SweepCommand command = new SweepCommand(-10.0, 10.0, 1.0, false);
		XtrResults<List<DataPoint>> result = alien.sendCommand(command);
		System.out.println("Message: " + result.getMessage());
		System.out.println("" + result.isError());
		List<DataPoint> values = result.getData();

Implemented commands are:

	HelloCommand
	MeasureCurrentAndVoltageCommand
	MeasureCurrentCommand
	MeasureVoltageCommand
	SetVoltageCommand
	SweepCommand