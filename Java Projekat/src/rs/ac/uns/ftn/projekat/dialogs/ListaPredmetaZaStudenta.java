package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.MainFrame;


public class ListaPredmetaZaStudenta extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaPredmetaZaStudenta(JFrame parent,int selrow) {
		super(parent,"Lista studenata",true);
		
		this.setSize(MainFrame.sirina*2/7,MainFrame.visina*3/7);
		this.setLayout(new BorderLayout());
		//paneli p1 i p2 da naprave razmak
		JPanel p1= new JPanel();
		p1.setPreferredSize(new Dimension(30,20));
		JPanel p2= new JPanel();
		p2.setPreferredSize(new Dimension(30,20));
		JPanel panelC = new JPanel(new FlowLayout(FlowLayout.CENTER));  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		JButton bOdustani=new JButton("Odustani");
		
		///////////////////////////////////////////////////////////////
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		ArrayList<Predmet> listaPredmeta = BazaStudent.getInstance().getRow(selrow).getPredmeti();
		
		for(Predmet p : listaPredmeta) {
			listModel.addElement(p.getNaziv());
		}

		JList<String> lista = new JList<>(listModel);
		lista.setFixedCellWidth(200);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lista.setVisibleRowCount(8);
		
		bOdustani.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panelC.add(new JScrollPane(lista));
		panelC.add(lista);
		
		panelC.add(new JScrollPane(lista));
		
		panelS.add(bOdustani);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(panelC,BorderLayout.CENTER);
		
		this.add(panelS,BorderLayout.SOUTH);
		this.setTitle("Lista predmeta");  
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
