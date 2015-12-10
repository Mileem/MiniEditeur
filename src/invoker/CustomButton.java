package invoker;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Custom button with a picture
 * @author Mileem
 *
 */
public class CustomButton extends JButton{
	public CustomButton(String name, String picture) {
		super(name);
		addImage(picture);
	}
	
	/**
	 * Add a picture to a Button 
	 * @param picture
	 */
	public void addImage(String picture) {
		String pictureName = "/" + picture + ".png";
		ImageIcon icon = new ImageIcon(getClass().getResource(pictureName));
		setIcon(icon);
	}

}
