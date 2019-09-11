package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Class;
import jdk.internal.org.xml.sax.SAXException;
import org.w3c.dom.Document;
import parser.classdiagram.ClassDiagramParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class VS15XMLClassDiagramParser extends ClassDiagramParser {
    private Document doc;

    @Override
    protected Collection<Class> getClasses() {
        return null;
    }

    @Override
    public void parse() {
        super.parse();
    }

    @Override
    public String parseName() {
        String name = doc.getDocumentElement().getAttribute("name");
        return name;
    }

    private Document getXMLDocument(File file) throws ParserConfigurationException, IOException, SAXException, ParserConfigurationException, org.xml.sax.SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }

}
