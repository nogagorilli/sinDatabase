package testSinDatabase;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import SinDatabase.SinObjectModel;
import SinDatabase.UnableToExportPDFException;
import SinDatabase.WrongXMLException;
public class TestSinObjectModel {
//	@Test
//	void testWrongFileExtension(){
//		assertThrows(WrongXMLException.class, () -> {
//			new SinObjectModel().loadXML("src/test/resources/devil.png");
//		});
//	}
//	@Test
//	void testNoFile(){
//		assertThrows(WrongXMLException.class, () -> {
//			new SinObjectModel().loadXML("");
//		});
//	}
//	@Test
//	void testGoodFile() throws WrongXMLException {
//		new SinObjectModel().loadXML("src/test/resources/databases/1.xml");
//	}
//	@Test
//	void testNoTemplateXMLForExportPDF(){
//		assertThrows(WrongXMLException.class, () -> {
//			SinObjectModel m = new SinObjectModel();
//			m.loadXML("src/test/resources/databases/0.xml");
//			//m.ExportPDF("src/test/resoureces/report.pdf", "1.xml");
//		});
//	}
//	@Test
//	void testGoodTemplateXMLForExportPDF() throws WrongXMLException, UnableToExportPDFException{
//		
//		SinObjectModel m = new SinObjectModel();
//		m.loadXML("src/test/resources/databases/1.xml");
//		m.saveXML("src/test/resources/reportXML.xml");
//		//m.ExportPDF("src/test/resources/report.pdf", "src/test/resources/reportXML.xml");
//		
//	}
}
