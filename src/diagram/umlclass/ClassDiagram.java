package diagram.umlclass;

import analyser.Analyser;
import analyser.ClassDiagramAnalyser;
import diagram.Diagram;
import parser.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClassDiagram extends Diagram {
    private final List<Class> classes;

    public ClassDiagram(String name, List<Class> classes) {
        super(name);
        this.classes = classes;
    }

    public void addClass(Class c){
        classes.add(c);
    }

    public void removeClass(Class c){
        classes.remove(c);
    }
}
