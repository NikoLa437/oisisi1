package rs.ac.uns.ftn.projekat.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Student implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 7298611130586699009L;

		public enum Status{ B, S }
		private String ime,prezime;
		private String adresa_stanovanja, kontakt_telefon;
		private String email_adresa,indeks;
		private Date datum_rodjenja,datum_upisa;
		private int god_studija;
		private double prosecna_ocena;
		private Status status;
		ArrayList<Predmet> predmeti;
		
		public Student() {}
	
		
		public Student(String i,String p,String a_s,String k_t,
				String e_a,String ind,Date dr,Date du,int g_s,
				double p_o,Status ss) {
			this.ime= i;
			this.prezime=p;
			this.adresa_stanovanja=a_s;
			this.kontakt_telefon= k_t;
			this.email_adresa= e_a;
			this.indeks=ind;
			this.datum_rodjenja=dr;
			this.datum_upisa=du;
			this.god_studija= g_s;
			this.prosecna_ocena=p_o;
			this.status=ss;
			this.predmeti=new ArrayList<Predmet>();
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

		public String getKontakt_telefon() {
			return kontakt_telefon;
		}

		public void setKontakt_telefon(String kontakt_telefon) {
			this.kontakt_telefon = kontakt_telefon;
		}

		public String getEmail_adresa() {
			return email_adresa;
		}

		public void setEmail_adresa(String email_adresa) {
			this.email_adresa = email_adresa;
		}

		public String getIndeks() {
			return indeks;
		}

		public void setIndeks(String indeks) {
			this.indeks = indeks;
		}

		public Date getDatum_rodjenja() {
			return datum_rodjenja;
		}

		public void setDatum_rodjenja(Date datum_rodjenja) {
			this.datum_rodjenja = datum_rodjenja;
		}

		public Date getDatum_upisa() {
			return datum_upisa;
		}

		public void setDatum_upisa(Date datum_upisa) {
			this.datum_upisa = datum_upisa;
		}

		public int getGod_studija() {
			return god_studija;
		}

		public void setGod_studija(int god_studija) {
			this.god_studija = god_studija;
		}

		public double getProsecna_ocena() {
			return prosecna_ocena;
		}

		public void setProsecna_ocena(double prosecna_ocena) {
			this.prosecna_ocena = prosecna_ocena;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public ArrayList<Predmet> getPredmeti() {
			return predmeti;
		}

		public void setPredmeti(ArrayList<Predmet> predmeti) {
			this.predmeti = predmeti;
		}
		
		
			
}
