package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Method;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.InterfaceParser;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class VS15XMLInterfaceParser extends InterfaceParser {
    private final Node node;

    public VS15XMLInterfaceParser(Node interfaceNode) {
        this.node = interfaceNode;
    }

    @Override
    protected List<Method> parseMethods() {
        List<Method> methods = new ArrayList<>();
        NodeList methodNodes = XML.getNodeList(this.node, "ownedOperations/operation");
        for (int i = 0; i < methodNodes.getLength(); ++i){
            methods.add((new VS15XMLClassMethodParser(methodNodes.item(i)).parse()));
        }
        return methods;
    }

    @Override
    protected List<String> parseBaseIDs() {
        throw new NotImplementedException();
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
