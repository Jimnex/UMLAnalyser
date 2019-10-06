package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import diagram.umlclass.ClassDiagram;

public class ClassDiagramAnalyser implements Analyser{
    private final ClassDiagram diagram;

    public ClassDiagramAnalyser(ClassDiagram diagram) {
        this.diagram = diagram;
    }

    @Override
    public Reporter analyse() {
        ClassAnalyser classAnalyser;
        Reporter reporter = null;
        for (String id : this.diagram.getIDs()) {
            classAnalyser = new ClassAnalyser(this.diagram.getID(id));
            reporter = classAnalyser.analyse();
        }
        return reporter;
    }



}
