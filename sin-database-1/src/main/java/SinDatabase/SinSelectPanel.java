package SinDatabase;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuListener;



public class SinSelectPanel extends JPanel implements DBOperator {
	final private SinSelectPanel sinSelectPanel = this;
	
	private ArrayList<WherePanel> wherePanels;
	private JMenuBar tableChooseBar;
	private TableChooseMenu tableChooser;
	private JButton andButton;
	private JTextArea selectTextField;
	private JTextArea whereTextField;
	SinSelectPanel(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.wherePanels = new ArrayList<WherePanel>();
		selectTextField = new JTextArea("SELECT ENTRIES FROM");
		selectTextField.setFocusable(false);
		this.add(selectTextField);
		
		tableChooseBar = new JMenuBar();
		tableChooser = new TableChooseMenu();
		
		tableChooseBar.add(tableChooser);
		System.out.println(tableChooser.getComponents().length);
		
		
		this.add(tableChooseBar);
		for(JMenuItem j:new JMenuItem[]{tableChooser.demonsItem,
				tableChooser.sinnersItem, tableChooser.sinsItem,
				tableChooser.circlesOfHellItem, tableChooser.sinInstancesItem,
				tableChooser.selectedItem}) {
			j.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					wherePanels.clear();
					updatePanels();
				}
			});
			
		}
		
		whereTextField = new JTextArea("WHERE");
		whereTextField.setFocusable(false);
		this.add(whereTextField);
		
		andButton = new JButton("add parameter");
		
		andButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addNewWherePanel();
				updatePanels();
				sinSelectPanel.getParent().repaint();
				
			}
			
		});
		
		
		this.add(andButton);
		
		
		updatePanels();
	}
	
	public void updatePanels() {
		this.removeAll();
		this.add(selectTextField);
		this.add(tableChooseBar);
		this.add(whereTextField);
		for(int i = 0;i<wherePanels.size();i++) {
			if(i != 0) {
				JTextArea and = new JTextArea("and");
				and.setFocusable(false);
				this.add(and);
			}
			this.add(wherePanels.get(i));
		}
		this.add(andButton);
		revalidate();
		repaint();
	}
	
	
	public void addNewWherePanel() {
		if(tableChooser.getText().equals(tableChooser.sinsItem.getText())) {
			System.out.println("sins");
			AttributeChooseMenu attr = new AttributeChooseMenu.SinMenu("attribute");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.sinnersItem.getText())) {
			System.out.println("sinners");
			AttributeChooseMenu attr = new AttributeChooseMenu.SinnerMenu("attribute");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.sinInstancesItem.getText())) {
			System.out.println("sin instances");
			AttributeChooseMenu attr = new AttributeChooseMenu.SinInstancesMenu("attribute");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.demonsItem.getText())) {
			System.out.println("demons");
			AttributeChooseMenu attr = new AttributeChooseMenu.DemonMenu("attribute");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.circlesOfHellItem.getText())) {
			System.out.println("circles");
			AttributeChooseMenu attr = new AttributeChooseMenu.CirclesMenu("attribute");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}
	}

	@Override
	public String createHQLQuery() {
		
		HashMap<String,String> tableMap = new HashMap<String, String>() {{
		    put("DEMONS", "Demon");
		    put("SINNERS", "Sinner");
		    put("SINS", "Sin");
		    put("CIRCLES OF HELL", "CircleOfHell");
		    put("SIN INSTANCES", "SinInstance");
		}};
		
		HashMap<String,String> attributeMap = new HashMap<String, String>() {{
		    put("DEMONS", "Demon");
		    put("SINNERS", "Sinner");
		    put("SINS", "Sin");
		    put("CIRCLES OF HELL", "CircleOfHell");
		    put("SIN INSTANCES", "SinInstance");
		}};
		
		
		String query = "";
		query = query+"SELECT object from ";
		query = query+ tableMap.get(tableChooser.getText());
		query = query+ " object";
		if(wherePanels.size() != 0) {
			query+=" WHERE ";
			query+=" ( ";
			for(int i = 0;i<wherePanels.size();i++) {
				if(i != 0) {
					query+= " && ";
				}
				WherePanel panel = wherePanels.get(i);
				query+= panel.getAttribute();
				query+= panel.getRelation();
				query+= panel.getAttributeValue();
				
			}
			query+=" )";
		}
		return query;
	}
}
