package receiver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Observable;

import javax.swing.JFileChooser;

public class EngineEditionImplemantation extends Observable implements EngineEdition {
	private Buffer buffer;
	private Paperweight paperweight;
	private Selection selection;
	
	public EngineEditionImplemantation() {
		this.setBuffer(new Buffer());
		this.setPaperweight(new Paperweight());
		this.setSelection(new Selection());
	}
	
	@Override
	public void copy() {
		if(this.selection.getLength() > 0) {
			this.paperweight.setPaperweight(this.buffer.getText().substring(this.selection.getStart(), this.selection.getEnd()));
		}
		setChanged();
		notifyObservers();
	}

	@Override
	public void past() {
		if(this.selection.getLength() == 0) {
			this.buffer.getText().insert(this.selection.getStart(), this.paperweight.getPaperweight());
		} else {
			this.buffer.getText().delete(this.selection.getStart(), this.selection.getEnd());
			this.buffer.getText().insert(this.selection.getStart(), this.paperweight.getPaperweight());
		}
		this.selection.setStart(this.selection.getEnd());
		this.selection.setLength(0);
		setChanged();
		notifyObservers();
	}

	@Override
	public void cut() {
		if(this.selection.getLength() > 0) {
			this.paperweight.setPaperweight(this.buffer.getText().substring(this.selection.getStart(), this.selection.getEnd()));
			this.buffer.getText().delete(this.selection.getStart(), this.selection.getEnd());
		}
		this.selection.setLength(0);
		setChanged();
		notifyObservers();
	}

	@Override
	public void select(int start, int length) {
		if(start >= 0 && length <= this.buffer.getText().length()) {
			this.selection.setStart(start);
			this.selection.setLength(length);
		} 
	}

	@Override
	public void enter(char c) {
		if(this.selection.getStart() != this.selection.getEnd()) {
			this.delete();
		}
		if(c == '\n') {
			this.buffer.getText().insert(this.selection.getStart()-1, c);
		} else {
			this.buffer.getText().insert(this.selection.getStart(), c);
		}
	}

	@Override
	public void delete() {
		if(this.selection.getLength() != 0) {
			this.buffer.getText().delete(this.selection.getStart(), this.selection.getEnd());
			this.selection.setLength(0);
		} else if(this.selection.getLength() == 0 && this.selection.getStart() > 0){
			this.buffer.getText().deleteCharAt(this.selection.getStart()-1);
		} if(this.selection.getStart() == 0 && this.selection.getLength() == this.buffer.getText().length()) {
			this.buffer.getText().append("");
		}
	}
	
	@Override
	public void save() {
		JFileChooser pathFile = new JFileChooser();
		int retour = pathFile.showSaveDialog(pathFile);
		if(retour==JFileChooser.APPROVE_OPTION){
			// Create file
		    FileWriter fstream;
			try {
				fstream = new FileWriter(pathFile.getSelectedFile().getAbsolutePath() + ".txt");
				BufferedWriter out = new BufferedWriter(fstream);
			    try {
			    	out.write(this.buffer.getText().toString());
			    } catch (IOException e) {
			    	e.printStackTrace();
			    } finally {
			    	//Close the output stream
			    	out.close();
			    }
			} catch (IOException e) {
				e.printStackTrace();
			}
		       
		}
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	public Paperweight getPaperweight() {
		return paperweight;
	}

	public void setPaperweight(Paperweight paperweight) {
		this.paperweight = paperweight;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

}
