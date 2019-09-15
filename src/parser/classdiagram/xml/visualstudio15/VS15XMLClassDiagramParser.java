package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Class;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.classdiagram.ClassDiagramParser;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VS15XMLClassDiagramParser extends ClassDiagramParser {
    private Document doc;

    public VS15XMLClassDiagramParser(String filePath) {
        super(filePath);
    }

    @Override
    protected List<Class> parseClasses() {
        List<Class> classes = new ArrayList<Class>();
        NodeList classNodes = this.getClassNodes();
        for (int i = 0; i < classNodes.getLength(); i++){
            Element classNode = (Element) classNodes.item(i);
            VS15XMLClassParser classParser = new VS15XMLClassParser(classNode);
            classParser.parse();
            classes.add(classParser.getC());
        }
        return classes;
    }

    private NodeList getClassNodes() {
        //TODO: exception handling
        NodeList classNodes = this.doc.getElementsByTagName("class");
        return classNodes;
    }

    @Override
    public String parseName() {
        return this.doc.getDocumentElement().getAttribute("name");
        //TODO: exception handling
    }

    @Override
    public void openFile(String path){
        File file = new File(path);
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
