package rs.ac.uns.ftn.projekat.classes;

import java.util.ArrayList;

public class Predmet {

	private String sifra_predmeta, naziv;
	private int semestar, godina_studija;
	private Profesor profesor;
	private ArrayList<Student> studenti;
	
	
	
	public Predmet(String sifra_predmeta, String naziv, int semestar, int godina_studija) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.profesor = new Profesor();
		this.studenti = new ArrayList<Student>();
	}
	public String getSifra_predmeta() {
		return sifra_predmeta;
	}
	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getSemestar() {
		return semestar;
	}
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	public int getGodina_studija() {
		return godina_studija;
	}
	public void setGodina_studija(int godina_studija) {
		this.godina_studija = godina_studija;
	}
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	
	
	
}
