package diagram.umlclass;

import diagram.Diagram;

import java.util.Collection;

public class ClassDiagram extends Diagram {
    public Collection<Class> getClasses() {
        return classes;
    }

    public void setClasses(Collection<Class> classes) {
        this.classes = classes;
    }

    private Collection<Class> classes;

    public ClassDiagram(String name) {
        super(name);
    }
}
