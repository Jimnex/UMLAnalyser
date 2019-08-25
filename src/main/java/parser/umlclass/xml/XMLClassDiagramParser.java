package parser.umlclass.xml;
import diagram.umlclass.*;
import diagram.*;
import diagram.umlclass.Class;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.XMLFileParser;
import parser.umlclass.ClassDiagramParser;
import parser.umlclass.ClassParser;

import javax.xml.parsers.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class XMLClassDiagramParser extends XMLFileParser implements ClassDiagramParser {
    protected final Document doc;
    private ClassDiagram diagram;

    public XMLClassDiagramParser(File file) throws ParserConfigurationException, SAXException, IOException {
        this.doc = this.getXMLDocument(file);
    }

    private Document getXMLDocument(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        return doc;
    }

    @Override
    public void parse() {
        String diagramName = this.parseDiagramName();
        this.diagram = new ClassDiagram(diagramName);
        Collection<Class> classes = this.getClasses();
        diagram.setClasses(classes);
    }

    @Override
    public String parseDiagramName(){
        return super.parseDiagramName(this.doc);
    }

    public Collection<Class> getClasses(){
        Collection<Class> classes = new ArrayList<Class>();
        NodeList classNodes = this.getClassNodes();
        for (int i = 0; i < classNodes.getLength(); i++){
            Node classNode = classNodes.item(i);
            XMLClassParser classParser = new XMLClassParser(classNode);
            classParser.parse();
            classes.add(classParser.getC());
        }
        return classes;
    }

    NodeList getClassNodes(){
        NodeList classNodes = this.doc.getElementsByTagName("class");
        return classNodes;
    }


}
