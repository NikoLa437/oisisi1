package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.controllers.StudentController;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class ObrisiStudenta extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObrisiStudenta() {
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
