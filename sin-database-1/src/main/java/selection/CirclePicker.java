package selection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import entities.CircleOfHell;
import sinDatabase.SinObjectModel;

public class CirclePicker extends JPanel{
	private CircleOfHell circle;
	private JTextPane equalsField;
	private SinObjectModel objectModel;
	private JComboBox circleChooser;
	CirclePicker(SinObjectModel objectModel){
		this.objectModel = objectModel;
		setLayout(new FlowLayout());
		equalsField = new JTextPane();
		equalsField.setText("=");
		equalsField.setFocusable(false);
		circleChooser = new JComboBox();
		
		
		for(CircleOfHell c:this.objectModel.getCirclesOfHell()) {
			System.out.println("circle");
			ListEntry entry = new ListEntry(c);
			circleChooser.addItem(entry);
		}
		this.setCircle(this.objectModel.getCirclesOfHell().get(0));
		circleChooser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				circle = ((ListEntry)circleChooser.getSelectedItem()).circle;
				System.out.println(circle.getShortDescription());
			}
			
		});
		
		
		
		this.add(equalsField);
		this.add(circleChooser);
		this.setVisible(true);
	}
	
	public CircleOfHell getCircle() {
		return circle;
	}

	public void setCircle(CircleOfHell circle) {
		this.circle = circle;
	}
	private class ListEntry extends JButton{
		CircleOfHell circle;
		ListEntry(CircleOfHell circle){
			this.circle = circle;
			this.setText(circle.getShortDescription());
		}
		@Override
		
		public String toString() {
			return this.circle.getShortDescription();
			
		}
	}
}
