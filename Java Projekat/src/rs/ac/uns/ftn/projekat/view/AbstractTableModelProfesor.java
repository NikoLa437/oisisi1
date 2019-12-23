package rs.ac.uns.ftn.projekat.view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;

public class AbstractTableModelProfesor  extends AbstractTableModel{

	private static final long serialVersionUID = -4564009147876456382L;
	
	public static String kolonaDugme = "DUGME";


	@Override
	public int getColumnCount() {
		return BazaProfesor.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		if(BazaProfesor.indikator == 0)
			return  BazaProfesor.getInstance().getProfesori().size();
		else
			return BazaProfesor.getInstance().getFilterProfesori().size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex < 6)
			return BazaProfesor.getInstance().getValueAt(rowIndex, columnIndex);
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
	public String getColumnName(int column) {
		return BazaProfesor.getInstance().getColumnName(column);
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
			return String.class;
		case 6:
		case 7:
			return JButton.class;
		default:
			return null;
		}
	}
}
