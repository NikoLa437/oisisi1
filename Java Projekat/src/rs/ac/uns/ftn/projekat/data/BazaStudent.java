package rs.ac.uns.ftn.projekat.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.classes.Student.Status;

public class BazaStudent {
	
	private static BazaStudent instance = null; // kreiramo referencu koja ce pokazivati na bazu
	
	public static BazaStudent getInstance() {  // kreiramo metodu koja ce vracati instancu baze(referencu)
		if (instance == null) {
			instance = new BazaStudent();
		}
		return instance;
	}
	 
	private List<Student> studenti;  // lista studenata
	private List<String> kolone; // kolone tabele
	
	private BazaStudent() {  // konstruktor klase Baza Studenata
		
		initStudent();

		this.kolone = new ArrayList<String>(); // instanciramo listu kolona i dodajemo elemente
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	@SuppressWarnings("deprecation")
	private void initStudent() { // inicijalizovace studente u listu
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Nikola","Kolovic","Kraljevo","062490393","nikoladskv@hotmail.rs","RA133-2017",new Date(1998,04,03),new Date(98,04,03),3,9.76,Status.B));
		studenti.add(new Student("Dusan","Petrovic","Sabac","0624905435","dusanchinaa@hotmail.rs","RA122-2017",new Date(1998,12,12),new Date(07,04,03),3,9.76,Status.B));
	}
	
	public List<Student> getStudenti() { // vraca listu studenata
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) { // setuje studente
		this.studenti = studenti;
	}
	
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) { // vraca naziv kolone na indeksu
		return this.kolone.get(index);
	}
	
	public Student getRow(int rowIndex) { // vraca studenta u odredjenoj vrsti
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student stud = this.studenti.get(row);
		switch (column) {
		case 0:
			return stud.getIndeks();
		case 1:
			return stud.getIme();
		case 2:
			return stud.getPrezime();
		case 3:
			return Integer.toString(stud.getGod_studija());
		case 4:
			return stud.getStatus().toString();  // getovanje statusa proveriti kako
		case 5:
			return Double.toString(stud.getProsecna_ocena());
			
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String i,String p,String a_s,String k_t,
			String e_a,String ind,Date dr,Date du,int g_s,
			double p_o,Status ss) {
		
		this.studenti.add(new Student(i, p, a_s, k_t,e_a,ind,dr,du,g_s,p_o,ss));
		
	}
	
	public void izbrisiStudenta(String indeks_studenta) {
		for (Student s : studenti) {
			if (s.getIndeks().equals(indeks_studenta)) {
				studenti.remove(s);
				break;
			}
		}
	}
	
	public void izmeniStudenta(String indeks_studenta, String ime,String prz,String a_s,String k_t,
			String e_a,String ind,Date dr,Date du,int g_s,
			double p_o) {
		for (Student s : studenti) {
			if (s.getIndeks().equals(indeks_studenta)) {
				s.setIme(ime);
				s.setPrezime(prz);
				s.setAdresa_stanovanja(a_s);
				s.setKontakt_telefon(k_t);
				s.setEmail_adresa(e_a);
				//s.setIndeks(ind);  //pitanje je da li sme da se setuje drugi br indeksa(morao bi proveriti ostale)
				s.setDatum_rodjenja(dr);
				s.setDatum_upisa(du);
				s.setGod_studija(g_s);
				s.setProsecna_ocena(p_o);
			}
		}
	}
	
}