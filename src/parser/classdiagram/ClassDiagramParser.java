package parser.classdiagram;

import diagram.umlclass.Class;
import diagram.umlclass.ClassDiagram;
import diagram.umlclass.Interface;
import parser.IDParser;
import parser.NameParser;
import parser.Parser;

import java.util.AbstractMap;

public abstract class ClassDiagramParser implements Parser<ClassDiagram> , NameParser{

    @Override
    public ClassDiagram parse(){
        return new ClassDiagram(this.parseName(), parseClasses(), this.parseInterfaces());
    }

    protected abstract AbstractMap<String, Interface> parseInterfaces();

    protected abstract AbstractMap<String, Class> parseClasses();
}
