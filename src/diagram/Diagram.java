package diagram;

import analyser.Analyser;
import parser.Parser;

import java.io.File;

public abstract class Diagram {
    protected final Parser diagramParser;
    protected final Analyser analyser;
    protected final File file;

    public Diagram(File file, Parser diagramParser, Analyser analyser){
        this.diagramParser = diagramParser;
        this.analyser = analyser;
        this.file = file;
    }

    public Parser getDiagramParser() {
        return diagramParser;
    }

    public Analyser getAnalyser() {
        return analyser;
    }
}
