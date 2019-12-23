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

import rs.ac.uns.ftn.projekat.dialogs.DetaljiProfesor;

public class ButtonColumnDetaljiProfesora extends AbstractCellEditor
											implements TableCellRenderer, TableCellEditor, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3058285665120865249L;
	
	// dugme koje se iscrtava
			private JButton renderButton;
			// dugme koje obradjuje akciju
			private JButton editorButton;
			// referenca na tabelu
			private JTable table;
			// da li je aktivno editovanje celije tabele
			// (da li se obradjuju dogadjaji pritiska misa)
			private boolean isEditorActive = false;
			
			public ButtonColumnDetaljiProfesora(JTable table, int column) {
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
				
				this.renderButton.setToolTipText("Detalji profesora");
				this.renderButton.setBorder(null);
				this.renderButton.setOpaque(false);
				this.renderButton.setContentAreaFilled(false);
				this.renderButton.setBorderPainted(false);
				
				
				this.editorButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped();
						DetaljiProfesor dp = new DetaljiProfesor(new JFrame());
					}
				});

				this.isEditorActive = false;
			}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		return new ProfesorTablePanel(this.editorButton, 50, 50);

	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		return new ProfesorTablePanel(this.renderButton, 50, 50);

	}

}
