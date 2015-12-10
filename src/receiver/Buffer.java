package receiver;

/**
 * Buffer that remembers some text
 * @author Mileem
 *
 */
public class Buffer {

	private StringBuffer text;
	
	Buffer() {
		this.text = new StringBuffer();
	}

	/**
	 * 
	 * @return text buffer
	 */
	public StringBuffer getText() {
		return text;
	}

	/**
	 * Update text buffer
	 * @param text
	 */
	public void setText(StringBuffer text) {
		this.text = text;
	}

}
