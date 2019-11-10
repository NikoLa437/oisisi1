package rs.ac.uns.ftn.dn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel{
	/**
	 * ZAVRSEN	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		super();
		setLayout(new BorderLayout());

		Label studentska_sluzba=new Label("Studentska sluzba");
		
		Date date2= new Date();
		SimpleDateFormat format_datuma = new SimpleDateFormat("HH:mm:ss   dd.MM.yyyy. ");
		Label timedate=new Label(format_datuma.format(date2));
		
		Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	Date date= new Date();
            	timedate.setText(format_datuma.format(date));
            	}
            });
		timer.start();
		this.add(studentska_sluzba, BorderLayout.WEST);
		this.add(timedate, BorderLayout.EAST);
	}
}
