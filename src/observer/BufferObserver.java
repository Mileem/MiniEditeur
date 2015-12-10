package observer;

import java.util.Observable;
import java.util.Observer;

import invoker.HumanMachineInterface;
import receiver.EngineEditionImplemantation;

/**
 * Observed changes in Buffer
 * @author Mileem
 *
 */
public class BufferObserver extends HumanMachineInterface implements Observer {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Update mainContent in HumainMachineInterface when the buffer changes
	 */
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof EngineEditionImplemantation) {
			EngineEditionImplemantation engineEditionImplemantation = (EngineEditionImplemantation) o;
			this.setMainContent(engineEditionImplemantation.getBuffer().getText().toString());
		}
	}

}
