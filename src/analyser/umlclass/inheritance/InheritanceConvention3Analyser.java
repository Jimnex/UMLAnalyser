package analyser.umlclass.inheritance;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.relationship.directed.Generalization;

public class InheritanceConvention3Analyser extends Analyser<ClassDiagramStructure> {


    /**
     * Returns true if analysed class has NO intersect field or method with its sibling classes.
     * @return boolean
     * @param generalization
     */
    private void checkAreClassifiersMeetsInheritanceRequirementuirement3(Generalization generalization) {
        /*
        for (int i = 1; i < generalization.getSubClassifiers().size(); i++) {
            if(anyCommonItem(generalization.getSubClassifiers().get(0).getBehaviorFeatures(), generalization.getSubClassifiers().get(i).getBehaviorFeatures()) || anyCommonItem(generalization.getSubClassifiers().get(0).getStructuralFeatures(), generalization.getSubClassifiers().get(i).getStructuralFeatures())){
                this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az egyik testvérében is deklarálva van");
            }
        }

         */
    }

    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        return null;
    }
}
