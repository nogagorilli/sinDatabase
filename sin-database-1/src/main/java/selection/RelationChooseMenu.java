package selection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class RelationChooseMenu extends JMenu{
	final private RelationChooseMenu relationChooseMenu = this;
	public JMenuItem equalItem;
	public JMenuItem moreItem;
	public JMenuItem lessItem;
	RelationChooseMenu(){
		super("=");
		equalItem = new JMenuItem("=");
		moreItem = new JMenuItem(">");
		lessItem = new JMenuItem("<");
		
		equalItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				relationChooseMenu.setText("=");
			}
		});
		
		moreItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				relationChooseMenu.setText(">");
			}
		});
		
		lessItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				relationChooseMenu.setText("<");
			}
		});
		
		this.add(equalItem);
		this.add(moreItem);
		this.add(lessItem);
	}

}
