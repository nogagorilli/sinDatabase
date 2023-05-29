package SinDatabase;

public class SinSelectPanel  extends QueryPanel{
	SinSelectPanel(){
		super();
		this.queryTextField.setText("SELECT FROM");
	}
	@Override
	public String createHQLQuery() {
		String ret = "";
		ret = "SELECT " + super.createHQLQuery();
		return ret;
	}
}
