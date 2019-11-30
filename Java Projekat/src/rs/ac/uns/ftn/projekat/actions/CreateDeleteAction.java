package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.KeyStroke;


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
		// TODO Auto-generated method stub
		if(JTabbedPaneTabele.selektovan_tab == 0) {
			 ObrisiStudenta os= new ObrisiStudenta(new JFrame());
		}
	}

}
