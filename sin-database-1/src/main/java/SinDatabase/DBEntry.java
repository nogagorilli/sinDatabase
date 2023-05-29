package SinDatabase;

public interface DBEntry {
	static String[] getTableColumns() {
		return null;
	}
	
	
	abstract String[] getTableRow();
	
	abstract String getShortDescription();
}
