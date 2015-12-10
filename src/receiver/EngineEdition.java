package receiver;

/**
 * Interface of engine edition
 * @author Mileem
 *
 */
public interface EngineEdition {

	public void copy();
	public void past();
	public void cut();
	public void select(int start, int length);
	public void enter(char c);
	public void delete();
	public void save();
}
