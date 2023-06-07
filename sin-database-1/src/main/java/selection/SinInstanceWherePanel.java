package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import entities.DBEntry;
import entities.SinInstance;
import entities.Sinner;
import selection.AttributeChooseMenu.SinInstancesMenu;
import selection.AttributeChooseMenu.SinnerMenu;

import sinDatabase.SinObjectModel;

public class SinInstanceWherePanel extends WherePanel {
	private ValuePicker idPicker = null;
	private SinnerPicker sinnerPicker = null;
	private SinPicker sinPicker = null;
	private DatePicker datePicker = null;


	SinInstanceWherePanel(SinObjectModel objectModel){
		super(objectModel);
		this.setAttributeChooser(new AttributeChooseMenu.SinInstancesMenu("value"));
		Set<JMenuItem> temp = new HashSet<JMenuItem>();
		SinInstancesMenu t = (SinInstancesMenu)attributeChooser;
		temp.add(t.getDateItem());
		temp.add(t.getSinItem());
		temp.add(t.getSinnerItem());
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
						if(((SinInstance)elem).getId() < Float.parseFloat( idPicker.getValueField().getText())) { 
							ret.add((SinInstance)elem);
							};

					}else if(idPicker.getRelationChooser().getText().equals("=")) {
						if(((SinInstance)elem).getId() == Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((SinInstance)elem);
							};
					}else if(idPicker.getRelationChooser().getText().equals(">")) {
						if(((SinInstance)elem).getId() > Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((SinInstance)elem);
							};
					}
				}
			}else if(datePicker != null) {
				System.out.println("by date");
				for(DBEntry elem:entries) {
					if(datePicker.getRelationChooser().getText().equals("<")) {
						if(((SinInstance)elem).getDate().compareTo( datePicker.getDate()) < 0) { 
							ret.add((SinInstance)elem);
							};

					}else if(datePicker.getRelationChooser().getText().equals("=")) {
						if(((SinInstance)elem).getDate().toString().equals( (datePicker.getDate()).toString())){ 
							ret.add((SinInstance)elem);
							};
					}else if(datePicker.getRelationChooser().getText().equals(">")) {
						if(((SinInstance)elem).getDate().compareTo( datePicker.getDate()) > 0){ 
							ret.add((SinInstance)elem);
							};
					}
				}
			}else if(sinnerPicker != null) {
				System.out.println("by sinner");
				for(DBEntry elem:entries) {
					if(sinnerPicker.getSinner() == ((SinInstance)elem).getSinner()) {
						ret.add((SinInstance)elem);
					}
				}
			}else if(sinPicker != null) {
				System.out.println("by sin");
				for(DBEntry elem:entries) {
					if(sinPicker.getSin() == ((SinInstance)elem).getSin()) {
						ret.add((SinInstance)elem);
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
		public MenuClickListener(SinInstanceWherePanel sinInstanceWherePanel, AttributeChooseMenu menu, JMenuItem item) {
			this.item = item;
			this.menu = menu;
			this.wherePanel = sinInstanceWherePanel;
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
				
			}else if(this.item.getText() == "DATE") {
				System.out.println("date of death");
				datePicker = new DatePicker();
				updatePanels();
				this.wherePanel.add(datePicker);
				updatePanels();
				
			}else if(this.item.getText() == "SINNER") {
				System.out.println("sinner");
				sinnerPicker = new SinnerPicker(objectModel);
				updatePanels();
				this.wherePanel.add(sinnerPicker);
				updatePanels();
				
			}else if(this.item.getText() == "SIN") {
				System.out.println("sin");
				sinPicker = new SinPicker(objectModel);
				updatePanels();
				this.wherePanel.add(sinPicker);
				updatePanels();
				
			}
			
		}
		
	}
	private void deleteAllPickers() {
		try {
			this.remove(idPicker);
		}catch(Exception ex) {};

		try {
			this.remove(datePicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(sinnerPicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(sinPicker);
		}catch(Exception ex) {};

		
		idPicker = null;
		sinnerPicker = null;
		sinPicker = null;
		datePicker = null;

		updatePanels();
		revalidate();
		repaint();
	}
}
