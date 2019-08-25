package parser.umlclass;

import diagram.Diagram;
import diagram.umlclass.*;
import diagram.umlclass.Class;
import parser.DiagramParser;

import java.util.Collection;

public interface ClassDiagramParser extends DiagramParser{

    String parseDiagramName();

    Collection<Class> getClasses();


}
