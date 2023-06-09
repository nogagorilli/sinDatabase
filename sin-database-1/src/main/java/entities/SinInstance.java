package entities;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "sinInstances")
@Embeddable
public class SinInstance implements DBEntry{
	
	@Id
	@Column(name="idSinInstance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(targetEntity =Sin.class,cascade=CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name="idForeignSin")
	private Sin sin;
	
	
	@ManyToOne(targetEntity =Sinner.class,cascade=CascadeType.DETACH,fetch = FetchType.LAZY)
    @JoinColumn(name="idForeignSinner")
	private Sinner sinner;

	
	@Column(name = "date")
	private Date date = new Date(0);
	
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
	
	public static String[] getTableColumns() {
		return new String[] {"ID", "SINNER", "SIN","DATE"};
		
	}
	
	
	public String[] getTableRow() {
		//return new String[] {Integer.toString(this.getId()),this.getSinner().getName()+" "+this.getSinner().getLastName(),this.getSin().getName(),this.getDate().toString()};
		String[] ret = new String[] {"","","","",""};
		try {
			ret[0] = Integer.toString(this.getId());
		}catch(Exception ex) {
			ret[0] = "UNDEFINED";
		}
		try {
			ret[1] = this.getSinner().getName()+" "+this.getSinner().getLastName();
		}catch(Exception ex) {
			ret[1] = "UNDEFINED";
		}
		try {
			ret[2] = this.getSin().getName();
		}catch(Exception ex) {
			ret[2] = "UNDEFINED";
		}
		try {
			ret[3] = this.getDate().toString();
		}catch(Exception ex) {
			ret[3] = "UNDEFINED";
		}
		return ret;
		
	}
	@Override
	public String getShortDescription() {
		String ret = "";
		ret = "(ID "+Integer.toString(this.getId())+") "+this.getSinner().getName() +" " +this.getSinner().getLastName() 
				+" commited " + this.getSin().getName() + " at " + this.getDate().toString();
		return ret;
	}
	
	@Override
	public SinInstance clone() throws CloneNotSupportedException {
		SinInstance clone = new SinInstance();
		clone.setDate(date);
		clone.setSin(sin);
		clone.setSinner(sinner);
		return clone;
	}
}