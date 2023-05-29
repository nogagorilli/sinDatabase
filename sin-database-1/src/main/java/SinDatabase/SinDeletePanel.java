package SinDatabase;

public class SinDeletePanel extends QueryPanel{
	@Override
	public String createHQLQuery() {
		String ret = "";
		ret = "DELETE "+ super.createHQLQuery();
		return ret;
	}
}
