package selection;

import java.util.Set;

import entities.DBEntry;
import sinDatabase.SinObjectModel;

public class SinWherePanel extends WherePanel{
	
	
	SinWherePanel(SinObjectModel objectModel) {
		super(objectModel);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Set<DBEntry> filter(Set<DBEntry> entries){
		// TODO Auto-generated method stub
		return entries;
	}
	
}
