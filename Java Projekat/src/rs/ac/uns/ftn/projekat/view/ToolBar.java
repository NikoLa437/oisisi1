package rs.ac.uns.ftn.projekat.view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import rs.ac.uns.ftn.projekat.actions.CreateEntityAction;
import rs.ac.uns.ftn.projekat.additionalclass.ScaleIcon;

public class ToolBar extends JToolBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4227338301683108746L;
	static JButton studbtn;
	static JButton profbtn;

	ToolBar (){
		super(SwingConstants.HORIZONTAL);
				
		JTextField textField = new JTextField();
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
		
		profbtn = new JButton();
		profbtn.setIcon(ScaleIcon.ScaleIconSize("icon/proficon.png"));
		profbtn.setToolTipText("Add Profesor");
		profbtn.setMargin(new Insets(0, 0, 0, 0));
		profbtn.setBorder(null);
		profbtn.setOpaque(false);
		profbtn.setVisible(false);
		
		JButton editbtn = new JButton();
		editbtn.setIcon(ScaleIcon.ScaleIconSize("icon/penicon.png"));
		editbtn.setToolTipText("Edit");
		editbtn.setMargin(new Insets(0, 0, 0, 0));
		editbtn.setBorder(null);
		editbtn.setOpaque(false);

		
		JButton deletebtn = new JButton();
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
