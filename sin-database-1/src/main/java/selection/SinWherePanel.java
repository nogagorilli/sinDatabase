package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import entities.DBEntry;
import entities.Sin;
import entities.SinInstance;
import entities.Sinner;
import selection.AttributeChooseMenu.SinMenu;
import selection.AttributeChooseMenu.SinnerMenu;

import sinDatabase.SinObjectModel;

public class SinWherePanel extends WherePanel{
	private ValuePicker idPicker = null;
	private StringPicker namePicker = null;
	private ValuePicker heavinessPicker = null;

	SinWherePanel(SinObjectModel objectModel){
		super(objectModel);
		this.setAttributeChooser(new AttributeChooseMenu.SinMenu("value"));
		Set<JMenuItem> temp = new HashSet<JMenuItem>();
		SinMenu t = (SinMenu)attributeChooser;
	
		temp.add(t.getNameItem());

		temp.add(t.getIdItem()); 
		temp.add(t.getHeavinessItem()); 

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
						if(((Sin)elem).getId() < Float.parseFloat( idPicker.getValueField().getText())) { 
							ret.add((Sin)elem);
							};

					}else if(idPicker.getRelationChooser().getText().equals("=")) {
						if(((Sin)elem).getId() == Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Sin)elem);
							};
					}else if(idPicker.getRelationChooser().getText().equals(">")) {
						if(((Sin)elem).getId() > Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Sin)elem);
							};
					}
				}
			}else if(namePicker != null) {
				System.out.println("by name");
				for(DBEntry elem:entries) {
					if(((Sin)elem).getName().trim().equals(namePicker.getValueField().getText().trim())) {
						ret.add((Sin)elem);
					}
				}
			}else if(heavinessPicker != null) {
				System.out.println("by heaviness");
				for(DBEntry elem:entries) {
					if(heavinessPicker.getRelationChooser().getText().equals("<")) {
						if(((Sin)elem).getHeaviness() < Float.parseFloat( heavinessPicker.getValueField().getText())) { 
							ret.add((Sin)elem);
							};

					}else if(heavinessPicker.getRelationChooser().getText().equals("=")) {
						if(((Sin)elem).getHeaviness() == Float.parseFloat(heavinessPicker.getValueField().getText())){ 
							ret.add((Sin)elem);
							};
					}else if(heavinessPicker.getRelationChooser().getText().equals(">")) {
						if(((Sin)elem).getHeaviness() > Float.parseFloat(heavinessPicker.getValueField().getText())){ 
							ret.add((Sin)elem);
							};
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
		public MenuClickListener(SinWherePanel sinWherePanel, AttributeChooseMenu menu, JMenuItem item) {
			this.item = item;
			this.menu = menu;
			this.wherePanel = sinWherePanel;
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
				
			}else if(this.item.getText() == "HEAVINESS") {
				System.out.println("heaviness");
				heavinessPicker = new ValuePicker();
				updatePanels();
				this.wherePanel.add(heavinessPicker);
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
		
		try {
			this.remove(heavinessPicker);
		}catch(Exception ex) {};
		
		
		idPicker = null;
		namePicker = null;
		heavinessPicker = null;

		updatePanels();
		revalidate();
		repaint();
	}
	public ValuePicker getHeavinessPicker() {
		return heavinessPicker;
	}
}
