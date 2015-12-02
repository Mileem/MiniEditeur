package receiver;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestEngineEdition {

	@Test
	public void testCopier() {
		StringBuffer sb = new StringBuffer("Portez ce vieux whisky au juge blond qui fume.");
		EngineEditionImplemantation moteur = new EngineEditionImplemantation();
		Selection select = moteur.getSelection();
		moteur.getBuffer().setText(sb);
		moteur.select(0, sb.length()-10);
		moteur.copy();
		assertTrue(moteur.getPaperweight().getPaperweight().equals("Portez ce vieux whisky au juge blond"));
	}

}
