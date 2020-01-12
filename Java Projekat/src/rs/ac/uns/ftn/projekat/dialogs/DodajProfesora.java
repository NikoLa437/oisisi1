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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import rs.ac.uns.ftn.projekat.controllers.ProfesorController;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class DodajProfesora extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static JTextField txtIme;
	public static JTextField txtPrezime ;
	public static JTextField txtDatumRodj ;
	public static JTextField txtAdresaStan;
	public static JTextField txtKtkTel ;
	public static JTextField txtEAdresa ;
	public static JTextField txtAdresaKanc ;
	public static JTextField txtBrojLicne ;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbTitula ;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbZvanje ;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DodajProfesora(JFrame parent) {
		super(parent,"Dodavanje novog profesora",true);
		
		
		this.setSize(MainFrame.sirina*3/7,MainFrame.visina*5/7);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		//labele za profesora
		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodj= new JLabel("Datum rodjenja*");
		JLabel lblAdresaStan = new JLabel("Adresa stanovanja*");
		JLabel lblKtkTel = new JLabel("Kontakt telefon*");
		JLabel lblEAdresa = new JLabel("Email adresa*");
		JLabel lblAdresaKanc = new JLabel("Adresa kancelarije*");
		JLabel lblBrojLicne = new JLabel("Broj licne karte*");
		JLabel lblTitula = new JLabel("Titula*");
		JLabel lblZvanje = new JLabel("Zvanje*");
		
		//text field za profesora
		 txtIme = new JTextField();
		 txtPrezime = new JTextField();
		 txtDatumRodj = new JTextField();
		 txtAdresaStan = new JTextField();
		 txtKtkTel = new JTextField();
		 txtEAdresa = new JTextField();
		 txtAdresaKanc = new JTextField();
		 txtBrojLicne = new JTextField();
		 String[] sTitule = { "Prof.Dr","Doktor","Magistar","Master"};
		 String[] sZvanje = { "Redovni profesor","Vandredni profesor","Asistent","Saradnik u nastavi","Docent" };
		 cbTitula = new JComboBox(sTitule);
		 cbZvanje = new JComboBox(sZvanje);
	

		panelC.add(lblIme, gbclbl(0,0));
		panelC.add(txtIme, gbctxt(1,0));
		panelC.add(lblPrezime,gbclbl(0,1));
		panelC.add(txtPrezime,gbctxt(1,1));
		panelC.add(lblDatumRodj,gbclbl(0,2));
		panelC.add(txtDatumRodj,gbctxt(1,2));
		panelC.add(lblAdresaStan,gbclbl(0,3));
		panelC.add(txtAdresaStan,gbctxt(1,3));
		panelC.add(lblKtkTel,gbclbl(0,4));
		panelC.add(txtKtkTel,gbctxt(1,4));
		panelC.add(lblEAdresa,gbclbl(0,5));
		panelC.add(txtEAdresa,gbctxt(1,5));
		panelC.add(lblAdresaKanc,gbclbl(0,6));
		panelC.add(txtAdresaKanc,gbctxt(1,6));
		panelC.add(lblBrojLicne,gbclbl(0,7));
		panelC.add(txtBrojLicne,gbctxt(1,7));
		panelC.add(lblTitula,gbclbl(0,8));
		panelC.add(cbTitula,gbctxt(1,8));
		panelC.add(lblZvanje,gbclbl(0,9));
		panelC.add(cbZvanje,gbctxt(1,9));
		
		JButton bPotvrda = new JButton("Potvrda");
		JButton bOdustanak = new JButton("Odustanak");
		
		bPotvrda.setEnabled(false);
		
		
		//disable dugmeta 
		JButtonStateControllerDodajProfesora jbsc = new JButtonStateControllerDodajProfesora(bPotvrda);
		Document textFieldDocIme = txtIme.getDocument();
		textFieldDocIme.addDocumentListener(jbsc);
		Document textFieldDocPrezime = txtPrezime.getDocument();
		textFieldDocPrezime.addDocumentListener(jbsc);
		Document textFieldDocDatumRodj = txtDatumRodj.getDocument();
		textFieldDocDatumRodj.addDocumentListener(jbsc);
		Document textFieldDocAdresa = txtAdresaStan.getDocument();
		textFieldDocAdresa.addDocumentListener(jbsc);
		Document textFieldDocBrojTel = txtKtkTel.getDocument();
		textFieldDocBrojTel.addDocumentListener(jbsc);
		Document textFieldDocEmailAdresa = txtEAdresa.getDocument();
		textFieldDocEmailAdresa.addDocumentListener(jbsc);
		Document textFieldDocAdresaKanc= txtAdresaKanc.getDocument();
		textFieldDocAdresaKanc.addDocumentListener(jbsc);
		Document textFieldDocBrojLicneKarte = txtBrojLicne.getDocument();
		textFieldDocBrojLicneKarte.addDocumentListener(jbsc);
		
		 
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
				if(ProfesorController.getInstance().dodajProfesora()==1)
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

class JButtonStateControllerDodajProfesora implements DocumentListener {
    private JButton button;

    JButtonStateControllerDodajProfesora(JButton b) {
        button = b;
    }

    public void changedUpdate(DocumentEvent e) {
        disableIfEmpty();
    }

    public void insertUpdate(DocumentEvent e){
        disableIfEmpty();
    }

    public void removeUpdate(DocumentEvent e){
        disableIfEmpty();
    }

    public void disableIfEmpty() {
    	if(DodajProfesora.txtIme.getText().isEmpty() || DodajProfesora.txtPrezime.getText().isEmpty() || DodajProfesora.txtDatumRodj.getText().isEmpty()
    			|| DodajProfesora.txtAdresaStan.getText().isEmpty() || DodajProfesora.txtKtkTel.getText().isEmpty() || DodajProfesora.txtEAdresa.getText().isEmpty()
    			|| DodajProfesora.txtAdresaKanc.getText().isEmpty() || DodajProfesora.txtBrojLicne.getText().isEmpty())
    		button.setEnabled(false);
    	else
    		button.setEnabled(true);

    } 
}


