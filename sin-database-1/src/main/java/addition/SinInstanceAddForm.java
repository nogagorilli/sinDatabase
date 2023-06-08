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
import entities.SinInstance;
import sinDatabase.SinObjectModel;

public class SinInstanceAddForm extends AddForm{
	SinInstance entity = new SinInstance();
	public void setEntity(SinInstance entity) {
		this.entity = entity;
		try {
			this.sinnerChoosePanel.getAttrValueButton().setText(entity.getSinner().getShortDescription());
		}catch(Exception ex) {
			this.sinnerChoosePanel.getAttrValueButton().setText("undefined");
		}
		this.sinnerChoosePanel.setEntry(entity.getSinner());
		
		try {
			this.sinChoosePanel.getAttrValueButton().setText(entity.getSin().getShortDescription());
		}catch(Exception ex) {
			this.sinChoosePanel.getAttrValueButton().setText("undefined");
		}
		this.sinChoosePanel.setEntry(entity.getSin());
		
		this.datePanel.getAttrValueField().setText(entity.getDate().toString());
		revalidate();
	}

	AttributeValuePanel datePanel;
	AttributeChoosePanel sinnerChoosePanel;
	AttributeChoosePanel sinChoosePanel;
	
	public AttributeChoosePanel getSinChoosePanel() {
		return sinChoosePanel;
	}

	public void setSinChoosePanel(AttributeChoosePanel sinChoosePanel) {
		this.sinChoosePanel = sinChoosePanel;
	}

	public AttributeChoosePanel getSinnerChoosePanel() {
		return sinnerChoosePanel;
	}

	public void setSinnerChoosePanel(AttributeChoosePanel circleChoosePanel) {
		this.sinnerChoosePanel = circleChoosePanel;
	}

	public SinInstanceAddForm(SinObjectModel om, String name) {
		super(om, name);
		
		
		
		
		
		this.datePanel = new AttributeValuePanel("DATE (YYYY-MM-DD)");
		datePanel.getAttrValueField().addCaretListener(new CaretListener() {
			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setDate(Date.valueOf(datePanel.getAttrValueField().getText()));
				}catch(Exception ex) {
					System.out.println("wrong data format");
				}
			}
		});
		datePanel.getAttrValueField().addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				try {
					entity.setDate(Date.valueOf(datePanel.getAttrValueField().getText()));
					System.out.println("a date");
				}catch(Exception ex) {
					System.out.println("not a date");
					datePanel.getAttrValueField().setText(new Date(0).toString());
					entity.setDate(new Date(0));
				}
				
			}
			
		});
		
		this.sinnerChoosePanel = new AttributeChoosePanel(this, "SINNER",(ArrayList) this.getObjectModel().getSinners());
		
		

		this.sinChoosePanel = new AttributeChoosePanel(this, "SIN",(ArrayList) this.getObjectModel().getSins());
		
		for(ActionListener a:this.getAddButton().getActionListeners()) this.getAddButton().removeActionListener(a);
		
		
		
		this.mainPanel.add(sinnerChoosePanel);
		this.mainPanel.add(sinChoosePanel);
		this.mainPanel.add(datePanel);
		
		
	}

	@Override
	public DBEntry getEntity() {
		// TODO Auto-generated method stub
		return this.entity;
	}

}
