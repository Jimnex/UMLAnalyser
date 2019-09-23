package parser;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class XML{

    public static NodeList getNodeList(Node rootNode, String path){
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList list = null;
        try {
            list = (NodeList)xPath.evaluate(path, rootNode, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            System.out.println("Error with getNodeList()");
            e.printStackTrace();
        }
        return list;
    }

    public static Node getNode(Node rootNode, String path){
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = null;
        try {
            node = (Node)xPath.evaluate(path, rootNode, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            System.out.println("Error with getNode()");
            e.printStackTrace();
        }
        return node;
    }

    public static String getValue(Node node, String name){
        Element e = (Element) node;
        String value = e.getAttribute(name);
        return value;
    }

    public static boolean getBooleanValue(Node node, String name){
        return Boolean.parseBoolean(XML.getValue(node, name));
    }
}
