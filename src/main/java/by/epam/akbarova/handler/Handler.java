package by.epam.akbarova.handler;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;


public class Handler extends DefaultHandler {
    private Map<Integer, String> data = new HashMap<>();
    private String element;
    private int id;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("start parsing...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("end parsing...");
    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attr) {
        element = qName;
        if (element.equals("candy")) {
            id = Integer.parseInt(attr.getValue(0));
        }
    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        element = "";
        id = -1;
    }

    @Override
    public void characters(char[] ch, int start, int end) {
        if (element.equals("name")) {
            String name = new String(ch, start, end);
            data.put(id, name);
        }
        String str = new String(ch, start, end);
        System.out.println(str);
    }

    public Map<Integer, String> getData() {
        return data;
    }
}
