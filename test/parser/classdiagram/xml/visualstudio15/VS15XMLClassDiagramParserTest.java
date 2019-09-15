package parser.classdiagram.xml.visualstudio15;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VS15XMLClassDiagramParserTest {
    private VS15XMLClassDiagramParser parser;

    @BeforeEach
    void setUp() {
        this.parser = new VS15XMLClassDiagramParser("/home/izsof/Code/UMLAnalyser/class.classdiagram");
    }

    @AfterEach
    void tearDown() {
        this.parser = null;
    }

    @Test
    void parseNameTest(){
        String name = this.parser.parseName();
        assertEquals("Test",name);
    }
}