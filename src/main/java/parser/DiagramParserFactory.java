package parser;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public interface DiagramParserFactory {
    DiagramParser create(File file) throws NotSupportedDiagramParser, IOException, SAXException, ParserConfigurationException;
}
