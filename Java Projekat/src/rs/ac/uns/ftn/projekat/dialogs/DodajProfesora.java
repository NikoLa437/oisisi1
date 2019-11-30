package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.classes.Student.Status;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class DodajProfesora extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DodajProfesora(JFrame parent) {
		super(parent,"Dodavanje novog profesora",true);
		
		
		this.setSize(400,400);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		//labele za profesora
		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodj= new JLabel("Datum rodjenja*");
		JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
		JLabel lblKtkTel = new JLabel("Kontakt telefon*");
		JLabel lblEAdresa = new JLabel("Email adresa*");
		JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
		JLabel lblBrojLicne = new JLabel("Broj licne karte*");
		JLabel lblTitula = new JLabel("Titula*");
		JLabel lblZvanje = new JLabel("Zvanje*");
		
		//text field za profesora
		JTextField txtIme = new JTextField();
		JTextField txtPrezime = new JTextField();
		JTextField txtDatumRodj = new JTextField();
		JTextField txtAdresaStan = new JTextField();
		JTextField txtKtkTel = new JTextField();
		JTextField txtEAdresa = new JTextField();
		JTextField txtAdresaKanc = new JTextField();
		JTextField txtBrojLicne = new JTextField();
		JTextField txtTitula = new JTextField();
		JTextField txtZvanje = new JTextField();
	
		panelC.add(lblIme, gbclbl(0,0));
		panelC.add(txtIme, gbctxt(1,0));
		panelC.add(lblPrezime,gbclbl(0,1));
		panelC.add(txtPrezime,gbctxt(1,1));
		panelC.add(lblDatumRodj,gbclbl(0,2));
		panelC.add(txtDatumRodj,gbctxt(1,2));
		panelC.add(lblAdresaStan,gbclbl(0,3));
		panelC.add(txtAdresaStan,gbctxt(1,3));
		panelC.add(lblKtkTel,gbclbl(0,4));
		panelC.add(txtKtkTel,gbctxt(1,4));
		panelC.add(lblEAdresa,gbclbl(0,5));
		panelC.add(txtEAdresa,gbctxt(1,5));
		panelC.add(lblAdresaKanc,gbclbl(0,6));
		panelC.add(txtAdresaKanc,gbctxt(1,6));
		panelC.add(lblBrojLicne,gbclbl(0,7));
		panelC.add(txtBrojLicne,gbctxt(1,7));
		panelC.add(lblTitula,gbclbl(0,8));
		panelC.add(txtTitula,gbctxt(1,8));
		panelC.add(lblZvanje,gbclbl(0,9));
		panelC.add(txtZvanje,gbctxt(1,9));
		
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
				Profesor p= new Profesor();
				
				
				if(!txtIme.getText().isEmpty()) {
					p.setIme(txtIme.getText());
					if(!txtPrezime.getText().isEmpty()) {
						p.setPrezime(txtPrezime.getText());
							if(!txtAdresaStan.getText().isEmpty()) {
								p.setAdresa_stanovanja(txtAdresaStan.getText());
								if(!txtKtkTel.getText().isEmpty()) {
									p.setBr_telefona(txtKtkTel.getText());
										if(!txtBrojLicne.getText().isEmpty() ) {//&&!BazaStudent.getInstance().postoji(txtBrojInd.getText())) {
											p.setBr_licne(txtBrojLicne.getText());
												if(!txtEAdresa.getText().isEmpty()) {
													p.setMail(txtEAdresa.getText());
													if(!txtTitula.getText().isEmpty()) {
														p.setTitula(txtTitula.getText());
														if(!txtZvanje.getText().isEmpty()) {
															p.setTitula(txtZvanje.getText());
															try {
																	SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
																	Date date = formatter.parse(txtDatumRodj.getText());
																	p.setDatum_rodjenja(date);
																	BazaProfesor.getInstance().dodajProfesora(p.getIme(), p.getPrezime(), p.getAdresa_stanovanja(), p.getBr_telefona(), p.getMail(), p.getAdresa_kancelarije(), p.getBr_licne(), p.getTitula(), p.getZvanje(), p.getDatum_rodjenja());
																	
																	dispose();
																	StudentJTable.osvezi();	
																
															}catch(Exception e1) {
																JOptionPane.showMessageDialog(null, "Pogresan unos datuma!", "Error", JOptionPane.ERROR_MESSAGE );
															}
														}else {
															JOptionPane.showMessageDialog(null, "Pogresan unos zvanja!", "Error", JOptionPane.ERROR_MESSAGE );
														}
													}else {
														JOptionPane.showMessageDialog(null, "Pogresan unos titule!", "Error", JOptionPane.ERROR_MESSAGE );
													}
												}else {
													JOptionPane.showMessageDialog(null, "Pogresan unos e-mail adrese!", "Error", JOptionPane.ERROR_MESSAGE );
												}
											}else {
												JOptionPane.showMessageDialog(null, "Pogresan unos broja licne karte (broj licne karte mora biti jedinstven)!", "Error", JOptionPane.ERROR_MESSAGE );
											}
										}else {
											JOptionPane.showMessageDialog(null, "Pogresan unos broja telefona!", "Error", JOptionPane.ERROR_MESSAGE );
										}
								}else {
									JOptionPane.showMessageDialog(null, "Pogresan unos adrese stanovanja!", "Error", JOptionPane.ERROR_MESSAGE );
								}
							}else {
								JOptionPane.showMessageDialog(null, "Pogresan unos prezimena!", "Error", JOptionPane.ERROR_MESSAGE );
							}
					}else {
						JOptionPane.showMessageDialog(null, "Pogresan unos imena!", "Error", JOptionPane.ERROR_MESSAGE );
					}
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
