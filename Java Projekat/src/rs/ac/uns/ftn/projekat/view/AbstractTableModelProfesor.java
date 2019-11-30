package rs.ac.uns.ftn.projekat.view;

import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.projekat.data.BazaProfesor;

public class AbstractTableModelProfesor  extends AbstractTableModel{

	private static final long serialVersionUID = -4564009147876456382L;

	@Override
	public int getColumnCount() {
		return BazaProfesor.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return  BazaProfesor.getInstance().getProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaProfesor.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaProfesor.getInstance().getColumnName(column);
	}

}
