package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InterfaceOrAbstractClassHasAtLeastOneDerived extends Analyser<ClassDiagramStructure> {

    public InterfaceOrAbstractClassHasAtLeastOneDerived() {
        conventionType = "Classifier szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        List<Classifier> classes = structure.getClasses().stream().filter(c -> c.checkIsAbstract() == true).collect(Collectors.toList());
        for (Classifier class_ : classes) {
            if(structure.getClasses().stream().anyMatch(c -> c.getGeneralizations().stream().anyMatch(inner -> inner.getSuperClassifier().equals(class_.getIndentifier())))){
                reporter.addReport(conventionType, "Legalább egy leszármazottal kell rendelkeznie az " + class_.getName() + "nevű absztrakt osztálynak a következő diagramban: " + structure.getName());
            }
        }

        List<Classifier> interfaces = structure.getInterfaces().stream().filter(c -> c.checkIsAbstract() == true).collect(Collectors.toList());
        for (Classifier interface_: interfaces) {
            if(structure.getClasses().stream().anyMatch(c -> c.getGeneralizations().stream().anyMatch(inner -> inner.getSuperClassifier().equals(interface_.getIndentifier())))){
                reporter.addReport(conventionType, "Legalább egy leszármazottal kell rendelkeznie az " + interface_.getName() + "nevű interfésznek a következő diagramban: " + structure.getName());
            }
        }

        return this.reporter;
    }

}
