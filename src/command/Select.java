package command;

import invoker.HumanMachineInterface;
import receiver.EngineEdition;

/**
 * Class of the order select
 * @author Mileem
 *
 */
public class Select extends Command {
	private HumanMachineInterface humanMachineInterface;

	public Select(EngineEdition engineEdition, HumanMachineInterface humanMachineInterface) {
		super(engineEdition);
		this.humanMachineInterface = humanMachineInterface;
	}
	
	/**
	 * Execute the order save define by the class EngineEdition
	 */
	@Override
	public void execute() {
		int min = Math.min(this.humanMachineInterface.mainContent.getCaret().getDot(), this.humanMachineInterface.mainContent.getCaret().getMark());
		int max = Math.max(this.humanMachineInterface.mainContent.getCaret().getDot(), this.humanMachineInterface.mainContent.getCaret().getMark());
		this.engineEdition.select(min, max-min);
	}

}
