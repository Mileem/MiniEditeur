package command;

import receiver.EngineEdition;

/**
 * Class of the order save
 * @author Mileem
 *
 */
public class Save extends Command {

	public Save(EngineEdition engineEdition) {
		super(engineEdition);
	}
	
	/**
	 * Execute the order save define by the class EngineEdition
	 */
	@Override
	public void execute() {
		this.engineEdition.save();
	}

}
