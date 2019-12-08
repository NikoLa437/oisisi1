package rs.ac.uns.ftn.projekat.dialogs;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rs.ac.uns.ftn.projekat.classes.Predmet;
import rs.ac.uns.ftn.projekat.classes.Student;
import rs.ac.uns.ftn.projekat.controllers.StudentController;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.PredmetJTable;

public class ListaStudenataNaPredmetu extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String selRow = "";
	
	public ListaStudenataNaPredmetu(JFrame parent) {
		super(parent,"Lista studenata",true);
		
		//String selektovaniIndeks="";
		this.setSize(300,200);
		this.setLayout(new BorderLayout());

		JPanel p1= new JPanel();
		p1.setPreferredSize(new Dimension(30,20));
		JPanel p2= new JPanel();
		p2.setPreferredSize(new Dimension(30,20));
		JPanel panelC = new JPanel(new FlowLayout(FlowLayout.CENTER));  // panel za unos 
		JPanel panelS = new JPanel(new FlowLayout(FlowLayout.RIGHT));  // panel za button-e
		
		Button bObrisi=new Button("Obrisi");
		Button bOdustani=new Button("Odustani");
		
		///////////////////////////////////////////////////////////////
		DefaultListModel<String> listModel = new DefaultListModel<>();
		
		Predmet p = BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow);
		ArrayList<Student> listaStudenata= new ArrayList<Student>();
		listaStudenata= p.getStudenti();
		
		
		for(Student s : listaStudenata) {
			listModel.addElement(s.getIndeks());
		}


		JList<String> lista = new JList<>(listModel);
		lista.setFixedCellWidth(100);
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lista.setBorder(BorderFactory.createLineBorder(Color.black));
		
		lista.setVisibleRowCount(5);
		////////////////////////////////////////////////////////////////
		
		lista.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				if (!e.getValueIsAdjusting()) {
					selRow = lista.getSelectedValue();
	             }
			}
			
		});
		
		
		bOdustani.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		bObrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(listModel.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Ne postoji student na predmetu kojeg mozete izbrisati", "Error", JOptionPane.ERROR_MESSAGE );
					//dispose();
					}
				else {
					
				StudentController.getInstance().brisanjeStudentaSaPredmeta(p);
				listModel.removeElement(selRow);
				lista.updateUI();
				PredmetJTable.osvezi();
				}
			}
		});
		
		panelC.add(new JScrollPane(lista));
		panelC.add(lista);
		
		panelC.add(new JScrollPane(lista));
		
		panelS.add(bOdustani);
		panelS.add(bObrisi);
		
		this.add(p1,BorderLayout.NORTH);
		this.add(panelC,BorderLayout.CENTER);
		
		this.add(panelS,BorderLayout.SOUTH);
		this.setTitle("Lista studenata");  
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}	
}
