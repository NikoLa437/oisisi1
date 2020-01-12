package rs.ac.uns.ftn.projekat.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Profesor.Titula;
import rs.ac.uns.ftn.projekat.classes.Profesor.Zvanje;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class DetaljiProfesor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2270914367761460928L;
	
	private JTextField txtIme;
	private JTextField txtPrezime ;
	private JTextField txtDatumRodj ;
	private JTextField txtAdresa;
	private JTextField txtBrojTel ;
	private JTextField txteadresa ;
	private JTextField txtAdresaKanc ;
	private JTextField txtBrLicne ;
	private JTextField txtTitula ;
	private JTextField txtZvanje ;

	public DetaljiProfesor(JFrame parent, int selected) {
		super(parent,"Detalji profesora",true);
		
			this.setSize(MainFrame.sirina*3/7,MainFrame.visina*6/8);
			this.setLayout(new BorderLayout());
			
			JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
			JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
			
			Profesor p= new Profesor();
			p= BazaProfesor.getInstance().getRow(selected);
			
			JLabel lblIme = new JLabel("Ime*");
			JLabel lblPrezime = new JLabel("Prezime*");
			JLabel lblDatumRodj= new JLabel("Datum Rodjenja*");
			JLabel lblAdresa = new JLabel("Adresa stanovanja*");
			JLabel lblBrojTel = new JLabel("Broj telefona*");
			JLabel lbleadresa = new JLabel("Email adresa*");
			JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
			JLabel lblBrLicne = new JLabel("Broj licne*");
			JLabel lblTitula = new JLabel("Titula*");
			JLabel lblZvanje = new JLabel("Zvanje*");
			
			 txtIme = new JTextField();
			 txtPrezime = new JTextField();
			 txtDatumRodj = new JTextField();
			 txtAdresa = new JTextField();
			 txtBrojTel = new JTextField();
			 txteadresa = new JTextField();
			 txtAdresaKanc = new JTextField();
			 txtBrLicne = new JTextField();
			 txtTitula = new JTextField();
			 txtZvanje = new JTextField();
			
			txtIme.setText(p.getIme());
			txtPrezime.setText(p.getPrezime());
			//datum rodjenja
			Date date=p.getDatum_rodjenja();
			DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
			txtDatumRodj.setText(dateFormat.format(date));
			//
			txtAdresa.setText(p.getAdresa_stanovanja());
			txtBrojTel.setText(p.getBr_telefona());
			txteadresa.setText(p.getMail());
			txtAdresaKanc.setText(p.getAdresa_kancelarije());
			txtBrLicne.setText(p.getBr_licne());
			if(p.getTitula() == Titula.doktor)
				txtTitula.setText("Doktor");
			else if(p.getTitula() == Titula.magistar)
				txtTitula.setText("Magistar");
			else if(p.getTitula() == Titula.prof_dr)
				txtTitula.setText("Prof.Dr");
			else
				txtTitula.setText("Master");

			if(p.getZvanje() == Zvanje.asistent)
				txtZvanje.setText("Asistent");
			else if(p.getZvanje() == Zvanje.docent)
				txtZvanje.setText("Docent");
			else if(p.getZvanje() == Zvanje.red_profesor)
				txtZvanje.setText("Redovni profesor");
			else if(p.getZvanje() == Zvanje.van_profesor)
				txtZvanje.setText("Vandredni profesor");
			else
				txtZvanje.setText("Saradnik u nastavi");

			
			txtIme.setEditable(false);
			txtPrezime.setEditable(false);
			txtDatumRodj.setEditable(false);
			txtBrLicne.setEditable(false);
			txtBrojTel.setEditable(false);
			txtAdresaKanc.setEditable(false);
			txtZvanje.setEditable(false);
			txtTitula.setEditable(false);
			txteadresa.setEditable(false);
			txtAdresa.setEditable(false);
			txtBrLicne.setEditable(false);
			
			panelC.add(lblIme, gbclbl(0,0));
			panelC.add(txtIme, gbctxt(1,0));
			panelC.add(lblPrezime,gbclbl(0,1));
			panelC.add(txtPrezime,gbctxt(1,1));
			panelC.add(lblDatumRodj,gbclbl(0,2));
			panelC.add(txtDatumRodj,gbctxt(1,2));
			panelC.add(lblAdresa,gbclbl(0,3));
			panelC.add(txtAdresa,gbctxt(1,3));
			panelC.add(lblBrojTel,gbclbl(0,4));
			panelC.add(txtBrojTel,gbctxt(1,4));
			panelC.add(lblAdresaKanc,gbclbl(0,5));
			panelC.add(txtAdresaKanc,gbctxt(1,5));
			panelC.add(lbleadresa,gbclbl(0,6));
			panelC.add(txteadresa,gbctxt(1,6));
			panelC.add(lblBrLicne,gbclbl(0,7));
			panelC.add(txtBrLicne,gbctxt(1,7));
			panelC.add(lblTitula,gbclbl(0,8));
			panelC.add(txtTitula,gbctxt(1,8));
			panelC.add(lblZvanje,gbclbl(0,9));
			panelC.add(txtZvanje,gbctxt(1,9));

			JButton bIzlazak = new JButton("Izlaz");
			
			bIzlazak.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					dispose();
				}
			});
			
			
			panelS.add(bIzlazak);
			
			add(panelC,BorderLayout.NORTH);
			add(panelS,BorderLayout.SOUTH);
			
			//this.setResizable(false);
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
