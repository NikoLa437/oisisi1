package rs.ac.uns.ftn.projekat.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.dialogs.DetaljiStudenta;

public class ButtonColumnDetaljiStudent extends AbstractCellEditor	implements TableCellRenderer, TableCellEditor, MouseListener{

	private static final long serialVersionUID = 1L;
	// dugme koje se iscrtava
	private JButton renderButton;
	// dugme koje obradjuje akciju
	private JButton editorButton;
	// referenca na tabelu
	private JTable table;
	private boolean isEditorActive = false;
			
	public ButtonColumnDetaljiStudent(JTable table, int column) {
		// povezivanje sa tabelom
		this.table = table;
		// nacin iscrtavanje celije
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		// nacin editovanja celije
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		// dugme koje ce biti iscrtavanp
		this.renderButton = new JButton("Detalji");
		this.editorButton = new JButton("Detalji");
				
		this.renderButton.setToolTipText("Detalji studenta");
		this.renderButton.setBorder(null);
		this.renderButton.setOpaque(false);
		this.renderButton.setContentAreaFilled(false);
		this.renderButton.setBorderPainted(false);
				
				
		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				int indeks = 0;
				if(BazaStudent.indikator == 0)
					indeks = table.convertRowIndexToModel(table.getSelectedRow());
				else
					indeks = BazaStudent.getInstance().getRealRowForFilter(table.convertRowIndexToModel(table.getSelectedRow()));
				@SuppressWarnings("unused")
				DetaljiStudenta ds = new DetaljiStudenta(new JFrame(), table.convertRowIndexToModel(indeks));
			}
		});

		this.isEditorActive = false;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return new StudentTablePanel(this.editorButton, 50, 50);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return new StudentTablePanel(this.renderButton, 50, 50);
	}

}
