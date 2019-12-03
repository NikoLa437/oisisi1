package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class UklanjanjeProfesoraNaPredmetu extends JDialog{


	private static final long serialVersionUID = -7697484585521881915L;
	
	public UklanjanjeProfesoraNaPredmetu(JFrame parent) {
		super(parent,"Profesor na predmetu",true);
		
		Predmet pr = BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow);
		
		this.setSize(400,200);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		
		JLabel lblIme = new JLabel("Ime Profesora");
		JLabel lblPrezime = new JLabel("Prezime Profesora");
		JLabel lblLicna= new JLabel("Br. Licne Karte");
		
		
		JTextField txtImeProf = new JTextField();
		JTextField txtPrezProf = new JTextField();
		JTextField txtBrLicne = new JTextField();
		
		txtImeProf.setText(pr.getProfesor().getIme());
		txtPrezProf.setText(pr.getProfesor().getPrezime());
		txtBrLicne.setText(pr.getProfesor().getBr_licne());
		
		txtImeProf.setEditable(false);
		txtPrezProf.setEditable(false);
		txtBrLicne.setEditable(false);
		
		panelC.add(lblIme, gbclbl(0,0));
		panelC.add(txtImeProf, gbctxt(1,0));
		panelC.add(lblPrezime,gbclbl(0,1));
		panelC.add(txtPrezProf,gbctxt(1,1));
		panelC.add(lblLicna,gbclbl(0,2));
		panelC.add(txtBrLicne,gbctxt(1,2));
		
		JButton bBrisanje = new JButton("Obrisi Profesora");
		JButton bOdustanak = new JButton("Odustanak");
		
		bBrisanje.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profesor p = pr.getProfesor();
				BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(), new Profesor(), pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
				p.removePredmet(pr);
				dispose();
				PredmetJTable.osvezi();
			}
		});
		
		bOdustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();				
			}
		});
		
		panelS.add(bOdustanak);
		panelS.add(bBrisanje);
		
		add(panelC,BorderLayout.NORTH);
		add(panelS,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);
	}

	private GridBagConstraints gbclbl(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 20, 0, 0);
		return gbc;
	}
	private GridBagConstraints gbctxt(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 3;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 0, 20);
		return gbc;
	}
}
