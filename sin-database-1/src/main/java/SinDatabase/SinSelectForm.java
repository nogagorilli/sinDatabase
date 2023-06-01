package SinDatabase;

public class SinSelectForm extends QueryForm{
	SinSelectForm(){
		super("Select");
		this.setAlwaysOnTop(true);
		this.getQueryButton().setText("SELECT");
		this.setQueryPanel(new SinSelectPanel());
		this.revalidate();
	}

}
