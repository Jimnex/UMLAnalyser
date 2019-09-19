package parser.classdiagram;

import diagram.Diagram;
import diagram.umlclass.Class;
import diagram.umlclass.ClassDiagram;
import parser.Parser;

import java.util.List;

public abstract class ClassDiagramParser implements Parser<ClassDiagram> {
    protected ClassDiagram classDiagram;

    protected abstract List<Class> parseClasses();

    @Override
    public ClassDiagram parse(){
        this.classDiagram = new ClassDiagram(this.parseName(),this.parseClasses());
        return classDiagram;
    }
}
