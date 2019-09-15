package diagram;

import analyser.Analyser;
import parser.Parser;

public abstract class Diagram {
    protected final Parser parser;
    protected final Analyser analyser;

    public Diagram(Parser diagramParser, Analyser analyser){
        this.parser = diagramParser;
        this.analyser = analyser;
    }

    public void parse(){
        parser.parse();
    }

    public void analyse(){
        analyser.analyse();
    }

    public Parser getParser() {
        return parser;
    }

    public Analyser getAnalyser() {
        return analyser;
    }
}
