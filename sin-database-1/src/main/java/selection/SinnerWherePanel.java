package selection;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuItem;

import org.jdatepicker.impl.UtilDateModel;

import entities.DBEntry;
import entities.SinInstance;
import entities.Sinner;
import selection.AttributeChooseMenu.SinMenu;
import selection.AttributeChooseMenu.SinnerMenu;
import sinDatabase.SinObjectModel;

public class SinnerWherePanel extends WherePanel {
	private ValuePicker idPicker = null;
	private StringPicker namePicker = null;
	private StringPicker lastNamePicker = null;
	private DatePicker dateOfDeathPicker = null;
	private CirclePicker circlePicker = null;
	private SinPicker hasSinPicker = null;

	SinnerWherePanel(SinObjectModel objectModel){
		super(objectModel);
		this.setAttributeChooser(new AttributeChooseMenu.SinnerMenu("value"));
		Set<JMenuItem> temp = new HashSet<JMenuItem>();
		SinnerMenu t = (SinnerMenu)attributeChooser;
		temp.add(t.getCircleOfHellNameItem());
		temp.add(t.getNameItem());
		temp.add(t.getLastNameItem());
		temp.add(t.getIdItem()); 
		temp.add(t.getDateOfDeathItem());
		temp.add(t.getHasSinItem());
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
						if(((Sinner)elem).getId() < Float.parseFloat( idPicker.getValueField().getText())) { 
							ret.add((Sinner)elem);
							};

					}else if(idPicker.getRelationChooser().getText().equals("=")) {
						if(((Sinner)elem).getId() == Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Sinner)elem);
							};
					}else if(idPicker.getRelationChooser().getText().equals(">")) {
						if(((Sinner)elem).getId() > Float.parseFloat( idPicker.getValueField().getText())){ 
							ret.add((Sinner)elem);
							};
					}
				}
			}else if(namePicker != null) {
				System.out.println("by name");
				for(DBEntry elem:entries) {
					if(((Sinner)elem).getName().trim().equals(namePicker.getValueField().getText().trim())) {
						ret.add((Sinner)elem);
					}
				}
			}else if(lastNamePicker != null) {
				System.out.println("by lastname");
				for(DBEntry elem:entries) {
					if(((Sinner)elem).getLastName().trim().equals(lastNamePicker.getValueField().getText().trim())) {
						ret.add((Sinner)elem);
					}
				}
			}else if(dateOfDeathPicker != null) {
				System.out.println("by date of death");
				for(DBEntry elem:entries) {
					if(dateOfDeathPicker.getRelationChooser().getText().equals("<")) {
						if(((Sinner)elem).getDateOfDeath().compareTo( dateOfDeathPicker.getDate()) < 0) { 
							ret.add((Sinner)elem);
							};

					}else if(dateOfDeathPicker.getRelationChooser().getText().equals("=")) {
						if(((Sinner)elem).getDateOfDeath().toString().equals( (dateOfDeathPicker.getDate()).toString())){ 
							ret.add((Sinner)elem);
							};
					}else if(dateOfDeathPicker.getRelationChooser().getText().equals(">")) {
						if(((Sinner)elem).getDateOfDeath().compareTo( dateOfDeathPicker.getDate()) > 0){ 
							ret.add((Sinner)elem);
							};
					}
				}
			}else if(circlePicker != null) {
				System.out.println("by circle");
				for(DBEntry elem:entries) {
					if(circlePicker.getCircle() == ((Sinner)elem).getCircleOfHell()) {
						ret.add((Sinner)elem);
					}
				}
			}else if(hasSinPicker != null) {
				System.out.println("by sin");
				for(DBEntry elem:entries) {
					for(SinInstance inst: objectModel.getSinInstances()) {
						if(inst.getSinner() ==((Sinner)elem) &&  inst.getSin() == hasSinPicker.getSin()) {
							ret.add((Sinner)elem);
							break;
						}
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
		public MenuClickListener(SinnerWherePanel sinnerWherePanel, AttributeChooseMenu menu, JMenuItem item) {
			this.item = item;
			this.menu = menu;
			this.wherePanel = sinnerWherePanel;
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
				
			}else if(this.item.getText() == "DATE OF DEATH") {
				System.out.println("date of death");
				dateOfDeathPicker = new DatePicker();
				updatePanels();
				this.wherePanel.add(dateOfDeathPicker);
				updatePanels();
				
			}else if(this.item.getText() == "CIRCLE OF HELL") {
				System.out.println("circle of hell");
				circlePicker = new CirclePicker(objectModel);
				updatePanels();
				this.wherePanel.add(circlePicker);
				updatePanels();
			}else if(this.item.getText() == "HAS SIN") {
				System.out.println("has sin");
				hasSinPicker = new SinPicker(objectModel);
				updatePanels();
				this.wherePanel.add(hasSinPicker);
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
			this.remove(dateOfDeathPicker);
		}catch(Exception ex) {};
		
		try {
			this.remove(circlePicker);
		}catch(Exception ex) {};
		try {
			this.remove(hasSinPicker);
		}catch(Exception ex) {};
		
		
		idPicker = null;
		namePicker = null;
		lastNamePicker = null;
		dateOfDeathPicker = null;
		circlePicker = null;
		hasSinPicker = null;
		updatePanels();
		revalidate();
		repaint();
	}
}
