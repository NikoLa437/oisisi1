package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;

public class ObrisiProfesora extends JDialog{

	private static final long serialVersionUID = -7901245393508096872L;

	public ObrisiProfesora(JFrame parent) {
		super(parent,"Brisanje profesora",true);
		
		this.setSize(400,150);
		this.setLayout(new BorderLayout());
		
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblTxt = new JLabel("Da li ste sigurni da zelite da izbrisete izabranog profesora?");
		lblTxt.setBorder(new EmptyBorder(0,10,0,0));
		
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
			
				Profesor p= BazaProfesor.getInstance().getRow(ProfesorJTable.selectedRow);
				BazaProfesor.getInstance().izbrisiProfesora(p.getBr_licne());
				ArrayList<Predmet> predmeti = (ArrayList<Predmet>) BazaPredmet.getInstance().getPredmeti();
				for(Predmet pr: predmeti) {
					if(pr.getProfesor().getBr_licne() != null)
						if(pr.getProfesor().getBr_licne().equals(p.getBr_licne()))
							BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(), new Profesor(), pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
				}
				dispose();
				PredmetJTable.osvezi();
				ProfesorJTable.osvezi();
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
