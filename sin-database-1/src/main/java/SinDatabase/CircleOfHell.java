package SinDatabase;

import javax.persistence.*;


@Entity
@Table(name = "circlesOfHell")
public class CircleOfHell {
	
	
	
	@Id
	@Column(name = "idCirclesOfHell")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String newName) {
		this.name = newName;		
	}
	
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;		
	}

	
	CircleOfHell(String newName) {
		setName(newName);
		setDescription("NO DESCRIPTION");
	}
	CircleOfHell(){
		
	}
}
