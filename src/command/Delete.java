package command;

import receiver.EngineEdition;

/**
 * Class of the order delete
 * @author Mileem
 *
 */
public class Delete extends Command {

	public Delete(EngineEdition engineEdition) {
		super(engineEdition);
	}
	
	/**
	 * Execute the order delete define by the class EngineEdition
	 */
	@Override
	public void execute() {
		this.engineEdition.delete();
	}

}
