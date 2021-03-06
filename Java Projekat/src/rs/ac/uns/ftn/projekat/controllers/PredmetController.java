package rs.ac.uns.ftn.projekat.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;
import rs.ac.uns.ftn.projekat.view.ProfesorJTable;
import rs.ac.uns.ftn.projekat.view.ToolBar;
import rs.ac.uns.ftn.projekat.view.dialogs.DodajPredmet;
import rs.ac.uns.ftn.projekat.view.dialogs.DodajProfesoraNaPredmet;
import rs.ac.uns.ftn.projekat.view.dialogs.IzmeniPredmet;

public class PredmetController {
	
	private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public int dodajPredmet() {
		Predmet p= new Predmet();
		int err = -1;
		int ret = 0;
		int err1 = -1;
		//provera da li postoji predmet sa istom sifrom
		for(Predmet prr: BazaPredmet.getInstance().getPredmeti()) {
			if(prr.getSifra_predmeta().equals(DodajPredmet.txtSifra.getText())) {
				err1=1;
				break;
			}
		}
		//provera da li semestar odgovara godini (npr. prva godina I i II semestar)
		if(DodajPredmet.cbGodStud.getSelectedIndex() == 0) 
			if(!(DodajPredmet.cbSemestar.getSelectedIndex() == 0 || DodajPredmet.cbSemestar.getSelectedIndex() == 1))
				err = 1;
		if(DodajPredmet.cbGodStud.getSelectedIndex() == 1) 
			if(!(DodajPredmet.cbSemestar.getSelectedIndex() == 2 || DodajPredmet.cbSemestar.getSelectedIndex() == 3))
				err = 1;
		if(DodajPredmet.cbGodStud.getSelectedIndex() == 2) 
			if(!(DodajPredmet.cbSemestar.getSelectedIndex() == 4 || DodajPredmet.cbSemestar.getSelectedIndex() == 5))
				err = 1;
		if(DodajPredmet.cbGodStud.getSelectedIndex() == 3) 
			if(!(DodajPredmet.cbSemestar.getSelectedIndex() == 6 || DodajPredmet.cbSemestar.getSelectedIndex() == 7))
				err = 1;
		if(err == 1)
			JOptionPane.showMessageDialog(null, "Neodgovarajuci semestar za izabranu godinu!", "Error", JOptionPane.ERROR_MESSAGE );
		else if(err1 != -1)
			JOptionPane.showMessageDialog(null, "Sifra predmeta mora biti jedinstvena!", "Error", JOptionPane.ERROR_MESSAGE );
		else {
				p.setSifra_predmeta(DodajPredmet.txtSifra.getText());
				p.setNaziv(DodajPredmet.txtNaziv.getText());
				p.setSemestar(DodajPredmet.cbSemestar.getSelectedIndex() + 1);
				p.setGodina_studija(DodajPredmet.cbGodStud.getSelectedIndex()+1);
				BazaPredmet.getInstance().dodajPredmet(p.getSifra_predmeta(), p.getNaziv(), p.getSemestar(), p.getGodina_studija());
				//ako novi predmet odgovara kriterijumu pretrage, prikazati ga u pretrazi
				if(BazaPredmet.indikator == 1)
					this.PretraziPredmet(ToolBar.textField.getText());
				ret = 1;
		}
		PredmetJTable.osvezi();
		return ret;
	}
	
	public int izmeniPredmet(Profesor pr,int godina_studija){
		Predmet p= new Predmet();
		int ret  = 0;
		int err = -1;

		//provera da li semestar odgovara godini (npr. prva godina I i II semestar)
		if(IzmeniPredmet.cbGodStud.getSelectedIndex() == 0) 
			if(!(IzmeniPredmet.cbSemestar.getSelectedIndex() == 0 || IzmeniPredmet.cbSemestar.getSelectedIndex() == 1))
				err = 1;
		if(IzmeniPredmet.cbGodStud.getSelectedIndex() == 1) 
			if(!(IzmeniPredmet.cbSemestar.getSelectedIndex() == 2 || IzmeniPredmet.cbSemestar.getSelectedIndex() == 3))
				err = 1;
		if(IzmeniPredmet.cbGodStud.getSelectedIndex() == 2) 
			if(!(IzmeniPredmet.cbSemestar.getSelectedIndex() == 4 || IzmeniPredmet.cbSemestar.getSelectedIndex() == 5))
				err = 1;
		if(IzmeniPredmet.cbGodStud.getSelectedIndex() == 3) 
			if(!(IzmeniPredmet.cbSemestar.getSelectedIndex() == 6 || IzmeniPredmet.cbSemestar.getSelectedIndex() == 7))
				err = 1;
		if(IzmeniPredmet.txtNaziv.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Naziv predmeta ne sme biti prazan!", "Error", JOptionPane.ERROR_MESSAGE );
		else if(err ==1)
			JOptionPane.showMessageDialog(null, "Neodgovarajuci semestar za izabranu godinu!", "Error", JOptionPane.ERROR_MESSAGE );
		else {
				p.setSifra_predmeta(IzmeniPredmet.txtSifra.getText());
				p.setNaziv(IzmeniPredmet.txtNaziv.getText());
				p.setSemestar(IzmeniPredmet.cbSemestar.getSelectedIndex() + 1);
				p.setGodina_studija(IzmeniPredmet.cbGodStud.getSelectedIndex()+1);
				BazaPredmet.getInstance().izmeniPredmet(p.getSifra_predmeta(),pr, p.getNaziv(), p.getSemestar(), p.getGodina_studija());
				//ako se promeni godina studija na predmetu, obrisu se studenti sa predmeta (jer bi u suprotnom, npr student prve godine
				// ostao na predmetu koji je iz prve promenjen u drugu godinu)
				if(godina_studija != p.getGodina_studija()) {
					BazaStudent.getInstance().izbrisiPredmetStudentima(p.getSifra_predmeta());
					BazaPredmet.getInstance().returnPredmet(p.getSifra_predmeta()).getStudenti().clear();
				}
				//ako je kriterijum pretrage godina:2, promenom godine na 1 ce izbaciti predmet iz prikazanih
				if(BazaPredmet.indikator == 1)
					this.PretraziPredmet(ToolBar.textField.getText());
				
				BazaProfesor.getInstance().izmenaPredmetaProfesora(p);
				BazaStudent.getInstance().izmenaPredmetaStudentima(p);
				ret = 1;
		}
		PredmetJTable.osvezi();
		
		return ret;
	}
	
	public void obrisiPredmet(Predmet p) {
			
		BazaPredmet.getInstance().izbrisiPredmet(p.getSifra_predmeta());
		if(BazaPredmet.indikator == 1)
			this.PretraziPredmet(ToolBar.textField.getText());
		BazaProfesor.getInstance().izbrisiPredmetProfesoru(p.getSifra_predmeta());
		BazaStudent.getInstance().izbrisiPredmetStudentima(p.getSifra_predmeta());

		PredmetJTable.osvezi();
		ProfesorJTable.osvezi();
		
	}
	
	public int dodajProfesoraNaPredmet(Predmet pr) {
		List<Profesor> profesori = BazaProfesor.getInstance().getProfesori();
		int ret = 0;
		Profesor prof = new Profesor();
		boolean nasao = false;
		//provera da li postoji uneti broj licne karte
		for(Profesor p1: profesori) {
			if(DodajProfesoraNaPredmet.txtLicna.getText().equals(p1.getBr_licne())) {
				prof = p1;
				nasao = true;
				break;
			}
		}
		//provera validnosti broja licne karte
		if(!DodajProfesoraNaPredmet.txtLicna.getText().matches("[A-Za-z0-9]{7,13}"))
			JOptionPane.showMessageDialog(null, "Broj licne karte nije validan!", "Error", JOptionPane.ERROR_MESSAGE );
		else if(nasao == false)
			JOptionPane.showMessageDialog(null, "Unet pogresan broj licne karte!", "Error", JOptionPane.ERROR_MESSAGE );
		
		else {				
				BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(),prof, pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
				prof.addPredmet(pr);
				ret = 1;		
		}
		PredmetJTable.osvezi();
		
		return ret;
	}
	
	public void uklanjanjeProfesoraSaPredmet(Predmet pr) {
		BazaPredmet.getInstance().izmeniPredmet(pr.getSifra_predmeta(), new Profesor(), pr.getNaziv(), pr.getSemestar(), pr.getGodina_studija());
		BazaProfesor.getInstance().izbrisiPredmetProfesoru(pr.getSifra_predmeta());
		PredmetJTable.osvezi();
		ProfesorJTable.osvezi();
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
				boolean err = false;
				for(int k = 0; k < kolone.length; k++) {
				 if(kolone[k] != null) 
					if(!kolone[0].equals("naziv") && !kolone[0].equals("sifra") && !kolone[0].equals("semestar") && !kolone[0].equals("godina")) {
						JOptionPane.showMessageDialog(null,
								"Pogresan unos podataka!\nPretraga se vrsi u formatu: '[naziv:'naziv';][sifra:'sifra'];[semestar:'semstar'];[godina:'godina']'",
								"Error", JOptionPane.ERROR_MESSAGE );
						err = true;
						break;
					}
				}
				if(!err) {
					
					for(Predmet p: BazaPredmet.getInstance().getPredmeti())
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
					BazaPredmet.indikator = 1;
					BazaPredmet.getInstance().setFilterPredmeti(pretraga);
					PredmetJTable.osvezi();
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		else
		{
			BazaPredmet.indikator = 0;
			PredmetJTable.osvezi();
		}			
	}

		

}
