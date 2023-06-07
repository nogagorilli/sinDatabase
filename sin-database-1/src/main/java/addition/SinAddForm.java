package addition;

import javax.persistence.EntityManager;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import entities.DBEntry;
import entities.Sin;
import sinDatabase.SinObjectModel;

public class SinAddForm extends AddForm{
	Sin entity = new Sin();
	AttributeValuePanel namePanel;
	AttributeValuePanel heavinessPanel;
	public SinAddForm(SinObjectModel om, String name) {
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
	public DBEntry getEntity() {
		
		return this.entity;
	}
	
	public void setEntity(Sin entity) {
		System.out.println("setting an entity");
		this.entity = entity;
		this.namePanel.getAttrValueField().setText(entity.getName());
		this.heavinessPanel.getAttrValueField().setText(String.valueOf( entity.getHeaviness()));
		revalidate();
		
	}
	

}
