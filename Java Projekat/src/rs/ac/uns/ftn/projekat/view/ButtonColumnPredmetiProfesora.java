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
import rs.ac.uns.ftn.projekat.dialogs.ListaPredmetaProfesora;

public class ButtonColumnPredmetiProfesora extends AbstractCellEditor
											implements TableCellRenderer, TableCellEditor, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5835816018903381575L;

	
	private JButton renderButton;
	// dugme koje obradjuje akciju
	private JButton editorButton;
	// referenca na tabelu
	private JTable table;
	// da li je aktivno editovanje celije tabele
	// (da li se obradjuju dogadjaji pritiska misa)
	private boolean isEditorActive = false;

	public ButtonColumnPredmetiProfesora(JTable table, int column) {
		// povezivanje sa tabelom
		this.table = table;
		// nacin iscrtavanje celije
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		// nacin editovanja celije
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);

		// dugme koje ce biti iscrtavanp
		this.renderButton = new JButton("Prikazi");
		this.editorButton = new JButton("Prikazi");
		
		this.renderButton.setToolTipText("Prikazi predmete");
		this.renderButton.setBorder(null);
		this.renderButton.setOpaque(false);
		this.renderButton.setContentAreaFilled(false);
		this.renderButton.setBorderPainted(false);
		
		
		this.editorButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				int indeks = 0;
				if(BazaProfesor.indikator == 0)
					indeks = table.convertRowIndexToModel(table.getSelectedRow());
				else
					indeks = BazaProfesor.getInstance().getRealRowForFilter(table.convertRowIndexToModel(table.getSelectedRow()));
				
				@SuppressWarnings("unused")
				ListaPredmetaProfesora lpp = new ListaPredmetaProfesora(new JFrame(),indeks);
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
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		return new PredmetTablePanel(this.editorButton, 0, 0);

	}

	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		return new PredmetTablePanel(this.renderButton, 0, 0);
	}

}
