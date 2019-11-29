package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.classes.Student.Status;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.StudentJTable;

public class IzmeniStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public IzmeniStudenta(JFrame parent) {
		super(parent,"Izmena studenta",true);

		Student s= BazaStudent.getInstance().getRow(StudentJTable.getSelRow());

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
	
		txtIme.setText(s.getIme());
		txtPrezime.setText(s.getPrezime());
		txtDatumRodj.setText(s.getDatum_rodjenja().toString());
		txtAdresa.setText(s.getAdresa_stanovanja());
		txtBrojTel.setText(s.getKontakt_telefon());
		txtBrojInd.setText(s.getIndeks());
		txtBrojInd.setEditable(false);
		if(s.getStatus()==Status.B) {
			rbBudzet.setSelected(true);
		}else {
			rbSamof.setSelected(true);
		}
		cbGodStud.setSelectedIndex(s.getGod_studija()-1);
		
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
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student s= new Student();

				if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtAdresa.getText().isEmpty() || txtBrojTel.getText().isEmpty() || txtBrojInd.getText().isEmpty())
					JOptionPane.showMessageDialog(null, "Pogresan unos podataka!", "Error", JOptionPane.ERROR_MESSAGE );
				else {
					try {
						SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
						Date date = formatter.parse(txtDatumRodj.getText());
						s.setDatum_rodjenja(date);
						
						s.setIme(txtIme.getText());
						s.setPrezime(txtPrezime.getText());
						s.setAdresa_stanovanja(txtAdresa.getText());
						s.setKontakt_telefon(txtBrojTel.getText());
						s.setIndeks(txtBrojInd.getText());
						String g_s = cbGodStud.getSelectedItem().toString();
						
						if(g_s.equals("I (prva)")){
							s.setGod_studija(1);
						}else if(g_s.equals("II (druga)")){
							s.setGod_studija(2);
						}else if(g_s.equals("III (treca)")){
							s.setGod_studija(3);
						}else {
							s.setGod_studija(4);
						}
						
						if(rbSamof.isSelected()) {
							s.setStatus(Status.S);
						}else {
							s.setStatus(Status.B);
						}
						
						
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Datum mora biti u formatu: dd.MM.yyyy.", "Error", JOptionPane.ERROR_MESSAGE );
						}
				}
				BazaStudent.getInstance().izmeniStudenta(s.getIndeks(),s.getIme(), s.getPrezime(), s.getAdresa_stanovanja(), s.getKontakt_telefon(), "e-adresa", s.getDatum_rodjenja(), s.getDatum_rodjenja(), s.getGod_studija(), 13.3,s.getStatus());
				dispose();
				StudentJTable.osvezi();
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
