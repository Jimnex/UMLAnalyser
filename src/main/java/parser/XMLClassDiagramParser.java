package parser;
import diagram.umlclass.ClassDiagram;
import diagram.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Collection;

public class XMLClassDiagramParser extends XMLDiagramParser {


    XMLClassDiagramParser(File file) throws ParserConfigurationException, SAXException, IOException {
        super(file);
    }

    @Override
    public Diagram parse() {
        String diagramName = this.getDiagramName();
        Diagram diagram = new ClassDiagram(diagramName);


        return diagram;
    }

    private String getDiagramName() {
        String name = super.doc.getDocumentElement().getAttribute("name");
        return name;
    }

    private Collection<Class> getClasses(){
        return null;
    }
}
