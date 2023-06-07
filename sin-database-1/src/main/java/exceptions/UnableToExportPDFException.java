package exceptions;

public class UnableToExportPDFException extends Throwable {

	public UnableToExportPDFException(){
		super("Wrong JRXML template");
	}
}
