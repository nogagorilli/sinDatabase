package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import entities.CircleOfHell;
import entities.DBEntry;
import entities.Sin;
import selection.AttributeChooseMenu.CirclesMenu;
import selection.AttributeChooseMenu.SinMenu;

import sinDatabase.SinObjectModel;

public class CircleWherePanel extends WherePanel {
	private ValuePicker idPicker = null;
	private StringPicker namePicker = null;

	CircleWherePanel(SinObjectModel objectModel){
		super(objectModel);
		this.setAttributeChooser(new AttributeChooseMenu.CirclesMenu("value"));
		Set<JMenuItem> temp = new HashSet<JMenuItem>();
		CirclesMenu t = (CirclesMenu)attributeChooser;
	
		temp.add(t.getNameItem());
		temp.add(t.getIdItem()); 

		for(JMenuItem item: temp) {
			item.addActionListener(new MenuClickListener(this,attributeChooser,item));
		}
	}
	@Override
	public Set<DBEntry> filter(Set<DBEntry> entries) {
		System.out.println("filtering");
		HashSet<DBEntry> ret = new HashSet<DBEntry>();
		for(DBEntry entry: entries) {
			if(idPicker != null) {
				System.out.println("by id");
				for(DBEntry elem:entries) {
					if(idPicker.getRelationChooser().getText().equals("<")) {
						if(((CircleOfHell)elem).getId() < Float.parseFloat( idPicker.getValueField().getText())) { 
							ret.add((CircleOfHell)elem);
							};

					}else if(idPicker.getRelationChooser().getText().equals("=")) {
						if(((CircleOfHell)elem).getId() == Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((CircleOfHell)elem);
							};
					}else if(idPicker.getRelationChooser().getText().equals(">")) {
						if(((CircleOfHell)elem).getId() > Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((CircleOfHell)elem);
							};
					}
				}
			}else if(namePicker != null) {
				System.out.println("by name");
				for(DBEntry elem:entries) {
					if(((CircleOfHell)elem).getName().trim().equals(namePicker.getValueField().getText().trim())) {
						ret.add((CircleOfHell)elem);
					}
				}
			}else {
				System.out.println("no chooser");
				return entries;
			}
		}
		return ret;
	}
	
	private class MenuClickListener implements ActionListener{
		private JMenuItem item;
		private AttributeChooseMenu menu;
		private WherePanel wherePanel;
		public MenuClickListener(CircleWherePanel circleWherePanel, AttributeChooseMenu menu, JMenuItem item) {
			this.item = item;
			this.menu = menu;
			this.wherePanel = circleWherePanel;
			// TODO Auto-generated constructor stub
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			deleteAllPickers();
			System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbb");
			if(this.item.getText() == "ID") {
				System.out.println("id");
				idPicker = new ValuePicker();
				updatePanels();
				this.wherePanel.add(idPicker);
				updatePanels();
				
			}else if(this.item.getText() == "NAME") {
				System.out.println("name");
				namePicker = new StringPicker();
				updatePanels();
				this.wherePanel.add(namePicker);
				updatePanels();
				
			}
			
		}
		
	}
	private void deleteAllPickers() {
		try {
			this.remove(idPicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(namePicker);
		}catch(Exception ex) {};
		
		
		
		
		idPicker = null;
		namePicker = null;


		updatePanels();
		revalidate();
		repaint();
	}

}