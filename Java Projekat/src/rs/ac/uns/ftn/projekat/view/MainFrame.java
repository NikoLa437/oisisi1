package rs.ac.uns.ftn.projekat.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;


public class MainFrame extends JFrame {
	
	private static MainFrame instance = null;
	public static int sirina;
	public static int visina;
	
	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
		}
		return instance;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MainFrame() {
		super();
		Toolkit kit = Toolkit.getDefaultToolkit(); 
		Dimension dimension = kit.getScreenSize();
		sirina = dimension.width*3/4;
		visina = dimension.height*3/4;
		this.setSize(sirina,visina);
		this.setLocationRelativeTo(null);
		this.setTitle("Studentska služba");
		ToolBar toolbar = new ToolBar();
		this.add(toolbar, BorderLayout.NORTH);
        
		MenuBar myMenuBar= new MenuBar();
		this.setJMenuBar(myMenuBar);
		ImageIcon image = new ImageIcon("icon/mainIcon.png");
		Image i = image.getImage();
		this.setIconImage(i);
		
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
				 MainFrame.getInstance().appTurnOff();
			  }
			});
		
		this.setVisible(true);

	}
	
	public void appTurnOff() {
		 String[] options = {"Da", "Ne"};
		    int confirmed = JOptionPane.showOptionDialog(null, 
		        "Da li ste sigurni da zelite da ugasite program?", "Napustanje programa",
		        JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[1]);

		    if (confirmed == JOptionPane.YES_OPTION) {
		    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    	BazaPredmet.getInstance().serialize();
		    	BazaStudent.getInstance().serialize();
		    	BazaProfesor.getInstance().serialize();
		    }
		    else{
             setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
         }
	}
}
