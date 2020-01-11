package rs.ac.uns.ftn.projekat.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import rs.ac.uns.ftn.projekat.actions.CreateDeleteAction;
import rs.ac.uns.ftn.projekat.actions.CreateEditAction;
import rs.ac.uns.ftn.projekat.actions.CreateEntityAction;
import rs.ac.uns.ftn.projekat.additionalclass.ScaleIcon;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;

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
		CreateEntityAction ac = new CreateEntityAction();
		JMenuItem miNew = new JMenuItem();
		miNew.setAction(ac);
		miNew.setText("New");
		miNew.setIcon(ScaleIcon.ScaleIconSize("icon/addperson.png"));
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close",ScaleIcon.ScaleIconSize("icon/exit.png"));
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
		
		CreateEditAction ed= new CreateEditAction();
		JMenuItem miEdit = new JMenuItem();
		miEdit.setAction(ed);
		miEdit.setText("Edit");
		miEdit.setIcon(ScaleIcon.ScaleIconSize("icon/penicon.png"));
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));

		
		CreateDeleteAction da = new CreateDeleteAction();
		JMenuItem miDelete = new JMenuItem();
		miDelete.setAction(da);
		miDelete.setText("Delete");
		miDelete.setIcon(ScaleIcon.ScaleIconSize("icon/deleteicon.png"));
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		

		JMenuItem miHelp = new JMenuItem("Help",ScaleIcon.ScaleIconSize("icon/helpicon.jpg"));
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem miAbout = new JMenuItem("About",ScaleIcon.ScaleIconSize("icon/abouticon.jpg"));	
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));

		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Help h= new Help();
			}
		});
		
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About a=new About();
			}
			
		});
		
		miClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] options = {"Da", "Ne"};
			    int confirmed = JOptionPane.showOptionDialog(null, 
			        "Da li ste sigurni da zelite da ugasite program?", "Napustanje programa",
			        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	BazaPredmet.getInstance().serialize();
			    	BazaStudent.getInstance().serialize();
			    	BazaProfesor.getInstance().serialize();
					System.exit(1);
			    }
			   
			}			
			
		});
		
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