package rs.ac.uns.ftn.dn;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar{
	
	/**
	 *  JOS AKCIJE DA SE DODAJU , DIZAJN ZAVRSEN
	 */
	private static final long serialVersionUID = 1L;

	public MenuBar() {
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
	
		JMenuItem miNew = new JMenuItem("New",new ImageIcon("icon/addicon.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close",new ImageIcon("icon/exiticon.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		
		JMenuItem miEdit = new JMenuItem("Edit",new ImageIcon("icon/editicon.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem miDelete = new JMenuItem("Delete",new ImageIcon("icon/deleteicon.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

		
		JMenuItem miHelp = new JMenuItem("Help",new ImageIcon("icon/helpicon.png"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem miAbout = new JMenuItem("About",new ImageIcon("icon/abouticon.png"));	
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));


		
		file.add(miNew);
		file.add(miClose);
		
		edit.add(miEdit);
		edit.add(miDelete);
		
		help.add(miHelp);
		help.add(miAbout);
		
		this.add(file);
		this.add(edit);
		this.add(help);
	}
}