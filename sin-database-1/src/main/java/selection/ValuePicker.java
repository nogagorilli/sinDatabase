package selection;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValuePicker extends JPanel{
	private RelationChooseMenu relationChooser;
	public RelationChooseMenu getRelationChooser() {
		return relationChooser;
	}
	private JMenuBar relationBar;
	private JTextField valueField;
	public JTextField getValueField() {
		return valueField;
	}
	ValuePicker(){
		super();
		setLayout(new FlowLayout());
		relationChooser = new RelationChooseMenu();
		relationBar = new JMenuBar();
		valueField = new JTextField("value");
		relationBar.add(relationChooser);
		this.add(relationBar);
		this.add(valueField);
		this.setVisible(true);
	}
}
