import diagram.Diagram;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        DiagramFactory diagramFactory = new DiagramFactory();
        Diagram diagram = diagramFactory.createDiagram("/home/izsof/Code/UMLAnalyser/class.classdiagram");
        diagram.parse();
        diagram.analyse();
        //TODO: diagram.visualize();
    }

}
