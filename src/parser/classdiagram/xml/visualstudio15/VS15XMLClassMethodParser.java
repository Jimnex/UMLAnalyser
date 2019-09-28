package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Method;
import diagram.umlclass.Type;
import diagram.umlclass.Visibility;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.XML;
import parser.classdiagram.MethodParser;

import javax.xml.bind.annotation.XmlAccessOrder;
import java.util.ArrayList;
import java.util.List;

public class VS15XMLClassMethodParser extends MethodParser {
    private final Node node;

    public VS15XMLClassMethodParser(Node methodNode) {
        this.node = methodNode;
    }

    @Override
    protected Boolean parseIsAbstract() {
        return XML.getBooleanValue(this.node,"isAbstract");
    }

    @Override
    protected Type parseReturnType() {
        Node typeNode = XML.getNode(this.node, "ownedParameters/operationHasOwnedParameters/parameter[@direction='Return']/type_NamedElement/referencedTypeMoniker");
        return new Type(XML.getValue(typeNode,"Id"),XML.getValue(typeNode,"LastKnownName"));
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
    protected List<Method.Parameter> parseParameters() {
        List<Method.Parameter> parameters = new ArrayList<>();
        NodeList parameterNodes = XML.getNodeList(this.node,"ownedParameters/operationHasOwnedParameters/parameter[@direction='In']");
        for (int i = 0; i < parameterNodes.getLength(); ++i) {
            parameters.add(parseParameter(parameterNodes.item(i)));
        }
        return parameters;
    }

    private Method.Parameter parseParameter(Node parameterNode){
        Node typeNode = XML.getNode(parameterNode,"type_NamedElement/referencedTypeMoniker");
        return new Method.Parameter(XML.getValue(parameterNode,"name"),
                                    new Type(XML.getValue(typeNode,"Id"),
                                             XML.getValue(typeNode,"LastKnownName")));
    }

    @Override
    public String parseName() {
        return XML.getValue(this.node, "name");
    }
}
