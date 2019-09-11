package diagram.umlclass;

import analyser.Analyser;
import diagram.Diagram;
import parser.Parser;

import java.util.ArrayList;
import java.util.Collection;

public class ClassDiagram extends Diagram {
    private Collection<Class> classes;

    public ClassDiagram(Parser diagramParser, Analyser analyser) {
        super(diagramParser, analyser);
        classes = new ArrayList<Class>();
    }

    public void addClass(Class c){
        classes.add(c);
    }

    public void removeClass(Class c){
        classes.remove(c);
    }
}
