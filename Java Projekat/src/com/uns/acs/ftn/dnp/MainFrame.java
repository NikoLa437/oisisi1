package com.uns.acs.ftn.dnp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
		super();
		this.setSize(700,450);

        
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
