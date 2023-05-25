package SinDatabase;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WherePanel extends JPanel {
	private AttributeChooseMenu attributeChooser;
	private RelationChooseMenu relationChooser;
	private JTextField attributeValue;
	private JMenuBar attributeBar;
	private JMenuBar relationBar;
	WherePanel(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		attributeChooser = new AttributeChooseMenu.CirclesMenu("circles");
		attributeBar = new JMenuBar();
		attributeBar.add(attributeChooser);
		relationChooser = new RelationChooseMenu();
		relationBar = new JMenuBar();
		relationBar.add(relationChooser);
		attributeValue = new JTextField("value");
		this.add(attributeBar);
		this.add(relationBar);
		this.add(attributeValue);
		
		updatePanels();
	}
	private void updatePanels() {
		this.attributeBar.removeAll();
		this.attributeBar.add(attributeChooser);
		this.relationBar.removeAll();
		this.relationBar.add(relationChooser);
		
	}
	public AttributeChooseMenu getAttributeChooser() {
		return attributeChooser;
	}
	public void setAttributeChooser(AttributeChooseMenu attribute) {
		this.attributeChooser = attribute;
		updatePanels();
	}
	
	public String getAttribute() {
		return this.attributeChooser.getText();
	}
	
	public String getAttributeValue() {
		return this.attributeValue.getText();
	}
	
	public String getRelation() {
		return this.relationChooser.getText();
	}

}
