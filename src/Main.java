import analyser.Analyser;
import uml.diagrams.Diagram;
import factory.AnalysersFactory;
import factory.ClassDiagramAnalysersFactory;
import factory.DiagramFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;



public class Main {



    public static void main(String[] args) {
        DiagramFactory diagramFactory = new DiagramFactory("/home/izsof/Code/UMLAnalyser/class2.classdiagram");
        Optional<Diagram> diagram = diagramFactory.create();
        if(diagram.isPresent()){
            diagram.get().parse();
        }
        List<String> conventions = new ArrayList<>();
    }

}
