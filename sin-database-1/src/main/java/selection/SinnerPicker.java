package selection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import entities.Sin;
import entities.Sinner;
import sinDatabase.SinObjectModel;

public class SinnerPicker extends JPanel{
	private Sinner sinner;
	public Sinner getSinner() {
		return sinner;
	}


	public void setSinner(Sinner sinner) {
		this.sinner = sinner;
	}


	private JTextPane equalsField;
	private SinObjectModel objectModel;
	private JComboBox sinnerChooser;
	SinnerPicker(SinObjectModel objectModel){
		this.objectModel = objectModel;
		setLayout(new FlowLayout());
		equalsField = new JTextPane();
		equalsField.setText("=");
		equalsField.setFocusable(false);
		sinnerChooser = new JComboBox();
		
		
		for(Sinner c:this.objectModel.getSinners()) {
			System.out.println("sinner");
			ListEntry entry = new ListEntry(c);
			sinnerChooser.addItem(entry);
		}
		this.setSinner(this.objectModel.getSinners().get(0));
		sinnerChooser.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sinner = ((ListEntry)sinnerChooser.getSelectedItem()).sinner;
				System.out.println(sinner.getShortDescription());
			}
			
		});
		
		
		
		this.add(equalsField);
		this.add(sinnerChooser);
		this.setVisible(true);
	}
	

	private class ListEntry extends JButton{
		Sinner sinner;
		ListEntry(Sinner sinner){
			this.sinner = sinner;
			this.setText(sinner.getShortDescription());
		}
		
		@Override
		public String toString() {
			return this.sinner.getShortDescription();
			
		}
	}
}