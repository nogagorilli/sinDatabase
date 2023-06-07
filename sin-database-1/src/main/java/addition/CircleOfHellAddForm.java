package addition;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import entities.CircleOfHell;
import entities.DBEntry;
import sinDatabase.SinObjectModel;

public class CircleOfHellAddForm extends AddForm{
	CircleOfHell entity = new CircleOfHell();
	AttributeValuePanel namePanel;
	AttributeValuePanel descriptionPanel;
	public CircleOfHellAddForm(SinObjectModel om, String name) {
		super(om, name);
		namePanel = new AttributeValuePanel("NAME");
		namePanel.getAttrValueField().addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				System.out.println("name updated");
				entity.setName(namePanel.getAttrValueField().getText());
				System.out.println(entity.getName());
			}
			
		});
		
		
		
		
		descriptionPanel = new AttributeValuePanel("DESCRIPTION");
		descriptionPanel.getAttrValueField().addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setDescription( descriptionPanel.getAttrValueField().getText());
				}catch(Exception ex) {
					entity.setDescription("---------------");
				}
			}
			
		});
		
		this.mainPanel.add(namePanel);
		this.mainPanel.add(descriptionPanel);
		
	}
	@Override
	public DBEntry getEntity() {
		return this.entity;
	}
	public void setEntity(CircleOfHell entity) {
		this.entity = entity;
		this.namePanel.getAttrValueField().setText(entity.getName());
		this.descriptionPanel.getAttrValueField().setText(entity.getDescription());
		
	}
}
