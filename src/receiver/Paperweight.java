package receiver;

/**
 * Paperweight that remembers last selection
 * @author Mileem
 *
 */
public class Paperweight {
	private String memory;

	
	public Paperweight() {
		this.setPaperweight("");
	}

	/**
	 * 
	 * @return paperweight
	 */
	public String getPaperweight() {
		return memory;
	}

	/**
	 * Update paperweight
	 * @param memory
	 */
	public void setPaperweight(String memory) {
		this.memory = memory;
	}

}
