package analyser;

import uml.diagrams.Structure;
import uml.metaclasses.Element;

public abstract class Analyser<T> {
    protected T analysedElement;
    protected Reporter reporter;

    public Analyser(T analysedElement){
        this.analysedElement = analysedElement;
        this.reporter = new Reporter();
    }

    public abstract Reporter analyse();
}
