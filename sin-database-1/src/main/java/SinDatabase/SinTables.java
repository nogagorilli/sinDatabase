package SinDatabase;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SinTables extends JLayeredPane{
	private JScrollPane sinnerScroll;
	private DefaultTableModel sinnerModel;
	private JScrollPane demonScroll;
	private DefaultTableModel demonModel;
	private JScrollPane sinScroll;
	private DefaultTableModel sinModel;
	private JScrollPane circleScroll;
	private DefaultTableModel circleModel;
	private JScrollPane choosedScroll;
	private JScrollPane sinIstanceScroll;
	private DefaultTableModel sinInstanceModel;
	private JScrollPane sinInstanceScroll;
	
	SinTables(int x,int y,int width,int height){
		super();
		String [] demonColumns = {"ID", "NAME", "LASTNAME","EXPERIENCE","SALARY","CIRCLE OF HELL"};
        String [][] demonData = {{"1", "Mephisto", "Phel","100 days","666","9"},
        {"2", "Molag","Baal","novice","12","1"}};
        demonModel= new DefaultTableModel(demonData, demonColumns);
        JTable demons = new JTable(demonModel);
        demonScroll = new JScrollPane(demons);
        demonScroll.setBounds(0,0,width,height);
        
        
        
        
        
        
        
        
        
        String [] sinnerColumns = {"ID", "NAME", "LASTNAME","DATE OF DEATH","CIRCLE OF HELL"};
        String [][] sinnerData = {{"1", "Alexander", "Kondakov","22.02.2040","9"},
        {"2", "Alexander", "Varfolomeev","22.02.2099","1"}};
        sinnerModel= new DefaultTableModel(sinnerData, sinnerColumns);
        JTable sinners = new JTable(sinnerModel);
        sinnerScroll = new JScrollPane(sinners);
        sinnerScroll.setBounds(0,0,width,height);
        
        
        String [] sinColumns = {"ID", "NAME", "HEAVINESS"};
        String [][] sinData = {{"1", "Murder", "100"},
        {"2", "Robbery", "20"}};
        sinModel= new DefaultTableModel(sinData, sinColumns);
        JTable sins = new JTable(sinModel);
        sinScroll = new JScrollPane(sins);
        sinScroll.setBounds(0,0,width,height);
        
        
        
        String [] circleColumns = {"ID", "NAME", "DESCRIPTION"};
        String [][] circleData = {{"1", "fire", "people burn here"},
        {"2", "frost", "people freeze here"},{"3", "pot", "people boil here"}};
        circleModel= new DefaultTableModel(circleData, circleColumns);
        JTable circles = new JTable(circleModel);
        circleScroll = new JScrollPane(circles);
        circleScroll.setBounds(0,0,width,height);
        
        
        String [] sinInstColumns = {"ID", "SINNER", "SIN","DATE"};
        String [][] sinInstData = {{"1", "Alek", "murder","08.09.10"}};
        sinInstanceModel= new DefaultTableModel(sinInstData, sinInstColumns);
        JTable sinInstances = new JTable(sinInstanceModel);
        sinInstanceScroll = new JScrollPane(sinInstances);
        sinInstanceScroll.setBounds(0,0,width,height);
        
        
        this.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        
        this.add(sinScroll,JLayeredPane.DEFAULT_LAYER);
        this.add(demonScroll,JLayeredPane.DEFAULT_LAYER);
        this.add(sinnerScroll,JLayeredPane.DEFAULT_LAYER);
        this.add(circleScroll,JLayeredPane.DEFAULT_LAYER);
        
        
        this.add(sinInstanceScroll,JLayeredPane.DEFAULT_LAYER);
        this.setLayer(sinInstanceScroll,JLayeredPane.PALETTE_LAYER);
        
	}
	
	private void moveTableOnTop(JScrollPane panel) {
		Component[] components;
		components = this.getComponents();
		for(Component comp: components) {
			comp.setEnabled(false);
			comp.setFocusable(false);
			this.setLayer(comp, JLayeredPane.DEFAULT_LAYER);
		}
		this.setLayer(panel, JLayeredPane.PALETTE_LAYER);

	}
	public void openSinTable() {
		this.moveTableOnTop(sinScroll);
	}
	public void openSinnerTable() {
		this.moveTableOnTop(sinnerScroll);
	}
	public void openDemonTable() {
		this.moveTableOnTop(demonScroll);
	}
	public void openCircleTable() {
		this.moveTableOnTop(circleScroll);
	}
	public void openSinInstanceTable() {
		this.moveTableOnTop(sinInstanceScroll);
	}
	
	public void LoadObjectModel(SinObjectModel objectModel) {
		DefaultTableModel tableModel;
		String[] columns;
		
		// Adding demons
		columns = new String[] {"ID", "NAME", "LASTNAME","EXPERIENCE","SALARY","CIRCLE OF HELL"};
		tableModel = new DefaultTableModel(columns, 0);
		for(Demon temp:objectModel.getDemons()) {
			tableModel.addRow(new String[] {Integer.toString(temp.getId()),temp.getName(),temp.getLastName(),Integer.toString(temp.getExperience()),Integer.toString(temp.getSalary()),temp.getCircleOfHell().getName()});
		}
		this.demonScroll = new JScrollPane(new JTable(tableModel));
		this.demonScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.demonScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sinners
		columns = new String[] {"ID", "NAME", "LASTNAME","DATE OF DEATH","CIRCLE OF HELL"};
		tableModel = new DefaultTableModel(columns, 0);
		for(Sinner temp:objectModel.getSinners()) {
			tableModel.addRow(new String[] {Integer.toString(temp.getId()),temp.getName(),temp.getLastName(),temp.getDateOfDeath().toString(),temp.getCircleOfHell().getName()});
		}
		this.sinnerScroll = new JScrollPane(new JTable(tableModel));
		this.sinnerScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinnerScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sins
		columns = new String[] {"ID", "NAME", "HEAVINESS"};
		tableModel = new DefaultTableModel(columns, 0);
		for(Sin temp:objectModel.getSins()) {
			tableModel.addRow(new String[] {Integer.toString(temp.getId()),temp.getName(),Float.toString(temp.getHeaviness())});
		}
		this.sinScroll = new JScrollPane(new JTable(tableModel));
		this.sinScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding circles of hell
		columns = new String[] {"ID", "NAME", "DESCRIPTION"};
		tableModel = new DefaultTableModel(columns, 0);
		for(CircleOfHell temp:objectModel.getCirclesOfHell()) {
			tableModel.addRow(new String[] {Integer.toString(temp.getId()),temp.getName(),temp.getDescription()});
		}
		this.circleScroll = new JScrollPane(new JTable(tableModel));
		this.circleScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.circleScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sin instances
		columns = new String[] {"ID", "SINNER", "SIN","DATE"};
		tableModel = new DefaultTableModel(columns, 0);
		for(SinInstance temp:objectModel.getSinInstances()) {
			System.out.println("aaaaa");
			tableModel.addRow(new String[] {Integer.toString(temp.getId()),temp.getSinner().getName()+" "+temp.getSinner().getLastName(),temp.getSin().getName(),temp.getDate().toString()});
		}
		this.sinInstanceScroll = new JScrollPane(new JTable(tableModel));
		this.sinInstanceScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinInstanceScroll,JLayeredPane.DEFAULT_LAYER);
				
	}
}
