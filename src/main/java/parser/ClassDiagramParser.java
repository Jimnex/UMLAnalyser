package parser;

import diagram.Diagram;
import diagram.umlclass.*;
import diagram.umlclass.Class;

import java.util.Collection;

public interface ClassDiagramParser extends DiagramParser {

    String parseDiagramName();

    Collection<Class> getClasses();

    Class parseClass();

    Collection<Association> getAssociations();

    Association parseAssociation();

    Collection<Field> getFields();

    Field parseField();

    Collection<Method> getMethods();

    Method parseMethods();

    Collection<Dependency> getDependencies();

    Dependency parseDependency();




}
