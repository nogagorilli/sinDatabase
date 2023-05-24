package SinDatabase;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "sinInstances")
public class SinInstance {
	
	@Id
	@Column(name="idSinInstance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idForeignSin")
	private Sin sin;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idForeignSinner")
	private Sinner sinner;

	
	@Column(name = "date")
	private Date date;
	
	public void setSin(Sin s) {
		this.sin = s;
	}
	
	public Sin getSin() {
		return this.sin;		
	}
	
	public void setDate(Date d) {
		this.date = d;
	}
	
	public Date getDate() {
		return this.date;		
	}
	
	public void setSinner(Sinner s) {
		this.sinner = s;
	}
	
	public Sinner getSinner() {
		return this.sinner;		
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}