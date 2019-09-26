package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Multiplicity;
import org.w3c.dom.Node;
import parser.XML;
import parser.classdiagram.AssociationParser;

public class VS15XMLClassAssociationParser  extends AssociationParser{
    private org.w3c.dom.Node node;

    public VS15XMLClassAssociationParser(org.w3c.dom.Node associationNode) {
        this.node = associationNode;
    }

    protected Association.Node parseNode(boolean isSource) {
        Node xmlNode;
        if (isSource){
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[1]/memberEnd");
        } else {
            xmlNode = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[2]/memberEnd");
        }
        return new Association.Node(this.parseName(xmlNode),
                this.parseIsComposite(xmlNode),
                this.parseAggregation(xmlNode),
                this.parseIsNavigableOwned(xmlNode),
                this.parseMultiplicity(XML.getNode(xmlNode,"lowerValueInternal/literalString")),
                this.parseMultiplicity(XML.getNode(xmlNode,"upperValueInternal/literalString")));
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
        return Multiplicity.createFromStr(XML.getValue(node, "value"));
    }

    public String parseName(Node node) {
        return XML.getValue(node,"name");
    }
}





//XmlNode sourceNode = aNode.SelectSingleNode("cd:relationshipOwnedElementsInternal",nsmgr).ChildNodes.Item(0).FirstChild;
//XmlNode targetNode = aNode.SelectSingleNode("cd:relationshipOwnedElementsInternal", nsmgr).ChildNodes.Item(1).FirstChild;

//a.Source = getCommonAssociationMemberAttributes(sourceNode);
//a.Source.ClassName = className;
//a.Source.ClassID = id;

//a.Target = getCommonAssociationMemberAttributes(targetNode);
//a.Target.ClassName = getAttribute(aNode.SelectSingleNode("cd:classMoniker",nsmgr),"LastKnownName");
//a.Target.ClassID = getAttribute(aNode.SelectSingleNode("cd:classMoniker",nsmgr),"Id");
