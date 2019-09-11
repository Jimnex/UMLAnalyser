package parser.classdiagram.xml;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class XMLFileParser {
    protected String getValue(Node node, String name){
        Element e = (Element) node;
        String value = e.getAttribute(name);
        return value;
    }
}
