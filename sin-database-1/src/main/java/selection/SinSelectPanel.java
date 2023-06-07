package selection;

import java.util.HashSet;
import java.util.Set;

import entities.DBEntry;
import sinDatabase.SinObjectModel;

public class SinSelectPanel  extends QueryPanel{
	SinSelectPanel(SinObjectModel objectModel){
		super(objectModel);
		this.queryTextField.setText("SELECT FROM");
	}
	@Override
	public String createHQLQuery() {
		String ret = "";
		ret = "SELECT " + super.createHQLQuery();
		return ret;
	}
	@Override
	public Set<DBEntry> getResultingList() {
		String query = createHQLQuery();
		Set<DBEntry> entries = new HashSet<DBEntry>(this.objectModel.getEntityManager().createQuery(query).getResultList());
		for(WherePanel w:this.wherePanels) {
			entries = w.filter(entries);
		}
		return entries;
	}
}
