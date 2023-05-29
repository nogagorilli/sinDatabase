package SinDatabase;

public class SinSelectForm extends QueryForm{
	SinSelectForm(){
		super("Select");
		this.getQueryButton().setText("SELECT");
		this.setQueryPanel(new SinSelectPanel());
		this.revalidate();
	}

}
