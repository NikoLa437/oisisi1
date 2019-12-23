package rs.ac.uns.ftn.projekat.view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import rs.ac.uns.ftn.projekat.actions.CreateDeleteAction;
import rs.ac.uns.ftn.projekat.actions.CreateEditAction;
import rs.ac.uns.ftn.projekat.actions.CreateEntityAction;
import rs.ac.uns.ftn.projekat.additionalclass.ScaleIcon;
import rs.ac.uns.ftn.projekat.controllers.PredmetController;
import rs.ac.uns.ftn.projekat.controllers.ProfesorController;
import rs.ac.uns.ftn.projekat.controllers.StudentController;
import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.dialogs.DodajProfesoraNaPredmet;
import rs.ac.uns.ftn.projekat.dialogs.DodajStudentaNaPredmet;
import rs.ac.uns.ftn.projekat.dialogs.UklanjanjeProfesoraNaPredmetu;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227338301683108746L;
	static JButton studbtn;
	static JButton profbtn;
	static JTextField textField;
	ToolBar (){
		super(SwingConstants.HORIZONTAL);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // zbog look and feel-a (menja se default layout)
		
		textField = new JTextField();
		textField.setPreferredSize(new Dimension(150, textField.getPreferredSize().height));
		textField.setMaximumSize( 
			     new Dimension(textField.getPreferredSize().width, textField.getPreferredSize().height) );
		
		textField.setToolTipText("Unesite kriterijum pretrage");
        
		
		CreateEntityAction act = new CreateEntityAction();
		JButton addbtn = new JButton(act);
		addbtn.setIcon(ScaleIcon.ScaleIconSize("icon/addperson.png"));
		addbtn.setToolTipText("Add");
		addbtn.setMargin(new Insets(0, 0, 0, 0));
		addbtn.setBorder(null);
		addbtn.setOpaque(false);
		
		studbtn = new JButton();
		studbtn.setIcon(ScaleIcon.ScaleIconSize("icon/addperson.png"));
		studbtn.setToolTipText("Add Student");
		studbtn.setMargin(new Insets(0, 0, 0, 0));
		studbtn.setBorder(null);
		studbtn.setOpaque(false);
		studbtn.setVisible(false);
		
		studbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				DodajStudentaNaPredmet dpnp = new DodajStudentaNaPredmet(new JFrame());
			}
		});
		
		profbtn = new JButton();
		profbtn.setIcon(ScaleIcon.ScaleIconSize("icon/proficon.png"));
		profbtn.setToolTipText("Add/Delete Profesor");
		profbtn.setMargin(new Insets(0, 0, 0, 0));
		profbtn.setBorder(null);
		profbtn.setOpaque(false);
		profbtn.setVisible(false);
		
		
		profbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			if(BazaPredmet.getInstance().getRow(PredmetJTable.selectedRow).getProfesor().getBr_licne() != null) {
				UklanjanjeProfesoraNaPredmetu ep = new UklanjanjeProfesoraNaPredmetu(new JFrame());
			}				
			else {
				DodajProfesoraNaPredmet dpnp = new DodajProfesoraNaPredmet(new JFrame());
			}
			}
		});
		
		CreateEditAction edit_act = new CreateEditAction();
		JButton editbtn = new JButton(edit_act);
		editbtn.setIcon(ScaleIcon.ScaleIconSize("icon/penicon.png"));
		editbtn.setToolTipText("Edit");
		editbtn.setMargin(new Insets(0, 0, 0, 0));
		editbtn.setBorder(null);
		editbtn.setOpaque(false);

		CreateDeleteAction del_act = new CreateDeleteAction();
		JButton deletebtn = new JButton(del_act);
		deletebtn.setIcon(new ImageIcon("icon/deleteicon.png"));
		deletebtn.setToolTipText("Delete");
		deletebtn.setMargin(new Insets(0, 0, 0, 0));
		deletebtn.setBorder(null);
		deletebtn.setOpaque(false);
		
		JButton searchbtn = new JButton();
		searchbtn.setIcon(ScaleIcon.ScaleIconSize("icon/searchicon.png"));
		searchbtn.setToolTipText("Search");
		searchbtn.setMargin(new Insets(0, 0, 0, 0));
		searchbtn.setBorder(null);
		searchbtn.setOpaque(false);
		
		searchbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String tekst = textField.getText();
				if(JTabbedPaneTabele.selektovan_tab == 0) {
					StudentController.getInstance().pretraziStudente(tekst);
				}
				if(JTabbedPaneTabele.selektovan_tab == 1) {
					ProfesorController.getInstance().pretraziProfesora(tekst);
				}
				
				if(JTabbedPaneTabele.selektovan_tab == 2) {
					PredmetController.getInstance().PretraziPredmet(tekst);		
				}

			}
		});
		
		this.add(Box.createHorizontalStrut(5));
		this.add(addbtn);
		this.add(Box.createHorizontalStrut(10));
		this.add(editbtn);
		this.add(Box.createHorizontalStrut(10));
		this.add(deletebtn);
		this.add(Box.createHorizontalStrut(10));
		this.add(studbtn);
		this.add(Box.createHorizontalStrut(10));
		this.add(profbtn);
		this.add(Box.createHorizontalGlue());

		this.add(textField);
		this.add(Box.createHorizontalStrut(10));

		this.add(searchbtn);
		this.add(Box.createHorizontalStrut(5));

		this.setFloatable(false);
	}
	
	public static void setStudVisible() {
		studbtn.setVisible(true);
		profbtn.setVisible(true);
	}
	public static void setStudUnvisible() {
		studbtn.setVisible(false);
		profbtn.setVisible(false);
	}

}
