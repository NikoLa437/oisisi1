package rs.ac.uns.ftn.projekat.view.dialogs;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.controllers.PredmetController;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.view.MainFrame;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class DodajProfesoraNaPredmet extends JDialog{


	private static final long serialVersionUID = -4852567883901855950L;
	
	public static JTextField txtLicna;
	
	public DodajProfesoraNaPredmet(JFrame parent) {
		super(parent,"Dodavanje profesora na predmet",true);
		
		Predmet pr = BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow);
		
		this.setSize(MainFrame.sirina*3/7,MainFrame.visina/4);
		//this.setSize(400,120);
		this.setLayout(new BorderLayout());
		
		JPanel panelC = new JPanel(new GridBagLayout());  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JLabel lblLicna = new JLabel("Broj licne karte profesora*");
		txtLicna = new JTextField();
		
		
		GridBagConstraints gbcL= new GridBagConstraints();
		gbcL.gridx = 0;
		gbcL.gridy = 0;
		gbcL.gridwidth = 1;
		gbcL.anchor = GridBagConstraints.WEST;
		gbcL.insets = new Insets(10, 20, 0, 0);
		panelC.add(lblLicna, gbcL);
		
		GridBagConstraints gbcT= new GridBagConstraints();
		gbcT.gridx = 1;
		gbcT.gridy = 0;
		gbcT.gridwidth = 3;
		gbcT.weightx = 100;
		gbcT.fill = GridBagConstraints.HORIZONTAL;
		gbcT.insets = new Insets(10, 20, 0, 20);
		panelC.add(txtLicna, gbcT);
		
		
		JButton bPotvrda = new JButton("Potvrda");
		JButton bOdustanak = new JButton("Odustanak");
		bPotvrda.setEnabled(false);
		
		JButtonStateControllerDPNP jbsc = new JButtonStateControllerDPNP(bPotvrda);
		Document textFieldDocNaziv = txtLicna.getDocument();
	    textFieldDocNaziv.addDocumentListener(jbsc);
		
		bOdustanak.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bPotvrda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(PredmetController.getInstance().dodajProfesoraNaPredmet(pr) == 1)
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
}
//klasa za osluskivanje praznog polja
class JButtonStateControllerDPNP implements DocumentListener {
    private JButton button;

    JButtonStateControllerDPNP(JButton b) {
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
    	if(DodajProfesoraNaPredmet.txtLicna.getText().isEmpty())
    		button.setEnabled(false);
    	else
    		button.setEnabled(true);
    }
}
