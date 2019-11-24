package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.Visibility;
import uml.metaclasses.feature.BehavioralFeature;
import uml.metaclasses.feature.StructuralFeature;

import java.util.List;

public class InterfaceHasOnlyPublicFieldsAndOperations extends Analyser<ClassDiagramStructure> {
    public InterfaceHasOnlyPublicFieldsAndOperations() {
        this.conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier interface_: structure.getInterfaces()) {
            if(interface_.getBehaviorFeatures().stream().anyMatch(i -> i.getVisibility() != Visibility.PUBLIC)){
                reporter.addReport(conventionType, "Nem publikus valamelyik attribútuma vagy tulajdonsága " + interface_.getName() + " interfésznek a következő diagramban: " + structure.getName());
            }

            if(interface_.getStructuralFeatures().stream().anyMatch(i -> i.getVisibility() != Visibility.PUBLIC)){
                reporter.addReport(conventionType, "Nem publikus valamelyik attribútuma vagy tulajdonsága " + interface_.getName() + " interfésznek a következő diagramban: " + structure.getName());
            }
        }
        return reporter;
    }
}
