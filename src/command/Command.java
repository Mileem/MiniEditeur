package command;

import receiver.EngineEdition;

/**
 *  Command interface that corresponds to the Command design pattern
 * @author Mileem
 *
 */
public abstract class Command {
	protected EngineEdition engineEdition;
	
	/**
	 * 
	 * @param engineEdition implements the commands to execute
	 */
	public Command(EngineEdition engineEdition) {
		this.engineEdition = engineEdition;
	}
	
	public abstract void execute();
}
