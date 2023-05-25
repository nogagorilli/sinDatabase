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
		
		tableChooser = new TableChooseMenu();
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(tableChooser);
		this.add(menuBar);
				
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
