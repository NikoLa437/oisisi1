package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class DodajProfesoraNaPredmet extends JDialog{


	private static final long serialVersionUID = -4852567883901855950L;
	
	public DodajProfesoraNaPredmet(JFrame parent) {
		super(parent,"Dodavanje profesora na predmet",true);
		
		Predmet pr = BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow);

		this.setSize(400,120);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JLabel lblLicna = new JLabel("Broj licne karte profesora*");
		JTextField txtLicna = new JTextField();
		
		
		GridBagConstraints gbcL= new GridBagConstraints();
		gbcL.gridx = 0;
		gbcL.gridy = 0;
		gbcL.gridwidth = 1;
		gbcL.anchor = GridBagConstraints.WEST;
		gbcL.insets = new Insets(10, 20, 0, 0);
		panelC.add(lblLicna, gbcL);
		
		GridBagConstraints gbcT= new GridBagConstraints();
		gbcT.gridx = 1;
		gbcT.gridy = 0;
		gbcT.gridwidth = 3;
		gbcT.weightx = 100;
		gbcT.fill = GridBagConstraints.HORIZONTAL;
		gbcT.insets = new Insets(10, 20, 0, 20);
		panelC.add(txtLicna, gbcT);
		
		
		Button bPotvrda = new Button("Potvrda");
		Button bOdustanak = new Button("Odustanak");
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Profesor> profesori = BazaProfesor.getInstance().getProfesori();
				Profesor prof = new Profesor();
				boolean nasao = false;
				for(Profesor p1: profesori) {
					if(txtLicna.getText().equals(p1.getBr_licne())) {
						prof = p1;
						nasao = true;
						break;
					}
				}
				if(txtLicna.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Podaci se moraju uneti!", "Error", JOptionPane.ERROR_MESSAGE );
				else if(nasao == false)
					JOptionPane.showMessageDialog(null, "Unet pogresan broj licne karte!", "Error", JOptionPane.ERROR_MESSAGE );
				
				else {				
						BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(),prof, pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
						prof.addPredmet(pr);
					
				}
				dispose();
				PredmetJTable.osvezi();
			}
		});
		
		panelS.add(bOdustanak);
		panelS.add(bPotvrda);
		//test
		add(panelC,BorderLayout.NORTH);
		add(panelS,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

}
