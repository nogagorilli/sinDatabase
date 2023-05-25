package SinDatabase;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class SinSelectForm extends JFrame {
	private TableChooseMenu tableChooser;
	private JPanel mainPanel;
	public SinSelectForm(){
		super("Select");
		this.setSize(600,300);
		mainPanel = new JPanel();
		mainPanel.setSize(400, 100);
		mainPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		WherePanel w;
		
		w = new WherePanel();
		w.setAttributeChooser(new AttributeChooseMenu.CirclesMenu("circles"));
		mainPanel.add(w);
			
		w = new WherePanel();
		w.setAttributeChooser(new AttributeChooseMenu.SinMenu("sins"));
		mainPanel.add(w);

		w = new WherePanel();
		w.setAttributeChooser(new AttributeChooseMenu.SinnerMenu("sinners"));
		mainPanel.add(w);
		
		w = new WherePanel();
		w.setAttributeChooser(new AttributeChooseMenu.SinInstancesMenu("sin instances"));
		mainPanel.add(w);
		
		w = new WherePanel();
		w.setAttributeChooser(new AttributeChooseMenu.DemonMenu("demons"));
		mainPanel.add(w);
		
				
		this.add(mainPanel);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
