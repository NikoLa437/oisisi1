package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class ObrisiStudenta extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ObrisiStudenta(JFrame parent) {
		super(parent,"Brisanje studenata",true);
		
		this.setSize(400,200);
		this.setLayout(new BorderLayout());
		
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		
		JLabel lblTxt = new JLabel("Da li ste sigurni da zelite da izbrisete izabranog studenta?");
		
		add(lblTxt,BorderLayout.CENTER);
		
		Button bPotvrda = new Button("Potvrda");
		Button bOdustanak = new Button("Odustanak");
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				Student s= BazaStudent.getInstance().getRow(StudentJTable.selectedRow);
				BazaStudent.getInstance().izbrisiStudenta(s.getIndeks());
				
				dispose();
				StudentJTable.osvezi();
			}
		});
		
		panelS.add(bOdustanak);
		panelS.add(bPotvrda);
		//test
		add(panelS,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}
}
