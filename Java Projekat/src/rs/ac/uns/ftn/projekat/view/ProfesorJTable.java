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

import rs.ac.uns.ftn.projekat.data.BazaProfesor;

public class ProfesorJTable extends JTable{

	private static final long serialVersionUID = -4634202201266755582L;
	public static int selectedRow=0; // zbog izmene i sortiranja dodao Nikola
	public static JTable jt = null;
	public static TableModel model;
	
	public ProfesorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfesor());
		new ButtonColumnDetaljiProfesora(this, 6);
		new ButtonColumnPredmetiProfesora(this, 7);

		this.getTableHeader().setReorderingAllowed(false);
		
		// sortiranje edit Nikola
			TableRowSorter<TableModel> sorter = new TableRowSorter<>(this.getModel());
			this.setRowSorter(sorter);
			jt= this;
			model= this.getModel();
			
			sorter.setSortable(6, false);
			sorter.setSortable(7, false);

			
			this.addMouseListener(new MouseAdapter() {
		        @Override
		        public void mouseReleased(MouseEvent e) {
		        	JTable jt = (JTable)e.getComponent();
		        	if(BazaProfesor.indikator == 0) {
			        	if (jt.getSelectedRow() != -1)
			        		selectedRow=jt.convertRowIndexToModel(jt.getSelectedRow());
		        	}else {
		        		if (jt.getSelectedRow() != -1)
			        		selectedRow= BazaProfesor.getInstance().getRealRowForFilter(jt.convertRowIndexToModel(jt.getSelectedRow()));
		   
		        	}
		        }
		    });
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
