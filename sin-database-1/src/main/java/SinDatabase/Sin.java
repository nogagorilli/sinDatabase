package SinDatabase;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "sins")
public class Sin {
	
	@Id
	@Column(name = "idSins")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "heaviness")
	private float heaviness;
	
	
	
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
	
	
}
