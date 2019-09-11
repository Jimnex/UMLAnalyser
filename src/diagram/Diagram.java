package diagram;

import analyser.Analyser;
import parser.Parser;

public abstract class Diagram {
    private Parser diagramParser;
    private Analyser analyser;

    public Diagram(Parser diagramParser, Analyser analyser){
        this.diagramParser = diagramParser;
        this.analyser = analyser;
    }
}
