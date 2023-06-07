package selection;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class DatePicker extends JPanel{
	private JDatePicker datePicker;
	private RelationChooseMenu relationChooser;
	public RelationChooseMenu getRelationChooser() {
		return relationChooser;
	}

	private JMenuBar relationBar;
	DatePicker(){
		super();
		
		
		relationBar = new JMenuBar();
		relationChooser = new RelationChooseMenu();
		relationBar.add(relationChooser);
		
		
		
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		this.datePicker = datePicker;
		this.add(relationBar);
		this.add(datePicker);
		
		
	}
	
	public JDatePicker getDatePicker() {
		return datePicker;
	}

	public class DateLabelFormatter extends AbstractFormatter {

	    private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }

	        return "";
	    }

	}
	public Date getDate() {
		return new Date(((UtilDateModel)this.getDatePicker().getModel()).getValue().getTime());
	}
}
