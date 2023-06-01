package SinDatabase;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;



abstract class QueryPanel extends JPanel implements DBOperator {
	final private QueryPanel queryPanel = this;
	
	private ArrayList<WherePanel> wherePanels;
	private JMenuBar tableChooseBar;
	private TableChooseMenu tableChooser;
	private JButton andButton;
	public JTextArea getQueryTextField() {
		return queryTextField;
	}

	public void setQueryTextField(JTextArea queryTextField) {
		this.queryTextField = queryTextField;
	}

	protected JTextArea queryTextField;
	private JTextArea whereTextField;
	QueryPanel(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		this.wherePanels = new ArrayList<WherePanel>();
		queryTextField = new JTextArea("SELECT ENTRIES FROM");
		queryTextField.setFocusable(false);
		this.add(queryTextField);
		
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
				queryPanel.getParent().repaint();
				
			}
			
		});
		
		
		this.add(andButton);
		
		
		updatePanels();
	}
	
	public void updatePanels() {
		this.removeAll();
		this.add(queryTextField);
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
			AttributeChooseMenu attr = new AttributeChooseMenu.SinMenu("ID");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.sinnersItem.getText())) {
			System.out.println("sinners");
			AttributeChooseMenu attr = new AttributeChooseMenu.SinnerMenu("ID");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.sinInstancesItem.getText())) {
			System.out.println("sin instances");
			AttributeChooseMenu attr = new AttributeChooseMenu.SinInstancesMenu("ID");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.demonsItem.getText())) {
			System.out.println("demons");
			AttributeChooseMenu attr = new AttributeChooseMenu.DemonMenu("ID");
			WherePanel where = new WherePanel();
			where.setAttributeChooser(attr);
			wherePanels.add(where);
		}else if(tableChooser.getText().equals(tableChooser.circlesOfHellItem.getText())) {
			System.out.println("circles");
			AttributeChooseMenu attr = new AttributeChooseMenu.CirclesMenu("ID");
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
			put("ID", "obj.id");
		    put("NAME", "obj.name");
		    put("LASTNAME", "obj.lastName");
		    put("EXPERIENCE", "obj.experienceInDays");
		    put("SALARY", "obj.salary");
		    put("CIRCLE OF HELL.NAME", "obj.circle.name");
		    put("DATE OF DEATH", "obj.dateOfDeath");
		    put("HEAVINESS", "obj.heaviness");
		    put("SINNER.NAME", "obj.sinner.name");
		    put("SINNER.LASTNAME", "obj.sinner.lastName");
		    put("SIN.NAME", "obj.sin.name");
		    put("DATE", "obj.date");
		}};
		HashMap<String,String> wrapperMap = new HashMap<String, String>() {{
			put("ID", "int");
		    put("NAME", "str");
		    put("LASTNAME", "str");
		    put("EXPERIENCE", "int");
		    put("SALARY", "int");
		    put("CIRCLE OF HELL.NAME", "str");
		    put("DATE OF DEATH", "int");
		    put("HEAVINESS", "int");
		    put("SINNER.NAME", "str");
		    put("SINNER.LASTNAME", "str");
		    put("SIN.NAME", "str");
		    put("DATE", "int");
		}};
		
		HashMap<String,String> relationMap = new HashMap<String, String>() {{
		    put(" = ", " = ");
		    put(">", " > ");
		    put("<", " < ");
		}};
		
		String query = "";
		query = query+"obj from ";
		query = query+ tableMap.get(tableChooser.getText());
		query = query+ " obj";
		if(wherePanels.size() != 0) {
			query+=" WHERE ";
			query+=" ( ";
			for(int i = 0;i<wherePanels.size();i++) {
				if(i != 0) {
					query+= " and ";
				}
				WherePanel panel = wherePanels.get(i);
				query+= attributeMap.get(panel.getAttribute());
				query+= relationMap.get(panel.getRelation());
				String attr = panel.getAttributeValue().replaceAll("\"", "").replaceAll("'", "");
				if (wrapperMap.get(panel.getAttribute()) == "str") {
					attr = "'" + attr+ "'";
				}
				query+=attr;
			}
			query+=" ) ";
		}
		return query;
	}
	private Boolean isAlikeNumber(String s) {
		if(s.length() == 0) return false;
		char c =s.charAt(0);
		if(Character.isDigit(c)||c == '-') {
			return true;
		}
		return false;
	}
}
