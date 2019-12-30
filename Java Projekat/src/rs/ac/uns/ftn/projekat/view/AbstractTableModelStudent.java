package rs.ac.uns.ftn.projekat.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String kolonaDugme = "DUGME";
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		if(BazaStudent.indikator == 0)
			return  BazaStudent.getInstance().getStudenti().size();
		else
			return BazaStudent.getInstance().getPretrazeni().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return  BazaStudent.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		//return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
		if (columnIndex < 6)
			return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
		else if (columnIndex == 6 || columnIndex == 7) {
			JButton btn = new JButton("" + rowIndex);
			return btn;
		} 
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return (columnIndex == 6 || columnIndex == 7);
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			return JButton.class;
		case 7:
			return JButton.class;
		default:
			return null;
		}
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}
}
