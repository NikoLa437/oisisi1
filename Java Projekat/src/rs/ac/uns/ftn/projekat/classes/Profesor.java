package rs.ac.uns.ftn.projekat.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Profesor implements Serializable{

	
	private static final long serialVersionUID = 2558848616368820819L;
	public enum Titula{doktor,magistar,master}
	public enum Zvanje{profesor,asistent,saradnik,docent}
	private String ime, prezime, adresa_stanovanja, br_telefona, mail, adresa_kancelarije, br_licne;
	private Date datum_rodjenja;
	private Titula titula;
	private Zvanje zvanje;
	private ArrayList<Predmet> predmeti;
	
	public Profesor() {
		
		predmeti = new ArrayList<Predmet>();
	}
	
	public Profesor(String ime, String prezime, String adresa_stanovanja, String br_telefona, String mail,
			String adresa_kancelarije, String br_licne, Titula titula, Zvanje zvanje, Date datum_rodjenja) {
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
	
	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	
	public Zvanje getZvanje() {
		return this.zvanje;
	}
	
	public Titula getTitula() {
		return this.titula;
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
	public void addPredmet(Predmet predmet) {
		this.predmeti.add(predmet);
	}
	public void removePredmet(Predmet predmet) {
		for(Predmet p: predmeti) {
			if(p.getSifra_predmeta().equals(predmet.getSifra_predmeta())) {
				predmeti.remove(p);
				break;
			}
		}
	}
	
	
}
