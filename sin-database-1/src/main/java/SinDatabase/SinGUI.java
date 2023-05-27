package SinDatabase;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SinGUI extends JFrame{
	
	
	
	
	private int WIDTH = 1280;
	private int HEIGHT = 720;
	private JPanel demonPanel;
	private JPanel buttonPanel;
	private JPanel choosePanel;
	
	
	
	//Class for creating selection queries;
	private SinSelectForm sinSelectForm;
	
	
	//Class where all data is contained and where all operations with data are executed
	private SinObjectModel objectModel;
	
	
	//Panels to display information
	private SinTables tables;

	
	//Buttons for action selection
	private sinGUIButton addButton;
	private sinGUIButton deleteButton;
	private sinGUIButton selectButton;
	private sinGUIButton saveButton;
	private sinGUIButton loadButton;
	private sinGUIButton exportButton;
	
    //Buttons for table selection
	private sinGUIButton demonsButton;
	private sinGUIButton sinnersButton;
	private sinGUIButton sinsButton;
	private sinGUIButton circlesButton;
	private sinGUIButton sinInstancesButton;
	private sinGUIButton selectedButton;
	
	
	
	
	static class sinGUIButton extends JButton{
		sinGUIButton(String name){
			super(name);
			this.setBackground(Color.DARK_GRAY);
	        this.setBorder(BorderFactory.createLineBorder(Color.black,5));
	        this.setMinimumSize(new Dimension(90,30));
	        this.setForeground(Color.white);
	        this.setFocusable(false);
		}
	}
	

	
	public SinGUI() {
		this.objectModel = new SinObjectModel();
		
		
		
		
	 // Initializing a JFrame
        setTitle("Sin database");
        setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        
        
        
     // Adding a demon picture to a top left corner
        Border demonBorder = BorderFactory.createLineBorder(Color.black,5);
        
        demonPanel = new JPanel();
        demonPanel.setBorder(demonBorder);
        demonPanel.setLayout(null);
        demonPanel.setBackground(Color.DARK_GRAY);
        demonPanel.setBounds(0,0,130,100);
        
        
        JLabel demonLabel = new JLabel();
        ImageIcon demonImage = new ImageIcon("src/main/resources/pictures/devil.png");
        Image img = demonImage.getImage().getScaledInstance(130, 100,demonImage.getImage().SCALE_SMOOTH);
        demonImage = new ImageIcon(img);
        demonLabel.setText("Demon");
        demonLabel.setIcon(demonImage);
        demonLabel.setVerticalAlignment(JLabel.TOP);
        demonLabel.setHorizontalAlignment(JLabel.CENTER);
        demonLabel.setBounds(0, 0, 130, 100);
        demonPanel.add(demonLabel);
        
        
     // Adding tables to display information
        tables = new SinTables(demonLabel.getWidth(),demonLabel.getHeight(),WIDTH-demonLabel.getWidth(),HEIGHT -demonLabel.getHeight());
        
     // Adding a panel for buttons on the left
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xcc7722));
        buttonPanel.setBounds(0,demonPanel.getY()+demonPanel.getHeight(),demonPanel.getWidth(),620);
        buttonPanel.setBorder(demonBorder);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        
     // Creating and adding buttons to a button panel on the left
        addButton = new sinGUIButton("    ADD    ");
        deleteButton = new sinGUIButton(" DELETE ");
        selectButton = new sinGUIButton(" SELECT ");
        selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sinSelectForm = new SinSelectForm();
				sinSelectForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sinSelectForm.getSelectButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String query = sinSelectForm.getSelectPanel().createHQLQuery();
						//SinObjectModel.getEntityManager().getTransaction().begin();
						try {
							ArrayList<Object> list= (ArrayList<Object>) SinObjectModel.getEntityManager().createQuery(query).getResultList();
//							List<Sinner> sinnerList= SinObjectModel.getEntityManager().createQuery("SELECT obj from Sinner obj WHERE  obj.name = 'Alek'").getResultList();
							tables.setSelected(SinObjectModel.createSelectedScroll(list));
						}catch(Exception ex) {
							ex.printStackTrace();
						}
					}
				});
			}
        });
        saveButton = new sinGUIButton("   SAVE   ");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileopen = new JFileChooser("src/main/resources/databases");             
                int ret = fileopen.showDialog(null, "Save XML");
                if (ret == JFileChooser.APPROVE_OPTION) {
                	objectModel.saveXML(fileopen.getSelectedFile().getAbsolutePath());
                	
                }
            }
        });
        loadButton = new sinGUIButton("   LOAD   ");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
	                JFileChooser fileopen = new JFileChooser("src/main/resources/databases");             
	                int ret = fileopen.showDialog(null, "Load XML");                
	                if (ret == JFileChooser.APPROVE_OPTION) {
	                	objectModel.loadXML(fileopen.getSelectedFile().getAbsolutePath());
	                	tables.LoadObjectModel(objectModel);
	                }
            	}catch(WrongXMLException ex) {
            		JOptionPane.showMessageDialog(tables, "Wrong XML provided");
            	}
            }
        });
        exportButton = new sinGUIButton("   EXPORT   ");
        exportButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
	                JFileChooser fileopen = new JFileChooser("src/main/resources/databases");             
	                int ret = fileopen.showDialog(null, "Export PDF");                
	                if (ret == JFileChooser.APPROVE_OPTION) {
	                	objectModel.saveXML("report export.xml");
	                	objectModel.ExportPDF(fileopen.getSelectedFile().getAbsolutePath(), "report export.xml");
	                }
            	}catch(UnableToExportPDFException ex) {
        			JOptionPane.showMessageDialog(tables, "Can't export PDF");
        		}
        	}
        });
        
    	buttonPanel.add(selectButton);
    	buttonPanel.add(deleteButton);
    	buttonPanel.add(addButton);
    	buttonPanel.add(saveButton);
    	buttonPanel.add(loadButton);
    	buttonPanel.add(exportButton);
        
        
        
        
        
     // Adding a panel for buttons on the top
        choosePanel = new JPanel();
        choosePanel.setBackground(new Color(0xcc7722));
        choosePanel.setBounds(demonPanel.getX()+demonPanel.getWidth(),0,1180,100);
        choosePanel.setBorder(demonBorder);
        choosePanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,50));
        
        
     // Creating and adding buttons on the top
        demonsButton = new sinGUIButton("demons");
        demonsButton.addActionListener(e -> tables.openDemonTable());
        
        sinnersButton = new sinGUIButton("sinners");
        sinnersButton.addActionListener(e -> tables.openSinnerTable());
        
        sinsButton = new sinGUIButton("sins");
        sinsButton.addActionListener(e -> tables.openSinTable());
        
        circlesButton = new sinGUIButton("circles of hell");
        circlesButton.addActionListener(e -> tables.openCircleTable());
        
        sinInstancesButton = new sinGUIButton("sin instances");
        sinInstancesButton.addActionListener(e -> tables.openSinInstanceTable());
        
        selectedButton = new sinGUIButton("selected");
        selectedButton.addActionListener(e -> tables.openSelectedTable());
        
        
        choosePanel.add(demonsButton);
        choosePanel.add(sinnersButton);
        choosePanel.add(sinsButton);
        choosePanel.add(circlesButton);
        choosePanel.add(sinInstancesButton);
        choosePanel.add(selectedButton);
        
        
        
        
        
     
        
        
    	
    	// Adding panels to a frame
        this.add(choosePanel);
        this.add(demonPanel);
        this.add(buttonPanel);
        this.add(tables);
        
        

        setVisible(true);
    }
    
    
	
	

	
	
	
}
