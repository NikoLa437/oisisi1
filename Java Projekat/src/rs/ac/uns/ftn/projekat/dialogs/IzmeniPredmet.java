package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.controllers.PredmetController;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class IzmeniPredmet extends JDialog{

	private static final long serialVersionUID = 8968815004285653671L;
	
	public static JTextField txtSifra;
	public static JTextField txtNaziv;
	public static JComboBox cbGodStud;
	public static JComboBox cbSemestar;

	public IzmeniPredmet(JFrame parent) {
		super(parent,"Izmena predmeta",true);
		
		Predmet p = BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow);
		Profesor pr = p.getProfesor();
		this.setSize(400,250);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JLabel lblSifra = new JLabel("Sifra Predmeta*");
		JLabel lblNaziv = new JLabel("Naziv*");
		JLabel lblSemestar= new JLabel("Semestar*");
		JLabel lblGodina = new JLabel("Godina Studija*");
		
		txtSifra = new JTextField();
		txtNaziv = new JTextField();
		
		String[] sGodStud = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
		cbGodStud = new JComboBox(sGodStud);
		String[] sSemestar = { "I (prvi)", "II (drugi)", "III (treci)", "IV (cetvrti)", "V (peti)", "VI (sesti)", "VII (sedmi)", "VIII (osmi)" };
		cbSemestar = new JComboBox(sSemestar);
		
		txtSifra.setText(p.getSifra_predmeta());
		txtSifra.setEditable(false);
		txtNaziv.setText(p.getNaziv());
		
		cbGodStud.setSelectedIndex(p.getGodina_studija() - 1);
		cbSemestar.setSelectedIndex(p.getSemestar() - 1);
		
		panelC.add(lblSifra, gbclbl(0,0));
		panelC.add(txtSifra, gbctxt(1,0));
		panelC.add(lblNaziv,gbclbl(0,1));
		panelC.add(txtNaziv,gbctxt(1,1));
		panelC.add(lblSemestar,gbclbl(0,2));
		panelC.add(cbSemestar,gbctxt(1,2));
		panelC.add(lblGodina,gbclbl(0,3));
		panelC.add(cbGodStud,gbctxt(1,3));
		
		JButton bPotvrda = new JButton("Potvrda");
		JButton bOdustanak = new JButton("Odustanak");
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(PredmetController.getInstance().izmeniPredmet(pr) == 1)
					dispose();
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
