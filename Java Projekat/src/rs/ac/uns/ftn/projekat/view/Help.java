package rs.ac.uns.ftn.projekat.view;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import rs.ac.uns.ftn.projekat.additionalclass.ScaleIcon;

public class Help extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ImageIcon iconAdd=ScaleIcon.ScaleIconSize("icon/addperson.png");
	ImageIcon iconEdit= ScaleIcon.ScaleIconSize("icon/penicon.png");
	ImageIcon iconDelete = ScaleIcon.ScaleIconSize("icon/deleteicon.png");
	ImageIcon iconSearch = ScaleIcon.ScaleIconSize("icon/searchicon.png");
	ImageIcon iconHelp = ScaleIcon.ScaleIconSize("icon/helpicon.png");
	ImageIcon iconAbout = ScaleIcon.ScaleIconSize("icon/abouticon.png");
	ImageIcon iconAddStudent = ScaleIcon.ScaleIconSize("icon/addperson.png"); // promeniti ikonicu
	ImageIcon iconAddDelProfesor = ScaleIcon.ScaleIconSize("icon/proficon.png");
	ImageIcon iconClose = ScaleIcon.ScaleIconSize("icon/exit.png");
	String[] columns={"Oznaka","Precica","Objasnjenje"};
	Object[][] rows={{iconAdd,"CTRL+A","Dodavanje studenta/predmeta/profesora"},{iconEdit,"CTRL+E","Izmena studenta/predmeta/profesora"}
					, {iconDelete, "CTRL+D","Brisanje studenta/predmeta/profesora"},{iconSearch, "/","Pretraga studenta/predmeta/profesora"}
					, {iconAddStudent, "/","Dodavanje studenta na predmet"},{iconAddDelProfesor, "/","Dodavanje i brisanje profesora na predmet"}
					, {iconHelp, "CTRL+H","Pomoc u vezi koriscenja programa"},{iconAbout, "CTRL+U","Opste informacije u vezi .."}
					, {iconClose, "CTRL+ X", "Izlazak iz programa"}};
	

	public Help() {
		//podesavanje Jframe
		Image Image = iconHelp.getImage();
	    this.setIconImage(Image);
		this.setSize(450,330);
		this.setTitle("Pomoc pri koriscenju programa");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		JScrollPane scrollPane = new JScrollPane();
		
		
		//table podesavanje
		JTable table= new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setColumnSelectionAllowed(false);
		table.setRowHeight(30);
		
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(50);
		columnModel.getColumn(1).setPreferredWidth(100);
		columnModel.getColumn(2).setPreferredWidth(300);
	
		scrollPane.setViewportView(table);
		
		
		this.add(scrollPane);
		this.setVisible(true);


	}
	
	DefaultTableModel model = new DefaultTableModel(rows, columns) {
	    /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Class<?> getColumnClass(int column) {
	        switch(column) {
	            case 0:return ImageIcon.class;
	            case 1: return String.class;
	            case 2: return String.class;
	            default: return Object.class;
	        }
	    }
	};
	
}
