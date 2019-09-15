package parser.classdiagram;

import diagram.umlclass.Class;
import parser.DiagramParser;

import java.util.ArrayList;
import java.util.List;

public abstract class ClassDiagramParser extends DiagramParser {
    protected List<Class> classes;
    protected String name;

    public String getName() {
        return name;
    }

    public void addClass(Class c){
        classes.add(c);
    }

    public Class getClass(int index){
        return this.classes.get(index);
    }

    public List<Class> getClasses(){
        return new ArrayList<Class>(classes);
    }

    public ClassDiagramParser(String filePath) {
        super(filePath);
    }

    protected abstract List<Class> parseClasses();

    public void parse(){
        this.classes = this.parseClasses();
        this.name = this.parseName();
    }
}
