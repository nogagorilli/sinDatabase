package SinDatabase;

import javax.persistence.*;

import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SinDatabase{
	public static void main(String[] args)
	{
		
		Logger log = LogManager.getLogger(SinDatabase.class);
		for(int i = 0;i<10;i++) {
			log.fatal("aaaaaaaaaaaaaaaaaaaaaaaaaaa");
		}
		SinGUI gui = new SinGUI();
		gui.setVisible(true);
		System.out.println("All is done");
		
		
		
	}
	

}
