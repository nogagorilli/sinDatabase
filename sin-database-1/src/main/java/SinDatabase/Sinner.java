package SinDatabase;

import java.sql.Date;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



@Entity
@Table(name = "sinners")
public class Sinner extends Being implements DBEntry{
	
	
	@Id
	@Column(name = "idSinners")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "dateOfDeath")
	private Date dateOfDeath = new Date(0);
	
	
	
	@OneToMany(mappedBy ="sinner",cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
	@Embedded
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<SinInstance> sinInstances;
	

	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public Date getDateOfDeath() {
		return this.dateOfDeath;
	}
	
	public void setDateOfDeath(Date date) {
		this.dateOfDeath = date;
	}
	

	public int calculateCircleOfHell() {
		return 0;
	}
	
	
	
	
	public Sinner(String newName, String newLastName) {
		this.name = newName;
		this.lastName = newLastName;
		
	}
	public Sinner() {
		this.setDateOfDeath(new Date(0));
		System.out.println(this.getDateOfDeath());
		
	}
	
	
	static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "LASTNAME","DATE OF DEATH","CIRCLE OF HELL"};
		
	}
	
	
	@Override
	public String[] getTableRow() {
		
		//return new String[] {Integer.toString(this.getId()),this.getName(),this.getLastName(),this.getDateOfDeath().toString(),this.getCircleOfHell().getName()};
		
		String[] ret = new String[] {"","","","",""};
		try {
			ret[0] = Integer.toString(this.getId());
		}catch(Exception ex) {
			ret[0] = "undefined";
		}
		try {
			ret[1] = this.getName();
		}catch(Exception ex) {
			ret[1] = "undefined";
		}
		try {
			ret[2] = this.getLastName();
		}catch(Exception ex) {
			ret[2] = "undefined";
		}
		try {
			ret[3] = this.getDateOfDeath().toString();
		}catch(Exception ex) {
			ret[3] = "undefined";
		}
		try {
			ret[4] = this.getCircleOfHell().getName();
		}catch(Exception ex) {
			ret[4] = "undefined";
		}
		
		return ret;
	}
	
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = Integer.toString(this.getId())+" "+this.getName()+" " + this.getLastName();
		return ret;
	}
	
	@Override
	public Sinner clone() throws CloneNotSupportedException {
		Sinner clone = new Sinner();
		clone.setCircleOfHell(getCircleOfHell());
		clone.setDateOfDeath(dateOfDeath);
		clone.setName(name);
		clone.setLastName(lastName);
		return clone;
	}
}
