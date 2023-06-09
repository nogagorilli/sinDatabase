package entities;

import javax.persistence.*;


@Entity
@Table(name = "circlesOfHell")
public class CircleOfHell implements DBEntry{
	
	
	
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
	public CircleOfHell(){
		
	}
	
	public static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "DESCRIPTION"};
		
	}
	
	
	public String[] getTableRow() {
		//return new String[] {Integer.toString(this.getId()),this.getName(),this.getDescription()};
		String[] ret = new String[] {"","",""};
		try {
			ret[0] = Integer.toString(this.getId());
		}catch(Exception ex) {
			ret[0] = "UNDEFINED";
		}
		try {
			ret[1] = this.getName();
		}catch(Exception ex) {
			ret[1] = "UNDEFINED";
		}
		try {
			ret[2] = this.getDescription();
		}catch(Exception ex) {
			ret[2] = "UNDEFINED";
		}
		return ret;
		
	}
	
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = "(ID "+Integer.toString(this.getId())+") "+this.getName();
		return ret;
	}
	@Override
	public CircleOfHell clone() throws CloneNotSupportedException {
		CircleOfHell clone = new CircleOfHell();
		clone.setDescription(description);
		clone.setName(name);
		return clone;
	}
}
