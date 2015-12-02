package receiver;

public class Selection {
	private int start;
	private int length;
	
	public Selection() {
		this.setStart(0);
		this.setLength(0);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	public int getEnd() {
		return this.start+this.length;
	}

}
