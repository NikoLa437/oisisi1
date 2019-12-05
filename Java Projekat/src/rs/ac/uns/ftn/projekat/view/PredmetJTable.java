package rs.ac.uns.ftn.projekat.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class PredmetJTable extends JTable {

	private static final long serialVersionUID = -6843496177536627282L;
	public static TableModel model;
	public static int selectedRow=0;
	public static JTable jt = null;


	public PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmet());
		new ButtonColumnPredmet(this, 6);
		this.getTableHeader().setReorderingAllowed(false);
		

		jt=this;
	    model = this.getModel();
	    
	    this.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        	JTable jt = (JTable)e.getComponent();
	        	
	            if (jt.getSelectedRow() != -1)
	            	selectedRow=jt.convertRowIndexToModel(jt.getSelectedRow());
	        }
	    });
		
	    //sortiranje
		TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.getModel());
		this.setRowSorter(sorter);
		
		sorter.setSortable(6, false);
	}


	
	public static void osvezi() {
		((AbstractTableModel) model).fireTableDataChanged();
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	

}
