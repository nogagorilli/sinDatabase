package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import sinDatabase.SinObjectModel;

abstract class QueryForm extends JFrame {
	private QueryPanel queryPanel;
	public QueryPanel getQueryPanel() {
		return queryPanel;
	}
	
	private JButton queryButton;
	protected SinObjectModel objectModel = null;
	
	public void setQueryPanel(QueryPanel panel) {
		mainPanel.removeAll();
		this.queryPanel = panel;
		
		mainPanel.add(this.queryPanel);
		mainPanel.add(queryButton);
		
		this.revalidate();
		this.repaint();
		
	}
	public JButton getQueryButton() {
		return queryButton;
	}
	
	private JPanel mainPanel;
	public QueryForm(String s, SinObjectModel objectModel){
		super(s);
		this.objectModel = objectModel;
		this.setSize(600,300);
		this.setLocation(500, 400);
		this.setAlwaysOnTop(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setSize(400, 100);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		queryPanel = new SinSelectPanel(objectModel);
		queryButton = new JButton("SELECT");
		queryButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(queryPanel.createHQLQuery());
				
			}
			
		});
		mainPanel.add(queryButton);
				
		this.add(mainPanel);
		
		
		this.setVisible(true);
	}
}
