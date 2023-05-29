package SinDatabase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class AddForm  extends JFrame{
	private JPanel mainPanel;
	private JPanel topPanel;
	private DBEntry entity;
	private EntityManager entityManager;
	private JButton addButton;
	private JButton cancelButton;
	AddForm(EntityManager em, String name){
		super(name);
		this.setEntityManager(em);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(600, 300);
		
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400,400));
		mainPanel.setBackground(Color.GREEN);
		
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(400,50));
		topPanel.setBackground(Color.black);
		
		this.setLayout(new BorderLayout());
		this.add(topPanel,BorderLayout.PAGE_START);
		this.add(mainPanel,BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		for(int i =0;i<3;i++) {
			AttributeValuePanel a = new AttributeValuePanel("abobus");
			AttributeChoosePanel b = new AttributeChoosePanel("sus"); 
			mainPanel.add(a);
			mainPanel.add(b);
			b.setParentJFrame(this);
		}
		
		addButton = new JButton("ADD");
		cancelButton = new JButton("CANCEL");
		this.add(cancelButton,BorderLayout.WEST);
		this.add(addButton,BorderLayout.EAST);
		this.setVisible(true);
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	private void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public void setAddButton(JButton addButton) {
		this.addButton = addButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(JButton cancelButton) {
		this.cancelButton = cancelButton;
	}

	protected class AttributeValuePanel extends JPanel{
		private JTextPane attrNameField;
		private JTextField attrValueField;
		
		AttributeValuePanel(String attrName){
			super();
			this.setMaximumSize(new Dimension(400,40));
			this.setBackground(Color.red);
			this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			
			setAttrNameField(new JTextPane());
			this.getAttrNameField().setText(attrName);
			this.getAttrNameField().setPreferredSize(new Dimension(100, 20));
			this.getAttrNameField().setFocusable(false);;
			
			setAttrValueField(new JTextField("value"));
			this.getAttrValueField().setPreferredSize(new Dimension(200, 20));
			this.add(attrNameField);
			this.add(attrValueField);
		}
		public JTextPane getAttrNameField() {
			return attrNameField;
		}
		private void setAttrNameField(JTextPane nameField) {
			this.attrNameField = nameField;
		}
		public JTextField getAttrValueField() {
			return attrValueField;
		}
		private void setAttrValueField(JTextField valueField) {
			this.attrValueField = valueField;
		}
	}
	
	protected class AttributeChoosePanel extends JPanel{
		final private AttributeChoosePanel attributeChoosePanel = this;
		private JFrame parentJFrame;
		private JTextPane attrNameField;

		private JButton attrValueButton;

		AttributeChoosePanel(String attrName){
			super();
			this.setMaximumSize(new Dimension(400,40));
			this.setBackground(Color.red);
			this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			
			setAttrNameField(new JTextPane());
			this.getAttrNameField().setText(attrName);
			this.getAttrNameField().setPreferredSize(new Dimension(100, 20));
			this.getAttrNameField().setFocusable(false);;
			
			attrValueButton = new JButton("value");
			attrValueButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ChooseForm c = new ChooseForm(attributeChoosePanel.getParentJFrame(), null);
					
					System.out.println("was closed");
					
				}
				
			});
			this.add(attrNameField);
			this.add(attrValueButton);
			
			
			
			
		    
		    
		    
			
			
			
		}
		public JTextPane getAttrNameField() {
			return attrNameField;
		}
		private void setAttrNameField(JTextPane nameField) {
			this.attrNameField = nameField;
		}
		public JFrame getParentJFrame() {
			return parentJFrame;
		}
		public void setParentJFrame(JFrame parentJFrame) {
			this.parentJFrame = parentJFrame;
		}

	}
	
}
