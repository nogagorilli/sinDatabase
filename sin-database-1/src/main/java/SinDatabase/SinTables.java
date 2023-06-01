package SinDatabase;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

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
	private DefaultTableModel sinInstanceModel;
	private JScrollPane sinInstanceScroll;
	private Class selectedClass = Object.class;
	
	public Class getSelectedClass() {
		return selectedClass;
	}

	public void setSelectedClass(Class selectedClass) {
		this.selectedClass = selectedClass;
	}

	private JScrollPane selectedScroll;
	
	public JScrollPane getSelectedScroll() {
		return selectedScroll;
	}

	public void setSelectedScroll(JScrollPane selectedScroll) {
		this.selectedScroll = selectedScroll;
	}

	SinTables(int x,int y,int width,int height){
		super();
		
		String [] demonColumns = Demon.getTableColumns();
        String [][] demonData = {};
        demonModel= new DefaultTableModel(demonData, demonColumns);
        JTable demons = new JTable(demonModel);
        demonScroll = new JScrollPane(demons);
        demonScroll.setBounds(0,0,width,height);
        
        
        String [] sinnerColumns = Sinner.getTableColumns();
        String [][] sinnerData = {};
        sinnerModel= new DefaultTableModel(sinnerData, sinnerColumns);
        JTable sinners = new JTable(sinnerModel);
        sinnerScroll = new JScrollPane(sinners);
        sinnerScroll.setBounds(0,0,width,height);
        
        
        String [] sinColumns = Sin.getTableColumns();
        String [][] sinData = {};
        sinModel= new DefaultTableModel(sinData, sinColumns);
        JTable sins = new JTable(sinModel);
        sinScroll = new JScrollPane(sins);
        sinScroll.setBounds(0,0,width,height);
        
        
        
        String [] circleColumns = CircleOfHell.getTableColumns();
        String [][] circleData = {};
        circleModel= new DefaultTableModel(circleData, circleColumns);
        JTable circles = new JTable(circleModel);
        circleScroll = new JScrollPane(circles);
        circleScroll.setBounds(0,0,width,height);
        
        
        String [] sinInstColumns = SinInstance.getTableColumns();
        String [][] sinInstData = {};
        sinInstanceModel= new DefaultTableModel(sinInstData, sinInstColumns);
        JTable sinInstances = new JTable(sinInstanceModel);
        sinInstanceScroll = new JScrollPane(sinInstances);
        sinInstanceScroll.setBounds(0,0,width,height);
        
        
        this.setBorder(BorderFactory.createLineBorder(Color.black,5));
        this.setBackground(Color.DARK_GRAY);
        this.setBounds(x,y,width,height);
        this.setLayout(null);
        sinScroll.setFocusable(false);
        demonScroll.setFocusable(false);
        sinnerScroll.setFocusable(false);
        sinInstanceScroll.setFocusable(false);
        circleScroll.setFocusable(false);
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
		this.revalidate();
		this.repaint();

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
		System.out.println("aaaaaaaaaaaaaaaaaa");
		this.moveTableOnTop(sinInstanceScroll);
	}
	public void openSelectedTable() {
		System.out.println("bbbbbbbbbbbbbbbbbb");
		this.moveTableOnTop(selectedScroll);
	}
	public void setSelected(JScrollPane scroll) {
		this.selectedScroll = scroll;
		this.selectedScroll.setFocusable(false);
		this.selectedScroll.setEnabled(false);
		this.selectedScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(selectedScroll,JLayeredPane.DEFAULT_LAYER);
		this.openSelectedTable();
	}
	
	public void LoadObjectModel(SinObjectModel objectModel) {
		objectModel.update();
		this.removeAll();
		DefaultTableModel tableModel;
		String[] columns;
		this.setSelectedScroll(null);
		this.setSelectedClass(Object.class);
		
		// Adding demons
		columns = Demon.getTableColumns();
		tableModel = new DefaultTableModel(columns, 0);
		for(Demon temp:objectModel.getDemons()) {
			tableModel.addRow(temp.getTableRow());
		}
		this.demonScroll = new JScrollPane(new JTable(tableModel));
		this.demonScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.demonScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sinners
		columns = Sinner.getTableColumns();
		tableModel = new DefaultTableModel(columns, 0);
		for(Sinner temp:objectModel.getSinners()) {
			tableModel.addRow(temp.getTableRow());
		}
		this.sinnerScroll = new JScrollPane(new JTable(tableModel));
		this.sinnerScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinnerScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sins
		columns = Sin.getTableColumns();
		tableModel = new DefaultTableModel(columns, 0);
		for(Sin temp:objectModel.getSins()) {
			tableModel.addRow(temp.getTableRow());
		}
		this.sinScroll = new JScrollPane(new JTable(tableModel));
		this.sinScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding circles of hell
		columns = CircleOfHell.getTableColumns();
		tableModel = new DefaultTableModel(columns, 0);
		for(CircleOfHell temp:objectModel.getCirclesOfHell()) {
			tableModel.addRow(temp.getTableRow());
		}
		this.circleScroll = new JScrollPane(new JTable(tableModel));
		this.circleScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.circleScroll,JLayeredPane.DEFAULT_LAYER);
		
		// Adding sin instances
		columns = SinInstance.getTableColumns();
		tableModel = new DefaultTableModel(columns, 0);
		for(SinInstance temp:objectModel.getSinInstances()) {
			System.out.println("aaaaa");
			tableModel.addRow(temp.getTableRow());
		}
		this.sinInstanceScroll = new JScrollPane(new JTable(tableModel));
		this.sinInstanceScroll.setBounds(0,0,this.getWidth(),this.getHeight());
		this.add(this.sinInstanceScroll,JLayeredPane.DEFAULT_LAYER);
		
				
	}
	
	
//	public void updateTables() {
//		
//		// Does not work
//		
//		this.removeAll();
//		selectedScroll.setBounds(0,0,this.getWidth(),this.getHeight());
//		this.add(selectedScroll,JLayeredPane.DEFAULT_LAYER);
//		this.add(demonScroll,JLayeredPane.DEFAULT_LAYER);
//		this.add(circleScroll,JLayeredPane.DEFAULT_LAYER);
//		this.add(sinInstanceScroll,JLayeredPane.DEFAULT_LAYER);
//		this.add(sinScroll,JLayeredPane.DEFAULT_LAYER);
//		this.add(sinnerScroll,JLayeredPane.DEFAULT_LAYER);
//		revalidate();
//		repaint();
//	}
	
}
