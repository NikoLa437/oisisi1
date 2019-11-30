package rs.ac.uns.ftn.projekat.data;

import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;

public class BazaPredmet {

	private static BazaPredmet instance = null;

	public static BazaPredmet getInstance() {
		if (instance == null) {
			instance = new BazaPredmet();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	private BazaPredmet() {
	
		initPredmet();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Sifra");
		this.kolone.add("Naziv");
		this.kolone.add("Semestar");
		this.kolone.add("Godina studija");
		this.kolone.add("Profesor");
		this.kolone.add("Broj studenata");
		this.kolone.add("Studenti");
	}
	
	private void initPredmet() {
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("O12-ss", "OISISI",5,3));
		predmeti.add(new Predmet("sq654652", "SPPuRV",4,2));
		predmeti.add(new Predmet("as87", "Baze Podataka 1",3,2));
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 7;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra_predmeta();
		case 1:
			return predmet.getNaziv();
		case 2:
			return Integer.toString(predmet.getSemestar());
		case 3:
			return Integer.toString(predmet.getGodina_studija());
		case 4: {
			if (predmet.getProfesor().getIme() == null)
					return "";
			else 			
				return predmet.getProfesor().getIme() + " " + predmet.getProfesor().getPrezime();

		}
		case 5:
			return Integer.toString(0);
			
		default:
			return null;
		}
	}

	public void dodajPredmet(String sifra_predmeta, String naziv, int semestar, int godina_studija) {
		this.predmeti.add(new Predmet(sifra_predmeta, naziv, semestar, godina_studija));
	}

	public void izbrisiPredmet(String sifra_pr) {
		for (Predmet p : predmeti) {
			if (p.getSifra_predmeta().equals(sifra_pr)) {
				predmeti.remove(p);
				break;
			}
		}
	}

	public void izmeniPredmet(String sifra_predmeta, Profesor profesor,String naziv, int semestar, int godina_studija) {
		for (Predmet p : predmeti) {
			if (p.getSifra_predmeta().equals(sifra_predmeta)) {
				p.setNaziv(naziv);
				p.setProfesor(profesor);
				p.setSemestar(semestar);
				p.setGodina_studija(godina_studija);
			}
		}
	}

	public void dodajStudenta(String sifra_predmeta, Student s) {
		for (Predmet pr : predmeti) {
			if (pr.getSifra_predmeta().equals(sifra_predmeta)) {
				pr.getStudenti().add(s);
			}
		}
	}
	
}
