package by.epam.akbarova;

import by.epam.akbarova.parser.DOMParser;
import by.epam.akbarova.parser.SaxParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        File file = new File("C:/Users/Leyli/project_candy/src/main/resources/candy.xml");
        DOMParser dp=new DOMParser();
        dp.parserDOM(file);
//        SaxParser saxParser = new SaxParser();
//        saxParser.saxParser(file);
    }
}
