package editing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import addition.CircleOfHellAddForm;
import addition.DemonAddForm;
import addition.SinAddForm;
import addition.SinInstanceAddForm;
import addition.SinnerAddForm;
import entities.CircleOfHell;
import entities.DBEntry;
import entities.Demon;
import entities.Sin;
import entities.SinInstance;
import entities.Sinner;
import sinDatabase.SinGUI;
import sinDatabase.SinObjectModel;

public class EditForm extends JFrame{
	JMenuBar tableChooseBar;
	JMenu tableMenu;
	JTextField idField;
	JTextPane tableText;
	JTextPane idText;
	JPanel idPanel;
	JPanel tablePanel;
	JButton editButton;
	private SinGUI parentGUI;
	private SinObjectModel objectModel;
	public EditForm(SinObjectModel om,SinGUI gui){
		super("EDIT");
		parentGUI = gui;
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setSize(new Dimension(500,150));
		this.setLayout(new GridLayout(3,1));
		this.setResizable(false);
		this.objectModel = om;
		//Initializing fields
		this.tableChooseBar = new JMenuBar();
		this.tableMenu = new JMenu();
		idField = new JTextField("0");
		tableText = new JTextPane();
		tableText.setText("TABLE");
		tableText.setFocusable(false);
		idText = new JTextPane();
		idText.setText("ID");
		idText.setFocusable(false);
		idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout());
		tablePanel = new JPanel();
		tablePanel.setLayout(new FlowLayout());
		editButton = new JButton("EDIT");
		
		//Assembling frame
		
		
		this.add(tablePanel);
		this.add(idPanel);
		this.add(editButton);
		
		idPanel.add(idText);
		idPanel.add(idField);
		idField.setPreferredSize(new Dimension(100,20));
		
		
		tablePanel.add(tableText);
		tablePanel.add(tableChooseBar);
		tableChooseBar.add(tableMenu);
		
		tableMenu.add(new tableMenuItem ("SINNERS",tableMenu));
		tableMenu.add(new tableMenuItem ("DEMONS",tableMenu));
		tableMenu.add(new tableMenuItem ("SINS",tableMenu));
		tableMenu.add(new tableMenuItem ("SIN INSTANCES",tableMenu));
		tableMenu.add(new tableMenuItem ("CIRCLES OF HELL",tableMenu));
		tableMenu.setText("SINNERS");
		
		editButton.addActionListener(new editClickListener());
		this.setVisible(true);
		
	}
	private class editClickListener implements ActionListener{
		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ArrayList<DBEntry> entries;
			DBEntry entry;
			EntityManager em = objectModel.getEntityManager();
			int id;
			dispose();
			try {
				id = Integer.parseInt(idField.getText());
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(getContentPane(), "Invalid id");
				return;
			}
			if(tableMenu.getText().equals("SINNERS")) {
				entries = (ArrayList<DBEntry>) em.createQuery("select obj from Sinner obj where id = "+String.valueOf(id)).getResultList();
				
				try {
					entry = entries.get(0);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "No entry with such id");
					return;
				}
				try {
					Sinner clone = ((Sinner)entry).clone();
					SinnerAddForm addForm = new SinnerAddForm(objectModel, "Edit sinner");
					addForm.setEntity(clone);
					addForm.getAddButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							addForm.dispose();
							clone.setCircleOfHell((CircleOfHell) addForm.getCircleChoosePanel().getEntry());
							((Sinner)entry).setCircleOfHell(clone.getCircleOfHell());
							((Sinner)entry).setDateOfDeath(clone.getDateOfDeath());
							((Sinner)entry).setLastName(clone.getLastName());
							((Sinner)entry).setName(clone.getName());
							objectModel.loadSingleDBEntry(entry);
							parentGUI.tables.LoadObjectModel(objectModel);
						}
					});
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Clone not supported");
					return;
				}
				
				
				
			}else if(tableMenu.getText().equals("DEMONS")) {
				entries = (ArrayList<DBEntry>) em.createQuery("select obj from Demon obj where id = "+String.valueOf(id)).getResultList();
				
				try {
					entry = entries.get(0);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "No entry with such id");
					return;
				}
				try {
					Demon clone = ((Demon)entry).clone();
					DemonAddForm addForm = new DemonAddForm(objectModel, "Edit sinner");
					addForm.setEntity(clone);
					addForm.getAddButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							addForm.dispose();
							
							clone.setCircleOfHell((CircleOfHell) addForm.getCircleChoosePanel().getEntry());
							((Demon)entry).setCircleOfHell(clone.getCircleOfHell());
							((Demon)entry).setExperience(clone.getExperience());
							((Demon)entry).setLastName(clone.getLastName());
							((Demon)entry).setName(clone.getName());
							((Demon)entry).setSalary(clone.getSalary());
							objectModel.loadSingleDBEntry(entry);
							parentGUI.tables.LoadObjectModel(objectModel);
						}
					});
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Clone not supported");
					return;
				}
				
				
			}else if(tableMenu.getText().equals("SINS")) {
				entries = (ArrayList<DBEntry>) em.createQuery("select obj from Sin obj where id = "+String.valueOf(id)).getResultList();
				
				try {
					entry = entries.get(0);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "No entry with such id");
					return;
				}
				try {
					Sin clone = ((Sin)entry).clone();
					SinAddForm addForm = new SinAddForm(objectModel, "Edit sinner");
					addForm.setEntity(clone);
					addForm.getAddButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							addForm.dispose();
							((Sin)entry).setHeaviness(clone.getHeaviness());
							((Sin)entry).setName(clone.getName());
							
							objectModel.loadSingleDBEntry(entry);
							parentGUI.tables.LoadObjectModel(objectModel);
						}
					});
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Clone not supported");
					return;
				}
				
				
			}else if(tableMenu.getText().equals("SIN INSTANCES")) {
				entries = (ArrayList<DBEntry>) em.createQuery("select obj from SinInstance obj where id = "+String.valueOf(id)).getResultList();
				
				try {
					entry = entries.get(0);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "No entry with such id");
					return;
				}
				try {
					SinInstance clone = ((SinInstance)entry).clone();
					
					SinInstanceAddForm addForm = new SinInstanceAddForm(objectModel, "Edit sinner");
					addForm.setEntity(clone);
					addForm.getAddButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							addForm.dispose();
							clone.setSinner((Sinner)addForm.getSinnerChoosePanel().getEntry());
							clone.setSin((Sin)addForm.getSinChoosePanel().getEntry());
							((SinInstance)entry).setDate(clone.getDate());
							((SinInstance)entry).setSin(clone.getSin());
							((SinInstance)entry).setSinner(clone.getSinner());
							
							objectModel.loadSingleDBEntry(entry);
							parentGUI.tables.LoadObjectModel(objectModel);
						}
					});
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Clone not supported");
					return;
				}
				
				
			}else if(tableMenu.getText().equals("CIRCLES OF HELL")) {
				entries = (ArrayList<DBEntry>) em.createQuery("select obj from CircleOfHell obj where id = "+String.valueOf(id)).getResultList();
				try {
					entry = entries.get(0);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "No entry with such id");
					return;
				}
				try {
					CircleOfHell clone = ((CircleOfHell)entry).clone();
					
					CircleOfHellAddForm addForm = new CircleOfHellAddForm(objectModel, "Edit sinner");
					addForm.setEntity(clone);
					addForm.getAddButton().addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							addForm.dispose();
							((CircleOfHell)entry).setDescription(clone.getDescription());
							((CircleOfHell)entry).setName(clone.getName());
							
							objectModel.loadSingleDBEntry(entry);
							parentGUI.tables.LoadObjectModel(objectModel);
						}
					});
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(getContentPane(), "Clone not supported");
					return;
				}
				
				
			}else {
				JOptionPane.showMessageDialog(getContentPane(), "You somehow chose table that was not supposed to exist (:-{) ");
				return;
			}
			
			
			
		}
		
	}
	
	
	private class tableMenuItem extends JMenuItem{
		private JMenu parent;
		tableMenuItem(String s, JMenu parentMenu){
			super(s);
			parent = parentMenu;
			addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					parent.setText(getText());
				}
			});
		}
	}
}
