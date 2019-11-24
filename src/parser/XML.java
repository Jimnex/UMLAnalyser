package parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

import static javax.xml.xpath.XPathConstants.*;

public class XML{

    public static Optional<NodeList> getNodeList(Node rootNode, String path){
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList list = null;
        try {
            list = (NodeList)xPath.evaluate(path, rootNode, NODESET);
        } catch (XPathExpressionException e) {
            System.out.println("Error with getNodeList()"); //TODO: just add to the logger
            e.printStackTrace();
        }
        return Optional.ofNullable(list);
    }

    public static Optional<Node> getNode(Node rootNode, String path){
        XPath xPath = XPathFactory.newInstance().newXPath();
        Node node = null;
        try {
            XPathExpression expr =  xPath.compile(path);
            node = (Node) expr.evaluate(rootNode, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            System.out.println("Error with getNode()");
            e.printStackTrace();
        }
        return Optional.ofNullable(node);
    }

    public static String getValue(Node node, String name){
        Element e = (Element) node;
        String value = e.getAttribute(name);
        return value;
    }

    public static String getValue(Optional<Node> node, String name){
        String value = "N/A";
        if(node.isPresent()){
            Element e = (Element) node.get();
            value = e.getAttribute(name);
        }
        return value;
    }

    public static boolean getBooleanValue(Node node, String name){
        String value = XML.getValue(node,name);
        if(value == "N/A"){
            System.out.println("there was no value set to false");
            return false;
        }
        return Boolean.parseBoolean(value);
    }

    public static Document parseXMLDocWithDOM(File file) throws ParserConfigurationException, IOException, SAXException {
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          return builder.parse(file);
    }
}
