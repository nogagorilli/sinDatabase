package addition;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import entities.DBEntry;
import entities.Demon;
import sinDatabase.SinObjectModel;

public class DemonAddForm extends AddForm{
	Demon entity = new Demon();
	public void setEntity(Demon entity) {
		this.entity = entity;
		this.namePanel.getAttrValueField().setText(entity.getName());
		this.lastNamePanel.getAttrValueField().setText(entity.getLastName());
		this.experiencePanel.getAttrValueField().setText(String.valueOf( entity.getExperience()));
		this.salaryPanel.getAttrValueField().setText(String.valueOf( entity.getExperience()));
		try {
			this.circleChoosePanel.getAttrValueButton().setText(entity.getCircleOfHell().getShortDescription());
		}catch(Exception ex) {
			this.circleChoosePanel.getAttrValueButton().setText("undefined");
		}
		this.circleChoosePanel.setEntry(entity.getCircleOfHell());
		
	}

	AttributeValuePanel namePanel;
	AttributeValuePanel lastNamePanel;
	AttributeValuePanel experiencePanel;
	AttributeValuePanel salaryPanel;
	AttributeChoosePanel circleChoosePanel;
	public AttributeChoosePanel getCircleChoosePanel() {
		return circleChoosePanel;
	}

	public void setCircleChoosePanel(AttributeChoosePanel circleChoosePanel) {
		this.circleChoosePanel = circleChoosePanel;
	}

	public DemonAddForm(SinObjectModel om, String name) {
		super(om, name);
		
		this.namePanel = new AttributeValuePanel("NAME");
		namePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				entity.setName(namePanel.getAttrValueField().getText());
			}
		});
		namePanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(namePanel.getAttrValueField().getText().trim().length() == 0) {
					namePanel.getAttrValueField().setText("UNDEFINED");
					entity.setName(namePanel.getAttrValueField().getText());
				}
				
			}
			
		});
		
		
		this.lastNamePanel = new AttributeValuePanel("LAST NAME");
		lastNamePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				entity.setLastName(lastNamePanel.getAttrValueField().getText());
			}
		});
		lastNamePanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(lastNamePanel.getAttrValueField().getText().trim().length() == 0) {
					lastNamePanel.getAttrValueField().setText("UNDEFINED");
					entity.setName(lastNamePanel.getAttrValueField().getText());
				}
				
			}
			
		});
		
		this.experiencePanel = new AttributeValuePanel("EXPERIENCE");
		experiencePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					if(Integer.parseInt(experiencePanel.getAttrValueField().getText()) <0) {
						experiencePanel.getAttrValueField().setText(String.valueOf( -Integer.parseInt(experiencePanel.getAttrValueField().getText())));
					}
					entity.setExperience(Integer.parseInt(experiencePanel.getAttrValueField().getText()));
					System.out.println("an int");
				}catch(Exception ex) {
					System.out.println("not an int");
				}
			}
		});
		experiencePanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(Integer.parseInt(experiencePanel.getAttrValueField().getText()) <0) {
						experiencePanel.getAttrValueField().setText(String.valueOf( -Integer.parseInt(experiencePanel.getAttrValueField().getText())));
					}
					entity.setExperience(Integer.parseInt(experiencePanel.getAttrValueField().getText()));
					System.out.println("an int");
				}catch(Exception ex) {
					System.out.println("not an int");
					experiencePanel.getAttrValueField().setText("0");
					entity.setExperience(0);
				}
				
			}
			
		});
		
		this.salaryPanel = new AttributeValuePanel("SALARY");
		salaryPanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setSalary(Integer.parseInt(salaryPanel.getAttrValueField().getText()));
					System.out.println("an int");
				}catch(Exception ex) {
					System.out.println("not an int");
				}
			}
		});
		salaryPanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(Integer.parseInt(salaryPanel.getAttrValueField().getText()) <0) {
						salaryPanel.getAttrValueField().setText(String.valueOf( -Integer.parseInt(salaryPanel.getAttrValueField().getText())));
					}
					entity.setSalary(Integer.parseInt(salaryPanel.getAttrValueField().getText()));
					System.out.println("an int");
				}catch(Exception ex) {
					System.out.println("not an int");
					salaryPanel.getAttrValueField().setText("0");
					entity.setSalary(0);
				}
				
			}
			
		});
		
		this.circleChoosePanel = new AttributeChoosePanel(this, "CIRCLE OF HELL",(ArrayList) this.getObjectModel().getCirclesOfHell());
		
		

		
		
		this.mainPanel.add(namePanel);
		this.mainPanel.add(lastNamePanel);
		this.mainPanel.add(salaryPanel);
		this.mainPanel.add(experiencePanel);		
		this.mainPanel.add(circleChoosePanel);
		
		
	}

	@Override
	public DBEntry getEntity() {
		// TODO Auto-generated method stub
		return this.entity;
	}
	

}
