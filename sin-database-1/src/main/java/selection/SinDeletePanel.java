package selection;

import java.util.Set;

import entities.DBEntry;
import sinDatabase.SinObjectModel;

public class SinDeletePanel extends QueryPanel{
	SinDeletePanel(SinObjectModel objectModel) {
		super(objectModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String createHQLQuery() {
		String ret = "";
		ret = "SELECT "+ super.createHQLQuery();
		return ret;
	}

	@Override
	public Set<DBEntry> getResultingList() {
		// TODO Auto-generated method stub
		return null;
	}
}
