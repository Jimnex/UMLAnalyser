package parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import parser.DiagramParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public abstract class XMLFileParser{
    protected final Document doc;

    public XMLFileParser(File file) throws IOException, SAXException, ParserConfigurationException {
        this.doc = this.getXMLDocument(file);
    }

    private Document getXMLDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }

}
