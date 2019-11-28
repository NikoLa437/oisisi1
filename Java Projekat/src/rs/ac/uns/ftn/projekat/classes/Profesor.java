package rs.ac.uns.ftn.projekat.classes;

import java.util.ArrayList;
import java.util.Date;

public class Profesor {

	private String ime, prezime, adresa_stanovanja, br_telefona, mail, adresa_kancelarije, br_licne, titula, zvanje;
	private Date datum_rodjenja;
	private ArrayList<Predmet> predmeti;
	
	public Profesor() {
		
		predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, String adresa_stanovanja, String br_telefona, String mail,
			String adresa_kancelarije, String br_licne, String titula, String zvanje, Date datum_rodjenja) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.adresa_stanovanja = adresa_stanovanja;
		this.br_telefona = br_telefona;
		this.mail = mail;
		this.adresa_kancelarije = adresa_kancelarije;
		this.br_licne = br_licne;
		this.titula = titula;
		this.zvanje = zvanje;
		this.datum_rodjenja = datum_rodjenja;
		predmeti = new ArrayList<Predmet>();

	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getAdresa_stanovanja() {
		return adresa_stanovanja;
	}
	public void setAdresa_stanovanja(String adresa_stanovanja) {
		this.adresa_stanovanja = adresa_stanovanja;
	}
	public String getBr_telefona() {
		return br_telefona;
	}
	public void setBr_telefona(String br_telefona) {
		this.br_telefona = br_telefona;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAdresa_kancelarije() {
		return adresa_kancelarije;
	}
	public void setAdresa_kancelarije(String adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
	}
	public String getBr_licne() {
		return br_licne;
	}
	public void setBr_licne(String br_licne) {
		this.br_licne = br_licne;
	}
	public String getTitula() {
		return titula;
	}
	public void setTitula(String titula) {
		this.titula = titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}
	public Date getDatum_rodjenja() {
		return datum_rodjenja;
	}
	public void setDatum_rodjenja(Date datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}
	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}
	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
	
	
}
