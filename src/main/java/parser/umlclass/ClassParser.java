package parser.umlclass;

import diagram.umlclass.Class;
import diagram.umlclass.*;
import parser.DiagramParser;

import java.util.Collection;

public interface ClassParser {

    Visibility parseVisibility();

    Collection<Association> getAssociations();

    Collection<Field> getFields();

    Collection<Method> getMethods();

    Collection<Dependency> getDependencies();

    String parseClassName();
}
