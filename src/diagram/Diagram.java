package diagram;

import analyser.Analyser;
import parser.Parser;

public abstract class Diagram {
    private Parser parser;
    private Analyser analyser;

    public Diagram(Parser parser, Analyser analyser){
        this.parser = parser;
        this.analyser = analyser;
    }
}
