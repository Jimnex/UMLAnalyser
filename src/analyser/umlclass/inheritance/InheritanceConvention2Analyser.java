package analyser.umlclass.inheritance;

import analyser.Analyser;
import analyser.Reporter;
import uml.diagrams.umlclass.ClassDiagramStructure;
import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.directed.Generalization;

public class InheritanceConvention2Analyser extends Analyser<ClassDiagramStructure> {

    protected Reporter analyseGeneralization(Generalization generalization) {
        CheckAreSubclassifiersMeetsInheritanceRequirementuirement2(generalization);
        return reporter;
    }

    /**
     * Returns true if the analysed class has NO common field or method with its base class. Regulation does not include overriding base class methods or fields.
     * @return boolean
     * @param generalization
     */
    private void CheckAreSubclassifiersMeetsInheritanceRequirementuirement2(Generalization generalization){
        /*
        for (Classifier subClassifier: generalization.getSubClassifiers()) {
            if(isClassMeetsInheritanceRequirementuirement2(generalization.getSuperClassifier(), subClassifier) == false){
                this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága és viselkedése sem");
            }
        }

         */
    }

    private boolean isClassMeetsInheritanceRequirementuirement2(Classifier superClassifier, Classifier subClassifier) {
        /*
        return anyCommonItem(superClassifier.getBehaviorFeatures(), subClassifier.getBehaviorFeatures()) &&
                anyCommonItem(superClassifier.getStructuralFeatures(), subClassifier.getStructuralFeatures());

         */
        return  false;
    }



    @Override
    public Reporter analyse(ClassDiagramStructure structure) {
        return null;
    }
}
