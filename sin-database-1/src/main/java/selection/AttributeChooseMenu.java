package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

abstract public class AttributeChooseMenu extends JMenu{
	static int num = 1;
	AttributeChooseMenu(String s){
		super(s);
		this.setText(s);
		
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
		public JMenuItem getNameItem() {
			return nameItem;
		}

		public void setNameItem(JMenuItem nameItem) {
			this.nameItem = nameItem;
		}

		public JMenuItem getLastNameItem() {
			return lastNameItem;
		}

		public void setLastNameItem(JMenuItem lastNameItem) {
			this.lastNameItem = lastNameItem;
		}

		public JMenuItem getDateOfDeathItem() {
			return dateOfDeathItem;
		}

		public void setDateOfDeathItem(JMenuItem dateOfDeathItem) {
			this.dateOfDeathItem = dateOfDeathItem;
		}

		public JMenuItem getCircleOfHellNameItem() {
			return circleOfHellNameItem;
		}

		public void setCircleOfHellNameItem(JMenuItem circleOfHellNameItem) {
			this.circleOfHellNameItem = circleOfHellNameItem;
		}

		public JMenuItem getIdItem() {
			return idItem;
		}

		private void setIdItem(JMenuItem idItem) {
			this.idItem = idItem;
		}

		private JMenuItem lastNameItem;
		private JMenuItem dateOfDeathItem;
		private JMenuItem circleOfHellNameItem;
		private JMenuItem idItem;
		private JMenuItem hasSinItem;
		
		SinnerMenu(String s) {
			super(s);
			System.out.println("total number is: " + num++);
			nameItem = new JMenuItem("NAME");
			lastNameItem = new JMenuItem("LASTNAME");
			dateOfDeathItem = new JMenuItem("DATE OF DEATH");
			circleOfHellNameItem = new JMenuItem("CIRCLE OF HELL");
			idItem = new JMenuItem("ID");
			hasSinItem = new JMenuItem("HAS SIN");
			
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
			hasSinItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinnerMenu.setText("HAS SIN");
				}
			});	
			this.add(nameItem);
			this.add(lastNameItem);
			this.add(dateOfDeathItem);
			this.add(circleOfHellNameItem);
			this.add(idItem);
			this.add(hasSinItem);
		}

		public JMenuItem getHasSinItem() {
			return hasSinItem;
		}

		public void setHasSinItem(JMenuItem hasSinItem) {
			this.hasSinItem = hasSinItem;
		}

	}
	
	static class DemonMenu  extends AttributeChooseMenu{
		final private DemonMenu demonMenu = this;
		private JMenuItem nameItem;
		public JMenuItem getNameItem() {
			return nameItem;
		}

		public JMenuItem getLastNameItem() {
			return lastNameItem;
		}

		public JMenuItem getExperienceItem() {
			return experienceItem;
		}

		public JMenuItem getSalaryItem() {
			return salaryItem;
		}

		public JMenuItem getCircleOfHellNameItem() {
			return circleOfHellNameItem;
		}

		public JMenuItem getIdItem() {
			return idItem;
		}

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
		private JMenuItem dateItem;
		
		SinInstancesMenu (String s) {
			super(s);
			sinnerNameItem = new JMenuItem("SINNER.NAME");
			sinnerLastNameItem = new JMenuItem("SINNER.LASTNAME");
			sinNameItem = new JMenuItem("SIN.NAME");
			dateItem = new JMenuItem("DATE");
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
			
			dateItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sinInstancesMenu.setText("DATE");
				}
			});	
			
			this.add(sinnerNameItem);
			this.add(sinnerLastNameItem);
			this.add(sinNameItem);
			this.add(idItem);
			this.add(dateItem);
		}

		public JMenuItem getSinnerNameItem() {
			return sinnerNameItem;
		}

		public void setSinnerNameItem(JMenuItem sinnerNameItem) {
			this.sinnerNameItem = sinnerNameItem;
		}

		public JMenuItem getSinnerLastNameItem() {
			return sinnerLastNameItem;
		}

		public void setSinnerLastNameItem(JMenuItem sinnerLastNameItem) {
			this.sinnerLastNameItem = sinnerLastNameItem;
		}

		public JMenuItem getSinNameItem() {
			return sinNameItem;
		}

		public void setSinNameItem(JMenuItem sinNameItem) {
			this.sinNameItem = sinNameItem;
		}

		public JMenuItem getIdItem() {
			return idItem;
		}

		public void setIdItem(JMenuItem idItem) {
			this.idItem = idItem;
		}

		public JMenuItem getDateItem() {
			return dateItem;
		}

		public void setDateItem(JMenuItem dateItem) {
			this.dateItem = dateItem;
		}

		public SinInstancesMenu getSinInstancesMenu() {
			return sinInstancesMenu;
		}
	}
	
	
}
