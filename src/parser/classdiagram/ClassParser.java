package parser.classdiagram;

import diagram.umlclass.*;
import diagram.umlclass.Class;
import parser.Parser;

import java.util.Collection;

public abstract class ClassParser implements Parser<Class> {
    protected Class c;

    @Override
    public Class parse() {
        this.c = new Class(this.parseName());
        this.c.setVisibility(this.parseVisibility());
        this.c.setAbstract(this.parseIsAbstract());
        this.c.setAssociations(this.getAssociations());
        this.c.setFields(this.getFields());
        this.c.setMethods(this.getMethods());
        this.c.setDependencies(this.getDependencies());

        return this.c;
    }

    abstract protected Visibility parseVisibility();

    abstract protected Boolean parseIsAbstract();

    abstract protected Collection<Association> getAssociations();

    abstract protected Collection<Field> getFields();

    abstract protected Collection<Method> getMethods();

    abstract protected Collection<Dependency> getDependencies();
}
