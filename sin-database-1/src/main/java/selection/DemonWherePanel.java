package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import entities.DBEntry;
import entities.Demon;
import entities.SinInstance;
import entities.Sinner;
import selection.AttributeChooseMenu.DemonMenu;
import selection.AttributeChooseMenu.SinnerMenu;

import sinDatabase.SinObjectModel;

public class DemonWherePanel extends WherePanel {
	
	private ValuePicker idPicker = null;
	private StringPicker namePicker = null;
	private StringPicker lastNamePicker = null;
	private ValuePicker salaryPicker = null;
	private ValuePicker experiencePicker = null;
	private CirclePicker circlePicker = null;
	

	DemonWherePanel(SinObjectModel objectModel){
		super(objectModel);
		this.setAttributeChooser(new AttributeChooseMenu.DemonMenu("value"));
		Set<JMenuItem> temp = new HashSet<JMenuItem>();
		DemonMenu t = (DemonMenu)attributeChooser;
		temp.add(t.getCircleOfHellNameItem());
		temp.add(t.getNameItem());
		temp.add(t.getLastNameItem());
		temp.add(t.getIdItem()); 
		temp.add(t.getSalaryItem());
		temp.add(t.getExperienceItem());
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
						if(((Demon)elem).getId() < Float.parseFloat( idPicker.getValueField().getText())) { 
							ret.add((Demon)elem);
							};

					}else if(idPicker.getRelationChooser().getText().equals("=")) {
						if(((Demon)elem).getId() == Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Demon)elem);
							};
					}else if(idPicker.getRelationChooser().getText().equals(">")) {
						if(((Demon)elem).getId() > Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Demon)elem);
							};
					}
				}
				
			}else if(namePicker != null) {
				System.out.println("by name");
				for(DBEntry elem:entries) {
					if(((Demon)elem).getName().trim().equals(namePicker.getValueField().getText().trim())) {
						ret.add((Demon)elem);
					}
				}
				
			}else if(lastNamePicker != null) {
				System.out.println("by lastname");
				for(DBEntry elem:entries) {
					if(((Demon)elem).getLastName().trim().equals(lastNamePicker.getValueField().getText().trim())) {
						ret.add((Demon)elem);
					}
				}
				
			}else if(circlePicker != null) {
				System.out.println("by circle");
				for(DBEntry elem:entries) {
					if(circlePicker.getCircle() == ((Demon)elem).getCircleOfHell()) {
						ret.add((Demon)elem);
					}
				}
				
			}else if(salaryPicker != null) {
				System.out.println("by salary");
				for(DBEntry elem:entries) {
					if(salaryPicker.getRelationChooser().getText().equals("<")) {
						if(((Demon)elem).getSalary() < Float.parseFloat( salaryPicker.getValueField().getText())) { 
							ret.add((Demon)elem);
							};

					}else if(salaryPicker.getRelationChooser().getText().equals("=")) {
						if(((Demon)elem).getSalary() == Float.parseFloat( salaryPicker.getValueField().getText())){ 
							ret.add((Demon)elem);
							};
					}else if(salaryPicker.getRelationChooser().getText().equals(">")) {
						if(((Demon)elem).getSalary() > Float.parseFloat( salaryPicker.getValueField().getText())){ 
							ret.add((Demon)elem);
							};
					}
				}
				
				
				
			}else if(experiencePicker != null) {
				System.out.println("by experience");
				for(DBEntry elem:entries) {
					if(experiencePicker.getRelationChooser().getText().equals("<")) {
						if(((Demon)elem).getSalary() < Float.parseFloat( experiencePicker.getValueField().getText())) { 
							ret.add((Demon)elem);
							};

					}else if(experiencePicker.getRelationChooser().getText().equals("=")) {
						if(((Demon)elem).getId() == Float.parseFloat( experiencePicker.getValueField().getText())){ 
							ret.add((Demon)elem);
							};
					}else if(experiencePicker.getRelationChooser().getText().equals(">")) {
						if(((Demon)elem).getId() > Float.parseFloat( experiencePicker.getValueField().getText())){ 
							ret.add((Demon)elem);
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
		public MenuClickListener(DemonWherePanel demonWherePanel, AttributeChooseMenu menu, JMenuItem item) {
			this.item = item;
			this.menu = menu;
			this.wherePanel = demonWherePanel;
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
				
			}else if(this.item.getText() == "LASTNAME") {
				System.out.println("lastname");
				lastNamePicker = new StringPicker();
				updatePanels();
				this.wherePanel.add(lastNamePicker);
				updatePanels();
				
			}else if(this.item.getText() == "CIRCLE OF HELL") {
				System.out.println("circle of hell");
				circlePicker = new CirclePicker(objectModel);
				updatePanels();
				this.wherePanel.add(circlePicker);
				updatePanels();
			}else if(this.item.getText() == "EXPERIENCE") {
				System.out.println("experience");
				experiencePicker = new ValuePicker();
				updatePanels();
				this.wherePanel.add(experiencePicker);
				updatePanels();
			}else if(this.item.getText() == "SALARY") {
				System.out.println("salary");
				salaryPicker = new ValuePicker();
				updatePanels();
				this.wherePanel.add(salaryPicker);
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
			this.remove(lastNamePicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(experiencePicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(salaryPicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(circlePicker);
		}catch(Exception ex) {};
		
		
		
		idPicker = null;
		namePicker = null;
		lastNamePicker = null;
		salaryPicker = null;
		experiencePicker =null;
		circlePicker = null;
		updatePanels();
		revalidate();
		repaint();
	}

}
