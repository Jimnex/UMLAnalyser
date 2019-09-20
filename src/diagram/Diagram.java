package diagram;

import analyser.Analyser;
import parser.Parser;

public abstract class Diagram {
    protected final String name;

    public Diagram(String name){
        this.name = name;
    }

    public void analyse(Analyser analyser){
        analyser.analyse();
    }
}
