package SinDatabase;

import java.util.Date;
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
	private Date dateOfDeath;
	
	
	
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
	
	
	static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "LASTNAME","DATE OF DEATH","CIRCLE OF HELL"};
		
	}
	
	
	@Override
	public String[] getTableRow() {
		
		return new String[] {Integer.toString(this.getId()),this.getName(),this.getLastName(),this.getDateOfDeath().toString(),this.getCircleOfHell().getName()};
	}
	
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = Integer.toString(this.getId())+this.getName() + this.getLastName();
		return ret;
	}
}
