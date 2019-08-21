package parser;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public abstract class XMLDiagramParser extends DiagramParser{
    protected final Document doc;

    XMLDiagramParser(File file) throws IOException, SAXException, ParserConfigurationException {
        super(file);
        this.doc = this.getXMLDocument(file);
    }

    private Document getXMLDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }

}
