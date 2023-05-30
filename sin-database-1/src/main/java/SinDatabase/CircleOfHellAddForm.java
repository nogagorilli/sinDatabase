package SinDatabase;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class CircleOfHellAddForm extends AddForm{
	CircleOfHell entity = new CircleOfHell();
	AttributeValuePanel namePanel;
	AttributeValuePanel descriptionPanel;
	CircleOfHellAddForm(SinObjectModel om, String name) {
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
	DBEntry getEntity() {
		return this.entity;
	}

}
