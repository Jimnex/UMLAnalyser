package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.Visibility;

public class InterfaceHasPublicScope extends Analyser<ClassDiagramStructure> {
    public InterfaceHasPublicScope() {
        this.conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier interface_: structure.getInterfaces()) {
            if(interface_.getVisibility() != Visibility.PUBLIC){
                reporter.addReport(conventionType, "Nem publikus a(z)" + interface_.getName() + " interfész a következő diagramban: " + structure.getName());
            }
        }
        return reporter;
    }
}
