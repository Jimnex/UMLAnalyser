package parser.classdiagram;

import diagram.umlclass.Class;
import diagram.umlclass.ClassDiagram;
import diagram.umlclass.Interface;
import parser.IDParser;
import parser.NameParser;
import parser.Parser;

import java.util.AbstractMap;
import java.util.List;

public abstract class ClassDiagramParser implements Parser<ClassDiagram> , NameParser{

    @Override
    public ClassDiagram parse(){
        return new ClassDiagram(this.parseName(), parseClasses(), this.parseInterfaces());
    }

    protected abstract List<Interface> parseInterfaces();

    protected abstract List<Class> parseClasses();
}
