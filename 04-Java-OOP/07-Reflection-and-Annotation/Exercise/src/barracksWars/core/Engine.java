package barracksWars.core;

import barracksWars.core.commands.CommandInterpreterImpl;
import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];

				CommandInterpreterImpl commandInterpreter =  new CommandInterpreterImpl(repository, unitFactory);
				Executable executable = commandInterpreter.interpretCommand(data, commandName);

				String execute = executable.execute();

				if (execute.equals("fight")) {
					break;
				}
				System.out.println(execute);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
