package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.ClassParser;

import java.util.ArrayList;
import java.util.List;


public class VS15XMLClassParser extends ClassParser {
    private final Node node;

//region Completed Implementation
    public VS15XMLClassParser(Node node) {
        this.node = node;
    }

    @Override
    public String parseName() {
        return XML.getValue(this.node, "name");
    }

    @Override
    protected Boolean parseIsStatic() {
        return null;
    }

    @Override
    public Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.node, "visibility"));
    }

    @Override
    public Boolean parseIsAbstract() {
        return Boolean.parseBoolean(XML.getValue(node, "isAbstract"));
    }
    //endregion

    @Override
    public List<Association> getAssociations() {
        List<Association> associations = new ArrayList<>();
        NodeList associationNodes = XML.getNodeList(this.node,"targetEnds/association");
        for (int i = 0; i < associationNodes.getLength(); ++i){
            associations.add((new VS15XMLClassAssociationParser(associationNodes.item(i)).parse()));
        }
        return associations;
    }

    @Override
    public List<Field> getFields() {
        List<Field> fields = new ArrayList<>();
        NodeList fieldNodes = XML.getNodeList(this.node, "ownedAttributesInternal/property");
        for (int i = 0; i < fieldNodes.getLength(); ++i){
            fields.add((new VS15XMLClassFieldParser(fieldNodes.item(i)).parse()));
        }
        return fields;
    }

    @Override
    public List<Method> getMethods() {
        List<Method> methods = new ArrayList<>();
        NodeList methodNodes = XML.getNodeList(this.node, "ownedOperationsInternal/operation");
        for (int i = 0; i < methodNodes.getLength(); ++i){
            methods.add((new VS15XMLClassMethodParser(methodNodes.item(i)).parse()));
        }
        return methods;
    }

    @Override
    protected List<String> getBaseIDs() {
        return this.getIDs("generalsInternal/generalization/classMoniker");
    }

    private List<String> getIDs(String xpath){
        List<String> ids = new ArrayList<>();
        NodeList baseIDNodes = XML.getNodeList(this.node,xpath);
        for (int i = 0; i < baseIDNodes.getLength(); ++i) {
            ids.add(getID(baseIDNodes.item(i)));
        }
        return ids;
    }

    private String getID(Node node){
        return XML.getValue(node, "Id");
    }

    private <T> List<T> collect(String xpath, Object parser){
        List<T> list = new ArrayList<>();
        NodeList nodeList = XML.getNodeList(this.node, xpath);
        for (int i = 0; i < nodeList.getLength(); ++i){
            //list.add((parser(nodeList.item(i)).parse()));
        }
        return list;
    }


    @Override
    public String parseID() {
        return XML.getValue(this.node, "Id");
    }
}
