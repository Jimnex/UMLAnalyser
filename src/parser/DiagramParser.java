package parser;

import diagram.Diagram;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public abstract class DiagramParser implements Parser {

    public DiagramParser(String filePath) throws ParserConfigurationException, IOException, SAXException {
        this.openFile(filePath);
    }

    protected abstract void openFile(String filePath) throws ParserConfigurationException, IOException, SAXException;

}
