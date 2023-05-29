package SinDatabase;

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
	CircleOfHell(){
		
	}
	
	static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "DESCRIPTION"};
		
	}
	
	
	public String[] getTableRow() {
		return new String[] {Integer.toString(this.getId()),this.getName(),this.getDescription()};
		
	}
	
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = Integer.toString(this.getId())+this.getName();
		return ret;
	}
}
