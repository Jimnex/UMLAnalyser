import diagram.Diagram;


public class Main {

    public static Diagram DIAGRAM;

    public static void main(String[] args) {
        DiagramFactory diagramFactory = new DiagramFactory();
        DIAGRAM = diagramFactory.createDiagram("/home/izsof/Code/UMLAnalyser/class.classdiagram");
        //TODO: diagram.visualize();
    }

}
