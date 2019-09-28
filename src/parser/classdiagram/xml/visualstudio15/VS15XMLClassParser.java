package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.ClassParser;

import java.util.ArrayList;
import java.util.List;


public class VS15XMLClassParser extends ClassParser {
    private final Node classNode;

//region Completed Implementation
    public VS15XMLClassParser(Node classNode) {
        this.classNode = classNode;
    }

    @Override
    public String parseName() {
        return XML.getValue(this.classNode, "name");
    }

    @Override
    protected Boolean parseIsStatic() {
        return null;
    }

    @Override
    public Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.classNode, "visibility"));
        //TODO: Should be exception handling here?
    }

    @Override
    public Boolean parseIsAbstract() {
        return Boolean.parseBoolean(XML.getValue(classNode, "isAbstract"));
    }
    //endregion

    @Override
    public List<Association> getAssociations() {
        List<Association> associations = new ArrayList<>();
        NodeList associationNodes = XML.getNodeList(this.classNode,"targetEnds/association");
        for (int i = 0; i < associationNodes.getLength(); ++i){
            associations.add((new VS15XMLClassAssociationParser(associationNodes.item(i)).parse()));
        }
        return associations;
    }

    @Override
    public List<Field> getFields() {
        List<Field> fields = new ArrayList<>();
        NodeList fieldNodes = XML.getNodeList(this.classNode, "ownedAttributesInternal/property");
        for (int i = 0; i < fieldNodes.getLength(); ++i){
            fields.add((new VS15XMLClassFieldParser(fieldNodes.item(i)).parse()));
        }
        return fields;
    }

    @Override
    public List<Method> getMethods() {
        List<Method> methods = new ArrayList<>();
        NodeList methodNodes = XML.getNodeList(this.classNode, "ownedOperationsInternal/operation");
        for (int i = 0; i < methodNodes.getLength(); ++i){
            methods.add((new VS15XMLClassMethodParser(methodNodes.item(i)).parse()));
        }
        return methods;
    }
    
    private <T> List<T> collect(String xpath, Object parser){
        List<T> list = new ArrayList<>();
        NodeList nodeList = XML.getNodeList(this.classNode, xpath);
        for (int i = 0; i < nodeList.getLength(); ++i){
            //list.add((parser(nodeList.item(i)).parse()));
        }
        return list;
    }

    @Override
    public List<Dependency> getDependencies() {
        return null;
    }



}
