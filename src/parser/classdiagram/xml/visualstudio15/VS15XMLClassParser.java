package parser.classdiagram.xml.visualstudio15;

import diagram.Visibility;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.ClassParser;

import java.util.List;
import java.util.Optional;

public class VS15XMLClassParser extends ClassParser {
    private final Node classnode;
    private Optional<NodeList> attributesNodeList;
    private Optional<NodeList> operationsNodeList;
    private Optional<NodeList> associationsNodeList;


    VS15XMLClassParser(Node classnode){
        this.classnode = classnode;
        attributesNodeList = this.getNodeList("ownedAttributesInternal/property");
        operationsNodeList = this.getNodeList("ownedOperationsInternal/operation");
        associationsNodeList = this.getNodeList("targetEnds/association");
    }

    private Optional<NodeList> getNodeList(String xPath){
        return XML.getNodeList(this.classnode, xPath);
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

    //region bases

    @Override
    protected List<String> getBaseIDs() {
        return null;
    }

    @Override
    protected List<String> parseBaseClasses() {
        return null;
    }

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
