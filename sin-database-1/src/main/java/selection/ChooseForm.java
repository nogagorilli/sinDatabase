package selection;

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

import addition.AddForm.AttributeChoosePanel;
import entities.DBEntry;

public class ChooseForm extends JDialog{
	JList list;
	DefaultListModel model;
	private AttributeChoosePanel parentChoosePanel;
	private ArrayList<DBEntry> entries;
	int counter = 15;
	private JButton okButton;
	private JButton cancelButton;
	public ChooseForm(JFrame parentJFrame,AttributeChoosePanel parentChoosePanel, ArrayList<DBEntry> entryList){
		super(parentJFrame,true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setParentChoosePanel(parentChoosePanel);
		this.setEntries(entryList);
		
		this.setSize(400, 250);
		this.setLocation(500, 400);
		this.setResizable(false);
		setLayout(new BorderLayout());
	    model = new DefaultListModel();
	    list = new JList(model);
	    JScrollPane pane = new JScrollPane(list);
	    cancelButton = new JButton("CANCEL");
	    okButton = new JButton("OK");
	    try {
		    for(DBEntry el:entryList) {
		    	model.addElement(el.getShortDescription());
		    }
	    }catch(Exception ex) {
	    	System.out.println("list is null");
	    }
	    add(pane, BorderLayout.NORTH);
	    add(cancelButton, BorderLayout.WEST);
	    okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				parentChoosePanel.setEntry(entries.get(list.getSelectedIndex()));
				
			}
	    	
	    });
	    
	    cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
	    	
	    });
	    add(okButton, BorderLayout.EAST);
		
	    this.setVisible(true);
		revalidate();
	}

	public AttributeChoosePanel getParentChoosePanel() {
		return parentChoosePanel;
	}

	public void setParentChoosePanel(AttributeChoosePanel parentChoosePanel) {
		this.parentChoosePanel = parentChoosePanel;
	}

	public ArrayList<DBEntry> getEntries() {
		return entries;
	}

	public void setEntries(ArrayList<DBEntry> entries) {
		this.entries = entries;
	}
}
