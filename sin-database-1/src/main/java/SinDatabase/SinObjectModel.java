package SinDatabase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class SinObjectModel {
	private HashMap<Integer,Sinner> sinners;
	private HashMap<Integer,Sin> sins;
	private HashMap<Integer,Demon> demons;
	private HashMap<Integer,SinInstance> sinInstances;
	private HashMap<Integer,CircleOfHell> circlesOfHell;
	private EntityManager entityManager;
	
	public List<Sinner> getSinners(){
		return new ArrayList<Sinner>(this.sinners.values());
	}
	
	public List<Sin> getSins(){
		return new ArrayList<Sin>(this.sins.values());
	}
	
	public List<Demon> getDemons(){
		return new ArrayList<Demon>(this.demons.values());
	}
	
	public List<SinInstance> getSinInstances(){
		return new ArrayList<SinInstance>(this.sinInstances.values());
	}
	
	public List<CircleOfHell> getCirclesOfHell(){
		return new ArrayList<CircleOfHell>(this.circlesOfHell.values());
	}
	
	
	
	
	
	public SinObjectModel(){
		this.sinners = new HashMap<Integer,Sinner>();
		this.sins = new HashMap<Integer,Sin>();
		this.demons = new HashMap<Integer,Demon>();
		this.sinInstances= new HashMap<Integer,SinInstance>();
		this.circlesOfHell = new HashMap<Integer,CircleOfHell>();
		entityManager = Persistence.createEntityManagerFactory("SinPersistence").createEntityManager();
		
		
//		Demon tempD;
//		this.entityManager.getTransaction().begin();
//		tempD = new Demon();
//		tempD.setName("a");	
//		this.entityManager.persist(tempD);
//		this.entityManager.getTransaction().commit();
//		
//		
//		Demon kondakov;
//		this.entityManager.getTransaction().begin();
//		kondakov = new Demon("Alexander","Kondakov");
//		kondakov.setSalary(666);
//		kondakov.setExperience(666);
//		this.entityManager.persist(kondakov);
//		this.entityManager.getTransaction().commit();
		
		
		
		
		
	}
	
	
	public void loadXML(String docName) throws WrongXMLException {
		NodeList list;
		Node node;
		Document doc;
		DocumentBuilder dBuilder;
		
		try {
			dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			doc = dBuilder.parse(new File(docName));
			doc.getDocumentElement().normalize();
			}
		catch (ParserConfigurationException e) { e.printStackTrace(); throw new WrongXMLException(); }
		catch (IOException e) { e.printStackTrace(); throw new WrongXMLException(); }
		catch (SAXException e) { e.printStackTrace(); throw new WrongXMLException(); }
		
		
		this.entityManager.getTransaction().begin();
		try {
			List<Sin> sinList= this.entityManager.createQuery("SELECT s FROM Sin s").getResultList();
			List<Sinner> sinnerList= this.entityManager.createQuery("SELECT s FROM Sinner s").getResultList();
			List<Demon> demonList= this.entityManager.createQuery("SELECT d FROM Demon d").getResultList();
			List<SinInstance> sinInstanceList= this.entityManager.createQuery("SELECT s FROM SinInstance s").getResultList();
			List<CircleOfHell> circleList= this.entityManager.createQuery("SELECT c FROM CircleOfHell c").getResultList();
			
			for(Sin temp:sinList) this.entityManager.remove(temp);
			for(Sinner temp:sinnerList) this.entityManager.remove(temp);
			for(Demon temp:demonList) this.entityManager.remove(temp);
			for(SinInstance temp:sinInstanceList) this.entityManager.remove(temp);
			for(CircleOfHell temp:circleList) this.entityManager.remove(temp);
		}
		catch(Exception e) {e.printStackTrace();return;}
		this.entityManager.getTransaction().commit();
		
		
		
		this.sinners = new HashMap<Integer,Sinner>();
		this.sins = new HashMap<Integer,Sin>();
		this.demons = new HashMap<Integer,Demon>();
		this.sinInstances= new HashMap<Integer,SinInstance>();
		this.circlesOfHell = new HashMap<Integer,CircleOfHell>();
		
		
		//Loading sin data
		this.entityManager.getTransaction().begin();
		Sin tempSin;
		node = doc.getElementsByTagName("Sins").item(0);
		list = node.getChildNodes();
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node elem = list.item(temp);
			if(elem.getNodeName()=="Sin") {
				NamedNodeMap attrs = elem.getAttributes();
				tempSin = new Sin();
				tempSin.setName(attrs.getNamedItem("name").getNodeValue());
				tempSin.setHeaviness(Float.parseFloat(attrs.getNamedItem("heaviness").getNodeValue()));
				this.sins.put(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()),tempSin);	
				this.entityManager.persist(tempSin);
				
			}
		}
		this.entityManager.getTransaction().commit();
		
		//Loading circles of hell data
		this.entityManager.getTransaction().begin();
		CircleOfHell tempCircle;
		node = doc.getElementsByTagName("CirclesOfHell").item(0);
		list = node.getChildNodes();
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node elem = list.item(temp);
			if(elem.getNodeName()=="CircleOfHell") {
				
				NamedNodeMap attrs = elem.getAttributes();
				tempCircle = new CircleOfHell();
				tempCircle.setName(attrs.getNamedItem("name").getNodeValue());
				tempCircle.setDescription(attrs.getNamedItem("description").getNodeValue());
				this.entityManager.persist(tempCircle);
				this.circlesOfHell.put(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()),tempCircle);
			}
		}
		this.entityManager.getTransaction().commit();
		
		
		//loading demons data
		this.entityManager.getTransaction().begin();
		Demon tempDemon;
		node = doc.getElementsByTagName("Demons").item(0);
		list = node.getChildNodes();
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node elem = list.item(temp);
			if(elem.getNodeName()=="Demon") {
				NamedNodeMap attrs = elem.getAttributes();
				tempDemon = new Demon();
				tempDemon.setExperience(Integer.parseInt(attrs.getNamedItem("experience").getNodeValue()));
				
				tempDemon.setLastName(attrs.getNamedItem("lastname").getNodeValue());
				tempDemon.setName(attrs.getNamedItem("name").getNodeValue());
				tempDemon.setSalary(Integer.parseInt(attrs.getNamedItem("salary").getNodeValue()));
				tempDemon.setCircleOfHell(this.circlesOfHell.get(Integer.parseInt(attrs.getNamedItem("idcircleofhell").getNodeValue())));
				this.entityManager.persist(tempDemon);
				this.demons.put(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()), tempDemon);
				
			}
		}
		this.entityManager.getTransaction().commit();
		
		
		
		//loading sinners data
		this.entityManager.getTransaction().begin();
		Sinner tempSinner;
		node = doc.getElementsByTagName("Sinners").item(0);
		list = node.getChildNodes();
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node elem = list.item(temp);
			if(elem.getNodeName()=="Sinner") {
				NamedNodeMap attrs = elem.getAttributes();
				tempSinner = new Sinner();
				tempSinner.setDateOfDeath(new Date());
				tempSinner.setLastName(attrs.getNamedItem("lastname").getNodeValue());
				tempSinner.setName(attrs.getNamedItem("name").getNodeValue());
				tempSinner.setCircleOfHell(this.circlesOfHell.get(Integer.parseInt(attrs.getNamedItem("idcircleofhell").getNodeValue())));
				this.entityManager.persist(tempSinner);
				this.sinners.put(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()),tempSinner);
			}
		}
		this.entityManager.getTransaction().commit();
		
		//loading sin instances data
		this.entityManager.getTransaction().begin();
		SinInstance tempSinInstance;
		node = doc.getElementsByTagName("SinInstances").item(0);
		list = node.getChildNodes();
		for (int temp = 0; temp < list.getLength(); temp++) {
			Node elem = list.item(temp);
			if(elem.getNodeName()=="SinInstance") {
				NamedNodeMap attrs = elem.getAttributes();
				
				tempSinInstance = new SinInstance();
				tempSinInstance.setDate(new Date());
				tempSinInstance.setSin(this.sins.get(Integer.parseInt(attrs.getNamedItem("idsin").getNodeValue())));
				
				tempSinInstance.setSinner(this.sinners.get(Integer.parseInt(attrs.getNamedItem("idsinner").getNodeValue())));
				
				this.entityManager.persist(tempSinInstance);
				this.sinInstances.put(Integer.parseInt(attrs.getNamedItem("id").getNodeValue()),tempSinInstance);
				
			}
		}
		this.entityManager.getTransaction().commit();
		System.out.println(this.sinInstances.size());
		
		System.out.println("Successfully downloaded XML");
	}

	
	
	public void saveXML(String docName) {
		
		List<Sin> sinList= this.entityManager.createQuery("SELECT s FROM Sin s").getResultList();
		List<Sinner> sinnerList= this.entityManager.createQuery("SELECT s FROM Sinner s").getResultList();
		List<Demon> demonList= this.entityManager.createQuery("SELECT d FROM Demon d").getResultList();
		List<SinInstance> sinInstanceList= this.entityManager.createQuery("SELECT s FROM SinInstance s").getResultList();
		List<CircleOfHell> circleList= this.entityManager.createQuery("SELECT c FROM CircleOfHell c").getResultList();
		Document doc;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		} catch(ParserConfigurationException e) { e.printStackTrace(); return;}
		
		
		Node root = doc.createElement("SinDatabase");
		doc.appendChild(root);
		
		Node sins = doc.createElement("Sins");
		root.appendChild(sins);
		
		Node circles = doc.createElement("CirclesOfHell");
		root.appendChild(circles);
		
		Node sinners = doc.createElement("Sinners");
		root.appendChild(sinners);
		
		Node demons = doc.createElement("Demons");
		root.appendChild(demons);
		
		Node sinInstances = doc.createElement("SinInstances");
		root.appendChild(sinInstances);
		int i = 0;
		for(Sin temp:sinList) {
			Element sin = doc.createElement("Sin");
			sin.setAttribute("id", String.valueOf(temp.getId()));
			sin.setAttribute("name", temp.getName());
			sin.setAttribute("heaviness", String.valueOf(temp.getHeaviness()));
			sins.appendChild(sin);
			System.out.println(i++);
		}
		
		for(CircleOfHell temp:circleList) {
			Element circle = doc.createElement("CircleOfHell");
			circle.setAttribute("id", String.valueOf(temp.getId()));
			circle.setAttribute("name", temp.getName());
			circle.setAttribute("description", temp.getDescription());
			circles.appendChild(circle);
		}
		
		for(Sinner temp:sinnerList) {
			Element sinner = doc.createElement("Sinner");
			sinner.setAttribute("id", String.valueOf(temp.getId()));
			sinner.setAttribute("name", temp.getName());
			sinner.setAttribute("lastname", temp.getLastName());
			sinner.setAttribute("dateofdeath", temp.getDateOfDeath().toString());
			sinner.setAttribute("idcircleofhell", String.valueOf(temp.getCircleOfHell().getId()));
			
			sinners.appendChild(sinner);
		}
		
		for(Demon temp:demonList) {
			Element demon = doc.createElement("Demon");
			demon.setAttribute("id", String.valueOf(temp.getId()));
			demon.setAttribute("name", temp.getName());
			demon.setAttribute("lastname", temp.getLastName());
			demon.setAttribute("experience", String.valueOf(temp.getExperience()));
			demon.setAttribute("salary", String.valueOf(temp.getSalary()));
			demon.setAttribute("idcircleofhell", String.valueOf(temp.getCircleOfHell().getId()));
			
			demons.appendChild(demon);
		}
		
		
		
		for(SinInstance temp:sinInstanceList) {
			Element sinInst = doc.createElement("SinInstance");
			sinInst.setAttribute("id", String.valueOf(temp.getId()));
			
			sinInst.setAttribute("idsinner", String.valueOf(temp.getSinner().getId()));
			sinInst.setAttribute("idsin", String.valueOf(temp.getSin().getId()));
			sinInst.setAttribute("date", temp.getDate().toString());
			
			sinInstances.appendChild(sinInst);
		}
		
		try {
			
			Transformer trans = TransformerFactory.newInstance().newTransformer();
			
			java.io.FileWriter fw = new FileWriter(docName);
			
			trans.transform(new DOMSource(doc), new StreamResult(fw));
			}
		catch (TransformerConfigurationException e) { e.printStackTrace(); }
		catch (TransformerException e) { e.printStackTrace(); }
		catch (IOException e) { e.printStackTrace(); }
		
	}
	public void ExportPDF(String exportFileName,String xmlFileName) throws UnableToExportPDFException {
		try {
			// Указание источника XML-данных
			JRDataSource ds = new JRXmlDataSource(xmlFileName,"/SinDatabase/Sins/Sin");
			// Создание отчета на базе шаблона
			JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/sampleXML/Coffee.jrxml");
			// Заполнение отчета данными
			JasperPrint print = JasperFillManager.fillReport(jasperReport, new HashMap(), ds);
			JRExporter exporter = null;
			exporter = new JRPdfExporter(); // Генерация отчета в формате PDF
			// Задание имени файла для выгрузки отчета
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, exportFileName);
			// Подключение данных к отчету
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			// Выгрузка отчета в заданном формате
			exporter.exportReport();
		} catch (JRException e) { e.printStackTrace(); throw new UnableToExportPDFException();}
	}
}
