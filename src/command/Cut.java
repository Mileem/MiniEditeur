package command;

import receiver.EngineEdition;

/**
 * Class of the order cut
 * @author Mileem
 *
 */
public class Cut extends Command {

	public Cut(EngineEdition engineEdition) {
		super(engineEdition);
	}
	
	/**
	 * Execute the order cut define by the class EngineEdition
	 */
	@Override
	public void execute() {
		this.engineEdition.cut();
	}

}
