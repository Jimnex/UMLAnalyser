package parser.classdiagram.xml.visualstudio15;

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
    private Optional<NodeList> generalsNodeList;
    private Optional<NodeList> realizationNodeList;

    VS15XMLClassParser(Node classnode){
        this.classnode = classnode;
        this.attributesNodeList = this.getNodeList("ownedAttributesInternal/property");
        this.operationsNodeList = this.getNodeList("ownedOperationsInternal/operation");
        this.associationsNodeList = this.getNodeList("targetEnds/association");
        this.generalsNodeList = this.getNodeList("generalsInternal/generalization/classMoniker");
        this.realizationNodeList = this.getNodeList("suppliersInternal/interfaceRealization/interfaceMoniker");
    }

    private Optional<NodeList> getNodeList(String xPath){
        return XML.getNodeList(this.classnode, xPath);
    }

    @Override
    protected List<Dependency> parseDependencies() {
        return new ArrayList<Dependency>();
    }

    @Override
    protected List<Generalization> parseGeneralization() {
        List<Generalization> generalizations = new ArrayList<>();
        if(this.generalsNodeList.isPresent()){
            for (int i = 0; i < this.generalsNodeList.get().getLength(); i++) {
                generalizations.add(new Generalization(XML.getValue(this.generalsNodeList.get().item(i),"Id")));
            }
        }

        if(this.realizationNodeList.isPresent()){
            for (int i = 0; i < this.realizationNodeList.get().getLength(); i++) {
                generalizations.add(new Generalization(XML.getValue(this.realizationNodeList.get().item(i),"Id")));
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
        return Boolean.parseBoolean(XML.getValue(classnode,"isLeaf"));
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
