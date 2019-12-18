package rs.ac.uns.ftn.projekat.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;

public class AbstractTableModelStudent extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudent.getInstance().getColumnName(column);
	}
}
