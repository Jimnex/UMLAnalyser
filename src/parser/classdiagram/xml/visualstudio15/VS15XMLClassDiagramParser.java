package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Class;
import diagram.umlclass.Interface;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.XML;
import parser.classdiagram.ClassDiagramParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class VS15XMLClassDiagramParser<T> extends ClassDiagramParser {
    private Document doc;
    private String filePath;

    public VS15XMLClassDiagramParser(String filePath) {
        this.filePath = filePath;
        this.openFile();
    }

    protected AbstractMap<String, Class> parseClasses() {
        AbstractMap<String, Class> classes = new HashMap<>();
        NodeList classNodes = this.getClassNodes();
        VS15XMLClassParser classParser;
        for (int i = 0; i < classNodes.getLength(); i++){
            classParser = new VS15XMLClassParser(classNodes.item(i));
            classes.put(classParser.parseID(), classParser.parse());
        }
        return classes;
    }

    @Override
    protected AbstractMap<String, Interface> parseInterfaces() {
        AbstractMap<String, Interface> interfaces = new HashMap<>();
        NodeList interfaceNodeList = this.getInterfaceNodes();
        VS15XMLInterfaceParser interfaceParser;
        for (int i = 0; i < interfaceNodeList.getLength(); i++){
            interfaceParser = new VS15XMLInterfaceParser(interfaceNodeList.item(i));
            interfaces.put(interfaceParser.parseID(), interfaceParser.parse());
        }
        return interfaces;
    }

    private NodeList getInterfaceNodes() {
        return this.doc.getElementsByTagName("Interface");
    }

    private NodeList getClassNodes() {
        //TODO: exception handling
        return this.doc.getElementsByTagName("class");
    }

    @Override
    public String parseName() {
        return this.doc.getDocumentElement().getAttribute("name");
        //TODO: exception handling
    }

    private void openFile(){
        File file = new File(this.filePath);
        try {
            this.parseXMLDocWithDOM(file);
        }catch (Exception e){
            //TODO: exception handling
        }
    }

    private void parseXMLDocWithDOM(File file) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        this.doc = builder.parse(file);
    }
}
