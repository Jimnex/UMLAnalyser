package parser.classdiagram.xml.visualstudio15;

import diagram.AggregationType;
import diagram.umlclass.Association;
import diagram.AssociationEnd;
import diagram.Multiplicity;
import diagram.umlclass.Interface;
import org.w3c.dom.Node;
import parser.XML;
import parser.classdiagram.AssociationParser;

import java.util.Optional;
import java.util.logging.*;

class VS15XMLClassAssociationParser extends AssociationParser{
    private final org.w3c.dom.Node node;
    private static final Logger LOGGER = Logger.getLogger(VS15XMLClassAssociationParser.class.getName());

    public VS15XMLClassAssociationParser(org.w3c.dom.Node associationNode) {
        this.node = associationNode;
    }

    protected AssociationEnd parseEnd(boolean isSource) {
        Optional<Node> xmlNode;
        if (isSource){
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[1]/memberEnd");
        } else {
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[2]/memberEnd");
        }
        if(xmlNode.isPresent()){
            Multiplicity multiplicity = this.parseMultiplicity(xmlNode.get());

            return new AssociationEnd(this.parseName(xmlNode.get()),
                    this.parseAggregation(xmlNode.get()),
                    this.parseIsNavigableOwned(xmlNode.get()),
                    this.parseMultiplicity(xmlNode.get()));
        } else {
            return new AssociationEnd();
        }
    }

    protected boolean parseIsComposite(Node node) {
        return XML.getBooleanValue(node, "isComposite");
    }

    protected AggregationType parseAggregation(Node node) {
        return AggregationType.createFromStr(XML.getValue(node, "aggregation"));
    }

    protected boolean parseIsNavigableOwned(Node node) {
        return XML.getBooleanValue(node, "isNavigableOwned");
    }

    protected Multiplicity parseMultiplicity(Node node) {
        Optional<Node> lowerNode = XML.getNode(node,"lowerValueInternal/literalString");
        Optional<Node> upperNode = XML.getNode(node,"upperValueInternal/literalString");
        String lowerValue = "";
        String upperValue = "";
        if(lowerNode.isPresent()){
            lowerValue = XML.getValue(lowerNode,"value");
        }
        if(upperNode.isPresent()){
            upperValue = XML.getValue(upperNode,"value");
        }
        Multiplicity multiplicity = new Multiplicity(lowerValue,upperValue);
        return multiplicity;
    }

    public String parseName(Node node) {
        return XML.getValue(node,"name");
    }
}
