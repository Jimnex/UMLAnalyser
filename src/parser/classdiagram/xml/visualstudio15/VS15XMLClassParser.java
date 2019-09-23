package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.*;
import diagram.umlclass.Class;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.ClassParser;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class VS15XMLClassParser extends ClassParser {
    private final Element classElement;

//region Completed Implementation
    public VS15XMLClassParser(Element classElement) {
        this.classElement = classElement;
    }

    @Override
    public String parseName() {
        return XML.getValue(this.classElement, "name");
    }

    @Override
    public Visibility parseVisibility() {
        String strVisibility = XML.getValue(this.classElement, "visibility");
        return Visibility.createFromStr(strVisibility);
        //TODO: Should be exception handling here?
    }

    @Override
    public Boolean parseIsAbstract() {
        return Boolean.parseBoolean(XML.getValue(classElement, "isAbstract"));
    }
    //endregion

    @Override
    public Collection<Association> getAssociations() {
        List<Association> associations = new ArrayList<>();
        NodeList associationNodes = XML.getNodeList(this.classElement,"targetEnds/association");
        VS15XMLClassAssociationParser associationParser;
        for (int i = 0; i < associationNodes.getLength(); i++){
            associationParser = new VS15XMLClassAssociationParser(associationNodes.item(i));
            associations.add(associationParser.parse());
        }
        return associations;
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



}
