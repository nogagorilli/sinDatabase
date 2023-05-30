package SinDatabase;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class SinAddForm extends AddForm{
	Sin entity = new Sin();
	AttributeValuePanel namePanel;
	AttributeValuePanel heavinessPanel;
	SinAddForm(SinObjectModel om, String name) {
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
		
		
		
		
		heavinessPanel = new AttributeValuePanel("HEAVINESS");
		heavinessPanel.getAttrValueField().addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
				try {
					entity.setHeaviness(Float.parseFloat( heavinessPanel.getAttrValueField().getText()));
				}catch(Exception ex) {
					entity.setHeaviness(0);
				}
			}
			
		});
		
		this.mainPanel.add(namePanel);
		this.mainPanel.add(heavinessPanel);
		
	}
	@Override
	DBEntry getEntity() {
		
		return this.entity;
	}

}
