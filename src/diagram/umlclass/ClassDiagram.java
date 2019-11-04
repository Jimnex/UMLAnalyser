package diagram.umlclass;
import diagram.Diagram;
import parser.Parser;
import parser.classdiagram.ClassDiagramStructureParser;

import java.util.List;

public class ClassDiagram extends Diagram { ;
    private ClassDiagramStructureParser classDiagramStructureParser;

    public ClassDiagram(ClassDiagramStructureParser classDiagramStructureParser) {
        this.classDiagramStructureParser = classDiagramStructureParser;
    }

    @Override
    public String getDisplayedName() {
        return "Class diagram";
    }

    @Override
    public void parse() {
        super.parse();
        super.structure = classDiagramStructureParser.parse();
    }

    @Override
    public String parseName() {
        return classDiagramStructureParser.parseName();
    }
}
