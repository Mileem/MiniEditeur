package command;

import invoker.HumanMachineInterface;
import receiver.EngineEdition;

/**
 * Class of the order enter
 * @author Mileem
 *
 */
public class Enter extends Command {
	private HumanMachineInterface humanMachineInterface;

	public Enter(EngineEdition engineEdition, HumanMachineInterface humanMachineInterface) {
		super(engineEdition);
		this.humanMachineInterface = humanMachineInterface;
	}
	
	/**
	 * Execute the order enter define by the class EngineEdition
	 */
	@Override
	public void execute() {
		char c = this.humanMachineInterface.getChar();
		this.engineEdition.enter(c);
	}

}
