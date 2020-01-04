package rs.ac.uns.ftn.projekat.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.classes.Student.Status;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.dialogs.DodajProfesoraNaPredmet;
import rs.ac.uns.ftn.projekat.dialogs.DodajStudenta;
import rs.ac.uns.ftn.projekat.dialogs.DodajStudentaNaPredmet;
import rs.ac.uns.ftn.projekat.dialogs.IzmeniStudenta;
import rs.ac.uns.ftn.projekat.dialogs.ListaStudenataNaPredmetu;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class StudentController {

	private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	
	private StudentController() {}
	
	public int dodajStudenta() {
		Student s= new Student();
		int ret=0;
		if(this.proveriUnos()) {
			s.setIme(DodajStudenta.txtIme.getText());
			s.setPrezime(DodajStudenta.txtPrezime.getText());
			s.setKontakt_telefon(DodajStudenta.txtBrojTel.getText());
			s.setIndeks(DodajStudenta.txtBrojInd.getText());
			s.setEmail_adresa(DodajStudenta.txteadresa.getText());
			s.setAdresa_stanovanja(DodajStudenta.txtAdresa.getText());
			double p_o= Double.parseDouble(DodajStudenta.txtprosecnaOcena.getText());
			s.setProsecna_ocena(p_o);
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
				Date date = formatter.parse(DodajStudenta.txtdatumUpisa.getText());
				s.setDatum_upisa(date);
				date = formatter.parse(DodajStudenta.txtDatumRodj.getText());
				s.setDatum_rodjenja(date);
			}catch(Exception e ) {
				System.out.println("Test");
			}
			String g_s = DodajStudenta.cbGodStud.getSelectedItem().toString();
			if(g_s.equals("I (prva)")){
				s.setGod_studija(1);
			}else if(g_s.equals("II (druga)")){
				s.setGod_studija(2);
			}else if(g_s.equals("III (treca)")){
				s.setGod_studija(3);
			}else {
				s.setGod_studija(4);
			}

			if(DodajStudenta.rbSamof.isSelected()) {
				s.setStatus(Status.S);
			}else {
				s.setStatus(Status.B);
			}
			BazaStudent.getInstance().dodajStudenta(s.getIme(), s.getPrezime(), s.getAdresa_stanovanja(), s.getKontakt_telefon(),s.getEmail_adresa(), s.getIndeks(), s.getDatum_rodjenja(), s.getDatum_upisa(), s.getGod_studija(), s.getProsecna_ocena(),s.getStatus());
			ret=1;
			StudentJTable.osvezi();	
		}else {
			JOptionPane.showMessageDialog(null, "Pogresan unos!", "Error", JOptionPane.ERROR_MESSAGE );
		}
		return ret;	
	}
	
	public int izmeniStudenta() {
		Student s= new Student();
		int ret=0;
		if(this.proveriUnosIzmene()) {
			s.setIme(IzmeniStudenta.txtIme.getText());
			s.setPrezime(IzmeniStudenta.txtPrezime.getText());
			s.setKontakt_telefon(IzmeniStudenta.txtBrojTel.getText());
			s.setIndeks(IzmeniStudenta.txtBrojInd.getText());
			s.setEmail_adresa(IzmeniStudenta.txteadresa.getText());
			s.setAdresa_stanovanja(IzmeniStudenta.txtAdresa.getText());
			double p_o= Double.parseDouble(IzmeniStudenta.txtprosecnaOcena.getText());
			s.setProsecna_ocena(p_o);
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
				Date date = formatter.parse(IzmeniStudenta.txtdatumUpisa.getText());
				s.setDatum_upisa(date);
				date = formatter.parse(IzmeniStudenta.txtDatumRodj.getText());
				s.setDatum_rodjenja(date);
			}catch(Exception e ) {
				System.out.println("Test");
			}

			String g_s = IzmeniStudenta.cbGodStud.getSelectedItem().toString();
			if(g_s.equals("I (prva)")){
				s.setGod_studija(1);
			}else if(g_s.equals("II (druga)")){
				s.setGod_studija(2);
			}else if(g_s.equals("III (treca)")){
				s.setGod_studija(3);
			}else {
				s.setGod_studija(4);
			}

			if(IzmeniStudenta.rbSamof.isSelected()) {
				s.setStatus(Status.S);
			}else {
				s.setStatus(Status.B);
			}
			BazaStudent.getInstance().izmeniStudenta(s.getIndeks(),s.getIme(), s.getPrezime(), s.getAdresa_stanovanja(), s.getKontakt_telefon(),s.getEmail_adresa(),  s.getDatum_rodjenja(), s.getDatum_upisa(), s.getGod_studija(), s.getProsecna_ocena(),s.getStatus());
			ret=1;
			StudentJTable.osvezi();	
		}else {
			JOptionPane.showMessageDialog(null, "Pogresan unos!", "Error", JOptionPane.ERROR_MESSAGE );
		}
		return ret;
	}
	
	
	public void obrisiStudenta() {
		Student s= BazaStudent.getInstance().getRow(StudentJTable.selectedRow);
		BazaStudent.getInstance().izbrisiStudenta(s.getIndeks());
		StudentJTable.osvezi();
	}
	
	public int dodajStudentaNaPredmet(Predmet pr) {
		Student s= new Student();
		int ret=0;
		if(!DodajStudentaNaPredmet.txtIndeks.getText().isEmpty()) {
			String idx= DodajStudentaNaPredmet.txtIndeks.getText();
			// provera da li postoji student sa tim indeksom
			if((s= BazaStudent.getInstance().getStudentInd(idx)) != null) {
				if(s.getGod_studija()==pr.getGodina_studija()) {
					boolean postoji=false;
					for(Student st : pr.getStudenti()) {
						if(st.getIndeks().equals(s.getIndeks()))
							postoji=true;
					}
					if(!postoji) {
						BazaStudent.getInstance().dodajPredmet(s.getIndeks(), pr);
						BazaPredmet.getInstance().dodajStudenta(pr.getSifra_predmeta(), s);
						ret=1;
						PredmetJTable.osvezi();
					}
					else {
						JOptionPane.showMessageDialog(null, "Vec postoji student sa tim brojem indeksa", "Error", JOptionPane.ERROR_MESSAGE );
					}

				}else {
					JOptionPane.showMessageDialog(null, "Nije moguce dodati studenta na predmet koji su razlicitih godina", "Error", JOptionPane.ERROR_MESSAGE );
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "Ne postoji student sa tim brojem indeksa!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Podaci se moraju uneti!", "Error", JOptionPane.ERROR_MESSAGE );
		}
		return ret;
	}
	
	public void brisanjeStudentaSaPredmeta(Predmet pr) {
		Student s=BazaStudent.getInstance().getStudentInd(ListaStudenataNaPredmetu.selRow);
		BazaPredmet.getInstance().obrisiStudenta(pr.getSifra_predmeta(), s);
		
	}
	
	public void pretraziStudente(String kriterijum) {

		if(!kriterijum.equals("")) {
			try {
				
			ArrayList<Student> studenti= new ArrayList<Student>();
			// po ime prezime indeks status god studija
			String[] deo= kriterijum.split(";");
			String[] kolona= new String [5];
			String[] kolonakrit= new String[5];
			//int brojac = 0;
			
			for(int i=0; i<deo.length;i++) {
				String[] pom= deo[i].split(":");
				kolona[i]=pom[0];
				kolonakrit[i]=pom[1];
				//brojac++;
			}
			

			
			boolean error=false;
			
			for(int i=0;i<deo.length;i++) {
				if(!kolona[i].equals("status") && !kolona[i].equals("ime") && !kolona[i].equals("prezime") && !kolona[i].equals("brojindeksa") && !kolona[i].equals("godinastudija")) {
					JOptionPane.showMessageDialog(null,
							"Pogresan unos podataka!\nPretraga se vrsi u formatu '[ime:'ime';][prezime:'prezime';][brojindeksa:'broj';][status: 'status';][godinastudija:'godina']'",
							"Error", JOptionPane.ERROR_MESSAGE );
					error = true;
					break;
				}
			}
		
			if(!error) {
				
				for(Student s : BazaStudent.getInstance().getStudenti()) {
					boolean za_prikazati=false;
					
					for(int i=0;i<deo.length;i++) {
						
						
						if(kolona[i].equals("ime")) {
							if(kolonakrit[i].equals(s.getIme())) {
								za_prikazati = true;
							}else {
								za_prikazati = false;
								break;
							}
						}
						if(kolona[i].equals("prezime")) {
							if(kolonakrit[i].equals(s.getPrezime())) {
								za_prikazati = true;
							}else {
								za_prikazati = false;
								break;
							}
						}
						if(kolona[i].equals("brojindeksa")) {
							if(kolonakrit[i].equals(s.getIndeks())) {
								za_prikazati = true;
							}else {
								za_prikazati = false;
								break;
							}
						}
						if(kolona[i].equals("godinastudija")) {
							if(Integer.parseInt(kolonakrit[i]) == s.getGod_studija()) {
								za_prikazati = true;
							}else {
								za_prikazati = false;
								break;
							}
						}
						if(kolona[i].equals("status")) {
							if(kolonakrit[i] == s.getStatus().toString()) {
								za_prikazati = true;
							}else {
								za_prikazati = false;
								break;
							}
						}
					}
					if(za_prikazati== true) {
						studenti.add(s);
					}
				}
				
				BazaStudent.indikator=1;
				BazaStudent.getInstance().setPretrazeni(studenti);
				StudentJTable.osvezi();
			}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}else {
			BazaStudent.indikator=0;
			StudentJTable.osvezi();
		}
	}

	private boolean proveriUnos() {
		boolean ret;
		ret = false;
		
		if(DodajStudenta.txtIme.getText().matches("[A-Z][A-Z a-z]+")&&DodajStudenta.txtPrezime.getText().matches("[A-Z][A-Z a-z]+")&&DodajStudenta.txtdatumUpisa.getText().matches("([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)")&&DodajStudenta.txtDatumRodj.getText().matches("([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)")
				&&DodajStudenta.txtAdresa.getText().matches("[A-Za-z][A-Z a-z]+[ 0-9]*")&&!DodajStudenta.txtBrojInd.getText().isEmpty()&&DodajStudenta.txtBrojTel.getText().matches("([+]{1})?[0-9]{8,12}") && DodajStudenta.txteadresa.getText().matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
				&&DodajStudenta.txtprosecnaOcena.getText().matches("([5-9]{1}(\\.)[0-9]{1,2})|((10)(\\.)[0]{1,2})") && (!BazaStudent.getInstance().postoji(DodajStudenta.txtBrojInd.getText()))){
			ret=true;
		}
		return ret;
	}
	
	private boolean proveriUnosIzmene() {
		boolean ret;
		ret = false;
		
		if(IzmeniStudenta.txtIme.getText().matches("[A-Z][A-Z a-z]+")&&IzmeniStudenta.txtPrezime.getText().matches("[A-Z][A-Z a-z]+")&&IzmeniStudenta.txtdatumUpisa.getText().matches("([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)")&&IzmeniStudenta.txtDatumRodj.getText().matches("([0-2][0-9]|(3)[0-1])(\\.)(((0)[0-9])|((1)[0-2]))(\\.)\\d{4}(\\.)")
				&&IzmeniStudenta.txtAdresa.getText().matches("[A-Za-z][A-Z a-z]+[ 0-9]*")&&!IzmeniStudenta.txtBrojInd.getText().isEmpty()&&IzmeniStudenta.txtBrojTel.getText().matches("([+]{1})?[0-9]{8,12}") && IzmeniStudenta.txteadresa.getText().matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")
				&&IzmeniStudenta.txtprosecnaOcena.getText().matches("([5-9]{1}(\\.)[0-9]{1,2})|((10)(\\.)[0]{1,2})")){
			ret=true;
		}
		return ret;
	}
	
}


	

