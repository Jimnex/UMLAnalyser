package diagram.umlclass;

import analyser.Analyser;
import analyser.ClassDiagramAnalyser;
import diagram.Diagram;
import parser.Parser;

import java.util.ArrayList;
import java.util.Collection;

public class ClassDiagram extends Diagram {
    private Collection<Class> classes;

    public ClassDiagram(Parser diagramParser) {
        super(diagramParser, new ClassDiagramAnalyser());
        classes = new ArrayList<>();
    }

    public void addClass(Class c){
        classes.add(c);
    }

    public void removeClass(Class c){
        classes.remove(c);
    }
}
