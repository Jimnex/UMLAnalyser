package diagram.umlclass;

import analyser.Reporter;
import diagram.Element;
import diagram.Diagram;
import parser.Parser;

import java.util.Collection;

public class ClassDiagram extends Diagram {
    private Parser<Collection<Element>> classifiersParser;
    private Parser<Collection<Element>> realizationsParser;


    public ClassDiagram(String filePath, Parser<Collection<Element>> classifierParser, Parser<Collection<Element>> realizationParser) {
        super(filePath);
        this.classifiersParser = classifierParser;
        this.realizationsParser = realizationParser;
    }

    @Override
    public void parse() {
        super.addRootStructure(classifiersParser.parse());
        super.addRootStructure(realizationsParser.parse());
    }

    @Override
    protected String parseName() {
        return null;
    }

    @Override
    public Reporter analyse() {
        return null;
    }

    @Override
    public void visualize() {

    }
}
