package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import rs.ac.uns.ftn.projekat.controllers.StudentController;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class DodajStudenta extends JDialog{
	
	/**
	 * 
	 *
	 */
	public static JTextField txtIme;
	public static JTextField txtPrezime;
	public static JTextField txtDatumRodj;
	public static JTextField txtAdresa;
	public static JTextField txtBrojTel;
	public static JTextField txtBrojInd;
	public static JTextField txteadresa;
	public static JTextField txtdatumUpisa;
	public static JTextField txtprosecnaOcena;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbGodStud;
	public static JRadioButton rbBudzet;
	public static JRadioButton rbSamof;
	
	private static final long serialVersionUID = 1L;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DodajStudenta(JFrame parent) {
		super(parent,"Dodavanje novog studenta",true);
		
		this.setSize(MainFrame.sirina*3/7,MainFrame.visina*3/4);
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
	     cbGodStud = new JComboBox(sGodStud);
	
		 rbBudzet = new JRadioButton("Budzet");
		 rbSamof = new JRadioButton("Samofinansiranje");

		ButtonGroup btnGroup1 = new ButtonGroup();
		   btnGroup1.add(rbBudzet);
		   btnGroup1.add(rbSamof);

		rbBudzet.setSelected(true);
	
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
		
		JButton bPotvrda = new JButton("Potvrda");
		JButton bOdustanak = new JButton("Odustanak");
		bPotvrda.setEnabled(false);
		
		
		//disable dugmeta 
		JButtonStateControllerDodajStudenta jbsc = new JButtonStateControllerDodajStudenta(bPotvrda);
		Document textFieldDocIme = txtIme.getDocument();
		textFieldDocIme.addDocumentListener(jbsc);
		Document textFieldDocPrezime = txtPrezime.getDocument();
		textFieldDocPrezime.addDocumentListener(jbsc);
		Document textFieldDocDatumRodj = txtDatumRodj.getDocument();
		textFieldDocDatumRodj.addDocumentListener(jbsc);
		Document textFieldDocAdresa = txtAdresa.getDocument();
		textFieldDocAdresa.addDocumentListener(jbsc);
		Document textFieldDocBrojTel = txtBrojTel.getDocument();
		textFieldDocBrojTel.addDocumentListener(jbsc);
		Document textFieldDocBrojInd = txtBrojInd.getDocument();
		textFieldDocBrojInd.addDocumentListener(jbsc);
		Document textFieldDocEmailAdresa = txteadresa.getDocument();
		textFieldDocEmailAdresa.addDocumentListener(jbsc);
		Document textFieldDocDatumUpisa = txtdatumUpisa.getDocument();
		textFieldDocDatumUpisa.addDocumentListener(jbsc);
		Document textFieldDocProsecnaOcena = txtprosecnaOcena.getDocument();
		textFieldDocProsecnaOcena.addDocumentListener(jbsc);
		
		
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
				
				if(StudentController.getInstance().dodajStudenta()==1)
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

class JButtonStateControllerDodajStudenta implements DocumentListener {
    private JButton button;

    JButtonStateControllerDodajStudenta(JButton b) {
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
    	if(DodajStudenta.txtIme.getText().isEmpty() || DodajStudenta.txtPrezime.getText().isEmpty() || DodajStudenta.txtDatumRodj.getText().isEmpty()
    			|| DodajStudenta.txtAdresa.getText().isEmpty() || DodajStudenta.txtBrojTel.getText().isEmpty() || DodajStudenta.txtBrojInd.getText().isEmpty()
    			|| DodajStudenta.txteadresa.getText().isEmpty() || DodajStudenta.txtdatumUpisa.getText().isEmpty() 
    			|| DodajStudenta.txtprosecnaOcena.getText().isEmpty())
    		button.setEnabled(false);
    	else
    		button.setEnabled(true);

    } 
}

