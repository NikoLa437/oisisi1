package rs.ac.uns.ftn.projekat.additionalclass;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class PretragaPredmeta {

	private static List<Predmet> svi_predmeti;
	private static int br_pretraga = 0;
	
	public PretragaPredmeta(String kriterijum) {
		if(br_pretraga == 0)
			svi_predmeti = BazaPredmet.getInstance().getPredmeti();
		if(!kriterijum.equals("")) {
			try{
				br_pretraga++;
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
					
					ArrayList<Predmet> pretraga = new ArrayList<Predmet>();
					for(Predmet p: svi_predmeti)
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
						if(za_prikazati== true)
							pretraga.add(p);
							
					}
					BazaPredmet.getInstance().setPredmeti(pretraga);
					PredmetJTable.osvezi();
				}
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
			}
		}
		else
		{
			BazaPredmet.getInstance().setPredmeti(svi_predmeti);
			PredmetJTable.osvezi();
		}
		
	}
}
