package parser.classdiagram;

import diagram.umlclass.*;
import diagram.umlclass.Class;
import parser.NameParser;
import parser.Parser;

import java.util.List;

public abstract class ClassParser implements Parser<Class> , NameParser {

    @Override
    public Class parse() {
        return new Class(this.parseName(),
                this.parseIsAbstract(),
                this.parseIsStatic(),
                this.parseVisibility(),
                this.getAssociations(),
                this.getFields(),
                this.getMethods());
    }

    protected abstract Boolean parseIsStatic();

    abstract protected Visibility parseVisibility();

    abstract protected Boolean parseIsAbstract();

    abstract protected List<Association> getAssociations();

    abstract protected List<Field> getFields();

    abstract protected List<Method> getMethods();

    abstract protected List<Dependency> getDependencies();
}
