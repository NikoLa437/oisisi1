package rs.ac.uns.ftn.projekat.additionalclass;

import java.awt.Component;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class DateCellRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
		super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		DateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");
		String date= dateFormat.format((Date) value);
		this.setText(date);
		return this;
	}

}
