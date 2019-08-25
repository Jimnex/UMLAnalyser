package parser.umlclass.xml;

import diagram.Diagram;
import diagram.umlclass.*;
import diagram.umlclass.Class;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import parser.XMLFileParser;
import parser.umlclass.ClassDiagramParser;
import parser.umlclass.ClassParser;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class XMLClassParser implements ClassParser {

    @Override
    public Visibility parseVisibility() {
        return null;
    }

    @Override
    public Collection<Association> getAssociations() {
        return null;
    }

    @Override
    public Collection<Field> getFields() {
        return null;
    }

    @Override
    public Collection<Method> getMethods() {
        return null;
    }

    @Override
    public Collection<Dependency> getDependencies() {
        return null;
    }

    @Override
    public String parseClassName() {
        return null;
    }


}
