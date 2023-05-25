package SinDatabase;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class TableChooseMenu extends JMenu {
	final private TableChooseMenu tableChooseMenu = this;
	public JMenuItem demonsItem;
	public JMenuItem sinnersItem;
	public JMenuItem sinsItem;
	public JMenuItem circlesOfHellItem;
	public JMenuItem sinInstancesItem;
	public JMenuItem selectedItem;
	private String prevText;
	TableChooseMenu(){
		super("select a table");
		demonsItem = new JMenuItem("DEMONS");
		sinnersItem = new JMenuItem("SINNERS");
		sinsItem = new JMenuItem("SINS");
		circlesOfHellItem = new JMenuItem("CIRCLES OF HELL");
		sinInstancesItem = new JMenuItem("SIN INSTANCES");
		selectedItem = new JMenuItem("SELECTED");
		
		demonsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("DEMONS");
			}
		});
		
		sinnersItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("SINNERS");
			}
		});
		
		sinsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("SINS");
			}
		});
		
		circlesOfHellItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("CIRCLES OF HELL");
			}
		});
		
		sinInstancesItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("SIN INSTANCES");
			}
		});
		
		selectedItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tableChooseMenu.setText("SELECTED");
			}
		});
		this.setBackground(Color.black);
		this.add(demonsItem);
		this.add(sinnersItem);
		this.add(sinsItem);
		this.add(circlesOfHellItem);
		this.add(sinInstancesItem);
		this.add(selectedItem);		
	}
	@Override
	public void setText(String s) {
		prevText = this.getText();
		super.setText(s);
	}
	public String getPrevText() {
		return prevText;
	}
	
	
	
	
}
