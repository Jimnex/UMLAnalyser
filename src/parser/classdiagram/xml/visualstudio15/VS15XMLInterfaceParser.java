package parser.classdiagram.xml.visualstudio15;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.InterfaceParser;
import uml.diagrams.umlclass.Attribute;
import uml.metaclasses.Visibility;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class VS15XMLInterfaceParser extends InterfaceParser {
    private final Node node;
    private Optional<NodeList> attributesNodeList;
    private Optional<NodeList> operationsNodeList;
    private Optional<NodeList> baseNodeList;

    public VS15XMLInterfaceParser(Node interfaceNode) {
        this.node = interfaceNode;
        this.attributesNodeList = XML.getNodeList(this.node,"ownedAttributes/property");
        this.operationsNodeList = XML.getNodeList(this.node, "ownedOperations/operation");
        this.baseNodeList = XML.getNodeList(this.node,"generals/generalization/classMoniker");

    }

    @Override
    public String parseName() {
        return XML.getValue(this.node,"name");
    }

    @Override
    public String parseID() {
        return XML.getValue(this.node,"Id");
    }

    @Override
    protected int getNumberOfAttributes() {
        return getNumberOfNodes(this.attributesNodeList);
    }

    @Override
    protected void getDataForAttribute(int index) {
        super.attributeParser = new VS15XMLClassAttributeParser(this.attributesNodeList.get().item(index));
    }

    @Override
    protected List<Generalization> parseGeneralizations() {
        List<Generalization> generalizations = new ArrayList<>();
        if(this.baseNodeList.isPresent()){
            for (int i = 0; i < this.baseNodeList.get().getLength(); i++) {
                generalizations.add(new Generalization(XML.getValue(this.baseNodeList.get().item(i),"Id")));
            }
        }
        return generalizations;
    }

    @Override
    protected Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.node, "visibility"));
    }

    @Override
    protected boolean parseIsLeaf() {
        return Boolean.parseBoolean(XML.getValue(this.node,"isLeaf"));
    }

    @Override
    protected List<Dependency> parseDependencies() {
        return new ArrayList<>();
    }

    @Override
    protected int getNumberOfOperations() {
        if(this.operationsNodeList.isPresent()){
            return this.operationsNodeList.get().getLength();
        } else {
            return 0;
        }
    }

    @Override
    protected void getDataForOperation(int index) {
        super.operationParser = new VS15XMLClassOperationParser(this.operationsNodeList.get().item(index));
    }

    private int getNumberOfNodes(Optional<NodeList> nodeList){
        if(nodeList.isPresent()){
            return nodeList.get().getLength();
        } else {
            return 0;
        }
    }
}
