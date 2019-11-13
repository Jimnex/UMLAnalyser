package analyser.umlclass;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;

public class FirstUpperCharNamingConvention extends Analyser<ClassDiagramStructure> {

    public FirstUpperCharNamingConvention() {
        this.conventionType = "Elnevezési szabály";
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        for (Classifier class_: structure.getClasses()) {
            if(meetsNamingConvention(class_.getName()) == false){
                reporter.addReport(conventionType, "Nem nagybetűvel kezdődik az " + class_.getName() + " osztály a következő diagramban: " + structure.getName());
            }
        }
        for (Classifier interface_: structure.getInterfaces()) {
            if(meetsNamingConvention(interface_.getName()) == false){
                reporter.addReport(conventionType, "Nem nagybetűvel kezdődik az " + interface_.getName() + " interfész a következő diagramban: " + structure.getName());
            }
        }
        return this.reporter;
    }

    private boolean meetsNamingConvention(String name){
        return Character.isUpperCase(name.charAt(0));
    }
}
