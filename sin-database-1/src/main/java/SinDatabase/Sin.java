package SinDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "sins")
public class Sin implements DBEntry{
	
	@Id
	@Column(name = "idSins")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name = "UNDEFINED";
	
	@Column(name = "heaviness")
	private float heaviness = 0;
	
	@OneToMany(mappedBy ="sin",cascade = CascadeType.ALL,fetch=FetchType.EAGER, orphanRemoval = true)
	@Embedded
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<SinInstance> sinInstances;
	
	Sin(String newName) {
		this.name = newName;
		this.heaviness = 7;
	}
	
	Sin(){
		
	}
	
	
	public void appendSinList(Sin s) {
		
	}
	
	public void removeFromSinList(Sin s) {
		
	}
	
	
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String s) {
		this.name = s;
		
	}
	
	public float getHeaviness() {
		return this.heaviness;
	}
	
	public void setHeaviness(float h) {
		this.heaviness = h;
	}
	
	static String[] getTableColumns() {
		return new String[] {"ID", "NAME", "HEAVINESS"};
		
	}
	
	
	public String[] getTableRow() {
		//return new String[] {Integer.toString(this.getId()),this.getName(),Float.toString(this.getHeaviness())};
		String[] ret = new String[] {"","",""};
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
			ret[2] = Float.toString(this.getHeaviness());
		}catch(Exception ex) {
			ret[2] = "undefined";
		}
		
		return ret;
	}
	
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = Integer.toString(this.getId())+" "+this.getName()+" heaviness:" + Float.toString(this.getHeaviness());
		return ret;
	}
	@Override
	public Sin clone() throws CloneNotSupportedException {
		Sin clone = new Sin();
		clone.setHeaviness(heaviness);
		clone.setName(name);
		return clone;
	}
}
