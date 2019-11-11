package parser.classdiagram.xml.visualstudio15;

import uml.metaclasses.Multiplicity;
import uml.metaclasses.relationship.association.AggregationType;
import uml.metaclasses.Type;
import uml.metaclasses.Visibility;
import org.w3c.dom.Node;
import parser.XML;
import parser.classdiagram.AttributeParser;

import java.util.Optional;

class VS15XMLClassAttributeParser extends AttributeParser {
    private final Node node;

    public VS15XMLClassAttributeParser(Node fieldNode) {
        this.node = fieldNode;
    }

    @Override
    protected Multiplicity parseMultiplicity() {
        return null;
    }

    @Override
    protected String parseId() {
        return XML.getValue(node,"Id");
    }

    @Override
    protected Boolean parseIsLeaf() {
        return null;
    }

    @Override
    protected Type parseType() {
        Optional<Node> typeNode = XML.getNode(this.node, "type_NamedElement/referencedTypeMoniker");
        if(typeNode.isPresent()){
            return new Type(XML.getValue(typeNode,"Id"),XML.getValue(typeNode,"LastKnownName"));
        } else {
            System.out.println("There was no typeNode, Type set to N/A");
            return new Type();
        }
    }

    @Override
    protected Visibility parseVisibility() {
        return Visibility.createFromStr(XML.getValue(this.node, "visibility"));
    }

    @Override
    protected Boolean parseIsStatic() {
        return XML.getBooleanValue(this.node,"isStatic");
    }

    @Override
    protected Boolean parseIsReadOnly() {
        return XML.getBooleanValue(this.node,"isReadOnly");
    }

    @Override
    protected AggregationType parseAggregation() {
        return AggregationType.createFromStr(XML.getValue(this.node, "aggregation"));
    }

    @Override
    protected Boolean parseIsComposite() {
        return XML.getBooleanValue(this.node,"isComposite");
    }

    @Override
    public String parseName() {
        return XML.getValue(this.node,"name");
    }
}
