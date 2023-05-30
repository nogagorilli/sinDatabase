package SinDatabase;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class EditForm extends JFrame{
	JMenuBar tableChooseBar;
	JMenu tableMenu;
	JTextField idField;
	JTextPane tableText;
	JTextPane idText;
	JPanel idPanel;
	JPanel tablePanel;
	JButton editButton;
	EditForm(SinObjectModel om){
		super("EDIT");
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(new Dimension(500,400));
		this.setLayout(new BorderLayout());
		
		//Initializing fields
		this.tableChooseBar = new JMenuBar();
		this.tableMenu = new JMenu();
		idField = new JTextField("0");
		tableText = new JTextPane();
		tableText.setText("TABLE");
		idText = new JTextPane();
		idText.setText("TABLE");
		idPanel = new JPanel();
		idPanel.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		editButton = new JButton("EDIT");
		
		//Assembling frame
		
		this.add(editButton,BorderLayout.AFTER_LAST_LINE);
		this.add(tablePanel,BorderLayout.WEST);
		this.add(idPanel,BorderLayout.EAST);
		idPanel.add(idText);
		idPanel.add(idField);
		tablePanel.add(tableText);
		
		
		this.setVisible(true);
	}
}
