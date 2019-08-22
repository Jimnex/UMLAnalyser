package parser;

import org.junit.jupiter.api.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class XMLClassDiagramParserTest {
    XMLClassDiagramParser parser;


    @Test
    void getDiagramName() {
        try {
            File classDiagram = new File("/home/izsof/Code/UMLAnalyser/src/test/resources/class.classdiagram");
            this.parser = new XMLClassDiagramParser(classDiagram);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        assertEquals("Test", this.parser.getDiagramName());
    }

    @Test
    void getClasses() {
    }
}