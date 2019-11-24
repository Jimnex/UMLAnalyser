package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;

public class AtLeastOneAttribiteOrOperationConvention extends Analyser<ClassDiagramStructure> {

    public AtLeastOneAttribiteOrOperationConvention() {
        conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier class_: structure.getClasses()) {
            if(meetsAtLeastOneAttribiteOrOperationConvention(class_)){
                reporter.addReport(conventionType, "Legalbb egy tulajdonsággal vagy viselkedéssel kell rendelkezzen " + class_.getName() + "nevű osztálynak a következő diagramban: " + structure.getName());
            }
        }
        for (Classifier interface_: structure.getInterfaces()) {
            if(meetsAtLeastOneAttribiteOrOperationConvention(interface_)){
                reporter.addReport(conventionType, "Legalbb egy viselkedéssel kell rendelkezzen " + interface_.getName() + "nevű interfésznek a következő diagramban: " + structure.getName());
            }
        }
        return this.reporter;
    }

    private boolean meetsAtLeastOneAttribiteOrOperationConvention(Classifier classifier){
        return classifier.getStructuralFeatures().size() > 0 || classifier.getBehaviorFeatures().size() > 0;
    }
}
