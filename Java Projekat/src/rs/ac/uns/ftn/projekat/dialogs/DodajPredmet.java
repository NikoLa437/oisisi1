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

import rs.ac.uns.ftn.projekat.controllers.PredmetController;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class DodajPredmet extends JDialog{

	private static final long serialVersionUID = -5495281142892800228L;
	
	public static JTextField txtSifra;
	public static JTextField txtNaziv;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbGodStud;
	@SuppressWarnings("rawtypes")
	public static JComboBox cbSemestar;



	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DodajPredmet(JFrame parent) {
		super(parent,"Dodavanje novog predmeta",true);
		
		this.setSize(MainFrame.sirina*3/7,MainFrame.visina*3/7);
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
		bPotvrda.setEnabled(false);
		
		JButtonStateControllerDodaj jbsc = new JButtonStateControllerDodaj(bPotvrda);
		Document textFieldDocNaziv = txtNaziv.getDocument();
	    textFieldDocNaziv.addDocumentListener(jbsc);
		Document textFieldDocSifra = txtSifra.getDocument();
		textFieldDocSifra.addDocumentListener(jbsc);
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(PredmetController.getInstance().dodajPredmet() == 1)
					dispose();
			}
		});
		
		panelS.add(bOdustanak);
		panelS.add(bPotvrda);
		//test
		add(panelC,BorderLayout.NORTH);
		add(panelS,BorderLayout.SOUTH);
		
		//this.setResizable(false);
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

//klasa za osluskivanje praznih polja
class JButtonStateControllerDodaj implements DocumentListener {
    private JButton button;

    JButtonStateControllerDodaj(JButton b) {
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
    //ako je prazno polje onemoguciti pritisak na dugme
    public void disableIfEmpty() {
    	if(DodajPredmet.txtNaziv.getText().isEmpty() || DodajPredmet.txtSifra.getText().isEmpty())
    		button.setEnabled(false);
    	else
    		button.setEnabled(true);
    }
}
