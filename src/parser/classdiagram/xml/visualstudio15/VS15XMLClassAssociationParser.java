package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Association;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.Parser;

public class VS15XMLClassAssociationParser implements Parser<Association>{
    private Element element;
    private Association association;

    public Association getAssociation() {
        return association;
    }

    public VS15XMLClassAssociationParser(Element associationElement) {
        this.element = associationElement;
    }


        //XmlNode sourceNode = aNode.SelectSingleNode("cd:relationshipOwnedElementsInternal",nsmgr).ChildNodes.Item(0).FirstChild;
        //XmlNode targetNode = aNode.SelectSingleNode("cd:relationshipOwnedElementsInternal", nsmgr).ChildNodes.Item(1).FirstChild;

        //a.Source = getCommonAssociationMemberAttributes(sourceNode);
        //a.Source.ClassName = className;
        //a.Source.ClassID = id;

        //a.Target = getCommonAssociationMemberAttributes(targetNode);
        //a.Target.ClassName = getAttribute(aNode.SelectSingleNode("cd:classMoniker",nsmgr),"LastKnownName");
        //a.Target.ClassID = getAttribute(aNode.SelectSingleNode("cd:classMoniker",nsmgr),"Id");

    @Override
    public Association parse() {
        Node associationXMLNodes = this.element.getChildNodes().item(3);
        //this.association = new Association(this.parseAssociationNodeElement((Element)associationXMLNodes.item(0)),this.parseAssociationNodeElement((Element)associationXMLNodes.item(1)));
        return this.association;
    }



    private Association.AssociationNode parseAssociationNodeElement(Element element) {
        String name = element.getAttribute("sourceEndRoleName");
        return null;
    }

    @Override
    public String parseName() {
        return null;
    }
}
