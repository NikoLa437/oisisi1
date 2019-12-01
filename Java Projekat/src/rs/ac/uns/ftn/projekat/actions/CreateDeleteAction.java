package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.dialogs.ObrisiPredmet;
import rs.ac.uns.ftn.projekat.dialogs.ObrisiProfesora;
import rs.ac.uns.ftn.projekat.dialogs.ObrisiStudenta;
import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;

public class CreateDeleteAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CreateDeleteAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			ObrisiPredmet op = new ObrisiPredmet(new JFrame());
		}
		if(JTabbedPaneTabele.selektovan_tab == 1) {
			ObrisiProfesora op = new ObrisiProfesora(new JFrame());
		}
		if(JTabbedPaneTabele.selektovan_tab == 0) {
			 ObrisiStudenta os= new ObrisiStudenta(new JFrame());
		}
	}

}
