package parser;
import diagram.umlclass.*;
import diagram.*;
import diagram.umlclass.Class;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;
import java.util.Collection;

public class XMLClassDiagramParser extends XMLFileParser implements ClassDiagramParser {

    XMLClassDiagramParser(File file) throws ParserConfigurationException, SAXException, IOException {
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
        return null;
    }

    @Override
    public Class parseClass() {
        return null;
    }

    @Override
    public Collection<Association> getAssociations() {
        return null;
    }

    @Override
    public Association parseAssociation() {
        return null;
    }

    @Override
    public Collection<Field> getFields() {
        return null;
    }

    @Override
    public Field parseField() {
        return null;
    }

    @Override
    public Collection<Method> getMethods() {
        return null;
    }

    @Override
    public Method parseMethods() {
        return null;
    }

    @Override
    public Collection<Dependency> getDependencies() {
        return null;
    }

    @Override
    public Dependency parseDependency() {
        return null;
    }
}
