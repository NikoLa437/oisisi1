package rs.ac.uns.ftn.projekat.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension dimension = kit.getScreenSize();
		this.setSize(dimension.width*3/4,dimension.height*3/4);
		this.setLocationRelativeTo(null);
		this.setTitle("Studentska služba");
		ToolBar toolbar = new ToolBar();
		this.add(toolbar, BorderLayout.NORTH);
        
		MenuBar myMenuBar= new MenuBar();
		this.setJMenuBar(myMenuBar);
		
		
//		JPanel jp= new JPanel();
//		jp.setBackground(Color.white);
//		this.add(jp,BorderLayout.CENTER);
		
		StatusBar myStatusBar= new StatusBar();
		this.add(myStatusBar,BorderLayout.SOUTH);
		
		
		JTabbedPaneTabele tabovi = new JTabbedPaneTabele();
		this.add(tabovi, BorderLayout.CENTER);
		
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			  public void windowClosing(WindowEvent e) {
				  String[] options = {"Da", "Ne"};
			    int confirmed = JOptionPane.showOptionDialog(null, 
			        "Da li ste sigurni da zelite da ugasite program?", "Napustanje programa",
			        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			    }
			    else{
                    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                }
			  }
			});
	}
}
