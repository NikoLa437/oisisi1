package rs.ac.uns.ftn.projekat.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.classes.Profesor.Titula;
import rs.ac.uns.ftn.projekat.classes.Profesor.Zvanje;
import rs.ac.uns.ftn.projekat.classes.Student.Status;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.dialogs.DodajProfesora;
import rs.ac.uns.ftn.projekat.dialogs.DodajStudenta;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniProfesora;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;
import rs.ac.uns.ftn.projekat.view.StudentJTable;
import rs.ac.uns.ftn.projekat.view.ToolBar;

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
		Profesor p= new Profesor();
		int ret=0;
		if(this.proveriUnos()) {
			p.setIme(DodajProfesora.txtIme.getText());
			p.setPrezime(DodajProfesora.txtPrezime.getText());
			p.setAdresa_kancelarije(DodajProfesora.txtAdresaKanc.getText());
			p.setAdresa_stanovanja(DodajProfesora.txtAdresaStan.getText());
			p.setBr_licne(DodajProfesora.txtBrojLicne.getText());
			p.setBr_telefona(DodajProfesora.txtKtkTel.getText());
			p.setMail(DodajProfesora.txtEAdresa.getText());

			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
				Date date= formatter.parse(DodajProfesora.txtDatumRodj.getText());
				p.setDatum_rodjenja(date);
			}catch(Exception e ) {
				System.out.println("Test");
			}
			
			p.setZvanje((Profesor.Zvanje) DodajProfesora.cbZvanje.getSelectedItem());
			p.setTitula((Profesor.Titula) DodajProfesora.cbTitula.getSelectedItem());
			
			BazaProfesor.getInstance().dodajProfesora(p.getIme(), p.getPrezime(), p.getAdresa_stanovanja(), p.getBr_telefona(), p.getMail(), p.getAdresa_kancelarije(), p.getBr_licne(), p.getTitula(), p.getZvanje(), p.getDatum_rodjenja());
			ret=1;
			ProfesorJTable.osvezi();	
		}else {
			JOptionPane.showMessageDialog(null, "Pogresan unos!", "Error", JOptionPane.ERROR_MESSAGE );
		}
		return ret;	
	}
	public void obrisiProfesora(Profesor p) {
				
		BazaProfesor.getInstance().izbrisiProfesora(p.getBr_licne());
		if(BazaProfesor.indikator ==1)
			this.pretraziProfesora(ToolBar.textField.getText());
		
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

		
		if(IzmeniProfesora.txteadresa.getText().isEmpty() || IzmeniProfesora.txtBrLicne.getText().isEmpty() || IzmeniProfesora.txtIme.getText().isEmpty() || IzmeniProfesora.txtPrezime.getText().isEmpty() || IzmeniProfesora.txtAdresa.getText().isEmpty() || IzmeniProfesora.txtBrojTel.getText().isEmpty() || IzmeniProfesora.txtAdresaKanc.getText().isEmpty())
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
				p.setAdresa_kancelarije(IzmeniProfesora.txtAdresaKanc.getText());
				
				Profesor.Titula t = null;
				if(IzmeniProfesora.cbTitula.getSelectedItem().toString().equals("doktor")) {
					t=Titula.doktor;
				}else if(IzmeniProfesora.cbTitula.getSelectedItem().toString().equals("magistar")) {
					t=Titula.magistar;
				}else {
					t=Titula.master;
				}
				p.setTitula(t);
				
				Profesor.Zvanje z= null;
				if(IzmeniProfesora.cbZvanje.getSelectedItem().toString().equals("profesor")) {
					z= Zvanje.profesor;
				}else if(IzmeniProfesora.cbZvanje.getSelectedItem().toString().equals("asistent")) {
					z= Zvanje.asistent;
				}else if(IzmeniProfesora.cbZvanje.getSelectedItem().toString().equals("saradnik")) {
					z= Zvanje.saradnik;
				}else{
					z= Zvanje.docent;
				}
				
			    p.setZvanje(z);
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
								if(kriter[i].equals(p.getZvanje().toString())) {
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
	private boolean proveriUnos() {
		boolean ret;
		ret = false;
		
		if(DodajProfesora.txtIme.getText().matches("[A-Z][A-Z a-z]+")&&DodajProfesora.txtPrezime.getText().matches("[A-Z][A-Z a-z]+")&&DodajProfesora.txtDatumRodj.getText().matches("([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)")
				&&DodajProfesora.txtAdresaStan.getText().matches("[A-Za-z][A-Z a-z]+[ 0-9]*")&&DodajProfesora.txtAdresaKanc.getText().matches("[A-Za-z][A-Z a-z]+[ 0-9]*")&&DodajProfesora.txtBrojLicne.getText().matches("[A-Za-z0-9]{7,13}")&&DodajProfesora.txtKtkTel.getText().matches("([+]{1})?[0-9]{8,12}") && DodajProfesora.txtEAdresa.getText().matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
			    && (!BazaProfesor.getInstance().postoji(DodajProfesora.txtBrojLicne.getText()))){
			ret=true;
		}
		return ret;
	}
	
}
