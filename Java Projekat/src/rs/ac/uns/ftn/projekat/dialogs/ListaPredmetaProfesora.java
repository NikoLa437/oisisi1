package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Profesor;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;

public class ListaPredmetaProfesora extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4543268701897695684L;

	public ListaPredmetaProfesora(JFrame parent, int selected) {
		super(parent,"Lista studenata",true);
		
		this.setSize(300,200);
		this.setLayout(new BorderLayout());

		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  
		
		Button bIzlaz=new Button("Izlaz");
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		Profesor p = BazaProfesor.getInstance().getRow(selected);
		ArrayList<Predmet> listaPredmeta= new ArrayList<Predmet>();
		listaPredmeta= p.getPredmeti();
		

		for(Predmet pr : listaPredmeta) {
			listModel.addElement(pr.getNaziv());
		}


		JList<String> lista = new JList<>(listModel);
		lista.setFixedCellWidth(100);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lista.setVisibleRowCount(5);
			
		bIzlaz.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		//lista.setPreferredSize(new Dimension(280, 180));
		JScrollPane sp = new JScrollPane(lista);
		sp.setPreferredSize(new Dimension(280, 180));
		
		
		panelS.add(bIzlaz);
		
		//this.add(p1,BorderLayout.NORTH);
		this.add(sp,BorderLayout.CENTER);
		
		this.add(panelS,BorderLayout.SOUTH);
		this.setTitle("Lista Predmeta");  
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
