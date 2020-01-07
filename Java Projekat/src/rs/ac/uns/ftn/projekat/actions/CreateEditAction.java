package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniPredmet;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniProfesora;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniStudenta;
import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class CreateEditAction extends AbstractAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CreateEditAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_E);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E,KeyEvent.CTRL_MASK));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			 @SuppressWarnings("unused")
			IzmeniPredmet ip;
			 if(PredmetJTable.selectedRow != -1)
				 ip= new IzmeniPredmet(new JFrame());
			 else
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet za izmenu!", "Error", JOptionPane.ERROR_MESSAGE );

		}
		if(JTabbedPaneTabele.selektovan_tab == 1) {
			@SuppressWarnings("unused")
			IzmeniProfesora ip= new IzmeniProfesora(new JFrame());
		}
		if(JTabbedPaneTabele.selektovan_tab == 0) {
			 @SuppressWarnings("unused")
			IzmeniStudenta is = new IzmeniStudenta(new JFrame());
		}
	}

}
