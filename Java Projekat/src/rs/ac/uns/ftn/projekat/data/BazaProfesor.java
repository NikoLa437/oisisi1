package rs.ac.uns.ftn.projekat.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Profesor.Titula;
import rs.ac.uns.ftn.projekat.classes.Profesor.Zvanje;

public class BazaProfesor {

	private static BazaProfesor instance = null;
	
	public static BazaProfesor getInstance() {
		if (instance == null) {
			instance = new BazaProfesor();
		}
		return instance;
	}
	
	private List<Profesor> profesori;
	private List<Profesor> filter_profesor;
	private List<String> kolone;
	public static int indikator = 0;

	
	private BazaProfesor() {
	
		initPredmet();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Broj telefona");
		this.kolone.add("Mail");
		this.kolone.add("Datum rodjenja");
		this.kolone.add("Broj licne karte");
		this.kolone.add("Detalji");
		this.kolone.add("Predmeti");

	}
	private void initPredmet() {
		this.profesori = new ArrayList<Profesor>();
		this.filter_profesor = new ArrayList<Profesor>();
	}
	
	public List<Profesor> getProfesori() {
		return profesori;
	}
	

	public List<Profesor> getFilterProfesori() {
		return this.filter_profesor;
	}
	
	public void setFilterProfesori(List<Profesor> filter_profesor) {
		this.filter_profesor = filter_profesor;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getColumnCount() {
		return 8;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}

	public Object getValueAt(int row, int column) {
		Profesor profesor = new Profesor();
		if(indikator == 0)
			profesor = this.profesori.get(row);
		else
			profesor = this.filter_profesor.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getBr_telefona();
		case 3:
			return profesor.getMail();
		case 4:
			return profesor.getDatum_rodjenja();
		case 5:
			return profesor.getBr_licne();		
		default:
			return null;
		}
	}

	public void dodajProfesora(String ime, String prezime, String adresa_stanovanja, String br_telefona, String mail,
			String adresa_kancelarije, String br_licne, Titula titula, Zvanje zvanje, Date datum_rodjenja) {
		this.profesori.add(new Profesor(ime, prezime, adresa_stanovanja, br_telefona,mail,adresa_kancelarije,br_licne,titula,zvanje,datum_rodjenja));
	}
	
	public void izbrisiProfesora(String br_licne) {
		for (Profesor p : profesori) {
			if (p.getBr_licne().equals(br_licne)) {
				profesori.remove(p);
				break;
			}
		}
	}
	//brise predmet profesoru kada se izbrise predmet
	public void izbrisiPredmetProfesoru(String sifra_predmeta) {
		for (Profesor p : profesori) {
			for(Predmet pred : p.getPredmeti()) {
				if(pred.getSifra_predmeta().equals(sifra_predmeta)) {
					p.getPredmeti().remove(pred);
					break;
				}
			}
		}
	}
	//brise predmet profesoru kada se izmeni predmet
	public void izmenaPredmetaProfesora(Predmet predmet) {
		for(Profesor p : profesori) {
			for(Predmet pred : p.getPredmeti()) {
				if(pred.getSifra_predmeta().equals(predmet.getSifra_predmeta())) {
					pred.setGodina_studija(predmet.getGodina_studija());
					pred.setNaziv(predmet.getNaziv());
					pred.setSemestar(predmet.getSemestar());
					break;
				}
			}
		}
	}

	public void izmeniProfesora(String ime, String prezime, String adresa_stanovanja, String br_telefona, String mail,
			String adresa_kancelarije, String br_licne, Titula titula, Zvanje zvanje, Date datum_rodjenja) {
		for (Profesor p : profesori) {
			if (p.getBr_licne().equals(br_licne)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setAdresa_stanovanja(adresa_stanovanja);
				p.setBr_telefona(br_telefona);
				p.setMail(mail);
				p.setAdresa_kancelarije(adresa_kancelarije);
				p.setBr_licne(br_licne);//jel sme da se menja?
				p.setTitula(titula);
				p.setZvanje(zvanje);
				p.setDatum_rodjenja(datum_rodjenja);
			}
		}
	}
	
	public void serialize() {
		try { ObjectOutputStream out = new ObjectOutputStream(
		          new FileOutputStream("./datafiles/profesoriFile.txt"));
		      out.writeObject(this.getProfesori());
		      out.close();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public void deserialize() {
		try {  ObjectInputStream in = new ObjectInputStream(
		          new FileInputStream("./datafiles/profesoriFile.txt"));
			this.setProfesori((ArrayList<Profesor>)in.readObject());
			in.close();
		}catch(FileNotFoundException e) {
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//vraca pravi indeks iz filtrirane liste
	public int getRealRowForFilter(int selectedrow) {
		Profesor prof = filter_profesor.get(selectedrow);
		int i = 0;
		for(Profesor p : getProfesori()) {
			if(prof.getBr_licne().equals(p.getBr_licne())) {
				break;
			}
			i++;
		}
		return i;
	}
	// ispituje da li postoji profesor sa zadatim brojem licne karte
	public boolean postoji(String broj_licne) {
		boolean pronadjen=false;
		for(Profesor p : profesori) {
			if(p.getBr_licne().equals(broj_licne))
				pronadjen=true;
		}
		return pronadjen;
	}
	
}