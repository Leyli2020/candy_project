package by.epam.akbarova.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class DOMParser {
    public Document buildDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        return dbf.newDocumentBuilder().parse(file);
    }

    public void parserDOM(File file){
        Document doc;
        try {
            doc = buildDocument(file);
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.toString());
            return;
        }
        String  rootEl=doc.getDocumentElement().getNodeName();
        System.out.println("Root element "+ rootEl);
        NodeList candyList=doc.getElementsByTagName("candy");

        String name="";
        double energy=0.0;
        String type="";
        System.out.println("Name      energy   type");
        for(int i=0;i< candyList.getLength();i++){
            Element element=(Element) candyList.item(i);
            name=element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
            energy= Double.parseDouble(element.getElementsByTagName("energy").item(0).getChildNodes().item(0).getNodeValue());
            type=element.getElementsByTagName("type").item(0).getChildNodes().item(0).getNodeValue();
            System.out.println(name+"     "+energy+"    "+type);
        }
        String inName="";
        double quantity=0.0;
        NodeList ingredientsList=doc.getElementsByTagName("ingredients");
        for(int j=0;j< ingredientsList.getLength();j++){
            Element element=(Element) ingredientsList.item(j);
            String node=ingredientsList.item(j).getNodeName();
            inName=element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
            quantity= Double.parseDouble(element.getElementsByTagName("quantity").item(0).getChildNodes().item(0).getNodeValue());
            System.out.println("Ingredient "+"     "+inName+"    "+quantity);
        }

        NodeList date= doc.getElementsByTagName("date");
        Element el=(Element)date.item(0);
        LocalDate localDate= LocalDate.parse(el.getTextContent());
        System.out.println("Date  "+localDate);

        double proteins=0.0;
        double fats=0.0;
        double carbohydrates=0.0;
        NodeList valuesList=doc.getElementsByTagName("value");
        System.out.println("Name "+"         proteins   "+" fats  " + "   carbohydrates");
        for(int j=0;j< valuesList.getLength();j++){
            Element element=(Element) valuesList.item(j);
            String node=valuesList.item(j).getNodeName();
            proteins= Double.parseDouble(element.getElementsByTagName("proteins").item(0).getChildNodes().item(0).getNodeValue());
            fats= Double.parseDouble(element.getElementsByTagName("fats").item(0).getChildNodes().item(0).getNodeValue());
            carbohydrates= Double.parseDouble(element.getElementsByTagName("carbohydrates").item(0).getChildNodes().item(0).getNodeValue());
            System.out.println("Quantity "+"       "+proteins+"      "+fats+"      "+carbohydrates);
        }
    }

}
