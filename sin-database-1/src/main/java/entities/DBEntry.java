package entities;

public interface DBEntry extends Cloneable{
	public static String[] getTableColumns() {
		return null;
	}
	
	
	public abstract String[] getTableRow();
	
	public abstract String getShortDescription();
}
