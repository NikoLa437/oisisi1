package rs.ac.uns.ftn.projekat.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import rs.ac.uns.ftn.projekat.data.BazaPredmet;


public class PredmetJTable extends JTable {

	private static final long serialVersionUID = -6843496177536627282L;
	public static TableModel model;
	public static int selectedRow=-1;
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
	    
	  //sortiranje
	  		TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.getModel());
	  		this.setRowSorter(sorter);
	  		
	  		sorter.setSortable(6, false);
	    
	    this.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseReleased(MouseEvent e) {
	        	JTable jt = (JTable)e.getComponent();
	        	if(BazaPredmet.indikator == 0) {
		            if (jt.getSelectedRow() != -1)
		            	selectedRow=jt.convertRowIndexToModel(jt.getSelectedRow());
	        	}else
	        	{
	        		if (jt.getSelectedRow() != -1)
		            	selectedRow= BazaPredmet.getInstance().getRealRowForFilter(jt.convertRowIndexToModel(jt.getSelectedRow()));
	        	}
            	//selectedRow = jt.getSelectedRow();

	        	 
	        }
	    });
	   
		
	    

	}

	
	public static void osvezi() {
		((AbstractTableModel) model).fireTableDataChanged();
		PredmetJTable.selectedRow = -1;
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
