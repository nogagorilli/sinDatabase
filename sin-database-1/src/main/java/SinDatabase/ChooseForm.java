package SinDatabase;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class ChooseForm extends JDialog{
	JList list;

	DefaultListModel model;

	int counter = 15;
	
	ChooseForm(JFrame parent, ArrayList<DBEntry> entryList){
		super(parent,true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		this.setSize(400, 250);
		this.setResizable(false);
		setLayout(new BorderLayout());
	    model = new DefaultListModel();
	    list = new JList(model);
	    JScrollPane pane = new JScrollPane(list);
	    JButton addButton = new JButton("CANCEL");
	    JButton removeButton = new JButton("OK");
	    try {
		    for(DBEntry el:entryList) {
		    	model.addElement(el.getShortDescription());
		    }
	    }catch(Exception ex) {
	    	System.out.println("list is null");
	    }
	    add(pane, BorderLayout.NORTH);
	    add(addButton, BorderLayout.WEST);
	    add(removeButton, BorderLayout.EAST);
		
	    this.setVisible(true);
		revalidate();
	}
}
