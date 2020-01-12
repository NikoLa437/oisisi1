package rs.ac.uns.ftn.projekat.view.dialogs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.controllers.StudentController;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class ObrisiStudenta extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObrisiStudenta() {
			 	
				this.setSize(MainFrame.sirina*3/7,MainFrame.visina/4);
			
				String[] options = {"Da", "Ne"};
			    int confirmed = JOptionPane.showOptionDialog(null, 
			        "Da li ste sigurni da zelite da obrisete studenta iz baze?", "Brisanje studenta",
			        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);
	
			    if (confirmed == JOptionPane.YES_OPTION) {
			    	StudentController.getInstance().obrisiStudenta();
			    }
			    else{
			    	this.dispose();
			    }
	}
}
