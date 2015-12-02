package invoker;

import javax.swing.JTextArea;


public class TextAreaCustom extends JTextArea {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TextAreaCustom() {
		super();
		this.setLineWrap(true);
	}

	@Override
    public void cut() {
        // 
    }

    @Override
    public void copy() {
         //
    }

    @Override
    public void paste() {
        //   
    }

}
