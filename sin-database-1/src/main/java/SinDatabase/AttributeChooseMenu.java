package SinDatabase;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

abstract public class AttributeChooseMenu extends JMenu{
	AttributeChooseMenu(String s){
		super(s);
	}
	static class SinMenu  extends AttributeChooseMenu{
		final private SinMenu sinMenu = this;
		private JMenuItem heavinessItem;
		private JMenuItem nameItem;
		private JMenuItem idItem;
		public SinMenu(String s){
			super(s);
			heavinessItem = new JMenuItem("HEAVINESS");
			nameItem = new JMenuItem("NAME");
			idItem = new JMenuItem("ID");
			
			heavinessItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinMenu.setText("HEAVINESS");
				}
			});
			
			nameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinMenu.setText("NAME");
				}
			});
			
			idItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinMenu.setText("ID");
				}
			});
			
			this.add(heavinessItem);
			this.add(nameItem);
			this.add(idItem);
			
			
		}
		public JMenuItem getHeavinessItem() {
			return heavinessItem;
		}
		public JMenuItem getNameItem() {
			return nameItem;
		}
		public JMenuItem getIdItem() {
			return idItem;
		}
	}
	
	static class SinnerMenu  extends AttributeChooseMenu{
		final private SinnerMenu sinnerMenu = this;
		private JMenuItem nameItem;
		private JMenuItem lastNameItem;
		private JMenuItem dateOfDeathItem;
		private JMenuItem circleOfHellNameItem;
		private JMenuItem idItem;
		
		SinnerMenu(String s) {
			super(s);
			nameItem = new JMenuItem("NAME");
			lastNameItem = new JMenuItem("LASTNAME");
			dateOfDeathItem = new JMenuItem("DATE OF DEATH");
			circleOfHellNameItem = new JMenuItem("CIRCLE OF HELL");
			idItem = new JMenuItem("ID");
			nameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("NAME");
				}
			});		
			lastNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("LASTNAME");
				}
			});	
			dateOfDeathItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("DATE OF DEATH");
				}
			});	
			circleOfHellNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("CIRCLE OF HELL.NAME");
				}
			});	
			idItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("ID");
				}
			});	
			this.add(nameItem);
			this.add(lastNameItem);
			this.add(dateOfDeathItem);
			this.add(circleOfHellNameItem);
			this.add(idItem);
		}

	}
	
	static class DemonMenu  extends AttributeChooseMenu{
		final private DemonMenu demonMenu = this;
		private JMenuItem nameItem;
		private JMenuItem lastNameItem;
		private JMenuItem experienceItem;
		private JMenuItem salaryItem;
		private JMenuItem circleOfHellNameItem;
		private JMenuItem idItem;
		
		DemonMenu(String s) {
			super(s);
			nameItem = new JMenuItem("NAME");
			lastNameItem = new JMenuItem("LASTNAME");
			experienceItem = new JMenuItem("EXPERIENCE");
			salaryItem = new JMenuItem("SALARY");
			circleOfHellNameItem = new JMenuItem("CIRCLE OF HELL");
			idItem = new JMenuItem("ID");
			nameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("NAME");
				}
			});		
			lastNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("LASTNAME");
				}
			});	
			
			experienceItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("EXPERIENCE");
				}
			});	
			
			salaryItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("SALARY");
				}
			});	
			
			circleOfHellNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("CIRCLE OF HELL.NAME");
				}
			});	
			idItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					demonMenu.setText("ID");
				}
			});	
			this.add(nameItem);
			this.add(lastNameItem);
			this.add(experienceItem);
			this.add(salaryItem);
			this.add(circleOfHellNameItem);
			this.add(idItem);
		}

	}
	
	static class CirclesMenu  extends AttributeChooseMenu{
		final private CirclesMenu circlesMenu = this;
		private JMenuItem nameItem;
		private JMenuItem idItem;
		
		CirclesMenu(String s) {
			super(s);
			nameItem = new JMenuItem("NAME");
			idItem = new JMenuItem("ID");
			
			nameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					circlesMenu.setText("NAME");
				}
			});		
			
			idItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					circlesMenu.setText("ID");
				}
			});	
			
			this.add(nameItem);
			this.add(idItem);
		}
	}
	
	static class SinInstancesMenu  extends AttributeChooseMenu{
		final private SinInstancesMenu  sinInstancesMenu = this;
		private JMenuItem sinnerNameItem;
		private JMenuItem sinnerLastNameItem;
		private JMenuItem sinNameItem;
		private JMenuItem idItem;
		
		SinInstancesMenu (String s) {
			super(s);
			sinnerNameItem = new JMenuItem("SINNER.NAME");
			sinnerLastNameItem = new JMenuItem("SINNER.LASTNAME");
			sinNameItem = new JMenuItem("SIN.NAME");
			idItem = new JMenuItem("ID");
			
			sinnerNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinInstancesMenu.setText("SINNER.NAME");
				}
			});	
			
			sinnerLastNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinInstancesMenu.setText("SINNER.LASTNAME");
				}
			});		
			
			sinNameItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinInstancesMenu.setText("SIN.NAME");
				}
			});	
			
			idItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinInstancesMenu.setText("ID");
				}
			});	
			
			this.add(sinnerNameItem);
			this.add(sinnerLastNameItem);
			this.add(sinNameItem);
			this.add(idItem);
		}
	}
	
	
}
