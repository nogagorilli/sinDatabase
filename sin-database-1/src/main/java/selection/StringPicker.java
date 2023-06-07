package selection;

import java.awt.FlowLayout;

import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class StringPicker extends JPanel{
	private JTextPane equalsField;
	private JTextField valueField;
	public JTextField getValueField() {
		return valueField;
	}
	StringPicker(){
		super();
		setLayout(new FlowLayout());
		equalsField = new JTextPane();
		equalsField.setText("=");
		equalsField.setFocusable(false);
		valueField = new JTextField("value");
		this.add(equalsField);
		this.add(valueField);
		this.setVisible(true);
	}
}
