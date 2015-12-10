package invoker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import command.Command;

/**
 * Interface of the editor
 * @author Mileem
 *
 */
public class HumanMachineInterface extends JFrame{

	private static final long serialVersionUID = 1L;

	private char lastChar; 
	
	private Command copy;
	private Command past;
	private Command cut;
	private Command enter;
	private Command delete;
	private Command select;
	private Command save;

	public final JButton copyButton = new CustomButton("Copier", "copier");
	public final JButton pastButton = new CustomButton("Coller", "coller");
	public final JButton cutButton = new CustomButton("Couper", "couper");
	public final JButton saveButton = new CustomButton("Enregistrer", "save");
    public final JButton closeButton = new JButton("Fermer l'éditeur");
    
    public final JTextArea mainContent = new CustomTextArea();
    
    public final JPanel topButton = new JPanel();
    public final JPanel textArea = new JPanel();
    public final JPanel close = new JPanel();
    public final JPanel publisher = new JPanel();
	
    /**
     * Constructor of HumanMachineInterface
     */
	public HumanMachineInterface() {
		this.lastChar = '\0';
		
		this.setTitle("Editor");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		
		topButton.setLayout(new BoxLayout(topButton, BoxLayout.LINE_AXIS));
		topButton.add(copyButton);
		topButton.add(pastButton);		
		topButton.add(cutButton);
		topButton.add(saveButton);
		
		textArea.setLayout(new BoxLayout(textArea, BoxLayout.LINE_AXIS));
		mainContent.setSize(400, 250);
		mainContent.setVisible(true);
		mainContent.requestFocusInWindow();
		JScrollPane scrollPaneForMainContent = new JScrollPane(mainContent); 
		textArea.add(scrollPaneForMainContent);
		
		this.mainContent.addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				select.execute(); 
			}
		});
		
		this.mainContent.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() != KeyEvent.VK_BACK_SPACE) {					
					lastChar = e.getKeyChar();
					enter.execute();
				} 
			}
			
			@Override
			public void keyReleased(KeyEvent e) {	
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
					delete.execute();
				}
			}
			
		});
		
		this.copyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				copy.execute();
				mainContent.requestFocusInWindow();
			}
		});
		
		this.pastButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				past.execute();
				mainContent.requestFocusInWindow();
			}
		});
		
		this.cutButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cut.execute();
				mainContent.requestFocusInWindow();
			}
		});
		
		this.saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				save.execute();
				mainContent.requestFocusInWindow();
			}
		});
		
		close.setLayout(new BoxLayout(close, BoxLayout.LINE_AXIS));
		closeButton.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		close.add(closeButton);
		
		JPanel publisher = new JPanel();
		publisher.setLayout(new BoxLayout(publisher, BoxLayout.PAGE_AXIS));
		publisher.add(topButton);
		publisher.add(textArea);
		publisher.add(close);
		
		this.getContentPane().add(publisher);	
		
		this.setVisible(true);
	}
	
	/**
	 * 
	 * @return last char enter in the mainContent
	 */
	public char getChar() {
		return this.lastChar;
	}
	
	/**
	 * Update the mainContent
	 * @param text that should appear in mainContent
	 */
	public void setMainContent(String text) {
		this.mainContent.setText(text);
	}
	
	/**
	 * Definition commands
	 * @param commands List contains commands
	 * @throws Exception
	 */
	public void invokeCommands(HashMap<String, Command> commands) throws Exception{
		this.copy = commands.get("copy");
		if(copy == null) {
			throw new Exception("Error: don't copied");
		}
		this.past = commands.get("past");
		if(past == null) {
			throw new Exception("Error: don't pasted");
		}
		this.cut = commands.get("cut");
		if(cut == null) {
			throw new Exception("Error: don't cuted");
		}
		this.enter = commands.get("enter");
		if(enter == null) {
			throw new Exception("Error: don't entered");
		}
		this.select = commands.get("select");
		if(select == null) {
			throw new Exception("Error: don't selected");
		}
		this.delete = commands.get("delete");
		if(delete == null) {
			throw new Exception("Error: don't deleted");
		}
		this.save = commands.get("save");
		if(save == null) {
			throw new Exception("Error: don't save");
		}
	}
	
}
