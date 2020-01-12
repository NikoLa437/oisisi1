package rs.ac.uns.ftn.projekat.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


import rs.ac.uns.ftn.projekat.additionalclass.ScaleIcon;

public class About extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon iconAbout = ScaleIcon.ScaleIconSize("icon/abouticon.png");
	
	public About()  {
		Image Image = iconAbout.getImage();
	    this.setIconImage(Image);
		this.setSize(900,600);
		this.setTitle("Informacije o aplikaciji");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
		JPanel p1= new JPanel();
		BoxLayout bLayout1= new BoxLayout(p1,BoxLayout.Y_AXIS);
		p1.setLayout(bLayout1);
		
		TitledBorder title;
		title = BorderFactory.createTitledBorder("ABOUT APPLICATION");
		title.setTitleJustification(TitledBorder.CENTER);
		
		p1.setBorder(title);
		JLabel verzija= new JLabel("Version: v1.0");
		JLabel opisNaslov = new JLabel("Opis aplikacije: Aplikacija je namenjena laksem rukovanju studentskom sluzbom. Omogucava "
				+ "evidenciju studenata,profesora i predmeta dodavanje"); 
		JLabel opisText = new JLabel("novih kao i brisanje i izmenu postojecih,pretrazivanje i "
				+ "sortiranje. Svi podaci se cuvaju u datotekama i azuriraju pri svakom izlasku iz aplikacije.");
		p1.add(verzija);
		JLabel prazan=new JLabel("                              ");
		p1.add(prazan);
		p1.add(opisNaslov);
		p1.add(opisText);
		JLabel prazan1=new JLabel("                              ");
		p1.add(prazan1);
		
		JPanel p2= new JPanel();
		bLayout1= new BoxLayout(p2,BoxLayout.Y_AXIS);
		p2.setLayout(bLayout1);

		title = BorderFactory.createTitledBorder("ABOUT AUTHORS");
		title.setTitleJustification(TitledBorder.CENTER);
		p2.setBorder(title);
		JLabel imgLabel = new JLabel(new ImageIcon("icon/resized.jpg"),JLabel.CENTER);
		imgLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		p2.add(imgLabel);
		
		JPanel panelS1 = new JPanel();
		title = BorderFactory.createTitledBorder("Student 1");
		panelS1.setBorder(title);
		bLayout1= new BoxLayout(panelS1,BoxLayout.Y_AXIS);
		panelS1.setLayout(bLayout1);
		JLabel ime = new JLabel("Ime: Nikola");
		panelS1.add(ime);
		JLabel prezime = new JLabel("Prezime: Kolovic");
		panelS1.add(prezime);
		JLabel mesto_rodjenja = new JLabel("Mesto rodjenja: Kraljevo");
		panelS1.add(mesto_rodjenja);
		JLabel datum_rodjenja = new JLabel("Datum rodjenja: 04.03.1998.");
		panelS1.add(datum_rodjenja);
		JLabel srednja_skola = new JLabel("Srednja skola: Elektro-tehnicka skola Kraljevo");
		panelS1.add(srednja_skola);
		JLabel fakultet1 = new JLabel("Trenutno pohadja: Fakultet tehnickih nauka - Novi Sad");
		panelS1.add(fakultet1);

		JPanel panelS2= new JPanel();
		title = BorderFactory.createTitledBorder("Student 2");
		panelS2.setBorder(title);
		bLayout1= new BoxLayout(panelS2,BoxLayout.Y_AXIS);
		panelS2.setLayout(bLayout1);
		JLabel ime2 = new JLabel("Ime: Dusan");
		panelS2.add(ime2);
		JLabel prezime2 = new JLabel("Prezime: Petrovic");
		panelS2.add(prezime2);
		JLabel mesto_rodjenja2 = new JLabel("Mesto rodjenja: Beograd");
		panelS2.add(mesto_rodjenja2);
		JLabel datum_rodjenja2 = new JLabel("Datum rodjenja: 17.07.1998.");
		panelS2.add(datum_rodjenja2);
		JLabel srednja_skola2 = new JLabel("Srednja skola: Sabacka gimnazija");
		panelS2.add(srednja_skola2);
		JLabel fakultet2 = new JLabel("Trenutno pohadja: Fakultet tehnickih nauka - Novi Sad");
		panelS2.add(fakultet2);
		
		JPanel p3 = new JPanel(new FlowLayout());
		p3.add(panelS1,FlowLayout.LEFT);
		((FlowLayout)p3.getLayout()).setHgap(80);
		p3.add(panelS2,FlowLayout.CENTER);
		
		p2.add(p3,BorderLayout.CENTER);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(p2,BorderLayout.SOUTH);
		this.setVisible(true);
		
	}

}
