package sinDatabase;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

import addition.CircleOfHellAddForm;
import addition.DemonAddForm;
import addition.SinAddForm;
import addition.SinInstanceAddForm;
import addition.SinnerAddForm;
import editing.EditForm;
import entities.CircleOfHell;
import entities.DBEntry;
import entities.Demon;
import entities.Sin;
import entities.SinInstance;
import entities.Sinner;
import exceptions.UnableToExportPDFException;
import exceptions.WrongXMLException;
import selection.SinSelectForm;

public class SinGUI extends JFrame{
	final private SinGUI sinGUI = this;
	
	
	
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
	public SinTables tables;

	
	//Buttons for action selection
	private sinGUIButton addSinnerButton;
	private sinGUIButton addSinButton;
	private sinGUIButton addDemonButton;
	private sinGUIButton addCircleButton;
	private sinGUIButton addSinInstanceButton;
	private sinGUIButton editButton;
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
	        
	        this.setSize(new Dimension(200,20));
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
        demonPanel.setBounds(20,0,150,100);
        
        
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
        tables = new SinTables(demonPanel.getWidth(),demonLabel.getHeight(),WIDTH-demonPanel.getWidth(),HEIGHT -demonLabel.getHeight());
        
     // Adding a panel for buttons on the left
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xcc7722));
        buttonPanel.setBounds(0,demonPanel.getY()+demonPanel.getHeight(),demonPanel.getWidth(),620);
        buttonPanel.setBorder(demonBorder);
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        
        
     // Creating and adding buttons to a button panel on the left
        addSinInstanceButton = new sinGUIButton("ADD SIN INSTANCE");
        addSinInstanceButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SinInstanceAddForm addForm = new SinInstanceAddForm(objectModel, "ADD");
				addForm.setEntity(new SinInstance());
				addForm.getAddButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbb");
						((SinInstance) addForm.getEntity()).setSinner((Sinner) addForm.getSinnerChoosePanel().getEntry());
						((SinInstance) addForm.getEntity()).setSin((Sin) addForm.getSinChoosePanel().getEntry());
						DBEntry ent = addForm.getEntity();
						objectModel.loadSingleDBEntry(ent);
						addForm.dispose();
						tables.LoadObjectModel(objectModel);
					}
					
				});
				
			}
        	
        });
        
        
        addCircleButton = new sinGUIButton("ADD CIRCLE OF HELL");
        addCircleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CircleOfHellAddForm addForm = new CircleOfHellAddForm(objectModel, "ADD");
				addForm.setEntity(new Demon());
				addForm.getAddButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						DBEntry ent = addForm.getEntity();
						objectModel.loadSingleDBEntry(ent);
						addForm.dispose();
						tables.LoadObjectModel(objectModel);
					}
					
				});
				
			}
        	
        });
        
        
        addDemonButton = new sinGUIButton("    ADD DEMON  ");
        addDemonButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DemonAddForm addForm = new DemonAddForm(objectModel, "ADD");
				addForm.setEntity(new Demon());
				addForm.getAddButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						((Demon) addForm.getEntity()).setCircleOfHell((CircleOfHell) addForm.getCircleChoosePanel().getEntry());
						DBEntry ent = addForm.getEntity();
						objectModel.loadSingleDBEntry(ent);
						addForm.dispose();
						tables.LoadObjectModel(objectModel);
					}
					
				});
				
			}
        	
        });
        
        
        
        addSinnerButton = new sinGUIButton("    ADD SINNER   ");
        addSinnerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SinnerAddForm addForm = new SinnerAddForm(objectModel, "ADD");
				addForm.setEntity(new Sinner());
				addForm.getAddButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						((Sinner) addForm.getEntity()).setCircleOfHell((CircleOfHell) addForm.getCircleChoosePanel().getEntry());
						DBEntry ent = addForm.getEntity();
						objectModel.loadSingleDBEntry(ent);
						addForm.dispose();
						tables.LoadObjectModel(objectModel);
					}
					
				});
				
			}
        	
        });
        
        addSinButton = new sinGUIButton("    ADD SIN   ");
        addSinButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SinAddForm addForm = new SinAddForm(objectModel, "ADD");
				addForm.setEntity(new Sin());
				addForm.getAddButton().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
					
						DBEntry ent = addForm.getEntity();
						objectModel.loadSingleDBEntry(ent);
						addForm.dispose();
						tables.LoadObjectModel(objectModel);
					}
					
				});
				
			}
        	
        });
        
        deleteButton = new sinGUIButton(" DELETE ");
        deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sinSelectForm = new SinSelectForm(objectModel);
				sinSelectForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sinSelectForm.getQueryButton().setText("DELETE");
				sinSelectForm.getQueryPanel().getQueryTextField().setText("DELETE FROM");
				sinSelectForm.getQueryButton().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						sinSelectForm.dispose();
						String query = sinSelectForm.getQueryPanel().createHQLQuery();
						//SinObjectModel.getEntityManager().getTransaction().begin();
						try {
							ArrayList<DBEntry> list= (ArrayList<DBEntry>)sinSelectForm.getResultingList().stream().collect(Collectors.toList());;
//							List<Sinner> sinnerList= SinObjectModel.getEntityManager().createQuery("SELECT obj from Sinner obj WHERE  obj.name = 'Alek'").getResultList();
							int decision = JOptionPane.showConfirmDialog(tables, String.format("are you sure you want to delete %d entities",list.size()));
							if(decision == JOptionPane.YES_OPTION) {
								for(Object i:list) {
									objectModel.getEntityManager().getTransaction().begin();
									objectModel.getEntityManager().remove(i);
									objectModel.getEntityManager().getTransaction().commit();
								}
								tables.LoadObjectModel(objectModel);
							}
							
						}catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(tables, "Can't create deletion query");
						}
					}
				});
			}
        });
        
        selectButton = new sinGUIButton(" SELECT ");
        selectButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sinSelectForm = new SinSelectForm(objectModel);
				sinSelectForm.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				sinSelectForm.getQueryButton().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						sinSelectForm.dispose();
						String query = sinSelectForm.getQueryPanel().createHQLQuery();
						//SinObjectModel.getEntityManager().getTransaction().begin();
						try {
							ArrayList<DBEntry> list= (ArrayList<DBEntry>)sinSelectForm.getResultingList().stream().collect(Collectors.toList());;
//							List<Sinner> sinnerList= SinObjectModel.getEntityManager().createQuery("SELECT obj from Sinner obj WHERE  obj.name = 'Alek'").getResultList();
							tables.setSelected(SinObjectModel.createSelectedScroll(list));
							try {
								tables.setSelectedClass(list.get(0).getClass());
							}catch(Exception ex){}
						}catch(Exception ex) {
							ex.printStackTrace();
							JOptionPane.showMessageDialog(tables, "Failed to create a query");
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
	                JFileChooser fileopen = new JFileChooser("src/main/resources/templates");             
	                int ret = fileopen.showDialog(null, "Export PDF");                
	                if (ret == JFileChooser.APPROVE_OPTION) {
	                	objectModel.ExportPDF(fileopen.getSelectedFile().getAbsolutePath(), tables);
	                }
            	}catch(UnableToExportPDFException ex) {
        			JOptionPane.showMessageDialog(tables, "Can't export PDF");
        		}
        	}
        });
        editButton = new sinGUIButton("EDIT");
        editButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EditForm edit = new EditForm(objectModel,sinGUI);
				
			}
        	
        });
        
    	buttonPanel.add(selectButton);
    	buttonPanel.add(deleteButton);
    	buttonPanel.add(addSinnerButton);
    	buttonPanel.add(addSinButton);
    	buttonPanel.add(addDemonButton);
    	buttonPanel.add(addCircleButton);
    	buttonPanel.add(addSinInstanceButton);
    	buttonPanel.add(editButton);
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
        selectedButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					tables.openSelectedTable();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(tables, "Nothing was selected");
				}
				
			}
        	
        });
        
        
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
        try {
			objectModel.loadXML("src/main/resources/databases/1.xml");
			tables.LoadObjectModel(objectModel);
		} catch (WrongXMLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(tables, "Could not load XML");
		}
    }
    
    
	
	

	
	
	
}
