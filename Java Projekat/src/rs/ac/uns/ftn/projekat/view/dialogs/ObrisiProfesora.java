package rs.ac.uns.ftn.projekat.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.ac.uns.ftn.projekat.controllers.ProfesorController;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.view.MainFrame;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;

public class ObrisiProfesora extends JDialog{

	private static final long serialVersionUID = -7901245393508096872L;

	public ObrisiProfesora(JFrame parent) {
		super(parent,"Brisanje profesora",true);
		
		this.setSize(MainFrame.sirina*3/7,MainFrame.visina/4);
		this.setLayout(new BorderLayout());
		
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblTxt = new JLabel("Da li ste sigurni da zelite da izbrisete izabranog profesora?");
		lblTxt.setBorder(new EmptyBorder(0,10,0,0));
		
		add(lblTxt,BorderLayout.CENTER);
		
		JButton bPotvrda = new JButton("Potvrda");
		JButton bOdustanak = new JButton("Odustanak");
		
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
			
				if(ProfesorJTable.selectedRow != -1)
					ProfesorController.getInstance().obrisiProfesora(BazaProfesor.getInstance().getRow(ProfesorJTable.selectedRow));
				dispose();
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
