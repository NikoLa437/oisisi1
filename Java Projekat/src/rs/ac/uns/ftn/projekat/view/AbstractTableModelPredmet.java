package rs.ac.uns.ftn.projekat.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.projekat.data.BazaPredmet;

public class AbstractTableModelPredmet extends AbstractTableModel{

	
	private static final long serialVersionUID = -6303696363712190860L;
	
	public static String kolonaDugme = "DUGME";


	@Override
	public int getColumnCount() {
		return  BazaPredmet.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		if(BazaPredmet.indikator == 0)
			return BazaPredmet.getInstance().getPredmeti().size();
		else
			return BazaPredmet.getInstance().getFilterPredmeti().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 6)
			return BazaPredmet.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 6) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		} 
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex == 6;
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmet.getInstance().getColumnName(column);
	}
	
	// da bismo mogli prikazati dugme
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			switch (columnIndex) {
			case 0:
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				return String.class;
			case 6:
				return JButton.class;
			default:
				return null;
			}
		}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			super.setValueAt(aValue, rowIndex, columnIndex);
		}

}
