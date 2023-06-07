package selection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import entities.CircleOfHell;
import entities.Sin;
import sinDatabase.SinObjectModel;

public class SinPicker extends JPanel{
	private Sin sin;
	public Sin getSin() {
		return sin;
	}


	public void setSin(Sin sin) {
		this.sin = sin;
	}


	private JTextPane equalsField;
	private SinObjectModel objectModel;
	private JComboBox sinChooser;
	SinPicker(SinObjectModel objectModel){
		this.objectModel = objectModel;
		setLayout(new FlowLayout());
		equalsField = new JTextPane();
		equalsField.setText("=");
		equalsField.setFocusable(false);
		sinChooser = new JComboBox();
		
		
		for(Sin c:this.objectModel.getSins()) {
			System.out.println("sin");
			ListEntry entry = new ListEntry(c);
			sinChooser.addItem(entry);
		}
		this.setSin(this.objectModel.getSins().get(0));
		sinChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sin = ((ListEntry)sinChooser.getSelectedItem()).sin;
				System.out.println(sin.getShortDescription());
			}
			
		});
		
		
		
		this.add(equalsField);
		this.add(sinChooser);
		this.setVisible(true);
	}
	

	private class ListEntry extends JButton{
		Sin sin;
		ListEntry(Sin sin){
			this.sin = sin;
			this.setText(sin.getShortDescription());
		}
		
		@Override
		public String toString() {
			return this.sin.getShortDescription();
			
		}
	}
}
