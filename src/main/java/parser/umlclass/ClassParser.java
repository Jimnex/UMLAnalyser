package parser.umlclass;

import diagram.Diagram;
import diagram.umlclass.Class;
import diagram.umlclass.*;
import parser.DiagramParser;

import java.util.Collection;

public interface ClassParser extends DiagramParser {

    Visibility parseVisibility();

    Boolean parseIsAbstract();

    Collection<Association> getAssociations();

    Collection<Field> getFields();

    Collection<Method> getMethods();

    Collection<Dependency> getDependencies();

    String parseClassName();
}
