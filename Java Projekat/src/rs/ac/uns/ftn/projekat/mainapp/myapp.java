package rs.ac.uns.ftn.projekat.mainapp;

import rs.ac.uns.ftn.projekat.data.BazaPredmet;
import rs.ac.uns.ftn.projekat.data.BazaProfesor;
import rs.ac.uns.ftn.projekat.data.BazaStudent;
import rs.ac.uns.ftn.projekat.view.MainFrame;

public class myapp {

	public static void main(String[] args) {
		
//		try {
//            // Set cross-platform Java L&F (also called "Metal")
//        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//    } 
//    catch (Exception e) {
//       // handle exception
//    }
//		
		BazaStudent.getInstance().deserialize();
		BazaProfesor.getInstance().deserialize();
		BazaPredmet.getInstance().deserialize();
		MainFrame.getInstance();
	
		
	//	IzmeniStudenta is=new IzmeniStudenta(mf);
		
	
	}

}
