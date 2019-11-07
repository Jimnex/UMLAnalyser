package analyser;

import uml.diagrams.Structure;

public abstract class Analyser {
    protected Reporter reporter;

    public Analyser(){
        this.reporter = new Reporter();
    }

    abstract Reporter analyse(Structure structure);
}
