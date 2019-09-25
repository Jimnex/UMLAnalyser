package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.Multiplicity;
import parser.XML;
import parser.classdiagram.AssociationParser;

public class VS15XMLClassAssociationParser extends AssociationParser {
    private org.w3c.dom.Node node;
    private org.w3c.dom.Node target;
    private org.w3c.dom.Node source;

    public VS15XMLClassAssociationParser(org.w3c.dom.Node associationNode) {
        this.node = associationNode;
        this.source = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[0]/memberEnd");
        this.target = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[1]/memberEnd");
    }

    @Override
    protected boolean parseIsComposite() {
        return XML.getBooleanValue(this.source, "isComposite");
    }

    @Override
    protected Aggregation parseAggregation() {
        return Aggregation.createFromStr(XML.getValue(this.source, "aggregation"));
    }

    @Override
    protected boolean parseIsNavigableOwned() {
        return XML.getBooleanValue(this.source, "isNavigableOwned");
    }


    @Override
    protected Multiplicity parseMultiplicity(boolean isLower) {
        return Multiplicity.createFromStr(XML.getValue(this.source, "value"));
    }


    @Override
    public String parseName() {
        return null;
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
