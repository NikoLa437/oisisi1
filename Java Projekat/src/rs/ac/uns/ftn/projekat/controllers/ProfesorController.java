package rs.ac.uns.ftn.projekat.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.dialogs.DodajProfesora;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniProfesora;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class ProfesorController {
	
	private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public int dodajProfesora() {
		int ret=0;
		
		Profesor p= new Profesor();
		
		
		if(!DodajProfesora.txtIme.getText().isEmpty()) {
			p.setIme(DodajProfesora.txtIme.getText());
			if(!DodajProfesora.txtPrezime.getText().isEmpty()) {
				p.setPrezime(DodajProfesora.txtPrezime.getText());
					if(!DodajProfesora.txtAdresaStan.getText().isEmpty()) {
						p.setAdresa_stanovanja(DodajProfesora.txtAdresaStan.getText());
						if(!DodajProfesora.txtKtkTel.getText().isEmpty()) {
							p.setBr_telefona(DodajProfesora.txtKtkTel.getText());
								if(!DodajProfesora.txtBrojLicne.getText().isEmpty() ) {//&&!BazaStudent.getInstance().postoji(txtBrojInd.getText())) {
									p.setBr_licne(DodajProfesora.txtBrojLicne.getText());
										if(!DodajProfesora.txtEAdresa.getText().isEmpty()) {
											p.setMail(DodajProfesora.txtEAdresa.getText());
											if(!DodajProfesora.txtTitula.getText().isEmpty()) {
												//p.setTitula(DodajProfesora.txtTitula.getText());
												if(!DodajProfesora.txtZvanje.getText().isEmpty()) {
													//p.setTitula(DodajProfesora.txtZvanje.getText());
													try {
															SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
															Date date = formatter.parse(DodajProfesora.txtDatumRodj.getText());
															p.setDatum_rodjenja(date);
															BazaProfesor.getInstance().dodajProfesora(p.getIme(), p.getPrezime(), p.getAdresa_stanovanja(), p.getBr_telefona(), p.getMail(), p.getAdresa_kancelarije(), p.getBr_licne(), p.getTitula(), p.getZvanje(), p.getDatum_rodjenja());
															
															ret=1;
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
		
		
		return ret;	
	}
	public void obrisiProfesora(Profesor p) {
		
		if(BazaProfesor.indikator ==1)
			BazaProfesor.getInstance().izbrisiProfesoraIzPretrage(p.getBr_licne());
		
		BazaProfesor.getInstance().izbrisiProfesora(p.getBr_licne());
		ArrayList<Predmet> predmeti = (ArrayList<Predmet>) BazaPredmet.getInstance().getPredmeti();
		for(Predmet pr: predmeti) {
			if(pr.getProfesor().getBr_licne() != null)
				if(pr.getProfesor().getBr_licne().equals(p.getBr_licne()))
					BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(), new Profesor(), pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
		}
		PredmetJTable.osvezi();
		ProfesorJTable.osvezi();
	}
	
	public int izmeniProfesora() {
		int ret=0;
		
		Profesor p= new Profesor();

		
		if(IzmeniProfesora.txtZvanje.getText().isEmpty() ||IzmeniProfesora.txteadresa.getText().isEmpty() || IzmeniProfesora.txtBrLicne.getText().isEmpty() || IzmeniProfesora.txtTitula.getText().isEmpty() || IzmeniProfesora.txtIme.getText().isEmpty() || IzmeniProfesora.txtPrezime.getText().isEmpty() || IzmeniProfesora.txtAdresa.getText().isEmpty() || IzmeniProfesora.txtBrojTel.getText().isEmpty() || IzmeniProfesora.txtAdresaKanc.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
		else {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
				Date date = formatter.parse(IzmeniProfesora.txtDatumRodj.getText());
				
				p.setBr_licne(IzmeniProfesora.txtBrLicne.getText());
				p.setDatum_rodjenja(date);
				p.setIme(IzmeniProfesora.txtIme.getText());
				p.setPrezime(IzmeniProfesora.txtPrezime.getText());
				p.setAdresa_stanovanja(IzmeniProfesora.txtAdresa.getText());
				p.setBr_telefona(IzmeniProfesora.txtBrojTel.getText());
				p.setTitula(IzmeniProfesora.txtTitula.getText());
				p.setAdresa_kancelarije(IzmeniProfesora.txtAdresaKanc.getText());
				p.setZvanje(IzmeniProfesora.txtZvanje.getText());
				p.setMail(IzmeniProfesora.txteadresa.getText());
				BazaProfesor.getInstance().izmeniProfesora(p.getIme(), p.getPrezime(), p.getAdresa_stanovanja(), p.getBr_telefona(), p.getMail(), p.getAdresa_kancelarije(), p.getBr_licne(), p.getTitula(), p.getZvanje(), p.getDatum_rodjenja());
				ret=1;
				ProfesorJTable.osvezi();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Datum mora biti u formatu: dd.MM.yyyy.", "Error", JOptionPane.ERROR_MESSAGE );
				}
		}
		
		return ret;	
	}
	
	public void pretraziProfesora(String kriterijum) {
		ArrayList<Profesor> pretraga = new ArrayList<Profesor>();

		if(!kriterijum.equals("")) {
			try{
				String[] podeljeno = kriterijum.split(";");
				String[] kolone = new String[4];
				String[] kriter = new String[4];
				int brojac = 0;
				for(String s: podeljeno)
				{
					String[] pom = s.split(":");
					kolone[brojac] = pom[0];
					kriter[brojac] = pom[1];
					brojac++;
				}
				boolean err = false;
				for(int k = 0; k < kolone.length; k++) {
				 if(kolone[k] != null) 
					if(!kolone[k].equals("ime") && !kolone[k].equals("prezime") && !kolone[k].equals("brojlicnekarte") && !kolone[k].equals("zvanje")) {
						JOptionPane.showMessageDialog(null,
								"Pogresan unos podataka!\nPretraga se vrsi u formatu '[ime:'ime';][prezime:'prezime';][brojlicnekarte:'broj';][zvanje:'zvanje']'",
								"Error", JOptionPane.ERROR_MESSAGE );
						err = true;
						break;
					}
				}
				if(!err) {
					
					for(Profesor p: BazaProfesor.getInstance().getProfesori())
					{
						boolean za_prikazati = false;
						for(int i = 0; i < brojac; i++)
						{
							if(kolone[i].equals("ime")) {
								if(kriter[i].equals(p.getIme())) {
									za_prikazati = true;
								}else {
									za_prikazati = false;
									break;
								}
							}
							if(kolone[i].equals("prezime")) {
								if(kriter[i].equals(p.getPrezime())) {
									za_prikazati = true;
								}else {
									za_prikazati = false;
									break;
								}
							}
							if(kolone[i].equals("brojlicnekarte")) {
								if(kriter[i].equals(p.getBr_licne())) {
									za_prikazati = true;
								}else {
									za_prikazati = false;
									break;
								}
							}
							if(kolone[i].equals("zvanje")) {
								if(kriter[i].equals(p.getZvanje())) {
									za_prikazati = true;
								}else {
									za_prikazati = false;
									break;
								}
							}
						}
						if(za_prikazati== true) {
							pretraga.add(p);
						}
							
					}
					BazaProfesor.indikator = 1;
					BazaProfesor.getInstance().setFilterProfesori(pretraga);
					ProfesorJTable.osvezi();
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		else
		{
			BazaProfesor.indikator = 0;
			ProfesorJTable.osvezi();
		}	
	}
	
}
