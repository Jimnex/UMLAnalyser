import diagram.Diagram;

import java.io.File;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        DiagramFactory diagramFactory = new DiagramFactory();
        Optional<Diagram> diagram = diagramFactory.createDiagram("/home/izsof/Code/UMLAnalyser/class2.classdiagram");
        //TODO: diagram.visualize();
    }

}
