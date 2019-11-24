package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.Visibility;

public class InterfaceHasAttributes extends Analyser<ClassDiagramStructure> {
    public InterfaceHasAttributes() {
        this.conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier interface_: structure.getInterfaces()) {
            if(interface_.getBehaviorFeatures().isEmpty() == false){
                reporter.addReport(conventionType, "A(z) " + interface_.getName() + "nevű interfésznek vannak tulajdonságai következő diagramban: " + structure.getName());
            }
        }
        return reporter;
    }
}
