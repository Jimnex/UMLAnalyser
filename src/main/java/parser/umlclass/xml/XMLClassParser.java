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

public class XMLClassParser extends XMLFileParser implements ClassParser {
    private final Node classNode;
    private Class c;

    public Class getC() {
        return c;
    }

    public XMLClassParser(Node classNode) {
        this.classNode = classNode;
    }

    @Override
    public void parse(){
        String name = this.parseClassName();
        this.c = new Class(name);
        Visibility visibility = this.parseVisibility();
        c.setVisibility(visibility);


    }

    @Override
    public Visibility parseVisibility() {
        String strVisibility = super.getValue(this.classNode, "visibility");
        Visibility visibility = Visibility.createFromStr(strVisibility);
        return visibility;
    }

    @Override
    public Boolean parseIsAbstract() {
        return false;
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
        return super.getValue(classNode, "name");
    }


}
