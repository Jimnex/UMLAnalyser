import diagram.Diagram;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("/home/izsof/Code/UMLAnalyser/class.classdiagram");
        DiagramFactory diagramFactory = new DiagramFactory();
        Diagram diagram = diagramFactory.createDiagram(file);
    }

}
