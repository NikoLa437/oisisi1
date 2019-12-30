package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
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

public class DetaljiStudenta extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField txtIme;
	public JTextField txtPrezime;
	public JTextField txtDatumRodj;
	public JTextField txtAdresa;
	public JTextField txtBrojTel;
	public JTextField txtBrojInd;
	public JTextField txteadresa;
	public JTextField txtdatumUpisa;
	public JTextField txtprosecnaOcena;
	public JComboBox cbGodStud;
	public JRadioButton rbBudzet;
	public JRadioButton rbSamof;
	
	public DetaljiStudenta(JFrame parent,int selected) {
		super(parent,"Detalji studenata",true);
	
	if(BazaStudent.getInstance().getStudenti().size()==0) {
		JOptionPane.showMessageDialog(null, "Ne postoji ili nije selektovan ni jedan student", "Error", JOptionPane.ERROR_MESSAGE );
        dispose();
	}else {
	
	Student s= new Student();
	s=BazaStudent.getInstance().getRow(selected);

	this.setSize(400,450);
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
	JLabel lbleadresa = new JLabel("Email adresa*");
	JLabel lbldatumUpisa = new JLabel("Datum upisa*");
	JLabel lblprosecnaOcena = new JLabel("Prosecna ocena*");
	
	 txtIme = new JTextField();
	 txtPrezime = new JTextField();
	 txtDatumRodj = new JTextField();
	 txtAdresa = new JTextField();
	 txtBrojTel = new JTextField();
	 txtBrojInd = new JTextField();
	 txteadresa = new JTextField();
	 txtdatumUpisa = new JTextField();
	 txtprosecnaOcena = new JTextField();
	
	String[] sGodStud = { "I (prva)", "II (druga)", "III (treca)", "IV (cetvrta)" };
	JComboBox cbGodStud = new JComboBox(sGodStud);

	 rbBudzet = new JRadioButton("Budzet");
	 rbSamof = new JRadioButton("Samofinansiranje");

	ButtonGroup btnGroup1 = new ButtonGroup();
	btnGroup1.add(rbBudzet);
	btnGroup1.add(rbSamof);
	rbBudzet.setEnabled(false);
	rbSamof.setEnabled(false);
	
	txtIme.setText(s.getIme());
	txtIme.setEditable(false);
	txtPrezime.setText(s.getPrezime());
	txtPrezime.setEditable(false);
	//datum rodjenja
	Date date=s.getDatum_rodjenja();
	DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy.", Locale.ENGLISH);
	txtDatumRodj.setText(dateFormat.format(date));
	txtDatumRodj.setEditable(false);
	//
	txtAdresa.setText(s.getAdresa_stanovanja());
	txtAdresa.setEditable(false);
	txtBrojTel.setText(s.getKontakt_telefon());
	txtBrojTel.setEditable(false);
	txtBrojInd.setText(s.getIndeks());
	txtBrojInd.setEditable(false);
	if(s.getStatus()==Status.B) {
		rbBudzet.setSelected(true);
	}else {
		rbSamof.setSelected(true);
	}
	cbGodStud.setSelectedIndex(s.getGod_studija()-1);
	cbGodStud.setEnabled(false);
	txteadresa.setText(s.getEmail_adresa());
	txteadresa.setEditable(false);
	txtdatumUpisa.setText(dateFormat.format(s.getDatum_upisa()));
	txtdatumUpisa.setEditable(false);
	txtprosecnaOcena.setText(String.valueOf(s.getProsecna_ocena()));
	txtprosecnaOcena.setEditable(false);
	
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
	panelC.add(lbleadresa,gbclbl(0,6));
	panelC.add(txteadresa,gbctxt(1,6));
	panelC.add(lbldatumUpisa,gbclbl(0,7));
	panelC.add(txtdatumUpisa,gbctxt(1,7));
	panelC.add(lblprosecnaOcena,gbclbl(0,8));
	panelC.add(txtprosecnaOcena,gbctxt(1,8));
	panelC.add(lblGodStud,gbclbl(0,9));
	panelC.add(cbGodStud,gbctxt(1,9));
	panelC.add(rbBudzet,gbclbl(0,10));
	panelC.add(rbSamof,gbclbl(0,11));
	
	JButton bOdustanak = new JButton("Odustanak");
	
	bOdustanak.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}
	});
	
	panelS.add(bOdustanak);
	//test
	add(panelC,BorderLayout.NORTH);
	add(panelS,BorderLayout.SOUTH);
	
	this.setResizable(false);
	this.setLocationRelativeTo(parent);
	this.setVisible(true);
}

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
