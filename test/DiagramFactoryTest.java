import analyser.ClassDiagramAnalyser;
import diagram.Diagram;
import diagram.umlclass.ClassDiagram;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import parser.classdiagram.ClassDiagramParser;
import parser.classdiagram.xml.visualstudio15.VS15XMLClassDiagramParser;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class DiagramFactoryTest {

    @Test
    void NoPathFileCreateNullDiagram() {
        assertNull(createDiagram(""));
    }

    @Test
    void dotClassdiagramFileCreateVisualStudio15ClassDiagram(){
        Diagram diagram = createDiagram("/home/izsof/Code/UMLAnalyser/class.classdiagram");
        assertEquals(ClassDiagram.class, diagram.getClass());
        assertEquals(VS15XMLClassDiagramParser.class,diagram.getDiagramParser().getClass());
        assertEquals(ClassDiagramAnalyser.class, diagram.getAnalyser().getClass());
    }

    Diagram createDiagram(String filePath){
        File f = new File(filePath);
        DiagramFactory diagramFactory = new DiagramFactory();
        return diagramFactory.createDiagram(f);
    }

}