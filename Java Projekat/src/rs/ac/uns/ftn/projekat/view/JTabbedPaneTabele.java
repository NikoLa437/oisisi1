package rs.ac.uns.ftn.projekat.view;

import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class JTabbedPaneTabele extends JTabbedPane {


	private static final long serialVersionUID = 6359401644771337741L;
	public static int selektovan_tab = 0;
	
	public JTabbedPaneTabele() {
					
		super();
		ProfesorJTable tabelaProfesor = new ProfesorJTable();
		JScrollPane scrollPaneProf = new JScrollPane(tabelaProfesor);
		scrollPaneProf.setBorder(new EmptyBorder(30, 20, 10, 20));

		
		PredmetJTable tabelaPredmet= new PredmetJTable();		
		JScrollPane scrollPanePr = new JScrollPane(tabelaPredmet);		
		scrollPanePr.setBorder(new EmptyBorder(30, 20, 10, 20));
		
		StudentJTable tabelaStudent = new StudentJTable();
		JScrollPane scroolPaneSt = new JScrollPane(tabelaStudent);
		scroolPaneSt.setBorder(new EmptyBorder(30,20,10,20));
		
		this.addTab("Student", null,scroolPaneSt,"Student");
		this.addTab("Profesor", null,scrollPaneProf,"Profesor");
		this.addTab("Predmet", null,scrollPanePr,"Predmet");

		this.addChangeListener(new ChangeListener() {

			// This method is called whenever the selected tab changes

			@Override
			public void stateChanged(ChangeEvent evt) {
				
			    JTabbedPane tabbedPane = (JTabbedPane)evt.getSource();
			    selektovan_tab = tabbedPane.getSelectedIndex();
			    if(selektovan_tab == 2) {
			    	ToolBar.setStudVisible();
			    }
			    else
			    {
			    	ToolBar.setStudUnvisible();
			    }

			}

		
		    });
		
		}
		
		

	@Override
	public void addTab(String title,Icon icon, Component component, String tip) {
		super.addTab(title, icon, component, tip);
		int count = this.getTabCount() - 1;
		setTabComponentAt(count, null);
	}
	
	@Override
	public void addTab(String title, Icon icon, Component component) {
		addTab(title, icon, component, null);
	}

	@Override
	public void addTab(String title, Component component) {
		addTab(title, null, component);
	}
}
