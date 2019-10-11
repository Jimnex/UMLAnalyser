package parser.classdiagram.xml.visualstudio15;

import diagram.umlclass.Visibility;
import org.junit.jupiter.api.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class VS15XMLClassesParserTest {
    private VS15XMLClassesParser parser;

    @BeforeEach
    void setUp() throws ParserConfigurationException, IOException, SAXException {
        File file = new File("/home/izsof/Code/UMLAnalyser/class.classdiagram");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(file);
        NodeList classNodes = doc.getElementsByTagName("class");
        Element classNode = (Element) classNodes.item(0);
        this.parser = new VS15XMLClassesParser(classNode);
    }

    @AfterEach
    void tearDown() {
        this.parser = null;
    }

    @Test
    void parseName() {
        assertEquals("Source", parser.parseName());
    }

    @Test
    void parseVisibility() {
        assertEquals(Visibility.PRIVATE, this.parser.parseVisibility());
    }

    @Test
    void parseIsAbstract() {
        assertEquals(false, this.parser.parseIsAbstract());
    }

    @Test
    void getAssociations() {

    }

    @Test
    void getFields() {
    }

    @Test
    void getMethods() {
    }

    @Test
    void getDependencies() {
    }
}