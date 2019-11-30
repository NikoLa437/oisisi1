package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class DodajPredmet extends JDialog{

	private static final long serialVersionUID = -5495281142892800228L;

	public DodajPredmet(JFrame parent) {
		super(parent,"Dodavanje novog predmeta",true);
		
		this.setSize(400,250);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JLabel lblSifra = new JLabel("Sifra Predmeta*");
		JLabel lblNaziv = new JLabel("Naziv*");
		JLabel lblSemestar= new JLabel("Semestar*");
		JLabel lblGodina = new JLabel("Godina Studija*");
		
		JTextField txtSifra = new JTextField();
		JTextField txtNaziv = new JTextField();
		
		String[] sGodStud = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
		JComboBox cbGodStud = new JComboBox(sGodStud);
		String[] sSemestar = { "I (prvi)", "II (drugi)", "III (treci)", "IV (cetvrti)", "V (peti)", "VI (sesti)", "VII (sedmi)", "VIII (osmi)" };
		JComboBox cbSemestar = new JComboBox(sSemestar);
		
		panelC.add(lblSifra, gbclbl(0,0));
		panelC.add(txtSifra, gbctxt(1,0));
		panelC.add(lblNaziv,gbclbl(0,1));
		panelC.add(txtNaziv,gbctxt(1,1));
		panelC.add(lblSemestar,gbclbl(0,2));
		panelC.add(cbSemestar,gbctxt(1,2));
		panelC.add(lblGodina,gbclbl(0,3));
		panelC.add(cbGodStud,gbctxt(1,3));
		
		Button bPotvrda = new Button("Potvrda");
		Button bOdustanak = new Button("Odustanak");
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Predmet p= new Predmet();
				int err = -1;

				if(cbGodStud.getSelectedIndex() == 0) 
					if(!(cbSemestar.getSelectedIndex() == 0 || cbSemestar.getSelectedIndex() == 1))
						err = 1;
				if(cbGodStud.getSelectedIndex() == 1) 
					if(!(cbSemestar.getSelectedIndex() == 2 || cbSemestar.getSelectedIndex() == 3))
						err = 1;
				if(cbGodStud.getSelectedIndex() == 2) 
					if(!(cbSemestar.getSelectedIndex() == 4 || cbSemestar.getSelectedIndex() == 5))
						err = 1;
				if(cbGodStud.getSelectedIndex() == 3) 
					if(!(cbSemestar.getSelectedIndex() == 6 || cbSemestar.getSelectedIndex() == 7))
						err = 1;
				if(txtSifra.getText().isEmpty() || txtNaziv.getText().isEmpty() || err == 1)
					JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
				else {
						p.setSifra_predmeta(txtSifra.getText());
						p.setNaziv(txtNaziv.getText());
						p.setSemestar(cbSemestar.getSelectedIndex() + 1);
						p.setGodina_studija(cbGodStud.getSelectedIndex()+1);
						BazaPredmet.getInstance().dodajPredmet(p.getSifra_predmeta(), p.getNaziv(), p.getSemestar(), p.getGodina_studija());
					
				}
				dispose();
				PredmetJTable.osvezi();
			}
		});
		
		panelS.add(bOdustanak);
		panelS.add(bPotvrda);
		//test
		add(panelC,BorderLayout.NORTH);
		add(panelS,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(parent);
		this.setVisible(true);

	}
	
	
	private GridBagConstraints gbclbl(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(10, 20, 0, 0);
		return gbc;
	}
	private GridBagConstraints gbctxt(int x,int y) {
		GridBagConstraints gbc= new GridBagConstraints();
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridwidth = 3;
		gbc.weightx = 100;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10, 20, 0, 20);
		return gbc;
	}
}
