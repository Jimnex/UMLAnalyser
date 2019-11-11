package parser.classdiagram.xml.visualstudio15;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uml.metaclasses.Visibility;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.ClassParser;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class VS15XMLClassParser extends ClassParser {
    private final Node classnode;
    private Optional<NodeList> attributesNodeList;
    private Optional<NodeList> operationsNodeList;
    private Optional<NodeList> associationsNodeList;
    private Optional<NodeList> baseNodeList;


    VS15XMLClassParser(Node classnode){
        this.classnode = classnode;
        this.attributesNodeList = this.getNodeList("ownedAttributesInternal/property");
        this.operationsNodeList = this.getNodeList("ownedOperationsInternal/operation");
        this.associationsNodeList = this.getNodeList("targetEnds/association");
        this.baseNodeList = this.getNodeList("generalsInternal/generalization/classMoniker");
    }

    private Optional<NodeList> getNodeList(String xPath){
        return XML.getNodeList(this.classnode, xPath);
    }

    @Override
    protected List<Dependency> parseDependencies() {
        throw new NotImplementedException();
    }

    @Override
    protected List<Generalization> parseGeneralization() {
        List<Generalization> generalizations = new ArrayList<>();
        if(this.baseNodeList.isPresent()){
            for (int i = 0; i < this.baseNodeList.get().getLength(); i++) {
                generalizations.add(new Generalization(XML.getValue(this.baseNodeList.get().item(i),"Id")));
            }
        }
        return generalizations;
    }

    @Override
    protected String parseID() {
        return XML.getValue(this.classnode, "Id");
    }

    @Override
    protected String parseName() {
        return XML.getValue(this.classnode, "name");
    }

    @Override
    protected Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.classnode, "visibility"));
    }

    @Override
    protected Boolean parseIsAbstract() {
        return Boolean.parseBoolean(XML.getValue(classnode, "isAbstract"));
    }

    @Override
    protected Boolean parseIsLeaf() {
        return null;
    }

    //region bases

//endregion

    //region getNumberOfNodes

    @Override
    protected int getNumberOfAttributes() {
        return getNumberOfNodes(this.attributesNodeList);
    }

    @Override
    protected int getNumberOfAssociations() {
        return getNumberOfNodes(this.associationsNodeList);
    }

    @Override
    protected int getNumberOfOperations() {
        return getNumberOfNodes(this.operationsNodeList);
    }

    private int getNumberOfNodes(Optional<NodeList> nodeList){
        if(nodeList.isPresent()){
            return nodeList.get().getLength();
        } else {
            return 0;
        }
    }

    //endregion

    //region getDataForSubParsers

    //TODO: take a look at Template Method Pattern --> https://stackoverflow.com/questions/19666652/changing-the-value-of-superclass-instance-variables-from-a-subclass

    @Override
    protected void getDataForAttribute(int index) {
        super.attributeParser = new VS15XMLClassAttributeParser(this.attributesNodeList.get().item(index));
    }

    @Override
    protected void getDataForOperation(int index) {
        super.operationParser = new VS15XMLClassOperationParser(this.operationsNodeList.get().item(index));
    }

    @Override
    protected void getDataForAssociation(int index) {
        super.associationParser = new VS15XMLClassAssociationParser(this.associationsNodeList.get().item(index));
    }

    //endregion
}
