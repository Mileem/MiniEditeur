package invoker;

import javax.swing.JTextArea;

/**
 * Custom TextArea without copy, past, cut through the keyboard
 * @author Mileem
 *
 */
public class CustomTextArea extends JTextArea {

	private static final long serialVersionUID = 1L;
	
	public CustomTextArea() {
		super();
		this.setLineWrap(true);
	}

	@Override
    public void cut() {
        // Empty
    }

    @Override
    public void copy() {
         // Empty
    }

    @Override
    public void paste() {
        //  Empty
    }

}
