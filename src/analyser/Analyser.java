package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.Element;

public abstract class Analyser<T extends Structure> {
    protected Reporter reporter;
    protected String conventionType;

    public Analyser(){
        this.reporter = new Reporter();
    }

    public abstract Reporter analyse(T structure);

}
