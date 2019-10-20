package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Operation;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.InterfaceParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class VS15XMLInterfaceParser extends InterfaceParser {
    private final Node node;

    public VS15XMLInterfaceParser(Node interfaceNode) {
        this.node = interfaceNode;
    }

    @Override
    protected List<Operation> parseMethods() {
        List<Operation> operations = new ArrayList<>();
        Optional<NodeList> methodNodes = XML.getNodeList(this.node, "ownedOperations/operation");
        if(methodNodes.isPresent()){
            for (int i = 0; i < methodNodes.get().getLength(); ++i){
                operations.add((new VS15XMLClassOperationParser(methodNodes.get().item(i)).parse()));
            }
        }
        return operations;
    }

    @Override
    protected List<String> parseBaseIDs() {
        return new ArrayList<>();
    }

    @Override
    public String parseName() {
        return XML.getValue(this.node,"name");
    }

    @Override
    public String parseID() {
        return XML.getValue(this.node,"Id");
    }
}
