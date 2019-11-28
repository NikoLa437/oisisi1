package rs.ac.uns.ftn.projekat.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PredmetTablePanel  extends JPanel{

	private static final long serialVersionUID = -6455161004148149848L;
	
	private JPanel leftPanel = new JPanel();
	//private Component c;
	private JPanel rightPanel = new JPanel();
	
	
	public PredmetTablePanel() {
		setLayout(new BorderLayout());
		add(leftPanel, BorderLayout.WEST);
		leftPanel.setBackground(Color.LIGHT_GRAY);
		add(rightPanel, BorderLayout.EAST);
		rightPanel.setBackground(Color.LIGHT_GRAY);
	}

	public PredmetTablePanel(Component c, int leftGap, int rightGap) {
		this();
		leftPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		rightPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		JButton b = (JButton) c;
		b.setToolTipText("Prikazi Studente");
		b.setBorder(null);
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		add(b, BorderLayout.CENTER);
			
	}
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(bg);
		if (leftPanel == null || rightPanel == null) 
			return;
		leftPanel.setBackground(bg);
		rightPanel.setBackground(bg);
	}
}
