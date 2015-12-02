package command;

import receiver.EngineEdition;

/**
 * Class of the order copy
 * @author Mileem
 *
 */
public class Copy extends Command {

	public Copy(EngineEdition engineEdition) {
		super(engineEdition);
	}
	
	/**
	 * Execute the order copy define by the class EngineEdition
	 */
	@Override
	public void execute() {
		this.engineEdition.copy();	
	}
	
}
