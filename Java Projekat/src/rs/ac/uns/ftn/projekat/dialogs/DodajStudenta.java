package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DodajStudenta extends JDialog{
	
	public DodajStudenta(JFrame parent) {
		super(parent,"Dodavanje novog studenta",true);
		this.pack();
		
		this.setSize(400,350);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodj= new JLabel("Datum Rodjenja*");
		JLabel lblAdresa = new JLabel("Adresa stanovanja*");
		JLabel lblBrojTel = new JLabel("Broj telefona*");
		JLabel lblBrojInd = new JLabel("Broj indeksa*");
		JLabel lblGodStud = new JLabel("Godina studija*");
		
		JTextField txtIme = new JTextField();
		JTextField txtPrezime = new JTextField();
		JTextField txtDatumRodj = new JTextField();
		JTextField txtAdresa = new JTextField();
		JTextField txtBrojTel = new JTextField();
		JTextField txtBrojInd = new JTextField();
		
		String[] sGodStud = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
		JComboBox cbGodStud = new JComboBox(sGodStud);
		
		JRadioButton rbBudzet = new JRadioButton("Budzet");
		JRadioButton rbSamof = new JRadioButton("Samofinansiranje");

		ButtonGroup btnGroup1 = new ButtonGroup();
		btnGroup1.add(rbBudzet);
		btnGroup1.add(rbSamof);
	
		panelC.add(lblIme, gbclbl(0,0));
		panelC.add(txtIme, gbctxt(1,0));
		panelC.add(lblPrezime,gbclbl(0,1));
		panelC.add(txtPrezime,gbctxt(1,1));
		panelC.add(lblDatumRodj,gbclbl(0,2));
		panelC.add(txtDatumRodj,gbctxt(1,2));
		panelC.add(lblAdresa,gbclbl(0,3));
		panelC.add(txtAdresa,gbctxt(1,3));
		panelC.add(lblBrojTel,gbclbl(0,4));
		panelC.add(txtBrojTel,gbctxt(1,4));
		panelC.add(lblBrojInd,gbclbl(0,5));
		panelC.add(txtBrojInd,gbctxt(1,5));
		panelC.add(lblGodStud,gbclbl(0,6));
		panelC.add(cbGodStud,gbctxt(1,6));
		panelC.add(rbBudzet,gbclbl(0,7));
		panelC.add(rbSamof,gbclbl(0,8));
		
		Button bPotvrda = new Button("Potvrda");
		Button bOdustanak = new Button("Odustanak");
		
		panelS.add(bOdustanak);
		panelS.add(bPotvrda);
		//test
		add(panelC,BorderLayout.NORTH);
		add(panelS,BorderLayout.SOUTH);
		
		
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
