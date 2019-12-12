package parser.classdiagram.xml.visualstudio15;

import factory.DiagramFactory;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import parser.classdiagram.ClassDiagramStructureParser;
import uml.diagrams.Diagram;
import uml.diagrams.umlclass.Attribute;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.diagrams.umlclass.Interface;
import uml.diagrams.umlclass.Operation;
import uml.metaclasses.Multiplicity;
import uml.metaclasses.Type;
import uml.metaclasses.Visibility;
import uml.metaclasses.relationship.association.AggregationType;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class VS15XMLClassDiagramStructureParserTest {
    private VS15XMLClassDiagramStructureParser classDiagramStructureParser;
    private ArrayList<Attribute> attributes;
    private Interface i;
    private Attribute attribute;

    @BeforeEach
    void setUp() {
        File file = new File("/home/izsof/Code/UMLAnalyser/InterfaceHasOnlyPublicFieldsAndOperations.classdiagram");
        classDiagramStructureParser = new VS15XMLClassDiagramStructureParser(file);
        classDiagramStructureParser.parse();
    }

    @org.junit.jupiter.api.Test
    void getNumberOfClasses() {
        assertEquals(0,classDiagramStructureParser.getNumberOfClasses());
    }

    @Test
    void getNumberOfInterfaces() {
        assertEquals(4,classDiagramStructureParser.getNumberOfInterfaces());
    }

    @Test
    void parseName() {
        assertEquals("InterfaceHasOnlyPublicFieldsAndOperations", this.classDiagramStructureParser.parseName());
    }
}