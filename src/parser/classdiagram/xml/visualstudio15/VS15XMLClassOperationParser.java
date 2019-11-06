package parser.classdiagram.xml.visualstudio15;

import uml.metaclasses.Type;
import uml.metaclasses.Visibility;
import uml.diagrams.umlclass.OperationParameter;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.OperationParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class VS15XMLClassOperationParser extends OperationParser {
    private final Node node;

    public VS15XMLClassOperationParser(Node methodNode) {
        this.node = methodNode;
    }

    @Override
    protected Boolean parseIsLeaf() {
        return XML.getBooleanValue(this.node, "isLeaf");
    }

    @Override
    protected String parseID() {
        return XML.getValue(this.node,"Id");
    }

    @Override
    protected Boolean parseIsAbstract() {
        return XML.getBooleanValue(this.node,"isAbstract");
    }

    @Override
    protected Type parseReturnType() {
        Optional<Node> typeNode = XML.getNode(this.node, "ownedParameters/operationHasOwnedParameters/parameter[@direction='Return']/type_NamedElement/referencedTypeMoniker");
        if(typeNode != null){
            return new Type(XML.getValue(typeNode,"Id"),XML.getValue(typeNode,"LastKnownName"));
        } else {
            return new Type();
        }
    }

    @Override
    protected Boolean parseIsStatic() {
        return XML.getBooleanValue(this.node,"isStatic");
    }

    @Override
    protected Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.node, "visibility"));
    }

    @Override
    protected List<OperationParameter> parseParameters() {
        List<OperationParameter> parameters = new ArrayList<>();
        Optional<NodeList> parameterNodes = XML.getNodeList(this.node,"ownedParameters/operationHasOwnedParameters/parameter[@direction='In']");
        if(parameterNodes.isPresent()){
            for (int i = 0; i < parameterNodes.get().getLength(); ++i) {
                parameters.add(parseParameter(parameterNodes.get().item(i)));
            }
        }
        return parameters;
    }

    private OperationParameter parseParameter(Node parameterNode){
        Optional<Node> typeNode = XML.getNode(parameterNode,"type_NamedElement/referencedTypeMoniker");
        if(typeNode.isPresent()){
            return new OperationParameter(XML.getValue(parameterNode,"name"),
                    new Type(XML.getValue(typeNode,"Id"),
                            XML.getValue(typeNode,"LastKnownName")));
        } else {
            System.out.println("operation parameter has not been found, N/A values set");
            return new OperationParameter();
        }
    }

    @Override
    public String parseName() {
        return XML.getValue(this.node, "name");
    }
}
