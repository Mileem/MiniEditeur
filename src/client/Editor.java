package client;

import java.util.HashMap;

import command.*;
import observer.BufferObserver;
import receiver.EngineEditionImplemantation;

/**
 * Main class of the project
 * @author Mileem
 *
 */
public class Editor {
	private static HashMap<String, Command> commands;

	public static void main(String[] args) throws Exception {
		BufferObserver humanMachineInterface = new BufferObserver();
		EngineEditionImplemantation engineEdition = new EngineEditionImplemantation();
		engineEdition.addObserver(humanMachineInterface);
		
		//Commands
		commands = new HashMap<String, Command>();
		commands.put("copy", new Copy(engineEdition));
		commands.put("past", new Past(engineEdition));
		commands.put("cut", new Cut(engineEdition));
		commands.put("enter", new Enter(engineEdition, humanMachineInterface));
		commands.put("select", new Select(engineEdition, humanMachineInterface));
		commands.put("delete", new Delete(engineEdition));
		commands.put("save", new Save(engineEdition));
		
		humanMachineInterface.invokeCommands(commands);
	}

}
