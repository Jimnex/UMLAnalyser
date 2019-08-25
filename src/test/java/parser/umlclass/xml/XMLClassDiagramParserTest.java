package parser.umlclass.xml;

import org.junit.jupiter.api.*;
import org.w3c.dom.NodeList;
import diagram.umlclass.Class;
import parser.umlclass.xml.XMLClassDiagramParser;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class XMLClassDiagramParserTest {
    XMLClassDiagramParser parser;



    @BeforeEach
    void setUp() {
        try {
            File classDiagram = new File("/home/izsof/Code/UMLAnalyser/src/test/resources/class.classdiagram");
            this.parser = new XMLClassDiagramParser(classDiagram);
        } catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    @AfterEach
    void tearDown() {
        this.parser = null;
    }

    @Test
    void parseDiagramNameTest() {
        assertEquals("Test", this.parser.parseDiagramName());
    }

    @Test
    void parseClassTest() {
        NodeList classNodes = this.parser.getClassNodes();
        Class expected = new Class("Source");
        Class actual = this.parser.parseClass(classNodes.item(0));
        assertEquals(expected.getName(), actual.getName());

    }


}