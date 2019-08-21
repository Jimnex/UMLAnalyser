package parser;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;

public class XMLClassDiagramParser extends XMLDiagramParser {


    XMLClassDiagramParser(File file) throws ParserConfigurationException, SAXException, IOException {
        super(file);
    }


    @Override
    public DiagramParser parse() {
        return null;
    }
}
