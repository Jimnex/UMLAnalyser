package diagram.umlclass;

import diagram.Diagram;

import java.util.Collection;

public class ClassDiagram extends Diagram {
    private Collection<Class> classes;

    public Collection<Class> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Class> classes) {
        this.classes = classes;
    }



    public ClassDiagram(String name) {
        super(name);
    }
}
