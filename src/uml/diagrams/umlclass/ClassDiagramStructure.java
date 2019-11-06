package uml.diagrams.umlclass;

import uml.diagrams.Structure;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagramStructure implements Structure {
    private final List<Interface> interfaces;
    private final List<Class> classes;
    private final String name;

    public ClassDiagramStructure(String name, List<Class> classes, List<Interface> interfaces) {
        this.name = name;
        this.interfaces = interfaces;
        this.classes = classes;
    }

    public List<Interface> getInterfaces(){
        return new ArrayList<Interface>(interfaces);
    }

    public List<Class> getClasses(){
        return new ArrayList<Class>(classes);
    }

    @Override
    public String getName() {
        return name;
    }
}
