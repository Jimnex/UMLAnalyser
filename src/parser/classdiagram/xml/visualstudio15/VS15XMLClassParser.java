package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.*;
import diagram.umlclass.Class;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
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

    public Class getC() {
        return c;
    }

    public VS15XMLClassParser(Element classElement) {
        this.classElement = classElement;
    }

    @Override
    public String parseName() {
        return this.getValue(this.classElement, "name");
    }

    @Override
    public Visibility parseVisibility() {
        String strVisibility = this.getValue(this.classElement, "visibility");
        return Visibility.createFromStr(strVisibility);
        //TODO: Should be exception handling here?
    }

    @Override
    public Boolean parseIsAbstract() {
        return Boolean.parseBoolean(this.getValue(classElement, "isAbstract"));
    }

    @Override
    public Collection<Association> getAssociations() {
        List<Association> associations = new ArrayList<>();
        NodeList associationNodes = this.getAssociationsNodes();
        VS15XMLClassAssociationParser associationParser;
        for (int i = 0; i < associationNodes.getLength(); i++){
            Element associationElement = (Element) associationNodes.item(i);
            associationParser = new VS15XMLClassAssociationParser(associationElement);
            associationParser.parse();
            associations.add(associationParser.getAssociation());
        }
        return associations;
    }

    private NodeList getAssociationsNodes(){
        //TODO: Handling when there is no association
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList associationNodes = null;
        try {
            associationNodes = (NodeList)xPath.evaluate("targetEnds/association",
            (Node)this.classElement, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return associationNodes;
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

    protected String getValue(Node node, String name){
        Element e = (Element) node;
        String value = e.getAttribute(name);
        return value;
    }

}
