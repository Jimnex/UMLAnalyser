package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.Visibility;

public class InterfaceHasOnlyStaticAttributes extends Analyser<ClassDiagramStructure> {
    public InterfaceHasOnlyStaticAttributes() {
        this.conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier interface_: structure.getInterfaces()) {
            if(interface_.getStructuralFeatures().stream().anyMatch(i -> i.checkIsStatic() == false)){
                reporter.addReport(conventionType, "Nem statikus valamelyik attribútuma a " + interface_.getName() + "nevű interfésznek a következő diagramban: " + structure.getName());
            }
        }
        return reporter;
    }
}
