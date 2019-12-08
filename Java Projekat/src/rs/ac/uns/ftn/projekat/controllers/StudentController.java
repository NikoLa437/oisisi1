package rs.ac.uns.ftn.projekat.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JOptionPane;

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
		
		if(!DodajStudenta.txtIme.getText().isEmpty()) {
			s.setIme(DodajStudenta.txtIme.getText());
			if(!DodajStudenta.txtPrezime.getText().isEmpty()) {
				s.setPrezime(DodajStudenta.txtPrezime.getText());
					if(!DodajStudenta.txtAdresa.getText().isEmpty()) {
						s.setAdresa_stanovanja(DodajStudenta.txtAdresa.getText());
						if(!DodajStudenta.txtBrojTel.getText().isEmpty()) {
							s.setKontakt_telefon(DodajStudenta.txtBrojTel.getText());
								if(!DodajStudenta.txtBrojInd.getText().isEmpty()&&!BazaStudent.getInstance().postoji(DodajStudenta.txtBrojInd.getText())) {
									s.setIndeks(DodajStudenta.txtBrojInd.getText());
									if(!DodajStudenta.txteadresa.getText().isEmpty()) {
										s.setEmail_adresa(DodajStudenta.txteadresa.getText());
										try {
											double p_o= Double.parseDouble(DodajStudenta.txtprosecnaOcena.getText());
											s.setProsecna_ocena(p_o);
											//try catch za datum upisa 
												try {
													SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
													Date date = formatter.parse(DodajStudenta.txtdatumUpisa.getText());
													s.setDatum_upisa(date);
													//try catch za datum studenta
														try {
															date = formatter.parse(DodajStudenta.txtDatumRodj.getText());
															s.setDatum_rodjenja(date);
															String g_s = DodajStudenta.cbGodStud.getSelectedItem().toString(); // godina studija	
															if(g_s.equals("I (prva)")){
																s.setGod_studija(1);
															}else if(g_s.equals("II (druga)")){
																s.setGod_studija(2);
															}else if(g_s.equals("III (treca)")){
																s.setGod_studija(3);
															}else {
																s.setGod_studija(4);
															}
															// status
															if(DodajStudenta.rbSamof.isSelected()) {
																s.setStatus(Status.S);
															}else {
																s.setStatus(Status.B);
															}
															//
															// dodavanje studenta ako je proslo sve
															BazaStudent.getInstance().dodajStudenta(s.getIme(), s.getPrezime(), s.getAdresa_stanovanja(), s.getKontakt_telefon(),s.getEmail_adresa(), s.getIndeks(), s.getDatum_rodjenja(), s.getDatum_upisa(), s.getGod_studija(), s.getProsecna_ocena(),s.getStatus());
															ret=1;
															StudentJTable.osvezi();	
															return ret;
														}catch(Exception ee) {
															JOptionPane.showMessageDialog(null, "Pogresan format datuma(datum mora biti u formatu dd.MM.yyyy.", "Error", JOptionPane.ERROR_MESSAGE );
														}
														// ako prodje i ovaj try catch znaci da je sve uredu i mozemo napraviti studenta
													
												
												}catch(Exception e1) {
													JOptionPane.showMessageDialog(null, "Pogresan unos datuma upisa! ( Format : yyyy. )", "Error", JOptionPane.ERROR_MESSAGE );
												}
											
										}catch(Exception e1) {
											JOptionPane.showMessageDialog(null, "Pogresan unos prosecne ocene!", "Error", JOptionPane.ERROR_MESSAGE );
										}
									
									}else {
										JOptionPane.showMessageDialog(null, "Pogresan unos e-mail adrese!", "Error", JOptionPane.ERROR_MESSAGE );
									}
								}else {
									JOptionPane.showMessageDialog(null, "Pogresan unos indeksa(indeks mora biti jedinstven)!", "Error", JOptionPane.ERROR_MESSAGE );
								}
						}else {
							JOptionPane.showMessageDialog(null, "Pogresan unos broja telefona!", "Error", JOptionPane.ERROR_MESSAGE );
						}
					}else {
						JOptionPane.showMessageDialog(null, "Pogresan unos adrese!", "Error", JOptionPane.ERROR_MESSAGE );
					}
			}else {
				JOptionPane.showMessageDialog(null, "Pogresan unos prezimena!", "Error", JOptionPane.ERROR_MESSAGE );
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Pogresan unos imena!", "Error", JOptionPane.ERROR_MESSAGE );
		}
		return ret;	
	}
	
	public int izmeniStudenta() {
		Student s= new Student();
		int ret=0;
		
		if(!IzmeniStudenta.txtIme.getText().isEmpty()) {
			s.setIme(IzmeniStudenta.txtIme.getText());
			if(!IzmeniStudenta.txtPrezime.getText().isEmpty()) {
				s.setPrezime(IzmeniStudenta.txtPrezime.getText());
					if(!IzmeniStudenta.txtAdresa.getText().isEmpty()) {
						s.setAdresa_stanovanja(IzmeniStudenta.txtAdresa.getText());
						if(!IzmeniStudenta.txtBrojTel.getText().isEmpty()) {
							s.setKontakt_telefon(IzmeniStudenta.txtBrojTel.getText());
									if(!IzmeniStudenta.txteadresa.getText().isEmpty()) {
										s.setEmail_adresa(IzmeniStudenta.txteadresa.getText());
										s.setIndeks(IzmeniStudenta.txtBrojInd.getText());
										try {
											double p_o= Double.parseDouble(IzmeniStudenta.txtprosecnaOcena.getText());
											s.setProsecna_ocena(p_o);
											//try catch za datum upisa 
												try {
													SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
													Date date = formatter.parse(IzmeniStudenta.txtdatumUpisa.getText());
													s.setDatum_upisa(date);
													//try catch za datum studenta
														try {
															date = formatter.parse(IzmeniStudenta.txtDatumRodj.getText());
															s.setDatum_rodjenja(date);
															String g_s = IzmeniStudenta.cbGodStud.getSelectedItem().toString(); // godina studija	
															if(g_s.equals("I (prva)")){
																s.setGod_studija(1);
															}else if(g_s.equals("II (druga)")){
																s.setGod_studija(2);
															}else if(g_s.equals("III (treca)")){
																s.setGod_studija(3);
															}else {
																s.setGod_studija(4);
															}
															// status
															if(IzmeniStudenta.rbSamof.isSelected()) {
																s.setStatus(Status.S);
															}else {
																s.setStatus(Status.B);
															}
															//
															// dodavanje studenta ako je proslo sve
															BazaStudent.getInstance().izmeniStudenta(s.getIndeks(),s.getIme(), s.getPrezime(), s.getAdresa_stanovanja(), s.getKontakt_telefon(), s.getEmail_adresa(), s.getDatum_rodjenja(), s.getDatum_upisa(), s.getGod_studija(), s.getProsecna_ocena(),s.getStatus());
															StudentJTable.osvezi();
															ret=1;
															return ret;
														}catch(Exception ee) {
															JOptionPane.showMessageDialog(null, "Pogresan format datuma(datum mora biti u formatu dd.MM.yyyy.", "Error", JOptionPane.ERROR_MESSAGE );
														}
														// ako prodje i ovaj try catch znaci da je sve uredu i mozemo napraviti studenta
													
												
												}catch(Exception e1) {
													JOptionPane.showMessageDialog(null, "Pogresan unos datuma upisa! ( Format : yyyy. )", "Error", JOptionPane.ERROR_MESSAGE );
												}
											
										}catch(Exception e1) {
											JOptionPane.showMessageDialog(null, "Pogresan unos prosecne ocene!", "Error", JOptionPane.ERROR_MESSAGE );
										}
									
									}else {
										JOptionPane.showMessageDialog(null, "Pogresan unos e-mail adrese!", "Error", JOptionPane.ERROR_MESSAGE );
									}
						}else {
							JOptionPane.showMessageDialog(null, "Pogresan unos broja telefona!", "Error", JOptionPane.ERROR_MESSAGE );
						}
					}else {
						JOptionPane.showMessageDialog(null, "Pogresan unos adrese!", "Error", JOptionPane.ERROR_MESSAGE );
					}
			}else {
				JOptionPane.showMessageDialog(null, "Pogresan unos prezimena!", "Error", JOptionPane.ERROR_MESSAGE );
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Pogresan unos imena!", "Error", JOptionPane.ERROR_MESSAGE );
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
						if(st.getIndeks()==s.getIndeks())
							postoji=true;
					}
					if(!postoji) {
					BazaStudent.getInstance().dodajPredmet(s.getIndeks(), pr);
					BazaPredmet.getInstance().dodajStudenta(pr.getSifra_predmeta(), s);
					ret=1;
					PredmetJTable.osvezi();}
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
	
}


	

