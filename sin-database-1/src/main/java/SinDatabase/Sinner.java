package SinDatabase;

import java.util.Date;

import java.util.ArrayList;

import javax.persistence.*;



@Entity
@Table(name = "sinners")
public class Sinner extends Being {
	
	
	@Id
	@Column(name = "idSinners")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dateOfDeath")
	private Date dateOfDeath;
	
	
	

	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Date getDateOfDeath() {
		return this.dateOfDeath;
	}
	
	public void setDateOfDeath(Date d) {
		this.dateOfDeath = d;
	}
	

	public int calculateCircleOfHell() {
		return 0;
	}
	
	
	
	
	public Sinner(String newName, String newLastName) {
		this.name = newName;
		this.lastName = newLastName;
		
	}
	public Sinner() {
		
	}
	
}
