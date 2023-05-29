package SinDatabase;

public class SinDeleteForm extends QueryForm{

	public SinDeleteForm() {
		super("Select");
		this.getQueryButton().setText("DELETE");
		this.setQueryPanel(new SinDeletePanel());
		this.revalidate();
	}

}
