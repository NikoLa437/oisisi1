package rs.ac.uns.ftn.projekat.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


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

		ToolBar toolbar = new ToolBar();
		this.add(toolbar, BorderLayout.NORTH);
        
		MenuBar myMenuBar= new MenuBar();
		this.setJMenuBar(myMenuBar);
		JPanel jp= new JPanel();
		jp.setBackground(Color.white);
		this.add(jp,BorderLayout.CENTER);
		
		StatusBar myStatusBar= new StatusBar();
		this.add(myStatusBar,BorderLayout.SOUTH);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
