package diagram.umlclass;

import diagram.Structure;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagramStructure implements Structure {
    private final List<Interface> interfaces;
    private final List<Class> classes;

    public ClassDiagramStructure(List<Interface> interfaces, List<Class> classes) {
        this.interfaces = interfaces;
        this.classes = classes;
    }

    public List<Interface> getInterfaces(){
        return new ArrayList<Interface>(interfaces);
    }

    public List<Class> getClasses(){
        return new ArrayList<Class>(classes);
    }
}
