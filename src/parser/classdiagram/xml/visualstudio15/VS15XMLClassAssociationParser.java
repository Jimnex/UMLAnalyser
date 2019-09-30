package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Multiplicity;
import org.w3c.dom.Node;
import parser.XML;
import parser.classdiagram.AssociationParser;
import java.util.logging.*;

class VS15XMLClassAssociationParser extends AssociationParser{
    private final org.w3c.dom.Node node;
    private static final Logger LOGGER = Logger.getLogger(VS15XMLClassAssociationParser.class.getName());

    public VS15XMLClassAssociationParser(org.w3c.dom.Node associationNode) {
        this.node = associationNode;
    }

    @Override
    protected String parseTargetID() {
        return XML.getID(XML.getNode(this.node,"classMoniker"));
    }

    protected Association.Node parseNode(boolean isSource) {
        Node xmlNode;
        if (isSource){
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[1]/memberEnd");
        } else {
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[2]/memberEnd");

        }
        if(xmlNode != null){
            return new Association.Node(this.parseName(xmlNode),
                    this.parseIsComposite(xmlNode),
                    this.parseAggregation(xmlNode),
                    this.parseIsNavigableOwned(xmlNode),
                    this.parseMultiplicity(XML.getNode(xmlNode,"lowerValueInternal/literalString")),
                    this.parseMultiplicity(XML.getNode(xmlNode,"upperValueInternal/literalString")));
        } else {
            //LOGGER.log(Level.FINE, String.format("Warning, no target or source association node found in s%", this.parseName((this.node)))); Parser has no responsibility of logical processing data
            return null;
        }
    }

    protected boolean parseIsComposite(Node node) {
        return XML.getBooleanValue(node, "isComposite");
    }

    protected Aggregation parseAggregation(Node node) {
        return Aggregation.createFromStr(XML.getValue(node, "aggregation"));
    }

    protected boolean parseIsNavigableOwned(Node node) {
        return XML.getBooleanValue(node, "isNavigableOwned");
    }

    protected Multiplicity parseMultiplicity(Node node) {
        Multiplicity multiplicity = null;
        String value = XML.getValue(node, "value");
        try {
            multiplicity = Multiplicity.createFromStr(value);
        } catch (EnumConstantNotPresentException ex){
            //LOGGER.log(Level.FINE, String.format("Warning! Couldn't parse multiplicity value of s% in s%", value, this.parseName(this.node)));Parser has no responsibility of logical processing data
        }
        return multiplicity;
    }

    public String parseName(Node node) {
        return XML.getValue(node,"name");
    }
}
