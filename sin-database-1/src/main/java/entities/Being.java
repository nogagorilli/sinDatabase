package entities;
import javax.persistence.*;

@MappedSuperclass
public abstract class Being {

	@Column(name = "name")
	protected String name = "UNDEFINED";
	
	@Column(name = "lastName")
	protected String lastName = "UNDEFINED"; 
	

	public String getName(){
		return this.name;
	}
	
	public void setName(String s){
		this.name = s;
	}
	
	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String s){
		this.lastName = s;
	}
		
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idForeignCircleOfHell")
	private CircleOfHell circle;
	
	
	public void setCircleOfHell(CircleOfHell newCircle) {
		this.circle = newCircle;
	}
	
	public CircleOfHell getCircleOfHell() {
		return this.circle;
	}
	
}
