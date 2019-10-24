package diagram.umlclass;

import analyser.Reporter;
import diagram.Element;
import diagram.Diagram;
import parser.Parser;

import java.util.Collection;
import java.util.List;

public class ClassDiagram extends Diagram {
    private final List<Interface> interfaces;
    private final List<Class> classes;

    public ClassDiagram(String filePath, List<Interface> interfaces, List<Class> classes) {
        super(filePath);
        this.interfaces = interfaces;
        this.classes = classes;
    }


    public Reporter analyse() {
        return null;
    }


    public void visualize() {

    }
}
