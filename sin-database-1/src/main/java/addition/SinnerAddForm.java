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
import entities.Sinner;
import sinDatabase.SinObjectModel;

public class SinnerAddForm extends AddForm{
	Sinner entity = new Sinner();
	public void setEntity(Sinner entity) {
		System.out.println("setting an entity");
		this.entity = entity;
		this.namePanel.getAttrValueField().setText(entity.getName());
		this.lastNamePanel.getAttrValueField().setText(entity.getLastName());
		this.dateOfDeathPanel.getAttrValueField().setText(entity.getDateOfDeath().toString());
		try {
			this.circleChoosePanel.getAttrValueButton().setText(entity.getCircleOfHell().getShortDescription());
		}catch(Exception ex) {
			this.circleChoosePanel.getAttrValueButton().setText("undefined");
		}
		this.circleChoosePanel.setEntry(entity.getCircleOfHell());
		revalidate();
		
	}

	AttributeValuePanel namePanel;
	AttributeValuePanel lastNamePanel;
	AttributeValuePanel dateOfDeathPanel;
	AttributeChoosePanel circleChoosePanel;
	public AttributeChoosePanel getCircleChoosePanel() {
		return circleChoosePanel;
	}

	public void setCircleChoosePanel(AttributeChoosePanel circleChoosePanel) {
		this.circleChoosePanel = circleChoosePanel;
	}

	public SinnerAddForm(SinObjectModel om, String name) {
		super(om, name);
		
		entity.setDateOfDeath(new Date(0));
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
		
		this.dateOfDeathPanel = new AttributeValuePanel("DATE OF DEATH (YYYY-MM-DD)");
		dateOfDeathPanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setDateOfDeath(Date.valueOf(dateOfDeathPanel.getAttrValueField().getText()));
				}catch(Exception ex) {
					System.out.println("wrong datta format");
				}
			}
		});
		
		dateOfDeathPanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					entity.setDateOfDeath(Date.valueOf(dateOfDeathPanel.getAttrValueField().getText()));
					System.out.println("a date");
				}catch(Exception ex) {
					System.out.println("not a date");
					dateOfDeathPanel.getAttrValueField().setText(new Date(0).toString());
					entity.setDateOfDeath(new Date(0));
				}
				
			}
			
		});
		
		
		this.circleChoosePanel = new AttributeChoosePanel(this, "CIRCLE OF HELL",(ArrayList) this.getObjectModel().getCirclesOfHell());
		for(ActionListener a:this.getAddButton().getActionListeners()) this.getAddButton().removeActionListener(a);
		

		
		
		this.mainPanel.add(namePanel);
		this.mainPanel.add(lastNamePanel);
		this.mainPanel.add(dateOfDeathPanel);
		this.mainPanel.add(circleChoosePanel);
		
		
	}

	@Override
	public DBEntry getEntity() {
		// TODO Auto-generated method stub
		System.out.println(this.entity.getDateOfDeath());
		return this.entity;
	}
	
}
