package uml.diagrams.umlclass;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import uml.diagrams.Structure;
import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.association.BinaryAssociation;
import uml.metaclasses.relationship.directed.Dependency;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;

public class ClassDiagramStructure implements Structure {
    private final String name;
    private final List<Interface> interfaces;
    private final List<Class> classes;

    public ClassDiagramStructure(String name, List<Interface> interfaces, List<Class> classes) {
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
