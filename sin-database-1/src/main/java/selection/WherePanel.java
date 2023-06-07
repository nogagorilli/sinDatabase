package selection;

import java.awt.FlowLayout;
import java.util.Set;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entities.DBEntry;
import sinDatabase.SinObjectModel;

abstract public class WherePanel extends JPanel {
	protected AttributeChooseMenu attributeChooser;
	private JMenuBar attributeBar;
	protected SinObjectModel objectModel;
	WherePanel(SinObjectModel objectModel){
		super();
		this.objectModel = objectModel;
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		attributeChooser = new AttributeChooseMenu.CirclesMenu("circles");
		attributeBar = new JMenuBar();
		attributeBar.add(attributeChooser);


		this.add(attributeBar);


		this.setVisible(true);
		updatePanels();
	}
	protected void updatePanels() {
		this.attributeBar.removeAll();
		this.attributeBar.add(attributeChooser);
		revalidate();
		repaint();

		
	}
	protected AttributeChooseMenu getAttributeChooser() {
		return attributeChooser;
	}
	protected void setAttributeChooser(AttributeChooseMenu attribute) {
		this.attributeChooser = attribute;
		updatePanels();
	}
	public String getAttribute() {
		return this.attributeChooser.getText();
	}
	

	

	
	public abstract Set<DBEntry> filter(Set<DBEntry> entries);
}
