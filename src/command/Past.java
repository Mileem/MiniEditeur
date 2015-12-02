package command;

import receiver.EngineEdition;

/**
 * Class of the order past
 * @author Mileem
 *
 */
public class Past extends Command {

	public Past(EngineEdition engineEdition) {
		super(engineEdition);
	}
	
	/**
	 * Execute the order past define by the class EngineEdition
	 */
	@Override
	public void execute() {
		this.engineEdition.past();
	}

}
