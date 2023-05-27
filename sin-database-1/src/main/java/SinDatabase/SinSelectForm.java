package SinDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SinSelectForm extends JFrame {
	private SinSelectPanel selectPanel;
	public SinSelectPanel getSelectPanel() {
		return selectPanel;
	}

	private JButton selectButton;
	public JButton getSelectButton() {
		return selectButton;
	}
	
	private JPanel mainPanel;
	public SinSelectForm(){
		super("Select");
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setSize(400, 100);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		selectPanel = new SinSelectPanel();
		selectButton = new JButton("SELECT");
		selectButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(selectPanel.createHQLQuery());
				
			}
			
		});
		
		mainPanel.add(selectPanel);
		mainPanel.add(selectButton);
				
		this.add(mainPanel);
		
		
		this.setVisible(true);
	}
}
