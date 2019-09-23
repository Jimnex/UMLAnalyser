package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Aggregation;
import diagram.umlclass.Association;
import diagram.umlclass.AssociationNode;
import diagram.umlclass.Multiplicity;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.Parser;
import parser.XML;
import parser.classdiagram.AssociationParser;

public class VS15XMLClassAssociationParser extends AssociationParser {
    private Node node;
    private Node target;
    private Node source;

    public VS15XMLClassAssociationParser(Node associationNode) {
        this.node = associationNode;
        this.source = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[0]/memberEnd");
        this.target = XML.getNode(this.node,"relationshipOwnedElementsInternal/associationHasOwnedEnds[1]/memberEnd");
    }


    @Override
    protected AssociationNode parseAssociationNode(Boolean isSource) {
        if(isSource){
            return this.parseAssociationNode(source);
        } else {
            return this.parseAssociationNode(target);
        }
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
    protected boolean isNavigableOwned() {
        return XML.getBooleanValue(this.source, "isNavigableOwned");
    }

    @Override
    protected Multiplicity parseMultiplicity() {
        //return XML.getValue(this.source, )
        return null;
    }

    private AssociationNode parseAssociationNode(Node node){
        //return new AssociationNode();
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
