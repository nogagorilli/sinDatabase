package SinDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class DemonAddForm extends AddForm{
	Demon entity = new Demon();
	public void setEntity(Demon entity) {
		this.entity = entity;
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

	DemonAddForm(SinObjectModel om, String name) {
		super(om, name);
		
		this.namePanel = new AttributeValuePanel("NAME");
		namePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				entity.setName(namePanel.getAttrValueField().getText());
			}
		});
		
		this.lastNamePanel = new AttributeValuePanel("LAST NAME");
		lastNamePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				entity.setLastName(namePanel.getAttrValueField().getText());
			}
		});
		
		this.experiencePanel = new AttributeValuePanel("EXPERIENCE");
		experiencePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setExperience(Integer.parseInt(experiencePanel.getAttrValueField().getText()));
					System.out.println("an int");
				}catch(Exception ex) {
					System.out.println("not an int");
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
		
		this.circleChoosePanel = new AttributeChoosePanel(this, "CIRCLE OF HELL",(ArrayList) this.getObjectModel().getCirclesOfHell());
		
		

		
		
		this.mainPanel.add(namePanel);
		this.mainPanel.add(lastNamePanel);
		this.mainPanel.add(salaryPanel);
		this.mainPanel.add(experiencePanel);		
		this.mainPanel.add(circleChoosePanel);
		
		
	}

	@Override
	DBEntry getEntity() {
		// TODO Auto-generated method stub
		return this.entity;
	}

}
