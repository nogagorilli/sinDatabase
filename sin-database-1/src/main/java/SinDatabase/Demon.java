package SinDatabase;
import javax.persistence.*;

@Entity
@Table(name = "demons")
public class Demon extends Being implements DBEntry{
	
	@Id
	@Column(name = "idDemon")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "salary")
	private int salary;
	
	@Column(name = "experienceInDays")
	private int experienceInDays;
	
	public Demon(String name, String lName) {
		setName(name);
		setLastName(lName);
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Demon() {
		// TODO Auto-generated constructor stub
	}

	public int getSalary() {
		return this.salary;
	}
	
	public void setSalary(int s) {
		this.salary = s;
	}
	
	
	public void setExperience(int exp) {
		this.experienceInDays = exp;	
	}
	
	public int getExperience() {
		return this.experienceInDays;
	}
	
	
	static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "LASTNAME","EXPERIENCE","SALARY","CIRCLE OF HELL"};
		
	}
	
	
	public String[] getTableRow() {
		return new String[] {Integer.toString(this.getId()),this.getName(),this.getLastName(),Integer.toString(this.getExperience()),Integer.toString(this.getSalary()),this.getCircleOfHell().getName()};
		
	}

	@Override
	public String getShortDescription() {
		String ret = "";
		ret = Integer.toString(this.getId())+this.getName() + this.getLastName();
		return ret;
	}
}