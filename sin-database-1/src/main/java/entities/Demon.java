package entities;
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
	
	
	public static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "LASTNAME","EXPERIENCE","SALARY","CIRCLE OF HELL"};
		
	}
	
	
	public String[] getTableRow() {
		
		//return new String[] {Integer.toString(this.getId()),this.getName(),this.getLastName(),Integer.toString(this.getExperience()),Integer.toString(this.getSalary()),this.getCircleOfHell().getName()};
		String[] ret = new String[] {"","","","","",""};
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
			ret[2] = this.getLastName();
		}catch(Exception ex) {
			ret[2] = "UNDEFINED";
		}
		try {
			ret[3] = Integer.toString(this.getExperience());
		}catch(Exception ex) {
			ret[3] = "UNDEFINED";
		}
		try {
			ret[4] = Integer.toString(this.getSalary());
		}catch(Exception ex) {
			ret[4] = "UNDEFINED";
		}
		try {
			ret[5] = this.getCircleOfHell().getName();
		}catch(Exception ex) {
			ret[5] = "UNDEFINED";
		}
		return ret;
		
	}

	@Override
	public String getShortDescription() {
		String ret = "";
		ret = "(ID "+Integer.toString(this.getId())+") "+this.getName()+" " + this.getLastName();
		return ret;
	}
	
	@Override
	public Demon clone() throws CloneNotSupportedException {
		Demon clone = new Demon();
		clone.setCircleOfHell(getCircleOfHell());
		clone.setLastName(lastName);
		clone.setName(name);
		clone.setSalary(salary);
		clone.setExperience(experienceInDays);
		return clone;
	}
}