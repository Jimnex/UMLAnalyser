package parser.classdiagram;

import diagram.umlclass.Class;
import parser.Parser;

import java.util.Collection;

public abstract class ClassDiagramParser implements Parser {
    protected abstract Collection<Class> getClasses();

    public void parse(){

    }
}
