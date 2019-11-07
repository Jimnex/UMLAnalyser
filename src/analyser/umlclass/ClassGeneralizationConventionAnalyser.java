package analyser.umlclass;

import analyser.GeneralizationsAnalyser;
import analyser.Reporter;
import uml.metaclasses.Classifier;
import uml.metaclasses.relationship.directed.Generalization;

import java.util.List;

public class ClassGeneralizationConventionAnalyser extends GeneralizationsAnalyser {

    @Override
    protected Reporter analyseGeneralization(Generalization generalization) {
        checkAreSubclassifiersMeetsInheritanceRequirementuirement1(generalization);
        CheckAreSubclassifiersMeetsInheritanceRequirementuirement2(generalization);
        checkAreClassifiersMeetsInheritanceRequirementuirement3(generalization);
        //this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az ősben is deklarálva van");
        //this.reporter.addReport("Öröklés", "Osztály több őssel is rendelkezik. Gyémánt probléma");
        return reporter;
    }

    /**
     * Returns true if the analysed class has ONE and ONLY ONE base class.
     * @return boolean
     */
    /*
    private boolean isClassMeetsInheritanceRequirementuirement0(){
        return c.getBaseClassIDs().size() == 1;
    }
    */

    /**
     * Returns true if analysed class has any field or method.
     * @return boolean
     * @param generalization
     */
    private void checkAreSubclassifiersMeetsInheritanceRequirementuirement1(Generalization generalization){
        for (Classifier subClassifier: generalization.getSubClassifiers()) {
            if(isSubclassifierMeetsInheritanceRequirementuirement1(subClassifier) == false){
                this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága és viselkedése sem");
            }
        }
    }

    private boolean isSubclassifierMeetsInheritanceRequirementuirement1(Classifier subClassifier){
        return subClassifier.getBehaviorFeatures().isEmpty() == false || subClassifier.getStructuralFeatures().isEmpty() == false;
    }

    /**
     * Returns true if the analysed class has NO common field or method with its base class. Regulation does not include overriding base class methods or fields.
     * @return boolean
     * @param generalization
     */
    private void CheckAreSubclassifiersMeetsInheritanceRequirementuirement2(Generalization generalization){
        for (Classifier subClassifier: generalization.getSubClassifiers()) {
            if(isClassMeetsInheritanceRequirementuirement2(generalization.getSuperClassifier(), subClassifier) == false){
                this.reporter.addReport("Öröklés", "Osztálynak nincsen egy tulajdonsága és viselkedése sem");
            }
        }
    }

    private boolean isClassMeetsInheritanceRequirementuirement2(Classifier superClassifier, Classifier subClassifier) {
        return anyCommonItem(superClassifier.getBehaviorFeatures(), subClassifier.getBehaviorFeatures()) &&
               anyCommonItem(superClassifier.getStructuralFeatures(), subClassifier.getStructuralFeatures());
    }

    /**
     * Returns true if analysed class has NO intersect field or method with its sibling classes.
     * @return boolean
     * @param generalization
     */
    private void checkAreClassifiersMeetsInheritanceRequirementuirement3(Generalization generalization) {
        for (int i = 1; i < generalization.getSubClassifiers().size(); i++) {
            if(anyCommonItem(generalization.getSubClassifiers().get(0).getBehaviorFeatures(), generalization.getSubClassifiers().get(i).getBehaviorFeatures()) || anyCommonItem(generalization.getSubClassifiers().get(0).getStructuralFeatures(), generalization.getSubClassifiers().get(i).getStructuralFeatures())){
                this.reporter.addReport("Öröklés", "Osztálynak van olyan deklarált tulajdonsága vagy viselkedése amely az egyik testvérében is deklarálva van");
            }
        }
    }

    private <T> boolean anyCommonItem(List<T> l1, List<T> l2){
        for (int i = 0; i < l1.size(); i++) {
            if (l2.contains(l1.get(i))){
                return false;
            }
        }
        return true;
    }


}
