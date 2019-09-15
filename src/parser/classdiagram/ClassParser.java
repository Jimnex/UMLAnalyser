package parser.classdiagram;

import diagram.umlclass.*;
import parser.Parser;

import java.util.Collection;

public interface ClassParser extends Parser {

    Visibility parseVisibility();

    Boolean parseIsAbstract();

    Collection<Association> getAssociations();

    Collection<Field> getFields();

    Collection<Method> getMethods();

    Collection<Dependency> getDependencies();
}
