package diagram.umlclass;

import diagram.Diagram;

import java.util.*;

public class ClassDiagram extends Diagram {
    private final AbstractMap<String, Class> classes;
    private final AbstractMap<String, Interface> interfaces;

    public ClassDiagram(String name, AbstractMap<String, Class> classes, AbstractMap<String, Interface> interfaces) {
        super(name);
        this.classes = classes;
        this.interfaces = interfaces;
    }

    public void addClass(String id, Class c){
        classes.put(id, c);
    }

    public Class getClass(int index){
        return classes.remove(index);
    }
}
