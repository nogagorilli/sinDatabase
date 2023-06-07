package selection;

import sinDatabase.SinObjectModel;

public class SinDeleteForm extends QueryForm{

	public SinDeleteForm(SinObjectModel objectModel) {
		super("Select",objectModel);
		this.getQueryButton().setText("DELETE");
		this.setQueryPanel(new SinDeletePanel(this.objectModel));
		this.revalidate();
	}

}
