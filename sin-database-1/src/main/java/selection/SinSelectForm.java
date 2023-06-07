package selection;

import java.util.HashSet;
import java.util.Set;

import entities.DBEntry;
import sinDatabase.SinObjectModel;

public class SinSelectForm extends QueryForm{
	public SinSelectForm(SinObjectModel objectModel){
		super("Select", objectModel);
		this.setAlwaysOnTop(true);
		this.getQueryButton().setText("SELECT");
		this.setQueryPanel(new SinSelectPanel(this.objectModel));
		this.revalidate();
	}
	public Set<DBEntry> getResultingList() {
		
		return this.getQueryPanel().getResultingList();
	}
}
