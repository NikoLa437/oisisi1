package rs.ac.uns.ftn.projekat.data;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

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
		predmeti.add(new Predmet("O12-ss", "OISISI",5,3));
		predmeti.add(new Predmet("sq654652", "SPPuRV",4,2));
		predmeti.add(new Predmet("as87", "Baze Podataka 1",3,2));
	}
	
	public List<Predmet> getPredmeti() {
		return this.predmeti;
	}
	
	public List<Predmet> getFilterPredmeti() {
		return this.filter_predmet;
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
	
	public void obrisiStudenta(String sifra_predmeta, Student s) {
		for (Predmet pr : predmeti) {
			if (pr.getSifra_predmeta().equals(sifra_predmeta)) {
				pr.getStudenti().remove(s)	;
				}
		}
	}
	
	public void PretraziPredmet(String kriterijum) {
			ArrayList<Predmet> pretraga = new ArrayList<Predmet>();

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
					
					if(!kolone[0].equals("naziv") && !kolone[0].equals("sifra") && !kolone[0].equals("semestar") && !kolone[0].equals("godina"))
						JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
					else {
						
						for(Predmet p: predmeti)
						{
							boolean za_prikazati = false;
							for(int i = 0; i < brojac; i++)
							{
								if(kolone[i].equals("naziv")) {
									if(kriter[i].equals(p.getNaziv())) {
										za_prikazati = true;
									}else {
										za_prikazati = false;
										break;
									}
								}
								if(kolone[i].equals("sifra")) {
									if(kriter[i].equals(p.getSifra_predmeta())) {
										za_prikazati = true;
									}else {
										za_prikazati = false;
										break;
									}
								}
								if(kolone[i].equals("semestar")) {
									if(kriter[i].equals(Integer.toString(p.getSemestar()))) {
										za_prikazati = true;
									}else {
										za_prikazati = false;
										break;
									}
								}
								if(kolone[i].equals("godina")) {
									if(kriter[i].equals(Integer.toString(p.getGodina_studija()))) {
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
						indikator = 1;
						filter_predmet = pretraga;
						PredmetJTable.osvezi();
					}
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
				}
			}
			else
			{
				indikator = 0;
				PredmetJTable.osvezi();
			}			
		}
	
}
