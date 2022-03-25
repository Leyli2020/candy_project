package by.epam.akbarova.parser;

import by.epam.akbarova.handler.Handler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.SAXParser;

public class SaxParser {

    Handler handler = new Handler();

    public void saxParser(File file) throws ParserConfigurationException, SAXException, IOException {

        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = parserFactory.newSAXParser();
        saxParser.parse(file, handler);
        Map<Integer, String> data = handler.getData();
        for (Map.Entry<Integer, String> dMap : data.entrySet()) {
            System.out.println(dMap.getKey() + " - " + dMap.getValue());
        }
    }
}



