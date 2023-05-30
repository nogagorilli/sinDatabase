package SinDatabase;

public interface DBEntry extends Cloneable{
	static String[] getTableColumns() {
		return null;
	}
	
	
	abstract String[] getTableRow();
	
	abstract String getShortDescription();
}
