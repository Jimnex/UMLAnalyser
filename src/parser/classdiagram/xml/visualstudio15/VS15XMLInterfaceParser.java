package parser.classdiagram.xml.visualstudio15;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.InterfaceParser;
import uml.diagrams.umlclass.Attribute;
import uml.metaclasses.Visibility;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.List;
import java.util.Optional;

class VS15XMLInterfaceParser extends InterfaceParser {
    private final Node node;
    private final Optional<NodeList> operationsNodeList;

    public VS15XMLInterfaceParser(Node interfaceNode) {
        this.node = interfaceNode;
        this.operationsNodeList = XML.getNodeList(this.node, "ownedOperations/operation");
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
    protected List<Attribute> parseAttributes() {
        return null;
    }

    @Override
    protected List<Generalization> parseGeneralizations() {
        return null;
    }

    @Override
    protected Visibility parseVisibility() {
        return null;
    }

    @Override
    protected boolean parseIsLeaf() {
        return false;
    }

    @Override
    protected List<Dependency> parseDependencies() {
        return null;
    }

    @Override
    protected List<String> parseBases() {
        return null;
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
}
