package receiver;


public class Buffer {

	private StringBuffer text;
	
	Buffer() {
		this.text = new StringBuffer();
	}

	public StringBuffer getText() {
		return text;
	}

	public void setText(StringBuffer text) {
		this.text = text;
	}

}
