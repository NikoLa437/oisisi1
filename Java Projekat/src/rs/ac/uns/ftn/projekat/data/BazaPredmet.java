package rs.ac.uns.ftn.projekat.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.controllers.StudentController;

public class BazaPredmet {

	private static BazaPredmet instance = null;

	public static BazaPredmet getInstance() {
		if (instance == null) {
			instance = new BazaPredmet();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<Predmet> filter_predmet;
	private List<String> kolone;
	public static int indikator = 0;
	
	private BazaPredmet() {
	
		initPredmet();
		filter_predmet = new ArrayList<Predmet>();
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
	}
	
	public List<Predmet> getPredmeti() {
		return this.predmeti;
	}
	
	public List<Predmet> getFilterPredmeti() {
		return this.filter_predmet;
	}
	
	public void setFilterPredmeti(List<Predmet> filter_predmet) {
		this.filter_predmet = filter_predmet;
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
		Predmet predmet = new Predmet();
		if(indikator == 0)
			predmet = this.predmeti.get(row);
		else
			predmet = this.filter_predmet.get(row);
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
				return Integer.toString(predmet.getStudenti().size());
		default:
			return null;
		}
	}

	public void dodajPredmet(String sifra_predmeta, String naziv, int semestar, int godina_studija) {
		this.predmeti.add(new Predmet(sifra_predmeta, naziv, semestar, godina_studija));
	}
	
	public Predmet returnPredmet(String sifra_predmeta) {
		for(Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifra_predmeta)) {
				return p;
			}
		}
		return null;
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
	
	public void obrisiStudenta(String indexStudenta,String sifraPredmeta ) {
		for(Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifraPredmeta)) {
				for(Student s : p.getStudenti()) {
					if(s.getIndeks().equals(indexStudenta)) {
						p.getStudenti().remove(s);
						break;
					}
				}
				break;
			}
		}
	}
	
	public void serialize() {
		try { ObjectOutputStream out = new ObjectOutputStream(
		          new FileOutputStream("./datafiles/predmetiFile.txt"));
		      out.writeObject(this.getPredmeti());
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
		          new FileInputStream("./datafiles/predmetiFile.txt"));
			this.setPredmeti((ArrayList<Predmet>)in.readObject());
			in.close();
		}catch(FileNotFoundException e) {
		}
		catch(IOException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getRealRowForFilter(int selectedrow) {
		Predmet pred = filter_predmet.get(selectedrow);
		int i = 0;
		for(Predmet p : getPredmeti()) {
			if(pred.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				break;
			}
			i++;
		}
		return i;
	}
}
