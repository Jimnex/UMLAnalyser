package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Type;
import diagram.umlclass.Visibility;
import org.w3c.dom.Node;
import parser.XML;
import parser.classdiagram.FieldParser;

class VS15XMLClassFieldParser extends FieldParser {
    private final Node node;

    public VS15XMLClassFieldParser(Node fieldNode) {
        this.node = fieldNode;
    }

    @Override
    protected Type parseType() {
        Node typeNode = XML.getNode(this.node, "type_NamedElement/referencedTypeMoniker");
        return new Type(XML.getValue(typeNode,"Id"),XML.getValue(typeNode,"LastKnownName"));
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
    protected Aggregation parseAggregation() {
        return Aggregation.createFromStr(XML.getValue(this.node, "aggregation"));
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
