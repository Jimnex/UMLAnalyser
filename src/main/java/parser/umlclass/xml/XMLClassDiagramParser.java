package parser.umlclass.xml;
import diagram.umlclass.*;
import diagram.*;
import diagram.umlclass.Class;
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

    public XMLClassDiagramParser(File file) throws ParserConfigurationException, SAXException, IOException {
        super(file);
    }

    @Override
    public Diagram parse() {
        String diagramName = this.parseDiagramName();
        Diagram diagram = new ClassDiagram(diagramName);


        return diagram;
    }

    @Override
    public String parseDiagramName() {
        String name = super.doc.getDocumentElement().getAttribute("name");
        return name;
    }

    public Collection<Class> getClasses(){
        Collection<Class> classes = new ArrayList<Class>();
        NodeList classNodes = this.getClassNodes();
        for (int i = 0; i < classNodes.getLength(); i++){
            Node classNode = classNodes.item(i);
            Class c = parseClass(classNode);
            classes.add(c);
        }
        return classes;
    }

    NodeList getClassNodes(){
        NodeList classNodes = super.doc.getElementsByTagName("class");
        return classNodes;
    }

    Class parseClass(Node classNode) {
        String name = this.getValue(classNode,"name");
        Class c = new Class(name);
        Visibility visibility  = getVisibility(classNode);
        c.setVisibility(visibility);

        return c;

    }
    private Visibility getVisibility(Node node){
        String strVisibility = getValue(node, "visibility");
        Visibility visibility = Visibility.createFromStr(strVisibility);
        return visibility;
    }

    private String getValue(Node node, String name){
        Element e = (Element) node;
        String value = e.getAttribute(name);
        return value;
    }
}
