package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;
import rs.ac.uns.ftn.projekat.view.MainFrame;
import rs.ac.uns.ftn.projekat.view.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.view.dialogs.DodajProfesora;
import rs.ac.uns.ftn.projekat.view.dialogs.DodajStudenta;

public class CreateEntityAction extends AbstractAction{


	private static final long serialVersionUID = 1218029309718581204L;

	@SuppressWarnings("deprecation")
	public CreateEntityAction() {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_MASK));
	
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			DodajPredmet dp = new DodajPredmet(MainFrame.getInstance());
		}else if(JTabbedPaneTabele.selektovan_tab == 1) {
			DodajProfesora dp = new DodajProfesora(MainFrame.getInstance());
		}else if(JTabbedPaneTabele.selektovan_tab == 0) {
			DodajStudenta ds = new DodajStudenta(MainFrame.getInstance());
		}
		
	}
}
