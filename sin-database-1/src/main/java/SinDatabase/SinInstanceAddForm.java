package SinDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class SinInstanceAddForm extends AddForm{
	SinInstance entity = new SinInstance();
	public void setEntity(SinInstance entity) {
		this.entity = entity;
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

	SinInstanceAddForm(SinObjectModel om, String name) {
		super(om, name);
		
		
		
		
		
		this.datePanel = new AttributeValuePanel("DATE");
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
		
		this.sinnerChoosePanel = new AttributeChoosePanel(this, "SINNER",(ArrayList) this.getObjectModel().getSinners());
		
		

		this.sinChoosePanel = new AttributeChoosePanel(this, "SIN",(ArrayList) this.getObjectModel().getSins());
		
		for(ActionListener a:this.getAddButton().getActionListeners()) this.getAddButton().removeActionListener(a);
		
		
		
		this.mainPanel.add(sinnerChoosePanel);
		this.mainPanel.add(sinChoosePanel);
		this.mainPanel.add(datePanel);
		
		
	}

	@Override
	DBEntry getEntity() {
		// TODO Auto-generated method stub
		return this.entity;
	}

}
