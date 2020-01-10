package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.dialogs.DodajProfesora;
import rs.ac.uns.ftn.projekat.dialogs.DodajStudenta;
import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class CreateEntityAction extends AbstractAction{


	private static final long serialVersionUID = 1218029309718581204L;

	public CreateEntityAction() {

		//putValue(MNEMONIC_KEY, KeyEvent.VK_N);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			DodajPredmet dp = new DodajPredmet(MainFrame.getInstance());
		}else if(JTabbedPaneTabele.selektovan_tab == 1) {
			DodajProfesora dp = new DodajProfesora(new JFrame());
		}else if(JTabbedPaneTabele.selektovan_tab == 0) {
			DodajStudenta ds = new DodajStudenta(new JFrame());
		}
		
	}
	
	

}
