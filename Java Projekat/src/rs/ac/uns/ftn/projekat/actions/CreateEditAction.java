package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniPredmet;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniStudenta;
import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;

public class CreateEditAction extends AbstractAction {

	
	public CreateEditAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			 IzmeniPredmet ip = new IzmeniPredmet(new JFrame());
		}
		if(JTabbedPaneTabele.selektovan_tab == 0) {
			 IzmeniStudenta is = new IzmeniStudenta(new JFrame());
		}
	}

}
