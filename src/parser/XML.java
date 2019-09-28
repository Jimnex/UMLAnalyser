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

import static javax.xml.xpath.XPathConstants.*;

public  class XML{

    public static NodeList getNodeList(Node rootNode, String path){
        XPath xPath = XPathFactory.newInstance().newXPath();
        NodeList list = null;
        try {
            list = (NodeList)xPath.evaluate(path, rootNode, NODESET);
        } catch (XPathExpressionException e) {
            System.out.println("Error with getNodeList()");
            e.printStackTrace();
        }
        return list;
    }

    public static Node getNode(Node rootNode, String path){
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        Node node = null;
        try {
            XPathExpression expr =  xpath.compile(path);
            node = (Node) expr.evaluate(rootNode, XPathConstants.NODE);
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

      public static Document parseXMLDocWithDOM(File file) throws ParserConfigurationException, IOException, SAXException {
          DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
          DocumentBuilder builder = factory.newDocumentBuilder();
          return builder.parse(file);
      }
}
