package rs.ac.uns.ftn.projekat.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.dialogs.ObrisiPredmet;
import rs.ac.uns.ftn.projekat.dialogs.ObrisiProfesora;
import rs.ac.uns.ftn.projekat.dialogs.ObrisiStudenta;
import rs.ac.uns.ftn.projekat.view.JTabbedPaneTabele;
import rs.ac.uns.ftn.projekat.view.MainFrame;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class CreateDeleteAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("deprecation")
	public CreateDeleteAction() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_D);
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D,KeyEvent.CTRL_MASK));
	}
	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(JTabbedPaneTabele.selektovan_tab == 2) {
			ObrisiPredmet op;
			if(PredmetJTable.selectedRow != -1)
				op = new ObrisiPredmet(MainFrame.getInstance());
			else
				JOptionPane.showMessageDialog(null, "Niste selektovali predmet za brisanje!", "Error", JOptionPane.ERROR_MESSAGE );

		}
		if(JTabbedPaneTabele.selektovan_tab == 1) {
			ObrisiProfesora op;
			if(ProfesorJTable.selectedRow != -1)
				op = new ObrisiProfesora(MainFrame.getInstance());
			else
				JOptionPane.showMessageDialog(null, "Niste selektovali profesora za brisanje!", "Error", JOptionPane.ERROR_MESSAGE );

		}
		if(JTabbedPaneTabele.selektovan_tab == 0) {
			if(StudentJTable.selectedRow!=-1) {
				ObrisiStudenta os= new ObrisiStudenta();
			}else {
				JOptionPane.showMessageDialog(null, "Niste selektovali studenta za brisanje!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
	}

}
