package parser.classdiagram;

import diagram.umlclass.Class;
import parser.DiagramParser;
import parser.Parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

public abstract class ClassDiagramParser extends DiagramParser {
    protected Collection<Class> classes;

    public ClassDiagramParser(String filePath) {
        super(filePath);
    }

    protected abstract Collection<Class> getClasses();

    public void parse(){
        this.classes = this.getClasses();
    }
}
