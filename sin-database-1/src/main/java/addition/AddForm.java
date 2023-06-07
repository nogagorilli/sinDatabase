package addition;

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

import entities.DBEntry;
import selection.ChooseForm;
import sinDatabase.SinObjectModel;

public abstract class AddForm  extends JFrame{
	protected JPanel mainPanel;
	private JPanel topPanel;
	private DBEntry entity;
	private SinObjectModel objectModel;
	
	public SinObjectModel getObjectModel() {
		return objectModel;
	}


	private void setObjectModel(SinObjectModel objectModel) {
		this.objectModel = objectModel;
	}

	private JButton addButton;
	private JButton cancelButton;
	AddForm(SinObjectModel om, String name){
		super(name);
		this.setObjectModel(om);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(600, 300);
		this.setLocation(500, 400);
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
		
		
		addButton = new JButton("ADD");
		cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
			
		});
		this.add(cancelButton,BorderLayout.WEST);
		this.add(addButton,BorderLayout.EAST);
		this.setVisible(true);
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

	abstract DBEntry getEntity();

	public void setEntity(DBEntry entity) {
		this.entity = entity;
		
	}

	protected class AttributeValuePanel extends JPanel{
		private JTextPane attrNameField;
		private JTextField attrValueField;
		
		AttributeValuePanel(String attrName){
			super();
			this.setMaximumSize(new Dimension(500,40));
			this.setBackground(Color.red);
			this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			
			setAttrNameField(new JTextPane());
			this.getAttrNameField().setText(attrName);
			this.getAttrNameField().setPreferredSize(new Dimension(200, 20));
			this.getAttrNameField().setFocusable(false);
			
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
	
	public class AttributeChoosePanel extends JPanel{
		final private AttributeChoosePanel attributeChoosePanel = this;
		private JFrame parentJFrame;
		private JTextPane attrNameField;
		private DBEntry entry;
		private JButton attrValueButton;
		public JButton getAttrValueButton() {
			return attrValueButton;
		}
		public void setAttrValueButton(JButton attrValueButton) {
			this.attrValueButton = attrValueButton;
		}
		private ArrayList attrList;

		AttributeChoosePanel(JFrame parentJFrame, String attrName,ArrayList attrList){
			super();
			this.setMaximumSize(new Dimension(500,40));
			this.setBackground(Color.red);
			this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
			this.setLayout(new FlowLayout(FlowLayout.LEADING));
			this.setParentJFrame(parentJFrame);
			setAttrNameField(new JTextPane());
			this.getAttrNameField().setText(attrName);
			this.getAttrNameField().setPreferredSize(new Dimension(200, 20));
			this.getAttrNameField().setFocusable(false);;
			
			this.attrList = attrList;
			
			attrValueButton = new JButton("value");
			attrValueButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					ChooseForm c = new ChooseForm(attributeChoosePanel.getParentJFrame(),attributeChoosePanel, attrList);
					attrValueButton.setText(entry.getShortDescription());
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
		public DBEntry getEntry() {
			return entry;
		}
		public void setEntry(DBEntry entry) {
			this.entry = entry;
		}

	}
	
}
